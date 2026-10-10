package androidx.collection;

import androidx.annotation.IntRange;
import c9.l;
import c9.p;
import c9.q;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import h9.e;
import h9.f;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0016\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ2\u0010\t\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\t\u0010\rJ2\u0010\u000e\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u000e\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u0015\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0015\u0010\u0017J\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J2\u0010\u0018\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0018\u0010\u001aJF\u0010\u001f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\u001f\u0010 JL\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\u001e\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u00000!H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b\"\u0010#JF\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b$\u0010 JL\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00028\u00002\u001e\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000!H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0004\b%\u0010#J2\u0010(\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020&0\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b(\u0010)J8\u0010*\u001a\u00020&2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020&0\u001dH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b*\u0010+J2\u0010,\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020&0\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b,\u0010)J8\u0010-\u001a\u00020&2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020&0\u001dH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b-\u0010+J\u001a\u0010/\u001a\u00020\u000b2\b\b\u0001\u0010.\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u000b2\b\b\u0001\u0010.\u001a\u00020\u0002¢\u0006\u0004\b1\u00100J1\u00103\u001a\u00020\u000b2\b\b\u0001\u0010.\u001a\u00020\u00022\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b5\u00106J2\u00107\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b7\u0010\u0017J2\u00108\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b8\u0010\u0017J\r\u00109\u001a\u00020\u0006¢\u0006\u0004\b9\u0010\bJ\r\u0010:\u001a\u00020\u0006¢\u0006\u0004\b:\u0010\bJ\r\u0010;\u001a\u00020\u000b¢\u0006\u0004\b;\u0010\u0019J2\u0010;\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b;\u0010\u001aJ\u0015\u0010<\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b<\u00106JA\u0010D\u001a\u00020C2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=2\b\b\u0002\u0010A\u001a\u00020\u00022\b\b\u0002\u0010B\u001a\u00020=H\u0007¢\u0006\u0004\bD\u0010EJ[\u0010D\u001a\u00020C2\b\b\u0002\u0010>\u001a\u00020=2\b\b\u0002\u0010?\u001a\u00020=2\b\b\u0002\u0010@\u001a\u00020=2\b\b\u0002\u0010A\u001a\u00020\u00022\b\b\u0002\u0010B\u001a\u00020=2\u0014\b\u0004\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020=0\nH\u0087\bø\u0001\u0000¢\u0006\u0004\bD\u0010GJ\u000f\u0010H\u001a\u00020\u0002H\u0016¢\u0006\u0004\bH\u0010\u0016J\u001a\u0010J\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020CH\u0016¢\u0006\u0004\bL\u0010MR\u001c\u0010O\u001a\u00020N8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bO\u0010P\u0012\u0004\bQ\u0010RR\u001c\u0010S\u001a\u00020\u00028\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bS\u0010T\u0012\u0004\bU\u0010RR\u0011\u0010W\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\bV\u0010\u0016R\u0012\u0010Y\u001a\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\bX\u0010\u0016R\u0012\u0010]\u001a\u00020Z8Æ\u0002¢\u0006\u0006\u001a\u0004\b[\u0010\\\u0082\u0001\u0001^\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006_"}, d2 = {"Landroidx/collection/LongList;", "", "", "initialCapacity", "<init>", "(I)V", "", "none", "()Z", "any", "Lkotlin/Function1;", "", "predicate", "(Lc9/l;)Z", "reversedAny", "element", "contains", "(J)Z", "elements", "containsAll", "(Landroidx/collection/LongList;)Z", "count", "()I", "(Lc9/l;)I", "first", "()J", "(Lc9/l;)J", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Lc9/p;)Ljava/lang/Object;", "Lkotlin/Function3;", "foldIndexed", "(Ljava/lang/Object;Lc9/q;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "Lr8/z;", "block", "forEach", "(Lc9/l;)V", "forEachIndexed", "(Lc9/p;)V", "forEachReversed", "forEachReversedIndexed", "index", "get", "(I)J", "elementAt", "defaultValue", "elementAtOrElse", "(ILc9/l;)J", "indexOf", "(J)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "", "separator", "prefix", "postfix", "limit", "truncated", "", "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)Ljava/lang/String;", "transform", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lc9/l;)Ljava/lang/String;", "hashCode", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "", "content", "[J", "getContent$annotations", "()V", "_size", "I", "get_size$annotations", "getSize", "size", "getLastIndex", "lastIndex", "Lh9/e;", "getIndices", "()Lh9/e;", "indices", "Landroidx/collection/MutableLongList;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LongList {
    public int _size;
    public long[] content;

    public /* synthetic */ LongList(int i10, g gVar) {
        this(i10);
    }

    public static /* synthetic */ String joinToString$default(LongList longList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, int i11, Object obj) {
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
        return longList.joinToString(charSequence, charSequence2, charSequence6, i10, charSequence5);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    /* JADX INFO: renamed from: count, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final long first() {
        if (isEmpty()) {
            throw new NoSuchElementException("LongList is empty.");
        }
        return this.content[0];
    }

    public final e getIndices() {
        return f.m(0, this._size);
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final long last() {
        if (isEmpty()) {
            throw new NoSuchElementException("LongList is empty.");
        }
        return this.content[this._size - 1];
    }

    private LongList(int i10) {
        this.content = i10 == 0 ? LongSetKt.getEmptyLongArray() : new long[i10];
    }

    public final boolean any(l<? super Long, Boolean> predicate) {
        m.f(predicate, "predicate");
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (predicate.invoke(Long.valueOf(jArr[i11])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean contains(long element) {
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (jArr[i11] == element) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(LongList elements) {
        m.f(elements, "elements");
        e eVarM = f.m(0, elements._size);
        int first = eVarM.getFirst();
        int last = eVarM.getLast();
        if (first > last) {
            return true;
        }
        while (contains(elements.get(first))) {
            if (first == last) {
                return true;
            }
            first++;
        }
        return false;
    }

    public final int count(l<? super Long, Boolean> predicate) {
        m.f(predicate, "predicate");
        long[] jArr = this.content;
        int i10 = this._size;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            if (predicate.invoke(Long.valueOf(jArr[i12])).booleanValue()) {
                i11++;
            }
        }
        return i11;
    }

    public final long elementAt(@IntRange(from = 0) int index) {
        if (index >= 0 && index < this._size) {
            return this.content[index];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Index ");
        sb2.append(index);
        sb2.append(" must be in 0..");
        sb2.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    public final long elementAtOrElse(@IntRange(from = 0) int index, l<? super Integer, Long> defaultValue) {
        m.f(defaultValue, "defaultValue");
        return (index < 0 || index >= this._size) ? defaultValue.invoke(Integer.valueOf(index)).longValue() : this.content[index];
    }

    public boolean equals(Object other) {
        if (other instanceof LongList) {
            LongList longList = (LongList) other;
            int i10 = longList._size;
            int i11 = this._size;
            if (i10 == i11) {
                long[] jArr = this.content;
                long[] jArr2 = longList.content;
                e eVarM = f.m(0, i11);
                int first = eVarM.getFirst();
                int last = eVarM.getLast();
                if (first > last) {
                    return true;
                }
                while (jArr[first] == jArr2[first]) {
                    if (first == last) {
                        return true;
                    }
                    first++;
                }
                return false;
            }
        }
        return false;
    }

    public final <R> R fold(R initial, p<? super R, ? super Long, ? extends R> operation) {
        m.f(operation, "operation");
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            initial = operation.invoke(initial, Long.valueOf(jArr[i11]));
        }
        return initial;
    }

    public final <R> R foldIndexed(R initial, q<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        m.f(operation, "operation");
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            R r10 = initial;
            initial = operation.invoke(Integer.valueOf(i11), r10, Long.valueOf(jArr[i11]));
        }
        return initial;
    }

    public final <R> R foldRight(R initial, p<? super Long, ? super R, ? extends R> operation) {
        m.f(operation, "operation");
        long[] jArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return initial;
            }
            initial = operation.invoke(Long.valueOf(jArr[i10]), initial);
        }
    }

    public final <R> R foldRightIndexed(R initial, q<? super Integer, ? super Long, ? super R, ? extends R> operation) {
        m.f(operation, "operation");
        long[] jArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return initial;
            }
            initial = operation.invoke(Integer.valueOf(i10), Long.valueOf(jArr[i10]), initial);
        }
    }

    public final void forEach(l<? super Long, z> block) {
        m.f(block, "block");
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            block.invoke(Long.valueOf(jArr[i11]));
        }
    }

    public final void forEachIndexed(p<? super Integer, ? super Long, z> block) {
        m.f(block, "block");
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            block.invoke(Integer.valueOf(i11), Long.valueOf(jArr[i11]));
        }
    }

    public final void forEachReversed(l<? super Long, z> block) {
        m.f(block, "block");
        long[] jArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return;
            } else {
                block.invoke(Long.valueOf(jArr[i10]));
            }
        }
    }

    public final void forEachReversedIndexed(p<? super Integer, ? super Long, z> block) {
        m.f(block, "block");
        long[] jArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return;
            } else {
                block.invoke(Integer.valueOf(i10), Long.valueOf(jArr[i10]));
            }
        }
    }

    public final long get(@IntRange(from = 0) int index) {
        if (index >= 0 && index < this._size) {
            return this.content[index];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Index ");
        sb2.append(index);
        sb2.append(" must be in 0..");
        sb2.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        long[] jArr = this.content;
        int i10 = this._size;
        int iA = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iA += a.a(jArr[i11]) * 31;
        }
        return iA;
    }

    public final int indexOf(long element) {
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (element == jArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public final int indexOfFirst(l<? super Long, Boolean> predicate) {
        m.f(predicate, "predicate");
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (predicate.invoke(Long.valueOf(jArr[i11])).booleanValue()) {
                return i11;
            }
        }
        return -1;
    }

    public final int indexOfLast(l<? super Long, Boolean> predicate) {
        m.f(predicate, "predicate");
        long[] jArr = this.content;
        int i10 = this._size;
        do {
            i10--;
            if (-1 >= i10) {
                return -1;
            }
        } while (!predicate.invoke(Long.valueOf(jArr[i10])).booleanValue());
        return i10;
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

    public final int lastIndexOf(long element) {
        long[] jArr = this.content;
        int i10 = this._size;
        do {
            i10--;
            if (-1 >= i10) {
                return -1;
            }
        } while (jArr[i10] != element);
        return i10;
    }

    public final boolean reversedAny(l<? super Long, Boolean> predicate) {
        m.f(predicate, "predicate");
        long[] jArr = this.content;
        for (int i10 = this._size - 1; -1 < i10; i10--) {
            if (predicate.invoke(Long.valueOf(jArr[i10])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final boolean none() {
        return isEmpty();
    }

    public final long first(l<? super Long, Boolean> predicate) {
        m.f(predicate, "predicate");
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            long j10 = jArr[i11];
            if (predicate.invoke(Long.valueOf(j10)).booleanValue()) {
                return j10;
            }
        }
        throw new NoSuchElementException("LongList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ String joinToString$default(LongList longList, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, l transform, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                separator = ", ";
            }
            if ((i11 & 2) != 0) {
                prefix = "";
            }
            if ((i11 & 4) != 0) {
                postfix = "";
            }
            if ((i11 & 8) != 0) {
                i10 = -1;
            }
            if ((i11 & 16) != 0) {
                truncated = "...";
            }
            m.f(separator, "separator");
            m.f(prefix, "prefix");
            m.f(postfix, "postfix");
            m.f(truncated, "truncated");
            m.f(transform, "transform");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(prefix);
            long[] jArr = longList.content;
            int i12 = longList._size;
            for (int i13 = 0; i13 < i12; i13++) {
                long j10 = jArr[i13];
                if (i13 == i10) {
                    sb2.append(truncated);
                    String string = sb2.toString();
                    m.e(string, "StringBuilder().apply(builderAction).toString()");
                    return string;
                }
                if (i13 != 0) {
                    sb2.append(separator);
                }
                sb2.append((CharSequence) transform.invoke(Long.valueOf(j10)));
            }
            sb2.append(postfix);
            String string2 = sb2.toString();
            m.e(string2, "StringBuilder().apply(builderAction).toString()");
            return string2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i10) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i10, null, 16, null);
    }

    public final long last(l<? super Long, Boolean> predicate) {
        long j10;
        m.f(predicate, "predicate");
        long[] jArr = this.content;
        int i10 = this._size;
        do {
            i10--;
            if (-1 < i10) {
                j10 = jArr[i10];
            } else {
                throw new NoSuchElementException("LongList contains no element matching the predicate.");
            }
        } while (!predicate.invoke(Long.valueOf(j10)).booleanValue());
        return j10;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        m.f(truncated, "truncated");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            long j10 = jArr[i11];
            if (i11 == limit) {
                sb2.append(truncated);
                String string = sb2.toString();
                m.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i11 != 0) {
                sb2.append(separator);
            }
            sb2.append(j10);
        }
        sb2.append(postfix);
        String string2 = sb2.toString();
        m.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, l<? super Long, ? extends CharSequence> transform) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        m.f(truncated, "truncated");
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            long j10 = jArr[i11];
            if (i11 == limit) {
                sb2.append(truncated);
                String string = sb2.toString();
                m.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i11 != 0) {
                sb2.append(separator);
            }
            sb2.append(transform.invoke(Long.valueOf(j10)));
        }
        sb2.append(postfix);
        String string2 = sb2.toString();
        m.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, l<? super Long, ? extends CharSequence> transform) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.content;
        int i11 = this._size;
        for (int i12 = 0; i12 < i11; i12++) {
            long j10 = jArr[i12];
            if (i12 == i10) {
                sb2.append((CharSequence) "...");
                String string = sb2.toString();
                m.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i12 != 0) {
                sb2.append(separator);
            }
            sb2.append(transform.invoke(Long.valueOf(j10)));
        }
        sb2.append(postfix);
        String string2 = sb2.toString();
        m.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, l<? super Long, ? extends CharSequence> transform) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(postfix, "postfix");
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            long j10 = jArr[i11];
            if (i11 == -1) {
                sb2.append((CharSequence) "...");
                String string = sb2.toString();
                m.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i11 != 0) {
                sb2.append(separator);
            }
            sb2.append(transform.invoke(Long.valueOf(j10)));
        }
        sb2.append(postfix);
        String string2 = sb2.toString();
        m.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, l<? super Long, ? extends CharSequence> transform) {
        m.f(separator, "separator");
        m.f(prefix, "prefix");
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            long j10 = jArr[i11];
            if (i11 == -1) {
                sb2.append((CharSequence) "...");
                String string = sb2.toString();
                m.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i11 != 0) {
                sb2.append(separator);
            }
            sb2.append(transform.invoke(Long.valueOf(j10)));
        }
        sb2.append((CharSequence) "");
        String string2 = sb2.toString();
        m.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final String joinToString(CharSequence separator, l<? super Long, ? extends CharSequence> transform) {
        m.f(separator, "separator");
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            long j10 = jArr[i11];
            if (i11 == -1) {
                sb2.append((CharSequence) "...");
                String string = sb2.toString();
                m.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i11 != 0) {
                sb2.append(separator);
            }
            sb2.append(transform.invoke(Long.valueOf(j10)));
        }
        sb2.append((CharSequence) "");
        String string2 = sb2.toString();
        m.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final String joinToString(l<? super Long, ? extends CharSequence> transform) {
        m.f(transform, "transform");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            long j10 = jArr[i11];
            if (i11 == -1) {
                sb2.append((CharSequence) "...");
                String string = sb2.toString();
                m.e(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            }
            if (i11 != 0) {
                sb2.append((CharSequence) ", ");
            }
            sb2.append(transform.invoke(Long.valueOf(j10)));
        }
        sb2.append((CharSequence) "");
        String string2 = sb2.toString();
        m.e(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }
}
