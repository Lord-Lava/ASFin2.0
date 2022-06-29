package com.lava.asfin20.di

import com.lava.asfin20.data.remote.services.AspireApi
import com.lava.asfin20.data.repository.StudentRepositoryImpl
import com.lava.asfin20.domain.repository.StudentRepository
import com.lava.asfin20.helper.RetrofitRequestHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    @Singleton
    fun provideAspireApi(): AspireApi =
        RetrofitRequestHelper().getAspireClient().create(AspireApi::class.java)

    @Provides
    @Singleton
    fun provideStudentRepository(api: AspireApi): StudentRepository = StudentRepositoryImpl(api)
}