package i0;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import g0.d;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\"\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0011\u001a\u00020\u000e2\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J1\u0010\u0012\u001a\u00020\u000e2\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH$¢\u0006\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013¨\u0006\u0015"}, d2 = {"Li0/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lg0/d$d;", "Lg0/d$b;", "", "interval", "<init>", "(J)V", "Lg0/d;", "adapter", "Landroid/view/View;", "view", "", "position", "Lr8/z;", "b", "(Lg0/d;Landroid/view/View;I)V", "a", "c", "J", "mLastClickTime", "com.github.CymChad.brvah"}, k = 1, mv = {1, 8, 0}, xi = 48)
abstract class b<T> implements d.InterfaceC0181d<T>, d.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long interval;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long mLastClickTime;

    protected abstract void c(d<T, ?> adapter, View view, int position);

    @Override // g0.d.b
    public void a(d<T, ?> adapter, View view, int position) {
        m.f(adapter, "adapter");
        m.f(view, "view");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = jCurrentTimeMillis - this.mLastClickTime;
        if (j10 >= this.interval || j10 < 0) {
            this.mLastClickTime = jCurrentTimeMillis;
            c(adapter, view, position);
        }
    }

    @Override // g0.d.InterfaceC0181d
    public void b(d<T, ?> adapter, View view, int position) {
        m.f(adapter, "adapter");
        m.f(view, "view");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = jCurrentTimeMillis - this.mLastClickTime;
        if (j10 >= this.interval || j10 < 0) {
            this.mLastClickTime = jCurrentTimeMillis;
            c(adapter, view, position);
        }
    }

    public b(long j10) {
        this.interval = j10;
    }
}
