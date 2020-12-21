package com.bawei.user.presenter

import com.bawei.base.ext.excute
import com.bawei.base.presenter.BasePresenter
import com.bawei.base.rx.BaseSubscriber
import com.bawei.user.data.protocol.UserInfo
import com.bawei.user.presenter.view.LoginView
import com.bawei.user.service.UserService
import javax.inject.Inject

/*
    登录界面 Presenter
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    /*
        登录
     */
    fun login(mobile: String, pwd: String, pushId: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.login(mobile, pwd, pushId).excute(object : BaseSubscriber<UserInfo>(mView) {
            override fun onNext(t: UserInfo) {
                    mView.onLoginResult(t)
            }
        }, lifecycleProvider)

    }

}
