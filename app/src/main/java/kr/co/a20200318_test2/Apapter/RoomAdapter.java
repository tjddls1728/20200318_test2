package kr.co.a20200318_test2.Apapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import kr.co.a20200318_test2.R;
import kr.co.a20200318_test2.datas.Room;

public class RoomAdapter extends ArrayAdapter<Room> {

    Context mContext;
    List<Room> mList;
    LayoutInflater  inf;



    public RoomAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);

        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row ==null){
            row = inf.inflate(R.layout.room_list_item,null);
        }

        Room data = mList.get(position);
        TextView priceTxt = row.findViewById(R.id.priceTxt);
        TextView addressAndFloorTxt = row.findViewById(R.id.addressAndFloorTxt);
        TextView descTxt = row.findViewById(R.id.DescTxt);

//        가격설정 => setText에는 int값 넣지 말자.
//        1만 이상이면 억단위 아니면 숫자만 ,찍어서.
        priceTxt.setText(data.getFormattedPrice());

        String floorStr = "";
        if (data.getFloor()>0){
            floorStr = String.format("%d층",data.getFloor());

        }
        else if (data.getFloor()==0){
            floorStr = "반지하";
        }
        else {
            floorStr = String.format("지하 %d층",data.getFloor()*-1);
        }
//     주소 / 층수 결합
        addressAndFloorTxt.setText(String.format("%s,%s",data.getAddress(),data.getFloorToString()));


//        설명은 들어온 그대로 출력
        descTxt.setText(data.getDescription());



        return row;
    }
}
