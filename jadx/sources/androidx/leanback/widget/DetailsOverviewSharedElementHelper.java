package androidx.leanback.widget;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.ViewCompat;
import androidx.leanback.transition.TransitionHelper;
import androidx.leanback.transition.TransitionListener;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
final class DetailsOverviewSharedElementHelper extends SharedElementCallback {
    static final boolean DEBUG = false;
    static final String TAG = "DetailsTransitionHelper";
    Activity mActivityToRunTransition;
    int mRightPanelHeight;
    int mRightPanelWidth;
    private Matrix mSavedMatrix;
    private ImageView.ScaleType mSavedScaleType;
    String mSharedElementName;
    boolean mStartedPostpone;
    WeakReference<DetailsOverviewRowPresenter.ViewHolder> mViewHolder = new WeakReference<>(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class TransitionTimeOutRunnable implements Runnable {
        final WeakReference<DetailsOverviewSharedElementHelper> mHelperRef;

        @Override // java.lang.Runnable
        public void run() {
            DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper = this.mHelperRef.get();
            if (detailsOverviewSharedElementHelper == null) {
                return;
            }
            detailsOverviewSharedElementHelper.startPostponedEnterTransition();
        }

        TransitionTimeOutRunnable(DetailsOverviewSharedElementHelper detailsOverviewSharedElementHelper) {
            this.mHelperRef = new WeakReference<>(detailsOverviewSharedElementHelper);
        }
    }

    private static void changeImageViewScale(DetailsOverviewRowPresenter.ViewHolder viewHolder, View view) {
        ImageView imageView = (ImageView) view;
        ImageView imageView2 = viewHolder.mImageView;
        imageView2.setScaleType(imageView.getScaleType());
        if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
            imageView2.setImageMatrix(imageView.getImageMatrix());
        }
        updateImageViewAfterScaleTypeChange(imageView2);
    }

    private boolean hasImageViewScaleChange(View view) {
        return view instanceof ImageView;
    }

    private void restoreImageViewScale(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        ImageView.ScaleType scaleType = this.mSavedScaleType;
        if (scaleType != null) {
            ImageView imageView = viewHolder.mImageView;
            imageView.setScaleType(scaleType);
            if (this.mSavedScaleType == ImageView.ScaleType.MATRIX) {
                imageView.setImageMatrix(this.mSavedMatrix);
            }
            this.mSavedScaleType = null;
            updateImageViewAfterScaleTypeChange(imageView);
        }
    }

    private void saveImageViewScale() {
        DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder.get();
        if (this.mSavedScaleType != null || viewHolder == null) {
            return;
        }
        ImageView imageView = viewHolder.mImageView;
        ImageView.ScaleType scaleType = imageView.getScaleType();
        this.mSavedScaleType = scaleType;
        this.mSavedMatrix = scaleType == ImageView.ScaleType.MATRIX ? imageView.getMatrix() : null;
    }

