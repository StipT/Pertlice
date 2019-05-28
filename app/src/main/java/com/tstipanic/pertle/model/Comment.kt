package com.tstipanic.pertle.model

import com.google.firebase.firestore.ServerTimestamp

data class Comment(
    val username: String = "Anonymous",
    val content: String = "",
    @ServerTimestamp val timestamp: com.google.firebase.Timestamp ?= null
)