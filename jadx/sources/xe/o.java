package xe;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Method f22249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadMode f22250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Class<?> f22251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f22252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f22253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f22254f;

    private synchronized void a() {
        if (this.f22254f == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.f22249a.getDeclaringClass().getName());
            sb2.append('#');
            sb2.append(this.f22249a.getName());
            sb2.append('(');
            sb2.append(this.f22251c.getName());
            this.f22254f = sb2.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        a();
        o oVar = (o) obj;
        oVar.a();
        return this.f22254f.equals(oVar.f22254f);
    }

    public int hashCode() {
        return this.f22249a.hashCode();
    }

    public o(Method method, Class<?> cls, ThreadMode threadMode, int i10, boolean z10) {
        this.f22249a = method;
        this.f22250b = threadMode;
        this.f22251c = cls;
        this.f22252d = i10;
        this.f22253e = z10;
    }
}
