package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.l0;
import r8.i;
import r8.j;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bb\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001fR3\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010 R\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/paging/multicast/Multicaster;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/l0;", "scope", "", "bufferSize", "Lkotlinx/coroutines/flow/f;", "source", "", "piggybackingDownstream", "Lkotlin/Function2;", "Lv8/f;", "Lr8/z;", "onEach", "keepUpstreamAlive", "<init>", "(Lkotlinx/coroutines/l0;ILkotlinx/coroutines/flow/f;ZLc9/p;Z)V", "close", "(Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/multicast/ChannelManager;", "channelManager$delegate", "Lr8/i;", "getChannelManager", "()Landroidx/paging/multicast/ChannelManager;", "channelManager", "flow", "Lkotlinx/coroutines/flow/f;", "getFlow", "()Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/l0;", "Z", "Lc9/p;", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class Multicaster<T> {

    /* JADX INFO: renamed from: channelManager$delegate, reason: from kotlin metadata */
    private final i channelManager;
    private final f<T> flow;
    private final boolean keepUpstreamAlive;
    private final p<T, v8.f<? super z>, Object> onEach;
    private final boolean piggybackingDownstream;
    private final l0 scope;
    private final f<T> source;

    /* JADX WARN: Multi-variable type inference failed */
    public Multicaster(l0 scope, int i10, f<? extends T> source, boolean z10, p<? super T, ? super v8.f<? super z>, ? extends Object> onEach, boolean z11) {
        m.f(scope, "scope");
        m.f(source, "source");
        m.f(onEach, "onEach");
        this.scope = scope;
        this.source = source;
        this.piggybackingDownstream = z10;
        this.onEach = onEach;
        this.keepUpstreamAlive = z11;
        this.channelManager = j.b(r8.m.SYNCHRONIZED, new Multicaster$channelManager$2(this, i10));
        this.flow = h.v(new Multicaster$flow$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelManager<T> getChannelManager() {
        return (ChannelManager) this.channelManager.getValue();
    }

    public final f<T> getFlow() {
        return this.flow;
    }

    public final Object close(v8.f<? super z> fVar) {
        Object objClose = getChannelManager().close(fVar);
        if (objClose == b.c()) {
            return objClose;
        }
        return z.f17874a;
    }

    public /* synthetic */ Multicaster(l0 l0Var, int i10, f fVar, boolean z10, p pVar, boolean z11, int i11, g gVar) {
        this(l0Var, (i11 & 2) != 0 ? 0 : i10, fVar, (i11 & 8) != 0 ? false : z10, pVar, (i11 & 32) != 0 ? false : z11);
    }
}
