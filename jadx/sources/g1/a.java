package g1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.stub.StubApp;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import m1.g;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import w1.e;
import w1.f;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    j1.a f10417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    f f10418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f10419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object f10420d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    c f10421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f10422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f10423g;

    /* JADX INFO: renamed from: g1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0182a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final String f10424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f10425b;

        @Nullable
        public String a() {
            return this.f10424a;
        }

        public boolean b() {
            return this.f10425b;
        }

        @NonNull
        public String toString() {
            String str = this.f10424a;
            boolean z10 = this.f10425b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 7);
            sb2.append("{");
            sb2.append(str);
            sb2.append("}");
            sb2.append(z10);
            return sb2.toString();
        }

        @Deprecated
        public C0182a(@Nullable String str, boolean z10) {
            this.f10424a = str;
            this.f10425b = z10;
        }
    }

    @NonNull
    public static C0182a a(@NonNull Context context) {
        a aVar = new a(context, -1L, true, false);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            aVar.d(false);
            C0182a c0182aF = aVar.f(-1);
            aVar.e(c0182aF, true, 0.0f, SystemClock.elapsedRealtime() - jElapsedRealtime, "", null);
            aVar.c();
            return c0182aF;
        } catch (Throwable th) {
            try {
                aVar.e(null, true, 0.0f, -1L, "", th);
                throw th;
            } catch (Throwable th2) {
                aVar.c();
                throw th2;
            }
        }
    }

    private final C0182a f(int i10) {
        C0182a c0182a;
        g.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f10419c) {
                    synchronized (this.f10420d) {
                        c cVar = this.f10421e;
                        if (cVar == null || !cVar.f10430d) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        d(false);
                        if (!this.f10419c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e10) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e10);
                    }
                }
                g.k(this.f10417a);
                g.k(this.f10418b);
                try {
                    c0182a = new C0182a(this.f10418b.d(), this.f10418b.s(true));
                } catch (RemoteException e11) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e11);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        g();
        return c0182a;
    }

    private final void g() {
        synchronized (this.f10420d) {
            c cVar = this.f10421e;
            if (cVar != null) {
                cVar.f10429c.countDown();
                try {
                    this.f10421e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j10 = this.f10423g;
            if (j10 > 0) {
                this.f10421e = new c(this, j10);
            }
        }
    }

    public final void c() {
        g.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f10422f == null || this.f10417a == null) {
                    return;
                }
                try {
                    if (this.f10419c) {
                        s1.b.b().c(this.f10422f, this.f10417a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f10419c = false;
                this.f10418b = null;
                this.f10417a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @VisibleForTesting
    protected final void d(boolean z10) {
        g.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f10419c) {
                    c();
                }
                Context context = this.f10422f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iH = com.google.android.gms.common.b.f().h(context, 12451000);
                    if (iH != 0 && iH != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    j1.a aVar = new j1.a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!s1.b.b().a(context, intent, aVar, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f10417a = aVar;
                        try {
                            this.f10418b = e.a(aVar.a(10000L, TimeUnit.MILLISECONDS));
                            this.f10419c = true;
                            if (z10) {
                                g();
                            }
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } catch (Throwable th2) {
                        throw new IOException(th2);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new j1.f(9);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @VisibleForTesting
    public a(@NonNull Context context, long j10, boolean z10, boolean z11) {
        Context origApplicationContext;
        g.k(context);
        if (z10 && (origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())) != null) {
            context = origApplicationContext;
        }
        this.f10422f = context;
        this.f10419c = false;
        this.f10423g = j10;
    }

    @VisibleForTesting
    final boolean e(@Nullable C0182a c0182a, boolean z10, float f10, long j10, String str, @Nullable Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap map = new HashMap();
            String str2 = "1";
            map.put("app_context", "1");
            if (c0182a != null) {
                if (true != c0182a.b()) {
                    str2 = "0";
                }
                map.put("limit_ad_tracking", str2);
                String strA = c0182a.a();
                if (strA != null) {
                    map.put("ad_id_size", Integer.toString(strA.length()));
                }
            }
            if (th != null) {
                map.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, th.getClass().getName());
            }
            map.put("tag", "AdvertisingIdClient");
            map.put("time_spent", Long.toString(j10));
            new b(this, map).start();
            return true;
        }
        return false;
    }

    protected final void finalize() throws Throwable {
        c();
        super.finalize();
    }

    public static void b(boolean z10) {
    }
}
