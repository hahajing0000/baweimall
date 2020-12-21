package com.bawei.pay.injection.component

import com.bawei.base.injection.PerComponentScope
import com.bawei.base.injection.component.ActivityComponent
import com.bawei.pay.injection.module.PayModule
import com.bawei.pay.ui.activity.CashRegisterActivity
import dagger.Component

/*
    支付Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(PayModule::class))
interface PayComponent {
    fun inject(activity: CashRegisterActivity)
}
