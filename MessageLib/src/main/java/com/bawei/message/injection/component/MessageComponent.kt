package com.bawei.message.injection.component


import com.bawei.message.injection.module.MessageModule
import com.bawei.message.ui.fragment.MessageFragment
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import dagger.Component

/*
    消息模块注入组件
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(MessageModule::class))
interface MessageComponent{
    fun inject(fragment:MessageFragment)
}
