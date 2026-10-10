package h9;

import androidx.exifinterface.media.ExifInterface;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lh9/b;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "", "isEmpty", "()Z", "getStart", "()Ljava/lang/Comparable;", "start", "getEndInclusive", "endInclusive", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface b<T extends Comparable<? super T>> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(b<T> bVar, T value) {
            m.f(value, "value");
            return value.compareTo(bVar.getStart()) >= 0 && value.compareTo(bVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(b<T> bVar) {
            if (bVar.getStart().compareTo(bVar.getEndInclusive()) > 0) {
                return true;
            }
            return false;
        }
    }

    T getEndInclusive();

    T getStart();

    boolean isEmpty();
}
