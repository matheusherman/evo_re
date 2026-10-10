package m1;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseIntArray f15512a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.google.android.gms.common.b f15513b;

    public final int a(Context context, int i10) {
        return this.f15512a.get(i10, -1);
    }

    public final void c() {
        this.f15512a.clear();
    }

    public w(@NonNull com.google.android.gms.common.b bVar) {
        g.k(bVar);
        this.f15513b = bVar;
    }

    @ResultIgnorabilityUnspecified
    public final int b(@NonNull Context context, @NonNull com.google.android.gms.common.api.a.f fVar) {
        g.k(context);
        g.k(fVar);
        int iH = 0;
        if (!fVar.i()) {
            return 0;
        }
        int iJ = fVar.j();
        int iA = a(context, iJ);
        if (iA != -1) {
            return iA;
        }
        int i10 = 0;
        while (true) {
            if (i10 < this.f15512a.size()) {
                int iKeyAt = this.f15512a.keyAt(i10);
                if (iKeyAt > iJ && this.f15512a.get(iKeyAt) == 0) {
                    break;
                }
                i10++;
            } else {
                iH = -1;
                break;
            }
        }
        if (iH == -1) {
            iH = this.f15513b.h(context, iJ);
        }
        this.f15512a.put(iJ, iH);
        return iH;
    }
}
