package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile t f1437d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f1438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    final Set<com.bumptech.glide.manager.c.a> f1439b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f1440c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements e0.f.b<ConnectivityManager> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f1441a;

        a(Context context) {
            this.f1441a = context;
        }

        @Override // e0.f.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectivityManager get() {
            return (ConnectivityManager) this.f1441a.getSystemService("connectivity");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements com.bumptech.glide.manager.c.a {
        b() {
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean z10) {
            ArrayList arrayList;
            e0.l.b();
            synchronized (t.this) {
                arrayList = new ArrayList(t.this.f1439b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.bumptech.glide.manager.c.a) it.next()).a(z10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private interface c {
        boolean register();

        void unregister();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @RequiresApi(24)
    private static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.manager.c.a f1445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e0.f.b<ConnectivityManager> f1446c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ConnectivityManager.NetworkCallback f1447d = new a();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: renamed from: com.bumptech.glide.manager.t$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            class RunnableC0038a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ boolean f1449a;

                RunnableC0038a(boolean z10) {
                    this.f1449a = z10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(this.f1449a);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(@NonNull Network network) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(@NonNull Network network) {
                b(false);
            }

            a() {
            }

            private void b(boolean z10) {
                e0.l.v(new RunnableC0038a(z10));
            }

            void a(boolean z10) {
                e0.l.b();
                d dVar = d.this;
                boolean z11 = dVar.f1444a;
                dVar.f1444a = z10;
                if (z11 != z10) {
                    dVar.f1445b.a(z10);
                }
            }
        }

        @Override // com.bumptech.glide.manager.t.c
        @SuppressLint({"MissingPermission"})
        public boolean register() {
            this.f1444a = this.f1446c.get().getActiveNetwork() != null;
            try {
                this.f1446c.get().registerDefaultNetworkCallback(this.f1447d);
                return true;
            } catch (RuntimeException e10) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e10);
                }
                return false;
            }
        }

        @Override // com.bumptech.glide.manager.t.c
        public void unregister() {
            this.f1446c.get().unregisterNetworkCallback(this.f1447d);
        }

        d(e0.f.b<ConnectivityManager> bVar, com.bumptech.glide.manager.c.a aVar) {
            this.f1446c = bVar;
            this.f1445b = aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class e implements c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final Executor f1451g = AsyncTask.SERIAL_EXECUTOR;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f1452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.manager.c.a f1453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e0.f.b<ConnectivityManager> f1454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f1455d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f1456e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final BroadcastReceiver f1457f = new a();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@NonNull Context context, Intent intent) {
                e.this.c();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f1455d = eVar.a();
                try {
                    e eVar2 = e.this;
                    eVar2.f1452a.registerReceiver(eVar2.f1457f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    e.this.f1456e = true;
                } catch (SecurityException e10) {
                    if (Log.isLoggable("ConnectivityMonitor", 5)) {
                        Log.w("ConnectivityMonitor", "Failed to register", e10);
                    }
                    e.this.f1456e = false;
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f1456e) {
                    e.this.f1456e = false;
                    e eVar = e.this;
                    eVar.f1452a.unregisterReceiver(eVar.f1457f);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10 = e.this.f1455d;
                e eVar = e.this;
                eVar.f1455d = eVar.a();
                if (z10 != e.this.f1455d) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f1455d);
                    }
                    e eVar2 = e.this;
                    eVar2.b(eVar2.f1455d);
                }
            }
        }

        /* JADX INFO: renamed from: com.bumptech.glide.manager.t$e$e, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class RunnableC0039e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f1462a;

            RunnableC0039e(boolean z10) {
                this.f1462a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f1453b.a(this.f1462a);
            }
        }

        @SuppressLint({"MissingPermission"})
        boolean a() {
            try {
                NetworkInfo activeNetworkInfo = this.f1454c.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e10) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e10);
                }
                return true;
            }
        }

        void b(boolean z10) {
            e0.l.v(new RunnableC0039e(z10));
        }

        void c() {
            f1451g.execute(new d());
        }

        @Override // com.bumptech.glide.manager.t.c
        public boolean register() {
            f1451g.execute(new b());
            return true;
        }

        @Override // com.bumptech.glide.manager.t.c
        public void unregister() {
            f1451g.execute(new c());
        }

        e(Context context, e0.f.b<ConnectivityManager> bVar, com.bumptech.glide.manager.c.a aVar) {
            this.f1452a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f1454c = bVar;
            this.f1453b = aVar;
        }
    }

    synchronized void d(com.bumptech.glide.manager.c.a aVar) {
        this.f1439b.add(aVar);
        b();
    }

    synchronized void e(com.bumptech.glide.manager.c.a aVar) {
        this.f1439b.remove(aVar);
        c();
    }

    static t a(@NonNull Context context) {
        if (f1437d == null) {
            synchronized (t.class) {
                try {
                    if (f1437d == null) {
                        f1437d = new t(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1437d;
    }

    @GuardedBy("this")
    private void b() {
        if (this.f1440c || this.f1439b.isEmpty()) {
            return;
        }
        this.f1440c = this.f1438a.register();
    }

    @GuardedBy("this")
    private void c() {
        if (this.f1440c && this.f1439b.isEmpty()) {
            this.f1438a.unregister();
            this.f1440c = false;
        }
    }

    private t(@NonNull Context context) {
        c eVar;
        e0.f.b bVarA = e0.f.a(new a(context));
        b bVar = new b();
        if (Build.VERSION.SDK_INT >= 24) {
            eVar = new d(bVarA, bVar);
        } else {
            eVar = new e(context, bVarA, bVar);
        }
        this.f1438a = eVar;
    }
}
