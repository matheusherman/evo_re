package com.live.evo.fragment.subjuect;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.util.q1;
import com.live.evo.util.s0;
import com.live.evo.util.x1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f6650b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, i5.h> f6654f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f6649a = q6.c.d(getClass());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<j5.c> f6651c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6652d = 0;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView f6655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6656b;

        /* JADX INFO: renamed from: com.live.evo.fragment.subjuect.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class RunnableC0099a implements Runnable {
            RunnableC0099a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                if (aVar.f6656b < c.this.getItemCount()) {
                    a aVar2 = a.this;
                    aVar2.f6655a.scrollToPosition(aVar2.f6656b);
                }
            }
        }

        a(RecyclerView recyclerView, int i10) {
            this.f6655a = recyclerView;
            this.f6656b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.notifyDataSetChanged();
            this.f6655a.post(new RunnableC0099a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6659a;

        b(int i10) {
            this.f6659a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = c.this.f6652d;
            if (i10 >= c.this.getItemCount()) {
                return;
            }
            int i11 = this.f6659a;
            if (i11 != i10) {
                c.this.notifyItemChanged(i11);
            }
            c.this.notifyItemChanged(i10);
        }
    }

    /* JADX INFO: renamed from: com.live.evo.fragment.subjuect.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public class C0100c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TextView f6661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f6662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImageView f6663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private TextView f6664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private TextView f6665e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private TextView f6666f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private TextView f6667g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private TextView f6668h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private TextView f6669i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private TextView f6670j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private ImageView f6671k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private ImageView f6672l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private LinearLayout f6673m;

        public C0100c(c cVar, View view) {
            super(view);
            this.f6661a = (TextView) view.findViewById(R$id.subject_id_tv);
            this.f6662b = (TextView) view.findViewById(R$id.subject_state_tv);
            this.f6663c = (ImageView) view.findViewById(R$id.subject_program_iv);
            this.f6664d = (TextView) view.findViewById(R$id.subject_title_tv);
            this.f6665e = (TextView) view.findViewById(R$id.subject_time_tv);
            this.f6666f = (TextView) view.findViewById(R$id.subject_score_tv);
            this.f6667g = (TextView) view.findViewById(R$id.tv_subject_score_vs);
            this.f6668h = (TextView) view.findViewById(R$id.subject_score_tv2);
            this.f6669i = (TextView) view.findViewById(R$id.subject_match_tv1);
            this.f6670j = (TextView) view.findViewById(R$id.subject_match_tv2);
            this.f6671k = (ImageView) view.findViewById(R$id.subject_match_iv1);
            this.f6672l = (ImageView) view.findViewById(R$id.subject_match_iv2);
            this.f6673m = (LinearLayout) view.findViewById(R$id.subject_item_layout);
        }
    }

    public void b(RecyclerView recyclerView, Integer num, List<j5.c> list) {
        int iIntValue = this.f6652d;
        if (num != null) {
            iIntValue = num.intValue();
        }
        this.f6651c.clear();
        this.f6651c.addAll(list);
        if (iIntValue < getItemCount()) {
            this.f6652d = iIntValue;
        }
        recyclerView.post(new a(recyclerView, iIntValue));
    }

    public void c(RecyclerView recyclerView, Integer num, Boolean bool) {
        int iIntValue = this.f6652d;
        if (num != null) {
            if (num.intValue() >= getItemCount()) {
                return;
            } else {
                iIntValue = num.intValue();
            }
        }
        if (bool != null) {
            this.f6653e = bool.booleanValue();
        }
        this.f6654f = s0.f7342a.u();
        int i10 = this.f6652d;
        if (iIntValue != i10) {
            this.f6652d = iIntValue;
            recyclerView.scrollToPosition(iIntValue);
        }
        recyclerView.post(new b(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f6651c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i10) {
        String strG;
        String strB;
        String strB2;
        int iD;
        String strE;
        C0100c c0100c = (C0100c) viewHolder;
        j5.c cVar = this.f6651c.get(i10);
        boolean zIsEmpty = TextUtils.isEmpty(cVar.a());
        if (zIsEmpty) {
            c0100c.f6661a.setText(R$string.no_channel);
            strG = "no_icon";
        } else {
            i5.h hVar = this.f6654f.get(cVar.a());
            if (hVar != null) {
                strG = hVar.g();
                iD = hVar.d() + 1;
                strE = hVar.e() == null ? "" : hVar.e();
            } else {
                iD = i10;
                strE = "";
                strG = "no_icon";
            }
            if (iD < 10) {
                c0100c.f6661a.setText("00" + iD + "  " + strE);
            } else if (iD < 100) {
                c0100c.f6661a.setText("0" + iD + "  " + strE);
            } else {
                c0100c.f6661a.setText("" + iD + "  " + strE);
            }
        }
        if (strG.equals("no_icon")) {
            com.live.evo.util.v.a(this.f6650b, R$drawable.menu_tv_icon, 2131102158, c0100c.f6663c);
        } else {
            com.live.evo.util.v.c(this.f6650b, strG, 2131102158, c0100c.f6663c);
        }
        c0100c.f6664d.setText(cVar.f());
        c0100c.f6665e.setText(String.format("%s - %s", q1.m(cVar.g(), x1.j(R$string.HHmm)), q1.m(cVar.h(), x1.j(R$string.HHmm))));
        List<j5.d> listI = cVar.i();
        if (listI == null || listI.size() == 0) {
            c0100c.f6669i.setText("——");
            c0100c.f6670j.setText("——");
            strB = "";
            strB2 = strB;
        } else {
            strB2 = listI.get(0).b();
            c0100c.f6669i.setText(listI.get(0).a());
            if (listI.size() == 1) {
                c0100c.f6670j.setText("——");
                strB = "";
            } else {
                strB = listI.get(1).b();
                c0100c.f6670j.setText(listI.get(1).a());
            }
        }
        com.live.evo.util.v.c(this.f6650b, strB2, 2131102158, c0100c.f6671k);
        com.live.evo.util.v.c(this.f6650b, strB, 2131102158, c0100c.f6672l);
        String strE2 = cVar.e();
        String strD = LocationInfo.NA;
        String strE3 = strE2 == null ? LocationInfo.NA : cVar.e();
        if (cVar.d() != null) {
            strD = cVar.d();
        }
        c0100c.f6666f.setText(strE3);
        c0100c.f6667g.setText(":");
        c0100c.f6667g.setVisibility(0);
        c0100c.f6668h.setText(strD);
        c0100c.f6668h.setVisibility(0);
        if (zIsEmpty) {
            c0100c.f6662b.setText("");
            c0100c.f6662b.setBackground(ContextCompat.getDrawable(this.f6650b, 2131102158));
        } else {
            long jB = q1.b();
            if (cVar.g() > jB) {
                if (com.live.evo.k.b().n()) {
                    if (s0.f7342a.O(new i5.p(null, cVar.c(), 0L, cVar.f(), Long.valueOf(cVar.g()), Long.valueOf(cVar.h()), cVar.b(), cVar.a() + cVar.g(), false), cVar.a())) {
                        c0100c.f6662b.setText(x1.j(2131951835));
                        c0100c.f6662b.setTextColor(ContextCompat.getColor(this.f6650b, R$color.subject_match_subsriblecancel));
                        c0100c.f6662b.setBackground(ContextCompat.getDrawable(this.f6650b, R$drawable.subject_match_subcribecancel));
                    } else {
                        c0100c.f6662b.setText(x1.j(R$string.epg_subscribe));
                        c0100c.f6662b.setTextColor(ContextCompat.getColor(this.f6650b, R$color.subject_match_subsrible));
                        c0100c.f6662b.setBackground(ContextCompat.getDrawable(this.f6650b, R$drawable.subject_match_subcribe));
                    }
                } else {
                    c0100c.f6662b.setText("");
                    c0100c.f6662b.setBackground(ContextCompat.getDrawable(this.f6650b, 2131102158));
                }
            } else if (cVar.h() >= jB) {
                c0100c.f6662b.setText(x1.j(R$string.live));
                c0100c.f6662b.setTextColor(ContextCompat.getColor(this.f6650b, R$color.subject_match_live));
                c0100c.f6662b.setBackground(ContextCompat.getDrawable(this.f6650b, R$drawable.subject_match_live));
            } else if (s0.f7342a.M(cVar.c(), cVar.a(), Long.valueOf(cVar.g()))) {
                c0100c.f6662b.setText(x1.j(2131952706));
                c0100c.f6662b.setTextColor(ContextCompat.getColor(this.f6650b, R$color.subject_match_live));
                c0100c.f6662b.setBackground(ContextCompat.getDrawable(this.f6650b, R$drawable.subject_match_live));
            } else {
                c0100c.f6662b.setText("");
                c0100c.f6662b.setBackground(ContextCompat.getDrawable(this.f6650b, 2131102158));
            }
        }
        if (this.f6652d != i10) {
            c0100c.f6673m.setBackgroundResource(2131102158);
        } else if (this.f6653e) {
            c0100c.f6673m.setBackgroundResource(R$drawable.subject_match_select);
        } else {
            c0100c.f6673m.setBackgroundResource(R$drawable.subject_match_select_not_focus);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i10) {
        return new C0100c(this, LayoutInflater.from(this.f6650b).inflate(R$layout.subject_match_item, viewGroup, false));
    }

    public c(Context context, List<j5.c> list) {
        this.f6654f = new HashMap();
        this.f6650b = context;
        this.f6651c.addAll(list);
        this.f6654f = s0.f7342a.u();
    }
}
