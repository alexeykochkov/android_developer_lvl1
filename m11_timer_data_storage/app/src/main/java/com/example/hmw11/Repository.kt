package com.example.hmw11

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

private const val NAME_FILE = "NAME"
private const val NAME_TEXT = "TEXT"

class Repository(context: Context) {

    var pref = context.getSharedPreferences(NAME_FILE, Context.MODE_PRIVATE)
    var local_text_: String? = null


    fun getDataFromSharedPreference(): String? {
        return pref.getString(NAME_TEXT, null)
    }

    fun getDataFromLocalVariable(): String? {
        return local_text_
    }

    fun saveText(text: String) {
        local_text_ = text

        pref.edit {
            putString(NAME_TEXT, text)
        }

    }

    fun clearText() {
        local_text_ = null
        pref.edit {
            clear()
        }
    }

    fun getText(): String {
//        return getDataFromLocalVariable()?: getDataFromSharedPreference()?: ""
        return when {
            getDataFromLocalVariable() != null -> getDataFromLocalVariable()
            getDataFromLocalVariable() == null -> getDataFromSharedPreference()
            else -> ""
        } ?: ""
    }
}