package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlinx.coroutines.internal.q0;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.x2;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\t¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012J.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0012J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001a\u00028\u0000H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0000H\u0096@ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u000e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/channels/p;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/b;", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "Lkotlin/Function1;", "Lr8/z;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/a;Lc9/l;)V", "element", "", "isSendOp", "Lkotlinx/coroutines/channels/h;", "E0", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "C0", "D0", "(Ljava/lang/Object;)Ljava/lang/Object;", "b", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "i", "m", "I", "n", "Lkotlinx/coroutines/channels/a;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Z", "isConflatedDropOldest", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class p<E> extends b<E> {

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int capacity;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final a onBufferOverflow;

    static /* synthetic */ <E> Object B0(p<E> pVar, E e10, v8.f<? super z> fVar) throws Throwable {
        q0 q0VarD;
        Object objE0 = pVar.E0(e10, true);
        if (!(objE0 instanceof h.Closed)) {
            return z.f17874a;
        }
        h.e(objE0);
        c9.l<E, z> lVar = pVar.onUndeliveredElement;
        if (lVar == null || (q0VarD = x.d(lVar, e10, null, 2, null)) == null) {
            throw pVar.K();
        }
        r8.a.a(q0VarD, pVar.K());
        throw q0VarD;
    }

    @Override // kotlinx.coroutines.channels.b, kotlinx.coroutines.channels.v
    public Object i(E element) {
        return E0(element, false);
    }

    private final Object D0(E element) {
        j jVarF;
        Object obj = c.f14632d;
        j jVar = (j) b.f14618h.get(this);
        while (true) {
            long andIncrement = b.f14614d.getAndIncrement(this);
            long j10 = 1152921504606846975L & andIncrement;
            boolean zU = U(andIncrement);
            int i10 = c.f14630b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String != j11) {
                jVarF = F(j11, jVar);
                if (jVarF == null) {
                    if (zU) {
                        return h.INSTANCE.a(K());
                    }
                }
            } else {
                jVarF = jVar;
            }
            E e10 = element;
            int iW0 = w0(jVarF, i11, e10, j10, obj, zU);
            jVar = jVarF;
            if (iW0 == 0) {
                jVar.b();
                return h.INSTANCE.c(z.f17874a);
            }
            if (iW0 == 1) {
                return h.INSTANCE.c(z.f17874a);
            }
            if (iW0 == 2) {
                if (zU) {
                    jVar.p();
                    return h.INSTANCE.a(K());
                }
                x2 x2Var = obj instanceof x2 ? (x2) obj : null;
                if (x2Var != null) {
                    i0(x2Var, jVar, i11);
                }
                B((jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) i10)) + ((long) i11));
                return h.INSTANCE.c(z.f17874a);
            }
            if (iW0 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iW0 == 4) {
                if (j10 < J()) {
                    jVar.b();
                }
                return h.INSTANCE.a(K());
            }
            if (iW0 == 5) {
                jVar.b();
            }
            element = e10;
        }
    }

    private final Object E0(E element, boolean isSendOp) {
        return this.onBufferOverflow == a.DROP_LATEST ? C0(element, isSendOp) : D0(element);
    }

    @Override // kotlinx.coroutines.channels.b
    protected boolean V() {
        return this.onBufferOverflow == a.DROP_OLDEST;
    }

    public p(int i10, a aVar, c9.l<? super E, z> lVar) {
        super(i10, lVar);
        this.capacity = i10;
        this.onBufferOverflow = aVar;
        if (aVar != a.SUSPEND) {
            if (i10 >= 1) {
                return;
            }
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i10 + " was specified").toString());
        }
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + c0.b(b.class).e() + " instead").toString());
    }

    private final Object C0(E element, boolean isSendOp) {
        c9.l<E, z> lVar;
        q0 q0VarD;
        Object objI = super.i(element);
        if (!h.h(objI) && !h.g(objI)) {
            if (isSendOp && (lVar = this.onUndeliveredElement) != null && (q0VarD = x.d(lVar, element, null, 2, null)) != null) {
                throw q0VarD;
            }
            return h.INSTANCE.c(z.f17874a);
        }
        return objI;
    }

    @Override // kotlinx.coroutines.channels.b, kotlinx.coroutines.channels.v
    public Object b(E e10, v8.f<? super z> fVar) {
        return B0(this, e10, fVar);
    }
}
