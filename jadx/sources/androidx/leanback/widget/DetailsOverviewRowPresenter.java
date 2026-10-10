package androidx.leanback.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Deprecated
public class DetailsOverviewRowPresenter extends RowPresenter {
    static final boolean DEBUG = false;
    private static final long DEFAULT_TIMEOUT = 5000;
    static final String TAG = "DetailsOverviewRowP";
    OnActionClickedListener mActionClickedListener;
    private boolean mBackgroundColorSet;
    final Presenter mDetailsPresenter;
    private DetailsOverviewSharedElementHelper mSharedElementHelper;
    private int mBackgroundColor = 0;
    private boolean mIsStyleLarge = true;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class ActionsItemBridgeAdapter extends ItemBridgeAdapter {
        ViewHolder mViewHolder;

        ActionsItemBridgeAdapter(ViewHolder viewHolder) {
            this.mViewHolder = viewHolder;
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onAttachedToWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            viewHolder.itemView.removeOnLayoutChangeListener(this.mViewHolder.mLayoutChangeListener);
            viewHolder.itemView.addOnLayoutChangeListener(this.mViewHolder.mLayoutChangeListener);
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onBind(final ItemBridgeAdapter.ViewHolder viewHolder) {
            if (this.mViewHolder.getOnItemViewClickedListener() == null && DetailsOverviewRowPresenter.this.mActionClickedListener == null) {
                return;
            }
            viewHolder.getPresenter().setOnClickListener(viewHolder.getViewHolder(), new View.OnClickListener() { // from class: androidx.leanback.widget.DetailsOverviewRowPresenter.ActionsItemBridgeAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ActionsItemBridgeAdapter.this.mViewHolder.getOnItemViewClickedListener() != null) {
                        BaseOnItemViewClickedListener onItemViewClickedListener = ActionsItemBridgeAdapter.this.mViewHolder.getOnItemViewClickedListener();
                        Presenter.ViewHolder viewHolder2 = viewHolder.getViewHolder();
                        Object item = viewHolder.getItem();
                        ViewHolder viewHolder3 = ActionsItemBridgeAdapter.this.mViewHolder;
                        onItemViewClickedListener.onItemClicked(viewHolder2, item, viewHolder3, viewHolder3.getRow());
                    }
                    OnActionClickedListener onActionClickedListener = DetailsOverviewRowPresenter.this.mActionClickedListener;
                    if (onActionClickedListener != null) {
                        onActionClickedListener.onActionClicked((Action) viewHolder.getItem());
                    }
                }
            });
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onDetachedFromWindow(ItemBridgeAdapter.ViewHolder viewHolder) {
            viewHolder.itemView.removeOnLayoutChangeListener(this.mViewHolder.mLayoutChangeListener);
            this.mViewHolder.checkFirstAndLastPosition(false);
        }

        @Override // androidx.leanback.widget.ItemBridgeAdapter
        public void onUnbind(ItemBridgeAdapter.ViewHolder viewHolder) {
            if (this.mViewHolder.getOnItemViewClickedListener() == null && DetailsOverviewRowPresenter.this.mActionClickedListener == null) {
                return;
            }
            viewHolder.getPresenter().setOnClickListener(viewHolder.getViewHolder(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public final class ViewHolder extends RowPresenter.ViewHolder {
        ItemBridgeAdapter mActionBridgeAdapter;
        final HorizontalGridView mActionsRow;
        final OnChildSelectedListener mChildSelectedListener;
        final FrameLayout mDetailsDescriptionFrame;
        public final Presenter.ViewHolder mDetailsDescriptionViewHolder;
        final Handler mHandler;
        final ImageView mImageView;
        final View.OnLayoutChangeListener mLayoutChangeListener;
        final DetailsOverviewRow.Listener mListener;
        int mNumItems;
        final FrameLayout mOverviewFrame;
        final ViewGroup mOverviewView;
        final ViewGroup mRightPanel;
        final RecyclerView.OnScrollListener mScrollListener;
        boolean mShowMoreLeft;
        boolean mShowMoreRight;
        final Runnable mUpdateDrawableCallback;

        public ViewHolder(View view, Presenter presenter) {
            super(view);
            this.mHandler = new Handler();
            this.mUpdateDrawableCallback = new Runnable() { // from class: androidx.leanback.widget.DetailsOverviewRowPresenter.ViewHolder.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewHolder viewHolder = ViewHolder.this;
                    DetailsOverviewRowPresenter.this.bindImageDrawable(viewHolder);
                }
            };
            this.mListener = new DetailsOverviewRow.Listener() { // from class: androidx.leanback.widget.DetailsOverviewRowPresenter.ViewHolder.2
                @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
                public void onActionsAdapterChanged(DetailsOverviewRow detailsOverviewRow) {
                    ViewHolder.this.bindActions(detailsOverviewRow.getActionsAdapter());
                }

                @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
                public void onImageDrawableChanged(DetailsOverviewRow detailsOverviewRow) {
                    ViewHolder viewHolder = ViewHolder.this;
                    viewHolder.mHandler.removeCallbacks(viewHolder.mUpdateDrawableCallback);
                    ViewHolder viewHolder2 = ViewHolder.this;
                    viewHolder2.mHandler.post(viewHolder2.mUpdateDrawableCallback);
                }

                @Override // androidx.leanback.widget.DetailsOverviewRow.Listener
                public void onItemChanged(DetailsOverviewRow detailsOverviewRow) {
                    ViewHolder viewHolder = ViewHolder.this;
                    Presenter.ViewHolder viewHolder2 = viewHolder.mDetailsDescriptionViewHolder;
                    if (viewHolder2 != null) {
                        DetailsOverviewRowPresenter.this.mDetailsPresenter.onUnbindViewHolder(viewHolder2);
                    }
                    ViewHolder viewHolder3 = ViewHolder.this;
                    DetailsOverviewRowPresenter.this.mDetailsPresenter.onBindViewHolder(viewHolder3.mDetailsDescriptionViewHolder, detailsOverviewRow.getItem());
                }
            };
            this.mLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.leanback.widget.DetailsOverviewRowPresenter.ViewHolder.3
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                    ViewHolder.this.checkFirstAndLastPosition(false);
                }
            };
            OnChildSelectedListener onChildSelectedListener = new OnChildSelectedListener() { // from class: androidx.leanback.widget.DetailsOverviewRowPresenter.ViewHolder.4
                @Override // androidx.leanback.widget.OnChildSelectedListener
                public void onChildSelected(ViewGroup viewGroup, View view2, int i10, long j10) {
                    ViewHolder.this.dispatchItemSelection(view2);
                }
            };
            this.mChildSelectedListener = onChildSelectedListener;
            RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.leanback.widget.DetailsOverviewRowPresenter.ViewHolder.5
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
                    ViewHolder.this.checkFirstAndLastPosition(true);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
                }
            };
            this.mScrollListener = onScrollListener;
            this.mOverviewFrame = (FrameLayout) view.findViewById(androidx.leanback.R.id.details_frame);
            this.mOverviewView = (ViewGroup) view.findViewById(androidx.leanback.R.id.details_overview);
            this.mImageView = (ImageView) view.findViewById(androidx.leanback.R.id.details_overview_image);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(androidx.leanback.R.id.details_overview_right_panel);
            this.mRightPanel = viewGroup;
            FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(androidx.leanback.R.id.details_overview_description);
            this.mDetailsDescriptionFrame = frameLayout;
            HorizontalGridView horizontalGridView = (HorizontalGridView) viewGroup.findViewById(androidx.leanback.R.id.details_overview_actions);
            this.mActionsRow = horizontalGridView;
            horizontalGridView.setHasOverlappingRendering(false);
            horizontalGridView.setOnScrollListener(onScrollListener);
            horizontalGridView.setAdapter(this.mActionBridgeAdapter);
            horizontalGridView.setOnChildSelectedListener(onChildSelectedListener);
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_actions_fade_size);
            horizontalGridView.setFadingRightEdgeLength(dimensionPixelSize);
            horizontalGridView.setFadingLeftEdgeLength(dimensionPixelSize);
            Presenter.ViewHolder viewHolderOnCreateViewHolder = presenter.onCreateViewHolder(frameLayout);
            this.mDetailsDescriptionViewHolder = viewHolderOnCreateViewHolder;
            frameLayout.addView(viewHolderOnCreateViewHolder.view);
        }

        private void showMoreLeft(boolean z10) {
            if (z10 != this.mShowMoreLeft) {
                this.mActionsRow.setFadingLeftEdge(z10);
                this.mShowMoreLeft = z10;
            }
        }

        private void showMoreRight(boolean z10) {
            if (z10 != this.mShowMoreRight) {
                this.mActionsRow.setFadingRightEdge(z10);
                this.mShowMoreRight = z10;
            }
        }

        void bindActions(ObjectAdapter objectAdapter) {
            this.mActionBridgeAdapter.setAdapter(objectAdapter);
            this.mActionsRow.setAdapter(this.mActionBridgeAdapter);
            this.mNumItems = this.mActionBridgeAdapter.getItemCount();
            this.mShowMoreRight = false;
            this.mShowMoreLeft = true;
            showMoreLeft(false);
        }

        void checkFirstAndLastPosition(boolean z10) {
            boolean z11 = true;
            RecyclerView.ViewHolder viewHolderFindViewHolderForPosition = this.mActionsRow.findViewHolderForPosition(this.mNumItems - 1);
            boolean z12 = viewHolderFindViewHolderForPosition == null || viewHolderFindViewHolderForPosition.itemView.getRight() > this.mActionsRow.getWidth();
            RecyclerView.ViewHolder viewHolderFindViewHolderForPosition2 = this.mActionsRow.findViewHolderForPosition(0);
            if (viewHolderFindViewHolderForPosition2 != null && viewHolderFindViewHolderForPosition2.itemView.getLeft() >= 0) {
                z11 = false;
            }
            showMoreRight(z12);
            showMoreLeft(z11);
        }

        void unbindActions() {
            this.mActionsRow.setAdapter(null);
            this.mActionBridgeAdapter.setAdapter(null);
            this.mNumItems = 0;
        }

        void dispatchItemSelection(View view) {
            RecyclerView.ViewHolder viewHolderFindViewHolderForPosition;
            if (isSelected()) {
                if (view != null) {
                    viewHolderFindViewHolderForPosition = this.mActionsRow.getChildViewHolder(view);
                } else {
                    HorizontalGridView horizontalGridView = this.mActionsRow;
                    viewHolderFindViewHolderForPosition = horizontalGridView.findViewHolderForPosition(horizontalGridView.getSelectedPosition());
                }
                ItemBridgeAdapter.ViewHolder viewHolder = (ItemBridgeAdapter.ViewHolder) viewHolderFindViewHolderForPosition;
                if (viewHolder == null) {
                    if (getOnItemViewSelectedListener() != null) {
                        getOnItemViewSelectedListener().onItemSelected(null, null, this, getRow());
                    }
                } else if (getOnItemViewSelectedListener() != null) {
                    getOnItemViewSelectedListener().onItemSelected(viewHolder.getViewHolder(), viewHolder.getItem(), this, getRow());
                }
            }
        }
    }

    private static int getNonNegativeHeight(Drawable drawable) {
        int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            return intrinsicHeight;
        }
        return 0;
    }

    private static int getNonNegativeWidth(Drawable drawable) {
        int intrinsicWidth = drawable == null ? 0 : drawable.getIntrinsicWidth();
        if (intrinsicWidth > 0) {
            return intrinsicWidth;
        }
        return 0;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public final boolean isUsingDefaultSelectEffect() {
        return false;
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        ((DetailsOverviewRow) viewHolder2.getRow()).removeListener(viewHolder2.mListener);
        Presenter.ViewHolder viewHolder3 = viewHolder2.mDetailsDescriptionViewHolder;
        if (viewHolder3 != null) {
            this.mDetailsPresenter.onUnbindViewHolder(viewHolder3);
        }
        viewHolder2.unbindActions();
        super.onUnbindRowViewHolder(viewHolder);
    }

    public final void setSharedElementEnterTransition(Activity activity, String str, long j10) {
        if (this.mSharedElementHelper == null) {
            this.mSharedElementHelper = new DetailsOverviewSharedElementHelper();
        }
        this.mSharedElementHelper.setSharedElementEnterTransition(activity, str, j10);
    }

    private int getCardHeight(Context context) {
        return context.getResources().getDimensionPixelSize(this.mIsStyleLarge ? androidx.leanback.R.dimen.lb_details_overview_height_large : androidx.leanback.R.dimen.lb_details_overview_height_small);
    }

    private int getDefaultBackgroundColor(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(androidx.leanback.R.attr.defaultBrandColor, typedValue, true) ? context.getResources().getColor(typedValue.resourceId) : context.getResources().getColor(androidx.leanback.R.color.lb_default_brand_color);
    }

    private void initDetailsOverview(final ViewHolder viewHolder) {
        viewHolder.mActionBridgeAdapter = new ActionsItemBridgeAdapter(viewHolder);
        FrameLayout frameLayout = viewHolder.mOverviewFrame;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = getCardHeight(frameLayout.getContext());
        frameLayout.setLayoutParams(layoutParams);
        if (!getSelectEffectEnabled()) {
            viewHolder.mOverviewFrame.setForeground(null);
        }
        viewHolder.mActionsRow.setOnUnhandledKeyListener(new BaseGridView.OnUnhandledKeyListener() { // from class: androidx.leanback.widget.DetailsOverviewRowPresenter.1
            @Override // androidx.leanback.widget.BaseGridView.OnUnhandledKeyListener
            public boolean onUnhandledKey(KeyEvent keyEvent) {
                return viewHolder.getOnKeyListener() != null && viewHolder.getOnKeyListener().onKey(viewHolder.view, keyEvent.getKeyCode(), keyEvent);
            }
        });
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public OnActionClickedListener getOnActionClickedListener() {
        return this.mActionClickedListener;
    }

    public boolean isStyleLarge() {
        return this.mIsStyleLarge;
    }

    public void setBackgroundColor(@ColorInt int i10) {
        this.mBackgroundColor = i10;
        this.mBackgroundColorSet = true;
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.mActionClickedListener = onActionClickedListener;
    }

    public void setStyleLarge(boolean z10) {
        this.mIsStyleLarge = z10;
    }

    public DetailsOverviewRowPresenter(Presenter presenter) {
        setHeaderPresenter(null);
        setSelectEffectEnabled(false);
        this.mDetailsPresenter = presenter;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0065  */
    void bindImageDrawable(ViewHolder viewHolder) {
        boolean z10;
        int defaultBackgroundColor;
        DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper;
        boolean z11;
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) viewHolder.getRow();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.mImageView.getLayoutParams();
        int cardHeight = getCardHeight(viewHolder.mImageView.getContext());
        int dimensionPixelSize = viewHolder.mImageView.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_image_margin_vertical);
        int dimensionPixelSize2 = viewHolder.mImageView.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_overview_image_margin_horizontal);
        int nonNegativeWidth = getNonNegativeWidth(detailsOverviewRow.getImageDrawable());
        int nonNegativeHeight = getNonNegativeHeight(detailsOverviewRow.getImageDrawable());
        boolean zIsImageScaleUpAllowed = detailsOverviewRow.isImageScaleUpAllowed();
        if (detailsOverviewRow.getImageDrawable() != null) {
            if (nonNegativeWidth > nonNegativeHeight) {
                if (this.mIsStyleLarge) {
                    z11 = true;
                    z10 = true;
                } else {
                    z11 = true;
                }
                if ((!z11 && nonNegativeWidth > cardHeight) || (!z11 && nonNegativeHeight > cardHeight)) {
                }
                if (!zIsImageScaleUpAllowed) {
                    z10 = true;
                }
                if (z10 && !zIsImageScaleUpAllowed && ((z11 && nonNegativeWidth > cardHeight - dimensionPixelSize2) || (!z11 && nonNegativeHeight > cardHeight - (dimensionPixelSize * 2)))) {
                    zIsImageScaleUpAllowed = true;
                }
            } else {
                z11 = false;
            }
            z10 = false;
            zIsImageScaleUpAllowed = !z11 ? true : true;
            if (!zIsImageScaleUpAllowed) {
                z10 = true;
            }
            if (z10) {
                zIsImageScaleUpAllowed = true;
            }
        } else {
            z10 = false;
        }
        if (this.mBackgroundColorSet) {
            defaultBackgroundColor = this.mBackgroundColor;
        } else {
            defaultBackgroundColor = getDefaultBackgroundColor(viewHolder.mOverviewView.getContext());
        }
        if (z10) {
            marginLayoutParams.setMarginStart(dimensionPixelSize2);
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            marginLayoutParams.topMargin = dimensionPixelSize;
            viewHolder.mOverviewFrame.setBackgroundColor(defaultBackgroundColor);
            viewHolder.mRightPanel.setBackground(null);
            viewHolder.mImageView.setBackground(null);
        } else {
            marginLayoutParams.bottomMargin = 0;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            viewHolder.mRightPanel.setBackgroundColor(defaultBackgroundColor);
            viewHolder.mImageView.setBackgroundColor(defaultBackgroundColor);
            viewHolder.mOverviewFrame.setBackground(null);
        }
        RoundedRectHelper.setClipToRoundedOutline(viewHolder.mOverviewFrame, true);
        if (zIsImageScaleUpAllowed) {
            viewHolder.mImageView.setScaleType(ImageView.ScaleType.FIT_START);
            viewHolder.mImageView.setAdjustViewBounds(true);
            viewHolder.mImageView.setMaxWidth(cardHeight);
            marginLayoutParams.height = -1;
            marginLayoutParams.width = -2;
        } else {
            viewHolder.mImageView.setScaleType(ImageView.ScaleType.CENTER);
            viewHolder.mImageView.setAdjustViewBounds(false);
            marginLayoutParams.height = -2;
            marginLayoutParams.width = Math.min(cardHeight, nonNegativeWidth);
        }
        viewHolder.mImageView.setLayoutParams(marginLayoutParams);
        viewHolder.mImageView.setImageDrawable(detailsOverviewRow.getImageDrawable());
        if (detailsOverviewRow.getImageDrawable() != null && (detailsOverviewSharedElementHelper = this.mSharedElementHelper) != null) {
            detailsOverviewSharedElementHelper.onBindToDrawable(viewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_details_overview, viewGroup, false), this.mDetailsPresenter);
        initDetailsOverview(viewHolder);
        return viewHolder;
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        bindImageDrawable(viewHolder2);
        this.mDetailsPresenter.onBindViewHolder(viewHolder2.mDetailsDescriptionViewHolder, detailsOverviewRow.getItem());
        viewHolder2.bindActions(detailsOverviewRow.getActionsAdapter());
        detailsOverviewRow.addListener(viewHolder2.mListener);
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onRowViewAttachedToWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewAttachedToWindow(viewHolder);
        Presenter presenter = this.mDetailsPresenter;
        if (presenter != null) {
            presenter.onViewAttachedToWindow(((ViewHolder) viewHolder).mDetailsDescriptionViewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onRowViewDetachedFromWindow(RowPresenter.ViewHolder viewHolder) {
        super.onRowViewDetachedFromWindow(viewHolder);
        Presenter presenter = this.mDetailsPresenter;
        if (presenter != null) {
            presenter.onViewDetachedFromWindow(((ViewHolder) viewHolder).mDetailsDescriptionViewHolder);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onRowViewSelected(RowPresenter.ViewHolder viewHolder, boolean z10) {
        super.onRowViewSelected(viewHolder, z10);
        if (z10) {
            ((ViewHolder) viewHolder).dispatchItemSelection(null);
        }
    }

    @Override // androidx.leanback.widget.RowPresenter
    protected void onSelectLevelChanged(RowPresenter.ViewHolder viewHolder) {
        super.onSelectLevelChanged(viewHolder);
        if (getSelectEffectEnabled()) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            ((ColorDrawable) viewHolder2.mOverviewFrame.getForeground().mutate()).setColor(viewHolder2.mColorDimmer.getPaint().getColor());
        }
    }

    public final void setSharedElementEnterTransition(Activity activity, String str) {
        setSharedElementEnterTransition(activity, str, 5000L);
    }
}
