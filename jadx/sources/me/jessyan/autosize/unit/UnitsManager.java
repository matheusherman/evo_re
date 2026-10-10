package me.jessyan.autosize.unit;

import me.jessyan.autosize.utils.Preconditions;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class UnitsManager {
    private float mDesignHeight;
    private float mDesignWidth;
    private boolean isSupportDP = true;
    private boolean isSupportSP = true;
    private Subunits mSupportSubunits = Subunits.NONE;
    private boolean isSupportScreenSizeDP = false;

    public UnitsManager setDesignHeight(float f10) {
        Preconditions.checkArgument(f10 > 0.0f, "designHeight must be > 0");
        this.mDesignHeight = f10;
        return this;
    }

    public UnitsManager setDesignWidth(float f10) {
        Preconditions.checkArgument(f10 > 0.0f, "designWidth must be > 0");
        this.mDesignWidth = f10;
        return this;
    }

    public float getDesignHeight() {
        return this.mDesignHeight;
    }

    public float getDesignWidth() {
        return this.mDesignWidth;
    }

    public Subunits getSupportSubunits() {
        return this.mSupportSubunits;
    }

    public boolean isSupportDP() {
        return this.isSupportDP;
    }

    public boolean isSupportSP() {
        return this.isSupportSP;
    }

    public boolean isSupportScreenSizeDP() {
        return this.isSupportScreenSizeDP;
    }

    public UnitsManager setSupportDP(boolean z10) {
        this.isSupportDP = z10;
        return this;
    }

    public UnitsManager setSupportSP(boolean z10) {
        this.isSupportSP = z10;
        return this;
    }

    public UnitsManager setSupportScreenSizeDP(boolean z10) {
        this.isSupportScreenSizeDP = z10;
        return this;
    }

    public UnitsManager setSupportSubunits(Subunits subunits) {
        this.mSupportSubunits = (Subunits) Preconditions.checkNotNull(subunits, "The supportSubunits can not be null, use Subunits.NONE instead");
        return this;
    }

    public UnitsManager setDesignSize(float f10, float f11) {
        setDesignWidth(f10);
        setDesignHeight(f11);
        return this;
    }
}
