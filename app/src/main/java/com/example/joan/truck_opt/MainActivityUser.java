package com.example.joan.truck_opt;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivityUser extends ActionBarActivity {
    PacketListAdapter packetListAdapter;
    ListView packetList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packetList = (ListView) findViewById(R.id.packet_list);
        packetListAdapter = new PacketListAdapter(this);
        testData();
        packetList.setAdapter(packetListAdapter);
    }
    private void testData(){
        for (int i = 0; i < 100; i=i+2) {
            packetListAdapter.add(new Delivery(i, "Here", "Th3ere", Arrays.asList("A", "B")));
            packetListAdapter.add(new Delivery(i+1, "Anotha one" + i, "Th3ere", Arrays.asList("A", "B")));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
