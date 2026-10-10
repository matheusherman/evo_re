package com.youth.banner.config;

import androidx.annotation.ColorInt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class IndicatorConfig {
    private int currentPosition;
    private int indicatorSize;
    private Margins margins;
    private int gravity = 1;
    private int indicatorSpace = BannerConfig.INDICATOR_SPACE;
    private int normalWidth = BannerConfig.INDICATOR_NORMAL_WIDTH;
    private int selectedWidth = BannerConfig.INDICATOR_SELECTED_WIDTH;

    @ColorInt
    private int normalColor = BannerConfig.INDICATOR_NORMAL_COLOR;

    @ColorInt
    private int selectedColor = BannerConfig.INDICATOR_SELECTED_COLOR;
    private int radius = BannerConfig.INDICATOR_RADIUS;
    private int height = BannerConfig.INDICATOR_HEIGHT;
    private boolean attachToBanner = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int CENTER = 1;
        public static final int LEFT = 0;
        public static final int RIGHT = 2;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class Margins {
        public int bottomMargin;
        public int leftMargin;
        public int rightMargin;
        public int topMargin;

        public Margins() {
            this(BannerConfig.INDICATOR_MARGIN);
        }

        public Margins(int i10) {
            this(i10, i10, i10, i10);
        }

        public Margins(int i10, int i11, int i12, int i13) {
            this.leftMargin = i10;
            this.topMargin = i11;
            this.rightMargin = i12;
            this.bottomMargin = i13;
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public int getGravity() {
        return this.gravity;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIndicatorSize() {
        return this.indicatorSize;
    }

    public int getIndicatorSpace() {
        return this.indicatorSpace;
    }

    public Margins getMargins() {
        if (this.margins == null) {
            setMargins(new Margins());
        }
        return this.margins;
    }

    public int getNormalColor() {
        return this.normalColor;
    }

    public int getNormalWidth() {
        return this.normalWidth;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getSelectedColor() {
        return this.selectedColor;
    }

    public int getSelectedWidth() {
        return this.selectedWidth;
    }

    public boolean isAttachToBanner() {
        return this.attachToBanner;
    }

    public IndicatorConfig setAttachToBanner(boolean z10) {
        this.attachToBanner = z10;
        return this;
    }

    public IndicatorConfig setCurrentPosition(int i10) {
        this.currentPosition = i10;
        return this;
    }

    public IndicatorConfig setGravity(int i10) {
        this.gravity = i10;
        return this;
    }

    public IndicatorConfig setHeight(int i10) {
        this.height = i10;
        return this;
    }

    public IndicatorConfig setIndicatorSize(int i10) {
        this.indicatorSize = i10;
        return this;
    }

    public IndicatorConfig setIndicatorSpace(int i10) {
        this.indicatorSpace = i10;
        return this;
    }

    public IndicatorConfig setMargins(Margins margins) {
        this.margins = margins;
        return this;
    }

    public IndicatorConfig setNormalColor(int i10) {
        this.normalColor = i10;
        return this;
    }

    public IndicatorConfig setNormalWidth(int i10) {
        this.normalWidth = i10;
        return this;
    }

    public IndicatorConfig setRadius(int i10) {
        this.radius = i10;
        return this;
    }

    public IndicatorConfig setSelectedColor(int i10) {
        this.selectedColor = i10;
        return this;
    }

    public IndicatorConfig setSelectedWidth(int i10) {
        this.selectedWidth = i10;
        return this;
    }
}
