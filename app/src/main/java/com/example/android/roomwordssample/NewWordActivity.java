package com.example.android.roomwordssample;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY_WORD_ID = "com.example.android.wordlistsql.EXTRA_ID";
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditWordView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        mEditWordView = findViewById(R.id.edit_word);
        Intent intent = getIntent();//cambia de pantalla
        if (intent.hasExtra(EXTRA_REPLY_WORD_ID)){
            setTitle("Editar");
            mEditWordView.setText(intent.getStringExtra(EXTRA_REPLY_WORD_ID));
        }else {
            setTitle("Add word");
        }

         Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    int id = getIntent().getIntExtra(EXTRA_REPLY_WORD_ID, -1);
                    if (id != -1){
                        replyIntent.putExtra(EXTRA_REPLY_WORD_ID,id);
                    }
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}

