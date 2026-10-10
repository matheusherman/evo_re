package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Boolean f3468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Boolean f3469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Long f3470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Long f3471f;

    private static Boolean f(String str, com.google.android.gms.internal.measurement.q4.b bVar, boolean z10, String str2, List<String> list, String str3, p5 p5Var) {
        if (str == null) {
            return null;
        }
        if (bVar == com.google.android.gms.internal.measurement.q4.b.IN_LIST) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z10 && bVar != com.google.android.gms.internal.measurement.q4.b.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (cd.f3464a[bVar.ordinal()]) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z10 ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (p5Var != null) {
                        p5Var.M().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    abstract int a();

    abstract boolean i();

    abstract boolean j();

    static Boolean b(double d10, com.google.android.gms.internal.measurement.o4 o4Var) {
        try {
            return h(new BigDecimal(d10), o4Var, Math.ulp(d10));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean c(long j10, com.google.android.gms.internal.measurement.o4 o4Var) {
        try {
            return h(new BigDecimal(j10), o4Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    static Boolean d(Boolean bool, boolean z10) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z10);
    }

    d(String str, int i10) {
        this.f3466a = str;
        this.f3467b = i10;
    }

    static Boolean e(String str, com.google.android.gms.internal.measurement.o4 o4Var) {
        if (!sc.h0(str)) {
            return null;
        }
        try {
            return h(new BigDecimal(str), o4Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    static Boolean g(String str, com.google.android.gms.internal.measurement.q4 q4Var, p5 p5Var) {
        String strN;
        List<String> list;
        String str2;
        m1.g.k(q4Var);
        if (str == null || !q4Var.T() || q4Var.K() == com.google.android.gms.internal.measurement.q4.b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        com.google.android.gms.internal.measurement.q4.b bVarK = q4Var.K();
        com.google.android.gms.internal.measurement.q4.b bVar = com.google.android.gms.internal.measurement.q4.b.IN_LIST;
        if (bVarK == bVar) {
            if (q4Var.n() == 0) {
                return null;
            }
        } else if (!q4Var.S()) {
            return null;
        }
        com.google.android.gms.internal.measurement.q4.b bVarK2 = q4Var.K();
        boolean zQ = q4Var.Q();
        if (!zQ && bVarK2 != com.google.android.gms.internal.measurement.q4.b.REGEXP && bVarK2 != bVar) {
            strN = q4Var.N().toUpperCase(Locale.ENGLISH);
        } else {
            strN = q4Var.N();
        }
        String str3 = strN;
        if (q4Var.n() == 0) {
            list = null;
        } else {
            List<String> listO = q4Var.O();
            if (!zQ) {
                ArrayList arrayList = new ArrayList(listO.size());
                Iterator<String> it = listO.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                listO = Collections.unmodifiableList(arrayList);
            }
            list = listO;
        }
        if (bVarK2 == com.google.android.gms.internal.measurement.q4.b.REGEXP) {
            str2 = str3;
        } else {
            str2 = null;
        }
        return f(str, bVarK2, zQ, str3, list, str2, p5Var);
    }

    @VisibleForTesting
    private static Boolean h(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.o4 o4Var, double d10) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        m1.g.k(o4Var);
        if (o4Var.S() && o4Var.K() != com.google.android.gms.internal.measurement.o4.b.UNKNOWN_COMPARISON_TYPE) {
            com.google.android.gms.internal.measurement.o4.b bVarK = o4Var.K();
            com.google.android.gms.internal.measurement.o4.b bVar = com.google.android.gms.internal.measurement.o4.b.BETWEEN;
            if (bVarK == bVar) {
                if (!o4Var.X() || !o4Var.W()) {
                    return null;
                }
            } else if (!o4Var.T()) {
                return null;
            }
            com.google.android.gms.internal.measurement.o4.b bVarK2 = o4Var.K();
            if (o4Var.K() == bVar) {
                if (sc.h0(o4Var.Q()) && sc.h0(o4Var.O())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(o4Var.Q());
                        bigDecimal4 = new BigDecimal(o4Var.O());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!sc.h0(o4Var.N())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(o4Var.N());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (bVarK2 == bVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 != null) {
            }
            int i10 = cd.f3465b[bVarK2.ordinal()];
            boolean z10 = false;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4 || bigDecimal3 == null) {
                            return null;
                        }
                        if (bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z10 = true;
                        }
                        return Boolean.valueOf(z10);
                    }
                    if (bigDecimal2 != null) {
                        if (d10 != 0.0d) {
                            if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d10).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d10).multiply(new BigDecimal(2)))) < 0) {
                                z10 = true;
                            }
                            return Boolean.valueOf(z10);
                        }
                        if (bigDecimal.compareTo(bigDecimal2) == 0) {
                            z10 = true;
                        }
                        return Boolean.valueOf(z10);
                    }
                } else if (bigDecimal2 != null) {
                    if (bigDecimal.compareTo(bigDecimal2) > 0) {
                        z10 = true;
                    }
                    return Boolean.valueOf(z10);
                }
            } else if (bigDecimal2 != null) {
                if (bigDecimal.compareTo(bigDecimal2) < 0) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        }
        return null;
    }
}
