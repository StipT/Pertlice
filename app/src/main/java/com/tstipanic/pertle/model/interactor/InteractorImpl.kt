package com.tstipanic.pertle.model.interactor

import android.util.Log

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.tstipanic.pertle.common.COLLECTION_NAME
import com.tstipanic.pertle.common.FirestoreCallback
import com.tstipanic.pertle.common.TIMESTAMP_FIELD
import com.tstipanic.pertle.model.Comment


class InteractorImpl : Interactor {
    private val firestoreDb = FirebaseFirestore.getInstance().collection(COLLECTION_NAME)


    override fun addDataToDb(comment: Comment) {
        firestoreDb.add(comment).addOnCompleteListener { Log.d("addDataToDb", "Success: " + it.result.toString()) }
    }


    override fun getDataFromDb(callback: FirestoreCallback) {
        firestoreDb.orderBy(TIMESTAMP_FIELD, Query.Direction.DESCENDING)
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val list = mutableListOf<Comment>()
                    for (document in it.result!!) {
                        val comment: Comment = document.toObject(Comment::class.java)
                        list.add(comment)
                    }
                    callback.onSuccess(list)
                }
            }
    }
}