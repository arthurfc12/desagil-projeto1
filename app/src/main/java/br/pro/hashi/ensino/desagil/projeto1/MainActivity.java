package br.pro.hashi.ensino.desagil.projeto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_SEND_SMS = 0;


    private void startButtonMorse() {

        Intent intent = new Intent(this, Button_Morse.class);

        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonExample = findViewById(R.id.button_permission);

        buttonExample.setOnClickListener((view) -> {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {

                startButtonMorse();
            } else {

                String[] permissions = new String[]{
                        Manifest.permission.SEND_SMS,
                };

                ActivityCompat.requestPermissions(this, permissions, REQUEST_SEND_SMS);
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_SEND_SMS && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            startButtonMorse();
        }
    }
}