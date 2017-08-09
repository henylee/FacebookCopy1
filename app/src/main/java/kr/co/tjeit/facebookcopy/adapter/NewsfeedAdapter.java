package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.ReplyListActivity;
import kr.co.tjeit.facebookcopy.data.NewsfeedData;
import kr.co.tjeit.facebookcopy.util.TimeAgoUtil;

/**
 * Created by the on 2017-08-08.
 */

public class NewsfeedAdapter extends ArrayAdapter<NewsfeedData> {

    Context mContext;
    List<NewsfeedData> mList;
    LayoutInflater inf;

    public NewsfeedAdapter(Context context, List<NewsfeedData> list) {
        super(context, R.layout.newsfeed_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.newsfeed_list_item, null);
        }

        NewsfeedData data = mList.get(position);

        Button likeBtn = (Button) row.findViewById(R.id.likeBtn);
        Button replyBtn = (Button) row.findViewById(R.id.replyBtn);
        TextView newsfeedTxt = (TextView) row.findViewById(R.id.newsfeedTxt);
        TextView urlTxt = (TextView) row.findViewById(R.id.urlTxt);
        TextView newsMinuteAgoTxt = (TextView) row.findViewById(R.id.newsMinuteAgoTxt);
        TextView likeCountTxt = (TextView) row.findViewById(R.id.likeCountTxt);
        LinearLayout previewLayout = (LinearLayout) row.findViewById(R.id.previewLayout);


        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "좋아요를 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        replyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyListActivity.class);
                mContext.startActivity(intent);
            }
        });

        if (data.getLinkUrl().length()==0) {
            previewLayout.setVisibility(View.GONE);
        }
        else {
            previewLayout.setVisibility(View.VISIBLE);
        }

        newsfeedTxt.setText(data.getContentText());
        urlTxt.setText(data.getLinkUrl());

        String likeCountStr = String.format(Locale.KOREA, "%,d개", data.getLikeCount());
        likeCountTxt.setText(likeCountStr);

        String minuteStr = TimeAgoUtil.getTimeAgoString(data.getMinuteAgo());
        newsMinuteAgoTxt.setText(minuteStr);



        return row;
    }

}
