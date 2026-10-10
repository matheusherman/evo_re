package com.live.evo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.widget.ProgramListView;
import com.live.evo.widget.RemoveKeyCodeEnterEditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class u0 extends f0 implements View.OnKeyListener {
    private static Map<String, i5.i> B;
    private static u0 C;
    private static com.live.evo.osd.persenter.a D;
    private static List<String> E = new ArrayList();
    private static Window F;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ProgramListView f6822g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f6825j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f6827l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f6828m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f6829n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LinearLayout f6830o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RelativeLayout f6831p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RelativeLayout f6832q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private RelativeLayout f6833r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Button f6834s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private RemoveKeyCodeEnterEditText f6835t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f6836u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f6837v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ziyi.kit.keyboard.b f6839x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View f6840y;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6821f = 262145;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private n5.h f6823h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    List<i5.z> f6824i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6826k = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f6838w = 4;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Handler f6841z = new c();
    private AdapterView.OnItemSelectedListener A = new e();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u0.this.g0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 262145) {
                return;
            }
            u0.this.h0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements AdapterView.OnItemSelectedListener {
        e() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            u0.this.f6827l.setText(String.valueOf(i10 + 1));
            if (u0.this.f6822g == null || !u0.this.f6822g.isFocused()) {
                return;
            }
            u0.this.f6823h.a(i10);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements View.OnFocusChangeListener {
        b(u0 u0Var) {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements Comparator<i5.z> {
        d(u0 u0Var) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i5.z zVar, i5.z zVar2) {
            return zVar2.d() - zVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        String string = this.f6835t.getText().toString();
        if (string.length() < this.f6838w) {
            com.live.evo.util.r1.b(getActivity(), R$string.lock_key_incorrect, 0);
            this.f6835t.requestFocus();
            return;
        }
        if (!com.live.evo.l.n().z()) {
            if (TextUtils.equals(string, "2026")) {
                com.live.evo.util.r1.b(getActivity(), R$string.adult_key_invalid, 0);
                this.f6835t.setText("");
                this.f6835t.requestFocus();
                return;
            } else {
                com.live.evo.util.r1.d(getActivity(), com.live.evo.util.x1.k(R$string.lock_key_saved, string.toString()), 1);
                com.live.evo.l.n().Q(string.toString());
                this.f6835t.setText("");
                r0();
                return;
            }
        }
        if (TextUtils.equals(string, com.live.evo.l.n().o())) {
            this.f6835t.setText("");
            r0();
        } else if (!TextUtils.equals(string, "2026")) {
            com.live.evo.util.r1.b(getActivity(), R$string.lock_key_incorrect, 0);
            this.f6835t.setText("");
            this.f6835t.requestFocus();
        } else {
            com.live.evo.util.r1.b(getActivity(), R$string.lock_key_reset_hint, 0);
            com.live.evo.l.n().Q("");
            this.f6835t.setText("");
            q0();
        }
    }

    private void i0() {
        this.f6841z.sendEmptyMessageDelayed(262145, 100L);
    }

    private void j0() {
        int i10;
        this.f6824i.clear();
        List<String> list = E;
        if (list != null && list.size() > 0) {
            List<i5.a0> listC = com.live.evo.util.b1.c("private_group");
            for (String str : E) {
                i5.i iVar = B.get(str);
                if (iVar != null && iVar.g() == 1) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= listC.size()) {
                            i10 = 0;
                            break;
                        }
                        i5.a0 a0Var = listC.get(i11);
                        if (a0Var != null && a0Var.a().equals(str)) {
                            i10 = Integer.parseInt(a0Var.b());
                            break;
                        }
                        i11++;
                    }
                    this.f6824i.add(new i5.z(iVar.h(), iVar.c(), i10, iVar.i()));
                }
            }
        }
        if (this.f6824i.size() <= 0) {
            this.f6822g.setVisibility(4);
            this.f6825j.setVisibility(0);
            return;
        }
        Collections.sort(this.f6824i, new d(this));
        this.f6822g.setVisibility(0);
        this.f6825j.setVisibility(4);
        n5.h hVar = this.f6823h;
        if (hVar != null) {
            hVar.b(this.f6824i);
            return;
        }
        n5.h hVar2 = new n5.h(getActivity(), this.f6824i);
        this.f6823h = hVar2;
        this.f6822g.setAdapter((ListAdapter) hVar2);
    }

    private void m0() {
        this.f6834s.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(AdapterView adapterView, View view, int i10, long j10) {
        com.live.evo.osd.persenter.a aVar = D;
        if (aVar != null && aVar.i() != null && D.i().p()) {
            com.live.evo.util.r1.b(getActivity(), R$string.forbid_lock_key, 1);
            return;
        }
        int i11 = 0;
        if (this.f6824i.isEmpty()) {
            com.live.evo.util.b1.e("private_group", this.f6824i.get(i10).a(), "1");
        } else {
            i5.z zVar = this.f6824i.get(i10);
            i11 = zVar.c() != 1 ? 1 : 0;
            zVar.e(i11);
            com.live.evo.util.b1.e("private_group", zVar.a(), String.valueOf(i11));
        }
        this.f6823h.notifyDataSetChanged();
        if (i11 == 1) {
            com.live.evo.util.r1.b(getActivity(), R$string.lock_key_success, 1);
        } else {
            com.live.evo.util.r1.b(getActivity(), R$string.unlock_key_success, 1);
        }
    }

    public static u0 p0(String str, com.live.evo.osd.persenter.a aVar, Window window) {
        if (C == null) {
            C = new u0();
            Bundle bundle = new Bundle();
            bundle.putString("tag", str);
            C.setArguments(bundle);
            D = aVar;
            F = window;
        }
        return C;
    }

    private void q0() {
        TextView textView = this.f6836u;
        if (textView == null) {
            return;
        }
        textView.setVisibility(4);
        if (!com.live.evo.l.n().z()) {
            this.f6835t.setHint(R$string.adult_key_pwd_hint);
            this.f6837v.setText(R$string.lock_key_first_hint);
        } else {
            this.f6835t.setHint(R$string.adult_key_pwd_hint2);
            this.f6837v.setText(com.live.evo.util.x1.j(R$string.lock_key_again_hint));
        }
    }

    private void r0() {
        this.f6825j.setVisibility(0);
        this.f6825j.requestFocus();
        if (this.f6832q.getVisibility() != 0) {
            this.f6832q.setVisibility(0);
        }
        if (this.f6833r.getVisibility() == 0) {
            this.f6833r.setVisibility(8);
        }
        List<i5.z> list = this.f6824i;
        if (list == null || list.size() <= 0) {
            this.f6825j.setVisibility(0);
            this.f6825j.requestFocus();
            this.f6822g.setVisibility(8);
        } else {
            this.f6822g.setVisibility(0);
            this.f6822g.requestFocus();
            this.f6825j.setVisibility(8);
        }
    }

    @Override // com.live.evo.fragment.f0
    protected void S(Bundle bundle) {
        E = t.v.c.i.a.f18646a.u(Boolean.TRUE);
        B = com.live.evo.util.s0.f7342a.t();
        i0();
    }

    @Override // com.live.evo.fragment.f0
    protected void T() {
        this.f6835t.setOnKeyListener(this);
        this.f6835t.setOnKeyListener(this);
        this.f6834s.setOnKeyListener(this);
        this.f6834s.setOnKeyListener(this);
        this.f6822g.setOnKeyListener(this);
        this.f6825j.setOnKeyListener(this);
        this.f6822g.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.live.evo.fragment.t0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                this.f6787a.o0(adapterView, view, i10, j10);
            }
        });
        this.f6822g.setOnFocusChangeListener(new b(this));
        m0();
    }

    @Override // com.live.evo.fragment.f0
    protected void V(View view) {
        this.f6840y = view;
        this.f6827l = (TextView) view.findViewById(R$id.duo_lockf_tv_lock_classify_current);
        this.f6828m = (TextView) view.findViewById(R$id.duo_lockf_tv_lock_classify_all);
        this.f6822g = (ProgramListView) view.findViewById(R$id.duo_lockf_lv_lock_classify);
        this.f6825j = (TextView) view.findViewById(R$id.duo_lockf_tv_no_data);
        this.f6832q = (RelativeLayout) view.findViewById(R$id.duo_lockf_rl_locklist_parent);
        this.f6833r = (RelativeLayout) view.findViewById(R$id.duo_lockf_rl_lockkey_parent);
        this.f6831p = (RelativeLayout) view.findViewById(R$id.duo_lockf_rl_parent);
        this.f6830o = (LinearLayout) view.findViewById(R$id.kidsmode_show_layout);
        this.f6829n = (TextView) view.findViewById(R$id.kidsmode_show_tv);
        this.f6829n.setText(com.live.evo.util.p1.a("kids_lock_tip", com.live.evo.util.x1.j(R$string.kidsmode_lock_tip)));
        n0(view);
        k0();
    }

    @Override // com.live.evo.fragment.f0
    public void X(boolean z10) {
        if (!z10) {
            this.f6841z.removeMessages(262145);
            return;
        }
        this.f6826k = false;
        i0();
        k0();
        l0();
    }

    public void l0() {
        ziyi.kit.keyboard.b bVarU = KeyUtils.u(F, getContext(), this.f6840y, getLifecycle(), false, false);
        this.f6839x = bVarU;
        if (bVarU != null) {
            bVarU.l(this.f6835t);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        a2 a2Var;
        if (this.f6839x != null && keyEvent.getAction() == 0 && (i10 == 23 || i10 == 66)) {
            if (view.getId() == 2131427478 && this.f6839x.getVisibility() != 0) {
                this.f6839x.m0();
                return true;
            }
        } else if (this.f6839x != null && keyEvent.getAction() == 1 && (i10 == 23 || i10 == 66)) {
            if (view.getId() == 2131427478) {
                return true;
            }
        } else if (i10 == 20 && keyEvent.getAction() == 0) {
            if (this.f6832q.getVisibility() == 0 && this.f6822g.getCount() > 0 && this.f6822g.getSelectedItemPosition() == this.f6822g.getCount() - 1) {
                this.f6822g.setSelection(0);
                return true;
            }
        } else if (i10 == 19 && keyEvent.getAction() == 0) {
            if (this.f6832q.getVisibility() == 0 && this.f6822g.getCount() > 0 && this.f6822g.getSelectedItemPosition() == 0) {
                ProgramListView programListView = this.f6822g;
                programListView.setSelection(programListView.getCount() - 1);
                return true;
            }
        } else if (i10 == 21 && keyEvent.getAction() == 0) {
            if ((!this.f6835t.hasFocus() || this.f6835t.getSelectionStart() <= 0) && (a2Var = this.f5935e) != null) {
                a2Var.D(this);
            }
        } else if (i10 == 22 && keyEvent.getAction() == 0) {
            return !this.f6835t.hasFocus() || TextUtils.isEmpty(this.f6835t.getText()) || this.f6835t.getSelectionStart() >= this.f6835t.getText().length();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        j0();
        List<String> list = E;
        if (list != null && list.size() > 0) {
            this.f6827l.setText("1");
            this.f6828m.setText("/" + E.size());
            this.f6822g.setSelection(0);
            return;
        }
        this.f6827l.setText("0");
        this.f6828m.setText("/0");
    }

    private void k0() {
        if (a5.b.a().b()) {
            this.f6830o.setVisibility(0);
            this.f6832q.setVisibility(8);
            this.f6833r.setVisibility(8);
        } else {
            this.f6830o.setVisibility(8);
            this.f6832q.setVisibility(8);
            this.f6833r.setVisibility(0);
            q0();
        }
    }

    private void n0(View view) {
        this.f6835t = (RemoveKeyCodeEnterEditText) view.findViewById(R$id.adultkeyl_et_pwd);
        this.f6834s = (Button) view.findViewById(R$id.duo_adultkey_btn_go);
        this.f6836u = (TextView) view.findViewById(R$id.duo_adultkey_tv_title);
        this.f6837v = (TextView) view.findViewById(R$id.duo_adultkey_tv_hint);
        com.live.evo.util.t.c(this.f6835t);
        com.live.evo.util.t.c(this.f6834s);
        com.live.evo.util.t.c(this.f6836u);
        com.live.evo.util.t.c(this.f6837v);
    }

    @Override // com.live.evo.fragment.f0
    protected int R() {
        return R$layout.fragment_lock;
    }

    @Override // com.live.evo.fragment.f0
    public void W(boolean z10) {
        RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText;
        if (!a5.b.a().b()) {
            RelativeLayout relativeLayout = this.f6833r;
            if (relativeLayout != null && relativeLayout.getVisibility() == 0 && (removeKeyCodeEnterEditText = this.f6835t) != null) {
                removeKeyCodeEnterEditText.requestFocus();
                l0();
                return;
            }
            n5.h hVar = this.f6823h;
            if (hVar != null && hVar.getCount() != 0) {
                ProgramListView programListView = this.f6822g;
                if (programListView != null) {
                    programListView.requestFocus();
                    return;
                }
                return;
            }
            TextView textView = this.f6825j;
            if (textView != null) {
                textView.requestFocus();
            }
        }
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
