package com.bawei.mall.common

import cn.jpush.android.api.JPushInterface
import com.bawei.base.common.BaseApplication

/*
    主工程 Application
 */
class MainApplication:BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        //极光推送初始化
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
    }
}


