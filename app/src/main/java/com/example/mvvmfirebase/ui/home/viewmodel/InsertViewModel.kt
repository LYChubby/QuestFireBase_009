package com.example.mvvmfirebase.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmfirebase.repository.RepositoryMhs

sealed class FormState {
    object Idle : FormState()
    object Loading : FormState()
    data class Success(val message: String) : FormState()
    data class Error(val message: String) : FormState()
}