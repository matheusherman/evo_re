package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlinx.coroutines.flow.internal.d;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00028\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b2\u0006\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0011\u0010\u0012R8\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000b2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000b8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001a¨\u0006 "}, d2 = {"Lkotlinx/coroutines/flow/internal/b;", "Lkotlinx/coroutines/flow/internal/d;", ExifInterface.LATITUDE_SOUTH, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "f", "()Lkotlinx/coroutines/flow/internal/d;", "", "size", "", "g", "(I)[Lkotlinx/coroutines/flow/internal/d;", "e", "slot", "Lr8/z;", "h", "(Lkotlinx/coroutines/flow/internal/d;)V", "<set-?>", "a", "[Lkotlinx/coroutines/flow/internal/d;", "j", "()[Lkotlinx/coroutines/flow/internal/d;", "slots", "b", "I", "i", "()I", "nCollectors", "c", "nextIndex", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class b<S extends d<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private S[] slots;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int nCollectors;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int nextIndex;

    protected final S e() {
        S s10;
        synchronized (this) {
            try {
                S[] sArr = this.slots;
                if (sArr == null) {
                    sArr = (S[]) g(2);
                    this.slots = sArr;
                } else if (this.nCollectors >= sArr.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    kotlin.jvm.internal.m.e(objArrCopyOf, "copyOf(this, newSize)");
                    this.slots = (S[]) ((d[]) objArrCopyOf);
                    sArr = (S[]) ((d[]) objArrCopyOf);
                }
                int i10 = this.nextIndex;
                do {
                    s10 = sArr[i10];
                    if (s10 == null) {
                        s10 = (S) f();
                        sArr[i10] = s10;
                    }
                    i10++;
                    if (i10 >= sArr.length) {
                        i10 = 0;
                    }
                    kotlin.jvm.internal.m.d(s10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s10.a(this));
                this.nextIndex = i10;
                this.nCollectors++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return s10;
    }

    protected abstract S f();

    protected abstract S[] g(int size);

    protected final void h(S slot) {
        int i10;
        v8.f<z>[] fVarArrB;
        synchronized (this) {
            try {
                int i11 = this.nCollectors - 1;
                this.nCollectors = i11;
                if (i11 == 0) {
                    this.nextIndex = 0;
                }
                kotlin.jvm.internal.m.d(slot, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                fVarArrB = slot.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (v8.f<z> fVar : fVarArrB) {
            if (fVar != null) {
                r8.q.Companion companion = r8.q.INSTANCE;
                fVar.resumeWith(r8.q.a(z.f17874a));
            }
        }
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    protected final int getNCollectors() {
        return this.nCollectors;
    }

    protected final S[] j() {
        return this.slots;
    }
}
