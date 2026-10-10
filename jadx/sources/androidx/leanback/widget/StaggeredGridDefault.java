package androidx.leanback.widget;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
final class StaggeredGridDefault extends StaggeredGrid {
    private int findRowEdgeLimitSearchIndex(boolean z10) {
        boolean z11 = false;
        if (z10) {
            for (int i10 = this.mLastVisibleIndex; i10 >= this.mFirstVisibleIndex; i10--) {
                int i11 = getLocation(i10).mRow;
                if (i11 == 0) {
                    z11 = true;
                } else if (z11 && i11 == this.mNumRows - 1) {
                    return i10;
                }
            }
            return -1;
        }
        for (int i12 = this.mFirstVisibleIndex; i12 <= this.mLastVisibleIndex; i12++) {
            int i13 = getLocation(i12).mRow;
            if (i13 == this.mNumRows - 1) {
                z11 = true;
            } else if (z11 && i13 == 0) {
                return i12;
            }
        }
        return -1;
    }

    @Override // androidx.leanback.widget.StaggeredGrid
    protected boolean appendVisibleItemsWithoutCache(int i10, boolean z10) {
        int i11;
        int i12;
        boolean z11;
        int rowMin;
        int i13;
        int i14;
        int count = this.mProvider.getCount();
        int i15 = this.mLastVisibleIndex;
        if (i15 < 0) {
            int i16 = this.mStartIndex;
            i11 = i16 != -1 ? i16 : 0;
            i12 = (this.mLocations.size() > 0 ? getLocation(getLastIndex()).mRow + 1 : i11) % this.mNumRows;
            z11 = false;
            rowMin = 0;
        } else {
            if (i15 < getLastIndex()) {
                return false;
            }
            int i17 = this.mLastVisibleIndex;
            i11 = i17 + 1;
            i12 = getLocation(i17).mRow;
            int iFindRowEdgeLimitSearchIndex = findRowEdgeLimitSearchIndex(true);
            if (iFindRowEdgeLimitSearchIndex < 0) {
                rowMin = Integer.MIN_VALUE;
                for (int i18 = 0; i18 < this.mNumRows; i18++) {
                    rowMin = this.mReversedFlow ? getRowMin(i18) : getRowMax(i18);
                    if (rowMin != Integer.MIN_VALUE) {
                        break;
                    }
                }
            } else {
                rowMin = this.mReversedFlow ? findRowMin(false, iFindRowEdgeLimitSearchIndex, null) : findRowMax(true, iFindRowEdgeLimitSearchIndex, null);
            }
            if (!this.mReversedFlow ? getRowMax(i12) >= rowMin : getRowMin(i12) <= rowMin) {
                i12++;
                if (i12 == this.mNumRows) {
                    rowMin = this.mReversedFlow ? findRowMin(false, null) : findRowMax(true, null);
                    i12 = 0;
                }
            }
            z11 = true;
        }
        boolean z12 = false;
        while (true) {
            if (i12 < this.mNumRows) {
                if (i11 == count || (!z10 && checkAppendOverLimit(i10))) {
                    break;
                }
                int rowMin2 = this.mReversedFlow ? getRowMin(i12) : getRowMax(i12);
                if (rowMin2 != Integer.MAX_VALUE && rowMin2 != Integer.MIN_VALUE) {
                    if (this.mReversedFlow) {
                        i14 = this.mSpacing;
                        i13 = -i14;
                    } else {
                        i13 = this.mSpacing;
                    }
                    rowMin2 += i13;
                } else if (i12 == 0) {
                    rowMin2 = this.mReversedFlow ? getRowMin(this.mNumRows - 1) : getRowMax(this.mNumRows - 1);
                    if (rowMin2 != Integer.MAX_VALUE && rowMin2 != Integer.MIN_VALUE) {
                        if (this.mReversedFlow) {
                            i14 = this.mSpacing;
                            i13 = -i14;
                        } else {
                            i13 = this.mSpacing;
                        }
                        rowMin2 += i13;
                    }
                } else {
                    rowMin2 = this.mReversedFlow ? getRowMax(i12 - 1) : getRowMin(i12 - 1);
                }
                int i19 = i11 + 1;
                int iAppendVisibleItemToRow = appendVisibleItemToRow(i11, i12, rowMin2);
                if (z11) {
                    while (true) {
                        if (!this.mReversedFlow) {
                            if (rowMin2 + iAppendVisibleItemToRow >= rowMin) {
                                break;
                            }
                            if (i19 != count) {
                            }
                            return true;
                        }
                        if (rowMin2 - iAppendVisibleItemToRow <= rowMin) {
                            break;
                        }
                        if (i19 != count || (!z10 && checkAppendOverLimit(i10))) {
                            return true;
                        }
                        rowMin2 += this.mReversedFlow ? (-iAppendVisibleItemToRow) - this.mSpacing : iAppendVisibleItemToRow + this.mSpacing;
                        int i20 = i19 + 1;
                        int iAppendVisibleItemToRow2 = appendVisibleItemToRow(i19, i12, rowMin2);
                        i19 = i20;
                        iAppendVisibleItemToRow = iAppendVisibleItemToRow2;
                    }
                } else {
                    rowMin = this.mReversedFlow ? getRowMin(i12) : getRowMax(i12);
                    z11 = true;
                }
                i11 = i19;
                i12++;
                z12 = true;
            } else {
                if (z10) {
                    break;
                }
                rowMin = this.mReversedFlow ? findRowMin(false, null) : findRowMax(true, null);
                i12 = 0;
            }
        }
        return z12;
    }

