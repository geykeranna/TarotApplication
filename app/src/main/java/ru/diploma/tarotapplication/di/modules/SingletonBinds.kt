package ru.diploma.tarotapplication.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.diploma.tarotapplication.data.repo.CardRepositoryImpl
import ru.diploma.tarotapplication.data.repo.GroupOfSuitsRepositoryImpl
import ru.diploma.tarotapplication.data.repo.TarotSystemRepositoryImpl
import ru.diploma.tarotapplication.domain.repositories.CardRepository
import ru.diploma.tarotapplication.domain.repositories.GroupOfSuitsRepository
import ru.diploma.tarotapplication.domain.repositories.TarotSystemRepository
import ru.diploma.tarotapplication.ui.detailcard.DetailCardScreenFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface SingletonBinds {

    @Binds
    @Singleton
    fun bindTarotSystemRepository(tarotSystemRepositoryImpl: TarotSystemRepositoryImpl) : TarotSystemRepository

    @Binds
    @Singleton
    fun bindGroupOfSuitsRepository(groupOfSuitsRepositoryImpl: GroupOfSuitsRepositoryImpl) : GroupOfSuitsRepository

    @Binds
    @Singleton
    fun bindDetailCardRepository(cardRepositoryImpl: CardRepositoryImpl) : CardRepository
}