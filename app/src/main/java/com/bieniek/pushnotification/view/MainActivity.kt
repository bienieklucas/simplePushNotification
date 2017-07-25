package com.bieniek.pushnotification.view

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.bieniek.pushnotification.R
import com.bieniek.pushnotification.util.ConstantUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.hasExtra(ConstantUtil.PUSH_TITLE_EXTRA))
            showNotificationMessage()
    }

    private fun showNotificationMessage() {
        val dialog: AlertDialog = AlertDialog.Builder(this)
                .setTitle(intent.getStringExtra(ConstantUtil.PUSH_TITLE_EXTRA))
                .setMessage(intent.getStringExtra(ConstantUtil.PUSH_BODY_EXTRA))
                .setCancelable(false)
                .setPositiveButton(R.string.positive_button_text,
                        { dialog, which -> dialog.dismiss() })
                .create()
        dialog.show()
    }
}
