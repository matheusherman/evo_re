package com.live.evo_mobile.ui;

import android.content.Intent;
import android.view.View;
import com.live.evo.R$color;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.pengrad.telegrambot.request.ContentTypes;
import com.tvc.lib.mobile.ui.base.BaseDataBindActivity;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/live/evo_mobile/ui/ShareActivity;", "Lcom/tvc/lib/mobile/ui/base/BaseDataBindActivity;", "Lz4/s;", "<init>", "()V", "", "x", "()I", "Lr8/z;", "v", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareActivity extends BaseDataBindActivity<z4.s> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(ShareActivity shareActivity, String str, View view) {
        shareActivity.F("com.whatsapp", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(ShareActivity shareActivity, String str, View view) {
        shareActivity.F("org.telegram.messenger,org.telegram.messenger.web", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(ShareActivity shareActivity, String str, View view) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(ContentTypes.DOC_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", str);
        shareActivity.getLogger().a("share via more", new Object[0]);
        shareActivity.startActivity(Intent.createChooser(intent, shareActivity.getString(R$string.share_via)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(ShareActivity shareActivity, View view) {
        shareActivity.finish();
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public void v() {
        com.tvc.lib.mobile.ext.a.c(this, R$color.status_bar_bg_color, Boolean.FALSE);
        t().f22959e.f22835a.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareActivity.K(this.f7959a, view);
            }
        });
        t().f22959e.f22836b.setText(getString(2131952948));
        final String strO = x1.f1.lb.config.b.f20643a.o();
        if (strO.length() == 0) {
            strO = getString(2131952954) + " " + t.v.c.i.a.f18646a.N();
        }
        t().f22957c.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareActivity.L(this.f7963a, strO, view);
            }
        });
        t().f22956b.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.k2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareActivity.M(this.f7982a, strO, view);
            }
        });
        t().f22955a.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo_mobile.ui.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareActivity.N(this.f7990a, strO, view);
            }
        });
    }

    @Override // com.tvc.lib.mobile.ui.base.BaseDataBindActivity
    public int x() {
        return R$layout.activity_share;
    }
}
