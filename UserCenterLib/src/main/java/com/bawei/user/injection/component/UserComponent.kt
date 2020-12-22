package com.bawei.user.injection.component

import com.bawei.user.injection.module.UploadModule
import com.bawei.user.injection.module.UserModule
import com.bawei.user.ui.activity.*
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import dagger.Component

/*
    用户模块Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class,UploadModule::class))
interface UserComponent {
    fun inject(activity:RegisterActivity)
    fun inject(activity:LoginActivity)
    fun inject(activity:ForgetPwdActivity)
    fun inject(activity:ResetPwdActivity)
    fun inject(activity:UserInfoActivity)
}
