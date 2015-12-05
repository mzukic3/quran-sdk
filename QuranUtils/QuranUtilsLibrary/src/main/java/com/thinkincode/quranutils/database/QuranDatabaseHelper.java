package com.thinkincode.quranutils.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class QuranDatabaseHelper {

    private static final String DATABASE_NAME = "quran.db";

    private static final String TABLE_NAME_QURAN_TEXT = "quran_text";
    private static final String TABLE_NAME_SURA_NAMES = "sura_names";

    private static final String COLUMN_NAME_AYA = "aya";
    private static final String COLUMN_NAME_NAME = "name";
    private static final String COLUMN_NAME_SURA = "sura";
    private static final String COLUMN_NAME_TEXT = "text";

    private SQLiteDatabase sqliteDatabase; 

	/**
     * Copies the Quran database from assets to internal storage database
     * if it does not already exist in internal storage.
     *
     * @param context is non-null
     * */
    public void createDatabaseIfDoesNotExist(Context context) throws IOException {
    	if (!isDatabaseExistsInInternalStorage(context)) {
        	copyDatabaseFromAssetsToInternalStorage(context);
    	}
    }

    /**
     * Checks whether the Quran database exists in internal storage.
     *
	 * @param context is non-null
     * @return true if it exists, false if it doesn't
     */
    private boolean isDatabaseExistsInInternalStorage(Context context) {
    	SQLiteDatabase checkDatabase = null;

    	try {
    		String myPath = context.getFilesDir().getPath() + "/" + DATABASE_NAME;
    		checkDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    	} catch (SQLiteException ex) { 
    		//database does't exist
    	}

    	if (checkDatabase != null){
    		checkDatabase.close();
    	}

    	return checkDatabase != null;
    }

    /**
     * Copies the Quran database from assets to internal storage,
     * so that it can be accessed and handled.
     *
     * @param context is non-null
     * */
    private void copyDatabaseFromAssetsToInternalStorage(Context context) throws IOException {
    	// Read from the local database in assets
    	InputStream inputStream = context.getAssets().open(DATABASE_NAME);
 
    	// Write to a local database in internal storage
    	OutputStream outputStream = context.openFileOutput(DATABASE_NAME, Context.MODE_PRIVATE);

    	// Transfer bytes from the input file to the output file
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = inputStream.read(buffer)) > 0) {
    		outputStream.write(buffer, 0, length);
    	}

    	// Close the streams
    	outputStream.flush();
    	outputStream.close();
    	inputStream.close();
    }

    /**
     * @param context
     * @throws SQLException
     */
    private void openDatabaseForReadingIfClosed(Context context) throws SQLException {
    	if (sqliteDatabase == null || !sqliteDatabase.isOpen()) {
	    	String myPath = context.getFilesDir().getPath() + "/" + DATABASE_NAME;
	    	sqliteDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    	}
    }

    /**
     * @param context is non-null
     * @param table
     * @param columns
     * @param selection
     * @param selectionArgs
     * @param groupBy
     * @param having
     * @param orderBy
     * @param limit
     * @return
     */
    private Cursor queryDatabase(Context context, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
    	openDatabaseForReadingIfClosed(context);
//		DatabaseUtils.explainQueryPlanForSelectStatement(sqliteDatabase, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
		return sqliteDatabase.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
    }

	public void closeDatabase() {
    	if (sqliteDatabase != null) {
    		sqliteDatabase.close();
    	}
	}

	/**
     * @param context is non-null
	 * @param surahNumber
	 * @return the name of the specified surah,
	 * or null if the surah number is not valid.
	 */
	public String getSurahName(Context context, int surahNumber) {
		String surahName = null;

		String[] columns = new String[] { COLUMN_NAME_NAME };
		String selection = COLUMN_NAME_SURA + " = ? ";
		String[] selectionArgs = new String[] { String.valueOf(surahNumber) };
		String limit = "1";

		Cursor cursor = queryDatabase(context, TABLE_NAME_SURA_NAMES, columns, selection, selectionArgs, null, null, null, limit);

		int columnIndexName = cursor.getColumnIndex(COLUMN_NAME_NAME);

		if (cursor.moveToFirst()) {
			surahName = cursor.getString(columnIndexName);
		}

		cursor.close();

		return surahName;
	}

	/**
     * @param context
	 * @return the names of all the surahs in the Qur'an.
	 */
	public List<String> getSurahNames(Context context) {
		List<String> surahNames = new ArrayList<>();

		String[] columns = new String[] { COLUMN_NAME_NAME };
		String orderBy = COLUMN_NAME_SURA + " ASC ";

		Cursor cursor = queryDatabase(context, TABLE_NAME_SURA_NAMES, columns, null, null, null, null, orderBy, null);

		int columnIndexName = cursor.getColumnIndex(COLUMN_NAME_NAME);

		while (cursor.moveToNext()) {
			surahNames.add(cursor.getString(columnIndexName));
		}

		cursor.close();

		return surahNames;
	}

	/**
     * @param context is non-null
	 * @param surahNumber >= 1.
	 * @return the ayahs of the specified surah,
	 * or null if the surah number is not valid.
	 */
	public List<String> getAyahsInSurah(Context context, int surahNumber) {
		List<String> surahAyahs = new ArrayList<>();

		String[] columns = new String[] { COLUMN_NAME_TEXT };
		String selection = COLUMN_NAME_SURA + " = ? ";
		String[] selectionArgs = new String[] { String.valueOf(surahNumber) };
		String orderBy = COLUMN_NAME_AYA + " ASC ";

		Cursor cursor = queryDatabase(context, TABLE_NAME_QURAN_TEXT, columns, selection, selectionArgs, null, null, orderBy, null);

		int columnIndexText = cursor.getColumnIndex(COLUMN_NAME_TEXT);

		while (cursor.moveToNext()) {
			surahAyahs.add(cursor.getString(columnIndexText));
		}

		cursor.close();

		return surahAyahs;
	}

	/**
     * @param context is non-null
	 * @param surahNumber >= 1.
	 * @param ayahNumber >= 1.
	 * @return the text of the specified ayah,
	 * or null if the surah and ayah number provided do not map to an ayah.
	 */
	public String getAyah(Context context, int surahNumber, int ayahNumber) {
		String ayah = null;

		String[] columns = new String[] { COLUMN_NAME_TEXT };
		String selection = COLUMN_NAME_SURA + " = ? AND " + COLUMN_NAME_AYA + " = ? ";
		String[] selectionArgs = new String[] { String.valueOf(surahNumber), String.valueOf(ayahNumber) };
		String limit = "1";

		Cursor cursor = queryDatabase(context, TABLE_NAME_QURAN_TEXT, columns, selection, selectionArgs, null, null, null, limit);

		int columnIndexText = cursor.getColumnIndex(COLUMN_NAME_TEXT);

		if (cursor.moveToFirst()) {
			ayah = cursor.getString(columnIndexText);
		}

		cursor.close();

		return ayah;
	}
}
