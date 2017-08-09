package kr.co.tjeit.facebookcopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.adapter.NotificationAdapter;
import kr.co.tjeit.facebookcopy.util.GrobalDatas;

/**
 * Created by the on 2017-08-08.
 */

public class NotificationFragment extends Fragment {

    ListView notificationListView;
    NotificationAdapter notificationAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification, container, false);
        notificationListView = (ListView) v.findViewById(R.id.notificationListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupEvnets();
        setValues();

    }

    private void setupEvnets() {

        notificationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), position+"번 줄 클릭", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setValues() {

        notificationAdapter = new NotificationAdapter(getActivity(), GrobalDatas.notificationDatas);
        notificationListView.setAdapter(notificationAdapter);
    }

}
