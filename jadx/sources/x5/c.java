package x5;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f21855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f21856b;

    private b b(int i10) {
        if (i10 >= this.f21856b.size()) {
            List list = this.f21856b;
            b bVarF = (b) list.get(list.size() - 1);
            for (int size = this.f21856b.size(); size <= i10; size++) {
                a aVar = this.f21855a;
                bVarF = bVarF.f(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.a())}));
                this.f21856b.add(bVarF);
            }
        }
        return (b) this.f21856b.get(i10);
    }

    public void a(int[] iArr, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i10;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b bVarB = b(i10);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrD = new b(this.f21855a, iArr2).b(i10, 1).h(bVarB)[1].d();
        int length2 = i10 - iArrD.length;
        for (int i11 = 0; i11 < length2; i11++) {
            iArr[length + i11] = 0;
        }
        System.arraycopy(iArrD, 0, iArr, length + length2, iArrD.length);
    }

    public c(a aVar) {
        ArrayList arrayList = new ArrayList();
        this.f21856b = arrayList;
        this.f21855a = aVar;
        arrayList.add(new b(aVar, new int[]{1}));
    }
}
