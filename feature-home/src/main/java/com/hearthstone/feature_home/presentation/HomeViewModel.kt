package com.hearthstone.feature_home.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hearthstone.feature_home.domain.HomeUseCase
import com.hearthstone.feature_home.domain.model.Card
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCase: HomeUseCase
) : ViewModel(), DefaultLifecycleObserver {

    private val _itemsCardLiveData = MutableLiveData<List<Card>>()
    val itemsCardBackLiveData: LiveData<List<Card>> get() = _itemsCardLiveData

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        viewModelScope.launch {
            useCase.getCardItems().collect {
                _itemsCardLiveData.postValue(it)
            }
        }
    }
}