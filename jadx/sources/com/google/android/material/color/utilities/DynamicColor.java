package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final ContrastCurve contrastCurve;
    private final HashMap<DynamicScheme, Hct> hctCache;
    public final boolean isBackground;
    public final String name;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, TonalPalette> palette;
    public final Function<DynamicScheme, DynamicColor> secondBackground;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaPair> toneDeltaPair;

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z10, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve, @Nullable Function<DynamicScheme, ToneDeltaPair> function5) {
        this.hctCache = new HashMap<>();
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z10;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve;
        this.toneDeltaPair = function5;
        this.opacity = null;
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2) {
        return new DynamicColor(str, function, function2, false, null, null, null, null);
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z10) {
        return new DynamicColor(str, function, function2, z10, null, null, null, null);
    }

    @NonNull
    public Hct getHct(@NonNull DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hct2 = ((TonalPalette) this.palette.apply(dynamicScheme)).getHct(getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, hct2);
        return hct2;
    }

    public double getTone(@NonNull DynamicScheme dynamicScheme) {
        double dMax;
        double dMin;
        boolean z10 = false;
        boolean z11 = dynamicScheme.contrastLevel < 0.0d;
        Function<DynamicScheme, ToneDeltaPair> function = this.toneDeltaPair;
        if (function == null) {
            boolean z12 = z11;
            double dDoubleValue = ((Double) this.tone.apply(dynamicScheme)).doubleValue();
            Function<DynamicScheme, DynamicColor> function2 = this.background;
            if (function2 == null) {
                return dDoubleValue;
            }
            double tone = ((DynamicColor) function2.apply(dynamicScheme)).getTone(dynamicScheme);
            double d10 = this.contrastCurve.get(dynamicScheme.contrastLevel);
            if (Contrast.ratioOfTones(tone, dDoubleValue) < d10) {
                dDoubleValue = foregroundTone(tone, d10);
            }
            if (z12) {
                dDoubleValue = foregroundTone(tone, d10);
            }
            if (this.isBackground && 50.0d <= dDoubleValue && dDoubleValue < 60.0d) {
                dDoubleValue = Contrast.ratioOfTones(49.0d, tone) >= d10 ? 49.0d : 60.0d;
            }
            if (this.secondBackground != null) {
                double tone2 = ((DynamicColor) this.background.apply(dynamicScheme)).getTone(dynamicScheme);
                double tone3 = ((DynamicColor) this.secondBackground.apply(dynamicScheme)).getTone(dynamicScheme);
                double dMax2 = Math.max(tone2, tone3);
                double dMin2 = Math.min(tone2, tone3);
                if (Contrast.ratioOfTones(dMax2, dDoubleValue) < d10 || Contrast.ratioOfTones(dMin2, dDoubleValue) < d10) {
                    double dLighter = Contrast.lighter(dMax2, d10);
                    double dDarker = Contrast.darker(dMin2, d10);
                    ArrayList arrayList = new ArrayList();
                    if (dLighter != -1.0d) {
                        arrayList.add(Double.valueOf(dLighter));
                    }
                    if (dDarker != -1.0d) {
                        arrayList.add(Double.valueOf(dDarker));
                    }
                    if (tonePrefersLightForeground(tone2) || tonePrefersLightForeground(tone3)) {
                        if (dLighter == -1.0d) {
                            return 100.0d;
                        }
                        return dLighter;
                    }
                    if (arrayList.size() == 1) {
                        return ((Double) arrayList.get(0)).doubleValue();
                    }
                    if (dDarker == -1.0d) {
                        return 0.0d;
                    }
                    return dDarker;
                }
            }
            return dDoubleValue;
        }
        ToneDeltaPair toneDeltaPair = (ToneDeltaPair) function.apply(dynamicScheme);
        DynamicColor roleA = toneDeltaPair.getRoleA();
        DynamicColor roleB = toneDeltaPair.getRoleB();
        double delta = toneDeltaPair.getDelta();
        TonePolarity polarity = toneDeltaPair.getPolarity();
        boolean stayTogether = toneDeltaPair.getStayTogether();
        double tone4 = ((DynamicColor) this.background.apply(dynamicScheme)).getTone(dynamicScheme);
        if (polarity == TonePolarity.NEARER || ((polarity == TonePolarity.LIGHTER && !dynamicScheme.isDark) || (polarity == TonePolarity.DARKER && dynamicScheme.isDark))) {
            z10 = true;
        }
        DynamicColor dynamicColor = z10 ? roleA : roleB;
        DynamicColor dynamicColor2 = z10 ? roleB : roleA;
        boolean zEquals = this.name.equals(dynamicColor.name);
        double d11 = dynamicScheme.isDark ? 1.0d : -1.0d;
        double d12 = dynamicColor.contrastCurve.get(dynamicScheme.contrastLevel);
        double d13 = dynamicColor2.contrastCurve.get(dynamicScheme.contrastLevel);
        boolean z13 = z11;
        double dDoubleValue2 = ((Double) dynamicColor.tone.apply(dynamicScheme)).doubleValue();
        if (Contrast.ratioOfTones(tone4, dDoubleValue2) < d12) {
            dDoubleValue2 = foregroundTone(tone4, d12);
        }
        double dDoubleValue3 = ((Double) dynamicColor2.tone.apply(dynamicScheme)).doubleValue();
        if (Contrast.ratioOfTones(tone4, dDoubleValue3) < d13) {
            dDoubleValue3 = foregroundTone(tone4, d13);
        }
        if (z13) {
            dDoubleValue2 = foregroundTone(tone4, d12);
            dDoubleValue3 = foregroundTone(tone4, d13);
        }
        if ((dDoubleValue3 - dDoubleValue2) * d11 < delta) {
            double d14 = delta * d11;
            double dClampDouble = MathUtils.clampDouble(0.0d, 100.0d, dDoubleValue2 + d14);
            if ((dClampDouble - dDoubleValue2) * d11 < delta) {
                dDoubleValue2 = MathUtils.clampDouble(0.0d, 100.0d, dClampDouble - d14);
            }
            dDoubleValue3 = dClampDouble;
        }
        if (50.0d > dDoubleValue2 || dDoubleValue2 >= 60.0d) {
            if (50.0d > dDoubleValue3 || dDoubleValue3 >= 60.0d) {
                dMax = dDoubleValue3;
            } else if (!stayTogether) {
                dMax = d11 > 0.0d ? 60.0d : 49.0d;
            } else if (d11 > 0.0d) {
                dMax = Math.max(dDoubleValue3, (delta * d11) + 60.0d);
                dDoubleValue2 = 60.0d;
            } else {
                dMin = Math.min(dDoubleValue3, (delta * d11) + 49.0d);
                dMax = dMin;
                dDoubleValue2 = 49.0d;
            }
        } else if (d11 > 0.0d) {
            dMax = Math.max(dDoubleValue3, (delta * d11) + 60.0d);
            dDoubleValue2 = 60.0d;
        } else {
            dMin = Math.min(dDoubleValue3, (delta * d11) + 49.0d);
            dMax = dMin;
            dDoubleValue2 = 49.0d;
        }
        return zEquals ? dDoubleValue2 : dMax;
    }

    public static double enableLightForeground(double d10) {
        if (tonePrefersLightForeground(d10) && !toneAllowsLightForeground(d10)) {
            return 49.0d;
        }
        return d10;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0045 A[RETURN] */
    public static double foregroundTone(double d10, double d11) {
        boolean z10;
        double dLighterUnsafe = Contrast.lighterUnsafe(d10, d11);
        double dDarkerUnsafe = Contrast.darkerUnsafe(d10, d11);
        double dRatioOfTones = Contrast.ratioOfTones(dLighterUnsafe, d10);
        double dRatioOfTones2 = Contrast.ratioOfTones(dDarkerUnsafe, d10);
        if (tonePrefersLightForeground(d10)) {
            if (Math.abs(dRatioOfTones - dRatioOfTones2) < 0.1d && dRatioOfTones < d11 && dRatioOfTones2 < d11) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (dRatioOfTones >= d11 || dRatioOfTones >= dRatioOfTones2 || z10) {
                return dLighterUnsafe;
            }
            return dDarkerUnsafe;
        }
        if (dRatioOfTones2 < d11 && dRatioOfTones2 < dRatioOfTones) {
            return dLighterUnsafe;
        }
        return dDarkerUnsafe;
    }

    @NonNull
    public static DynamicColor fromArgb(@NonNull String str, int i10) {
        final Hct hctFromInt = Hct.fromInt(i10);
        final TonalPalette tonalPaletteFromInt = TonalPalette.fromInt(i10);
        return fromPalette(str, new Function() { // from class: com.google.android.material.color.utilities.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DynamicColor.b(tonalPaletteFromInt, (DynamicScheme) obj);
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Double.valueOf(hctFromInt.getTone());
            }
        });
    }

    public static boolean toneAllowsLightForeground(double d10) {
        if (Math.round(d10) <= 49) {
            return true;
        }
        return false;
    }

    public static boolean tonePrefersLightForeground(double d10) {
        if (Math.round(d10) < 60) {
            return true;
        }
        return false;
    }

    public int getArgb(@NonNull DynamicScheme dynamicScheme) {
        int i10 = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function == null) {
            return i10;
        }
        return (MathUtils.clampInt(0, 255, (int) Math.round(((Double) function.apply(dynamicScheme)).doubleValue() * 255.0d)) << 24) | (i10 & ViewCompat.MEASURED_SIZE_MASK);
    }

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z10, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve, @Nullable Function<DynamicScheme, ToneDeltaPair> function5, @Nullable Function<DynamicScheme, Double> function6) {
        this.hctCache = new HashMap<>();
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z10;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve;
        this.toneDeltaPair = function5;
        this.opacity = function6;
    }

    public static /* synthetic */ TonalPalette b(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }
}
