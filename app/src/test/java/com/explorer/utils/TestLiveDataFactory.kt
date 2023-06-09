package com.explorer.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.explorer.core.utils.presentation.livedata.LiveDataFactory

class TestLiveDataFactory<T>(
    private val observer: Observer<T>
): LiveDataFactory {
    override fun <T : Any> mutableLiveData(): MutableLiveData<T> {
        return MutableLiveData<T>().apply {
            observeForever(observer as Observer<in T>)
        }
    }
}