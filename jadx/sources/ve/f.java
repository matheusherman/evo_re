package ve;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class f extends Exception {
    private static final long serialVersionUID = 300;
    private Throwable cause;
    private int reasonCode = 0;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return we.b.b(this.reasonCode);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(getMessage()));
        stringBuffer.append(" (");
        stringBuffer.append(this.reasonCode);
        stringBuffer.append(")");
        String string = stringBuffer.toString();
        if (this.cause == null) {
            return string;
        }
        StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(string));
        stringBuffer2.append(" - ");
        stringBuffer2.append(this.cause.toString());
        return stringBuffer2.toString();
    }

    public f(Throwable th) {
        this.cause = th;
    }
}
