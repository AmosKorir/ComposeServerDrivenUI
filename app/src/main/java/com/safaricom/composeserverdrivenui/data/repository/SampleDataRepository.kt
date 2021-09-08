package com.safaricom.composeserverdrivenui.data.repository

import com.safaricom.composeserverdrivenui.data.api.ViewApi
import com.safaricom.composeserverdrivenui.data.apiresponse.MainViewApiResponse
import com.safaricom.composeserverdrivenui.domain.SampleDataRepositoryInter
import io.reactivex.Single

class SampleDataRepository(private val viewApi: ViewApi) : SampleDataRepositoryInter {
    override fun getViewData(): Single<MainViewApiResponse> {
       return viewApi.getVIewData()
    }

}

