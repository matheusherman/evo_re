package s8;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0015\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0012\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0000\u0018\u0000 a*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0003bcaB\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u000bJ\u001b\u0010\u001a\u001a\u00020\u00192\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b \u0010!J-\u0010$\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010*\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u001eJ5\u0010\u0001\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010+\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u0001\u0010,J\u0013\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0019H\u0016¢\u0006\u0004\b/\u00100J\u0018\u00102\u001a\u00028\u00002\u0006\u00101\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b2\u0010'J \u00103\u001a\u00028\u00002\u0006\u00101\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b7\u00106J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00028\u000008H\u0096\u0002¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0016¢\u0006\u0004\b<\u0010=J\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000;2\u0006\u00101\u001a\u00020\bH\u0016¢\u0006\u0004\b<\u0010>J\u0017\u0010?\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b?\u0010@J\u001f\u0010?\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b?\u0010!J\u001d\u0010A\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\bA\u0010BJ%\u0010A\u001a\u00020\u00192\u0006\u00101\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\bA\u0010CJ\u000f\u0010D\u001a\u00020\u000fH\u0016¢\u0006\u0004\bD\u0010\u0011J\u0017\u0010E\u001a\u00028\u00002\u0006\u00101\u001a\u00020\bH\u0016¢\u0006\u0004\bE\u0010'J\u0017\u0010F\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\bF\u0010@J\u001d\u0010G\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\bG\u0010BJ\u001d\u0010H\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\"H\u0016¢\u0006\u0004\bH\u0010BJ%\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\bH\u0016¢\u0006\u0004\bK\u0010LJ)\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00010N\"\u0004\b\u0001\u0010M2\f\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00010NH\u0016¢\u0006\u0004\bP\u0010QJ\u0017\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0NH\u0016¢\u0006\u0004\bP\u0010RJ\u001a\u0010S\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\bS\u0010@J\u000f\u0010T\u001a\u00020\bH\u0016¢\u0006\u0004\bT\u0010UJ\u000f\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010XR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010U¨\u0006d"}, d2 = {"Ls8/b;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/f;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "initialCapacity", "<init>", "(I)V", "", "writeReplace", "()Ljava/lang/Object;", "Lr8/z;", "B", "()V", "w", "n", "z", "minCapacity", "y", "", TransactionPartnerType.OTHER, "", "x", "(Ljava/util/List;)Z", "i", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(II)V", "element", "u", "(ILjava/lang/Object;)V", "", "elements", "t", "(ILjava/util/Collection;I)V", "C", "(I)Ljava/lang/Object;", "rangeOffset", "rangeLength", "D", "retain", "(IILjava/util/Collection;Z)I", "v", "()Ljava/util/List;", "isEmpty", "()Z", "index", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "add", "(Ljava/lang/Object;)Z", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "f", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "backing", "[Ljava/lang/Object;", "length", "I", "isReadOnly", "Z", "e", "size", "a", "b", "c", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class b<E> extends kotlin.collections.f<E> implements List<E>, RandomAccess, Serializable, d9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0356b f18472a = new C0356b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f18473b;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0016\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001fBC\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u001b\u0010!\u001a\u00020 2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0001H\u0002¢\u0006\u0004\b%\u0010&J-\u0010*\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'2\u0006\u0010)\u001a\u00020\nH\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00028\u00012\u0006\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nH\u0002¢\u0006\u0004\b0\u00101J5\u00103\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'2\u0006\u00102\u001a\u00020 H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020 H\u0016¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u00028\u00012\u0006\u00107\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b8\u0010-J \u00109\u001a\u00028\u00012\u0006\u00107\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0001H\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0001H\u0016¢\u0006\u0004\b=\u0010<J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010>H\u0096\u0002¢\u0006\u0004\b?\u0010@J\u0015\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00010AH\u0016¢\u0006\u0004\bB\u0010CJ\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00010A2\u0006\u00107\u001a\u00020\nH\u0016¢\u0006\u0004\bB\u0010DJ\u0017\u0010E\u001a\u00020 2\u0006\u0010$\u001a\u00028\u0001H\u0016¢\u0006\u0004\bE\u0010FJ\u001f\u0010E\u001a\u00020\u00172\u0006\u00107\u001a\u00020\n2\u0006\u0010$\u001a\u00028\u0001H\u0016¢\u0006\u0004\bE\u0010&J\u001d\u0010G\u001a\u00020 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0016¢\u0006\u0004\bG\u0010HJ%\u0010G\u001a\u00020 2\u0006\u00107\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0016¢\u0006\u0004\bG\u0010IJ\u000f\u0010J\u001a\u00020\u0017H\u0016¢\u0006\u0004\bJ\u0010\u001bJ\u0017\u0010K\u001a\u00028\u00012\u0006\u00107\u001a\u00020\nH\u0016¢\u0006\u0004\bK\u0010-J\u0017\u0010L\u001a\u00020 2\u0006\u0010$\u001a\u00028\u0001H\u0016¢\u0006\u0004\bL\u0010FJ\u001d\u0010M\u001a\u00020 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0016¢\u0006\u0004\bM\u0010HJ\u001d\u0010N\u001a\u00020 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010'H\u0016¢\u0006\u0004\bN\u0010HJ%\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\nH\u0016¢\u0006\u0004\bQ\u0010RJ)\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00020\b\"\u0004\b\u0002\u0010S2\f\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00020\bH\u0016¢\u0006\u0004\bU\u0010VJ\u0017\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\bH\u0016¢\u0006\u0004\bU\u0010WJ\u001a\u0010X\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\bX\u0010FJ\u000f\u0010Y\u001a\u00020\nH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b\\\u0010]R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010^R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010_R\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010_R\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010`R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010aR\u0014\u0010c\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u00106R\u0014\u0010e\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010Z¨\u0006g"}, d2 = {"Ls8/b$a;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/f;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "backing", "", "offset", "length", "parent", "Ls8/b;", "root", "<init>", "([Ljava/lang/Object;IILs8/b$a;Ls8/b;)V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "Lr8/z;", "readObject", "(Ljava/io/ObjectInputStream;)V", "v", "()V", "r", "s", "", TransactionPartnerType.OTHER, "", "t", "(Ljava/util/List;)Z", "i", "element", "q", "(ILjava/lang/Object;)V", "", "elements", "n", "o", "(ILjava/util/Collection;I)V", "w", "(I)Ljava/lang/Object;", "rangeOffset", "rangeLength", "x", "(II)V", "retain", "y", "(IILjava/util/Collection;Z)I", "isEmpty", "()Z", "index", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "add", "(Ljava/lang/Object;)Z", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "f", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "[Ljava/lang/Object;", "I", "Ls8/b$a;", "Ls8/b;", "u", "isReadOnly", "e", "size", "a", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<E> extends kotlin.collections.f<E> implements List<E>, RandomAccess, Serializable, d9.d {
        private E[] backing;
        private int length;
        private final int offset;
        private final a<E> parent;
        private final b<E> root;

        /* JADX INFO: renamed from: s8.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006\""}, d2 = {"Ls8/b$a$a;", ExifInterface.LONGITUDE_EAST, "", "Ls8/b$a;", "list", "", "index", "<init>", "(Ls8/b$a;I)V", "Lr8/z;", "c", "()V", "", "hasPrevious", "()Z", "hasNext", "previousIndex", "()I", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "element", "set", "(Ljava/lang/Object;)V", "add", "remove", "a", "Ls8/b$a;", "b", "I", "lastIndex", "d", "expectedModCount", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        private static final class C0355a<E> implements ListIterator<E>, d9.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final a<E> list;

            /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
            private int index;

            /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
            private int lastIndex;

            /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
            private int expectedModCount;

            public C0355a(a<E> list, int i10) {
                m.f(list, "list");
                this.list = list;
                this.index = i10;
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) list).modCount;
            }

            private final void c() {
                if (((AbstractList) ((a) this.list).root).modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.index < ((a) this.list).length;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.index > 0;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.index;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.index - 1;
            }

            @Override // java.util.ListIterator
            public void add(E element) {
                c();
                a<E> aVar = this.list;
                int i10 = this.index;
                this.index = i10 + 1;
                aVar.add(i10, element);
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) this.list).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public E next() {
                c();
                if (this.index < ((a) this.list).length) {
                    int i10 = this.index;
                    this.index = i10 + 1;
                    this.lastIndex = i10;
                    return (E) ((a) this.list).backing[((a) this.list).offset + this.lastIndex];
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public E previous() {
                c();
                int i10 = this.index;
                if (i10 > 0) {
                    int i11 = i10 - 1;
                    this.index = i11;
                    this.lastIndex = i11;
                    return (E) ((a) this.list).backing[((a) this.list).offset + this.lastIndex];
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                c();
                int i10 = this.lastIndex;
                if (i10 != -1) {
                    this.list.f(i10);
                    this.index = this.lastIndex;
                    this.lastIndex = -1;
                    this.expectedModCount = ((AbstractList) this.list).modCount;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }

            @Override // java.util.ListIterator
            public void set(E element) {
                c();
                int i10 = this.lastIndex;
                if (i10 != -1) {
                    this.list.set(i10, element);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E element) {
            s();
            r();
            q(this.offset + this.length, element);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> elements) {
            m.f(elements, "elements");
            s();
            r();
            int size = elements.size();
            o(this.offset + this.length, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] array) {
            m.f(array, "array");
            r();
            int length = array.length;
            int i10 = this.length;
            if (length >= i10) {
                E[] eArr = this.backing;
                int i11 = this.offset;
                kotlin.collections.j.i(eArr, array, 0, i11, i10 + i11);
                return (T[]) r.f(this.length, array);
            }
            E[] eArr2 = this.backing;
            int i12 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr2, i12, i10 + i12, array.getClass());
            m.e(tArr, "copyOfRange(...)");
            return tArr;
        }

        public a(E[] backing, int i10, int i11, a<E> aVar, b<E> root) {
            m.f(backing, "backing");
            m.f(root, "root");
            this.backing = backing;
            this.offset = i10;
            this.length = i11;
            this.parent = aVar;
            this.root = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }

        private final void r() {
            if (((AbstractList) this.root).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void readObject(ObjectInputStream input) throws InvalidObjectException {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final boolean t(List<?> other) {
            return s8.c.h(this.backing, this.offset, this.length, other);
        }

        private final boolean u() {
            return ((b) this.root).isReadOnly;
        }

        private final void v() {
            ((AbstractList) this).modCount++;
        }

        private final void x(int rangeOffset, int rangeLength) {
            if (rangeLength > 0) {
                v();
            }
            a<E> aVar = this.parent;
            if (aVar != null) {
                aVar.x(rangeOffset, rangeLength);
            } else {
                this.root.D(rangeOffset, rangeLength);
            }
            this.length -= rangeLength;
        }

        private final int y(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
            a<E> aVar = this.parent;
            int iY = aVar != null ? aVar.y(rangeOffset, rangeLength, elements, retain) : this.root.E(rangeOffset, rangeLength, elements, retain);
            if (iY > 0) {
                v();
            }
            this.length -= iY;
            return iY;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int index) {
            r();
            kotlin.collections.d.INSTANCE.c(index, this.length);
            return new C0355a(this, index);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<?> elements) {
            m.f(elements, "elements");
            s();
            r();
            return y(this.offset, this.length, elements, false) > 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<?> elements) {
            m.f(elements, "elements");
            s();
            r();
            return y(this.offset, this.length, elements, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            kotlin.collections.d.INSTANCE.d(fromIndex, toIndex, this.length);
            return new a(this.backing, this.offset + fromIndex, toIndex - fromIndex, this, this.root);
        }

        private final void o(int i10, Collection<? extends E> elements, int n10) {
            v();
            a<E> aVar = this.parent;
            if (aVar == null) {
                this.root.t(i10, elements, n10);
            } else {
                aVar.o(i10, elements, n10);
            }
            this.backing = (E[]) ((b) this.root).backing;
            this.length += n10;
        }

        private final void q(int i10, E element) {
            v();
            a<E> aVar = this.parent;
            if (aVar == null) {
                this.root.u(i10, element);
            } else {
                aVar.q(i10, element);
            }
            this.backing = (E[]) ((b) this.root).backing;
            this.length++;
        }

        private final void s() {
            if (!u()) {
            } else {
                throw new UnsupportedOperationException();
            }
        }

        private final E w(int i10) {
            E eW;
            v();
            a<E> aVar = this.parent;
            if (aVar == null) {
                eW = (E) this.root.C(i10);
            } else {
                eW = aVar.w(i10);
            }
            this.length--;
            return eW;
        }

        private final Object writeReplace() throws NotSerializableException {
            if (u()) {
                return new h(this, 0);
            }
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            s();
            r();
            x(this.offset, this.length);
        }

        @Override // kotlin.collections.f
        /* JADX INFO: renamed from: e */
        public int getSize() {
            r();
            return this.length;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object other) {
            r();
            if (other != this) {
                if (!(other instanceof List) || !t((List) other)) {
                    return false;
                }
                return true;
            }
            return true;
        }

        @Override // kotlin.collections.f
        public E f(int index) {
            s();
            r();
            kotlin.collections.d.INSTANCE.b(index, this.length);
            return w(this.offset + index);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int index) {
            r();
            kotlin.collections.d.INSTANCE.b(index, this.length);
            return this.backing[this.offset + index];
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            r();
            return s8.c.i(this.backing, this.offset, this.length);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object element) {
            r();
            for (int i10 = 0; i10 < this.length; i10++) {
                if (m.a(this.backing[this.offset + i10], element)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            r();
            if (this.length == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object element) {
            r();
            for (int i10 = this.length - 1; i10 >= 0; i10--) {
                if (m.a(this.backing[this.offset + i10], element)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object element) {
            s();
            r();
            int iIndexOf = indexOf(element);
            if (iIndexOf >= 0) {
                f(iIndexOf);
            }
            if (iIndexOf >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int index, E element) {
            s();
            r();
            kotlin.collections.d.INSTANCE.b(index, this.length);
            E[] eArr = this.backing;
            int i10 = this.offset;
            E e10 = eArr[i10 + index];
            eArr[i10 + index] = element;
            return e10;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            r();
            return s8.c.j(this.backing, this.offset, this.length, this);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int index, E element) {
            s();
            r();
            kotlin.collections.d.INSTANCE.c(index, this.length);
            q(this.offset + index, element);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int index, Collection<? extends E> elements) {
            m.f(elements, "elements");
            s();
            r();
            kotlin.collections.d.INSTANCE.c(index, this.length);
            int size = elements.size();
            o(this.offset + index, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            r();
            E[] eArr = this.backing;
            int i10 = this.offset;
            return kotlin.collections.j.p(eArr, i10, this.length + i10);
        }
    }

    /* JADX INFO: renamed from: s8.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ls8/b$b;", "", "<init>", "()V", "Ls8/b;", "", "Empty", "Ls8/b;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class C0356b {
        public /* synthetic */ C0356b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private C0356b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006\""}, d2 = {"Ls8/b$c;", ExifInterface.LONGITUDE_EAST, "", "Ls8/b;", "list", "", "index", "<init>", "(Ls8/b;I)V", "Lr8/z;", "c", "()V", "", "hasPrevious", "()Z", "hasNext", "previousIndex", "()I", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "element", "set", "(Ljava/lang/Object;)V", "add", "remove", "a", "Ls8/b;", "b", "I", "lastIndex", "d", "expectedModCount", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class c<E> implements ListIterator<E>, d9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final b<E> list;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int index;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int lastIndex;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int expectedModCount;

        public c(b<E> list, int i10) {
            m.f(list, "list");
            this.list = list;
            this.index = i10;
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) list).modCount;
        }

        private final void c() {
            if (((AbstractList) this.list).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < ((b) this.list).length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public void add(E element) {
            c();
            b<E> bVar = this.list;
            int i10 = this.index;
            this.index = i10 + 1;
            bVar.add(i10, element);
            this.lastIndex = -1;
            this.expectedModCount = ((AbstractList) this.list).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            c();
            if (this.index < ((b) this.list).length) {
                int i10 = this.index;
                this.index = i10 + 1;
                this.lastIndex = i10;
                return (E) ((b) this.list).backing[this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public E previous() {
            c();
            int i10 = this.index;
            if (i10 > 0) {
                int i11 = i10 - 1;
                this.index = i11;
                this.lastIndex = i11;
                return (E) ((b) this.list).backing[this.lastIndex];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            c();
            int i10 = this.lastIndex;
            if (i10 != -1) {
                this.list.f(i10);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = ((AbstractList) this.list).modCount;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }

        @Override // java.util.ListIterator
        public void set(E element) {
            c();
            int i10 = this.lastIndex;
            if (i10 != -1) {
                this.list.set(i10, element);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    public b() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int E(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < rangeLength) {
            int i12 = rangeOffset + i10;
            if (elements.contains(this.backing[i12]) == retain) {
                E[] eArr = this.backing;
                i10++;
                eArr[i11 + rangeOffset] = eArr[i12];
                i11++;
            } else {
                i10++;
            }
        }
        int i13 = rangeLength - i11;
        E[] eArr2 = this.backing;
        kotlin.collections.j.i(eArr2, eArr2, rangeOffset + i11, rangeLength + rangeOffset, this.length);
        E[] eArr3 = this.backing;
        int i14 = this.length;
        s8.c.g(eArr3, i14 - i13, i14);
        if (i13 > 0) {
            B();
        }
        this.length -= i13;
        return i13;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        w();
        u(this.length, element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        m.f(elements, "elements");
        w();
        int size = elements.size();
        t(this.length, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        for (int i10 = 0; i10 < this.length; i10++) {
            if (m.a(this.backing[i10], element)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        m.f(array, "array");
        int length = array.length;
        int i10 = this.length;
        if (length >= i10) {
            kotlin.collections.j.i(this.backing, array, 0, 0, i10);
            return (T[]) r.f(this.length, array);
        }
        T[] tArr = (T[]) Arrays.copyOfRange(this.backing, 0, i10, array.getClass());
        m.e(tArr, "copyOfRange(...)");
        return tArr;
    }

    static {
        b bVar = new b(0);
        bVar.isReadOnly = true;
        f18473b = bVar;
    }

    public b(int i10) {
        this.backing = (E[]) s8.c.d(i10);
    }

    private final void B() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int rangeOffset, int rangeLength) {
        if (rangeLength > 0) {
            B();
        }
        E[] eArr = this.backing;
        kotlin.collections.j.i(eArr, eArr, rangeOffset, rangeOffset + rangeLength, this.length);
        E[] eArr2 = this.backing;
        int i10 = this.length;
        s8.c.g(eArr2, i10 - rangeLength, i10);
        this.length -= rangeLength;
    }

    private final void w() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new h(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    private final boolean x(List<?> other) {
        return s8.c.h(this.backing, 0, this.length, other);
    }

    private final void y(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.backing;
        if (minCapacity > eArr.length) {
            this.backing = (E[]) s8.c.e(this.backing, kotlin.collections.d.INSTANCE.e(eArr.length, minCapacity));
        }
    }

    private final void z(int n10) {
        y(this.length + n10);
    }

    @Override // kotlin.collections.f
    /* JADX INFO: renamed from: e, reason: from getter */
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object other) {
        if (other != this) {
            return (other instanceof List) && x((List) other);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        kotlin.collections.d.INSTANCE.b(index, this.length);
        return this.backing[index];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return s8.c.i(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        for (int i10 = this.length - 1; i10 >= 0; i10--) {
            if (m.a(this.backing[i10], element)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        kotlin.collections.d.INSTANCE.c(index, this.length);
        return new c(this, index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> elements) {
        m.f(elements, "elements");
        w();
        return E(0, this.length, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> elements) {
        m.f(elements, "elements");
        w();
        return E(0, this.length, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        kotlin.collections.d.INSTANCE.d(fromIndex, toIndex, this.length);
        return new a(this.backing, fromIndex, toIndex - fromIndex, null, this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return s8.c.j(this.backing, 0, this.length, this);
    }

    private final void A(int i10, int n10) {
        z(n10);
        E[] eArr = this.backing;
        kotlin.collections.j.i(eArr, eArr, i10 + n10, i10, this.length);
        this.length += n10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E C(int i10) {
        B();
        E[] eArr = this.backing;
        E e10 = eArr[i10];
        kotlin.collections.j.i(eArr, eArr, i10, i10 + 1, this.length);
        s8.c.f(this.backing, this.length - 1);
        this.length--;
        return e10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int i10, Collection<? extends E> elements, int n10) {
        B();
        A(i10, n10);
        Iterator<? extends E> it = elements.iterator();
        for (int i11 = 0; i11 < n10; i11++) {
            this.backing[i10 + i11] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int i10, E element) {
        B();
        A(i10, 1);
        this.backing[i10] = element;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        w();
        kotlin.collections.d.INSTANCE.c(index, this.length);
        u(index, element);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        w();
        D(0, this.length);
    }

    @Override // kotlin.collections.f
    public E f(int index) {
        w();
        kotlin.collections.d.INSTANCE.b(index, this.length);
        return C(index);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        w();
        int iIndexOf = indexOf(element);
        if (iIndexOf >= 0) {
            f(iIndexOf);
        }
        if (iIndexOf >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        w();
        kotlin.collections.d.INSTANCE.b(index, this.length);
        E[] eArr = this.backing;
        E e10 = eArr[index];
        eArr[index] = element;
        return e10;
    }

    public final List<E> v() {
        w();
        this.isReadOnly = true;
        if (this.length > 0) {
            return this;
        }
        return f18473b;
    }

    public /* synthetic */ b(int i10, int i11, kotlin.jvm.internal.g gVar) {
        this((i11 & 1) != 0 ? 10 : i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        m.f(elements, "elements");
        w();
        kotlin.collections.d.INSTANCE.c(index, this.length);
        int size = elements.size();
        t(index, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return kotlin.collections.j.p(this.backing, 0, this.length);
    }
}
