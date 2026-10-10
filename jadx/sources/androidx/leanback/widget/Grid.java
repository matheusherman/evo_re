package androidx.leanback.widget;

import android.util.SparseIntArray;
import androidx.collection.CircularIntArray;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
abstract class Grid {
    static final int START_DEFAULT = -1;
    protected int mNumRows;
    protected Provider mProvider;
    protected boolean mReversedFlow;
    protected int mSpacing;
    protected CircularIntArray[] mTmpItemPositionsInRows;
    Object[] mTmpItem = new Object[1];
    protected int mFirstVisibleIndex = -1;
    protected int mLastVisibleIndex = -1;
    protected int mStartIndex = -1;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface Provider {
        void addItem(Object obj, int i10, int i11, int i12, int i13);

        int createItem(int i10, boolean z10, Object[] objArr, boolean z11);

        int getCount();

        int getEdge(int i10);

        int getMinIndex();

        int getSize(int i10);

        void removeItem(int i10);
    }

    public static Grid createGrid(int i10) {
        if (i10 == 1) {
            return new SingleRow();
        }
        StaggeredGridDefault staggeredGridDefault = new StaggeredGridDefault();
        staggeredGridDefault.setNumRows(i10);
        return staggeredGridDefault;
    }

    public final void appendVisibleItems(int i10) {
        appendVisibleItems(i10, false);
    }

    protected abstract boolean appendVisibleItems(int i10, boolean z10);

    public abstract void debugPrint(PrintWriter printWriter);

    protected abstract int findRowMax(boolean z10, int i10, int[] iArr);

    public final int findRowMax(boolean z10, int[] iArr) {
        return findRowMax(z10, this.mReversedFlow ? this.mFirstVisibleIndex : this.mLastVisibleIndex, iArr);
    }

    protected abstract int findRowMin(boolean z10, int i10, int[] iArr);

    public final int findRowMin(boolean z10, int[] iArr) {
        return findRowMin(z10, this.mReversedFlow ? this.mLastVisibleIndex : this.mFirstVisibleIndex, iArr);
    }

    public final CircularIntArray[] getItemPositionsInRows() {
        return getItemPositionsInRows(getFirstVisibleIndex(), getLastVisibleIndex());
    }

    public abstract CircularIntArray[] getItemPositionsInRows(int i10, int i11);

    public abstract Location getLocation(int i10);

    public final void prependVisibleItems(int i10) {
        prependVisibleItems(i10, false);
    }

    protected abstract boolean prependVisibleItems(int i10, boolean z10);

    public void resetVisibleIndex() {
        this.mLastVisibleIndex = -1;
        this.mFirstVisibleIndex = -1;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class Location {
        int mRow;

        Location(int i10) {
            this.mRow = i10;
        }
    }

    private void resetVisibleIndexIfEmpty() {
        if (this.mLastVisibleIndex < this.mFirstVisibleIndex) {
            resetVisibleIndex();
        }
    }

    public boolean appendOneColumnVisibleItems() {
        return appendVisibleItems(this.mReversedFlow ? Integer.MAX_VALUE : Integer.MIN_VALUE, true);
    }

    protected final boolean checkAppendOverLimit(int i10) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        if (this.mReversedFlow) {
            return findRowMin(true, null) <= i10 + this.mSpacing;
        }
        return findRowMax(false, null) >= i10 - this.mSpacing;
    }

