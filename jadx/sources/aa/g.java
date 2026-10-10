package aa;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.IndexedValue;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g implements y9.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f182d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<String> f184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<String, Integer> f185g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Integer> f187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<z9.a.e.c> f188c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f189a;

        static {
            int[] iArr = new int[z9.a.e.c.EnumC0492c.values().length];
            try {
                iArr[z9.a.e.c.EnumC0492c.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[z9.a.e.c.EnumC0492c.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[z9.a.e.c.EnumC0492c.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f189a = iArr;
        }
    }

    static {
        String strQ0 = r.q0(r.o('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
        f183e = strQ0;
        List<String> listO = r.o(strQ0 + "/Any", strQ0 + "/Nothing", strQ0 + "/Unit", strQ0 + "/Throwable", strQ0 + "/Number", strQ0 + "/Byte", strQ0 + "/Double", strQ0 + "/Float", strQ0 + "/Int", strQ0 + "/Long", strQ0 + "/Short", strQ0 + "/Boolean", strQ0 + "/Char", strQ0 + "/CharSequence", strQ0 + "/String", strQ0 + "/Comparable", strQ0 + "/Enum", strQ0 + "/Array", strQ0 + "/ByteArray", strQ0 + "/DoubleArray", strQ0 + "/FloatArray", strQ0 + "/IntArray", strQ0 + "/LongArray", strQ0 + "/ShortArray", strQ0 + "/BooleanArray", strQ0 + "/CharArray", strQ0 + "/Cloneable", strQ0 + "/Annotation", strQ0 + "/collections/Iterable", strQ0 + "/collections/MutableIterable", strQ0 + "/collections/Collection", strQ0 + "/collections/MutableCollection", strQ0 + "/collections/List", strQ0 + "/collections/MutableList", strQ0 + "/collections/Set", strQ0 + "/collections/MutableSet", strQ0 + "/collections/Map", strQ0 + "/collections/MutableMap", strQ0 + "/collections/Map.Entry", strQ0 + "/collections/MutableMap.MutableEntry", strQ0 + "/collections/Iterator", strQ0 + "/collections/MutableIterator", strQ0 + "/collections/ListIterator", strQ0 + "/collections/MutableListIterator");
        f184f = listO;
        Iterable<IndexedValue> iterableU0 = r.U0(listO);
        LinkedHashMap linkedHashMap = new LinkedHashMap(h9.f.c(n0.e(r.w(iterableU0, 10)), 16));
        for (IndexedValue indexedValue : iterableU0) {
            linkedHashMap.put((String) indexedValue.d(), Integer.valueOf(indexedValue.c()));
        }
        f185g = linkedHashMap;
    }

    public g(String[] strings, Set<Integer> localNameIndices, List<z9.a.e.c> records) {
        m.f(strings, "strings");
        m.f(localNameIndices, "localNameIndices");
        m.f(records, "records");
        this.f186a = strings;
        this.f187b = localNameIndices;
        this.f188c = records;
    }

    @Override // y9.c
    public boolean b(int i10) {
        return this.f187b.contains(Integer.valueOf(i10));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0036  */
    @Override // y9.c
    public String getString(int i10) {
        String string;
        z9.a.e.c cVar = this.f188c.get(i10);
        if (cVar.P()) {
            string = cVar.H();
        } else if (cVar.N()) {
            List<String> list = f184f;
            int size = list.size();
            int iD = cVar.D();
            if (iD < 0 || iD >= size) {
                string = this.f186a[i10];
            } else {
                string = list.get(cVar.D());
            }
        } else {
            string = this.f186a[i10];
        }
        if (cVar.J() >= 2) {
            List<Integer> substringIndexList = cVar.K();
            m.e(substringIndexList, "substringIndexList");
            Integer begin = substringIndexList.get(0);
            Integer end = substringIndexList.get(1);
            m.e(begin, "begin");
            if (begin.intValue() >= 0) {
                int iIntValue = begin.intValue();
                m.e(end, "end");
                if (iIntValue <= end.intValue() && end.intValue() <= string.length()) {
                    m.e(string, "string");
                    string = string.substring(begin.intValue(), end.intValue());
                    m.e(string, "this as java.lang.String…ing(startIndex, endIndex)");
                }
            }
        }
        String string2 = string;
        if (cVar.F() >= 2) {
            List<Integer> replaceCharList = cVar.G();
            m.e(replaceCharList, "replaceCharList");
            Integer num = replaceCharList.get(0);
            Integer num2 = replaceCharList.get(1);
            m.e(string2, "string");
            string2 = n.D(string2, (char) num.intValue(), (char) num2.intValue(), false, 4, null);
        }
        String string3 = string2;
        z9.a.e.c.EnumC0492c enumC0492cC = cVar.C();
        if (enumC0492cC == null) {
            enumC0492cC = z9.a.e.c.EnumC0492c.NONE;
        }
        int i11 = b.f189a[enumC0492cC.ordinal()];
        if (i11 == 2) {
            m.e(string3, "string");
            string3 = n.D(string3, '$', '.', false, 4, null);
        } else if (i11 == 3) {
            if (string3.length() >= 2) {
                m.e(string3, "string");
                string3 = string3.substring(1, string3.length() - 1);
                m.e(string3, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            String string4 = string3;
            m.e(string4, "string");
            string3 = n.D(string4, '$', '.', false, 4, null);
        }
        m.e(string3, "string");
        return string3;
    }

    @Override // y9.c
    public String a(int i10) {
        return getString(i10);
    }
}
