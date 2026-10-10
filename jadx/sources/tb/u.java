package tb;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\u0017B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\fJ\r\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u001d\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001cR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006#"}, d2 = {"Ltb/u;", "", "<init>", "()V", "", "data", "", "pos", "limit", "", "shared", "owner", "([BIIZZ)V", "d", "()Ltb/u;", "b", "segment", "c", "(Ltb/u;)Ltb/u;", "byteCount", "e", "(I)Ltb/u;", "Lr8/z;", "a", "sink", "f", "(Ltb/u;I)V", "[B", "I", "Z", "Ltb/u;", "next", "g", "prev", "h", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final byte[] data;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int pos;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int limit;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean shared;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean owner;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    public u next;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public u prev;

    public u() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final u d() {
        this.shared = true;
        return new u(this.data, this.pos, this.limit, true, false);
    }

    public final void a() {
        int i10;
        u uVar = this.prev;
        if (uVar == this) {
            throw new IllegalStateException("cannot compact");
        }
        kotlin.jvm.internal.m.c(uVar);
        if (uVar.owner) {
            int i11 = this.limit - this.pos;
            u uVar2 = this.prev;
            kotlin.jvm.internal.m.c(uVar2);
            int i12 = 8192 - uVar2.limit;
            u uVar3 = this.prev;
            kotlin.jvm.internal.m.c(uVar3);
            if (uVar3.shared) {
                i10 = 0;
            } else {
                u uVar4 = this.prev;
                kotlin.jvm.internal.m.c(uVar4);
                i10 = uVar4.pos;
            }
            if (i11 > i12 + i10) {
                return;
            }
            u uVar5 = this.prev;
            kotlin.jvm.internal.m.c(uVar5);
            f(uVar5, i11);
            b();
            v.b(this);
        }
    }

    public final u b() {
        u uVar = this.next;
        if (uVar == this) {
            uVar = null;
        }
        u uVar2 = this.prev;
        kotlin.jvm.internal.m.c(uVar2);
        uVar2.next = this.next;
        u uVar3 = this.next;
        kotlin.jvm.internal.m.c(uVar3);
        uVar3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return uVar;
    }

    public final u c(u segment) {
        kotlin.jvm.internal.m.f(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        u uVar = this.next;
        kotlin.jvm.internal.m.c(uVar);
        uVar.prev = segment;
        this.next = segment;
        return segment;
    }

    public final u e(int byteCount) {
        u uVarC;
        if (byteCount <= 0 || byteCount > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (byteCount >= 1024) {
            uVarC = d();
        } else {
            uVarC = v.c();
            byte[] bArr = this.data;
            byte[] bArr2 = uVarC.data;
            int i10 = this.pos;
            kotlin.collections.j.j(bArr, bArr2, 0, i10, i10 + byteCount, 2, null);
        }
        uVarC.limit = uVarC.pos + byteCount;
        this.pos += byteCount;
        u uVar = this.prev;
        kotlin.jvm.internal.m.c(uVar);
        uVar.c(uVarC);
        return uVarC;
    }

    public final void f(u sink, int byteCount) {
        kotlin.jvm.internal.m.f(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int i10 = sink.limit;
        if (i10 + byteCount > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i11 = sink.pos;
            if ((i10 + byteCount) - i11 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.data;
            kotlin.collections.j.j(bArr, bArr, 0, i11, i10, 2, null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i12 = sink.limit;
        int i13 = this.pos;
        kotlin.collections.j.e(bArr2, bArr3, i12, i13, i13 + byteCount);
        sink.limit += byteCount;
        this.pos += byteCount;
    }

    public u(byte[] data, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.m.f(data, "data");
        this.data = data;
        this.pos = i10;
        this.limit = i11;
        this.shared = z10;
        this.owner = z11;
    }
}
