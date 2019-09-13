package com.example.rxwithmvvm.base

import android.arch.lifecycle.ViewModel
import com.example.rxwithmvvm.injection.component.DaggerViewModelInjector
import com.example.rxwithmvvm.injection.component.ViewModelInjector
import com.example.rxwithmvvm.injection.module.NetworkModule
import com.example.rxwithmvvm.post.PostListViewModel
import com.example.rxwithmvvm.post.PostViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)
        }
    }
}