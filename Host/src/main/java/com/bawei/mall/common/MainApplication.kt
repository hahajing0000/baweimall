package com.bawei.mall.common

import cn.jpush.android.api.JPushInterface
import com.zy.dilib.injection.BaseApplication
import com.zy.livelib.push.LiveEnv

/*
    主工程 Application
 */
class MainApplication: com.zy.dilib.injection.BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        //极光推送初始化
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)

        /**
         * 初始化腾讯云直播
         */
        //LiveEnv.getInstance().initEnv("http://license.vod2.myqcloud.com/license/v1/4a6b0b9cb26d0afef2efb38775610430/TXLiveSDK.licence","35788906c3548b820c34cd706f023c75");
    }
}


