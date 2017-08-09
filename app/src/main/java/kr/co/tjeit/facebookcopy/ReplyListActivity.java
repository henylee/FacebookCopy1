package kr.co.tjeit.facebookcopy;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.tjeit.facebookcopy.adapter.ReplyAdapter;
import kr.co.tjeit.facebookcopy.data.ReplyData;

public class ReplyListActivity extends AppCompatActivity {

    private android.widget.ListView replyListView;
    List<ReplyData> replyDatas = new ArrayList<>();
    ReplyAdapter replyAdapter;
    public EditText replyEdit;
    private android.widget.Button replyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_list);

        bindViews();
        setupEvents();
        setValues();
        addDatas();
    }

    private void addDatas() {
        replyDatas.clear();
        replyDatas.add(new ReplyData(1, 0, "김태희", "김태희입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(2, 1, "아이유", "아이유입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(3, 1, "수지", "수지입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(5, 1, "이요한", "이요한입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(4, 0, "비", "비입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(6, 4, "비", "비입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(7, 4, "비", "비입니다.", Calendar.getInstance()));
        replyDatas.add(new ReplyData(8, 4, "비", "비입니다.", Calendar.getInstance()));

        replyAdapter.notifyDataSetChanged();
    }

    private void setValues() {
        replyAdapter = new ReplyAdapter(ReplyListActivity.this, replyDatas);
        replyListView.setAdapter(replyAdapter);
        InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(replyEdit.getWindowToken(), 0);
    }

    private void setupEvents() {

        replyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = replyEdit.getText().toString();
                int parentId = Integer.parseInt(replyEdit.getTag().toString());
                int index = replyDatas.size();

                if (parentId != 0) {

                    for (int i=0; i<replyDatas.size(); i++) {
                        ReplyData data = replyDatas.get(i);
                        if (parentId==data.getReplyId()) {
                            index=i;
                        }
                        else if (parentId==data.getParentReplyId()) {
                            index=i;
                        }
                    }
                }

                replyDatas.add((index+1), new ReplyData(replyDatas.size()+1, parentId, "user",inputString, Calendar.getInstance()));
                replyAdapter.notifyDataSetChanged();
                replyListView.setSelection(replyAdapter.getCount() - 1);

                replyEdit.setText("");
            }
        });

    }

    private void bindViews() {
        this.replyBtn = (Button) findViewById(R.id.replyBtn);
        this.replyEdit = (EditText) findViewById(R.id.replyEdit);
        this.replyListView = (ListView) findViewById(R.id.replyListView);
    }
}
