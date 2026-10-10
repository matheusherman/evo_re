package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d<T> extends c<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f14402c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f14403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14404b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends kotlin.collections.c<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f14405c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d<T> f14406d;

        b(d<T> dVar) {
            this.f14406d = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.c
        protected void c() {
            do {
                int i10 = this.f14405c + 1;
                this.f14405c = i10;
                if (i10 >= ((d) this.f14406d).f14403a.length) {
                    break;
                }
            } while (((d) this.f14406d).f14403a[this.f14405c] == null);
            if (this.f14405c >= ((d) this.f14406d).f14403a.length) {
                d();
                return;
            }
            Object obj = ((d) this.f14406d).f14403a[this.f14405c];
            kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
            e(obj);
        }
    }

    private d(Object[] objArr, int i10) {
        super(null);
        this.f14403a = objArr;
        this.f14404b = i10;
    }

    private final void i(int i10) {
        Object[] objArr = this.f14403a;
        if (objArr.length <= i10) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length * 2);
            kotlin.jvm.internal.m.e(objArrCopyOf, "copyOf(this, newSize)");
            this.f14403a = objArrCopyOf;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public int e() {
        return this.f14404b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public void f(int i10, T value) {
        kotlin.jvm.internal.m.f(value, "value");
        i(i10);
        if (this.f14403a[i10] == null) {
            this.f14404b = e() + 1;
        }
        this.f14403a[i10] = value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c
    public T get(int i10) {
        return (T) kotlin.collections.j.T(this.f14403a, i10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.c, java.lang.Iterable
    public Iterator<T> iterator() {
        return new b(this);
    }

    public d() {
        this(new Object[20], 0);
    }
}