    @Override // androidx.leanback.widget.Grid
    public int findRowMax(boolean z10, int i10, int[] iArr) {
        int i11;
        int edge = this.mProvider.getEdge(i10);
        StaggeredGrid.Location location = getLocation(i10);
        int i12 = location.mRow;
        if (this.mReversedFlow) {
            i11 = i12;
            int i13 = i11;
            int i14 = 1;
            int i15 = edge;
            for (int i16 = i10 + 1; i14 < this.mNumRows && i16 <= this.mLastVisibleIndex; i16++) {
                StaggeredGrid.Location location2 = getLocation(i16);
                i15 += location2.mOffset;
                int i17 = location2.mRow;
                if (i17 != i13) {
                    i14++;
                    if (!z10 ? i15 >= edge : i15 <= edge) {
                        i13 = i17;
                    } else {
                        edge = i15;
                        i10 = i16;
                        i11 = i17;
                        i13 = i11;
                    }
                }
            }
        } else {
            int i18 = 1;
            int i19 = i12;
            StaggeredGrid.Location location3 = location;
            int i20 = edge;
            edge = this.mProvider.getSize(i10) + edge;
            i11 = i19;
            for (int i21 = i10 - 1; i18 < this.mNumRows && i21 >= this.mFirstVisibleIndex; i21--) {
                i20 -= location3.mOffset;
                location3 = getLocation(i21);
                int i22 = location3.mRow;
                if (i22 != i19) {
                    i18++;
                    int size = this.mProvider.getSize(i21) + i20;
                    if (!z10 ? size >= edge : size <= edge) {
                        i19 = i22;
                    } else {
                        edge = size;
                        i10 = i21;
                        i11 = i22;
                        i19 = i11;
                    }
                }
            }
        }
        if (iArr != null) {
            iArr[0] = i11;
            iArr[1] = i10;
        }
        return edge;
    }

