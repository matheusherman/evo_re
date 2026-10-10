package y0;

import android.graphics.Bitmap;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.common.base.k;
import k0.d;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f22271r = new b().h("").a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final k0.a<a> f22272s = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final CharSequence f22273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Layout.Alignment f22274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Layout.Alignment f22275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Bitmap f22276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f22277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f22278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f22279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f22280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f22281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f22282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f22283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f22284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f22285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f22286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f22287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f22288p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float f22289q;

    /* JADX INFO: renamed from: y0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class C0477a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private CharSequence f22290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private Bitmap f22291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Layout.Alignment f22292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private Layout.Alignment f22293d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f22294e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f22295f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f22296g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f22297h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f22298i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f22299j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f22300k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private float f22301l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private float f22302m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f22303n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @ColorInt
        private int f22304o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f22305p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private float f22306q;

        /* synthetic */ b(a aVar, C0477a c0477a) {
            this(aVar);
        }

        public b b() {
            this.f22303n = false;
            return this;
        }

        public b() {
            this.f22290a = null;
            this.f22291b = null;
            this.f22292c = null;
            this.f22293d = null;
            this.f22294e = -3.4028235E38f;
            this.f22295f = Integer.MIN_VALUE;
            this.f22296g = Integer.MIN_VALUE;
            this.f22297h = -3.4028235E38f;
            this.f22298i = Integer.MIN_VALUE;
            this.f22299j = Integer.MIN_VALUE;
            this.f22300k = -3.4028235E38f;
            this.f22301l = -3.4028235E38f;
            this.f22302m = -3.4028235E38f;
            this.f22303n = false;
            this.f22304o = ViewCompat.MEASURED_STATE_MASK;
            this.f22305p = Integer.MIN_VALUE;
        }

        public a a() {
            return new a(this.f22290a, this.f22292c, this.f22293d, this.f22291b, this.f22294e, this.f22295f, this.f22296g, this.f22297h, this.f22298i, this.f22299j, this.f22300k, this.f22301l, this.f22302m, this.f22303n, this.f22304o, this.f22305p, this.f22306q, null);
        }

        @Nullable
        public CharSequence c() {
            return this.f22290a;
        }

        public b d(float f10, int i10) {
            this.f22294e = f10;
            this.f22295f = i10;
            return this;
        }

        public b e(int i10) {
            this.f22296g = i10;
            return this;
        }

        public b f(float f10) {
            this.f22297h = f10;
            return this;
        }

        public b g(int i10) {
            this.f22298i = i10;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f22290a = charSequence;
            return this;
        }

        public b i(@Nullable Layout.Alignment alignment) {
            this.f22292c = alignment;
            return this;
        }

        public b j(float f10, int i10) {
            this.f22300k = f10;
            this.f22299j = i10;
            return this;
        }

        private b(a aVar) {
            this.f22290a = aVar.f22273a;
            this.f22291b = aVar.f22276d;
            this.f22292c = aVar.f22274b;
            this.f22293d = aVar.f22275c;
            this.f22294e = aVar.f22277e;
            this.f22295f = aVar.f22278f;
            this.f22296g = aVar.f22279g;
            this.f22297h = aVar.f22280h;
            this.f22298i = aVar.f22281i;
            this.f22299j = aVar.f22286n;
            this.f22300k = aVar.f22287o;
            this.f22301l = aVar.f22282j;
            this.f22302m = aVar.f22283k;
            this.f22303n = aVar.f22284l;
            this.f22304o = aVar.f22285m;
            this.f22305p = aVar.f22288p;
            this.f22306q = aVar.f22289q;
        }
    }

    /* synthetic */ a(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f10, int i10, int i11, float f11, int i12, int i13, float f12, float f13, float f14, boolean z10, int i14, int i15, float f15, C0477a c0477a) {
        this(charSequence, alignment, alignment2, bitmap, f10, i10, i11, f11, i12, i13, f12, f13, f14, z10, i14, i15, f15);
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (TextUtils.equals(this.f22273a, aVar.f22273a) && this.f22274b == aVar.f22274b && this.f22275c == aVar.f22275c && ((bitmap = this.f22276d) != null ? !((bitmap2 = aVar.f22276d) == null || !bitmap.sameAs(bitmap2)) : aVar.f22276d == null) && this.f22277e == aVar.f22277e && this.f22278f == aVar.f22278f && this.f22279g == aVar.f22279g && this.f22280h == aVar.f22280h && this.f22281i == aVar.f22281i && this.f22282j == aVar.f22282j && this.f22283k == aVar.f22283k && this.f22284l == aVar.f22284l && this.f22285m == aVar.f22285m && this.f22286n == aVar.f22286n && this.f22287o == aVar.f22287o && this.f22288p == aVar.f22288p && this.f22289q == aVar.f22289q) {
                return true;
            }
        }
        return false;
    }

    private a(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Layout.Alignment alignment2, @Nullable Bitmap bitmap, float f10, int i10, int i11, float f11, int i12, int i13, float f12, float f13, float f14, boolean z10, int i14, int i15, float f15) {
        if (charSequence == null) {
            d1.a.b(bitmap);
        } else {
            d1.a.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f22273a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f22273a = charSequence.toString();
        } else {
            this.f22273a = null;
        }
        this.f22274b = alignment;
        this.f22275c = alignment2;
        this.f22276d = bitmap;
        this.f22277e = f10;
        this.f22278f = i10;
        this.f22279g = i11;
        this.f22280h = f11;
        this.f22281i = i12;
        this.f22282j = f13;
        this.f22283k = f14;
        this.f22284l = z10;
        this.f22285m = i14;
        this.f22286n = i13;
        this.f22287o = f12;
        this.f22288p = i15;
        this.f22289q = f15;
    }

    public b a() {
        return new b(this, null);
    }

    public int hashCode() {
        return k.b(this.f22273a, this.f22274b, this.f22275c, this.f22276d, Float.valueOf(this.f22277e), Integer.valueOf(this.f22278f), Integer.valueOf(this.f22279g), Float.valueOf(this.f22280h), Integer.valueOf(this.f22281i), Float.valueOf(this.f22282j), Float.valueOf(this.f22283k), Boolean.valueOf(this.f22284l), Integer.valueOf(this.f22285m), Integer.valueOf(this.f22286n), Float.valueOf(this.f22287o), Integer.valueOf(this.f22288p), Float.valueOf(this.f22289q));
    }
}
