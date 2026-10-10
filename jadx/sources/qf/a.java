package qf;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.u;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eR&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000f¨\u0006\u0010"}, d2 = {"Lqf/a;", "Ln6/a;", "Lr8/u;", "", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "triple", "<init>", "(Lr8/u;)V", "c", "()I", "e", "()J", "d", "()Lz1/b1/lb/m/meta/EPGProgramme;", "Lr8/u;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a extends n6.a {
    private final u<Integer, Long, EPGProgramme> triple;

    /* JADX WARN: Multi-variable type inference failed */
    public a(u<Integer, Long, ? extends EPGProgramme> triple) {
        m.f(triple, "triple");
        this.triple = triple;
    }

    public final int c() {
        return this.triple.d().intValue();
    }

    public final EPGProgramme d() {
        return this.triple.f();
    }

    public final long e() {
        return this.triple.e().longValue();
    }
}
