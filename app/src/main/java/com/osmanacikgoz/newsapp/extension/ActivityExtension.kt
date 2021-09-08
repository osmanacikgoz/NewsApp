package com.osmanacikgoz.newsapp.extension

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Activity.showFragment(resContainerId: Int, fragment: Fragment) {
    when (this) {
        is AppCompatActivity -> {
            supportFragmentManager.beginTransaction().apply {
                replace(resContainerId, fragment)
                    .addToBackStack(fragment.tag)
                commit()
            }
        }
    }
}

fun Activity.sharePlainText(plainText: String?) {
    plainText?.let {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, it)
        startActivity(Intent.createChooser(intent, "Paylaş"))
    }
}