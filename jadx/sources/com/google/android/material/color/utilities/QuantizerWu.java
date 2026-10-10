package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* JADX INFO: renamed from: com.google.android.material.color.utilities.QuantizerWu$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum Direction {
        RED,
        GREEN,
        BLUE
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class CreateBoxesResult {
        int resultCount;

        CreateBoxesResult(int i10, int i11) {
            this.resultCount = i11;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class MaximizeResult {
        int cutLocation;
        double maximum;

        MaximizeResult(int i10, double d10) {
            this.cutLocation = i10;
            this.maximum = d10;
        }
    }

    static int getIndex(int i10, int i11, int i12) {
        return (i10 << 10) + (i10 << 6) + i10 + (i11 << 5) + i11 + i12;
    }

    static int volume(Box box, int[] iArr) {
        return ((((((iArr[getIndex(box.f4395r1, box.f4393g1, box.f4391b1)] - iArr[getIndex(box.f4395r1, box.f4393g1, box.f4390b0)]) - iArr[getIndex(box.f4395r1, box.f4392g0, box.f4391b1)]) + iArr[getIndex(box.f4395r1, box.f4392g0, box.f4390b0)]) - iArr[getIndex(box.f4394r0, box.f4393g1, box.f4391b1)]) + iArr[getIndex(box.f4394r0, box.f4393g1, box.f4390b0)]) + iArr[getIndex(box.f4394r0, box.f4392g0, box.f4391b1)]) - iArr[getIndex(box.f4394r0, box.f4392g0, box.f4390b0)];
    }

    CreateBoxesResult createBoxes(int i10) {
        int i11;
        this.cubes = new Box[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            this.cubes[i12] = new Box(null);
        }
        double[] dArr = new double[i10];
        Box box = this.cubes[0];
        box.f4395r1 = 32;
        box.f4393g1 = 32;
        box.f4391b1 = 32;
        int i13 = 1;
        int i14 = 0;
        while (i13 < i10) {
            Box[] boxArr = this.cubes;
            if (cut(boxArr[i14], boxArr[i13]).booleanValue()) {
                Box box2 = this.cubes[i14];
                dArr[i14] = box2.vol > 1 ? variance(box2) : 0.0d;
                Box box3 = this.cubes[i13];
                dArr[i13] = box3.vol > 1 ? variance(box3) : 0.0d;
            } else {
                dArr[i14] = 0.0d;
                i13--;
            }
            double d10 = dArr[0];
            int i15 = 0;
            for (int i16 = 1; i16 <= i13; i16++) {
                double d11 = dArr[i16];
                if (d11 > d10) {
                    i15 = i16;
                    d10 = d11;
                }
            }
            if (d10 <= 0.0d) {
                i11 = i13 + 1;
                return new CreateBoxesResult(i10, i11);
            }
            i13++;
            i14 = i15;
        }
        i11 = i10;
        return new CreateBoxesResult(i10, i11);
    }

    void createMoments() {
        int i10 = 1;
        while (true) {
            int i11 = 33;
            if (i10 >= 33) {
                return;
            }
            int[] iArr = new int[33];
            int[] iArr2 = new int[33];
            int[] iArr3 = new int[33];
            int[] iArr4 = new int[33];
            double[] dArr = new double[33];
            int i12 = 1;
            while (i12 < i11) {
                int i13 = 0;
                double d10 = 0.0d;
                int i14 = 1;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (i14 < i11) {
                    int index = getIndex(i10, i12, i14);
                    i13 += this.weights[index];
                    i15 += this.momentsR[index];
                    i16 += this.momentsG[index];
                    i17 += this.momentsB[index];
                    d10 += this.moments[index];
                    iArr[i14] = iArr[i14] + i13;
                    iArr2[i14] = iArr2[i14] + i15;
                    iArr3[i14] = iArr3[i14] + i16;
                    iArr4[i14] = iArr4[i14] + i17;
                    dArr[i14] = dArr[i14] + d10;
                    int index2 = getIndex(i10 - 1, i12, i14);
                    int i18 = i14;
                    int[] iArr5 = this.weights;
                    iArr5[index] = iArr5[index2] + iArr[i18];
                    int[] iArr6 = this.momentsR;
                    iArr6[index] = iArr6[index2] + iArr2[i18];
                    int[] iArr7 = this.momentsG;
                    iArr7[index] = iArr7[index2] + iArr3[i18];
                    int[] iArr8 = this.momentsB;
                    iArr8[index] = iArr8[index2] + iArr4[i18];
                    double[] dArr2 = this.moments;
                    dArr2[index] = dArr2[index2] + dArr[i18];
                    i14 = i18 + 1;
                    i11 = 33;
                }
                i12++;
                i11 = 33;
            }
            i10++;
        }
    }

    List<Integer> createResult(int i10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < i10; i11++) {
            Box box = this.cubes[i11];
            int iVolume = volume(box, this.weights);
            if (iVolume > 0) {
                int iVolume2 = volume(box, this.momentsR) / iVolume;
                int iVolume3 = volume(box, this.momentsG) / iVolume;
                arrayList.add(Integer.valueOf(((volume(box, this.momentsB) / iVolume) & 255) | ((iVolume2 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((iVolume3 & 255) << 8)));
            }
        }
        return arrayList;
    }

    Boolean cut(Box box, Box box2) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        int iVolume4 = volume(box, this.weights);
        Direction direction = Direction.RED;
        MaximizeResult maximizeResultMaximize = maximize(box, direction, box.f4394r0 + 1, box.f4395r1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction2 = Direction.GREEN;
        MaximizeResult maximizeResultMaximize2 = maximize(box, direction2, box.f4392g0 + 1, box.f4393g1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction3 = Direction.BLUE;
        MaximizeResult maximizeResultMaximize3 = maximize(box, direction3, box.f4390b0 + 1, box.f4391b1, iVolume, iVolume2, iVolume3, iVolume4);
        double d10 = maximizeResultMaximize.maximum;
        double d11 = maximizeResultMaximize2.maximum;
        double d12 = maximizeResultMaximize3.maximum;
        if (d10 < d11 || d10 < d12) {
            if (d11 >= d10 && d11 >= d12) {
                direction3 = direction2;
            }
        } else {
            if (maximizeResultMaximize.cutLocation < 0) {
                return Boolean.FALSE;
            }
            direction3 = direction;
        }
        box2.f4395r1 = box.f4395r1;
        box2.f4393g1 = box.f4393g1;
        box2.f4391b1 = box.f4391b1;
        int iOrdinal = direction3.ordinal();
        if (iOrdinal == 0) {
            int i10 = maximizeResultMaximize.cutLocation;
            box.f4395r1 = i10;
            box2.f4394r0 = i10;
            box2.f4392g0 = box.f4392g0;
            box2.f4390b0 = box.f4390b0;
        } else if (iOrdinal == 1) {
            int i11 = maximizeResultMaximize2.cutLocation;
            box.f4393g1 = i11;
            box2.f4394r0 = box.f4394r0;
            box2.f4392g0 = i11;
            box2.f4390b0 = box.f4390b0;
        } else if (iOrdinal == 2) {
            int i12 = maximizeResultMaximize3.cutLocation;
            box.f4391b1 = i12;
            box2.f4394r0 = box.f4394r0;
            box2.f4392g0 = box.f4392g0;
            box2.f4390b0 = i12;
        }
        box.vol = (box.f4395r1 - box.f4394r0) * (box.f4393g1 - box.f4392g0) * (box.f4391b1 - box.f4390b0);
        box2.vol = (box2.f4395r1 - box2.f4394r0) * (box2.f4393g1 - box2.f4392g0) * (box2.f4391b1 - box2.f4390b0);
        return Boolean.TRUE;
    }

    MaximizeResult maximize(Box box, Direction direction, int i10, int i11, int i12, int i13, int i14, int i15) {
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        int iBottom = bottom(box2, direction, quantizerWu.momentsR);
        int iBottom2 = bottom(box2, direction, quantizerWu.momentsG);
        int iBottom3 = bottom(box2, direction, quantizerWu.momentsB);
        int iBottom4 = bottom(box2, direction, quantizerWu.weights);
        double d10 = 0.0d;
        int i16 = -1;
        int i17 = i10;
        while (i17 < i11) {
            int pVar = top(box2, direction, i17, quantizerWu.momentsR) + iBottom;
            int pVar2 = top(box2, direction, i17, quantizerWu.momentsG) + iBottom2;
            int pVar3 = top(box2, direction, i17, quantizerWu.momentsB) + iBottom3;
            int pVar4 = top(box2, direction, i17, quantizerWu.weights) + iBottom4;
            if (pVar4 != 0) {
                double d11 = ((double) (((pVar * pVar) + (pVar2 * pVar2)) + (pVar3 * pVar3))) / ((double) pVar4);
                int i18 = i12 - pVar;
                int i19 = i13 - pVar2;
                int i20 = i14 - pVar3;
                int i21 = i15 - pVar4;
                if (i21 != 0) {
                    double d12 = d11 + (((double) (((i18 * i18) + (i19 * i19)) + (i20 * i20))) / ((double) i21));
                    if (d12 > d10) {
                        d10 = d12;
                        i16 = i17;
                    }
                }
            }
            i17++;
            quantizerWu = this;
            box2 = box;
        }
        return new MaximizeResult(i16, d10);
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] iArr, int i10) {
        constructHistogram(new QuantizerMap().quantize(iArr, i10).colorToCount);
        createMoments();
        List<Integer> listCreateResult = createResult(createBoxes(i10).resultCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer num : listCreateResult) {
            num.intValue();
            linkedHashMap.put(num, 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    double variance(Box box) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        return (((((((this.moments[getIndex(box.f4395r1, box.f4393g1, box.f4391b1)] - this.moments[getIndex(box.f4395r1, box.f4393g1, box.f4390b0)]) - this.moments[getIndex(box.f4395r1, box.f4392g0, box.f4391b1)]) + this.moments[getIndex(box.f4395r1, box.f4392g0, box.f4390b0)]) - this.moments[getIndex(box.f4394r0, box.f4393g1, box.f4391b1)]) + this.moments[getIndex(box.f4394r0, box.f4393g1, box.f4390b0)]) + this.moments[getIndex(box.f4394r0, box.f4392g0, box.f4391b1)]) - this.moments[getIndex(box.f4394r0, box.f4392g0, box.f4390b0)]) - (((double) (((iVolume * iVolume) + (iVolume2 * iVolume2)) + (iVolume3 * iVolume3))) / ((double) volume(box, this.weights)));
    }

    static int bottom(Box box, Direction direction, int[] iArr) {
        int i10;
        int i11;
        int iOrdinal = direction.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    i10 = (-iArr[getIndex(box.f4395r1, box.f4393g1, box.f4390b0)]) + iArr[getIndex(box.f4395r1, box.f4392g0, box.f4390b0)] + iArr[getIndex(box.f4394r0, box.f4393g1, box.f4390b0)];
                    i11 = iArr[getIndex(box.f4394r0, box.f4392g0, box.f4390b0)];
                } else {
                    throw new IllegalArgumentException("unexpected direction " + direction);
                }
            } else {
                i10 = (-iArr[getIndex(box.f4395r1, box.f4392g0, box.f4391b1)]) + iArr[getIndex(box.f4395r1, box.f4392g0, box.f4390b0)] + iArr[getIndex(box.f4394r0, box.f4392g0, box.f4391b1)];
                i11 = iArr[getIndex(box.f4394r0, box.f4392g0, box.f4390b0)];
            }
        } else {
            i10 = (-iArr[getIndex(box.f4394r0, box.f4393g1, box.f4391b1)]) + iArr[getIndex(box.f4394r0, box.f4393g1, box.f4390b0)] + iArr[getIndex(box.f4394r0, box.f4392g0, box.f4391b1)];
            i11 = iArr[getIndex(box.f4394r0, box.f4392g0, box.f4390b0)];
        }
        return i10 - i11;
    }

    static int top(Box box, Direction direction, int i10, int[] iArr) {
        int i11;
        int i12;
        int iOrdinal = direction.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    i11 = (iArr[getIndex(box.f4395r1, box.f4393g1, i10)] - iArr[getIndex(box.f4395r1, box.f4392g0, i10)]) - iArr[getIndex(box.f4394r0, box.f4393g1, i10)];
                    i12 = iArr[getIndex(box.f4394r0, box.f4392g0, i10)];
                } else {
                    throw new IllegalArgumentException("unexpected direction " + direction);
                }
            } else {
                i11 = (iArr[getIndex(box.f4395r1, i10, box.f4391b1)] - iArr[getIndex(box.f4395r1, i10, box.f4390b0)]) - iArr[getIndex(box.f4394r0, i10, box.f4391b1)];
                i12 = iArr[getIndex(box.f4394r0, i10, box.f4390b0)];
            }
        } else {
            i11 = (iArr[getIndex(i10, box.f4393g1, box.f4391b1)] - iArr[getIndex(i10, box.f4393g1, box.f4390b0)]) - iArr[getIndex(i10, box.f4392g0, box.f4391b1)];
            i12 = iArr[getIndex(i10, box.f4392g0, box.f4390b0)];
        }
        return i11 + i12;
    }

    void constructHistogram(Map<Integer, Integer> map) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int iRedFromArgb = ColorUtils.redFromArgb(iIntValue);
            int iGreenFromArgb = ColorUtils.greenFromArgb(iIntValue);
            int iBlueFromArgb = ColorUtils.blueFromArgb(iIntValue);
            int index = getIndex((iRedFromArgb >> 3) + 1, (iGreenFromArgb >> 3) + 1, (iBlueFromArgb >> 3) + 1);
            int[] iArr = this.weights;
            iArr[index] = iArr[index] + iIntValue2;
            int[] iArr2 = this.momentsR;
            iArr2[index] = iArr2[index] + (iRedFromArgb * iIntValue2);
            int[] iArr3 = this.momentsG;
            iArr3[index] = iArr3[index] + (iGreenFromArgb * iIntValue2);
            int[] iArr4 = this.momentsB;
            iArr4[index] = iArr4[index] + (iBlueFromArgb * iIntValue2);
            double[] dArr = this.moments;
            dArr[index] = dArr[index] + ((double) (iIntValue2 * ((iRedFromArgb * iRedFromArgb) + (iGreenFromArgb * iGreenFromArgb) + (iBlueFromArgb * iBlueFromArgb))));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class Box {

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        int f4390b0;

        /* JADX INFO: renamed from: b1, reason: collision with root package name */
        int f4391b1;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        int f4392g0;

        /* JADX INFO: renamed from: g1, reason: collision with root package name */
        int f4393g1;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        int f4394r0;

        /* JADX INFO: renamed from: r1, reason: collision with root package name */
        int f4395r1;
        int vol;

        private Box() {
            this.f4394r0 = 0;
            this.f4395r1 = 0;
            this.f4392g0 = 0;
            this.f4393g1 = 0;
            this.f4390b0 = 0;
            this.f4391b1 = 0;
            this.vol = 0;
        }

        /* synthetic */ Box(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
