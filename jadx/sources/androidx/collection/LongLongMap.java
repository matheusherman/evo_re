package androidx.collection;

import c9.l;
import c9.p;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0016\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0018\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0081\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001b\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001d\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u0014H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0019J'\u0010\u001e\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u0014H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0019J-\u0010 \u001a\u00020\u00042\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b \u0010!J-\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010!J\r\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010#J-\u0010\"\u001a\u00020\u00152\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\"\u0010$J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b'\u0010&J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\n¢\u0006\u0004\b)\u0010&JA\u00101\u001a\u0002002\b\b\u0002\u0010+\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020*2\b\b\u0002\u0010-\u001a\u00020*2\b\b\u0002\u0010.\u001a\u00020\u00152\b\b\u0002\u0010/\u001a\u00020*H\u0007¢\u0006\u0004\b1\u00102Ja\u00101\u001a\u0002002\b\b\u0002\u0010+\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020*2\b\b\u0002\u0010-\u001a\u00020*2\b\b\u0002\u0010.\u001a\u00020\u00152\b\b\u0002\u0010/\u001a\u00020*2\u001a\b\u0004\u00103\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020*0\u001aH\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u00104J\u000f\u00105\u001a\u00020\u0015H\u0016¢\u0006\u0004\b5\u0010#J\u001a\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u000200H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b;\u0010<R\u001c\u0010>\u001a\u00020=8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b>\u0010?\u0012\u0004\b@\u0010\u0003R\u001c\u0010A\u001a\u00020=8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bA\u0010?\u0012\u0004\bB\u0010\u0003R\u001c\u0010C\u001a\u00020=8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bC\u0010?\u0012\u0004\bD\u0010\u0003R\u001c\u0010E\u001a\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bE\u0010F\u0012\u0004\bG\u0010\u0003R\u001c\u0010H\u001a\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bH\u0010F\u0012\u0004\bI\u0010\u0003R\u0011\u0010K\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bJ\u0010#R\u0011\u0010M\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bL\u0010#\u0082\u0001\u0001N\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006O"}, d2 = {"Landroidx/collection/LongLongMap;", "", "<init>", "()V", "", "any", "()Z", "none", "isEmpty", "isNotEmpty", "", "key", "get", "(J)J", "defaultValue", "getOrDefault", "(JJ)J", "Lkotlin/Function0;", "getOrElse", "(JLc9/a;)J", "Lkotlin/Function1;", "", "Lr8/z;", "block", "forEachIndexed", "(Lc9/l;)V", "Lkotlin/Function2;", "forEach", "(Lc9/p;)V", "forEachKey", "forEachValue", "predicate", "all", "(Lc9/p;)Z", "count", "()I", "(Lc9/p;)I", "contains", "(J)Z", "containsKey", "value", "containsValue", "", "separator", "prefix", "postfix", "limit", "truncated", "", "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)Ljava/lang/String;", "transform", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lc9/p;)Ljava/lang/String;", "hashCode", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "findKeyIndex", "(J)I", "", "metadata", "[J", "getMetadata$annotations", "keys", "getKeys$annotations", "values", "getValues$annotations", "_capacity", "I", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "getCapacity", "capacity", "getSize", "size", "Landroidx/collection/MutableLongLongMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LongLongMap {
    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public long[] values;

    public /* synthetic */ LongLongMap(g gVar) {
        this();
    }

    public static /* synthetic */ String joinToString$default(LongLongMap longLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return longLongMap.joinToString(charSequence, charSequence2, charSequence6, i10, charSequence5);
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final int count() {
        return get_size();
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    private LongLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = LongSetKt.getEmptyLongArray();
    }

    public final boolean all(p<? super Long, ? super Long, Boolean> predicate) {
        m.f(predicate, "predicate");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return true;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        int i13 = (i10 << 3) + i12;
                        if (!predicate.invoke(Long.valueOf(jArr[i13]), Long.valueOf(jArr2[i13])).booleanValue()) {
                            return false;
                        }
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return true;
                }
            }
            if (i10 == length) {
                return true;
            }
            i10++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0060 A[LOOP:0: B:5:0x0016->B:18:0x0060, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0063 A[SYNTHETIC] */
    public final boolean any(p<? super Long, ? super Long, Boolean> predicate) {
        m.f(predicate, "predicate");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i10 = 0;
            while (true) {
                long j10 = jArr3[i10];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    for (int i12 = 0; i12 < i11; i12++) {
                        if ((255 & j10) < 128) {
                            int i13 = (i10 << 3) + i12;
                            if (predicate.invoke(Long.valueOf(jArr[i13]), Long.valueOf(jArr2[i13])).booleanValue()) {
                                return true;
                            }
                        }
                        j10 >>= 8;
                    }
                    if (i11 == 8) {
                        if (i10 != length) {
                            i10++;
                        }
                    }
                } else if (i10 != length) {
                    i10++;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0045 A[LOOP:0: B:5:0x000d->B:18:0x0045, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:21:0x0048 A[SYNTHETIC] */
    public final boolean containsValue(long value) {
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i10 = 0;
            while (true) {
                long j10 = jArr2[i10];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    for (int i12 = 0; i12 < i11; i12++) {
                        if ((255 & j10) < 128 && value == jArr[(i10 << 3) + i12]) {
                            return true;
                        }
                        j10 >>= 8;
                    }
                    if (i11 == 8) {
                        if (i10 != length) {
                            i10++;
                        }
                    }
                } else if (i10 != length) {
                    i10++;
                }
            }
        }
        return false;
    }

    public final int count(p<? super Long, ? super Long, Boolean> predicate) {
        m.f(predicate, "predicate");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return 0;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j10) < 128) {
                        int i14 = (i10 << 3) + i13;
                        if (predicate.invoke(Long.valueOf(jArr[i14]), Long.valueOf(jArr2[i14])).booleanValue()) {
                            i11++;
                        }
                    }
                    j10 >>= 8;
                }
                if (i12 != 8) {
                    return i11;
                }
            }
            if (i10 == length) {
                return i11;
            }
            i10++;
        }
    }

    public boolean equals(Object other) {
        long[] jArr;
        boolean z10;
        long[] jArr2;
        if (other == this) {
            return true;
        }
        if (!(other instanceof LongLongMap)) {
            return false;
        }
        LongLongMap longLongMap = (LongLongMap) other;
        if (longLongMap.get_size() != get_size()) {
            return false;
        }
        long[] jArr3 = this.keys;
        long[] jArr4 = this.values;
        long[] jArr5 = this.metadata;
        int length = jArr5.length - 2;
        if (length < 0) {
            return true;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr5[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                int i12 = 0;
                while (i12 < i11) {
                    if ((255 & j10) < 128) {
                        int i13 = (i10 << 3) + i12;
                        jArr2 = jArr3;
                        if (jArr4[i13] != longLongMap.get(jArr2[i13])) {
                            return false;
                        }
                    } else {
                        jArr2 = jArr3;
                    }
                    j10 >>= 8;
                    i12++;
                    jArr3 = jArr2;
                }
                jArr = jArr3;
                z10 = true;
                if (i11 != 8) {
                    return true;
                }
            } else {
                jArr = jArr3;
                z10 = true;
            }
            if (i10 == length) {
                return z10;
            }
            i10++;
            jArr3 = jArr;
        }
    }

    public final void forEach(p<? super Long, ? super Long, z> block) {
        m.f(block, "block");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        int i13 = (i10 << 3) + i12;
                        block.invoke(Long.valueOf(jArr[i13]), Long.valueOf(jArr2[i13]));
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return;
                }
            }
            if (i10 == length) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final void forEachIndexed(l<? super Integer, z> block) {
        m.f(block, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        block.invoke(Integer.valueOf((i10 << 3) + i12));
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return;
                }
            }
            if (i10 == length) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final void forEachKey(l<? super Long, z> block) {
        m.f(block, "block");
        long[] jArr = this.keys;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr2[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        block.invoke(Long.valueOf(jArr[(i10 << 3) + i12]));
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return;
                }
            }
            if (i10 == length) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final void forEachValue(l<? super Long, z> block) {
        m.f(block, "block");
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr2[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        block.invoke(Long.valueOf(jArr[(i10 << 3) + i12]));
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return;
                }
            }
            if (i10 == length) {
                return;
            } else {
                i10++;
            }
        }
    }

    /* JADX INFO: renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    public final long getOrElse(long key, c9.a<Long> defaultValue) {
        m.f(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(key);
        return iFindKeyIndex < 0 ? defaultValue.invoke().longValue() : this.values[iFindKeyIndex];
    }

    /* JADX INFO: renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return 0;
        }
        int i10 = 0;
        int iA = 0;
        while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        int i13 = (i10 << 3) + i12;
                        iA += a.a(jArr[i13]) ^ a.a(jArr2[i13]);
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return iA;
                }
            }
            if (i10 == length) {
                return iA;
            }
            i10++;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString(CharSequence separator) {
        m.f(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        int i10;
        int i11;
        int i12;
        char c10;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i13 = 0;
            int i14 = 0;
            while (true) {
                long j10 = jArr3[i13];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i15 = 8 - ((~(i13 - length)) >>> 31);
                    int i16 = 0;
                    while (i16 < i15) {
                        if ((255 & j10) < 128) {
                            int i17 = (i13 << 3) + i16;
                            i11 = i13;
                            long j11 = jArr[i17];
                            i12 = i16;
                            c10 = '\b';
                            long j12 = jArr2[i17];
                            sb2.append(j11);
                            sb2.append("=");
                            sb2.append(j12);
                            i14++;
                            if (i14 < this._size) {
                                sb2.append(',');
                                sb2.append(' ');
                            }
                        } else {
                            i11 = i13;
                            i12 = i16;
                            c10 = '\b';
                        }
                        j10 >>= c10;
                        i16 = i12 + 1;
                        i13 = i11;
                    }
                    int i18 = i13;
                    if (i15 != 8) {
                        break;
                    }
                    i10 = i18;
                } else {
                    i10 = i13;
                }
                if (i10 == length) {
                    break;
                }
                i13 = i10 + 1;
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        m.e(string, "s.append('}').toString()");
        return string;
    }

    public final boolean contains(long key) {
        if (findKeyIndex(key) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsKey(long key) {
        if (findKeyIndex(key) >= 0) {
            return true;
        }
        return false;
    }

    public final int findKeyIndex(long key) {
        int iA = a.a(key) * ScatterMapKt.MurmurHashC1;
        int i10 = iA ^ (iA << 16);
        int i11 = i10 & 127;
        int i12 = this._capacity;
        int i13 = (i10 >>> 7) & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i15 = i13 >> 3;
            int i16 = (i13 & 7) << 3;
            long j10 = ((jArr[i15 + 1] << (64 - i16)) & ((-i16) >> 63)) | (jArr[i15] >>> i16);
            long j11 = (((long) i11) * ScatterMapKt.BitmaskLsb) ^ j10;
            for (long j12 = (~j11) & (j11 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j12 != 0; j12 &= j12 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j12) >> 3) + i13) & i12;
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j10 & ((~j10) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i14 += 8;
            i13 = (i13 + i14) & i12;
        }
    }

    public final long get(long key) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        throw new NoSuchElementException("Cannot find value for key " + key);
    }

    public final long getOrDefault(long key, long defaultValue) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        return defaultValue;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ String joinToString$default(LongLongMap longLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, p transform, int i11, Object obj) {
        long[] jArr;
        char c10;
        if (obj == null) {
            CharSequence separator = (i11 & 1) != 0 ? ", " : charSequence;
            CharSequence prefix = (i11 & 2) != 0 ? "" : charSequence2;
            CharSequence postfix = (i11 & 4) == 0 ? charSequence3 : "";
            int i12 = (i11 & 8) != 0 ? -1 : i10;
            CharSequence truncated = (i11 & 16) != 0 ? "..." : charSequence4;
            m.f(separator, "separator");
            m.f(prefix, "prefix");
            m.f(postfix, "postfix");
            m.f(truncated, "truncated");
            m.f(transform, "transform");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(prefix);
            long[] jArr2 = longLongMap.keys;
            long[] jArr3 = longLongMap.values;
            long[] jArr4 = longLongMap.metadata;
            int length = jArr4.length - 2;
            if (length < 0) {
                sb2.append(postfix);
                break;
            }
            int i13 = 0;
            int i14 = 0;
            loop0: while (true) {
                long j10 = jArr4[i13];
                int i15 = i13;
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i16 = 8 - ((~(i15 - length)) >>> 31);
                    int i17 = 0;
                    while (i17 < i16) {
                        if ((j10 & 255) < 128) {
                            int i18 = (i15 << 3) + i17;
                            long j11 = jArr2[i18];
                            long j12 = jArr3[i18];
                            if (i14 == i12) {
                                sb2.append(truncated);
                                break loop0;
                            }
                            if (i14 != 0) {
                                sb2.append(separator);
                            }
                            c10 = '\b';
                            sb2.append((CharSequence) transform.invoke(Long.valueOf(j11), Long.valueOf(j12)));
                            i14++;
                        } else {
                            c10 = '\b';
                        }
                        j10 >>= c10;
                        i17++;
                        jArr4 = jArr4;
                    }
                    jArr = jArr4;
                    if (i16 == 8) {
                    }
                    sb2.append(postfix);
                    break;
                }
                jArr = jArr4;
                if (i15 == length) {
                    sb2.append(postfix);
                    break;
                }
                i13 = i15 + 1;
                jArr4 = jArr;
            }
            String string = sb2.toString();
            m.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i10) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i10, null, 16, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        char c10;
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        m.f(truncated, "truncated");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr4 = this.keys;
        long[] jArr5 = this.values;
        long[] jArr6 = this.metadata;
        int length = jArr6.length - 2;
        if (length < 0) {
            sb2.append(postfix);
            break;
        }
        int i10 = 0;
        int i11 = 0;
        loop0: while (true) {
            long j10 = jArr6[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                int i13 = 0;
                while (i13 < i12) {
                    if ((j10 & 255) < 128) {
                        int i14 = (i10 << 3) + i13;
                        jArr3 = jArr5;
                        long j11 = jArr4[i14];
                        long j12 = jArr3[i14];
                        c10 = '\b';
                        if (i11 == limit) {
                            sb2.append(truncated);
                            break loop0;
                        }
                        if (i11 != 0) {
                            sb2.append(separator);
                        }
                        sb2.append(j11);
                        sb2.append('=');
                        sb2.append(j12);
                        i11++;
                    } else {
                        jArr3 = jArr5;
                        c10 = '\b';
                    }
                    j10 >>= c10;
                    i13++;
                    jArr5 = jArr3;
                    jArr6 = jArr6;
                }
                jArr = jArr5;
                jArr2 = jArr6;
                if (i12 == 8) {
                }
                sb2.append(postfix);
                break;
            }
            jArr = jArr5;
            jArr2 = jArr6;
            if (i10 == length) {
                sb2.append(postfix);
                break;
            }
            i10++;
            jArr5 = jArr;
            jArr6 = jArr2;
        }
        String string = sb2.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:20:0x009b A[DONT_INVERT, PHI: r12
      0x009b: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x004c, B:19:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:21:0x009d A[LOOP:0: B:5:0x003a->B:21:0x009d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:27:0x00a4 A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, p<? super Long, ? super Long, ? extends CharSequence> transform) {
        CharSequence separator2 = separator;
        m.f(separator2, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        m.f(truncated, "truncated");
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            sb2.append(postfix);
            break;
        }
        int i10 = 0;
        int i11 = 0;
        loop0: while (true) {
            long j10 = jArr3[i10];
            int i12 = i10;
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) == -9187201950435737472L) {
                if (i12 == length) {
                    sb2.append(postfix);
                    break;
                }
                i10 = i12 + 1;
                separator2 = separator;
            } else {
                int i13 = 8 - ((~(i12 - length)) >>> 31);
                int i14 = 0;
                while (i14 < i13) {
                    if ((j10 & 255) < 128) {
                        int i15 = (i12 << 3) + i14;
                        long j11 = jArr[i15];
                        long j12 = jArr2[i15];
                        if (i11 == limit) {
                            sb2.append(truncated);
                            break loop0;
                        }
                        if (i11 != 0) {
                            sb2.append(separator2);
                        }
                        sb2.append(transform.invoke(Long.valueOf(j11), Long.valueOf(j12)));
                        i11++;
                    }
                    j10 >>= 8;
                    i14++;
                    separator2 = separator;
                }
                if (i13 == 8) {
                    if (i12 == length) {
                        i10 = i12 + 1;
                        separator2 = separator;
                    }
                }
                sb2.append(postfix);
                break;
            }
        }
        String string = sb2.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence postfix, int i10, p<? super Long, ? super Long, ? extends CharSequence> transform) {
        char c10;
        CharSequence separator = charSequence;
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            sb2.append(postfix);
            break;
        }
        int i11 = 0;
        int i12 = 0;
        loop0: while (true) {
            long j10 = jArr3[i11];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i13 = 8 - ((~(i11 - length)) >>> 31);
                int i14 = 0;
                while (i14 < i13) {
                    if ((j10 & 255) < 128) {
                        int i15 = (i11 << 3) + i14;
                        long j11 = jArr[i15];
                        long j12 = jArr2[i15];
                        c10 = '\b';
                        if (i12 == i10) {
                            sb2.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i12 != 0) {
                            sb2.append(separator);
                        }
                        sb2.append(transform.invoke(Long.valueOf(j11), Long.valueOf(j12)));
                        i12++;
                    } else {
                        c10 = '\b';
                    }
                    j10 >>= c10;
                    i14++;
                    separator = charSequence;
                }
                if (i13 == 8) {
                }
                sb2.append(postfix);
                break;
            }
            if (i11 == length) {
                sb2.append(postfix);
                break;
            }
            i11++;
            separator = charSequence;
        }
        String string = sb2.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0097 A[DONT_INVERT, PHI: r11
      0x0097: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x0044, B:20:0x0095] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0099 A[LOOP:0: B:5:0x0033->B:22:0x0099, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x009e A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, p<? super Long, ? super Long, ? extends CharSequence> transform) {
        char c10;
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            sb2.append(postfix);
            break;
        }
        int i10 = 0;
        int i11 = 0;
        loop0: while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((j10 & 255) < 128) {
                        int i14 = (i10 << 3) + i13;
                        long j11 = jArr[i14];
                        long j12 = jArr2[i14];
                        c10 = '\b';
                        if (i11 == -1) {
                            sb2.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i11 != 0) {
                            sb2.append(separator);
                        }
                        sb2.append(transform.invoke(Long.valueOf(j11), Long.valueOf(j12)));
                        i11++;
                    } else {
                        c10 = '\b';
                    }
                    j10 >>= c10;
                }
                if (i12 == 8) {
                    if (i10 == length) {
                        i10++;
                    }
                }
                sb2.append(postfix);
                break;
            }
            if (i10 == length) {
                sb2.append(postfix);
                break;
            }
            i10++;
        }
        String string = sb2.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008b A[DONT_INVERT, PHI: r10
      0x008b: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x003a, B:20:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x008d A[LOOP:0: B:5:0x002c->B:22:0x008d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0090 A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, CharSequence prefix, p<? super Long, ? super Long, ? extends CharSequence> transform) {
        char c10;
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            sb2.append((CharSequence) "");
            break;
        }
        int i10 = 0;
        int i11 = 0;
        loop0: while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((j10 & 255) < 128) {
                        int i14 = (i10 << 3) + i13;
                        long j11 = jArr[i14];
                        long j12 = jArr2[i14];
                        if (i11 == -1) {
                            sb2.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i11 != 0) {
                            sb2.append(separator);
                        }
                        c10 = '\b';
                        sb2.append(transform.invoke(Long.valueOf(j11), Long.valueOf(j12)));
                        i11++;
                    } else {
                        c10 = '\b';
                    }
                    j10 >>= c10;
                }
                if (i12 == 8) {
                    if (i10 == length) {
                        i10++;
                    }
                }
                sb2.append((CharSequence) "");
                break;
            }
            if (i10 == length) {
                sb2.append((CharSequence) "");
                break;
            }
            i10++;
        }
        String string = sb2.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008b A[DONT_INVERT, PHI: r11
      0x008b: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x0038, B:20:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x008d A[LOOP:0: B:5:0x0027->B:22:0x008d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0092 A[SYNTHETIC] */
    public final String joinToString(CharSequence separator, p<? super Long, ? super Long, ? extends CharSequence> transform) {
        char c10;
        m.f(separator, "separator");
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            sb2.append((CharSequence) "");
            break;
        }
        int i10 = 0;
        int i11 = 0;
        loop0: while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((j10 & 255) < 128) {
                        int i14 = (i10 << 3) + i13;
                        long j11 = jArr[i14];
                        long j12 = jArr2[i14];
                        c10 = '\b';
                        if (i11 == -1) {
                            sb2.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i11 != 0) {
                            sb2.append(separator);
                        }
                        sb2.append(transform.invoke(Long.valueOf(j11), Long.valueOf(j12)));
                        i11++;
                    } else {
                        c10 = '\b';
                    }
                    j10 >>= c10;
                }
                if (i12 == 8) {
                    if (i10 == length) {
                        i10++;
                    }
                }
                sb2.append((CharSequence) "");
                break;
            }
            if (i10 == length) {
                sb2.append((CharSequence) "");
                break;
            }
            i10++;
        }
        String string = sb2.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0081 A[DONT_INVERT, PHI: r10
      0x0081: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x002e, B:20:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0083 A[LOOP:0: B:5:0x0020->B:22:0x0083, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0086 A[SYNTHETIC] */
    public final String joinToString(p<? super Long, ? super Long, ? extends CharSequence> transform) {
        char c10;
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            sb2.append((CharSequence) "");
            break;
        }
        int i10 = 0;
        int i11 = 0;
        loop0: while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((j10 & 255) < 128) {
                        int i14 = (i10 << 3) + i13;
                        long j11 = jArr[i14];
                        long j12 = jArr2[i14];
                        if (i11 == -1) {
                            sb2.append((CharSequence) "...");
                            break loop0;
                        }
                        if (i11 != 0) {
                            sb2.append((CharSequence) ", ");
                        }
                        Long lValueOf = Long.valueOf(j11);
                        c10 = '\b';
                        sb2.append(transform.invoke(lValueOf, Long.valueOf(j12)));
                        i11++;
                    } else {
                        c10 = '\b';
                    }
                    j10 >>= c10;
                }
                if (i12 == 8) {
                    if (i10 == length) {
                        i10++;
                    }
                }
                sb2.append((CharSequence) "");
                break;
            }
            if (i10 == length) {
                sb2.append((CharSequence) "");
                break;
            }
            i10++;
        }
        String string = sb2.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
