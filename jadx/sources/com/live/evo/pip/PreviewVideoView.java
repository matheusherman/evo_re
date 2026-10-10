package com.live.evo.pip;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.util.n;
import com.live.evo.util.v;
import com.live.evo.util.x1;
import com.live.evo.widget.sloading.SLoadingView;
import t.v.c.widget.videoview.VideoView;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class PreviewVideoView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f7160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f7162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SLoadingView f7163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f7164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f7165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f7166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private VideoView f7167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f7168i;

    public PreviewVideoView(Context context) {
        this(context, null);
    }

    public PreviewVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(Context context, View view, String str) {
        this.f7160a = view;
        this.f7168i = (View) view.getParent();
        this.f7162c = (TextView) this.f7160a.findViewById(R$id.preview_text_loading);
        this.f7163d = (SLoadingView) this.f7160a.findViewById(R$id.preview_loading);
        this.f7164e = (TextView) this.f7160a.findViewById(R$id.preview_lock);
        this.f7165f = (TextView) this.f7160a.findViewById(R$id.preview_channel);
        this.f7166g = (ImageView) this.f7160a.findViewById(R$id.preview_nosignal);
        this.f7167h = (VideoView) this.f7160a.findViewById(R$id.preview_videoview);
        int iD = n.d() / 4;
        int i10 = (iD * 9) / 16;
        View view2 = this.f7168i;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = iD;
            layoutParams.height = i10;
            this.f7168i.requestLayout();
        } else {
            setLayoutParams(new RelativeLayout.LayoutParams(iD, i10));
        }
        int i11 = "en".equalsIgnoreCase(x1.h()) ? R$drawable.pip_no_signal_en : R$drawable.pip_no_signal_pt;
        this.f7166g.setBackground(null);
        if (TextUtils.isEmpty(str)) {
            this.f7166g.setBackground(context.getResources().getDrawable(i11));
        } else {
            v.d(context, str, this.f7166g);
        }
    }

    public VideoView getPreviewVideo() {
        return this.f7167h;
    }

    @Override // android.view.View
    public int getVisibility() {
        return this.f7163d.getVisibility();
    }

    public void setLoadingText(String str) {
        TextView textView = this.f7162c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setLoadingTextVisible(int i10) {
        TextView textView = this.f7162c;
        if (textView != null) {
            textView.setVisibility(i10);
            if (i10 != 0) {
                this.f7162c.setText("");
            }
        }
        SLoadingView sLoadingView = this.f7163d;
        if (sLoadingView == null || sLoadingView.getVisibility() == i10) {
            return;
        }
        this.f7163d.setVisibility(i10);
    }

    public void setNoSignalVisible(int i10) {
        ImageView imageView = this.f7166g;
        if (imageView != null) {
            imageView.setVisibility(i10);
        }
    }

    public void setPreviewVideoVisible(int i10) {
        View view = this.f7168i;
        if (view != null) {
            view.setVisibility(i10);
        }
    }

    public void setTextlockVisible(int i10) {
        TextView textView = this.f7164e;
        if (textView != null) {
            textView.setVisibility(i10);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        View view = this.f7168i;
        if (view != null) {
            view.setVisibility(i10);
        }
    }

    public PreviewVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7161b = context;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.preview_live_layout, this);
        this.f7160a = viewInflate;
        a(this.f7161b, viewInflate, "");
    }

    public void setChannelText(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f7165f.setText(str);
    }
}
