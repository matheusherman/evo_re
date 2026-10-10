package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class u implements s, Iterable<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3091a;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:101:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:103:0x01cd A[PHI: r4
      0x01cd: PHI (r4v8 java.lang.String) = (r4v7 java.lang.String), (r4v9 java.lang.String) binds: [B:102:0x01cb, B:98:0x01bc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:104:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:108:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:109:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:111:0x01f1 A[PHI: r4 r7
      0x01f1: PHI (r4v5 java.lang.String) = (r4v4 java.lang.String), (r4v6 java.lang.String) binds: [B:110:0x01ef, B:106:0x01de] A[DONT_GENERATE, DONT_INLINE]
      0x01f1: PHI (r7v2 java.lang.String) = (r7v1 java.lang.String), (r7v3 java.lang.String) binds: [B:110:0x01ef, B:106:0x01de] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:112:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:115:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:117:0x0203  */
    /* JADX WARN: Code duplicated, block: B:119:0x0213  */
    /* JADX WARN: Code duplicated, block: B:120:0x021c  */
    /* JADX WARN: Code duplicated, block: B:124:0x0235  */
    /* JADX WARN: Code duplicated, block: B:127:0x025c  */
    /* JADX WARN: Code duplicated, block: B:129:0x0272  */
    /* JADX WARN: Code duplicated, block: B:131:0x0288  */
    /* JADX WARN: Code duplicated, block: B:135:0x029c  */
    /* JADX WARN: Code duplicated, block: B:137:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:138:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:141:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:143:0x0304  */
    /* JADX WARN: Code duplicated, block: B:144:0x031d  */
    /* JADX WARN: Code duplicated, block: B:147:0x0325  */
    /* JADX WARN: Code duplicated, block: B:149:0x033e  */
    /* JADX WARN: Code duplicated, block: B:152:0x036d  */
    /* JADX WARN: Code duplicated, block: B:154:0x037f  */
    /* JADX WARN: Code duplicated, block: B:156:0x038b  */
    /* JADX WARN: Code duplicated, block: B:158:0x0397  */
    /* JADX WARN: Code duplicated, block: B:159:0x039c  */
    /* JADX WARN: Code duplicated, block: B:161:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:162:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:165:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:167:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:174:0x0405  */
    /* JADX WARN: Code duplicated, block: B:177:0x040c  */
    /* JADX WARN: Code duplicated, block: B:179:0x0410 A[LOOP:0: B:178:0x040e->B:179:0x0410, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:182:0x0423  */
    /* JADX WARN: Code duplicated, block: B:184:0x0435  */
    /* JADX WARN: Code duplicated, block: B:185:0x0449  */
    /* JADX WARN: Code duplicated, block: B:188:0x0452  */
    /* JADX WARN: Code duplicated, block: B:189:0x045d  */
    /* JADX WARN: Code duplicated, block: B:192:0x046e  */
    /* JADX WARN: Code duplicated, block: B:193:0x0481  */
    /* JADX WARN: Code duplicated, block: B:196:0x048e  */
    /* JADX WARN: Code duplicated, block: B:197:0x0499  */
    /* JADX WARN: Code duplicated, block: B:200:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:202:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:203:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:206:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:208:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:210:0x04fe  */
    /* JADX WARN: Code duplicated, block: B:212:0x0512  */
    /* JADX WARN: Code duplicated, block: B:214:0x0528  */
    /* JADX WARN: Code duplicated, block: B:216:0x053a  */
    /* JADX WARN: Code duplicated, block: B:217:0x0541  */
    /* JADX WARN: Code duplicated, block: B:220:0x0557  */
    /* JADX WARN: Code duplicated, block: B:221:0x055a  */
    /* JADX WARN: Code duplicated, block: B:224:0x0573  */
    /* JADX WARN: Code duplicated, block: B:225:0x0576  */
    /* JADX WARN: Code duplicated, block: B:228:0x058a  */
    /* JADX WARN: Code duplicated, block: B:230:0x059e  */
    /* JADX WARN: Code duplicated, block: B:232:0x05af  */
    /* JADX WARN: Code duplicated, block: B:233:0x05be  */
    /* JADX WARN: Code duplicated, block: B:236:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:238:0x05e3  */
    /* JADX WARN: Code duplicated, block: B:240:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:242:0x0605  */
    /* JADX WARN: Code duplicated, block: B:245:0x0612  */
    /* JADX WARN: Code duplicated, block: B:248:0x0620 A[LOOP:1: B:246:0x061a->B:248:0x0620, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:251:0x063e  */
    /* JADX WARN: Code duplicated, block: B:253:0x064e  */
    /* JADX WARN: Code duplicated, block: B:254:0x0667  */
    /* JADX WARN: Code duplicated, block: B:264:0x0684  */
    /* JADX WARN: Code duplicated, block: B:266:0x0699  */
    /* JADX WARN: Code duplicated, block: B:268:0x06a2  */
    /* JADX WARN: Code duplicated, block: B:270:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:272:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:49:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:57:0x0101  */
    /* JADX WARN: Code duplicated, block: B:60:0x0108  */
    /* JADX WARN: Code duplicated, block: B:61:0x0113  */
    /* JADX WARN: Code duplicated, block: B:64:0x011a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0125  */
    /* JADX WARN: Code duplicated, block: B:68:0x012c  */
    /* JADX WARN: Code duplicated, block: B:69:0x0137  */
    /* JADX WARN: Code duplicated, block: B:72:0x013e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0149  */
    /* JADX WARN: Code duplicated, block: B:76:0x0151  */
    /* JADX WARN: Code duplicated, block: B:77:0x015c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0164  */
    /* JADX WARN: Code duplicated, block: B:81:0x016f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0177  */
    /* JADX WARN: Code duplicated, block: B:85:0x0181  */
    /* JADX WARN: Code duplicated, block: B:88:0x0189  */
    /* JADX WARN: Code duplicated, block: B:89:0x0193  */
    /* JADX WARN: Code duplicated, block: B:92:0x019b  */
    /* JADX WARN: Code duplicated, block: B:93:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:97:0x01b6  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.s
    public final s k(String str, v6 v6Var, List<s> list) {
        String str2;
        String str3;
        byte b10;
        String str4;
        String str5;
        String str6;
        s sVarB;
        int i10;
        int iA;
        u uVar;
        StringBuilder sb2;
        int i11;
        String strF;
        String strF2;
        double dDoubleValue;
        double dA;
        String strF3;
        String str7;
        double dDoubleValue2;
        double dA2;
        double dMin;
        double length;
        double dA3;
        double dMin2;
        String str8;
        ArrayList arrayList;
        String strF4;
        long jM;
        String[] strArrSplit;
        int length2;
        int i12;
        boolean zIsEmpty;
        String str9;
        int iA2;
        int length3;
        s sVarA;
        String strF5;
        String str10;
        int iIndexOf;
        int i13;
        v6 v6Var2;
        String strF6;
        String str11 = "toLocaleLowerCase";
        if (!"charAt".equals(str) && !"concat".equals(str) && !"hasOwnProperty".equals(str) && !"indexOf".equals(str) && !"lastIndexOf".equals(str) && !"match".equals(str) && !"replace".equals(str) && !"search".equals(str) && !"slice".equals(str) && !"split".equals(str) && !"substring".equals(str) && !"toLowerCase".equals(str) && !"toLocaleLowerCase".equals(str) && !"toString".equals(str) && !"toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                str3 = "trim";
                if (!str3.equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
            }
            str.getClass();
            b10 = -1;
            switch (str.hashCode()) {
                case -1789698943:
                    str4 = "charAt";
                    str5 = "toString";
                    if (str.equals("hasOwnProperty")) {
                        str11 = "toLocaleLowerCase";
                        b10 = 0;
                    } else {
                        str11 = "toLocaleLowerCase";
                    }
                    break;
                case -1776922004:
                    str4 = "charAt";
                    str5 = "toString";
                    if (str.equals(str5)) {
                        str11 = "toLocaleLowerCase";
                        b10 = 1;
                    } else {
                        str11 = "toLocaleLowerCase";
                    }
                    break;
                case -1464939364:
                    str4 = "charAt";
                    if (str.equals("toLocaleLowerCase")) {
                        str11 = "toLocaleLowerCase";
                        str5 = "toString";
                        b10 = 2;
                    } else {
                        str5 = "toString";
                    }
                    break;
                case -1361633751:
                    str4 = "charAt";
                    if (str.equals(str4)) {
                        str11 = "toLocaleLowerCase";
                        str5 = "toString";
                        b10 = 3;
                    } else {
                        str5 = "toString";
                    }
                    break;
                case -1354795244:
                    if (str.equals("concat")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 4;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case -1137582698:
                    if (str.equals("toLowerCase")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 5;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case -906336856:
                    if (str.equals("search")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 6;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case -726908483:
                    if (str.equals(str2)) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 7;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case -467511597:
                    if (str.equals("lastIndexOf")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 8;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case -399551817:
                    if (str.equals("toUpperCase")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 9;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case 3568674:
                    if (str.equals(str3)) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 10;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case 103668165:
                    if (str.equals("match")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 11;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case 109526418:
                    if (str.equals("slice")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 12;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case 109648666:
                    if (str.equals("split")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 13;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case 530542161:
                    if (str.equals("substring")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 14;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case 1094496948:
                    if (str.equals("replace")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 15;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                case 1943291465:
                    if (str.equals("indexOf")) {
                        str11 = "toLocaleLowerCase";
                        str4 = "charAt";
                        str5 = "toString";
                        b10 = 16;
                    } else {
                        str4 = "charAt";
                        str5 = "toString";
                    }
                    break;
                default:
                    str4 = "charAt";
                    str5 = "toString";
                    break;
            }
            switch (b10) {
                case 0:
                    c5.g("hasOwnProperty", 1, list);
                    str6 = this.f3091a;
                    sVarB = v6Var.b(list.get(0));
                    if ("length".equals(sVarB.f())) {
                        return s.f3015f0;
                    }
                    double dDoubleValue3 = sVarB.g().doubleValue();
                    return (dDoubleValue3 == Math.floor(dDoubleValue3) || (i10 = (int) dDoubleValue3) < 0 || i10 >= str6.length()) ? s.f3016g0 : s.f3015f0;
                case 1:
                    c5.g(str5, 0, list);
                    return this;
                case 2:
                    c5.g(str11, 0, list);
                    return new u(this.f3091a.toLowerCase());
                case 3:
                    c5.n(str4, 1, list);
                    if (list.isEmpty()) {
                        iA = 0;
                    } else {
                        iA = (int) c5.a(v6Var.b(list.get(0)).g().doubleValue());
                    }
                    String str12 = this.f3091a;
                    return (iA >= 0 || iA >= str12.length()) ? s.f3017h0 : new u(String.valueOf(str12.charAt(iA)));
                case 4:
                    uVar = this;
                    if (!list.isEmpty()) {
                        sb2 = new StringBuilder(uVar.f3091a);
                        for (i11 = 0; i11 < list.size(); i11++) {
                            sb2.append(v6Var.b(list.get(i11)).f());
                        }
                        return new u(sb2.toString());
                    }
                    return uVar;
                case 5:
                    c5.g("toLowerCase", 0, list);
                    return new u(this.f3091a.toLowerCase(Locale.ENGLISH));
                case 6:
                    c5.n("search", 1, list);
                    if (list.isEmpty()) {
                        strF = s.f3010a0.f();
                    } else {
                        strF = v6Var.b(list.get(0)).f();
                    }
                    Matcher matcher = Pattern.compile(strF).matcher(this.f3091a);
                    return matcher.find() ? new k(Double.valueOf(matcher.start())) : new k(Double.valueOf(-1.0d));
                case 7:
                    c5.g(str2, 0, list);
                    return new u(this.f3091a.toUpperCase());
                case 8:
                    c5.n("lastIndexOf", 2, list);
                    String str13 = this.f3091a;
                    if (list.size() <= 0) {
                        strF2 = s.f3010a0.f();
                    } else {
                        strF2 = v6Var.b(list.get(0)).f();
                    }
                    if (list.size() < 2) {
                        dDoubleValue = Double.NaN;
                    } else {
                        dDoubleValue = v6Var.b(list.get(1)).g().doubleValue();
                    }
                    if (Double.isNaN(dDoubleValue)) {
                        dA = Double.POSITIVE_INFINITY;
                    } else {
                        dA = c5.a(dDoubleValue);
                    }
                    return new k(Double.valueOf(str13.lastIndexOf(strF2, (int) dA)));
                case 9:
                    c5.g("toUpperCase", 0, list);
                    return new u(this.f3091a.toUpperCase(Locale.ENGLISH));
                case 10:
                    c5.g("toUpperCase", 0, list);
                    return new u(this.f3091a.trim());
                case 11:
                    c5.n("match", 1, list);
                    String str14 = this.f3091a;
                    if (list.size() <= 0) {
                        strF3 = "";
                    } else {
                        strF3 = v6Var.b(list.get(0)).f();
                    }
                    Matcher matcher2 = Pattern.compile(strF3).matcher(str14);
                    return matcher2.find() ? new g(new u(matcher2.group())) : s.f3011b0;
                case 12:
                    c5.n("slice", 2, list);
                    str7 = this.f3091a;
                    if (list.isEmpty()) {
                        dDoubleValue2 = 0.0d;
                    } else {
                        dDoubleValue2 = v6Var.b(list.get(0)).g().doubleValue();
                    }
                    dA2 = c5.a(dDoubleValue2);
                    if (dA2 < 0.0d) {
                        dMin = Math.max(((double) str7.length()) + dA2, 0.0d);
                    } else {
                        dMin = Math.min(dA2, str7.length());
                    }
                    int i14 = (int) dMin;
                    if (list.size() > 1) {
                        length = v6Var.b(list.get(1)).g().doubleValue();
                    } else {
                        length = str7.length();
                    }
                    dA3 = c5.a(length);
                    if (dA3 < 0.0d) {
                        dMin2 = Math.max(((double) str7.length()) + dA3, 0.0d);
                    } else {
                        dMin2 = Math.min(dA3, str7.length());
                    }
                    return new u(str7.substring(i14, Math.max(0, ((int) dMin2) - i14) + i14));
                case 13:
                    c5.n("split", 2, list);
                    str8 = this.f3091a;
                    if (str8.length() == 0) {
                        return new g(this);
                    }
                    arrayList = new ArrayList();
                    if (list.isEmpty()) {
                        arrayList.add(this);
                    } else {
                        strF4 = v6Var.b(list.get(0)).f();
                        if (list.size() > 1) {
                            jM = c5.m(v6Var.b(list.get(1)).g().doubleValue());
                        } else {
                            jM = 2147483647L;
                        }
                        if (jM == 0) {
                            return new g();
                        }
                        strArrSplit = str8.split(Pattern.quote(strF4), ((int) jM) + 1);
                        length2 = strArrSplit.length;
                        if (strF4.isEmpty() || strArrSplit.length <= 0) {
                            i12 = 0;
                        } else {
                            zIsEmpty = strArrSplit[0].isEmpty();
                            if (strArrSplit[strArrSplit.length - 1].isEmpty()) {
                                i12 = zIsEmpty;
                                length2 = strArrSplit.length - 1;
                                i12 = zIsEmpty;
                            }
                        }
                        i12 = zIsEmpty;
                        if (strArrSplit.length > jM) {
                            length2--;
                        }
                        while (i12 < length2) {
                            arrayList.add(new u(strArrSplit[i12]));
                            i12++;
                        }
                    }
                    return new g(arrayList);
                case 14:
                    c5.n("substring", 2, list);
                    str9 = this.f3091a;
                    if (list.isEmpty()) {
                        iA2 = 0;
                    } else {
                        iA2 = (int) c5.a(v6Var.b(list.get(0)).g().doubleValue());
                    }
                    if (list.size() > 1) {
                        length3 = (int) c5.a(v6Var.b(list.get(1)).g().doubleValue());
                    } else {
                        length3 = str9.length();
                    }
                    int iMin = Math.min(Math.max(iA2, 0), str9.length());
                    int iMin2 = Math.min(Math.max(length3, 0), str9.length());
                    return new u(str9.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
                case 15:
                    uVar = this;
                    c5.n("replace", 2, list);
                    sVarA = s.f3010a0;
                    strF5 = sVarA.f();
                    if (!list.isEmpty()) {
                        strF5 = v6Var.b(list.get(0)).f();
                        if (list.size() > 1) {
                            sVarA = v6Var.b(list.get(1));
                        }
                    }
                    str10 = uVar.f3091a;
                    iIndexOf = str10.indexOf(strF5);
                    if (iIndexOf >= 0) {
                        if (sVarA instanceof n) {
                            i13 = 0;
                            sVarA = ((n) sVarA).a(v6Var, Arrays.asList(new u(strF5), new k(Double.valueOf(iIndexOf)), uVar));
                        } else {
                            i13 = 0;
                        }
                        return new u(str10.substring(i13, iIndexOf) + sVarA.f() + str10.substring(iIndexOf + strF5.length()));
                    }
                    return uVar;
                case 16:
                    c5.n("indexOf", 2, list);
                    String str15 = this.f3091a;
                    if (list.size() <= 0) {
                        strF6 = s.f3010a0.f();
                        v6Var2 = v6Var;
                    } else {
                        v6Var2 = v6Var;
                        strF6 = v6Var2.b(list.get(0)).f();
                    }
                    return new k(Double.valueOf(str15.indexOf(strF6, (int) c5.a(list.size() >= 2 ? v6Var2.b(list.get(1)).g().doubleValue() : 0.0d))));
                default:
                    throw new IllegalArgumentException("Command not supported");
            }
        }
        str2 = "toLocaleUpperCase";
        str3 = "trim";
        str.getClass();
        b10 = -1;
        switch (str.hashCode()) {
            case -1789698943:
                str4 = "charAt";
                str5 = "toString";
                if (str.equals("hasOwnProperty")) {
                    str11 = "toLocaleLowerCase";
                } else {
                    str11 = "toLocaleLowerCase";
                    b10 = 0;
                }
                break;
            case -1776922004:
                str4 = "charAt";
                str5 = "toString";
                if (str.equals(str5)) {
                    str11 = "toLocaleLowerCase";
                } else {
                    str11 = "toLocaleLowerCase";
                    b10 = 1;
                }
                break;
            case -1464939364:
                str4 = "charAt";
                if (str.equals("toLocaleLowerCase")) {
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str5 = "toString";
                    b10 = 2;
                }
                break;
            case -1361633751:
                str4 = "charAt";
                if (str.equals(str4)) {
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str5 = "toString";
                    b10 = 3;
                }
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 4;
                }
                break;
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 5;
                }
                break;
            case -906336856:
                if (str.equals("search")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 6;
                }
                break;
            case -726908483:
                if (str.equals(str2)) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 7;
                }
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 8;
                }
                break;
            case -399551817:
                if (str.equals("toUpperCase")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 9;
                }
                break;
            case 3568674:
                if (str.equals(str3)) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 10;
                }
                break;
            case 103668165:
                if (str.equals("match")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 11;
                }
                break;
            case 109526418:
                if (str.equals("slice")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 12;
                }
                break;
            case 109648666:
                if (str.equals("split")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 13;
                }
                break;
            case 530542161:
                if (str.equals("substring")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 14;
                }
                break;
            case 1094496948:
                if (str.equals("replace")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 15;
                }
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    str4 = "charAt";
                    str5 = "toString";
                } else {
                    str11 = "toLocaleLowerCase";
                    str4 = "charAt";
                    str5 = "toString";
                    b10 = 16;
                }
                break;
            default:
                str4 = "charAt";
                str5 = "toString";
                break;
        }
        switch (b10) {
            case 0:
                c5.g("hasOwnProperty", 1, list);
                str6 = this.f3091a;
                sVarB = v6Var.b(list.get(0));
                if ("length".equals(sVarB.f())) {
                    return s.f3015f0;
                }
                double dDoubleValue4 = sVarB.g().doubleValue();
                if (dDoubleValue4 == Math.floor(dDoubleValue4)) {
                }
                break;
            case 1:
                c5.g(str5, 0, list);
                return this;
            case 2:
                c5.g(str11, 0, list);
                return new u(this.f3091a.toLowerCase());
            case 3:
                c5.n(str4, 1, list);
                if (list.isEmpty()) {
                    iA = (int) c5.a(v6Var.b(list.get(0)).g().doubleValue());
                } else {
                    iA = 0;
                }
                String str16 = this.f3091a;
                if (iA >= 0) {
                }
                break;
            case 4:
                uVar = this;
                if (!list.isEmpty()) {
                    sb2 = new StringBuilder(uVar.f3091a);
                    while (i11 < list.size()) {
                        sb2.append(v6Var.b(list.get(i11)).f());
                    }
                    return new u(sb2.toString());
                }
                return uVar;
            case 5:
                c5.g("toLowerCase", 0, list);
                return new u(this.f3091a.toLowerCase(Locale.ENGLISH));
            case 6:
                c5.n("search", 1, list);
                if (list.isEmpty()) {
                    strF = v6Var.b(list.get(0)).f();
                } else {
                    strF = s.f3010a0.f();
                }
                Matcher matcher3 = Pattern.compile(strF).matcher(this.f3091a);
                if (matcher3.find()) {
                }
            case 7:
                c5.g(str2, 0, list);
                return new u(this.f3091a.toUpperCase());
            case 8:
                c5.n("lastIndexOf", 2, list);
                String str17 = this.f3091a;
                if (list.size() <= 0) {
                    strF2 = s.f3010a0.f();
                } else {
                    strF2 = v6Var.b(list.get(0)).f();
                }
                if (list.size() < 2) {
                    dDoubleValue = Double.NaN;
                } else {
                    dDoubleValue = v6Var.b(list.get(1)).g().doubleValue();
                }
                if (Double.isNaN(dDoubleValue)) {
                    dA = Double.POSITIVE_INFINITY;
                } else {
                    dA = c5.a(dDoubleValue);
                }
                return new k(Double.valueOf(str17.lastIndexOf(strF2, (int) dA)));
            case 9:
                c5.g("toUpperCase", 0, list);
                return new u(this.f3091a.toUpperCase(Locale.ENGLISH));
            case 10:
                c5.g("toUpperCase", 0, list);
                return new u(this.f3091a.trim());
            case 11:
                c5.n("match", 1, list);
                String str18 = this.f3091a;
                if (list.size() <= 0) {
                    strF3 = "";
                } else {
                    strF3 = v6Var.b(list.get(0)).f();
                }
                Matcher matcher4 = Pattern.compile(strF3).matcher(str18);
                if (matcher4.find()) {
                }
            case 12:
                c5.n("slice", 2, list);
                str7 = this.f3091a;
                if (list.isEmpty()) {
                    dDoubleValue2 = v6Var.b(list.get(0)).g().doubleValue();
                } else {
                    dDoubleValue2 = 0.0d;
                }
                dA2 = c5.a(dDoubleValue2);
                if (dA2 < 0.0d) {
                    dMin = Math.max(((double) str7.length()) + dA2, 0.0d);
                } else {
                    dMin = Math.min(dA2, str7.length());
                }
                int i15 = (int) dMin;
                if (list.size() > 1) {
                    length = v6Var.b(list.get(1)).g().doubleValue();
                } else {
                    length = str7.length();
                }
                dA3 = c5.a(length);
                if (dA3 < 0.0d) {
                    dMin2 = Math.max(((double) str7.length()) + dA3, 0.0d);
                } else {
                    dMin2 = Math.min(dA3, str7.length());
                }
                return new u(str7.substring(i15, Math.max(0, ((int) dMin2) - i15) + i15));
            case 13:
                c5.n("split", 2, list);
                str8 = this.f3091a;
                if (str8.length() == 0) {
                    return new g(this);
                }
                arrayList = new ArrayList();
                if (list.isEmpty()) {
                    arrayList.add(this);
                } else {
                    strF4 = v6Var.b(list.get(0)).f();
                    if (list.size() > 1) {
                        jM = c5.m(v6Var.b(list.get(1)).g().doubleValue());
                    } else {
                        jM = 2147483647L;
                    }
                    if (jM == 0) {
                        return new g();
                    }
                    strArrSplit = str8.split(Pattern.quote(strF4), ((int) jM) + 1);
                    length2 = strArrSplit.length;
                    if (strF4.isEmpty()) {
                        i12 = 0;
                    } else {
                        i12 = 0;
                    }
                    i12 = zIsEmpty;
                    if (strArrSplit.length > jM) {
                        length2--;
                    }
                    while (i12 < length2) {
                        arrayList.add(new u(strArrSplit[i12]));
                        i12++;
                    }
                }
                return new g(arrayList);
            case 14:
                c5.n("substring", 2, list);
                str9 = this.f3091a;
                if (list.isEmpty()) {
                    iA2 = (int) c5.a(v6Var.b(list.get(0)).g().doubleValue());
                } else {
                    iA2 = 0;
                }
                if (list.size() > 1) {
                    length3 = (int) c5.a(v6Var.b(list.get(1)).g().doubleValue());
                } else {
                    length3 = str9.length();
                }
                int iMin3 = Math.min(Math.max(iA2, 0), str9.length());
                int iMin4 = Math.min(Math.max(length3, 0), str9.length());
                return new u(str9.substring(Math.min(iMin3, iMin4), Math.max(iMin3, iMin4)));
            case 15:
                uVar = this;
                c5.n("replace", 2, list);
                sVarA = s.f3010a0;
                strF5 = sVarA.f();
                if (!list.isEmpty()) {
                    strF5 = v6Var.b(list.get(0)).f();
                    if (list.size() > 1) {
                        sVarA = v6Var.b(list.get(1));
                    }
                }
                str10 = uVar.f3091a;
                iIndexOf = str10.indexOf(strF5);
                if (iIndexOf >= 0) {
                    if (sVarA instanceof n) {
                        i13 = 0;
                        sVarA = ((n) sVarA).a(v6Var, Arrays.asList(new u(strF5), new k(Double.valueOf(iIndexOf)), uVar));
                    } else {
                        i13 = 0;
                    }
                    return new u(str10.substring(i13, iIndexOf) + sVarA.f() + str10.substring(iIndexOf + strF5.length()));
                }
                return uVar;
            case 16:
                c5.n("indexOf", 2, list);
                String str19 = this.f3091a;
                if (list.size() <= 0) {
                    strF6 = s.f3010a0.f();
                    v6Var2 = v6Var;
                } else {
                    v6Var2 = v6Var;
                    strF6 = v6Var2.b(list.get(0)).f();
                }
                return new k(Double.valueOf(str19.indexOf(strF6, (int) c5.a(list.size() >= 2 ? v6Var2.b(list.get(1)).g().doubleValue() : 0.0d))));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final s d() {
        return new u(this.f3091a);
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Boolean e() {
        return Boolean.valueOf(!this.f3091a.isEmpty());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            return this.f3091a.equals(((u) obj).f3091a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final String f() {
        return this.f3091a;
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Double g() {
        if (this.f3091a.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.f3091a);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.s
    public final Iterator<s> h() {
        return new x(this);
    }

    public final int hashCode() {
        return this.f3091a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator<s> iterator() {
        return new w(this);
    }

    public final String toString() {
        return "\"" + this.f3091a + "\"";
    }

    public u(String str) {
        if (str != null) {
            this.f3091a = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }
}
