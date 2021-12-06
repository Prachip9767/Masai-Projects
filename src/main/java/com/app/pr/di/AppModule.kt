package com.app.pr.di

import com.app.pr.api.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val Base_URL="http://api.themoviedb.org/"
    @Provides
    fun ApiService() : ApiClient {
        val requestInterceptor = Interceptor {
            val url = it.request()
                .url
                .newBuilder()
                .addQueryParameter("api_key", "328c283cd27bd1877d9080ccb1604c91")
                .build()

            val request = it.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor it.proceed(request)
        }


        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.themoviedb.org/3/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
    }

}
