package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;
import s.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class q implements Handler.Callback {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final b f1423k = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.bumptech.glide.l f1424a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f1427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f1428e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final k f1432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final n f1433j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    final Map<FragmentManager, p> f1425b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, w> f1426c = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayMap<View, Fragment> f1429f = new ArrayMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f1430g = new ArrayMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Bundle f1431h = new Bundle();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements b {
        @Override // com.bumptech.glide.manager.q.b
        @NonNull
        public com.bumptech.glide.l a(@NonNull com.bumptech.glide.c cVar, @NonNull l lVar, @NonNull r rVar, @NonNull Context context) {
            return new com.bumptech.glide.l(cVar, lVar, rVar, context);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
        @NonNull
        com.bumptech.glide.l a(@NonNull com.bumptech.glide.c cVar, @NonNull l lVar, @NonNull r rVar, @NonNull Context context);
    }

    @NonNull
    w k(androidx.fragment.app.FragmentManager fragmentManager) {
        return l(fragmentManager, null);
    }

    private static k b(com.bumptech.glide.f fVar) {
        if (y.f18215h && y.f18214g) {
            return fVar.a(com.bumptech.glide.d.C0035d.class) ? new i() : new j();
        }
        return new g();
    }

    @Nullable
    private static Activity c(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @NonNull
    private com.bumptech.glide.l h(@NonNull Context context) {
        if (this.f1424a == null) {
            synchronized (this) {
                try {
                    if (this.f1424a == null) {
                        this.f1424a = this.f1428e.a(com.bumptech.glide.c.c(StubApp.getOrigApplicationContext(context.getApplicationContext())), new com.bumptech.glide.manager.b(), new h(), StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f1424a;
    }

    @NonNull
    private p j(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment) {
        p pVar = this.f1425b.get(fragmentManager);
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = (p) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (pVar2 != null) {
            return pVar2;
        }
        p pVar3 = new p();
        pVar3.j(fragment);
        this.f1425b.put(fragmentManager, pVar3);
        fragmentManager.beginTransaction().add(pVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f1427d.obtainMessage(1, fragmentManager).sendToTarget();
        return pVar3;
    }

    @NonNull
    private w l(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment) {
        w wVar = this.f1426c.get(fragmentManager);
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = (w) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (wVar2 != null) {
            return wVar2;
        }
        w wVar3 = new w();
        wVar3.a0(fragment);
        this.f1426c.put(fragmentManager, wVar3);
        fragmentManager.beginTransaction().add(wVar3, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f1427d.obtainMessage(2, fragmentManager).sendToTarget();
        return wVar3;
    }

    private boolean n(FragmentManager fragmentManager, boolean z10) {
        p pVar = this.f1425b.get(fragmentManager);
        p pVar2 = (p) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (pVar2 == pVar) {
            return true;
        }
        if (pVar2 != null && pVar2.e() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + pVar2 + " New: " + pVar);
        }
        if (z10 || fragmentManager.isDestroyed()) {
            if (Log.isLoggable("RMRetriever", 5)) {
                if (fragmentManager.isDestroyed()) {
                    Log.w("RMRetriever", "Parent was destroyed before our Fragment could be added");
                } else {
                    Log.w("RMRetriever", "Tried adding Fragment twice and failed twice, giving up!");
                }
            }
            pVar.c().c();
            return true;
        }
        FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(pVar, "com.bumptech.glide.manager");
        if (pVar2 != null) {
            fragmentTransactionAdd.remove(pVar2);
        }
        fragmentTransactionAdd.commitAllowingStateLoss();
        this.f1427d.obtainMessage(1, 1, 0, fragmentManager).sendToTarget();
        if (Log.isLoggable("RMRetriever", 3)) {
            Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
        }
        return false;
    }

    private boolean o(androidx.fragment.app.FragmentManager fragmentManager, boolean z10) {
        w wVar = this.f1426c.get(fragmentManager);
        w wVar2 = (w) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (wVar2 == wVar) {
            return true;
        }
        if (wVar2 != null && wVar2.V() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + wVar2 + " New: " + wVar);
        }
        if (z10 || fragmentManager.isDestroyed()) {
            if (fragmentManager.isDestroyed()) {
                if (Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
                }
            } else if (Log.isLoggable("RMRetriever", 6)) {
                Log.e("RMRetriever", "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
            }
            wVar.T().c();
            return true;
        }
        androidx.fragment.app.FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(wVar, "com.bumptech.glide.manager");
        if (wVar2 != null) {
            fragmentTransactionAdd.remove(wVar2);
        }
        fragmentTransactionAdd.commitNowAllowingStateLoss();
        this.f1427d.obtainMessage(2, 1, 0, fragmentManager).sendToTarget();
        if (Log.isLoggable("RMRetriever", 3)) {
            Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
        }
        return false;
    }

    @NonNull
    public com.bumptech.glide.l f(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (e0.l.s() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return g((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return e((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (StubApp.getOrigApplicationContext(contextWrapper.getBaseContext().getApplicationContext()) != null) {
                    return f(contextWrapper.getBaseContext());
                }
            }
        }
        return h(context);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0037  */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        androidx.fragment.app.FragmentManager fragmentManager;
        androidx.fragment.app.FragmentManager fragmentManager2;
        boolean z10 = true;
        boolean z11 = false;
        boolean z12 = message.arg1 == 1;
        int i10 = message.what;
        Object objRemove = null;
        if (i10 == 1) {
            FragmentManager fragmentManager3 = (FragmentManager) message.obj;
            if (n(fragmentManager3, z12)) {
                objRemove = this.f1425b.remove(fragmentManager3);
                fragmentManager = fragmentManager3;
            } else {
                fragmentManager = null;
                z10 = false;
            }
            z11 = true;
            fragmentManager2 = fragmentManager;
        } else if (i10 != 2) {
            fragmentManager2 = null;
            z10 = false;
        } else {
            androidx.fragment.app.FragmentManager fragmentManager4 = (androidx.fragment.app.FragmentManager) message.obj;
            if (o(fragmentManager4, z12)) {
                objRemove = this.f1426c.remove(fragmentManager4);
                fragmentManager = fragmentManager4;
            } else {
                fragmentManager = null;
                z10 = false;
            }
            z11 = true;
            fragmentManager2 = fragmentManager;
        }
        if (Log.isLoggable("RMRetriever", 5) && z10 && objRemove == null) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + fragmentManager2);
        }
        return z11;
    }

    public q(@Nullable b bVar, com.bumptech.glide.f fVar) {
        bVar = bVar == null ? f1423k : bVar;
        this.f1428e = bVar;
        this.f1427d = new Handler(Looper.getMainLooper(), this);
        this.f1433j = new n(bVar);
        this.f1432i = b(fVar);
    }

    @TargetApi(17)
    private static void a(@NonNull Activity activity) {
        if (!activity.isDestroyed()) {
        } else {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @NonNull
    @Deprecated
    private com.bumptech.glide.l d(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z10) {
        p pVarJ = j(fragmentManager, fragment);
        com.bumptech.glide.l lVarE = pVarJ.e();
        if (lVarE == null) {
            com.bumptech.glide.l lVarA = this.f1428e.a(com.bumptech.glide.c.c(context), pVarJ.c(), pVarJ.f(), context);
            if (z10) {
                lVarA.onStart();
            }
            pVarJ.k(lVarA);
            return lVarA;
        }
        return lVarE;
    }

    private static boolean m(Context context) {
        Activity activityC = c(context);
        if (activityC != null && activityC.isFinishing()) {
            return false;
        }
        return true;
    }

    @NonNull
    @Deprecated
    public com.bumptech.glide.l e(@NonNull Activity activity) {
        if (e0.l.r()) {
            return f(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        }
        if (activity instanceof FragmentActivity) {
            return g((FragmentActivity) activity);
        }
        a(activity);
        this.f1432i.a(activity);
        return d(activity, activity.getFragmentManager(), null, m(activity));
    }

    @NonNull
    public com.bumptech.glide.l g(@NonNull FragmentActivity fragmentActivity) {
        if (e0.l.r()) {
            return f(StubApp.getOrigApplicationContext(fragmentActivity.getApplicationContext()));
        }
        a(fragmentActivity);
        this.f1432i.a(fragmentActivity);
        boolean zM = m(fragmentActivity);
        return this.f1433j.b(fragmentActivity, com.bumptech.glide.c.c(StubApp.getOrigApplicationContext(fragmentActivity.getApplicationContext())), fragmentActivity.getLifecycle(), fragmentActivity.getSupportFragmentManager(), zM);
    }

    @NonNull
    @Deprecated
    p i(Activity activity) {
        return j(activity.getFragmentManager(), null);
    }
}
