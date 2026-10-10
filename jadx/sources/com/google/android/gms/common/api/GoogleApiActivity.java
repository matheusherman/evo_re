package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    protected int f2148a = 0;

    static {
        StubApp.interface11(8684);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        this.f2148a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @NonNull
    public static Intent a(@NonNull Context context, @NonNull PendingIntent pendingIntent, int i10, boolean z10) {
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i10);
        intent.putExtra("notify_manager", z10);
        return intent;
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt("resolution", this.f2148a);
        super.onSaveInstanceState(bundle);
    }

    private final void b() {
        GoogleApiActivity googleApiActivity;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
            return;
        }
        if (pendingIntent != null) {
            try {
                googleApiActivity = this;
                try {
                    googleApiActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    googleApiActivity.f2148a = 1;
                } catch (ActivityNotFoundException e10) {
                    e = e10;
                    if (extras.getBoolean("notify_manager", true)) {
                        k1.e.t(this).B(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
                    } else {
                        String strConcat = "Activity not found while launching " + pendingIntent.toString() + ".";
                        if (Build.FINGERPRINT.contains("generic")) {
                            strConcat = strConcat.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                        }
                        Log.e("GoogleApiActivity", strConcat, e);
                    }
                    googleApiActivity.f2148a = 1;
                    finish();
                } catch (IntentSender.SendIntentException e11) {
                    e = e11;
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e);
                    finish();
                }
            } catch (ActivityNotFoundException e12) {
                e = e12;
                googleApiActivity = this;
            } catch (IntentSender.SendIntentException e13) {
                e = e13;
            }
        } else {
            com.google.android.gms.common.a.m().n(this, ((Integer) m1.g.k(num)).intValue(), 2, this);
            this.f2148a = 1;
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i10, int i11, @NonNull Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f2148a = 0;
            setResult(i11, intent);
            if (booleanExtra) {
                k1.e eVarT = k1.e.t(this);
                if (i11 != -1) {
                    if (i11 == 0) {
                        eVarT.B(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                    }
                } else {
                    eVarT.C();
                }
            }
        } else if (i10 == 2) {
            this.f2148a = 0;
            setResult(i11, intent);
        }
        finish();
    }
}
