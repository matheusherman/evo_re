package k9;

import androidx.exifinterface.media.ExifInterface;
import i9.g;
import i9.h;
import i9.k;
import i9.n;
import i9.u;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.a0;
import kotlin.reflect.jvm.internal.c0;
import kotlin.reflect.jvm.internal.calls.e;
import kotlin.reflect.jvm.internal.j;
import kotlin.reflect.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\b\u001a\u0004\u0018\u00010\u0005*\u0006\u0012\u0002\b\u00030\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\f\u001a\u0004\u0018\u00010\u0005*\u0006\u0012\u0002\b\u00030\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u0005*\u0006\u0012\u0002\b\u00030\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"/\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u00028\u00000\r8F¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u001c\u001a\u00020\u0019*\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Li9/k;", "Ljava/lang/reflect/Field;", "b", "(Li9/k;)Ljava/lang/reflect/Field;", "javaField", "Ljava/lang/reflect/Method;", "c", "(Li9/k;)Ljava/lang/reflect/Method;", "javaGetter", "Li9/h;", "e", "(Li9/h;)Ljava/lang/reflect/Method;", "javaSetter", "Li9/g;", "d", "(Li9/g;)Ljava/lang/reflect/Method;", "javaMethod", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/reflect/Constructor;", "a", "(Li9/g;)Ljava/lang/reflect/Constructor;", "getJavaConstructor$annotations", "(Li9/g;)V", "javaConstructor", "Li9/n;", "Ljava/lang/reflect/Type;", "f", "(Li9/n;)Ljava/lang/reflect/Type;", "javaType", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class c {
    public static final <T> Constructor<T> a(g<? extends T> gVar) {
        e<?> eVarQ;
        m.f(gVar, "<this>");
        j<?> jVarB = n0.b(gVar);
        Member memberB = (jVarB == null || (eVarQ = jVarB.q()) == null) ? null : eVarQ.b();
        if (memberB instanceof Constructor) {
            return (Constructor) memberB;
        }
        return null;
    }

    public static final Field b(k<?> kVar) {
        m.f(kVar, "<this>");
        a0<?> a0VarD = n0.d(kVar);
        if (a0VarD != null) {
            return a0VarD.B();
        }
        return null;
    }

    public static final Method c(k<?> kVar) {
        m.f(kVar, "<this>");
        return d(kVar.getGetter());
    }

    public static final Method d(g<?> gVar) {
        e<?> eVarQ;
        m.f(gVar, "<this>");
        j<?> jVarB = n0.b(gVar);
        Member memberB = (jVarB == null || (eVarQ = jVarB.q()) == null) ? null : eVarQ.b();
        if (memberB instanceof Method) {
            return (Method) memberB;
        }
        return null;
    }

    public static final Method e(h<?> hVar) {
        m.f(hVar, "<this>");
        return d(hVar.getSetter());
    }

    public static final Type f(n nVar) {
        m.f(nVar, "<this>");
        Type typeF = ((c0) nVar).f();
        return typeF == null ? u.f(nVar) : typeF;
    }
}
