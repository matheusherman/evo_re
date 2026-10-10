package com.live.evo.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.widget.ProgramListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a0 extends f0 implements View.OnKeyListener {
    private static a0 B;
    private static List<i5.h> C = new ArrayList();
    private static List<i5.h> D = new ArrayList();
    private static com.live.evo.osd.persenter.a E;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ProgramListView f5839j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f5841l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f5843n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private RelativeLayout f5844o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RelativeLayout f5845p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f5846q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f5847r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f5848s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f5849t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TimerTask f5851v;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final q6.b f5835f = q6.c.d(a0.class);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5836g = "FavoriteFragment";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f5837h = 262145;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f5838i = 262146;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private n5.c f5840k = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f5842m = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Timer f5850u = new Timer();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f5852w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f5853x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private Handler f5854y = new d();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f5855z = new e();
    private Runnable A = new f();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            int i11;
            i5.h hVar = (i5.h) a0.D.get(i10);
            if (hVar.j() == 0) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            hVar.C(i11);
            a0.this.f5840k.b(hVar, i10);
            a0.this.u0(hVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            if (!z10) {
                a0.this.f5840k.a(-1);
                return;
            }
            a0.this.f5840k.a(a0.this.f5839j.getSelectedItemPosition());
            if (a0.this.f5853x) {
                a0 a0Var = a0.this;
                a0Var.w0(a0Var.f5839j.getSelectedItemPosition());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a0.this.f5854y.sendEmptyMessage(262145);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 262145:
                    a0.this.n0();
                    break;
                case 262146:
                    a0.this.v0(message.arg1);
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements AdapterView.OnItemSelectedListener {
        e() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            a0.this.f5847r.setText(String.valueOf(i10 + 1));
            if (a0.this.f5839j != null && a0.this.f5839j.isFocused()) {
                a0.this.f5840k.a(i10);
            }
            if (a0.this.f5853x) {
                a0.this.w0(i10);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.live.evo.l.n() != null && a0.this.f5852w >= 0 && a0.D != null && a0.D.size() > a0.this.f5852w) {
                i5.h hVar = (i5.h) a0.D.get(a0.this.f5852w);
                if (a0.E != null && hVar != null) {
                    a0.E.a(0, hVar.i());
                }
            }
        }
    }

    @Override // com.live.evo.fragment.f0
    public void W(boolean z10) {
        this.f5853x = true;
        ProgramListView programListView = this.f5839j;
        if (programListView != null) {
            programListView.requestFocus();
        }
    }

    @Override // com.live.evo.fragment.f0
    public void X(boolean z10) {
        RelativeLayout relativeLayout;
        if (!z10) {
            this.f5853x = false;
            TimerTask timerTask = this.f5851v;
            if (timerTask != null) {
                timerTask.cancel();
            }
            m0();
            return;
        }
        this.f5842m = false;
        if (com.live.evo.k.b().l() && (relativeLayout = this.f5844o) != null) {
            relativeLayout.setVisibility(com.live.evo.l.n().G() ? 0 : 8);
        }
        C = com.live.evo.util.s0.f7342a.C().get(t.v.c.i.a.f18646a.u(Boolean.TRUE).get(0));
        q0();
    }

    private void m0() {
        try {
            com.live.evo.osd.persenter.a aVar = E;
            if (aVar != null) {
                aVar.a(3, 1);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        this.f5846q.setText(com.live.evo.util.x1.j(R$string.all));
        p0();
        List<i5.h> list = D;
        if (list == null || list.size() <= 0) {
            this.f5847r.setText("0");
            this.f5848s.setText("/0");
            return;
        }
        this.f5847r.setText("1");
        this.f5848s.setText("/" + D.size());
        this.f5839j.setSelection(0);
    }

    private void o0() {
        TimerTask timerTask = this.f5851v;
        if (timerTask != null) {
            timerTask.cancel();
        }
        c cVar = new c();
        this.f5851v = cVar;
        this.f5850u.schedule(cVar, 100L);
    }

    private void p0() {
        D.clear();
        List<i5.h> list = C;
        if (list != null && list.size() > 0) {
            for (int i10 = 0; i10 < C.size() && !C.get(i10).p(); i10++) {
                D.add(C.get(i10));
            }
        }
        if (D.size() <= 0) {
            this.f5839j.setVisibility(4);
            this.f5841l.setVisibility(0);
            return;
        }
        this.f5839j.setVisibility(0);
        this.f5841l.setVisibility(4);
        n5.c cVar = this.f5840k;
        if (cVar != null) {
            cVar.c(D);
            return;
        }
        n5.c cVar2 = new n5.c(getContext(), D);
        this.f5840k = cVar2;
        this.f5839j.setAdapter((ListAdapter) cVar2);
    }

    private void r0() {
        if (this.f5844o == null || E == null || !com.live.evo.k.b().l() || !com.live.evo.l.n().G()) {
            return;
        }
        if (!com.live.evo.l.n().H()) {
            v0(com.live.evo.l.n().s());
        }
        E.e("FavoriteFragment");
    }

    public static a0 t0(String str, com.live.evo.osd.persenter.a aVar) {
        if (B == null) {
            B = new a0();
            Bundle bundle = new Bundle();
            bundle.putString("tag", str);
            B.setArguments(bundle);
            E = aVar;
        }
        return B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(i5.h hVar) {
        Intent intent = new Intent();
        intent.setAction("com.bb.action.FAVORITE");
        intent.putExtra("channelFavorite", hVar.j());
        intent.putExtra("channelId", hVar.b());
        intent.putExtra("channelName", hVar.e());
        t.v.c.i.a.f18646a.L0(Integer.parseInt(hVar.b()));
        if (getContext() != null) {
            getContext().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(int i10) {
        com.live.evo.osd.persenter.a aVar = E;
        if (aVar != null) {
            aVar.c("FavoriteFragment", i10);
        }
    }

    @Override // com.live.evo.fragment.f0
    protected void S(Bundle bundle) {
        C = com.live.evo.util.s0.f7342a.C().get(t.v.c.i.a.f18646a.u(Boolean.TRUE).get(0));
        if (this.f5844o != null && com.live.evo.k.b().l()) {
            this.f5844o.setVisibility(com.live.evo.l.n().G() ? 0 : 8);
        }
        q0();
    }

    @Override // com.live.evo.fragment.f0
    protected void T() {
        this.f5839j.setOnItemClickListener(new a());
        this.f5839j.setOnItemSelectedListener(this.f5855z);
        this.f5839j.setOnFocusChangeListener(new b());
        this.f5839j.setOnKeyListener(this);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (this.f5839j == null) {
            return true;
        }
        if (keyEvent.getAction() == 0) {
            if (i10 == 20) {
                if (this.f5839j.getCount() > 0 && this.f5839j.getSelectedItemPosition() == this.f5839j.getCount() - 1) {
                    this.f5839j.setSelection(0);
                    return true;
                }
            } else if (i10 == 19) {
                if (this.f5839j.getCount() > 0 && this.f5839j.getSelectedItemPosition() == 0) {
                    ProgramListView programListView = this.f5839j;
                    programListView.setSelection(programListView.getCount() - 1);
                    return true;
                }
            } else if (i10 == 21) {
                a2 a2Var = this.f5935e;
                if (a2Var != null) {
                    a2Var.D(this);
                }
            } else {
                if (i10 == 22) {
                    Z(getView());
                    return true;
                }
                if (i10 == 82 && com.live.evo.k.b().l() && this.f5839j.isFocused()) {
                    if (D.size() <= 0) {
                        return true;
                    }
                    if (!com.live.evo.l.n().G()) {
                        com.live.evo.util.r1.d(getActivity(), com.live.evo.util.x1.j(R$string.pip_not_open), 1);
                    } else if (this.f5852w >= 0) {
                        int size = D.size();
                        int i11 = this.f5852w;
                        if (size > i11) {
                            i5.h hVar = D.get(i11);
                            if (E != null && hVar != null && !hVar.p() && !hVar.q()) {
                                E.a(1, hVar.i());
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void q0() {
        o0();
        r0();
    }

    private void s0() {
        RelativeLayout relativeLayout;
        this.f5845p = (RelativeLayout) ((Activity) getContext()).findViewById(R$id.preview_container);
        if (E != null && com.live.evo.k.b().l() && (relativeLayout = this.f5844o) != null) {
            E.h("FavoriteFragment", relativeLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i10) {
        if (com.live.evo.k.b().l() && com.live.evo.l.n().G()) {
            this.f5854y.removeMessages(262146);
            this.f5852w = i10;
            Message message = new Message();
            message.what = 262146;
            message.arg1 = this.f5852w;
            this.f5854y.sendMessageDelayed(message, com.live.evo.l.n().r());
        }
    }

    @Override // com.live.evo.fragment.f0
    protected int R() {
        return R$layout.newfavorite_fragment;
    }

    @Override // com.live.evo.fragment.f0
    protected void V(View view) {
        this.f5843n = view.findViewById(R$id.favf_rl_parent);
        if (com.live.evo.l.n().j("pip_on_channel", true)) {
            this.f5844o = (RelativeLayout) view.findViewById(R$id.favf_preview_container);
        }
        this.f5846q = (TextView) view.findViewById(R$id.favf_tv_favorite_clssify_name);
        this.f5847r = (TextView) view.findViewById(R$id.favf_tv_favorite_program_current);
        this.f5848s = (TextView) view.findViewById(R$id.favf_tv_favorite_program_all);
        this.f5849t = (TextView) view.findViewById(R$id.favf_tv_favorite_program_des);
        this.f5839j = (ProgramListView) view.findViewById(R$id.favf_lv_favor);
        this.f5841l = (TextView) view.findViewById(R$id.favf_tv_no_data);
        com.live.evo.util.t.d(this.f5846q);
        com.live.evo.util.t.a(this.f5847r);
        com.live.evo.util.t.b(this.f5848s);
        com.live.evo.util.t.c(this.f5849t);
        com.live.evo.util.t.d(this.f5841l);
        s0();
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        B = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
