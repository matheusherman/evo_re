package i4;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 i4.f, still in use, count: 1, list:
  (r0v0 i4.f) from 0x002f: FILLED_NEW_ARRAY (r1v1 i4.f), (r0v0 i4.f), (r5v1 i4.f), (r4v1 i4.f) A[WRAPPED] (LINE:49) elemType: i4.f
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f[] f11035e;
    private final int bits;

    static {
        f11035e = new f[]{fVar, new f(1), fVar, new f(3)};
    }

    public static f f(int i10) {
        if (i10 >= 0) {
            f[] fVarArr = f11035e;
            if (i10 < fVarArr.length) {
                return fVarArr[i10];
            }
        }
        throw new IllegalArgumentException();
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f11036f.clone();
    }

    public int i() {
        return this.bits;
    }

    private f(int i10) {
        super(str, i);
        this.bits = i10;
    }
}
