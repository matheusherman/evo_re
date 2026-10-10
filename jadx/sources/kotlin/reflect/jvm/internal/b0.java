package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.types.s1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\"\u0010\f\u001a\u0004\u0018\u00010\t*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/a0$a;", "", "isGetter", "Lkotlin/reflect/jvm/internal/calls/e;", "b", "(Lkotlin/reflect/jvm/internal/a0$a;Z)Lkotlin/reflect/jvm/internal/calls/e;", "Lkotlin/reflect/jvm/internal/impl/descriptors/u0;", "g", "(Lkotlin/reflect/jvm/internal/impl/descriptors/u0;)Z", "", "f", "(Lkotlin/reflect/jvm/internal/a0$a;)Ljava/lang/Object;", "boundReceiver", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class b0 {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:13:0x003d  */
    public static final kotlin.reflect.jvm.internal.calls.e<?> b(a0.a<?, ?> aVar, boolean z10) {
        h.e eVarC;
        Method methodC;
        kotlin.reflect.jvm.internal.calls.e aVar2;
        z9.a.c cVarB;
        kotlin.reflect.jvm.internal.calls.e cVar;
        Method methodF;
        if (n.INSTANCE.a().d(aVar.x().getSignature())) {
            return kotlin.reflect.jvm.internal.calls.k.f12417a;
        }
        i iVarF = k0.f14515a.f(aVar.x().w());
        if (iVarF instanceof i.c) {
            i.c cVar2 = (i.c) iVarF;
            z9.a.d dVarF = cVar2.getSignature();
            if (z10) {
                if (dVarF.F()) {
                    cVarB = dVarF.A();
                } else {
                    cVarB = null;
                }
            } else if (dVarF.G()) {
                cVarB = dVarF.B();
            } else {
                cVarB = null;
            }
            Method methodR = cVarB != null ? aVar.x().getContainer().r(cVar2.getNameResolver().getString(cVarB.w()), cVar2.getNameResolver().getString(cVarB.v())) : null;
            if (methodR != null) {
                if (!Modifier.isStatic(methodR.getModifiers())) {
                    cVar = aVar.v() ? new kotlin.reflect.jvm.internal.calls.f.h.a(methodR, f(aVar)) : new kotlin.reflect.jvm.internal.calls.f.h.d(methodR);
                } else if (d(aVar)) {
                    cVar = aVar.v() ? new kotlin.reflect.jvm.internal.calls.f.h.b(methodR) : new kotlin.reflect.jvm.internal.calls.f.h.e(methodR);
                } else {
                    cVar = aVar.v() ? new kotlin.reflect.jvm.internal.calls.f.h.c(methodR, f(aVar)) : new kotlin.reflect.jvm.internal.calls.f.h.C0211f(methodR);
                }
                aVar2 = cVar;
            } else if (kotlin.reflect.jvm.internal.impl.resolve.g.e(aVar.x().w()) && kotlin.jvm.internal.m.a(aVar.x().w().getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.t.f13067d)) {
                Class<?> clsH = kotlin.reflect.jvm.internal.calls.i.h(aVar.x().w().b());
                if (clsH == null || (methodF = kotlin.reflect.jvm.internal.calls.i.f(clsH, aVar.x().w())) == null) {
                    throw new f0("Underlying property of inline class " + aVar.x() + " should have a field");
                }
                aVar2 = aVar.v() ? new kotlin.reflect.jvm.internal.calls.j.a(methodF, f(aVar)) : new kotlin.reflect.jvm.internal.calls.j.b(methodF);
            } else {
                Field fieldB = aVar.x().B();
                if (fieldB == null) {
                    throw new f0("No accessors or field is found for property " + aVar.x());
                }
                aVar2 = c(aVar, z10, fieldB);
            }
        } else if (iVarF instanceof i.a) {
            aVar2 = c(aVar, z10, ((i.a) iVarF).getField());
        } else {
            if (!(iVarF instanceof i.b)) {
                if (!(iVarF instanceof i.d)) {
                    throw new r8.n();
                }
                if (z10) {
                    eVarC = ((i.d) iVarF).getGetterSignature();
                } else {
                    eVarC = ((i.d) iVarF).getSetterSignature();
                    if (eVarC == null) {
                        throw new f0("No setter found for property " + aVar.x());
                    }
                }
                Method methodR2 = aVar.x().getContainer().r(eVarC.c(), eVarC.b());
                if (methodR2 != null) {
                    Modifier.isStatic(methodR2.getModifiers());
                    return aVar.v() ? new kotlin.reflect.jvm.internal.calls.f.h.a(methodR2, f(aVar)) : new kotlin.reflect.jvm.internal.calls.f.h.d(methodR2);
                }
                throw new f0("No accessor found for property " + aVar.x());
            }
            if (z10) {
                methodC = ((i.b) iVarF).getGetterMethod();
            } else {
                i.b bVar = (i.b) iVarF;
                methodC = bVar.getSetterMethod();
                if (methodC == null) {
                    throw new f0("No source found for setter of Java method property: " + bVar.getGetterMethod());
                }
            }
            aVar2 = aVar.v() ? new kotlin.reflect.jvm.internal.calls.f.h.a(methodC, f(aVar)) : new kotlin.reflect.jvm.internal.calls.f.h.d(methodC);
        }
        return kotlin.reflect.jvm.internal.calls.i.c(aVar2, aVar.w(), false, 2, null);
    }

    public static final Object f(a0.a<?, ?> aVar) {
        kotlin.jvm.internal.m.f(aVar, "<this>");
        return aVar.x().x();
    }

    private static final kotlin.reflect.jvm.internal.calls.f<Field> c(a0.a<?, ?> aVar, boolean z10, Field field) {
        if (!g(aVar.x().w()) && Modifier.isStatic(field.getModifiers())) {
            if (d(aVar)) {
                if (z10) {
                    if (aVar.v()) {
                        return new kotlin.reflect.jvm.internal.calls.f.AbstractC0210f.b(field);
                    }
                    return new kotlin.reflect.jvm.internal.calls.f.AbstractC0210f.d(field);
                }
                if (aVar.v()) {
                    return new kotlin.reflect.jvm.internal.calls.f.g.b(field, e(aVar));
                }
                return new kotlin.reflect.jvm.internal.calls.f.g.d(field, e(aVar));
            }
            if (z10) {
                return new kotlin.reflect.jvm.internal.calls.f.AbstractC0210f.e(field);
            }
            return new kotlin.reflect.jvm.internal.calls.f.g.e(field, e(aVar));
        }
        if (z10) {
            if (aVar.v()) {
                return new kotlin.reflect.jvm.internal.calls.f.AbstractC0210f.a(field, f(aVar));
            }
            return new kotlin.reflect.jvm.internal.calls.f.AbstractC0210f.c(field);
        }
        if (aVar.v()) {
            return new kotlin.reflect.jvm.internal.calls.f.g.a(field, e(aVar), f(aVar));
        }
        return new kotlin.reflect.jvm.internal.calls.f.g.c(field, e(aVar));
    }

    private static final boolean d(a0.a<?, ?> aVar) {
        return aVar.x().w().getAnnotations().F(n0.j());
    }

    private static final boolean e(a0.a<?, ?> aVar) {
        return !s1.l(aVar.x().w().getType());
    }

    private static final boolean g(u0 u0Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.m containingDeclaration = u0Var.b();
        kotlin.jvm.internal.m.e(containingDeclaration, "containingDeclaration");
        if (!kotlin.reflect.jvm.internal.impl.resolve.e.x(containingDeclaration)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarB = containingDeclaration.b();
        if (!kotlin.reflect.jvm.internal.impl.resolve.e.C(mVarB) && !kotlin.reflect.jvm.internal.impl.resolve.e.t(mVarB)) {
            return true;
        }
        if (!(u0Var instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j) || !aa.i.f(((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j) u0Var).y())) {
            return false;
        }
        return true;
    }
}
