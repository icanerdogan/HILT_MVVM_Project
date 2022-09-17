package com.ibrahimcanerdogan.hiltproject.util.event

sealed class CommentEvent {
    object GetComment: CommentEvent()
    object AddComment: CommentEvent()
    object DeleteComment: CommentEvent()
    object None: CommentEvent()
}
