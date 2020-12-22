package com.bawei.mall.common

import cn.jpush.android.api.JPushInterface
import com.zy.dilib.injection.BaseApplication

/*
    主工程 Application
 */
class MainApplication: com.zy.dilib.injection.BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        //极光推送初始化
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
    }
}


