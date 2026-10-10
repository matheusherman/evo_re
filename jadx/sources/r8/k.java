package r8;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "initializer", "Lr8/i;", "a", "(Lc9/a;)Lr8/i;", "Lr8/m;", "mode", "b", "(Lr8/m;Lc9/a;)Lr8/i;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/LazyKt")
public class k {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17863a;

        static {
            int[] iArr = new int[m.values().length];
            try {
                iArr[m.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[m.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[m.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f17863a = iArr;
        }
    }

    public static <T> i<T> a(c9.a<? extends T> initializer) {
        kotlin.jvm.internal.m.f(initializer, "initializer");
        kotlin.jvm.internal.g gVar = null;
        return new t(initializer, gVar, 2, gVar);
    }

    public static <T> i<T> b(m mode, c9.a<? extends T> initializer) {
        kotlin.jvm.internal.m.f(mode, "mode");
        kotlin.jvm.internal.m.f(initializer, "initializer");
        int i10 = a.f17863a[mode.ordinal()];
        int i11 = 2;
        if (i10 == 1) {
            kotlin.jvm.internal.g gVar = null;
            return new t(initializer, gVar, i11, gVar);
        }
        if (i10 == 2) {
            return new s(initializer);
        }
        if (i10 == 3) {
            return new a0(initializer);
        }
        throw new n();
    }
}
