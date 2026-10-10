package k0;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class m {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final k0.a<a> f11950h = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Object f11951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Object f11952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f11954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f11955e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f11956f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private s0.a f11957g = s0.a.f18234g;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class.equals(obj.getClass())) {
                a aVar = (a) obj;
                if (d1.k.a(this.f11951a, aVar.f11951a) && d1.k.a(this.f11952b, aVar.f11952b) && this.f11953c == aVar.f11953c && this.f11954d == aVar.f11954d && this.f11955e == aVar.f11955e && this.f11956f == aVar.f11956f && d1.k.a(this.f11957g, aVar.f11957g)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f11951a;
            int iHashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.f11952b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f11953c) * 31;
            long j10 = this.f11954d;
            int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f11955e;
            return ((((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f11956f ? 1 : 0)) * 31) + this.f11957g.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Object f11958p = new Object();

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final Object f11959q = new Object();

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final g f11960r = new g.c().b("com.google.android.exoplayer2.Timeline").c(Uri.EMPTY).a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final k0.a<b> f11961s = new d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11962a = f11958p;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f11963b = f11960r;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Object f11964c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f11965d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f11966e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f11967f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f11968g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f11969h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public g.C0201g f11970i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f11971j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f11972k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f11973l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11974m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11975n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f11976o;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class.equals(obj.getClass())) {
                b bVar = (b) obj;
                if (d1.k.a(this.f11962a, bVar.f11962a) && d1.k.a(this.f11963b, bVar.f11963b) && d1.k.a(this.f11964c, bVar.f11964c) && d1.k.a(this.f11970i, bVar.f11970i) && this.f11965d == bVar.f11965d && this.f11966e == bVar.f11966e && this.f11967f == bVar.f11967f && this.f11968g == bVar.f11968g && this.f11969h == bVar.f11969h && this.f11971j == bVar.f11971j && this.f11972k == bVar.f11972k && this.f11973l == bVar.f11973l && this.f11974m == bVar.f11974m && this.f11975n == bVar.f11975n && this.f11976o == bVar.f11976o) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = (((217 + this.f11962a.hashCode()) * 31) + this.f11963b.hashCode()) * 31;
            Object obj = this.f11964c;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            g.C0201g c0201g = this.f11970i;
            int iHashCode3 = (iHashCode2 + (c0201g != null ? c0201g.hashCode() : 0)) * 31;
            long j10 = this.f11965d;
            int i10 = (iHashCode3 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
            long j11 = this.f11966e;
            int i11 = (i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f11967f;
            int i12 = (((((((i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f11968g ? 1 : 0)) * 31) + (this.f11969h ? 1 : 0)) * 31) + (this.f11971j ? 1 : 0)) * 31;
            long j13 = this.f11972k;
            int i13 = (i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31;
            long j14 = this.f11973l;
            int i14 = (((((i13 + ((int) (j14 ^ (j14 >>> 32)))) * 31) + this.f11974m) * 31) + this.f11975n) * 31;
            long j15 = this.f11976o;
            return i14 + ((int) (j15 ^ (j15 >>> 32)));
        }
    }
}
