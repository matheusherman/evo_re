package com.live.evo.osd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.q1;
import com.live.evo.util.s0;
import com.live.evo.util.x1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f7050a = q6.c.d(b.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7051b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LayoutInflater f7053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<i5.p> f7054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7055f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f7056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f7057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextView f7058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f7059d;

        a(b bVar, View view) {
            this.f7056a = (TextView) view.findViewById(R$id.epgitem_tv_time);
            this.f7057b = (TextView) view.findViewById(R$id.epgitem_tv_name);
            this.f7058c = (TextView) view.findViewById(R$id.epgitem_tv_play);
            if (com.live.evo.util.e.b().a()) {
                com.live.evo.util.t.b(this.f7056a);
                com.live.evo.util.t.b(this.f7057b);
                com.live.evo.util.t.b(this.f7058c);
            } else {
                com.live.evo.util.t.a(this.f7056a);
                com.live.evo.util.t.b(this.f7057b);
                com.live.evo.util.t.d(this.f7058c);
            }
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return null;
    }

    public void a(List<i5.p> list, String str) {
        if (list == null) {
            this.f7054e.clear();
        } else {
            this.f7054e.clear();
            this.f7054e.addAll(list);
        }
        this.f7055f = str;
        if (this.f7054e.size() > 0) {
            notifyDataSetChanged();
        }
    }

    public void b(int i10) {
        if (this.f7051b == i10) {
            return;
        }
        this.f7051b = i10;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7054e.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        View viewInflate;
        if (view == null) {
            viewInflate = this.f7053d.inflate(R$layout.epg_item, viewGroup, false);
            aVar = new a(this, viewInflate);
            viewInflate.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
            viewInflate = view;
        }
        i5.p pVar = this.f7054e.get(i10);
        Long lF = pVar.f();
        long jLongValue = lF.longValue();
        long jLongValue2 = pVar.g().longValue();
        long jB = q1.b();
        long jF = q1.f(jB, 1);
        View view2 = viewInflate;
        aVar.f7056a.setText(String.format("%s - %s", q1.m(jLongValue, x1.j(R$string.HHmm)), q1.m(jLongValue2, x1.j(R$string.HHmm))));
        aVar.f7057b.setText(pVar.e());
        aVar.f7058c.setVisibility(0);
        if (jLongValue2 < jB) {
            if (s0.f7342a.M(pVar.b(), this.f7055f, lF)) {
                aVar.f7058c.setText(x1.j(2131952706));
            } else {
                aVar.f7058c.setVisibility(4);
            }
        } else if (jLongValue <= jB) {
            aVar.f7058c.setText(x1.j(R$string.is_playing));
        } else if (!com.live.evo.k.b().n() || jLongValue > jF) {
            aVar.f7058c.setVisibility(4);
        } else if (s0.f7342a.O(pVar, this.f7055f)) {
            aVar.f7058c.setText(x1.j(2131951835));
        } else {
            aVar.f7058c.setText(x1.j(R$string.epg_subscribe));
        }
        if (this.f7051b == i10) {
            aVar.f7059d = true;
            aVar.f7058c.setBackgroundResource(R$drawable.epg_statusfly_bg);
            return view2;
        }
        if (aVar.f7059d) {
            aVar.f7058c.setBackgroundResource(R$drawable.epg_playstatus_bg);
        }
        aVar.f7059d = false;
        return view2;
    }

    public b(Context context, List<i5.p> list, String str) {
        ArrayList arrayList = new ArrayList();
        this.f7054e = arrayList;
        this.f7055f = "";
        arrayList.clear();
        if (list != null) {
            this.f7054e.addAll(list);
        }
        this.f7055f = str;
        this.f7052c = context;
        this.f7053d = LayoutInflater.from(context);
    }
}
