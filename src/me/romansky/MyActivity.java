package me.romansky;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

	public void startBackground(View view){
		Toast.makeText(this, "Starting background service..",Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(getApplicationContext(), RadarService.class);
		startService(intent);
	}
}
