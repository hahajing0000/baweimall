package com.zy.livelib.push.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.zy.livelib.R;

public class PushStreamActivity extends AppCompatActivity {
    private String TAG=PushStreamActivity.class.getSimpleName();
    private TXLivePusher mLivePusher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_stream);

        initView();

        initLive();

        startPreview();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startPushStream();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPushStream();
    }

    /**
     * 接收推流
     */
    private void stopPushStream() {
        mLivePusher.stopPusher();
        mLivePusher.stopCameraPreview(true); //如果已经启动了摄像头预览，请在结束推流时将其关闭。
    }

    /**
     * 开始推流
     */
    private void startPushStream() {
        String rtmpURL = "rtmp://96329.livepush.myqcloud.com/live/pushstream?txSecret=173768b9c359e5f4c940df57a9ab3a58&txTime=5FE318D0"; //此处填写您的 rtmp 推流地址
        int ret = mLivePusher.startPusher(rtmpURL.trim());
        if (ret == -5) {
            Log.i(TAG, "startRTMPPush: license 校验失败");
        }
    }

    /**
     * 开启摄像头预览
     */
    private void startPreview() {
        //启动本地摄像头预览
        TXCloudVideoView mPusherView = (TXCloudVideoView) findViewById(R.id.pusher_tx_cloud_view);
        mLivePusher.startCameraPreview(mPusherView);
    }

    /**
     * 初始化直播设置
     */
    private void initLive() {
        TXLivePushConfig mLivePushConfig=new TXLivePushConfig();
        mLivePusher = new TXLivePusher(this);
        // 一般情况下不需要修改 config 的默认配置
        mLivePusher.setConfig(mLivePushConfig);
    }

    /**
     * 初始化视图
     */
    private void initView() {

    }
}