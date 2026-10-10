package com.live.evo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class LoadView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NetView f7474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f7475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f7476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f7477d;

    public LoadView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7477d = context;
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.p_vod_cache, this);
        this.f7474a = (NetView) viewInflate.findViewById(R$id.pvodcache_iv_rotate_image);
        this.f7475b = (TextView) viewInflate.findViewById(R$id.pvodcache_tv_traffic);
        this.f7476c = (TextView) viewInflate.findViewById(R$id.pvodcache_tv_traffic_kbs);
        com.live.evo.util.t.b(this.f7475b);
        com.live.evo.util.t.b(this.f7476c);
    }

    public void setText(String str) {
        this.f7475b.setText(str);
        this.f7476c.setText(" kb/s");
    }

    public LoadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadView(Context context) {
        this(context, null);
    }
}
