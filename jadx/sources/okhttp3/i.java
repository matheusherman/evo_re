package okhttp3;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.taobao.sophix.PatchStatus;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u0007¨\u0006\f"}, d2 = {"Lokhttp3/i;", "", "", "javaName", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "c", "b", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class i {
    public static final i A;
    public static final i A0;
    public static final i B;
    public static final i B0;
    public static final i C;
    public static final i C0;
    public static final i D;
    public static final i D0;
    public static final i E;
    public static final i E0;
    public static final i F;
    public static final i F0;
    public static final i G;
    public static final i G0;
    public static final i H;
    public static final i H0;
    public static final i I;
    public static final i I0;
    public static final i J;
    public static final i J0;
    public static final i K;
    public static final i K0;
    public static final i L;
    public static final i L0;
    public static final i M;
    public static final i M0;
    public static final i N;
    public static final i N0;
    public static final i O;
    public static final i O0;
    public static final i P;
    public static final i P0;
    public static final i Q;
    public static final i Q0;
    public static final i R;
    public static final i R0;
    public static final i S;
    public static final i S0;
    public static final i T;
    public static final i T0;
    public static final i U;
    public static final i U0;
    public static final i V;
    public static final i V0;
    public static final i W;
    public static final i W0;
    public static final i X;
    public static final i X0;
    public static final i Y;
    public static final i Y0;
    public static final i Z;
    public static final i Z0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final i f16719a0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final i f16720a1;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final i f16722b0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final i f16723b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Comparator<String> f16724c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final i f16725c0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final i f16726c1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, i> f16727d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final i f16728d0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final i f16729d1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f16730e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final i f16731e0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final i f16732e1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i f16733f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final i f16734f0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final i f16735f1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f16736g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final i f16737g0;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final i f16738g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f16739h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final i f16740h0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final i f16741h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i f16742i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final i f16743i0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final i f16744i1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i f16745j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final i f16746j0;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final i f16747j1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final i f16748k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final i f16749k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final i f16750k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final i f16751l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final i f16752l0;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final i f16753l1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final i f16754m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final i f16755m0;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final i f16756m1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final i f16757n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final i f16758n0;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final i f16759n1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final i f16760o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final i f16761o0;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final i f16762o1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final i f16763p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final i f16764p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final i f16765p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final i f16766q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final i f16767q0;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final i f16768q1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final i f16769r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final i f16770r0;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final i f16771r1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final i f16772s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final i f16773s0;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final i f16774s1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final i f16775t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final i f16776t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final i f16777u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final i f16778u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final i f16779v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final i f16780v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final i f16781w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final i f16782w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final i f16783x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final i f16784x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final i f16785y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final i f16786y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final i f16787z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final i f16788z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String javaName;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J\u001f\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"okhttp3/i$a", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "a", "b", "", "(Ljava/lang/String;Ljava/lang/String;)I", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Comparator<String> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String a10, String b10) {
            kotlin.jvm.internal.m.f(a10, "a");
            kotlin.jvm.internal.m.f(b10, "b");
            int iMin = Math.min(a10.length(), b10.length());
            for (int i10 = 4; i10 < iMin; i10++) {
                char cCharAt = a10.charAt(i10);
                char cCharAt2 = b10.charAt(i10);
                if (cCharAt != cCharAt2) {
                    return kotlin.jvm.internal.m.h(cCharAt, cCharAt2) < 0 ? -1 : 1;
                }
            }
            int length = a10.length();
            int length2 = b10.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }

        a() {
        }
    }

    /* JADX INFO: renamed from: okhttp3.i$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b{\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000fj\b\u0012\u0004\u0012\u00020\u0004`\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010#\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0014\u0010$\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0019R\u0014\u0010%\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0019R\u0014\u0010(\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b(\u0010\u0019R\u0014\u0010)\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0019R\u0014\u0010*\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0019R\u0014\u0010,\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b,\u0010\u0019R\u0014\u0010-\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0019R\u0014\u0010.\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0019R\u0014\u0010/\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b/\u0010\u0019R\u0014\u00100\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0019R\u0014\u00101\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b1\u0010\u0019R\u0014\u00102\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0019R\u0014\u00103\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b3\u0010\u0019R\u0014\u00104\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b4\u0010\u0019R\u0014\u00105\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b5\u0010\u0019R\u0014\u00106\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0019R\u0014\u00107\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b7\u0010\u0019R\u0014\u00108\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b8\u0010\u0019R\u0014\u00109\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b9\u0010\u0019R\u0014\u0010:\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u0010\u0019R\u0014\u0010;\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b;\u0010\u0019R\u0014\u0010<\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b<\u0010\u0019R\u0014\u0010=\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b=\u0010\u0019R\u0014\u0010>\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010\u0019R\u0014\u0010?\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b?\u0010\u0019R\u0014\u0010@\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b@\u0010\u0019R\u0014\u0010A\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010\u0019R\u0014\u0010B\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bB\u0010\u0019R\u0014\u0010C\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010\u0019R\u0014\u0010D\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bD\u0010\u0019R\u0014\u0010E\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bE\u0010\u0019R\u0014\u0010F\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010\u0019R\u0014\u0010G\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bG\u0010\u0019R\u0014\u0010H\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bH\u0010\u0019R\u0014\u0010I\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bI\u0010\u0019R\u0014\u0010J\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u0010\u0019R\u0014\u0010K\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010\u0019R\u0014\u0010L\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bL\u0010\u0019R\u0014\u0010M\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010\u0019R\u0014\u0010N\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bN\u0010\u0019R\u0014\u0010O\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010\u0019R\u0014\u0010P\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010\u0019R\u0014\u0010Q\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010\u0019R\u0014\u0010R\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bR\u0010\u0019R\u0014\u0010S\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bS\u0010\u0019R\u0014\u0010T\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010\u0019R\u0014\u0010U\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bU\u0010\u0019R\u0014\u0010V\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010\u0019R\u0014\u0010W\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bW\u0010\u0019R\u0014\u0010X\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bX\u0010\u0019R\u0014\u0010Y\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bY\u0010\u0019R\u0014\u0010Z\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bZ\u0010\u0019R\u0014\u0010[\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b[\u0010\u0019R\u0014\u0010\\\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\\\u0010\u0019R\u0014\u0010]\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b]\u0010\u0019R\u0014\u0010^\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b^\u0010\u0019R\u0014\u0010_\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b_\u0010\u0019R\u0014\u0010`\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b`\u0010\u0019R\u0014\u0010a\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u0010\u0019R\u0014\u0010b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bb\u0010\u0019R\u0014\u0010c\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bc\u0010\u0019R\u0014\u0010d\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bd\u0010\u0019R\u0014\u0010e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\be\u0010\u0019R\u0014\u0010f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bf\u0010\u0019R\u0014\u0010g\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bg\u0010\u0019R\u0014\u0010h\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bh\u0010\u0019R\u0014\u0010i\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bi\u0010\u0019R\u0014\u0010j\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bj\u0010\u0019R\u0014\u0010k\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bk\u0010\u0019R\u0014\u0010l\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bl\u0010\u0019R\u0014\u0010m\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bm\u0010\u0019R\u0014\u0010n\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bn\u0010\u0019R\u0014\u0010o\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bo\u0010\u0019R\u0014\u0010p\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bp\u0010\u0019R\u0014\u0010q\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bq\u0010\u0019R\u0014\u0010r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\br\u0010\u0019R\u0014\u0010s\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bs\u0010\u0019R\u0014\u0010t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bt\u0010\u0019R\u0014\u0010u\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bu\u0010\u0019R\u0014\u0010v\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bv\u0010\u0019R\u0014\u0010w\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bw\u0010\u0019R\u0014\u0010x\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bx\u0010\u0019R\u0014\u0010y\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\by\u0010\u0019R\u0014\u0010z\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bz\u0010\u0019R\u0014\u0010{\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b{\u0010\u0019R\u0014\u0010|\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b|\u0010\u0019R\u0014\u0010}\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b}\u0010\u0019R\u0014\u0010~\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b~\u0010\u0019R\u0014\u0010\u007f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010\u0019R\u0016\u0010\u0080\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010\u0019R\u0016\u0010\u0081\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u0019R\u0016\u0010\u0082\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010\u0019R\u0016\u0010\u0083\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010\u0019R\u0016\u0010\u0084\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010\u0019R\u0016\u0010\u0085\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010\u0019R\u0016\u0010\u0086\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010\u0019R\u0016\u0010\u0087\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010\u0019R\u0016\u0010\u0088\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010\u0019R\u0016\u0010\u0089\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010\u0019R\u0016\u0010\u008a\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010\u0019R\u0016\u0010\u008b\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010\u0019R\u0016\u0010\u008c\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010\u0019R\u0016\u0010\u008d\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010\u0019R\u0016\u0010\u008e\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010\u0019R\u0016\u0010\u008f\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010\u0019¨\u0006\u0090\u0001"}, d2 = {"Lokhttp3/i$b;", "", "<init>", "()V", "", "javaName", "e", "(Ljava/lang/String;)Ljava/lang/String;", "", "value", "Lokhttp3/i;", "d", "(Ljava/lang/String;I)Lokhttp3/i;", "b", "(Ljava/lang/String;)Lokhttp3/i;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "ORDER_BY_NAME", "Ljava/util/Comparator;", "c", "()Ljava/util/Comparator;", "", "INSTANCES", "Ljava/util/Map;", "TLS_AES_128_CCM_8_SHA256", "Lokhttp3/i;", "TLS_AES_128_CCM_SHA256", "TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_DSS_WITH_DES_CBC_SHA", "TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_DHE_RSA_WITH_DES_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_RC4_40_MD5", "TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA256", "TLS_DH_anon_WITH_AES_128_GCM_SHA256", "TLS_DH_anon_WITH_AES_256_CBC_SHA", "TLS_DH_anon_WITH_AES_256_CBC_SHA256", "TLS_DH_anon_WITH_AES_256_GCM_SHA384", "TLS_DH_anon_WITH_DES_CBC_SHA", "TLS_DH_anon_WITH_RC4_128_MD5", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_NULL_SHA", "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_NULL_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_ECDSA_WITH_NULL_SHA", "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_RSA_WITH_NULL_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA", "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", "TLS_ECDH_anon_WITH_NULL_SHA", "TLS_ECDH_anon_WITH_RC4_128_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_FALLBACK_SCSV", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_DES_CBC_MD5", "TLS_KRB5_WITH_DES_CBC_SHA", "TLS_KRB5_WITH_RC4_128_MD5", "TLS_KRB5_WITH_RC4_128_SHA", "TLS_PSK_WITH_3DES_EDE_CBC_SHA", "TLS_PSK_WITH_AES_128_CBC_SHA", "TLS_PSK_WITH_AES_256_CBC_SHA", "TLS_PSK_WITH_RC4_128_SHA", "TLS_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_RSA_EXPORT_WITH_RC4_40_MD5", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_RSA_WITH_DES_CBC_SHA", "TLS_RSA_WITH_NULL_MD5", "TLS_RSA_WITH_NULL_SHA", "TLS_RSA_WITH_NULL_SHA256", "TLS_RSA_WITH_RC4_128_MD5", "TLS_RSA_WITH_RC4_128_SHA", "TLS_RSA_WITH_SEED_CBC_SHA", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final synchronized i b(String javaName) {
            i iVar;
            try {
                kotlin.jvm.internal.m.f(javaName, "javaName");
                iVar = (i) i.f16727d.get(javaName);
                if (iVar == null) {
                    iVar = (i) i.f16727d.get(e(javaName));
                    if (iVar == null) {
                        iVar = new i(javaName, null);
                    }
                    i.f16727d.put(javaName, iVar);
                }
            } catch (Throwable th) {
                throw th;
            }
            return iVar;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final i d(String javaName, int value) {
            i iVar = new i(javaName, null);
            i.f16727d.put(javaName, iVar);
            return iVar;
        }

        private final String e(String javaName) {
            if (ua.n.I(javaName, "TLS_", false, 2, null)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SSL_");
                String strSubstring = javaName.substring(4);
                kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring);
                return sb2.toString();
            }
            if (!ua.n.I(javaName, "SSL_", false, 2, null)) {
                return javaName;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("TLS_");
            String strSubstring2 = javaName.substring(4);
            kotlin.jvm.internal.m.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
            sb3.append(strSubstring2);
            return sb3.toString();
        }

        public final Comparator<String> c() {
            return i.f16724c;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f16724c = new a();
        f16727d = new LinkedHashMap();
        f16730e = companion.d("SSL_RSA_WITH_NULL_MD5", 1);
        f16733f = companion.d("SSL_RSA_WITH_NULL_SHA", 2);
        f16736g = companion.d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        f16739h = companion.d("SSL_RSA_WITH_RC4_128_MD5", 4);
        f16742i = companion.d("SSL_RSA_WITH_RC4_128_SHA", 5);
        f16745j = companion.d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        f16748k = companion.d("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f16751l = companion.d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        f16754m = companion.d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        f16757n = companion.d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        f16760o = companion.d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        f16763p = companion.d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        f16766q = companion.d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        f16769r = companion.d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        f16772s = companion.d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        f16775t = companion.d("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        f16777u = companion.d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        f16779v = companion.d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        f16781w = companion.d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        f16783x = companion.d("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        f16785y = companion.d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        f16787z = companion.d("TLS_KRB5_WITH_RC4_128_SHA", 32);
        A = companion.d("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        B = companion.d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        C = companion.d("TLS_KRB5_WITH_RC4_128_MD5", 36);
        D = companion.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        E = companion.d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        F = companion.d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        G = companion.d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        H = companion.d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        I = companion.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        J = companion.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        K = companion.d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        L = companion.d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        M = companion.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        N = companion.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        O = companion.d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        P = companion.d("TLS_RSA_WITH_NULL_SHA256", 59);
        Q = companion.d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        R = companion.d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        S = companion.d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        T = companion.d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        U = companion.d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        V = companion.d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        W = companion.d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        X = companion.d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        Y = companion.d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        Z = companion.d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        f16719a0 = companion.d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        f16722b0 = companion.d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", PatchStatus.CODE_LOAD_LIB_CPUABIS);
        f16725c0 = companion.d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", PatchStatus.CODE_LOAD_LIB_UNZIP);
        f16728d0 = companion.d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        f16731e0 = companion.d("TLS_PSK_WITH_RC4_128_SHA", 138);
        f16734f0 = companion.d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        f16737g0 = companion.d("TLS_PSK_WITH_AES_128_CBC_SHA", ModuleDescriptor.MODULE_VERSION);
        f16740h0 = companion.d("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        f16743i0 = companion.d("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f16746j0 = companion.d("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f16749k0 = companion.d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        f16752l0 = companion.d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        f16755m0 = companion.d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        f16758n0 = companion.d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        f16761o0 = companion.d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        f16764p0 = companion.d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        f16767q0 = companion.d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        f16770r0 = companion.d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        f16773s0 = companion.d("TLS_FALLBACK_SCSV", 22016);
        f16776t0 = companion.d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        f16778u0 = companion.d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        f16780v0 = companion.d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        f16782w0 = companion.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        f16784x0 = companion.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        f16786y0 = companion.d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        f16788z0 = companion.d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        A0 = companion.d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        B0 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        C0 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        D0 = companion.d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        E0 = companion.d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        F0 = companion.d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        G0 = companion.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        H0 = companion.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        I0 = companion.d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        J0 = companion.d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        K0 = companion.d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        L0 = companion.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        M0 = companion.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        N0 = companion.d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        O0 = companion.d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        P0 = companion.d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        Q0 = companion.d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        R0 = companion.d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        S0 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        T0 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        U0 = companion.d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        V0 = companion.d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        W0 = companion.d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        X0 = companion.d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        Y0 = companion.d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        Z0 = companion.d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        f16720a1 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f16723b1 = companion.d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        f16726c1 = companion.d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        f16729d1 = companion.d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        f16732e1 = companion.d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        f16735f1 = companion.d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        f16738g1 = companion.d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        f16741h1 = companion.d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        f16744i1 = companion.d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        f16747j1 = companion.d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        f16750k1 = companion.d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        f16753l1 = companion.d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        f16756m1 = companion.d("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        f16759n1 = companion.d("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        f16762o1 = companion.d("TLS_AES_128_GCM_SHA256", 4865);
        f16765p1 = companion.d("TLS_AES_256_GCM_SHA384", 4866);
        f16768q1 = companion.d("TLS_CHACHA20_POLY1305_SHA256", 4867);
        f16771r1 = companion.d("TLS_AES_128_CCM_SHA256", 4868);
        f16774s1 = companion.d("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public /* synthetic */ i(String str, kotlin.jvm.internal.g gVar) {
        this(str);
    }

    private i(String str) {
        this.javaName = str;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getJavaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }
}
