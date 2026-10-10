package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.v1;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0013\u001a\u00020\u00032\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00030\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0001ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b$\u0010%R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Lkotlinx/coroutines/channels/e;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/a;", "Lr8/z;", "Lkotlinx/coroutines/channels/d;", "Lv8/j;", "parentContext", "_channel", "", "initParentJob", "active", "<init>", "(Lv8/j;Lkotlinx/coroutines/channels/d;ZZ)V", "", "cause", "g", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "d", "(Lc9/l;)V", "Lkotlinx/coroutines/channels/f;", "iterator", "()Lkotlinx/coroutines/channels/f;", "element", "offer", "(Ljava/lang/Object;)Z", "b", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/h;", "i", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "a", "(Ljava/util/concurrent/CancellationException;)V", "K", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/channels/d;", "M0", "()Lkotlinx/coroutines/channels/d;", "l", "()Z", "isClosedForSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class e<E> extends kotlinx.coroutines.a<z> implements d<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final d<E> _channel;

    @Override // kotlinx.coroutines.c2
    public void K(Throwable cause) {
        CancellationException cancellationExceptionB0 = c2.B0(this, cause, null, 1, null);
        this._channel.a(cancellationExceptionB0);
        I(cancellationExceptionB0);
    }

    protected final d<E> M0() {
        return this._channel;
    }

    @Override // kotlinx.coroutines.channels.v
    public Object b(E e10, v8.f<? super z> fVar) {
        return this._channel.b(e10, fVar);
    }

    @Override // kotlinx.coroutines.channels.v
    public void d(c9.l<? super Throwable, z> handler) {
        this._channel.d(handler);
    }

    @Override // kotlinx.coroutines.channels.v
    public boolean g(Throwable cause) {
        return this._channel.g(cause);
    }

    @Override // kotlinx.coroutines.channels.v
    public Object i(E element) {
        return this._channel.i(element);
    }

    @Override // kotlinx.coroutines.channels.u
    public f<E> iterator() {
        return this._channel.iterator();
    }

    @Override // kotlinx.coroutines.channels.v
    public boolean l() {
        return this._channel.l();
    }

    @Override // kotlinx.coroutines.channels.v
    public boolean offer(E element) {
        return this._channel.offer(element);
    }

    public e(v8.j jVar, d<E> dVar, boolean z10, boolean z11) {
        super(jVar, z10, z11);
        this._channel = dVar;
    }

    @Override // kotlinx.coroutines.c2, kotlinx.coroutines.u1
    public final void a(CancellationException cause) {
        if (isCancelled()) {
            return;
        }
        if (cause == null) {
            cause = new v1(N(), null, this);
        }
        K(cause);
    }
}
