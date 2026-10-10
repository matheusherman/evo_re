package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.GridView;
import androidx.annotation.VisibleForTesting;
import androidx.collection.CircularIntArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class GridLayoutManager extends RecyclerView.LayoutManager {
    static final boolean DEBUG = false;
    static final int DEFAULT_MAX_PENDING_MOVES = 10;
    static final int MIN_MS_SMOOTH_SCROLL_MAIN_SCREEN = 30;
    private static final int NEXT_ITEM = 1;
    private static final int NEXT_ROW = 3;
    static final int PF_FAST_RELAYOUT = 4;
    static final int PF_FAST_RELAYOUT_UPDATED_SELECTED_POSITION = 8;
    static final int PF_FOCUS_OUT_BACK = 4096;
    static final int PF_FOCUS_OUT_FRONT = 2048;
    static final int PF_FOCUS_OUT_MASKS = 6144;
    static final int PF_FOCUS_OUT_SIDE_END = 16384;
    static final int PF_FOCUS_OUT_SIDE_MASKS = 24576;
    static final int PF_FOCUS_OUT_SIDE_START = 8192;
    static final int PF_FOCUS_SEARCH_DISABLED = 32768;
    static final int PF_FORCE_FULL_LAYOUT = 256;
    static final int PF_IN_LAYOUT_SEARCH_FOCUS = 16;
    static final int PF_IN_SELECTION = 32;
    static final int PF_LAYOUT_EATEN_IN_SLIDING = 128;
    static final int PF_LAYOUT_ENABLED = 512;
    static final int PF_PRUNE_CHILD = 65536;
    static final int PF_REVERSE_FLOW_MASK = 786432;
    static final int PF_REVERSE_FLOW_PRIMARY = 262144;
    static final int PF_REVERSE_FLOW_SECONDARY = 524288;
    static final int PF_ROW_SECONDARY_SIZE_REFRESH = 1024;
    static final int PF_SCROLL_ENABLED = 131072;
    static final int PF_SLIDING = 64;
    static final int PF_STAGE_LAYOUT = 1;
    static final int PF_STAGE_MASK = 3;
    static final int PF_STAGE_SCROLL = 2;
    private static final int PREV_ITEM = 0;
    private static final int PREV_ROW = 2;
    private static final String TAG = "GridLayoutManager";
    private static final Rect sTempRect = new Rect();
    static int[] sTwoInts = new int[2];
    AudioManager mAudioManager;
    BaseGridView mBaseGridView;
    OnChildLaidOutListener mChildLaidOutListener;
    private OnChildSelectedListener mChildSelectedListener;
    private ArrayList<OnChildViewHolderSelectedListener> mChildViewHolderSelectedListeners;
    int mChildVisibility;
    final ViewsStateBundle mChildrenStates;
    GridLinearSmoothScroller mCurrentSmoothScroller;
    int[] mDisappearingPositions;
    private int mExtraLayoutSpace;
    int mExtraLayoutSpaceInPreLayout;
    private FacetProviderAdapter mFacetProviderAdapter;
    private int mFixedRowSizeSecondary;
    int mFlag;
    int mFocusPosition;
    private int mFocusPositionOffset;
    private int mFocusScrollStrategy;
    private int mGravity;
    Grid mGrid;
    private final Grid.Provider mGridProvider;
    private int mHorizontalSpacing;
    private final ItemAlignment mItemAlignment;
    int mMaxPendingMoves;
    private int mMaxSizeSecondary;
    private final int[] mMeasuredDimension;
    int mNumRows;
    private int mNumRowsRequested;

    @VisibleForTesting
    ArrayList<BaseGridView.OnLayoutCompletedListener> mOnLayoutCompletedListeners;
    int mOrientation;
    private OrientationHelper mOrientationHelper;
    PendingMoveSmoothScroller mPendingMoveSmoothScroller;
    int mPositionDeltaInPreLayout;
    final SparseIntArray mPositionToRowInPostLayout;
    private int mPrimaryScrollExtra;
    RecyclerView.Recycler mRecycler;
    private final Runnable mRequestLayoutRunnable;
    private int[] mRowSizeSecondary;
    private int mRowSizeSecondaryRequested;
    private int mSaveContextLevel;
    int mScrollOffsetSecondary;
    private int mSizePrimary;
    float mSmoothScrollSpeedFactor;
    private int mSpacingPrimary;
    private int mSpacingSecondary;
    RecyclerView.State mState;
    int mSubFocusPosition;
    private int mVerticalSpacing;
    final WindowAlignment mWindowAlignment;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    abstract class GridLinearSmoothScroller extends LinearSmoothScroller {
        boolean mSkipOnStopInternal;

        GridLinearSmoothScroller() {
            super(GridLayoutManager.this.mBaseGridView.getContext());
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            int i10;
            int i11;
            if (GridLayoutManager.this.getScrollPosition(view, null, GridLayoutManager.sTwoInts)) {
                if (GridLayoutManager.this.mOrientation == 0) {
                    int[] iArr = GridLayoutManager.sTwoInts;
                    i11 = iArr[0];
                    i10 = iArr[1];
                } else {
                    int[] iArr2 = GridLayoutManager.sTwoInts;
                    int i12 = iArr2[1];
                    i10 = iArr2[0];
                    i11 = i12;
                }
                action.update(i11, i10, calculateTimeForDeceleration((int) Math.sqrt((i11 * i11) + (i10 * i10))), this.mDecelerateInterpolator);
            }
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return super.calculateSpeedPerPixel(displayMetrics) * GridLayoutManager.this.mSmoothScrollSpeedFactor;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int calculateTimeForScrolling(int i10) {
            int iCalculateTimeForScrolling = super.calculateTimeForScrolling(i10);
            if (GridLayoutManager.this.mWindowAlignment.mainAxis().getSize() > 0) {
                float size = (30.0f / GridLayoutManager.this.mWindowAlignment.mainAxis().getSize()) * i10;
                if (iCalculateTimeForScrolling < size) {
                    return (int) size;
                }
            }
            return iCalculateTimeForScrolling;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        protected void onStop() {
            super.onStop();
            if (!this.mSkipOnStopInternal) {
                onStopInternal();
            }
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            if (gridLayoutManager.mCurrentSmoothScroller == this) {
                gridLayoutManager.mCurrentSmoothScroller = null;
            }
            if (gridLayoutManager.mPendingMoveSmoothScroller == this) {
                gridLayoutManager.mPendingMoveSmoothScroller = null;
            }
        }

        protected void onStopInternal() {
            View viewFindViewByPosition = findViewByPosition(getTargetPosition());
            if (viewFindViewByPosition == null) {
                if (getTargetPosition() >= 0) {
                    GridLayoutManager.this.scrollToSelection(getTargetPosition(), 0, false, 0);
                    return;
                }
                return;
            }
            if (GridLayoutManager.this.mFocusPosition != getTargetPosition()) {
                GridLayoutManager.this.mFocusPosition = getTargetPosition();
            }
            if (GridLayoutManager.this.hasFocus()) {
                GridLayoutManager.this.mFlag |= 32;
                viewFindViewByPosition.requestFocus();
                GridLayoutManager.this.mFlag &= -33;
            }
            GridLayoutManager.this.dispatchChildSelected();
            GridLayoutManager.this.dispatchChildSelectedAndPositioned();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class LayoutParams extends RecyclerView.LayoutParams {
        private int[] mAlignMultiple;
        private int mAlignX;
        private int mAlignY;
        private ItemAlignmentFacet mAlignmentFacet;
        int mBottomInset;
        int mLeftInset;
        int mRightInset;
        int mTopInset;

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        void calculateItemAlignments(int i10, View view) {
            ItemAlignmentFacet.ItemAlignmentDef[] alignmentDefs = this.mAlignmentFacet.getAlignmentDefs();
            int[] iArr = this.mAlignMultiple;
            if (iArr == null || iArr.length != alignmentDefs.length) {
                this.mAlignMultiple = new int[alignmentDefs.length];
            }
            for (int i11 = 0; i11 < alignmentDefs.length; i11++) {
                this.mAlignMultiple[i11] = ItemAlignmentFacetHelper.getAlignmentPosition(view, alignmentDefs[i11], i10);
            }
            if (i10 == 0) {
                this.mAlignX = this.mAlignMultiple[0];
            } else {
                this.mAlignY = this.mAlignMultiple[0];
            }
        }

        int[] getAlignMultiple() {
            return this.mAlignMultiple;
        }

        int getAlignX() {
            return this.mAlignX;
        }

        int getAlignY() {
            return this.mAlignY;
        }

        ItemAlignmentFacet getItemAlignmentFacet() {
            return this.mAlignmentFacet;
        }

        int getOpticalBottomInset() {
            return this.mBottomInset;
        }

        int getOpticalLeftInset() {
            return this.mLeftInset;
        }

        int getOpticalRightInset() {
            return this.mRightInset;
        }

        int getOpticalTopInset() {
            return this.mTopInset;
        }

        void setAlignX(int i10) {
            this.mAlignX = i10;
        }

        void setAlignY(int i10) {
            this.mAlignY = i10;
        }

        void setItemAlignmentFacet(ItemAlignmentFacet itemAlignmentFacet) {
            this.mAlignmentFacet = itemAlignmentFacet;
        }

        void setOpticalInsets(int i10, int i11, int i12, int i13) {
            this.mLeftInset = i10;
            this.mTopInset = i11;
            this.mRightInset = i12;
            this.mBottomInset = i13;
        }

        LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        int getOpticalBottom(View view) {
            return view.getBottom() - this.mBottomInset;
        }

        int getOpticalHeight(View view) {
            return (view.getHeight() - this.mTopInset) - this.mBottomInset;
        }

        int getOpticalLeft(View view) {
            return view.getLeft() + this.mLeftInset;
        }

        int getOpticalRight(View view) {
            return view.getRight() - this.mRightInset;
        }

        int getOpticalTop(View view) {
            return view.getTop() + this.mTopInset;
        }

        int getOpticalWidth(View view) {
            return (view.getWidth() - this.mLeftInset) - this.mRightInset;
        }

        LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class PendingMoveSmoothScroller extends GridLinearSmoothScroller {
        static final int TARGET_UNDEFINED = -2;
        private int mPendingMoves;
        private final boolean mStaggeredGrid;

        PendingMoveSmoothScroller(int i10, boolean z10) {
            super();
            this.mPendingMoves = i10;
            this.mStaggeredGrid = z10;
            setTargetPosition(-2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i10) {
            int i11 = this.mPendingMoves;
            if (i11 == 0) {
                return null;
            }
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            int i12 = ((gridLayoutManager.mFlag & 262144) == 0 ? i11 >= 0 : i11 <= 0) ? 1 : -1;
            return gridLayoutManager.mOrientation == 0 ? new PointF(i12, 0.0f) : new PointF(0.0f, i12);
        }

        void consumePendingMovesAfterLayout() {
            int i10;
            if (this.mStaggeredGrid && (i10 = this.mPendingMoves) != 0) {
                this.mPendingMoves = GridLayoutManager.this.processSelectionMoves(true, i10);
            }
            int i11 = this.mPendingMoves;
            if (i11 == 0 || ((i11 > 0 && GridLayoutManager.this.hasCreatedLastItem()) || (this.mPendingMoves < 0 && GridLayoutManager.this.hasCreatedFirstItem()))) {
                setTargetPosition(GridLayoutManager.this.mFocusPosition);
                stop();
            }
        }

        void consumePendingMovesBeforeLayout() {
            int i10;
            int i11;
            View viewFindViewByPosition;
            if (this.mStaggeredGrid || (i10 = this.mPendingMoves) == 0) {
                return;
            }
            if (i10 > 0) {
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                i11 = gridLayoutManager.mFocusPosition + gridLayoutManager.mNumRows;
            } else {
                GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                i11 = gridLayoutManager2.mFocusPosition - gridLayoutManager2.mNumRows;
            }
            View view = null;
            while (this.mPendingMoves != 0 && (viewFindViewByPosition = findViewByPosition(i11)) != null) {
                if (GridLayoutManager.this.canScrollTo(viewFindViewByPosition)) {
                    GridLayoutManager gridLayoutManager3 = GridLayoutManager.this;
                    gridLayoutManager3.mFocusPosition = i11;
                    gridLayoutManager3.mSubFocusPosition = 0;
                    int i12 = this.mPendingMoves;
                    if (i12 > 0) {
                        this.mPendingMoves = i12 - 1;
                    } else {
                        this.mPendingMoves = i12 + 1;
                    }
                    view = viewFindViewByPosition;
                }
                i11 = this.mPendingMoves > 0 ? i11 + GridLayoutManager.this.mNumRows : i11 - GridLayoutManager.this.mNumRows;
            }
            if (view == null || !GridLayoutManager.this.hasFocus()) {
                return;
            }
            GridLayoutManager.this.mFlag |= 32;
            view.requestFocus();
            GridLayoutManager.this.mFlag &= -33;
        }

        void decreasePendingMoves() {
            int i10 = this.mPendingMoves;
            if (i10 > (-GridLayoutManager.this.mMaxPendingMoves)) {
                this.mPendingMoves = i10 - 1;
            }
        }

        void increasePendingMoves() {
            int i10 = this.mPendingMoves;
            if (i10 < GridLayoutManager.this.mMaxPendingMoves) {
                this.mPendingMoves = i10 + 1;
            }
        }

        @Override // androidx.leanback.widget.GridLayoutManager.GridLinearSmoothScroller
        protected void onStopInternal() {
            super.onStopInternal();
            this.mPendingMoves = 0;
            View viewFindViewByPosition = findViewByPosition(getTargetPosition());
            if (viewFindViewByPosition != null) {
                GridLayoutManager.this.scrollToView(viewFindViewByPosition, true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @SuppressLint({"BanParcelableUsage"})
    static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.leanback.widget.GridLayoutManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        Bundle mChildStates;
        int mIndex;

        SavedState(Parcel parcel) {
            this.mChildStates = Bundle.EMPTY;
            this.mIndex = parcel.readInt();
            this.mChildStates = parcel.readBundle(GridLayoutManager.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.mIndex);
            parcel.writeBundle(this.mChildStates);
        }

        SavedState() {
            this.mChildStates = Bundle.EMPTY;
        }
    }

    public GridLayoutManager() {
        this(null);
    }

    private void discardLayoutInfo() {
        this.mGrid = null;
        this.mRowSizeSecondary = null;
        this.mFlag &= -1025;
    }

    private int getAdapterPositionByView(View view) {
        LayoutParams layoutParams;
        if (view == null || (layoutParams = (LayoutParams) view.getLayoutParams()) == null || layoutParams.isItemRemoved()) {
            return -1;
        }
        return layoutParams.getAbsoluteAdapterPosition();
    }

    private void updateChildAlignments(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.getItemAlignmentFacet() == null) {
            layoutParams.setAlignX(this.mItemAlignment.horizontal.getAlignmentPosition(view));
            layoutParams.setAlignY(this.mItemAlignment.vertical.getAlignmentPosition(view));
            return;
        }
        layoutParams.calculateItemAlignments(this.mOrientation, view);
        if (this.mOrientation == 0) {
            layoutParams.setAlignY(this.mItemAlignment.vertical.getAlignmentPosition(view));
        } else {
            layoutParams.setAlignX(this.mItemAlignment.horizontal.getAlignmentPosition(view));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        try {
            saveContext(null, state);
            if (this.mOrientation != 0) {
                i10 = i11;
            }
            if (getChildCount() != 0 && i10 != 0) {
                this.mGrid.collectAdjacentPrefetchPositions(i10 < 0 ? -this.mExtraLayoutSpace : this.mSizePrimary + this.mExtraLayoutSpace, i10, layoutPrefetchRegistry);
            }
        } finally {
            leaveContext();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    int getSubPositionByView(View view, View view2) {
        ItemAlignmentFacet itemAlignmentFacet;
        if (view != null && view2 != null && (itemAlignmentFacet = ((LayoutParams) view.getLayoutParams()).getItemAlignmentFacet()) != null) {
            ItemAlignmentFacet.ItemAlignmentDef[] alignmentDefs = itemAlignmentFacet.getAlignmentDefs();
            if (alignmentDefs.length > 1) {
                while (view2 != view) {
                    int id2 = view2.getId();
                    if (id2 != -1) {
                        for (int i10 = 1; i10 < alignmentDefs.length; i10++) {
                            if (alignmentDefs[i10].getItemAlignmentFocusViewId() == id2) {
                                return i10;
                            }
                        }
                    }
                    view2 = (View) view2.getParent();
                }
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mFocusPositionOffset = 0;
        this.mChildrenStates.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            this.mChildrenStates.remove(i10);
            i10++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        setSelection(i10, 0, false, 0);
    }

    void scrollToView(View view, boolean z10) {
        scrollToView(view, view == null ? null : view.findFocus(), z10);
    }

    void setSelection(int i10, int i11) {
        setSelection(i10, 0, false, i11);
    }

    void setSelectionSmooth(int i10) {
        setSelection(i10, 0, true, 0);
    }

    void setSelectionSmoothWithSub(int i10, int i11) {
        setSelection(i10, i11, true, 0);
    }

    void setSelectionWithSub(int i10, int i11, int i12) {
        setSelection(i10, i11, false, i12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        setSelection(i10, 0, true, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return true;
    }

    @SuppressLint({"WrongConstant"})
    GridLayoutManager(BaseGridView baseGridView) {
        this.mSmoothScrollSpeedFactor = 1.0f;
        this.mMaxPendingMoves = 10;
        this.mOrientation = 0;
        this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
        this.mPositionToRowInPostLayout = new SparseIntArray();
        this.mFlag = 221696;
        this.mChildSelectedListener = null;
        this.mChildViewHolderSelectedListeners = null;
        this.mOnLayoutCompletedListeners = null;
        this.mChildLaidOutListener = null;
        this.mFocusPosition = -1;
        this.mSubFocusPosition = 0;
        this.mFocusPositionOffset = 0;
        this.mGravity = 8388659;
        this.mNumRowsRequested = 1;
        this.mFocusScrollStrategy = 0;
        this.mWindowAlignment = new WindowAlignment();
        this.mItemAlignment = new ItemAlignment();
        this.mMeasuredDimension = new int[2];
        this.mChildrenStates = new ViewsStateBundle();
        this.mRequestLayoutRunnable = new Runnable() { // from class: androidx.leanback.widget.GridLayoutManager.1
            @Override // java.lang.Runnable
            public void run() {
                GridLayoutManager.this.requestLayout();
            }
        };
        this.mGridProvider = new Grid.Provider() { // from class: androidx.leanback.widget.GridLayoutManager.2
            @Override // androidx.leanback.widget.Grid.Provider
            public void addItem(Object obj, int i10, int i11, int i12, int i13) {
                int i14;
                int i15;
                PendingMoveSmoothScroller pendingMoveSmoothScroller;
                View view = (View) obj;
                if (i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE) {
                    i13 = !GridLayoutManager.this.mGrid.isReversedFlow() ? GridLayoutManager.this.mWindowAlignment.mainAxis().getPaddingMin() : GridLayoutManager.this.mWindowAlignment.mainAxis().getSize() - GridLayoutManager.this.mWindowAlignment.mainAxis().getPaddingMax();
                }
                if (GridLayoutManager.this.mGrid.isReversedFlow()) {
                    i14 = i13 - i11;
                    i15 = i13;
                } else {
                    i15 = i11 + i13;
                    i14 = i13;
                }
                int rowStartSecondary = GridLayoutManager.this.getRowStartSecondary(i12) + GridLayoutManager.this.mWindowAlignment.secondAxis().getPaddingMin();
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                int i16 = rowStartSecondary - gridLayoutManager.mScrollOffsetSecondary;
                gridLayoutManager.mChildrenStates.loadView(view, i10);
                GridLayoutManager.this.layoutChild(i12, view, i14, i15, i16);
                if (!GridLayoutManager.this.mState.isPreLayout()) {
                    GridLayoutManager.this.updateScrollLimits();
                }
                GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                if ((gridLayoutManager2.mFlag & 3) != 1 && (pendingMoveSmoothScroller = gridLayoutManager2.mPendingMoveSmoothScroller) != null) {
                    pendingMoveSmoothScroller.consumePendingMovesAfterLayout();
                }
                GridLayoutManager gridLayoutManager3 = GridLayoutManager.this;
                if (gridLayoutManager3.mChildLaidOutListener != null) {
                    RecyclerView.ViewHolder childViewHolder = gridLayoutManager3.mBaseGridView.getChildViewHolder(view);
                    GridLayoutManager gridLayoutManager4 = GridLayoutManager.this;
                    gridLayoutManager4.mChildLaidOutListener.onChildLaidOut(gridLayoutManager4.mBaseGridView, view, i10, childViewHolder == null ? -1L : childViewHolder.getItemId());
                }
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public int createItem(int i10, boolean z10, Object[] objArr, boolean z11) {
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                View viewForPosition = gridLayoutManager.getViewForPosition(i10 - gridLayoutManager.mPositionDeltaInPreLayout);
                if (!((LayoutParams) viewForPosition.getLayoutParams()).isItemRemoved()) {
                    if (z11) {
                        if (z10) {
                            GridLayoutManager.this.addDisappearingView(viewForPosition);
                        } else {
                            GridLayoutManager.this.addDisappearingView(viewForPosition, 0);
                        }
                    } else if (z10) {
                        GridLayoutManager.this.addView(viewForPosition);
                    } else {
                        GridLayoutManager.this.addView(viewForPosition, 0);
                    }
                    int i11 = GridLayoutManager.this.mChildVisibility;
                    if (i11 != -1) {
                        viewForPosition.setVisibility(i11);
                    }
                    PendingMoveSmoothScroller pendingMoveSmoothScroller = GridLayoutManager.this.mPendingMoveSmoothScroller;
                    if (pendingMoveSmoothScroller != null) {
                        pendingMoveSmoothScroller.consumePendingMovesBeforeLayout();
                    }
                    int subPositionByView = GridLayoutManager.this.getSubPositionByView(viewForPosition, viewForPosition.findFocus());
                    GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                    int i12 = gridLayoutManager2.mFlag;
                    if ((i12 & 3) != 1) {
                        if (i10 == gridLayoutManager2.mFocusPosition && subPositionByView == gridLayoutManager2.mSubFocusPosition && gridLayoutManager2.mPendingMoveSmoothScroller == null) {
                            gridLayoutManager2.dispatchChildSelected();
                        }
                    } else if ((i12 & 4) == 0) {
                        if ((i12 & 16) == 0 && i10 == gridLayoutManager2.mFocusPosition && subPositionByView == gridLayoutManager2.mSubFocusPosition) {
                            gridLayoutManager2.dispatchChildSelected();
                        } else if ((i12 & 16) != 0 && i10 >= gridLayoutManager2.mFocusPosition && viewForPosition.hasFocusable()) {
                            GridLayoutManager gridLayoutManager3 = GridLayoutManager.this;
                            gridLayoutManager3.mFocusPosition = i10;
                            gridLayoutManager3.mSubFocusPosition = subPositionByView;
                            gridLayoutManager3.mFlag &= -17;
                            gridLayoutManager3.dispatchChildSelected();
                        }
                    }
                    GridLayoutManager.this.measureChild(viewForPosition);
                }
                objArr[0] = viewForPosition;
                GridLayoutManager gridLayoutManager4 = GridLayoutManager.this;
                return gridLayoutManager4.mOrientation == 0 ? gridLayoutManager4.getDecoratedMeasuredWidthWithMargin(viewForPosition) : gridLayoutManager4.getDecoratedMeasuredHeightWithMargin(viewForPosition);
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public int getCount() {
                return GridLayoutManager.this.mState.getItemCount() + GridLayoutManager.this.mPositionDeltaInPreLayout;
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public int getEdge(int i10) {
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i10 - gridLayoutManager.mPositionDeltaInPreLayout);
                GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                return (gridLayoutManager2.mFlag & 262144) != 0 ? gridLayoutManager2.getViewMax(viewFindViewByPosition) : gridLayoutManager2.getViewMin(viewFindViewByPosition);
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public int getMinIndex() {
                return GridLayoutManager.this.mPositionDeltaInPreLayout;
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public int getSize(int i10) {
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                return gridLayoutManager.getViewPrimarySize(gridLayoutManager.findViewByPosition(i10 - gridLayoutManager.mPositionDeltaInPreLayout));
            }

            @Override // androidx.leanback.widget.Grid.Provider
            public void removeItem(int i10) {
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i10 - gridLayoutManager.mPositionDeltaInPreLayout);
                GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                if ((gridLayoutManager2.mFlag & 3) == 1) {
                    gridLayoutManager2.detachAndScrapView(viewFindViewByPosition, gridLayoutManager2.mRecycler);
                } else {
                    gridLayoutManager2.removeAndRecycleView(viewFindViewByPosition, gridLayoutManager2.mRecycler);
                }
            }
        };
        this.mBaseGridView = baseGridView;
        this.mChildVisibility = -1;
        setItemPrefetchEnabled(false);
    }

    private void addA11yActionMovingBackward(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, boolean z10) {
        if (Build.VERSION.SDK_INT < 23) {
            accessibilityNodeInfoCompat.addAction(8192);
        } else if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.addAction(z10 ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT);
        } else {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
        }
        accessibilityNodeInfoCompat.setScrollable(true);
    }

    private void addA11yActionMovingForward(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, boolean z10) {
        if (Build.VERSION.SDK_INT < 23) {
            accessibilityNodeInfoCompat.addAction(4096);
        } else if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.addAction(z10 ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT);
        } else {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
        }
        accessibilityNodeInfoCompat.setScrollable(true);
    }

    private boolean appendOneColumnVisibleItems() {
        return this.mGrid.appendOneColumnVisibleItems();
    }

    private void appendVisibleItems() {
        this.mGrid.appendVisibleItems((this.mFlag & 262144) != 0 ? (-this.mExtraLayoutSpace) - this.mExtraLayoutSpaceInPreLayout : this.mSizePrimary + this.mExtraLayoutSpace + this.mExtraLayoutSpaceInPreLayout);
    }

    private int findImmediateChildIndex(View view) {
        BaseGridView baseGridView;
        View viewFindContainingItemView;
        if (view == null || (baseGridView = this.mBaseGridView) == null || view == baseGridView || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return -1;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (getChildAt(i10) == viewFindContainingItemView) {
                return i10;
            }
        }
        return -1;
    }

    private void focusToViewInLayout(boolean z10, boolean z11, int i10, int i11) {
        View viewFindViewByPosition = findViewByPosition(this.mFocusPosition);
        if (viewFindViewByPosition != null && z11) {
            scrollToView(viewFindViewByPosition, false, i10, i11);
        }
        if (viewFindViewByPosition != null && z10 && !viewFindViewByPosition.hasFocus()) {
            viewFindViewByPosition.requestFocus();
            return;
        }
        if (z10 || this.mBaseGridView.hasFocus()) {
            return;
        }
        if (viewFindViewByPosition == null || !viewFindViewByPosition.hasFocusable()) {
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                viewFindViewByPosition = getChildAt(i12);
                if (viewFindViewByPosition != null && viewFindViewByPosition.hasFocusable()) {
                    this.mBaseGridView.focusableViewAvailable(viewFindViewByPosition);
                    break;
                }
            }
        } else {
            this.mBaseGridView.focusableViewAvailable(viewFindViewByPosition);
        }
        if (z11 && viewFindViewByPosition != null && viewFindViewByPosition.hasFocus()) {
            scrollToView(viewFindViewByPosition, false, i10, i11);
        }
    }

    private void forceRequestLayout() {
        ViewCompat.postOnAnimation(this.mBaseGridView, this.mRequestLayoutRunnable);
    }

    private int getMovement(int i10) {
        int i11 = this.mOrientation;
        if (i11 == 0) {
            if (i10 == 17) {
                return (this.mFlag & 262144) == 0 ? 0 : 1;
            }
            if (i10 == 33) {
                return 2;
            }
            if (i10 == 66) {
                return (this.mFlag & 262144) == 0 ? 1 : 0;
            }
            if (i10 == 130) {
                return 3;
            }
        } else if (i11 == 1) {
            if (i10 == 17) {
                return (this.mFlag & 524288) == 0 ? 2 : 3;
            }
            if (i10 == 33) {
                return 0;
            }
            if (i10 == 66) {
                return (this.mFlag & 524288) == 0 ? 3 : 2;
            }
            if (i10 == 130) {
                return 1;
            }
        }
        return 17;
    }

    private int getPrimaryAlignedScrollDistance(View view) {
        return this.mWindowAlignment.mainAxis().getScroll(getViewCenter(view));
    }

    private int getRowSizeSecondary(int i10) {
        int i11 = this.mFixedRowSizeSecondary;
        if (i11 != 0) {
            return i11;
        }
        int[] iArr = this.mRowSizeSecondary;
        if (iArr == null) {
            return 0;
        }
        return iArr[i10];
    }

    private int getSizeSecondary() {
        int i10 = (this.mFlag & 524288) != 0 ? 0 : this.mNumRows - 1;
        return getRowStartSecondary(i10) + getRowSizeSecondary(i10);
    }

    private int getViewCenter(View view) {
        return this.mOrientation == 0 ? getViewCenterX(view) : getViewCenterY(view);
    }

    private int getViewCenterSecondary(View view) {
        return this.mOrientation == 0 ? getViewCenterY(view) : getViewCenterX(view);
    }

    private boolean gridOnRequestFocusInDescendantsAligned(int i10, Rect rect) {
        View viewFindViewByPosition = findViewByPosition(this.mFocusPosition);
        if (viewFindViewByPosition != null) {
            return viewFindViewByPosition.requestFocus(i10, rect);
        }
        return false;
    }

    private void initScrollController() {
        this.mWindowAlignment.reset();
        this.mWindowAlignment.horizontal.setSize(getWidth());
        this.mWindowAlignment.vertical.setSize(getHeight());
        this.mWindowAlignment.horizontal.setPadding(getPaddingLeft(), getPaddingRight());
        this.mWindowAlignment.vertical.setPadding(getPaddingTop(), getPaddingBottom());
        this.mSizePrimary = this.mWindowAlignment.mainAxis().getSize();
        this.mScrollOffsetSecondary = 0;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    /* JADX WARN: Code duplicated, block: B:36:0x008b  */
    private boolean layoutInit() {
        Grid grid;
        int itemCount = this.mState.getItemCount();
        if (itemCount == 0) {
            this.mFocusPosition = -1;
            this.mSubFocusPosition = 0;
        } else {
            int i10 = this.mFocusPosition;
            if (i10 >= itemCount) {
                this.mFocusPosition = itemCount - 1;
                this.mSubFocusPosition = 0;
            } else if (i10 == -1 && itemCount > 0) {
                this.mFocusPosition = 0;
                this.mSubFocusPosition = 0;
            }
        }
        if (!this.mState.didStructureChange() && (grid = this.mGrid) != null && grid.getFirstVisibleIndex() >= 0 && (this.mFlag & 256) == 0 && this.mGrid.getNumRows() == this.mNumRows) {
            updateScrollController();
            updateSecondaryScrollLimits();
            this.mGrid.setSpacing(this.mSpacingPrimary);
            return true;
        }
        this.mFlag &= -257;
        Grid grid2 = this.mGrid;
        if (grid2 == null || this.mNumRows != grid2.getNumRows()) {
            Grid gridCreateGrid = Grid.createGrid(this.mNumRows);
            this.mGrid = gridCreateGrid;
            gridCreateGrid.setProvider(this.mGridProvider);
            this.mGrid.setReversedFlow((262144 & this.mFlag) != 0);
        } else {
            if (((this.mFlag & 262144) != 0) != this.mGrid.isReversedFlow()) {
                Grid gridCreateGrid2 = Grid.createGrid(this.mNumRows);
                this.mGrid = gridCreateGrid2;
                gridCreateGrid2.setProvider(this.mGridProvider);
                this.mGrid.setReversedFlow((262144 & this.mFlag) != 0);
            }
        }
        initScrollController();
        updateSecondaryScrollLimits();
        this.mGrid.setSpacing(this.mSpacingPrimary);
        detachAndScrapAttachedViews(this.mRecycler);
        this.mGrid.resetVisibleIndex();
        this.mWindowAlignment.mainAxis().invalidateScrollMin();
        this.mWindowAlignment.mainAxis().invalidateScrollMax();
        return false;
    }

    private void leaveContext() {
        int i10 = this.mSaveContextLevel - 1;
        this.mSaveContextLevel = i10;
        if (i10 == 0) {
            this.mRecycler = null;
            this.mState = null;
            this.mPositionDeltaInPreLayout = 0;
            this.mExtraLayoutSpaceInPreLayout = 0;
        }
    }

    private void measureScrapChild(int i10, int i11, int i12, int[] iArr) {
        View viewForPosition = this.mRecycler.getViewForPosition(i10);
        if (viewForPosition != null) {
            LayoutParams layoutParams = (LayoutParams) viewForPosition.getLayoutParams();
            Rect rect = sTempRect;
            calculateItemDecorationsForChild(viewForPosition, rect);
            viewForPosition.measure(ViewGroup.getChildMeasureSpec(i11, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.left + rect.right, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.top + rect.bottom, ((ViewGroup.MarginLayoutParams) layoutParams).height));
            iArr[0] = getDecoratedMeasuredWidthWithMargin(viewForPosition);
            iArr[1] = getDecoratedMeasuredHeightWithMargin(viewForPosition);
            this.mRecycler.recycleView(viewForPosition);
        }
    }

    private boolean prependOneColumnVisibleItems() {
        return this.mGrid.prependOneColumnVisibleItems();
    }

    private void prependVisibleItems() {
        this.mGrid.prependVisibleItems((this.mFlag & 262144) != 0 ? this.mSizePrimary + this.mExtraLayoutSpace + this.mExtraLayoutSpaceInPreLayout : (-this.mExtraLayoutSpace) - this.mExtraLayoutSpaceInPreLayout);
    }

    private boolean processRowSizeSecondary(boolean z10) {
        if (this.mFixedRowSizeSecondary != 0 || this.mRowSizeSecondary == null) {
            return false;
        }
        Grid grid = this.mGrid;
        CircularIntArray[] itemPositionsInRows = grid == null ? null : grid.getItemPositionsInRows();
        boolean z11 = false;
        int i10 = -1;
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            CircularIntArray circularIntArray = itemPositionsInRows == null ? null : itemPositionsInRows[i11];
            int size = circularIntArray == null ? 0 : circularIntArray.size();
            int i12 = -1;
            for (int i13 = 0; i13 < size; i13 += 2) {
                int i14 = circularIntArray.get(i13 + 1);
                for (int i15 = circularIntArray.get(i13); i15 <= i14; i15++) {
                    View viewFindViewByPosition = findViewByPosition(i15 - this.mPositionDeltaInPreLayout);
                    if (viewFindViewByPosition != null) {
                        if (z10) {
                            measureChild(viewFindViewByPosition);
                        }
                        int decoratedMeasuredHeightWithMargin = this.mOrientation == 0 ? getDecoratedMeasuredHeightWithMargin(viewFindViewByPosition) : getDecoratedMeasuredWidthWithMargin(viewFindViewByPosition);
                        if (decoratedMeasuredHeightWithMargin > i12) {
                            i12 = decoratedMeasuredHeightWithMargin;
                        }
                    }
                }
            }
            int itemCount = this.mState.getItemCount();
            if (!this.mBaseGridView.hasFixedSize() && z10 && i12 < 0 && itemCount > 0) {
                if (i10 < 0) {
                    int i16 = this.mFocusPosition;
                    if (i16 < 0) {
                        i16 = 0;
                    } else if (i16 >= itemCount) {
                        i16 = itemCount - 1;
                    }
                    if (getChildCount() > 0) {
                        int layoutPosition = this.mBaseGridView.getChildViewHolder(getChildAt(0)).getLayoutPosition();
                        int layoutPosition2 = this.mBaseGridView.getChildViewHolder(getChildAt(getChildCount() - 1)).getLayoutPosition();
                        if (i16 >= layoutPosition && i16 <= layoutPosition2) {
                            i16 = i16 - layoutPosition <= layoutPosition2 - i16 ? layoutPosition - 1 : layoutPosition2 + 1;
                            if (i16 < 0 && layoutPosition2 < itemCount - 1) {
                                i16 = layoutPosition2 + 1;
                            } else if (i16 >= itemCount && layoutPosition > 0) {
                                i16 = layoutPosition - 1;
                            }
                        }
                    }
                    if (i16 >= 0 && i16 < itemCount) {
                        measureScrapChild(i16, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0), this.mMeasuredDimension);
                        i10 = this.mOrientation == 0 ? this.mMeasuredDimension[1] : this.mMeasuredDimension[0];
                    }
                }
                if (i10 >= 0) {
                    i12 = i10;
                }
            }
            if (i12 < 0) {
                i12 = 0;
            }
            int[] iArr = this.mRowSizeSecondary;
            if (iArr[i11] != i12) {
                iArr[i11] = i12;
                z11 = true;
            }
        }
        return z11;
    }

    private void removeInvisibleViewsAtEnd() {
        int i10 = this.mFlag;
        if ((65600 & i10) == 65536) {
            this.mGrid.removeInvisibleItemsAtEnd(this.mFocusPosition, (i10 & 262144) != 0 ? -this.mExtraLayoutSpace : this.mSizePrimary + this.mExtraLayoutSpace);
        }
    }

    private void removeInvisibleViewsAtFront() {
        int i10 = this.mFlag;
        if ((65600 & i10) == 65536) {
            this.mGrid.removeInvisibleItemsAtFront(this.mFocusPosition, (i10 & 262144) != 0 ? this.mSizePrimary + this.mExtraLayoutSpace : -this.mExtraLayoutSpace);
        }
    }

    private void saveContext(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i10 = this.mSaveContextLevel;
        if (i10 == 0) {
            this.mRecycler = recycler;
            this.mState = state;
            this.mPositionDeltaInPreLayout = 0;
            this.mExtraLayoutSpaceInPreLayout = 0;
        }
        this.mSaveContextLevel = i10 + 1;
    }

    private int scrollDirectionPrimary(int i10) {
        int minScroll;
        int i11 = this.mFlag;
        if ((i11 & 64) == 0 && (i11 & 3) != 1 && (i10 <= 0 ? !(i10 >= 0 || this.mWindowAlignment.mainAxis().isMinUnknown() || i10 >= (minScroll = this.mWindowAlignment.mainAxis().getMinScroll())) : !(this.mWindowAlignment.mainAxis().isMaxUnknown() || i10 <= (minScroll = this.mWindowAlignment.mainAxis().getMaxScroll())))) {
            i10 = minScroll;
        }
        if (i10 == 0) {
            return 0;
        }
        offsetChildrenPrimary(-i10);
        if ((this.mFlag & 3) == 1) {
            updateScrollLimits();
            return i10;
        }
        int childCount = getChildCount();
        if ((this.mFlag & 262144) == 0 ? i10 >= 0 : i10 <= 0) {
            appendVisibleItems();
        } else {
            prependVisibleItems();
        }
        boolean z10 = getChildCount() > childCount;
        int childCount2 = getChildCount();
        if ((262144 & this.mFlag) == 0 ? i10 >= 0 : i10 <= 0) {
            removeInvisibleViewsAtFront();
        } else {
            removeInvisibleViewsAtEnd();
        }
        if (z10 | (getChildCount() < childCount2)) {
            updateRowSecondarySizeRefresh();
        }
        this.mBaseGridView.invalidate();
        updateScrollLimits();
        return i10;
    }

    private int scrollDirectionSecondary(int i10) {
        if (i10 == 0) {
            return 0;
        }
        offsetChildrenSecondary(-i10);
        this.mScrollOffsetSecondary += i10;
        updateSecondaryScrollLimits();
        this.mBaseGridView.invalidate();
        return i10;
    }

    private void scrollGrid(int i10, int i11, boolean z10) {
        if ((this.mFlag & 3) == 1) {
            scrollDirectionPrimary(i10);
            scrollDirectionSecondary(i11);
            return;
        }
        if (this.mOrientation != 0) {
            i11 = i10;
            i10 = i11;
        }
        if (z10) {
            this.mBaseGridView.smoothScrollBy(i10, i11);
        } else {
            this.mBaseGridView.scrollBy(i10, i11);
            dispatchChildSelectedAndPositioned();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void sendTypeViewScrolledAccessibilityEvent() {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(4096);
        this.mBaseGridView.onInitializeAccessibilityEvent(accessibilityEventObtain);
        BaseGridView baseGridView = this.mBaseGridView;
        baseGridView.requestSendAccessibilityEvent(baseGridView, accessibilityEventObtain);
    }

    private void updateRowSecondarySizeRefresh() {
        int i10 = (this.mFlag & (-1025)) | (processRowSizeSecondary(false) ? 1024 : 0);
        this.mFlag = i10;
        if ((i10 & 1024) != 0) {
            forceRequestLayout();
        }
    }

    private void updateScrollController() {
        this.mWindowAlignment.horizontal.setSize(getWidth());
        this.mWindowAlignment.vertical.setSize(getHeight());
        this.mWindowAlignment.horizontal.setPadding(getPaddingLeft(), getPaddingRight());
        this.mWindowAlignment.vertical.setPadding(getPaddingTop(), getPaddingBottom());
        this.mSizePrimary = this.mWindowAlignment.mainAxis().getSize();
    }

    private void updateSecondaryScrollLimits() {
        WindowAlignment.Axis axisSecondAxis = this.mWindowAlignment.secondAxis();
        int paddingMin = axisSecondAxis.getPaddingMin() - this.mScrollOffsetSecondary;
        int sizeSecondary = getSizeSecondary() + paddingMin;
        axisSecondAxis.updateMinMax(paddingMin, sizeSecondary, paddingMin, sizeSecondary);
    }

    void addOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        if (this.mChildViewHolderSelectedListeners == null) {
            this.mChildViewHolderSelectedListeners = new ArrayList<>();
        }
        this.mChildViewHolderSelectedListeners.add(onChildViewHolderSelectedListener);
    }

    void addOnLayoutCompletedListener(BaseGridView.OnLayoutCompletedListener onLayoutCompletedListener) {
        if (this.mOnLayoutCompletedListeners == null) {
            this.mOnLayoutCompletedListeners = new ArrayList<>();
        }
        this.mOnLayoutCompletedListeners.add(onLayoutCompletedListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0 || this.mNumRows > 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1 || this.mNumRows > 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int i10, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i11 = this.mBaseGridView.mInitialPrefetchItemCount;
        if (i10 == 0 || i11 == 0) {
            return;
        }
        int iMax = Math.max(0, Math.min(this.mFocusPosition - ((i11 - 1) / 2), i10 - i11));
        for (int i12 = iMax; i12 < i10 && i12 < iMax + i11; i12++) {
            layoutPrefetchRegistry.addPosition(i12, 0);
        }
    }

    void dispatchChildSelected() {
        if (this.mChildSelectedListener != null || hasOnChildViewHolderSelectedListener()) {
            int i10 = this.mFocusPosition;
            View viewFindViewByPosition = i10 == -1 ? null : findViewByPosition(i10);
            if (viewFindViewByPosition != null) {
                RecyclerView.ViewHolder childViewHolder = this.mBaseGridView.getChildViewHolder(viewFindViewByPosition);
                OnChildSelectedListener onChildSelectedListener = this.mChildSelectedListener;
                if (onChildSelectedListener != null) {
                    onChildSelectedListener.onChildSelected(this.mBaseGridView, viewFindViewByPosition, this.mFocusPosition, childViewHolder == null ? -1L : childViewHolder.getItemId());
                }
                fireOnChildViewHolderSelected(this.mBaseGridView, childViewHolder, this.mFocusPosition, this.mSubFocusPosition);
            } else {
                OnChildSelectedListener onChildSelectedListener2 = this.mChildSelectedListener;
                if (onChildSelectedListener2 != null) {
                    onChildSelectedListener2.onChildSelected(this.mBaseGridView, null, -1, -1L);
                }
                fireOnChildViewHolderSelected(this.mBaseGridView, null, -1, 0);
            }
            if ((this.mFlag & 3) == 1 || this.mBaseGridView.isLayoutRequested()) {
                return;
            }
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                if (getChildAt(i11).isLayoutRequested()) {
                    forceRequestLayout();
                    return;
                }
            }
        }
    }

    void fillScrapViewsInPostLayout() {
        List<RecyclerView.ViewHolder> scrapList = this.mRecycler.getScrapList();
        int size = scrapList.size();
        if (size == 0) {
            return;
        }
        int[] iArr = this.mDisappearingPositions;
        if (iArr == null || size > iArr.length) {
            int length = iArr == null ? 16 : iArr.length;
            while (length < size) {
                length <<= 1;
            }
            this.mDisappearingPositions = new int[length];
        }
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            int absoluteAdapterPosition = scrapList.get(i11).getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition >= 0) {
                this.mDisappearingPositions[i10] = absoluteAdapterPosition;
                i10++;
            }
        }
        if (i10 > 0) {
            Arrays.sort(this.mDisappearingPositions, 0, i10);
            this.mGrid.fillDisappearingItems(this.mDisappearingPositions, i10, this.mPositionToRowInPostLayout);
        }
        this.mPositionToRowInPostLayout.clear();
    }

    void fireOnChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i10, int i11) {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            this.mChildViewHolderSelectedListeners.get(size).onChildViewHolderSelected(recyclerView, viewHolder, i10, i11);
        }
    }

    void fireOnChildViewHolderSelectedAndPositioned(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i10, int i11) {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            this.mChildViewHolderSelectedListeners.get(size).onChildViewHolderSelectedAndPositioned(recyclerView, viewHolder, i10, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            return new LayoutParams((RecyclerView.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    AudioManager getAudioManager() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) this.mBaseGridView.getContext().getSystemService("audio");
        }
        return this.mAudioManager;
    }

    int getChildDrawingOrder(RecyclerView recyclerView, int i10, int i11) {
        int iIndexOfChild;
        View viewFindViewByPosition = findViewByPosition(this.mFocusPosition);
        if (viewFindViewByPosition != null && i11 >= (iIndexOfChild = recyclerView.indexOfChild(viewFindViewByPosition))) {
            return i11 < i10 + (-1) ? ((iIndexOfChild + i10) - 1) - i11 : iIndexOfChild;
        }
        return i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Grid grid;
        return (this.mOrientation != 1 || (grid = this.mGrid) == null) ? super.getColumnCountForAccessibility(recycler, state) : grid.getNumRows();
    }

    int getExtraLayoutSpace() {
        return this.mExtraLayoutSpace;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <E> E getFacet(RecyclerView.ViewHolder viewHolder, Class<? extends E> cls) {
        FacetProviderAdapter facetProviderAdapter;
        FacetProvider facetProvider;
        E e10 = viewHolder instanceof FacetProvider ? (E) ((FacetProvider) viewHolder).getFacet(cls) : null;
        return (e10 != null || (facetProviderAdapter = this.mFacetProviderAdapter) == null || (facetProvider = facetProviderAdapter.getFacetProvider(viewHolder.getItemViewType())) == null) ? e10 : (E) facetProvider.getFacet(cls);
    }

    int getFocusScrollStrategy() {
        return this.mFocusScrollStrategy;
    }

    int getHorizontalSpacing() {
        return this.mHorizontalSpacing;
    }

    int getItemAlignmentOffset() {
        return this.mItemAlignment.mainAxis().getItemAlignmentOffset();
    }

    float getItemAlignmentOffsetPercent() {
        return this.mItemAlignment.mainAxis().getItemAlignmentOffsetPercent();
    }

    int getItemAlignmentViewId() {
        return this.mItemAlignment.mainAxis().getItemAlignmentViewId();
    }

    boolean getPruneChild() {
        return (this.mFlag & 65536) != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Grid grid;
        return (this.mOrientation != 0 || (grid = this.mGrid) == null) ? super.getRowCountForAccessibility(recycler, state) : grid.getNumRows();
    }

    int getRowStartSecondary(int i10) {
        int rowSizeSecondary = 0;
        if ((this.mFlag & 524288) != 0) {
            for (int i11 = this.mNumRows - 1; i11 > i10; i11--) {
                rowSizeSecondary += getRowSizeSecondary(i11) + this.mSpacingSecondary;
            }
            return rowSizeSecondary;
        }
        int rowSizeSecondary2 = 0;
        while (rowSizeSecondary < i10) {
            rowSizeSecondary2 += getRowSizeSecondary(rowSizeSecondary) + this.mSpacingSecondary;
            rowSizeSecondary++;
        }
        return rowSizeSecondary2;
    }

    boolean getScrollPosition(View view, View view2, int[] iArr) {
        int i10 = this.mFocusScrollStrategy;
        return (i10 == 1 || i10 == 2) ? getNoneAlignedPosition(view, iArr) : getAlignedPosition(view, view2, iArr);
    }

    int getSelection() {
        return this.mFocusPosition;
    }

    int getSlideOutDistance() {
        int left;
        int right;
        int top;
        if (this.mOrientation == 1) {
            int i10 = -getHeight();
            return (getChildCount() <= 0 || (top = getChildAt(0).getTop()) >= 0) ? i10 : i10 + top;
        }
        if ((this.mFlag & 262144) != 0) {
            int width = getWidth();
            return (getChildCount() <= 0 || (right = getChildAt(0).getRight()) <= width) ? width : right;
        }
        int i11 = -getWidth();
        return (getChildCount() <= 0 || (left = getChildAt(0).getLeft()) >= 0) ? i11 : i11 + left;
    }

    int getSubSelection() {
        return this.mSubFocusPosition;
    }

    String getTag() {
        return "GridLayoutManager:" + this.mBaseGridView.getId();
    }

    int getVerticalSpacing() {
        return this.mVerticalSpacing;
    }

    View getViewForPosition(int i10) {
        View viewForPosition = this.mRecycler.getViewForPosition(i10);
        ((LayoutParams) viewForPosition.getLayoutParams()).setItemAlignmentFacet((ItemAlignmentFacet) getFacet(this.mBaseGridView.getChildViewHolder(viewForPosition), ItemAlignmentFacet.class));
        return viewForPosition;
    }

    int getViewMax(View view) {
        return this.mOrientationHelper.getDecoratedEnd(view);
    }

    int getViewMin(View view) {
        return this.mOrientationHelper.getDecoratedStart(view);
    }

    int getViewPrimarySize(View view) {
        Rect rect = sTempRect;
        getDecoratedBoundsWithMargins(view, rect);
        return this.mOrientation == 0 ? rect.width() : rect.height();
    }

    void getViewSelectedOffsets(View view, int[] iArr) {
        if (this.mOrientation == 0) {
            iArr[0] = getPrimaryAlignedScrollDistance(view);
            iArr[1] = getSecondaryScrollDistance(view);
        } else {
            iArr[1] = getPrimaryAlignedScrollDistance(view);
            iArr[0] = getSecondaryScrollDistance(view);
        }
    }

    int getWindowAlignment() {
        return this.mWindowAlignment.mainAxis().getWindowAlignment();
    }

    int getWindowAlignmentOffset() {
        return this.mWindowAlignment.mainAxis().getWindowAlignmentOffset();
    }

    float getWindowAlignmentOffsetPercent() {
        return this.mWindowAlignment.mainAxis().getWindowAlignmentOffsetPercent();
    }

    boolean gridOnRequestFocusInDescendants(RecyclerView recyclerView, int i10, Rect rect) {
        int i11 = this.mFocusScrollStrategy;
        return (i11 == 1 || i11 == 2) ? gridOnRequestFocusInDescendantsUnaligned(i10, rect) : gridOnRequestFocusInDescendantsAligned(i10, rect);
    }

    boolean hasDoneFirstLayout() {
        return this.mGrid != null;
    }

    boolean hasOnChildViewHolderSelectedListener() {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        return arrayList != null && arrayList.size() > 0;
    }

    boolean hasPreviousViewInSameRow(int i10) {
        Grid grid = this.mGrid;
        if (grid != null && i10 != -1 && grid.getFirstVisibleIndex() >= 0) {
            if (this.mGrid.getFirstVisibleIndex() > 0) {
                return true;
            }
            int i11 = this.mGrid.getLocation(i10).mRow;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                int adapterPositionByIndex = getAdapterPositionByIndex(childCount);
                Grid.Location location = this.mGrid.getLocation(adapterPositionByIndex);
                if (location != null && location.mRow == i11 && adapterPositionByIndex < i10) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isFocusSearchDisabled() {
        return (this.mFlag & 32768) != 0;
    }

    boolean isItemAlignmentOffsetWithPadding() {
        return this.mItemAlignment.mainAxis().isItemAlignmentOffsetWithPadding();
    }

    boolean isItemFullyVisible(int i10) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.mBaseGridView.findViewHolderForAdapterPosition(i10);
        return viewHolderFindViewHolderForAdapterPosition != null && viewHolderFindViewHolderForAdapterPosition.itemView.getLeft() >= 0 && viewHolderFindViewHolderForAdapterPosition.itemView.getRight() <= this.mBaseGridView.getWidth() && viewHolderFindViewHolderForAdapterPosition.itemView.getTop() >= 0 && viewHolderFindViewHolderForAdapterPosition.itemView.getBottom() <= this.mBaseGridView.getHeight();
    }

    boolean isScrollEnabled() {
        return (this.mFlag & 131072) != 0;
    }

    boolean isSlidingChildViews() {
        return (this.mFlag & 64) != 0;
    }

    void layoutChild(int i10, View view, int i11, int i12, int i13) {
        int rowSizeSecondary;
        int i14;
        int i15;
        int i16;
        int i17;
        int decoratedMeasuredHeightWithMargin = this.mOrientation == 0 ? getDecoratedMeasuredHeightWithMargin(view) : getDecoratedMeasuredWidthWithMargin(view);
        int i18 = this.mFixedRowSizeSecondary;
        if (i18 > 0) {
            decoratedMeasuredHeightWithMargin = Math.min(decoratedMeasuredHeightWithMargin, i18);
        }
        int i19 = this.mGravity;
        int i20 = i19 & 112;
        int absoluteGravity = (this.mFlag & PF_REVERSE_FLOW_MASK) != 0 ? Gravity.getAbsoluteGravity(i19 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK, 1) : i19 & 7;
        int i21 = this.mOrientation;
        if ((i21 != 0 || i20 != 48) && (i21 != 1 || absoluteGravity != 3)) {
            if ((i21 == 0 && i20 == 80) || (i21 == 1 && absoluteGravity == 5)) {
                rowSizeSecondary = getRowSizeSecondary(i10) - decoratedMeasuredHeightWithMargin;
            } else if ((i21 == 0 && i20 == 16) || (i21 == 1 && absoluteGravity == 1)) {
                rowSizeSecondary = (getRowSizeSecondary(i10) - decoratedMeasuredHeightWithMargin) / 2;
            }
            i13 += rowSizeSecondary;
        }
        if (this.mOrientation == 0) {
            i16 = i11;
            i17 = i12;
            i14 = i13;
            i15 = decoratedMeasuredHeightWithMargin + i13;
        } else {
            i14 = i11;
            i15 = i12;
            i16 = i13;
            i17 = decoratedMeasuredHeightWithMargin + i13;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutDecoratedWithMargins(view, i16, i14, i17, i15);
        Rect rect = sTempRect;
        super.getDecoratedBoundsWithMargins(view, rect);
        layoutParams.setOpticalInsets(i16 - rect.left, i14 - rect.top, rect.right - i17, rect.bottom - i15);
        updateChildAlignments(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        if (adapter != null) {
            discardLayoutInfo();
            this.mFocusPosition = -1;
            this.mFocusPositionOffset = 0;
            this.mChildrenStates.clear();
        }
        if (adapter2 instanceof FacetProviderAdapter) {
            this.mFacetProviderAdapter = (FacetProviderAdapter) adapter2;
        } else {
            this.mFacetProviderAdapter = null;
        }
        super.onAdapterChanged(adapter, adapter2);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean onAddFocusables(RecyclerView recyclerView, @SuppressLint({"ConcreteCollection"}) ArrayList<View> arrayList, int i10, int i11) {
        View childAt;
        int i12;
        int i13 = 1;
        if ((this.mFlag & 32768) != 0) {
            return true;
        }
        if (!recyclerView.hasFocus()) {
            int size = arrayList.size();
            if (this.mFocusScrollStrategy != 0) {
                int paddingMin = this.mWindowAlignment.mainAxis().getPaddingMin();
                int clientSize = this.mWindowAlignment.mainAxis().getClientSize() + paddingMin;
                int childCount = getChildCount();
                for (int i14 = 0; i14 < childCount; i14++) {
                    View childAt2 = getChildAt(i14);
                    if (childAt2.getVisibility() == 0 && getViewMin(childAt2) >= paddingMin && getViewMax(childAt2) <= clientSize) {
                        childAt2.addFocusables(arrayList, i10, i11);
                    }
                }
                if (arrayList.size() == size) {
                    int childCount2 = getChildCount();
                    for (int i15 = 0; i15 < childCount2; i15++) {
                        View childAt3 = getChildAt(i15);
                        if (childAt3.getVisibility() == 0) {
                            childAt3.addFocusables(arrayList, i10, i11);
                        }
                    }
                }
            } else {
                View viewFindViewByPosition = findViewByPosition(this.mFocusPosition);
                if (viewFindViewByPosition != null) {
                    viewFindViewByPosition.addFocusables(arrayList, i10, i11);
                }
            }
            if (arrayList.size() != size || !recyclerView.isFocusable()) {
                return true;
            }
            arrayList.add(recyclerView);
            return true;
        }
        if (this.mPendingMoveSmoothScroller != null) {
            return true;
        }
        int movement = getMovement(i10);
        int iFindImmediateChildIndex = findImmediateChildIndex(recyclerView.findFocus());
        int adapterPositionByIndex = getAdapterPositionByIndex(iFindImmediateChildIndex);
        View viewFindViewByPosition2 = adapterPositionByIndex == -1 ? null : findViewByPosition(adapterPositionByIndex);
        if (viewFindViewByPosition2 != null) {
            viewFindViewByPosition2.addFocusables(arrayList, i10, i11);
        }
        if (this.mGrid == null || getChildCount() == 0) {
            return true;
        }
        if ((movement == 3 || movement == 2) && this.mGrid.getNumRows() <= 1) {
            return true;
        }
        Grid grid = this.mGrid;
        int i16 = (grid == null || viewFindViewByPosition2 == null) ? -1 : grid.getLocation(adapterPositionByIndex).mRow;
        int size2 = arrayList.size();
        int i17 = (movement == 1 || movement == 3) ? 1 : -1;
        int childCount3 = i17 > 0 ? getChildCount() - 1 : 0;
        int childCount4 = iFindImmediateChildIndex == -1 ? i17 > 0 ? 0 : getChildCount() - 1 : iFindImmediateChildIndex + i17;
        while (true) {
            if (i17 <= 0) {
                if (childCount4 < childCount3) {
                    break;
                }
                childAt = getChildAt(childCount4);
                if (childAt.getVisibility() != 0) {
                }
                childCount4 += i17;
                i13 = 1;
            } else {
                if (childCount4 > childCount3) {
                    break;
                }
                childAt = getChildAt(childCount4);
                if (childAt.getVisibility() != 0 && childAt.hasFocusable()) {
                    if (viewFindViewByPosition2 == null) {
                        childAt.addFocusables(arrayList, i10, i11);
                        if (arrayList.size() > size2) {
                            break;
                        }
                    } else {
                        int adapterPositionByIndex2 = getAdapterPositionByIndex(childCount4);
                        Grid.Location location = this.mGrid.getLocation(adapterPositionByIndex2);
                        if (location != null) {
                            if (movement == i13) {
                                if (location.mRow == i16 && adapterPositionByIndex2 > adapterPositionByIndex) {
                                    childAt.addFocusables(arrayList, i10, i11);
                                    if (arrayList.size() > size2) {
                                        break;
                                    }
                                }
                            } else if (movement == 0) {
                                if (location.mRow == i16 && adapterPositionByIndex2 < adapterPositionByIndex) {
                                    childAt.addFocusables(arrayList, i10, i11);
                                    if (arrayList.size() > size2) {
                                        break;
                                    }
                                }
                            } else if (movement == 3) {
                                int i18 = location.mRow;
                                if (i18 != i16) {
                                    if (i18 < i16) {
                                        break;
                                    }
                                    childAt.addFocusables(arrayList, i10, i11);
                                }
                            } else if (movement == 2 && (i12 = location.mRow) != i16) {
                                if (i12 > i16) {
                                    return true;
                                }
                                childAt.addFocusables(arrayList, i10, i11);
                            }
                        }
                    }
                }
                childCount4 += i17;
                i13 = 1;
            }
        }
        return true;
    }

    void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (!z10) {
            return;
        }
        int i11 = this.mFocusPosition;
        while (true) {
            View viewFindViewByPosition = findViewByPosition(i11);
            if (viewFindViewByPosition == null) {
                return;
            }
            if (viewFindViewByPosition.getVisibility() == 0 && viewFindViewByPosition.hasFocusable()) {
                viewFindViewByPosition.requestFocus();
                return;
            }
            i11++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onInterceptFocusSearch(View view, int i10) {
        View viewFindNextFocus;
        View viewFindNextFocus2;
        if ((this.mFlag & 32768) != 0) {
            return view;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (i10 == 2 || i10 == 1) {
            if (canScrollVertically()) {
                viewFindNextFocus = focusFinder.findNextFocus(this.mBaseGridView, view, i10 == 2 ? 130 : 33);
            } else {
                viewFindNextFocus = null;
            }
            if (canScrollHorizontally()) {
                viewFindNextFocus2 = focusFinder.findNextFocus(this.mBaseGridView, view, (getLayoutDirection() == 1) ^ (i10 == 2) ? 66 : 17);
            } else {
                viewFindNextFocus2 = viewFindNextFocus;
            }
        } else {
            viewFindNextFocus2 = focusFinder.findNextFocus(this.mBaseGridView, view, i10);
        }
        if (viewFindNextFocus2 != null) {
            return viewFindNextFocus2;
        }
        if (this.mBaseGridView.getDescendantFocusability() == 393216) {
            return this.mBaseGridView.getParent().focusSearch(view, i10);
        }
        int movement = getMovement(i10);
        boolean z10 = this.mBaseGridView.getScrollState() != 0;
        if (movement == 1) {
            if (z10 || (this.mFlag & 4096) == 0) {
                viewFindNextFocus2 = view;
            }
            if ((this.mFlag & 131072) != 0 && !hasCreatedLastItem()) {
                processPendingMovement(true);
                viewFindNextFocus2 = view;
            }
        } else if (movement == 0) {
            if (z10 || (this.mFlag & 2048) == 0) {
                viewFindNextFocus2 = view;
            }
            if ((this.mFlag & 131072) != 0 && !hasCreatedFirstItem()) {
                processPendingMovement(false);
                viewFindNextFocus2 = view;
            }
        } else if (movement == 3) {
        }
        if (viewFindNextFocus2 != null) {
            return viewFindNextFocus2;
        }
        View viewFocusSearch = this.mBaseGridView.getParent().focusSearch(view, i10);
        if (viewFocusSearch != null) {
            return viewFocusSearch;
        }
        return view != null ? view : this.mBaseGridView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        Grid grid;
        int i12;
        if (this.mFocusPosition != -1 && (grid = this.mGrid) != null && grid.getFirstVisibleIndex() >= 0 && (i12 = this.mFocusPositionOffset) != Integer.MIN_VALUE && i10 <= this.mFocusPosition + i12) {
            this.mFocusPositionOffset = i12 + i11;
        }
        this.mChildrenStates.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        int i13;
        int i14 = this.mFocusPosition;
        if (i14 != -1 && (i13 = this.mFocusPositionOffset) != Integer.MIN_VALUE) {
            int i15 = i14 + i13;
            if (i10 <= i15 && i15 < i10 + i12) {
                this.mFocusPositionOffset = i13 + (i11 - i10);
            } else if (i10 < i15 && i11 > i15 - i12) {
                this.mFocusPositionOffset = i13 - i12;
            } else if (i10 > i15 && i11 < i15) {
                this.mFocusPositionOffset = i13 + i12;
            }
        }
        this.mChildrenStates.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        Grid grid;
        int i12;
        int i13;
        int i14;
        if (this.mFocusPosition != -1 && (grid = this.mGrid) != null && grid.getFirstVisibleIndex() >= 0 && (i12 = this.mFocusPositionOffset) != Integer.MIN_VALUE && i10 <= (i14 = (i13 = this.mFocusPosition) + i12)) {
            if (i10 + i11 > i14) {
                this.mFocusPosition = i13 + i12 + (i10 - i14);
                this.mFocusPositionOffset = Integer.MIN_VALUE;
            } else {
                this.mFocusPositionOffset = i12 - i11;
            }
        }
        this.mChildrenStates.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int remainingScrollHorizontal;
        int remainingScrollVertical;
        int i10;
        int i11;
        int i12;
        if (this.mNumRows != 0 && state.getItemCount() >= 0) {
            if ((this.mFlag & 64) != 0 && getChildCount() > 0) {
                this.mFlag |= 128;
                return;
            }
            int i13 = this.mFlag;
            if ((i13 & 512) == 0) {
                discardLayoutInfo();
                removeAndRecycleAllViews(recycler);
                return;
            }
            this.mFlag = (i13 & (-4)) | 1;
            saveContext(recycler, state);
            int iMax = Integer.MIN_VALUE;
            if (state.isPreLayout()) {
                updatePositionDeltaInPreLayout();
                int childCount = getChildCount();
                if (this.mGrid != null && childCount > 0) {
                    int oldPosition = this.mBaseGridView.getChildViewHolder(getChildAt(0)).getOldPosition();
                    int oldPosition2 = this.mBaseGridView.getChildViewHolder(getChildAt(childCount - 1)).getOldPosition();
                    int iMin = Integer.MAX_VALUE;
                    for (int i14 = 0; i14 < childCount; i14++) {
                        View childAt = getChildAt(i14);
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        int childAdapterPosition = this.mBaseGridView.getChildAdapterPosition(childAt);
                        if (layoutParams.isItemChanged() || layoutParams.isItemRemoved() || childAt.isLayoutRequested() || ((!childAt.hasFocus() && this.mFocusPosition == layoutParams.getAbsoluteAdapterPosition()) || ((childAt.hasFocus() && this.mFocusPosition != layoutParams.getAbsoluteAdapterPosition()) || childAdapterPosition < oldPosition || childAdapterPosition > oldPosition2))) {
                            iMin = Math.min(iMin, getViewMin(childAt));
                            iMax = Math.max(iMax, getViewMax(childAt));
                        }
                    }
                    if (iMax > iMin) {
                        this.mExtraLayoutSpaceInPreLayout = iMax - iMin;
                    }
                    appendVisibleItems();
                    prependVisibleItems();
                }
                this.mFlag &= -4;
                leaveContext();
                return;
            }
            if (state.willRunPredictiveAnimations()) {
                updatePositionToRowMapInPostLayout();
            }
            boolean z10 = !isSmoothScrolling() && this.mFocusScrollStrategy == 0;
            int i15 = this.mFocusPosition;
            if (i15 != -1 && (i12 = this.mFocusPositionOffset) != Integer.MIN_VALUE) {
                this.mFocusPosition = i15 + i12;
                this.mSubFocusPosition = 0;
            }
            this.mFocusPositionOffset = 0;
            View viewFindViewByPosition = findViewByPosition(this.mFocusPosition);
            int i16 = this.mFocusPosition;
            int i17 = this.mSubFocusPosition;
            boolean zHasFocus = this.mBaseGridView.hasFocus();
            Grid grid = this.mGrid;
            int firstVisibleIndex = grid != null ? grid.getFirstVisibleIndex() : -1;
            Grid grid2 = this.mGrid;
            int lastVisibleIndex = grid2 != null ? grid2.getLastVisibleIndex() : -1;
            if (this.mOrientation == 0) {
                remainingScrollVertical = state.getRemainingScrollHorizontal();
                remainingScrollHorizontal = state.getRemainingScrollVertical();
            } else {
                remainingScrollHorizontal = state.getRemainingScrollHorizontal();
                remainingScrollVertical = state.getRemainingScrollVertical();
            }
            if (layoutInit()) {
                this.mFlag |= 4;
                this.mGrid.setStart(this.mFocusPosition);
                fastRelayout();
            } else {
                int i18 = this.mFlag;
                this.mFlag = i18 & (-5);
                this.mFlag = (z10 ? 16 : 0) | (i18 & (-21));
                if (z10 && (firstVisibleIndex < 0 || (i10 = this.mFocusPosition) > lastVisibleIndex || i10 < firstVisibleIndex)) {
                    firstVisibleIndex = this.mFocusPosition;
                    lastVisibleIndex = firstVisibleIndex;
                }
                this.mGrid.setStart(firstVisibleIndex);
                if (lastVisibleIndex != -1) {
                    while (appendOneColumnVisibleItems() && findViewByPosition(lastVisibleIndex) == null) {
                    }
                }
            }
            while (true) {
                updateScrollLimits();
                int firstVisibleIndex2 = this.mGrid.getFirstVisibleIndex();
                int lastVisibleIndex2 = this.mGrid.getLastVisibleIndex();
                focusToViewInLayout(zHasFocus, z10, -remainingScrollVertical, -remainingScrollHorizontal);
                appendVisibleItems();
                prependVisibleItems();
                if (this.mGrid.getFirstVisibleIndex() == firstVisibleIndex2 && this.mGrid.getLastVisibleIndex() == lastVisibleIndex2) {
                    break;
                }
            }
            removeInvisibleViewsAtFront();
            removeInvisibleViewsAtEnd();
            if (state.willRunPredictiveAnimations()) {
                fillScrapViewsInPostLayout();
            }
            int i19 = this.mFlag;
            if ((i19 & 1024) != 0) {
                this.mFlag = i19 & (-1025);
            } else {
                updateRowSecondarySizeRefresh();
            }
            if (((this.mFlag & 4) != 0 && ((i11 = this.mFocusPosition) != i16 || this.mSubFocusPosition != i17 || findViewByPosition(i11) != viewFindViewByPosition || (this.mFlag & 8) != 0)) || (this.mFlag & 20) == 16) {
                dispatchChildSelected();
            }
            dispatchChildSelectedAndPositioned();
            if ((this.mFlag & 64) != 0) {
                scrollDirectionPrimary(getSlideOutDistance());
            }
            this.mFlag &= -4;
            leaveContext();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        ArrayList<BaseGridView.OnLayoutCompletedListener> arrayList = this.mOnLayoutCompletedListeners;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mOnLayoutCompletedListeners.get(size).onLayoutCompleted(state);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean onRequestChildFocus(RecyclerView recyclerView, RecyclerView.State state, View view, View view2) {
        if ((this.mFlag & 32768) == 0 && getAdapterPositionByView(view) != -1 && (this.mFlag & 35) == 0) {
            scrollToView(view, view2, true);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mFocusPosition = savedState.mIndex;
            this.mFocusPositionOffset = 0;
            this.mChildrenStates.loadFromBundle(savedState.mChildStates);
            this.mFlag |= 256;
            requestLayout();
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000b  */
    void onRtlPropertiesChanged(int i10) {
        int i11;
        if (this.mOrientation == 0) {
            if (i10 == 1) {
                i11 = 262144;
            } else {
                i11 = 0;
            }
        } else if (i10 == 1) {
            i11 = 524288;
        } else {
            i11 = 0;
        }
        int i12 = this.mFlag;
        if ((PF_REVERSE_FLOW_MASK & i12) == i11) {
            return;
        }
        this.mFlag = i11 | (i12 & (-786433)) | 256;
        this.mWindowAlignment.horizontal.setReversedFlow(i10 == 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.mIndex = getSelection();
        Bundle bundleSaveAsBundle = this.mChildrenStates.saveAsBundle();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int adapterPositionByView = getAdapterPositionByView(childAt);
            if (adapterPositionByView != -1) {
                bundleSaveAsBundle = this.mChildrenStates.saveOnScreenView(bundleSaveAsBundle, childAt, adapterPositionByView);
            }
        }
        savedState.mChildStates = bundleSaveAsBundle;
        return savedState;
    }

    void processPendingMovement(boolean z10) {
        int i10;
        if (z10) {
            if (hasCreatedLastItem()) {
                return;
            }
        } else if (hasCreatedFirstItem()) {
            return;
        }
        PendingMoveSmoothScroller pendingMoveSmoothScroller = this.mPendingMoveSmoothScroller;
        if (pendingMoveSmoothScroller == null) {
            PendingMoveSmoothScroller pendingMoveSmoothScroller2 = new PendingMoveSmoothScroller(z10 ? 1 : -1, this.mNumRows > 1);
            this.mFocusPositionOffset = 0;
            startSmoothScroll(pendingMoveSmoothScroller2);
        } else if (z10) {
            pendingMoveSmoothScroller.increasePendingMoves();
        } else {
            pendingMoveSmoothScroller.decreasePendingMoves();
        }
        if (this.mOrientation == 0) {
            i10 = 4;
            if (getLayoutDirection() != 1 ? !z10 : z10) {
                i10 = 3;
            }
        } else {
            i10 = z10 ? 2 : 1;
        }
        getAudioManager().playSoundEffect(i10);
    }

    int processSelectionMoves(boolean z10, int i10) {
        Grid grid = this.mGrid;
        if (grid == null) {
            return i10;
        }
        int i11 = this.mFocusPosition;
        int rowIndex = i11 != -1 ? grid.getRowIndex(i11) : -1;
        int childCount = getChildCount();
        View view = null;
        for (int i12 = 0; i12 < childCount && i10 != 0; i12++) {
            int i13 = i10 > 0 ? i12 : (childCount - 1) - i12;
            View childAt = getChildAt(i13);
            if (canScrollTo(childAt)) {
                int adapterPositionByIndex = getAdapterPositionByIndex(i13);
                int rowIndex2 = this.mGrid.getRowIndex(adapterPositionByIndex);
                if (rowIndex == -1) {
                    i11 = adapterPositionByIndex;
                    view = childAt;
                    rowIndex = rowIndex2;
                } else if (rowIndex2 == rowIndex && ((i10 > 0 && adapterPositionByIndex > i11) || (i10 < 0 && adapterPositionByIndex < i11))) {
                    i10 = i10 > 0 ? i10 - 1 : i10 + 1;
                    i11 = adapterPositionByIndex;
                    view = childAt;
                }
            }
        }
        if (view != null) {
            if (z10) {
                if (hasFocus()) {
                    this.mFlag |= 32;
                    view.requestFocus();
                    this.mFlag &= -33;
                }
                this.mFocusPosition = i11;
                this.mSubFocusPosition = 0;
                return i10;
            }
            scrollToView(view, true);
        }
        return i10;
    }

    void removeOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList != null) {
            arrayList.remove(onChildViewHolderSelectedListener);
        }
    }

    void removeOnLayoutCompletedListener(BaseGridView.OnLayoutCompletedListener onLayoutCompletedListener) {
        ArrayList<BaseGridView.OnLayoutCompletedListener> arrayList = this.mOnLayoutCompletedListeners;
        if (arrayList != null) {
            arrayList.remove(onLayoutCompletedListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if ((this.mFlag & 512) == 0 || !hasDoneFirstLayout()) {
            return 0;
        }
        saveContext(recycler, state);
        this.mFlag = (this.mFlag & (-4)) | 2;
        int iScrollDirectionPrimary = this.mOrientation == 0 ? scrollDirectionPrimary(i10) : scrollDirectionSecondary(i10);
        leaveContext();
        this.mFlag &= -4;
        return iScrollDirectionPrimary;
    }

    void scrollToSelection(int i10, int i11, boolean z10, int i12) {
        this.mPrimaryScrollExtra = i12;
        View viewFindViewByPosition = findViewByPosition(i10);
        boolean zIsSmoothScrolling = isSmoothScrolling();
        if (!zIsSmoothScrolling && !this.mBaseGridView.isLayoutRequested() && viewFindViewByPosition != null && getAdapterPositionByView(viewFindViewByPosition) == i10) {
            this.mFlag |= 32;
            scrollToView(viewFindViewByPosition, z10);
            this.mFlag &= -33;
            return;
        }
        int i13 = this.mFlag;
        if ((i13 & 512) == 0 || (i13 & 64) != 0) {
            this.mFocusPosition = i10;
            this.mSubFocusPosition = i11;
            this.mFocusPositionOffset = Integer.MIN_VALUE;
            return;
        }
        if (z10 && !this.mBaseGridView.isLayoutRequested()) {
            this.mFocusPosition = i10;
            this.mSubFocusPosition = i11;
            this.mFocusPositionOffset = Integer.MIN_VALUE;
            if (!hasDoneFirstLayout()) {
                Log.w(getTag(), "setSelectionSmooth should not be called before first layout pass");
                return;
            }
            int iStartPositionSmoothScroller = startPositionSmoothScroller(i10);
            if (iStartPositionSmoothScroller != this.mFocusPosition) {
                this.mFocusPosition = iStartPositionSmoothScroller;
                this.mSubFocusPosition = 0;
                return;
            }
            return;
        }
        if (zIsSmoothScrolling) {
            skipSmoothScrollerOnStopInternal();
            this.mBaseGridView.stopScroll();
        }
        if (!this.mBaseGridView.isLayoutRequested() && viewFindViewByPosition != null && getAdapterPositionByView(viewFindViewByPosition) == i10) {
            this.mFlag |= 32;
            scrollToView(viewFindViewByPosition, z10);
            this.mFlag &= -33;
        } else {
            this.mFocusPosition = i10;
            this.mSubFocusPosition = i11;
            this.mFocusPositionOffset = Integer.MIN_VALUE;
            this.mFlag |= 256;
            requestLayout();
        }
    }

    void scrollToView(View view, boolean z10, int i10, int i11) {
        scrollToView(view, view == null ? null : view.findFocus(), z10, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if ((this.mFlag & 512) == 0 || !hasDoneFirstLayout()) {
            return 0;
        }
        this.mFlag = (this.mFlag & (-4)) | 2;
        saveContext(recycler, state);
        int iScrollDirectionPrimary = this.mOrientation == 1 ? scrollDirectionPrimary(i10) : scrollDirectionSecondary(i10);
        leaveContext();
        this.mFlag &= -4;
        return iScrollDirectionPrimary;
    }

    void setChildrenVisibility(int i10) {
        this.mChildVisibility = i10;
        if (i10 != -1) {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                getChildAt(i11).setVisibility(this.mChildVisibility);
            }
        }
    }

    void setExtraLayoutSpace(int i10) {
        int i11 = this.mExtraLayoutSpace;
        if (i11 == i10) {
            return;
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("ExtraLayoutSpace must >= 0");
        }
        this.mExtraLayoutSpace = i10;
        requestLayout();
    }

    public void setFocusOutAllowed(boolean z10, boolean z11) {
        this.mFlag = (z10 ? 2048 : 0) | (this.mFlag & (-6145)) | (z11 ? 4096 : 0);
    }

    void setFocusOutSideAllowed(boolean z10, boolean z11) {
        this.mFlag = (z10 ? 8192 : 0) | (this.mFlag & (-24577)) | (z11 ? 16384 : 0);
    }

    void setFocusScrollStrategy(int i10) {
        this.mFocusScrollStrategy = i10;
    }

    void setFocusSearchDisabled(boolean z10) {
        this.mFlag = (z10 ? 32768 : 0) | (this.mFlag & (-32769));
    }

    void setGravity(int i10) {
        this.mGravity = i10;
    }

    void setGridView(BaseGridView baseGridView) {
        this.mBaseGridView = baseGridView;
        this.mGrid = null;
    }

    void setHorizontalSpacing(int i10) {
        if (this.mOrientation == 0) {
            this.mHorizontalSpacing = i10;
            this.mSpacingPrimary = i10;
        } else {
            this.mHorizontalSpacing = i10;
            this.mSpacingSecondary = i10;
        }
    }

    void setItemAlignmentOffset(int i10) {
        this.mItemAlignment.mainAxis().setItemAlignmentOffset(i10);
        updateChildAlignments();
    }

    void setItemAlignmentOffsetPercent(float f10) {
        this.mItemAlignment.mainAxis().setItemAlignmentOffsetPercent(f10);
        updateChildAlignments();
    }

    void setItemAlignmentOffsetWithPadding(boolean z10) {
        this.mItemAlignment.mainAxis().setItemAlignmentOffsetWithPadding(z10);
        updateChildAlignments();
    }

    void setItemAlignmentViewId(int i10) {
        this.mItemAlignment.mainAxis().setItemAlignmentViewId(i10);
        updateChildAlignments();
    }

    void setItemSpacing(int i10) {
        this.mHorizontalSpacing = i10;
        this.mVerticalSpacing = i10;
        this.mSpacingSecondary = i10;
        this.mSpacingPrimary = i10;
    }

    void setLayoutEnabled(boolean z10) {
        int i10 = this.mFlag;
        if (((i10 & 512) != 0) != z10) {
            this.mFlag = (i10 & (-513)) | (z10 ? 512 : 0);
            requestLayout();
        }
    }

    void setNumRows(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        this.mNumRowsRequested = i10;
    }

    void setOnChildLaidOutListener(OnChildLaidOutListener onChildLaidOutListener) {
        this.mChildLaidOutListener = onChildLaidOutListener;
    }

    void setOnChildSelectedListener(OnChildSelectedListener onChildSelectedListener) {
        this.mChildSelectedListener = onChildSelectedListener;
    }

    void setOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        if (onChildViewHolderSelectedListener == null) {
            this.mChildViewHolderSelectedListeners = null;
            return;
        }
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList == null) {
            this.mChildViewHolderSelectedListeners = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        this.mChildViewHolderSelectedListeners.add(onChildViewHolderSelectedListener);
    }

    public void setOrientation(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.mOrientation = i10;
            this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, i10);
            this.mWindowAlignment.setOrientation(i10);
            this.mItemAlignment.setOrientation(i10);
            this.mFlag |= 256;
        }
    }

    void setPruneChild(boolean z10) {
        int i10 = this.mFlag;
        if (((i10 & 65536) != 0) != z10) {
            this.mFlag = (i10 & (-65537)) | (z10 ? 65536 : 0);
            if (z10) {
                requestLayout();
            }
        }
    }

    void setRowHeight(int i10) {
        if (i10 >= 0 || i10 == -2) {
            this.mRowSizeSecondaryRequested = i10;
            return;
        }
        throw new IllegalArgumentException("Invalid row height: " + i10);
    }

    void setScrollEnabled(boolean z10) {
        int i10;
        int i11 = this.mFlag;
        if (((i11 & 131072) != 0) != z10) {
            int i12 = (i11 & (-131073)) | (z10 ? 131072 : 0);
            this.mFlag = i12;
            if ((i12 & 131072) == 0 || this.mFocusScrollStrategy != 0 || (i10 = this.mFocusPosition) == -1) {
                return;
            }
            scrollToSelection(i10, this.mSubFocusPosition, true, this.mPrimaryScrollExtra);
        }
    }

    void setSelection(int i10, int i11, boolean z10, int i12) {
        if ((this.mFocusPosition == i10 || i10 == -1) && i11 == this.mSubFocusPosition && i12 == this.mPrimaryScrollExtra) {
            return;
        }
        scrollToSelection(i10, i11, z10, i12);
    }

    void setVerticalSpacing(int i10) {
        if (this.mOrientation == 1) {
            this.mVerticalSpacing = i10;
            this.mSpacingPrimary = i10;
        } else {
            this.mVerticalSpacing = i10;
            this.mSpacingSecondary = i10;
        }
    }

    void setWindowAlignment(int i10) {
        this.mWindowAlignment.mainAxis().setWindowAlignment(i10);
    }

    void setWindowAlignmentOffset(int i10) {
        this.mWindowAlignment.mainAxis().setWindowAlignmentOffset(i10);
    }

    void setWindowAlignmentOffsetPercent(float f10) {
        this.mWindowAlignment.mainAxis().setWindowAlignmentOffsetPercent(f10);
    }

    void skipSmoothScrollerOnStopInternal() {
        GridLinearSmoothScroller gridLinearSmoothScroller = this.mCurrentSmoothScroller;
        if (gridLinearSmoothScroller != null) {
            gridLinearSmoothScroller.mSkipOnStopInternal = true;
        }
    }

    void slideIn() {
        int i10 = this.mFlag;
        if ((i10 & 64) != 0) {
            this.mFlag = i10 & (-65);
            int i11 = this.mFocusPosition;
            if (i11 >= 0) {
                scrollToSelection(i11, this.mSubFocusPosition, true, this.mPrimaryScrollExtra);
            } else {
                this.mFlag = i10 & (-193);
                requestLayout();
            }
            int i12 = this.mFlag;
            if ((i12 & 128) != 0) {
                this.mFlag = i12 & (-129);
                if (this.mBaseGridView.getScrollState() != 0 || isSmoothScrolling()) {
                    this.mBaseGridView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: androidx.leanback.widget.GridLayoutManager.3
                        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                        public void onScrollStateChanged(RecyclerView recyclerView, int i13) {
                            if (i13 == 0) {
                                GridLayoutManager.this.mBaseGridView.removeOnScrollListener(this);
                                GridLayoutManager.this.requestLayout();
                            }
                        }
                    });
                } else {
                    requestLayout();
                }
            }
        }
    }

    void slideOut() {
        int i10 = this.mFlag;
        if ((i10 & 64) != 0) {
            return;
        }
        this.mFlag = i10 | 64;
        if (getChildCount() == 0) {
            return;
        }
        if (this.mOrientation == 1) {
            this.mBaseGridView.smoothScrollBy(0, getSlideOutDistance(), new AccelerateDecelerateInterpolator());
        } else {
            this.mBaseGridView.smoothScrollBy(getSlideOutDistance(), 0, new AccelerateDecelerateInterpolator());
        }
    }

    int startPositionSmoothScroller(int i10) {
        GridLinearSmoothScroller gridLinearSmoothScroller = new GridLinearSmoothScroller() { // from class: androidx.leanback.widget.GridLayoutManager.4
            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i11) {
                int i12;
                if (getChildCount() == 0) {
                    return null;
                }
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                int position = gridLayoutManager.getPosition(gridLayoutManager.getChildAt(0));
                GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                if ((gridLayoutManager2.mFlag & 262144) == 0 ? i11 < position : i11 > position) {
                    i12 = -1;
                } else {
                    i12 = 1;
                }
                if (gridLayoutManager2.mOrientation == 0) {
                    return new PointF(i12, 0.0f);
                }
                return new PointF(0.0f, i12);
            }
        };
        gridLinearSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(gridLinearSmoothScroller);
        return gridLinearSmoothScroller.getTargetPosition();
    }

    void updatePositionToRowMapInPostLayout() {
        Grid.Location location;
        this.mPositionToRowInPostLayout.clear();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            int oldPosition = this.mBaseGridView.getChildViewHolder(getChildAt(i10)).getOldPosition();
            if (oldPosition >= 0 && (location = this.mGrid.getLocation(oldPosition)) != null) {
                this.mPositionToRowInPostLayout.put(oldPosition, location.mRow);
            }
        }
    }

    void updateScrollLimits() {
        int firstVisibleIndex;
        int lastVisibleIndex;
        int itemCount;
        int itemCount2;
        int iFindRowMax;
        int viewCenter;
        int iFindRowMin;
        int viewCenter2;
        if (this.mState.getItemCount() == 0) {
            return;
        }
        if ((this.mFlag & 262144) == 0) {
            firstVisibleIndex = this.mGrid.getLastVisibleIndex();
            itemCount2 = this.mState.getItemCount() - 1;
            lastVisibleIndex = this.mGrid.getFirstVisibleIndex();
            itemCount = 0;
        } else {
            firstVisibleIndex = this.mGrid.getFirstVisibleIndex();
            lastVisibleIndex = this.mGrid.getLastVisibleIndex();
            itemCount = this.mState.getItemCount() - 1;
            itemCount2 = 0;
        }
        if (firstVisibleIndex < 0 || lastVisibleIndex < 0) {
            return;
        }
        boolean z10 = firstVisibleIndex == itemCount2;
        boolean z11 = lastVisibleIndex == itemCount;
        if (z10 || !this.mWindowAlignment.mainAxis().isMaxUnknown() || z11 || !this.mWindowAlignment.mainAxis().isMinUnknown()) {
            if (z10) {
                iFindRowMax = this.mGrid.findRowMax(true, sTwoInts);
                View viewFindViewByPosition = findViewByPosition(sTwoInts[1]);
                viewCenter = getViewCenter(viewFindViewByPosition);
                int[] alignMultiple = ((LayoutParams) viewFindViewByPosition.getLayoutParams()).getAlignMultiple();
                if (alignMultiple != null && alignMultiple.length > 0) {
                    viewCenter += alignMultiple[alignMultiple.length - 1] - alignMultiple[0];
                }
            } else {
                iFindRowMax = Integer.MAX_VALUE;
                viewCenter = Integer.MAX_VALUE;
            }
            if (z11) {
                iFindRowMin = this.mGrid.findRowMin(false, sTwoInts);
                viewCenter2 = getViewCenter(findViewByPosition(sTwoInts[1]));
            } else {
                iFindRowMin = Integer.MIN_VALUE;
                viewCenter2 = Integer.MIN_VALUE;
            }
            this.mWindowAlignment.mainAxis().updateMinMax(iFindRowMin, iFindRowMax, viewCenter2, viewCenter);
        }
    }

    private void fastRelayout() {
        GridLayoutManager gridLayoutManager;
        Grid.Location location;
        int decoratedMeasuredHeightWithMargin;
        int childCount = getChildCount();
        int firstVisibleIndex = this.mGrid.getFirstVisibleIndex();
        this.mFlag &= -9;
        int i10 = 0;
        while (true) {
            if (i10 < childCount) {
                View childAt = getChildAt(i10);
                if (firstVisibleIndex != getAdapterPositionByView(childAt) || (location = this.mGrid.getLocation(firstVisibleIndex)) == null) {
                    gridLayoutManager = this;
                    break;
                }
                int rowStartSecondary = (getRowStartSecondary(location.mRow) + this.mWindowAlignment.secondAxis().getPaddingMin()) - this.mScrollOffsetSecondary;
                int viewMin = getViewMin(childAt);
                int viewPrimarySize = getViewPrimarySize(childAt);
                if (((LayoutParams) childAt.getLayoutParams()).viewNeedsUpdate()) {
                    this.mFlag |= 8;
                    detachAndScrapView(childAt, this.mRecycler);
                    childAt = getViewForPosition(firstVisibleIndex);
                    addView(childAt, i10);
                }
                View view = childAt;
                measureChild(view);
                if (this.mOrientation == 0) {
                    decoratedMeasuredHeightWithMargin = getDecoratedMeasuredWidthWithMargin(view);
                } else {
                    decoratedMeasuredHeightWithMargin = getDecoratedMeasuredHeightWithMargin(view);
                }
                gridLayoutManager = this;
                gridLayoutManager.layoutChild(location.mRow, view, viewMin, viewMin + decoratedMeasuredHeightWithMargin, rowStartSecondary);
                if (viewPrimarySize != decoratedMeasuredHeightWithMargin) {
                    break;
                }
                i10++;
                firstVisibleIndex++;
            }
            updateScrollLimits();
            updateSecondaryScrollLimits();
        }
        int lastVisibleIndex = gridLayoutManager.mGrid.getLastVisibleIndex();
        for (int i11 = childCount - 1; i11 >= i10; i11--) {
            detachAndScrapView(getChildAt(i11), gridLayoutManager.mRecycler);
        }
        gridLayoutManager.mGrid.invalidateItemsAfter(firstVisibleIndex);
        if ((gridLayoutManager.mFlag & 65536) != 0) {
            appendVisibleItems();
            int i12 = gridLayoutManager.mFocusPosition;
            if (i12 >= 0 && i12 <= lastVisibleIndex) {
                while (gridLayoutManager.mGrid.getLastVisibleIndex() < gridLayoutManager.mFocusPosition) {
                    gridLayoutManager.mGrid.appendOneColumnVisibleItems();
                }
            }
        } else {
            while (gridLayoutManager.mGrid.appendOneColumnVisibleItems() && gridLayoutManager.mGrid.getLastVisibleIndex() < lastVisibleIndex) {
            }
        }
        updateScrollLimits();
        updateSecondaryScrollLimits();
    }

    private int getAdapterPositionByIndex(int i10) {
        return getAdapterPositionByView(getChildAt(i10));
    }

    private int getAdjustedPrimaryAlignedScrollDistance(int i10, View view, View view2) {
        int subPositionByView = getSubPositionByView(view, view2);
        if (subPositionByView != 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return i10 + (layoutParams.getAlignMultiple()[subPositionByView] - layoutParams.getAlignMultiple()[0]);
        }
        return i10;
    }

    private boolean getAlignedPosition(View view, View view2, int[] iArr) {
        int primaryAlignedScrollDistance = getPrimaryAlignedScrollDistance(view);
        if (view2 != null) {
            primaryAlignedScrollDistance = getAdjustedPrimaryAlignedScrollDistance(primaryAlignedScrollDistance, view, view2);
        }
        int secondaryScrollDistance = getSecondaryScrollDistance(view);
        int i10 = primaryAlignedScrollDistance + this.mPrimaryScrollExtra;
        if (i10 == 0 && secondaryScrollDistance == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
        iArr[0] = i10;
        iArr[1] = secondaryScrollDistance;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00bc  */
    private boolean getNoneAlignedPosition(View view, int[] iArr) {
        View viewFindViewByPosition;
        int i10;
        int viewMax;
        int secondaryScrollDistance;
        int adapterPositionByView = getAdapterPositionByView(view);
        int viewMin = getViewMin(view);
        int viewMax2 = getViewMax(view);
        int paddingMin = this.mWindowAlignment.mainAxis().getPaddingMin();
        int clientSize = this.mWindowAlignment.mainAxis().getClientSize();
        int rowIndex = this.mGrid.getRowIndex(adapterPositionByView);
        View viewFindViewByPosition2 = null;
        if (viewMin < paddingMin) {
            if (this.mFocusScrollStrategy == 2) {
                View view2 = view;
                while (true) {
                    if (prependOneColumnVisibleItems()) {
                        Grid grid = this.mGrid;
                        CircularIntArray circularIntArray = grid.getItemPositionsInRows(grid.getFirstVisibleIndex(), adapterPositionByView)[rowIndex];
                        View viewFindViewByPosition3 = findViewByPosition(circularIntArray.get(0));
                        if (viewMax2 - getViewMin(viewFindViewByPosition3) > clientSize) {
                            if (circularIntArray.size() > 2) {
                                viewFindViewByPosition = null;
                                viewFindViewByPosition2 = findViewByPosition(circularIntArray.get(2));
                                break;
                            }
                            viewFindViewByPosition = null;
                            viewFindViewByPosition2 = viewFindViewByPosition3;
                            break;
                        }
                        view2 = viewFindViewByPosition3;
                    } else {
                        viewFindViewByPosition = null;
                        viewFindViewByPosition2 = view2;
                        break;
                    }
                }
            } else {
                viewFindViewByPosition = null;
                viewFindViewByPosition2 = view;
            }
        } else if (viewMax2 > clientSize + paddingMin) {
            if (this.mFocusScrollStrategy == 2) {
                do {
                    Grid grid2 = this.mGrid;
                    CircularIntArray circularIntArray2 = grid2.getItemPositionsInRows(adapterPositionByView, grid2.getLastVisibleIndex())[rowIndex];
                    viewFindViewByPosition = findViewByPosition(circularIntArray2.get(circularIntArray2.size() - 1));
                    if (getViewMax(viewFindViewByPosition) - viewMin > clientSize) {
                        viewFindViewByPosition = null;
                        break;
                    }
                } while (appendOneColumnVisibleItems());
                if (viewFindViewByPosition == null) {
                    viewFindViewByPosition2 = view;
                }
            } else {
                viewFindViewByPosition = view;
            }
        } else {
            viewFindViewByPosition = null;
        }
        if (viewFindViewByPosition2 != null) {
            viewMax = getViewMin(viewFindViewByPosition2);
        } else {
            if (viewFindViewByPosition != null) {
                viewMax = getViewMax(viewFindViewByPosition);
                paddingMin += clientSize;
            } else {
                i10 = 0;
            }
            if (viewFindViewByPosition2 != null) {
                view = viewFindViewByPosition2;
            } else if (viewFindViewByPosition != null) {
                view = viewFindViewByPosition;
            }
            secondaryScrollDistance = getSecondaryScrollDistance(view);
            if (i10 != 0 && secondaryScrollDistance == 0) {
                return false;
            }
            iArr[0] = i10;
            iArr[1] = secondaryScrollDistance;
            return true;
        }
        i10 = viewMax - paddingMin;
        if (viewFindViewByPosition2 != null) {
            view = viewFindViewByPosition2;
        } else if (viewFindViewByPosition != null) {
            view = viewFindViewByPosition;
        }
        secondaryScrollDistance = getSecondaryScrollDistance(view);
        if (i10 != 0) {
        }
        iArr[0] = i10;
        iArr[1] = secondaryScrollDistance;
        return true;
    }

    private int getSecondaryScrollDistance(View view) {
        return this.mWindowAlignment.secondAxis().getScroll(getViewCenterSecondary(view));
    }

    private int getViewCenterX(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.getOpticalLeft(view) + layoutParams.getAlignX();
    }

    private int getViewCenterY(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.getOpticalTop(view) + layoutParams.getAlignY();
    }

    private boolean gridOnRequestFocusInDescendantsUnaligned(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        int childCount = getChildCount();
        if ((i10 & 2) != 0) {
            i12 = childCount;
            i11 = 0;
            i13 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
            i13 = -1;
        }
        int paddingMin = this.mWindowAlignment.mainAxis().getPaddingMin();
        int clientSize = this.mWindowAlignment.mainAxis().getClientSize() + paddingMin;
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && getViewMin(childAt) >= paddingMin && getViewMax(childAt) <= clientSize && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i11 += i13;
        }
        return false;
    }

    private void offsetChildrenPrimary(int i10) {
        int childCount = getChildCount();
        int i11 = 0;
        if (this.mOrientation == 1) {
            while (i11 < childCount) {
                getChildAt(i11).offsetTopAndBottom(i10);
                i11++;
            }
        } else {
            while (i11 < childCount) {
                getChildAt(i11).offsetLeftAndRight(i10);
                i11++;
            }
        }
    }

    private void offsetChildrenSecondary(int i10) {
        int childCount = getChildCount();
        int i11 = 0;
        if (this.mOrientation == 0) {
            while (i11 < childCount) {
                getChildAt(i11).offsetTopAndBottom(i10);
                i11++;
            }
        } else {
            while (i11 < childCount) {
                getChildAt(i11).offsetLeftAndRight(i10);
                i11++;
            }
        }
    }

    private void scrollToView(View view, View view2, boolean z10) {
        scrollToView(view, view2, z10, 0, 0);
    }

    boolean canScrollTo(View view) {
        if (view.getVisibility() == 0) {
            if (!hasFocus() || view.hasFocusable()) {
                return true;
            }
            return false;
        }
        return false;
    }

    void dispatchChildSelectedAndPositioned() {
        View viewFindViewByPosition;
        if (!hasOnChildViewHolderSelectedListener()) {
            return;
        }
        int i10 = this.mFocusPosition;
        if (i10 == -1) {
            viewFindViewByPosition = null;
        } else {
            viewFindViewByPosition = findViewByPosition(i10);
        }
        if (viewFindViewByPosition != null) {
            fireOnChildViewHolderSelectedAndPositioned(this.mBaseGridView, this.mBaseGridView.getChildViewHolder(viewFindViewByPosition), this.mFocusPosition, this.mSubFocusPosition);
        } else {
            OnChildSelectedListener onChildSelectedListener = this.mChildSelectedListener;
            if (onChildSelectedListener != null) {
                onChildSelectedListener.onChildSelected(this.mBaseGridView, null, -1, -1L);
            }
            fireOnChildViewHolderSelectedAndPositioned(this.mBaseGridView, null, -1, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedBottom(View view) {
        return super.getDecoratedBottom(view) - ((LayoutParams) view.getLayoutParams()).mBottomInset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        rect.left += layoutParams.mLeftInset;
        rect.top += layoutParams.mTopInset;
        rect.right -= layoutParams.mRightInset;
        rect.bottom -= layoutParams.mBottomInset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedLeft(View view) {
        return super.getDecoratedLeft(view) + ((LayoutParams) view.getLayoutParams()).mLeftInset;
    }

    int getDecoratedMeasuredHeightWithMargin(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    int getDecoratedMeasuredWidthWithMargin(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedRight(View view) {
        return super.getDecoratedRight(view) - ((LayoutParams) view.getLayoutParams()).mRightInset;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedTop(View view) {
        return super.getDecoratedTop(view) + ((LayoutParams) view.getLayoutParams()).mTopInset;
    }

    int getOpticalBottom(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalBottom(view);
    }

    int getOpticalLeft(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalLeft(view);
    }

    int getOpticalRight(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalRight(view);
    }

    int getOpticalTop(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalTop(view);
    }

    boolean hasCreatedFirstItem() {
        if (getItemCount() != 0 && this.mBaseGridView.findViewHolderForAdapterPosition(0) == null) {
            return false;
        }
        return true;
    }

    boolean hasCreatedLastItem() {
        int itemCount = getItemCount();
        if (itemCount == 0 || this.mBaseGridView.findViewHolderForAdapterPosition(itemCount - 1) != null) {
            return true;
        }
        return false;
    }

    void measureChild(View view) {
        int iMakeMeasureSpec;
        int childMeasureSpec;
        int childMeasureSpec2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = sTempRect;
        calculateItemDecorationsForChild(view, rect);
        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.left + rect.right;
        int i11 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.top + rect.bottom;
        if (this.mRowSizeSecondaryRequested == -2) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mFixedRowSizeSecondary, BasicMeasure.EXACTLY);
        }
        if (this.mOrientation == 0) {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i10, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, i11, ((ViewGroup.MarginLayoutParams) layoutParams).height);
        } else {
            int childMeasureSpec3 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i11, ((ViewGroup.MarginLayoutParams) layoutParams).height);
            childMeasureSpec = ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, i10, ((ViewGroup.MarginLayoutParams) layoutParams).width);
            childMeasureSpec2 = childMeasureSpec3;
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    void onChildRecycled(RecyclerView.ViewHolder viewHolder) {
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition != -1) {
            this.mChildrenStates.saveOffscreenView(viewHolder.itemView, absoluteAdapterPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean z10;
        saveContext(recycler, state);
        int itemCount = state.getItemCount();
        int i10 = this.mFlag;
        if ((262144 & i10) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((i10 & 2048) == 0 || (itemCount > 1 && !isItemFullyVisible(0))) {
            addA11yActionMovingBackward(accessibilityNodeInfoCompat, z10);
        }
        if ((this.mFlag & 4096) == 0 || (itemCount > 1 && !isItemFullyVisible(itemCount - 1))) {
            addA11yActionMovingForward(accessibilityNodeInfoCompat, z10);
        }
        accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
        leaveContext();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int rowIndex;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.mGrid != null && (layoutParams instanceof LayoutParams)) {
            int absoluteAdapterPosition = ((LayoutParams) layoutParams).getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition >= 0) {
                rowIndex = this.mGrid.getRowIndex(absoluteAdapterPosition);
            } else {
                rowIndex = -1;
            }
            if (rowIndex >= 0) {
                int numRows = absoluteAdapterPosition / this.mGrid.getNumRows();
                if (this.mOrientation == 0) {
                    accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(rowIndex, 1, numRows, 1, false, false));
                } else {
                    accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(numRows, 1, rowIndex, 1, false, false));
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ec  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i10, int i11) {
        int size;
        int size2;
        int mode;
        int paddingLeft;
        int paddingRight;
        int i12;
        int i13;
        saveContext(recycler, state);
        if (this.mOrientation == 0) {
            size2 = View.MeasureSpec.getSize(i10);
            size = View.MeasureSpec.getSize(i11);
            mode = View.MeasureSpec.getMode(i11);
            paddingLeft = getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            size = View.MeasureSpec.getSize(i10);
            size2 = View.MeasureSpec.getSize(i11);
            mode = View.MeasureSpec.getMode(i10);
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        int i14 = paddingLeft + paddingRight;
        this.mMaxSizeSecondary = size;
        int i15 = this.mRowSizeSecondaryRequested;
        if (i15 == -2) {
            int i16 = this.mNumRowsRequested;
            if (i16 == 0) {
                i16 = 1;
            }
            this.mNumRows = i16;
            this.mFixedRowSizeSecondary = 0;
            int[] iArr = this.mRowSizeSecondary;
            if (iArr == null || iArr.length != i16) {
                this.mRowSizeSecondary = new int[i16];
            }
            if (this.mState.isPreLayout()) {
                updatePositionDeltaInPreLayout();
            }
            processRowSizeSecondary(true);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    if (mode == 1073741824) {
                        size = this.mMaxSizeSecondary;
                    } else {
                        throw new IllegalStateException("wrong spec");
                    }
                } else {
                    size = getSizeSecondary() + i14;
                }
            } else {
                size = Math.min(getSizeSecondary() + i14, this.mMaxSizeSecondary);
            }
        } else if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    throw new IllegalStateException("wrong spec");
                }
                i12 = this.mNumRowsRequested;
                if (i12 != 0) {
                    if (i12 == 0) {
                        this.mFixedRowSizeSecondary = i15;
                        int i17 = this.mSpacingSecondary;
                        this.mNumRows = (size + i17) / (i15 + i17);
                    } else if (i15 == 0) {
                        this.mNumRows = i12;
                        this.mFixedRowSizeSecondary = ((size - i14) - (this.mSpacingSecondary * (i12 - 1))) / i12;
                    } else {
                        this.mNumRows = i12;
                        this.mFixedRowSizeSecondary = i15;
                    }
                } else if (i12 == 0) {
                    this.mFixedRowSizeSecondary = i15;
                    int i18 = this.mSpacingSecondary;
                    this.mNumRows = (size + i18) / (i15 + i18);
                } else if (i15 == 0) {
                    this.mNumRows = i12;
                    this.mFixedRowSizeSecondary = ((size - i14) - (this.mSpacingSecondary * (i12 - 1))) / i12;
                } else {
                    this.mNumRows = i12;
                    this.mFixedRowSizeSecondary = i15;
                }
                if (mode == Integer.MIN_VALUE) {
                    int i19 = this.mFixedRowSizeSecondary;
                    int i20 = this.mNumRows;
                    i13 = (i19 * i20) + (this.mSpacingSecondary * (i20 - 1)) + i14;
                    if (i13 < size) {
                        size = i13;
                    }
                }
            } else {
                if (i15 == 0) {
                    i15 = size - i14;
                }
                this.mFixedRowSizeSecondary = i15;
                int i21 = this.mNumRowsRequested;
                if (i21 == 0) {
                    i21 = 1;
                }
                this.mNumRows = i21;
                size = (i15 * i21) + (this.mSpacingSecondary * (i21 - 1)) + i14;
            }
        } else {
            i12 = this.mNumRowsRequested;
            if (i12 != 0 && i15 == 0) {
                this.mNumRows = 1;
                this.mFixedRowSizeSecondary = size - i14;
            } else if (i12 == 0) {
                this.mFixedRowSizeSecondary = i15;
                int i110 = this.mSpacingSecondary;
                this.mNumRows = (size + i110) / (i15 + i110);
            } else if (i15 == 0) {
                this.mNumRows = i12;
                this.mFixedRowSizeSecondary = ((size - i14) - (this.mSpacingSecondary * (i12 - 1))) / i12;
            } else {
                this.mNumRows = i12;
                this.mFixedRowSizeSecondary = i15;
            }
            if (mode == Integer.MIN_VALUE) {
                int i111 = this.mFixedRowSizeSecondary;
                int i22 = this.mNumRows;
                i13 = (i111 * i22) + (this.mSpacingSecondary * (i22 - 1)) + i14;
                if (i13 < size) {
                    size = i13;
                }
            }
        }
        if (this.mOrientation == 0) {
            setMeasuredDimension(size2, size);
        } else {
            setMeasuredDimension(size, size2);
        }
        leaveContext();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i10, Bundle bundle) {
        boolean z10;
        boolean z11;
        boolean z12;
        if (!isScrollEnabled()) {
            return true;
        }
        saveContext(recycler, state);
        if ((this.mFlag & 262144) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.mOrientation == 0) {
                if (i10 == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT.getId()) {
                    if (!z10) {
                        i10 = 8192;
                    } else {
                        i10 = 4096;
                    }
                } else if (i10 == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT.getId()) {
                    if (z10) {
                        i10 = 8192;
                    } else {
                        i10 = 4096;
                    }
                }
            } else if (i10 == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP.getId()) {
                i10 = 8192;
            } else if (i10 == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN.getId()) {
                i10 = 4096;
            }
        }
        int i11 = this.mFocusPosition;
        if (i11 == 0 && i10 == 8192) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (i11 == state.getItemCount() - 1 && i10 == 4096) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 && !z12) {
            if (i10 != 4096) {
                if (i10 == 8192) {
                    processPendingMovement(false);
                    processSelectionMoves(false, -1);
                }
            } else {
                processPendingMovement(true);
                processSelectionMoves(false, 1);
            }
        } else {
            sendTypeViewScrolledAccessibilityEvent();
        }
        leaveContext();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            removeAndRecycleViewAt(childCount, recycler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void startSmoothScroll(RecyclerView.SmoothScroller smoothScroller) {
        skipSmoothScrollerOnStopInternal();
        super.startSmoothScroll(smoothScroller);
        if (smoothScroller.isRunning() && (smoothScroller instanceof GridLinearSmoothScroller)) {
            GridLinearSmoothScroller gridLinearSmoothScroller = (GridLinearSmoothScroller) smoothScroller;
            this.mCurrentSmoothScroller = gridLinearSmoothScroller;
            if (gridLinearSmoothScroller instanceof PendingMoveSmoothScroller) {
                this.mPendingMoveSmoothScroller = (PendingMoveSmoothScroller) gridLinearSmoothScroller;
                return;
            } else {
                this.mPendingMoveSmoothScroller = null;
                return;
            }
        }
        this.mCurrentSmoothScroller = null;
        this.mPendingMoveSmoothScroller = null;
    }

    void updatePositionDeltaInPreLayout() {
        if (getChildCount() > 0) {
            this.mPositionDeltaInPreLayout = this.mGrid.getFirstVisibleIndex() - ((LayoutParams) getChildAt(0).getLayoutParams()).getViewLayoutPosition();
        } else {
            this.mPositionDeltaInPreLayout = 0;
        }
    }

    private void scrollToView(View view, View view2, boolean z10, int i10, int i11) {
        if ((this.mFlag & 64) != 0) {
            return;
        }
        int adapterPositionByView = getAdapterPositionByView(view);
        int subPositionByView = getSubPositionByView(view, view2);
        if (adapterPositionByView != this.mFocusPosition || subPositionByView != this.mSubFocusPosition) {
            this.mFocusPosition = adapterPositionByView;
            this.mSubFocusPosition = subPositionByView;
            this.mFocusPositionOffset = 0;
            if ((this.mFlag & 3) != 1) {
                dispatchChildSelected();
            }
            if (this.mBaseGridView.isChildrenDrawingOrderEnabledInternal()) {
                this.mBaseGridView.invalidate();
            }
        }
        if (view == null) {
            return;
        }
        if (!view.hasFocus() && this.mBaseGridView.hasFocus()) {
            view.requestFocus();
        }
        if ((this.mFlag & 131072) == 0 && z10) {
            return;
        }
        if (!getScrollPosition(view, view2, sTwoInts) && i10 == 0 && i11 == 0) {
            return;
        }
        int[] iArr = sTwoInts;
        scrollGrid(iArr[0] + i10, iArr[1] + i11, z10);
    }

    private void updateChildAlignments() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            updateChildAlignments(getChildAt(i10));
        }
    }
}
