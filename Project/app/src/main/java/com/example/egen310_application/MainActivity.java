package com.example.egen310_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BluetoothBroadcaster b = new BluetoothBroadcaster();

        final Button forward = (Button) findViewById(R.id.goForward);
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.sendForwardMessage();
            }
        });

        final Button backward = (Button) findViewById(R.id.goBackward);
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.sendBackwardMessage();
            }
        });

        final Button left = (Button) findViewById(R.id.turnLeft);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.sendLeftMessage();
            }
        });

        final Button right = (Button) findViewById(R.id.turnRight);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.sendRightMessage();
            }
        });
    }
}
