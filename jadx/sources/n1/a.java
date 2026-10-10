package n1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {
    public static float A(@NonNull Parcel parcel, int i10) {
        L(parcel, i10, 4);
        return parcel.readFloat();
    }

    public static int E(@NonNull Parcel parcel, int i10) {
        L(parcel, i10, 4);
        return parcel.readInt();
    }

    public static int v(int i10) {
        return (char) i10;
    }

    public static boolean w(@NonNull Parcel parcel, int i10) {
        L(parcel, i10, 4);
        return parcel.readInt() != 0;
    }

    /* JADX INFO: renamed from: n1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class C0307a extends RuntimeException {
        public C0307a(@NonNull String str, @NonNull Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static long F(@NonNull Parcel parcel, int i10) {
        L(parcel, i10, 8);
        return parcel.readLong();
    }

    public static int H(@NonNull Parcel parcel, int i10) {
        return (i10 & SupportMenu.CATEGORY_MASK) != -65536 ? (char) (i10 >> 16) : parcel.readInt();
    }

    private static void K(Parcel parcel, int i10, int i11, int i12) {
        if (i11 == i12) {
            return;
        }
        throw new C0307a("Expected size " + i12 + " got " + i11 + " (0x" + Integer.toHexString(i11) + ")", parcel);
    }

    public static double y(@NonNull Parcel parcel, int i10) {
        L(parcel, i10, 8);
        return parcel.readDouble();
    }

    @NonNull
    public static Float B(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        if (iH == 0) {
            return null;
        }
        K(parcel, i10, iH, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int C(@NonNull Parcel parcel) {
        return parcel.readInt();
    }

    @NonNull
    public static IBinder D(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iH);
        return strongBinder;
    }

    @NonNull
    public static Long G(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        if (iH == 0) {
            return null;
        }
        K(parcel, i10, iH, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static void I(@NonNull Parcel parcel, int i10) {
        parcel.setDataPosition(parcel.dataPosition() + H(parcel, i10));
    }

    public static int J(@NonNull Parcel parcel) {
        int iC = C(parcel);
        int iH = H(parcel, iC);
        int iV = v(iC);
        int iDataPosition = parcel.dataPosition();
        if (iV == 20293) {
            int i10 = iH + iDataPosition;
            if (i10 >= iDataPosition && i10 <= parcel.dataSize()) {
                return i10;
            }
            throw new C0307a("Size read is invalid start=" + iDataPosition + " end=" + i10, parcel);
        }
        throw new C0307a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iC))), parcel);
    }

    private static void L(Parcel parcel, int i10, int i11) {
        int iH = H(parcel, i10);
        if (iH == i11) {
            return;
        }
        throw new C0307a("Expected size " + i11 + " got " + iH + " (0x" + Integer.toHexString(iH) + ")", parcel);
    }

    @NonNull
    public static BigDecimal a(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i11 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iH);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i11);
    }

    @NonNull
    public static BigDecimal[] b(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i12] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iH);
        return bigDecimalArr;
    }

    @NonNull
    public static BigInteger c(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iH);
        return new BigInteger(bArrCreateByteArray);
    }

    @NonNull
    public static BigInteger[] d(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bigIntegerArr[i12] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iH);
        return bigIntegerArr;
    }

    @NonNull
    public static boolean[] e(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iDataPosition + iH);
        return zArrCreateBooleanArray;
    }

    @NonNull
    public static Bundle f(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iH);
        return bundle;
    }

    @NonNull
    public static byte[] g(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iH);
        return bArrCreateByteArray;
    }

    @NonNull
    public static double[] h(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iDataPosition + iH);
        return dArrCreateDoubleArray;
    }

    @NonNull
    public static float[] i(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iDataPosition + iH);
        return fArrCreateFloatArray;
    }

    @NonNull
    public static int[] j(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iH);
        return iArrCreateIntArray;
    }

    @NonNull
    public static ArrayList<Integer> k(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i11 = parcel.readInt();
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(iDataPosition + iH);
        return arrayList;
    }

    @NonNull
    public static long[] l(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + iH);
        return jArrCreateLongArray;
    }

    @NonNull
    public static Parcel m(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iH);
        parcel.setDataPosition(iDataPosition + iH);
        return parcelObtain;
    }

    @NonNull
    public static Parcel[] n(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        int i11 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = parcel.readInt();
            if (i13 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i13);
                parcelArr[i12] = parcelObtain;
                parcel.setDataPosition(iDataPosition2 + i13);
            } else {
                parcelArr[i12] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iH);
        return parcelArr;
    }

    @NonNull
    public static <T extends Parcelable> T o(@NonNull Parcel parcel, int i10, @NonNull Parcelable.Creator<T> creator) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        T tCreateFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iH);
        return tCreateFromParcel;
    }

    @NonNull
    public static String p(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iH);
        return string;
    }

    @NonNull
    public static String[] q(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iH);
        return strArrCreateStringArray;
    }

    @NonNull
    public static ArrayList<String> r(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iH);
        return arrayListCreateStringArrayList;
    }

    @NonNull
    public static <T> T[] s(@NonNull Parcel parcel, int i10, @NonNull Parcelable.Creator<T> creator) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iH);
        return tArr;
    }

    @NonNull
    public static <T> ArrayList<T> t(@NonNull Parcel parcel, int i10, @NonNull Parcelable.Creator<T> creator) {
        int iH = H(parcel, i10);
        int iDataPosition = parcel.dataPosition();
        if (iH == 0) {
            return null;
        }
        ArrayList<T> arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iH);
        return arrayListCreateTypedArrayList;
    }

    public static void u(@NonNull Parcel parcel, int i10) {
        if (parcel.dataPosition() == i10) {
            return;
        }
        throw new C0307a("Overread allowed size end=" + i10, parcel);
    }

    @NonNull
    public static Boolean x(@NonNull Parcel parcel, int i10) {
        boolean z10;
        int iH = H(parcel, i10);
        if (iH == 0) {
            return null;
        }
        K(parcel, i10, iH, 4);
        if (parcel.readInt() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    @NonNull
    public static Double z(@NonNull Parcel parcel, int i10) {
        int iH = H(parcel, i10);
        if (iH == 0) {
            return null;
        }
        K(parcel, i10, iH, 8);
        return Double.valueOf(parcel.readDouble());
    }
}
