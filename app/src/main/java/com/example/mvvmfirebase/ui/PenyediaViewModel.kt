package com.example.mvvmfirebase.ui

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mvvmfirebase.MahasiswaApp
import com.example.mvvmfirebase.ui.home.viewmodel.DetailViewModel
import com.example.mvvmfirebase.ui.home.viewmodel.HomeViewModel
import com.example.mvvmfirebase.ui.home.viewmodel.InsertViewModel

object PenyediaViewModel{
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(mahasiswaApp().container.repositoryMhs)
        }
        initializer {
            InsertViewModel(mahasiswaApp().container.repositoryMhs)
        }
        initializer {
            DetailViewModel(mahasiswaApp().container.repositoryMhs)
        }
    }
}

fun CreationExtras.mahasiswaApp(): MahasiswaApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApp)