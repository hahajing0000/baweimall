package com.bawei.goods.presenter

import com.bawei.base.ext.excute
import com.bawei.base.presenter.BasePresenter
import com.bawei.base.rx.BaseSubscriber
import com.bawei.goods.data.protocol.CartGoods
import com.bawei.goods.presenter.view.CartListView
import com.bawei.goods.service.CartService
import javax.inject.Inject

/*
    购物车 Presenter
 */
class CartListPresenter @Inject constructor() : BasePresenter<CartListView>() {

    @Inject
    lateinit var cartService: CartService


    /*
        获取购物车列表
     */
    fun getCartList() {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.getCartList().excute(object : BaseSubscriber<MutableList<CartGoods>?>(mView) {
            override fun onNext(t: MutableList<CartGoods>?) {
                mView.onGetCartListResult(t)
            }
        }, lifecycleProvider)

    }

    /*
        删除购物车商品
     */
    fun deleteCartList(list: List<Int>) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.deleteCartList(list).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onDeleteCartListResult(t)
            }
        }, lifecycleProvider)

    }

    /*
        提交购物车商品
     */
    fun submitCart(list: MutableList<CartGoods>, totalPrice: Long) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.submitCart(list,totalPrice).excute(object : BaseSubscriber<Int>(mView) {
            override fun onNext(t: Int) {
                mView.onSubmitCartListResult(t)
            }
        }, lifecycleProvider)

    }

}
