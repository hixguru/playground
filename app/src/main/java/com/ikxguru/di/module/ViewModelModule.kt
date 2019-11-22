package com.ikxguru.di.module

import androidx.lifecycle.ViewModelProvider
import com.ikxguru.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun provideViewModelFactory(vmf: ViewModelFactory): ViewModelProvider.Factory
}