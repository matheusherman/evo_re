package s0;

import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import d1.k;
import java.util.Arrays;
import k0.d;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f18234g = new a(null, new C0350a[0], 0, -9223372036854775807L, 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final C0350a f18235h = new C0350a(0).c(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k0.a<a> f18236i = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f18237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f18240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f18241e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final C0350a[] f18242f;

    /* JADX INFO: renamed from: s0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0350a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final k0.a<C0350a> f18243h = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri[] f18246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f18247d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long[] f18248e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f18249f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f18250g;

        public C0350a(long j10) {
            this(j10, -1, new int[0], new Uri[0], new long[0], 0L, false);
        }

        @CheckResult
        private static long[] a(long[] jArr, int i10) {
            int length = jArr.length;
            int iMax = Math.max(i10, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }

        @CheckResult
        private static int[] b(int[] iArr, int i10) {
            int length = iArr.length;
            int iMax = Math.max(i10, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C0350a.class == obj.getClass()) {
                C0350a c0350a = (C0350a) obj;
                if (this.f18244a == c0350a.f18244a && this.f18245b == c0350a.f18245b && Arrays.equals(this.f18246c, c0350a.f18246c) && Arrays.equals(this.f18247d, c0350a.f18247d) && Arrays.equals(this.f18248e, c0350a.f18248e) && this.f18249f == c0350a.f18249f && this.f18250g == c0350a.f18250g) {
                    return true;
                }
            }
            return false;
        }

        private C0350a(long j10, int i10, int[] iArr, Uri[] uriArr, long[] jArr, long j11, boolean z10) {
            d1.a.a(iArr.length == uriArr.length);
            this.f18244a = j10;
            this.f18245b = i10;
            this.f18247d = iArr;
            this.f18246c = uriArr;
            this.f18248e = jArr;
            this.f18249f = j11;
            this.f18250g = z10;
        }

        @CheckResult
        public C0350a c(int i10) {
            int[] iArrB = b(this.f18247d, i10);
            long[] jArrA = a(this.f18248e, i10);
            return new C0350a(this.f18244a, i10, iArrB, (Uri[]) Arrays.copyOf(this.f18246c, i10), jArrA, this.f18249f, this.f18250g);
        }

        public int hashCode() {
            int i10 = this.f18245b * 31;
            long j10 = this.f18244a;
            int iHashCode = (((((((i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31) + Arrays.hashCode(this.f18246c)) * 31) + Arrays.hashCode(this.f18247d)) * 31) + Arrays.hashCode(this.f18248e)) * 31;
            long j11 = this.f18249f;
            return ((iHashCode + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f18250g ? 1 : 0);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (k.a(this.f18237a, aVar.f18237a) && this.f18238b == aVar.f18238b && this.f18239c == aVar.f18239c && this.f18240d == aVar.f18240d && this.f18241e == aVar.f18241e && Arrays.equals(this.f18242f, aVar.f18242f)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.f18238b * 31;
        Object obj = this.f18237a;
        return ((((((((i10 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f18239c)) * 31) + ((int) this.f18240d)) * 31) + this.f18241e) * 31) + Arrays.hashCode(this.f18242f);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdPlaybackState(adsId=");
        sb2.append(this.f18237a);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.f18239c);
        sb2.append(", adGroups=[");
        for (int i10 = 0; i10 < this.f18242f.length; i10++) {
            sb2.append("adGroup(timeUs=");
            sb2.append(this.f18242f[i10].f18244a);
            sb2.append(", ads=[");
            for (int i11 = 0; i11 < this.f18242f[i10].f18247d.length; i11++) {
                sb2.append("ad(state=");
                int i12 = this.f18242f[i10].f18247d[i11];
                if (i12 == 0) {
                    sb2.append('_');
                } else if (i12 == 1) {
                    sb2.append('R');
                } else if (i12 == 2) {
                    sb2.append('S');
                } else if (i12 == 3) {
                    sb2.append('P');
                } else if (i12 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append('!');
                }
                sb2.append(", durationUs=");
                sb2.append(this.f18242f[i10].f18248e[i11]);
                sb2.append(')');
                if (i11 < this.f18242f[i10].f18247d.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i10 < this.f18242f.length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("])");
        return sb2.toString();
    }

    private a(@Nullable Object obj, C0350a[] c0350aArr, long j10, long j11, int i10) {
        this.f18237a = obj;
        this.f18239c = j10;
        this.f18240d = j11;
        this.f18238b = c0350aArr.length + i10;
        this.f18242f = c0350aArr;
        this.f18241e = i10;
    }
}
