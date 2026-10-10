package y9;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0479a f22488f = new C0479a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f22489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f22491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Integer> f22493e;

    /* JADX INFO: renamed from: y9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0479a {
        public /* synthetic */ C0479a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private C0479a() {
        }
    }

    public a(int... numbers) {
        List<Integer> listL;
        m.f(numbers, "numbers");
        this.f22489a = numbers;
        Integer numS = j.S(numbers, 0);
        this.f22490b = numS != null ? numS.intValue() : -1;
        Integer numS2 = j.S(numbers, 1);
        this.f22491c = numS2 != null ? numS2.intValue() : -1;
        Integer numS3 = j.S(numbers, 2);
        this.f22492d = numS3 != null ? numS3.intValue() : -1;
        if (numbers.length <= 3) {
            listL = r.l();
        } else {
            if (numbers.length > 1024) {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + numbers.length + '.');
            }
            listL = r.O0(j.c(numbers).subList(3, numbers.length));
        }
        this.f22493e = listL;
    }

    public final int a() {
        return this.f22490b;
    }

    public final int b() {
        return this.f22491c;
    }

    public final boolean c(int i10, int i11, int i12) {
        int i13 = this.f22490b;
        if (i13 > i10) {
            return true;
        }
        if (i13 < i10) {
            return false;
        }
        int i14 = this.f22491c;
        if (i14 > i11) {
            return true;
        }
        return i14 >= i11 && this.f22492d >= i12;
    }

    public final boolean d(a version) {
        m.f(version, "version");
        return c(version.f22490b, version.f22491c, version.f22492d);
    }

    public final boolean e(int i10, int i11, int i12) {
        int i13 = this.f22490b;
        if (i13 < i10) {
            return true;
        }
        if (i13 > i10) {
            return false;
        }
        int i14 = this.f22491c;
        if (i14 < i11) {
            return true;
        }
        return i14 <= i11 && this.f22492d <= i12;
    }

    public boolean equals(Object obj) {
        if (obj == null || !m.a(getClass(), obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        return this.f22490b == aVar.f22490b && this.f22491c == aVar.f22491c && this.f22492d == aVar.f22492d && m.a(this.f22493e, aVar.f22493e);
    }

    protected final boolean f(a ourVersion) {
        m.f(ourVersion, "ourVersion");
        int i10 = this.f22490b;
        if (i10 == 0) {
            return ourVersion.f22490b == 0 && this.f22491c == ourVersion.f22491c;
        }
        return i10 == ourVersion.f22490b && this.f22491c <= ourVersion.f22491c;
    }

    public final int[] g() {
        return this.f22489a;
    }

    public int hashCode() {
        int i10 = this.f22490b;
        int i11 = i10 + (i10 * 31) + this.f22491c;
        int i12 = i11 + (i11 * 31) + this.f22492d;
        return i12 + (i12 * 31) + this.f22493e.hashCode();
    }

    public String toString() {
        int[] iArrG = g();
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArrG) {
            if (i10 == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i10));
        }
        if (arrayList.isEmpty()) {
            return "unknown";
        }
        return r.q0(arrayList, ".", null, null, 0, null, null, 62, null);
    }
}
