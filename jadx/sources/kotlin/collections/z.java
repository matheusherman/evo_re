package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0004\u001a#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"", "", "index", ExifInterface.LATITUDE_SOUTH, "(Ljava/util/List;I)I", "U", ExifInterface.GPS_DIRECTION_TRUE, "Q", "(Ljava/util/List;)Ljava/util/List;", "", "R", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
public class z extends y {
    public static <T> List<T> Q(List<? extends T> list) {
        kotlin.jvm.internal.m.f(list, "<this>");
        return new u0(list);
    }

    public static <T> List<T> R(List<T> list) {
        kotlin.jvm.internal.m.f(list, "<this>");
        return new t0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int S(List<?> list, int i10) {
        if (i10 >= 0 && i10 <= t.n(list)) {
            return t.n(list) - i10;
        }
        throw new IndexOutOfBoundsException("Element index " + i10 + " must be in range [" + new h9.e(0, t.n(list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int U(List<?> list, int i10) {
        if (i10 >= 0 && i10 <= list.size()) {
            return list.size() - i10;
        }
        throw new IndexOutOfBoundsException("Position index " + i10 + " must be in range [" + new h9.e(0, list.size()) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int T(List<?> list, int i10) {
        return t.n(list) - i10;
    }
}