    void onBindToDrawable(DetailsOverviewRowPresenter.ViewHolder viewHolder) {
        DetailsOverviewRowPresenter.ViewHolder viewHolder2 = this.mViewHolder.get();
        if (viewHolder2 != null) {
            ViewCompat.setTransitionName(viewHolder2.mOverviewFrame, null);
        }
        this.mViewHolder = new WeakReference<>(viewHolder);
        viewHolder.mRightPanel.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.leanback.widget.DetailsOverviewSharedElementHelper.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                view.removeOnLayoutChangeListener(this);
                DetailsOverviewRowPresenter.ViewHolder viewHolder3 = DetailsOverviewSharedElementHelper.this.mViewHolder.get();
                if (viewHolder3 != null) {
                    DetailsOverviewSharedElementHelper.this.mRightPanelWidth = viewHolder3.mRightPanel.getWidth();
                    DetailsOverviewSharedElementHelper.this.mRightPanelHeight = viewHolder3.mRightPanel.getHeight();
                }
            }
        });
        viewHolder.mRightPanel.postOnAnimation(new Runnable() { // from class: androidx.leanback.widget.DetailsOverviewSharedElementHelper.2
            @Override // java.lang.Runnable
            public void run() {
                DetailsOverviewRowPresenter.ViewHolder viewHolder3 = DetailsOverviewSharedElementHelper.this.mViewHolder.get();
                if (viewHolder3 == null) {
                    return;
                }
                ViewCompat.setTransitionName(viewHolder3.mOverviewFrame, DetailsOverviewSharedElementHelper.this.mSharedElementName);
                Object sharedElementEnterTransition = TransitionHelper.getSharedElementEnterTransition(DetailsOverviewSharedElementHelper.this.mActivityToRunTransition.getWindow());
                if (sharedElementEnterTransition != null) {
                    TransitionHelper.addTransitionListener(sharedElementEnterTransition, new TransitionListener() { // from class: androidx.leanback.widget.DetailsOverviewSharedElementHelper.2.1
                        @Override // androidx.leanback.transition.TransitionListener
                        public void onTransitionEnd(Object obj) {
                            DetailsOverviewRowPresenter.ViewHolder viewHolder4 = DetailsOverviewSharedElementHelper.this.mViewHolder.get();
                            if (viewHolder4 != null && viewHolder4.mActionsRow.isFocused()) {
                                viewHolder4.mActionsRow.requestFocus();
                            }
                            TransitionHelper.removeTransitionListener(obj, this);
                        }
                    });
                }
                DetailsOverviewSharedElementHelper.this.startPostponedEnterTransition();
            }
        });
    }

    void setSharedElementEnterTransition(Activity activity, String str, long j10) {
        if ((activity == null && !TextUtils.isEmpty(str)) || (activity != null && TextUtils.isEmpty(str))) {
            throw new IllegalArgumentException();
        }
        if (activity == this.mActivityToRunTransition && TextUtils.equals(str, this.mSharedElementName)) {
            return;
        }
        Activity activity2 = this.mActivityToRunTransition;
        if (activity2 != null) {
            ActivityCompat.setEnterSharedElementCallback(activity2, null);
        }
        this.mActivityToRunTransition = activity;
        this.mSharedElementName = str;
        ActivityCompat.setEnterSharedElementCallback(activity, this);
        ActivityCompat.postponeEnterTransition(this.mActivityToRunTransition);
        if (j10 > 0) {
            new Handler().postDelayed(new TransitionTimeOutRunnable(this), j10);
        }
    }

    void startPostponedEnterTransition() {
        if (this.mStartedPostpone) {
            return;
        }
        ActivityCompat.startPostponedEnterTransition(this.mActivityToRunTransition);
        this.mStartedPostpone = true;
    }

    DetailsOverviewSharedElementHelper() {
    }

    private static void updateImageViewAfterScaleTypeChange(ImageView imageView) {
        imageView.measure(View.MeasureSpec.makeMeasureSpec(imageView.getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(imageView.getMeasuredHeight(), BasicMeasure.EXACTLY));
        imageView.layout(imageView.getLeft(), imageView.getTop(), imageView.getRight(), imageView.getBottom());
    }

    @Override // androidx.core.app.SharedElementCallback
    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
        if (list2.size() >= 1) {
            DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder.get();
            View view = list2.get(0);
            if (viewHolder != null && viewHolder.mOverviewFrame == view) {
                restoreImageViewScale(viewHolder);
                viewHolder.mActionsRow.setDescendantFocusability(131072);
                viewHolder.mActionsRow.setVisibility(0);
                viewHolder.mActionsRow.setDescendantFocusability(262144);
                viewHolder.mActionsRow.requestFocus();
                viewHolder.mDetailsDescriptionFrame.setVisibility(0);
            }
        }
    }

    @Override // androidx.core.app.SharedElementCallback
    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
        if (list2.size() >= 1) {
            DetailsOverviewRowPresenter.ViewHolder viewHolder = this.mViewHolder.get();
            View view = list2.get(0);
            if (viewHolder != null && viewHolder.mOverviewFrame == view) {
                View view2 = list3.get(0);
                if (hasImageViewScaleChange(view2)) {
                    saveImageViewScale();
                    changeImageViewScale(viewHolder, view2);
                }
                ImageView imageView = viewHolder.mImageView;
                int width = view.getWidth();
                int height = view.getHeight();
                imageView.measure(View.MeasureSpec.makeMeasureSpec(width, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(height, BasicMeasure.EXACTLY));
                imageView.layout(0, 0, width, height);
                ViewGroup viewGroup = viewHolder.mRightPanel;
                int i10 = this.mRightPanelWidth;
                if (i10 != 0 && this.mRightPanelHeight != 0) {
                    viewGroup.measure(View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.mRightPanelHeight, BasicMeasure.EXACTLY));
                    viewGroup.layout(width, viewGroup.getTop(), this.mRightPanelWidth + width, viewGroup.getTop() + this.mRightPanelHeight);
                } else {
                    viewGroup.offsetLeftAndRight(width - viewGroup.getLeft());
                }
                viewHolder.mActionsRow.setVisibility(4);
                viewHolder.mDetailsDescriptionFrame.setVisibility(4);
            }
        }
    }
}
