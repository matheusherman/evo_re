package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f546x - diagonal2.f546x;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i10, int i11);

        public abstract boolean areItemsTheSame(int i10, int i11);

        @Nullable
        public Object getChangePayload(int i10, int i11) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class CenteredArray {
        private final int[] mData;
        private final int mMid;

        int[] backingData() {
            return this.mData;
        }

        public void fill(int i10) {
            Arrays.fill(this.mData, i10);
        }

        int get(int i10) {
            return this.mData[i10 + this.mMid];
        }

        void set(int i10, int i11) {
            this.mData[i10 + this.mMid] = i11;
        }

        CenteredArray(int i10) {
            int[] iArr = new int[i10];
            this.mData = iArr;
            this.mMid = iArr.length / 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class Diagonal {
        public final int size;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final int f546x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f547y;

        int endX() {
            return this.f546x + this.size;
        }

        int endY() {
            return this.f547y + this.size;
        }

        Diagonal(int i10, int i11, int i12) {
            this.f546x = i10;
            this.f547y = i11;
            this.size = i12;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_MASK = 15;
        private static final int FLAG_MOVED = 12;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 4;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final List<Diagonal> mDiagonals;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        private void addEdgeDiagonals() {
            Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
            if (diagonal == null || diagonal.f546x != 0 || diagonal.f547y != 0) {
                this.mDiagonals.add(0, new Diagonal(0, 0, 0));
            }
            this.mDiagonals.add(new Diagonal(this.mOldListSize, this.mNewListSize, 0));
        }

        private void findMatchingAddition(int i10) {
            int size = this.mDiagonals.size();
            int iEndY = 0;
            for (int i11 = 0; i11 < size; i11++) {
                Diagonal diagonal = this.mDiagonals.get(i11);
                while (iEndY < diagonal.f547y) {
                    if (this.mNewItemStatuses[iEndY] == 0 && this.mCallback.areItemsTheSame(i10, iEndY)) {
                        int i12 = this.mCallback.areContentsTheSame(i10, iEndY) ? 8 : 4;
                        this.mOldItemStatuses[i10] = (iEndY << 4) | i12;
                        this.mNewItemStatuses[iEndY] = (i10 << 4) | i12;
                        return;
                    }
                    iEndY++;
                }
                iEndY = diagonal.endY();
            }
        }

        private void findMatchingItems() {
            for (Diagonal diagonal : this.mDiagonals) {
                for (int i10 = 0; i10 < diagonal.size; i10++) {
                    int i11 = diagonal.f546x + i10;
                    int i12 = diagonal.f547y + i10;
                    int i13 = this.mCallback.areContentsTheSame(i11, i12) ? 1 : 2;
                    this.mOldItemStatuses[i11] = (i12 << 4) | i13;
                    this.mNewItemStatuses[i12] = (i11 << 4) | i13;
                }
            }
            if (this.mDetectMoves) {
                findMoveMatches();
            }
        }

        private void findMoveMatches() {
            int iEndX = 0;
            for (Diagonal diagonal : this.mDiagonals) {
                while (iEndX < diagonal.f546x) {
                    if (this.mOldItemStatuses[iEndX] == 0) {
                        findMatchingAddition(iEndX);
                    }
                    iEndX++;
                }
                iEndX = diagonal.endX();
            }
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i10) {
            if (i10 >= 0 && i10 < this.mNewListSize) {
                int i11 = this.mNewItemStatuses[i10];
                if ((i11 & 15) == 0) {
                    return -1;
                }
                return i11 >> 4;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i10 + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i10) {
            if (i10 >= 0 && i10 < this.mOldListSize) {
                int i11 = this.mOldItemStatuses[i10];
                if ((i11 & 15) == 0) {
                    return -1;
                }
                return i11 >> 4;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i10 + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            int i10;
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            int i11 = this.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i12 = this.mOldListSize;
            int i13 = this.mNewListSize;
            for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.mDiagonals.get(size);
                int iEndX = diagonal.endX();
                int iEndY = diagonal.endY();
                while (true) {
                    if (i12 <= iEndX) {
                        break;
                    }
                    i12--;
                    int i14 = this.mOldItemStatuses[i12];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i15, false);
                        if (postponedUpdate != null) {
                            int i16 = (i11 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i12, i16);
                            if ((i14 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i16, 1, this.mCallback.getChangePayload(i12, i15));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i12, (i11 - i12) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.onRemoved(i12, 1);
                        i11--;
                    }
                }
                while (i13 > iEndY) {
                    i13--;
                    int i17 = this.mNewItemStatuses[i13];
                    if ((i17 & 12) != 0) {
                        int i18 = i17 >> 4;
                        PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i18, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i13, i11 - i12, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i11 - postponedUpdate2.currentPos) - 1, i12);
                            if ((i17 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i12, 1, this.mCallback.getChangePayload(i18, i13));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i12, 1);
                        i11++;
                    }
                }
                int i19 = diagonal.f546x;
                int i20 = diagonal.f547y;
                for (i10 = 0; i10 < diagonal.size; i10++) {
                    if ((this.mOldItemStatuses[i19] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i19, 1, this.mCallback.getChangePayload(i19, i20));
                    }
                    i19++;
                    i20++;
                }
                i12 = diagonal.f546x;
                i13 = diagonal.f547y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }

        DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z10) {
            this.mDiagonals = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z10;
            addEdgeDiagonals();
            findMatchingItems();
        }

        @Nullable
        private static PostponedUpdate getPostponedUpdate(Collection<PostponedUpdate> collection, int i10, boolean z10) {
            PostponedUpdate next;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (next.posInOwnerList == i10 && next.removal == z10) {
                        it.remove();
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next2 = it.next();
                if (z10) {
                    next2.currentPos--;
                } else {
                    next2.currentPos++;
                }
            }
            return next;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t10, @NonNull T t11);

        public abstract boolean areItemsTheSame(@NonNull T t10, @NonNull T t11);

        @Nullable
        public Object getChangePayload(@NonNull T t10, @NonNull T t11) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i10, int i11, int i12, int i13) {
            this.oldListStart = i10;
            this.oldListEnd = i11;
            this.newListStart = i12;
            this.newListEnd = i13;
        }

        int newSize() {
            return this.newListEnd - this.newListStart;
        }

        int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        Snake() {
        }

        @NonNull
        Diagonal toDiagonal() {
            if (hasAdditionOrRemoval()) {
                if (this.reverse) {
                    return new Diagonal(this.startX, this.startY, diagonalSize());
                }
                if (isAddition()) {
                    return new Diagonal(this.startX, this.startY + 1, diagonalSize());
                }
                return new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
            int i10 = this.startX;
            return new Diagonal(i10, this.startY, this.endX - i10);
        }
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        PostponedUpdate(int i10, int i11, boolean z10) {
            this.posInOwnerList = i10;
            this.currentPos = i11;
            this.removal = z10;
        }
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z10) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i10 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i10);
        CenteredArray centeredArray2 = new CenteredArray(i10);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeMidPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (snakeMidPoint != null) {
                if (snakeMidPoint.diagonalSize() > 0) {
                    arrayList.add(snakeMidPoint.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = snakeMidPoint.startX;
                range2.newListEnd = snakeMidPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = snakeMidPoint.endX;
                range.newListStart = snakeMidPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z10);
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i10) {
        boolean z10;
        int i11;
        int i12;
        int i13;
        int i14;
        if ((range.oldSize() - range.newSize()) % 2 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int iOldSize = range.oldSize() - range.newSize();
        int i15 = -i10;
        for (int i16 = i15; i16 <= i10; i16 += 2) {
            if (i16 != i15 && (i16 == i10 || centeredArray2.get(i16 + 1) >= centeredArray2.get(i16 - 1))) {
                i11 = centeredArray2.get(i16 - 1);
                i12 = i11 - 1;
            } else {
                i11 = centeredArray2.get(i16 + 1);
                i12 = i11;
            }
            int i17 = range.newListEnd - ((range.oldListEnd - i12) - i16);
            if (i10 != 0 && i12 == i11) {
                i13 = i17 + 1;
            } else {
                i13 = i17;
            }
            while (i12 > range.oldListStart && i17 > range.newListStart && callback.areItemsTheSame(i12 - 1, i17 - 1)) {
                i12--;
                i17--;
            }
            centeredArray2.set(i16, i12);
            if (z10 && (i14 = iOldSize - i16) >= i15 && i14 <= i10 && centeredArray.get(i14) >= i12) {
                Snake snake = new Snake();
                snake.startX = i12;
                snake.startY = i17;
                snake.endX = i11;
                snake.endY = i13;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z10 = true;
        if (Math.abs(range.oldSize() - range.newSize()) % 2 != 1) {
            z10 = false;
        }
        int iOldSize = range.oldSize() - range.newSize();
        int i15 = -i10;
        for (int i16 = i15; i16 <= i10; i16 += 2) {
            if (i16 != i15 && (i16 == i10 || centeredArray.get(i16 + 1) <= centeredArray.get(i16 - 1))) {
                i11 = centeredArray.get(i16 - 1);
                i12 = i11 + 1;
            } else {
                i11 = centeredArray.get(i16 + 1);
                i12 = i11;
            }
            int i17 = (range.newListStart + (i12 - range.oldListStart)) - i16;
            if (i10 != 0 && i12 == i11) {
                i13 = i17 - 1;
            } else {
                i13 = i17;
            }
            while (i12 < range.oldListEnd && i17 < range.newListEnd && callback.areItemsTheSame(i12, i17)) {
                i12++;
                i17++;
            }
            centeredArray.set(i16, i12);
            if (z10 && (i14 = iOldSize - i16) >= i15 + 1 && i14 <= i10 - 1 && centeredArray2.get(i14) <= i12) {
                Snake snake = new Snake();
                snake.startX = i11;
                snake.startY = i13;
                snake.endX = i12;
                snake.endY = i17;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int iOldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i10 = 0; i10 < iOldSize; i10++) {
                Snake snakeForward = forward(range, callback, centeredArray, centeredArray2, i10);
                if (snakeForward != null) {
                    return snakeForward;
                }
                Snake snakeBackward = backward(range, callback, centeredArray, centeredArray2, i10);
                if (snakeBackward != null) {
                    return snakeBackward;
                }
            }
        }
        return null;
    }
}
