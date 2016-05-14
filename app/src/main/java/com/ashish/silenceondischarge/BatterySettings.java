package com.ashish.silenceondischarge;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BatterySettings extends AppCompatActivity
{
    private List<String> listSpinner;
    private int batteryThreshold;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_settings);
        final Spinner thresholdSpinner = (Spinner) findViewById(R.id.thresholdSpinner);
        Button activateBtn = (Button) findViewById(R.id.activateBtn);

        thresholdSpinner.setPrompt("Battery Level");
        listSpinner = new ArrayList<String>();

        for(int i = 1; i < 50; i++)
        {
            listSpinner.add("" + i);
        }

        ArrayAdapter<String> thresholdAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSpinner);
        thresholdAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        thresholdSpinner.setAdapter(thresholdAdapter);

        activateBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                batteryThreshold = Integer.parseInt(thresholdSpinner.getSelectedItem().toString());
                Toast.makeText(getApplicationContext(), batteryThreshold + "", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_battery_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
