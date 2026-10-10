package j2;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.util.p;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import com.stub.StubApp;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import m2.o;
import m2.x;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f11547k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy("LOCK")
    static final Map<String, e> f11548l = new ArrayMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f11551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final o f11552d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final x<x2.a> f11555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final r2.b<q2.f> f11556h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f11553e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f11554f = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<a> f11557i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<Object> f11558j = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a(boolean z10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @TargetApi(24)
    private static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static AtomicReference<c> f11560b = new AtomicReference<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f11561a;

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (f11560b.get() == null) {
                c cVar = new c(context);
                if (androidx.p000lifecycle.h.a(f11560b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f11561a.unregisterReceiver(this);
        }

        public c(Context context) {
            this.f11561a = context;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (e.f11547k) {
                try {
                    Iterator<e> it = e.f11548l.values().iterator();
                    while (it.hasNext()) {
                        it.next().o();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @TargetApi(14)
    private static class b implements k1.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static AtomicReference<b> f11559a = new AtomicReference<>();

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            if (com.google.android.gms.common.util.m.a() && (StubApp.getOrigApplicationContext(context.getApplicationContext()) instanceof Application)) {
                Application application = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (f11559a.get() == null) {
                    b bVar = new b();
                    if (androidx.p000lifecycle.h.a(f11559a, null, bVar)) {
                        k1.c.c(application);
                        k1.c.b().a(bVar);
                    }
                }
            }
        }

        @Override // k1.c.a
        public void a(boolean z10) {
            synchronized (e.f11547k) {
                try {
                    for (e eVar : new ArrayList(e.f11548l.values())) {
                        if (eVar.f11553e.get()) {
                            eVar.v(z10);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static /* synthetic */ void a(e eVar, boolean z10) {
        if (z10) {
            eVar.getClass();
        } else {
            eVar.f11556h.get().g();
        }
    }

    public static /* synthetic */ x2.a b(e eVar, Context context) {
        return new x2.a(context, eVar.n(), (p2.c) eVar.f11552d.a(p2.c.class));
    }

    private void h() {
        m1.g.p(!this.f11554f.get(), "FirebaseApp was deleted");
    }

    @NonNull
    public static e k() {
        e eVar;
        synchronized (f11547k) {
            try {
                eVar = f11548l.get("[DEFAULT]");
                if (eVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + p.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                eVar.f11556h.get().g();
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!UserManagerCompat.isUserUnlocked(this.f11549a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + l());
            c.b(this.f11549a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + l());
        this.f11552d.n(t());
        this.f11556h.get().g();
    }

    @Nullable
    public static e p(@NonNull Context context) {
        synchronized (f11547k) {
            try {
                if (f11548l.containsKey("[DEFAULT]")) {
                    return k();
                }
                l lVarA = l.a(context);
                if (lVarA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return q(context, lVarA);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public static e q(@NonNull Context context, @NonNull l lVar) {
        return r(context, lVar, "[DEFAULT]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z10) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator<a> it = this.f11557i.iterator();
        while (it.hasNext()) {
            it.next().a(z10);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f11550b.equals(((e) obj).l());
        }
        return false;
    }

    public int hashCode() {
        return this.f11550b.hashCode();
    }

    public String n() {
        return com.google.android.gms.common.util.c.c(l().getBytes(Charset.defaultCharset())) + "+" + com.google.android.gms.common.util.c.c(m().c().getBytes(Charset.defaultCharset()));
    }

    @VisibleForTesting
    public boolean t() {
        return "[DEFAULT]".equals(l());
    }

    protected e(final Context context, String str, l lVar) {
        this.f11549a = (Context) m1.g.k(context);
        this.f11550b = m1.g.e(str);
        this.f11551c = (l) m1.g.k(lVar);
        m mVarB = FirebaseInitProvider.b();
        z2.c.b("Firebase");
        z2.c.b("ComponentDiscovery");
        List<r2.b<ComponentRegistrar>> listB = m2.g.c(context, ComponentDiscoveryService.class).b();
        z2.c.a();
        z2.c.b("Runtime");
        o.b bVarF = o.k(n2.m.INSTANCE).d(listB).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(m2.c.q(context, Context.class, new Class[0])).b(m2.c.q(this, e.class, new Class[0])).b(m2.c.q(lVar, l.class, new Class[0])).f(new z2.b());
        if (UserManagerCompat.isUserUnlocked(context) && FirebaseInitProvider.c()) {
            bVarF.b(m2.c.q(mVarB, m.class, new Class[0]));
        }
        o oVarE = bVarF.e();
        this.f11552d = oVarE;
        z2.c.a();
        this.f11555g = new x<>(new r2.b() { // from class: j2.c
            @Override // r2.b
            public final Object get() {
                return e.b(this.f11544a, context);
            }
        });
        this.f11556h = oVarE.c(q2.f.class);
        g(new a() { // from class: j2.d
            @Override // j2.e.a
            public final void a(boolean z10) {
                e.a(this.f11546a, z10);
            }
        });
        z2.c.a();
    }

    @NonNull
    public static e r(@NonNull Context context, @NonNull l lVar, @NonNull String str) {
        e eVar;
        b.c(context);
        String strU = u(str);
        if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        synchronized (f11547k) {
            Map<String, e> map = f11548l;
            m1.g.p(!map.containsKey(strU), "FirebaseApp name " + strU + " already exists!");
            m1.g.l(context, "Application context cannot be null.");
            eVar = new e(context, strU, lVar);
            map.put(strU, eVar);
        }
        eVar.o();
        return eVar;
    }

    private static String u(@NonNull String str) {
        return str.trim();
    }

    public void g(a aVar) {
        h();
        if (this.f11553e.get() && k1.c.b().d()) {
            aVar.a(true);
        }
        this.f11557i.add(aVar);
    }

    public <T> T i(Class<T> cls) {
        h();
        return (T) this.f11552d.a(cls);
    }

    @NonNull
    public Context j() {
        h();
        return this.f11549a;
    }

    @NonNull
    public String l() {
        h();
        return this.f11550b;
    }

    @NonNull
    public l m() {
        h();
        return this.f11551c;
    }

    public boolean s() {
        h();
        return this.f11555g.get().b();
    }

    public String toString() {
        return m1.f.c(this).a("name", this.f11550b).a("options", this.f11551c).toString();
    }
}
