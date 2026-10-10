package androidx.leanback.widget;

import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class GuidanceStylist implements FragmentAnimationProvider {
    private TextView mBreadcrumbView;
    private TextView mDescriptionView;
    private View mGuidanceContainer;
    private ImageView mIconView;
    private TextView mTitleView;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class Guidance {
        private final String mBreadcrumb;
        private final String mDescription;
        private final Drawable mIconDrawable;
        private final String mTitle;

        public String getBreadcrumb() {
            return this.mBreadcrumb;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public Drawable getIconDrawable() {
            return this.mIconDrawable;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public Guidance(String str, String str2, String str3, Drawable drawable) {
            this.mBreadcrumb = str3;
            this.mTitle = str;
            this.mDescription = str2;
            this.mIconDrawable = drawable;
        }
    }

    public void onDestroyView() {
        this.mBreadcrumbView = null;
        this.mDescriptionView = null;
        this.mIconView = null;
        this.mTitleView = null;
        this.mGuidanceContainer = null;
    }

    public TextView getBreadcrumbView() {
        return this.mBreadcrumbView;
    }

    public TextView getDescriptionView() {
        return this.mDescriptionView;
    }

    public ImageView getIconView() {
        return this.mIconView;
    }

    public TextView getTitleView() {
        return this.mTitleView;
    }

    public int onProvideLayoutId() {
        return androidx.leanback.R.layout.lb_guidance;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Guidance guidance) {
        View viewInflate = layoutInflater.inflate(onProvideLayoutId(), viewGroup, false);
        this.mTitleView = (TextView) viewInflate.findViewById(androidx.leanback.R.id.guidance_title);
        this.mBreadcrumbView = (TextView) viewInflate.findViewById(androidx.leanback.R.id.guidance_breadcrumb);
        this.mDescriptionView = (TextView) viewInflate.findViewById(androidx.leanback.R.id.guidance_description);
        this.mIconView = (ImageView) viewInflate.findViewById(androidx.leanback.R.id.guidance_icon);
        this.mGuidanceContainer = viewInflate.findViewById(androidx.leanback.R.id.guidance_container);
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(guidance.getTitle());
        }
        TextView textView2 = this.mBreadcrumbView;
        if (textView2 != null) {
            textView2.setText(guidance.getBreadcrumb());
        }
        TextView textView3 = this.mDescriptionView;
        if (textView3 != null) {
            textView3.setText(guidance.getDescription());
        }
        if (this.mIconView != null) {
            if (guidance.getIconDrawable() != null) {
                this.mIconView.setImageDrawable(guidance.getIconDrawable());
            } else {
                this.mIconView.setVisibility(8);
            }
        }
        View view = this.mGuidanceContainer;
        if (view != null && TextUtils.isEmpty(view.getContentDescription())) {
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(guidance.getBreadcrumb())) {
                sb2.append(guidance.getBreadcrumb());
                sb2.append('\n');
            }
            if (!TextUtils.isEmpty(guidance.getTitle())) {
                sb2.append(guidance.getTitle());
                sb2.append('\n');
            }
            if (!TextUtils.isEmpty(guidance.getDescription())) {
                sb2.append(guidance.getDescription());
                sb2.append('\n');
            }
            this.mGuidanceContainer.setContentDescription(sb2);
        }
        return viewInflate;
    }

    @Override // androidx.leanback.widget.FragmentAnimationProvider
    public void onImeAppearing(List<Animator> list) {
    }

    @Override // androidx.leanback.widget.FragmentAnimationProvider
    public void onImeDisappearing(List<Animator> list) {
    }
}
