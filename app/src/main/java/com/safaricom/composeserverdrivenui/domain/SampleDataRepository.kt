package com.safaricom.composeserverdrivenui.domain

import com.safaricom.composeserverdrivenui.data.apiresponse.MainViewApiResponse
import io.reactivex.Single

interface SampleDataRepositoryInter {
    fun getViewData(): Single<MainViewApiResponse>
}