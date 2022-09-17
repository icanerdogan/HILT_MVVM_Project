package com.ibrahimcanerdogan.hiltproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahimcanerdogan.hiltproject.data.local.entity.CommentLocalEntity
import com.ibrahimcanerdogan.hiltproject.repository.CommentRepositoryImpl
import com.ibrahimcanerdogan.hiltproject.util.ResultState
import com.ibrahimcanerdogan.hiltproject.util.event.CommentEvent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CommentViewModel(private val commentRepository: CommentRepositoryImpl): ViewModel() {

    private val _state: MutableLiveData<ResultState<List<CommentLocalEntity>>> = MutableLiveData()
    val state: LiveData<ResultState<List<CommentLocalEntity>>>
        get() = _state

    fun setCommentState(commentEvent: CommentEvent) {
        viewModelScope.launch {
            when(commentEvent) {
                is CommentEvent.GetComment -> {
                    commentRepository.getCommments()
                        .onEach {
                            _state.value = it
                        }
                        .launchIn(viewModelScope)
                }
                is CommentEvent.AddComment -> {

                }
                is CommentEvent.DeleteComment -> {

                }
                is CommentEvent.None -> {

                }
            }
        }
    }
}