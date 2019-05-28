package com.tstipanic.pertle.common

import com.tstipanic.pertle.model.Comment

interface FirestoreCallback {
    fun onCallback(list: List<Comment>)
}