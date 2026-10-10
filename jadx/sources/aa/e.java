package aa;

import java.util.Arrays;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends y9.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f176h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f177i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f178j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f179k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f180g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int[] versionArray, boolean z10) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        m.f(versionArray, "versionArray");
        this.f180g = z10;
    }

    static {
        e eVar = new e(1, 8, 0);
        f177i = eVar;
        f178j = eVar.m();
        f179k = new e(new int[0]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(int... numbers) {
        this(numbers, false);
        m.f(numbers, "numbers");
    }

    public final boolean h(e metadataVersionFromLanguageVersion) {
        m.f(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        if (a() == 2 && b() == 0) {
            e eVar = f177i;
            if (eVar.a() == 1 && eVar.b() == 8) {
                return true;
            }
        }
        return i(metadataVersionFromLanguageVersion.k(this.f180g));
    }

    public final boolean j() {
        return this.f180g;
    }

    public final e k(boolean z10) {
        e eVar = z10 ? f177i : f178j;
        return eVar.l(this) ? eVar : this;
    }

    private final boolean i(e eVar) {
        if ((a() == 1 && b() == 0) || a() == 0) {
            return false;
        }
        return !l(eVar);
    }

    private final boolean l(e eVar) {
        if (a() > eVar.a()) {
            return true;
        }
        if (a() >= eVar.a() && b() > eVar.b()) {
            return true;
        }
        return false;
    }

    public final e m() {
        if (a() == 1 && b() == 9) {
            return new e(2, 0, 0);
        }
        return new e(a(), b() + 1, 0);
    }
}
