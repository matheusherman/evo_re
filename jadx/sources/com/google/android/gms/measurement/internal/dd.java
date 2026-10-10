package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.ke;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class dd extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.google.android.gms.internal.measurement.m4 f3499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zc f3500h;

    @Override // com.google.android.gms.measurement.internal.d
    final boolean j() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    dd(zc zcVar, String str, int i10, com.google.android.gms.internal.measurement.m4 m4Var) {
        super(str, i10);
        this.f3500h = zcVar;
        this.f3499g = m4Var;
    }

    @Override // com.google.android.gms.measurement.internal.d
    final int a() {
        return this.f3499g.N();
    }

    @Override // com.google.android.gms.measurement.internal.d
    final boolean i() {
        return this.f3499g.Y();
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:107:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:112:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:114:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:115:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:117:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:119:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:122:0x0301  */
    /* JADX WARN: Code duplicated, block: B:128:0x0355 A[EDGE_INSN: B:128:0x0355->B:131:0x03a1 BREAK  A[LOOP:0: B:47:0x0117->B:52:0x0148]] */
    /* JADX WARN: Code duplicated, block: B:129:0x037b A[EDGE_INSN: B:129:0x037b->B:131:0x03a1 BREAK  A[LOOP:0: B:47:0x0117->B:52:0x0148]] */
    /* JADX WARN: Code duplicated, block: B:164:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x012d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x01ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x01af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x0179 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x01c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x015d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x027d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x039f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0281 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x0240 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x03a1 A[EDGE_INSN: B:183:0x03a1->B:131:0x03a1 BREAK  A[LOOP:0: B:47:0x0117->B:52:0x0148], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x02cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x028b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x03a1 A[EDGE_INSN: B:186:0x03a1->B:131:0x03a1 BREAK  A[LOOP:0: B:47:0x0117->B:52:0x0148], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x02c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x023a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0285 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x0353 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x032f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x030b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x03a1 A[EDGE_INSN: B:193:0x03a1->B:131:0x03a1 BREAK  A[LOOP:0: B:47:0x0117->B:52:0x0148], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x0307 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x010a  */
    /* JADX WARN: Code duplicated, block: B:49:0x011d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0148 A[LOOP:0: B:47:0x0117->B:52:0x0148, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x0163  */
    /* JADX WARN: Code duplicated, block: B:62:0x0183  */
    /* JADX WARN: Code duplicated, block: B:63:0x018c  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:70:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:74:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:84:0x020c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0232  */
    /* JADX WARN: Code duplicated, block: B:93:0x0265  */
    /* JADX WARN: Code duplicated, block: B:96:0x0277  */
    final boolean k(Long l10, Long l11, com.google.android.gms.internal.measurement.o5 o5Var, long j10, c0 c0Var, boolean z10) {
        boolean z11;
        long j11;
        boolean z12;
        HashSet hashSet;
        Iterator<com.google.android.gms.internal.measurement.n4> it;
        ArrayMap arrayMap;
        Iterator<com.google.android.gms.internal.measurement.q5> it2;
        Iterator<com.google.android.gms.internal.measurement.n4> it3;
        com.google.android.gms.internal.measurement.n4 next;
        boolean z13;
        String strQ;
        Object obj;
        Boolean boolC;
        Boolean boolB;
        String str;
        Boolean boolE;
        com.google.android.gms.internal.measurement.q5 next2;
        Long lValueOf;
        Double dValueOf;
        com.google.android.gms.internal.measurement.n4 next3;
        Object obj2;
        Integer numValueOf;
        if (ke.a() && this.f3500h.d().K(this.f3466a, g0.E0)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.f3499g.X()) {
            j11 = c0Var.f3444e;
        } else {
            j11 = j10;
        }
        Integer numValueOf2 = null;
        Integer numValueOf3 = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        Boolean bool = null;
        if (this.f3500h.l().D(2)) {
            r5 r5VarL = this.f3500h.l().L();
            Integer numValueOf4 = Integer.valueOf(this.f3467b);
            if (this.f3499g.Z()) {
                numValueOf = Integer.valueOf(this.f3499g.N());
            } else {
                numValueOf = null;
            }
            r5VarL.d("Evaluating filter. audience, filter, event", numValueOf4, numValueOf, this.f3500h.g().c(this.f3499g.S()));
            this.f3500h.l().L().b("Filter definition", this.f3500h.o().L(this.f3499g));
        }
        if (this.f3499g.Z() && this.f3499g.N() <= 256) {
            boolean zU = this.f3499g.U();
            boolean zW = this.f3499g.W();
            boolean zX = this.f3499g.X();
            if (!zU && !zW && !zX) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z10 && !z12) {
                r5 r5VarL2 = this.f3500h.l().L();
                Integer numValueOf5 = Integer.valueOf(this.f3467b);
                if (this.f3499g.Z()) {
                    numValueOf3 = Integer.valueOf(this.f3499g.N());
                }
                r5VarL2.c("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", numValueOf5, numValueOf3);
                return true;
            }
            com.google.android.gms.internal.measurement.m4 m4Var = this.f3499g;
            String strA0 = o5Var.a0();
            if (m4Var.Y()) {
                Boolean boolC2 = d.c(j11, m4Var.R());
                if (boolC2 != null) {
                    if (!boolC2.booleanValue()) {
                        bool = Boolean.FALSE;
                    } else {
                        hashSet = new HashSet();
                        it = m4Var.T().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                next3 = it.next();
                                if (next3.Q().isEmpty()) {
                                    this.f3500h.l().M().b("null or empty param name in filter. event", this.f3500h.g().c(strA0));
                                    break;
                                }
                                hashSet.add(next3.Q());
                            } else {
                                arrayMap = new ArrayMap();
                                it2 = o5Var.b0().iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        next2 = it2.next();
                                        if (!hashSet.contains(next2.c0())) {
                                            if (next2.h0()) {
                                                String strC0 = next2.c0();
                                                if (next2.h0()) {
                                                    lValueOf = Long.valueOf(next2.Y());
                                                } else {
                                                    lValueOf = null;
                                                }
                                                arrayMap.put(strC0, lValueOf);
                                            } else if (next2.f0()) {
                                                String strC1 = next2.c0();
                                                if (next2.f0()) {
                                                    dValueOf = Double.valueOf(next2.K());
                                                } else {
                                                    dValueOf = null;
                                                }
                                                arrayMap.put(strC1, dValueOf);
                                            } else if (next2.j0()) {
                                                arrayMap.put(next2.c0(), next2.d0());
                                            } else {
                                                this.f3500h.l().M().c("Unknown value for param. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(next2.c0()));
                                                break;
                                            }
                                        }
                                    } else {
                                        it3 = m4Var.T().iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                next = it3.next();
                                                if (!next.S()) {
                                                    z13 = false;
                                                } else {
                                                    z13 = false;
                                                }
                                                strQ = next.Q();
                                                if (strQ.isEmpty()) {
                                                    this.f3500h.l().M().b("Event has empty param name. event", this.f3500h.g().c(strA0));
                                                    break;
                                                }
                                                obj = arrayMap.get(strQ);
                                                if (obj instanceof Long) {
                                                    if (!next.T()) {
                                                        this.f3500h.l().M().c("No number filter for long param. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                        break;
                                                    }
                                                    boolC = d.c(((Long) obj).longValue(), next.N());
                                                    if (boolC != null) {
                                                        break;
                                                        break;
                                                    }
                                                    if (boolC.booleanValue() == z13) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                } else if (obj instanceof Double) {
                                                    if (!next.T()) {
                                                        this.f3500h.l().M().c("No number filter for double param. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                        break;
                                                    }
                                                    boolB = d.b(((Double) obj).doubleValue(), next.N());
                                                    if (boolB != null) {
                                                        break;
                                                        break;
                                                    }
                                                    if (boolB.booleanValue() == z13) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                } else if (obj instanceof String) {
                                                    if (next.W()) {
                                                        boolE = d.g((String) obj, next.O(), this.f3500h.l());
                                                    } else if (next.T()) {
                                                        str = (String) obj;
                                                        if (sc.h0(str)) {
                                                            boolE = d.e(str, next.N());
                                                        } else {
                                                            this.f3500h.l().M().c("Invalid param value for number filter. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                            break;
                                                        }
                                                    } else {
                                                        this.f3500h.l().M().c("No filter for String param. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                        break;
                                                    }
                                                    if (boolE != null) {
                                                        break;
                                                        break;
                                                    }
                                                    if (boolE.booleanValue() == z13) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                } else {
                                                    if (obj == null) {
                                                        this.f3500h.l().L().c("Missing param for filter. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                    this.f3500h.l().M().c("Unknown param type. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                    break;
                                                }
                                            } else {
                                                bool = Boolean.TRUE;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                hashSet = new HashSet();
                it = m4Var.T().iterator();
                while (true) {
                    if (it.hasNext()) {
                        next3 = it.next();
                        if (next3.Q().isEmpty()) {
                            this.f3500h.l().M().b("null or empty param name in filter. event", this.f3500h.g().c(strA0));
                            break;
                        }
                        hashSet.add(next3.Q());
                    } else {
                        arrayMap = new ArrayMap();
                        it2 = o5Var.b0().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next2 = it2.next();
                                if (!hashSet.contains(next2.c0())) {
                                    if (next2.h0()) {
                                        String strC2 = next2.c0();
                                        if (next2.h0()) {
                                            lValueOf = Long.valueOf(next2.Y());
                                        } else {
                                            lValueOf = null;
                                        }
                                        arrayMap.put(strC2, lValueOf);
                                    } else if (next2.f0()) {
                                        String strC3 = next2.c0();
                                        if (next2.f0()) {
                                            dValueOf = Double.valueOf(next2.K());
                                        } else {
                                            dValueOf = null;
                                        }
                                        arrayMap.put(strC3, dValueOf);
                                    } else if (next2.j0()) {
                                        arrayMap.put(next2.c0(), next2.d0());
                                    } else {
                                        this.f3500h.l().M().c("Unknown value for param. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(next2.c0()));
                                        break;
                                    }
                                }
                            } else {
                                it3 = m4Var.T().iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        next = it3.next();
                                        if (!next.S() && next.R()) {
                                            z13 = true;
                                        } else {
                                            z13 = false;
                                        }
                                        strQ = next.Q();
                                        if (strQ.isEmpty()) {
                                            this.f3500h.l().M().b("Event has empty param name. event", this.f3500h.g().c(strA0));
                                            break;
                                        }
                                        obj = arrayMap.get(strQ);
                                        if (obj instanceof Long) {
                                            if (!next.T()) {
                                                this.f3500h.l().M().c("No number filter for long param. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                break;
                                            }
                                            boolC = d.c(((Long) obj).longValue(), next.N());
                                            if (boolC != null) {
                                                break;
                                            }
                                            if (boolC.booleanValue() == z13) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else if (obj instanceof Double) {
                                            if (!next.T()) {
                                                this.f3500h.l().M().c("No number filter for double param. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                break;
                                            }
                                            boolB = d.b(((Double) obj).doubleValue(), next.N());
                                            if (boolB != null) {
                                                break;
                                            }
                                            if (boolB.booleanValue() == z13) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else if (obj instanceof String) {
                                            if (next.W()) {
                                                boolE = d.g((String) obj, next.O(), this.f3500h.l());
                                            } else if (next.T()) {
                                                str = (String) obj;
                                                if (sc.h0(str)) {
                                                    boolE = d.e(str, next.N());
                                                } else {
                                                    this.f3500h.l().M().c("Invalid param value for number filter. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                    break;
                                                }
                                            } else {
                                                this.f3500h.l().M().c("No filter for String param. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                break;
                                            }
                                            if (boolE != null) {
                                                break;
                                            }
                                            if (boolE.booleanValue() == z13) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else {
                                            if (obj == null) {
                                                this.f3500h.l().L().c("Missing param for filter. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                            this.f3500h.l().M().c("Unknown param type. event, param", this.f3500h.g().c(strA0), this.f3500h.g().f(strQ));
                                            break;
                                        }
                                    } else {
                                        bool = Boolean.TRUE;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            r5 r5VarL3 = this.f3500h.l().L();
            if (bool == null) {
                obj2 = Configurator.NULL;
            } else {
                obj2 = bool;
            }
            r5VarL3.b("Event filter result", obj2);
            if (bool == null) {
                return false;
            }
            Boolean bool2 = Boolean.TRUE;
            this.f3468c = bool2;
            if (!bool.booleanValue()) {
                return true;
            }
            this.f3469d = bool2;
            if (z12 && o5Var.e0()) {
                Long lValueOf2 = Long.valueOf(o5Var.X());
                if (this.f3499g.W()) {
                    if (!z11 || !this.f3499g.Y()) {
                        l10 = lValueOf2;
                    }
                    this.f3471f = l10;
                } else {
                    if (z11 && this.f3499g.Y()) {
                        lValueOf2 = l11;
                    }
                    this.f3470e = lValueOf2;
                }
            }
            return true;
        }
        r5 r5VarM = this.f3500h.l().M();
        Object objW = p5.w(this.f3466a);
        if (this.f3499g.Z()) {
            numValueOf2 = Integer.valueOf(this.f3499g.N());
        }
        r5VarM.c("Invalid event filter ID. appId, id", objW, String.valueOf(numValueOf2));
        return false;
    }
}
