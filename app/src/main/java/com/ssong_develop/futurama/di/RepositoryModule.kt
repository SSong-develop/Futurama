package com.ssong_develop.futurama.di

import com.ssong_develop.data.repository.CharacterRepository
import com.ssong_develop.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCharacterRepository(repository : CharacterRepository) : Repository = repository

}