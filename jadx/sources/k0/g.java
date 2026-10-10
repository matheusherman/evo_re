package k0;

import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.p;
import com.google.common.collect.q;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f11811h = new c().a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k0.a<g> f11812i = new k0.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final h f11814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    @Deprecated
    public final i f11815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0201g f11816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k0.h f11817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f11818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Deprecated
    public final e f11819g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private String f11820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private Uri f11821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private String f11822c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private String f11826g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        private Object f11828i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private k0.h f11829j;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d.a f11823d = new d.a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private f.a f11824e = new f.a(null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<StreamKey> f11825f = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private p<k> f11827h = p.w();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private C0201g.a f11830k = new C0201g.a();

        public g a() {
            i iVar;
            d1.a.c(this.f11824e.f11856b == null || this.f11824e.f11855a != null);
            Uri uri = this.f11821b;
            if (uri != null) {
                iVar = new i(uri, this.f11822c, this.f11824e.f11855a != null ? this.f11824e.i() : null, null, this.f11825f, this.f11826g, this.f11827h, this.f11828i, null);
            } else {
                iVar = null;
            }
            String str = this.f11820a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e eVarG = this.f11823d.g();
            C0201g c0201gF = this.f11830k.f();
            k0.h hVar = this.f11829j;
            if (hVar == null) {
                hVar = k0.h.F;
            }
            return new g(str2, eVarG, iVar, c0201gF, hVar, null);
        }

        public c c(@Nullable Uri uri) {
            this.f11821b = uri;
            return this;
        }

        public c b(String str) {
            this.f11820a = (String) d1.a.b(str);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f11831f = new a().f();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final k0.a<e> f11832g = new k0.d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @IntRange(from = 0)
        public final long f11833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f11834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f11835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f11836d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f11837e;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f11838a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f11839b = Long.MIN_VALUE;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f11840c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f11841d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f11842e;

            @Deprecated
            public e g() {
                return new e(this, null);
            }

            public d f() {
                return g();
            }
        }

        /* synthetic */ d(a aVar, a aVar2) {
            this(aVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f11833a == dVar.f11833a && this.f11834b == dVar.f11834b && this.f11835c == dVar.f11835c && this.f11836d == dVar.f11836d && this.f11837e == dVar.f11837e;
        }

        private d(a aVar) {
            this.f11833a = aVar.f11838a;
            this.f11834b = aVar.f11839b;
            this.f11835c = aVar.f11840c;
            this.f11836d = aVar.f11841d;
            this.f11837e = aVar.f11842e;
        }

        public int hashCode() {
            long j10 = this.f11833a;
            int i10 = ((int) (j10 ^ (j10 >>> 32))) * 31;
            long j11 = this.f11834b;
            return ((((((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.f11835c ? 1 : 0)) * 31) + (this.f11836d ? 1 : 0)) * 31) + (this.f11837e ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Deprecated
    public static final class e extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f11843h = new d.a().g();

        /* synthetic */ e(d.a aVar, a aVar2) {
            this(aVar);
        }

        private e(d.a aVar) {
            super(aVar, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f11844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public final UUID f11845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final Uri f11846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public final q<String, String> f11847d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final q<String, String> f11848e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f11849f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f11850g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f11851h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        public final p<Integer> f11852i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final p<Integer> f11853j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        private final byte[] f11854k;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            private UUID f11855a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            private Uri f11856b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private q<String, String> f11857c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f11858d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f11859e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f11860f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private p<Integer> f11861g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            @Nullable
            private byte[] f11862h;

            /* synthetic */ a(a aVar) {
                this();
            }

            @Deprecated
            private a() {
                this.f11857c = q.i();
                this.f11861g = p.w();
            }

            public f i() {
                return new f(this, null);
            }
        }

        /* synthetic */ f(a aVar, a aVar2) {
            this(aVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f11844a.equals(fVar.f11844a) && d1.k.a(this.f11846c, fVar.f11846c) && d1.k.a(this.f11848e, fVar.f11848e) && this.f11849f == fVar.f11849f && this.f11851h == fVar.f11851h && this.f11850g == fVar.f11850g && this.f11853j.equals(fVar.f11853j) && Arrays.equals(this.f11854k, fVar.f11854k);
        }

        private f(a aVar) {
            d1.a.c((aVar.f11860f && aVar.f11856b == null) ? false : true);
            UUID uuid = (UUID) d1.a.b(aVar.f11855a);
            this.f11844a = uuid;
            this.f11845b = uuid;
            this.f11846c = aVar.f11856b;
            this.f11847d = aVar.f11857c;
            this.f11848e = aVar.f11857c;
            this.f11849f = aVar.f11858d;
            this.f11851h = aVar.f11860f;
            this.f11850g = aVar.f11859e;
            this.f11852i = aVar.f11861g;
            this.f11853j = aVar.f11861g;
            this.f11854k = aVar.f11862h != null ? Arrays.copyOf(aVar.f11862h, aVar.f11862h.length) : null;
        }

        public int hashCode() {
            int iHashCode = this.f11844a.hashCode() * 31;
            Uri uri = this.f11846c;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f11848e.hashCode()) * 31) + (this.f11849f ? 1 : 0)) * 31) + (this.f11851h ? 1 : 0)) * 31) + (this.f11850g ? 1 : 0)) * 31) + this.f11853j.hashCode()) * 31) + Arrays.hashCode(this.f11854k);
        }
    }

    /* JADX INFO: renamed from: k0.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0201g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0201g f11863f = new a().f();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final k0.a<C0201g> f11864g = new k0.d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f11865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f11866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f11867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f11868d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f11869e;

        /* JADX INFO: renamed from: k0.g$g$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private long f11870a = -9223372036854775807L;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f11871b = -9223372036854775807L;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private long f11872c = -9223372036854775807L;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private float f11873d = -3.4028235E38f;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private float f11874e = -3.4028235E38f;

            public C0201g f() {
                return new C0201g(this, null);
            }
        }

        /* synthetic */ C0201g(a aVar, a aVar2) {
            this(aVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0201g)) {
                return false;
            }
            C0201g c0201g = (C0201g) obj;
            return this.f11865a == c0201g.f11865a && this.f11866b == c0201g.f11866b && this.f11867c == c0201g.f11867c && this.f11868d == c0201g.f11868d && this.f11869e == c0201g.f11869e;
        }

        private C0201g(a aVar) {
            this(aVar.f11870a, aVar.f11871b, aVar.f11872c, aVar.f11873d, aVar.f11874e);
        }

        public int hashCode() {
            long j10 = this.f11865a;
            long j11 = this.f11866b;
            int i10 = ((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
            long j12 = this.f11867c;
            int i11 = (i10 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
            float f10 = this.f11868d;
            int iFloatToIntBits = (i11 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
            float f11 = this.f11869e;
            return iFloatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0);
        }

        @Deprecated
        public C0201g(long j10, long j11, long j12, float f10, float f11) {
            this.f11865a = j10;
            this.f11866b = j11;
            this.f11867c = j12;
            this.f11868d = f10;
            this.f11869e = f11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f11875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f11876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final f f11877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<StreamKey> f11878d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final String f11879e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final p<k> f11880f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public final List<j> f11881g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public final Object f11882h;

        /* synthetic */ h(Uri uri, String str, f fVar, b bVar, List list, String str2, p pVar, Object obj, a aVar) {
            this(uri, str, fVar, bVar, list, str2, pVar, obj);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f11875a.equals(hVar.f11875a) && d1.k.a(this.f11876b, hVar.f11876b) && d1.k.a(this.f11877c, hVar.f11877c) && d1.k.a(null, null) && this.f11878d.equals(hVar.f11878d) && d1.k.a(this.f11879e, hVar.f11879e) && this.f11880f.equals(hVar.f11880f) && d1.k.a(this.f11882h, hVar.f11882h);
        }

        private h(Uri uri, @Nullable String str, @Nullable f fVar, @Nullable b bVar, List<StreamKey> list, @Nullable String str2, p<k> pVar, @Nullable Object obj) {
            this.f11875a = uri;
            this.f11876b = str;
            this.f11877c = fVar;
            this.f11878d = list;
            this.f11879e = str2;
            this.f11880f = pVar;
            p.a aVarQ = p.q();
            for (int i10 = 0; i10 < pVar.size(); i10++) {
                aVarQ.f(pVar.get(i10).a().i());
            }
            this.f11881g = aVarQ.g();
            this.f11882h = obj;
        }

        public int hashCode() {
            int iHashCode = this.f11875a.hashCode() * 31;
            String str = this.f11876b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f11877c;
            int iHashCode3 = (((iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 961) + this.f11878d.hashCode()) * 31;
            String str2 = this.f11879e;
            int iHashCode4 = (((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f11880f.hashCode()) * 31;
            Object obj = this.f11882h;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Deprecated
    public static final class i extends h {
        /* synthetic */ i(Uri uri, String str, f fVar, b bVar, List list, String str2, p pVar, Object obj, a aVar) {
            this(uri, str, fVar, bVar, list, str2, pVar, obj);
        }

        private i(Uri uri, @Nullable String str, @Nullable f fVar, @Nullable b bVar, List<StreamKey> list, @Nullable String str2, p<k> pVar, @Nullable Object obj) {
            super(uri, str, fVar, bVar, list, str2, pVar, obj, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Deprecated
    public static final class j extends k {
        /* synthetic */ j(k.a aVar, a aVar2) {
            this(aVar);
        }

        private j(k.a aVar) {
            super(aVar, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f11883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f11884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f11885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f11886d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f11887e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final String f11888f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public final String f11889g;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Uri f11890a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            private String f11891b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            private String f11892c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f11893d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f11894e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @Nullable
            private String f11895f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @Nullable
            private String f11896g;

            /* synthetic */ a(k kVar, a aVar) {
                this(kVar);
            }

            private a(k kVar) {
                this.f11890a = kVar.f11883a;
                this.f11891b = kVar.f11884b;
                this.f11892c = kVar.f11885c;
                this.f11893d = kVar.f11886d;
                this.f11894e = kVar.f11887e;
                this.f11895f = kVar.f11888f;
                this.f11896g = kVar.f11889g;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public j i() {
                return new j(this, null);
            }
        }

        /* synthetic */ k(a aVar, a aVar2) {
            this(aVar);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.f11883a.equals(kVar.f11883a) && d1.k.a(this.f11884b, kVar.f11884b) && d1.k.a(this.f11885c, kVar.f11885c) && this.f11886d == kVar.f11886d && this.f11887e == kVar.f11887e && d1.k.a(this.f11888f, kVar.f11888f) && d1.k.a(this.f11889g, kVar.f11889g);
        }

        private k(a aVar) {
            this.f11883a = aVar.f11890a;
            this.f11884b = aVar.f11891b;
            this.f11885c = aVar.f11892c;
            this.f11886d = aVar.f11893d;
            this.f11887e = aVar.f11894e;
            this.f11888f = aVar.f11895f;
            this.f11889g = aVar.f11896g;
        }

        public a a() {
            return new a(this, null);
        }

        public int hashCode() {
            int iHashCode = this.f11883a.hashCode() * 31;
            String str = this.f11884b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f11885c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f11886d) * 31) + this.f11887e) * 31;
            String str3 = this.f11888f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f11889g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    /* synthetic */ g(String str, e eVar, i iVar, C0201g c0201g, k0.h hVar, a aVar) {
        this(str, eVar, iVar, c0201g, hVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return d1.k.a(this.f11813a, gVar.f11813a) && this.f11818f.equals(gVar.f11818f) && d1.k.a(this.f11814b, gVar.f11814b) && d1.k.a(this.f11816d, gVar.f11816d) && d1.k.a(this.f11817e, gVar.f11817e);
    }

    private g(String str, e eVar, @Nullable i iVar, C0201g c0201g, k0.h hVar) {
        this.f11813a = str;
        this.f11814b = iVar;
        this.f11815c = iVar;
        this.f11816d = c0201g;
        this.f11817e = hVar;
        this.f11818f = eVar;
        this.f11819g = eVar;
    }

    public int hashCode() {
        int iHashCode = this.f11813a.hashCode() * 31;
        h hVar = this.f11814b;
        return ((((((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f11816d.hashCode()) * 31) + this.f11818f.hashCode()) * 31) + this.f11817e.hashCode();
    }
}
