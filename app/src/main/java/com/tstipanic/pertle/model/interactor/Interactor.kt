package com.tstipanic.pertle.model.interactor

import com.tstipanic.pertle.common.FirestoreCallback
import com.tstipanic.pertle.model.Comment

interface Interactor {

    fun addDataToDb(comment: Comment)

    fun getDataFromDb(callback: FirestoreCallback)
}