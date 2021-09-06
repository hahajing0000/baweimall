package com.bawei.goods.ui.activity

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.Gravity
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.bawei.base.ext.onClick
import com.bawei.base.ui.activity.BaseActivity
import com.bawei.goods.R
import com.bawei.goods.common.GoodsConstant
import com.bawei.goods.event.AddCartEvent
import com.bawei.goods.event.UpdateCartSizeEvent
import com.bawei.goods.ui.adapter.GoodsDetailVpAdapter
import com.hyphenate.easeui.ui.ChatActivity
import kotlinx.android.synthetic.main.activity_goods_detail.*
import org.jetbrains.anko.startActivity
import q.rorbin.badgeview.QBadgeView

/*
    商品详情 Activity
 */
class GoodsDetailActivity:BaseActivity() {

    private lateinit var mCartBdage:QBadgeView
    lateinit var animatorSet:AnimatorSet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_goods_detail)
        initView()
        initObserve()
        loadCartSize()
        startAnimate();
    }

    /**
     * 开启动画
     */
    private fun startAnimate() {
        animatorSet=AnimatorSet()
        val animatorx=ObjectAnimator.ofFloat(mImTv,"scaleX",1F,1.1F)
        animatorx.repeatCount= Animator.DURATION_INFINITE.toInt()
        animatorx.setDuration(2000)
        val animatory=ObjectAnimator.ofFloat(mImTv,"scaleY",1F,1.1F)
        animatory.repeatCount= Animator.DURATION_INFINITE.toInt()
        animatory.setDuration(2000)
        animatorSet.playTogether(animatorx,animatory)

        animatorSet.start()
    }

    override fun onStop() {
        super.onStop()
        animatorSet.cancel()

    }

    /*
            初始化视图
         */
    private fun initView() {
//        throw RuntimeException("一个测试用的运行时异常")

        mGoodsDetailTab.tabMode = TabLayout.MODE_FIXED
        mGoodsDetailVp.adapter = GoodsDetailVpAdapter(supportFragmentManager,this)
        //TabLayout关联ViewPager
        mGoodsDetailTab.setupWithViewPager(mGoodsDetailVp)

        mAddCartBtn.onClick {
            com.bawei.base.common.afterLogin {
                Bus.send(AddCartEvent())
            }
        }

        mEnterCartTv.onClick {
            startActivity<CartActivity>()
        }

        mLeftIv.onClick {
            finish()
        }

        mImTv.onClick {
            startActivity<ChatActivity>("user" to "店小二")
        }

        mCartBdage = QBadgeView(this)
    }

    /*
        加载购物车数量
     */
    private fun loadCartSize() {
        setCartBadge()
    }

    /*
        监听购物车数量变化
     */
    private fun initObserve(){
        Bus.observe<UpdateCartSizeEvent>()
                .subscribe {
                    setCartBadge()
                }.registerInBus(this)
    }

    /*
        设置购物车标签
     */
    private fun setCartBadge() {
        mCartBdage.badgeGravity = Gravity.END or Gravity.TOP
        mCartBdage.setGravityOffset(22f,-2f,true)
        mCartBdage.setBadgeTextSize(6f,true)
        mCartBdage.bindTarget(mEnterCartTv).badgeNumber = com.bawei.storagelib.AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE)

    }

    /*
        Bus取消监听
     */
    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }
}
