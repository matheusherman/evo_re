package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u001f\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\f\u0010\n\u001a'\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a%\u0010\u0013\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0015\u0010\u0007\u001a\u001d\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0016\u0010\n\u001a\u001f\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0017\u0010\u0007\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0018\u0010\n\u001a\u001d\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0019\u0010\u0007\u001a\u001d\u0010\u001a\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u001a\u0010\n\u001a\u001f\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001b\u0010\u0007\u001a\u001f\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u001c\u0010\n\u001a+\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b \u0010!\u001a=\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\"H\u0086\bø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a+\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b&\u0010\u001f\u001a+\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b'\u0010!\u001a#\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b(\u0010)\u001a-\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000**\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b+\u0010)\u001a?\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010.\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000,j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`-¢\u0006\u0004\b/\u00100\u001a\u0017\u00103\u001a\u000202*\b\u0012\u0004\u0012\u00020\r01¢\u0006\u0004\b3\u00104\u001a7\u00108\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u00028\u000005*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u00107\u001a\u00028\u0001¢\u0006\u0004\b8\u00109\u001a#\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b:\u0010)\u001a#\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000;\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b<\u0010)\u001a#\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000;\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u000001¢\u0006\u0004\b=\u0010>\u001a#\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000?\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b@\u0010A\u001aC\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010B*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\u0086\bø\u0001\u0000¢\u0006\u0004\bD\u0010%\u001a)\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000E0\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bF\u0010G\u001a#\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bH\u0010)\u001a4\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000?\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0004¢\u0006\u0004\bJ\u0010K\u001a#\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000L\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bM\u0010A\u001a4\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000?\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0004¢\u0006\u0004\bN\u0010K\u001a7\u0010O\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\"H\u0086\bø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a+\u0010Q\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000**\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\bQ\u0010R\u001a+\u0010S\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000**\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\bS\u0010R\u001a.\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bT\u0010U\u001a.\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bV\u0010U\u001a.\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u0000012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bW\u0010X\u001a4\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\bZ\u0010[\u001a4\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u0000012\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b\\\u0010]\u001aF\u0010_\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010^0\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010B*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001H\u0086\u0004¢\u0006\u0004\b_\u0010[\u001a}\u0010j\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\f\b\u0001\u0010b*\u00060`j\u0002`a*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010c\u001a\u00028\u00012\b\b\u0002\u0010e\u001a\u00020d2\b\b\u0002\u0010f\u001a\u00020d2\b\b\u0002\u0010g\u001a\u00020d2\b\b\u0002\u0010h\u001a\u00020\r2\b\b\u0002\u0010i\u001a\u00020d2\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020d\u0018\u00010\"¢\u0006\u0004\bj\u0010k\u001ag\u0010m\u001a\u00020l\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010e\u001a\u00020d2\b\b\u0002\u0010f\u001a\u00020d2\b\b\u0002\u0010g\u001a\u00020d2\b\b\u0002\u0010h\u001a\u00020\r2\b\b\u0002\u0010i\u001a\u00020d2\u0016\b\u0002\u0010C\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020d\u0018\u00010\"¢\u0006\u0004\bm\u0010n\u001a#\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000o\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\bp\u0010q\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006r"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "element", "", "a0", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "f0", "(Ljava/lang/Iterable;)Ljava/lang/Object;", "", "g0", "(Ljava/util/List;)Ljava/lang/Object;", "h0", "i0", "", "index", "j0", "(Ljava/util/List;I)Ljava/lang/Object;", "k0", "(Ljava/lang/Iterable;Ljava/lang/Object;)I", "l0", "(Ljava/util/List;Ljava/lang/Object;)I", "r0", "s0", "t0", "u0", "E0", "F0", "G0", "H0", "n", "c0", "(Ljava/lang/Iterable;I)Ljava/util/List;", "d0", "(Ljava/util/List;I)Ljava/util/List;", "Lkotlin/Function1;", "predicate", "e0", "(Ljava/lang/Iterable;Lc9/l;)Ljava/util/List;", "K0", "L0", "D0", "(Ljava/lang/Iterable;)Ljava/util/List;", "", "I0", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "J0", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/List;", "", "", "N0", "(Ljava/util/Collection;)[I", "", "C", "destination", "M0", "(Ljava/lang/Iterable;Ljava/util/Collection;)Ljava/util/Collection;", "O0", "", "P0", "Q0", "(Ljava/util/Collection;)Ljava/util/List;", "", "S0", "(Ljava/lang/Iterable;)Ljava/util/Set;", "R", "transform", "v0", "Lkotlin/collections/h0;", "U0", "(Ljava/lang/Iterable;)Ljava/lang/Iterable;", "b0", TransactionPartnerType.OTHER, "m0", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/Set;", "", "R0", "T0", "Y", "(Ljava/lang/Iterable;Lc9/l;)Z", "w0", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "x0", "y0", "(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/util/List;", "A0", "C0", "(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;", "elements", "z0", "(Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/List;", "B0", "(Ljava/util/Collection;Ljava/lang/Iterable;)Ljava/util/List;", "Lr8/p;", "W0", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "buffer", "", "separator", "prefix", "postfix", "limit", "truncated", "n0", "(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lc9/l;)Ljava/lang/Appendable;", "", "p0", "(Ljava/lang/Iterable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lc9/l;)Ljava/lang/String;", "Lta/h;", "Z", "(Ljava/lang/Iterable;)Lta/h;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
public class c0 extends a0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/collections/c0$a", "Lta/h;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements ta.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f12284a;

        public a(Iterable iterable) {
            this.f12284a = iterable;
        }

        @Override // ta.h
        public Iterator<T> iterator() {
            return this.f12284a.iterator();
        }
    }

    public static <T> List<T> A0(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return C0((Collection) iterable, t10);
        }
        ArrayList arrayList = new ArrayList();
        y.C(arrayList, iterable);
        arrayList.add(t10);
        return arrayList;
    }

    public static <T> List<T> B0(Collection<? extends T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.f(collection, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            y.C(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static <T> List<T> C0(Collection<? extends T> collection, T t10) {
        kotlin.jvm.internal.m.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t10);
        return arrayList;
    }

    public static <T> List<T> D0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return O0(iterable);
        }
        List<T> listP0 = P0(iterable);
        a0.V(listP0);
        return listP0;
    }

    public static <T> T E0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) F0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static <T> T F0(List<? extends T> list) {
        kotlin.jvm.internal.m.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static <T> T G0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    public static <T> T H0(List<? extends T> list) {
        kotlin.jvm.internal.m.f(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static <T extends Comparable<? super T>> List<T> I0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> listP0 = P0(iterable);
            x.A(listP0);
            return listP0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return O0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        m.C((Comparable[]) array);
        return m.d(array);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> J0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> listP0 = P0(iterable);
            x.B(listP0, comparator);
            return listP0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return O0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        m.D(array, comparator);
        return m.d(array);
    }

    public static <T> List<T> K0(Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return t.l();
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                return O0(iterable);
            }
            if (i10 == 1) {
                return s.e(f0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator<? extends T> it = iterable.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return t.s(arrayList);
    }

    public static <T> List<T> L0(List<? extends T> list, int i10) {
        kotlin.jvm.internal.m.f(list, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return t.l();
        }
        int size = list.size();
        if (i10 >= size) {
            return O0(list);
        }
        if (i10 == 1) {
            return s.e(s0(list));
        }
        ArrayList arrayList = new ArrayList(i10);
        if (list instanceof RandomAccess) {
            for (int i11 = size - i10; i11 < size; i11++) {
                arrayList.add(list.get(i11));
            }
        } else {
            ListIterator<? extends T> listIterator = list.listIterator(size - i10);
            while (listIterator.hasNext()) {
                arrayList.add(listIterator.next());
            }
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C M0(Iterable<? extends T> iterable, C destination) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static int[] N0(Collection<Integer> collection) {
        kotlin.jvm.internal.m.f(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = it.next().intValue();
            i10++;
        }
        return iArr;
    }

    public static <T> List<T> O0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return t.s(P0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return t.l();
        }
        if (size != 1) {
            return Q0(collection);
        }
        return s.e(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final <T> List<T> P0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        return iterable instanceof Collection ? Q0((Collection) iterable) : (List) M0(iterable, new ArrayList());
    }

    public static <T> List<T> Q0(Collection<? extends T> collection) {
        kotlin.jvm.internal.m.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> R0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) M0(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> S0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return x0.g((Set) M0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return x0.e();
        }
        if (size != 1) {
            return (Set) M0(iterable, new LinkedHashSet(p0.e(collection.size())));
        }
        return w0.d(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static <T> Set<T> T0(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(other, "other");
        Set<T> setR0 = R0(iterable);
        y.C(setR0, other);
        return setR0;
    }

    public static <T> Iterable<IndexedValue<T>> U0(final Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        return new i0(new c9.a() { // from class: kotlin.collections.b0
            @Override // c9.a
            public final Object invoke() {
                return c0.V0(iterable);
            }
        });
    }

    public static <T, R> List<r8.p<T, R>> W0(Iterable<? extends T> iterable, Iterable<? extends R> other) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(u.w(iterable, 10), u.w(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(r8.v.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> boolean Y(Iterable<? extends T> iterable, c9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static <T> ta.h<T> Z(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> boolean a0(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t10);
        }
        return k0(iterable, t10) >= 0;
    }

    public static <T> List<T> b0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        return O0(R0(iterable));
    }

    public static <T> List<T> c0(Iterable<? extends T> iterable, int i10) {
        ArrayList arrayList;
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return O0(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i10;
            if (size <= 0) {
                return t.l();
            }
            if (size == 1) {
                return s.e(r0(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i10 < size2) {
                        arrayList.add(list.get(i10));
                        i10++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i10);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i11 = 0;
        for (T t10 : iterable) {
            if (i11 >= i10) {
                arrayList.add(t10);
            } else {
                i11++;
            }
        }
        return t.s(arrayList);
    }

    public static <T> List<T> d0(List<? extends T> list, int i10) {
        kotlin.jvm.internal.m.f(list, "<this>");
        if (i10 >= 0) {
            return K0(list, h9.f.c(list.size() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static <T> List<T> e0(Iterable<? extends T> iterable, c9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            if (predicate.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static <T> T f0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) g0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T g0(List<? extends T> list) {
        kotlin.jvm.internal.m.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T h0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T> T i0(List<? extends T> list) {
        kotlin.jvm.internal.m.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T j0(List<? extends T> list, int i10) {
        kotlin.jvm.internal.m.f(list, "<this>");
        if (i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return list.get(i10);
    }

    public static <T> int k0(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t10);
        }
        int i10 = 0;
        for (T t11 : iterable) {
            if (i10 < 0) {
                t.v();
            }
            if (kotlin.jvm.internal.m.a(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static <T> int l0(List<? extends T> list, T t10) {
        kotlin.jvm.internal.m.f(list, "<this>");
        return list.indexOf(t10);
    }

    public static <T> Set<T> m0(Iterable<? extends T> iterable, Iterable<? extends T> other) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(other, "other");
        Set<T> setR0 = R0(iterable);
        y.M(setR0, other);
        return setR0;
    }

    public static final <T, A extends Appendable> A n0(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, c9.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(buffer, "buffer");
        kotlin.jvm.internal.m.f(separator, "separator");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        kotlin.jvm.internal.m.f(postfix, "postfix");
        kotlin.jvm.internal.m.f(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : iterable) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            ua.n.a(buffer, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String p0(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, c9.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(separator, "separator");
        kotlin.jvm.internal.m.f(prefix, "prefix");
        kotlin.jvm.internal.m.f(postfix, "postfix");
        kotlin.jvm.internal.m.f(truncated, "truncated");
        return ((StringBuilder) n0(iterable, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }

    public static /* synthetic */ String q0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, c9.l lVar, int i11, Object obj) {
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
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        c9.l lVar2 = lVar;
        return p0(iterable, charSequence, charSequence2, charSequence3, i10, charSequence5, lVar2);
    }

    public static <T> T r0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) s0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T s0(List<? extends T> list) {
        kotlin.jvm.internal.m.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(t.n(list));
    }

    public static <T> T t0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T u0(List<? extends T> list) {
        kotlin.jvm.internal.m.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T, R> List<R> v0(Iterable<? extends T> iterable, c9.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(transform, "transform");
        ArrayList arrayList = new ArrayList(u.w(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static <T extends Comparable<? super T>> T w0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T extends Comparable<? super T>> T x0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> y0(Iterable<? extends T> iterable, T t10) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        ArrayList arrayList = new ArrayList(u.w(iterable, 10));
        boolean z10 = false;
        for (T t11 : iterable) {
            boolean z11 = true;
            if (!z10 && kotlin.jvm.internal.m.a(t11, t10)) {
                z10 = true;
                z11 = false;
            }
            if (z11) {
                arrayList.add(t11);
            }
        }
        return arrayList;
    }

    public static <T> List<T> z0(Iterable<? extends T> iterable, Iterable<? extends T> elements) {
        kotlin.jvm.internal.m.f(iterable, "<this>");
        kotlin.jvm.internal.m.f(elements, "elements");
        if (iterable instanceof Collection) {
            return B0((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        y.C(arrayList, iterable);
        y.C(arrayList, elements);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterator V0(Iterable iterable) {
        return iterable.iterator();
    }
}
