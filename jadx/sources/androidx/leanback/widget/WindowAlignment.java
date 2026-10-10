package androidx.leanback.widget;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
final class WindowAlignment {
    public final Axis horizontal;
    private Axis mMainAxis;
    private int mOrientation = 0;
    private Axis mSecondAxis;
    public final Axis vertical;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class Axis {
        private static final int PF_KEYLINE_OVER_HIGH_EDGE = 2;
        private static final int PF_KEYLINE_OVER_LOW_EDGE = 1;
        private int mMaxEdge;
        private int mMaxScroll;
        private int mMinEdge;
        private int mMinScroll;
        private int mPaddingMax;
        private int mPaddingMin;
        private boolean mReversedFlow;
        private int mSize;
        private int mPreferredKeyLine = 2;
        private int mWindowAlignment = 3;
        private int mWindowAlignmentOffset = 0;
        private float mWindowAlignmentOffsetPercent = 50.0f;

        int calculateScrollToKeyLine(int i10, int i11) {
            return i10 - i11;
        }

        public void setWindowAlignmentOffsetPercent(float f10) {
            if ((f10 < 0.0f || f10 > 100.0f) && f10 != -1.0f) {
                throw new IllegalArgumentException();
            }
            this.mWindowAlignmentOffsetPercent = f10;
        }

        int calculateKeyline() {
            if (this.mReversedFlow) {
                int i10 = this.mWindowAlignmentOffset;
                int i11 = i10 >= 0 ? this.mSize - i10 : -i10;
                float f10 = this.mWindowAlignmentOffsetPercent;
                return f10 != -1.0f ? i11 - ((int) ((this.mSize * f10) / 100.0f)) : i11;
            }
            int i12 = this.mWindowAlignmentOffset;
            if (i12 < 0) {
                i12 += this.mSize;
            }
            float f11 = this.mWindowAlignmentOffsetPercent;
            return f11 != -1.0f ? i12 + ((int) ((this.mSize * f11) / 100.0f)) : i12;
        }

        public int getClientSize() {
            return (this.mSize - this.mPaddingMin) - this.mPaddingMax;
        }

        public int getMaxScroll() {
            return this.mMaxScroll;
        }

        public int getMinScroll() {
            return this.mMinScroll;
        }

        public int getPaddingMax() {
            return this.mPaddingMax;
        }

        public int getPaddingMin() {
            return this.mPaddingMin;
        }

        public int getSize() {
            return this.mSize;
        }

        public int getWindowAlignment() {
            return this.mWindowAlignment;
        }

        public int getWindowAlignmentOffset() {
            return this.mWindowAlignmentOffset;
        }

        public float getWindowAlignmentOffsetPercent() {
            return this.mWindowAlignmentOffsetPercent;
        }

        public void invalidateScrollMin() {
            this.mMinEdge = Integer.MIN_VALUE;
            this.mMinScroll = Integer.MIN_VALUE;
        }

        public boolean isMaxUnknown() {
            return this.mMaxEdge == Integer.MAX_VALUE;
        }

        public boolean isMinUnknown() {
            return this.mMinEdge == Integer.MIN_VALUE;
        }

        boolean isPreferKeylineOverHighEdge() {
            return (this.mPreferredKeyLine & 2) != 0;
        }

        boolean isPreferKeylineOverLowEdge() {
            return (this.mPreferredKeyLine & 1) != 0;
        }

        void reset() {
            this.mMinEdge = Integer.MIN_VALUE;
            this.mMaxEdge = Integer.MAX_VALUE;
        }

        public void setPadding(int i10, int i11) {
            this.mPaddingMin = i10;
            this.mPaddingMax = i11;
        }

        void setPreferKeylineOverHighEdge(boolean z10) {
            this.mPreferredKeyLine = z10 ? this.mPreferredKeyLine | 2 : this.mPreferredKeyLine & (-3);
        }

        void setPreferKeylineOverLowEdge(boolean z10) {
            this.mPreferredKeyLine = z10 ? this.mPreferredKeyLine | 1 : this.mPreferredKeyLine & (-2);
        }

        public void setReversedFlow(boolean z10) {
            this.mReversedFlow = z10;
        }

        public void setSize(int i10) {
            this.mSize = i10;
        }

        public void setWindowAlignment(int i10) {
            this.mWindowAlignment = i10;
        }

        public void setWindowAlignmentOffset(int i10) {
            this.mWindowAlignmentOffset = i10;
        }

        public String toString() {
            return " min:" + this.mMinEdge + " " + this.mMinScroll + " max:" + this.mMaxEdge + " " + this.mMaxScroll;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        
            r4.mMinScroll = r4.mMinEdge - r4.mPaddingMin;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        
            r4.mMaxScroll = (r4.mMaxEdge - r4.mPaddingMin) - r5;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void updateMinMax(int i10, int i11, int i12, int i13) {
            this.mMinEdge = i10;
            this.mMaxEdge = i11;
            int clientSize = getClientSize();
            int iCalculateKeyline = calculateKeyline();
            boolean zIsMinUnknown = isMinUnknown();
            boolean zIsMaxUnknown = isMaxUnknown();
            if (!zIsMinUnknown) {
                if (this.mReversedFlow) {
                    this.mMinScroll = calculateScrollToKeyLine(i12, iCalculateKeyline);
                } else {
                    this.mMinScroll = calculateScrollToKeyLine(i12, iCalculateKeyline);
                }
            }
            if (!zIsMaxUnknown) {
                if (this.mReversedFlow) {
                    this.mMaxScroll = calculateScrollToKeyLine(i13, iCalculateKeyline);
                } else {
                    this.mMaxScroll = calculateScrollToKeyLine(i13, iCalculateKeyline);
                }
            }
            if (zIsMaxUnknown || zIsMinUnknown) {
                return;
            }
            if (this.mReversedFlow) {
                int i14 = this.mWindowAlignment;
                if ((i14 & 1) != 0) {
                    if (isPreferKeylineOverLowEdge()) {
                        this.mMaxScroll = Math.max(this.mMaxScroll, calculateScrollToKeyLine(i12, iCalculateKeyline));
                    }
                    this.mMinScroll = Math.min(this.mMinScroll, this.mMaxScroll);
                    return;
                } else {
                    if ((i14 & 2) != 0) {
                        if (isPreferKeylineOverHighEdge()) {
                            this.mMinScroll = Math.min(this.mMinScroll, calculateScrollToKeyLine(i13, iCalculateKeyline));
                        }
                        this.mMaxScroll = Math.max(this.mMinScroll, this.mMaxScroll);
                        return;
                    }
                    return;
                }
            }
            int i15 = this.mWindowAlignment;
            if ((i15 & 1) != 0) {
                if (isPreferKeylineOverLowEdge()) {
                    this.mMinScroll = Math.min(this.mMinScroll, calculateScrollToKeyLine(i13, iCalculateKeyline));
                }
                this.mMaxScroll = Math.max(this.mMinScroll, this.mMaxScroll);
            } else if ((i15 & 2) != 0) {
                if (isPreferKeylineOverHighEdge()) {
                    this.mMaxScroll = Math.max(this.mMaxScroll, calculateScrollToKeyLine(i12, iCalculateKeyline));
                }
                this.mMinScroll = Math.min(this.mMinScroll, this.mMaxScroll);
            }
        }

        Axis(String str) {
            reset();
        }

        public int getScroll(int i10) {
            int i11;
            int i12;
            int size = getSize();
            int iCalculateKeyline = calculateKeyline();
            boolean zIsMinUnknown = isMinUnknown();
            boolean zIsMaxUnknown = isMaxUnknown();
            if (!zIsMinUnknown) {
                int i13 = this.mPaddingMin;
                int i14 = iCalculateKeyline - i13;
                if (this.mReversedFlow ? (this.mWindowAlignment & 2) != 0 : (this.mWindowAlignment & 1) != 0) {
                    int i15 = this.mMinEdge;
                    if (i10 - i15 <= i14) {
                        int i16 = i15 - i13;
                        if (!zIsMaxUnknown && i16 > (i12 = this.mMaxScroll)) {
                            return i12;
                        }
                        return i16;
                    }
                }
            }
            if (!zIsMaxUnknown) {
                int i17 = this.mPaddingMax;
                int i18 = (size - iCalculateKeyline) - i17;
                if (this.mReversedFlow ? (this.mWindowAlignment & 1) != 0 : (this.mWindowAlignment & 2) != 0) {
                    int i19 = this.mMaxEdge;
                    if (i19 - i10 <= i18) {
                        int i20 = i19 - (size - i17);
                        if (!zIsMinUnknown && i20 < (i11 = this.mMinScroll)) {
                            return i11;
                        }
                        return i20;
                    }
                }
            }
            return calculateScrollToKeyLine(i10, iCalculateKeyline);
        }

        public void invalidateScrollMax() {
            this.mMaxEdge = Integer.MAX_VALUE;
            this.mMaxScroll = Integer.MAX_VALUE;
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public Axis mainAxis() {
        return this.mMainAxis;
    }

    public Axis secondAxis() {
        return this.mSecondAxis;
    }

    public void setOrientation(int i10) {
        this.mOrientation = i10;
        if (i10 == 0) {
            this.mMainAxis = this.horizontal;
            this.mSecondAxis = this.vertical;
        } else {
            this.mMainAxis = this.vertical;
            this.mSecondAxis = this.horizontal;
        }
    }

    public String toString() {
        return "horizontal=" + this.horizontal + "; vertical=" + this.vertical;
    }

    WindowAlignment() {
        Axis axis = new Axis("vertical");
        this.vertical = axis;
        Axis axis2 = new Axis("horizontal");
        this.horizontal = axis2;
        this.mMainAxis = axis2;
        this.mSecondAxis = axis;
    }

    public void reset() {
        mainAxis().reset();
    }
}
