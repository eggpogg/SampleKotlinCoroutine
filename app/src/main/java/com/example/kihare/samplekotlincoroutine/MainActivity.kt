package com.example.kihare.samplekotlincoroutine

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById(R.id.hello_world).setOnClickListener { view ->
            launch(UI) {
                val delayTime = delay3000().await()
                (view as TextView).text = "delay $delayTime"
            }
        }
    }

    fun delay3000(): Deferred<*> {
        return async(CommonPool) {
            delay(3000)
            return@async 3000
        }
    }

}
