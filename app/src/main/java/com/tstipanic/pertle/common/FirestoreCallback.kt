package com.tstipanic.pertle.common

import com.tstipanic.pertle.model.Comment

interface FirestoreCallback {
    fun onSuccess(list: List<Comment>)
    fun onFailure()
}