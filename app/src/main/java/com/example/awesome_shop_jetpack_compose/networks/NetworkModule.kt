package com.example.awesome_shop_jetpack_compose.networks

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiInterface(): ApiInterface {
        return ApiClient.getInstance().create(ApiInterface::class.java)
    }
}