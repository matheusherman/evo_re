package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/flow/c0;", "Lkotlinx/coroutines/flow/internal/d;", "Lkotlinx/coroutines/flow/a0;", "<init>", "()V", "flow", "", "c", "(Lkotlinx/coroutines/flow/a0;)Z", "", "Lv8/f;", "Lr8/z;", "d", "(Lkotlinx/coroutines/flow/a0;)[Lv8/f;", "", "a", "J", "index", "b", "Lv8/f;", "cont", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class c0 extends kotlinx.coroutines.flow.internal.d<a0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long index = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public v8.f<? super r8.z> cont;

    @Override // kotlinx.coroutines.flow.internal.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(a0<?> flow) {
        if (this.index >= 0) {
            return false;
        }
        this.index = flow.T();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public v8.f<r8.z>[] b(a0<?> flow) {
        long j10 = this.index;
        this.index = -1L;
        this.cont = null;
        return flow.S(j10);
    }
}
