package kr.co.a20200318_test2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
                Log.d("리스트뷰 아이템클릭",String.format("%d번중 클릭",position));
                Room clickedRoom = roomDatas.get(position);
                Toast.makeText(mContext,clickedRoom.getAddress(),Toast.LENGTH_SHORT).show();

                }


        });

        binding.roomListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Room data = roomDatas.get(position);

                Toast.makeText(mContext, data.getDescription(), Toast.LENGTH_SHORT).show();

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
        roomDatas.add(new Room(18000,"서울시 노원구", 2 , "노원구의 투룸"));
        roomDatas.add(new Room(28000,"서울시 종로구", 5 , "종로구입니다"));
        roomDatas.add(new Room(38000,"서울시 중랑구", 2 , "2층집 입니다"));
        roomDatas.add(new Room(48000,"서울시 강북구", 10000 , "편의시설이 좋습니다"));


        roomAdapter.notifyDataSetChanged();
    }


}
