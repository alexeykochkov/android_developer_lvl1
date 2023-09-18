package com.example.myapplication.di

import com.example.myapplication.domain.GetUsefulActivityUseCase
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun provideMainViewModel(useCase: GetUsefulActivityUseCase): MainViewModel {
        return MainViewModel(useCase)
    }

    @Provides
    fun provideFactory(mainViewModel: MainViewModel): ViewModelFactory {
        return ViewModelFactory(mainViewModel)
    }

}