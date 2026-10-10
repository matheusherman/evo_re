package com.live.evo.fragment.login.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.live.evo.R$string;
import com.live.evo.util.s0;
import com.live.evo.util.x1;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g implements k5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f6330a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements c9.r<Boolean, Integer, String, Throwable, z> {
        a() {
        }

        @Override // c9.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z invoke(Boolean bool, Integer num, String str, Throwable th) {
            if (g.this.f6330a == null) {
                return null;
            }
            g.this.f6330a.a();
            if (bool.booleanValue()) {
                g.this.f6330a.e();
                return null;
            }
            if (th != null || num == null || TextUtils.isEmpty(str)) {
                g.this.f6330a.i(x1.j(R$string.recharge_fail), "");
                return null;
            }
            if (num.intValue() == -3) {
                g.this.f6330a.i(x1.j(R$string.recharge_connect_failure), "");
                return null;
            }
            g.this.f6330a.i(str, "");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements c9.r<Boolean, Integer, String, Throwable, z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f6332a;

        b(boolean z10) {
            this.f6332a = z10;
        }

        @Override // c9.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z invoke(Boolean bool, Integer num, String str, Throwable th) {
            if (g.this.f6330a == null) {
                return null;
            }
            g.this.f6330a.a();
            if (bool.booleanValue()) {
                g.this.f6330a.z();
                return null;
            }
            if (this.f6332a) {
                if (th != null || num == null || TextUtils.isEmpty(str)) {
                    g.this.f6330a.C(x1.j(R$string.recharge_fail), "");
                    return null;
                }
                if (num.intValue() == -3) {
                    g.this.f6330a.C(x1.j(R$string.recharge_connect_failure), "");
                    return null;
                }
                g.this.f6330a.C(str, "");
            } else {
                if (th != null || num == null || TextUtils.isEmpty(str)) {
                    g.this.f6330a.i(x1.j(R$string.recharge_fail), "");
                    return null;
                }
                if (num.intValue() == -3) {
                    g.this.f6330a.i(x1.j(R$string.recharge_connect_failure), "");
                    return null;
                }
                g.this.f6330a.i(str, "");
            }
            return null;
        }
    }

    @Override // k5.a
    public void u() {
        this.f6330a = null;
    }

    public void A(String str, int i10) {
        this.f6330a.b();
        s0.f7342a.U(str, i10, new a());
    }

    public void B(f fVar) {
        this.f6330a = fVar;
    }

    public void s(Context context, String str) {
        if (this.f6330a == null) {
            return;
        }
        z(str, false);
    }

    public void z(String str, boolean z10) {
        f fVar = this.f6330a;
        if (fVar == null) {
            return;
        }
        fVar.b();
        s0.f7342a.T(str, z10, new b(z10));
    }
}
