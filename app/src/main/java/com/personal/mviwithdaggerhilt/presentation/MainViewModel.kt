package com.personal.mviwithdaggerhilt.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.mviwithdaggerhilt.domain.Blog
import com.personal.mviwithdaggerhilt.repository.MainRepository
import com.personal.mviwithdaggerhilt.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: MainRepository
): ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Blog>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Blog>>> get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when(mainStateEvent) {
                is MainStateEvent.GetBlogEvents -> {
                    repository.getBlog()
                        .map { _dataState.value = it }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None -> {

                }
            }
        }
    }
}

sealed class MainStateEvent{
    object GetBlogEvents: MainStateEvent()
    object None: MainStateEvent()
}
