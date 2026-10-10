package m1;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Uri f15492f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f15493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f15494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final ComponentName f15495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f15497e;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return f.a(this.f15493a, j0Var.f15493a) && f.a(this.f15494b, j0Var.f15494b) && f.a(this.f15495c, j0Var.f15495c) && this.f15497e == j0Var.f15497e;
    }

    @Nullable
    public final ComponentName a() {
        return this.f15495c;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:36:0x0092  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b1 A[RETURN] */
    public final Intent b(Context context) throws f0 {
        Bundle bundleCall;
        PendingIntent pendingIntent;
        if (this.f15493a == null) {
            return new Intent().setComponent(this.f15495c);
        }
        Intent intent = null;
        if (this.f15497e) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.f15493a);
            try {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f15492f);
                if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                    throw new RemoteException("Failed to acquire ContentProviderClient");
                }
                try {
                    bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("serviceIntentCall", null, bundle);
                    try {
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                    } catch (RemoteException e10) {
                        e = e10;
                        Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                    } catch (IllegalArgumentException e11) {
                        e = e11;
                        Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                    }
                    if (bundleCall == null && (intent = (Intent) bundleCall.getParcelable("serviceResponseIntentKey")) == null && (pendingIntent = (PendingIntent) bundleCall.getParcelable("serviceMissingResolutionIntentKey")) != null) {
                        Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action " + this.f15493a + " but has possible resolution");
                        throw new f0(new ConnectionResult(25, pendingIntent));
                    }
                    if (intent == null) {
                        Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f15493a)));
                    }
                } catch (Throwable th) {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    throw th;
                }
            } catch (RemoteException e12) {
                e = e12;
                bundleCall = null;
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                if (bundleCall == null) {
                }
                if (intent == null) {
                    Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f15493a)));
                }
                if (intent == null) {
                    return new Intent(this.f15493a).setPackage(this.f15494b);
                }
                return intent;
            } catch (IllegalArgumentException e13) {
                e = e13;
                bundleCall = null;
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                if (bundleCall == null) {
                }
                if (intent == null) {
                    Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f15493a)));
                }
                if (intent == null) {
                    return new Intent(this.f15493a).setPackage(this.f15494b);
                }
                return intent;
            }
        }
        if (intent == null) {
            return new Intent(this.f15493a).setPackage(this.f15494b);
        }
        return intent;
    }

    @Nullable
    public final String c() {
        return this.f15494b;
    }

    public final int hashCode() {
        return f.b(this.f15493a, this.f15494b, this.f15495c, 4225, Boolean.valueOf(this.f15497e));
    }

    public final String toString() {
        String str = this.f15493a;
        if (str != null) {
            return str;
        }
        g.k(this.f15495c);
        return this.f15495c.flattenToString();
    }

    public j0(String str, String str2, int i10, boolean z10) {
        g.e(str);
        this.f15493a = str;
        g.e(str2);
        this.f15494b = str2;
        this.f15495c = null;
        this.f15496d = 4225;
        this.f15497e = z10;
    }
}
