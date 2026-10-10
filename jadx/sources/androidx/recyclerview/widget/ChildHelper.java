package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final int REMOVE_STATUS_IN_REMOVE = 1;
    private static final int REMOVE_STATUS_IN_REMOVE_IF_HIDDEN = 2;
    private static final int REMOVE_STATUS_NONE = 0;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    private View mViewInRemoveView;
    private int mRemoveStatus = 0;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        void clear(int i10) {
            if (i10 < 64) {
                this.mData &= ~(1 << i10);
                return;
            }
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.clear(i10 - 64);
            }
        }

        int countOnesBefore(int i10) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                return i10 >= 64 ? Long.bitCount(this.mData) : Long.bitCount(this.mData & ((1 << i10) - 1));
            }
            return i10 < 64 ? Long.bitCount(this.mData & ((1 << i10) - 1)) : bucket.countOnesBefore(i10 - 64) + Long.bitCount(this.mData);
        }

        boolean get(int i10) {
            if (i10 < 64) {
                return (this.mData & (1 << i10)) != 0;
            }
            ensureNext();
            return this.mNext.get(i10 - 64);
        }

        void insert(int i10, boolean z10) {
            if (i10 >= 64) {
                ensureNext();
                this.mNext.insert(i10 - 64, z10);
                return;
            }
            long j10 = this.mData;
            boolean z11 = (LAST_BIT & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.mData = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                set(i10);
            } else {
                clear(i10);
            }
            if (z11 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z11);
            }
        }

        boolean remove(int i10) {
            if (i10 >= 64) {
                ensureNext();
                return this.mNext.remove(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.mData;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.mData = j12;
            long j13 = j10 - 1;
            this.mData = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z10;
        }

        void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        void set(int i10) {
            if (i10 < 64) {
                this.mData |= 1 << i10;
            } else {
                ensureNext();
                this.mNext.set(i10 - 64);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }

        Bucket() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface Callback {
        void addView(View view, int i10);

        void attachViewToParent(View view, int i10, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i10);

        View getChildAt(int i10);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i10);
    }

    private int getOffset(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i11 = i10;
        while (i11 < childCount) {
            int iCountOnesBefore = i10 - (i11 - this.mBucket.countOnesBefore(i11));
            if (iCountOnesBefore == 0) {
                while (this.mBucket.get(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += iCountOnesBefore;
        }
        return -1;
    }

    void addView(View view, boolean z10) {
        addView(view, -1, z10);
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    void addView(View view, int i10, boolean z10) {
        int childCount = i10 < 0 ? this.mCallback.getChildCount() : getOffset(i10);
        this.mBucket.insert(childCount, z10);
        if (z10) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, childCount);
    }

    void attachViewToParent(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int childCount = i10 < 0 ? this.mCallback.getChildCount() : getOffset(i10);
        this.mBucket.insert(childCount, z10);
        if (z10) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, childCount, layoutParams);
    }

    View findHiddenNonRemovedView(int i10) {
        int size = this.mHiddenViews.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.mHiddenViews.get(i11);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i10 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    View getUnfilteredChildAt(int i10) {
        return this.mCallback.getChildAt(i10);
    }

    int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    void hide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.mBucket.set(iIndexOfChild);
            hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int indexOfChild(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild == -1 || this.mBucket.get(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - this.mBucket.countOnesBefore(iIndexOfChild);
    }

    boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    void removeView(View view) {
        int i10 = this.mRemoveStatus;
        if (i10 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i10 == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            this.mRemoveStatus = 1;
            this.mViewInRemoveView = view;
            int iIndexOfChild = this.mCallback.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (this.mBucket.remove(iIndexOfChild)) {
                    unhideViewInternal(view);
                }
                this.mCallback.removeViewAt(iIndexOfChild);
            }
        } finally {
            this.mRemoveStatus = 0;
            this.mViewInRemoveView = null;
        }
    }

    void removeViewAt(int i10) {
        int i11 = this.mRemoveStatus;
        if (i11 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i11 == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            int offset = getOffset(i10);
            View childAt = this.mCallback.getChildAt(offset);
            if (childAt != null) {
                this.mRemoveStatus = 1;
                this.mViewInRemoveView = childAt;
                if (this.mBucket.remove(offset)) {
                    unhideViewInternal(childAt);
                }
                this.mCallback.removeViewAt(offset);
            }
        } finally {
            this.mRemoveStatus = 0;
            this.mViewInRemoveView = null;
        }
    }

    boolean removeViewIfHidden(View view) {
        int i10 = this.mRemoveStatus;
        if (i10 == 1) {
            if (this.mViewInRemoveView == view) {
                return false;
            }
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
        }
        if (i10 == 2) {
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
        }
        try {
            this.mRemoveStatus = 2;
            int iIndexOfChild = this.mCallback.indexOfChild(view);
            if (iIndexOfChild == -1) {
                unhideViewInternal(view);
                return true;
            }
            if (!this.mBucket.get(iIndexOfChild)) {
                return false;
            }
            this.mBucket.remove(iIndexOfChild);
            unhideViewInternal(view);
            this.mCallback.removeViewAt(iIndexOfChild);
            return true;
        } finally {
            this.mRemoveStatus = 0;
        }
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    void unhide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.mBucket.get(iIndexOfChild)) {
            this.mBucket.clear(iIndexOfChild);
            unhideViewInternal(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    void detachViewFromParent(int i10) {
        int offset = getOffset(i10);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    View getChildAt(int i10) {
        return this.mCallback.getChildAt(getOffset(i10));
    }
}
