package com.bawei.mall.ui.activity

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.bawei.mall.R
import kotlinx.android.synthetic.main.activity_loading.*
import org.jetbrains.anko.startActivity

class LoadingActivity : AppCompatActivity() {
    var i:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        handler.postDelayed(object:Runnable{
            override fun run() {
                handler.postDelayed(this,1000)
                i=i+1
                runOnUiThread {
                    mIvTimes.text="倒计时:${(5-i).toString()}秒"
                }
                if (i==5){
                    startActivity<MainActivity>()
                    finish()
                }
            }

        },1000L)
    }

    val handler:Handler= Handler()
}