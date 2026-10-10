package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/x;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/c2;", "Lkotlinx/coroutines/w;", "Lkotlinx/coroutines/u1;", "parent", "<init>", "(Lkotlinx/coroutines/u1;)V", "c", "()Ljava/lang/Object;", "B", "(Lv8/f;)Ljava/lang/Object;", "value", "", "r", "(Ljava/lang/Object;)Z", "Y", "()Z", "onCancelComplete", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class x<T> extends c2 implements w<T> {
    public x(u1 u1Var) {
        super(true);
        e0(u1Var);
    }

    @Override // kotlinx.coroutines.c2
    public boolean Y() {
        return true;
    }

    @Override // kotlinx.coroutines.s0
    public Object B(v8.f<? super T> fVar) throws Throwable {
        Object objG = G(fVar);
        kotlin.coroutines.intrinsics.b.c();
        return objG;
    }

    @Override // kotlinx.coroutines.s0
    public T c() {
        return (T) U();
    }

    @Override // kotlinx.coroutines.w
    public boolean r(T value) {
        return k0(value);
    }
}
