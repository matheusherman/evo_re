package n1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {
    public static void c(@NonNull Parcel parcel, int i10, boolean z10) {
        y(parcel, i10, 4);
        parcel.writeInt(z10 ? 1 : 0);
    }

    public static void h(@NonNull Parcel parcel, int i10, float f10) {
        y(parcel, i10, 4);
        parcel.writeFloat(f10);
    }

    public static void k(@NonNull Parcel parcel, int i10, int i11) {
        y(parcel, i10, 4);
        parcel.writeInt(i11);
    }

    public static void m(@NonNull Parcel parcel, int i10, @NonNull List<Integer> list, boolean z10) {
        if (list == null) {
            if (z10) {
                y(parcel, i10, 0);
                return;
            }
            return;
        }
        int iW = w(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeInt(list.get(i11).intValue());
        }
        x(parcel, iW);
    }

    public static void p(@NonNull Parcel parcel, int i10, @NonNull Parcel parcel2, boolean z10) {
        if (parcel2 == null) {
            if (z10) {
                y(parcel, i10, 0);
            }
        } else {
            int iW = w(parcel, i10);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            x(parcel, iW);
        }
    }

    public static <T extends Parcelable> void u(@NonNull Parcel parcel, int i10, @NonNull T[] tArr, int i11, boolean z10) {
        if (tArr == null) {
            if (z10) {
                y(parcel, i10, 0);
                return;
            }
            return;
        }
        int iW = w(parcel, i10);
        parcel.writeInt(tArr.length);
        for (T t10 : tArr) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                z(parcel, t10, i11);
            }
        }
        x(parcel, iW);
    }

    public static <T extends Parcelable> void v(@NonNull Parcel parcel, int i10, @NonNull List<T> list, boolean z10) {
        if (list == null) {
            if (z10) {
                y(parcel, i10, 0);
                return;
            }
            return;
        }
        int iW = w(parcel, i10);
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            T t10 = list.get(i11);
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                z(parcel, t10, 0);
            }
        }
        x(parcel, iW);
    }

    public static int a(@NonNull Parcel parcel) {
        return w(parcel, 20293);
    }

    public static void d(@NonNull Parcel parcel, int i10, @NonNull Boolean bool, boolean z10) {
        if (bool != null) {
            y(parcel, i10, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z10) {
            y(parcel, i10, 0);
        }
    }

    public static void e(@NonNull Parcel parcel, int i10, @NonNull Bundle bundle, boolean z10) {
        if (bundle == null) {
            if (z10) {
                y(parcel, i10, 0);
            }
        } else {
            int iW = w(parcel, i10);
            parcel.writeBundle(bundle);
            x(parcel, iW);
        }
    }

    public static void f(@NonNull Parcel parcel, int i10, @NonNull byte[] bArr, boolean z10) {
        if (bArr == null) {
            if (z10) {
                y(parcel, i10, 0);
            }
        } else {
            int iW = w(parcel, i10);
            parcel.writeByteArray(bArr);
            x(parcel, iW);
        }
    }

    public static void g(@NonNull Parcel parcel, int i10, @NonNull Double d10, boolean z10) {
        if (d10 != null) {
            y(parcel, i10, 8);
            parcel.writeDouble(d10.doubleValue());
        } else if (z10) {
            y(parcel, i10, 0);
        }
    }

    public static void i(@NonNull Parcel parcel, int i10, @NonNull Float f10, boolean z10) {
        if (f10 != null) {
            y(parcel, i10, 4);
            parcel.writeFloat(f10.floatValue());
        } else if (z10) {
            y(parcel, i10, 0);
        }
    }

    public static void j(@NonNull Parcel parcel, int i10, @NonNull IBinder iBinder, boolean z10) {
        if (iBinder == null) {
            if (z10) {
                y(parcel, i10, 0);
            }
        } else {
            int iW = w(parcel, i10);
            parcel.writeStrongBinder(iBinder);
            x(parcel, iW);
        }
    }

    public static void l(@NonNull Parcel parcel, int i10, @NonNull int[] iArr, boolean z10) {
        if (iArr == null) {
            if (z10) {
                y(parcel, i10, 0);
            }
        } else {
            int iW = w(parcel, i10);
            parcel.writeIntArray(iArr);
            x(parcel, iW);
        }
    }

    public static void n(@NonNull Parcel parcel, int i10, long j10) {
        y(parcel, i10, 8);
        parcel.writeLong(j10);
    }

    public static void o(@NonNull Parcel parcel, int i10, @NonNull Long l10, boolean z10) {
        if (l10 != null) {
            y(parcel, i10, 8);
            parcel.writeLong(l10.longValue());
        } else if (z10) {
            y(parcel, i10, 0);
        }
    }

    public static void q(@NonNull Parcel parcel, int i10, @NonNull Parcelable parcelable, int i11, boolean z10) {
        if (parcelable == null) {
            if (z10) {
                y(parcel, i10, 0);
            }
        } else {
            int iW = w(parcel, i10);
            parcelable.writeToParcel(parcel, i11);
            x(parcel, iW);
        }
    }

    public static void r(@NonNull Parcel parcel, int i10, @NonNull String str, boolean z10) {
        if (str == null) {
            if (z10) {
                y(parcel, i10, 0);
            }
        } else {
            int iW = w(parcel, i10);
            parcel.writeString(str);
            x(parcel, iW);
        }
    }

    public static void s(@NonNull Parcel parcel, int i10, @NonNull String[] strArr, boolean z10) {
        if (strArr == null) {
            if (z10) {
                y(parcel, i10, 0);
            }
        } else {
            int iW = w(parcel, i10);
            parcel.writeStringArray(strArr);
            x(parcel, iW);
        }
    }

    public static void t(@NonNull Parcel parcel, int i10, @NonNull List<String> list, boolean z10) {
        if (list == null) {
            if (z10) {
                y(parcel, i10, 0);
            }
        } else {
            int iW = w(parcel, i10);
            parcel.writeStringList(list);
            x(parcel, iW);
        }
    }

    private static int w(Parcel parcel, int i10) {
        parcel.writeInt(i10 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void y(Parcel parcel, int i10, int i11) {
        parcel.writeInt(i10 | (i11 << 16));
    }

    public static void b(@NonNull Parcel parcel, int i10) {
        x(parcel, i10);
    }

    private static void x(Parcel parcel, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(iDataPosition - i10);
        parcel.setDataPosition(iDataPosition);
    }

    private static void z(Parcel parcel, Parcelable parcelable, int i10) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i10);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}
