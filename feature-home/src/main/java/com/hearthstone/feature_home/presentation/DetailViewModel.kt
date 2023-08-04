package com.hearthstone.feature_home.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hearthstone.feature_home.domain.CardBackUseCase
import com.hearthstone.feature_home.domain.model.Card
import kotlinx.coroutines.launch

class DetailViewModel(
    private val useCase: CardBackUseCase
) : ViewModel(), DefaultLifecycleObserver {

    private val _cardLiveData = MutableLiveData<Card>()
    val cardBackLiveData: LiveData<Card> get() = _cardLiveData

    fun getCard(name: String){
        viewModelScope.launch {
            useCase.getCard(name).collect {
                _cardLiveData.postValue(it)
            }
        }
    }
}