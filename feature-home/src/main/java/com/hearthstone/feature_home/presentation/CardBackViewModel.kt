package com.hearthstone.feature_home.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hearthstone.feature_home.domain.CardBackUseCase
import com.hearthstone.feature_home.domain.model.Cardback
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CardBackViewModel(
    private val useCase: CardBackUseCase
) : ViewModel(), DefaultLifecycleObserver {

    private val _itemsCardbackLiveData = MutableLiveData<List<Cardback>>()
    val itemsCardBackLiveData: LiveData<List<Cardback>> get() = _itemsCardbackLiveData

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        viewModelScope.launch {
            useCase.getCardBacksItems().collect {
                _itemsCardbackLiveData.postValue(it)
            }
        }
    }
}