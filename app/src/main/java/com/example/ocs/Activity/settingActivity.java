package com.example.ocs.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ocs.R;
import com.google.firebase.database.DatabaseReference;

public class settingActivity extends AppCompatActivity {

    private Button update;
    DatabaseReference reference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        update = (Button) findViewById(R.id.updateBtn);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (isNameChanged() || isPasswordChanged()) {
//                    Toast.makeText(getApplicationContext(), "Data has been updated", Toast.LENGTH_SHORT).show();
//                }
            }

//            private boolean isPasswordChanged() { }
//
//            private boolean isNameChanged() { }
        });
    }
}
