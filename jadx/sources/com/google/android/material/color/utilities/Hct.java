package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Hct {
    private int argb;
    private double chroma;
    private double hue;
    private double tone;

    public static Hct fromInt(int i10) {
        return new Hct(i10);
    }

    private void setInternalState(int i10) {
        this.argb = i10;
        Cam16 cam16FromInt = Cam16.fromInt(i10);
        this.hue = cam16FromInt.getHue();
        this.chroma = cam16FromInt.getChroma();
        this.tone = ColorUtils.lstarFromArgb(i10);
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getTone() {
        return this.tone;
    }

    public void setChroma(double d10) {
        setInternalState(HctSolver.solveToInt(this.hue, d10, this.tone));
    }

    public void setHue(double d10) {
        setInternalState(HctSolver.solveToInt(d10, this.chroma, this.tone));
    }

    public void setTone(double d10) {
        setInternalState(HctSolver.solveToInt(this.hue, this.chroma, d10));
    }

    public int toInt() {
        return this.argb;
    }

    private Hct(int i10) {
        setInternalState(i10);
    }

    public static Hct from(double d10, double d11, double d12) {
        return new Hct(HctSolver.solveToInt(d10, d11, d12));
    }

    public Hct inViewingConditions(ViewingConditions viewingConditions) {
        double[] dArrXyzInViewingConditions = Cam16.fromInt(toInt()).xyzInViewingConditions(viewingConditions, null);
        Cam16 cam16FromXyzInViewingConditions = Cam16.fromXyzInViewingConditions(dArrXyzInViewingConditions[0], dArrXyzInViewingConditions[1], dArrXyzInViewingConditions[2], ViewingConditions.DEFAULT);
        return from(cam16FromXyzInViewingConditions.getHue(), cam16FromXyzInViewingConditions.getChroma(), ColorUtils.lstarFromY(dArrXyzInViewingConditions[1]));
    }
}
