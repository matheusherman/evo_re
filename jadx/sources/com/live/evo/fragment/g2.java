package com.live.evo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.live.evo.MyApplication;
import com.live.evo.R$array;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.osd.recyclerviewadapter.FocusFixedLinearLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g2 extends f0 implements View.OnKeyListener, n5.a.f {
    private static com.live.evo.osd.persenter.a E;
    private static g2 F;
    private FrameLayout A;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<i5.h> f5949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f5950h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f5952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f5953k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f5954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ImageView f5955m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RecyclerView f5956n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private EditText f5957o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f5958p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private LinearLayout f5959q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f5960r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private RecyclerView f5961s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private l5.c f5962t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private n5.g f5963u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f5964v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f5967y;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5948f = 30;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<i5.h> f5951i = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f5965w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f5966x = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f5968z = 0;
    private final int B = 1;
    private Handler C = new e();
    private Runnable D = new f();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements n5.a.e {
        a() {
        }

        @Override // n5.a.e
        public void a(int i10, Object obj) {
            String str = (String) obj;
            g2.this.f5957o.setText(String.format("%s%s", g2.this.f5958p.getText().toString().trim(), str));
            g2.this.f5958p.setText(String.format("%s%s", g2.this.f5958p.getText().toString().trim(), str));
            g2.this.f5965w = i10;
            g2.this.o0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements n5.a.g {
        b() {
        }

        @Override // n5.a.g
        public void a(View view, int i10) {
            g2.this.f5965w = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements n5.a.e {
        c() {
        }

        @Override // n5.a.e
        public void a(int i10, Object obj) {
            if (g2.this.f5951i == null || g2.this.f5951i.size() <= i10) {
                return;
            }
            int i11 = ((i5.h) g2.this.f5951i.get(i10)).i();
            if (g2.E == null) {
                return;
            }
            if (g2.E.g() != i11) {
                g2.E.o(0, i11, i11, "search");
                g2.E.hide();
                return;
            }
            String str = String.format("%03d", Integer.valueOf(i11 + 1));
            com.live.evo.util.r1.c(g2.this.getActivity(), "(" + str + ")" + com.live.evo.util.x1.j(R$string.is_playing));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements n5.a.g {
        d() {
        }

        @Override // n5.a.g
        public void a(View view, int i10) {
            if (i10 < 0 || g2.this.f5951i == null || g2.this.f5951i.size() <= i10) {
                return;
            }
            g2.this.r0(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            int i10 = message.arg1;
            if (com.live.evo.l.n() == null || g2.this.f5968z < 0 || g2.this.f5951i == null || g2.this.f5951i.size() <= g2.this.f5968z) {
                return;
            }
            i5.h hVar = (i5.h) g2.this.f5951i.get(g2.this.f5968z);
            if (g2.E == null || hVar == null) {
                return;
            }
            g2.E.a(0, hVar.i());
            g2.this.q0(i10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.live.evo.l.n() != null && g2.this.f5968z >= 0 && g2.this.f5951i != null && g2.this.f5951i.size() > g2.this.f5968z) {
                i5.h hVar = (i5.h) g2.this.f5951i.get(g2.this.f5968z);
                if (g2.E != null && hVar != null) {
                    g2.E.a(0, hVar.i());
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g2.this.f5961s.findViewHolderForAdapterPosition(0) != null) {
                g2.this.f5961s.findViewHolderForAdapterPosition(0).itemView.requestFocus();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5976a;

        h(int i10) {
            this.f5976a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g2.this.f5961s.findViewHolderForAdapterPosition(this.f5976a) != null) {
                g2.this.f5961s.findViewHolderForAdapterPosition(this.f5976a).itemView.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.f5967y = true;
        this.f5951i.clear();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strTrim = this.f5958p.getText().toString().trim();
        int size = this.f5949g.size();
        if (size < 1) {
            this.f5962t.a(null);
            this.f5964v.setVisibility(0);
            this.f5959q.setVisibility(4);
            return;
        }
        if (TextUtils.isEmpty(strTrim)) {
            this.f5962t.a(null);
            this.f5964v.setVisibility(4);
            this.f5959q.setVisibility(4);
            return;
        }
        for (int i10 = 0; i10 < size; i10++) {
            i5.h hVar = this.f5949g.get(i10);
            if (!hVar.p()) {
                String upperCase = hVar.e().replace(" ", "").toUpperCase();
                if (upperCase.startsWith(strTrim)) {
                    arrayList.add(hVar);
                } else if (upperCase.contains(strTrim)) {
                    arrayList2.add(hVar);
                }
            }
        }
        this.f5951i.addAll(arrayList);
        this.f5951i.addAll(arrayList2);
        List<i5.h> list = this.f5951i;
        if (list == null || list.isEmpty()) {
            this.f5962t.a(null);
            this.f5964v.setVisibility(0);
            this.f5959q.setVisibility(4);
            return;
        }
        this.f5964v.setVisibility(4);
        this.f5959q.setVisibility(0);
        this.f5962t.a(this.f5951i);
        this.f5962t.notifyDataSetChanged();
        this.f5960r.setText(com.live.evo.util.x1.j(2131952892) + "  " + this.f5951i.size());
        RecyclerView recyclerView = this.f5961s;
        if (recyclerView != null && recyclerView.findViewHolderForAdapterPosition(0) != null) {
            this.f5961s.findViewHolderForAdapterPosition(0).itemView.requestFocus();
        }
        this.f5961s.scrollToPosition(0);
    }

    private void l0(StringBuffer stringBuffer) {
        this.f5958p.setText(stringBuffer.toString());
        this.f5957o.setText(stringBuffer.toString());
        o0();
    }

    private String m0(View view) {
        if (view == null) {
            return "";
        }
        if (view instanceof TextView) {
            return ((TextView) view).getText().toString();
        }
        TextView textView = (TextView) view.findViewById(R$id.keyitem_tv_name);
        return textView != null ? textView.getText().toString() : "";
    }

    private void n0() {
        if (this.f5957o == null) {
            return;
        }
        ((InputMethodManager) MyApplication.a().getSystemService("input_method")).hideSoftInputFromWindow(this.f5957o.getWindowToken(), 0);
        this.f5957o.setInputType(0);
    }

    public static g2 p0(String str, com.live.evo.osd.persenter.a aVar, y1 y1Var) {
        if (F == null) {
            F = new g2();
            Bundle bundle = new Bundle();
            bundle.putString("tag", str);
            F.setArguments(bundle);
            E = aVar;
        }
        return F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i10) {
        com.live.evo.osd.persenter.a aVar = E;
        if (aVar != null) {
            aVar.c("SearchFragment", i10);
        }
    }

    @Override // com.live.evo.fragment.f0
    protected void T() {
        this.f5963u.e(new a());
        this.f5963u.g(new b());
        this.f5962t.e(new c());
        this.f5962t.g(new d());
        this.f5957o.setOnKeyListener(this);
        this.f5953k.setOnKeyListener(this);
        this.f5952j.setOnKeyListener(this);
        this.f5955m.setOnKeyListener(this);
        this.f5954l.setOnKeyListener(this);
        this.f5956n.setOnKeyListener(this);
        this.f5961s.setOnKeyListener(this);
        this.A.setOnKeyListener(this);
    }

    @Override // com.live.evo.fragment.f0
    public void W(boolean z10) {
        RecyclerView recyclerView = this.f5956n;
        if (recyclerView == null || recyclerView.findViewHolderForAdapterPosition(0) == null) {
            return;
        }
        this.f5956n.findViewHolderForAdapterPosition(0).itemView.requestFocus();
    }

    @Override // com.live.evo.fragment.f0
    public void X(boolean z10) {
        if (!z10) {
            this.f5957o.setText("");
            this.f5958p.setText("");
            this.f5959q.setVisibility(4);
            this.f5964v.setVisibility(4);
            this.f5967y = false;
        }
        this.f5949g = com.live.evo.util.s0.f7342a.w();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        a2 a2Var;
        boolean zContains = true;
        if (i10 == 19 && view.getId() == 2131429283) {
            return true;
        }
        if (keyEvent.getAction() == 1) {
            if (i10 == 66 || i10 == 23) {
                switch (view.getId()) {
                    case R$id.searchchannelf_tv_clear /* 2131429291 */:
                        this.f5957o.setText("");
                        this.f5958p.setText("");
                        o0();
                        break;
                    case R$id.searchchannelf_tv_delete /* 2131429292 */:
                        CharSequence text = this.f5958p.getText();
                        if (text != null && text.length() > 0) {
                            CharSequence charSequenceSubSequence = text.subSequence(0, text.length() - 1);
                            this.f5958p.setText(charSequenceSubSequence);
                            this.f5957o.setText(charSequenceSubSequence);
                        }
                        o0();
                        break;
                    case R$id.searchchannelf_tv_y /* 2131429296 */:
                        this.f5957o.setText(String.format("%sY", this.f5958p.getText()));
                        TextView textView = this.f5958p;
                        textView.setText(String.format("%sY", textView.getText()));
                        o0();
                        break;
                    case R$id.searchchannelf_tv_z /* 2131429297 */:
                        this.f5957o.setText(String.format("%sZ", this.f5958p.getText()));
                        TextView textView2 = this.f5958p;
                        textView2.setText(String.format("%sZ", textView2.getText()));
                        o0();
                        break;
                }
            } else {
                k0(i10, keyEvent);
            }
        }
        if (keyEvent.getAction() == 0) {
            if (i10 == 67) {
                String string = this.f5958p.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    CharSequence charSequenceSubSequence2 = string.subSequence(0, string.length() - 1);
                    this.f5958p.setText(charSequenceSubSequence2);
                    this.f5957o.setText(charSequenceSubSequence2);
                    o0();
                }
            } else if (i10 != 82) {
                switch (i10) {
                    case 19:
                        if (view.getId() == 2131428363 || view.getId() == 2131428362) {
                            if ("ABCDEF".contains(m0(view))) {
                                return true;
                            }
                        } else if (view.getId() == 2131429289 || view.getId() == 2131429301) {
                            int size = this.f5951i.size();
                            if (size <= 1) {
                                return true;
                            }
                            if (this.f5961s.findViewHolderForAdapterPosition(0) != null && this.f5961s.findViewHolderForAdapterPosition(0).itemView.isFocused()) {
                                this.f5961s.postDelayed(new h(size - 1), 0L);
                                return true;
                            }
                        } else if ((view.getId() == 2131429292 || view.getId() == 2131429296 || view.getId() == 2131429297) && this.f5956n.findViewHolderForAdapterPosition(this.f5965w) != null) {
                            this.f5956n.findViewHolderForAdapterPosition(this.f5965w).itemView.requestFocus();
                            return true;
                        }
                        break;
                    case 20:
                        if (view.getId() == 2131429292 || view.getId() == 2131429296 || view.getId() == 2131429297 || view.getId() == 2131429291) {
                            view.requestFocus();
                            view.setFocusable(true);
                            return true;
                        }
                        if (view.getId() == 2131428363 || view.getId() == 2131428362) {
                            String strM0 = m0(view);
                            if ("ST".contains(strM0)) {
                                this.f5955m.requestFocus();
                                this.f5955m.setFocusable(true);
                                return true;
                            }
                            if ("WX".contains(strM0)) {
                                this.f5954l.requestFocus();
                                this.f5954l.setFocusable(true);
                                return true;
                            }
                            if ("U".contains(strM0)) {
                                this.f5953k.requestFocus();
                                this.f5953k.setFocusable(true);
                                return true;
                            }
                        } else if (view.getId() == 2131429289 || view.getId() == 2131429301) {
                            int size2 = this.f5951i.size();
                            if (size2 <= 1) {
                                return true;
                            }
                            int i11 = size2 - 1;
                            if (this.f5961s.findViewHolderForAdapterPosition(i11) != null && this.f5961s.findViewHolderForAdapterPosition(i11).itemView.isFocused()) {
                                this.f5961s.postDelayed(new g(), 0L);
                                return true;
                            }
                        }
                        break;
                    case 21:
                        if (view.getId() == 2131428363 || view.getId() == 2131428362) {
                            zContains = "AGMS".contains(m0(view));
                        } else if (view.getId() != 2131429292) {
                            if (view.getId() == 2131429289 || view.getId() == 2131429301) {
                                if (this.f5956n.findViewHolderForAdapterPosition(this.f5965w) != null) {
                                    this.f5956n.findViewHolderForAdapterPosition(this.f5965w).itemView.requestFocus();
                                } else {
                                    this.f5954l.requestFocus();
                                    this.f5954l.setFocusable(true);
                                }
                                return true;
                            }
                            view.getId();
                            zContains = false;
                        }
                        if (zContains && (a2Var = this.f5935e) != null) {
                            a2Var.D(this);
                        }
                        break;
                    case 22:
                        if (view.getId() == 2131429289 || view.getId() == 2131429301) {
                            Z(this.f5959q);
                        } else if (view.getId() == 2131429291) {
                            if (TextUtils.isEmpty(this.f5957o.getText())) {
                                this.f5954l.requestFocus();
                                return true;
                            }
                            this.f5961s.requestFocus();
                            return true;
                        }
                        break;
                    default:
                        if (view.getId() == 2131429291) {
                            this.f5965w = 100;
                        }
                        break;
                }
            } else if ((com.live.evo.k.b().l() && view.getId() == 2131429289) || view.getId() == 2131429301) {
                if (this.f5951i.size() <= 0) {
                    return true;
                }
                if (com.live.evo.l.n().G()) {
                    i5.h hVar = this.f5951i.get(this.f5968z);
                    if (E != null && hVar != null && !hVar.p()) {
                        E.a(1, hVar.i());
                    }
                } else {
                    com.live.evo.util.r1.d(getActivity(), com.live.evo.util.x1.j(R$string.pip_not_open), 1);
                }
                return true;
            }
        }
        return false;
    }

    @Override // n5.a.f
    public boolean v(View view, int i10, KeyEvent keyEvent) {
        if (i10 == 21 && keyEvent.getAction() == 0) {
            if ("AGMS".contains(m0(view))) {
                a2 a2Var = this.f5935e;
                if (a2Var != null) {
                    a2Var.D(this);
                }
                return true;
            }
        } else if (i10 == 19 && keyEvent.getAction() == 0) {
            if ("ABCDEF".contains(m0(view))) {
                return true;
            }
        } else if (i10 != 66 && i10 != 23 && keyEvent.getAction() == 1) {
            if (i10 == 67) {
                String string = this.f5958p.getText().toString();
                if (!TextUtils.isEmpty(string)) {
                    CharSequence charSequenceSubSequence = string.subSequence(0, string.length() - 1);
                    this.f5958p.setText(charSequenceSubSequence);
                    this.f5957o.setText(charSequenceSubSequence);
                    o0();
                }
            } else {
                k0(i10, keyEvent);
            }
        }
        return false;
    }

    private void k0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            StringBuffer stringBuffer = new StringBuffer(this.f5958p.getText());
            if (i10 >= 29 && i10 <= 54) {
                stringBuffer.append((char) (i10 + 36));
                l0(stringBuffer);
            } else if (i10 >= 7 && i10 <= 16) {
                stringBuffer.append(i10 - 7);
                l0(stringBuffer);
            } else if (i10 >= 144 && i10 <= 153) {
                stringBuffer.append(i10 - 144);
                l0(stringBuffer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(int i10) {
        if (com.live.evo.k.b().l() && com.live.evo.l.n().G()) {
            this.f5968z = i10;
            Message message = new Message();
            message.what = 1;
            message.arg1 = this.f5968z;
            this.C.removeCallbacks(this.D);
            this.C.postDelayed(this.D, com.live.evo.l.n().r());
        }
    }

    @Override // com.live.evo.fragment.f0
    protected int R() {
        return R$layout.newsearch_channel_fragment;
    }

    @Override // com.live.evo.fragment.f0
    protected void S(Bundle bundle) {
        this.f5950h = getResources().getStringArray(R$array.key);
        this.f5949g = com.live.evo.util.s0.f7342a.w();
        this.f5956n.setLayoutManager(new GridLayoutManager((Context) getActivity(), 6, 1, false));
        this.f5956n.addItemDecoration(new n5.e(6, 15, true, 0));
        this.f5956n.setItemAnimator(null);
        n5.g gVar = new n5.g(getActivity(), this.f5950h);
        this.f5963u = gVar;
        this.f5956n.setAdapter(gVar);
        this.f5963u.a(Arrays.asList(this.f5950h));
        this.f5963u.f(this);
        this.f5961s.setLayoutManager(new FocusFixedLinearLayoutManager(getActivity(), 1, false));
        this.f5961s.setItemAnimator(null);
        l5.c cVar = new l5.c(getActivity());
        this.f5962t = cVar;
        this.f5961s.setAdapter(cVar);
    }

    @Override // com.live.evo.fragment.f0
    protected void V(View view) {
        this.A = (FrameLayout) view.findViewById(R$id.searchchannelf_fl_key);
        this.f5955m = (ImageView) view.findViewById(R$id.searchchannelf_tv_delete);
        this.f5954l = (TextView) view.findViewById(R$id.searchchannelf_tv_clear);
        this.f5953k = (TextView) view.findViewById(R$id.searchchannelf_tv_y);
        this.f5952j = (TextView) view.findViewById(R$id.searchchannelf_tv_z);
        this.f5956n = (RecyclerView) view.findViewById(R$id.searchchannelf_rv_key);
        this.f5957o = (EditText) view.findViewById(R$id.searchchannelf_et_showkey);
        this.f5958p = (TextView) view.findViewById(R$id.searchchannelf_tv_showkey);
        this.f5959q = (LinearLayout) view.findViewById(R$id.searchchannelf_ll_channel_layout);
        this.f5960r = (TextView) view.findViewById(R$id.searchchannelf_tv_search_num);
        this.f5961s = (RecyclerView) view.findViewById(R$id.searchchannelf_rv_channel);
        this.f5964v = (TextView) view.findViewById(R$id.searchchannelf_tv_no_related);
        n0();
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.b(this.f5957o);
            com.live.evo.util.t.b(this.f5958p);
            com.live.evo.util.t.b(this.f5953k);
            com.live.evo.util.t.b(this.f5952j);
            com.live.evo.util.t.b(this.f5960r);
            com.live.evo.util.t.b(this.f5964v);
            com.live.evo.util.t.b(this.f5954l);
            return;
        }
        com.live.evo.util.t.d(this.f5957o);
        com.live.evo.util.t.d(this.f5958p);
        com.live.evo.util.t.d(this.f5953k);
        com.live.evo.util.t.d(this.f5952j);
        com.live.evo.util.t.b(this.f5960r);
        com.live.evo.util.t.c(this.f5964v);
        com.live.evo.util.t.d(this.f5954l);
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        F = null;
    }
}
