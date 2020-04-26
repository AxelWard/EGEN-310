package com.example.egen310_application;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class BluetoothBroadcaster {

    BluetoothBroadcaster() {

    }

    public boolean sendForwardMessage() {
        return true;
    }

    public boolean sendBackwardMessage() {
        return true;
    }

    public boolean sendLeftMessage() {
        return true;
    }

    public boolean sendRightMessage() {
        return true;
    }

    public void BTConnect() {

        final UUID MY_UUID = UUID.fromString("0000110E-0000-1000-8000-00805F9B34FB");
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothSocket socket = null;
        String RPi_MAC = "XX:XX:XX:XX:XX:XX";

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        // If there are paired devices
        if (pairedDevices.size() > 0) {

            // Loop through paired devices
            for (BluetoothDevice device : pairedDevices) {
                if (device.getAddress().equals(RPi_MAC)) {
                    try {
                        socket = device.createInsecureRfcommSocketToServiceRecord(MY_UUID);
                    } catch (IOException e0) {
                        Log.d("BT_TEST", "Cannot create socket");
                        e0.printStackTrace();
                    }

                    try {
                        socket.connect();
                    } catch (IOException e1) {
                        try {
                            socket.close();
                            Log.d("BT_TEST", "Cannot connect");
                            e1.printStackTrace();
                        } catch (IOException e2) {
                            Log.d("BT_TEST", "Socket not closed");
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
