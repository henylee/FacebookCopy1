package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.ReplyListActivity;
import kr.co.tjeit.facebookcopy.data.ReplyData;
import kr.co.tjeit.facebookcopy.util.GrobalDatas;

/**
 * Created by the on 2017-08-09.
 */

public class ReplyAdapter extends ArrayAdapter<ReplyData> {

    Context mContext;
    List<ReplyData> mList;
    LayoutInflater inf;

    public ReplyAdapter(Context context, List<ReplyData> list) {
        super(context, R.layout.reply_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.reply_list_item, null);
        }

        final ReplyData data = mList.get(position);

        LinearLayout replyLayout = (LinearLayout) row.findViewById(R.id.replyLayout);
        LinearLayout replyReplyLayout = (LinearLayout) row.findViewById(R.id.replyReplyLayout);

        TextView replyNameTxt = (TextView) row.findViewById(R.id.replyNameTxt);
        TextView replyContentTxt = (TextView) row.findViewById(R.id.replyContentTxt);
        TextView reReplyNameTxt = (TextView) row.findViewById(R.id.reReplyNameTxt);
        TextView reReplyContentTxt = (TextView) row.findViewById(R.id.reReplyContentTxt);

        replyNameTxt.setText(data.getReplyUserName());
        replyContentTxt.setText(data.getReplyContentTxt());
        reReplyNameTxt.setText(data.getReplyUserName());
        reReplyContentTxt.setText(data.getReplyContentTxt());

        TextView makeRorTxt1 = (TextView) row.findViewById(R.id.makeRorTxt1);
        TextView makeRorTxt2 = (TextView) row.findViewById(R.id.makeRorTxt2);

        makeRorTxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int orignalReplyNum = data.getReplyId();
                ((ReplyListActivity) mContext).replyEdit.setTag(orignalReplyNum);
            }
        });

        makeRorTxt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int orignalReplyNum = data.getParentReplyId();
                ((ReplyListActivity) mContext).replyEdit.setTag(orignalReplyNum);
            }
        });

        if (data.getParentReplyId()==0) {
            replyLayout.setVisibility(View.VISIBLE);
            replyReplyLayout.setVisibility(View.GONE);
        }
        else {
            replyLayout.setVisibility(View.GONE);
            replyReplyLayout.setVisibility(View.VISIBLE);
        }

        return row;
    }
}
