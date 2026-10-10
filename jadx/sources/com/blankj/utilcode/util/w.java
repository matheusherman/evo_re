package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.p000lifecycle.Lifecycle;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class w implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final w f1255g = new w();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Activity f1256h = new Activity();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<Activity> f1257a = new LinkedList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<u.d> f1258b = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Activity, List<u.a>> f1259c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1260d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1261e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1262f = false;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f1263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u.a f1264b;

        a(Activity activity, u.a aVar) {
            this.f1263a = activity;
            this.f1264b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.e(this.f1263a, this.f1264b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f1266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u.a f1267b;

        b(Activity activity, u.a aVar) {
            this.f1266a = activity;
            this.f1267b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.t(this.f1266a, this.f1267b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f1269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f1270b;

        c(Activity activity, Object obj) {
            this.f1269a = activity;
            this.f1270b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Window window = this.f1269a.getWindow();
                if (window != null) {
                    window.setSoftInputMode(((Integer) this.f1270b).intValue());
                }
            } catch (Exception unused) {
            }
        }
    }

    private Object k() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e10) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e10.getMessage());
            return null;
        }
    }

    private Object l() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null).invoke(null, null);
        } catch (Exception e10) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e10.getMessage());
            return null;
        }
    }

    Application m() {
        Object objInvoke;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objJ = j();
            if (objJ == null || (objInvoke = cls.getMethod("getApplication", null).invoke(objJ, null)) == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Activity activity, u.a aVar) {
        List<u.a> copyOnWriteArrayList = this.f1259c.get(activity);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f1259c.put(activity, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        copyOnWriteArrayList.add(aVar);
    }

    private void f(Activity activity, Lifecycle.Event event) {
        g(activity, event, this.f1259c.get(activity));
        g(activity, event, this.f1259c.get(f1256h));
    }

    private void g(Activity activity, Lifecycle.Event event, List<u.a> list) {
        if (list == null) {
            return;
        }
        for (u.a aVar : list) {
            aVar.g(activity, event);
            if (event.equals(Lifecycle.Event.ON_CREATE)) {
                aVar.a(activity);
            } else if (event.equals(Lifecycle.Event.ON_START)) {
                aVar.e(activity);
            } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                aVar.d(activity);
            } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                aVar.c(activity);
            } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                aVar.f(activity);
            } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                aVar.b(activity);
            }
        }
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            this.f1259c.remove(activity);
        }
    }

    private List<Activity> h() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object objJ = j();
            if (objJ != null) {
                Field declaredField = objJ.getClass().getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(objJ);
                if (obj instanceof Map) {
                    for (Object obj2 : ((Map) obj).values()) {
                        Class<?> cls = obj2.getClass();
                        Field declaredField2 = cls.getDeclaredField("activity");
                        declaredField2.setAccessible(true);
                        Activity activity2 = (Activity) declaredField2.get(obj2);
                        if (activity == null) {
                            Field declaredField3 = cls.getDeclaredField("paused");
                            declaredField3.setAccessible(true);
                            if (declaredField3.getBoolean(obj2)) {
                                linkedList.addFirst(activity2);
                            } else {
                                activity = activity2;
                            }
                        } else {
                            linkedList.addFirst(activity2);
                        }
                    }
                    if (activity != null) {
                        linkedList.addFirst(activity);
                    }
                }
            }
        } catch (Exception e10) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e10.getMessage());
        }
        return linkedList;
    }

    private void p(Activity activity, boolean z10) {
        if (this.f1258b.isEmpty()) {
            return;
        }
        for (u.d dVar : this.f1258b) {
            if (z10) {
                dVar.a(activity);
            } else {
                dVar.b(activity);
            }
        }
    }

    private void q(Activity activity, boolean z10) {
        try {
            if (z10) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
                return;
            }
            Object tag = activity.getWindow().getDecorView().getTag(-123);
            if (tag instanceof Integer) {
                x.x(new c(activity, tag), 100L);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Activity activity, u.a aVar) {
        List<u.a> list = this.f1259c.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(aVar);
    }

    private static void u() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                    declaredField.set(null, Float.valueOf(1.0f));
                    Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (NoSuchFieldException e11) {
                e11.printStackTrace();
            }
        }
    }

    private void v(Activity activity) {
        if (!this.f1257a.contains(activity)) {
            this.f1257a.addFirst(activity);
        } else {
            if (this.f1257a.getFirst().equals(activity)) {
                return;
            }
            this.f1257a.remove(activity);
            this.f1257a.addFirst(activity);
        }
    }

    void c(Activity activity, u.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        x.w(new a(activity, aVar));
    }

    void d(u.a aVar) {
        c(f1256h, aVar);
    }

    List<Activity> i() {
        if (!this.f1257a.isEmpty()) {
            return new LinkedList(this.f1257a);
        }
        this.f1257a.addAll(h());
        return new LinkedList(this.f1257a);
    }

    boolean o() {
        return !this.f1262f;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) {
        if (this.f1257a.size() == 0) {
            p(activity, true);
        }
        h.a(activity);
        u();
        v(activity);
        f(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        this.f1257a.remove(activity);
        x.c(activity);
        f(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        f(activity, Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        if (!this.f1262f) {
            v(activity);
        }
        int i10 = this.f1261e;
        if (i10 < 0) {
            this.f1261e = i10 + 1;
        } else {
            this.f1260d++;
        }
        f(activity, Lifecycle.Event.ON_START);
    }

    void r(Activity activity, u.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        x.w(new b(activity, aVar));
    }

    void s(u.a aVar) {
        r(f1256h, aVar);
    }

    void w(Application application) {
        this.f1257a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }

    w() {
    }

    private Object j() {
        Object objK = k();
        if (objK != null) {
            return objK;
        }
        return l();
    }

    void n(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        v(activity);
        if (this.f1262f) {
            this.f1262f = false;
            p(activity, true);
        }
        q(activity, false);
        f(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.f1261e--;
        } else {
            int i10 = this.f1260d - 1;
            this.f1260d = i10;
            if (i10 <= 0) {
                this.f1262f = true;
                p(activity, false);
            }
        }
        q(activity, true);
        f(activity, Lifecycle.Event.ON_STOP);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
