package com.live.evo_mobile.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.live.evo.R$color;
import com.live.evo.R$id;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001c¨\u0006\""}, d2 = {"Lcom/live/evo_mobile/adapter/l;", "Landroid/widget/ArrayAdapter;", "", "Landroid/content/Context;", "mContext", "", "mResource", "", "mData", "Landroid/widget/ListView;", "mDatePickLv", "<init>", "(Landroid/content/Context;ILjava/util/List;Landroid/widget/ListView;)V", "selectedId", "Lr8/z;", "a", "(I)V", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "getCount", "()I", "Landroid/content/Context;", "b", "I", "c", "Ljava/util/List;", "d", "Landroid/widget/ListView;", "e", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l extends ArrayAdapter<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mResource;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final List<String> mData;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ListView mDatePickLv;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int selectedId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context mContext, int i10, List<String> mData, ListView mDatePickLv) {
        super(mContext, i10, mData);
        kotlin.jvm.internal.m.f(mContext, "mContext");
        kotlin.jvm.internal.m.f(mData, "mData");
        kotlin.jvm.internal.m.f(mDatePickLv, "mDatePickLv");
        this.mContext = mContext;
        this.mResource = i10;
        this.mData = mData;
        this.mDatePickLv = mDatePickLv;
    }

    public final void a(int selectedId) {
        this.selectedId = selectedId;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        List<String> list = this.mData;
        kotlin.jvm.internal.m.c(list);
        return list.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        kotlin.jvm.internal.m.f(parent, "parent");
        if (convertView == null) {
            convertView = View.inflate(this.mContext, this.mResource, null);
        }
        kotlin.jvm.internal.m.c(convertView);
        TextView textView = (TextView) convertView.findViewById(R$id.picker_item_tv);
        ListView listView = this.mDatePickLv;
        kotlin.jvm.internal.m.c(listView);
        textView.setSelected(listView.isItemChecked(position));
        List<String> list = this.mData;
        kotlin.jvm.internal.m.c(list);
        textView.setText(list.get(position));
        if (position == this.selectedId) {
            Context context = this.mContext;
            kotlin.jvm.internal.m.c(context);
            textView.setTextColor(context.getResources().getColor(R$color.vod_episode_choose_color));
            return convertView;
        }
        Context context2 = this.mContext;
        kotlin.jvm.internal.m.c(context2);
        textView.setTextColor(context2.getResources().getColor(R$color.picker_text_color));
        return convertView;
    }
}
