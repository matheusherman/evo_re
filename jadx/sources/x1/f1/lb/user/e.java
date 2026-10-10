package x1.f1.lb.user;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B?\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\r\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u0018\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u0019"}, d2 = {"Lx1/f1/lb/user/e;", "X", "", "x", "", "isRefreshAccessToken", "", "callFrom", "code", "username", "passwordDigest", "<init>", "(Ljava/lang/Object;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "a", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", "b", "Z", "f", "()Z", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e<X> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final X x;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isRefreshAccessToken;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String callFrom;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String code;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String username;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String passwordDigest;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCallFrom() {
        return this.callFrom;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getPasswordDigest() {
        return this.passwordDigest;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    public final X e() {
        return this.x;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getIsRefreshAccessToken() {
        return this.isRefreshAccessToken;
    }

    public e(X x10, boolean z10, String str, String str2, String str3, String str4) {
        this.x = x10;
        this.isRefreshAccessToken = z10;
        this.callFrom = str;
        this.code = str2;
        this.username = str3;
        this.passwordDigest = str4;
    }
}
