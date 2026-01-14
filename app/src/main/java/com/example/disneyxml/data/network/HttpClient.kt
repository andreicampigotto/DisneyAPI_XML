package com.example.disneyxml.data.network

import com.example.disneyxml.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

private const val TIMEOUT_90 = 90L
private const val BASE_URL = "https://api.disneyapi.dev/character/"

class HTTPClient {

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                return@Interceptor chain.proceed(builder.build())
            }
        )
        .readTimeout(TIMEOUT_90, TimeUnit.SECONDS)
        .connectTimeout(TIMEOUT_90, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_90, TimeUnit.SECONDS)

    private val provideRetrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun <T : Any> create(clazz: KClass<T>): T = provideRetrofit.create(clazz.java)
}
