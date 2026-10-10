package com.live.evo.osd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class PlanListPresenter$PlanItem extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f7046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f7047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f7048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f7049d;

    public PlanListPresenter$PlanItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlanListPresenter$PlanItem(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }

    private void a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.item_plan_info, (ViewGroup) this, true);
        setFocusable(false);
        this.f7046a = (TextView) viewInflate.findViewById(R$id.tv_plan_name);
        this.f7047b = (TextView) viewInflate.findViewById(R$id.tv_plan_sale_price);
        this.f7048c = (TextView) viewInflate.findViewById(R$id.tv_plan_origin_price);
        this.f7049d = (TextView) viewInflate.findViewById(R$id.tv_plan_describe);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return super.isFocused();
    }
}
