package kr.co.tjeit.facebookcopy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import kr.co.tjeit.facebookcopy.ChattingActivity;
import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.adapter.MessageAdapter;
import kr.co.tjeit.facebookcopy.util.GrobalDatas;

/**
 * Created by the on 2017-08-08.
 */

public class MessageFragment extends Fragment {

    ListView MessageListView;
    MessageAdapter messageAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, container, false);
        MessageListView = (ListView) v.findViewById(R.id.MessageListView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupEvents();
        setValues();
    }

    private void setupEvents() {
        MessageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ChattingActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setValues() {
        messageAdapter = new MessageAdapter(getActivity(), GrobalDatas.messageDatas);
        MessageListView.setAdapter(messageAdapter);
    }
}
