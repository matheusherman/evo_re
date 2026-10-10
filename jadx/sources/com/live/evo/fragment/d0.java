package com.live.evo.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d0 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<i5.t> f5919b = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f5920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f5921b;

        /* synthetic */ a(d0 d0Var, View view, e0 e0Var) {
            this(d0Var, view);
        }

        private a(d0 d0Var, View view) {
            this.f5920a = (TextView) view.findViewById(R$id.feedbackitem_tv_question);
            this.f5921b = (TextView) view.findViewById(R$id.feedbackitem_tv_numbers);
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public void a(List<i5.t> list) {
        if (list != null) {
            this.f5919b.clear();
            this.f5919b.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5919b.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f5918a).inflate(R$layout.feedback_item, viewGroup, false);
            aVar = new a(this, view, null);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f5921b.setText((i10 + 1) + "");
        aVar.f5920a.setText(this.f5919b.get(i10).a());
        com.live.evo.util.t.c(aVar.f5921b);
        com.live.evo.util.t.c(aVar.f5920a);
        return view;
    }

    public d0(Context context) {
        this.f5918a = context;
    }
}
