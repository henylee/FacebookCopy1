package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.data.FriendRequestData;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.util.GrobalDatas;

/**
 * Created by the on 2017-08-09.
 */

public class ChattingAdapter extends ArrayAdapter<MessageData> {

    Context mContext;
    List<MessageData> mList;
    LayoutInflater inf;


    public ChattingAdapter(Context context, List<MessageData> list) {
        super(context, R.layout.message_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.message_chat_list_item, null);
        }

        MessageData data = mList.get(position);

        LinearLayout myMessage = (LinearLayout) row.findViewById(R.id.mymessage);
        LinearLayout opponentmessage = (LinearLayout) row.findViewById(R.id.opponentmessage);

        if (GrobalDatas.loginUserId == data.getSendUserId()) {
            myMessage.setVisibility(View.VISIBLE);
            opponentmessage.setVisibility(View.GONE);

            TextView myMessageTxt = (TextView) row.findViewById(R.id.myMessageTxt);
            myMessageTxt.setText(data.getContenet());
        }
        else {
            myMessage.setVisibility(View.GONE);
            opponentmessage.setVisibility(View.VISIBLE);

            TextView opponentMessaseTxt = (TextView) row.findViewById(R.id.opponentMessaseTxt);
            opponentMessaseTxt.setText(data.getContenet());
        }

        return row;
    }

}
