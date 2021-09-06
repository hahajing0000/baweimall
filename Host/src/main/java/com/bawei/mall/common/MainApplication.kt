package com.bawei.mall.common

import android.os.Environment
import android.support.multidex.MultiDex
import cn.jpush.android.api.JPushInterface
import com.bawei.hotfixlib.FixDexUtil
import com.bawei.mall.BuildConfig
import com.hyphenate.chat.EMOptions
import com.hyphenate.easeui.EaseUI
//import com.tencent.bugly.Bugly
//import com.tencent.bugly.crashreport.CrashReport
//import com.umeng.analytics.MobclickAgent
//import com.umeng.commonsdk.UMConfigure

/*
    主工程 Application
 */
class MainApplication: com.bawei.dilib.injection.BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        //极光推送初始化
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)

        //IM初始化
//        val optoins:EMOptions= EMOptions()
//        optoins.acceptInvitationAlways=false
//        EaseUI.getInstance().init(this,optoins)


        //多dex支持
        MultiDex.install(this.applicationContext);


        //Bugly异常上报
//        CrashReport.initCrashReport(getApplicationContext(), "039ee77ca9", BuildConfig.DEBUG);
//        Bugly.init(getApplicationContext(), "039ee77ca9", BuildConfig.DEBUG);

//        //友盟统计
//        UMConfigure.init(this, "5fe32ad7d1c1ad39854eaee9", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
//        //自动采集
//        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);

//        /**
//         * 热修复
//         */
//        if (FixDexUtil.isGoingToFix(this)) {
//            FixDexUtil.loadFixedDex(this, Environment.getExternalStorageDirectory());
//        }

        /**
         * 初始化腾讯云直播
         */
        //LiveEnv.getInstance().initEnv("http://license.vod2.myqcloud.com/license/v1/4a6b0b9cb26d0afef2efb38775610430/TXLiveSDK.licence","35788906c3548b820c34cd706f023c75");
    }
}


