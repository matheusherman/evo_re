package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001c\u001a\u00020\u001b2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u001e\u0010#\u001a\u0004\u0018\u00010 *\u0006\u0012\u0002\b\u00030\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/k0;", "", "<init>", "()V", "Lkotlin/reflect/jvm/internal/impl/descriptors/y;", "descriptor", "", "b", "(Lkotlin/reflect/jvm/internal/impl/descriptors/y;)Z", "Lkotlin/reflect/jvm/internal/h$e;", "d", "(Lkotlin/reflect/jvm/internal/impl/descriptors/y;)Lkotlin/reflect/jvm/internal/h$e;", "Lkotlin/reflect/jvm/internal/impl/descriptors/b;", "", "e", "(Lkotlin/reflect/jvm/internal/impl/descriptors/b;)Ljava/lang/String;", "possiblySubstitutedFunction", "Lkotlin/reflect/jvm/internal/h;", "g", "(Lkotlin/reflect/jvm/internal/impl/descriptors/y;)Lkotlin/reflect/jvm/internal/h;", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/i;", "f", "(Lkotlin/reflect/jvm/internal/impl/descriptors/u0;)Lkotlin/reflect/jvm/internal/i;", "Ljava/lang/Class;", "klass", "Lba/b;", "c", "(Ljava/lang/Class;)Lba/b;", "Lba/b;", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/builtins/i;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "primitiveType", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k0 f14515a = new k0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ba.b JAVA_LANG_VOID;

    static {
        ba.b bVarM = ba.b.m(new ba.c("java.lang.Void"));
        kotlin.jvm.internal.m.e(bVarM, "topLevel(FqName(\"java.lang.Void\"))");
        JAVA_LANG_VOID = bVarM;
    }

    private final h.e d(kotlin.reflect.jvm.internal.impl.descriptors.y descriptor) {
        return new h.e(new aa.d.b(e(descriptor), kotlin.reflect.jvm.internal.impl.load.kotlin.x.c(descriptor, false, false, 1, null)));
    }

    public final ba.b c(Class<?> klass) {
        kotlin.jvm.internal.m.f(klass, "klass");
        if (klass.isArray()) {
            Class<?> componentType = klass.getComponentType();
            kotlin.jvm.internal.m.e(componentType, "klass.componentType");
            kotlin.reflect.jvm.internal.impl.builtins.i iVarA = a(componentType);
            if (iVarA != null) {
                return new ba.b(kotlin.reflect.jvm.internal.impl.builtins.k.f12593v, iVarA.i());
            }
            ba.b bVarM = ba.b.m(kotlin.reflect.jvm.internal.impl.builtins.k.a.f12614i.l());
            kotlin.jvm.internal.m.e(bVarM, "topLevel(StandardNames.FqNames.array.toSafe())");
            return bVarM;
        }
        if (kotlin.jvm.internal.m.a(klass, Void.TYPE)) {
            return JAVA_LANG_VOID;
        }
        kotlin.reflect.jvm.internal.impl.builtins.i iVarA2 = a(klass);
        if (iVarA2 != null) {
            return new ba.b(kotlin.reflect.jvm.internal.impl.builtins.k.f12593v, iVarA2.k());
        }
        ba.b bVarA = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(klass);
        if (!bVarA.k()) {
            kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f12505a;
            ba.c cVarB = bVarA.b();
            kotlin.jvm.internal.m.e(cVarB, "classId.asSingleFqName()");
            ba.b bVarM2 = cVar.m(cVarB);
            if (bVarM2 != null) {
                return bVarM2;
            }
        }
        return bVarA;
    }

    public final i f(u0 possiblyOverriddenProperty) {
        kotlin.jvm.internal.m.f(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        u0 u0VarA = ((u0) kotlin.reflect.jvm.internal.impl.resolve.e.L(possiblyOverriddenProperty)).a();
        kotlin.jvm.internal.m.e(u0VarA, "unwrapFakeOverride(possi…rriddenProperty).original");
        if (u0VarA instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j jVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j) u0VarA;
            w9.n nVarB1 = jVar.y();
            kotlin.reflect.jvm.internal.impl.protobuf.i.f<w9.n, z9.a.d> propertySignature = z9.a.f23127d;
            kotlin.jvm.internal.m.e(propertySignature, "propertySignature");
            z9.a.d dVar = (z9.a.d) y9.e.a(nVarB1, propertySignature);
            if (dVar != null) {
                return new i.c(u0VarA, nVarB1, dVar, jVar.V(), jVar.O());
            }
        } else if (u0VarA instanceof s9.f) {
            a1 source = ((s9.f) u0VarA).getSource();
            t9.a aVar = source instanceof t9.a ? (t9.a) source : null;
            u9.l lVarB = aVar != null ? aVar.b() : null;
            if (lVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.r) {
                return new i.a(((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.r) lVarB).Q());
            }
            if (lVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u) {
                Method methodS = ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u) lVarB).Q();
                w0 setter = u0VarA.getSetter();
                a1 source2 = setter != null ? setter.getSource() : null;
                t9.a aVar2 = source2 instanceof t9.a ? (t9.a) source2 : null;
                u9.l lVarB2 = aVar2 != null ? aVar2.b() : null;
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u uVar = lVarB2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u) lVarB2 : null;
                return new i.b(methodS, uVar != null ? uVar.Q() : null);
            }
            throw new f0("Incorrect resolution sequence for Java field " + u0VarA + " (source = " + lVarB + ')');
        }
        v0 getter = u0VarA.getGetter();
        kotlin.jvm.internal.m.c(getter);
        h.e eVarD = d(getter);
        w0 setter2 = u0VarA.getSetter();
        return new i.d(eVarD, setter2 != null ? d(setter2) : null);
    }

    public final h g(kotlin.reflect.jvm.internal.impl.descriptors.y possiblySubstitutedFunction) {
        Method methodS;
        aa.d.b bVarB;
        aa.d.b bVarE;
        kotlin.jvm.internal.m.f(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        kotlin.reflect.jvm.internal.impl.descriptors.y yVarA = ((kotlin.reflect.jvm.internal.impl.descriptors.y) kotlin.reflect.jvm.internal.impl.resolve.e.L(possiblySubstitutedFunction)).a();
        kotlin.jvm.internal.m.e(yVarA, "unwrapFakeOverride(possi…titutedFunction).original");
        if (yVarA instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b) yVarA;
            kotlin.reflect.jvm.internal.impl.protobuf.q qVarY = bVar.y();
            if ((qVarY instanceof w9.i) && (bVarE = aa.i.f190a.e((w9.i) qVarY, bVar.V(), bVar.O())) != null) {
                return new h.e(bVarE);
            }
            if (!(qVarY instanceof w9.d) || (bVarB = aa.i.f190a.b((w9.d) qVarY, bVar.V(), bVar.O())) == null) {
                return d(yVarA);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = possiblySubstitutedFunction.b();
            kotlin.jvm.internal.m.e(mVarB, "possiblySubstitutedFunction.containingDeclaration");
            return kotlin.reflect.jvm.internal.impl.resolve.g.b(mVarB) ? new h.e(bVarB) : new h.d(bVarB);
        }
        if (yVarA instanceof s9.e) {
            a1 source = ((s9.e) yVarA).getSource();
            t9.a aVar = source instanceof t9.a ? (t9.a) source : null;
            u9.l lVarB = aVar != null ? aVar.b() : null;
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u uVar = lVarB instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u) lVarB : null;
            if (uVar != null && (methodS = uVar.Q()) != null) {
                return new h.c(methodS);
            }
            throw new f0("Incorrect resolution sequence for Java method " + yVarA);
        }
        if (!(yVarA instanceof s9.b)) {
            if (b(yVarA)) {
                return d(yVarA);
            }
            throw new f0("Unknown origin of " + yVarA + " (" + yVarA.getClass() + ')');
        }
        a1 source2 = ((s9.b) yVarA).getSource();
        t9.a aVar2 = source2 instanceof t9.a ? (t9.a) source2 : null;
        u9.l lVarB2 = aVar2 != null ? aVar2.b() : null;
        if (lVarB2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.o) {
            return new h.b(((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.o) lVarB2).Q());
        }
        if (lVarB2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l lVar = (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l) lVarB2;
            if (lVar.o()) {
                return new h.a(lVar.t());
            }
        }
        throw new f0("Incorrect resolution sequence for Java constructor " + yVarA + " (" + lVarB2 + ')');
    }

    private k0() {
    }

    private final kotlin.reflect.jvm.internal.impl.builtins.i a(Class<?> cls) {
        if (cls.isPrimitive()) {
            return fa.e.f(cls.getSimpleName()).l();
        }
        return null;
    }

    private final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.y descriptor) {
        if (kotlin.reflect.jvm.internal.impl.resolve.d.p(descriptor) || kotlin.reflect.jvm.internal.impl.resolve.d.q(descriptor)) {
            return true;
        }
        if (kotlin.jvm.internal.m.a(descriptor.getName(), kotlin.reflect.jvm.internal.impl.builtins.jvm.a.f12501e.a()) && descriptor.f().isEmpty()) {
            return true;
        }
        return false;
    }

    private final String e(kotlin.reflect.jvm.internal.impl.descriptors.b descriptor) {
        String strB = kotlin.reflect.jvm.internal.impl.load.java.h0.b(descriptor);
        if (strB == null) {
            if (descriptor instanceof v0) {
                String strF = ea.c.s(descriptor).getName().f();
                kotlin.jvm.internal.m.e(strF, "descriptor.propertyIfAccessor.name.asString()");
                return kotlin.reflect.jvm.internal.impl.load.java.a0.b(strF);
            }
            if (descriptor instanceof w0) {
                String strF2 = ea.c.s(descriptor).getName().f();
                kotlin.jvm.internal.m.e(strF2, "descriptor.propertyIfAccessor.name.asString()");
                return kotlin.reflect.jvm.internal.impl.load.java.a0.e(strF2);
            }
            String strF3 = descriptor.getName().f();
            kotlin.jvm.internal.m.e(strF3, "descriptor.name.asString()");
            return strF3;
        }
        return strB;
    }
}
