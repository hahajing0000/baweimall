package com.bawei.goods.injection.component

import com.bawei.goods.injection.module.CategoryModule
import com.bawei.goods.ui.fragment.CategoryFragment
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import dagger.Component

/*
    商品分类Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(CategoryModule::class))
interface CategoryComponent {
    fun inject(fragment: CategoryFragment)
}
