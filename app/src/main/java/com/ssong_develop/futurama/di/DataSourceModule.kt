package com.ssong_develop.futurama.di

import com.ssong_develop.data.source.CharacterDataSource
import com.ssong_develop.data.source.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideCharacterDataSource(source : CharacterDataSource) : DataSource = source
}