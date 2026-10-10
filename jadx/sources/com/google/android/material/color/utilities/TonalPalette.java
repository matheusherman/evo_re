package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class KeyColor {
        private static final double MAX_CHROMA_VALUE = 200.0d;
        private final Map<Integer, Double> chromaCache = new HashMap();
        private final double hue;
        private final double requestedChroma;

        public Hct create() {
            int i10 = 100;
            int i11 = 0;
            while (i11 < i10) {
                int i12 = (i11 + i10) / 2;
                int i13 = i12 + 1;
                boolean z10 = maxChroma(i12) < maxChroma(i13);
                if (maxChroma(i12) >= this.requestedChroma - 0.01d) {
                    if (Math.abs(i11 - 50) < Math.abs(i10 - 50)) {
                        i10 = i12;
                    } else {
                        if (i11 == i12) {
                            return Hct.from(this.hue, this.requestedChroma, i11);
                        }
                        i11 = i12;
                    }
                } else if (z10) {
                    i11 = i13;
                } else {
                    i10 = i12;
                }
            }
            return Hct.from(this.hue, this.requestedChroma, i11);
        }

        private double maxChroma(int i10) {
            if (this.chromaCache.get(Integer.valueOf(i10)) == null) {
                this.chromaCache.put(Integer.valueOf(i10), Double.valueOf(Hct.from(this.hue, MAX_CHROMA_VALUE, i10).getChroma()));
            }
            return this.chromaCache.get(Integer.valueOf(i10)).doubleValue();
        }

        public KeyColor(double d10, double d11) {
            this.hue = d10;
            this.requestedChroma = d11;
        }
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d10, double d11) {
        return new TonalPalette(d10, d11, new KeyColor(d10, d11).create());
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d10) {
        return Hct.from(this.hue, this.chroma, d10);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int i10) {
        Integer numValueOf = this.cache.get(Integer.valueOf(i10));
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(Hct.from(this.hue, this.chroma, i10).toInt());
            this.cache.put(Integer.valueOf(i10), numValueOf);
        }
        return numValueOf.intValue();
    }

    private TonalPalette(double d10, double d11, Hct hct) {
        this.hue = d10;
        this.chroma = d11;
        this.keyColor = hct;
    }

    public static TonalPalette fromInt(int i10) {
        return fromHct(Hct.fromInt(i10));
    }
}
