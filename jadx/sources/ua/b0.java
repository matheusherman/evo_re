package ua;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0010\r\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\u001a\u001d\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\n\u0010\u0003\u001a\u00020\u0001\"\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0012\u001a\u00020\r*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0014\u001a\u00020\r*\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0016\u001a\u00020\r*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0013\u001a#\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0015\u001a#\u0010\u0018\u001a\u00020\r*\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0015\u001a#\u0010\u0019\u001a\u00020\r*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u0013\u001a\u0019\u0010\u001b\u001a\u00020\r*\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0019\u0010\u001e\u001a\u00020\r*\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u001c\u001a;\u0010%\u001a\u00020\b*\u00020\u00002\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\bH\u0000¢\u0006\u0004\b%\u0010&\u001a#\u0010(\u001a\u00020\b*\u00020\u00002\u0006\u0010'\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b(\u0010)\u001a#\u0010*\u001a\u00020\b*\u00020\u00002\u0006\u0010'\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b*\u0010)\u001a#\u0010+\u001a\u00020\b*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b+\u0010,\u001a#\u0010-\u001a\u00020\b*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b-\u0010,\u001a-\u0010/\u001a\u00020\u001f*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010.\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b/\u00100\u001a-\u00101\u001a\u00020\u001f*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010.\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b1\u00100\u001a=\u00104\u001a\u00020\u001f*\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\b2\b\b\u0002\u00103\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u00105\u001aG\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\r\u0018\u000108*\u00020\u00002\f\u00107\u001a\b\u0012\u0004\u0012\u00020\r062\u0006\u0010.\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0002¢\u0006\u0004\b9\u0010:\u001a-\u0010;\u001a\u00020\u001f*\u00020\u00002\u0006\u0010'\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b;\u0010<\u001a-\u0010>\u001a\u00020\u001f*\u00020\u00002\u0006\u0010=\u001a\u00020\r2\b\b\u0002\u0010.\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b>\u0010?\u001a-\u0010@\u001a\u00020\u001f*\u00020\u00002\u0006\u0010'\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b@\u0010<\u001a-\u0010A\u001a\u00020\u001f*\u00020\u00002\u0006\u0010=\u001a\u00020\r2\b\b\u0002\u0010.\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\bA\u0010?\u001a&\u0010B\u001a\u00020\b*\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\bB\u0010,\u001a&\u0010C\u001a\u00020\b*\u00020\u00002\u0006\u0010'\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\bC\u0010)\u001a?\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000b0F*\u00020\u00002\u0006\u0010D\u001a\u00020\u00012\b\b\u0002\u0010.\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010E\u001a\u00020\u001fH\u0002¢\u0006\u0004\bG\u0010H\u001aG\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0F*\u00020\u00002\u000e\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I2\b\b\u0002\u0010.\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010E\u001a\u00020\u001fH\u0002¢\u0006\u0004\bJ\u0010K\u001a\u0017\u0010M\u001a\u00020L2\u0006\u0010E\u001a\u00020\u001fH\u0000¢\u0006\u0004\bM\u0010N\u001a?\u0010P\u001a\b\u0012\u0004\u0012\u00020\r0O*\u00020\u00002\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0I\"\u00020\r2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010E\u001a\u00020\u001f¢\u0006\u0004\bP\u0010Q\u001a7\u0010R\u001a\b\u0012\u0004\u0012\u00020\r0O*\u00020\u00002\n\u0010D\u001a\u00020\u0001\"\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010E\u001a\u00020\u001f¢\u0006\u0004\bR\u0010S\u001a1\u0010T\u001a\b\u0012\u0004\u0012\u00020\r0O*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010$\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u001fH\u0002¢\u0006\u0004\bT\u0010U\u001a\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020\r0F*\u00020\u0000¢\u0006\u0004\bV\u0010W\u001a\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020\r0O*\u00020\u0000¢\u0006\u0004\bX\u0010Y\"\u0015\u0010\\\u001a\u00020\u000b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bZ\u0010[\"\u0015\u0010_\u001a\u00020\u001f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b]\u0010^¨\u0006`"}, d2 = {"", "", "", "chars", "R0", "(Ljava/lang/CharSequence;[C)Ljava/lang/CharSequence;", "Q0", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "", "d0", "(Ljava/lang/CharSequence;)Z", "Lh9/e;", "range", "", "E0", "(Ljava/lang/CharSequence;Lh9/e;)Ljava/lang/String;", "delimiter", "missingDelimiterValue", "L0", "(Ljava/lang/String;CLjava/lang/String;)Ljava/lang/String;", "M0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "F0", "G0", "P0", "J0", "prefix", "s0", "(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;", "suffix", "t0", "", "thisOffset", TransactionPartnerType.OTHER, "otherOffset", "length", "ignoreCase", "r0", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "char", "A0", "(Ljava/lang/CharSequence;CZ)Z", "P", "B0", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "Q", "startIndex", "c0", "(Ljava/lang/CharSequence;[CIZ)I", "i0", "endIndex", "last", "Y", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "", "strings", "Lr8/p;", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lr8/p;", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/CharSequence;CIZ)I", TypedValues.Custom.S_STRING, "X", "(Ljava/lang/CharSequence;Ljava/lang/String;IZ)I", "e0", "f0", "M", "L", "delimiters", "limit", "Lta/h;", "l0", "(Ljava/lang/CharSequence;[CIZI)Lta/h;", "", "m0", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lta/h;", "Lr8/z;", "u0", "(I)V", "", "w0", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "v0", "(Ljava/lang/CharSequence;[CZI)Ljava/util/List;", "x0", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "j0", "(Ljava/lang/CharSequence;)Lta/h;", "k0", "(Ljava/lang/CharSequence;)Ljava/util/List;", "U", "(Ljava/lang/CharSequence;)Lh9/e;", "indices", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/lang/CharSequence;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class b0 extends y {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"ua/b0$a", "Lta/h;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements ta.h<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f19424a;

        public a(CharSequence charSequence) {
            this.f19424a = charSequence;
        }

        @Override // ta.h
        public Iterator<String> iterator() {
            return new f(this.f19424a);
        }
    }

    private static final r8.p<Integer, String> T(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        CharSequence charSequence2;
        Object next;
        boolean z12;
        Object next2;
        if (!z10 && collection.size() == 1) {
            String str = (String) kotlin.collections.r.E0(collection);
            int iB0 = !z11 ? b0(charSequence, str, i10, false, 4, null) : h0(charSequence, str, i10, false, 4, null);
            if (iB0 < 0) {
                return null;
            }
            return r8.v.a(Integer.valueOf(iB0), str);
        }
        CharSequence charSequence3 = charSequence;
        h9.c eVar = !z11 ? new h9.e(h9.f.c(i10, 0), charSequence3.length()) : h9.f.k(h9.f.e(i10, V(charSequence3)), 0);
        if (charSequence3 instanceof String) {
            int iF = eVar.getFirst();
            int iH = eVar.getLast();
            int i11 = eVar.getStep();
            if ((i11 > 0 && iF <= iH) || (i11 < 0 && iH <= iF)) {
                int i12 = iF;
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z12 = z10;
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        z12 = z10;
                        if (y.y(str2, 0, (String) charSequence3, i12, str2.length(), z12)) {
                            break;
                        }
                        z10 = z12;
                    }
                    String str3 = (String) next2;
                    if (str3 != null) {
                        return r8.v.a(Integer.valueOf(i12), str3);
                    }
                    if (i12 != iH) {
                        i12 += i11;
                        z10 = z12;
                    }
                }
            }
        } else {
            boolean z13 = z10;
            int iF2 = eVar.getFirst();
            int iH2 = eVar.getLast();
            int i13 = eVar.getStep();
            if ((i13 > 0 && iF2 <= iH2) || (i13 < 0 && iH2 <= iF2)) {
                int i14 = iF2;
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            charSequence2 = charSequence3;
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        boolean z14 = z13;
                        charSequence2 = charSequence3;
                        z13 = z14;
                        if (r0(str4, 0, charSequence2, i14, str4.length(), z14)) {
                            break;
                        }
                        charSequence3 = charSequence2;
                    }
                    String str5 = (String) next;
                    if (str5 != null) {
                        return r8.v.a(Integer.valueOf(i14), str5);
                    }
                    if (i14 != iH2) {
                        i14 += i13;
                        charSequence3 = charSequence2;
                    }
                }
            }
        }
        return null;
    }

    private static final int Y(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        h9.c eVar = !z11 ? new h9.e(h9.f.c(i10, 0), h9.f.e(i11, charSequence.length())) : h9.f.k(h9.f.e(i10, V(charSequence)), h9.f.c(i11, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iF = eVar.getFirst();
            int iH = eVar.getLast();
            int i12 = eVar.getStep();
            if ((i12 <= 0 || iF > iH) && (i12 >= 0 || iH > iF)) {
                return -1;
            }
            int i13 = iF;
            while (true) {
                String str = (String) charSequence2;
                boolean z12 = z10;
                if (y.y(str, 0, (String) charSequence, i13, str.length(), z12)) {
                    return i13;
                }
                if (i13 == iH) {
                    return -1;
                }
                i13 += i12;
                z10 = z12;
            }
        } else {
            boolean z13 = z10;
            int iF2 = eVar.getFirst();
            int iH2 = eVar.getLast();
            int i14 = eVar.getStep();
            if ((i14 <= 0 || iF2 > iH2) && (i14 >= 0 || iH2 > iF2)) {
                return -1;
            }
            int i15 = iF2;
            while (true) {
                boolean z14 = z13;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z13 = z14;
                if (r0(charSequence4, 0, charSequence3, i15, charSequence2.length(), z14)) {
                    return i15;
                }
                if (i15 == iH2) {
                    return -1;
                }
                i15 += i14;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static final boolean A0(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        return charSequence.length() > 0 && c.d(charSequence.charAt(0), c10, z10);
    }

    public static final boolean B0(CharSequence charSequence, CharSequence prefix, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        return (!z10 && (charSequence instanceof String) && (prefix instanceof String)) ? y.I((String) charSequence, (String) prefix, false, 2, null) : r0(charSequence, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean C0(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return A0(charSequence, c10, z10);
    }

    public static /* synthetic */ boolean D0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return B0(charSequence, charSequence2, z10);
    }

    public static final String E0(CharSequence charSequence, h9.e range) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static final String F0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(missingDelimiterValue, "missingDelimiterValue");
        int iA0 = a0(str, c10, 0, false, 6, null);
        if (iA0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iA0 + 1, str.length());
        kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String G0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(delimiter, "delimiter");
        kotlin.jvm.internal.m.f(missingDelimiterValue, "missingDelimiterValue");
        int iB0 = b0(str, delimiter, 0, false, 6, null);
        if (iB0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iB0 + delimiter.length(), str.length());
        kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String H0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return F0(str, c10, str2);
    }

    public static /* synthetic */ String I0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return G0(str, str2, str3);
    }

    public static final String J0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(missingDelimiterValue, "missingDelimiterValue");
        int iG0 = g0(str, c10, 0, false, 6, null);
        if (iG0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iG0 + 1, str.length());
        kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String K0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return J0(str, c10, str2);
    }

    public static final boolean L(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        return a0(charSequence, c10, 0, z10, 2, null) >= 0;
    }

    public static final String L0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(missingDelimiterValue, "missingDelimiterValue");
        int iA0 = a0(str, c10, 0, false, 6, null);
        if (iA0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iA0);
        kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static boolean M(CharSequence charSequence, CharSequence other, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(other, "other");
        if (other instanceof String) {
            return b0(charSequence, (String) other, 0, z10, 2, null) >= 0;
        }
        return Z(charSequence, other, 0, charSequence.length(), z10, false, 16, null) >= 0;
    }

    public static final String M0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(delimiter, "delimiter");
        kotlin.jvm.internal.m.f(missingDelimiterValue, "missingDelimiterValue");
        int iB0 = b0(str, delimiter, 0, false, 6, null);
        if (iB0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iB0);
        kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean N(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return L(charSequence, c10, z10);
    }

    public static /* synthetic */ String N0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return L0(str, c10, str2);
    }

    public static /* synthetic */ boolean O(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return M(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ String O0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return M0(str, str2, str3);
    }

    public static final boolean P(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        return charSequence.length() > 0 && c.d(charSequence.charAt(V(charSequence)), c10, z10);
    }

    public static String P0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(delimiter, "delimiter");
        kotlin.jvm.internal.m.f(missingDelimiterValue, "missingDelimiterValue");
        int iH0 = h0(str, delimiter, 0, false, 6, null);
        if (iH0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iH0);
        kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean Q(CharSequence charSequence, CharSequence suffix, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(suffix, "suffix");
        return (!z10 && (charSequence instanceof String) && (suffix instanceof String)) ? y.v((String) charSequence, (String) suffix, false, 2, null) : r0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z10);
    }

    public static CharSequence Q0(CharSequence charSequence) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zC = b.c(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static /* synthetic */ boolean R(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return P(charSequence, c10, z10);
    }

    public static CharSequence R0(CharSequence charSequence, char... chars) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(chars, "chars");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zH = kotlin.collections.j.H(chars, charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zH) {
                    break;
                }
                length--;
            } else if (zH) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static /* synthetic */ boolean S(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return Q(charSequence, charSequence2, z10);
    }

    public static h9.e U(CharSequence charSequence) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        return new h9.e(0, charSequence.length() - 1);
    }

    public static int V(CharSequence charSequence) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int W(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? c0(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    public static final int X(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(string, "string");
        return (z10 || !(charSequence instanceof String)) ? Z(charSequence, string, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(string, i10);
    }

    static /* synthetic */ int Z(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        return Y(charSequence, charSequence2, i10, i11, z10, (i12 & 16) != 0 ? false : z11);
    }

    public static /* synthetic */ int a0(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return W(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int b0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return X(charSequence, str, i10, z10);
    }

    public static final int c0(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.j.m0(chars), i10);
        }
        int iC = h9.f.c(i10, 0);
        int iV = V(charSequence);
        if (iC > iV) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iC);
            for (char c10 : chars) {
                if (c.d(c10, cCharAt, z10)) {
                    return iC;
                }
            }
            if (iC == iV) {
                return -1;
            }
            iC++;
        }
    }

    public static boolean d0(CharSequence charSequence) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!b.c(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static final int e0(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? i0(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    public static final int f0(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(string, "string");
        return (z10 || !(charSequence instanceof String)) ? Y(charSequence, string, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(string, i10);
    }

    public static /* synthetic */ int g0(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = V(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return e0(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int h0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = V(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return f0(charSequence, str, i10, z10);
    }

    public static final int i0(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.j.m0(chars), i10);
        }
        for (int iE = h9.f.e(i10, V(charSequence)); -1 < iE; iE--) {
            char cCharAt = charSequence.charAt(iE);
            for (char c10 : chars) {
                if (c.d(c10, cCharAt, z10)) {
                    return iE;
                }
            }
        }
        return -1;
    }

    public static final ta.h<String> j0(CharSequence charSequence) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final List<String> k0(CharSequence charSequence) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        return ta.k.P(j0(charSequence));
    }

    static /* synthetic */ ta.h n0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return l0(charSequence, cArr, i10, z10, i11);
    }

    static /* synthetic */ ta.h o0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return m0(charSequence, strArr, i10, z10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.p p0(char[] cArr, boolean z10, CharSequence DelimitedRangesSequence, int i10) {
        kotlin.jvm.internal.m.f(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int iC0 = c0(DelimitedRangesSequence, cArr, i10, z10);
        if (iC0 < 0) {
            return null;
        }
        return r8.v.a(Integer.valueOf(iC0), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.p q0(List list, boolean z10, CharSequence DelimitedRangesSequence, int i10) {
        kotlin.jvm.internal.m.f(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        r8.p<Integer, String> pVarT = T(DelimitedRangesSequence, list, i10, z10, false);
        if (pVarT != null) {
            return r8.v.a(pVarT.c(), Integer.valueOf(pVarT.d().length()));
        }
        return null;
    }

    public static final boolean r0(CharSequence charSequence, int i10, CharSequence other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!c.d(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static String s0(String str, CharSequence prefix) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        if (!D0(str, prefix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String t0(String str, CharSequence suffix) {
        kotlin.jvm.internal.m.f(str, "<this>");
        kotlin.jvm.internal.m.f(suffix, "suffix");
        if (!S(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void u0(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }

    public static final List<String> v0(CharSequence charSequence, char[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return x0(charSequence, String.valueOf(delimiters[0]), z10, i10);
        }
        Iterable iterableU = ta.k.u(n0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(iterableU, 10));
        Iterator it = iterableU.iterator();
        while (it.hasNext()) {
            arrayList.add(E0(charSequence, (h9.e) it.next()));
        }
        return arrayList;
    }

    public static final List<String> w0(CharSequence charSequence, String[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.m.f(charSequence, "<this>");
        kotlin.jvm.internal.m.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return x0(charSequence, str, z10, i10);
            }
        }
        Iterable iterableU = ta.k.u(o0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.r.w(iterableU, 10));
        Iterator it = iterableU.iterator();
        while (it.hasNext()) {
            arrayList.add(E0(charSequence, (h9.e) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ List y0(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return v0(charSequence, cArr, z10, i10);
    }

    public static /* synthetic */ List z0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return w0(charSequence, strArr, z10, i10);
    }

    private static final ta.h<h9.e> l0(CharSequence charSequence, final char[] cArr, int i10, final boolean z10, int i11) {
        u0(i11);
        return new e(charSequence, i10, i11, new c9.p() { // from class: ua.z
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return b0.p0(cArr, z10, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    private static final ta.h<h9.e> m0(CharSequence charSequence, String[] strArr, int i10, final boolean z10, int i11) {
        u0(i11);
        final List listD = kotlin.collections.j.d(strArr);
        return new e(charSequence, i10, i11, new c9.p() { // from class: ua.a0
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return b0.q0(listD, z10, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    private static final List<String> x0(CharSequence charSequence, String str, boolean z10, int i10) {
        boolean z11;
        u0(i10);
        int length = 0;
        int iX = X(charSequence, str, 0, z10);
        if (iX != -1 && i10 != 1) {
            if (i10 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            int iE = 10;
            if (z11) {
                iE = h9.f.e(i10, 10);
            }
            ArrayList arrayList = new ArrayList(iE);
            do {
                arrayList.add(charSequence.subSequence(length, iX).toString());
                length = str.length() + iX;
                if (z11 && arrayList.size() == i10 - 1) {
                    break;
                }
                iX = X(charSequence, str, length, z10);
            } while (iX != -1);
            arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
            return arrayList;
        }
        return kotlin.collections.r.e(charSequence.toString());
    }
}
