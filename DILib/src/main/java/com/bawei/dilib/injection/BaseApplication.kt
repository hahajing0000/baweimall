package com.bawei.dilib.injection

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.injection.component.AppComponent
import com.kotlin.base.injection.component.DaggerAppComponent
import com.kotlin.base.injection.module.AppModule


/*
    Application 基类
 */
open class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()

        context = this

        //ARouter初始化
        ARouter.openLog()    // 打印日志
        ARouter.openDebug()
        ARouter.init(this)
    }

    /*
        Application Component初始化
     */
    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    /*
        全局伴生对象
     */
    companion object {
        lateinit var context: Context
    }
}
