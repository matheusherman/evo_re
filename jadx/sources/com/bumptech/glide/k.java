package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class k<TranscodeType> extends a0.a<k<TranscodeType>> implements Cloneable {
    protected static final a0.i O = new a0.i().g(l.j.f15050c).c0(h.LOW).k0(true);
    private final Context A;
    private final l B;
    private final Class<TranscodeType> C;
    private final c D;
    private final e E;

    @NonNull
    private m<?, ? super TranscodeType> F;

    @Nullable
    private Object G;

    @Nullable
    private List<a0.h<TranscodeType>> H;

    @Nullable
    private k<TranscodeType> I;

    @Nullable
    private k<TranscodeType> J;

    @Nullable
    private Float K;
    private boolean L = true;
    private boolean M;
    private boolean N;

    @NonNull
    public <Y extends b0.i<TranscodeType>> Y B0(@NonNull Y y10) {
        return (Y) D0(y10, null, e0.e.b());
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1343b;

        static {
            int[] iArr = new int[h.values().length];
            f1343b = iArr;
            try {
                iArr[h.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1343b[h.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1343b[h.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1343b[h.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f1342a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1342a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1342a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1342a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1342a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1342a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1342a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1342a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private a0.e L0(Object obj, b0.i<TranscodeType> iVar, a0.h<TranscodeType> hVar, a0.a<?> aVar, a0.f fVar, m<?, ? super TranscodeType> mVar, h hVar2, int i10, int i11, Executor executor) {
        Context context = this.A;
        e eVar = this.E;
        return a0.k.y(context, eVar, obj, this.G, this.C, aVar, i10, i11, hVar2, iVar, hVar, this.H, fVar, eVar.f(), mVar.c(), executor);
    }

    private k<TranscodeType> u0(k<TranscodeType> kVar) {
        return kVar.l0(this.A.getTheme()).i0(d0.a.c(this.A));
    }

    private a0.e v0(b0.i<TranscodeType> iVar, @Nullable a0.h<TranscodeType> hVar, a0.a<?> aVar, Executor executor) {
        return w0(new Object(), iVar, hVar, null, this.F, aVar.v(), aVar.s(), aVar.q(), aVar, executor);
    }

    private a0.e w0(Object obj, b0.i<TranscodeType> iVar, @Nullable a0.h<TranscodeType> hVar, @Nullable a0.f fVar, m<?, ? super TranscodeType> mVar, h hVar2, int i10, int i11, a0.a<?> aVar, Executor executor) {
        a0.b bVar;
        a0.f fVar2;
        if (this.J != null) {
            bVar = new a0.b(obj, fVar);
            fVar2 = bVar;
        } else {
            bVar = null;
            fVar2 = fVar;
        }
        a0.e eVarX0 = x0(obj, iVar, hVar, fVar2, mVar, hVar2, i10, i11, aVar, executor);
        if (bVar == null) {
            return eVarX0;
        }
        int iS = this.J.s();
        int iQ = this.J.q();
        if (e0.l.u(i10, i11) && !this.J.R()) {
            iS = aVar.s();
            iQ = aVar.q();
        }
        k<TranscodeType> kVar = this.J;
        a0.b bVar2 = bVar;
        bVar2.o(eVarX0, kVar.w0(obj, iVar, hVar, bVar2, kVar.F, kVar.v(), iS, iQ, this.J, executor));
        return bVar2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private a0.e x0(Object obj, b0.i<TranscodeType> iVar, a0.h<TranscodeType> hVar, @Nullable a0.f fVar, m<?, ? super TranscodeType> mVar, h hVar2, int i10, int i11, a0.a<?> aVar, Executor executor) {
        k<TranscodeType> kVar = this.I;
        if (kVar == null) {
            if (this.K == null) {
                return L0(obj, iVar, hVar, aVar, fVar, mVar, hVar2, i10, i11, executor);
            }
            a0.l lVar = new a0.l(obj, fVar);
            lVar.n(L0(obj, iVar, hVar, aVar, lVar, mVar, hVar2, i10, i11, executor), L0(obj, iVar, hVar, aVar.clone().j0(this.K.floatValue()), lVar, mVar, z0(hVar2), i10, i11, executor));
            return lVar;
        }
        if (this.N) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        m<?, ? super TranscodeType> mVar2 = kVar.L ? mVar : kVar.F;
        h hVarV = kVar.H() ? this.I.v() : z0(hVar2);
        int iS = this.I.s();
        int iQ = this.I.q();
        if (e0.l.u(i10, i11) && !this.I.R()) {
            iS = aVar.s();
            iQ = aVar.q();
        }
        a0.l lVar2 = new a0.l(obj, fVar);
        a0.e eVarL0 = L0(obj, iVar, hVar, aVar, lVar2, mVar, hVar2, i10, i11, executor);
        this.N = true;
        k<TranscodeType> kVar2 = this.I;
        a0.e eVarW0 = kVar2.w0(obj, iVar, hVar, lVar2, mVar2, hVarV, iS, iQ, kVar2, executor);
        this.N = false;
        lVar2.n(eVarL0, eVarW0);
        return lVar2;
    }

    @NonNull
    private h z0(@NonNull h hVar) {
        int i10 = a.f1343b[hVar.ordinal()];
        if (i10 == 1) {
            return h.NORMAL;
        }
        if (i10 == 2) {
            return h.HIGH;
        }
        if (i10 == 3 || i10 == 4) {
            return h.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + v());
    }

    @NonNull
    public a0.d<TranscodeType> M0() {
        return N0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public a0.d<TranscodeType> N0(int i10, int i11) {
        a0.g gVar = new a0.g(i10, i11);
        return (a0.d) D0(gVar, gVar, e0.e.a());
    }

    @Override // a0.a
    public boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (super.equals(kVar) && Objects.equals(this.C, kVar.C) && this.F.equals(kVar.F) && Objects.equals(this.G, kVar.G) && Objects.equals(this.H, kVar.H) && Objects.equals(this.I, kVar.I) && Objects.equals(this.J, kVar.J) && Objects.equals(this.K, kVar.K) && this.L == kVar.L && this.M == kVar.M) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"CheckResult"})
    protected k(@NonNull c cVar, l lVar, Class<TranscodeType> cls, Context context) {
        this.D = cVar;
        this.B = lVar;
        this.C = cls;
        this.A = context;
        this.F = lVar.r(cls);
        this.E = cVar.i();
        A0(lVar.p());
        a(lVar.q());
    }

    @SuppressLint({"CheckResult"})
    private void A0(List<a0.h<Object>> list) {
        Iterator<a0.h<Object>> it = list.iterator();
        while (it.hasNext()) {
            s0((a0.h) it.next());
        }
    }

    private <Y extends b0.i<TranscodeType>> Y C0(@NonNull Y y10, @Nullable a0.h<TranscodeType> hVar, a0.a<?> aVar, Executor executor) {
        e0.k.d(y10);
        if (this.M) {
            a0.e eVarV0 = v0(y10, hVar, aVar, executor);
            a0.e eVarL = y10.l();
            if (eVarV0.d(eVarL) && !F0(aVar, eVarL)) {
                if (!((a0.e) e0.k.d(eVarL)).isRunning()) {
                    eVarL.h();
                }
                return y10;
            }
            this.B.o(y10);
            y10.i(eVarV0);
            this.B.A(y10, eVarV0);
            return y10;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean F0(a0.a<?> aVar, a0.e eVar) {
        if (!aVar.G() && eVar.j()) {
            return true;
        }
        return false;
    }

    @NonNull
    private k<TranscodeType> K0(@Nullable Object obj) {
        if (F()) {
            return clone().K0(obj);
        }
        this.G = obj;
        this.M = true;
        return g0();
    }

    @NonNull
    <Y extends b0.i<TranscodeType>> Y D0(@NonNull Y y10, @Nullable a0.h<TranscodeType> hVar, Executor executor) {
        return (Y) C0(y10, hVar, this, executor);
    }

    @NonNull
    public b0.j<ImageView, TranscodeType> E0(@NonNull ImageView imageView) {
        a0.a aVarU;
        e0.l.b();
        e0.k.d(imageView);
        if (!Q() && N() && imageView.getScaleType() != null) {
            switch (a.f1342a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarU = clone().U();
                    break;
                case 2:
                    aVarU = clone().W();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarU = clone().X();
                    break;
                case 6:
                    aVarU = clone().W();
                    break;
                default:
                    aVarU = this;
                    break;
            }
        } else {
            aVarU = this;
        }
        return (b0.j) C0(this.E.a(imageView, this.C), null, aVarU, e0.e.b());
    }

    @NonNull
    @CheckResult
    public k<TranscodeType> G0(@Nullable Bitmap bitmap) {
        return K0(bitmap).a(a0.i.t0(l.j.f15049b));
    }

    @NonNull
    @CheckResult
    public k<TranscodeType> H0(@Nullable @DrawableRes @RawRes Integer num) {
        return u0(K0(num));
    }

    @NonNull
    @CheckResult
    public k<TranscodeType> I0(@Nullable Object obj) {
        return K0(obj);
    }

    @NonNull
    @CheckResult
    public k<TranscodeType> J0(@Nullable String str) {
        return K0(str);
    }

    @Override // a0.a
    public int hashCode() {
        return e0.l.q(this.M, e0.l.q(this.L, e0.l.p(this.K, e0.l.p(this.J, e0.l.p(this.I, e0.l.p(this.H, e0.l.p(this.G, e0.l.p(this.F, e0.l.p(this.C, super.hashCode())))))))));
    }

    @NonNull
    @CheckResult
    public k<TranscodeType> s0(@Nullable a0.h<TranscodeType> hVar) {
        if (F()) {
            return clone().s0(hVar);
        }
        if (hVar != null) {
            if (this.H == null) {
                this.H = new ArrayList();
            }
            this.H.add(hVar);
        }
        return g0();
    }

    @Override // a0.a
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public k<TranscodeType> a(@NonNull a0.a<?> aVar) {
        e0.k.d(aVar);
        return (k) super.a(aVar);
    }

    @Override // a0.a
    @CheckResult
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public k<TranscodeType> clone() {
        k<TranscodeType> kVar = (k) super.clone();
        kVar.F = kVar.F.clone();
        if (kVar.H != null) {
            kVar.H = new ArrayList(kVar.H);
        }
        k<TranscodeType> kVar2 = kVar.I;
        if (kVar2 != null) {
            kVar.I = kVar2.clone();
        }
        k<TranscodeType> kVar3 = kVar.J;
        if (kVar3 != null) {
            kVar.J = kVar3.clone();
        }
        return kVar;
    }
}
