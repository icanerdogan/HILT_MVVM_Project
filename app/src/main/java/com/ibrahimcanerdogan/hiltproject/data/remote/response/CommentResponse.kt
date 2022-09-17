package com.ibrahimcanerdogan.hiltproject.data.remote.response


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

class CommentResponse : ArrayList<CommentResponse.CommentResponseItem>(){
    @Keep
    data class CommentResponseItem(
        @SerializedName("postId")
        val postId: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("body")
        val body: String
    )
}