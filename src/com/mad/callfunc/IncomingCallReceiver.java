package com.mad.callfunc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class IncomingCallReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent) {
		try {

			String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

			if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
				String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
				Toast.makeText(context, "Hey, you got call from : " + number, Toast.LENGTH_LONG).show();
			}

			if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
				Toast.makeText(context, "Hmm, you received call", Toast.LENGTH_LONG).show();
			}

			if(state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
				Toast.makeText(context, "Phone is in idle state", Toast.LENGTH_LONG).show();
			}
		} catch(Exception e) {
			Toast.makeText(context, "Ooops! somethig wrong happen", Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}
}
