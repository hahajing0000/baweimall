package com.bawei.user.presenter.view

import com.bawei.base.presenter.view.BaseView
import com.bawei.user.data.protocol.UserInfo

/*
    用户登录 视图回调
 */
interface LoginView : BaseView {

    fun onLoginResult(result:UserInfo)
}
