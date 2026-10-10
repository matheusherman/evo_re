package y3;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class r implements h3.o {
    protected static float e(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            int i14 = iArr[i13];
            float f15 = iArr2[i13] * f12;
            float f16 = i14;
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }

    protected static void f(p3.a aVar, int i10, int[] iArr) throws h3.m {
        int length = iArr.length;
        int i11 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iM = aVar.m();
        if (i10 >= iM) {
            throw h3.m.a();
        }
        boolean z10 = !aVar.i(i10);
        while (i10 < iM) {
            if (aVar.i(i10) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                i11++;
                if (i11 == length) {
                    break;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            i10++;
        }
        if (i11 != length) {
            if (i11 != length - 1 || i10 != iM) {
                throw h3.m.a();
            }
        }
    }

    protected static void g(p3.a aVar, int i10, int[] iArr) throws h3.m {
        int length = iArr.length;
        boolean zI = aVar.i(i10);
        while (i10 > 0 && length >= 0) {
            i10--;
            if (aVar.i(i10) != zI) {
                length--;
                zI = !zI;
            }
        }
        if (length >= 0) {
            throw h3.m.a();
        }
        f(aVar, i10 + 1, iArr);
    }

    @Override // h3.o
    public h3.q a(h3.c cVar) {
        return b(cVar, null);
    }

    public abstract h3.q c(int i10, p3.a aVar, Map<h3.e, ?> map);

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        r3 = r22.b(r11, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f0, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private h3.q d(h3.c cVar, Map<h3.e, ?> map) throws h3.m {
        int i10;
        int i11;
        int i12;
        Map<h3.e, ?> map2;
        Map<h3.e, ?> map3 = map;
        int iD = cVar.d();
        int iC = cVar.c();
        p3.a aVar = new p3.a(iD);
        int i13 = 1;
        boolean z10 = map3 != null && map3.containsKey(h3.e.TRY_HARDER);
        int iMax = Math.max(1, iC >> (z10 ? 8 : 5));
        int i14 = z10 ? iC : 15;
        int i15 = iC / 2;
        int i16 = 0;
        while (i16 < i14) {
            i10 = i16 + 1;
            int i17 = i10 / 2;
            if ((i16 & 1) != 0) {
                i17 = -i17;
            }
            i11 = (i17 * iMax) + i15;
            if (i11 < 0 || i11 >= iC) {
                break;
            }
            i16 = i10;
            iD = iD;
            i13 = 1;
        }
        throw h3.m.a();
        while (i12 < 2) {
            if (i12 == i13) {
                aVar.q();
                if (map3 != null) {
                    h3.e eVar = h3.e.NEED_RESULT_POINT_CALLBACK;
                    if (map3.containsKey(eVar)) {
                        EnumMap enumMap = new EnumMap(h3.e.class);
                        enumMap.putAll(map3);
                        enumMap.remove(eVar);
                        map3 = enumMap;
                    }
                }
            }
            try {
                h3.q qVarC = c(i11, aVar, map3);
                if (i12 == i13) {
                    try {
                        qVarC.h(h3.r.ORIENTATION, 180);
                        h3.s[] sVarArrE = qVarC.e();
                        if (sVarArrE != null) {
                            float f10 = iD;
                            try {
                                map2 = map3;
                                try {
                                    try {
                                        sVarArrE[0] = new h3.s((f10 - sVarArrE[0].c()) - 1.0f, sVarArrE[0].d());
                                        sVarArrE[1] = new h3.s((f10 - sVarArrE[1].c()) - 1.0f, sVarArrE[1].d());
                                    } catch (h3.p unused) {
                                        continue;
                                        i12++;
                                        map3 = map2;
                                        iD = iD;
                                        i13 = 1;
                                    }
                                } catch (h3.p unused2) {
                                    i12++;
                                    map3 = map2;
                                    iD = iD;
                                    i13 = 1;
                                }
                            } catch (h3.p unused3) {
                                map2 = map3;
                            }
                        }
                    } catch (h3.p unused4) {
                        map2 = map3;
                    }
                }
                return qVarC;
            } catch (h3.p unused5) {
                map2 = map3;
            }
        }
        continue;
        i16 = i10;
        iD = iD;
        i13 = 1;
    }

    @Override // h3.o
    public h3.q b(h3.c cVar, Map<h3.e, ?> map) throws h3.m {
        try {
            return d(cVar, map);
        } catch (h3.m e10) {
            if (map != null && map.containsKey(h3.e.TRY_HARDER) && cVar.e()) {
                h3.c cVarF = cVar.f();
                h3.q qVarD = d(cVarF, map);
                Map<h3.r, Object> mapD = qVarD.d();
                int iIntValue = 270;
                if (mapD != null) {
                    h3.r rVar = h3.r.ORIENTATION;
                    if (mapD.containsKey(rVar)) {
                        iIntValue = (((Integer) mapD.get(rVar)).intValue() + 270) % 360;
                    }
                }
                qVarD.h(h3.r.ORIENTATION, Integer.valueOf(iIntValue));
                h3.s[] sVarArrE = qVarD.e();
                if (sVarArrE != null) {
                    int iC = cVarF.c();
                    for (int i10 = 0; i10 < sVarArrE.length; i10++) {
                        sVarArrE[i10] = new h3.s((iC - sVarArrE[i10].d()) - 1.0f, sVarArrE[i10].c());
                    }
                }
                return qVarD;
            }
            throw e10;
        }
    }

    @Override // h3.o
    public void reset() {
    }
}
