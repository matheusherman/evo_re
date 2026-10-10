package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<init>", "(Ljava/lang/String;I)V", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lv8/f;", "", "block", "receiver", "completion", "Lr8/z;", "f", "(Lc9/p;Ljava/lang/Object;Lv8/f;)V", "", "i", "()Z", "isLazy$annotations", "()V", "isLazy", "a", "b", "c", "d", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum n0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14891a;

        static {
            int[] iArr = new int[n0.values().length];
            try {
                iArr[n0.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[n0.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[n0.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[n0.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f14891a = iArr;
        }
    }

    public final <R, T> void f(c9.p<? super R, ? super v8.f<? super T>, ? extends Object> block, R receiver, v8.f<? super T> completion) throws Throwable {
        int i10 = a.f14891a[ordinal()];
        if (i10 == 1) {
            va.a.d(block, receiver, completion, null, 4, null);
            return;
        }
        if (i10 == 2) {
            v8.h.a(block, receiver, completion);
        } else if (i10 == 3) {
            va.b.a(block, receiver, completion);
        } else if (i10 != 4) {
            throw new r8.n();
        }
    }

    public final boolean i() {
        return this == LAZY;
    }
}
