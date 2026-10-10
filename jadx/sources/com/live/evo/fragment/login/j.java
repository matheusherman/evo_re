package com.live.evo.fragment.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.activity.LiveNewActivity;
import com.live.evo.fragment.l3;
import com.live.evo.fragment.y1;
import com.live.evo.util.q1;
import com.live.evo.util.u1;
import com.live.evo.util.x1;
import x1.f1.lb.util.w0;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j extends DialogFragment implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final q6.b f6218h = q6.c.d(j.class);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static j f6219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f6220j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f6221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RelativeLayout f6222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.live.evo.osd.a f6223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.live.evo.dialog.m f6224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6225e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f6226f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f6227g = null;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements e5.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f6229b;

        a(int i10, Fragment fragment) {
            this.f6228a = i10;
            this.f6229b = fragment;
        }

        @Override // e5.h
        public void a(Fragment fragment) {
            if (this.f6229b == null) {
                j.this.dismiss();
                return;
            }
            j.this.c0().beginTransaction().hide(fragment).show(this.f6229b).commitAllowingStateLoss();
            Fragment fragment2 = this.f6229b;
            if (fragment2 instanceof com.live.evo.fragment.login.g) {
                ((com.live.evo.fragment.login.g) fragment2).f0();
            }
        }

        @Override // e5.h
        public void b(Fragment fragment) {
            j.this.c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
            if (this.f6228a != 3) {
                j.this.r0(3);
                return;
            }
            if (this.f6229b != null) {
                j.this.c0().beginTransaction().hide(this.f6229b).commitAllowingStateLoss();
            }
            j.this.r0(8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements com.live.evo.fragment.login.h.b {
        b() {
        }

        @Override // com.live.evo.fragment.login.h.b
        public void a(Fragment fragment) {
            if (j.this.f6223c != null) {
                j.this.f6223c.e();
            }
            j.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements com.live.evo.fragment.login.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f6232a;

        c(Fragment fragment) {
            this.f6232a = fragment;
        }

        @Override // com.live.evo.fragment.login.k
        public void a(Fragment fragment) {
            j.this.c0().beginTransaction().show(this.f6232a).hide(fragment).commitAllowingStateLoss();
        }

        @Override // com.live.evo.fragment.login.k
        public void b(Fragment fragment) {
            j.this.r0(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements com.live.evo.fragment.login.g.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f6234a;

        d(Fragment fragment) {
            this.f6234a = fragment;
        }

        @Override // com.live.evo.fragment.login.g.f
        public void a(Fragment fragment) {
            if (this.f6234a != null) {
                j.this.c0().beginTransaction().hide(fragment).show(this.f6234a).commitAllowingStateLoss();
                return;
            }
            if (fragment != null) {
                j.this.c0().beginTransaction().remove(fragment).commitAllowingStateLoss();
            }
            j.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e implements com.live.evo.fragment.login.f.a {
        e() {
        }

        @Override // com.live.evo.fragment.login.f.a
        public void a(Fragment fragment, int i10) {
            if (i10 == 0) {
                if (j.this.f6223c != null) {
                    j.this.f6223c.c();
                }
            } else {
                if (i10 == 2) {
                    w0.f21452a.t("deviceuser_no_tip_bind", "true");
                }
                if (fragment != null) {
                    j.this.c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
                }
                j.this.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements com.live.evo.fragment.login.i {
        f() {
        }

        @Override // com.live.evo.fragment.login.i
        public void a(Fragment fragment) {
            j.this.c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
            j.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g implements com.live.evo.dialog.n {
        g() {
        }

        @Override // com.live.evo.dialog.n
        public void a() {
            if (j.this.f6223c != null) {
                j.this.f6223c.a();
            }
            j.f6220j = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h implements e5.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f6239a;

        h(Fragment fragment) {
            this.f6239a = fragment;
        }

        @Override // e5.c
        public void a(Fragment fragment) {
            if (fragment != null) {
                j.this.c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
            }
            if (this.f6239a != null) {
                j.this.c0().beginTransaction().show(this.f6239a).commitAllowingStateLoss();
            } else {
                j.this.dismiss();
            }
        }

        @Override // e5.c
        public void b(Fragment fragment) {
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            if (!aVar.r().isEmpty() && aVar.Z().isEmpty()) {
                j.this.getChildFragmentManager().beginTransaction().hide(fragment).commitAllowingStateLoss();
                j.this.A0(42, aVar.r());
            } else {
                j.this.dismiss();
                if (j.this.f6223c != null) {
                    j.this.f6223c.c();
                }
            }
        }

        @Override // e5.c
        public void c(Fragment fragment) {
            j.this.c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
            j.this.A0(40, t.v.c.i.a.f18646a.r());
        }

        @Override // e5.c
        public void d(Fragment fragment) {
            j.this.x0(fragment, !t.v.c.i.a.f18646a.l0() ? 1 : 2, false, false, null);
        }

        @Override // e5.c
        public void e(Fragment fragment, i5.a aVar) {
            j.this.B0(fragment, aVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class i implements y1 {
        i() {
        }

        @Override // com.live.evo.fragment.y1
        public void b() {
            j.this.dismissAllowingStateLoss();
        }

        @Override // com.live.evo.fragment.y1
        public void c() {
            j.this.dismissAllowingStateLoss();
        }

        @Override // com.live.evo.fragment.y1
        public void a(int i10) {
        }
    }

    /* JADX INFO: renamed from: com.live.evo.fragment.login.j$j, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0079j implements r.c {
        C0079j() {
        }

        @Override // com.live.evo.fragment.login.r.c
        public void a(Fragment fragment) {
            j.this.getChildFragmentManager().beginTransaction().hide(fragment).commitAllowingStateLoss();
            j.this.s0(false, 3);
        }

        @Override // com.live.evo.fragment.login.r.c
        public void b(Fragment fragment) {
            j.this.q0(fragment);
        }

        @Override // com.live.evo.fragment.login.r.c
        public void c(Fragment fragment) {
            j.this.dismiss();
            if (j.this.f6223c != null) {
                j.this.f6223c.c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class k implements e5.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentManager f6243a;

        k(FragmentManager fragmentManager) {
            this.f6243a = fragmentManager;
        }

        @Override // e5.j
        public void a(Fragment fragment) {
            this.f6243a.beginTransaction().hide(fragment).commitAllowingStateLoss();
            j.this.s0(false, 0);
        }

        @Override // e5.j
        public void b(Fragment fragment) {
            this.f6243a.beginTransaction().hide(fragment).commitAllowingStateLoss();
            j.this.r0(6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class l implements e5.f {
        @Override // e5.f
        public void a(Fragment fragment) {
            j.f6220j = false;
            j.this.f6223c.b();
            j.this.dismiss();
        }

        @Override // e5.f
        public void c(Fragment fragment, int i10) {
            j.f6220j = false;
            j.this.c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
            j.this.t0(true, i10, fragment);
        }

        l() {
        }

        @Override // e5.f
        public void b(Fragment fragment) {
            if (!com.live.evo.a.f5188h) {
                j.f6220j = false;
                j.this.v0(fragment);
            } else {
                j.this.c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
                if (j.this.f6223c != null) {
                    j.this.f6223c.a();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class m implements com.live.evo.fragment.login.k {
        m() {
        }

        @Override // com.live.evo.fragment.login.k
        public void b(Fragment fragment) {
            j.this.c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
            j.this.u0();
        }

        @Override // com.live.evo.fragment.login.k
        public void a(Fragment fragment) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class n implements com.live.evo.fragment.login.i {
        n() {
        }

        @Override // com.live.evo.fragment.login.i
        public void a(Fragment fragment) {
            j.this.c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
            j.this.dismiss();
            if (j.this.f6223c != null) {
                j.this.f6223c.e();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class o implements com.live.evo.fragment.login.i {
        o() {
        }

        @Override // com.live.evo.fragment.login.i
        public void a(Fragment fragment) {
            j.this.c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
            j.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(boolean z10, int i10) {
        t0(z10, i10, null);
    }

    private void y0() {
        x0(null, 1, false, false, null);
    }

    private boolean d0() {
        Boolean bool = this.f6227g;
        if (bool != null) {
            return bool.booleanValue();
        }
        return t.v.c.i.a.f18646a.I() > u1.b().a();
    }

    private static j e0() {
        j jVar = f6219i;
        if (jVar != null && jVar.getDialog() != null && f6219i.getDialog().isShowing()) {
            f6219i.dismiss();
        }
        j jVar2 = new j();
        f6219i = jVar2;
        return jVar2;
    }

    private void f0() {
        this.f6222b = (RelativeLayout) this.f6221a.findViewById(R$id.rechargedlg_rl_parent);
    }

    public static void g0(FragmentManager fragmentManager, int i10, com.live.evo.osd.a aVar) {
        h0(fragmentManager, i10, Boolean.TRUE, aVar);
    }

    private void k0() {
        if (com.live.evo.a.f5188h) {
            dismiss();
        } else {
            com.live.evo.fragment.login.f.e0(c0(), R$id.rechargedlg_rl_parent, new e());
        }
    }

    private void m0() {
        if (t.v.c.i.a.f18646a.Z().isEmpty()) {
            y0();
        } else {
            w0();
        }
    }

    private void n0() {
        int i10;
        String str;
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        long jU = aVar.U();
        long jI = aVar.I();
        long jA = u1.b().a();
        boolean z10 = aVar.a0() && !aVar.l0() && aVar.Z().isEmpty();
        long j10 = jI - jA;
        String str2 = "";
        if (j10 > jU && jI > jA) {
            i10 = z10 ? 5 : -1;
        } else if (jI <= jA || j10 > jU) {
            i10 = 4;
        } else {
            int iJ = q1.j(jA, jI);
            if (iJ <= 1) {
                str = iJ + " " + x1.j(R$string.hour);
            } else {
                str = iJ + " " + x1.j(R$string.hours);
            }
            str2 = str;
            i10 = 1;
        }
        if (i10 == -1) {
            dismiss();
            com.live.evo.osd.a aVar2 = this.f6223c;
            if (aVar2 != null) {
                aVar2.e();
                return;
            }
            return;
        }
        if (f6220j) {
            dismiss();
            return;
        }
        f6220j = true;
        if (z10) {
            p0(i10, str2);
        } else {
            i0(i10, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(Fragment fragment) {
        com.live.evo.fragment.login.g.g0(t.v.c.i.a.f18646a.Z(), getDialog().getWindow(), c0(), R$id.rechargedlg_rl_parent, new d(fragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(boolean z10, int i10, Fragment fragment) {
        if (com.live.evo.a.f5188h) {
            dismiss();
        } else {
            e5.b.a(c0(), getDialog().getWindow(), R$id.rechargedlg_rl_parent, z10, "", i10, new h(fragment));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Fragment fragment, int i10, boolean z10, boolean z11, i5.a aVar) {
        if (fragment != null) {
            c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
        }
        e5.g.a(c0(), getDialog().getWindow(), R$id.rechargedlg_rl_parent, i10, z10, z11, aVar, new a(i10, fragment));
    }

    private void z0() {
        l3.INSTANCE.f(c0(), getDialog().getWindow(), R$id.rechargedlg_rl_parent, new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int i10, String str) {
        r.b0(c0(), R$id.rechargedlg_rl_parent, str, i10, new C0079j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Fragment fragment, i5.a aVar) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        if (fragment != null) {
            childFragmentManager.beginTransaction().hide(fragment).commitAllowingStateLoss();
        }
        e5.i.a(c0(), getDialog().getWindow(), R$id.rechargedlg_rl_parent, aVar, false, new k(childFragmentManager));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FragmentManager c0() {
        return getChildFragmentManager();
    }

    public static void h0(FragmentManager fragmentManager, int i10, Boolean bool, com.live.evo.osd.a aVar) {
        try {
            j jVarE0 = e0();
            jVarE0.f6223c = aVar;
            jVarE0.f6225e = i10;
            jVarE0.f6227g = bool;
            Dialog dialog = jVarE0.getDialog();
            if (dialog != null && !dialog.isShowing()) {
                dialog.show();
            } else if (dialog == null) {
                jVarE0.show(fragmentManager, "recharge");
            }
        } catch (Exception e10) {
            f6218h.error(e10.getMessage(), e10);
        }
    }

    private void i0(int i10, String str) {
        e5.e.a(c0(), getDialog().getWindow(), R$id.rechargedlg_rl_parent, i10, str, 31, new l());
    }

    private void j0(int i10) {
        com.live.evo.fragment.login.e.h0(c0(), R$id.rechargedlg_rl_parent, i10, new o());
    }

    private void l() {
        setCancelable(d0());
        int i10 = this.f6225e;
        if (i10 == 24) {
            n0();
            return;
        }
        if (i10 == 21) {
            m0();
            return;
        }
        if (i10 == 22) {
            s0(true, 0);
            return;
        }
        if (i10 == 23) {
            w0();
            return;
        }
        if (i10 == 25) {
            q0(null);
            return;
        }
        if (i10 != 40 && i10 != 41 && i10 != 42) {
            if (i10 == 49) {
                u0();
                return;
            }
            if (i10 == 26) {
                k0();
                return;
            }
            if (i10 != 50 && i10 != 51) {
                if (i10 == 52) {
                    l0();
                    return;
                } else if (i10 == 53) {
                    o0();
                    return;
                } else {
                    if (i10 == 54) {
                        z0();
                        return;
                    }
                    return;
                }
            }
            j0(i10);
            return;
        }
        A0(i10, t.v.c.i.a.f18646a.r());
    }

    private void o0() {
        v.i0(c0(), R$id.rechargedlg_rl_parent, new f());
    }

    private void p0(int i10, String str) {
        i0(i10, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(int i10) {
        com.live.evo.fragment.login.h.X(c0(), R$id.rechargedlg_rl_parent, i10, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        com.live.evo.fragment.login.n.V(c0(), R$id.rechargedlg_rl_parent, new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(Fragment fragment) {
        c0().beginTransaction().hide(fragment).commitAllowingStateLoss();
        e5.d.a(c0(), getDialog().getWindow(), R$id.rechargedlg_rl_parent, new c(fragment));
    }

    private void w0() {
        com.live.evo.fragment.login.l.Y(c0(), getDialog().getWindow(), R$id.rechargedlg_rl_parent, new m());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().requestWindowFeature(1);
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(32);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 17;
        window.setAttributes(attributes);
        this.f6221a = layoutInflater.inflate(R$layout.recharge_dialog_fragment, viewGroup, false);
        getDialog().setOnKeyListener(this);
        FragmentActivity activity = getActivity();
        if (activity instanceof LiveNewActivity) {
            ((LiveNewActivity) activity).T3(true);
        }
        f0();
        l();
        return this.f6221a;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        FragmentActivity activity = getActivity();
        if (activity instanceof LiveNewActivity) {
            ((LiveNewActivity) activity).T3(false);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && (i10 == 4 || i10 == 111)) {
            if (KeyUtils.j().booleanValue()) {
                this.f6226f = true;
                return true;
            }
        } else if (keyEvent.getAction() == 1 && ((i10 == 4 || i10 == 111) && this.f6226f)) {
            this.f6226f = false;
            return false;
        }
        if (i10 != 4 && i10 != 111) {
            return false;
        }
        if (!isCancelable()) {
            if (this.f6224d == null) {
                com.live.evo.dialog.m mVar = new com.live.evo.dialog.m(getActivity());
                this.f6224d = mVar;
                mVar.h(new g());
            }
            this.f6224d.i();
        } else {
            f6220j = false;
            if (keyEvent.getAction() == 0) {
                if (!e5.a.a(this)) {
                    dismiss();
                }
                com.live.evo.osd.a aVar = this.f6223c;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        f6220j = false;
        super.onPause();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    private void l0() {
    }
}
