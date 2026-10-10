package com.live.evo.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.widget.ProgramListView;
import com.live.evo.widget.sloading.SLoadingView;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m3 extends com.live.evo.fragment.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f6481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ProgramListView f6482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f6483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f6484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f6485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SLoadingView f6486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f6487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f6488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private d0 f6489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<i5.t> f6490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f6491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f6492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f6493r = Configurator.NULL;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f6494s = Configurator.NULL;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f6495t = "rc_update_time";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            m3.this.f6483h.setVisibility(8);
            m3.this.f6484i.setVisibility(0);
            m3.this.f6486k.setVisibility(0);
            m3.this.f6488m.setVisibility(8);
            m3.this.f6485j.setVisibility(4);
            m3.this.f6487l.setText(Html.fromHtml(com.live.evo.util.x1.j(R$string.feedback_submitting)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m3.this.f6483h.setVisibility(0);
            m3.this.f6484i.setVisibility(8);
            m3.this.f6482g.requestFocus();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements Comparator<i5.t> {
        c(m3 m3Var) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i5.t tVar, i5.t tVar2) {
            return tVar.b() - tVar2.b();
        }
    }

    private void h0() {
        this.f6482g.setOnItemClickListener(new a());
        this.f6485j.setOnClickListener(new b());
    }

    private void i0() {
        this.f6482g = (ProgramListView) this.f6481f.findViewById(R$id.feedbackf_plv_feedback);
        this.f6483h = this.f6481f.findViewById(R$id.feedbackf_ll_question_parent);
        this.f6484i = this.f6481f.findViewById(R$id.feedbackf_ll_submit_view);
        this.f6485j = this.f6481f.findViewById(R$id.feedbackf_tv_ok);
        this.f6486k = (SLoadingView) this.f6481f.findViewById(R$id.feedbackf_slv);
        this.f6487l = (TextView) this.f6481f.findViewById(R$id.feedbackf_tv_remind2);
        this.f6488m = this.f6481f.findViewById(R$id.feedbackf_iv_success);
        this.f6491p = (TextView) this.f6481f.findViewById(R$id.feedbackf_tv_remind1);
        this.f6492q = (TextView) this.f6481f.findViewById(R$id.feedbackf_tv_title);
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.c(this.f6492q);
            com.live.evo.util.t.b(this.f6487l);
            com.live.evo.util.t.b(this.f6491p);
        } else {
            com.live.evo.util.t.d(this.f6492q);
            com.live.evo.util.t.b(this.f6487l);
            com.live.evo.util.t.d(this.f6491p);
        }
    }

    public void j0(String str) {
        this.f6494s = str;
    }

    public void k0(String str) {
        this.f6493r = str;
    }

    public void l0(List<i5.t> list) {
        if (list != null && !list.isEmpty()) {
            this.f6490o = list;
            Collections.sort(list, new c(this));
            this.f6489n.a(this.f6490o);
        }
        this.f6482g.setVisibility(0);
        this.f6486k.setVisibility(8);
    }

    private void l() {
        this.f6492q.setText(Html.fromHtml(com.live.evo.util.x1.j(R$string.feedback_title)));
        this.f6491p.setText(Html.fromHtml(com.live.evo.util.x1.j(R$string.feedback_remind_bottom)));
        d0 d0Var = new d0(getActivity());
        this.f6489n = d0Var;
        this.f6482g.setAdapter((ListAdapter) d0Var);
        this.f6486k.setVisibility(0);
        this.f6482g.setVisibility(4);
        this.f6491p.setVisibility(0);
        l0(com.live.evo.util.q.d().e());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6481f = layoutInflater.inflate(R$layout.feedback_fragment, viewGroup, false);
        i0();
        l();
        h0();
        return this.f6481f;
    }
}
