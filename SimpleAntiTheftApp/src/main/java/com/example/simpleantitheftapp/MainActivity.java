package com.example.simpleantitheftapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//        String senderNum = getIntent().getStringExtra("SENDER");
//        if(senderNum != null) {
//            Intent intent1 = new Intent(Intent.ACTION_CALL);
//            intent1.setData(Uri.parse("tel:"+senderNum));
//            startActivity(intent1);
//        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
