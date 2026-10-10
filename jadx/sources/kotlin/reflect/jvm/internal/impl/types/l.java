package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l extends b implements g1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f14337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<kotlin.reflect.jvm.internal.impl.descriptors.f1> f14338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Collection<g0> f14339f;

    private static /* synthetic */ void v(int i10) {
        String str = (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i10 == 4) {
            objArr[1] = "getParameters";
        } else if (i10 == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i10 == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i10 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 4 && i10 != 5 && i10 != 6 && i10 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public boolean e() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, List<? extends kotlin.reflect.jvm.internal.impl.descriptors.f1> list, Collection<g0> collection, ka.n nVar) {
        super(nVar);
        if (eVar == null) {
            v(0);
        }
        if (list == null) {
            v(1);
        }
        if (collection == null) {
            v(2);
        }
        if (nVar == null) {
            v(3);
        }
        this.f14337d = eVar;
        this.f14338e = Collections.unmodifiableList(new ArrayList(list));
        this.f14339f = Collections.unmodifiableCollection(collection);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g1
    public List<kotlin.reflect.jvm.internal.impl.descriptors.f1> getParameters() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.f1> list = this.f14338e;
        if (list == null) {
            v(4);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g
    protected Collection<g0> m() {
        Collection<g0> collection = this.f14339f;
        if (collection == null) {
            v(6);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g
    protected kotlin.reflect.jvm.internal.impl.descriptors.d1 q() {
        kotlin.reflect.jvm.internal.impl.descriptors.d1.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.d1.a.f12742a;
        if (aVar == null) {
            v(7);
        }
        return aVar;
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.resolve.e.m(this.f14337d).b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.m, kotlin.reflect.jvm.internal.impl.types.g1
    /* JADX INFO: renamed from: w */
    public kotlin.reflect.jvm.internal.impl.descriptors.e d() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = this.f14337d;
        if (eVar == null) {
            v(5);
        }
        return eVar;
    }
}
