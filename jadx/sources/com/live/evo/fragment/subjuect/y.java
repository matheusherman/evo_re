package com.live.evo.fragment.subjuect;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.fragment.y1;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.ThreadMode;
import x1.f1.lb.util.e0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class y extends com.live.evo.fragment.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FrameLayout f6768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f6769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private w f6770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.live.evo.osd.persenter.a f6774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private y1 f6775m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f6776n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Handler f6777o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TimerTask f6778p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Timer f6779q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f6780r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private j5.g f6781s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f6782t;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y.this.f6770h != null) {
                y.this.f6770h.M0();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (y.this.f6770h != null) {
                y.this.f6770h.U0();
            }
        }
    }

    private void c0() {
        this.f6781s = null;
        List<j5.g> listF = com.live.evo.fragment.subjuect.b.c().f();
        if (listF != null) {
            int size = listF.size();
            int i10 = this.f6771i;
            if (size > i10) {
                this.f6781s = listF.get(i10);
            }
        }
    }

    private void b0() {
        this.f6770h = new w(this.f6774l, this.f6775m);
        Bundle bundle = new Bundle();
        bundle.putInt("position", this.f6771i);
        this.f6770h.setArguments(bundle);
        try {
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.replace(R$id.subject_match_fl, this.f6770h);
            fragmentTransactionBeginTransaction.commit();
        } catch (Exception unused) {
        }
    }

    private void f0(boolean z10) {
        if (this.f6781s != null) {
            if (z10) {
                this.f6782t = SystemClock.elapsedRealtime();
            } else {
                if (!this.f6773k || z10) {
                    return;
                }
                SystemClock.elapsedRealtime();
            }
        }
    }

    public void e0() {
        TimerTask timerTask = this.f6778p;
        if (timerTask != null) {
            timerTask.cancel();
        }
        b bVar = new b();
        this.f6778p = bVar;
        this.f6779q.schedule(bVar, this.f6780r);
    }

    public void h0() {
        TimerTask timerTask = this.f6778p;
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    private void d0(View view) {
        long j10;
        this.f6768f = (FrameLayout) view.findViewById(R$id.subject_match_fl);
        this.f6769g = (TextView) this.f6776n.findViewById(R$id.kidsmode_show_tv);
        long jH = com.live.evo.l.n().h("update_dualmeet_list_int", this.f6780r);
        if (jH < 600) {
            j10 = this.f6780r;
        } else {
            j10 = jH * 1000;
        }
        this.f6780r = j10;
        g0();
    }

    private void g0() {
        if (a5.b.a().b()) {
            if (this.f6769g.getVisibility() != 0) {
                this.f6769g.setVisibility(0);
            }
            if (this.f6768f.getVisibility() != 8) {
                this.f6768f.setVisibility(8);
                return;
            }
            return;
        }
        if (this.f6769g.getVisibility() != 8) {
            this.f6769g.setVisibility(8);
        }
        if (this.f6768f.getVisibility() != 0) {
            this.f6768f.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f6776n = layoutInflater.inflate(R$layout.menu_fragment_subject, viewGroup, false);
        this.f6771i = getArguments().getInt("position");
        d0(this.f6776n);
        c0();
        b0();
        this.f6777o.postDelayed(new a(), 1000L);
        return this.f6776n;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        e0.f21385a.b(this);
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e0.f21385a.a(this);
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        if (z10) {
            if (!this.f6772j) {
                g0();
                if (!a5.b.a().b()) {
                    w wVar = this.f6770h;
                    if (wVar != null) {
                        wVar.S0();
                    }
                    w wVar2 = this.f6770h;
                    if (wVar2 != null) {
                        wVar2.M0();
                    }
                }
            } else {
                this.f6772j = false;
            }
        }
        f0(z10);
        w wVar3 = this.f6770h;
        if (wVar3 != null && (z10 || (this.f6773k && !z10))) {
            wVar3.h1(z10);
        }
        if (z10) {
            e0();
        } else {
            h0();
        }
        this.f6773k = z10;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSubjectUpdateEvent(b5.j jVar) {
    }
}
