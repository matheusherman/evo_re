package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ba.f f14412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ua.l f14413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<ba.f> f14414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c9.l<y, String> f14415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f[] f14416e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14417a = new a();

        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(y yVar) {
            kotlin.jvm.internal.m.f(yVar, "$this$null");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b extends kotlin.jvm.internal.o implements c9.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14418a = new b();

        b() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(y yVar) {
            kotlin.jvm.internal.m.f(yVar, "$this$null");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends kotlin.jvm.internal.o implements c9.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14419a = new c();

        c() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(y yVar) {
            kotlin.jvm.internal.m.f(yVar, "$this$null");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h(ba.f fVar, ua.l lVar, Collection<ba.f> collection, c9.l<? super y, String> lVar2, f... fVarArr) {
        this.f14412a = fVar;
        this.f14413b = lVar;
        this.f14414c = collection;
        this.f14415d = lVar2;
        this.f14416e = fVarArr;
    }

    public final g a(y functionDescriptor) {
        kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
        for (f fVar : this.f14416e) {
            String strA = fVar.a(functionDescriptor);
            if (strA != null) {
                return new g.b(strA);
            }
        }
        String strInvoke = this.f14415d.invoke(functionDescriptor);
        return strInvoke != null ? new g.b(strInvoke) : g.c.f14411b;
    }

    public final boolean b(y functionDescriptor) {
        kotlin.jvm.internal.m.f(functionDescriptor, "functionDescriptor");
        if (this.f14412a != null && !kotlin.jvm.internal.m.a(functionDescriptor.getName(), this.f14412a)) {
            return false;
        }
        if (this.f14413b != null) {
            String strF = functionDescriptor.getName().f();
            kotlin.jvm.internal.m.e(strF, "functionDescriptor.name.asString()");
            if (!this.f14413b.d(strF)) {
                return false;
            }
        }
        Collection<ba.f> collection = this.f14414c;
        return collection == null || collection.contains(functionDescriptor.getName());
    }

    public /* synthetic */ h(ba.f fVar, f[] fVarArr, c9.l lVar, int i10, kotlin.jvm.internal.g gVar) {
        this(fVar, fVarArr, (c9.l<? super y, String>) ((i10 & 4) != 0 ? a.f14417a : lVar));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(ba.f name, f[] checks, c9.l<? super y, String> additionalChecks) {
        this(name, (ua.l) null, (Collection<ba.f>) null, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        kotlin.jvm.internal.m.f(name, "name");
        kotlin.jvm.internal.m.f(checks, "checks");
        kotlin.jvm.internal.m.f(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ h(ua.l lVar, f[] fVarArr, c9.l lVar2, int i10, kotlin.jvm.internal.g gVar) {
        this(lVar, fVarArr, (c9.l<? super y, String>) ((i10 & 4) != 0 ? b.f14418a : lVar2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(ua.l regex, f[] checks, c9.l<? super y, String> additionalChecks) {
        this((ba.f) null, regex, (Collection<ba.f>) null, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        kotlin.jvm.internal.m.f(regex, "regex");
        kotlin.jvm.internal.m.f(checks, "checks");
        kotlin.jvm.internal.m.f(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ h(Collection collection, f[] fVarArr, c9.l lVar, int i10, kotlin.jvm.internal.g gVar) {
        this((Collection<ba.f>) collection, fVarArr, (c9.l<? super y, String>) ((i10 & 4) != 0 ? c.f14419a : lVar));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Collection<ba.f> nameList, f[] checks, c9.l<? super y, String> additionalChecks) {
        this((ba.f) null, (ua.l) null, nameList, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        kotlin.jvm.internal.m.f(nameList, "nameList");
        kotlin.jvm.internal.m.f(checks, "checks");
        kotlin.jvm.internal.m.f(additionalChecks, "additionalChecks");
    }
}
