package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class rb<T> implements fc<T> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int[] f2985q = new int[0];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Unsafe f2986r = xc.p();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f2987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f2988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ob f2991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f2992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f2993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f2994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f2995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f2996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f2997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final vb f2998l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ya f2999m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final vc<?, ?> f3000n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final s9<?> f3001o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final hb f3002p;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:176:0x054b  */
    /* JADX WARN: Code duplicated, block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.measurement.fc
    public final void g(T t10, nd ndVar) {
        Map.Entry<?, ?> entry;
        Iterator it;
        int i10;
        int i11;
        int i12;
        Iterator itM;
        Map.Entry<?, ?> entry2;
        rb<T> rbVar = this;
        int i13 = 1048575;
        if (ndVar.b() != 2) {
            if (rbVar.f2992f) {
                x9<T> x9VarB = rbVar.f3001o.b(t10);
                if (x9VarB.f3227a.isEmpty()) {
                    entry = null;
                    it = null;
                } else {
                    Iterator itP = x9VarB.p();
                    entry = (Map.Entry) itP.next();
                    it = itP;
                }
            } else {
                entry = null;
                it = null;
            }
            int length = rbVar.f2987a.length;
            Unsafe unsafe = f2986r;
            int i14 = 0;
            int i15 = 1048575;
            int i16 = 0;
            while (i14 < length) {
                int iG = rbVar.G(i14);
                int[] iArr = rbVar.f2987a;
                int i17 = iArr[i14];
                int i18 = (iG & 267386880) >>> 20;
                if (i18 <= 17) {
                    int i19 = iArr[i14 + 2];
                    int i20 = i19 & i13;
                    if (i20 != i15) {
                        i16 = i20 == i13 ? 0 : unsafe.getInt(t10, i20);
                        i15 = i20;
                    }
                    i10 = i15;
                    i11 = i16;
                    i12 = 1 << (i19 >>> 20);
                } else {
                    i10 = i15;
                    i11 = i16;
                    i12 = 0;
                }
                while (entry != null && rbVar.f3001o.a(entry) <= i17) {
                    rbVar.f3001o.d(ndVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                Iterator it2 = it;
                long j10 = iG & i13;
                switch (i18) {
                    case 0:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.y(i17, xc.a(t10, j10));
                        }
                        break;
                    case 1:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.z(i17, xc.n(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 2:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.e(i17, unsafe.getLong(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 3:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.N(i17, unsafe.getLong(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 4:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.j(i17, unsafe.getInt(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 5:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.w(i17, unsafe.getLong(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 6:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.g(i17, unsafe.getInt(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 7:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.c(i17, xc.F(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 8:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            t(i17, unsafe.getObject(t10, j10), ndVar);
                        }
                        rbVar = this;
                        break;
                    case 9:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.f(i17, unsafe.getObject(t10, j10), rbVar.O(i14));
                        }
                        break;
                    case 10:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.K(i17, (v8) unsafe.getObject(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 11:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.B(i17, unsafe.getInt(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 12:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.v(i17, unsafe.getInt(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 13:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.I(i17, unsafe.getInt(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 14:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.k(i17, unsafe.getLong(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 15:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.M(i17, unsafe.getInt(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 16:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.J(i17, unsafe.getLong(t10, j10));
                        }
                        rbVar = this;
                        break;
                    case 17:
                        if (rbVar.z(t10, i14, i10, i11, i12)) {
                            ndVar.x(i17, unsafe.getObject(t10, j10), rbVar.O(i14));
                        }
                        break;
                    case 18:
                        hc.w(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 19:
                        hc.I(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 20:
                        hc.O(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 21:
                        hc.Y(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 22:
                        hc.L(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 23:
                        hc.F(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 24:
                        hc.C(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 25:
                        hc.k(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 26:
                        hc.u(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar);
                        break;
                    case 27:
                        hc.v(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, rbVar.O(i14));
                        break;
                    case 28:
                        hc.i(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar);
                        break;
                    case 29:
                        hc.X(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 30:
                        hc.z(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 31:
                        hc.R(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 32:
                        hc.U(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 33:
                        hc.V(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 34:
                        hc.W(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, false);
                        break;
                    case 35:
                        hc.w(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 36:
                        hc.I(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 37:
                        hc.O(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 38:
                        hc.Y(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 39:
                        hc.L(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 40:
                        hc.F(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 41:
                        hc.C(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 42:
                        hc.k(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 43:
                        hc.X(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 44:
                        hc.z(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 45:
                        hc.R(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 46:
                        hc.U(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 47:
                        hc.V(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 48:
                        hc.W(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, true);
                        break;
                    case 49:
                        hc.j(rbVar.f2987a[i14], (List) unsafe.getObject(t10, j10), ndVar, rbVar.O(i14));
                        break;
                    case 50:
                        rbVar.v(ndVar, i17, unsafe.getObject(t10, j10), i14);
                        break;
                    case 51:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.y(i17, j(t10, j10));
                        }
                        break;
                    case 52:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.z(i17, B(t10, j10));
                        }
                        break;
                    case 53:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.e(i17, M(t10, j10));
                        }
                        break;
                    case 54:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.N(i17, M(t10, j10));
                        }
                        break;
                    case 55:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.j(i17, H(t10, j10));
                        }
                        break;
                    case 56:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.w(i17, M(t10, j10));
                        }
                        break;
                    case 57:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.g(i17, H(t10, j10));
                        }
                        break;
                    case 58:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.c(i17, P(t10, j10));
                        }
                        break;
                    case 59:
                        if (rbVar.K(t10, i17, i14)) {
                            t(i17, unsafe.getObject(t10, j10), ndVar);
                        }
                        break;
                    case 60:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.f(i17, unsafe.getObject(t10, j10), rbVar.O(i14));
                        }
                        break;
                    case 61:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.K(i17, (v8) unsafe.getObject(t10, j10));
                        }
                        break;
                    case 62:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.B(i17, H(t10, j10));
                        }
                        break;
                    case 63:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.v(i17, H(t10, j10));
                        }
                        break;
                    case 64:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.I(i17, H(t10, j10));
                        }
                        break;
                    case 65:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.k(i17, M(t10, j10));
                        }
                        break;
                    case 66:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.M(i17, H(t10, j10));
                        }
                        break;
                    case 67:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.J(i17, M(t10, j10));
                        }
                        break;
                    case 68:
                        if (rbVar.K(t10, i17, i14)) {
                            ndVar.x(i17, unsafe.getObject(t10, j10), rbVar.O(i14));
                        }
                        break;
                    default:
                        break;
                }
                i14 += 3;
                i16 = i11;
                it = it2;
                i13 = 1048575;
                i15 = i10;
                entry = entry;
            }
            Iterator it3 = it;
            while (entry != null) {
                rbVar.f3001o.d(ndVar, entry);
                entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
            }
            u(rbVar.f3000n, t10, ndVar);
            return;
        }
        u(rbVar.f3000n, t10, ndVar);
        if (rbVar.f2992f) {
            x9<T> x9VarB2 = rbVar.f3001o.b(t10);
            if (x9VarB2.f3227a.isEmpty()) {
                itM = null;
                entry2 = null;
            } else {
                itM = x9VarB2.m();
                entry2 = (Map.Entry) itM.next();
            }
        } else {
            itM = null;
            entry2 = null;
        }
        for (int length2 = rbVar.f2987a.length - 3; length2 >= 0; length2 -= 3) {
            int iG2 = rbVar.G(length2);
            int i21 = rbVar.f2987a[length2];
            while (entry2 != null && rbVar.f3001o.a(entry2) > i21) {
                rbVar.f3001o.d(ndVar, entry2);
                entry2 = itM.hasNext() ? (Map.Entry) itM.next() : null;
            }
            switch ((iG2 & 267386880) >>> 20) {
                case 0:
                    if (rbVar.J(t10, length2)) {
                        ndVar.y(i21, xc.a(t10, iG2 & 1048575));
                    }
                    break;
                case 1:
                    if (rbVar.J(t10, length2)) {
                        ndVar.z(i21, xc.n(t10, iG2 & 1048575));
                    }
                    break;
                case 2:
                    if (rbVar.J(t10, length2)) {
                        ndVar.e(i21, xc.x(t10, iG2 & 1048575));
                    }
                    break;
                case 3:
                    if (rbVar.J(t10, length2)) {
                        ndVar.N(i21, xc.x(t10, iG2 & 1048575));
                    }
                    break;
                case 4:
                    if (rbVar.J(t10, length2)) {
                        ndVar.j(i21, xc.t(t10, iG2 & 1048575));
                    }
                    break;
                case 5:
                    if (rbVar.J(t10, length2)) {
                        ndVar.w(i21, xc.x(t10, iG2 & 1048575));
                    }
                    break;
                case 6:
                    if (rbVar.J(t10, length2)) {
                        ndVar.g(i21, xc.t(t10, iG2 & 1048575));
                    }
                    break;
                case 7:
                    if (rbVar.J(t10, length2)) {
                        ndVar.c(i21, xc.F(t10, iG2 & 1048575));
                    }
                    break;
                case 8:
                    if (rbVar.J(t10, length2)) {
                        t(i21, xc.B(t10, iG2 & 1048575), ndVar);
                    }
                    break;
                case 9:
                    if (rbVar.J(t10, length2)) {
                        ndVar.f(i21, xc.B(t10, iG2 & 1048575), rbVar.O(length2));
                    }
                    break;
                case 10:
                    if (rbVar.J(t10, length2)) {
                        ndVar.K(i21, (v8) xc.B(t10, iG2 & 1048575));
                    }
                    break;
                case 11:
                    if (rbVar.J(t10, length2)) {
                        ndVar.B(i21, xc.t(t10, iG2 & 1048575));
                    }
                    break;
                case 12:
                    if (rbVar.J(t10, length2)) {
                        ndVar.v(i21, xc.t(t10, iG2 & 1048575));
                    }
                    break;
                case 13:
                    if (rbVar.J(t10, length2)) {
                        ndVar.I(i21, xc.t(t10, iG2 & 1048575));
                    }
                    break;
                case 14:
                    if (rbVar.J(t10, length2)) {
                        ndVar.k(i21, xc.x(t10, iG2 & 1048575));
                    }
                    break;
                case 15:
                    if (rbVar.J(t10, length2)) {
                        ndVar.M(i21, xc.t(t10, iG2 & 1048575));
                    }
                    break;
                case 16:
                    if (rbVar.J(t10, length2)) {
                        ndVar.J(i21, xc.x(t10, iG2 & 1048575));
                    }
                    break;
                case 17:
                    if (rbVar.J(t10, length2)) {
                        ndVar.x(i21, xc.B(t10, iG2 & 1048575), rbVar.O(length2));
                    }
                    break;
                case 18:
                    hc.w(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 19:
                    hc.I(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 20:
                    hc.O(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 21:
                    hc.Y(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 22:
                    hc.L(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 23:
                    hc.F(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 24:
                    hc.C(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 25:
                    hc.k(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 26:
                    hc.u(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar);
                    break;
                case 27:
                    hc.v(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, rbVar.O(length2));
                    break;
                case 28:
                    hc.i(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar);
                    break;
                case 29:
                    hc.X(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 30:
                    hc.z(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 31:
                    hc.R(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 32:
                    hc.U(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 33:
                    hc.V(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 34:
                    hc.W(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, false);
                    break;
                case 35:
                    hc.w(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 36:
                    hc.I(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 37:
                    hc.O(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 38:
                    hc.Y(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 39:
                    hc.L(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 40:
                    hc.F(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 41:
                    hc.C(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 42:
                    hc.k(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 43:
                    hc.X(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 44:
                    hc.z(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 45:
                    hc.R(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 46:
                    hc.U(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 47:
                    hc.V(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 48:
                    hc.W(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, true);
                    break;
                case 49:
                    hc.j(rbVar.f2987a[length2], (List) xc.B(t10, iG2 & 1048575), ndVar, rbVar.O(length2));
                    break;
                case 50:
                    rbVar.v(ndVar, i21, xc.B(t10, iG2 & 1048575), length2);
                    break;
                case 51:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.y(i21, j(t10, iG2 & 1048575));
                    }
                    break;
                case 52:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.z(i21, B(t10, iG2 & 1048575));
                    }
                    break;
                case 53:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.e(i21, M(t10, iG2 & 1048575));
                    }
                    break;
                case 54:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.N(i21, M(t10, iG2 & 1048575));
                    }
                    break;
                case 55:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.j(i21, H(t10, iG2 & 1048575));
                    }
                    break;
                case 56:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.w(i21, M(t10, iG2 & 1048575));
                    }
                    break;
                case 57:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.g(i21, H(t10, iG2 & 1048575));
                    }
                    break;
                case 58:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.c(i21, P(t10, iG2 & 1048575));
                    }
                    break;
                case 59:
                    if (rbVar.K(t10, i21, length2)) {
                        t(i21, xc.B(t10, iG2 & 1048575), ndVar);
                    }
                    break;
                case 60:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.f(i21, xc.B(t10, iG2 & 1048575), rbVar.O(length2));
                    }
                    break;
                case 61:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.K(i21, (v8) xc.B(t10, iG2 & 1048575));
                    }
                    break;
                case 62:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.B(i21, H(t10, iG2 & 1048575));
                    }
                    break;
                case 63:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.v(i21, H(t10, iG2 & 1048575));
                    }
                    break;
                case 64:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.I(i21, H(t10, iG2 & 1048575));
                    }
                    break;
                case 65:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.k(i21, M(t10, iG2 & 1048575));
                    }
                    break;
                case 66:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.M(i21, H(t10, iG2 & 1048575));
                    }
                    break;
                case 67:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.J(i21, M(t10, iG2 & 1048575));
                    }
                    break;
                case 68:
                    if (rbVar.K(t10, i21, length2)) {
                        ndVar.x(i21, xc.B(t10, iG2 & 1048575), rbVar.O(length2));
                    }
                    break;
            }
        }
        while (entry2 != null) {
            rbVar.f3001o.d(ndVar, entry2);
            entry2 = itM.hasNext() ? (Map.Entry) itM.next() : null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final void h(T t10, byte[] bArr, int i10, int i11, u8 u8Var) {
        m(t10, bArr, i10, i11, 0, u8Var);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 35801. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int m(T r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.measurement.u8 r37) {
        /*
            Method dump skipped, instruction units count: 3580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.rb.m(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.u8):int");
    }

    private final int C(int i10) {
        return this.f2987a[i10 + 2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(T t10, T t11, int i10) {
        int i11 = this.f2987a[i10];
        if (K(t11, i11, i10)) {
            long jG = G(i10) & 1048575;
            Unsafe unsafe = f2986r;
            Object object = unsafe.getObject(t11, jG);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f2987a[i10] + " is present but null: " + String.valueOf(t11));
            }
            fc fcVarO = O(i10);
            if (!K(t10, i11, i10)) {
                if (T(object)) {
                    Object objB = fcVarO.b();
                    fcVarO.f(objB, object);
                    unsafe.putObject(t10, jG, objB);
                } else {
                    unsafe.putObject(t10, jG, object);
                }
                E(t10, i11, i10);
                return;
            }
            Object object2 = unsafe.getObject(t10, jG);
            if (!T(object2)) {
                Object objB2 = fcVarO.b();
                fcVarO.f(objB2, object2);
                unsafe.putObject(t10, jG, objB2);
                object2 = objB2;
            }
            fcVarO.f(object2, object);
        }
    }

    private final int G(int i10) {
        return this.f2987a[i10 + 1];
    }

    static uc I(Object obj) {
        ea eaVar = (ea) obj;
        uc ucVar = eaVar.zzb;
        if (ucVar != uc.k()) {
            return ucVar;
        }
        uc ucVarL = uc.l();
        eaVar.zzb = ucVarL;
        return ucVarL;
    }

    private final ia N(int i10) {
        return (ia) this.f2988b[((i10 / 3) << 1) + 1];
    }

    private final fc O(int i10) {
        int i11 = (i10 / 3) << 1;
        fc fcVar = (fc) this.f2988b[i11];
        if (fcVar != null) {
            return fcVar;
        }
        fc<T> fcVarB = cc.a().b((Class) this.f2988b[i11 + 1]);
        this.f2988b[i11] = fcVarB;
        return fcVarB;
    }

    private final Object Q(int i10) {
        return this.f2988b[(i10 / 3) << 1];
    }

    private static boolean S(int i10) {
        return (i10 & 536870912) != 0;
    }

    private static boolean T(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof ea) {
            return ((ea) obj).J();
        }
        return true;
    }

    private final int k(int i10) {
        if (i10 < this.f2989c || i10 > this.f2990d) {
            return -1;
        }
        return l(i10, 0);
    }

    private final int l(int i10, int i11) {
        int length = (this.f2987a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.f2987a[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x0269  */
    /* JADX WARN: Code duplicated, block: B:125:0x0270  */
    /* JADX WARN: Code duplicated, block: B:128:0x0286  */
    /* JADX WARN: Code duplicated, block: B:129:0x0289  */
    static <T> rb<T> n(Class<T> cls, mb mbVar, vb vbVar, ya yaVar, vc<?, ?> vcVar, s9<?> s9Var, hb hbVar) {
        int i10;
        int iCharAt;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr;
        int i15;
        int i16;
        int i17;
        char cCharAt;
        int i18;
        char cCharAt2;
        int i19;
        char cCharAt3;
        int i20;
        char cCharAt4;
        int i21;
        char cCharAt5;
        int i22;
        char cCharAt6;
        int i23;
        char cCharAt7;
        int i24;
        char cCharAt8;
        int i25;
        dc dcVar;
        int i26;
        int[] iArr2;
        int i27;
        int i28;
        int iObjectFieldOffset;
        int i29;
        int i30;
        int i31;
        int iObjectFieldOffset2;
        int iObjectFieldOffset3;
        Field fieldS;
        int i32;
        char cCharAt9;
        int i33;
        int i34;
        int i35;
        Object obj;
        Field fieldS2;
        int i36;
        Object obj2;
        Field fieldS3;
        int i37;
        char cCharAt10;
        int i38;
        char cCharAt11;
        int i39;
        char cCharAt12;
        int i40;
        char cCharAt13;
        if (!(mbVar instanceof dc)) {
            throw new NoSuchMethodError();
        }
        dc dcVar2 = (dc) mbVar;
        String strA = dcVar2.a();
        int length = strA.length();
        char c10 = 55296;
        if (strA.charAt(0) >= 55296) {
            int i41 = 1;
            while (true) {
                i10 = i41 + 1;
                if (strA.charAt(i41) < 55296) {
                    break;
                }
                i41 = i10;
            }
        } else {
            i10 = 1;
        }
        int i42 = i10 + 1;
        int iCharAt2 = strA.charAt(i10);
        if (iCharAt2 >= 55296) {
            int i43 = iCharAt2 & 8191;
            int i44 = 13;
            while (true) {
                i40 = i42 + 1;
                cCharAt13 = strA.charAt(i42);
                if (cCharAt13 < 55296) {
                    break;
                }
                i43 |= (cCharAt13 & 8191) << i44;
                i44 += 13;
                i42 = i40;
            }
            iCharAt2 = i43 | (cCharAt13 << i44);
            i42 = i40;
        }
        if (iCharAt2 == 0) {
            iArr = f2985q;
            i15 = 0;
            i12 = 0;
            i14 = 0;
            iCharAt = 0;
            i11 = 0;
            i13 = 0;
            i16 = 0;
        } else {
            int i45 = i42 + 1;
            int iCharAt3 = strA.charAt(i42);
            if (iCharAt3 >= 55296) {
                int i46 = iCharAt3 & 8191;
                int i47 = 13;
                while (true) {
                    i24 = i45 + 1;
                    cCharAt8 = strA.charAt(i45);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt8 & 8191) << i47;
                    i47 += 13;
                    i45 = i24;
                }
                iCharAt3 = i46 | (cCharAt8 << i47);
                i45 = i24;
            }
            int i48 = i45 + 1;
            int iCharAt4 = strA.charAt(i45);
            if (iCharAt4 >= 55296) {
                int i49 = iCharAt4 & 8191;
                int i50 = 13;
                while (true) {
                    i23 = i48 + 1;
                    cCharAt7 = strA.charAt(i48);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt7 & 8191) << i50;
                    i50 += 13;
                    i48 = i23;
                }
                iCharAt4 = i49 | (cCharAt7 << i50);
                i48 = i23;
            }
            int i51 = i48 + 1;
            int iCharAt5 = strA.charAt(i48);
            if (iCharAt5 >= 55296) {
                int i52 = iCharAt5 & 8191;
                int i53 = 13;
                while (true) {
                    i22 = i51 + 1;
                    cCharAt6 = strA.charAt(i51);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt6 & 8191) << i53;
                    i53 += 13;
                    i51 = i22;
                }
                iCharAt5 = i52 | (cCharAt6 << i53);
                i51 = i22;
            }
            int i54 = i51 + 1;
            int iCharAt6 = strA.charAt(i51);
            if (iCharAt6 >= 55296) {
                int i55 = iCharAt6 & 8191;
                int i56 = 13;
                while (true) {
                    i21 = i54 + 1;
                    cCharAt5 = strA.charAt(i54);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt5 & 8191) << i56;
                    i56 += 13;
                    i54 = i21;
                }
                iCharAt6 = i55 | (cCharAt5 << i56);
                i54 = i21;
            }
            int i57 = i54 + 1;
            iCharAt = strA.charAt(i54);
            if (iCharAt >= 55296) {
                int i58 = iCharAt & 8191;
                int i59 = 13;
                while (true) {
                    i20 = i57 + 1;
                    cCharAt4 = strA.charAt(i57);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i58 |= (cCharAt4 & 8191) << i59;
                    i59 += 13;
                    i57 = i20;
                }
                iCharAt = i58 | (cCharAt4 << i59);
                i57 = i20;
            }
            int i60 = i57 + 1;
            int iCharAt7 = strA.charAt(i57);
            if (iCharAt7 >= 55296) {
                int i61 = iCharAt7 & 8191;
                int i62 = 13;
                while (true) {
                    i19 = i60 + 1;
                    cCharAt3 = strA.charAt(i60);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i61 |= (cCharAt3 & 8191) << i62;
                    i62 += 13;
                    i60 = i19;
                }
                iCharAt7 = i61 | (cCharAt3 << i62);
                i60 = i19;
            }
            int i63 = i60 + 1;
            int iCharAt8 = strA.charAt(i60);
            if (iCharAt8 >= 55296) {
                int i64 = iCharAt8 & 8191;
                int i65 = 13;
                while (true) {
                    i18 = i63 + 1;
                    cCharAt2 = strA.charAt(i63);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i64 |= (cCharAt2 & 8191) << i65;
                    i65 += 13;
                    i63 = i18;
                }
                iCharAt8 = i64 | (cCharAt2 << i65);
                i63 = i18;
            }
            int i66 = i63 + 1;
            int iCharAt9 = strA.charAt(i63);
            if (iCharAt9 >= 55296) {
                int i67 = iCharAt9 & 8191;
                int i68 = 13;
                while (true) {
                    i17 = i66 + 1;
                    cCharAt = strA.charAt(i66);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i67 |= (cCharAt & 8191) << i68;
                    i68 += 13;
                    i66 = i17;
                }
                iCharAt9 = i67 | (cCharAt << i68);
                i66 = i17;
            }
            int[] iArr3 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i69 = (iCharAt3 << 1) + iCharAt4;
            int i70 = iCharAt7;
            i11 = iCharAt5;
            i12 = i70;
            i13 = iCharAt6;
            i14 = i69;
            iArr = iArr3;
            i15 = iCharAt3;
            i16 = iCharAt9;
            i42 = i66;
        }
        Unsafe unsafe = f2986r;
        Object[] objArrE = dcVar2.e();
        Class<?> cls2 = dcVar2.b().getClass();
        int[] iArr4 = new int[iCharAt * 3];
        Object[] objArr = new Object[iCharAt << 1];
        int i71 = i16 + i12;
        int i72 = i16;
        int i73 = i71;
        int i74 = 0;
        int i75 = 0;
        while (i42 < length) {
            int i76 = i42 + 1;
            int iCharAt10 = strA.charAt(i42);
            if (iCharAt10 >= c10) {
                int i77 = iCharAt10 & 8191;
                int i78 = i76;
                int i79 = 13;
                while (true) {
                    i39 = i78 + 1;
                    cCharAt12 = strA.charAt(i78);
                    if (cCharAt12 < c10) {
                        break;
                    }
                    i77 |= (cCharAt12 & 8191) << i79;
                    i79 += 13;
                    i78 = i39;
                }
                iCharAt10 = i77 | (cCharAt12 << i79);
                i25 = i39;
            } else {
                i25 = i76;
            }
            int i80 = i25 + 1;
            int iCharAt11 = strA.charAt(i25);
            if (iCharAt11 >= c10) {
                int i81 = iCharAt11 & 8191;
                int i82 = i80;
                int i83 = 13;
                while (true) {
                    i38 = i82 + 1;
                    cCharAt11 = strA.charAt(i82);
                    dcVar = dcVar2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i81 |= (cCharAt11 & 8191) << i83;
                    i83 += 13;
                    i82 = i38;
                    dcVar2 = dcVar;
                }
                iCharAt11 = i81 | (cCharAt11 << i83);
                i26 = i38;
            } else {
                dcVar = dcVar2;
                i26 = i80;
            }
            int i84 = iCharAt11 & 255;
            int i85 = length;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i75] = i74;
                i75++;
            }
            int i86 = iCharAt10;
            if (i84 >= 51) {
                int i87 = i26 + 1;
                int iCharAt12 = strA.charAt(i26);
                char c11 = 55296;
                if (iCharAt12 >= 55296) {
                    int i88 = iCharAt12 & 8191;
                    int i89 = 13;
                    while (true) {
                        i37 = i87 + 1;
                        cCharAt10 = strA.charAt(i87);
                        if (cCharAt10 < c11) {
                            break;
                        }
                        i88 |= (cCharAt10 & 8191) << i89;
                        i89 += 13;
                        i87 = i37;
                        c11 = 55296;
                    }
                    iCharAt12 = i88 | (cCharAt10 << i89);
                    i87 = i37;
                }
                int i90 = i84 - 51;
                int i91 = iCharAt12;
                if (i90 == 9 || i90 == 17) {
                    i34 = i14 + 1;
                    objArr[((i74 / 3) << 1) + 1] = objArrE[i14];
                } else {
                    if (i90 == 12 && (dcVar.c().equals(zb.PROTO2) || (iCharAt11 & 2048) != 0)) {
                        i34 = i14 + 1;
                        objArr[((i74 / 3) << 1) + 1] = objArrE[i14];
                    }
                    i35 = i91 << 1;
                    obj = objArrE[i35];
                    if (obj instanceof Field) {
                        fieldS2 = (Field) obj;
                    } else {
                        fieldS2 = s(cls2, (String) obj);
                        objArrE[i35] = fieldS2;
                    }
                    iArr2 = iArr4;
                    i27 = i15;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldS2);
                    i36 = i35 + 1;
                    obj2 = objArrE[i36];
                    if (obj2 instanceof Field) {
                        fieldS3 = (Field) obj2;
                    } else {
                        fieldS3 = s(cls2, (String) obj2);
                        objArrE[i36] = fieldS3;
                    }
                    iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldS3);
                    i29 = i87;
                    i28 = i14;
                    strA = strA;
                    i31 = 0;
                }
                i14 = i34;
                i35 = i91 << 1;
                obj = objArrE[i35];
                if (obj instanceof Field) {
                    fieldS2 = (Field) obj;
                } else {
                    fieldS2 = s(cls2, (String) obj);
                    objArrE[i35] = fieldS2;
                }
                iArr2 = iArr4;
                i27 = i15;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldS2);
                i36 = i35 + 1;
                obj2 = objArrE[i36];
                if (obj2 instanceof Field) {
                    fieldS3 = (Field) obj2;
                } else {
                    fieldS3 = s(cls2, (String) obj2);
                    objArrE[i36] = fieldS3;
                }
                iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldS3);
                i29 = i87;
                i28 = i14;
                strA = strA;
                i31 = 0;
            } else {
                iArr2 = iArr4;
                i27 = i15;
                i28 = i14 + 1;
                Field fieldS4 = s(cls2, (String) objArrE[i14]);
                if (i84 == 9 || i84 == 17) {
                    objArr[((i74 / 3) << 1) + 1] = fieldS4.getType();
                } else {
                    if (i84 == 27 || i84 == 49) {
                        i33 = i14 + 2;
                        objArr[((i74 / 3) << 1) + 1] = objArrE[i28];
                    } else if (i84 == 12 || i84 == 30 || i84 == 44) {
                        if (dcVar.c() == zb.PROTO2 || (iCharAt11 & 2048) != 0) {
                            i33 = i14 + 2;
                            objArr[((i74 / 3) << 1) + 1] = objArrE[i28];
                        }
                    } else if (i84 == 50) {
                        int i92 = i72 + 1;
                        iArr[i72] = i74;
                        int i93 = (i74 / 3) << 1;
                        int i94 = i14 + 2;
                        objArr[i93] = objArrE[i28];
                        if ((iCharAt11 & 2048) != 0) {
                            i28 = i14 + 3;
                            objArr[i93 + 1] = objArrE[i94];
                            i72 = i92;
                        } else {
                            i72 = i92;
                            i28 = i94;
                        }
                    }
                    i28 = i33;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldS4);
                if ((iCharAt11 & 4096) == 0 || i84 > 17) {
                    iObjectFieldOffset = 1048575;
                    i29 = i26;
                    i30 = 0;
                } else {
                    i29 = i26 + 1;
                    int iCharAt13 = strA.charAt(i26);
                    if (iCharAt13 >= 55296) {
                        int i95 = iCharAt13 & 8191;
                        int i96 = 13;
                        while (true) {
                            i32 = i29 + 1;
                            cCharAt9 = strA.charAt(i29);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i95 |= (cCharAt9 & 8191) << i96;
                            i96 += 13;
                            i29 = i32;
                        }
                        iCharAt13 = i95 | (cCharAt9 << i96);
                        i29 = i32;
                    }
                    int i97 = (i27 << 1) + (iCharAt13 / 32);
                    Object obj3 = objArrE[i97];
                    int i98 = iCharAt13;
                    if (obj3 instanceof Field) {
                        fieldS = (Field) obj3;
                    } else {
                        fieldS = s(cls2, (String) obj3);
                        objArrE[i97] = fieldS;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldS);
                    i30 = i98 % 32;
                }
                if (i84 < 18 || i84 > 49) {
                    int i99 = iObjectFieldOffset;
                    i31 = i30;
                    iObjectFieldOffset2 = iObjectFieldOffset4;
                    iObjectFieldOffset3 = i99;
                } else {
                    int i100 = i73 + 1;
                    iArr[i73] = iObjectFieldOffset4;
                    int i101 = iObjectFieldOffset;
                    i31 = i30;
                    iObjectFieldOffset2 = iObjectFieldOffset4;
                    iObjectFieldOffset3 = i101;
                    i73 = i100;
                }
            }
            int i102 = i74 + 1;
            iArr2[i74] = i86;
            int i103 = i74 + 2;
            iArr2[i102] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i84 << 20) | iObjectFieldOffset2;
            i74 += 3;
            iArr2[i103] = (i31 << 20) | iObjectFieldOffset3;
            i42 = i29;
            strA = strA;
            dcVar2 = dcVar;
            i15 = i27;
            iArr4 = iArr2;
            c10 = 55296;
            i14 = i28;
            length = i85;
        }
        return new rb<>(iArr4, objArr, i11, i13, dcVar2.b(), false, iArr, i16, i71, vbVar, yaVar, vcVar, s9Var, hbVar);
    }

    private final <K, V, UT, UB> UB o(int i10, int i11, Map<K, V> map, ia iaVar, UB ub2, vc<UT, UB> vcVar, Object obj) {
        this.f3002p.a(Q(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!iaVar.a(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = vcVar.i(obj);
                }
                f9 f9VarT = v8.t(gb.a(null, next.getKey(), next.getValue()));
                try {
                    gb.b(f9VarT.b(), null, next.getKey(), next.getValue());
                    vcVar.c(ub2, i11, f9VarT.a());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    private final <UT, UB> UB r(Object obj, int i10, UB ub2, vc<UT, UB> vcVar, Object obj2) {
        ia iaVarN;
        int i11 = this.f2987a[i10];
        Object objB = xc.B(obj, G(i10) & 1048575);
        return (objB == null || (iaVarN = N(i10)) == null) ? ub2 : (UB) o(i10, i11, this.f3002p.c(objB), iaVarN, ub2, vcVar, obj2);
    }

    private static void t(int i10, Object obj, nd ndVar) {
        if (obj instanceof String) {
            ndVar.s(i10, (String) obj);
        } else {
            ndVar.K(i10, (v8) obj);
        }
    }

    private final <K, V> void v(nd ndVar, int i10, Object obj, int i11) {
        if (obj != null) {
            this.f3002p.a(Q(i11));
            ndVar.r(i10, null, this.f3002p.d(obj));
        }
    }

    private final void w(T t10, int i10, int i11, Object obj) {
        f2986r.putObject(t10, G(i11) & 1048575, obj);
        E(t10, i10, i11);
    }

    private final void x(T t10, int i10, Object obj) {
        f2986r.putObject(t10, G(i10) & 1048575, obj);
        D(t10, i10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:201:0x04d9 A[PHI: r0 r1
      0x04d9: PHI (r0v2 com.google.android.gms.internal.measurement.rb<T>) = 
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v24 com.google.android.gms.internal.measurement.rb<T>)
      (r0v30 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
      (r0v1 com.google.android.gms.internal.measurement.rb<T>)
     binds: [B:18:0x0055, B:199:0x04cf, B:169:0x0433, B:155:0x03ea, B:147:0x03c3, B:141:0x039c, B:121:0x02bb, B:118:0x02a5, B:115:0x028f, B:112:0x0279, B:109:0x0263, B:106:0x024d, B:103:0x0237, B:100:0x0221, B:97:0x020c, B:94:0x01f7, B:91:0x01e2, B:88:0x01cd, B:85:0x01b8, B:81:0x019e, B:76:0x016a, B:73:0x015e, B:70:0x014e, B:67:0x013e, B:64:0x012e, B:61:0x0122, B:58:0x0116, B:55:0x010a, B:49:0x00ec, B:46:0x00d9, B:43:0x00c8, B:40:0x00b9, B:37:0x00aa, B:34:0x009f, B:31:0x0094, B:28:0x0085, B:25:0x0076, B:21:0x005e] A[DONT_GENERATE, DONT_INLINE]
      0x04d9: PHI (r1v6 T) = 
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v7 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
      (r1v1 T)
     binds: [B:18:0x0055, B:199:0x04cf, B:169:0x0433, B:155:0x03ea, B:147:0x03c3, B:141:0x039c, B:121:0x02bb, B:118:0x02a5, B:115:0x028f, B:112:0x0279, B:109:0x0263, B:106:0x024d, B:103:0x0237, B:100:0x0221, B:97:0x020c, B:94:0x01f7, B:91:0x01e2, B:88:0x01cd, B:85:0x01b8, B:81:0x019e, B:76:0x016a, B:73:0x015e, B:70:0x014e, B:67:0x013e, B:64:0x012e, B:61:0x0122, B:58:0x0116, B:55:0x010a, B:49:0x00ec, B:46:0x00d9, B:43:0x00c8, B:40:0x00b9, B:37:0x00aa, B:34:0x009f, B:31:0x0094, B:28:0x0085, B:25:0x0076, B:21:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.measurement.fc
    public final int a(T t10) {
        int i10;
        int iE;
        int iF;
        int iC0;
        int iB;
        int iW0;
        int iZ0;
        rb<T> rbVar = this;
        T t11 = t10;
        Unsafe unsafe = f2986r;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i12 < rbVar.f2987a.length) {
            int iG = rbVar.G(i12);
            int i16 = (267386880 & iG) >>> 20;
            int[] iArr = rbVar.f2987a;
            int i17 = iArr[i12];
            int i18 = iArr[i12 + 2];
            int i19 = i18 & i11;
            if (i16 <= 17) {
                if (i19 != i13) {
                    i14 = i19 == i11 ? 0 : unsafe.getInt(t11, i19);
                    i13 = i19;
                }
                i10 = 1 << (i18 >>> 20);
            } else {
                i10 = 0;
            }
            long j10 = iG & i11;
            if (i16 >= y9.J.b()) {
                y9.W.b();
            }
            int i20 = i15;
            switch (i16) {
                case 0:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iE = m9.e(i17, 0.0d);
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 1:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iF = m9.f(i17, 0.0f);
                        i15 = i20 + iF;
                        rbVar = this;
                        t11 = t10;
                    }
                    rbVar = this;
                    t11 = t10;
                    i15 = i20;
                    break;
                case 2:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iC0 = m9.c0(i17, unsafe.getLong(t11, j10));
                        i15 = i20 + iC0;
                        rbVar = this;
                    }
                    rbVar = this;
                    i15 = i20;
                    break;
                case 3:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iC0 = m9.q0(i17, unsafe.getLong(t11, j10));
                        i15 = i20 + iC0;
                        rbVar = this;
                    }
                    rbVar = this;
                    i15 = i20;
                    break;
                case 4:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iC0 = m9.p0(i17, unsafe.getInt(t11, j10));
                        i15 = i20 + iC0;
                        rbVar = this;
                    }
                    rbVar = this;
                    i15 = i20;
                    break;
                case 5:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iF = m9.T(i17, 0L);
                        i15 = i20 + iF;
                        rbVar = this;
                        t11 = t10;
                    }
                    rbVar = this;
                    t11 = t10;
                    i15 = i20;
                    break;
                case 6:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iF = m9.l0(i17, 0);
                        i15 = i20 + iF;
                        rbVar = this;
                        t11 = t10;
                    }
                    rbVar = this;
                    t11 = t10;
                    i15 = i20;
                    break;
                case 7:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iF = m9.D(i17, true);
                        i15 = i20 + iF;
                        rbVar = this;
                        t11 = t10;
                    }
                    rbVar = this;
                    t11 = t10;
                    i15 = i20;
                    break;
                case 8:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        Object object = unsafe.getObject(t11, j10);
                        iC0 = object instanceof v8 ? m9.U(i17, (v8) object) : m9.C(i17, (String) object);
                        i15 = i20 + iC0;
                        rbVar = this;
                    }
                    rbVar = this;
                    i15 = i20;
                    break;
                case 9:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iE = hc.a(i17, unsafe.getObject(t11, j10), rbVar.O(i12));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 10:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iC0 = m9.U(i17, (v8) unsafe.getObject(t11, j10));
                        i15 = i20 + iC0;
                        rbVar = this;
                    }
                    rbVar = this;
                    i15 = i20;
                    break;
                case 11:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iC0 = m9.A0(i17, unsafe.getInt(t11, j10));
                        i15 = i20 + iC0;
                        rbVar = this;
                    }
                    rbVar = this;
                    i15 = i20;
                    break;
                case 12:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iC0 = m9.h0(i17, unsafe.getInt(t11, j10));
                        i15 = i20 + iC0;
                        rbVar = this;
                    }
                    rbVar = this;
                    i15 = i20;
                    break;
                case 13:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iF = m9.t0(i17, 0);
                        i15 = i20 + iF;
                        rbVar = this;
                        t11 = t10;
                    }
                    rbVar = this;
                    t11 = t10;
                    i15 = i20;
                    break;
                case 14:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iF = m9.i0(i17, 0L);
                        i15 = i20 + iF;
                        rbVar = this;
                        t11 = t10;
                    }
                    rbVar = this;
                    t11 = t10;
                    i15 = i20;
                    break;
                case 15:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iC0 = m9.x0(i17, unsafe.getInt(t11, j10));
                        i15 = i20 + iC0;
                        rbVar = this;
                    }
                    rbVar = this;
                    i15 = i20;
                    break;
                case 16:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iC0 = m9.m0(i17, unsafe.getLong(t11, j10));
                        i15 = i20 + iC0;
                        rbVar = this;
                    }
                    rbVar = this;
                    i15 = i20;
                    break;
                case 17:
                    if (rbVar.z(t11, i12, i13, i14, i10)) {
                        iE = m9.B(i17, (ob) unsafe.getObject(t11, j10), rbVar.O(i12));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 18:
                    iE = hc.A(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 19:
                    iE = hc.x(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 20:
                    iE = hc.G(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 21:
                    iE = hc.S(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 22:
                    iE = hc.D(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 23:
                    iE = hc.A(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 24:
                    iE = hc.x(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 25:
                    iE = hc.d(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 26:
                    iE = hc.q(i17, (List) unsafe.getObject(t11, j10));
                    i15 = i20 + iE;
                    break;
                case 27:
                    iE = hc.r(i17, (List) unsafe.getObject(t11, j10), rbVar.O(i12));
                    i15 = i20 + iE;
                    break;
                case 28:
                    iE = hc.b(i17, (List) unsafe.getObject(t11, j10));
                    i15 = i20 + iE;
                    break;
                case 29:
                    iE = hc.P(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 30:
                    iE = hc.s(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 31:
                    iE = hc.x(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 32:
                    iE = hc.A(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 33:
                    iE = hc.J(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 34:
                    iE = hc.M(i17, (List) unsafe.getObject(t11, j10), false);
                    i15 = i20 + iE;
                    break;
                case 35:
                    iB = hc.B((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 36:
                    iB = hc.y((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 37:
                    iB = hc.H((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 38:
                    iB = hc.T((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 39:
                    iB = hc.E((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 40:
                    iB = hc.B((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 41:
                    iB = hc.y((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 42:
                    iB = hc.e((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 43:
                    iB = hc.Q((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 44:
                    iB = hc.t((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 45:
                    iB = hc.y((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 46:
                    iB = hc.B((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 47:
                    iB = hc.K((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 48:
                    iB = hc.N((List) unsafe.getObject(t11, j10));
                    if (iB > 0) {
                        iW0 = m9.w0(i17);
                        iZ0 = m9.z0(iB);
                        i15 = i20 + iW0 + iZ0 + iB;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 49:
                    iE = hc.c(i17, (List) unsafe.getObject(t11, j10), rbVar.O(i12));
                    i15 = i20 + iE;
                    break;
                case 50:
                    iE = rbVar.f3002p.i(i17, unsafe.getObject(t11, j10), rbVar.Q(i12));
                    i15 = i20 + iE;
                    break;
                case 51:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.e(i17, 0.0d);
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 52:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.f(i17, 0.0f);
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 53:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.c0(i17, M(t11, j10));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 54:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.q0(i17, M(t11, j10));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 55:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.p0(i17, H(t11, j10));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 56:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.T(i17, 0L);
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 57:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.l0(i17, 0);
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 58:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.D(i17, true);
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 59:
                    if (rbVar.K(t11, i17, i12)) {
                        Object object2 = unsafe.getObject(t11, j10);
                        iE = object2 instanceof v8 ? m9.U(i17, (v8) object2) : m9.C(i17, (String) object2);
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 60:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = hc.a(i17, unsafe.getObject(t11, j10), rbVar.O(i12));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 61:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.U(i17, (v8) unsafe.getObject(t11, j10));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 62:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.A0(i17, H(t11, j10));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 63:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.h0(i17, H(t11, j10));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 64:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.t0(i17, 0);
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 65:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.i0(i17, 0L);
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 66:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.x0(i17, H(t11, j10));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 67:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.m0(i17, M(t11, j10));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                case 68:
                    if (rbVar.K(t11, i17, i12)) {
                        iE = m9.B(i17, (ob) unsafe.getObject(t11, j10), rbVar.O(i12));
                        i15 = i20 + iE;
                    } else {
                        i15 = i20;
                    }
                    break;
                default:
                    i15 = i20;
                    break;
            }
            i12 += 3;
            i11 = 1048575;
        }
        vc<?, ?> vcVar = rbVar.f3000n;
        int iA = i15 + vcVar.a(vcVar.k(t11));
        if (!rbVar.f2992f) {
            return iA;
        }
        x9<T> x9VarB = rbVar.f3001o.b(t11);
        int iA2 = x9VarB.f3227a.a();
        int iB2 = 0;
        for (int i21 = 0; i21 < iA2; i21++) {
            Map.Entry entryF = x9VarB.f3227a.f(i21);
            iB2 += x9.b((z9) entryF.getKey(), entryF.getValue());
        }
        for (Map.Entry entry : x9VarB.f3227a.h()) {
            iB2 += x9.b((z9) entry.getKey(), entry.getValue());
        }
        return iA + iB2;
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final T b() {
        return (T) this.f2998l.a(this.f2991e);
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final int e(T t10) {
        int i10;
        int iB;
        int length = this.f2987a.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int iG = G(i12);
            int i13 = this.f2987a[i12];
            long j10 = 1048575 & iG;
            int iHashCode = 37;
            switch ((iG & 267386880) >>> 20) {
                case 0:
                    i10 = i11 * 53;
                    iB = ga.b(Double.doubleToLongBits(xc.a(t10, j10)));
                    i11 = i10 + iB;
                    break;
                case 1:
                    i10 = i11 * 53;
                    iB = Float.floatToIntBits(xc.n(t10, j10));
                    i11 = i10 + iB;
                    break;
                case 2:
                    i10 = i11 * 53;
                    iB = ga.b(xc.x(t10, j10));
                    i11 = i10 + iB;
                    break;
                case 3:
                    i10 = i11 * 53;
                    iB = ga.b(xc.x(t10, j10));
                    i11 = i10 + iB;
                    break;
                case 4:
                    i10 = i11 * 53;
                    iB = xc.t(t10, j10);
                    i11 = i10 + iB;
                    break;
                case 5:
                    i10 = i11 * 53;
                    iB = ga.b(xc.x(t10, j10));
                    i11 = i10 + iB;
                    break;
                case 6:
                    i10 = i11 * 53;
                    iB = xc.t(t10, j10);
                    i11 = i10 + iB;
                    break;
                case 7:
                    i10 = i11 * 53;
                    iB = ga.c(xc.F(t10, j10));
                    i11 = i10 + iB;
                    break;
                case 8:
                    i10 = i11 * 53;
                    iB = ((String) xc.B(t10, j10)).hashCode();
                    i11 = i10 + iB;
                    break;
                case 9:
                    Object objB = xc.B(t10, j10);
                    if (objB != null) {
                        iHashCode = objB.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 10:
                    i10 = i11 * 53;
                    iB = xc.B(t10, j10).hashCode();
                    i11 = i10 + iB;
                    break;
                case 11:
                    i10 = i11 * 53;
                    iB = xc.t(t10, j10);
                    i11 = i10 + iB;
                    break;
                case 12:
                    i10 = i11 * 53;
                    iB = xc.t(t10, j10);
                    i11 = i10 + iB;
                    break;
                case 13:
                    i10 = i11 * 53;
                    iB = xc.t(t10, j10);
                    i11 = i10 + iB;
                    break;
                case 14:
                    i10 = i11 * 53;
                    iB = ga.b(xc.x(t10, j10));
                    i11 = i10 + iB;
                    break;
                case 15:
                    i10 = i11 * 53;
                    iB = xc.t(t10, j10);
                    i11 = i10 + iB;
                    break;
                case 16:
                    i10 = i11 * 53;
                    iB = ga.b(xc.x(t10, j10));
                    i11 = i10 + iB;
                    break;
                case 17:
                    Object objB2 = xc.B(t10, j10);
                    if (objB2 != null) {
                        iHashCode = objB2.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i10 = i11 * 53;
                    iB = xc.B(t10, j10).hashCode();
                    i11 = i10 + iB;
                    break;
                case 50:
                    i10 = i11 * 53;
                    iB = xc.B(t10, j10).hashCode();
                    i11 = i10 + iB;
                    break;
                case 51:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = ga.b(Double.doubleToLongBits(j(t10, j10)));
                        i11 = i10 + iB;
                    }
                    break;
                case 52:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = Float.floatToIntBits(B(t10, j10));
                        i11 = i10 + iB;
                    }
                    break;
                case 53:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = ga.b(M(t10, j10));
                        i11 = i10 + iB;
                    }
                    break;
                case 54:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = ga.b(M(t10, j10));
                        i11 = i10 + iB;
                    }
                    break;
                case 55:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = H(t10, j10);
                        i11 = i10 + iB;
                    }
                    break;
                case 56:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = ga.b(M(t10, j10));
                        i11 = i10 + iB;
                    }
                    break;
                case 57:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = H(t10, j10);
                        i11 = i10 + iB;
                    }
                    break;
                case 58:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = ga.c(P(t10, j10));
                        i11 = i10 + iB;
                    }
                    break;
                case 59:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = ((String) xc.B(t10, j10)).hashCode();
                        i11 = i10 + iB;
                    }
                    break;
                case 60:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = xc.B(t10, j10).hashCode();
                        i11 = i10 + iB;
                    }
                    break;
                case 61:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = xc.B(t10, j10).hashCode();
                        i11 = i10 + iB;
                    }
                    break;
                case 62:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = H(t10, j10);
                        i11 = i10 + iB;
                    }
                    break;
                case 63:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = H(t10, j10);
                        i11 = i10 + iB;
                    }
                    break;
                case 64:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = H(t10, j10);
                        i11 = i10 + iB;
                    }
                    break;
                case 65:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = ga.b(M(t10, j10));
                        i11 = i10 + iB;
                    }
                    break;
                case 66:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = H(t10, j10);
                        i11 = i10 + iB;
                    }
                    break;
                case 67:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = ga.b(M(t10, j10));
                        i11 = i10 + iB;
                    }
                    break;
                case 68:
                    if (K(t10, i13, i12)) {
                        i10 = i11 * 53;
                        iB = xc.B(t10, j10).hashCode();
                        i11 = i10 + iB;
                    }
                    break;
            }
        }
        int iHashCode2 = (i11 * 53) + this.f3000n.k(t10).hashCode();
        return this.f2992f ? (iHashCode2 * 53) + this.f3001o.b(t10).hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    @Override // com.google.android.gms.internal.measurement.fc
    public final boolean i(T t10, T t11) {
        int length = this.f2987a.length;
        int i10 = 0;
        while (true) {
            boolean zP = true;
            if (i10 >= length) {
                if (!this.f3000n.k(t10).equals(this.f3000n.k(t11))) {
                    return false;
                }
                if (this.f2992f) {
                    return this.f3001o.b(t10).equals(this.f3001o.b(t11));
                }
                return true;
            }
            int iG = G(i10);
            long j10 = iG & 1048575;
            switch ((iG & 267386880) >>> 20) {
                case 0:
                    if (!L(t10, t11, i10) || Double.doubleToLongBits(xc.a(t10, j10)) != Double.doubleToLongBits(xc.a(t11, j10))) {
                        zP = false;
                    }
                    break;
                case 1:
                    if (!L(t10, t11, i10) || Float.floatToIntBits(xc.n(t10, j10)) != Float.floatToIntBits(xc.n(t11, j10))) {
                        zP = false;
                    }
                    break;
                case 2:
                    if (!L(t10, t11, i10) || xc.x(t10, j10) != xc.x(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 3:
                    if (!L(t10, t11, i10) || xc.x(t10, j10) != xc.x(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 4:
                    if (!L(t10, t11, i10) || xc.t(t10, j10) != xc.t(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 5:
                    if (!L(t10, t11, i10) || xc.x(t10, j10) != xc.x(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 6:
                    if (!L(t10, t11, i10) || xc.t(t10, j10) != xc.t(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 7:
                    if (!L(t10, t11, i10) || xc.F(t10, j10) != xc.F(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 8:
                    if (!L(t10, t11, i10) || !hc.p(xc.B(t10, j10), xc.B(t11, j10))) {
                        zP = false;
                    }
                    break;
                case 9:
                    if (!L(t10, t11, i10) || !hc.p(xc.B(t10, j10), xc.B(t11, j10))) {
                        zP = false;
                    }
                    break;
                case 10:
                    if (!L(t10, t11, i10) || !hc.p(xc.B(t10, j10), xc.B(t11, j10))) {
                        zP = false;
                    }
                    break;
                case 11:
                    if (!L(t10, t11, i10) || xc.t(t10, j10) != xc.t(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 12:
                    if (!L(t10, t11, i10) || xc.t(t10, j10) != xc.t(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 13:
                    if (!L(t10, t11, i10) || xc.t(t10, j10) != xc.t(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 14:
                    if (!L(t10, t11, i10) || xc.x(t10, j10) != xc.x(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 15:
                    if (!L(t10, t11, i10) || xc.t(t10, j10) != xc.t(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 16:
                    if (!L(t10, t11, i10) || xc.x(t10, j10) != xc.x(t11, j10)) {
                        zP = false;
                    }
                    break;
                case 17:
                    if (!L(t10, t11, i10) || !hc.p(xc.B(t10, j10), xc.B(t11, j10))) {
                        zP = false;
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zP = hc.p(xc.B(t10, j10), xc.B(t11, j10));
                    break;
                case 50:
                    zP = hc.p(xc.B(t10, j10), xc.B(t11, j10));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jC = C(i10) & 1048575;
                    if (xc.t(t10, jC) != xc.t(t11, jC) || !hc.p(xc.B(t10, j10), xc.B(t11, j10))) {
                        zP = false;
                    }
                    break;
            }
            if (!zP) {
                return false;
            }
            i10 += 3;
        }
    }

    private rb(int[] iArr, Object[] objArr, int i10, int i11, ob obVar, boolean z10, int[] iArr2, int i12, int i13, vb vbVar, ya yaVar, vc<?, ?> vcVar, s9<?> s9Var, hb hbVar) {
        boolean z11;
        this.f2987a = iArr;
        this.f2988b = objArr;
        this.f2989c = i10;
        this.f2990d = i11;
        this.f2993g = obVar instanceof ea;
        if (s9Var != null && s9Var.e(obVar)) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f2992f = z11;
        this.f2994h = false;
        this.f2995i = iArr2;
        this.f2996j = i12;
        this.f2997k = i13;
        this.f2998l = vbVar;
        this.f2999m = yaVar;
        this.f3000n = vcVar;
        this.f3001o = s9Var;
        this.f2991e = obVar;
        this.f3002p = hbVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean A(Object obj, int i10, fc fcVar) {
        return fcVar.c(xc.B(obj, i10 & 1048575));
    }

    private static <T> float B(T t10, long j10) {
        return ((Float) xc.B(t10, j10)).floatValue();
    }

    private final void D(T t10, int i10) {
        int iC = C(i10);
        long j10 = 1048575 & iC;
        if (j10 == 1048575) {
            return;
        }
        xc.h(t10, j10, (1 << (iC >>> 20)) | xc.t(t10, j10));
    }

    private final void E(T t10, int i10, int i11) {
        xc.h(t10, C(i11) & 1048575, i10);
    }

    private static <T> int H(T t10, long j10) {
        return ((Integer) xc.B(t10, j10)).intValue();
    }

    private final boolean J(T t10, int i10) {
        int iC = C(i10);
        long j10 = iC & 1048575;
        if (j10 == 1048575) {
            int iG = G(i10);
            long j11 = iG & 1048575;
            switch ((iG & 267386880) >>> 20) {
                case 0:
                    if (Double.doubleToRawLongBits(xc.a(t10, j11)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(xc.n(t10, j11)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (xc.x(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (xc.x(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (xc.t(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (xc.x(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (xc.t(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return xc.F(t10, j11);
                case 8:
                    Object objB = xc.B(t10, j11);
                    if (objB instanceof String) {
                        if (((String) objB).isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                    if (objB instanceof v8) {
                        if (v8.f3170a.equals(objB)) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (xc.B(t10, j11) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (v8.f3170a.equals(xc.B(t10, j11))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (xc.t(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (xc.t(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (xc.t(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (xc.x(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (xc.t(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (xc.x(t10, j11) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (xc.B(t10, j11) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((xc.t(t10, j10) & (1 << (iC >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean K(T t10, int i10, int i11) {
        if (xc.t(t10, C(i11) & 1048575) == i10) {
            return true;
        }
        return false;
    }

    private final boolean L(T t10, T t11, int i10) {
        if (J(t10, i10) == J(t11, i10)) {
            return true;
        }
        return false;
    }

    private static <T> long M(T t10, long j10) {
        return ((Long) xc.B(t10, j10)).longValue();
    }

    private static <T> boolean P(T t10, long j10) {
        return ((Boolean) xc.B(t10, j10)).booleanValue();
    }

    private static void R(Object obj) {
        if (T(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    private static <T> double j(T t10, long j10) {
        return ((Double) xc.B(t10, j10)).doubleValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object p(T t10, int i10) {
        fc fcVarO = O(i10);
        long jG = G(i10) & 1048575;
        if (!J(t10, i10)) {
            return fcVarO.b();
        }
        Object object = f2986r.getObject(t10, jG);
        if (T(object)) {
            return object;
        }
        Object objB = fcVarO.b();
        if (object != null) {
            fcVarO.f(objB, object);
        }
        return objB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object q(T t10, int i10, int i11) {
        fc fcVarO = O(i11);
        if (!K(t10, i10, i11)) {
            return fcVarO.b();
        }
        Object object = f2986r.getObject(t10, G(i11) & 1048575);
        if (T(object)) {
            return object;
        }
        Object objB = fcVarO.b();
        if (object != null) {
            fcVarO.f(objB, object);
        }
        return objB;
    }

    private static Field s(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static <UT, UB> void u(vc<UT, UB> vcVar, T t10, nd ndVar) {
        vcVar.g(vcVar.k(t10), ndVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(T t10, T t11, int i10) {
        if (!J(t11, i10)) {
            return;
        }
        long jG = G(i10) & 1048575;
        Unsafe unsafe = f2986r;
        Object object = unsafe.getObject(t11, jG);
        if (object != null) {
            fc fcVarO = O(i10);
            if (!J(t10, i10)) {
                if (!T(object)) {
                    unsafe.putObject(t10, jG, object);
                } else {
                    Object objB = fcVarO.b();
                    fcVarO.f(objB, object);
                    unsafe.putObject(t10, jG, objB);
                }
                D(t10, i10);
                return;
            }
            Object object2 = unsafe.getObject(t10, jG);
            if (!T(object2)) {
                Object objB2 = fcVarO.b();
                fcVarO.f(objB2, object2);
                unsafe.putObject(t10, jG, objB2);
                object2 = objB2;
            }
            fcVarO.f(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.f2987a[i10] + " is present but null: " + String.valueOf(t11));
    }

    private final boolean z(T t10, int i10, int i11, int i12, int i13) {
        if (i11 == 1048575) {
            return J(t10, i10);
        }
        if ((i12 & i13) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0098  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00bd A[LOOP:1: B:45:0x00ac->B:50:0x00bd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.fc
    public final boolean c(T t10) {
        int i10;
        int i11;
        rb<T> rbVar;
        T t11;
        List list;
        fc fcVarO;
        int i12;
        int i13 = 0;
        int i14 = 1048575;
        int i15 = 0;
        while (i13 < this.f2996j) {
            int i16 = this.f2995i[i13];
            int i17 = this.f2987a[i16];
            int iG = G(i16);
            int i18 = this.f2987a[i16 + 2];
            int i19 = i18 & 1048575;
            int i20 = 1 << (i18 >>> 20);
            if (i19 != i14) {
                if (i19 != 1048575) {
                    i15 = f2986r.getInt(t10, i19);
                }
                i11 = i15;
                i10 = i19;
            } else {
                i10 = i14;
                i11 = i15;
            }
            if ((268435456 & iG) != 0) {
                rbVar = this;
                t11 = t10;
                if (!rbVar.z(t11, i16, i10, i11, i20)) {
                    return false;
                }
            } else {
                rbVar = this;
                t11 = t10;
            }
            int i21 = (267386880 & iG) >>> 20;
            if (i21 != 9 && i21 != 17) {
                if (i21 != 27) {
                    if (i21 != 60 && i21 != 68) {
                        if (i21 != 49) {
                            if (i21 == 50 && !rbVar.f3002p.d(xc.B(t11, iG & 1048575)).isEmpty()) {
                                rbVar.f3002p.a(Q(i16));
                                throw null;
                            }
                        } else {
                            list = (List) xc.B(t11, iG & 1048575);
                            if (list.isEmpty()) {
                                continue;
                            } else {
                                fcVarO = O(i16);
                                for (i12 = 0; i12 < list.size(); i12++) {
                                    if (!fcVarO.c(list.get(i12))) {
                                        return false;
                                    }
                                }
                            }
                        }
                    } else if (K(t11, i17, i16) && !A(t11, iG, O(i16))) {
                        return false;
                    }
                } else {
                    list = (List) xc.B(t11, iG & 1048575);
                    if (list.isEmpty()) {
                        fcVarO = O(i16);
                        while (i12 < list.size()) {
                            if (!fcVarO.c(list.get(i12))) {
                                return false;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            } else if (rbVar.z(t11, i16, i10, i11, i20) && !A(t11, iG, O(i16))) {
                return false;
            }
            i13++;
            t10 = t11;
            i14 = i10;
            i15 = i11;
        }
        T t12 = t10;
        if (this.f2992f && !this.f3001o.b(t12).s()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.fc
    public final void d(T t10) {
        if (T(t10)) {
            if (t10 instanceof ea) {
                ea eaVar = (ea) t10;
                eaVar.k(Integer.MAX_VALUE);
                eaVar.zza = 0;
                eaVar.I();
            }
            int length = this.f2987a.length;
            for (int i10 = 0; i10 < length; i10 += 3) {
                int iG = G(i10);
                long j10 = 1048575 & iG;
                int i11 = (iG & 267386880) >>> 20;
                if (i11 != 9) {
                    if (i11 == 60 || i11 == 68) {
                        if (K(t10, this.f2987a[i10], i10)) {
                            O(i10).d(f2986r.getObject(t10, j10));
                        }
                    } else {
                        switch (i11) {
                            case 17:
                                if (J(t10, i10)) {
                                    O(i10).d(f2986r.getObject(t10, j10));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.f2999m.a(t10, j10);
                                break;
                            case 50:
                                Unsafe unsafe = f2986r;
                                Object object = unsafe.getObject(t10, j10);
                                if (object != null) {
                                    unsafe.putObject(t10, j10, this.f3002p.h(object));
                                }
                                break;
                        }
                    }
                } else if (J(t10, i10)) {
                    O(i10).d(f2986r.getObject(t10, j10));
                }
            }
            this.f3000n.l(t10);
            if (this.f2992f) {
                this.f3001o.g(t10);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.fc
    public final void f(T t10, T t11) {
        R(t10);
        t11.getClass();
        for (int i10 = 0; i10 < this.f2987a.length; i10 += 3) {
            int iG = G(i10);
            long j10 = 1048575 & iG;
            int i11 = this.f2987a[i10];
            switch ((iG & 267386880) >>> 20) {
                case 0:
                    if (J(t11, i10)) {
                        xc.f(t10, j10, xc.a(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 1:
                    if (J(t11, i10)) {
                        xc.g(t10, j10, xc.n(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 2:
                    if (J(t11, i10)) {
                        xc.i(t10, j10, xc.x(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 3:
                    if (J(t11, i10)) {
                        xc.i(t10, j10, xc.x(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 4:
                    if (J(t11, i10)) {
                        xc.h(t10, j10, xc.t(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 5:
                    if (J(t11, i10)) {
                        xc.i(t10, j10, xc.x(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 6:
                    if (J(t11, i10)) {
                        xc.h(t10, j10, xc.t(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 7:
                    if (J(t11, i10)) {
                        xc.v(t10, j10, xc.F(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 8:
                    if (J(t11, i10)) {
                        xc.j(t10, j10, xc.B(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 9:
                    y(t10, t11, i10);
                    break;
                case 10:
                    if (J(t11, i10)) {
                        xc.j(t10, j10, xc.B(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 11:
                    if (J(t11, i10)) {
                        xc.h(t10, j10, xc.t(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 12:
                    if (J(t11, i10)) {
                        xc.h(t10, j10, xc.t(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 13:
                    if (J(t11, i10)) {
                        xc.h(t10, j10, xc.t(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 14:
                    if (J(t11, i10)) {
                        xc.i(t10, j10, xc.x(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 15:
                    if (J(t11, i10)) {
                        xc.h(t10, j10, xc.t(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 16:
                    if (J(t11, i10)) {
                        xc.i(t10, j10, xc.x(t11, j10));
                        D(t10, i10);
                    }
                    break;
                case 17:
                    y(t10, t11, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f2999m.b(t10, t11, j10);
                    break;
                case 50:
                    hc.m(this.f3002p, t10, t11, j10);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (K(t11, i11, i10)) {
                        xc.j(t10, j10, xc.B(t11, j10));
                        E(t10, i11, i10);
                    }
                    break;
                case 60:
                    F(t10, t11, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (K(t11, i11, i10)) {
                        xc.j(t10, j10, xc.B(t11, j10));
                        E(t10, i11, i10);
                    }
                    break;
                case 68:
                    F(t10, t11, i10);
                    break;
            }
        }
        hc.n(this.f3000n, t10, t11);
        if (this.f2992f) {
            hc.l(this.f3001o, t10, t11);
        }
    }
}
