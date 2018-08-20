package com.coverlabs.mvvmdagger.di

import com.coverlabs.mvvmdagger.view.MainActivity
import dagger.Component

@Component
interface MVVMDaggerComponent {
    fun inject(app: MainActivity)
}