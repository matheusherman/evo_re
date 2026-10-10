package androidx.leanback.widget;

import androidx.collection.CircularArray;
import androidx.collection.CircularIntArray;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
abstract class StaggeredGrid extends Grid {
    protected Object mPendingItem;
    protected int mPendingItemSize;
    protected CircularArray<Location> mLocations = new CircularArray<>(64);
    protected int mFirstIndex = -1;

    protected abstract boolean appendVisibleItemsWithoutCache(int i10, boolean z10);

    @Override // androidx.leanback.widget.Grid
    public final CircularIntArray[] getItemPositionsInRows(int i10, int i11) {
        for (int i12 = 0; i12 < this.mNumRows; i12++) {
            this.mTmpItemPositionsInRows[i12].clear();
        }
        if (i10 >= 0) {
            while (i10 <= i11) {
                CircularIntArray circularIntArray = this.mTmpItemPositionsInRows[getLocation(i10).mRow];
                if (circularIntArray.size() <= 0 || circularIntArray.getLast() != i10 - 1) {
                    circularIntArray.addLast(i10);
                    circularIntArray.addLast(i10);
                } else {
                    circularIntArray.popLast();
                    circularIntArray.addLast(i10);
                }
                i10++;
            }
        }
        return this.mTmpItemPositionsInRows;
    }

    protected abstract boolean prependVisibleItemsWithoutCache(int i10, boolean z10);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class Location extends Grid.Location {
        int mOffset;
        int mSize;

        Location(int i10, int i11, int i12) {
            super(i10);
            this.mOffset = i11;
            this.mSize = i12;
        }
    }

    protected final boolean appendVisbleItemsWithCache(int i10, boolean z10) {
        int i11;
        int edge;
        int i12;
        if (this.mLocations.size() == 0) {
            return false;
        }
        int count = this.mProvider.getCount();
        int i13 = this.mLastVisibleIndex;
        if (i13 >= 0) {
            i11 = i13 + 1;
            edge = this.mProvider.getEdge(i13);
        } else {
            int i14 = this.mStartIndex;
            i11 = i14 != -1 ? i14 : 0;
            if (i11 > getLastIndex() + 1 || i11 < getFirstIndex()) {
                this.mLocations.clear();
                return false;
            }
            if (i11 > getLastIndex()) {
                return false;
            }
            edge = Integer.MAX_VALUE;
        }
        int lastIndex = getLastIndex();
        int i15 = i11;
        while (i15 < count && i15 <= lastIndex) {
            Location location = getLocation(i15);
            if (edge != Integer.MAX_VALUE) {
                edge += location.mOffset;
            }
            int i16 = edge;
            int i17 = location.mRow;
            int iCreateItem = this.mProvider.createItem(i15, true, this.mTmpItem, false);
            if (iCreateItem != location.mSize) {
                location.mSize = iCreateItem;
                this.mLocations.removeFromEnd(lastIndex - i15);
                i12 = i15;
            } else {
                i12 = lastIndex;
            }
            this.mLastVisibleIndex = i15;
            if (this.mFirstVisibleIndex < 0) {
                this.mFirstVisibleIndex = i15;
            }
            this.mProvider.addItem(this.mTmpItem[0], i15, iCreateItem, i17, i16);
            if (!z10 && checkAppendOverLimit(i10)) {
                return true;
            }
            int edge2 = i16 == Integer.MAX_VALUE ? this.mProvider.getEdge(i15) : i16;
            if (i17 == this.mNumRows - 1 && z10) {
                return true;
            }
            i15++;
            lastIndex = i12;
            edge = edge2;
        }
        return false;
    }

