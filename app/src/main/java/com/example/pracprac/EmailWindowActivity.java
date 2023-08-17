package com.example.pracprac;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailWindowActivity extends AppCompatActivity {

    private EditText editTextSenderEmail;
    private EditText editTextReceiverEmail;
    private Button buttonSendEmailToAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emailwindow);

        editTextSenderEmail = findViewById(R.id.editTextSenderEmail);
        editTextReceiverEmail = findViewById(R.id.editTextReceiverEmail);
        buttonSendEmailToAdmin = findViewById(R.id.buttonSendEmailToAdmin);

        buttonSendEmailToAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String senderEmail = editTextSenderEmail.getText().toString();
                String receiverEmail = editTextReceiverEmail.getText().toString();
                sendEmailToAdmin(senderEmail, receiverEmail);
            }
        });
    }

    private void sendEmailToAdmin(String senderEmail, String receiverEmail) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ssadman8877@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Important email");
        intent.putExtra(Intent.EXTRA_TEXT, "Sender: " + senderEmail );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

//+ "\nReceiver: " + receiverEmail