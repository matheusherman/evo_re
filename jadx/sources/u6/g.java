package u6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g {
    public static /* synthetic */ boolean a(int i10, Integer num) {
        if (num.intValue() < ((long) (i10 + 1)) * 10000 && num.intValue() >= ((long) i10) * 10000) {
            return true;
        }
        return false;
    }

    public static byte[] b(List<Integer> list) {
        int i10;
        int i11;
        byte[] bArr;
        Collections.sort(list);
        int size = list.size();
        int i12 = size << 1;
        int iIntValue = list.get(0).intValue();
        int iIntValue2 = list.get(size - 1).intValue();
        int i13 = (iIntValue2 - iIntValue) + 1;
        int i14 = i13 >>> 3;
        if ((i13 & 7) == 0) {
            i10 = 0;
        } else {
            i10 = 1;
        }
        int i15 = i14 + i10;
        if (i12 <= i15) {
            i11 = 2;
        } else {
            i11 = 3;
        }
        if (i11 == 2) {
            bArr = new byte[i12 + 8];
            for (int i16 = 0; i16 < size; i16++) {
                int iIntValue3 = list.get(i16).intValue();
                int i17 = (i16 + 4) << 1;
                bArr[i17] = (byte) (iIntValue3 & 255);
                bArr[i17 + 1] = (byte) (iIntValue3 >>> 8);
            }
        } else {
            bArr = new byte[i15 + 8];
            Arrays.fill(bArr, (byte) 0);
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue4 = it.next().intValue() - iIntValue;
                int i18 = (iIntValue4 >>> 3) + 8;
                bArr[i18] = (byte) ((1 << (iIntValue4 & 7)) | bArr[i18]);
            }
        }
        bArr[0] = (byte) (i11 & 255);
        bArr[1] = (byte) 0;
        bArr[2] = (byte) (iIntValue & 255);
        bArr[3] = (byte) (iIntValue >>> 8);
        bArr[4] = (byte) (iIntValue2 & 255);
        bArr[5] = (byte) (iIntValue2 >>> 8);
        bArr[6] = (byte) (size & 255);
        bArr[7] = (byte) (size >>> 8);
        return bArr;
    }

    public static List<List<Integer>> c(List<Integer> list) {
        long j10;
        long jIntValue = list.get(list.size() - 1).intValue() + 1;
        if (jIntValue <= 10000) {
            return new ArrayList(Collections.singleton(list));
        }
        if (jIntValue % 10000 == 0) {
            j10 = jIntValue / 10000;
        } else {
            j10 = (jIntValue / 10000) + 1;
        }
        ArrayList arrayList = new ArrayList();
        for (final int i10 = 0; i10 < j10; i10++) {
            List list2 = (List) list.stream().filter(new Predicate() { // from class: u6.f
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return g.a(i10, (Integer) obj);
                }
            }).collect(Collectors.toList());
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        return arrayList;
    }
}
