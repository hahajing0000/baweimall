package com.bawei.mall.injection.component

import com.bawei.base.injection.PerComponentScope
import com.bawei.base.injection.component.ActivityComponent
import com.bawei.mall.injection.module.GoodsInfoModule
import com.bawei.mall.ui.fragment.HomeFragment
import dagger.Component

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(GoodsInfoModule::class))
interface GoodsInfoComponent {
    fun inject(fragment:HomeFragment)
}