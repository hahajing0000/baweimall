package com.bawei.user.presenter.view

import com.bawei.base.presenter.view.BaseView

/*
    忘记密码 视图回调
 */
interface ForgetPwdView : BaseView {

    /*
        忘记密码回调
     */
    fun onForgetPwdResult(result:String)
}
