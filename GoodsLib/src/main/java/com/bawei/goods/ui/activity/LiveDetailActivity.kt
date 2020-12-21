package com.bawei.goods.ui.activity

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import cn.jzvd.Jzvd
import com.bumptech.glide.Glide
import com.bawei.goods.R
import com.bawei.goods.common.GoodsConstant
import com.bawei.goods.data.protocol.LiveRealInfo
import kotlinx.android.synthetic.main.activity_live_detail.*
import org.jetbrains.anko.startActivity

class LiveDetailActivity : AppCompatActivity() {
    lateinit var item:LiveRealInfo
    private var isDialogSelected:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_detail)

        item = intent.getParcelableExtra<LiveRealInfo>(GoodsConstant.KEY_LIVE_ITEM_PATH)

        mLiveDetailBackIv.setOnClickListener {
            v->finish()
        }

        handler.postDelayed(object:Runnable{
            override fun run() {
                var animation:Animation
                if (!isDialogSelected){
                    ll_goods.visibility=View.VISIBLE
                    animation = AnimationUtils.loadAnimation(this@LiveDetailActivity, R.anim.dialog_left)
                    isDialogSelected=true
                }
                else{
                    animation=AnimationUtils.loadAnimation(this@LiveDetailActivity,R.anim.dialog_right);
                    isDialogSelected=false
                    ll_goods.visibility=View.GONE
                }

                ll_goods.startAnimation(animation)
                handler.postDelayed(this,10000)
            }

        },3000)
        ll_goods.visibility= View.GONE

        ll_goods.setOnClickListener {
            startActivity<GoodsDetailActivity>(GoodsConstant.KEY_GOODS_ID to 1)
        }

        val imageView = ll_goods.findViewById<ImageView>(R.id.mGoodsDetailItemIv)
        Glide.with(this).load("https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg").into(imageView)
    }

    private val handler:Handler= Handler()

    override fun onResume() {
        super.onResume()
        jz_video.setUp(item.livepath,item.livedesc)
        //设置封面
        jz_video.thumbImageView.setImageURI(Uri.parse(item.imgpath))
        //自动播放
        jz_video.startVideo()

        mLiveDetailDesc1Tv.isSelected=true

        mLiveDetailViewerCount.text=(1000..9999).random().toString()+"人正在观看"



    }

    override fun onBackPressed() {
        if (Jzvd.backPress()){
            return;
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }
}