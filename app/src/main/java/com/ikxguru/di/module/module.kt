package com.ikxguru.di.module

import com.ikxguru.BuildConfig
import com.ikxguru.remote.Remote
import com.ikxguru.repo.Repo
import com.ikxguru.repo.RepoImpl
import com.ikxguru.view.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {

    single<OkHttpClient> {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BuildConfig.END_POINT)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.createAsync())
            .build()
    }

    single<Remote> {
        val retrofit = get() as Retrofit
        retrofit.create(Remote::class.java)
    }

    single<Repo> {
        RepoImpl(get())
    }

    viewModel {
        MainViewModel(get())
    }
}