    @Override // androidx.leanback.widget.Grid
    public int findRowMin(boolean z10, int i10, int[] iArr) {
        int size;
        int edge = this.mProvider.getEdge(i10);
        StaggeredGrid.Location location = getLocation(i10);
        int i11 = location.mRow;
        if (this.mReversedFlow) {
            int i12 = 1;
            size = edge - this.mProvider.getSize(i10);
            int i13 = i11;
            for (int i14 = i10 - 1; i12 < this.mNumRows && i14 >= this.mFirstVisibleIndex; i14--) {
                edge -= location.mOffset;
                location = getLocation(i14);
                int i15 = location.mRow;
                if (i15 != i13) {
                    i12++;
                    int size2 = edge - this.mProvider.getSize(i14);
                    if (!z10 ? size2 >= size : size2 <= size) {
                        i13 = i15;
                    } else {
                        size = size2;
                        i10 = i14;
                        i11 = i15;
                        i13 = i11;
                    }
                }
            }
        } else {
            int i16 = i11;
            int i17 = i16;
            int i18 = 1;
            int i19 = edge;
            for (int i20 = i10 + 1; i18 < this.mNumRows && i20 <= this.mLastVisibleIndex; i20++) {
                StaggeredGrid.Location location2 = getLocation(i20);
                i19 += location2.mOffset;
                int i21 = location2.mRow;
                if (i21 != i17) {
                    i18++;
                    if (!z10 ? i19 >= edge : i19 <= edge) {
                        i17 = i21;
                    } else {
                        edge = i19;
                        i10 = i20;
                        i16 = i21;
                        i17 = i16;
                    }
                }
            }
            size = edge;
            i11 = i16;
        }
        if (iArr != null) {
            iArr[0] = i11;
            iArr[1] = i10;
        }
        return size;
    }

    int getRowMax(int i10) {
        int i11;
        StaggeredGrid.Location location;
        int i12 = this.mFirstVisibleIndex;
        if (i12 < 0) {
            return Integer.MIN_VALUE;
        }
        if (this.mReversedFlow) {
            int edge = this.mProvider.getEdge(i12);
            if (getLocation(this.mFirstVisibleIndex).mRow == i10) {
                return edge;
            }
            int i13 = this.mFirstVisibleIndex;
            do {
                i13++;
                if (i13 <= getLastIndex()) {
                    location = getLocation(i13);
                    edge += location.mOffset;
                }
            } while (location.mRow != i10);
            return edge;
        }
        int edge2 = this.mProvider.getEdge(this.mLastVisibleIndex);
        StaggeredGrid.Location location2 = getLocation(this.mLastVisibleIndex);
        if (location2.mRow == i10) {
            i11 = location2.mSize;
        } else {
            int i14 = this.mLastVisibleIndex;
            do {
                i14--;
                if (i14 >= getFirstIndex()) {
                    edge2 -= location2.mOffset;
                    location2 = getLocation(i14);
                }
            } while (location2.mRow != i10);
            i11 = location2.mSize;
        }
        return edge2 + i11;
        return Integer.MIN_VALUE;
    }

    int getRowMin(int i10) {
        StaggeredGrid.Location location;
        int i11;
        int i12 = this.mFirstVisibleIndex;
        if (i12 < 0) {
            return Integer.MAX_VALUE;
        }
        if (!this.mReversedFlow) {
            int edge = this.mProvider.getEdge(i12);
            if (getLocation(this.mFirstVisibleIndex).mRow == i10) {
                return edge;
            }
            int i13 = this.mFirstVisibleIndex;
            do {
                i13++;
                if (i13 <= getLastIndex()) {
                    location = getLocation(i13);
                    edge += location.mOffset;
                }
            } while (location.mRow != i10);
            return edge;
        }
        int edge2 = this.mProvider.getEdge(this.mLastVisibleIndex);
        StaggeredGrid.Location location2 = getLocation(this.mLastVisibleIndex);
        if (location2.mRow == i10) {
            i11 = location2.mSize;
        } else {
            int i14 = this.mLastVisibleIndex;
            do {
                i14--;
                if (i14 >= getFirstIndex()) {
                    edge2 -= location2.mOffset;
                    location2 = getLocation(i14);
                }
            } while (location2.mRow != i10);
            i11 = location2.mSize;
        }
        return edge2 - i11;
        return Integer.MAX_VALUE;
    }

