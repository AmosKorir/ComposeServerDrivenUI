package com.safaricom.composeserverdrivenui.data.api

import com.safaricom.composeserverdrivenui.data.apiresponse.MainViewApiResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ViewApi {
    @GET("main_paige")
    fun getVIewData(): Single<MainViewApiResponse>

}