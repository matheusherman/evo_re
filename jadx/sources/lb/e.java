package lb;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.n0;
import kotlin.jvm.internal.m;
import okhttp3.d0;
import okhttp3.u;
import okhttp3.v;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001a!\u0010\u001b\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001e\u001a\u00020\r*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001f\"\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!\"\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010!¨\u0006$"}, d2 = {"Lokhttp3/u;", "", "headerName", "", "Lokhttp3/h;", "a", "(Lokhttp3/u;Ljava/lang/String;)Ljava/util/List;", "Ltb/d;", "", "result", "Lr8/z;", "c", "(Ltb/d;Ljava/util/List;)V", "", "g", "(Ltb/d;)Z", "", "prefix", "h", "(Ltb/d;B)Z", "d", "(Ltb/d;)Ljava/lang/String;", "e", "Lokhttp3/n;", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "headers", "f", "(Lokhttp3/n;Lokhttp3/v;Lokhttp3/u;)V", "Lokhttp3/d0;", "b", "(Lokhttp3/d0;)Z", "Ltb/g;", "Ltb/g;", "QUOTED_STRING_DELIMITERS", "TOKEN_DELIMITERS", "okhttp"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final tb.g f15338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final tb.g f15339b;

    /* JADX WARN: Code duplicated, block: B:27:0x0085  */
    /* JADX WARN: Code duplicated, block: B:35:0x0098  */
    /* JADX WARN: Code duplicated, block: B:36:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bc A[EDGE_INSN: B:59:0x00bc->B:48:0x00bc BREAK  A[LOOP:2: B:22:0x0073->B:47:0x00ba], SYNTHETIC] */
    private static final void c(tb.d dVar, List<okhttp3.h> list) {
        String strE;
        while (true) {
            String strE2 = null;
            while (true) {
                if (strE2 == null) {
                    g(dVar);
                    strE2 = e(dVar);
                    if (strE2 == null) {
                        return;
                    }
                }
                boolean zG = g(dVar);
                String strE3 = e(dVar);
                if (strE3 == null) {
                    if (dVar.L()) {
                        list.add(new okhttp3.h(strE2, n0.i()));
                        return;
                    }
                    return;
                }
                int iK = hb.d.K(dVar, (byte) 61);
                boolean zG2 = g(dVar);
                if (zG || !(zG2 || dVar.L())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iK2 = iK + hb.d.K(dVar, (byte) 61);
                    while (true) {
                        if (strE3 != null) {
                            if (iK2 != 0) {
                                break;
                                break;
                            }
                            if (iK2 <= 1) {
                                return;
                            }
                            if (h(dVar, (byte) 34)) {
                                strE = d(dVar);
                            } else {
                                strE = e(dVar);
                            }
                            if (strE != null) {
                                return;
                            }
                            if (g(dVar)) {
                            }
                            strE3 = null;
                        } else {
                            strE3 = e(dVar);
                            if (!g(dVar)) {
                                iK2 = hb.d.K(dVar, (byte) 61);
                                if (iK2 != 0) {
                                    break;
                                }
                                if (iK2 <= 1 || g(dVar)) {
                                    return;
                                }
                                if (h(dVar, (byte) 34)) {
                                    strE = d(dVar);
                                } else {
                                    strE = e(dVar);
                                }
                                if (strE != null || ((String) linkedHashMap.put(strE3, strE)) != null) {
                                    return;
                                }
                                if (g(dVar) && !dVar.L()) {
                                    return;
                                } else {
                                    strE3 = null;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    list.add(new okhttp3.h(strE2, linkedHashMap));
                    strE2 = strE3;
                } else {
                    Map mapSingletonMap = Collections.singletonMap(null, strE3 + n.A("=", iK));
                    m.e(mapSingletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
                    list.add(new okhttp3.h(strE2, mapSingletonMap));
                }
            }
        }
    }

    private static final boolean g(tb.d dVar) {
        boolean z10 = false;
        while (!dVar.L()) {
            byte bK = dVar.k(0L);
            if (bK == 44) {
                dVar.readByte();
                z10 = true;
            } else {
                if (bK != 32 && bK != 9) {
                    break;
                }
                dVar.readByte();
            }
        }
        return z10;
    }

    static {
        tb.g.Companion companion = tb.g.INSTANCE;
        f15338a = companion.c("\"\\");
        f15339b = companion.c("\t ,=");
    }

    public static final List<okhttp3.h> a(u uVar, String headerName) {
        m.f(uVar, "<this>");
        m.f(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = uVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (n.w(headerName, uVar.f(i10), true)) {
                try {
                    c(new tb.d().T(uVar.k(i10)), arrayList);
                } catch (EOFException e10) {
                    ob.m.INSTANCE.g().j("Unable to parse challenge", 5, e10);
                }
            }
        }
        return arrayList;
    }

    public static final boolean b(d0 d0Var) {
        m.f(d0Var, "<this>");
        if (m.a(d0Var.getRequest().getMethod(), "HEAD")) {
            return false;
        }
        int code = d0Var.getCode();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && hb.d.v(d0Var) == -1 && !n.w("chunked", d0.l(d0Var, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    private static final String e(tb.d dVar) {
        long jM = dVar.m(f15339b);
        if (jM == -1) {
            jM = dVar.getSize();
        }
        if (jM != 0) {
            return dVar.x(jM);
        }
        return null;
    }

    public static final void f(okhttp3.n nVar, v url, u headers) {
        m.f(nVar, "<this>");
        m.f(url, "url");
        m.f(headers, "headers");
        if (nVar == okhttp3.n.f16932b) {
            return;
        }
        List<okhttp3.m> listG = okhttp3.m.INSTANCE.g(url, headers);
        if (listG.isEmpty()) {
            return;
        }
        nVar.a(url, listG);
    }

    private static final String d(tb.d dVar) {
        if (dVar.readByte() == 34) {
            tb.d dVar2 = new tb.d();
            while (true) {
                long jM = dVar.m(f15338a);
                if (jM == -1) {
                    return null;
                }
                if (dVar.k(jM) == 34) {
                    dVar2.N(dVar, jM);
                    dVar.readByte();
                    return dVar2.v();
                }
                if (dVar.getSize() == jM + 1) {
                    return null;
                }
                dVar2.N(dVar, jM);
                dVar.readByte();
                dVar2.N(dVar, 1L);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    private static final boolean h(tb.d dVar, byte b10) {
        if (!dVar.L() && dVar.k(0L) == b10) {
            return true;
        }
        return false;
    }
}
