package com.ikxguru.di.module

import com.ikxguru.repo.Repo
import com.ikxguru.repo.RepoImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AppModuleBinds {

    @Binds
    abstract fun provideRepo(repo: RepoImpl): Repo
}