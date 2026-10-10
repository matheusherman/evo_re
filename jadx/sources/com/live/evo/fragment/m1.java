package com.live.evo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.live.evo.R$dimen;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.widget.ProgramListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m1 extends f0 implements View.OnKeyListener {
    private static m1 A;
    private static com.live.evo.osd.persenter.a B;
    private static com.live.evo.osd.q C;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ProgramListView f6455h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f6457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f6458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f6459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f6460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ImageView f6461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f6462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f6463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f6464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f6465r;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6453f = 327681;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f6454g = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private n5.j f6456i = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<i5.v> f6466s = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f6467t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Handler f6468u = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f6469v = new b();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private AdapterView.OnItemClickListener f6470w = new c();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private AdapterView.OnItemLongClickListener f6471x = new d();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View.OnFocusChangeListener f6472y = new e();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private AbsListView.OnScrollListener f6473z = new f();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 327681) {
                return;
            }
            m1.this.j0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (m1.this.f6466s == null || m1.this.f6466s.size() <= i10 || view == null || !m1.this.f6467t) {
                return;
            }
            m1 m1Var = m1.this;
            m1Var.m0(m1Var.f6455h.getSelectedView(), i10);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (m1.this.f6466s == null || m1.this.f6466s.size() <= i10) {
                return;
            }
            i5.v vVar = (i5.v) m1.this.f6466s.get(i10);
            if (!vVar.i()) {
                if (vVar.h() != 1 && vVar.h() == 2) {
                    com.live.evo.util.b.c(m1.this.getActivity(), vVar.o());
                    return;
                }
                return;
            }
            m1.this.f6466s.remove(vVar);
            if (m1.this.f6466s.size() <= 0) {
                if (m1.this.f6459l != null && m1.this.f6459l.getVisibility() != 0) {
                    m1.this.f6459l.setVisibility(0);
                    m1.this.f6459l.requestFocus();
                }
                if (m1.this.f6460m != null && m1.this.f6460m.getVisibility() == 0) {
                    m1.this.f6460m.setVisibility(8);
                }
                if (m1.this.f6455h != null && m1.this.f6455h.getVisibility() == 0) {
                    m1.this.f6455h.setVisibility(8);
                }
            } else if (m1.this.f6466s.size() <= 5 && m1.this.f6457j != null && m1.this.f6457j.getVisibility() == 0) {
                m1.this.f6457j.setVisibility(8);
            }
            m1.this.f6456i.a(m1.this.f6466s);
            if (m1.this.f6466s.size() > 0) {
                m1 m1Var = m1.this;
                m1Var.m0(m1Var.f6455h.getSelectedView(), m1.this.f6455h.getSelectedItemPosition());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements AdapterView.OnItemLongClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            if (m1.this.f6466s != null && m1.this.f6466s.size() > i10) {
                i5.v vVar = (i5.v) m1.this.f6466s.get(i10);
                vVar.r(!vVar.p());
                m1.this.f6456i.notifyDataSetChanged();
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements View.OnFocusChangeListener {
        e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (z10 && m1.this.f6467t) {
                int selectedItemPosition = m1.this.f6455h.getSelectedItemPosition();
                m1 m1Var = m1.this;
                m1Var.m0(m1Var.f6455h.getSelectedView(), selectedItemPosition);
            } else {
                if (z10 || m1.this.f6460m.getVisibility() != 0) {
                    return;
                }
                m1.this.f6460m.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements AbsListView.OnScrollListener {
        f() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            if (m1.this.f6455h.getLastVisiblePosition() == i12 - 1) {
                if (m1.this.f6457j == null || m1.this.f6457j.getVisibility() != 0) {
                    return;
                }
                m1.this.f6457j.setBackgroundResource(R$drawable.arrow_down_disenabled);
                return;
            }
            if (m1.this.f6457j == null || m1.this.f6457j.getVisibility() != 0) {
                return;
            }
            m1.this.f6457j.setBackgroundResource(R$drawable.arrow_down);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    @Override // com.live.evo.fragment.f0
    public void W(boolean z10) {
        List<i5.v> list;
        this.f6467t = true;
        if (this.f6455h == null || (list = this.f6466s) == null || list.size() <= 0) {
            return;
        }
        this.f6455h.requestFocus();
        this.f6455h.setSelection(0);
    }

    @Override // com.live.evo.fragment.f0
    public void X(boolean z10) {
        if (z10) {
            this.f6468u.sendEmptyMessageDelayed(327681, 100L);
            this.f6467t = false;
            return;
        }
        View view = this.f6460m;
        if (view != null && view.getVisibility() == 0) {
            this.f6460m.setVisibility(8);
        }
        l0();
        this.f6467t = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        ProgramListView programListView;
        List<i5.v> list = this.f6466s;
        if (list != null) {
            list.clear();
        } else {
            this.f6466s = new ArrayList();
        }
        this.f6466s.addAll(com.live.evo.util.s0.f7342a.F());
        if (this.f6456i == null) {
            this.f6456i = new n5.j(getActivity(), this.f6466s);
        }
        n5.j jVar = this.f6456i;
        if (jVar != null && (programListView = this.f6455h) != null) {
            programListView.setAdapter((ListAdapter) jVar);
        }
        ImageView imageView = this.f6457j;
        if (imageView != null) {
            imageView.setVisibility(this.f6466s.size() > 5 ? 0 : 8);
        }
        this.f6459l.setText(com.live.evo.util.x1.j(R$string.not_data));
        this.f6459l.setVisibility(this.f6466s.size() <= 0 ? 0 : 8);
        this.f6455h.setVisibility(this.f6466s.size() > 0 ? 0 : 8);
    }

    public static m1 k0(String str, com.live.evo.osd.persenter.a aVar, com.live.evo.osd.q qVar) {
        if (A == null) {
            A = new m1();
            Bundle bundle = new Bundle();
            bundle.putString("tag", str);
            A.setArguments(bundle);
            B = aVar;
            C = qVar;
        }
        return A;
    }

    private void l0() {
        List<i5.v> list = this.f6466s;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<i5.v> it = this.f6466s.iterator();
        while (it.hasNext()) {
            it.next().r(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(View view, int i10) {
        List<i5.v> list = this.f6466s;
        if (list == null || list.size() <= i10 || view == null) {
            return;
        }
        i5.v vVar = this.f6466s.get(i10);
        if (vVar.f() == 0) {
            vVar.q(1);
            this.f6456i.a(this.f6466s);
            com.live.evo.osd.q qVar = C;
            if (qVar != null) {
                qVar.a("Message");
            }
        }
        if (this.f6460m.getVisibility() != 0) {
            this.f6460m.setVisibility(0);
        }
        this.f6462o.setText(vVar.g());
        this.f6463p.setText(vVar.c());
        String strM = com.live.evo.util.q1.m(vVar.n(), com.live.evo.util.x1.j(R$string.ddMMyyyy));
        String strM2 = com.live.evo.util.q1.m(vVar.n(), com.live.evo.util.x1.j(R$string.HHmm));
        this.f6464q.setText(strM2 + "  " + strM);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R$dimen.normal_dialog_padding);
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R$dimen.info_bg_width);
        this.f6460m.setTranslationY((float) dimensionPixelOffset);
        this.f6460m.setTranslationX((float) dimensionPixelOffset2);
        this.f6460m.requestLayout();
    }

    @Override // com.live.evo.fragment.f0
    protected void S(Bundle bundle) {
        this.f6468u.sendEmptyMessageDelayed(327681, 100L);
    }

    @Override // com.live.evo.fragment.f0
    protected void T() {
        this.f6455h.setOnItemSelectedListener(this.f6469v);
        this.f6455h.setOnItemClickListener(this.f6470w);
        this.f6455h.setOnItemLongClickListener(this.f6471x);
        this.f6455h.setOnFocusChangeListener(this.f6472y);
        this.f6455h.setOnScrollListener(this.f6473z);
        this.f6455h.setNextFocusUpId(R$id.lv_message);
        this.f6455h.setNextFocusDownId(R$id.lv_message);
        this.f6455h.setOnKeyListener(this);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (i10 == 20 && keyEvent.getAction() == 0) {
            List<i5.v> list = this.f6466s;
            return list == null || list.size() <= 0;
        }
        if (i10 == 19 && keyEvent.getAction() == 0) {
            List<i5.v> list2 = this.f6466s;
            return list2 == null || list2.size() <= 0;
        }
        if (i10 != 21 || keyEvent.getAction() != 0) {
            if (i10 != 22) {
                return false;
            }
            keyEvent.getAction();
            return false;
        }
        a2 a2Var = this.f5935e;
        if (a2Var == null) {
            return false;
        }
        a2Var.D(this);
        return false;
    }

    @Override // com.live.evo.fragment.f0
    protected int R() {
        return R$layout.newmessage_fragment;
    }

    @Override // com.live.evo.fragment.f0
    protected void V(View view) {
        this.f6455h = (ProgramListView) view.findViewById(R$id.lv_message);
        this.f6457j = (ImageView) view.findViewById(R$id.iv_down);
        this.f6458k = (TextView) view.findViewById(R$id.tv_message_tip);
        this.f6459l = (TextView) view.findViewById(R$id.tv_message_nodata);
        this.f6460m = view.findViewById(R$id.message_desc_parent);
        this.f6461n = (ImageView) view.findViewById(R$id.iv_message_logo);
        this.f6462o = (TextView) view.findViewById(R$id.tv_message_title);
        this.f6463p = (TextView) view.findViewById(R$id.tv_message_content);
        this.f6464q = (TextView) view.findViewById(R$id.tv_message_time);
        this.f6465r = (TextView) view.findViewById(R$id.tv_message_from);
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        A = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
