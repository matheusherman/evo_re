package kotlinx.coroutines.channels;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.x2;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0002B7\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0014\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0019\u0010\u0015J!\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b\u001a\u0010\u0011J+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b!\u0010\"J)\u0010'\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001d\u0010*\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001d¢\u0006\u0004\b*\u0010+R\u001c\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00103\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0013\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r048\u0002X\u0082\u0004¨\u00066"}, d2 = {"Lkotlinx/coroutines/channels/j;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/c0;", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "prev", "Lkotlinx/coroutines/channels/b;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "", "pointers", "<init>", "(JLkotlinx/coroutines/channels/j;Lkotlinx/coroutines/channels/b;I)V", "index", "", "value", "Lr8/z;", "z", "(ILjava/lang/Object;)V", "element", "B", "v", "(I)Ljava/lang/Object;", "y", "s", "(I)V", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "", "r", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "update", "t", "(ILjava/lang/Object;)Ljava/lang/Object;", "", "cause", "Lv8/j;", "context", "o", "(ILjava/lang/Throwable;Lv8/j;)V", "receiver", "x", "(IZ)V", "e", "Lkotlinx/coroutines/channels/b;", "_channel", "u", "()Lkotlinx/coroutines/channels/b;", "n", "()I", "numberOfSlots", "Lkotlinx/atomicfu/AtomicArray;", "data", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class j<E> extends c0<j<E>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b<E> _channel;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReferenceArray f14658f;

    public final void s(int index) {
        z(index, null);
    }

    private final void z(int index, Object value) {
        this.f14658f.lazySet(index * 2, value);
    }

    public final void A(int index, Object value) {
        this.f14658f.set((index * 2) + 1, value);
    }

    @Override // kotlinx.coroutines.internal.c0
    public int n() {
        return c.f14630b;
    }

    @Override // kotlinx.coroutines.internal.c0
    public void o(int index, Throwable cause, v8.j context) {
        c9.l<E, z> lVar;
        c9.l<E, z> lVar2;
        int i10 = c.f14630b;
        boolean z10 = index >= i10;
        if (z10) {
            index -= i10;
        }
        E eV = v(index);
        while (true) {
            Object objW = w(index);
            if ((objW instanceof x2) || (objW instanceof WaiterEB)) {
                if (r(index, objW, z10 ? c.f14638j : c.f14639k)) {
                    s(index);
                    x(index, !z10);
                    if (!z10 || (lVar = u().onUndeliveredElement) == null) {
                        return;
                    }
                    x.b(lVar, eV, context);
                    return;
                }
            } else {
                if (objW == c.f14638j || objW == c.f14639k) {
                    break;
                }
                if (objW != c.f14635g && objW != c.f14634f) {
                    if (objW == c.f14637i || objW == c.f14632d || objW == c.z()) {
                        return;
                    }
                    throw new IllegalStateException(("unexpected state: " + objW).toString());
                }
            }
        }
        s(index);
        if (!z10 || (lVar2 = u().onUndeliveredElement) == null) {
            return;
        }
        x.b(lVar2, eV, context);
    }

    public final boolean r(int index, Object from, Object to) {
        return i.a(this.f14658f, (index * 2) + 1, from, to);
    }

    public final Object t(int index, Object update) {
        return this.f14658f.getAndSet((index * 2) + 1, update);
    }

    public final b<E> u() {
        b<E> bVar = this._channel;
        kotlin.jvm.internal.m.c(bVar);
        return bVar;
    }

    public final E v(int index) {
        return (E) this.f14658f.get(index * 2);
    }

    public final Object w(int index) {
        return this.f14658f.get((index * 2) + 1);
    }

    public final void x(int index, boolean receiver) {
        if (receiver) {
            u().A0((this.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) c.f14630b)) + ((long) index));
        }
        p();
    }

    public j(long j10, j<E> jVar, b<E> bVar, int i10) {
        super(j10, jVar, i10);
        this._channel = bVar;
        this.f14658f = new AtomicReferenceArray(c.f14630b * 2);
    }

    public final void B(int index, E element) {
        z(index, element);
    }

    public final E y(int index) {
        E eV = v(index);
        s(index);
        return eV;
    }
}
