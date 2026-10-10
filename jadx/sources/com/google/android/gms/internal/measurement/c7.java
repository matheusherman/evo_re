package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c7 implements j7 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @GuardedBy("ConfigurationContentLoader.class")
    private static final Map<Uri, c7> f2583h = new ArrayMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f2584i = {"key", "value"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContentResolver f2585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f2586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f2587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ContentObserver f2588d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Map<String, String> f2590f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f2589e = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    private final List<h7> f2591g = new ArrayList();

    public static c7 a(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        c7 c7Var;
        synchronized (c7.class) {
            Map<Uri, c7> map = f2583h;
            c7Var = map.get(uri);
            if (c7Var == null) {
                try {
                    c7 c7Var2 = new c7(contentResolver, uri, runnable);
                    try {
                        contentResolver.registerContentObserver(uri, false, c7Var2.f2588d);
                        map.put(uri, c7Var2);
                    } catch (SecurityException unused) {
                    }
                    c7Var = c7Var2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return c7Var;
    }

    static synchronized void d() {
        try {
            for (c7 c7Var : f2583h.values()) {
                c7Var.f2585a.unregisterContentObserver(c7Var.f2588d);
            }
            f2583h.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Map f() {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = this.f2585a.acquireUnstableContentProviderClient(this.f2586b);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.EMPTY_MAP;
            }
            try {
                Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(this.f2586b, f2584i, null, null, null);
                try {
                    if (cursorQuery == null) {
                        Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                        Map map = Collections.EMPTY_MAP;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        return map;
                    }
                    int count = cursorQuery.getCount();
                    if (count == 0) {
                        Map map2 = Collections.EMPTY_MAP;
                        cursorQuery.close();
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        return map2;
                    }
                    Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
                    while (cursorQuery.moveToNext()) {
                        arrayMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
                    }
                    if (cursorQuery.isAfterLast()) {
                        cursorQuery.close();
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        return arrayMap;
                    }
                    Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                    Map map3 = Collections.EMPTY_MAP;
                    cursorQuery.close();
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return map3;
                } catch (Throwable th) {
                    if (cursorQuery == null) {
                        throw th;
                    }
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } catch (RemoteException e10) {
                Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e10);
                Map map4 = Collections.EMPTY_MAP;
                contentProviderClientAcquireUnstableContentProviderClient.release();
                return map4;
            }
        } catch (Throwable th3) {
            contentProviderClientAcquireUnstableContentProviderClient.release();
            throw th3;
        }
    }

    public final Map<String, String> b() {
        Map<String, String> mapG = this.f2590f;
        if (mapG == null) {
            synchronized (this.f2589e) {
                try {
                    mapG = this.f2590f;
                    if (mapG == null) {
                        mapG = g();
                        this.f2590f = mapG;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mapG != null ? mapG : Collections.EMPTY_MAP;
    }

    public final void e() {
        synchronized (this.f2589e) {
            this.f2590f = null;
            this.f2587c.run();
        }
        synchronized (this) {
            try {
                Iterator<h7> it = this.f2591g.iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private c7(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        com.google.common.base.m.i(contentResolver);
        com.google.common.base.m.i(uri);
        this.f2585a = contentResolver;
        this.f2586b = uri;
        this.f2587c = runnable;
        this.f2588d = new e7(this, null);
    }

    private final Map<String, String> g() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) i7.a(new l7() { // from class: com.google.android.gms.internal.measurement.f7
                    @Override // com.google.android.gms.internal.measurement.l7
                    public final Object b() {
                        return this.f2689a.f();
                    }
                });
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (SQLiteException | IllegalStateException | SecurityException e10) {
            Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e10);
            Map<String, String> map = Collections.EMPTY_MAP;
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return map;
        }
    }

    @Override // com.google.android.gms.internal.measurement.j7
    public final /* synthetic */ Object i(String str) {
        return b().get(str);
    }
}
