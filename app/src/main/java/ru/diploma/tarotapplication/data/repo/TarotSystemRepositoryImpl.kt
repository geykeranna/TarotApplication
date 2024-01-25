package ru.diploma.tarotapplication.data.repo

import ru.diploma.tarotapplication.R
import ru.diploma.tarotapplication.data.model.TarotDecks
import ru.diploma.tarotapplication.domain.repositories.TarotSystemRepository
import javax.inject.Inject

class TarotSystemRepositoryImpl @Inject constructor(

) : TarotSystemRepository {

    override suspend fun getSystemList(): List<TarotDecks> {
        return listOf(
            TarotDecks(
                id = 1001,
                name = "Таро Уэйта",
                img_id = R.drawable.rider_waite_tarot_system,
                description = "Таро Уэйта — поможет вам разобраться в себе и своих чувствах, отделить истинные желания от ложных, найти свой путь в жизни, увидеть решение сложной ситуации и понять намерения других людей."
            ),
            TarotDecks(
                id = 1003,
                name = "Таро Манара",
                img_id = R.drawable.manara_tarot_system,
                description = "Таро Манара - сюжетная колода, позволяющая \"воссоздать\" целую историю вашего вопроса. Идеальна, как уже отмечалось другими рецензентами, для работы с вопросами личных взаимоотношений."
            ),
            TarotDecks(
                id = 1002,
                name = "Таро Тотта",
                img_id = R.drawable.thoth_tarot_system,
                description = "Карты Таро Тота используются исключительно для того, чтобы увидеть прошлое и текущее положение дел. А отличается эта колода тем, что в ней нет перевёрнутых значений. "
            )
        )
    }
}