    protected final int appendVisibleItemToRow(int i10, int i11, int i12) {
        int edge;
        int i13 = this.mLastVisibleIndex;
        if (i13 >= 0 && (i13 != getLastIndex() || this.mLastVisibleIndex != i10 - 1)) {
            throw new IllegalStateException();
        }
        int i14 = this.mLastVisibleIndex;
        if (i14 < 0) {
            edge = (this.mLocations.size() <= 0 || i10 != getLastIndex() + 1) ? 0 : calculateOffsetAfterLastItem(i11);
        } else {
            edge = i12 - this.mProvider.getEdge(i14);
        }
        Location location = new Location(i11, edge, 0);
        this.mLocations.addLast(location);
        Object obj = this.mPendingItem;
        if (obj != null) {
            location.mSize = this.mPendingItemSize;
            this.mPendingItem = null;
        } else {
            location.mSize = this.mProvider.createItem(i10, true, this.mTmpItem, false);
            obj = this.mTmpItem[0];
        }
        Object obj2 = obj;
        if (this.mLocations.size() == 1) {
            this.mLastVisibleIndex = i10;
            this.mFirstVisibleIndex = i10;
            this.mFirstIndex = i10;
        } else {
            int i15 = this.mLastVisibleIndex;
            if (i15 < 0) {
                this.mLastVisibleIndex = i10;
                this.mFirstVisibleIndex = i10;
            } else {
                this.mLastVisibleIndex = i15 + 1;
            }
        }
        this.mProvider.addItem(obj2, i10, location.mSize, i11, i12);
        return location.mSize;
    }

