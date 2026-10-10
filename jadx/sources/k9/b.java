package k9;

import i9.e;
import i9.n;
import i9.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.c0;
import kotlin.reflect.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\"\"\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Li9/n;", "Li9/d;", "b", "(Li9/n;)Li9/d;", "getJvmErasure$annotations", "(Li9/n;)V", "jvmErasure", "Li9/e;", "a", "(Li9/e;)Li9/d;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class b {
    public static final i9.d<?> a(e eVar) {
        Object obj;
        i9.d<?> dVarB;
        m.f(eVar, "<this>");
        if (eVar instanceof i9.d) {
            return (i9.d) eVar;
        }
        if (!(eVar instanceof o)) {
            throw new f0("Cannot calculate JVM erasure for type: " + eVar);
        }
        List<n> upperBounds = ((o) eVar).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            n nVar = (n) next;
            m.d(nVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            h hVarD = ((c0) nVar).getTv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TYPE java.lang.String().J0().d();
            kotlin.reflect.jvm.internal.impl.descriptors.e eVar2 = hVarD instanceof kotlin.reflect.jvm.internal.impl.descriptors.e ? (kotlin.reflect.jvm.internal.impl.descriptors.e) hVarD : null;
            if (eVar2 != null && eVar2.g() != f.INTERFACE && eVar2.g() != f.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        n nVar2 = (n) obj;
        if (nVar2 == null) {
            nVar2 = (n) r.i0(upperBounds);
        }
        return (nVar2 == null || (dVarB = b(nVar2)) == null) ? kotlin.jvm.internal.c0.b(Object.class) : dVarB;
    }

    public static final i9.d<?> b(n nVar) {
        i9.d<?> dVarA;
        m.f(nVar, "<this>");
        e eVarC = nVar.c();
        if (eVarC != null && (dVarA = a(eVarC)) != null) {
            return dVarA;
        }
        throw new f0("Cannot calculate JVM erasure for type: " + nVar);
    }
}
