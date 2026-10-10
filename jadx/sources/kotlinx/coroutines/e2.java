package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B6\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/e2;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/t0;", "Lv8/j;", "parentContext", "Lkotlin/Function2;", "Lkotlinx/coroutines/l0;", "Lv8/f;", "", "block", "<init>", "(Lv8/j;Lc9/p;)V", "Lr8/z;", "t0", "()V", "d", "Lv8/f;", "continuation", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class e2<T> extends t0<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final v8.f<r8.z> continuation;

    public e2(v8.j jVar, c9.p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar) {
        super(jVar, false);
        this.continuation = kotlin.coroutines.intrinsics.b.a(pVar, this, this);
    }

    @Override // kotlinx.coroutines.c2
    protected void t0() throws Throwable {
        va.a.c(this.continuation, this);
    }
}
