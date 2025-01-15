package com.example.mvvmfirebase.ui.home.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmfirebase.model.Mahasiswa
import com.example.mvvmfirebase.repository.RepositoryMhs
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class DetailViewModel (
    private val repositoryMhs: RepositoryMhs
): ViewModel() {

    var detailUIState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    init {
        getMhs()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getMhs() {
        viewModelScope.launch {
            repositoryMhs.getAllMhs()
                .onStart {
                    detailUIState = DetailUiState.Loading
                }
                .catch {
                    detailUIState = DetailUiState.Error(e = it)
                }
                .collect {
                    detailUIState = if (it.isEmpty()) {
                        DetailUiState.Error(Exception("Belum Ada Data Mahasiswa"))
                    } else {
                        DetailUiState.Success(it)
                    }
                }
        }
    }
}

sealed class DetailUiState {
    object Loading : DetailUiState()

    data class Success(val data: List<Mahasiswa>) : DetailUiState()
    data class Error(val e: Throwable) : DetailUiState()
}