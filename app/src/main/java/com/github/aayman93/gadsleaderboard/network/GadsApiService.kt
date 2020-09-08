package com.github.aayman93.gadsleaderboard.network

import com.github.aayman93.gadsleaderboard.models.LearningLeader
import com.github.aayman93.gadsleaderboard.models.SkillIqLeader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://gadsapi.herokuapp.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val logger = HttpLoggingInterceptor()
    .setLevel(HttpLoggingInterceptor.Level.BODY)

private val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface GadsApiService {
    @GET("api/hours")
    suspend fun getLearningLeaders(): List<LearningLeader>

    @GET("api/skilliq")
    suspend fun getSkillIqLeaders(): List<SkillIqLeader>
}

object GadsApi {
    val retrofitService: GadsApiService by lazy {
        retrofit.create(GadsApiService::class.java)
    }
}