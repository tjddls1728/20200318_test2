package kr.co.a20200318_test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import kr.co.a20200318_test2.databinding.ActivityRoomDetailActuvutyBinding;
import kr.co.a20200318_test2.datas.Room;

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

//        첨부된 방 데이터를 받아서 화면에 출력.
        Room room =(Room) getIntent().getSerializableExtra("room");

        binding.priceTxt.setText(room.getFormattedPrice());

        binding.descTxt.setText(room.getDescription());

        binding.floorTxt.setText(room.getFloorToString());

        binding.addressTxt.setText(room.getAddress());

    }
}
