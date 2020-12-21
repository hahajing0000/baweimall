package com.bawei.goods.injection.component

import com.bawei.base.injection.PerComponentScope
import com.bawei.base.injection.component.ActivityComponent
import com.bawei.goods.injection.module.LiveInfoModule
import com.bawei.goods.ui.activity.LiveListActivity
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