package com.bawei.livelib.push;

import com.tencent.rtmp.TXLiveBase;
import com.bawei.dilib.injection.BaseApplication;

/**
 * @author:zhangyue
 * @date:2020/12/22
 */
public class LiveEnv {
    private static volatile LiveEnv instance=null;

    private LiveEnv(){}
    static Object lockObj=new Object();
    public static LiveEnv getInstance(){
        if (null==instance){
            synchronized (lockObj){
                if (null==instance){
                    instance=new LiveEnv();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化腾讯云直播环境
     * @param licenceUrl
     * @param licenceKey
     */
    public void initEnv(String licenceUrl,String licenceKey){
        TXLiveBase.getInstance().setLicence(BaseApplication.context,licenceUrl,licenceKey);
    }
}
