package kr.co.a20200318_test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

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
        binding.roomListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                클릭 된 방의 정보를 목록에서 빼옴. position 번째
                Room clickedRoom = roomDatas.get(position);

//                방 상세 화면으로 이동.
                Intent intent = new Intent(mContext,RoomDetailActuvuty.class);
                intent.putExtra("room",clickedRoom);
                startActivity(intent);

                }


        });

        binding.roomListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Room data = roomDatas.get(position);
//
//                Toast.makeText(mContext, data.getDescription(), Toast.LENGTH_SHORT).show();

//                꾹 누르면, 해당 아이템을 목록에서 삭제.
                roomDatas.remove(position);
//                어댑터에게 새로고침 시킴
                roomAdapter.notifyDataSetChanged();

                return true;// true 롱클릭만. false : 그냥 클릭도 같이
            }
        });
    }

    @Override
    public void setValues() {
        roomAdapter = new RoomAdapter(mContext,R.layout.room_list_item,roomDatas);
        binding.roomListview.setAdapter(roomAdapter);

        addRooms();
    }

    private void addRooms() {
        roomDatas.add(new Room(8000,"서울시 은평구", 4 , "살기 좋은 방입니다"));
        roomDatas.add(new Room(18000,"서울시 노원구", 0 , "노원구의 투룸"));
        roomDatas.add(new Room(28000,"서울시 종로구", 5 , "종로구입니다"));
        roomDatas.add(new Room(38000,"서울시 중랑구", 2 , "2층집 입니다"));
        roomDatas.add(new Room(48000,"서울시 강북구", 10000 , "편의시설이 좋습니다"));


        roomAdapter.notifyDataSetChanged();
    }


}
