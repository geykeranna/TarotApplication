package ru.diploma.tarotapplication.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.diploma.tarotapplication.data.repo.GroupOfSuitsRepositoryImpl
import ru.diploma.tarotapplication.domain.repositories.GroupOfSuitsRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface SingletonBinds {

    @Binds
    @Singleton
    fun bindGroupOfSuitsRepository(groupOfSuitsRepositoryImpl: GroupOfSuitsRepositoryImpl) : GroupOfSuitsRepository
}