package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.l0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0015\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0014¢\u0006\u0004\b \u0010!R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010$R\u000b\u0010&\u001a\u00020%8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lkotlinx/coroutines/flow/c;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/e;", "Lkotlinx/coroutines/channels/u;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "", "consume", "Lv8/j;", "context", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "<init>", "(Lkotlinx/coroutines/channels/u;ZLv8/j;ILkotlinx/coroutines/channels/a;)V", "Lr8/z;", "j", "()V", "f", "(Lv8/j;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/internal/e;", "Lkotlinx/coroutines/channels/s;", "scope", "e", "(Lkotlinx/coroutines/channels/s;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/l0;", "i", "(Lkotlinx/coroutines/l0;)Lkotlinx/coroutines/channels/u;", "Lkotlinx/coroutines/flow/g;", "collector", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "", "c", "()Ljava/lang/String;", "d", "Lkotlinx/coroutines/channels/u;", "Z", "Lkotlinx/atomicfu/AtomicBoolean;", "consumed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class c<T> extends kotlinx.coroutines.flow.internal.e<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f14702f = AtomicIntegerFieldUpdater.newUpdater(c.class, "consumed");
    private volatile int consumed;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final kotlinx.coroutines.channels.u<T> channel;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean consume;

    public /* synthetic */ c(kotlinx.coroutines.channels.u uVar, boolean z10, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar, int i11, kotlin.jvm.internal.g gVar) {
        this(uVar, z10, (i11 & 4) != 0 ? v8.k.f19724a : jVar, (i11 & 8) != 0 ? -3 : i10, (i11 & 16) != 0 ? kotlinx.coroutines.channels.a.SUSPEND : aVar);
    }

    private final void j() {
        if (this.consume && f14702f.getAndSet(this, 1) != 0) {
            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
        }
    }

    @Override // kotlinx.coroutines.flow.internal.e
    protected String c() {
        return "channel=" + this.channel;
    }

    @Override // kotlinx.coroutines.flow.internal.e, kotlinx.coroutines.flow.f
    public Object collect(g<? super T> gVar, v8.f<? super r8.z> fVar) {
        if (this.capacity != -3) {
            Object objCollect = super.collect(gVar, fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
        j();
        Object objD = j.d(gVar, this.channel, this.consume, fVar);
        return objD == kotlin.coroutines.intrinsics.b.c() ? objD : r8.z.f17874a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    protected Object e(kotlinx.coroutines.channels.s<? super T> sVar, v8.f<? super r8.z> fVar) {
        Object objD = j.d(new kotlinx.coroutines.flow.internal.t(sVar), this.channel, this.consume, fVar);
        return objD == kotlin.coroutines.intrinsics.b.c() ? objD : r8.z.f17874a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    protected kotlinx.coroutines.flow.internal.e<T> f(v8.j context, int capacity, kotlinx.coroutines.channels.a onBufferOverflow) {
        return new c(this.channel, this.consume, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    public kotlinx.coroutines.channels.u<T> i(l0 scope) {
        j();
        if (this.capacity == -3) {
            return this.channel;
        }
        return super.i(scope);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(kotlinx.coroutines.channels.u<? extends T> uVar, boolean z10, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar) {
        super(jVar, i10, aVar);
        this.channel = uVar;
        this.consume = z10;
        this.consumed = 0;
    }
}