    protected final boolean checkPrependOverLimit(int i10) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        if (this.mReversedFlow) {
            return findRowMax(false, null) >= i10 - this.mSpacing;
        }
        return findRowMin(true, null) <= i10 + this.mSpacing;
    }

    public final int getFirstVisibleIndex() {
        return this.mFirstVisibleIndex;
    }

    public final int getLastVisibleIndex() {
        return this.mLastVisibleIndex;
    }

    public int getNumRows() {
        return this.mNumRows;
    }

    public void invalidateItemsAfter(int i10) {
        int i11;
        if (i10 >= 0 && (i11 = this.mLastVisibleIndex) >= 0) {
            if (i11 >= i10) {
                this.mLastVisibleIndex = i10 - 1;
            }
            resetVisibleIndexIfEmpty();
            if (getFirstVisibleIndex() < 0) {
                setStart(i10);
            }
        }
    }

    public boolean isReversedFlow() {
        return this.mReversedFlow;
    }

    public final boolean prependOneColumnVisibleItems() {
        return prependVisibleItems(this.mReversedFlow ? Integer.MIN_VALUE : Integer.MAX_VALUE, true);
    }

    public void removeInvisibleItemsAtEnd(int i10, int i11) {
        while (true) {
            int i12 = this.mLastVisibleIndex;
            if (i12 >= this.mFirstVisibleIndex && i12 > i10) {
                if (!this.mReversedFlow) {
                    if (this.mProvider.getEdge(i12) < i11) {
                        break;
                    }
                    this.mProvider.removeItem(this.mLastVisibleIndex);
                    this.mLastVisibleIndex--;
                } else {
                    if (this.mProvider.getEdge(i12) > i11) {
                        break;
                    }
                    this.mProvider.removeItem(this.mLastVisibleIndex);
                    this.mLastVisibleIndex--;
                }
            } else {
                break;
            }
        }
        resetVisibleIndexIfEmpty();
    }

    public void removeInvisibleItemsAtFront(int i10, int i11) {
        while (true) {
            int i12 = this.mLastVisibleIndex;
            int i13 = this.mFirstVisibleIndex;
            if (i12 >= i13 && i13 < i10) {
                int size = this.mProvider.getSize(i13);
                if (!this.mReversedFlow) {
                    if (this.mProvider.getEdge(this.mFirstVisibleIndex) + size > i11) {
                        break;
                    }
                    this.mProvider.removeItem(this.mFirstVisibleIndex);
                    this.mFirstVisibleIndex++;
                } else {
                    if (this.mProvider.getEdge(this.mFirstVisibleIndex) - size < i11) {
                        break;
                    }
                    this.mProvider.removeItem(this.mFirstVisibleIndex);
                    this.mFirstVisibleIndex++;
                }
            } else {
                break;
            }
        }
        resetVisibleIndexIfEmpty();
    }

    void setNumRows(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException();
        }
        if (this.mNumRows == i10) {
            return;
        }
        this.mNumRows = i10;
        this.mTmpItemPositionsInRows = new CircularIntArray[i10];
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            this.mTmpItemPositionsInRows[i11] = new CircularIntArray();
        }
    }

    public void setProvider(Provider provider) {
        this.mProvider = provider;
    }

    public final void setReversedFlow(boolean z10) {
        this.mReversedFlow = z10;
    }

    public final void setSpacing(int i10) {
        this.mSpacing = i10;
    }

    public void setStart(int i10) {
        this.mStartIndex = i10;
    }

    Grid() {
    }

    public void fillDisappearingItems(int[] iArr, int i10, SparseIntArray sparseIntArray) {
        int iBinarySearch;
        int iBinarySearch2;
        int edge;
        int i11;
        int i12;
        int edge2;
        int i13;
        int lastVisibleIndex = getLastVisibleIndex();
        if (lastVisibleIndex >= 0) {
            iBinarySearch = Arrays.binarySearch(iArr, 0, i10, lastVisibleIndex);
        } else {
            iBinarySearch = 0;
        }
        if (iBinarySearch < 0) {
            if (this.mReversedFlow) {
                edge2 = (this.mProvider.getEdge(lastVisibleIndex) - this.mProvider.getSize(lastVisibleIndex)) - this.mSpacing;
            } else {
                edge2 = this.mProvider.getEdge(lastVisibleIndex) + this.mProvider.getSize(lastVisibleIndex) + this.mSpacing;
            }
            int i14 = edge2;
            for (int i15 = (-iBinarySearch) - 1; i15 < i10; i15++) {
                int i16 = iArr[i15];
                int i17 = sparseIntArray.get(i16);
                if (i17 < 0) {
                    i13 = 0;
                } else {
                    i13 = i17;
                }
                int iCreateItem = this.mProvider.createItem(i16, true, this.mTmpItem, true);
                this.mProvider.addItem(this.mTmpItem[0], i16, iCreateItem, i13, i14);
                if (this.mReversedFlow) {
                    i14 = (i14 - iCreateItem) - this.mSpacing;
                } else {
                    i14 = i14 + iCreateItem + this.mSpacing;
                }
            }
        }
        int firstVisibleIndex = getFirstVisibleIndex();
        if (firstVisibleIndex >= 0) {
            iBinarySearch2 = Arrays.binarySearch(iArr, 0, i10, firstVisibleIndex);
        } else {
            iBinarySearch2 = 0;
        }
        if (iBinarySearch2 < 0) {
            int i18 = (-iBinarySearch2) - 2;
            if (this.mReversedFlow) {
                edge = this.mProvider.getEdge(firstVisibleIndex);
            } else {
                edge = this.mProvider.getEdge(firstVisibleIndex);
            }
            while (i18 >= 0) {
                int i19 = iArr[i18];
                int i20 = sparseIntArray.get(i19);
                if (i20 < 0) {
                    i11 = 0;
                } else {
                    i11 = i20;
                }
                int iCreateItem2 = this.mProvider.createItem(i19, false, this.mTmpItem, true);
                if (this.mReversedFlow) {
                    i12 = edge + this.mSpacing + iCreateItem2;
                } else {
                    i12 = (edge - this.mSpacing) - iCreateItem2;
                }
                int i21 = i12;
                this.mProvider.addItem(this.mTmpItem[0], i19, iCreateItem2, i11, i21);
                i18--;
                edge = i21;
            }
        }
    }

    public final int getRowIndex(int i10) {
        Location location = getLocation(i10);
        if (location == null) {
            return -1;
        }
        return location.mRow;
    }

    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
    }
}
