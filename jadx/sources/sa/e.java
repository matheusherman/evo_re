package sa;

import c9.l;
import c9.p;
import c9.q;
import kotlin.jvm.internal.o;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final l<Object, Object> f18506a = f.f18517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l<Object, Boolean> f18507b = b.f18513a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final l<Object, Object> f18508c = a.f18512a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final l<Object, z> f18509d = c.f18514a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final p<Object, Object, z> f18510e = d.f18515a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final q<Object, Object, Object, z> f18511f = C0359e.f18516a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18512a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends o implements l<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f18513a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends o implements l<Object, z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f18514a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke2(obj);
            return z.f17874a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends o implements p<Object, Object, z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f18515a = new d();

        d() {
            super(2);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ z invoke(Object obj, Object obj2) {
            a(obj, obj2);
            return z.f17874a;
        }

        public final void a(Object obj, Object obj2) {
        }
    }

    /* JADX INFO: renamed from: sa.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0359e extends o implements q<Object, Object, Object, z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0359e f18516a = new C0359e();

        C0359e() {
            super(3);
        }

        @Override // c9.q
        public /* bridge */ /* synthetic */ z invoke(Object obj, Object obj2, Object obj3) {
            a(obj, obj2, obj3);
            return z.f17874a;
        }

        public final void a(Object obj, Object obj2, Object obj3) {
        }
    }

    public static final <T> l<T, Boolean> a() {
        return (l<T, Boolean>) f18507b;
    }

    public static final q<Object, Object, Object, z> b() {
        return f18511f;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class f extends o implements l<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f18517a = new f();

        f() {
            super(1);
        }

        @Override // c9.l
        public final Object invoke(Object obj) {
            return obj;
        }
    }
}
