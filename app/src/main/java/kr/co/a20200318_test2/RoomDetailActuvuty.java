package kr.co.a20200318_test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import kr.co.a20200318_test2.databinding.ActivityRoomDetailActuvutyBinding;

public class RoomDetailActuvuty extends baseActivity {

    ActivityRoomDetailActuvutyBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_room_detail_actuvuty);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

    }
}
