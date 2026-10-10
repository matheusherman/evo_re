package k9;

import i9.g;
import i9.h;
import i9.k;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.calls.e;
import kotlin.reflect.jvm.internal.j;
import kotlin.reflect.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\",\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Li9/c;", "", "value", "a", "(Li9/c;)Z", "setAccessible", "(Li9/c;Z)V", "isAccessible", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class a {
    public static final boolean a(i9.c<?> cVar) {
        e<?> eVarS;
        m.f(cVar, "<this>");
        if (cVar instanceof h) {
            k kVar = (k) cVar;
            Field fieldB = c.b(kVar);
            if (fieldB != null ? fieldB.isAccessible() : true) {
                Method methodC = c.c(kVar);
                if (methodC != null ? methodC.isAccessible() : true) {
                    Method methodE = c.e((h) cVar);
                    if (methodE != null ? methodE.isAccessible() : true) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (cVar instanceof k) {
            k kVar2 = (k) cVar;
            Field fieldB2 = c.b(kVar2);
            if (fieldB2 != null ? fieldB2.isAccessible() : true) {
                Method methodC2 = c.c(kVar2);
                if (methodC2 != null ? methodC2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (cVar instanceof k.b) {
            Field fieldB3 = c.b(((k.b) cVar).x());
            if (fieldB3 != null ? fieldB3.isAccessible() : true) {
                Method methodD = c.d((g) cVar);
                if (methodD != null ? methodD.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (cVar instanceof h.a) {
            Field fieldB4 = c.b(((h.a) cVar).x());
            if (fieldB4 != null ? fieldB4.isAccessible() : true) {
                Method methodD2 = c.d((g) cVar);
                if (methodD2 != null ? methodD2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (!(cVar instanceof g)) {
            throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
        }
        g gVar = (g) cVar;
        Method methodD3 = c.d(gVar);
        if (methodD3 != null ? methodD3.isAccessible() : true) {
            j<?> jVarB = n0.b(cVar);
            Member memberB = (jVarB == null || (eVarS = jVarB.s()) == null) ? null : eVarS.b();
            AccessibleObject accessibleObject = memberB instanceof AccessibleObject ? (AccessibleObject) memberB : null;
            if (accessibleObject != null ? accessibleObject.isAccessible() : true) {
                Constructor constructorA = c.a(gVar);
                if (constructorA != null ? constructorA.isAccessible() : true) {
                    return true;
                }
            }
        }
        return false;
    }
}
