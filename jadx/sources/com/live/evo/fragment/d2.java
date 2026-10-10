package com.live.evo.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d2 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f5923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f5924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f5925c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ImageView f5926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f5927b;

        /* synthetic */ a(d2 d2Var, e2 e2Var) {
            this(d2Var);
        }

        private a(d2 d2Var) {
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f5923a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        List<String> list = this.f5923a;
        if (list == null) {
            return null;
        }
        return list.get(i10);
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        if (view == null) {
            aVar = new a(this, null);
            viewInflate = this.f5925c.inflate(R$layout.pipsettings_list_item, (ViewGroup) null);
            aVar.f5926a = (ImageView) viewInflate.findViewById(R$id.pip_item_image);
            aVar.f5927b = (TextView) viewInflate.findViewById(R$id.pip_item_name);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        aVar.f5927b.setText(this.f5923a.get(i10));
        if (!(com.live.evo.l.n().G() && TextUtils.equals(this.f5923a.get(i10).toLowerCase(), com.live.evo.util.x1.j(R$string.on).toLowerCase())) && (com.live.evo.l.n().G() || !TextUtils.equals(this.f5923a.get(i10).toLowerCase(), com.live.evo.util.x1.j(R$string.off).toLowerCase()))) {
            aVar.f5926a.setVisibility(8);
            return viewInflate;
        }
        aVar.f5926a.setVisibility(0);
        return viewInflate;
    }

    public d2(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        this.f5923a = arrayList;
        this.f5924b = context;
        arrayList.addAll(list);
        this.f5925c = LayoutInflater.from(this.f5924b);
    }
}
