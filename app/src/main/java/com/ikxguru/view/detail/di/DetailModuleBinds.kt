package com.ikxguru.view.detail.di

import androidx.lifecycle.ViewModel
import com.ikxguru.di.annotations.ViewModelKey
import com.ikxguru.view.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailModuleBinds {

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun provideDetailViewModel(vm: DetailViewModel): ViewModel
}