    @Override // androidx.leanback.widget.StaggeredGrid
    protected boolean prependVisibleItemsWithoutCache(int i10, boolean z10) {
        int i11;
        int i12;
        boolean z11;
        int rowMax;
        int i13;
        int i14;
        int i15 = this.mFirstVisibleIndex;
        if (i15 < 0) {
            int i16 = this.mStartIndex;
            i11 = i16 != -1 ? i16 : 0;
            i12 = (this.mLocations.size() > 0 ? (getLocation(getFirstIndex()).mRow + this.mNumRows) - 1 : i11) % this.mNumRows;
            z11 = false;
            rowMax = 0;
        } else {
            if (i15 > getFirstIndex()) {
                return false;
            }
            int i17 = this.mFirstVisibleIndex;
            i11 = i17 - 1;
            i12 = getLocation(i17).mRow;
            int iFindRowEdgeLimitSearchIndex = findRowEdgeLimitSearchIndex(false);
            if (iFindRowEdgeLimitSearchIndex < 0) {
                i12--;
                rowMax = Integer.MAX_VALUE;
                for (int i18 = this.mNumRows - 1; i18 >= 0; i18--) {
                    rowMax = this.mReversedFlow ? getRowMax(i18) : getRowMin(i18);
                    if (rowMax != Integer.MAX_VALUE) {
                        break;
                    }
                }
            } else {
                rowMax = this.mReversedFlow ? findRowMax(true, iFindRowEdgeLimitSearchIndex, null) : findRowMin(false, iFindRowEdgeLimitSearchIndex, null);
            }
            if (!this.mReversedFlow ? getRowMin(i12) <= rowMax : getRowMax(i12) >= rowMax) {
                i12--;
                if (i12 < 0) {
                    i12 = this.mNumRows - 1;
                    rowMax = this.mReversedFlow ? findRowMax(true, null) : findRowMin(false, null);
                }
            }
            z11 = true;
        }
        boolean z12 = false;
        while (true) {
            if (i12 >= 0) {
                if (i11 < 0 || (!z10 && checkPrependOverLimit(i10))) {
                    break;
                }
                int rowMax2 = this.mReversedFlow ? getRowMax(i12) : getRowMin(i12);
                if (rowMax2 != Integer.MAX_VALUE && rowMax2 != Integer.MIN_VALUE) {
                    if (this.mReversedFlow) {
                        i14 = this.mSpacing;
                    } else {
                        i13 = this.mSpacing;
                        i14 = -i13;
                    }
                    rowMax2 += i14;
                } else if (i12 == this.mNumRows - 1) {
                    rowMax2 = this.mReversedFlow ? getRowMax(0) : getRowMin(0);
                    if (rowMax2 != Integer.MAX_VALUE && rowMax2 != Integer.MIN_VALUE) {
                        if (this.mReversedFlow) {
                            i14 = this.mSpacing;
                        } else {
                            i13 = this.mSpacing;
                            i14 = -i13;
                        }
                        rowMax2 += i14;
                    }
                } else {
                    rowMax2 = this.mReversedFlow ? getRowMin(i12 + 1) : getRowMax(i12 + 1);
                }
                int i19 = i11 - 1;
                int iPrependVisibleItemToRow = prependVisibleItemToRow(i11, i12, rowMax2);
                if (z11) {
                    while (true) {
                        if (!this.mReversedFlow) {
                            if (rowMax2 - iPrependVisibleItemToRow <= rowMax) {
                                break;
                            }
                            if (i19 >= 0) {
                            }
                            return true;
                        }
                        if (rowMax2 + iPrependVisibleItemToRow >= rowMax) {
                            break;
                        }
                        if (i19 >= 0 || (!z10 && checkPrependOverLimit(i10))) {
                            return true;
                        }
                        rowMax2 += this.mReversedFlow ? iPrependVisibleItemToRow + this.mSpacing : (-iPrependVisibleItemToRow) - this.mSpacing;
                        int i20 = i19 - 1;
                        int iPrependVisibleItemToRow2 = prependVisibleItemToRow(i19, i12, rowMax2);
                        i19 = i20;
                        iPrependVisibleItemToRow = iPrependVisibleItemToRow2;
                    }
                } else {
                    rowMax = this.mReversedFlow ? getRowMax(i12) : getRowMin(i12);
                    z11 = true;
                }
                i11 = i19;
                i12--;
                z12 = true;
            } else {
                if (z10) {
                    break;
                }
                rowMax = this.mReversedFlow ? findRowMax(true, null) : findRowMin(false, null);
                i12 = this.mNumRows - 1;
            }
        }
        return z12;
    }

    StaggeredGridDefault() {
    }
}
