package com.codingwithmitch.account.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AccountModule {

    @Singleton
    @Provides
    @Named("accountString")
    fun provideAccountString(): String{
        return "Account"
    }
}