package com.example.shelfari.presentation.shelves

import androidx.compose.foundation.gestures.DraggableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShelvesViewModel @Inject constructor(): ViewModel() {
    private val _tabIndex: MutableLiveData<Int> = MutableLiveData(0)
    val tabIndex: LiveData<Int> = _tabIndex
    val tabs = listOf("Reading", "To Read", "Have Read")

    var isSwipeToLeft: Boolean = false
    private val draggableState = DraggableState {delta ->
        isSwipeToLeft = delta > 0
    }

    private val _dragState = MutableLiveData<DraggableState>(draggableState)
    val dragState: LiveData<DraggableState> = _dragState

    fun updateTabIndexBasedOnSwipe() {
        _tabIndex.value = when (isSwipeToLeft) {
            true -> Math.floorMod(_tabIndex.value!!.plus(1), tabs.size)
            false -> Math.floorMod(_tabIndex.value!!.minus(1), tabs.size)
        }
    }

    fun updateTabIndex(i: Int) {
        _tabIndex.value = i
    }
}