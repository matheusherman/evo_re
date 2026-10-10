package nb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.r;
import tb.z;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\n\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000e\u0010\b¨\u0006\u0015"}, d2 = {"Lnb/d;", "", "<init>", "()V", "", "Ltb/g;", "", "d", "()Ljava/util/Map;", "name", "a", "(Ltb/g;)Ltb/g;", "", "Lnb/c;", "b", "[Lnb/c;", "c", "()[Lnb/c;", "STATIC_HEADER_TABLE", "Ljava/util/Map;", "NAME_TO_FIRST_INDEX", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f16135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final c[] STATIC_HEADER_TABLE;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Map<tb.g, Integer> NAME_TO_FIRST_INDEX;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0%¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\t¢\u0006\u0004\b(\u0010\u000bJ\u001d\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0019¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010/R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010/R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u001f008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u00101R\u0014\u0010\u0003\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00104R\u001e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u00106R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010/R\u0016\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010/R\u0016\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010/¨\u0006;"}, d2 = {"Lnb/d$a;", "", "Ltb/z;", "source", "", "headerTableSizeSetting", "maxDynamicTableByteCount", "<init>", "(Ltb/z;II)V", "Lr8/z;", "a", "()V", "b", "bytesToRecover", "d", "(I)I", "index", "l", "(I)V", "c", "p", "q", "nameIndex", "n", "o", "Ltb/g;", "f", "(I)Ltb/g;", "", "h", "(I)Z", "Lnb/c;", "entry", "g", "(ILnb/c;)V", "i", "()I", "", "e", "()Ljava/util/List;", "k", "firstByte", "prefixMask", "m", "(II)I", "j", "()Ltb/g;", "I", "", "Ljava/util/List;", "headerList", "Ltb/f;", "Ltb/f;", "", "[Lnb/c;", "dynamicTable", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int headerTableSizeSetting;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int maxDynamicTableByteCount;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final List<c> headerList;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final tb.f source;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        public c[] dynamicTable;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int nextHeaderIndex;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        public int headerCount;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        public int dynamicTableByteCount;

        public a(z source, int i10, int i11) {
            kotlin.jvm.internal.m.f(source, "source");
            this.headerTableSizeSetting = i10;
            this.maxDynamicTableByteCount = i11;
            this.headerList = new ArrayList();
            this.source = tb.n.b(source);
            c[] cVarArr = new c[8];
            this.dynamicTable = cVarArr;
            this.nextHeaderIndex = cVarArr.length - 1;
        }

        private final int d(int bytesToRecover) {
            int i10;
            int i11 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i10 = this.nextHeaderIndex;
                    if (length < i10 || bytesToRecover <= 0) {
                        break;
                    }
                    c cVar = this.dynamicTable[length];
                    kotlin.jvm.internal.m.c(cVar);
                    int i12 = cVar.hpackSize;
                    bytesToRecover -= i12;
                    this.dynamicTableByteCount -= i12;
                    this.headerCount--;
                    i11++;
                }
                c[] cVarArr = this.dynamicTable;
                System.arraycopy(cVarArr, i10 + 1, cVarArr, i10 + 1 + i11, this.headerCount);
                this.nextHeaderIndex += i11;
            }
            return i11;
        }

        public final int m(int firstByte, int prefixMask) {
            int i10 = firstByte & prefixMask;
            if (i10 < prefixMask) {
                return i10;
            }
            int i11 = 0;
            while (true) {
                int i12 = i();
                if ((i12 & 128) == 0) {
                    return prefixMask + (i12 << i11);
                }
                prefixMask += (i12 & 127) << i11;
                i11 += 7;
            }
        }

        private final void a() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    d(i11 - i10);
                }
            }
        }

        private final void b() {
            kotlin.collections.j.t(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int c(int index) {
            return this.nextHeaderIndex + 1 + index;
        }

        private final void g(int index, c entry) {
            this.headerList.add(entry);
            int i10 = entry.hpackSize;
            if (index != -1) {
                c cVar = this.dynamicTable[c(index)];
                kotlin.jvm.internal.m.c(cVar);
                i10 -= cVar.hpackSize;
            }
            int i11 = this.maxDynamicTableByteCount;
            if (i10 > i11) {
                b();
                return;
            }
            int iD = d((this.dynamicTableByteCount + i10) - i11);
            if (index == -1) {
                int i12 = this.headerCount + 1;
                c[] cVarArr = this.dynamicTable;
                if (i12 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = cVarArr2;
                }
                int i13 = this.nextHeaderIndex;
                this.nextHeaderIndex = i13 - 1;
                this.dynamicTable[i13] = entry;
                this.headerCount++;
            } else {
                this.dynamicTable[index + c(index) + iD] = entry;
            }
            this.dynamicTableByteCount += i10;
        }

        private final boolean h(int index) {
            return index >= 0 && index <= d.f16135a.c().length - 1;
        }

        private final int i() {
            return hb.d.d(this.source.readByte(), 255);
        }

        private final void o() {
            g(-1, new c(d.f16135a.a(j()), j()));
        }

        private final void q() throws IOException {
            this.headerList.add(new c(d.f16135a.a(j()), j()));
        }

        public final List<c> e() {
            List<c> listO0 = r.O0(this.headerList);
            this.headerList.clear();
            return listO0;
        }

        public final void k() throws IOException {
            while (!this.source.L()) {
                int iD = hb.d.d(this.source.readByte(), 255);
                if (iD == 128) {
                    throw new IOException("index == 0");
                }
                if ((iD & 128) == 128) {
                    l(m(iD, 127) - 1);
                } else if (iD == 64) {
                    o();
                } else if ((iD & 64) == 64) {
                    n(m(iD, 63) - 1);
                } else if ((iD & 32) == 32) {
                    int iM = m(iD, 31);
                    this.maxDynamicTableByteCount = iM;
                    if (iM < 0 || iM > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    a();
                } else if (iD == 16 || iD == 0) {
                    q();
                } else {
                    p(m(iD, 15) - 1);
                }
            }
        }

        private final tb.g f(int index) throws IOException {
            if (h(index)) {
                return d.f16135a.c()[index].name;
            }
            int iC = c(index - d.f16135a.c().length);
            if (iC >= 0) {
                c[] cVarArr = this.dynamicTable;
                if (iC < cVarArr.length) {
                    c cVar = cVarArr[iC];
                    kotlin.jvm.internal.m.c(cVar);
                    return cVar.name;
                }
            }
            throw new IOException("Header index too large " + (index + 1));
        }

        private final void l(int index) throws IOException {
            if (h(index)) {
                this.headerList.add(d.f16135a.c()[index]);
                return;
            }
            int iC = c(index - d.f16135a.c().length);
            if (iC >= 0) {
                c[] cVarArr = this.dynamicTable;
                if (iC < cVarArr.length) {
                    List<c> list = this.headerList;
                    c cVar = cVarArr[iC];
                    kotlin.jvm.internal.m.c(cVar);
                    list.add(cVar);
                    return;
                }
            }
            throw new IOException("Header index too large " + (index + 1));
        }

        private final void n(int nameIndex) {
            g(-1, new c(f(nameIndex), j()));
        }

        private final void p(int index) throws IOException {
            this.headerList.add(new c(f(index), j()));
        }

        public final tb.g j() {
            boolean z10;
            int i10 = i();
            if ((i10 & 128) == 128) {
                z10 = true;
            } else {
                z10 = false;
            }
            long jM = m(i10, 127);
            if (z10) {
                tb.d dVar = new tb.d();
                k.f16291a.b(this.source, jM, dVar);
                return dVar.p();
            }
            return this.source.E(jM);
        }

        public /* synthetic */ a(z zVar, int i10, int i11, int i12, kotlin.jvm.internal.g gVar) {
            this(zVar, i10, (i12 & 4) != 0 ? i10 : i11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u001b\u0010\u0017\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010&R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010$R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010%R\u0016\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010$R\u001e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100*8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010+R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010$R\u0016\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010$R\u0016\u00101\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b0\u0010$¨\u00062"}, d2 = {"Lnb/d$b;", "", "", "headerTableSizeSetting", "", "useCompression", "Ltb/d;", "out", "<init>", "(IZLtb/d;)V", "Lr8/z;", "b", "()V", "bytesToRecover", "c", "(I)I", "Lnb/c;", "entry", "d", "(Lnb/c;)V", "a", "", "headerBlock", "g", "(Ljava/util/List;)V", "value", "prefixMask", "bits", "h", "(III)V", "Ltb/g;", "data", "f", "(Ltb/g;)V", "e", "(I)V", "I", "Z", "Ltb/d;", "smallestHeaderTableSizeSetting", "emitDynamicTableSizeUpdate", "maxDynamicTableByteCount", "", "[Lnb/c;", "dynamicTable", "nextHeaderIndex", "i", "headerCount", "j", "dynamicTableByteCount", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int headerTableSizeSetting;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean useCompression;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final tb.d out;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int smallestHeaderTableSizeSetting;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean emitDynamicTableSizeUpdate;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        public int maxDynamicTableByteCount;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        public c[] dynamicTable;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int nextHeaderIndex;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        public int headerCount;

        /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
        public int dynamicTableByteCount;

        public b(int i10, boolean z10, tb.d out) {
            kotlin.jvm.internal.m.f(out, "out");
            this.headerTableSizeSetting = i10;
            this.useCompression = z10;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i10;
            c[] cVarArr = new c[8];
            this.dynamicTable = cVarArr;
            this.nextHeaderIndex = cVarArr.length - 1;
        }

        private final int c(int bytesToRecover) {
            int i10;
            int i11 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i10 = this.nextHeaderIndex;
                    if (length < i10 || bytesToRecover <= 0) {
                        break;
                    }
                    c cVar = this.dynamicTable[length];
                    kotlin.jvm.internal.m.c(cVar);
                    bytesToRecover -= cVar.hpackSize;
                    int i12 = this.dynamicTableByteCount;
                    c cVar2 = this.dynamicTable[length];
                    kotlin.jvm.internal.m.c(cVar2);
                    this.dynamicTableByteCount = i12 - cVar2.hpackSize;
                    this.headerCount--;
                    i11++;
                }
                c[] cVarArr = this.dynamicTable;
                System.arraycopy(cVarArr, i10 + 1, cVarArr, i10 + 1 + i11, this.headerCount);
                c[] cVarArr2 = this.dynamicTable;
                int i13 = this.nextHeaderIndex;
                Arrays.fill(cVarArr2, i13 + 1, i13 + 1 + i11, (Object) null);
                this.nextHeaderIndex += i11;
            }
            return i11;
        }

        private final void a() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    c(i11 - i10);
                }
            }
        }

        private final void b() {
            kotlin.collections.j.t(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final void d(c entry) {
            int i10 = entry.hpackSize;
            int i11 = this.maxDynamicTableByteCount;
            if (i10 > i11) {
                b();
                return;
            }
            c((this.dynamicTableByteCount + i10) - i11);
            int i12 = this.headerCount + 1;
            c[] cVarArr = this.dynamicTable;
            if (i12 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = cVarArr2;
            }
            int i13 = this.nextHeaderIndex;
            this.nextHeaderIndex = i13 - 1;
            this.dynamicTable[i13] = entry;
            this.headerCount++;
            this.dynamicTableByteCount += i10;
        }

        public final void e(int headerTableSizeSetting) {
            this.headerTableSizeSetting = headerTableSizeSetting;
            int iMin = Math.min(headerTableSizeSetting, 16384);
            int i10 = this.maxDynamicTableByteCount;
            if (i10 == iMin) {
                return;
            }
            if (iMin < i10) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            a();
        }

        public final void f(tb.g data) {
            kotlin.jvm.internal.m.f(data, "data");
            if (this.useCompression) {
                k kVar = k.f16291a;
                if (kVar.d(data) < data.x()) {
                    tb.d dVar = new tb.d();
                    kVar.c(data, dVar);
                    tb.g gVarP = dVar.p();
                    h(gVarP.x(), 127, 128);
                    this.out.Q(gVarP);
                    return;
                }
            }
            h(data.x(), 127, 0);
            this.out.Q(data);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x007e  */
        /* JADX WARN: Code duplicated, block: B:28:0x0087  */
        /* JADX WARN: Code duplicated, block: B:30:0x0096  */
        /* JADX WARN: Code duplicated, block: B:33:0x00b1 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:34:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:37:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:38:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:40:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:41:0x00df  */
        /* JADX WARN: Code duplicated, block: B:46:0x00f8  */
        /* JADX WARN: Code duplicated, block: B:55:0x00a5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x00bf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x00bf A[SYNTHETIC] */
        public final void g(List<c> headerBlock) {
            int length;
            int length2;
            int i10;
            int length3;
            c cVar;
            c cVar2;
            kotlin.jvm.internal.m.f(headerBlock, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i11 = this.smallestHeaderTableSizeSetting;
                if (i11 < this.maxDynamicTableByteCount) {
                    h(i11, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                h(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = headerBlock.size();
            for (int i12 = 0; i12 < size; i12++) {
                c cVar3 = headerBlock.get(i12);
                tb.g gVarZ = cVar3.name.z();
                tb.g gVar = cVar3.value;
                d dVar = d.f16135a;
                Integer num = dVar.b().get(gVarZ);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (2 <= length2 && length2 < 8) {
                        if (kotlin.jvm.internal.m.a(dVar.c()[iIntValue].value, gVar)) {
                            length = length2;
                        } else if (kotlin.jvm.internal.m.a(dVar.c()[length2].value, gVar)) {
                            length = length2;
                            length2 = iIntValue + 2;
                        }
                        if (length2 == -1) {
                            length3 = this.dynamicTable.length;
                            for (i10 = this.nextHeaderIndex + 1; i10 < length3; i10++) {
                                cVar = this.dynamicTable[i10];
                                kotlin.jvm.internal.m.c(cVar);
                                if (kotlin.jvm.internal.m.a(cVar.name, gVarZ)) {
                                    cVar2 = this.dynamicTable[i10];
                                    kotlin.jvm.internal.m.c(cVar2);
                                    if (kotlin.jvm.internal.m.a(cVar2.value, gVar)) {
                                        length2 = d.f16135a.c().length + (i10 - this.nextHeaderIndex);
                                        break;
                                    } else if (length == -1) {
                                        length = (i10 - this.nextHeaderIndex) + d.f16135a.c().length;
                                    }
                                }
                            }
                        }
                        if (length2 != -1) {
                            h(length2, 127, 128);
                        } else if (length == -1) {
                            this.out.writeByte(64);
                            f(gVarZ);
                            f(gVar);
                            d(cVar3);
                        } else if (gVarZ.y(c.f16126e) || kotlin.jvm.internal.m.a(c.f16131j, gVarZ)) {
                            h(length, 63, 64);
                            f(gVar);
                            d(cVar3);
                        } else {
                            h(length, 15, 0);
                            f(gVar);
                        }
                    }
                    length = length2;
                } else {
                    length = -1;
                }
                length2 = -1;
                if (length2 == -1) {
                    length3 = this.dynamicTable.length;
                    while (i10 < length3) {
                        cVar = this.dynamicTable[i10];
                        kotlin.jvm.internal.m.c(cVar);
                        if (kotlin.jvm.internal.m.a(cVar.name, gVarZ)) {
                            cVar2 = this.dynamicTable[i10];
                            kotlin.jvm.internal.m.c(cVar2);
                            if (kotlin.jvm.internal.m.a(cVar2.value, gVar)) {
                                length2 = d.f16135a.c().length + (i10 - this.nextHeaderIndex);
                                break;
                            } else if (length == -1) {
                                length = (i10 - this.nextHeaderIndex) + d.f16135a.c().length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    h(length2, 127, 128);
                } else if (length == -1) {
                    this.out.writeByte(64);
                    f(gVarZ);
                    f(gVar);
                    d(cVar3);
                } else if (gVarZ.y(c.f16126e)) {
                    h(length, 63, 64);
                    f(gVar);
                    d(cVar3);
                } else {
                    h(length, 63, 64);
                    f(gVar);
                    d(cVar3);
                }
            }
        }

        public final void h(int value, int prefixMask, int bits) {
            if (value < prefixMask) {
                this.out.writeByte(value | bits);
                return;
            }
            this.out.writeByte(bits | prefixMask);
            int i10 = value - prefixMask;
            while (i10 >= 128) {
                this.out.writeByte(128 | (i10 & 127));
                i10 >>>= 7;
            }
            this.out.writeByte(i10);
        }

        public /* synthetic */ b(int i10, boolean z10, tb.d dVar, int i11, kotlin.jvm.internal.g gVar) {
            this((i11 & 1) != 0 ? 4096 : i10, (i11 & 2) != 0 ? true : z10, dVar);
        }
    }

    static {
        d dVar = new d();
        f16135a = dVar;
        c cVar = new c(c.f16131j, "");
        tb.g gVar = c.f16128g;
        c cVar2 = new c(gVar, IMediaPlayer.DRM_REQ_GET);
        c cVar3 = new c(gVar, IMediaPlayer.DRM_REQ_POST);
        tb.g gVar2 = c.f16129h;
        c cVar4 = new c(gVar2, "/");
        c cVar5 = new c(gVar2, "/index.html");
        tb.g gVar3 = c.f16130i;
        c cVar6 = new c(gVar3, "http");
        c cVar7 = new c(gVar3, "https");
        tb.g gVar4 = c.f16127f;
        STATIC_HEADER_TABLE = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, new c(gVar4, "200"), new c(gVar4, "204"), new c(gVar4, "206"), new c(gVar4, "304"), new c(gVar4, "400"), new c(gVar4, "404"), new c(gVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c(TypedValues.TransitionType.S_FROM, ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = dVar.d();
    }

    private final Map<tb.g, Integer> d() {
        c[] cVarArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(cVarArr.length);
        int length = cVarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            c[] cVarArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(cVarArr2[i10].name)) {
                linkedHashMap.put(cVarArr2[i10].name, Integer.valueOf(i10));
            }
        }
        Map<tb.g, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        kotlin.jvm.internal.m.e(mapUnmodifiableMap, "unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    public final tb.g a(tb.g name) throws IOException {
        kotlin.jvm.internal.m.f(name, "name");
        int iX = name.x();
        for (int i10 = 0; i10 < iX; i10++) {
            byte bJ = name.j(i10);
            if (65 <= bJ && bJ < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.A());
            }
        }
        return name;
    }

    public final Map<tb.g, Integer> b() {
        return NAME_TO_FIRST_INDEX;
    }

    public final c[] c() {
        return STATIC_HEADER_TABLE;
    }

    private d() {
    }
}
