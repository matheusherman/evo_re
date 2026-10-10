package r3;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f17810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<b> f17811b;

    private b a(int i10) {
        if (i10 >= this.f17811b.size()) {
            List<b> list = this.f17811b;
            b bVarI = list.get(list.size() - 1);
            for (int size = this.f17811b.size(); size <= i10; size++) {
                a aVar = this.f17810a;
                bVarI = bVarI.i(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f17811b.add(bVarI);
            }
        }
        return this.f17811b.get(i10);
    }

    public void b(int[] iArr, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i10;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b bVarA = a(i10);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrE = new b(this.f17810a, iArr2).j(i10, 1).b(bVarA)[1].e();
        int length2 = i10 - iArrE.length;
        for (int i11 = 0; i11 < length2; i11++) {
            iArr[length + i11] = 0;
        }
        System.arraycopy(iArrE, 0, iArr, length + length2, iArrE.length);
    }

    public d(a aVar) {
        this.f17810a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f17811b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }
}
