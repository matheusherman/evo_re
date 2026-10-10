package x1.f1.lb.util;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lx1/f1/lb/util/l;", "", "<init>", "()V", "", "code", "a", "(Ljava/lang/String;)Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f21408a = new l();

    public final String a(String code) {
        if (code == null) {
            return "";
        }
        int length = code.length() / 4;
        if (length <= 0) {
            return code;
        }
        int i10 = length - 1;
        int i11 = length << 1;
        Character[] chArr = new Character[code.length()];
        int length2 = code.length();
        for (int i12 = 0; i12 < length2; i12++) {
            if (i12 < i10 || i12 >= i11) {
                chArr[i12] = Character.valueOf(code.charAt(i12));
            } else {
                chArr[i12] = '*';
            }
        }
        return chArr.toString();
    }

    private l() {
    }
}
