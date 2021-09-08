package com.safaricom.composeserverdrivenui.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.safaricom.composeserverdrivenui.data.apiresponse.MainViewApiResponse
import com.safaricom.composeserverdrivenui.domain.SampleDataRepositoryInter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val sampleDataRepositoryInter: SampleDataRepositoryInter) :
    ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _handleLiveData = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> get() = _handleLiveData

    //getData for the UI
    val mainPageData = mutableStateOf<MainViewApiResponse?>(null)
    fun getViewData() {
        val disposable = sampleDataRepositoryInter.getViewData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mainPageData.value = it
            }, {
                _handleLiveData.value = it;
            })
    }

}