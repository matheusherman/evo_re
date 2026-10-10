package com.live.evo.fragment.login.presenter;

import android.text.TextUtils;
import com.live.evo.R$string;
import com.live.evo.util.s0;
import com.live.evo.util.x1;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i implements k5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f6334a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements c9.r<Boolean, Integer, String, Throwable, z> {
        a() {
        }

        @Override // c9.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z invoke(Boolean bool, Integer num, String str, Throwable th) {
            if (i.this.f6334a == null) {
                return null;
            }
            i.this.f6334a.a();
            if (bool.booleanValue()) {
                i.this.f6334a.e();
                return null;
            }
            if (num.intValue() == -3) {
                i.this.f6334a.i(x1.j(R$string.recharge_connect_failure), "");
                return null;
            }
            if (th == null && !TextUtils.isEmpty(str)) {
                i.this.f6334a.i(str, "");
                return null;
            }
            i.this.f6334a.i(x1.j(R$string.recharge_fail) + "\n" + str, "");
            return null;
        }
    }

    @Override // k5.a
    public void u() {
        this.f6334a = null;
    }

    public void A(String str, int i10) {
        this.f6334a.b();
        s0.f7342a.U(str, i10, new a());
    }

    public void B(h hVar) {
        this.f6334a = hVar;
    }

    public void z() {
        if (this.f6334a != null) {
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            String strZ = aVar.Z();
            if (strZ.isEmpty()) {
                strZ = aVar.L();
            }
            this.f6334a.n(strZ);
        }
    }
}
