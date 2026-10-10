package androidx.leanback.widget;

import android.animation.TimeAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.leanback.graphics.ColorOverlayDimmer;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class FocusHighlightHelper {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class BrowseItemFocusHighlight implements FocusHighlightHandler {
        private static final int DURATION_MS = 150;
        private int mScaleIndex;
        private final boolean mUseDimmer;

        private FocusAnimator getOrCreateAnimator(View view) {
            int i10 = androidx.leanback.R.id.lb_focus_animator;
            FocusAnimator focusAnimator = (FocusAnimator) view.getTag(i10);
            if (focusAnimator != null) {
                return focusAnimator;
            }
            FocusAnimator focusAnimator2 = new FocusAnimator(view, getScale(view.getResources()), this.mUseDimmer, DURATION_MS);
            view.setTag(i10, focusAnimator2);
            return focusAnimator2;
        }

        private float getScale(Resources resources) {
            int i10 = this.mScaleIndex;
            if (i10 == 0) {
                return 1.0f;
            }
            return resources.getFraction(FocusHighlightHelper.getResId(i10), 1, 1);
        }

        BrowseItemFocusHighlight(int i10, boolean z10) {
            if (FocusHighlightHelper.isValidZoomIndex(i10)) {
                this.mScaleIndex = i10;
                this.mUseDimmer = z10;
                return;
            }
            throw new IllegalArgumentException("Unhandled zoom index");
        }

        @Override // androidx.leanback.widget.FocusHighlightHandler
        public void onInitializeView(View view) {
            getOrCreateAnimator(view).animateFocus(false, true);
        }

        @Override // androidx.leanback.widget.FocusHighlightHandler
        public void onItemFocused(View view, boolean z10) {
            view.setSelected(z10);
            getOrCreateAnimator(view).animateFocus(z10, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class FocusAnimator implements TimeAnimator.TimeListener {
        private final TimeAnimator mAnimator;
        private final ColorOverlayDimmer mDimmer;
        private final int mDuration;
        private float mFocusLevel = 0.0f;
        private float mFocusLevelDelta;
        private float mFocusLevelStart;
        private final Interpolator mInterpolator;
        private final float mScaleDiff;
        private final View mView;
        private final ShadowOverlayContainer mWrapper;

        void endAnimation() {
            this.mAnimator.end();
        }

        float getFocusLevel() {
            return this.mFocusLevel;
        }

        @Override // android.animation.TimeAnimator.TimeListener
        public void onTimeUpdate(TimeAnimator timeAnimator, long j10, long j11) {
            float interpolation;
            int i10 = this.mDuration;
            if (j10 >= i10) {
                this.mAnimator.end();
                interpolation = 1.0f;
            } else {
                interpolation = (float) (j10 / ((double) i10));
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                interpolation = interpolator.getInterpolation(interpolation);
            }
            setFocusLevel(this.mFocusLevelStart + (interpolation * this.mFocusLevelDelta));
        }

        void setFocusLevel(float f10) {
            this.mFocusLevel = f10;
            float f11 = (this.mScaleDiff * f10) + 1.0f;
            this.mView.setScaleX(f11);
            this.mView.setScaleY(f11);
            ShadowOverlayContainer shadowOverlayContainer = this.mWrapper;
            if (shadowOverlayContainer != null) {
                shadowOverlayContainer.setShadowFocusLevel(f10);
            } else {
                ShadowOverlayHelper.setNoneWrapperShadowFocusLevel(this.mView, f10);
            }
            ColorOverlayDimmer colorOverlayDimmer = this.mDimmer;
            if (colorOverlayDimmer != null) {
                colorOverlayDimmer.setActiveLevel(f10);
                int color = this.mDimmer.getPaint().getColor();
                ShadowOverlayContainer shadowOverlayContainer2 = this.mWrapper;
                if (shadowOverlayContainer2 != null) {
                    shadowOverlayContainer2.setOverlayColor(color);
                } else {
                    ShadowOverlayHelper.setNoneWrapperOverlayColor(this.mView, color);
                }
            }
        }

        FocusAnimator(View view, float f10, boolean z10, int i10) {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.mAnimator = timeAnimator;
            this.mInterpolator = new AccelerateDecelerateInterpolator();
            this.mView = view;
            this.mDuration = i10;
            this.mScaleDiff = f10 - 1.0f;
            if (view instanceof ShadowOverlayContainer) {
                this.mWrapper = (ShadowOverlayContainer) view;
            } else {
                this.mWrapper = null;
            }
            timeAnimator.setTimeListener(this);
            if (z10) {
                this.mDimmer = ColorOverlayDimmer.createDefault(view.getContext());
            } else {
                this.mDimmer = null;
            }
        }

        void animateFocus(boolean z10, boolean z11) {
            float f10;
            endAnimation();
            if (z10) {
                f10 = 1.0f;
            } else {
                f10 = 0.0f;
            }
            if (z11) {
                setFocusLevel(f10);
                return;
            }
            float f11 = this.mFocusLevel;
            if (f11 != f10) {
                this.mFocusLevelStart = f11;
                this.mFocusLevelDelta = f10 - f11;
                this.mAnimator.start();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class HeaderItemFocusHighlight implements FocusHighlightHandler {
        private int mDuration;
        private boolean mInitialized;
        private float mSelectScale;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static class HeaderFocusAnimator extends FocusAnimator {
            ItemBridgeAdapter.ViewHolder mViewHolder;

            HeaderFocusAnimator(View view, float f10, int i10) {
                super(view, f10, false, i10);
                ViewParent parent = view.getParent();
                while (parent != null && !(parent instanceof RecyclerView)) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    this.mViewHolder = (ItemBridgeAdapter.ViewHolder) ((RecyclerView) parent).getChildViewHolder(view);
                }
            }

            @Override // androidx.leanback.widget.FocusHighlightHelper.FocusAnimator
            void setFocusLevel(float f10) {
                Presenter presenter = this.mViewHolder.getPresenter();
                if (presenter instanceof RowHeaderPresenter) {
                    ((RowHeaderPresenter) presenter).setSelectLevel((RowHeaderPresenter.ViewHolder) this.mViewHolder.getViewHolder(), f10);
                }
                super.setFocusLevel(f10);
            }
        }

        void lazyInit(View view) {
            if (this.mInitialized) {
                return;
            }
            Resources resources = view.getResources();
            TypedValue typedValue = new TypedValue();
            resources.getValue(androidx.leanback.R.dimen.lb_browse_header_select_scale, typedValue, true);
            this.mSelectScale = typedValue.getFloat();
            resources.getValue(androidx.leanback.R.dimen.lb_browse_header_select_duration, typedValue, true);
            this.mDuration = typedValue.data;
            this.mInitialized = true;
        }

        HeaderItemFocusHighlight() {
        }

        private void viewFocused(View view, boolean z10) {
            lazyInit(view);
            view.setSelected(z10);
            int i10 = androidx.leanback.R.id.lb_focus_animator;
            FocusAnimator headerFocusAnimator = (FocusAnimator) view.getTag(i10);
            if (headerFocusAnimator == null) {
                headerFocusAnimator = new HeaderFocusAnimator(view, this.mSelectScale, this.mDuration);
                view.setTag(i10, headerFocusAnimator);
            }
            headerFocusAnimator.animateFocus(z10, false);
        }

        @Override // androidx.leanback.widget.FocusHighlightHandler
        public void onItemFocused(View view, boolean z10) {
            viewFocused(view, z10);
        }

        @Override // androidx.leanback.widget.FocusHighlightHandler
        public void onInitializeView(View view) {
        }
    }

    static int getResId(int i10) {
        if (i10 == 1) {
            return androidx.leanback.R.fraction.lb_focus_zoom_factor_small;
        }
        if (i10 == 2) {
            return androidx.leanback.R.fraction.lb_focus_zoom_factor_medium;
        }
        if (i10 == 3) {
            return androidx.leanback.R.fraction.lb_focus_zoom_factor_large;
        }
        if (i10 != 4) {
            return 0;
        }
        return androidx.leanback.R.fraction.lb_focus_zoom_factor_xsmall;
    }

    @Deprecated
    public static void setupHeaderItemFocusHighlight(VerticalGridView verticalGridView) {
        setupHeaderItemFocusHighlight(verticalGridView, true);
    }

    static boolean isValidZoomIndex(int i10) {
        return i10 == 0 || getResId(i10) > 0;
    }

    public static void setupBrowseItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter, int i10, boolean z10) {
        if (i10 != 0 || z10) {
            itemBridgeAdapter.setFocusHighlight(new BrowseItemFocusHighlight(i10, z10));
        } else {
            itemBridgeAdapter.setFocusHighlight(null);
        }
    }

    @Deprecated
    public static void setupHeaderItemFocusHighlight(VerticalGridView verticalGridView, boolean z10) {
        if (verticalGridView == null || !(verticalGridView.getAdapter() instanceof ItemBridgeAdapter)) {
            return;
        }
        ((ItemBridgeAdapter) verticalGridView.getAdapter()).setFocusHighlight(z10 ? new HeaderItemFocusHighlight() : null);
    }

    @SuppressLint({"PrivateConstructorForUtilityClass"})
    @Deprecated
    public FocusHighlightHelper() {
    }

    public static void setupHeaderItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter) {
        setupHeaderItemFocusHighlight(itemBridgeAdapter, true);
    }

    public static void setupHeaderItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter, boolean z10) {
        itemBridgeAdapter.setFocusHighlight(z10 ? new HeaderItemFocusHighlight() : null);
    }
}
