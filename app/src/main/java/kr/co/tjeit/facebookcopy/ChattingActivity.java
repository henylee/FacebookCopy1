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

import kr.co.tjeit.facebookcopy.adapter.ChattingAdapter;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.util.GrobalDatas;

public class ChattingActivity extends AppCompatActivity {

    private ListView chattingListView;
    List<MessageData> messageDatas = new ArrayList<>();
    ChattingAdapter mAdapter;
    private android.widget.EditText editMessageTxt;
    private android.widget.Button MessageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);


        bindViews();
        setupEvents();
        setValues();
        addMessageDatas();
    }

    private void addMessageDatas() {
        messageDatas.clear();
        messageDatas.add(new MessageData(10, "ㅎㅇㅎㅇ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅇㅇ", Calendar.getInstance()));
        messageDatas.add(new MessageData(9, "ㅋㅋㅋㅋ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "머함??", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "롤??", Calendar.getInstance()));
        messageDatas.add(new MessageData(9, "ㄴㄴ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅇㅋㅇㅋ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅂㅇㅂㅇ", Calendar.getInstance()));
        messageDatas.add(new MessageData(9, "ㅇㅋ", Calendar.getInstance()));
        messageDatas.add(new MessageData(10, "ㅇㅇ", Calendar.getInstance()));

        mAdapter.notifyDataSetChanged();

    }

    private void setValues() {
        mAdapter = new ChattingAdapter(ChattingActivity.this, messageDatas);
        chattingListView.setAdapter(mAdapter);
    }

    private void setupEvents() {
        MessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                messageDatas.add(new MessageData(GrobalDatas.loginUserId, editMessageTxt.getText().toString(), Calendar.getInstance()));
                mAdapter.notifyDataSetChanged();
                editMessageTxt.setText("");

                View view = ChattingActivity.this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                chattingListView.setSelection(mAdapter.getCount() - 1);
            }
        });
    }

    private void bindViews() {
        this.MessageBtn = (Button) findViewById(R.id.MessageBtn);
        this.editMessageTxt = (EditText) findViewById(R.id.editMessageTxt);
        this.chattingListView = (ListView) findViewById(R.id.chattingListView);
    }
}
