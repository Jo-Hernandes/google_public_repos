package com.jonathas.googlepublicrepositories.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jonathas.googlepublicrepositories.commons.observeOnMainThread
import io.reactivex.disposables.Disposable

class HomeViewModel(
    private val getData: GetDataUseCase
) : ViewModel() {

    private var repositoryDisposable: Disposable? = null
        set(value) {
            field?.dispose()
            field = value
        }

    private val _repositoryList: MutableLiveData<List<HomeRepoModel>> = MutableLiveData()
    val repositoryList: LiveData<List<HomeRepoModel>> get() = _repositoryList

    fun fetchData() {
        repositoryDisposable = getData(1)
            .observeOnMainThread()
            .subscribe(_repositoryList::postValue){
                it.printStackTrace()
            }
    }


    override fun onCleared() {
        super.onCleared()
        repositoryDisposable?.dispose()
        repositoryDisposable = null
    }

}