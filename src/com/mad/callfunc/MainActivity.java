package com.mad.callfunc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity
{

	protected EditText mPhoneNo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mPhoneNo = (EditText) findViewById(R.id.phoneNo);
		findViewById(R.id.dial).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String strPhoneNo = mPhoneNo.getText().toString();
				Intent callIntent = new Intent(Intent.ACTION_DIAL);
				callIntent.setData(Uri.parse("tel:" + strPhoneNo));
				startActivity(callIntent);
			}
		});

		findViewById(R.id.call).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String strPhoneNo = mPhoneNo.getText().toString();
				// It's require permission android.permission.CALL_PHONE
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:" + strPhoneNo));
				startActivity(callIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
