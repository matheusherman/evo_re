package kotlin.reflect.jvm.internal.impl.resolve;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.k1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.x0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.i0;
import kotlin.reflect.jvm.internal.impl.types.s1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ba.c f13919a = new ba.c("kotlin.jvm.JvmName");

    public static boolean E(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(1);
        }
        while (mVar != null) {
            if (u(mVar) || y(mVar)) {
                return true;
            }
            mVar = mVar.b();
        }
        return false;
    }

    public static boolean A(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        return D(mVar, kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_CLASS);
    }

    public static boolean B(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(36);
        }
        return D(mVar, kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY);
    }

    public static boolean C(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        return D(mVar, kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE);
    }

    private static boolean D(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
        if (fVar == null) {
            a(37);
        }
        return (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && ((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar).g() == fVar;
    }

    private static boolean F(g0 g0Var, kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (g0Var == null) {
            a(30);
        }
        if (mVar == null) {
            a(31);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        if (hVarD == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m mVarA = hVarD.a();
        return (mVarA instanceof kotlin.reflect.jvm.internal.impl.descriptors.h) && (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.h) && ((kotlin.reflect.jvm.internal.impl.descriptors.h) mVar).h().equals(((kotlin.reflect.jvm.internal.impl.descriptors.h) mVarA).h());
    }

    public static boolean G(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        return (D(mVar, kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS) || D(mVar, kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE)) && ((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar).i() == e0.SEALED;
    }

    public static boolean H(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar2) {
        if (eVar == null) {
            a(28);
        }
        if (eVar2 == null) {
            a(29);
        }
        return I(eVar.p(), eVar2.a());
    }

    public static boolean I(g0 g0Var, kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (g0Var == null) {
            a(32);
        }
        if (mVar == null) {
            a(33);
        }
        if (F(g0Var, mVar)) {
            return true;
        }
        Iterator<g0> it = g0Var.J0().b().iterator();
        while (it.hasNext()) {
            if (I(it.next(), mVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        return mVar != null && (mVar.b() instanceof l0);
    }

    public static boolean K(k1 k1Var, g0 g0Var) {
        if (k1Var == null) {
            a(66);
        }
        if (g0Var == null) {
            a(67);
        }
        if (k1Var.f0() || i0.a(g0Var)) {
            return false;
        }
        if (s1.b(g0Var)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.builtins.h hVarJ = ea.c.j(k1Var);
        if (!kotlin.reflect.jvm.internal.impl.builtins.h.s0(g0Var)) {
            kotlin.reflect.jvm.internal.impl.types.checker.e eVar = kotlin.reflect.jvm.internal.impl.types.checker.e.f14235a;
            if (!eVar.b(hVarJ.W(), g0Var) && !eVar.b(hVarJ.K().p(), g0Var) && !eVar.b(hVarJ.i(), g0Var) && !kotlin.reflect.jvm.internal.impl.builtins.o.d(g0Var)) {
                return false;
            }
        }
        return true;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> D L(D d10) {
        if (d10 == null) {
            a(59);
        }
        while (d10.g() == kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE) {
            Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collectionE = d10.e();
            if (collectionE.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d10);
            }
            d10 = (D) collectionE.iterator().next();
        }
        return d10;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.q> D M(D d10) {
        if (d10 == null) {
            a(64);
        }
        if (d10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) {
            return L((kotlin.reflect.jvm.internal.impl.descriptors.b) d10);
        }
        if (d10 == null) {
            a(65);
        }
        return d10;
    }

    public static boolean b(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar2) {
        if (mVar == null) {
            a(16);
        }
        if (mVar2 == null) {
            a(17);
        }
        return g(mVar).equals(g(mVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> void c(D d10, Set<D> set) {
        if (d10 == null) {
            a(73);
        }
        if (set == 0) {
            a(74);
        }
        if (set.contains(d10)) {
            return;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.a> it = d10.a().e().iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVarA = it.next().a();
            c(aVarA, set);
            set.add(aVarA);
        }
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> d(D d10) {
        if (d10 == null) {
            a(71);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(d10.a(), linkedHashSet);
        return linkedHashSet;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.e e(g0 g0Var) {
        if (g0Var == null) {
            a(45);
        }
        return f(g0Var.J0());
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.e f(g1 g1Var) {
        if (g1Var == null) {
            a(46);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = (kotlin.reflect.jvm.internal.impl.descriptors.e) g1Var.d();
        if (eVar == null) {
            a(47);
        }
        return eVar;
    }

    public static h0 g(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(21);
        }
        h0 h0VarH = h(mVar);
        if (h0VarH == null) {
            a(22);
        }
        return h0VarH;
    }

    public static h0 h(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(23);
        }
        while (mVar != null) {
            if (mVar instanceof h0) {
                return (h0) mVar;
            }
            if (mVar instanceof q0) {
                return ((q0) mVar).r0();
            }
            mVar = mVar.b();
        }
        return null;
    }

    public static h0 i(g0 g0Var) {
        if (g0Var == null) {
            a(20);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.h hVarD = g0Var.J0().d();
        if (hVarD == null) {
            return null;
        }
        return h(hVarD);
    }

    public static b1 j(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(82);
        }
        if (mVar instanceof w0) {
            mVar = ((w0) mVar).x0();
        }
        if (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.p) {
            b1 b1VarA = ((kotlin.reflect.jvm.internal.impl.descriptors.p) mVar).getSource().a();
            if (b1VarA == null) {
                a(83);
            }
            return b1VarA;
        }
        b1 b1Var = b1.f12738a;
        if (b1Var == null) {
            a(84);
        }
        return b1Var;
    }

    public static u k(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, boolean z10) {
        if (eVar == null) {
            a(48);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.f fVarG = eVar.g();
        if (fVarG == kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_CLASS || fVarG.f()) {
            u uVar = t.f13064a;
            if (uVar == null) {
                a(49);
            }
            return uVar;
        }
        if (G(eVar)) {
            if (z10) {
                u uVar2 = t.f13066c;
                if (uVar2 == null) {
                    a(50);
                }
                return uVar2;
            }
            u uVar3 = t.f13064a;
            if (uVar3 == null) {
                a(51);
            }
            return uVar3;
        }
        if (u(eVar)) {
            u uVar4 = t.f13075l;
            if (uVar4 == null) {
                a(52);
            }
            return uVar4;
        }
        u uVar5 = t.f13068e;
        if (uVar5 == null) {
            a(53);
        }
        return uVar5;
    }

    public static x0 l(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(0);
        }
        if (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar).F0();
        }
        return null;
    }

    public static ba.d m(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(2);
        }
        ba.c cVarO = o(mVar);
        return cVarO != null ? cVarO.j() : p(mVar);
    }

    public static ba.c n(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(3);
        }
        ba.c cVarO = o(mVar);
        if (cVarO == null) {
            cVarO = p(mVar).l();
        }
        if (cVarO == null) {
            a(4);
        }
        return cVarO;
    }

    private static ba.c o(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(5);
        }
        if ((mVar instanceof h0) || la.k.m(mVar)) {
            return ba.c.f927c;
        }
        if (mVar instanceof q0) {
            return ((q0) mVar).d();
        }
        if (mVar instanceof l0) {
            return ((l0) mVar).d();
        }
        return null;
    }

    private static ba.d p(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(6);
        }
        ba.d dVarC = m(mVar.b()).c(mVar.getName());
        if (dVarC == null) {
            a(7);
        }
        return dVarC;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.m> D q(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, Class<D> cls) {
        if (cls == null) {
            a(18);
        }
        return (D) r(mVar, cls, true);
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.m> D r(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, Class<D> cls, boolean z10) {
        if (cls == null) {
            a(19);
        }
        if (mVar == null) {
            return null;
        }
        if (z10) {
            mVar = (D) mVar.b();
        }
        while (mVar != null) {
            if (cls.isInstance(mVar)) {
                return (D) mVar;
            }
            mVar = (D) mVar.b();
        }
        return null;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.e s(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (eVar == null) {
            a(44);
        }
        Iterator<g0> it = eVar.h().b().iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.descriptors.e eVarE = e(it.next());
            if (eVarE.g() != kotlin.reflect.jvm.internal.impl.descriptors.f.INTERFACE) {
                return eVarE;
            }
        }
        return null;
    }

    public static boolean t(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        return D(mVar, kotlin.reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS);
    }

    public static boolean u(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar == null) {
            a(34);
        }
        return v(mVar) && mVar.getName().equals(ba.h.f943b);
    }

    public static boolean v(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        return D(mVar, kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS);
    }

    public static boolean x(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        return D(mVar, kotlin.reflect.jvm.internal.impl.descriptors.f.OBJECT) && ((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar).t();
    }

    public static boolean y(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        return (mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.q) && ((kotlin.reflect.jvm.internal.impl.descriptors.q) mVar).getVisibility() == t.f13069f;
    }

    public static boolean z(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar2) {
        if (eVar == null) {
            a(26);
        }
        if (eVar2 == null) {
            a(27);
        }
        Iterator<g0> it = eVar.h().b().iterator();
        while (it.hasNext()) {
            if (F(it.next(), eVar2.a())) {
                return true;
            }
        }
        return false;
    }

    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 21:
            case 23:
            case 24:
            case 34:
            case 35:
            case 36:
            case 57:
            case 58:
            case 59:
            case 61:
            case 64:
            case 82:
            case 95:
            case 97:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = "first";
                break;
            case 17:
                objArr[0] = "second";
                break;
            case 18:
            case 19:
                objArr[0] = "aClass";
                break;
            case 20:
                objArr[0] = "kotlinType";
                break;
            case 25:
                objArr[0] = "declarationDescriptor";
                break;
            case 26:
            case 28:
                objArr[0] = "subClass";
                break;
            case 27:
            case 29:
            case 33:
                objArr[0] = "superClass";
                break;
            case 30:
            case 32:
            case 45:
            case 67:
                objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                break;
            case 31:
                objArr[0] = TransactionPartnerType.OTHER;
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case 41:
            case 44:
            case 48:
            case 54:
            case 68:
            case 69:
            case 70:
            case 77:
            case 78:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case 55:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = "location";
                break;
            case 66:
                objArr[0] = "variable";
                break;
            case 71:
                objArr[0] = "f";
                break;
            case 73:
                objArr[0] = "current";
                break;
            case 74:
                objArr[0] = "result";
                break;
            case 75:
                objArr[0] = "memberDescriptor";
                break;
            case 79:
            case 80:
            case 81:
                objArr[0] = "annotated";
                break;
            case 85:
            case 87:
            case 90:
            case 92:
                objArr[0] = "scope";
                break;
            case 88:
            case 91:
            case 93:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i10) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case 22:
                objArr[1] = "getContainingModule";
                break;
            case 40:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 42:
            case 43:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 62:
            case 63:
                objArr[1] = "unwrapSubstitutionOverride";
                break;
            case 65:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 72:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 76:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 83:
            case 84:
                objArr[1] = "getContainingSourceFile";
                break;
            case 86:
                objArr[1] = "getAllDescriptors";
                break;
            case 89:
                objArr[1] = "getFunctionByName";
                break;
            case 94:
                objArr[1] = "getPropertyByName";
                break;
            case 96:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i10) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case 18:
            case 19:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case 23:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 21:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case 25:
                objArr[2] = "isAncestor";
                break;
            case 26:
            case 27:
                objArr[2] = "isDirectSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSubclass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case 35:
                objArr[2] = "isAnonymousFunction";
                break;
            case 36:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 41:
                objArr[2] = "getSuperClassType";
                break;
            case 44:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 61:
                objArr[2] = "unwrapSubstitutionOverride";
                break;
            case 64:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 66:
            case 67:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 68:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 69:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 70:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 71:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 73:
            case 74:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 75:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 77:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 78:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 79:
                objArr[2] = "getJvmName";
                break;
            case 80:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 81:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 82:
                objArr[2] = "getContainingSourceFile";
                break;
            case 85:
                objArr[2] = "getAllDescriptors";
                break;
            case 87:
            case 88:
                objArr[2] = "getFunctionByName";
                break;
            case 90:
            case 91:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 92:
            case 93:
                objArr[2] = "getPropertyByName";
                break;
            case 95:
                objArr[2] = "getDirectMember";
                break;
            case 97:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 63:
            case 65:
            case 72:
            case 76:
            case 83:
            case 84:
            case 86:
            case 89:
            case 94:
            case 96:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean w(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
        if (!v(mVar) && !A(mVar)) {
            return false;
        }
        return true;
    }
}
