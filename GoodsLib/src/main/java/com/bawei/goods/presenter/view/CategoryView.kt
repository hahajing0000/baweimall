package com.bawei.goods.presenter.view

import com.bawei.base.presenter.view.BaseView
import com.bawei.goods.data.protocol.Category

/*
    商品分类 视图回调
 */
interface CategoryView : BaseView {

    //获取商品分类列表
    fun onGetCategoryResult(result: MutableList<Category>?)
}
