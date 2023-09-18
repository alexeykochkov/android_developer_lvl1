package com.example.myapplication.di

import com.example.myapplication.data.RetrofitInstance
import com.example.myapplication.data.UsefulActivitiesRepository
import com.example.myapplication.data.UsefulActivityRepository
import com.example.myapplication.domain.GetUsefulActivityUseCase
import com.example.myapplication.presentation.ViewModelFactory
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideRetrofit(): UsefulActivityRepository {
        return RetrofitInstance.usefulActivityRepository
    }

    @Provides
    fun provideUsefulActivitiesRepository(api: UsefulActivityRepository): UsefulActivitiesRepository {
        return UsefulActivitiesRepository(api)
    }

    @Provides
    fun provideGetUsefulActivityUseCase(usefulActivitiesRepository: UsefulActivitiesRepository): GetUsefulActivityUseCase {
        return GetUsefulActivityUseCase(usefulActivitiesRepository)
    }

}

@Component(modules = [DataModule::class, PresentationModule::class])
interface AppComponent {
    fun mainViewModelFactory(): ViewModelFactory
}