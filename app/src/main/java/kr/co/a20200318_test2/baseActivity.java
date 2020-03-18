package kr.co.a20200318_test2;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public abstract class baseActivity extends AppCompatActivity {

    public Context mContext = this;

    public abstract void setupEvents(); //이벤트셋팅
    public abstract void setValues(); // 값셋팅

}
