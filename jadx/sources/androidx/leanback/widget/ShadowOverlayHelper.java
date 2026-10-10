package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class ShadowOverlayHelper {
    public static final int SHADOW_DYNAMIC = 3;
    public static final int SHADOW_NONE = 1;
    public static final int SHADOW_STATIC = 2;
    float mFocusedZ;
    boolean mNeedsOverlay;
    boolean mNeedsRoundedCorner;
    boolean mNeedsShadow;
    boolean mNeedsWrapper;
    int mRoundedCornerRadius;
    int mShadowType = 1;
    float mUnfocusedZ;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class Builder {
        private boolean keepForegroundDrawable;
        private boolean needsOverlay;
        private boolean needsRoundedCorner;
        private boolean needsShadow;
        private boolean preferZOrder = true;
        private Options options = Options.DEFAULT;

        public ShadowOverlayHelper build(Context context) {
            ShadowOverlayHelper shadowOverlayHelper = new ShadowOverlayHelper();
            shadowOverlayHelper.mNeedsOverlay = this.needsOverlay;
            boolean z10 = false;
            shadowOverlayHelper.mNeedsRoundedCorner = this.needsRoundedCorner && ShadowOverlayHelper.supportsRoundedCorner();
            shadowOverlayHelper.mNeedsShadow = this.needsShadow && ShadowOverlayHelper.supportsShadow();
            if (shadowOverlayHelper.mNeedsRoundedCorner) {
                shadowOverlayHelper.setupRoundedCornerRadius(this.options, context);
            }
            if (!shadowOverlayHelper.mNeedsShadow) {
                shadowOverlayHelper.mShadowType = 1;
                if ((!ShadowOverlayHelper.supportsForeground() || this.keepForegroundDrawable) && shadowOverlayHelper.mNeedsOverlay) {
                    z10 = true;
                }
                shadowOverlayHelper.mNeedsWrapper = z10;
                return shadowOverlayHelper;
            }
            if (!this.preferZOrder || !ShadowOverlayHelper.supportsDynamicShadow()) {
                shadowOverlayHelper.mShadowType = 2;
                shadowOverlayHelper.mNeedsWrapper = true;
                return shadowOverlayHelper;
            }
            shadowOverlayHelper.mShadowType = 3;
            shadowOverlayHelper.setupDynamicShadowZ(this.options, context);
            if ((!ShadowOverlayHelper.supportsForeground() || this.keepForegroundDrawable) && shadowOverlayHelper.mNeedsOverlay) {
                z10 = true;
            }
            shadowOverlayHelper.mNeedsWrapper = z10;
            return shadowOverlayHelper;
        }

        public Builder keepForegroundDrawable(boolean z10) {
            this.keepForegroundDrawable = z10;
            return this;
        }

        public Builder needsOverlay(boolean z10) {
            this.needsOverlay = z10;
            return this;
        }

        public Builder needsRoundedCorner(boolean z10) {
            this.needsRoundedCorner = z10;
            return this;
        }

        public Builder needsShadow(boolean z10) {
            this.needsShadow = z10;
            return this;
        }

        public Builder options(Options options) {
            this.options = options;
            return this;
        }

        public Builder preferZOrder(boolean z10) {
            this.preferZOrder = z10;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class Options {
        public static final Options DEFAULT = new Options();
        private int roundedCornerRadius = 0;
        private float dynamicShadowUnfocusedZ = -1.0f;
        private float dynamicShadowFocusedZ = -1.0f;

        public Options dynamicShadowZ(float f10, float f11) {
            this.dynamicShadowUnfocusedZ = f10;
            this.dynamicShadowFocusedZ = f11;
            return this;
        }

        public final float getDynamicShadowFocusedZ() {
            return this.dynamicShadowFocusedZ;
        }

        public final float getDynamicShadowUnfocusedZ() {
            return this.dynamicShadowUnfocusedZ;
        }

        public final int getRoundedCornerRadius() {
            return this.roundedCornerRadius;
        }

        public Options roundedCornerRadius(int i10) {
            this.roundedCornerRadius = i10;
            return this;
        }
    }

    public void setShadowFocusLevel(View view, float f10) {
        if (needsWrapper()) {
            ((ShadowOverlayContainer) view).setShadowFocusLevel(f10);
        } else {
            setShadowFocusLevel(getNoneWrapperDynamicShadowImpl(view), 3, f10);
        }
    }

    static Object getNoneWrapperDynamicShadowImpl(View view) {
        return view.getTag(androidx.leanback.R.id.lb_shadow_impl);
    }

    public int getShadowType() {
        return this.mShadowType;
    }

    public boolean needsOverlay() {
        return this.mNeedsOverlay;
    }

    public boolean needsRoundedCorner() {
        return this.mNeedsRoundedCorner;
    }

    public boolean needsWrapper() {
        return this.mNeedsWrapper;
    }

    public void prepareParentForShadow(ViewGroup viewGroup) {
        if (this.mShadowType == 2) {
            StaticShadowHelper.prepareParent(viewGroup);
        }
    }

    ShadowOverlayHelper() {
    }

    public static void setNoneWrapperOverlayColor(View view, int i10) {
        Drawable foreground = ForegroundHelper.getForeground(view);
        if (foreground instanceof ColorDrawable) {
            ((ColorDrawable) foreground).setColor(i10);
        } else {
            ForegroundHelper.setForeground(view, new ColorDrawable(i10));
        }
    }

    public static void setNoneWrapperShadowFocusLevel(View view, float f10) {
        setShadowFocusLevel(getNoneWrapperDynamicShadowImpl(view), 3, f10);
    }

    public static boolean supportsDynamicShadow() {
        return ShadowHelper.supportsDynamicShadow();
    }

    public static boolean supportsForeground() {
        return ForegroundHelper.supportsForeground();
    }

    public static boolean supportsRoundedCorner() {
        return RoundedRectHelper.supportsRoundedCorner();
    }

    public static boolean supportsShadow() {
        return StaticShadowHelper.supportsShadow();
    }

    public ShadowOverlayContainer createShadowOverlayContainer(Context context) {
        if (needsWrapper()) {
            return new ShadowOverlayContainer(context, this.mShadowType, this.mNeedsOverlay, this.mUnfocusedZ, this.mFocusedZ, this.mRoundedCornerRadius);
        }
        throw new IllegalArgumentException();
    }

    public void onViewCreated(View view) {
        if (!needsWrapper()) {
            if (!this.mNeedsShadow) {
                if (this.mNeedsRoundedCorner) {
                    RoundedRectHelper.setClipToRoundedOutline(view, true, this.mRoundedCornerRadius);
                }
            } else if (this.mShadowType == 3) {
                view.setTag(androidx.leanback.R.id.lb_shadow_impl, ShadowHelper.addDynamicShadow(view, this.mUnfocusedZ, this.mFocusedZ, this.mRoundedCornerRadius));
            } else if (this.mNeedsRoundedCorner) {
                RoundedRectHelper.setClipToRoundedOutline(view, true, this.mRoundedCornerRadius);
            }
        }
    }

    public void setOverlayColor(View view, int i10) {
        if (needsWrapper()) {
            ((ShadowOverlayContainer) view).setOverlayColor(i10);
        } else {
            setNoneWrapperOverlayColor(view, i10);
        }
    }

    void setupDynamicShadowZ(Options options, Context context) {
        if (options.getDynamicShadowUnfocusedZ() < 0.0f) {
            Resources resources = context.getResources();
            this.mFocusedZ = resources.getDimension(androidx.leanback.R.dimen.lb_material_shadow_focused_z);
            this.mUnfocusedZ = resources.getDimension(androidx.leanback.R.dimen.lb_material_shadow_normal_z);
        } else {
            this.mFocusedZ = options.getDynamicShadowFocusedZ();
            this.mUnfocusedZ = options.getDynamicShadowUnfocusedZ();
        }
    }

    void setupRoundedCornerRadius(Options options, Context context) {
        if (options.getRoundedCornerRadius() == 0) {
            this.mRoundedCornerRadius = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_rounded_rect_corner_radius);
        } else {
            this.mRoundedCornerRadius = options.getRoundedCornerRadius();
        }
    }

    static void setShadowFocusLevel(Object obj, int i10, float f10) {
        if (obj != null) {
            if (f10 < 0.0f) {
                f10 = 0.0f;
            } else if (f10 > 1.0f) {
                f10 = 1.0f;
            }
            if (i10 == 2) {
                StaticShadowHelper.setShadowFocusLevel(obj, f10);
            } else {
                if (i10 != 3) {
                    return;
                }
                ShadowHelper.setShadowFocusLevel(obj, f10);
            }
        }
    }
}
