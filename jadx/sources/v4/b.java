package v4;

import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import com.live.evo.R$drawable;
import com.live.evo.util.n1;
import com.live.evo.util.o;
import com.live.evo.util.s0;
import com.live.evo.util.w;
import com.live.evo.util.x1;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import x1.f1.lb.ad.AdItem;
import x1.f1.lb.util.e0;
import x1.f1.lb.util.g0;
import x1.f1.lb.util.m;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f19595n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f19596o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f19597p = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static b f19598q;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private LinearLayout f19606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f19607i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f19608j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f19609k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private i5.b f19610l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f19599a = q6.c.d(b.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19600b = "SP_AD_START";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<i5.b> f19601c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<i5.b> f19602d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19603e = "AD_START_";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19605g = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CountDownTimer f19611m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private File f19604f = n1.b();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements w4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f19612a;

        a(b bVar, f fVar) {
            this.f19612a = fVar;
        }
    }

    /* JADX INFO: renamed from: v4.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0374b implements f {
        C0374b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c implements g0<List<AdItem>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f19614a;

        c(m mVar) {
            this.f19614a = mVar;
        }

        @Override // x1.f1.lb.util.g0
        public void b(@NonNull Throwable th) {
            this.f19614a.a(Boolean.FALSE);
        }

        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(List<AdItem> list) {
            List<i5.b> listG = s0.f7342a.g(list);
            if (listG.isEmpty()) {
                this.f19614a.a(Boolean.FALSE);
            } else {
                b.this.f19601c.addAll(listG);
                this.f19614a.a(Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d implements o.b {
        d() {
        }

        @Override // com.live.evo.util.o.b
        public void a(Throwable th) {
            b.this.f19599a.error("downloadAdStartFile failure", th);
        }

        @Override // com.live.evo.util.o.b
        public void b(String str) {
            b.this.f19599a.debug("downloadAdStartFile : " + str, new Object[0]);
            b bVar = b.this;
            bVar.i(bVar.f19602d);
        }

        @Override // com.live.evo.util.o.b
        public void c(int i10) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f19617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f19618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LinearLayout f19619c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j10, long j11, TextView textView, g gVar, LinearLayout linearLayout) {
            super(j10, j11);
            this.f19617a = textView;
            this.f19618b = gVar;
            this.f19619c = linearLayout;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            LinearLayout linearLayout = this.f19619c;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            g gVar = this.f19618b;
            if (gVar != null) {
                gVar.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            int i10 = ((int) (j10 / 1000)) + 1;
            TextView textView = this.f19617a;
            if (textView != null) {
                textView.setText(i10 + "s");
            }
            if (b.this.f19609k - j10 > CoroutineLiveDataKt.DEFAULT_TIMEOUT) {
                b bVar = b.this;
                if (bVar.w(bVar.f19610l)) {
                    if (this.f19618b != null) {
                        b bVar2 = b.this;
                        bVar2.f19609k = bVar2.f19608j - CoroutineLiveDataKt.DEFAULT_TIMEOUT;
                        this.f19618b.a();
                        return;
                    }
                    return;
                }
            }
            if (b.this.f19610l == null || b.this.f19609k - j10 <= b.this.f19610l.f() * 1000) {
                return;
            }
            b bVar3 = b.this;
            if (!bVar3.x(bVar3.f19610l) || this.f19618b == null) {
                return;
            }
            b bVar4 = b.this;
            bVar4.f19609k = bVar4.f19608j - ((long) (b.this.f19610l.f() * 1000));
            this.f19618b.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface f {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface g {
        void a();

        void onFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List<i5.b> list) {
        try {
            for (File file : n1.b().listFiles()) {
                String name = file.getName();
                if (name.startsWith(this.f19603e) || name.contains(this.f19603e)) {
                    if (list.size() <= 0) {
                        yb.c.h(file);
                    } else if (list.size() == 1) {
                        if (!name.contains(list.get(0).a() + "_" + list.get(0).e())) {
                            yb.c.h(file);
                        }
                    } else if (list.size() == 2) {
                        if (!name.contains(list.get(0).a() + "_" + list.get(0).e())) {
                            if (!name.contains(list.get(1).a() + "_" + list.get(1).e())) {
                                yb.c.h(file);
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            this.f19599a.error("delete old ad file failure", e10);
        }
    }

    public synchronized void A(List<i5.b> list) {
        try {
            this.f19602d.clear();
            if (list != null && list.size() > 0) {
                for (i5.b bVar : list) {
                    if (!TextUtils.isEmpty(bVar.c())) {
                        bVar.i(v4.a.b().c() * 1000);
                        bVar.g(v4.a.b().d());
                        this.f19602d.add(bVar);
                        if (this.f19602d.size() == 2) {
                            break;
                        }
                    }
                }
            }
            List<i5.b> list2 = this.f19602d;
            if (list2 == null || list2.size() <= 0) {
                w0.f21452a.t(this.f19600b, "");
            } else {
                w0.f21452a.t(this.f19600b, w.a().w(this.f19602d));
            }
            xe.c.c().l(new b5.a());
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean r() {
        return false;
    }

    public boolean t(i5.b bVar) {
        if (bVar == null) {
            return false;
        }
        for (i5.b bVar2 : this.f19601c) {
            if (bVar.a() == bVar2.a() && bVar.c().equals(bVar2.c())) {
                return true;
            }
        }
        return false;
    }

    private void k(String str, String str2) {
        o.a(str, new File(n1.b(), str2), true, new d());
    }

    public static b o() {
        if (f19598q == null) {
            f19598q = new b();
        }
        return f19598q;
    }

    public void B(i5.b bVar) {
        this.f19610l = bVar;
    }

    public void C(LinearLayout linearLayout, TextView textView, long j10, i5.b bVar, g gVar) {
        b bVar2;
        this.f19608j = j10;
        this.f19606h = linearLayout;
        this.f19607i = textView;
        this.f19610l = bVar;
        this.f19609k = j10;
        if (this.f19611m == null) {
            bVar2 = this;
            bVar2.f19611m = bVar2.new e(this.f19608j, 500L, textView, gVar, linearLayout);
        } else {
            bVar2 = this;
        }
        CountDownTimer countDownTimer = bVar2.f19611m;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public void D() {
        CountDownTimer countDownTimer = this.f19611m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void j() {
        e0.f21385a.b(this);
        D();
        this.f19611m = null;
    }

    public List<i5.b> l() {
        this.f19599a.a("adStartDatas = " + w.a().w(this.f19601c), new Object[0]);
        return this.f19601c;
    }

    public Drawable m(i5.b bVar) {
        File file;
        try {
            file = new File(bVar.c());
        } catch (Exception unused) {
            file = null;
        }
        try {
            this.f19599a.debug("getAdStartDrawable = " + file.getAbsolutePath(), new Object[0]);
            if (file.exists()) {
                return Drawable.createFromPath(file.getAbsolutePath());
            }
            this.f19599a.error("getAdStartDrawable = file is not exists", new Object[0]);
            return x1.f(R$drawable.load_bg);
        } catch (Exception e10) {
            this.f19599a.error("getAdStartDrawable = " + e10.getMessage(), new Object[0]);
            return x1.f(R$drawable.load_bg);
        }
    }

    @xe.m(threadMode = ThreadMode.BACKGROUND)
    public void onPropertiesChanged(b5.a aVar) {
        for (i5.b bVar : this.f19602d) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f19603e);
            sb2.append(bVar.a());
            sb2.append("_");
            sb2.append(bVar.e());
            sb2.append(bVar.e() == 2 ? ".mp4" : ".png");
            String string = sb2.toString();
            File file = new File(this.f19604f, string);
            if (!t(bVar) || !file.exists()) {
                k(bVar.c(), string);
            }
        }
    }

    public void q(m<Boolean> mVar) {
        x1.f1.lb.ad.b.f20540a.c(new c(mVar));
    }

    public boolean s() {
        return this.f19601c.size() > 0;
    }

    public boolean w(i5.b bVar) {
        return bVar != null && bVar.e() == 1;
    }

    public boolean x(i5.b bVar) {
        return bVar != null && bVar.e() == 2;
    }

    public boolean y() {
        if (this.f19601c.size() <= 0) {
            return false;
        }
        this.f19599a.a("isCanSkip = " + this.f19601c.get(0).b(), new Object[0]);
        return this.f19601c.get(0).b();
    }

    public b() {
        e0.f21385a.a(this);
    }

    public String n(i5.b bVar) {
        try {
            return bVar.c();
        } catch (Exception unused) {
            return "";
        }
    }

    public void p() {
        if (r() && !TextUtils.isEmpty("AD_SPLASH_KEY") && !TextUtils.isEmpty(f19595n)) {
            z("AD_SPLASH_KEY", f19595n, new C0374b());
        } else {
            A(null);
        }
    }

    public void u() {
        if (!r()) {
            return;
        }
        p();
    }

    public void v(m<Boolean> mVar) {
        q(mVar);
    }

    public void z(String str, String str2, f fVar) {
        if (r() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            v4.a.b().a(str, str2, null, new a(this, fVar));
        }
    }
}
