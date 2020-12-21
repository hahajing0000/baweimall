package com.bawei.goods.service.impl

import com.bawei.base.ext.convert
import com.bawei.goods.data.protocol.Category
import com.bawei.goods.data.repository.CategoryRepository
import com.bawei.goods.service.CategoryService
import rx.Observable
import javax.inject.Inject

/*
    商品分类 业务层 实现类
 */
class CategoryServiceImpl @Inject constructor(): CategoryService{
    @Inject
    lateinit var repository: CategoryRepository

    /*
        获取商品分类列表
     */
    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return repository.getCategory(parentId).convert()
    }


}
