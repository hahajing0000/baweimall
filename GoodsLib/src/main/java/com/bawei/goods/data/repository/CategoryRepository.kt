package com.bawei.goods.data.repository

import com.bawei.goods.data.api.CategoryApi
import com.bawei.goods.data.protocol.Category
import com.bawei.goods.data.protocol.GetCategoryReq
import com.bawei.provider.entity.protocol.BaseResp
import com.bawei.netutilslib.RetrofitFactory
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
