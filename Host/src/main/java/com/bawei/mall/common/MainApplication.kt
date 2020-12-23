package com.bawei.mall.common

import android.support.multidex.MultiDex
import cn.jpush.android.api.JPushInterface
import com.bawei.mall.BuildConfig
import com.hyphenate.chat.EMOptions
import com.hyphenate.easeui.EaseUI
import com.tencent.bugly.crashreport.CrashReport
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

        //IM初始化
        val optoins:EMOptions= EMOptions()
        optoins.acceptInvitationAlways=false
        EaseUI.getInstance().init(this,optoins)


        //多dex支持
        MultiDex.install(this.applicationContext);


        //Bugly异常上报
        CrashReport.initCrashReport(getApplicationContext(), "039ee77ca9", BuildConfig.DEBUG);
        /**
         * 初始化腾讯云直播
         */
        //LiveEnv.getInstance().initEnv("http://license.vod2.myqcloud.com/license/v1/4a6b0b9cb26d0afef2efb38775610430/TXLiveSDK.licence","35788906c3548b820c34cd706f023c75");
    }
}


