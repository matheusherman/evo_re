package com.tvc.lib.mobile.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tvc.lib.R$id;
import com.tvc.lib.R$layout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r extends BaseAdapter implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f9492b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutInflater f9493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9494d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends Filter {
        a() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = r.this.f9492b;
            filterResults.count = r.this.f9492b.size();
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            if (filterResults.count > 0) {
                r.this.notifyDataSetChanged();
            } else {
                r.this.notifyDataSetInvalidated();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f9496a;

        b(r rVar) {
        }
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getItem(int i10) {
        return this.f9494d + this.f9492b.get(i10);
    }

    public void c(String str, List<String> list) {
        this.f9492b.clear();
        if (!TextUtils.isEmpty(str)) {
            this.f9494d = str;
            this.f9492b.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9492b.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new a();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f9493c.inflate(R$layout.spinner_edit_text, (ViewGroup) null);
            bVar = new b(this);
            TextView textView = (TextView) view.findViewById(R$id.list_item);
            bVar.f9496a = textView;
            textView.setGravity(3);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f9496a.setText(this.f9494d + this.f9492b.get(i10));
        return view;
    }

    public r(Context context) {
        this.f9491a = context;
        this.f9493c = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
