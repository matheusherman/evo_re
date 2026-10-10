package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.g1;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final g1 f12865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f12866j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ka.i<Set<ba.f>> f12867k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f12868l;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a extends kotlin.reflect.jvm.internal.impl.resolve.scopes.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ka.g<ba.f, Collection<? extends z0>> f12869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ka.g<ba.f, Collection<? extends u0>> f12870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ka.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.m>> f12871d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ n f12872e;

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0221a implements c9.l<ba.f, Collection<? extends z0>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f12873a;

            C0221a(n nVar) {
                this.f12873a = nVar;
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<? extends z0> invoke(ba.f fVar) {
                return a.this.m(fVar);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class b implements c9.l<ba.f, Collection<? extends u0>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f12875a;

            b(n nVar) {
                this.f12875a = nVar;
            }

            @Override // c9.l
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<? extends u0> invoke(ba.f fVar) {
                return a.this.n(fVar);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class c implements c9.a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.m>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f12877a;

            c(n nVar) {
                this.f12877a = nVar;
            }

            @Override // c9.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> invoke() {
                return a.this.l();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class d extends kotlin.reflect.jvm.internal.impl.resolve.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Set f12879a;

            private static /* synthetic */ void f(int i10) {
                Object[] objArr = new Object[3];
                if (i10 == 1) {
                    objArr[0] = "fromSuper";
                } else if (i10 != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i10 == 1 || i10 == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            d(Set set) {
                this.f12879a = set;
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.j
            public void a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
                if (bVar == null) {
                    f(0);
                }
                kotlin.reflect.jvm.internal.impl.resolve.k.K(bVar, null);
                this.f12879a.add(bVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.i
            protected void e(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar2) {
                if (bVar == null) {
                    f(1);
                }
                if (bVar2 == null) {
                    f(2);
                }
            }
        }

        public a(n nVar, ka.n nVar2) {
            if (nVar2 == null) {
                h(0);
            }
            this.f12872e = nVar;
            this.f12869b = nVar2.f(new C0221a(nVar));
            this.f12870c = nVar2.f(new b(nVar));
            this.f12871d = nVar2.c(new c(nVar));
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0024  */
        /* JADX WARN: Code duplicated, block: B:9:0x0014  */
        private static /* synthetic */ void h(int i10) {
            String str;
            int i11;
            if (i10 != 3 && i10 != 7 && i10 != 9 && i10 != 12) {
                switch (i10) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i10 != 3 && i10 != 7 && i10 != 9 && i10 != 12) {
                switch (i10) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        i11 = 2;
                        break;
                    default:
                        i11 = 3;
                        break;
                }
            } else {
                i11 = 2;
            }
            Object[] objArr = new Object[i11];
            switch (i10) {
                case 1:
                case 4:
                case 5:
                case 8:
                case 10:
                    objArr[0] = "name";
                    break;
                case 2:
                case 6:
                    objArr[0] = "location";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                    break;
                case 11:
                    objArr[0] = "fromSupertypes";
                    break;
                case 13:
                    objArr[0] = "kindFilter";
                    break;
                case 14:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i10 == 3) {
                objArr[1] = "getContributedVariables";
            } else if (i10 == 7) {
                objArr[1] = "getContributedFunctions";
            } else if (i10 == 9) {
                objArr[1] = "getSupertypeScope";
            } else if (i10 != 12) {
                switch (i10) {
                    case 15:
                        objArr[1] = "getContributedDescriptors";
                        break;
                    case 16:
                        objArr[1] = "computeAllDeclarations";
                        break;
                    case 17:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 18:
                        objArr[1] = "getClassifierNames";
                        break;
                    case 19:
                        objArr[1] = "getVariableNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                        break;
                }
            } else {
                objArr[1] = "resolveFakeOverrides";
            }
            switch (i10) {
                case 1:
                case 2:
                    objArr[2] = "getContributedVariables";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                case 4:
                    objArr[2] = "computeProperties";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 8:
                    objArr[2] = "computeFunctions";
                    break;
                case 10:
                case 11:
                    objArr[2] = "resolveFakeOverrides";
                    break;
                case 13:
                case 14:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i10 != 3 && i10 != 7 && i10 != 9 && i10 != 12) {
                switch (i10) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> l() {
            HashSet hashSet = new HashSet();
            for (ba.f fVar : (Set) this.f12872e.f12867k.invoke()) {
                r9.d dVar = r9.d.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(c(fVar, dVar));
                hashSet.addAll(a(fVar, dVar));
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection<? extends z0> m(ba.f fVar) {
            if (fVar == null) {
                h(8);
            }
            return p(fVar, o().c(fVar, r9.d.FOR_NON_TRACKED_SCOPE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Collection<? extends u0> n(ba.f fVar) {
            if (fVar == null) {
                h(4);
            }
            return p(fVar, o().a(fVar, r9.d.FOR_NON_TRACKED_SCOPE));
        }

        private kotlin.reflect.jvm.internal.impl.resolve.scopes.h o() {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarN = this.f12872e.h().b().iterator().next().n();
            if (hVarN == null) {
                h(9);
            }
            return hVarN;
        }

        private <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> Collection<? extends D> p(ba.f fVar, Collection<? extends D> collection) {
            if (fVar == null) {
                h(10);
            }
            if (collection == null) {
                h(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            kotlin.reflect.jvm.internal.impl.resolve.k.f13933f.v(fVar, collection, Collections.EMPTY_SET, this.f12872e, new d(linkedHashSet));
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Collection<? extends u0> a(ba.f fVar, r9.b bVar) {
            if (fVar == null) {
                h(1);
            }
            if (bVar == null) {
                h(2);
            }
            Collection<? extends u0> collectionInvoke = this.f12870c.invoke(fVar);
            if (collectionInvoke == null) {
                h(3);
            }
            return collectionInvoke;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Set<ba.f> b() {
            Set<ba.f> set = (Set) this.f12872e.f12867k.invoke();
            if (set == null) {
                h(17);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Collection<? extends z0> c(ba.f fVar, r9.b bVar) {
            if (fVar == null) {
                h(5);
            }
            if (bVar == null) {
                h(6);
            }
            Collection<? extends z0> collectionInvoke = this.f12869b.invoke(fVar);
            if (collectionInvoke == null) {
                h(7);
            }
            return collectionInvoke;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Set<ba.f> d() {
            Set<ba.f> set = (Set) this.f12872e.f12867k.invoke();
            if (set == null) {
                h(19);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        public Set<ba.f> f() {
            Set<ba.f> set = Collections.EMPTY_SET;
            if (set == null) {
                h(18);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> g(kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, c9.l<? super ba.f, Boolean> lVar) {
            if (dVar == null) {
                h(13);
            }
            if (lVar == null) {
                h(14);
            }
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.m> collectionInvoke = this.f12871d.invoke();
            if (collectionInvoke == null) {
                h(15);
            }
            return collectionInvoke;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean A0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean E0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean F() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d0
    public boolean I() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean J() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.d M() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e P() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean t() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public h1<o0> v0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean x() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private n(ka.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, ba.f fVar, ka.i<Set<ba.f>> iVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, a1 a1Var) {
        super(nVar, eVar, fVar, a1Var, false);
        if (nVar == null) {
            w0(6);
        }
        if (eVar == null) {
            w0(7);
        }
        if (g0Var == null) {
            w0(8);
        }
        if (fVar == null) {
            w0(9);
        }
        if (iVar == null) {
            w0(10);
        }
        if (gVar == null) {
            w0(11);
        }
        if (a1Var == null) {
            w0(12);
        }
        this.f12868l = gVar;
        this.f12865i = new kotlin.reflect.jvm.internal.impl.types.l(this, Collections.EMPTY_LIST, Collections.singleton(g0Var), nVar);
        this.f12866j = new a(this, nVar);
        this.f12867k = iVar;
    }

    public static n H0(ka.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, ba.f fVar, ka.i<Set<ba.f>> iVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, a1 a1Var) {
        if (nVar == null) {
            w0(0);
        }
        if (eVar == null) {
            w0(1);
        }
        if (fVar == null) {
            w0(2);
        }
        if (iVar == null) {
            w0(3);
        }
        if (gVar == null) {
            w0(4);
        }
        if (a1Var == null) {
            w0(5);
        }
        return new n(nVar, eVar, eVar.p(), fVar, iVar, gVar, a1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> E() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            w0(23);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h G(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            w0(13);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = this.f12866j;
        if (hVar == null) {
            w0(14);
        }
        return hVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h N() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b bVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.h.b.f14005b;
        if (bVar == null) {
            w0(15);
        }
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f g() {
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar = kotlin.reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY;
        if (fVar == null) {
            w0(18);
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar = this.f12868l;
        if (gVar == null) {
            w0(21);
        }
        return gVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = kotlin.reflect.jvm.internal.impl.descriptors.t.f13068e;
        if (uVar == null) {
            w0(20);
        }
        return uVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public g1 h() {
        g1 g1Var = this.f12865i;
        if (g1Var == null) {
            w0(17);
        }
        return g1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.d0
    public kotlin.reflect.jvm.internal.impl.descriptors.e0 i() {
        kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var = kotlin.reflect.jvm.internal.impl.descriptors.e0.FINAL;
        if (e0Var == null) {
            w0(19);
        }
        return e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            w0(16);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<f1> r() {
        List<f1> list = Collections.EMPTY_LIST;
        if (list == null) {
            w0(22);
        }
        return list;
    }

    public String toString() {
        return "enum entry " + getName();
    }

    private static /* synthetic */ void w0(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i10) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i10) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }
}
