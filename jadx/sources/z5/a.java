package z5;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 z5.a, still in use, count: 1, list:
  (r0v0 z5.a) from 0x002f: FILLED_NEW_ARRAY (r1v1 z5.a), (r0v0 z5.a), (r5v1 z5.a), (r4v1 z5.a) A[WRAPPED] (LINE:49) elemType: z5.a
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
public final class a {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a[] f23071e;
    private final int f578b;

    static {
        f23071e = new a[]{aVar, new a(1), aVar, new a(3)};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f23072f.clone();
    }

    public int f() {
        return this.f578b;
    }

    private a(int i10) {
        super(str, i);
        this.f578b = i10;
    }
}
