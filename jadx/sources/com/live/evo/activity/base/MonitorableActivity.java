package com.live.evo.activity.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001a\u0010\u0003¨\u0006\u001b"}, d2 = {"Lcom/live/evo/activity/base/MonitorableActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "k", "()Ljava/lang/String;", "", "l", "()I", "Landroid/os/Bundle;", "savedInstanceState", "Lr8/z;", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onStart", "onResume", "onPause", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onStop", "onRestart", "onDestroy", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MonitorableActivity extends AppCompatActivity {
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        m.f(newConfig, "newConfig");
        Log.d("monitor_activity", "---onConfigurationChanged()--width = " + l());
        super.onConfigurationChanged(newConfig);
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        m.f(outState, "outState");
        Log.d("monitor_activity", "---onSaveInstanceState()--orientation = " + k() + "width = " + l());
        super.onSaveInstanceState(outState);
    }

    private final String k() {
        int i10 = getResources().getConfiguration().orientation;
        if (i10 != 1) {
            if (i10 != 2) {
                return "-------";
            }
            return "ORIENTATION_LANDSCAPE--";
        }
        return "ORIENTATION_PORTRAIT--";
    }

    private final int l() {
        return getWindowManager().getDefaultDisplay().getWidth();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("monitor_activity", "---onCreate()--orientation = " + k() + "width = " + l());
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Log.d("monitor_activity", "---onDestroy()--orientation = " + k() + "width = " + l());
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Log.d("monitor_activity", "---onPause()--orientation = " + k() + "width = " + l());
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        Log.d("monitor_activity", "---onRestart()--orientation = " + k() + "width = " + l());
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        Log.d("monitor_activity", "---onResume()--orientation = " + k() + "width = " + l());
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        Log.d("monitor_activity", "---onStart()--orientation = " + k() + "width = " + l());
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        Log.d("monitor_activity", "---onStop()--orientation = " + k() + "width = " + l());
        super.onStop();
    }
}
