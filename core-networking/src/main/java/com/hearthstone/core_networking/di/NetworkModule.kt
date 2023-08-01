package com.hearthstone.core_networking.di

import com.hearthstone.core.networking.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object NetworkModule {
    val module = module {
        single(QualifierHost) {
            ""
        }

        single {
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }

        single(QualifierAuthInterceptor) {
            Interceptor { chain ->
                val newRequest =
                    chain.request()
                        .newBuilder()
                        .addHeader("X-RapidAPI-Key", BuildConfig.X_RAPIDAPI_KEY)
                        .addHeader("X-RapidAPI-Host", BuildConfig.X_RAPIDAPI_HOST)
                        .addHeader("Content-Type", "application/json;charset=utf-8")
                        .build()
                chain.proceed(newRequest)
            }
        }

        single<Interceptor>(QualifierLoggerInterceptor) {
            HttpLoggingInterceptor().setLevel(
                HttpLoggingInterceptor.Level.NONE
            )
        }
        single {
            provideRetrofit(
                okHttpClient = get(),
                moshi = get(),
                baseUrl = get(QualifierHost)
            )
        }

        single {
            provideOkhttp(
                get(QualifierAuthInterceptor),
                get(QualifierLoggerInterceptor),
            )
        }
    }

    private fun provideOkhttp(
        vararg interceptor: Interceptor
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
        interceptor.forEach {
            okHttpClientBuilder.addInterceptor(it)
        }
        return okHttpClientBuilder
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    private fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
        baseUrl: String
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .addCallAdapterFactory(NetworkResponseAdapterFactory(moshi))
            .build()
}