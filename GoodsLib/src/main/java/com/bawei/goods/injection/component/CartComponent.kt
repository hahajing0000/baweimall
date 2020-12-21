package com.bawei.goods.injection.component

import com.bawei.base.injection.PerComponentScope
import com.bawei.base.injection.component.ActivityComponent
import com.bawei.goods.injection.module.CartModule
import com.bawei.goods.ui.fragment.CartFragment
import dagger.Component

/*
    购物车Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(CartModule::class))
interface CartComponent {
    fun inject(fragment: CartFragment)
}
