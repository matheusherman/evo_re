package s8;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u000b\b\u0000\u0018\u0000 \u0089\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\f\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001BG\b\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u0001\u0010\u0011J\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0013J\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010\u0013J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00028\u0000H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001fH\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b-\u0010\u0013J\u0017\u0010/\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u0010!J\u0017\u00100\u001a\u00020\f2\u0006\u0010&\u001a\u00028\u0000H\u0002¢\u0006\u0004\b0\u0010(J\u0017\u00102\u001a\u00020\f2\u0006\u00101\u001a\u00028\u0001H\u0002¢\u0006\u0004\b2\u0010(J\u0017\u00104\u001a\u00020\u00192\u0006\u00103\u001a\u00020\fH\u0002¢\u0006\u0004\b4\u0010\u0013J\u0017\u00106\u001a\u00020\u00192\u0006\u00105\u001a\u00020\fH\u0002¢\u0006\u0004\b6\u0010\u0013J\u001f\u00109\u001a\u00020\u001f2\u000e\u00108\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000307H\u0002¢\u0006\u0004\b9\u0010:J#\u0010=\u001a\u00020\u001f2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;H\u0002¢\u0006\u0004\b=\u0010>J)\u0010A\u001a\u00020\u001f2\u0018\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;0?H\u0002¢\u0006\u0004\bA\u0010BJ\u0019\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u001fH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u001f2\u0006\u0010&\u001a\u00028\u0000H\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u001f2\u0006\u00101\u001a\u00028\u0001H\u0016¢\u0006\u0004\bI\u0010HJ\u001a\u0010J\u001a\u0004\u0018\u00018\u00012\u0006\u0010&\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\bJ\u0010KJ!\u0010L\u001a\u0004\u0018\u00018\u00012\u0006\u0010&\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u0001H\u0016¢\u0006\u0004\bL\u0010MJ%\u0010N\u001a\u00020\u00192\u0014\u0010@\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107H\u0016¢\u0006\u0004\bN\u0010OJ\u0019\u0010P\u001a\u0004\u0018\u00018\u00012\u0006\u0010&\u001a\u00028\u0000H\u0016¢\u0006\u0004\bP\u0010KJ\u000f\u0010Q\u001a\u00020\u0019H\u0016¢\u0006\u0004\bQ\u0010\u0011J\u001a\u0010R\u001a\u00020\u001f2\b\u00108\u001a\u0004\u0018\u00010\u0014H\u0096\u0002¢\u0006\u0004\bR\u0010HJ\u000f\u0010S\u001a\u00020\fH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010X\u001a\u00020\f2\u0006\u0010&\u001a\u00028\u0000H\u0000¢\u0006\u0004\bX\u0010(J\u0017\u0010Y\u001a\u00020\u001f2\u0006\u0010&\u001a\u00028\u0000H\u0000¢\u0006\u0004\bY\u0010HJ#\u0010Z\u001a\u00020\u001f2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;H\u0000¢\u0006\u0004\bZ\u0010>J\u001b\u0010[\u001a\u00020\u001f2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030?H\u0000¢\u0006\u0004\b[\u0010BJ#\u0010\\\u001a\u00020\u001f2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;H\u0000¢\u0006\u0004\b\\\u0010>J\u0017\u0010^\u001a\u00020\u001f2\u0006\u0010]\u001a\u00028\u0001H\u0000¢\u0006\u0004\b^\u0010HJ\u001b\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010_H\u0000¢\u0006\u0004\b`\u0010aJ\u001b\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010bH\u0000¢\u0006\u0004\bc\u0010dJ\u001b\u0010f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010eH\u0000¢\u0006\u0004\bf\u0010gR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010hR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010hR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010iR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010iR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010=R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010=R\u0016\u0010j\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010=R\u0016\u0010k\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010=R$\u0010l\u001a\u00020\f2\u0006\u00101\u001a\u00020\f8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bl\u0010=\u001a\u0004\bm\u0010TR\u001e\u0010o\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u001e\u0010r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR$\u0010u\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR$\u0010w\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001f8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010FR\u0014\u0010{\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bz\u0010TR\u001a\u0010\u007f\u001a\b\u0012\u0004\u0012\u00028\u00000|8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~R\u001e\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0080\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R)\u0010\u0086\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0084\u00010|8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010~R\u0016\u0010\u0088\u0001\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010T¨\u0006\u008f\u0001"}, d2 = {"Ls8/d;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "keysArray", "valuesArray", "", "presenceArray", "hashArray", "", "maxProbeDistance", "length", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "()V", "initialCapacity", "(I)V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "Lr8/z;", "readObject", "(Ljava/io/ObjectInputStream;)V", "n", "t", "extraCapacity", "", "R", "(I)Z", "minCapacity", "s", "l", "()[Ljava/lang/Object;", "key", "D", "(Ljava/lang/Object;)I", "updateHashArray", "o", "(Z)V", "newHashSize", "L", "i", "J", "v", "value", "w", "index", "N", "removedHash", "O", "", TransactionPartnerType.OTHER, "r", "(Ljava/util/Map;)Z", "", "entry", "I", "(Ljava/util/Map$Entry;)Z", "", TypedValues.TransitionType.S_FROM, "H", "(Ljava/util/Collection;)Z", "m", "()Ljava/util/Map;", "isEmpty", "()Z", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "(Ljava/util/Map;)V", "remove", "clear", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "k", "P", "q", "p", "M", "element", "Q", "Ls8/d$e;", "G", "()Ls8/d$e;", "Ls8/d$f;", ExifInterface.LATITUDE_SOUTH, "()Ls8/d$f;", "Ls8/d$b;", "u", "()Ls8/d$b;", "[Ljava/lang/Object;", "[I", "hashShift", "modCount", "size", "B", "Ls8/f;", "keysView", "Ls8/f;", "Ls8/g;", "valuesView", "Ls8/g;", "Ls8/e;", "entriesView", "Ls8/e;", "isReadOnly", "Z", ExifInterface.LONGITUDE_EAST, "z", "hashSize", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/util/Set;", "keys", "", "C", "()Ljava/util/Collection;", "values", "", "y", "entries", "x", "capacity", "a", "d", "e", "f", "b", "c", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class d<K, V> implements Map<K, V>, Serializable, d9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d f18483b;
    private s8.e<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    private K[] keysArray;
    private s8.f<K> keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;
    private int[] presenceArray;
    private int size;
    private V[] valuesArray;
    private g<V> valuesView;

    /* JADX INFO: renamed from: s8.d$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\n\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Ls8/d$a;", "", "<init>", "()V", "", "capacity", "c", "(I)I", "hashSize", "d", "Ls8/d;", "", "Empty", "Ls8/d;", "e", "()Ls8/d;", "MAGIC", "I", "INITIAL_CAPACITY", "INITIAL_MAX_PROBE_DISTANCE", "TOMBSTONE", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int capacity) {
            return Integer.highestOneBit(h9.f.c(capacity, 1) * 3);
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int hashSize) {
            return Integer.numberOfLeadingZeros(hashSize) + 1;
        }

        public final d e() {
            return d.f18483b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00132\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ls8/d$b;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ls8/d$d;", "", "", "Ls8/d;", "map", "<init>", "(Ls8/d;)V", "Ls8/d$c;", "l", "()Ls8/d$c;", "", "n", "()I", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Lr8/z;", "m", "(Ljava/lang/StringBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b<K, V> extends C0357d<K, V> implements Iterator<Map.Entry<K, V>>, d9.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d<K, V> map) {
            super(map);
            m.f(map, "map");
        }

        public final void m(StringBuilder sb2) {
            m.f(sb2, "sb");
            if (getIndex() >= ((d) f()).length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            i(index + 1);
            k(index);
            Object obj = ((d) f()).keysArray[getLastIndex()];
            if (obj == f()) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = ((d) f()).valuesArray;
            m.c(objArr);
            Object obj2 = objArr[getLastIndex()];
            if (obj2 == f()) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            h();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            c();
            if (getIndex() < ((d) f()).length) {
                int index = getIndex();
                i(index + 1);
                k(index);
                c<K, V> cVar = new c<>(f(), getLastIndex());
                h();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final int n() {
            int iHashCode;
            if (getIndex() < ((d) f()).length) {
                int index = getIndex();
                i(index + 1);
                k(index);
                Object obj = ((d) f()).keysArray[getLastIndex()];
                int iHashCode2 = 0;
                if (obj != null) {
                    iHashCode = obj.hashCode();
                } else {
                    iHashCode = 0;
                }
                Object[] objArr = ((d) f()).valuesArray;
                m.c(objArr);
                Object obj2 = objArr[getLastIndex()];
                if (obj2 != null) {
                    iHashCode2 = obj2.hashCode();
                }
                int i10 = iHashCode ^ iHashCode2;
                h();
                return i10;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00028\u00032\u0006\u0010\r\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010!\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u0006$"}, d2 = {"Ls8/d$c;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Ls8/d;", "map", "", "index", "<init>", "(Ls8/d;I)V", "Lr8/z;", "a", "()V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ls8/d;", "b", "I", "c", "expectedModCount", "getKey", "()Ljava/lang/Object;", "key", "getValue", "value", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c<K, V> implements Map.Entry<K, V>, d9.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final d<K, V> map;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int index;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int expectedModCount;

        public c(d<K, V> map, int i10) {
            m.f(map, "map");
            this.map = map;
            this.index = i10;
            this.expectedModCount = ((d) map).modCount;
        }

        private final void a() {
            if (((d) this.map).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object other) {
            if (!(other instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) other;
            return m.a(entry.getKey(), getKey()) && m.a(entry.getValue(), getValue());
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            a();
            return (K) ((d) this.map).keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            a();
            Object[] objArr = ((d) this.map).valuesArray;
            m.c(objArr);
            return (V) objArr[this.index];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int iHashCode;
            K key = getKey();
            int iHashCode2 = 0;
            if (key != null) {
                iHashCode = key.hashCode();
            } else {
                iHashCode = 0;
            }
            V value = getValue();
            if (value != null) {
                iHashCode2 = value.hashCode();
            }
            return iHashCode ^ iHashCode2;
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            a();
            this.map.n();
            Object[] objArrL = this.map.l();
            int i10 = this.index;
            V v10 = (V) objArrL[i10];
            objArrL[i10] = newValue;
            return v10;
        }
    }

    /* JADX INFO: renamed from: s8.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000f\u0010\nR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006 "}, d2 = {"Ls8/d$d;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Ls8/d;", "map", "<init>", "(Ls8/d;)V", "Lr8/z;", "h", "()V", "", "hasNext", "()Z", "remove", "c", "a", "Ls8/d;", "f", "()Ls8/d;", "", "b", "I", "d", "()I", "i", "(I)V", "index", "e", "k", "lastIndex", "expectedModCount", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class C0357d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final d<K, V> map;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int index;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int lastIndex;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int expectedModCount;

        public C0357d(d<K, V> map) {
            m.f(map, "map");
            this.map = map;
            this.lastIndex = -1;
            this.expectedModCount = ((d) map).modCount;
            h();
        }

        public final void c() {
            if (((d) this.map).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final int getLastIndex() {
            return this.lastIndex;
        }

        public final d<K, V> f() {
            return this.map;
        }

        public final void h() {
            while (this.index < ((d) this.map).length) {
                int[] iArr = ((d) this.map).presenceArray;
                int i10 = this.index;
                if (iArr[i10] >= 0) {
                    return;
                } else {
                    this.index = i10 + 1;
                }
            }
        }

        public final boolean hasNext() {
            return this.index < ((d) this.map).length;
        }

        public final void i(int i10) {
            this.index = i10;
        }

        public final void k(int i10) {
            this.lastIndex = i10;
        }

        public final void remove() {
            c();
            if (this.lastIndex != -1) {
                this.map.n();
                this.map.N(this.lastIndex);
                this.lastIndex = -1;
                this.expectedModCount = ((d) this.map).modCount;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ls8/d$e;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ls8/d$d;", "", "Ls8/d;", "map", "<init>", "(Ls8/d;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e<K, V> extends C0357d<K, V> implements Iterator<K>, d9.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d<K, V> map) {
            super(map);
            m.f(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            c();
            if (getIndex() < ((d) f()).length) {
                int index = getIndex();
                i(index + 1);
                k(index);
                K k10 = (K) ((d) f()).keysArray[getLastIndex()];
                h();
                return k10;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ls8/d$f;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ls8/d$d;", "", "Ls8/d;", "map", "<init>", "(Ls8/d;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f<K, V> extends C0357d<K, V> implements Iterator<V>, d9.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d<K, V> map) {
            super(map);
            m.f(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            c();
            if (getIndex() < ((d) f()).length) {
                int index = getIndex();
                i(index + 1);
                k(index);
                Object[] objArr = ((d) f()).valuesArray;
                m.c(objArr);
                V v10 = (V) objArr[getLastIndex()];
                h();
                return v10;
            }
            throw new NoSuchElementException();
        }
    }

    private d(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i10, int i11) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i10;
        this.length = i11;
        this.hashShift = INSTANCE.d(z());
    }

    static {
        d dVar = new d(0);
        dVar.isReadOnly = true;
        f18483b = dVar;
    }

    private final int D(K key) {
        return ((key != null ? key.hashCode() : 0) * (-1640531527)) >>> this.hashShift;
    }

    private final boolean J(int i10) {
        int iD = D(this.keysArray[i10]);
        int i11 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[iD] == 0) {
                iArr[iD] = i10 + 1;
                this.presenceArray[i10] = iD;
                return true;
            }
            i11--;
            if (i11 < 0) {
                return false;
            }
            iD = iD == 0 ? z() - 1 : iD - 1;
        }
    }

    private final void K() {
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(int index) {
        s8.c.f(this.keysArray, index);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            s8.c.f(vArr, index);
        }
        O(this.presenceArray[index]);
        this.presenceArray[index] = -1;
        this.size = size() - 1;
        K();
    }

    private final void O(int removedHash) {
        int iE = h9.f.e(this.maxProbeDistance * 2, z() / 2);
        int i10 = 0;
        int i11 = removedHash;
        do {
            removedHash = removedHash == 0 ? z() - 1 : removedHash - 1;
            i10++;
            if (i10 > this.maxProbeDistance) {
                this.hashArray[i11] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i12 = iArr[removedHash];
            if (i12 == 0) {
                iArr[i11] = 0;
                return;
            }
            if (i12 < 0) {
                iArr[i11] = -1;
            } else {
                int i13 = i12 - 1;
                if (((D(this.keysArray[i13]) - removedHash) & (z() - 1)) >= i10) {
                    this.hashArray[i11] = i12;
                    this.presenceArray[i13] = i11;
                }
                iE--;
            }
            i11 = removedHash;
            i10 = 0;
            iE--;
        } while (iE >= 0);
        this.hashArray[i11] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] l() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) s8.c.d(x());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void o(boolean updateHashArray) {
        int i10;
        V[] vArr = this.valuesArray;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.length;
            if (i11 >= i10) {
                break;
            }
            int[] iArr = this.presenceArray;
            int i13 = iArr[i11];
            if (i13 >= 0) {
                K[] kArr = this.keysArray;
                kArr[i12] = kArr[i11];
                if (vArr != null) {
                    vArr[i12] = vArr[i11];
                }
                if (updateHashArray) {
                    iArr[i12] = i13;
                    this.hashArray[i13] = i12 + 1;
                }
                i12++;
            }
            i11++;
        }
        s8.c.g(this.keysArray, i12, i10);
        if (vArr != null) {
            s8.c.g(vArr, i12, this.length);
        }
        this.length = i12;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final void s(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (minCapacity > x()) {
            int iE = kotlin.collections.d.INSTANCE.e(x(), minCapacity);
            this.keysArray = (K[]) s8.c.e(this.keysArray, iE);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) s8.c.e(vArr, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, iE);
            m.e(iArrCopyOf, "copyOf(...)");
            this.presenceArray = iArrCopyOf;
            int iC = INSTANCE.c(iE);
            if (iC > z()) {
                L(iC);
            }
        }
    }

    private final int w(V value) {
        int i10 = this.length;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.presenceArray[i10] >= 0) {
                V[] vArr = this.valuesArray;
                m.c(vArr);
                if (m.a(vArr[i10], value)) {
                    return i10;
                }
            }
        }
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new i(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    private final int z() {
        return this.hashArray.length;
    }

    public Set<K> A() {
        s8.f<K> fVar = this.keysView;
        if (fVar != null) {
            return fVar;
        }
        s8.f<K> fVar2 = new s8.f<>(this);
        this.keysView = fVar2;
        return fVar2;
    }

    /* JADX INFO: renamed from: B, reason: from getter */
    public int getSize() {
        return this.size;
    }

    public Collection<V> C() {
        g<V> gVar = this.valuesView;
        if (gVar != null) {
            return gVar;
        }
        g<V> gVar2 = new g<>(this);
        this.valuesView = gVar2;
        return gVar2;
    }

    /* JADX INFO: renamed from: E, reason: from getter */
    public final boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    public final e<K, V> G() {
        return new e<>(this);
    }

    public final boolean M(Map.Entry<? extends K, ? extends V> entry) {
        m.f(entry, "entry");
        n();
        int iV = v(entry.getKey());
        if (iV < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        m.c(vArr);
        if (!m.a(vArr[iV], entry.getValue())) {
            return false;
        }
        N(iV);
        return true;
    }

    public final f<K, V> S() {
        return new f<>(this);
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (other != this) {
            return (other instanceof Map) && r((Map) other);
        }
        return true;
    }

    public final void n() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean p(Collection<?> m10) {
        m.f(m10, "m");
        for (Object obj : m10) {
            if (obj != null) {
                try {
                    if (!q((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        m.f(from, "from");
        n();
        H(from.entrySet());
    }

    public final boolean q(Map.Entry<? extends K, ? extends V> entry) {
        m.f(entry, "entry");
        int iV = v(entry.getKey());
        if (iV < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        m.c(vArr);
        return m.a(vArr[iV], entry.getValue());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        b<K, V> bVarU = u();
        int i10 = 0;
        while (bVarU.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            bVarU.m(sb2);
            i10++;
        }
        sb2.append("}");
        String string = sb2.toString();
        m.e(string, "toString(...)");
        return string;
    }

    public final b<K, V> u() {
        return new b<>(this);
    }

    public final int x() {
        return this.keysArray.length;
    }

    public Set<Map.Entry<K, V>> y() {
        s8.e<K, V> eVar = this.entriesView;
        if (eVar != null) {
            return eVar;
        }
        s8.e<K, V> eVar2 = new s8.e<>(this);
        this.entriesView = eVar2;
        return eVar2;
    }

    private final boolean H(Collection<? extends Map.Entry<? extends K, ? extends V>> from) {
        boolean z10 = false;
        if (from.isEmpty()) {
            return false;
        }
        t(from.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = from.iterator();
        while (it.hasNext()) {
            if (I(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    private final boolean I(Map.Entry<? extends K, ? extends V> entry) {
        int iK = k(entry.getKey());
        V[] vArrL = l();
        if (iK >= 0) {
            vArrL[iK] = entry.getValue();
            return true;
        }
        int i10 = (-iK) - 1;
        if (!m.a(entry.getValue(), vArrL[i10])) {
            vArrL[i10] = entry.getValue();
            return true;
        }
        return false;
    }

    private final void L(int newHashSize) {
        K();
        int i10 = 0;
        if (this.length > size()) {
            o(false);
        }
        this.hashArray = new int[newHashSize];
        this.hashShift = INSTANCE.d(newHashSize);
        while (i10 < this.length) {
            int i11 = i10 + 1;
            if (J(i10)) {
                i10 = i11;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final boolean R(int extraCapacity) {
        int iX = x();
        int i10 = this.length;
        int i11 = iX - i10;
        int size = i10 - size();
        if (i11 < extraCapacity && i11 + size >= extraCapacity && size >= x() / 4) {
            return true;
        }
        return false;
    }

    private final boolean r(Map<?, ?> other) {
        if (size() == other.size() && p(other.entrySet())) {
            return true;
        }
        return false;
    }

    private final void t(int n10) {
        if (R(n10)) {
            o(true);
        } else {
            s(this.length + n10);
        }
    }

    private final int v(K key) {
        int iD = D(key);
        int i10 = this.maxProbeDistance;
        while (true) {
            int i11 = this.hashArray[iD];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (m.a(this.keysArray[i12], key)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            int i13 = iD - 1;
            if (iD == 0) {
                iD = z() - 1;
            } else {
                iD = i13;
            }
        }
    }

    public final boolean P(K key) {
        n();
        int iV = v(key);
        if (iV < 0) {
            return false;
        }
        N(iV);
        return true;
    }

    public final boolean Q(V element) {
        n();
        int iW = w(element);
        if (iW < 0) {
            return false;
        }
        N(iW);
        return true;
    }

    @Override // java.util.Map
    public void clear() {
        n();
        int i10 = this.length - 1;
        if (i10 >= 0) {
            int i11 = 0;
            while (true) {
                int[] iArr = this.presenceArray;
                int i12 = iArr[i11];
                if (i12 >= 0) {
                    this.hashArray[i12] = 0;
                    iArr[i11] = -1;
                }
                if (i11 == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        s8.c.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            s8.c.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        K();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object key) {
        if (v(key) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object value) {
        if (w(value) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object key) {
        int iV = v(key);
        if (iV < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        m.c(vArr);
        return vArr[iV];
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarU = u();
        int iN = 0;
        while (bVarU.hasNext()) {
            iN += bVarU.n();
        }
        return iN;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final int k(K key) {
        n();
        while (true) {
            int iD = D(key);
            int iE = h9.f.e(this.maxProbeDistance * 2, z() / 2);
            int i10 = 0;
            while (true) {
                int i11 = this.hashArray[iD];
                if (i11 <= 0) {
                    if (this.length >= x()) {
                        t(1);
                        break;
                    }
                    int i12 = this.length;
                    int i13 = i12 + 1;
                    this.length = i13;
                    this.keysArray[i12] = key;
                    this.presenceArray[i12] = iD;
                    this.hashArray[iD] = i13;
                    this.size = size() + 1;
                    K();
                    if (i10 > this.maxProbeDistance) {
                        this.maxProbeDistance = i10;
                    }
                    return i12;
                }
                if (m.a(this.keysArray[i11 - 1], key)) {
                    return -i11;
                }
                i10++;
                if (i10 > iE) {
                    L(z() * 2);
                    break;
                }
                int i14 = iD - 1;
                if (iD == 0) {
                    iD = z() - 1;
                } else {
                    iD = i14;
                }
            }
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return A();
    }

    public final Map<K, V> m() {
        n();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        d dVar = f18483b;
        m.d(dVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return dVar;
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        n();
        int iK = k(key);
        V[] vArrL = l();
        if (iK < 0) {
            int i10 = (-iK) - 1;
            V v10 = vArrL[i10];
            vArrL[i10] = value;
            return v10;
        }
        vArrL[iK] = value;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object key) {
        n();
        int iV = v(key);
        if (iV < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        m.c(vArr);
        V v10 = vArr[iV];
        N(iV);
        return v10;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return C();
    }

    public d() {
        this(8);
    }

    public d(int i10) {
        this(s8.c.d(i10), null, new int[i10], new int[INSTANCE.c(i10)], 2, 0);
    }
}
