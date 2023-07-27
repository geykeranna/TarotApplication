package ru.diploma.tarotapplication.data.repo

import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.GroupOfSuits
import ru.diploma.tarotapplication.data.model.ShortCard
import ru.diploma.tarotapplication.domain.repositories.GroupOfSuitsRepository
import javax.inject.Inject

class GroupOfSuitsRepositoryImpl @Inject constructor(
) : GroupOfSuitsRepository {

    private val shortsCardInfoMajor = listOf(
        ShortCard(
            id = 1001101,
            id_card = 1001001,
            card_number = 0,
            card_name = "Шут",
            id_img = R.drawable.major00,
        ),
        ShortCard(
            id = 1001102,
            id_card = 1001001,
            card_number = 1,
            card_name = "Маг",
            id_img = R.drawable.major01,
        ),
        ShortCard(
            id = 1001103,
            id_card = 1001001,
            card_number = 2,
            card_name = "Жрица",
            id_img = R.drawable.major02,
        ),
        ShortCard(
            id = 1001104,
            id_card = 1001001,
            card_number = 3,
            card_name = "Императрица",
            id_img = R.drawable.major03,
        ),
        ShortCard(
            id = 1001105,
            id_card = 1001001,
            card_number = 4,
            card_name = "Император",
            id_img = R.drawable.major04,
        ),
        ShortCard(
            id = 1001106,
            id_card = 1001001,
            card_number = 5,
            card_name = "Жрец",
            id_img = R.drawable.major05,
        ),
        ShortCard(
            id = 1001107,
            id_card = 1001001,
            card_number = 6,
            card_name = "Влюбленные",
            id_img = R.drawable.major06,
        ),
        ShortCard(
            id = 1001108,
            id_card = 1001001,
            card_number = 7,
            card_name = "Колесница",
            id_img = R.drawable.major07,
        ),
        ShortCard(
            id = 1001109,
            id_card = 1001001,
            card_number = 8,
            card_name = "Правосудие",
            id_img = R.drawable.major08,
        ),
        ShortCard(
            id = 1001110,
            id_card = 1001001,
            card_number = 9,
            card_name = "Отшельник",
            id_img = R.drawable.major09,
        ),
        ShortCard(
            id = 1001111,
            id_card = 1001001,
            card_number = 10,
            card_name = "Колесо фортуны",
            id_img = R.drawable.major10,
        ),
        ShortCard(
            id = 1001112,
            id_card = 1001001,
            card_number = 11,
            card_name = "Сила",
            id_img = R.drawable.major11,
        ),
        ShortCard(
            id = 1001113,
            id_card = 1001001,
            card_number = 12,
            card_name = "Повешанный",
            id_img = R.drawable.major12,
        ),
        ShortCard(
            id = 1001114,
            id_card = 1001001,
            card_number = 13,
            card_name = "Смерть",
            id_img = R.drawable.major13,
        ),
        ShortCard(
            id = 1001115,
            id_card = 1001001,
            card_number = 14,
            card_name = "Умеренность",
            id_img = R.drawable.major14,
        ),
        ShortCard(
            id = 1001116,
            id_card = 1001001,
            card_number = 15,
            card_name = "Дьявол",
            id_img = R.drawable.major15,
        ),
        ShortCard(
            id = 1001117,
            id_card = 1001001,
            card_number = 16,
            card_name = "Башня",
            id_img = R.drawable.major16,
        ),
        ShortCard(
            id = 1001118,
            id_card = 1001001,
            card_number = 17,
            card_name = "Звезда",
            id_img = R.drawable.major17,
        ),
        ShortCard(
            id = 1001119,
            id_card = 1001001,
            card_number = 18,
            card_name = "Луна",
            id_img = R.drawable.major18,
        ),
        ShortCard(
            id = 1001120,
            id_card = 1001001,
            card_number = 19,
            card_name = "Солнце",
            id_img = R.drawable.major19,
        ),
        ShortCard(
            id = 1001121,
            id_card = 1001001,
            card_number = 20,
            card_name = "Суд",
            id_img = R.drawable.major20,
        ),
        ShortCard(
            id = 1001122,
            id_card = 1001001,
            card_number = 21,
            card_name = "Мир",
            id_img = R.drawable.major21,
        ),
    )

    private val shortsCardInfoWands = listOf(
        ShortCard(
            id = 1001123,
            id_card = 1001001,
            card_number = 22,
            card_name = "Туз жезлов",
            id_img = R.drawable.wands01,
        ),
        ShortCard(
            id = 1001124,
            id_card = 1001001,
            card_number = 23,
            card_name = "Двойка жезлов",
            id_img = R.drawable.wands02,
        ),
        ShortCard(
            id = 1001125,
            id_card = 1001001,
            card_number = 24,
            card_name = "Тройка жезлов",
            id_img = R.drawable.wands03,
        ),
        ShortCard(
            id = 1001126,
            id_card = 1001001,
            card_number = 25,
            card_name = "Четверка жезлов",
            id_img = R.drawable.wands04,
        ),
        ShortCard(
            id = 1001127,
            id_card = 1001001,
            card_number = 26,
            card_name = "Пятерка жезлов",
            id_img = R.drawable.wands05,
        ),
        ShortCard(
            id = 1001128,
            id_card = 1001001,
            card_number = 27,
            card_name = "Шестерка жезлов",
            id_img = R.drawable.wands06,
        ),
        ShortCard(
            id = 1001129,
            id_card = 1001001,
            card_number = 28,
            card_name = "Семерка жезлов",
            id_img = R.drawable.wands07,
        ),
        ShortCard(
            id = 1001130,
            id_card = 1001001,
            card_number = 29,
            card_name = "Восьмерка жезлов",
            id_img = R.drawable.wands08,
        ),
        ShortCard(
            id = 1001131,
            id_card = 1001001,
            card_number = 30,
            card_name = "Девятка жезлов",
            id_img = R.drawable.wands09,
        ),
        ShortCard(
            id = 1001132,
            id_card = 1001001,
            card_number = 31,
            card_name = "Десятка жезлов",
            id_img = R.drawable.wands10,
        ),
        ShortCard(
            id = 1001133,
            id_card = 1001001,
            card_number = 32,
            card_name = "Паж жезлов",
            id_img = R.drawable.wands11,
        ),
        ShortCard(
            id = 1001134,
            id_card = 1001001,
            card_number = 33,
            card_name = "Рыцарь жезлов",
            id_img = R.drawable.wands12,
        ),
        ShortCard(
            id = 1001135,
            id_card = 1001001,
            card_number = 34,
            card_name = "Королева жезлов",
            id_img = R.drawable.wands13,
        ),
        ShortCard(
            id = 1001136,
            id_card = 1001001,
            card_number = 35,
            card_name = "Король жезлов",
            id_img = R.drawable.wands14,
        )
    )

    private val shortsCardInfoCups = listOf(
        ShortCard(
            id = 1001137,
            id_card = 1001001,
            card_number = 36,
            card_name = "Туз кубков",
            id_img = R.drawable.cups01,
        ),
        ShortCard(
            id = 1001138,
            id_card = 1001001,
            card_number = 37,
            card_name = "Двойка кубков",
            id_img = R.drawable.cups02,
        ),
        ShortCard(
            id = 1001139,
            id_card = 1001001,
            card_number = 38,
            card_name = "Тройка кубков",
            id_img = R.drawable.cups03,
        ),
        ShortCard(
            id = 1001140,
            id_card = 1001001,
            card_number = 39,
            card_name = "Четверка кубков",
            id_img = R.drawable.cups04,
        ),
        ShortCard(
            id = 1001141,
            id_card = 1001001,
            card_number = 40,
            card_name = "Пятерка кубков",
            id_img = R.drawable.cups05,
        ),
        ShortCard(
            id = 1001142,
            id_card = 1001001,
            card_number = 41,
            card_name = "Шестерка кубков",
            id_img = R.drawable.cups06,
        ),
        ShortCard(
            id = 1001143,
            id_card = 1001001,
            card_number = 42,
            card_name = "Семерка кубков",
            id_img = R.drawable.cups07,
        ),
        ShortCard(
            id = 1001144,
            id_card = 1001001,
            card_number = 43,
            card_name = "Восьмерка кубков",
            id_img = R.drawable.cups08,
        ),
        ShortCard(
            id = 1001145,
            id_card = 1001001,
            card_number = 44,
            card_name = "Девятка кубков",
            id_img = R.drawable.cups09,
        ),
        ShortCard(
            id = 1001146,
            id_card = 1001001,
            card_number = 45,
            card_name = "Десятка кубков",
            id_img = R.drawable.cups10,
        ),
        ShortCard(
            id = 1001147,
            id_card = 1001001,
            card_number = 46,
            card_name = "Паж кубков",
            id_img = R.drawable.cups11,
        ),
        ShortCard(
            id = 1001148,
            id_card = 1001001,
            card_number = 47,
            card_name = "Рыцарь кубков",
            id_img = R.drawable.cups12,
        ),
        ShortCard(
            id = 1001149,
            id_card = 1001001,
            card_number = 48,
            card_name = "Королева кубков",
            id_img = R.drawable.cups13,
        ),
        ShortCard(
            id = 1001150,
            id_card = 1001001,
            card_number = 49,
            card_name = "Король кубков",
            id_img = R.drawable.cups14,
        )
    )

    private val shortsCardInfoSword = listOf(
        ShortCard(
            id = 1001151,
            card_number = 50,
            id_card = 1001001,
            card_name = "Туз мечей",
            id_img = R.drawable.swords01,
        ),
        ShortCard(
            id = 1001152,
            card_number = 51,
            id_card = 1001001,
            card_name = "Двойка мечей",
            id_img = R.drawable.swords02,
        ),
        ShortCard(
            id = 1001153,
            id_card = 1001001,
            card_number = 52,
            card_name = "Тройка мечей",
            id_img = R.drawable.swords03,
        ),
        ShortCard(
            id = 1001154,
            id_card = 1001001,
            card_number = 53,
            card_name = "Четверка мечей",
            id_img = R.drawable.swords04,
        ),
        ShortCard(
            id = 1001155,
            id_card = 1001001,
            card_number = 54,
            card_name = "Пятерка мечей",
            id_img = R.drawable.swords05,
        ),
        ShortCard(
            id = 1001156,
            id_card = 1001001,
            card_number = 55,
            card_name = "Шестерка мечей",
            id_img = R.drawable.swords06,
        ),
        ShortCard(
            id = 1001157,
            id_card = 1001001,
            card_number = 56,
            card_name = "Семерка мечей",
            id_img = R.drawable.swords07,
        ),
        ShortCard(
            id = 1001158,
            id_card = 1001001,
            card_number = 57,
            card_name = "Восьмерка мечей",
            id_img = R.drawable.swords08,
        ),
        ShortCard(
            id = 1001159,
            id_card = 1001001,
            card_number = 58,
            card_name = "Девятка мечей",
            id_img = R.drawable.swords09,
        ),
        ShortCard(
            id = 1001160,
            id_card = 1001001,
            card_number = 59,
            card_name = "Десятка мечей",
            id_img = R.drawable.swords10,
        ),
        ShortCard(
            id = 1001161,
            id_card = 1001001,
            card_number = 60,
            card_name = "Паж мечей",
            id_img = R.drawable.swords11,
        ),
        ShortCard(
            id = 1001162,
            id_card = 1001001,
            card_number = 61,
            card_name = "Рыцарь мечей",
            id_img = R.drawable.swords12,
        ),
        ShortCard(
            id = 1001163,
            id_card = 1001001,
            card_number = 62,
            card_name = "Королева мечей",
            id_img = R.drawable.swords13,
        ),
        ShortCard(
            id = 1001164,
            id_card = 1001001,
            card_number = 63,
            card_name = "Король мечей",
            id_img = R.drawable.swords14,
        )
    )

    private val shortsCardInfoPentacles = listOf(
        ShortCard(
            id = 1001165,
            id_card = 1001001,
            card_number = 64,
            card_name = "Туз пентаклей",
            id_img = R.drawable.coins01,
        ),
        ShortCard(
            id = 1001166,
            id_card = 1001001,
            card_number = 65,
            card_name = "Двойка пентаклей",
            id_img = R.drawable.coins02,
        ),
        ShortCard(
            id = 1001167,
            id_card = 1001001,
            card_number = 66,
            card_name = "Тройка пентаклей",
            id_img = R.drawable.coins03,
        ),
        ShortCard(
            id = 1001168,
            id_card = 1001001,
            card_number = 67,
            card_name = "Четверка пентаклей",
            id_img = R.drawable.coins04,
        ),
        ShortCard(
            id = 1001169,
            id_card = 1001001,
            card_number = 68,
            card_name = "Пятерка пентаклей",
            id_img = R.drawable.coins05,
        ),
        ShortCard(
            id = 1001170,
            id_card = 1001001,
            card_number = 69,
            card_name = "Шестерка пентаклей",
            id_img = R.drawable.coins06,
        ),
        ShortCard(
            id = 1001171,
            id_card = 1001001,
            card_number = 70,
            card_name = "Семерка пентаклей",
            id_img = R.drawable.coins07,
        ),
        ShortCard(
            id = 1001172,
            id_card = 1001001,
            card_number = 71,
            card_name = "Восьмерка пентаклей",
            id_img = R.drawable.coins08,
        ),
        ShortCard(
            id = 1001173,
            id_card = 1001001,
            card_number = 72,
            card_name = "Девятка пентаклей",
            id_img = R.drawable.coins09,
        ),
        ShortCard(
            id = 1001174,
            id_card = 1001001,
            card_number = 73,
            card_name = "Десятка пентаклей",
            id_img = R.drawable.coins10,
        ),
        ShortCard(
            id = 1001175,
            id_card = 1001001,
            card_number = 74,
            card_name = "Паж пентаклей",
            id_img = R.drawable.coins11,
        ),
        ShortCard(
            id = 1001176,
            id_card = 1001001,
            card_number = 75,
            card_name = "Рыцарь пентаклей",
            id_img = R.drawable.coins12,
        ),
        ShortCard(
            id = 1001177,
            id_card = 1001001,
            card_number = 76,
            card_name = "Королева пентаклей",
            id_img = R.drawable.coins13,
        ),
        ShortCard(
            id = 1001178,
            id_card = 1001001,
            card_number = 77,
            card_name = "Король пентаклей",
            id_img = R.drawable.coins14,
        )
    )

    private val listOfCard = listOf(
        GroupOfSuits(
            id = 1001500,
            name = "Старшие арканы",
            idImg = R.drawable.major_arcana,
            cardsLink = shortsCardInfoMajor
        ),
        GroupOfSuits(
            id = 1001501,
            name = "Жезлы",
            idImg = R.drawable.wands,
            cardsLink = shortsCardInfoWands
        ),
        GroupOfSuits(
            id = 1001502,
            name = "Кубки",
            idImg = R.drawable.cups,
            cardsLink = shortsCardInfoCups
        ),
        GroupOfSuits(
            id = 1001503,
            name = "Мечи",
            idImg = R.drawable.swords,
            cardsLink = shortsCardInfoSword
        ),
        GroupOfSuits(
            id = 1001504,
            name = "Пентакли",
            idImg = R.drawable.pentacles,
            cardsLink = shortsCardInfoPentacles
        )
    )

    override suspend fun getGroupByID(id: Long) : List<GroupOfSuits> = listOfCard

    override suspend fun getCardsBySearchString(name: String): List<ShortCard> {
        val mutableCardList = mutableListOf<ShortCard>()

        listOfCard.forEach{ card ->
            card.cardsLink.forEach{ shortCard ->
                if (shortCard.card_name.contains(name, ignoreCase = true)
                    || shortCard.name_tarot_system.contains(name, ignoreCase = true)
                    || shortCard.name_suits.contains(name, ignoreCase = true)
                ) mutableCardList.add(shortCard)
            }
        }

        return mutableCardList
    }
}