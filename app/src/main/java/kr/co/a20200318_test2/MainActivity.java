package kr.co.a20200318_test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import kr.co.a20200318_test2.Apapter.RoomAdapter;
import kr.co.a20200318_test2.databinding.ActivityMainBinding;
import kr.co.a20200318_test2.datas.Room;

public class MainActivity extends baseActivity {

    List<Room> roomDatas = new ArrayList<>();
    RoomAdapter roomAdapter = null;

    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        roomAdapter = new RoomAdapter(mContext,R.layout.room_list_item,roomDatas);
        binding.roomListview.setAdapter(roomAdapter);

    }
}
