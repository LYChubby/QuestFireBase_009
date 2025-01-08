package com.example.mvvmfirebase

import android.app.Application
import com.example.mvvmfirebase.di.MahasiswaContainer

class MahasiswaApp: Application() {
    lateinit var container: MahasiswaContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}