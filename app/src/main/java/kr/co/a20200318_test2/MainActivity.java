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

        addRooms();
    }

    private void addRooms() {
        roomDatas.add(new Room(8000,"서울시 은평구", 4 , "살기 좋은 방입니다"));
        roomDatas.add(new Room(8000,"서울시 노원구", 4 , "노원구의 투룸"));
        roomDatas.add(new Room(8000,"서울시 종로구", 4 , "종로구입니다"));
        roomDatas.add(new Room(8000,"서울시 중랑구", 4 , "2층집 입니다"));
        roomDatas.add(new Room(8000,"서울시 강북구", 4 , "편의시설이 좋습니다"));


        roomAdapter.notifyDataSetChanged();
    }


}
