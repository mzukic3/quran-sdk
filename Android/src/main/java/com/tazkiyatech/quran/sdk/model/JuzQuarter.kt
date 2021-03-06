package com.tazkiyatech.quran.sdk.model

/**
 * An enum representation of the Juz-Quarters that make up the Quran.
 *
 * @property juzNumber The Juz number (not index) that this Juz-quarter corresponds to.
 * @property quarterNumber The quarter (1 to 4) within the Juz that this Juz-Quarter corresponds to.
 * @property fromSurah The number (not index) of the Surah in which this Juz-Quarter begins.
 * @property fromVerse The number (not index) of the Verse/Ayah within [fromSurah] at which this Juz-Quarter begins.
 */
@Deprecated("Use the QuranDatabase.getMetadataForSectionsOfType(SectionType) and QuranDatabase.getMetadataForSection(SectionType, int) methods instead.")
enum class JuzQuarter(
    val juzNumber: Int,
    val quarterNumber: Int,
    val numVerses: Int,
    val fromSurah: Int,
    val fromVerse: Int
) {
    Juz_01_Quarter_01(1, 1, 46, 2, 1),
    Juz_01_Quarter_02(1, 2, 36, 2, 47),
    Juz_01_Quarter_03(1, 3, 30, 2, 83),
    Juz_01_Quarter_04(1, 4, 29, 2, 113),
    Juz_02_Quarter_01(2, 1, 35, 2, 142),
    Juz_02_Quarter_02(2, 2, 34, 2, 177),
    Juz_02_Quarter_03(2, 3, 21, 2, 211),
    Juz_02_Quarter_04(2, 4, 21, 2, 232),
    Juz_03_Quarter_01(3, 1, 21, 2, 253),
    Juz_03_Quarter_02(3, 2, 33, 2, 274),
    Juz_03_Quarter_03(3, 3, 34, 3, 21),
    Juz_03_Quarter_04(3, 4, 37, 3, 55),
    Juz_04_Quarter_01(4, 1, 38, 3, 92),
    Juz_04_Quarter_02(4, 2, 42, 3, 130),
    Juz_04_Quarter_03(4, 3, 29, 3, 172),
    Juz_04_Quarter_04(4, 4, 23, 4, 1),
    Juz_05_Quarter_01(5, 1, 36, 4, 24),
    Juz_05_Quarter_02(5, 2, 28, 4, 60),
    Juz_05_Quarter_03(5, 3, 28, 4, 88),
    Juz_05_Quarter_04(5, 4, 32, 4, 116),
    Juz_06_Quarter_01(6, 1, 34, 4, 148),
    Juz_06_Quarter_02(6, 2, 29, 5, 6),
    Juz_06_Quarter_03(6, 3, 22, 5, 35),
    Juz_06_Quarter_04(6, 4, 26, 5, 57),
    Juz_07_Quarter_01(7, 1, 33, 5, 83),
    Juz_07_Quarter_02(7, 2, 46, 5, 116),
    Juz_07_Quarter_03(7, 3, 41, 6, 42),
    Juz_07_Quarter_04(7, 4, 28, 6, 83),
    Juz_08_Quarter_01(8, 1, 30, 6, 111),
    Juz_08_Quarter_02(8, 2, 25, 6, 141),
    Juz_08_Quarter_03(8, 3, 47, 7, 1),
    Juz_08_Quarter_04(8, 4, 40, 7, 48),
    Juz_09_Quarter_01(9, 1, 54, 7, 88),
    Juz_09_Quarter_02(9, 2, 30, 7, 142),
    Juz_09_Quarter_03(9, 3, 35, 7, 172),
    Juz_09_Quarter_04(9, 4, 40, 8, 1),
    Juz_10_Quarter_01(10, 1, 35, 8, 41),
    Juz_10_Quarter_02(10, 2, 37, 9, 1),
    Juz_10_Quarter_03(10, 3, 29, 9, 38),
    Juz_10_Quarter_04(10, 4, 27, 9, 67),
    Juz_11_Quarter_01(11, 1, 36, 9, 94),
    Juz_11_Quarter_02(11, 2, 30, 10, 1),
    Juz_11_Quarter_03(11, 3, 40, 10, 31),
    Juz_11_Quarter_04(11, 4, 44, 10, 71),
    Juz_12_Quarter_01(12, 1, 44, 11, 6),
    Juz_12_Quarter_02(12, 2, 34, 11, 50),
    Juz_12_Quarter_03(12, 3, 60, 11, 84),
    Juz_12_Quarter_04(12, 4, 32, 12, 21),
    Juz_13_Quarter_01(13, 1, 52, 12, 53),
    Juz_13_Quarter_02(13, 2, 25, 12, 105),
    Juz_13_Quarter_03(13, 3, 37, 13, 19),
    Juz_13_Quarter_04(13, 4, 41, 14, 13),
    Juz_14_Quarter_01(14, 1, 98, 15, 2),
    Juz_14_Quarter_02(14, 2, 50, 16, 1),
    Juz_14_Quarter_03(14, 3, 39, 16, 51),
    Juz_14_Quarter_04(14, 4, 39, 16, 90),
    Juz_15_Quarter_01(15, 1, 52, 17, 1),
    Juz_15_Quarter_02(15, 2, 48, 17, 53),
    Juz_15_Quarter_03(15, 3, 42, 17, 101),
    Juz_15_Quarter_04(15, 4, 43, 18, 32),
    Juz_16_Quarter_01(16, 1, 76, 18, 75),
    Juz_16_Quarter_02(16, 2, 58, 19, 41),
    Juz_16_Quarter_03(16, 3, 76, 20, 1),
    Juz_16_Quarter_04(16, 4, 59, 20, 77),
    Juz_17_Quarter_01(17, 1, 50, 21, 1),
    Juz_17_Quarter_02(17, 2, 62, 21, 51),
    Juz_17_Quarter_03(17, 3, 38, 22, 1),
    Juz_17_Quarter_04(17, 4, 40, 22, 39),
    Juz_18_Quarter_01(18, 1, 77, 23, 1),
    Juz_18_Quarter_02(18, 2, 61, 23, 78),
    Juz_18_Quarter_03(18, 3, 30, 24, 21),
    Juz_18_Quarter_04(18, 4, 34, 24, 51),
    Juz_19_Quarter_01(19, 1, 57, 25, 21),
    Juz_19_Quarter_02(19, 2, 122, 26, 1),
    Juz_19_Quarter_03(19, 3, 119, 26, 123),
    Juz_19_Quarter_04(19, 4, 45, 27, 15),
    Juz_20_Quarter_01(20, 1, 47, 27, 60),
    Juz_20_Quarter_02(20, 2, 47, 28, 14),
    Juz_20_Quarter_03(20, 3, 28, 28, 61),
    Juz_20_Quarter_04(20, 4, 44, 29, 1),
    Juz_21_Quarter_01(21, 1, 52, 29, 45),
    Juz_21_Quarter_02(21, 2, 52, 30, 28),
    Juz_21_Quarter_03(21, 3, 45, 31, 20),
    Juz_21_Quarter_04(21, 4, 30, 33, 1),
    Juz_22_Quarter_01(22, 1, 38, 33, 31),
    Juz_22_Quarter_02(22, 2, 35, 33, 69),
    Juz_22_Quarter_03(22, 3, 38, 34, 31),
    Juz_22_Quarter_04(22, 4, 52, 35, 15),
    Juz_23_Quarter_01(23, 1, 136, 36, 22),
    Juz_23_Quarter_02(23, 2, 108, 37, 75),
    Juz_23_Quarter_03(23, 3, 64, 38, 1),
    Juz_23_Quarter_04(23, 4, 55, 38, 65),
    Juz_24_Quarter_01(24, 1, 44, 39, 32),
    Juz_24_Quarter_02(24, 2, 50, 40, 1),
    Juz_24_Quarter_03(24, 3, 43, 40, 51),
    Juz_24_Quarter_04(24, 4, 38, 41, 9),
    Juz_25_Quarter_01(25, 1, 37, 41, 47),
    Juz_25_Quarter_02(25, 2, 49, 42, 30),
    Juz_25_Quarter_03(25, 3, 93, 43, 26),
    Juz_25_Quarter_04(25, 4, 67, 44, 30),
    Juz_26_Quarter_01(26, 1, 35, 46, 1),
    Juz_26_Quarter_02(26, 2, 55, 47, 1),
    Juz_26_Quarter_03(26, 3, 22, 48, 18),
    Juz_26_Quarter_04(26, 4, 83, 49, 11),
    Juz_27_Quarter_01(27, 1, 111, 51, 31),
    Juz_27_Quarter_02(27, 2, 110, 53, 33),
    Juz_27_Quarter_03(27, 3, 127, 55, 26),
    Juz_27_Quarter_04(27, 4, 51, 56, 75),
    Juz_28_Quarter_01(28, 1, 32, 58, 1),
    Juz_28_Quarter_02(28, 2, 27, 59, 11),
    Juz_28_Quarter_03(28, 3, 46, 61, 1),
    Juz_28_Quarter_04(28, 4, 32, 64, 11),
    Juz_29_Quarter_01(29, 1, 82, 67, 1),
    Juz_29_Quarter_02(29, 2, 124, 69, 1),
    Juz_29_Quarter_03(29, 3, 104, 72, 1),
    Juz_29_Quarter_04(29, 4, 121, 75, 1),
    Juz_30_Quarter_01(30, 1, 176, 78, 1),
    Juz_30_Quarter_02(30, 2, 145, 83, 1),
    Juz_30_Quarter_03(30, 3, 137, 89, 1),
    Juz_30_Quarter_04(30, 4, 106, 98, 1);
}