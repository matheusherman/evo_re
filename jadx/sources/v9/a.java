package v9;

import aa.e;
import h9.f;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.j;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumC0377a f19725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f19726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f19727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String[] f19728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String[] f19729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f19730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f19731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f19732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f19733i;

    /* JADX INFO: renamed from: v9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum EnumC0377a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0378a f19734a = new C0378a(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Map<Integer, EnumC0377a> f19735b;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f19743id;

        /* JADX INFO: renamed from: v9.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0378a {
            public /* synthetic */ C0378a(g gVar) {
                this();
            }

            private C0378a() {
            }

            public final EnumC0377a a(int i10) {
                EnumC0377a enumC0377a = (EnumC0377a) EnumC0377a.f19735b.get(Integer.valueOf(i10));
                if (enumC0377a == null) {
                    return EnumC0377a.UNKNOWN;
                }
                return enumC0377a;
            }
        }

        static {
            EnumC0377a[] enumC0377aArrValues = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(f.c(n0.e(enumC0377aArrValues.length), 16));
            for (EnumC0377a enumC0377a : enumC0377aArrValues) {
                linkedHashMap.put(Integer.valueOf(enumC0377a.f19743id), enumC0377a);
            }
            f19735b = linkedHashMap;
        }

        public static final EnumC0377a i(int i10) {
            return f19734a.a(i10);
        }

        EnumC0377a(int i10) {
            this.f19743id = i10;
        }
    }

    private final boolean h(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public a(EnumC0377a kind, e metadataVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i10, String str2, byte[] bArr) {
        m.f(kind, "kind");
        m.f(metadataVersion, "metadataVersion");
        this.f19725a = kind;
        this.f19726b = metadataVersion;
        this.f19727c = strArr;
        this.f19728d = strArr2;
        this.f19729e = strArr3;
        this.f19730f = str;
        this.f19731g = i10;
        this.f19732h = str2;
        this.f19733i = bArr;
    }

    public final String[] a() {
        return this.f19727c;
    }

    public final String[] b() {
        return this.f19728d;
    }

    public final EnumC0377a c() {
        return this.f19725a;
    }

    public final e d() {
        return this.f19726b;
    }

    public final String e() {
        String str = this.f19730f;
        if (this.f19725a == EnumC0377a.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> f() {
        String[] strArr = this.f19727c;
        if (this.f19725a != EnumC0377a.MULTIFILE_CLASS) {
            strArr = null;
        }
        List<String> listD = strArr != null ? j.d(strArr) : null;
        return listD == null ? r.l() : listD;
    }

    public final String[] g() {
        return this.f19729e;
    }

    public final boolean i() {
        return h(this.f19731g, 2);
    }

    public final boolean j() {
        return h(this.f19731g, 64) && !h(this.f19731g, 32);
    }

    public final boolean k() {
        return h(this.f19731g, 16) && !h(this.f19731g, 32);
    }

    public String toString() {
        return this.f19725a + " version=" + this.f19726b;
    }
}
