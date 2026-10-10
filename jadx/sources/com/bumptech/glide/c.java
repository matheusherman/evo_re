package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.manager.q;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class c implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("Glide.class")
    private static volatile c f1273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile boolean f1274l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l.k f1275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m.d f1276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n.h f1277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f1278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final m.b f1279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final q f1280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.manager.d f1281g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a f1283i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @GuardedBy("managers")
    private final List<l> f1282h = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g f1284j = g.NORMAL;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        @NonNull
        a0.i build();
    }

    @GuardedBy("Glide.class")
    @VisibleForTesting
    static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (f1274l) {
            throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
        }
        f1274l = true;
        try {
            m(context, generatedAppGlideModule);
        } finally {
            f1274l = false;
        }
    }

    @NonNull
    public static c c(@NonNull Context context) {
        if (f1273k == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            synchronized (c.class) {
                try {
                    if (f1273k == null) {
                        a(context, generatedAppGlideModuleD);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1273k;
    }

    @Nullable
    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable("Glide", 5)) {
                return null;
            }
            Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (IllegalAccessException e10) {
            q(e10);
            return null;
        } catch (InstantiationException e11) {
            q(e11);
            return null;
        } catch (NoSuchMethodException e12) {
            q(e12);
            return null;
        } catch (InvocationTargetException e13) {
            q(e13);
            return null;
        }
    }

    @NonNull
    private static q l(@Nullable Context context) {
        e0.k.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    @GuardedBy("Glide.class")
    private static void m(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new d(), generatedAppGlideModule);
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public m.b e() {
        return this.f1279e;
    }

    @NonNull
    public m.d f() {
        return this.f1276b;
    }

    com.bumptech.glide.manager.d g() {
        return this.f1281g;
    }

    @NonNull
    public Context h() {
        return this.f1278d.getBaseContext();
    }

    @NonNull
    e i() {
        return this.f1278d;
    }

    @NonNull
    public i j() {
        return this.f1278d.i();
    }

    @NonNull
    public q k() {
        return this.f1280f;
    }

    void o(l lVar) {
        synchronized (this.f1282h) {
            try {
                if (this.f1282h.contains(lVar)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.f1282h.add(lVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean p(@NonNull b0.i<?> iVar) {
        synchronized (this.f1282h) {
            try {
                Iterator<l> it = this.f1282h.iterator();
                while (it.hasNext()) {
                    if (it.next().B(iVar)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void s(l lVar) {
        synchronized (this.f1282h) {
            try {
                if (!this.f1282h.contains(lVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f1282h.remove(lVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    c(@NonNull Context context, @NonNull l.k kVar, @NonNull n.h hVar, @NonNull m.d dVar, @NonNull m.b bVar, @NonNull q qVar, @NonNull com.bumptech.glide.manager.d dVar2, int i10, @NonNull a aVar, @NonNull Map<Class<?>, m<?, ?>> map, @NonNull List<a0.h<Object>> list, @NonNull List<GlideModule> list2, @Nullable AppGlideModule appGlideModule, @NonNull f fVar) {
        this.f1275a = kVar;
        this.f1276b = dVar;
        this.f1279e = bVar;
        this.f1277c = hVar;
        this.f1280f = qVar;
        this.f1281g = dVar2;
        this.f1283i = aVar;
        this.f1278d = new e(context, bVar, j.d(this, list2, appGlideModule), new b0.f(), aVar, map, list, kVar, fVar, i10);
    }

    @GuardedBy("Glide.class")
    private static void n(@NonNull Context context, @NonNull d dVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        q.b bVarE;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        List<GlideModule> listB = Collections.EMPTY_LIST;
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listB = new y.a(origApplicationContext).b();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> setD = generatedAppGlideModule.d();
            Iterator<GlideModule> it = listB.iterator();
            while (it.hasNext()) {
                GlideModule next = it.next();
                if (setD.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<GlideModule> it2 = listB.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        if (generatedAppGlideModule != null) {
            bVarE = generatedAppGlideModule.e();
        } else {
            bVarE = null;
        }
        dVar.b(bVarE);
        Iterator<GlideModule> it3 = listB.iterator();
        while (it3.hasNext()) {
            it3.next().a(origApplicationContext, dVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(origApplicationContext, dVar);
        }
        c cVarA = dVar.a(origApplicationContext, listB, generatedAppGlideModule);
        origApplicationContext.registerComponentCallbacks(cVarA);
        f1273k = cVarA;
    }

    @NonNull
    public static l t(@NonNull Context context) {
        return l(context).f(context);
    }

    @NonNull
    public static l u(@NonNull FragmentActivity fragmentActivity) {
        return l(fragmentActivity).g(fragmentActivity);
    }

    public void b() {
        e0.l.b();
        this.f1277c.b();
        this.f1276b.b();
        this.f1279e.b();
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        r(i10);
    }

    public void r(int i10) {
        e0.l.b();
        synchronized (this.f1282h) {
            try {
                Iterator<l> it = this.f1282h.iterator();
                while (it.hasNext()) {
                    it.next().onTrimMemory(i10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f1277c.a(i10);
        this.f1276b.a(i10);
        this.f1279e.a(i10);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
