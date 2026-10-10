package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0018\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001aS\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a9\u0010\u0010\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a9\u0010\u0012\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a9\u0010\u0015\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\t\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a9\u0010\u0018\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\t\u001a\u00020\u00172\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a5\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a#\u0010\u001e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a9\u0010\"\u001a\u00020!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010 \u001a\u00028\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#\u001a-\u0010%\u001a\u00020!*\u00020\u00142\u0006\u0010 \u001a\u00020$2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&\u001a6\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b(\u0010)\u001a\u001c\u0010*\u001a\u00020\u0005*\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\b*\u0010+\u001a\u001c\u0010,\u001a\u00020\u0014*\u00020\u00142\u0006\u0010'\u001a\u00020\u0014H\u0086\u0002¢\u0006\u0004\b,\u0010-\u001a\u001c\u0010.\u001a\u00020\u0017*\u00020\u00172\u0006\u0010'\u001a\u00020\u0017H\u0086\u0002¢\u0006\u0004\b.\u0010/\u001a\u001c\u00101\u001a\u000200*\u0002002\u0006\u0010'\u001a\u000200H\u0086\u0002¢\u0006\u0004\b1\u00102\u001a\u001f\u00103\u001a\u00020!\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b3\u00104\u001a%\u00105\u001a\u00020!*\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b5\u00106\u001a%\u00107\u001a\u00020!*\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b7\u00108\u001a%\u00109\u001a\u00020!*\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b9\u0010:\u001a;\u0010>\u001a\u00020!\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010=\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000;j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`<¢\u0006\u0004\b>\u0010?¨\u0006@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "d", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "c", "([I)Ljava/util/List;", "destination", "destinationOffset", "startIndex", "endIndex", "i", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "", "e", "([B[BIII)[B", "g", "([I[IIII)[I", "", "h", "([J[JIII)[J", "", "f", "([F[FIII)[F", "fromIndex", "toIndex", "p", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "o", "([BII)[B", "element", "Lr8/z;", "r", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "", "q", "([JJII)V", "elements", "x", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "v", "([I[I)[I", "w", "([J[J)[J", "u", "([F[F)[F", "", "y", "([Z[Z)[Z", "C", "([Ljava/lang/Object;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "([III)V", "B", "([JII)V", "z", "([FII)V", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "D", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
public class m extends l {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"kotlin/collections/m$a", "Lkotlin/collections/d;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "()Z", "element", "f", "(I)Z", "index", "h", "(I)Ljava/lang/Integer;", "i", "(I)I", "k", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends d<Integer> implements RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f12307a;

        a(int[] iArr) {
            this.f12307a = iArr;
        }

        @Override // kotlin.collections.b, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return f(((Number) obj).intValue());
            }
            return false;
        }

        public boolean f(int element) {
            return o.I(this.f12307a, element);
        }

        @Override // kotlin.collections.d, kotlin.collections.b
        /* JADX INFO: renamed from: getSize */
        public int get_size() {
            return this.f12307a.length;
        }

        @Override // kotlin.collections.d, java.util.List
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer get(int index) {
            return Integer.valueOf(this.f12307a[index]);
        }

        public int i(int element) {
            return o.V(this.f12307a, element);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return i(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.Collection
        public boolean isEmpty() {
            return this.f12307a.length == 0;
        }

        public int k(int element) {
            return o.f0(this.f12307a, element);
        }

        @Override // kotlin.collections.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return k(((Number) obj).intValue());
            }
            return -1;
        }
    }

    public static void A(int[] iArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        Arrays.sort(iArr, i10, i11);
    }

    public static void B(long[] jArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(jArr, "<this>");
        Arrays.sort(jArr, i10, i11);
    }

    public static final <T> void C(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void D(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static List<Integer> c(int[] iArr) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        return new a(iArr);
    }

    public static <T> List<T> d(T[] tArr) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        List<T> listA = p.a(tArr);
        kotlin.jvm.internal.m.e(listA, "asList(...)");
        return listA;
    }

    public static byte[] e(byte[] bArr, byte[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        System.arraycopy(bArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static float[] f(float[] fArr, float[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.m.f(fArr, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        System.arraycopy(fArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static int[] g(int[] iArr, int[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        System.arraycopy(iArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static long[] h(long[] jArr, long[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.m.f(jArr, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        System.arraycopy(jArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static <T> T[] i(T[] tArr, T[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        System.arraycopy(tArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static /* synthetic */ byte[] j(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return e(bArr, bArr2, i10, i11, i12);
    }

    public static /* synthetic */ float[] k(float[] fArr, float[] fArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = fArr.length;
        }
        return f(fArr, fArr2, i10, i11, i12);
    }

    public static /* synthetic */ int[] l(int[] iArr, int[] iArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length;
        }
        return g(iArr, iArr2, i10, i11, i12);
    }

    public static /* synthetic */ long[] m(long[] jArr, long[] jArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = jArr.length;
        }
        return h(jArr, jArr2, i10, i11, i12);
    }

    public static /* synthetic */ Object[] n(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return i(objArr, objArr2, i10, i11, i12);
    }

    public static byte[] o(byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        k.b(i11, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        kotlin.jvm.internal.m.e(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static <T> T[] p(T[] tArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        k.b(i11, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i10, i11);
        kotlin.jvm.internal.m.e(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    public static final void q(long[] jArr, long j10, int i10, int i11) {
        kotlin.jvm.internal.m.f(jArr, "<this>");
        Arrays.fill(jArr, i10, i11, j10);
    }

    public static <T> void r(T[] tArr, T t10, int i10, int i11) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        Arrays.fill(tArr, i10, i11, t10);
    }

    public static /* synthetic */ void s(long[] jArr, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length;
        }
        q(jArr, j10, i10, i11);
    }

    public static /* synthetic */ void t(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        r(objArr, obj, i10, i11);
    }

    public static float[] u(float[] fArr, float[] elements) {
        kotlin.jvm.internal.m.f(fArr, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        int length = fArr.length;
        int length2 = elements.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(elements, 0, fArrCopyOf, length, length2);
        kotlin.jvm.internal.m.c(fArrCopyOf);
        return fArrCopyOf;
    }

    public static int[] v(int[] iArr, int[] elements) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, iArrCopyOf, length, length2);
        kotlin.jvm.internal.m.c(iArrCopyOf);
        return iArrCopyOf;
    }

    public static long[] w(long[] jArr, long[] elements) {
        kotlin.jvm.internal.m.f(jArr, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        int length = jArr.length;
        int length2 = elements.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(elements, 0, jArrCopyOf, length, length2);
        kotlin.jvm.internal.m.c(jArrCopyOf);
        return jArrCopyOf;
    }

    public static <T> T[] x(T[] tArr, T[] elements) {
        kotlin.jvm.internal.m.f(tArr, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, tArr2, length, length2);
        kotlin.jvm.internal.m.c(tArr2);
        return tArr2;
    }

    public static boolean[] y(boolean[] zArr, boolean[] elements) {
        kotlin.jvm.internal.m.f(zArr, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        int length = zArr.length;
        int length2 = elements.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(elements, 0, zArrCopyOf, length, length2);
        kotlin.jvm.internal.m.c(zArrCopyOf);
        return zArrCopyOf;
    }

    public static void z(float[] fArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(fArr, "<this>");
        Arrays.sort(fArr, i10, i11);
    }
}
