package tb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u000fB!\b\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Ltb/q;", "Lkotlin/collections/d;", "Ltb/g;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "byteStrings", "", "trie", "<init>", "([Ltb/g;[I)V", "", "index", "h", "(I)Ltb/g;", "a", "[Ltb/g;", "i", "()[Ltb/g;", "b", "[I", "k", "()[I", "getSize", "()I", "size", "c", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class q extends kotlin.collections.d<g> implements RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final g[] byteStrings;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int[] trie;

    /* JADX INFO: renamed from: tb.q$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00142\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0013\"\u00020\u000bH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u00020\u0004*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Ltb/q$a;", "", "<init>", "()V", "", "nodeOffset", "Ltb/d;", "node", "", "byteStringOffset", "", "Ltb/g;", "byteStrings", "fromIndex", "toIndex", "indexes", "Lr8/z;", "a", "(JLtb/d;ILjava/util/List;IILjava/util/List;)V", "", "Ltb/q;", "d", "([Ltb/g;)Ltb/q;", "c", "(Ltb/d;)J", "intCount", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        private final void a(long nodeOffset, d node, int byteStringOffset, List<? extends g> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) {
            int i10;
            int i11;
            int i12;
            long j10;
            int i13 = byteStringOffset;
            if (fromIndex >= toIndex) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i14 = fromIndex; i14 < toIndex; i14++) {
                if (byteStrings.get(i14).x() < i13) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            g gVar = byteStrings.get(fromIndex);
            g gVar2 = byteStrings.get(toIndex - 1);
            if (i13 == gVar.x()) {
                int iIntValue = indexes.get(fromIndex).intValue();
                int i15 = fromIndex + 1;
                g gVar3 = byteStrings.get(i15);
                i10 = i15;
                i11 = iIntValue;
                gVar = gVar3;
            } else {
                i10 = fromIndex;
                i11 = -1;
            }
            if (gVar.j(i13) == gVar2.j(i13)) {
                int iMin = Math.min(gVar.x(), gVar2.x());
                int i16 = 0;
                for (int i17 = i13; i17 < iMin && gVar.j(i17) == gVar2.j(i17); i17++) {
                    i16++;
                }
                long jC = nodeOffset + c(node) + ((long) 2) + ((long) i16) + 1;
                node.writeInt(-i16);
                node.writeInt(i11);
                int i18 = i13 + i16;
                while (i13 < i18) {
                    node.writeInt(gVar.j(i13) & 255);
                    i13++;
                }
                if (i10 + 1 == toIndex) {
                    if (i18 != byteStrings.get(i10).x()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    node.writeInt(indexes.get(i10).intValue());
                    return;
                } else {
                    d dVar = new d();
                    node.writeInt(((int) (c(dVar) + jC)) * (-1));
                    a(jC, dVar, i18, byteStrings, i10, toIndex, indexes);
                    node.H(dVar);
                    return;
                }
            }
            int i19 = 1;
            for (int i20 = i10 + 1; i20 < toIndex; i20++) {
                if (byteStrings.get(i20 - 1).j(i13) != byteStrings.get(i20).j(i13)) {
                    i19++;
                }
            }
            long jC2 = nodeOffset + c(node) + ((long) 2) + ((long) (i19 * 2));
            node.writeInt(i19);
            node.writeInt(i11);
            for (int i21 = i10; i21 < toIndex; i21++) {
                byte bJ = byteStrings.get(i21).j(i13);
                if (i21 == i10 || bJ != byteStrings.get(i21 - 1).j(i13)) {
                    node.writeInt(bJ & 255);
                }
            }
            d dVar2 = new d();
            while (i10 < toIndex) {
                byte bJ2 = byteStrings.get(i10).j(i13);
                int i22 = i10 + 1;
                int i23 = i22;
                while (true) {
                    if (i23 >= toIndex) {
                        i12 = toIndex;
                        break;
                    } else {
                        if (bJ2 != byteStrings.get(i23).j(i13)) {
                            i12 = i23;
                            break;
                        }
                        i23++;
                    }
                }
                if (i22 == i12 && i13 + 1 == byteStrings.get(i10).x()) {
                    node.writeInt(indexes.get(i10).intValue());
                    j10 = jC2;
                } else {
                    node.writeInt(((int) (c(dVar2) + jC2)) * (-1));
                    j10 = jC2;
                    a(j10, dVar2, i13 + 1, byteStrings, i10, i12, indexes);
                }
                jC2 = j10;
                i10 = i12;
            }
            node.H(dVar2);
        }

        static /* synthetic */ void b(Companion companion, long j10, d dVar, int i10, List list, int i11, int i12, List list2, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                j10 = 0;
            }
            companion.a(j10, dVar, (i13 & 4) != 0 ? 0 : i10, list, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? list.size() : i12, list2);
        }

        public final q d(g... byteStrings) {
            kotlin.jvm.internal.m.f(byteStrings, "byteStrings");
            kotlin.jvm.internal.g gVar = null;
            int i10 = 0;
            if (byteStrings.length == 0) {
                return new q(new g[0], new int[]{0, -1}, gVar);
            }
            List listN0 = kotlin.collections.j.N0(byteStrings);
            kotlin.collections.r.A(listN0);
            ArrayList arrayList = new ArrayList(byteStrings.length);
            for (g gVar2 : byteStrings) {
                arrayList.add(-1);
            }
            Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
            List listR = kotlin.collections.r.r(Arrays.copyOf(numArr, numArr.length));
            int length = byteStrings.length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                listR.set(kotlin.collections.r.k(listN0, byteStrings[i11], 0, 0, 6, null), Integer.valueOf(i12));
                i11++;
                i12++;
            }
            if (((g) listN0.get(0)).x() <= 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option");
            }
            int i13 = 0;
            while (i13 < listN0.size()) {
                g gVar3 = (g) listN0.get(i13);
                int i14 = i13 + 1;
                int i15 = i14;
                while (i15 < listN0.size()) {
                    g gVar4 = (g) listN0.get(i15);
                    if (!gVar4.y(gVar3)) {
                        break;
                    }
                    if (gVar4.x() == gVar3.x()) {
                        throw new IllegalArgumentException(("duplicate option: " + gVar4).toString());
                    }
                    if (((Number) listR.get(i15)).intValue() > ((Number) listR.get(i13)).intValue()) {
                        listN0.remove(i15);
                        listR.remove(i15);
                    } else {
                        i15++;
                    }
                }
                i13 = i14;
            }
            d dVar = new d();
            b(this, 0L, dVar, 0, listN0, 0, 0, listR, 53, null);
            int[] iArr = new int[(int) c(dVar)];
            while (!dVar.L()) {
                iArr[i10] = dVar.readInt();
                i10++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStrings, byteStrings.length);
            kotlin.jvm.internal.m.e(objArrCopyOf, "copyOf(this, size)");
            return new q((g[]) objArrCopyOf, iArr, gVar);
        }

        private final long c(d dVar) {
            return dVar.getSize() / ((long) 4);
        }
    }

    public /* synthetic */ q(g[] gVarArr, int[] iArr, kotlin.jvm.internal.g gVar) {
        this(gVarArr, iArr);
    }

    private q(g[] gVarArr, int[] iArr) {
        this.byteStrings = gVarArr;
        this.trie = iArr;
    }

    @Override // kotlin.collections.b, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof g) {
            return f((g) obj);
        }
        return false;
    }

    @Override // kotlin.collections.d, kotlin.collections.b
    /* JADX INFO: renamed from: getSize */
    public int get_size() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.d, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public g get(int index) {
        return this.byteStrings[index];
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final g[] getByteStrings() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof g) {
            return m((g) obj);
        }
        return -1;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    @Override // kotlin.collections.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof g) {
            return n((g) obj);
        }
        return -1;
    }

    public /* bridge */ boolean f(g gVar) {
        return super.contains(gVar);
    }

    public /* bridge */ int m(g gVar) {
        return super.indexOf(gVar);
    }

    public /* bridge */ int n(g gVar) {
        return super.lastIndexOf(gVar);
    }
}
