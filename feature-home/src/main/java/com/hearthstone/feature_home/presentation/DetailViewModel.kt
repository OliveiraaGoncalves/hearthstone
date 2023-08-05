package com.hearthstone.feature_home.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hearthstone.feature_home.domain.HomeUseCase
import com.hearthstone.feature_home.domain.model.Card
import kotlinx.coroutines.launch

sealed class DetailState {
    data class Error(val message: String) : DetailState()
    data class Success(val card: Card) : DetailState()
}

class DetailViewModel(
    private val useCase: HomeUseCase
) : ViewModel(), DefaultLifecycleObserver {

    private val _cardLiveData = MutableLiveData<DetailState>()
    val cardBackLiveData: LiveData<DetailState> get() = _cardLiveData

    fun getCard(name: String) {
        viewModelScope.launch {
            try {
                useCase.getCard(name).collect {
                    _cardLiveData.postValue(DetailState.Success(it))
                }
            } catch (e: Exception) {
                _cardLiveData.postValue(DetailState.Error("Falha ao buscar os dados"))
            }
        }
    }
}