    @Override // androidx.leanback.widget.Grid
    protected final boolean appendVisibleItems(int i10, boolean z10) {
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z10 && checkAppendOverLimit(i10)) {
            return false;
        }
        try {
            if (appendVisbleItemsWithCache(i10, z10)) {
                return true;
            }
            return appendVisibleItemsWithoutCache(i10, z10);
        } finally {
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
        }
    }

    @Override // androidx.leanback.widget.Grid
    public final void debugPrint(PrintWriter printWriter) {
        int size = this.mLocations.size();
        for (int i10 = 0; i10 < size; i10++) {
            printWriter.print("<" + (this.mFirstIndex + i10) + "," + this.mLocations.get(i10).mRow + ">");
            printWriter.print(" ");
            printWriter.println();
        }
    }

    public final int getFirstIndex() {
        return this.mFirstIndex;
    }

    public final int getLastIndex() {
        return (this.mFirstIndex + this.mLocations.size()) - 1;
    }

    @Override // androidx.leanback.widget.Grid
    public final Location getLocation(int i10) {
        int i11 = i10 - this.mFirstIndex;
        if (i11 < 0 || i11 >= this.mLocations.size()) {
            return null;
        }
        return this.mLocations.get(i11);
    }

    public final int getSize() {
        return this.mLocations.size();
    }

    protected final boolean prependVisbleItemsWithCache(int i10, boolean z10) {
        int i11;
        int edge;
        int i12;
        if (this.mLocations.size() == 0) {
            return false;
        }
        int i13 = this.mFirstVisibleIndex;
        if (i13 >= 0) {
            edge = this.mProvider.getEdge(i13);
            i12 = getLocation(this.mFirstVisibleIndex).mOffset;
            i11 = this.mFirstVisibleIndex - 1;
        } else {
            int i14 = this.mStartIndex;
            i11 = i14 != -1 ? i14 : 0;
            if (i11 > getLastIndex() || i11 < getFirstIndex() - 1) {
                this.mLocations.clear();
                return false;
            }
            if (i11 < getFirstIndex()) {
                return false;
            }
            edge = Integer.MAX_VALUE;
            i12 = 0;
        }
        int iMax = Math.max(this.mProvider.getMinIndex(), this.mFirstIndex);
        for (int i15 = i11; i15 >= iMax; i15--) {
            Location location = getLocation(i15);
            int i16 = location.mRow;
            int iCreateItem = this.mProvider.createItem(i15, false, this.mTmpItem, false);
            if (iCreateItem != location.mSize) {
                this.mLocations.removeFromStart((i15 + 1) - this.mFirstIndex);
                this.mFirstIndex = this.mFirstVisibleIndex;
                this.mPendingItem = this.mTmpItem[0];
                this.mPendingItemSize = iCreateItem;
                return false;
            }
            this.mFirstVisibleIndex = i15;
            if (this.mLastVisibleIndex < 0) {
                this.mLastVisibleIndex = i15;
            }
            this.mProvider.addItem(this.mTmpItem[0], i15, iCreateItem, i16, edge - i12);
            if (!z10 && checkPrependOverLimit(i10)) {
                return true;
            }
            edge = this.mProvider.getEdge(i15);
            i12 = location.mOffset;
            if (i16 == 0 && z10) {
                return true;
            }
        }
        return false;
    }

    protected final int prependVisibleItemToRow(int i10, int i11, int i12) {
        int i13 = this.mFirstVisibleIndex;
        if (i13 >= 0 && (i13 != getFirstIndex() || this.mFirstVisibleIndex != i10 + 1)) {
            throw new IllegalStateException();
        }
        int i14 = this.mFirstIndex;
        Location location = i14 >= 0 ? getLocation(i14) : null;
        int edge = this.mProvider.getEdge(this.mFirstIndex);
        Location location2 = new Location(i11, 0, 0);
        this.mLocations.addFirst(location2);
        Object obj = this.mPendingItem;
        if (obj != null) {
            location2.mSize = this.mPendingItemSize;
            this.mPendingItem = null;
        } else {
            location2.mSize = this.mProvider.createItem(i10, false, this.mTmpItem, false);
            obj = this.mTmpItem[0];
        }
        Object obj2 = obj;
        this.mFirstVisibleIndex = i10;
        this.mFirstIndex = i10;
        if (this.mLastVisibleIndex < 0) {
            this.mLastVisibleIndex = i10;
        }
        int i15 = !this.mReversedFlow ? i12 - location2.mSize : i12 + location2.mSize;
        if (location != null) {
            location.mOffset = edge - i15;
        }
        this.mProvider.addItem(obj2, i10, location2.mSize, i11, i15);
        return location2.mSize;
    }

    @Override // androidx.leanback.widget.Grid
    protected final boolean prependVisibleItems(int i10, boolean z10) {
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z10 && checkPrependOverLimit(i10)) {
            return false;
        }
        try {
            if (prependVisbleItemsWithCache(i10, z10)) {
                return true;
            }
            return prependVisibleItemsWithoutCache(i10, z10);
        } finally {
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
        }
    }

    StaggeredGrid() {
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0039 -> B:17:0x003f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private int calculateOffsetAfterLastItem(int r3) {
        /*
            r2 = this;
            int r0 = r2.getLastIndex()
        L4:
            int r1 = r2.mFirstIndex
            if (r0 < r1) goto L14
            androidx.leanback.widget.StaggeredGrid$Location r1 = r2.getLocation(r0)
            int r1 = r1.mRow
            if (r1 != r3) goto L11
            goto L18
        L11:
            int r0 = r0 + (-1)
            goto L4
        L14:
            int r0 = r2.getLastIndex()
        L18:
            boolean r3 = r2.isReversedFlow()
            if (r3 == 0) goto L28
            androidx.leanback.widget.StaggeredGrid$Location r3 = r2.getLocation(r0)
            int r3 = r3.mSize
            int r3 = -r3
            int r1 = r2.mSpacing
            goto L3f
        L28:
            androidx.leanback.widget.StaggeredGrid$Location r3 = r2.getLocation(r0)
            int r3 = r3.mSize
            int r1 = r2.mSpacing
            int r3 = r3 + r1
        L31:
            int r0 = r0 + 1
            int r1 = r2.getLastIndex()
            if (r0 > r1) goto L41
            androidx.leanback.widget.StaggeredGrid$Location r1 = r2.getLocation(r0)
            int r1 = r1.mOffset
        L3f:
            int r3 = r3 - r1
            goto L31
        L41:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGrid.calculateOffsetAfterLastItem(int):int");
    }

    @Override // androidx.leanback.widget.Grid
    public void invalidateItemsAfter(int i10) {
        super.invalidateItemsAfter(i10);
        this.mLocations.removeFromEnd((getLastIndex() - i10) + 1);
        if (this.mLocations.size() == 0) {
            this.mFirstIndex = -1;
        }
    }
}
