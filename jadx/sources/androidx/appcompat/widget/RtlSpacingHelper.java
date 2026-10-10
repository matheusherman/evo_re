package androidx.appcompat.widget;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRtl = false;
    private boolean mIsRelative = false;

    public void setAbsolute(int i10, int i11) {
        this.mIsRelative = false;
        if (i10 != Integer.MIN_VALUE) {
            this.mExplicitLeft = i10;
            this.mLeft = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.mExplicitRight = i11;
            this.mRight = i11;
        }
    }

    public int getEnd() {
        return this.mIsRtl ? this.mLeft : this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        return this.mIsRtl ? this.mRight : this.mLeft;
    }

    public void setDirection(boolean z10) {
        if (z10 == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z10;
        if (!this.mIsRelative) {
            this.mLeft = this.mExplicitLeft;
            this.mRight = this.mExplicitRight;
            return;
        }
        if (z10) {
            int i10 = this.mEnd;
            if (i10 == Integer.MIN_VALUE) {
                i10 = this.mExplicitLeft;
            }
            this.mLeft = i10;
            int i11 = this.mStart;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.mExplicitRight;
            }
            this.mRight = i11;
            return;
        }
        int i12 = this.mStart;
        if (i12 == Integer.MIN_VALUE) {
            i12 = this.mExplicitLeft;
        }
        this.mLeft = i12;
        int i13 = this.mEnd;
        if (i13 == Integer.MIN_VALUE) {
            i13 = this.mExplicitRight;
        }
        this.mRight = i13;
    }

    public void setRelative(int i10, int i11) {
        this.mStart = i10;
        this.mEnd = i11;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i11 != Integer.MIN_VALUE) {
                this.mLeft = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.mRight = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.mLeft = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.mRight = i11;
        }
    }

    RtlSpacingHelper() {
    }
}
