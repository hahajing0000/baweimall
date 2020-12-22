package com.bawei.goods.injection.component

import com.bawei.goods.injection.module.LiveInfoModule
import com.bawei.goods.ui.activity.LiveListActivity
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import dagger.Component

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(LiveInfoModule::class))
interface LiveInfoComponent {
    fun inject(activity: LiveListActivity)
}