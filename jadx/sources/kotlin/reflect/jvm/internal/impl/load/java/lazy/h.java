package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import c9.l;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.n;
import u9.y;
import u9.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f13381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f13382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<y, Integer> f13384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ka.h<y, n> f13385e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements l<y, n> {
        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n invoke(y typeParameter) {
            kotlin.jvm.internal.m.f(typeParameter, "typeParameter");
            Integer num = (Integer) h.this.f13384d.get(typeParameter);
            if (num == null) {
                return null;
            }
            h hVar = h.this;
            return new n(kotlin.reflect.jvm.internal.impl.load.java.lazy.a.h(kotlin.reflect.jvm.internal.impl.load.java.lazy.a.b(hVar.f13381a, hVar), hVar.f13382b.getAnnotations()), typeParameter, hVar.f13383c + num.intValue(), hVar.f13382b);
        }
    }

    public h(g c10, m containingDeclaration, z typeParameterOwner, int i10) {
        kotlin.jvm.internal.m.f(c10, "c");
        kotlin.jvm.internal.m.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.m.f(typeParameterOwner, "typeParameterOwner");
        this.f13381a = c10;
        this.f13382b = containingDeclaration;
        this.f13383c = i10;
        this.f13384d = sa.a.d(typeParameterOwner.getTypeParameters());
        this.f13385e = c10.e().i(new a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.k
    public f1 a(y javaTypeParameter) {
        kotlin.jvm.internal.m.f(javaTypeParameter, "javaTypeParameter");
        n nVarInvoke = this.f13385e.invoke(javaTypeParameter);
        return nVarInvoke != null ? nVarInvoke : this.f13381a.f().a(javaTypeParameter);
    }
}
