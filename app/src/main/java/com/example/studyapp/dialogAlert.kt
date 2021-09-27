package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface


class dialogAlert(activity: Activity, title: String, text: String) {
    init {

        val dialogBuilder = AlertDialog.Builder(activity)

        dialogBuilder.setMessage(text)

            .setPositiveButton("OK", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle(title)
        alert.show()
    }
}
