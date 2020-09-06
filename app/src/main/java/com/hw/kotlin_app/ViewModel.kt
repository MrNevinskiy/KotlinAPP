package com.hw.kotlin_app

import android.os.Handler
import androidx.databinding.ObservableField

class ViewModel {

    var model: Model = Model()
    val text = ObservableField<String>()

    fun update(){
        model.updateData(object : OnDataReadyCallback {
            override fun onDataReady(data: Int) {
                text.set(data.toString())
            }
        })
    }

    class Model {

        var count: Int = 0

        fun updateData(onDataReadyCallback: OnDataReadyCallback) {
            count += 1
            Handler().postDelayed({
                onDataReadyCallback.onDataReady(count)
            },10)
        }
    }

    interface OnDataReadyCallback {
        fun onDataReady(data: Int)

    }

}