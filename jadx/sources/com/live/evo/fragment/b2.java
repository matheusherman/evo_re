package com.live.evo.fragment;

import android.os.Bundle;
import android.text.TextUtils;
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

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b2 extends f0 implements View.OnKeyListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static b2 f5876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static com.live.evo.osd.persenter.a f5877l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RelativeLayout f5878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ProgramListView f5879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f5880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5881i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AdapterView.OnItemClickListener f5882j = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            ListAdapter adapter;
            boolean zEquals;
            if (b2.this.f5879g == null || b2.this.f5879g.getCount() < i10 || (adapter = b2.this.f5879g.getAdapter()) == null || com.live.evo.l.n().G() == (zEquals = TextUtils.equals(adapter.getItem(i10).toString().toLowerCase(), com.live.evo.util.x1.j(R$string.on).toLowerCase()))) {
                return;
            }
            com.live.evo.l.n().R(zEquals);
            ((d2) adapter).notifyDataSetChanged();
            if (b2.f5877l == null || zEquals) {
                return;
            }
            b2.f5877l.a(2, zEquals ? 1 : 0);
        }
    }

    private void c0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, this.f5881i ? com.live.evo.util.x1.j(R$string.on).toUpperCase() : com.live.evo.util.x1.j(R$string.on));
        arrayList.add(1, this.f5881i ? com.live.evo.util.x1.j(R$string.off).toUpperCase() : com.live.evo.util.x1.j(R$string.off));
        this.f5879g.setAdapter((ListAdapter) new d2(getContext(), arrayList));
    }

    public static b2 d0(String str, com.live.evo.osd.persenter.a aVar) {
        if (f5876k == null) {
            f5876k = new b2();
            Bundle bundle = new Bundle();
            bundle.putString("tag", str);
            f5876k.setArguments(bundle);
            f5877l = aVar;
        }
        return f5876k;
    }

    private void e0() {
        ListAdapter adapter;
        ProgramListView programListView = this.f5879g;
        if (programListView == null || (adapter = programListView.getAdapter()) == null) {
            return;
        }
        ((d2) adapter).notifyDataSetChanged();
    }

    @Override // com.live.evo.fragment.f0
    protected void T() {
        this.f5879g.setOnItemClickListener(this.f5882j);
        this.f5879g.setOnKeyListener(this);
    }

    @Override // com.live.evo.fragment.f0
    public void W(boolean z10) {
        ProgramListView programListView = this.f5879g;
        if (programListView != null) {
            programListView.requestFocus();
        }
    }

    @Override // com.live.evo.fragment.f0
    public void X(boolean z10) {
        if (z10) {
            e0();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        ProgramListView programListView;
        a2 a2Var;
        if (i10 == 20 && keyEvent.getAction() == 0) {
            ProgramListView programListView2 = this.f5879g;
            return programListView2 != null && programListView2.isFocused() && this.f5879g.getSelectedItemPosition() == 1;
        }
        if (i10 == 19 && keyEvent.getAction() == 0) {
            ProgramListView programListView3 = this.f5879g;
            return programListView3 != null && programListView3.isFocused() && this.f5879g.getSelectedItemPosition() == 0;
        }
        if (i10 != 21 || keyEvent.getAction() != 0) {
            if (i10 != 22 || keyEvent.getAction() != 0 || (programListView = this.f5879g) == null) {
                return false;
            }
            programListView.requestFocus();
            return false;
        }
        ProgramListView programListView4 = this.f5879g;
        if (programListView4 == null || !programListView4.isFocused() || (a2Var = this.f5935e) == null) {
            return false;
        }
        a2Var.D(this);
        return true;
    }

    @Override // com.live.evo.fragment.f0
    protected int R() {
        return R$layout.newpipsetting_fragment;
    }

    @Override // com.live.evo.fragment.f0
    protected void V(View view) {
        this.f5878f = (RelativeLayout) view.findViewById(R$id.lly_pipsetting);
        this.f5879g = (ProgramListView) view.findViewById(R$id.pip_setting_list);
        this.f5880h = (TextView) view.findViewById(R$id.tv_choosepip_tip);
        this.f5881i = com.live.evo.l.n().j("category_is_upcase", true);
        c0();
    }

    @Override // com.live.evo.fragment.f0, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f5876k = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.live.evo.fragment.f0
    protected void S(Bundle bundle) {
    }
}
