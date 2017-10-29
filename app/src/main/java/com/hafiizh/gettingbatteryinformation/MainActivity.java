package com.hafiizh.gettingbatteryinformation;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv_battery_info = (TextView) findViewById(R.id.tv_battery_info);

        registerReceiver(new BroadcastReceiver() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onReceive(Context context, Intent intent) {
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
                int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
                boolean present = intent.getBooleanExtra(BatteryManager.EXTRA_PRESENT, true);
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                int icon_small = intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL, 0);
                int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0);
                String technology = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
                int temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
                int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);

                tv_battery_info.setText("Status : " + status + "\n" +
                        "Health : " + health + "\n" +
                        "Present : " + present + "\n" +
                        "Level : " + level + "\n" +
                        "Icon Small : " + icon_small + "\n" +
                        "Plugged : " + plugged + "\n" +
                        "Scale : " + scale + "\n" +
                        "Technology : " + technology + "\n" +
                        "Temperature : " + temperature + "\n" +
                        "Voltage : " + voltage);
            }
        }, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}
