package androidx.leanback.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final class ListRowHoverCardView extends LinearLayout {
    private final TextView mDescriptionView;
    private final TextView mTitleView;

    public ListRowHoverCardView(Context context) {
        this(context, null);
    }

    public ListRowHoverCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final CharSequence getDescription() {
        return this.mDescriptionView.getText();
    }

    public final CharSequence getTitle() {
        return this.mTitleView.getText();
    }

    public ListRowHoverCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_list_row_hovercard, this);
        this.mTitleView = (TextView) findViewById(androidx.leanback.R.id.title);
        this.mDescriptionView = (TextView) findViewById(androidx.leanback.R.id.description);
    }

    public final void setDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.mDescriptionView.setText(charSequence);
            this.mDescriptionView.setVisibility(0);
        } else {
            this.mDescriptionView.setVisibility(8);
        }
    }

    public final void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.mTitleView.setText(charSequence);
            this.mTitleView.setVisibility(0);
        } else {
            this.mTitleView.setVisibility(8);
        }
    }
}
