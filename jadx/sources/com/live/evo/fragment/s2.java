package com.live.evo.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u0018\u0010$\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001b¨\u0006'"}, d2 = {"Lcom/live/evo/fragment/s2;", "Ll5/b;", "<init>", "()V", "Lr8/z;", "j0", "", "b0", "()I", "Landroid/os/Bundle;", "savedInstanceState", "c0", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "f0", "(Landroid/view/View;)V", "", "isVisible", "h0", "(Z)V", "Landroid/widget/ImageView;", "l", "Landroid/widget/ImageView;", "qrcodeView", "Landroid/widget/TextView;", "m", "Landroid/widget/TextView;", "tipsView", "Landroid/widget/LinearLayout;", "n", "Landroid/widget/LinearLayout;", "upgradeLayoutView", "o", "upgradeTitleView", "p", "upgradeContentView", "q", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s2 extends l5.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private ImageView qrcodeView;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView tipsView;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private LinearLayout upgradeLayoutView;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private TextView upgradeTitleView;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private TextView upgradeContentView;

    /* JADX INFO: renamed from: com.live.evo.fragment.s2$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/live/evo/fragment/s2$a;", "", "<init>", "()V", "Lcom/live/evo/fragment/s2;", "a", "()Lcom/live/evo/fragment/s2;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final s2 a() {
            return new s2();
        }
    }

    @Override // l5.b
    protected void f0(View view) {
        this.qrcodeView = view != null ? (ImageView) view.findViewById(R$id.iv_qr_code) : null;
        this.tipsView = view != null ? (TextView) view.findViewById(R$id.tv_app_tips) : null;
        this.upgradeLayoutView = view != null ? (LinearLayout) view.findViewById(R$id.ll_new_version_layout) : null;
        this.upgradeTitleView = view != null ? (TextView) view.findViewById(R$id.iv_new_version_title) : null;
        this.upgradeContentView = view != null ? (TextView) view.findViewById(R$id.iv_new_version_content) : null;
    }

    private final void j0() {
        if (this.qrcodeView != null) {
            com.bumptech.glide.k kVarB0 = com.bumptech.glide.c.t(requireContext()).u(x1.f1.lb.heartbeat.f.f20678a.o0()).b0(R$drawable.qr_placehodler);
            ImageView imageView = this.qrcodeView;
            kotlin.jvm.internal.m.c(imageView);
            kVarB0.E0(imageView);
        }
    }

    @Override // l5.b
    protected int b0() {
        return R$layout.tabfunction_phonescan_fragment;
    }

    @Override // l5.b
    protected void c0(Bundle savedInstanceState) {
        j0();
        TextView textView = this.tipsView;
        if (textView != null) {
            textView.setText(Html.fromHtml(getString(R$string.phone_scan_page_tips)));
        }
        LinearLayout linearLayout = this.upgradeLayoutView;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // l5.b
    public void h0(boolean isVisible) {
        super.h0(isVisible);
        if (isVisible) {
            j0();
        }
    }
}
