package ta;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH¦@¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lta/j;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "value", "Lr8/z;", "c", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "", "iterator", "d", "(Ljava/util/Iterator;Lv8/f;)Ljava/lang/Object;", "Lta/h;", "sequence", "f", "(Lta/h;Lv8/f;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class j<T> {
    public abstract Object c(T t10, v8.f<? super z> fVar);

    public abstract Object d(Iterator<? extends T> it, v8.f<? super z> fVar);

    public final Object f(h<? extends T> hVar, v8.f<? super z> fVar) {
        Object objD = d(hVar.iterator(), fVar);
        if (objD == kotlin.coroutines.intrinsics.b.c()) {
            return objD;
        }
        return z.f17874a;
    }
}
