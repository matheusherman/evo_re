package com.live.evo_mobile.ui.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\rB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0016\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0018\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0017¢\u0006\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/live/evo_mobile/ui/login/b;", "Landroid/widget/BaseAdapter;", "Landroid/content/Context;", "ctx", "", "Lcom/live/evo_mobile/ui/login/c;", "dataList", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "", "getCount", "()I", "position", "a", "(I)Lcom/live/evo_mobile/ui/login/c;", "", "getItemId", "(I)J", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "getDropDownView", "Landroid/content/Context;", "b", "Ljava/util/List;", "Landroid/view/LayoutInflater;", "c", "Landroid/view/LayoutInflater;", "li", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context ctx;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<c> dataList;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LayoutInflater li;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/live/evo_mobile/ui/login/b$a;", "", "Landroid/view/View;", "view", "<init>", "(Lcom/live/evo_mobile/ui/login/b;Landroid/view/View;)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "areaCode", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final TextView areaCode;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f8013b;

        public a(b bVar, View view) {
            kotlin.jvm.internal.m.f(view, "view");
            this.f8013b = bVar;
            View viewFindViewById = view.findViewById(R$id.area_code);
            kotlin.jvm.internal.m.e(viewFindViewById, "findViewById(...)");
            this.areaCode = (TextView) viewFindViewById;
            view.setTag(this);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final TextView getAreaCode() {
            return this.areaCode;
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public b(Context ctx, List<c> dataList) {
        kotlin.jvm.internal.m.f(ctx, "ctx");
        kotlin.jvm.internal.m.f(dataList, "dataList");
        this.ctx = ctx;
        this.dataList = dataList;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(ctx);
        kotlin.jvm.internal.m.e(layoutInflaterFrom, "from(...)");
        this.li = layoutInflaterFrom;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c getItem(int position) {
        return this.dataList.get(position);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dataList.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    @SuppressLint({"SetTextI18n"})
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(this.ctx, R$layout.account_area_item_select_drop, null);
            kotlin.jvm.internal.m.c(convertView);
            convertView.setTag(new a(this, convertView));
        }
        Object tag = convertView.getTag();
        kotlin.jvm.internal.m.d(tag, "null cannot be cast to non-null type com.live.evo_mobile.ui.login.AreaSpinnerAdapter.ViewHolder");
        ((a) tag).getAreaCode().setText(getItem(position).getPhonePreCode() + "(" + getItem(position).getCountryShowName() + ")");
        kotlin.jvm.internal.m.c(convertView);
        return convertView;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"SetTextI18n"})
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(this.ctx, R$layout.account_area_item_select, null);
            kotlin.jvm.internal.m.c(convertView);
            convertView.setTag(new a(this, convertView));
        }
        Object tag = convertView.getTag();
        kotlin.jvm.internal.m.d(tag, "null cannot be cast to non-null type com.live.evo_mobile.ui.login.AreaSpinnerAdapter.ViewHolder");
        ((a) tag).getAreaCode().setText(getItem(position).getPhonePreCode() + "(" + getItem(position).getCountryShowName() + ")");
        kotlin.jvm.internal.m.c(convertView);
        return convertView;
    }
}
