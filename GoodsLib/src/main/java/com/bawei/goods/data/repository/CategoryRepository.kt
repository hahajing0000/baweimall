package com.bawei.goods.data.repository

import com.bawei.base.data.net.RetrofitFactory
import com.bawei.base.data.protocol.BaseResp
import com.bawei.goods.data.api.CategoryApi
import com.bawei.goods.data.protocol.Category
import com.bawei.goods.data.protocol.GetCategoryReq
import rx.Observable
import javax.inject.Inject

/*
    商品分类 数据层
 */
class CategoryRepository @Inject constructor(){
    /*
        获取商品分类
     */
    fun getCategory(parentId: Int): Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance.create(CategoryApi::class.java).getCategory(GetCategoryReq(parentId))
    }

}
