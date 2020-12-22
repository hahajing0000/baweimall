package com.bawei.goods.injection.component

import com.bawei.goods.injection.module.CartModule
import com.bawei.goods.injection.module.GoodsModule
import com.bawei.goods.ui.activity.GoodsActivity
import com.bawei.goods.ui.fragment.GoodsDetailTabOneFragment
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import dagger.Component

/*
    商品Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(GoodsModule::class,CartModule::class))
interface GoodsComponent {
    fun inject(activity: GoodsActivity)
    fun inject(fragment: GoodsDetailTabOneFragment)
}
