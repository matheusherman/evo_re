package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f13691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f13692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f13693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile q f13694d;

    protected void a(q qVar) {
        if (this.f13694d != null) {
            return;
        }
        synchronized (this) {
            if (this.f13694d != null) {
                return;
            }
            try {
                if (this.f13691a != null) {
                    this.f13694d = qVar.h().d(this.f13691a, this.f13692b);
                } else {
                    this.f13694d = qVar;
                }
            } catch (IOException unused) {
            }
        }
    }

    public int b() {
        return this.f13693c ? this.f13694d.e() : this.f13691a.size();
    }

    public q d(q qVar) {
        q qVar2 = this.f13694d;
        this.f13694d = qVar;
        this.f13691a = null;
        this.f13693c = true;
        return qVar2;
    }

    public q c(q qVar) {
        a(qVar);
        return this.f13694d;
    }
}
