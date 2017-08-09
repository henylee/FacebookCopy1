package kr.co.tjeit.facebookcopy.fragment;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.NotificationCompatBase;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ListView;

        import java.net.URL;

        import kr.co.tjeit.facebookcopy.R;
        import kr.co.tjeit.facebookcopy.adapter.NewsfeedAdapter;
        import kr.co.tjeit.facebookcopy.util.GrobalDatas;

        import static android.content.Intent.ACTION_VIEW;

/**
 * Created by user on 2017-08-04.
 */

public class NewsfeedFragment extends Fragment {

    ListView newsfeedListView;
    NewsfeedAdapter newsfeedAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_newsfeed, container, false);
        newsfeedListView = (ListView) v.findViewById(R.id.newsfeedListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupEvents();
        setValues();
    }

    private void setupEvents() {

        newsfeedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
            }
        });

    }

    private void setValues() {
        newsfeedAdapter = new NewsfeedAdapter(getActivity(), GrobalDatas.newsfeedDatas);
        newsfeedListView.setAdapter(newsfeedAdapter);
    }
}
