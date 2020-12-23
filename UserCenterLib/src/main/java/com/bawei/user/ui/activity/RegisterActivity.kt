package com.bawei.user.ui.activity

import android.os.Bundle
import android.view.View
import com.bawei.base.ext.enable
import com.bawei.base.ext.onClick
import com.bawei.base.ui.activity.BaseMvpActivity
import com.bawei.user.R
import com.bawei.user.injection.component.DaggerUserComponent
import com.bawei.user.injection.module.UserModule
import com.bawei.user.presenter.RegisterPresenter
import com.bawei.user.presenter.view.RegisterView
import com.hyphenate.chat.EMClient
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast
import java.util.concurrent.Executors

/*
    注册界面
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView,View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()

    }

    /*
        初始化视图
     */
    private fun initView() {

        mRegisterBtn.enable(mMobileEt,{isBtnEnable()})
        mRegisterBtn.enable(mVerifyCodeEt,{isBtnEnable()})
        mRegisterBtn.enable(mPwdEt,{isBtnEnable()})
        mRegisterBtn.enable(mPwdConfirmEt,{isBtnEnable()})

        mVerifyCodeBtn.onClick(this)
        mRegisterBtn.onClick(this)
    }

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    /*
        注册回调
     */
    override fun onRegisterResult(result: String) {
        toast(result)
        finish()
    }

    /*
        点击事件
     */
    override fun onClick(view: View) {
        when(view.id){
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证成功")
            }

            R.id.mRegisterBtn -> {
                mPresenter.register(mMobileEt.text.toString(),mPwdEt.text.toString(),mVerifyCodeEt.text.toString())
                Executors.newCachedThreadPool().submit(object:Runnable{
                    override fun run() {
                        EMClient.getInstance().createAccount(mMobileEt.text.toString(),mPwdEt.text.toString())
                    }
                })
            }
        }
    }

    /*
        判断按钮是否可用
     */
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()&&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}
