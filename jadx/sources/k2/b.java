package k2;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.measurement.f3;
import com.stub.StubApp;
import j2.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import m1.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f12112c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private final a2.a f12113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    final Map<String, Object> f12114b;

    private b(a2.a aVar) {
        g.k(aVar);
        this.f12113a = aVar;
        this.f12114b = new ConcurrentHashMap();
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    public static a a(@NonNull e eVar, @NonNull Context context, @NonNull p2.d dVar) {
        g.k(eVar);
        g.k(context);
        g.k(dVar);
        g.k(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        if (f12112c == null) {
            synchronized (b.class) {
                try {
                    if (f12112c == null) {
                        Bundle bundle = new Bundle(1);
                        if (eVar.t()) {
                            dVar.a(j2.b.class, new Executor() { // from class: k2.c
                                @Override // java.util.concurrent.Executor
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new p2.b() { // from class: k2.d
                                @Override // p2.b
                                public final void a(p2.a aVar) {
                                    b.b(aVar);
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", eVar.s());
                        }
                        f12112c = new b(f3.f(context, null, null, null, bundle).x());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12112c;
    }

    static /* synthetic */ void b(p2.a aVar) {
        boolean z10 = ((j2.b) aVar.a()).f11543a;
        synchronized (b.class) {
            ((b) g.k(f12112c)).f12113a.a(z10);
        }
    }
}
