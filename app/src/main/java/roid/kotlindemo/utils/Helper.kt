package roid.kotlindemo.utils

import android.content.Context
import android.widget.Toast

/**
 * Created by abc on 6/30/2017.
 */


class Helper {

    companion object {
        public fun toast(context: Context, message: String, length: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(context, message, length).show()
        }
    }

    fun toast(context: Context, message: Int, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, length).show()
    }
}