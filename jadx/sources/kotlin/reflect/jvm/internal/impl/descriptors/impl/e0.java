package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.types.o0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e0 extends b0 implements w0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private j1 f12833m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final w0 f12834n;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends w0> e() {
        Collection<t0> collectionH0 = super.H0(false);
        if (collectionH0 == null) {
            C(10);
        }
        return collectionH0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(u0 u0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, boolean z10, boolean z11, boolean z12, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, w0 w0Var, a1 a1Var) {
        super(e0Var, uVar, u0Var, gVar, ba.f.o("<set-" + u0Var.getName() + ">"), z10, z11, z12, aVar, a1Var);
        if (u0Var == null) {
            C(0);
        }
        if (gVar == null) {
            C(1);
        }
        if (e0Var == null) {
            C(2);
        }
        if (uVar == null) {
            C(3);
        }
        if (aVar == null) {
            C(4);
        }
        if (a1Var == null) {
            C(5);
        }
        this.f12834n = w0Var != null ? w0Var : this;
    }

    public static l0 L0(w0 w0Var, kotlin.reflect.jvm.internal.impl.types.g0 g0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        if (w0Var == null) {
            C(7);
        }
        if (g0Var == null) {
            C(8);
        }
        if (gVar == null) {
            C(9);
        }
        return new l0(w0Var, null, 0, gVar, ba.h.f956o, g0Var, false, false, false, null, a1.f12668a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.b0, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public w0 a() {
        w0 w0Var = this.f12834n;
        if (w0Var == null) {
            C(13);
        }
        return w0Var;
    }

    public void N0(j1 j1Var) {
        if (j1Var == null) {
            C(6);
        }
        this.f12833m = j1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<j1> f() {
        j1 j1Var = this.f12833m;
        if (j1Var == null) {
            throw new IllegalStateException();
        }
        List<j1> listSingletonList = Collections.singletonList(j1Var);
        if (listSingletonList == null) {
            C(11);
        }
        return listSingletonList;
    }

    private static /* synthetic */ void C(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                i11 = 2;
                break;
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 9:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = IjkMediaMeta.IJKM_KEY_TYPE;
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i10) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i10) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R H(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d10) {
        return oVar.i(this, d10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.jvm.internal.impl.types.g0 getReturnType() {
        o0 o0VarZ = ea.c.j(this).Z();
        if (o0VarZ == null) {
            C(12);
        }
        return o0VarZ;
    }
}
