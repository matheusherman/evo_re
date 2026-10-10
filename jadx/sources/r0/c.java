package r0;

import androidx.annotation.Nullable;
import java.util.Arrays;
import k0.e;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k0.a<c> f17782e = new k0.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e[] f17785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17786d;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f17783a == cVar.f17783a && this.f17784b.equals(cVar.f17784b) && Arrays.equals(this.f17785c, cVar.f17785c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f17786d == 0) {
            this.f17786d = ((527 + this.f17784b.hashCode()) * 31) + Arrays.hashCode(this.f17785c);
        }
        return this.f17786d;
    }
}
