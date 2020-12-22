package com.bawei.goods.data.api

import com.bawei.goods.data.protocol.Category
import com.bawei.goods.data.protocol.GetCategoryReq
import com.bawei.provider.entity.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/*
    商品分类接口
 */
interface CategoryApi {
    /*
        获取商品分类列表
     */
    @POST("category/getCategory")
    fun getCategory(@Body req: GetCategoryReq): Observable<BaseResp<MutableList<Category>?>>
}
