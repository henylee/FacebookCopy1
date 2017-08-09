package kr.co.tjeit.facebookcopy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EditStatusActivity extends AppCompatActivity {

    private android.widget.TextView titleTxt;
    private android.widget.LinearLayout picAndmovieTxtLayout;
    private android.widget.LinearLayout broadTxtLayout;
    private android.widget.LinearLayout checkInTxtLayout;
    private android.widget.LinearLayout myconditionTxtLayout;
    private android.widget.Button registBtn;
    private android.widget.EditText prepareTxt;
    private Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_status);


        bindViews();
        setupEvents();
        setValues();


    }

    private void setValues() {

    }

    private void setupEvents() {
        View.OnClickListener prepareListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditStatusActivity.this, "준비중인 기능입니다.", Toast.LENGTH_SHORT).show();
            }
        };

        picAndmovieTxtLayout.setOnClickListener(prepareListener);
        broadTxtLayout.setOnClickListener(prepareListener);
        checkInTxtLayout.setOnClickListener(prepareListener);
        myconditionTxtLayout.setOnClickListener(prepareListener);

        prepareTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String inputText = s.toString();
                if (inputText.length() > 0) {
                    registBtn.setTextColor(Color.parseColor("#3333FF"));
                } else {
                    registBtn.setTextColor(Color.parseColor("#A0A0A0"));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        registBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prepareTxt.getText().toString().length() == 0) {
                    Toast.makeText(EditStatusActivity.this, "게시글을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditStatusActivity.this, "게시글이 등록됩니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void bindViews() {
        this.myconditionTxtLayout = (LinearLayout) findViewById(R.id.myconditionTxtLayout);
        this.checkInTxtLayout = (LinearLayout) findViewById(R.id.checkInTxtLayout);
        this.broadTxtLayout = (LinearLayout) findViewById(R.id.broadTxtLayout);
        this.picAndmovieTxtLayout = (LinearLayout) findViewById(R.id.picAndmovieTxtLayout);
        this.prepareTxt = (EditText) findViewById(R.id.prepareTxt);
        this.registBtn = (Button) findViewById(R.id.registBtn);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
        this.cancelBtn = (Button) findViewById(R.id.cancelBtn);
    }
}
