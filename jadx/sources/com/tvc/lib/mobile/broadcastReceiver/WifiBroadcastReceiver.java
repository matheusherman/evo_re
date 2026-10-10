package com.tvc.lib.mobile.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class WifiBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"android.net.wifi.RSSI_CHANGED".equals(action)) {
            if ("android.net.wifi.STATE_CHANGE".equals(action)) {
                ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED);
            }
        } else {
            int intExtra = intent.getIntExtra("newRssi", 0);
            Log.i(WifiBroadcastReceiver.class.getName(), "Wifi Singal changed: rssi -= " + intExtra);
            throw null;
        }
    }
}
