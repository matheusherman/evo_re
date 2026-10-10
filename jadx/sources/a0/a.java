package a0;

import a0.a;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.color.utilities.Contrast;
import j.m;
import java.util.Map;
import s.n;
import s.v;
import s.x;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public abstract class a<T extends a<T>> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Drawable f10e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Drawable f12g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f18m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private Drawable f20o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f21p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f25t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private Resources.Theme f26u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f27v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f28w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f29x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f31z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private l.j f8c = l.j.f15052e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private com.bumptech.glide.h f9d = com.bumptech.glide.h.NORMAL;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f15j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f16k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    private j.f f17l = d0.c.c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f19n = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    private j.i f22q = new j.i();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    private Map<Class<?>, m<?>> f23r = new e0.b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private Class<?> f24s = Object.class;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f30y = true;

    private static boolean L(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    @NonNull
    private T Y(@NonNull n nVar, @NonNull m<Bitmap> mVar) {
        return (T) e0(nVar, mVar, false);
    }

    @NonNull
    public T T() {
        this.f25t = true;
        return (T) f0();
    }

    @NonNull
    @CheckResult
    public T m0(@NonNull m<Bitmap> mVar) {
        return (T) n0(mVar, true);
    }

    @NonNull
    @CheckResult
    public T q0(@NonNull m<Bitmap>... mVarArr) {
        if (mVarArr.length > 1) {
            return (T) n0(new j.g(mVarArr), true);
        }
        return mVarArr.length == 1 ? (T) m0(mVarArr[0]) : (T) g0();
    }

    private boolean K(int i10) {
        return L(this.f6a, i10);
    }

    @NonNull
    private T e0(@NonNull n nVar, @NonNull m<Bitmap> mVar, boolean z10) {
        T t10 = z10 ? (T) p0(nVar, mVar) : (T) Z(nVar, mVar);
        t10.f30y = true;
        return t10;
    }

    @Nullable
    public final Resources.Theme A() {
        return this.f26u;
    }

    @NonNull
    public final Map<Class<?>, m<?>> C() {
        return this.f23r;
    }

    public final boolean D() {
        return this.f31z;
    }

    public final boolean E() {
        return this.f28w;
    }

    protected final boolean F() {
        return this.f27v;
    }

    public final boolean G() {
        return this.f14i;
    }

    public final boolean H() {
        return K(8);
    }

    boolean I() {
        return this.f30y;
    }

    public final boolean N() {
        return this.f19n;
    }

    public final boolean O() {
        return this.f18m;
    }

    public final boolean Q() {
        return K(2048);
    }

    public final boolean R() {
        return e0.l.u(this.f16k, this.f15j);
    }

    @NonNull
    @CheckResult
    public T U() {
        return (T) Z(n.f18188e, new s.k());
    }

    @NonNull
    @CheckResult
    public T W() {
        return (T) Y(n.f18187d, new s.l());
    }

    @NonNull
    @CheckResult
    public T X() {
        return (T) Y(n.f18186c, new x());
    }

    @NonNull
    final T Z(@NonNull n nVar, @NonNull m<Bitmap> mVar) {
        if (this.f27v) {
            return (T) clone().Z(nVar, mVar);
        }
        h(nVar);
        return (T) n0(mVar, false);
    }

    @NonNull
    @CheckResult
    public T a(@NonNull a<?> aVar) {
        if (this.f27v) {
            return (T) clone().a(aVar);
        }
        if (L(aVar.f6a, 2)) {
            this.f7b = aVar.f7b;
        }
        if (L(aVar.f6a, 262144)) {
            this.f28w = aVar.f28w;
        }
        if (L(aVar.f6a, 1048576)) {
            this.f31z = aVar.f31z;
        }
        if (L(aVar.f6a, 4)) {
            this.f8c = aVar.f8c;
        }
        if (L(aVar.f6a, 8)) {
            this.f9d = aVar.f9d;
        }
        if (L(aVar.f6a, 16)) {
            this.f10e = aVar.f10e;
            this.f11f = 0;
            this.f6a &= -33;
        }
        if (L(aVar.f6a, 32)) {
            this.f11f = aVar.f11f;
            this.f10e = null;
            this.f6a &= -17;
        }
        if (L(aVar.f6a, 64)) {
            this.f12g = aVar.f12g;
            this.f13h = 0;
            this.f6a &= -129;
        }
        if (L(aVar.f6a, 128)) {
            this.f13h = aVar.f13h;
            this.f12g = null;
            this.f6a &= -65;
        }
        if (L(aVar.f6a, 256)) {
            this.f14i = aVar.f14i;
        }
        if (L(aVar.f6a, 512)) {
            this.f16k = aVar.f16k;
            this.f15j = aVar.f15j;
        }
        if (L(aVar.f6a, 1024)) {
            this.f17l = aVar.f17l;
        }
        if (L(aVar.f6a, 4096)) {
            this.f24s = aVar.f24s;
        }
        if (L(aVar.f6a, 8192)) {
            this.f20o = aVar.f20o;
            this.f21p = 0;
            this.f6a &= -16385;
        }
        if (L(aVar.f6a, 16384)) {
            this.f21p = aVar.f21p;
            this.f20o = null;
            this.f6a &= -8193;
        }
        if (L(aVar.f6a, 32768)) {
            this.f26u = aVar.f26u;
        }
        if (L(aVar.f6a, 65536)) {
            this.f19n = aVar.f19n;
        }
        if (L(aVar.f6a, 131072)) {
            this.f18m = aVar.f18m;
        }
        if (L(aVar.f6a, 2048)) {
            this.f23r.putAll(aVar.f23r);
            this.f30y = aVar.f30y;
        }
        if (L(aVar.f6a, 524288)) {
            this.f29x = aVar.f29x;
        }
        if (!this.f19n) {
            this.f23r.clear();
            int i10 = this.f6a;
            this.f18m = false;
            this.f6a = i10 & (-133121);
            this.f30y = true;
        }
        this.f6a |= aVar.f6a;
        this.f22q.d(aVar.f22q);
        return (T) g0();
    }

    @NonNull
    @CheckResult
    public T a0(int i10, int i11) {
        if (this.f27v) {
            return (T) clone().a0(i10, i11);
        }
        this.f16k = i10;
        this.f15j = i11;
        this.f6a |= 512;
        return (T) g0();
    }

    @NonNull
    @CheckResult
    public T b0(@DrawableRes int i10) {
        if (this.f27v) {
            return (T) clone().b0(i10);
        }
        this.f13h = i10;
        int i11 = this.f6a | 128;
        this.f12g = null;
        this.f6a = i11 & (-65);
        return (T) g0();
    }

    @NonNull
    public T c() {
        if (this.f25t && !this.f27v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f27v = true;
        return (T) T();
    }

    @NonNull
    @CheckResult
    public T c0(@NonNull com.bumptech.glide.h hVar) {
        if (this.f27v) {
            return (T) clone().c0(hVar);
        }
        this.f9d = (com.bumptech.glide.h) e0.k.d(hVar);
        this.f6a |= 8;
        return (T) g0();
    }

    T d0(@NonNull j.h<?> hVar) {
        if (this.f27v) {
            return (T) clone().d0(hVar);
        }
        this.f22q.e(hVar);
        return (T) g0();
    }

    @NonNull
    @CheckResult
    public T e(@NonNull Class<?> cls) {
        if (this.f27v) {
            return (T) clone().e(cls);
        }
        this.f24s = (Class) e0.k.d(cls);
        this.f6a |= 4096;
        return (T) g0();
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (Float.compare(aVar.f7b, this.f7b) == 0 && this.f11f == aVar.f11f && e0.l.d(this.f10e, aVar.f10e) && this.f13h == aVar.f13h && e0.l.d(this.f12g, aVar.f12g) && this.f21p == aVar.f21p && e0.l.d(this.f20o, aVar.f20o) && this.f14i == aVar.f14i && this.f15j == aVar.f15j && this.f16k == aVar.f16k && this.f18m == aVar.f18m && this.f19n == aVar.f19n && this.f28w == aVar.f28w && this.f29x == aVar.f29x && this.f8c.equals(aVar.f8c) && this.f9d == aVar.f9d && this.f22q.equals(aVar.f22q) && this.f23r.equals(aVar.f23r) && this.f24s.equals(aVar.f24s) && e0.l.d(this.f17l, aVar.f17l) && e0.l.d(this.f26u, aVar.f26u)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @CheckResult
    public T g(@NonNull l.j jVar) {
        if (this.f27v) {
            return (T) clone().g(jVar);
        }
        this.f8c = (l.j) e0.k.d(jVar);
        this.f6a |= 4;
        return (T) g0();
    }

    @NonNull
    protected final T g0() {
        if (this.f25t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) f0();
    }

    @NonNull
    @CheckResult
    public T h(@NonNull n nVar) {
        return (T) h0(n.f18191h, e0.k.d(nVar));
    }

    @NonNull
    @CheckResult
    public <Y> T h0(@NonNull j.h<Y> hVar, @NonNull Y y10) {
        if (this.f27v) {
            return (T) clone().h0(hVar, y10);
        }
        e0.k.d(hVar);
        e0.k.d(y10);
        this.f22q.f(hVar, y10);
        return (T) g0();
    }

    public int hashCode() {
        return e0.l.p(this.f26u, e0.l.p(this.f17l, e0.l.p(this.f24s, e0.l.p(this.f23r, e0.l.p(this.f22q, e0.l.p(this.f9d, e0.l.p(this.f8c, e0.l.q(this.f29x, e0.l.q(this.f28w, e0.l.q(this.f19n, e0.l.q(this.f18m, e0.l.o(this.f16k, e0.l.o(this.f15j, e0.l.q(this.f14i, e0.l.p(this.f20o, e0.l.o(this.f21p, e0.l.p(this.f12g, e0.l.o(this.f13h, e0.l.p(this.f10e, e0.l.o(this.f11f, e0.l.l(this.f7b)))))))))))))))))))));
    }

    @NonNull
    @CheckResult
    public T i(@DrawableRes int i10) {
        if (this.f27v) {
            return (T) clone().i(i10);
        }
        this.f11f = i10;
        int i11 = this.f6a | 32;
        this.f10e = null;
        this.f6a = i11 & (-17);
        return (T) g0();
    }

    @NonNull
    @CheckResult
    public T i0(@NonNull j.f fVar) {
        if (this.f27v) {
            return (T) clone().i0(fVar);
        }
        this.f17l = (j.f) e0.k.d(fVar);
        this.f6a |= 1024;
        return (T) g0();
    }

    @NonNull
    public final l.j j() {
        return this.f8c;
    }

    @NonNull
    @CheckResult
    public T j0(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f10) {
        if (this.f27v) {
            return (T) clone().j0(f10);
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f7b = f10;
        this.f6a |= 2;
        return (T) g0();
    }

    public final int k() {
        return this.f11f;
    }

    @NonNull
    @CheckResult
    public T k0(boolean z10) {
        if (this.f27v) {
            return (T) clone().k0(true);
        }
        this.f14i = !z10;
        this.f6a |= 256;
        return (T) g0();
    }

    @Nullable
    public final Drawable l() {
        return this.f10e;
    }

    @NonNull
    @CheckResult
    public T l0(@Nullable Resources.Theme theme) {
        if (this.f27v) {
            return (T) clone().l0(theme);
        }
        this.f26u = theme;
        if (theme != null) {
            this.f6a |= 32768;
            return (T) h0(u.k.f19308b, theme);
        }
        this.f6a &= -32769;
        return (T) d0(u.k.f19308b);
    }

    @Nullable
    public final Drawable m() {
        return this.f20o;
    }

    public final int n() {
        return this.f21p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T n0(@NonNull m<Bitmap> mVar, boolean z10) {
        if (this.f27v) {
            return (T) clone().n0(mVar, z10);
        }
        v vVar = new v(mVar, z10);
        o0(Bitmap.class, mVar, z10);
        o0(Drawable.class, vVar, z10);
        o0(BitmapDrawable.class, vVar.c(), z10);
        o0(w.c.class, new w.f(mVar), z10);
        return (T) g0();
    }

    public final boolean o() {
        return this.f29x;
    }

    @NonNull
    <Y> T o0(@NonNull Class<Y> cls, @NonNull m<Y> mVar, boolean z10) {
        if (this.f27v) {
            return (T) clone().o0(cls, mVar, z10);
        }
        e0.k.d(cls);
        e0.k.d(mVar);
        this.f23r.put(cls, mVar);
        int i10 = this.f6a;
        this.f19n = true;
        this.f6a = 67584 | i10;
        this.f30y = false;
        if (z10) {
            this.f6a = i10 | 198656;
            this.f18m = true;
        }
        return (T) g0();
    }

    @NonNull
    public final j.i p() {
        return this.f22q;
    }

    @NonNull
    @CheckResult
    final T p0(@NonNull n nVar, @NonNull m<Bitmap> mVar) {
        if (this.f27v) {
            return (T) clone().p0(nVar, mVar);
        }
        h(nVar);
        return (T) m0(mVar);
    }

    public final int q() {
        return this.f15j;
    }

    @NonNull
    @CheckResult
    public T r0(boolean z10) {
        if (this.f27v) {
            return (T) clone().r0(z10);
        }
        this.f31z = z10;
        this.f6a |= 1048576;
        return (T) g0();
    }

    public final int s() {
        return this.f16k;
    }

    @Nullable
    public final Drawable t() {
        return this.f12g;
    }

    public final int u() {
        return this.f13h;
    }

    @NonNull
    public final com.bumptech.glide.h v() {
        return this.f9d;
    }

    @NonNull
    public final Class<?> x() {
        return this.f24s;
    }

    @NonNull
    public final j.f y() {
        return this.f17l;
    }

    public final float z() {
        return this.f7b;
    }

    @Override // 
    @CheckResult
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public T clone() {
        try {
            T t10 = (T) super.clone();
            j.i iVar = new j.i();
            t10.f22q = iVar;
            iVar.d(this.f22q);
            e0.b bVar = new e0.b();
            t10.f23r = bVar;
            bVar.putAll(this.f23r);
            t10.f25t = false;
            t10.f27v = false;
            return t10;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    private T f0() {
        return this;
    }
}
