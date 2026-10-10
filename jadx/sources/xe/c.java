package xe;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static volatile c f22191s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final d f22192t = new d();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f22193u = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<q>> f22194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f22195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, Object> f22196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal<C0476c> f22197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h f22198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final l f22199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final xe.b f22200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final xe.a f22201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final p f22202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ExecutorService f22203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f22204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f22205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f22206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f22207n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f22208o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f22209p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f22210q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final g f22211r;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends ThreadLocal<C0476c> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0476c initialValue() {
            return new C0476c();
        }
    }

    public c() {
        this(f22192t);
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    private boolean n(Object obj, C0476c c0476c, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f22194a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (q qVar : copyOnWriteArrayList) {
            c0476c.f22218e = obj;
            c0476c.f22217d = qVar;
            try {
                p(qVar, obj, c0476c.f22216c);
                boolean z10 = c0476c.f22219f;
                c0476c.f22218e = null;
                c0476c.f22217d = null;
                c0476c.f22219f = false;
                if (z10) {
                    return true;
                }
            } catch (Throwable th) {
                c0476c.f22218e = null;
                c0476c.f22217d = null;
                c0476c.f22219f = false;
                throw th;
            }
        }
        return true;
    }

    public synchronized boolean j(Object obj) {
        return this.f22195b.containsKey(obj);
    }

    public synchronized void u(Object obj) {
        try {
            List<Class<?>> list = this.f22195b.get(obj);
            if (list != null) {
                Iterator<Class<?>> it = list.iterator();
                while (it.hasNext()) {
                    v(obj, it.next());
                }
                this.f22195b.remove(obj);
            } else {
                this.f22211r.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f22213a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f22213a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22213a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22213a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22213a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22213a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: xe.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0476c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<Object> f22214a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f22215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f22216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        q f22217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f22218e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f22219f;

        C0476c() {
        }
    }

    c(d dVar) {
        this.f22197d = new a();
        this.f22211r = dVar.a();
        this.f22194a = new HashMap();
        this.f22195b = new HashMap();
        this.f22196c = new ConcurrentHashMap();
        h hVarB = dVar.b();
        this.f22198e = hVarB;
        this.f22199f = hVarB != null ? hVarB.a(this) : null;
        this.f22200g = new xe.b(this);
        this.f22201h = new xe.a(this);
        List<ze.b> list = dVar.f22230j;
        this.f22210q = list != null ? list.size() : 0;
        this.f22202i = new p(dVar.f22230j, dVar.f22228h, dVar.f22227g);
        this.f22205l = dVar.f22221a;
        this.f22206m = dVar.f22222b;
        this.f22207n = dVar.f22223c;
        this.f22208o = dVar.f22224d;
        this.f22204k = dVar.f22225e;
        this.f22209p = dVar.f22226f;
        this.f22203j = dVar.f22229i;
    }

    private void b(q qVar, Object obj) {
        if (obj != null) {
            p(qVar, obj, i());
        }
    }

    public static c c() {
        c cVar;
        c cVar2 = f22191s;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            try {
                cVar = f22191s;
                if (cVar == null) {
                    cVar = new c();
                    f22191s = cVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    private void f(q qVar, Object obj, Throwable th) {
        if (!(obj instanceof n)) {
            if (this.f22204k) {
                throw new e("Invoking subscriber failed", th);
            }
            if (this.f22205l) {
                this.f22211r.b(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + qVar.f22267a.getClass(), th);
            }
            if (this.f22207n) {
                l(new n(this, th, obj, qVar.f22267a));
                return;
            }
            return;
        }
        if (this.f22205l) {
            g gVar = this.f22211r;
            Level level = Level.SEVERE;
            gVar.b(level, "SubscriberExceptionEvent subscriber " + qVar.f22267a.getClass() + " threw an exception", th);
            n nVar = (n) obj;
            this.f22211r.b(level, "Initial event " + nVar.f22247c + " caused exception in " + nVar.f22248d, nVar.f22246b);
        }
    }

    private boolean i() {
        h hVar = this.f22198e;
        return hVar == null || hVar.b();
    }

    private static List<Class<?>> k(Class<?> cls) {
        List<Class<?>> arrayList;
        Map<Class<?>, List<Class<?>>> map = f22193u;
        synchronized (map) {
            try {
                arrayList = map.get(cls);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                        arrayList.add(superclass);
                        a(arrayList, superclass.getInterfaces());
                    }
                    f22193u.put(cls, arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    private void p(q qVar, Object obj, boolean z10) {
        int i10 = b.f22213a[qVar.f22268b.f22250b.ordinal()];
        if (i10 == 1) {
            h(qVar, obj);
            return;
        }
        if (i10 == 2) {
            if (z10) {
                h(qVar, obj);
                return;
            } else {
                this.f22199f.a(qVar, obj);
                return;
            }
        }
        if (i10 == 3) {
            l lVar = this.f22199f;
            if (lVar != null) {
                lVar.a(qVar, obj);
                return;
            } else {
                h(qVar, obj);
                return;
            }
        }
        if (i10 == 4) {
            if (z10) {
                this.f22200g.a(qVar, obj);
                return;
            } else {
                h(qVar, obj);
                return;
            }
        }
        if (i10 == 5) {
            this.f22201h.a(qVar, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + qVar.f22268b.f22250b);
    }

    private void t(Object obj, o oVar) {
        Class<?> cls = oVar.f22251c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.f22194a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f22194a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i10 = 0; i10 <= size; i10++) {
            if (i10 == size || oVar.f22252d > copyOnWriteArrayList.get(i10).f22268b.f22252d) {
                copyOnWriteArrayList.add(i10, qVar);
                break;
            }
        }
        List<Class<?>> arrayList = this.f22195b.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f22195b.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (oVar.f22253e) {
            if (!this.f22209p) {
                b(qVar, this.f22196c.get(cls));
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.f22196c.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    b(qVar, entry.getValue());
                }
            }
        }
    }

    private void v(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.f22194a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i10 = 0;
            while (i10 < size) {
                q qVar = copyOnWriteArrayList.get(i10);
                if (qVar.f22267a == obj) {
                    qVar.f22269c = false;
                    copyOnWriteArrayList.remove(i10);
                    i10--;
                    size--;
                }
                i10++;
            }
        }
    }

    ExecutorService d() {
        return this.f22203j;
    }

    public g e() {
        return this.f22211r;
    }

    void g(j jVar) {
        Object obj = jVar.f22240a;
        q qVar = jVar.f22241b;
        j.b(jVar);
        if (qVar.f22269c) {
            h(qVar, obj);
        }
    }

    void h(q qVar, Object obj) {
        try {
            qVar.f22268b.f22249a.invoke(qVar.f22267a, obj);
        } catch (IllegalAccessException e10) {
            throw new IllegalStateException("Unexpected exception", e10);
        } catch (InvocationTargetException e11) {
            f(qVar, obj, e11.getCause());
        }
    }

    public void l(Object obj) {
        C0476c c0476c = this.f22197d.get();
        List<Object> list = c0476c.f22214a;
        list.add(obj);
        if (c0476c.f22215b) {
            return;
        }
        c0476c.f22216c = i();
        c0476c.f22215b = true;
        if (c0476c.f22219f) {
            throw new e("Internal error. Abort state was not reset");
        }
        while (!list.isEmpty()) {
            try {
                m(list.remove(0), c0476c);
            } catch (Throwable th) {
                c0476c.f22215b = false;
                c0476c.f22216c = false;
                throw th;
            }
        }
        c0476c.f22215b = false;
        c0476c.f22216c = false;
    }

    public void o(Object obj) {
        synchronized (this.f22196c) {
            this.f22196c.put(obj.getClass(), obj);
        }
        l(obj);
    }

    public <T> T r(Class<T> cls) {
        T tCast;
        synchronized (this.f22196c) {
            tCast = cls.cast(this.f22196c.remove(cls));
        }
        return tCast;
    }

    public boolean s(Object obj) {
        synchronized (this.f22196c) {
            try {
                Class<?> cls = obj.getClass();
                if (!obj.equals(this.f22196c.get(cls))) {
                    return false;
                }
                this.f22196c.remove(cls);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f22210q + ", eventInheritance=" + this.f22209p + "]";
    }

    private void m(Object obj, C0476c c0476c) {
        boolean zN;
        Class<?> cls = obj.getClass();
        if (this.f22209p) {
            List<Class<?>> listK = k(cls);
            int size = listK.size();
            zN = false;
            for (int i10 = 0; i10 < size; i10++) {
                zN |= n(obj, c0476c, listK.get(i10));
            }
        } else {
            zN = n(obj, c0476c, cls);
        }
        if (!zN) {
            if (this.f22206m) {
                this.f22211r.a(Level.FINE, "No subscribers registered for event " + cls);
            }
            if (this.f22208o && cls != i.class && cls != n.class) {
                l(new i(this, obj));
            }
        }
    }

    public void q(Object obj) {
        if (ye.b.c() && !ye.b.a()) {
            throw new RuntimeException("It looks like you are using EventBus on Android, make sure to add the \"eventbus\" Android library to your dependencies.");
        }
        List<o> listA = this.f22202i.a(obj.getClass());
        synchronized (this) {
            try {
                Iterator<o> it = listA.iterator();
                while (it.hasNext()) {
                    t(obj, it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
