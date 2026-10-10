package l6;

import kotlin.Metadata;
import kotlin.jvm.internal.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ll6/a;", "", "", "code", "", "message", "<init>", "(ILjava/lang/String;)V", "I", "getCode", "()I", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a extends Throwable {
    private final int code;
    private final String message;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ a(int i10, String str, int i11, g gVar) {
        if ((i11 & 2) != 0) {
            str = "The server has successfully fulfilled the request with the code (" + i10 + ") and that there is no additional content to send in the response payload body.";
        }
        this(i10, str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public a(int i10, String str) {
        super(str);
        this.code = i10;
        this.message = str;
    }
}
