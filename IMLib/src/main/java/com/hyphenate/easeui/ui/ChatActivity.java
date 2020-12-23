package com.hyphenate.easeui.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.R;

public class ChatActivity extends AppCompatActivity {
    private FrameLayout flChat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        String user = getIntent().getStringExtra("user");
        if (TextUtils.isEmpty(user)){
            Toast.makeText(this,"请指定用户",Toast.LENGTH_SHORT).show();
            finish();
        }

        flChat = (FrameLayout) findViewById(R.id.fl_chat);

        //new出EaseChatFragment或其子类的实例
        EaseChatFragment chatFragment = new EaseChatFragment();
        //传入参数
        Bundle args = new Bundle();
        args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
        args.putString(EaseConstant.EXTRA_USER_ID, user);
        chatFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_chat, chatFragment).commit();
    }
}