package d1;

import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f9573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private V[] f9574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9576d;

    public i() {
        this(10);
    }

    @Nullable
    private V c(long j10, boolean z10) {
        V vE = null;
        long j11 = LocationRequestCompat.PASSIVE_INTERVAL;
        while (this.f9576d > 0) {
            long j12 = j10 - this.f9573a[this.f9575c];
            if (j12 < 0 && (z10 || (-j12) >= j11)) {
                break;
            }
            vE = e();
            j11 = j12;
        }
        return vE;
    }

    @Nullable
    public synchronized V b(long j10) {
        return c(j10, false);
    }

    @Nullable
    public synchronized V d(long j10) {
        return c(j10, true);
    }

    public i(int i10) {
        this.f9573a = new long[i10];
        this.f9574b = (V[]) a(i10);
    }

    private static <V> V[] a(int i10) {
        return (V[]) new Object[i10];
    }

    @Nullable
    private V e() {
        a.c(this.f9576d > 0);
        V[] vArr = this.f9574b;
        int i10 = this.f9575c;
        V v10 = vArr[i10];
        vArr[i10] = null;
        this.f9575c = (i10 + 1) % vArr.length;
        this.f9576d--;
        return v10;
    }
}
