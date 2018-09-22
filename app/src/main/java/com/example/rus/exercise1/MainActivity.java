package com.example.rus.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //develop branch

    private EditText messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        messageEditText = findViewById(R.id.message_edit_text);
        sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessageActivity();
            }
        });
    }

    private void openMessageActivity() {
        if (!TextUtils.isEmpty(messageEditText.getText())){
            Intent intent = MessageActivity.newIntent(this, messageEditText.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.no_text_warning, Toast.LENGTH_SHORT).show();
        }
    }
}
