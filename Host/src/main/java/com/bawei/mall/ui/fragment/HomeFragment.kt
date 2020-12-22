package com.bawei.mall.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bawei.base.ext.onClick
import com.bawei.base.ui.adapter.BaseRecyclerViewAdapter
import com.bawei.base.ui.fragment.BaseMvpFragment
import com.bawei.base.widgets.BannerImageLoader
import com.bawei.goods.common.GoodsConstant
import com.bawei.goods.data.protocol.GetGoodsListReq
import com.bawei.goods.data.protocol.Goods
import com.bawei.goods.ui.activity.GoodsActivity
import com.bawei.goods.ui.activity.GoodsDetailActivity
import com.bawei.goods.ui.activity.LiveListActivity
import com.bawei.goods.ui.activity.SearchGoodsActivity
import com.bawei.mall.R
import com.bawei.mall.common.*
import com.bawei.mall.injection.component.DaggerGoodsInfoComponent
import com.bawei.mall.injection.module.GoodsInfoModule
import com.bawei.mall.presenter.GoodsInfoPresenter
import com.bawei.mall.presenter.view.GoodsInfoView
import com.bawei.mall.ui.adapter.HomeDiscountAdapter
import com.bawei.mall.ui.adapter.RecommendAdapter
import com.bawei.mall.ui.adapter.TopicAdapter
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_goodstype_grid.*
import me.crosswall.lib.coverflow.CoverFlow
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

/*
    主界面Fragment
 */
class HomeFragment:BaseMvpFragment<GoodsInfoPresenter>(),GoodsInfoView {
    private lateinit var  goodsListAdapter:RecommendAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater!!, container,savedInstanceState)
        return inflater?.inflate(R.layout.fragment_home,null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initBanner()
        initNews()
        initDiscount()
        initTopic()
        initGoodsInfo();
    }


    /*
        初始化视图
     */
    private fun initView() {
        mSearchEt.onClick {
            startActivity<SearchGoodsActivity>()
        }

        mScanIv.onClick {
            toast(R.string.coming_soon_tip)
        }
        tv_goodstype_live.setOnClickListener({
            v-> startActivity<LiveListActivity>()
        })

        tv_goodstype_pc.setOnClickListener({
            v->startActivity<GoodsActivity>(GoodsConstant.KEY_CATEGORY_ID  to 14)
        })
    }

    /*
        初始化Banner
     */
    private fun initBanner() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        mHomeBanner.setBannerAnimation(Transformer.Accordion)
        mHomeBanner.setDelayTime(2000)
        //设置指示器位置（当banner模式中有指示器时）
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT)
        //banner设置方法全部调用完毕时最后调用
        mHomeBanner.start()

    }

    /*
        初始化公告
     */
    private fun initNews(){
        //公告
        mNewsFlipperView.setData(arrayOf("夏日炎炎，第一波福利还有30秒到达战场", "新用户立领1000元优惠券"))
    }

    /*
        初始化折扣
     */
    private fun initDiscount(){
        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        mHomeDiscountRv.layoutManager = manager

        val discountAdapter  = HomeDiscountAdapter(activity)
        mHomeDiscountRv.adapter = discountAdapter
        discountAdapter.setData(mutableListOf(HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE,HOME_DISCOUNT_SIX, HOME_DISCOUNT_SEVEN))
    }

    /*
        初始化主题
     */
    private fun initTopic(){
        //话题
        mTopicPager.adapter = TopicAdapter(context, listOf(HOME_TOPIC_ONE, HOME_TOPIC_TWO, HOME_TOPIC_THREE, HOME_TOPIC_FOUR, HOME_TOPIC_FIVE))
        mTopicPager.currentItem = 1
        mTopicPager.offscreenPageLimit = 5

        CoverFlow.Builder().with(mTopicPager).scale(0.3f).pagerMargin(-25.0f).spaceSize(0.0f).build()
    }

    /**
     * 初始化推荐商品列表信息
     */
    private fun initGoodsInfo() {
//        mHomeGoodsList.adapter
        val manager=GridLayoutManager(context,2)
        mHomeGoodsList.layoutManager=manager
        goodsListAdapter=RecommendAdapter(activity)
        mHomeGoodsList.adapter=goodsListAdapter

        mPresenter.getGoodsInfo(GetGoodsListReq(14,1))

        goodsListAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Goods>{
            override fun onItemClick(item: Goods, position: Int) {
                startActivity<GoodsDetailActivity>(GoodsConstant.KEY_GOODS_ID to item.id)
            }
        })
    }

    override fun injectComponent() {
        DaggerGoodsInfoComponent.builder().activityComponent(mActivityComponent).goodsInfoModule(GoodsInfoModule()).build().inject(this)
        mPresenter.mView=this
    }

    override fun onSuccess(result: MutableList<Goods>?) {
        if (result != null) {
            goodsListAdapter.setData(result)
        }
    }

}
