package androidx.leanback.widget;

import androidx.collection.CircularIntArray;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
class SingleRow extends Grid {
    private final Grid.Location mTmpLocation = new Grid.Location(0);

    @Override // androidx.leanback.widget.Grid
    protected final boolean appendVisibleItems(int i10, boolean z10) {
        int edge;
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z10 && checkAppendOverLimit(i10)) {
            return false;
        }
        int startIndexForAppend = getStartIndexForAppend();
        boolean z11 = false;
        while (startIndexForAppend < this.mProvider.getCount()) {
            int iCreateItem = this.mProvider.createItem(startIndexForAppend, true, this.mTmpItem, false);
            if (this.mFirstVisibleIndex < 0 || this.mLastVisibleIndex < 0) {
                edge = this.mReversedFlow ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                this.mFirstVisibleIndex = startIndexForAppend;
                this.mLastVisibleIndex = startIndexForAppend;
            } else {
                if (this.mReversedFlow) {
                    int i11 = startIndexForAppend - 1;
                    edge = (this.mProvider.getEdge(i11) - this.mProvider.getSize(i11)) - this.mSpacing;
                } else {
                    int i12 = startIndexForAppend - 1;
                    edge = this.mProvider.getEdge(i12) + this.mProvider.getSize(i12) + this.mSpacing;
                }
                this.mLastVisibleIndex = startIndexForAppend;
            }
            this.mProvider.addItem(this.mTmpItem[0], startIndexForAppend, iCreateItem, 0, edge);
            if (z10 || checkAppendOverLimit(i10)) {
                return true;
            }
            startIndexForAppend++;
            z11 = true;
        }
        return z11;
    }

    @Override // androidx.leanback.widget.Grid
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int startIndexForPrepend;
        int edge;
        if (!this.mReversedFlow ? i11 < 0 : i11 > 0) {
            if (getLastVisibleIndex() == this.mProvider.getCount() - 1) {
                return;
            }
            startIndexForPrepend = getStartIndexForAppend();
            int size = this.mProvider.getSize(this.mLastVisibleIndex) + this.mSpacing;
            int edge2 = this.mProvider.getEdge(this.mLastVisibleIndex);
            if (this.mReversedFlow) {
                size = -size;
            }
            edge = size + edge2;
        } else {
            if (getFirstVisibleIndex() == 0) {
                return;
            }
            startIndexForPrepend = getStartIndexForPrepend();
            edge = this.mProvider.getEdge(this.mFirstVisibleIndex) + (this.mReversedFlow ? this.mSpacing : -this.mSpacing);
        }
        layoutPrefetchRegistry.addPosition(startIndexForPrepend, Math.abs(edge - i10));
    }

    @Override // androidx.leanback.widget.Grid
    public final void debugPrint(PrintWriter printWriter) {
        printWriter.print("SingleRow<");
        printWriter.print(this.mFirstVisibleIndex);
        printWriter.print(",");
        printWriter.print(this.mLastVisibleIndex);
        printWriter.print(">");
        printWriter.println();
    }

    @Override // androidx.leanback.widget.Grid
    protected final int findRowMax(boolean z10, int i10, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i10;
        }
        return this.mReversedFlow ? this.mProvider.getEdge(i10) : this.mProvider.getEdge(i10) + this.mProvider.getSize(i10);
    }

    @Override // androidx.leanback.widget.Grid
    protected final int findRowMin(boolean z10, int i10, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i10;
        }
        return this.mReversedFlow ? this.mProvider.getEdge(i10) - this.mProvider.getSize(i10) : this.mProvider.getEdge(i10);
    }

    @Override // androidx.leanback.widget.Grid
    public final CircularIntArray[] getItemPositionsInRows(int i10, int i11) {
        this.mTmpItemPositionsInRows[0].clear();
        this.mTmpItemPositionsInRows[0].addLast(i10);
        this.mTmpItemPositionsInRows[0].addLast(i11);
        return this.mTmpItemPositionsInRows;
    }

    @Override // androidx.leanback.widget.Grid
    public final Grid.Location getLocation(int i10) {
        return this.mTmpLocation;
    }

    int getStartIndexForAppend() {
        int i10 = this.mLastVisibleIndex;
        if (i10 >= 0) {
            return i10 + 1;
        }
        int i11 = this.mStartIndex;
        if (i11 != -1) {
            return Math.min(i11, this.mProvider.getCount() - 1);
        }
        return 0;
    }

    int getStartIndexForPrepend() {
        int i10 = this.mFirstVisibleIndex;
        if (i10 >= 0) {
            return i10 - 1;
        }
        int i11 = this.mStartIndex;
        return i11 != -1 ? Math.min(i11, this.mProvider.getCount() - 1) : this.mProvider.getCount() - 1;
    }

    @Override // androidx.leanback.widget.Grid
    protected final boolean prependVisibleItems(int i10, boolean z10) {
        int edge;
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z10 && checkPrependOverLimit(i10)) {
            return false;
        }
        int minIndex = this.mProvider.getMinIndex();
        boolean z11 = false;
        for (int startIndexForPrepend = getStartIndexForPrepend(); startIndexForPrepend >= minIndex; startIndexForPrepend--) {
            int iCreateItem = this.mProvider.createItem(startIndexForPrepend, false, this.mTmpItem, false);
            if (this.mFirstVisibleIndex < 0 || this.mLastVisibleIndex < 0) {
                edge = this.mReversedFlow ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                this.mFirstVisibleIndex = startIndexForPrepend;
                this.mLastVisibleIndex = startIndexForPrepend;
            } else {
                edge = this.mReversedFlow ? this.mProvider.getEdge(startIndexForPrepend + 1) + this.mSpacing + iCreateItem : (this.mProvider.getEdge(startIndexForPrepend + 1) - this.mSpacing) - iCreateItem;
                this.mFirstVisibleIndex = startIndexForPrepend;
            }
            this.mProvider.addItem(this.mTmpItem[0], startIndexForPrepend, iCreateItem, 0, edge);
            z11 = true;
            if (z10 || checkPrependOverLimit(i10)) {
                break;
            }
        }
        return z11;
    }

    SingleRow() {
        setNumRows(1);
    }
}
