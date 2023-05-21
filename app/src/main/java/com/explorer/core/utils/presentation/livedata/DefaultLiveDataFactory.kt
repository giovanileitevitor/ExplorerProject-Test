package com.explorer.core.utils.presentation.livedata

import androidx.lifecycle.MutableLiveData

class DefaultLiveDataFactory : LiveDataFactory {
    override fun <T : Any> mutableLiveData(): MutableLiveData<T> {
        return MutableLiveData<T>()
    }
}