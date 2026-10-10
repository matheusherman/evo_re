package kotlin.jvm.internal;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q extends p {
    public q(i9.f fVar, String str, String str2) {
        super(c.NO_RECEIVER, ((d) fVar).d(), str, str2, !(fVar instanceof i9.d) ? 1 : 0);
    }

    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public void set(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }

    public q(Class cls, String str, String str2, int i10) {
        super(c.NO_RECEIVER, cls, str, str2, i10);
    }

    public q(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
