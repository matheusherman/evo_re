package h3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class p extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static boolean f10815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final StackTraceElement[] f10816b;

    p() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    static {
        f10815a = System.getProperty("surefire.test.class.path") != null;
        f10816b = new StackTraceElement[0];
    }

    p(Throwable th) {
        super(th);
    }
}
