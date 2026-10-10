package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import c9.l;
import java.util.Iterator;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d implements kotlin.reflect.jvm.internal.impl.descriptors.annotations.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f13269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u9.d f13270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f13271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.h<u9.a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> f13272d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements l<u9.a, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> {
        a() {
            super(1);
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c invoke(u9.a annotation) {
            m.f(annotation, "annotation");
            return kotlin.reflect.jvm.internal.impl.load.java.components.c.f13167a.e(annotation, d.this.f13269a, d.this.f13271c);
        }
    }

    public d(g c10, u9.d annotationOwner, boolean z10) {
        m.f(c10, "c");
        m.f(annotationOwner, "annotationOwner");
        this.f13269a = c10;
        this.f13270b = annotationOwner;
        this.f13271c = z10;
        this.f13272d = c10.a().u().i(new a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean isEmpty() {
        return this.f13270b.getAnnotations().isEmpty() && !this.f13270b.l();
    }

    @Override // java.lang.Iterable
    public Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> iterator() {
        return ta.k.A(ta.k.M(ta.k.J(r.Z(this.f13270b.getAnnotations()), this.f13272d), kotlin.reflect.jvm.internal.impl.load.java.components.c.f13167a.a(kotlin.reflect.jvm.internal.impl.builtins.k.a.f12646y, this.f13270b, this.f13269a))).iterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.c j(ba.c fqName) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVarInvoke;
        m.f(fqName, "fqName");
        u9.a aVarJ = this.f13270b.j(fqName);
        return (aVarJ == null || (cVarInvoke = this.f13272d.invoke(aVarJ)) == null) ? kotlin.reflect.jvm.internal.impl.load.java.components.c.f13167a.a(fqName, this.f13270b, this.f13269a) : cVarInvoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
    public boolean F(ba.c cVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.b.b(this, cVar);
    }

    public /* synthetic */ d(g gVar, u9.d dVar, boolean z10, int i10, kotlin.jvm.internal.g gVar2) {
        this(gVar, dVar, (i10 & 4) != 0 ? false : z10);
    }
}
