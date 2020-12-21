package com.bawei.user.presenter.view

import com.bawei.base.presenter.view.BaseView

/*
    用户注册 视图回调
 */
interface RegisterView:BaseView{

    fun onRegisterResult(result:String)
}
