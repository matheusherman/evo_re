package com.live.evo.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f2 extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f5937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ProgramListView f5938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f5939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f5940i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f5941j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.live.evo.osd.n f5942k;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            f2.this.f5939h.setText((i10 + 1) + "/" + f2.this.f5941j);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            f2.this.f5939h.setText("0/" + f2.this.f5941j);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void c0() {
        this.f5938g.setOnItemSelectedListener(new a());
    }

    private void d0() {
        this.f5938g = (ProgramListView) this.f5937f.findViewById(R$id.lv_question);
        this.f5939h = (TextView) this.f5937f.findViewById(R$id.tv_cur_pos);
        this.f5940i = (TextView) this.f5937f.findViewById(R$id.tv_title);
    }

    public void e0(List<i5.r> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f5941j = list.size();
        this.f5942k.a(list);
    }

    private void l() {
        this.f5940i.setText(com.live.evo.l.n().i("feedback_faq_title", getString(R$string.feedback_faq_title_1)));
        com.live.evo.osd.n nVar = new com.live.evo.osd.n(getActivity());
        this.f5942k = nVar;
        this.f5938g.setAdapter((ListAdapter) nVar);
        e0(com.live.evo.util.q.d().c());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f5937f = layoutInflater.inflate(R$layout.question_fragment, viewGroup, false);
        d0();
        l();
        c0();
        return this.f5937f;
    }
}
