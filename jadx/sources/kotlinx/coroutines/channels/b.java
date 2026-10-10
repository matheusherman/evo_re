package kotlinx.coroutines.channels;

import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.e0;
import kotlinx.coroutines.internal.q0;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.x2;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\bF\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002w3B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\b\u0002\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ9\u0010\u0013\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\u00020\u0006*\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010 \u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!JG\u0010\"\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u0017\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0011H\u0003¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b'\u0010%J\u001b\u0010(\u001a\u00020\u001e*\u00020\u001c2\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b(\u0010)J)\u0010*\u001a\u00020\u0006*\u00020\u00152\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b*\u0010\u0017J9\u0010,\u001a\u0004\u0018\u00010\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b,\u0010-J9\u0010.\u001a\u0004\u0018\u00010\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b.\u0010-J)\u0010/\u001a\u00020\u001e*\u00020\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u00102J-\u00104\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0011H\u0002¢\u0006\u0004\b4\u00105J-\u00106\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0011H\u0002¢\u0006\u0004\b6\u00105J\u0019\u00108\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u00020\u0011H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u00102J\u000f\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u00102J\u000f\u0010<\u001a\u00020\u0006H\u0002¢\u0006\u0004\b<\u00102J\u000f\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b=\u00102J\u000f\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u00102J\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010?\u001a\u00020\u0011H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u0011H\u0002¢\u0006\u0004\bB\u00109J\u0015\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bC\u0010DJ\u001d\u0010F\u001a\u00020\u00112\f\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bF\u0010GJ\u001d\u0010H\u001a\u00020\u00062\f\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\bH\u0010IJ%\u0010K\u001a\u00020\u00062\f\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010J\u001a\u00020\u0011H\u0002¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\bM\u0010NJ\u0013\u0010O\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\bO\u0010NJ\u001b\u0010Q\u001a\u00020\u0006*\u00020\u00152\u0006\u0010P\u001a\u00020\u001eH\u0002¢\u0006\u0004\bQ\u0010RJ\u001f\u0010U\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\u001eH\u0002¢\u0006\u0004\bU\u0010VJ-\u0010X\u001a\u00020\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010W\u001a\u00020\u0011H\u0002¢\u0006\u0004\bX\u00105J-\u0010[\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010Y\u001a\u00020\u00112\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b[\u0010\\J-\u0010\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010Y\u001a\u00020\u00112\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b\u0001\u0010\\J5\u0010^\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010Y\u001a\u00020\u00112\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010]\u001a\u00020\u0011H\u0002¢\u0006\u0004\b^\u0010_J%\u0010`\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u00112\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b`\u0010aJ\u0017\u0010c\u001a\u00020\u00062\u0006\u0010b\u001a\u00020\u0011H\u0002¢\u0006\u0004\bc\u00109J\u0017\u0010d\u001a\u00020\u00062\u0006\u0010b\u001a\u00020\u0011H\u0002¢\u0006\u0004\bd\u00109J\u001b\u00103\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b3\u0010\rJ&\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00060e2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\u0006H\u0014¢\u0006\u0004\bh\u00102J\u000f\u0010i\u001a\u00020\u0006H\u0014¢\u0006\u0004\bi\u00102J\u0017\u0010k\u001a\u00020\u00062\u0006\u0010j\u001a\u00020\u0011H\u0004¢\u0006\u0004\bk\u00109J\u0017\u0010l\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u0011H\u0000¢\u0006\u0004\bl\u00109J\u0016\u0010n\u001a\b\u0012\u0004\u0012\u00028\u00000mH\u0096\u0002¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020\u0006H\u0014¢\u0006\u0004\bp\u00102J\u0019\u0010s\u001a\u00020\u001e2\b\u0010r\u001a\u0004\u0018\u00010qH\u0016¢\u0006\u0004\bs\u0010tJ\u001d\u0010w\u001a\u00020\u00062\u000e\u0010r\u001a\n\u0018\u00010uj\u0004\u0018\u0001`v¢\u0006\u0004\bw\u0010xJ\u0019\u0010y\u001a\u00020\u001e2\b\u0010r\u001a\u0004\u0018\u00010qH\u0010¢\u0006\u0004\by\u0010tJ!\u0010{\u001a\u00020\u001e2\b\u0010r\u001a\u0004\u0018\u00010q2\u0006\u0010z\u001a\u00020\u001eH\u0014¢\u0006\u0004\b{\u0010|J%\u0010~\u001a\u00020\u00062\u0014\u0010}\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010q\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b~\u0010\u007fJ\u0012\u0010\u0080\u0001\u001a\u00020\u001eH\u0000¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0013\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0015\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bw\u0010\u0085\u0001R/\u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00078\u0000X\u0081\u0004¢\u0006\u0007\n\u0005\b3\u0010\u0086\u0001RU\u0010\u008d\u0001\u001a9\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u0088\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0087\u0001j\u0005\u0018\u0001`\u0089\u00018\u0002X\u0082\u0004¢\u0006\u000f\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u0012\u0005\b\u008c\u0001\u00102R\u0017\u0010\u0090\u0001\u001a\u00020\u00118BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0017\u0010\u0092\u0001\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0081\u0001R\u0017\u0010\u0094\u0001\u001a\u00020q8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0093\u0001R\u001a\u0010\u0096\u0001\u001a\u00020\u001e*\u00020\u00118BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010%R\u001a\u0010\u0098\u0001\u001a\u00020\u001e*\u00020\u00118BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010%R\u0016\u0010J\u001a\u00020\u00118@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u008f\u0001R\u0017\u0010\u009b\u0001\u001a\u00020\u00118@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u008f\u0001R\u0019\u0010\u009d\u0001\u001a\u0004\u0018\u00010q8DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u0093\u0001R\u0017\u0010\u009f\u0001\u001a\u00020q8DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u0093\u0001R\u0017\u0010¡\u0001\u001a\u00020\u001e8TX\u0094\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010\u0081\u0001R\u001e\u0010¤\u0001\u001a\u00020\u001e8VX\u0097\u0004¢\u0006\u000f\u0012\u0005\b£\u0001\u00102\u001a\u0006\b¢\u0001\u0010\u0081\u0001R\u001d\u0010T\u001a\u00020\u001e8VX\u0097\u0004¢\u0006\u000f\u0012\u0005\b¦\u0001\u00102\u001a\u0006\b¥\u0001\u0010\u0081\u0001R\u0015\u0010¨\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0§\u00018\u0002X\u0082\u0004R\r\u0010ª\u0001\u001a\u00030©\u00018\u0002X\u0082\u0004R\u0019\u0010«\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0§\u00018\u0002X\u0082\u0004R\u0015\u0010¬\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0§\u00018\u0002X\u0082\u0004R\r\u0010\u00ad\u0001\u001a\u00030©\u00018\u0002X\u0082\u0004R\u0019\u0010®\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0§\u00018\u0002X\u0082\u0004R\r\u0010¯\u0001\u001a\u00030©\u00018\u0002X\u0082\u0004R\u0019\u0010°\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0§\u00018\u0002X\u0082\u0004R\r\u0010±\u0001\u001a\u00030©\u00018\u0002X\u0082\u0004\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006²\u0001"}, d2 = {"Lkotlinx/coroutines/channels/b;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/d;", "", "capacity", "Lkotlin/Function1;", "Lr8/z;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILc9/l;)V", "element", "d0", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/j;", "segment", "index", "", "s", "o0", "(Lkotlinx/coroutines/channels/j;ILjava/lang/Object;JLv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/x2;", "i0", "(Lkotlinx/coroutines/x2;Lkotlinx/coroutines/channels/j;I)V", "Lkotlinx/coroutines/n;", "cont", "e0", "(Ljava/lang/Object;Lkotlinx/coroutines/n;)V", "", "waiter", "", "closed", "w0", "(Lkotlinx/coroutines/channels/j;ILjava/lang/Object;JLjava/lang/Object;Z)I", "x0", "curSendersAndCloseStatus", "p0", "(J)Z", "curSenders", "t", "q0", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "h0", "r", "u0", "(Lkotlinx/coroutines/channels/j;IJLjava/lang/Object;)Ljava/lang/Object;", "v0", "r0", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/j;I)Z", "C", "()V", "b", "s0", "(Lkotlinx/coroutines/channels/j;IJ)Z", "t0", "nAttempts", "N", "(J)V", "P", "a0", "Z", "Y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "sendersCur", "z", "(J)Lkotlinx/coroutines/channels/j;", "y", "w", "()Lkotlinx/coroutines/channels/j;", "lastSegment", "X", "(Lkotlinx/coroutines/channels/j;)J", "j0", "(Lkotlinx/coroutines/channels/j;)V", "sendersCounter", "v", "(Lkotlinx/coroutines/channels/j;J)V", "k0", "(Lkotlinx/coroutines/x2;)V", "l0", "receiver", "m0", "(Lkotlinx/coroutines/x2;Z)V", "sendersAndCloseStatusCur", "isClosedForReceive", "R", "(JZ)Z", "globalIndex", "Q", IjkMediaMeta.IJKM_KEY_TRACK_ID, "startFrom", "F", "(JLkotlinx/coroutines/channels/j;)Lkotlinx/coroutines/channels/j;", "currentBufferEndCounter", "D", "(JLkotlinx/coroutines/channels/j;J)Lkotlinx/coroutines/channels/j;", "b0", "(JLkotlinx/coroutines/channels/j;)V", "value", "z0", "y0", "Lkotlinx/coroutines/channels/h;", "i", "(Ljava/lang/Object;)Ljava/lang/Object;", "g0", "f0", "globalCellIndex", "B", "A0", "Lkotlinx/coroutines/channels/f;", "iterator", "()Lkotlinx/coroutines/channels/f;", "c0", "", "cause", "g", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "a", "(Ljava/util/concurrent/CancellationException;)V", "u", "cancel", "x", "(Ljava/lang/Throwable;Z)Z", "handler", "d", "(Lc9/l;)V", "M", "()Z", "", "toString", "()Ljava/lang/String;", "I", "Lc9/l;", "Lkotlin/Function3;", "Lxa/b;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "c", "Lc9/q;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "onUndeliveredElementReceiveCancellationConstructor", "G", "()J", "bufferEndCounter", ExifInterface.LONGITUDE_WEST, "isRendezvousOrUnlimited", "()Ljava/lang/Throwable;", "receiveException", "U", "isClosedForSend0", ExifInterface.GPS_DIRECTION_TRUE, "isClosedForReceive0", "L", "J", "receiversCounter", "H", "closeCause", "K", "sendException", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "isConflatedDropOldest", "l", "isClosedForSend$annotations", "isClosedForSend", ExifInterface.LATITUDE_SOUTH, "isClosedForReceive$annotations", "Lkotlinx/atomicfu/AtomicRef;", "_closeCause", "Lkotlinx/atomicfu/AtomicLong;", "bufferEnd", "bufferEndSegment", "closeHandler", "completedExpandBuffersAndPauseFlag", "receiveSegment", "receivers", "sendSegment", "sendersAndCloseStatus", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class b<E> implements d<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f14614d = AtomicLongFieldUpdater.newUpdater(b.class, "sendersAndCloseStatus");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f14615e = AtomicLongFieldUpdater.newUpdater(b.class, "receivers");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f14616f = AtomicLongFieldUpdater.newUpdater(b.class, "bufferEnd");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f14617g = AtomicLongFieldUpdater.newUpdater(b.class, "completedExpandBuffersAndPauseFlag");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14618h = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "sendSegment");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14619i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "receiveSegment");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14620j = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "bufferEndSegment");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14621k = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_closeCause");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14622l = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "closeHandler");
    private volatile Object _closeCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int capacity;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final c9.l<E, z> onUndeliveredElement;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final c9.q<xa.b<?>, Object, Object, c9.l<Throwable, z>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000e\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u0005H\u0096Bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0016\u001a\u00020\u00102\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u0012R\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/b$a;", "Lkotlinx/coroutines/channels/f;", "Lkotlinx/coroutines/x2;", "<init>", "(Lkotlinx/coroutines/channels/b;)V", "", "g", "()Z", "Lkotlinx/coroutines/channels/j;", "segment", "", "index", "", "r", "f", "(Lkotlinx/coroutines/channels/j;IJLv8/f;)Ljava/lang/Object;", "Lr8/z;", "h", "()V", "a", "(Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/c0;", "b", "(Lkotlinx/coroutines/internal/c0;I)V", "next", "()Ljava/lang/Object;", "element", "i", "(Ljava/lang/Object;)Z", "j", "", "Ljava/lang/Object;", "receiveResult", "Lkotlinx/coroutines/o;", "Lkotlinx/coroutines/o;", "continuation", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class a implements f<E>, x2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private Object receiveResult = kotlinx.coroutines.channels.c.f14644p;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private kotlinx.coroutines.o<? super Boolean> continuation;

        public a() {
        }

        private final Object f(j<E> jVar, int i10, long j10, v8.f<? super Boolean> fVar) throws Throwable {
            Boolean boolA;
            c9.l<E, z> lVar;
            v8.j context;
            j jVarE;
            b<E> bVar = b.this;
            kotlinx.coroutines.o oVarB = kotlinx.coroutines.q.b(kotlin.coroutines.intrinsics.b.b(fVar));
            try {
                this.continuation = oVarB;
                try {
                    Object objU0 = bVar.u0(jVar, i10, j10, this);
                    if (objU0 == kotlinx.coroutines.channels.c.f14641m) {
                        bVar.h0(this, jVar, i10);
                    } else {
                        c9.l<Throwable, z> lVarA = null;
                        if (objU0 == kotlinx.coroutines.channels.c.f14643o) {
                            if (j10 < bVar.L()) {
                                jVar.b();
                            }
                            j jVar2 = (j) b.f14619i.get(bVar);
                            while (true) {
                                if (bVar.S()) {
                                    h();
                                } else {
                                    long andIncrement = b.f14615e.getAndIncrement(bVar);
                                    int i11 = kotlinx.coroutines.channels.c.f14630b;
                                    long j11 = andIncrement / ((long) i11);
                                    int i12 = (int) (andIncrement % ((long) i11));
                                    if (jVar2.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String != j11) {
                                        jVarE = bVar.E(j11, jVar2);
                                        if (jVarE == null) {
                                        }
                                    } else {
                                        jVarE = jVar2;
                                    }
                                    objU0 = bVar.u0(jVarE, i12, andIncrement, this);
                                    if (objU0 == kotlinx.coroutines.channels.c.f14641m) {
                                        bVar.h0(this, jVarE, i12);
                                    } else if (objU0 == kotlinx.coroutines.channels.c.f14643o) {
                                        if (andIncrement < bVar.L()) {
                                            jVarE.b();
                                        }
                                        jVar2 = jVarE;
                                    } else {
                                        if (objU0 == kotlinx.coroutines.channels.c.f14642n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        jVarE.b();
                                        this.receiveResult = objU0;
                                        this.continuation = null;
                                        boolA = kotlin.coroutines.jvm.internal.b.a(true);
                                        lVar = bVar.onUndeliveredElement;
                                        if (lVar != null) {
                                            context = oVarB.getContext();
                                            lVarA = x.a(lVar, objU0, context);
                                        }
                                        oVarB.q(boolA, lVarA);
                                    }
                                }
                            }
                        } else {
                            jVar.b();
                            this.receiveResult = objU0;
                            this.continuation = null;
                            boolA = kotlin.coroutines.jvm.internal.b.a(true);
                            lVar = bVar.onUndeliveredElement;
                            if (lVar != null) {
                                context = oVarB.getContext();
                                lVarA = x.a(lVar, objU0, context);
                            }
                            oVarB.q(boolA, lVarA);
                        }
                    }
                    Object objZ = oVarB.z();
                    if (objZ == kotlin.coroutines.intrinsics.b.c()) {
                        kotlin.coroutines.jvm.internal.h.c(fVar);
                    }
                    return objZ;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    oVarB.M();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h() {
            kotlinx.coroutines.o<? super Boolean> oVar = this.continuation;
            kotlin.jvm.internal.m.c(oVar);
            this.continuation = null;
            this.receiveResult = kotlinx.coroutines.channels.c.z();
            Throwable thH = b.this.H();
            if (thH == null) {
                r8.q.Companion companion = r8.q.INSTANCE;
                oVar.resumeWith(r8.q.a(Boolean.FALSE));
            } else {
                r8.q.Companion companion2 = r8.q.INSTANCE;
                oVar.resumeWith(r8.q.a(r8.r.a(thH)));
            }
        }

        @Override // kotlinx.coroutines.channels.f
        public Object a(v8.f<? super Boolean> fVar) {
            b<E> bVar = b.this;
            j<E> jVar = (j) b.f14619i.get(bVar);
            while (!bVar.S()) {
                long andIncrement = b.f14615e.getAndIncrement(bVar);
                int i10 = kotlinx.coroutines.channels.c.f14630b;
                long j10 = andIncrement / ((long) i10);
                int i11 = (int) (andIncrement % ((long) i10));
                if (jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String != j10) {
                    j<E> jVarE = bVar.E(j10, jVar);
                    if (jVarE == null) {
                        continue;
                    } else {
                        jVar = jVarE;
                    }
                }
                Object objU0 = bVar.u0(jVar, i11, andIncrement, null);
                if (objU0 == kotlinx.coroutines.channels.c.f14641m) {
                    throw new IllegalStateException("unreachable");
                }
                if (objU0 != kotlinx.coroutines.channels.c.f14643o) {
                    if (objU0 == kotlinx.coroutines.channels.c.f14642n) {
                        return f(jVar, i11, andIncrement, fVar);
                    }
                    jVar.b();
                    this.receiveResult = objU0;
                    return kotlin.coroutines.jvm.internal.b.a(true);
                }
                if (andIncrement < bVar.L()) {
                    jVar.b();
                }
            }
            return kotlin.coroutines.jvm.internal.b.a(g());
        }

        @Override // kotlinx.coroutines.x2
        public void b(c0<?> segment, int index) {
            kotlinx.coroutines.o<? super Boolean> oVar = this.continuation;
            if (oVar != null) {
                oVar.b(segment, index);
            }
        }

        public final boolean i(E element) {
            kotlinx.coroutines.o<? super Boolean> oVar = this.continuation;
            kotlin.jvm.internal.m.c(oVar);
            this.continuation = null;
            this.receiveResult = element;
            Boolean bool = Boolean.TRUE;
            c9.l<E, z> lVar = b.this.onUndeliveredElement;
            return kotlinx.coroutines.channels.c.B(oVar, bool, lVar != null ? x.a(lVar, element, oVar.getContext()) : null);
        }

        public final void j() {
            kotlinx.coroutines.o<? super Boolean> oVar = this.continuation;
            kotlin.jvm.internal.m.c(oVar);
            this.continuation = null;
            this.receiveResult = kotlinx.coroutines.channels.c.z();
            Throwable thH = b.this.H();
            if (thH == null) {
                r8.q.Companion companion = r8.q.INSTANCE;
                oVar.resumeWith(r8.q.a(Boolean.FALSE));
            } else {
                r8.q.Companion companion2 = r8.q.INSTANCE;
                oVar.resumeWith(r8.q.a(r8.r.a(thH)));
            }
        }

        @Override // kotlinx.coroutines.channels.f
        public E next() throws Throwable {
            E e10 = (E) this.receiveResult;
            if (e10 == kotlinx.coroutines.channels.c.f14644p) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.receiveResult = kotlinx.coroutines.channels.c.f14644p;
            if (e10 != kotlinx.coroutines.channels.c.z()) {
                return e10;
            }
            throw e0.a(b.this.I());
        }

        private final boolean g() throws Throwable {
            this.receiveResult = kotlinx.coroutines.channels.c.z();
            Throwable thH = b.this.H();
            if (thH == null) {
                return false;
            }
            throw e0.a(thH);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/channels/b$b;", "Lkotlinx/coroutines/x2;", "Lkotlinx/coroutines/n;", "", "cont", "Lkotlinx/coroutines/n;", "a", "()Lkotlinx/coroutines/n;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class C0279b implements x2 {
        public final kotlinx.coroutines.n<Boolean> a() {
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\"\u0004\b\u0000\u0010\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lxa/b;", "select", "", "<anonymous parameter 1>", "element", "Lkotlin/Function1;", "", "Lr8/z;", "a", "(Lxa/b;Ljava/lang/Object;Ljava/lang/Object;)Lc9/l;"}, k = 3, mv = {1, 8, 0})
    static final class c extends kotlin.jvm.internal.o implements c9.q<xa.b<?>, Object, Object, c9.l<? super Throwable, ? extends z>> {
        final /* synthetic */ b<E> this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LONGITUDE_EAST, "", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class a extends kotlin.jvm.internal.o implements c9.l<Throwable, z> {
            final /* synthetic */ Object $element;
            final /* synthetic */ xa.b<?> $select;
            final /* synthetic */ b<E> this$0;

            @Override // c9.l
            public /* bridge */ /* synthetic */ z invoke(Throwable th) {
                invoke2(th);
                return z.f17874a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, b<E> bVar, xa.b<?> bVar2) {
                super(1);
                this.$element = obj;
                this.this$0 = bVar;
                this.$select = bVar2;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (this.$element != kotlinx.coroutines.channels.c.z()) {
                    x.b(this.this$0.onUndeliveredElement, this.$element, this.$select.getContext());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(b<E> bVar) {
            super(3);
            this.this$0 = bVar;
        }

        @Override // c9.q
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c9.l<Throwable, z> invoke(xa.b<?> bVar, Object obj, Object obj2) {
            return new a(obj2, this.this$0, bVar);
        }
    }

    private final j<E> D(long id2, j<E> startFrom, long currentBufferEndCounter) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14620j;
        c9.p pVar = (c9.p) kotlinx.coroutines.channels.c.y();
        loop0: while (true) {
            objC = kotlinx.coroutines.internal.d.c(startFrom, id2, pVar);
            if (!d0.c(objC)) {
                c0 c0VarB = d0.b(objC);
                while (true) {
                    c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                    if (c0Var.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String >= c0VarB.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String) {
                        break loop0;
                    }
                    if (!c0VarB.q()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, c0VarB)) {
                        if (!c0Var.m()) {
                            break loop0;
                        }
                        c0Var.k();
                        break loop0;
                    }
                    if (c0VarB.m()) {
                        c0VarB.k();
                    }
                }
            } else {
                break;
            }
        }
        if (d0.c(objC)) {
            A();
            b0(id2, startFrom);
            O(this, 0L, 1, null);
            return null;
        }
        j<E> jVar = (j) d0.b(objC);
        long j10 = jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String;
        if (j10 <= id2) {
            return jVar;
        }
        int i10 = kotlinx.coroutines.channels.c.f14630b;
        if (f14616f.compareAndSet(this, currentBufferEndCounter + 1, j10 * ((long) i10))) {
            N((jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) i10)) - currentBufferEndCounter);
        } else {
            O(this, 0L, 1, null);
        }
        return null;
    }

    private final boolean T(long j10) {
        return R(j10, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U(long j10) {
        return R(j10, false);
    }

    private final void k0(x2 x2Var) {
        m0(x2Var, true);
    }

    private final void l0(x2 x2Var) {
        m0(x2Var, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(j<E> lastSegment, long sendersCounter) {
        Object objB = kotlinx.coroutines.internal.l.b(null, 1, null);
        loop0: while (lastSegment != null) {
            for (int i10 = kotlinx.coroutines.channels.c.f14630b - 1; -1 < i10; i10--) {
                if ((lastSegment.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) kotlinx.coroutines.channels.c.f14630b)) + ((long) i10) < sendersCounter) {
                    break loop0;
                }
                while (true) {
                    Object objW = lastSegment.w(i10);
                    if (objW != null && objW != kotlinx.coroutines.channels.c.f14633e) {
                        if (!(objW instanceof WaiterEB)) {
                            if (!(objW instanceof x2)) {
                                break;
                            }
                            if (lastSegment.r(i10, objW, kotlinx.coroutines.channels.c.z())) {
                                objB = kotlinx.coroutines.internal.l.c(objB, objW);
                                lastSegment.x(i10, true);
                                break;
                            }
                        } else {
                            if (lastSegment.r(i10, objW, kotlinx.coroutines.channels.c.z())) {
                                objB = kotlinx.coroutines.internal.l.c(objB, ((WaiterEB) objW).waiter);
                                lastSegment.x(i10, true);
                                break;
                            }
                        }
                    } else {
                        if (lastSegment.r(i10, objW, kotlinx.coroutines.channels.c.z())) {
                            lastSegment.p();
                            break;
                        }
                    }
                }
            }
            lastSegment = (j) lastSegment.g();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                k0((x2) objB);
                return;
            }
            kotlin.jvm.internal.m.d(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                k0((x2) arrayList.get(size));
            }
        }
    }

    protected boolean V() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.v
    public boolean g(Throwable cause) {
        return x(cause, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j<E> E(long id2, j<E> startFrom) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14619i;
        c9.p pVar = (c9.p) kotlinx.coroutines.channels.c.y();
        loop0: while (true) {
            objC = kotlinx.coroutines.internal.d.c(startFrom, id2, pVar);
            if (!d0.c(objC)) {
                c0 c0VarB = d0.b(objC);
                while (true) {
                    c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                    if (c0Var.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String >= c0VarB.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String) {
                        break loop0;
                    }
                    if (!c0VarB.q()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, c0VarB)) {
                        if (!c0Var.m()) {
                            break loop0;
                        }
                        c0Var.k();
                        break loop0;
                    }
                    if (c0VarB.m()) {
                        c0VarB.k();
                    }
                }
            } else {
                break;
            }
        }
        if (d0.c(objC)) {
            A();
            if (startFrom.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) kotlinx.coroutines.channels.c.f14630b) < L()) {
                startFrom.b();
            }
            return null;
        }
        j<E> jVar = (j) d0.b(objC);
        if (!W() && id2 <= G() / ((long) kotlinx.coroutines.channels.c.f14630b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f14620j;
            while (true) {
                c0 c0Var2 = (c0) atomicReferenceFieldUpdater2.get(this);
                if (c0Var2.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String >= jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String || !jVar.q()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, c0Var2, jVar)) {
                    if (!c0Var2.m()) {
                        break;
                    }
                    c0Var2.k();
                    break;
                }
                if (jVar.m()) {
                    jVar.k();
                }
            }
        }
        long j10 = jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String;
        if (j10 <= id2) {
            return jVar;
        }
        int i10 = kotlinx.coroutines.channels.c.f14630b;
        y0(j10 * ((long) i10));
        if (jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) i10) < L()) {
            jVar.b();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j<E> F(long id2, j<E> startFrom) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14618h;
        c9.p pVar = (c9.p) kotlinx.coroutines.channels.c.y();
        loop0: while (true) {
            objC = kotlinx.coroutines.internal.d.c(startFrom, id2, pVar);
            if (!d0.c(objC)) {
                c0 c0VarB = d0.b(objC);
                while (true) {
                    c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                    if (c0Var.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String >= c0VarB.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String) {
                        break loop0;
                    }
                    if (!c0VarB.q()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, c0VarB)) {
                        if (!c0Var.m()) {
                            break loop0;
                        }
                        c0Var.k();
                        break loop0;
                    }
                    if (c0VarB.m()) {
                        c0VarB.k();
                    }
                }
            } else {
                break;
            }
        }
        if (d0.c(objC)) {
            A();
            if (startFrom.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) kotlinx.coroutines.channels.c.f14630b) < J()) {
                startFrom.b();
            }
            return null;
        }
        j<E> jVar = (j) d0.b(objC);
        long j10 = jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String;
        if (j10 <= id2) {
            return jVar;
        }
        int i10 = kotlinx.coroutines.channels.c.f14630b;
        z0(j10 * ((long) i10));
        if (jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) i10) < J()) {
            jVar.b();
        }
        return null;
    }

    private final long G() {
        return f14616f.get(this);
    }

    private final void N(long nAttempts) {
        if ((f14617g.addAndGet(this, nAttempts) & 4611686018427387904L) != 0) {
            while ((f14617g.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    static /* synthetic */ void O(b bVar, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i10 & 1) != 0) {
            j10 = 1;
        }
        bVar.N(j10);
    }

    private final void P() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14622l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, obj == null ? kotlinx.coroutines.channels.c.f14645q : kotlinx.coroutines.channels.c.f14646r));
        if (obj == null) {
            return;
        }
        ((c9.l) obj).invoke(H());
    }

    private final boolean R(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        int i10 = (int) (sendersAndCloseStatusCur >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            z(sendersAndCloseStatusCur & 1152921504606846975L);
            return (isClosedForReceive && M()) ? false : true;
        }
        if (i10 == 3) {
            y(sendersAndCloseStatusCur & 1152921504606846975L);
            return true;
        }
        throw new IllegalStateException(("unexpected close status: " + i10).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long X(j<E> lastSegment) {
        do {
            int i10 = kotlinx.coroutines.channels.c.f14630b;
            while (true) {
                i10--;
                if (-1 < i10) {
                    long j10 = (lastSegment.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) kotlinx.coroutines.channels.c.f14630b)) + ((long) i10);
                    if (j10 >= J()) {
                        while (true) {
                            Object objW = lastSegment.w(i10);
                            if (objW != null && objW != kotlinx.coroutines.channels.c.f14633e) {
                                if (objW != kotlinx.coroutines.channels.c.f14632d) {
                                    break;
                                }
                                return j10;
                            }
                            if (lastSegment.r(i10, objW, kotlinx.coroutines.channels.c.z())) {
                                lastSegment.p();
                                break;
                            }
                        }
                    } else {
                        return -1L;
                    }
                }
            }
            lastSegment = (j) lastSegment.g();
        } while (lastSegment != null);
        return -1L;
    }

    private final void Y() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14614d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, kotlinx.coroutines.channels.c.w(1152921504606846975L & j10, 1)));
    }

    private final void Z() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14614d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, kotlinx.coroutines.channels.c.w(1152921504606846975L & j10, 3)));
    }

    private final void a0() {
        long j10;
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14614d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 >> 60);
            if (i10 == 0) {
                jW = kotlinx.coroutines.channels.c.w(1152921504606846975L & j10, 2);
            } else if (i10 != 1) {
                return;
            } else {
                jW = kotlinx.coroutines.channels.c.w(1152921504606846975L & j10, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, jW));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b0(long id2, j<E> startFrom) {
        j<E> jVar;
        j<E> jVar2;
        while (startFrom.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String < id2 && (jVar2 = (j) startFrom.e()) != null) {
            startFrom = jVar2;
        }
        while (true) {
            if (!startFrom.h() || (jVar = (j) startFrom.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14620j;
                while (true) {
                    c0 c0Var = (c0) atomicReferenceFieldUpdater.get(this);
                    if (c0Var.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String >= startFrom.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String) {
                        return;
                    }
                    if (!startFrom.q()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c0Var, startFrom)) {
                        if (c0Var.m()) {
                            c0Var.k();
                            return;
                        }
                        return;
                    } else if (startFrom.m()) {
                        startFrom.k();
                    }
                }
            } else {
                startFrom = jVar;
            }
        }
    }

    private final Object d0(E e10, v8.f<? super z> fVar) {
        q0 q0VarD;
        kotlinx.coroutines.o oVar = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.D();
        c9.l<E, z> lVar = this.onUndeliveredElement;
        if (lVar == null || (q0VarD = x.d(lVar, e10, null, 2, null)) == null) {
            Throwable thK = K();
            r8.q.Companion companion = r8.q.INSTANCE;
            oVar.resumeWith(r8.q.a(r8.r.a(thK)));
        } else {
            r8.a.a(q0VarD, K());
            r8.q.Companion companion2 = r8.q.INSTANCE;
            oVar.resumeWith(r8.q.a(r8.r.a(q0VarD)));
        }
        Object objZ = oVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ == kotlin.coroutines.intrinsics.b.c() ? objZ : z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(E element, kotlinx.coroutines.n<? super z> cont) {
        c9.l<E, z> lVar = this.onUndeliveredElement;
        if (lVar != null) {
            x.b(lVar, element, cont.getContext());
        }
        Throwable thK = K();
        r8.q.Companion companion = r8.q.INSTANCE;
        cont.resumeWith(r8.q.a(r8.r.a(thK)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(x2 x2Var, j<E> jVar, int i10) {
        x2Var.b(jVar, i10 + kotlinx.coroutines.channels.c.f14630b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j0(j<E> lastSegment) {
        c9.l<E, z> lVar = this.onUndeliveredElement;
        q0 q0VarC = null;
        Object objB = kotlinx.coroutines.internal.l.b(null, 1, null);
        loop0: do {
            for (int i10 = kotlinx.coroutines.channels.c.f14630b - 1; -1 < i10; i10--) {
                long j10 = (lastSegment.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) kotlinx.coroutines.channels.c.f14630b)) + ((long) i10);
                while (true) {
                    Object objW = lastSegment.w(i10);
                    if (objW == kotlinx.coroutines.channels.c.f14637i) {
                        break loop0;
                    }
                    if (objW != kotlinx.coroutines.channels.c.f14632d) {
                        if (objW != kotlinx.coroutines.channels.c.f14633e && objW != null) {
                            if (!(objW instanceof x2) && !(objW instanceof WaiterEB)) {
                                if (objW != kotlinx.coroutines.channels.c.f14635g && objW != kotlinx.coroutines.channels.c.f14634f) {
                                    if (objW != kotlinx.coroutines.channels.c.f14635g) {
                                        break;
                                    }
                                } else {
                                    break loop0;
                                }
                            } else {
                                if (j10 < J()) {
                                    break loop0;
                                }
                                x2 x2Var = objW instanceof WaiterEB ? ((WaiterEB) objW).waiter : (x2) objW;
                                if (lastSegment.r(i10, objW, kotlinx.coroutines.channels.c.z())) {
                                    if (lVar != null) {
                                        q0VarC = x.c(lVar, lastSegment.v(i10), q0VarC);
                                    }
                                    objB = kotlinx.coroutines.internal.l.c(objB, x2Var);
                                    lastSegment.s(i10);
                                    lastSegment.p();
                                    break;
                                }
                            }
                        } else {
                            if (lastSegment.r(i10, objW, kotlinx.coroutines.channels.c.z())) {
                                lastSegment.p();
                                break;
                            }
                        }
                    } else {
                        if (j10 < J()) {
                            break loop0;
                        }
                        if (lastSegment.r(i10, objW, kotlinx.coroutines.channels.c.z())) {
                            if (lVar != null) {
                                q0VarC = x.c(lVar, lastSegment.v(i10), q0VarC);
                            }
                            lastSegment.s(i10);
                            lastSegment.p();
                            break;
                        }
                    }
                }
            }
            lastSegment = (j) lastSegment.g();
        } while (lastSegment != null);
        if (objB != null) {
            if (objB instanceof ArrayList) {
                kotlin.jvm.internal.m.d(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                ArrayList arrayList = (ArrayList) objB;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    l0((x2) arrayList.get(size));
                }
            } else {
                l0((x2) objB);
            }
        }
        if (q0VarC != null) {
            throw q0VarC;
        }
    }

    private final void m0(x2 x2Var, boolean z10) {
        if (x2Var instanceof C0279b) {
            kotlinx.coroutines.n<Boolean> nVarA = ((C0279b) x2Var).a();
            r8.q.Companion companion = r8.q.INSTANCE;
            nVarA.resumeWith(r8.q.a(Boolean.FALSE));
            return;
        }
        if (x2Var instanceof kotlinx.coroutines.n) {
            v8.f fVar = (v8.f) x2Var;
            r8.q.Companion companion2 = r8.q.INSTANCE;
            fVar.resumeWith(r8.q.a(r8.r.a(z10 ? I() : K())));
        } else if (x2Var instanceof t) {
            kotlinx.coroutines.o<h<? extends E>> oVar = ((t) x2Var).cont;
            r8.q.Companion companion3 = r8.q.INSTANCE;
            oVar.resumeWith(r8.q.a(h.b(h.INSTANCE.a(H()))));
        } else if (x2Var instanceof a) {
            ((a) x2Var).j();
        } else {
            if (x2Var instanceof xa.b) {
                ((xa.b) x2Var).a(this, kotlinx.coroutines.channels.c.z());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + x2Var).toString());
        }
    }

    private final boolean q0(Object obj, E e10) {
        if (obj instanceof xa.b) {
            return ((xa.b) obj).a(this, e10);
        }
        if (obj instanceof t) {
            kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            t tVar = (t) obj;
            kotlinx.coroutines.o<h<? extends E>> oVar = tVar.cont;
            h hVarB = h.b(h.INSTANCE.c(e10));
            c9.l<E, z> lVar = this.onUndeliveredElement;
            return kotlinx.coroutines.channels.c.B(oVar, hVarB, lVar != null ? x.a(lVar, e10, tVar.cont.getContext()) : null);
        }
        if (obj instanceof a) {
            kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(e10);
        }
        if (obj instanceof kotlinx.coroutines.n) {
            kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            kotlinx.coroutines.n nVar = (kotlinx.coroutines.n) obj;
            c9.l<E, z> lVar2 = this.onUndeliveredElement;
            return kotlinx.coroutines.channels.c.B(nVar, e10, lVar2 != null ? x.a(lVar2, e10, nVar.getContext()) : null);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    private final boolean r0(Object obj, j<E> jVar, int i10) {
        if (obj instanceof kotlinx.coroutines.n) {
            kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return kotlinx.coroutines.channels.c.C((kotlinx.coroutines.n) obj, z.f17874a, null, 2, null);
        }
        if (obj instanceof xa.b) {
            kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            xa.d dVarG = ((xa.a) obj).g(this, z.f17874a);
            if (dVarG == xa.d.REREGISTER) {
                jVar.s(i10);
            }
            return dVarG == xa.d.SUCCESSFUL;
        }
        if (obj instanceof C0279b) {
            return kotlinx.coroutines.channels.c.C(((C0279b) obj).a(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final j<E> w() {
        Object obj = f14620j.get(this);
        j jVar = (j) f14618h.get(this);
        if (jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String > ((j) obj).tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String) {
            obj = jVar;
        }
        j jVar2 = (j) f14619i.get(this);
        if (jVar2.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String > ((j) obj).tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String) {
            obj = jVar2;
        }
        return (j) kotlinx.coroutines.internal.d.b((kotlinx.coroutines.internal.e) obj);
    }

    private final void y0(long value) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14615e;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if (j10 >= value) {
                return;
            }
            long j11 = value;
            if (f14615e.compareAndSet(this, j10, j11)) {
                return;
            } else {
                value = j11;
            }
        }
    }

    private final void z0(long value) {
        long j10;
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14614d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            j11 = 1152921504606846975L & j10;
            if (j11 >= value) {
                return;
            }
        } while (!f14614d.compareAndSet(this, j10, kotlinx.coroutines.channels.c.w(j11, (int) (j10 >> 60))));
    }

    public final void A0(long globalIndex) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        b<E> bVar = this;
        if (bVar.W()) {
            return;
        }
        while (bVar.G() <= globalIndex) {
            bVar = this;
        }
        int i10 = kotlinx.coroutines.channels.c.f14631c;
        for (int i11 = 0; i11 < i10; i11++) {
            long jG = bVar.G();
            if (jG == (4611686018427387903L & f14617g.get(bVar)) && jG == bVar.G()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f14617g;
        while (true) {
            long j10 = atomicLongFieldUpdater2.get(bVar);
            if (atomicLongFieldUpdater2.compareAndSet(bVar, j10, kotlinx.coroutines.channels.c.v(j10 & 4611686018427387903L, true))) {
                break;
            } else {
                bVar = this;
            }
        }
        while (true) {
            long jG2 = bVar.G();
            atomicLongFieldUpdater = f14617g;
            long j11 = atomicLongFieldUpdater.get(bVar);
            long j12 = j11 & 4611686018427387903L;
            boolean z10 = (4611686018427387904L & j11) != 0;
            if (jG2 == j12 && jG2 == bVar.G()) {
                break;
            }
            if (z10) {
                bVar = this;
            } else {
                bVar = this;
                atomicLongFieldUpdater.compareAndSet(bVar, j11, kotlinx.coroutines.channels.c.v(j12, true));
            }
        }
        while (true) {
            long j13 = atomicLongFieldUpdater.get(bVar);
            if (atomicLongFieldUpdater.compareAndSet(bVar, j13, kotlinx.coroutines.channels.c.v(j13 & 4611686018427387903L, false))) {
                return;
            } else {
                bVar = this;
            }
        }
    }

    protected final void B(long globalCellIndex) {
        q0 q0VarD;
        j<E> jVar = (j) f14619i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f14615e;
            long j10 = atomicLongFieldUpdater.get(this);
            if (globalCellIndex < Math.max(((long) this.capacity) + j10, G())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j10, 1 + j10)) {
                int i10 = kotlinx.coroutines.channels.c.f14630b;
                long j11 = j10 / ((long) i10);
                int i11 = (int) (j10 % ((long) i10));
                if (jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String != j11) {
                    j<E> jVarE = E(j11, jVar);
                    if (jVarE == null) {
                        continue;
                    } else {
                        jVar = jVarE;
                    }
                }
                j<E> jVar2 = jVar;
                Object objU0 = u0(jVar2, i11, j10, null);
                if (objU0 != kotlinx.coroutines.channels.c.f14643o) {
                    jVar2.b();
                    c9.l<E, z> lVar = this.onUndeliveredElement;
                    if (lVar != null && (q0VarD = x.d(lVar, objU0, null, 2, null)) != null) {
                        throw q0VarD;
                    }
                } else if (j10 < L()) {
                    jVar2.b();
                }
                jVar = jVar2;
            }
        }
    }

    protected final Throwable H() {
        return (Throwable) f14621k.get(this);
    }

    public final long J() {
        return f14615e.get(this);
    }

    public final long L() {
        return f14614d.get(this) & 1152921504606846975L;
    }

    public final boolean M() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14619i;
            j<E> jVarE = (j) atomicReferenceFieldUpdater.get(this);
            long J = J();
            if (L() <= J) {
                return false;
            }
            int i10 = kotlinx.coroutines.channels.c.f14630b;
            long j10 = J / ((long) i10);
            if (jVarE.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String == j10 || (jVarE = E(j10, jVarE)) != null) {
                jVarE.b();
                if (Q(jVarE, (int) (J % ((long) i10)), J)) {
                    return true;
                }
                f14615e.compareAndSet(this, J, J + 1);
            } else if (((j) atomicReferenceFieldUpdater.get(this)).tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String < j10) {
                return false;
            }
        }
    }

    public boolean S() {
        return T(f14614d.get(this));
    }

    @Override // kotlinx.coroutines.channels.v
    public void d(c9.l<? super Throwable, z> handler) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14622l;
        if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, null, handler)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != kotlinx.coroutines.channels.c.f14645q) {
                if (obj == kotlinx.coroutines.channels.c.f14646r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!androidx.concurrent.futures.a.a(f14622l, this, kotlinx.coroutines.channels.c.f14645q, kotlinx.coroutines.channels.c.f14646r));
        handler.invoke(H());
    }

    @Override // kotlinx.coroutines.channels.v
    public Object i(E element) {
        j jVarF;
        if (p0(f14614d.get(this))) {
            return h.INSTANCE.b();
        }
        Object obj = kotlinx.coroutines.channels.c.f14638j;
        j jVar = (j) f14618h.get(this);
        while (true) {
            long andIncrement = f14614d.getAndIncrement(this);
            long j10 = 1152921504606846975L & andIncrement;
            boolean zU = U(andIncrement);
            int i10 = kotlinx.coroutines.channels.c.f14630b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String != j11) {
                jVarF = F(j11, jVar);
                if (jVarF == null) {
                    if (zU) {
                        return h.INSTANCE.a(K());
                    }
                }
            } else {
                jVarF = jVar;
            }
            E e10 = element;
            int iW0 = w0(jVarF, i11, e10, j10, obj, zU);
            jVar = jVarF;
            if (iW0 == 0) {
                jVar.b();
                return h.INSTANCE.c(z.f17874a);
            }
            if (iW0 == 1) {
                return h.INSTANCE.c(z.f17874a);
            }
            if (iW0 == 2) {
                if (zU) {
                    jVar.p();
                    return h.INSTANCE.a(K());
                }
                x2 x2Var = obj instanceof x2 ? (x2) obj : null;
                if (x2Var != null) {
                    i0(x2Var, jVar, i11);
                }
                jVar.p();
                return h.INSTANCE.b();
            }
            if (iW0 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iW0 == 4) {
                if (j10 < J()) {
                    jVar.b();
                }
                return h.INSTANCE.a(K());
            }
            if (iW0 == 5) {
                jVar.b();
            }
            element = e10;
        }
    }

    @Override // kotlinx.coroutines.channels.u
    public f<E> iterator() {
        return new a();
    }

    @Override // kotlinx.coroutines.channels.v
    public boolean l() {
        return U(f14614d.get(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        String string;
        StringBuilder sb2 = new StringBuilder();
        int i10 = (int) (f14614d.get(this) >> 60);
        if (i10 == 2) {
            sb2.append("closed,");
        } else if (i10 == 3) {
            sb2.append("cancelled,");
        }
        sb2.append("capacity=" + this.capacity + ',');
        sb2.append("data=[");
        List listO = kotlin.collections.r.o(f14619i.get(this), f14618h.get(this), f14620j.get(this));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listO) {
            if (((j) obj) != kotlinx.coroutines.channels.c.f14629a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j10 = ((j) next).tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String;
            do {
                Object next2 = it.next();
                long j11 = ((j) next2).tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String;
                if (j10 > j11) {
                    next = next2;
                    j10 = j11;
                }
            } while (it.hasNext());
        }
        j jVar = (j) next;
        long J = J();
        long jL = L();
        loop2: do {
            int i11 = kotlinx.coroutines.channels.c.f14630b;
            for (int i12 = 0; i12 < i11; i12++) {
                long j12 = (jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String * ((long) kotlinx.coroutines.channels.c.f14630b)) + ((long) i12);
                if (j12 >= jL && j12 >= J) {
                    break loop2;
                }
                Object objW = jVar.w(i12);
                Object objV = jVar.v(i12);
                if (objW instanceof kotlinx.coroutines.n) {
                    string = (j12 >= J || j12 < jL) ? (j12 >= jL || j12 < J) ? "cont" : "send" : "receive";
                } else if (objW instanceof xa.b) {
                    string = (j12 >= J || j12 < jL) ? (j12 >= jL || j12 < J) ? "select" : "onSend" : "onReceive";
                } else if (objW instanceof t) {
                    string = "receiveCatching";
                } else if (objW instanceof C0279b) {
                    string = "sendBroadcast";
                } else if (objW instanceof WaiterEB) {
                    string = "EB(" + objW + ')';
                } else if (kotlin.jvm.internal.m.a(objW, kotlinx.coroutines.channels.c.f14634f) ? true : kotlin.jvm.internal.m.a(objW, kotlinx.coroutines.channels.c.f14635g)) {
                    string = "resuming_sender";
                } else {
                    if (!(objW == null ? true : kotlin.jvm.internal.m.a(objW, kotlinx.coroutines.channels.c.f14633e) ? true : kotlin.jvm.internal.m.a(objW, kotlinx.coroutines.channels.c.f14637i) ? true : kotlin.jvm.internal.m.a(objW, kotlinx.coroutines.channels.c.f14636h) ? true : kotlin.jvm.internal.m.a(objW, kotlinx.coroutines.channels.c.f14639k) ? true : kotlin.jvm.internal.m.a(objW, kotlinx.coroutines.channels.c.f14638j) ? true : kotlin.jvm.internal.m.a(objW, kotlinx.coroutines.channels.c.z()))) {
                        string = objW.toString();
                    }
                }
                if (objV != null) {
                    sb2.append('(' + string + ',' + objV + "),");
                } else {
                    sb2.append(string + ',');
                }
            }
            jVar = (j) jVar.e();
        } while (jVar != null);
        if (ua.n.U0(sb2) == ',') {
            kotlin.jvm.internal.m.e(sb2.deleteCharAt(sb2.length() - 1), "this.deleteCharAt(index)");
        }
        sb2.append("]");
        return sb2.toString();
    }

    public boolean u(Throwable cause) {
        if (cause == null) {
            cause = new CancellationException("Channel was cancelled");
        }
        return x(cause, true);
    }

    protected boolean x(Throwable cause, boolean cancel) {
        if (cancel) {
            Y();
        }
        boolean zA = androidx.concurrent.futures.a.a(f14621k, this, kotlinx.coroutines.channels.c.f14647s, cause);
        if (cancel) {
            Z();
        } else {
            a0();
        }
        A();
        c0();
        if (zA) {
            P();
        }
        return zA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(int i10, c9.l<? super E, z> lVar) {
        c cVar;
        this.capacity = i10;
        this.onUndeliveredElement = lVar;
        if (i10 >= 0) {
            this.bufferEnd = kotlinx.coroutines.channels.c.A(i10);
            this.completedExpandBuffersAndPauseFlag = G();
            j jVar = new j(0L, null, this, 3);
            this.sendSegment = jVar;
            this.receiveSegment = jVar;
            if (W()) {
                jVar = kotlinx.coroutines.channels.c.f14629a;
                kotlin.jvm.internal.m.d(jVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = jVar;
            if (lVar != 0) {
                cVar = new c(this);
            } else {
                cVar = null;
            }
            this.onUndeliveredElementReceiveCancellationConstructor = cVar;
            this._closeCause = kotlinx.coroutines.channels.c.f14647s;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i10 + ", should be >=0").toString());
    }

    private final void A() {
        l();
    }

    private final void C() {
        if (W()) {
            return;
        }
        j<E> jVar = (j) f14620j.get(this);
        while (true) {
            long andIncrement = f14616f.getAndIncrement(this);
            int i10 = kotlinx.coroutines.channels.c.f14630b;
            long j10 = andIncrement / ((long) i10);
            if (L() <= andIncrement) {
                if (jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String < j10 && jVar.e() != 0) {
                    b0(j10, jVar);
                }
                O(this, 0L, 1, null);
                return;
            }
            if (jVar.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String != j10) {
                j<E> jVarD = D(j10, jVar, andIncrement);
                if (jVarD == null) {
                    continue;
                } else {
                    jVar = jVarD;
                }
            }
            if (s0(jVar, (int) (andIncrement % ((long) i10)), andIncrement)) {
                O(this, 0L, 1, null);
                return;
            }
            O(this, 0L, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable I() {
        Throwable thH = H();
        if (thH == null) {
            return new n("Channel was closed");
        }
        return thH;
    }

    private final boolean Q(j<E> segment, int index, long globalIndex) {
        Object objW;
        do {
            objW = segment.w(index);
            if (objW != null && objW != kotlinx.coroutines.channels.c.f14633e) {
                if (objW == kotlinx.coroutines.channels.c.f14632d) {
                    return true;
                }
                if (objW == kotlinx.coroutines.channels.c.f14638j || objW == kotlinx.coroutines.channels.c.z() || objW == kotlinx.coroutines.channels.c.f14637i || objW == kotlinx.coroutines.channels.c.f14636h) {
                    return false;
                }
                if (objW == kotlinx.coroutines.channels.c.f14635g) {
                    return true;
                }
                if (objW == kotlinx.coroutines.channels.c.f14634f || globalIndex != J()) {
                    return false;
                }
                return true;
            }
        } while (!segment.r(index, objW, kotlinx.coroutines.channels.c.f14636h));
        C();
        return false;
    }

    private final boolean W() {
        long jG = G();
        if (jG != 0 && jG != LocationRequestCompat.PASSIVE_INTERVAL) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(x2 x2Var, j<E> jVar, int i10) {
        g0();
        x2Var.b(jVar, i10);
    }

    static /* synthetic */ <E> Object n0(b<E> bVar, E e10, v8.f<? super z> fVar) {
        j<E> jVar;
        j<E> jVar2 = (j) f14618h.get(bVar);
        while (true) {
            long andIncrement = f14614d.getAndIncrement(bVar);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zU = bVar.U(andIncrement);
            int i10 = kotlinx.coroutines.channels.c.f14630b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (jVar2.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String != j11) {
                j<E> jVarF = bVar.F(j11, jVar2);
                if (jVarF == null) {
                    if (zU) {
                        Object objD0 = bVar.d0(e10, fVar);
                        if (objD0 != kotlin.coroutines.intrinsics.b.c()) {
                            break;
                        }
                        return objD0;
                    }
                } else {
                    jVar = jVarF;
                }
            } else {
                jVar = jVar2;
            }
            b<E> bVar2 = bVar;
            E e11 = e10;
            int iW0 = bVar2.w0(jVar, i11, e11, j10, null, zU);
            if (iW0 != 0) {
                if (iW0 != 1) {
                    if (iW0 != 2) {
                        if (iW0 != 3) {
                            if (iW0 != 4) {
                                if (iW0 == 5) {
                                    jVar.b();
                                }
                                bVar = bVar2;
                                jVar2 = jVar;
                                e10 = e11;
                            } else {
                                if (j10 < bVar2.J()) {
                                    jVar.b();
                                }
                                Object objD1 = bVar2.d0(e11, fVar);
                                if (objD1 != kotlin.coroutines.intrinsics.b.c()) {
                                    break;
                                }
                                return objD1;
                            }
                        } else {
                            Object objO0 = bVar2.o0(jVar, i11, e11, j10, fVar);
                            if (objO0 != kotlin.coroutines.intrinsics.b.c()) {
                                break;
                            }
                            return objO0;
                        }
                    } else {
                        if (!zU) {
                            break;
                        }
                        jVar.p();
                        Object objD2 = bVar2.d0(e11, fVar);
                        if (objD2 != kotlin.coroutines.intrinsics.b.c()) {
                            break;
                        }
                        return objD2;
                    }
                } else {
                    break;
                }
            } else {
                jVar.b();
                break;
            }
        }
        return z.f17874a;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:67:0x0100 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x0101  */
    private final Object o0(j<E> jVar, int i10, E e10, long j10, v8.f<? super z> fVar) {
        z zVar;
        Object objZ;
        j jVarF;
        kotlinx.coroutines.o oVar;
        kotlinx.coroutines.o oVarB = kotlinx.coroutines.q.b(kotlin.coroutines.intrinsics.b.b(fVar));
        try {
            int iW0 = w0(jVar, i10, e10, j10, oVarB, false);
            if (iW0 != 0) {
                if (iW0 != 1) {
                    if (iW0 == 2) {
                        i0(oVarB, jVar, i10);
                    } else {
                        if (iW0 != 4) {
                            String str = "unexpected";
                            if (iW0 == 5) {
                                jVar.b();
                                j jVar2 = (j) f14618h.get(this);
                                while (true) {
                                    long andIncrement = f14614d.getAndIncrement(this);
                                    long j11 = 1152921504606846975L & andIncrement;
                                    boolean zU = U(andIncrement);
                                    int i11 = kotlinx.coroutines.channels.c.f14630b;
                                    long j12 = j11 / ((long) i11);
                                    int i12 = (int) (j11 % ((long) i11));
                                    str = str;
                                    if (jVar2.tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_TRACK_ID java.lang.String != j12) {
                                        jVarF = F(j12, jVar2);
                                        if (jVarF == null) {
                                            if (zU) {
                                            }
                                        }
                                    } else {
                                        jVarF = jVar2;
                                    }
                                    int iW1 = w0(jVarF, i12, e10, j11, oVarB, zU);
                                    if (iW1 != 0) {
                                        if (iW1 != 1) {
                                            if (iW1 != 2) {
                                                if (iW1 != 3) {
                                                    if (iW1 != 4) {
                                                        if (iW1 == 5) {
                                                            jVarF.b();
                                                        }
                                                        jVar2 = jVarF;
                                                    } else if (j11 < J()) {
                                                        jVarF.b();
                                                    }
                                                } else {
                                                    throw new IllegalStateException(str);
                                                }
                                            } else if (zU) {
                                                jVarF.p();
                                            } else {
                                                if (androidx.view.k.a(oVarB)) {
                                                    oVar = oVarB;
                                                } else {
                                                    oVar = null;
                                                }
                                                if (oVar == null) {
                                                    break;
                                                }
                                                i0(oVar, jVarF, i12);
                                                break;
                                            }
                                        } else {
                                            r8.q.Companion companion = r8.q.INSTANCE;
                                            zVar = z.f17874a;
                                        }
                                    } else {
                                        jVarF.b();
                                        r8.q.Companion companion2 = r8.q.INSTANCE;
                                        zVar = z.f17874a;
                                    }
                                }
                            } else {
                                throw new IllegalStateException("unexpected");
                            }
                        } else if (j10 < J()) {
                            jVar.b();
                        }
                        e0(e10, oVarB);
                        break;
                    }
                    objZ = oVarB.z();
                    if (objZ == kotlin.coroutines.intrinsics.b.c()) {
                        kotlin.coroutines.jvm.internal.h.c(fVar);
                    }
                    if (objZ == kotlin.coroutines.intrinsics.b.c()) {
                        return objZ;
                    }
                    return z.f17874a;
                }
                r8.q.Companion companion3 = r8.q.INSTANCE;
                zVar = z.f17874a;
            } else {
                jVar.b();
                r8.q.Companion companion4 = r8.q.INSTANCE;
                zVar = z.f17874a;
            }
            oVarB.resumeWith(r8.q.a(zVar));
            objZ = oVarB.z();
            if (objZ == kotlin.coroutines.intrinsics.b.c()) {
                kotlin.coroutines.jvm.internal.h.c(fVar);
            }
            if (objZ == kotlin.coroutines.intrinsics.b.c()) {
                return objZ;
            }
            return z.f17874a;
        } catch (Throwable th) {
            oVarB.M();
            throw th;
        }
    }

    private final boolean p0(long curSendersAndCloseStatus) {
        if (U(curSendersAndCloseStatus)) {
            return false;
        }
        return !t(curSendersAndCloseStatus & 1152921504606846975L);
    }

    private final boolean s0(j<E> segment, int index, long b10) {
        Object objW = segment.w(index);
        if ((objW instanceof x2) && b10 >= f14615e.get(this) && segment.r(index, objW, kotlinx.coroutines.channels.c.f14635g)) {
            if (r0(objW, segment, index)) {
                segment.A(index, kotlinx.coroutines.channels.c.f14632d);
                return true;
            }
            segment.A(index, kotlinx.coroutines.channels.c.f14638j);
            segment.x(index, false);
            return false;
        }
        return t0(segment, index, b10);
    }

    private final boolean t(long curSenders) {
        if (curSenders >= G() && curSenders >= J() + ((long) this.capacity)) {
            return false;
        }
        return true;
    }

    private final boolean t0(j<E> segment, int index, long b10) {
        while (true) {
            Object objW = segment.w(index);
            if (objW instanceof x2) {
                if (b10 < f14615e.get(this)) {
                    if (segment.r(index, objW, new WaiterEB((x2) objW))) {
                        return true;
                    }
                } else if (segment.r(index, objW, kotlinx.coroutines.channels.c.f14635g)) {
                    if (r0(objW, segment, index)) {
                        segment.A(index, kotlinx.coroutines.channels.c.f14632d);
                        return true;
                    }
                    segment.A(index, kotlinx.coroutines.channels.c.f14638j);
                    segment.x(index, false);
                    return false;
                }
            } else {
                if (objW == kotlinx.coroutines.channels.c.f14638j) {
                    return false;
                }
                if (objW == null) {
                    if (segment.r(index, objW, kotlinx.coroutines.channels.c.f14633e)) {
                        return true;
                    }
                } else {
                    if (objW == kotlinx.coroutines.channels.c.f14632d || objW == kotlinx.coroutines.channels.c.f14636h || objW == kotlinx.coroutines.channels.c.f14637i || objW == kotlinx.coroutines.channels.c.f14639k || objW == kotlinx.coroutines.channels.c.z()) {
                        return true;
                    }
                    if (objW != kotlinx.coroutines.channels.c.f14634f) {
                        throw new IllegalStateException(("Unexpected cell state: " + objW).toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u0(j<E> segment, int index, long r10, Object waiter) {
        Object objW = segment.w(index);
        if (objW == null) {
            if (r10 >= (f14614d.get(this) & 1152921504606846975L)) {
                if (waiter == null) {
                    return kotlinx.coroutines.channels.c.f14642n;
                }
                if (segment.r(index, objW, waiter)) {
                    C();
                    return kotlinx.coroutines.channels.c.f14641m;
                }
            }
        } else if (objW == kotlinx.coroutines.channels.c.f14632d && segment.r(index, objW, kotlinx.coroutines.channels.c.f14637i)) {
            C();
            return segment.y(index);
        }
        return v0(segment, index, r10, waiter);
    }

    private final Object v0(j<E> segment, int index, long r10, Object waiter) {
        while (true) {
            Object objW = segment.w(index);
            if (objW != null && objW != kotlinx.coroutines.channels.c.f14633e) {
                if (objW == kotlinx.coroutines.channels.c.f14632d) {
                    if (segment.r(index, objW, kotlinx.coroutines.channels.c.f14637i)) {
                        C();
                        return segment.y(index);
                    }
                } else {
                    if (objW != kotlinx.coroutines.channels.c.f14638j && objW != kotlinx.coroutines.channels.c.f14636h) {
                        if (objW == kotlinx.coroutines.channels.c.z()) {
                            C();
                            return kotlinx.coroutines.channels.c.f14643o;
                        }
                        if (objW != kotlinx.coroutines.channels.c.f14635g && segment.r(index, objW, kotlinx.coroutines.channels.c.f14634f)) {
                            boolean z10 = objW instanceof WaiterEB;
                            if (z10) {
                                objW = ((WaiterEB) objW).waiter;
                            }
                            if (r0(objW, segment, index)) {
                                segment.A(index, kotlinx.coroutines.channels.c.f14637i);
                                C();
                                return segment.y(index);
                            }
                            segment.A(index, kotlinx.coroutines.channels.c.f14638j);
                            segment.x(index, false);
                            if (z10) {
                                C();
                            }
                            return kotlinx.coroutines.channels.c.f14643o;
                        }
                    }
                    return kotlinx.coroutines.channels.c.f14643o;
                }
            } else if (r10 < (f14614d.get(this) & 1152921504606846975L)) {
                if (segment.r(index, objW, kotlinx.coroutines.channels.c.f14636h)) {
                    C();
                    return kotlinx.coroutines.channels.c.f14643o;
                }
            } else {
                if (waiter == null) {
                    return kotlinx.coroutines.channels.c.f14642n;
                }
                if (segment.r(index, objW, waiter)) {
                    C();
                    return kotlinx.coroutines.channels.c.f14641m;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int w0(j<E> segment, int index, E element, long s10, Object waiter, boolean closed) {
        segment.B(index, element);
        if (closed) {
            return x0(segment, index, element, s10, waiter, closed);
        }
        Object objW = segment.w(index);
        if (objW == null) {
            if (t(s10)) {
                if (segment.r(index, null, kotlinx.coroutines.channels.c.f14632d)) {
                    return 1;
                }
            } else {
                if (waiter == null) {
                    return 3;
                }
                if (segment.r(index, null, waiter)) {
                    return 2;
                }
            }
        } else if (objW instanceof x2) {
            segment.s(index);
            if (q0(objW, element)) {
                segment.A(index, kotlinx.coroutines.channels.c.f14637i);
                f0();
                return 0;
            }
            if (segment.t(index, kotlinx.coroutines.channels.c.f14639k) != kotlinx.coroutines.channels.c.f14639k) {
                segment.x(index, true);
                return 5;
            }
            return 5;
        }
        return x0(segment, index, element, s10, waiter, closed);
    }

    private final int x0(j<E> segment, int index, E element, long s10, Object waiter, boolean closed) {
        while (true) {
            Object objW = segment.w(index);
            if (objW == null) {
                if (t(s10) && !closed) {
                    if (segment.r(index, null, kotlinx.coroutines.channels.c.f14632d)) {
                        return 1;
                    }
                } else if (closed) {
                    if (segment.r(index, null, kotlinx.coroutines.channels.c.f14638j)) {
                        segment.x(index, false);
                        return 4;
                    }
                } else {
                    if (waiter == null) {
                        return 3;
                    }
                    if (segment.r(index, null, waiter)) {
                        return 2;
                    }
                }
            } else if (objW == kotlinx.coroutines.channels.c.f14633e) {
                if (segment.r(index, objW, kotlinx.coroutines.channels.c.f14632d)) {
                    return 1;
                }
            } else {
                if (objW == kotlinx.coroutines.channels.c.f14639k) {
                    segment.s(index);
                    return 5;
                }
                if (objW == kotlinx.coroutines.channels.c.f14636h) {
                    segment.s(index);
                    return 5;
                }
                if (objW == kotlinx.coroutines.channels.c.z()) {
                    segment.s(index);
                    A();
                    return 4;
                }
                segment.s(index);
                if (objW instanceof WaiterEB) {
                    objW = ((WaiterEB) objW).waiter;
                }
                if (q0(objW, element)) {
                    segment.A(index, kotlinx.coroutines.channels.c.f14637i);
                    f0();
                    return 0;
                }
                if (segment.t(index, kotlinx.coroutines.channels.c.f14639k) != kotlinx.coroutines.channels.c.f14639k) {
                    segment.x(index, true);
                }
                return 5;
            }
        }
    }

    private final void y(long sendersCur) {
        j0(z(sendersCur));
    }

    private final j<E> z(long sendersCur) {
        j<E> jVarW = w();
        if (V()) {
            long jX = X(jVarW);
            if (jX != -1) {
                B(jX);
            }
        }
        v(jVarW, sendersCur);
        return jVarW;
    }

    protected final Throwable K() {
        Throwable thH = H();
        if (thH == null) {
            return new o("Channel was closed");
        }
        return thH;
    }

    @Override // kotlinx.coroutines.channels.u
    public final void a(CancellationException cause) {
        u(cause);
    }

    @Override // kotlinx.coroutines.channels.v
    public Object b(E e10, v8.f<? super z> fVar) {
        return n0(this, e10, fVar);
    }

    @Override // kotlinx.coroutines.channels.v
    public boolean offer(E e10) {
        return d.a.a(this, e10);
    }

    protected void c0() {
    }

    protected void f0() {
    }

    protected void g0() {
    }
}
