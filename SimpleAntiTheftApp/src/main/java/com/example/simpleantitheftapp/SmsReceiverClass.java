package com.example.simpleantitheftapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by stejasvin on 5/22/2014.
 */
public class SmsReceiverClass extends BroadcastReceiver {

    // Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();

    public void onReceive(Context context, Intent intent) {

        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                    Log.e("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);

                    // Show Alert
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context,
                            "senderNum: " + senderNum + ", message: " + message, duration);
                    toast.show();

                    if(message.toLowerCase().equals("hey buddy listen")){

                        Intent intent1 = new Intent(Intent.ACTION_CALL);
                        intent1.setData(Uri.parse("tel:" + senderNum));
//                        startActivity(intent1);

                        //Intent intent1 = new Intent(context,MainActivity.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //intent1.putExtra("SENDER",senderNum);
                        context.startActivity(intent1);
                    };

                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);

        }
    }
}


