package com.safaricom.composeserverdrivenui.di


import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.safaricom.composeserverdrivenui.BuildConfig
import com.safaricom.composeserverdrivenui.data.api.ViewApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.KoinComponent
import org.koin.core.qualifier.named
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

class ApiModule {
    companion object : KoinComponent {
        val module = org.koin.dsl.module {


            fun provideHttpClient(): OkHttpClient {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val okHttpClientBuilder = OkHttpClient.Builder()
                    .addInterceptor(Interceptor { chain ->
                        val original: Request = chain.request()
                        val request: Request = original.newBuilder()
                            .build()
                        chain.proceed(request)
                    })
                    .addInterceptor(object : Interceptor {
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val request = chain.request()
                            val response = chain.proceed(request)

                            val responseBody = response.body
                            val source = responseBody?.source();
                            source?.request(Long.MAX_VALUE); // request the entire body.
                            val buffer = source?.buffer();
                            val responseBodyString =
                                buffer?.clone()?.readString(Charset.forName("UTF-8"))
                            if (response.code in 400..500) {
                                if (responseBodyString != null) {
                                    // sendErrorBody(responseBodyString)
                                }
                                return response
                            }

                            return response
                        }

                    })
                    .addInterceptor(httpLoggingInterceptor)

                return okHttpClientBuilder.build()
            }

            fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
                return Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(factory))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()
            }


            fun provideGson(): Gson {
                return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
            }




            single { provideGson() }
            single(named("default_okhttp")) { provideHttpClient() }

            single(named("withoutToken_retrofit")) {
                provideRetrofit(
                    get(),
                    get(named("default_okhttp"))
                )
            }


            single { provideRetrofit(get(), get(named("access_Okhttp"))) }

            fun provideViewApi(retrofit: Retrofit): ViewApi {
                return retrofit.create(ViewApi::class.java)
            }

            single { provideViewApi(get(named("withoutToken_retrofit"))) }
//            fun provideAuthApi(retrofit: Retrofit): AuthApi {
//
//                return retrofit.create(AuthApi::class.java)
//            }
//
//            fun provideProductApi(retrofit: Retrofit): ProductApi {
//                return retrofit.create(ProductApi::class.java)
//            }
//
//            fun provideCampaignApi(retrofit: Retrofit): CampaignApi {
//                return retrofit.create(CampaignApi::class.java)
//            }

//            single { provideAuthApi(get(named("withoutToken_retrofit"))) }
//
//            single { provideProductApi(get()) }
//
//            single { provideCampaignApi(get()) }
        }
    }
}