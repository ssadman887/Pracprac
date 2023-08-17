package com.example.pracprac;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button buttonSearch;
    private Button buttonEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonSearch = findViewById(R.id.buttonSearch);
        buttonEmail = findViewById(R.id.buttonEmail);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = editText.getText().toString();
                performWebSearch(keyword);
            }
        });

        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmailWindow();
            }
        });
    }

    private void performWebSearch(String keyword) {
        // Open a web search with the keyword
        String url = "https://www.google.com/search?q=" + keyword;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void openEmailWindow() {
        Intent intent = new Intent(MainActivity.this, EmailWindowActivity.class);
        startActivity(intent);
    }
}
