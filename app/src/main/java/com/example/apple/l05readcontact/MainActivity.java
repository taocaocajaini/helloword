package com.example.apple.l05readcontact;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        while (c.moveToNext()){
           String name= c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
           String tel= c.getString(c.getColumnIndex(ContactsContract.Contacts.PHONETIC_NAME));
            Log.i("MainActivity","联系人＝" + name);
            Log.i("MainActivity","电话＝" + tel);
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
