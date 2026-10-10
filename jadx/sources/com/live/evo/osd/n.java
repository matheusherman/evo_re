package com.live.evo.osd;

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
public class n extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<i5.r> f7129b = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f7130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f7131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f7132c;

        /* synthetic */ a(n nVar, View view, o oVar) {
            this(nVar, view);
        }

        private a(n nVar, View view) {
            this.f7131b = (TextView) view.findViewById(R$id.tv_question);
            this.f7132c = (TextView) view.findViewById(R$id.tv_numbers);
            TextView textView = (TextView) view.findViewById(R$id.tv_answer);
            this.f7130a = textView;
            textView.setTypeface(com.live.evo.util.s.b());
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

    public void a(List<i5.r> list) {
        if (list != null) {
            this.f7129b.clear();
            this.f7129b.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7129b.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f7128a).inflate(R$layout.question_item, viewGroup, false);
            aVar = new a(this, view, null);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f7132c.setText((i10 + 1) + "");
        aVar.f7131b.setText(this.f7129b.get(i10).b());
        aVar.f7130a.setText(this.f7129b.get(i10).a());
        return view;
    }

    public n(Context context) {
        this.f7128a = context;
    }
}
