package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0005nª\u0001«\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\u0014*\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b$\u0010!J\u0019\u0010&\u001a\u00020%2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b&\u0010'J1\u0010-\u001a\u00020,2\u0018\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00140(j\u0002`)2\u0006\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010.J'\u00101\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00100\u001a\u00020,H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u000203H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020,H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0004H\u0002¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b@\u0010=J\u0019\u0010A\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\t\u001a\u00020\u0017H\u0002¢\u0006\u0004\bA\u0010BJ\u001f\u0010C\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\bC\u0010DJ%\u0010E\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bE\u0010FJ#\u0010G\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bG\u0010HJ\u0019\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010\t\u001a\u00020\u0017H\u0002¢\u0006\u0004\bJ\u0010KJ*\u0010M\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010L\u001a\u00020I2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0082\u0010¢\u0006\u0004\bM\u0010NJ)\u0010P\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010O\u001a\u00020I2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\u0004\u0018\u00010I*\u00020RH\u0002¢\u0006\u0004\bS\u0010TJ\u0019\u0010V\u001a\u00020U2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\bV\u0010WJ\u0015\u0010X\u001a\u0004\u0018\u00010\nH\u0082@ø\u0001\u0000¢\u0006\u0004\bX\u0010;J\u0019\u0010Z\u001a\u00020\u00142\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0004¢\u0006\u0004\bZ\u0010[J\r\u0010\\\u001a\u00020\u0004¢\u0006\u0004\b\\\u00109J\u000f\u0010]\u001a\u00020\u0014H\u0014¢\u0006\u0004\b]\u0010^J\u0011\u0010a\u001a\u00060_j\u0002``¢\u0006\u0004\ba\u0010bJ#\u0010d\u001a\u00060_j\u0002``*\u00020\u000f2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010UH\u0004¢\u0006\u0004\bd\u0010eJ'\u0010g\u001a\u00020f2\u0018\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00140(j\u0002`)¢\u0006\u0004\bg\u0010hJ7\u0010j\u001a\u00020f2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u00042\u0018\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00140(j\u0002`)¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0004\bl\u0010;J\u0017\u0010m\u001a\u00020\u00142\u0006\u00100\u001a\u00020,H\u0000¢\u0006\u0004\bm\u00107J\u001f\u0010n\u001a\u00020\u00142\u000e\u0010\u001f\u001a\n\u0018\u00010_j\u0004\u0018\u0001``H\u0016¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020UH\u0014¢\u0006\u0004\bp\u0010qJ\u0017\u0010r\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\br\u0010sJ\u0015\u0010u\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\u0003¢\u0006\u0004\bu\u0010vJ\u0017\u0010w\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\bw\u0010#J\u0017\u0010x\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bx\u0010#J\u0019\u0010y\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\by\u0010zJ\u0013\u0010{\u001a\u00060_j\u0002``H\u0016¢\u0006\u0004\b{\u0010bJ\u0019\u0010|\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b|\u0010zJ\u001b\u0010}\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b}\u0010=J\u0016\u0010\u007f\u001a\u00020~2\u0006\u0010L\u001a\u00020\u0002¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u001a\u0010\u0082\u0001\u001a\u00020\u00142\u0007\u0010\u0081\u0001\u001a\u00020\u000fH\u0010¢\u0006\u0005\b\u0082\u0001\u0010sJ\u001b\u0010\u0083\u0001\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0005\b\u0083\u0001\u0010sJ\u001a\u0010\u0084\u0001\u001a\u00020\u00042\u0007\u0010\u0081\u0001\u001a\u00020\u000fH\u0014¢\u0006\u0005\b\u0084\u0001\u0010#J\u001c\u0010\u0085\u0001\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u001c\u0010\u0087\u0001\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0006\b\u0087\u0001\u0010\u0086\u0001J\u0011\u0010\u0088\u0001\u001a\u00020UH\u0016¢\u0006\u0005\b\u0088\u0001\u0010qJ\u0011\u0010\u0089\u0001\u001a\u00020UH\u0007¢\u0006\u0005\b\u0089\u0001\u0010qJ\u0011\u0010\u008a\u0001\u001a\u00020UH\u0010¢\u0006\u0005\b\u008a\u0001\u0010qJ\u0014\u0010\u008b\u0001\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0017\u0010\u008d\u0001\u001a\u0004\u0018\u00010\nH\u0084@ø\u0001\u0000¢\u0006\u0005\b\u008d\u0001\u0010;R\u001e\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010?R\u0019\u0010\u0093\u0001\u001a\u0007\u0012\u0002\b\u00030\u0090\u00018F¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R.\u0010\u0099\u0001\u001a\u0004\u0018\u00010~2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010~8@@@X\u0080\u000e¢\u0006\u0010\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010Y\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u008c\u0001R\u0016\u0010\u009d\u0001\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u00109R\u0013\u0010\u009f\u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u00109R\u0013\u0010 \u0001\u001a\u00020\u00048F¢\u0006\u0007\u001a\u0005\b \u0001\u00109R\u0016\u0010¢\u0001\u001a\u00020\u00048PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¡\u0001\u00109R\u0016\u0010¤\u0001\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b£\u0001\u00109R\u0016\u0010¦\u0001\u001a\u00020\u00048PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¥\u0001\u00109R\u0015\u0010¨\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010~0§\u00018\u0002X\u0082\u0004R\u0015\u0010©\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0§\u00018\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006¬\u0001"}, d2 = {"Lkotlinx/coroutines/c2;", "Lkotlinx/coroutines/u1;", "Lkotlinx/coroutines/v;", "Lkotlinx/coroutines/k2;", "", "active", "<init>", "(Z)V", "Lkotlinx/coroutines/c2$c;", "state", "", "proposedUpdate", ExifInterface.LATITUDE_SOUTH, "(Lkotlinx/coroutines/c2$c;Ljava/lang/Object;)Ljava/lang/Object;", "", "", "exceptions", ExifInterface.LONGITUDE_WEST, "(Lkotlinx/coroutines/c2$c;Ljava/util/List;)Ljava/lang/Throwable;", "rootCause", "Lr8/z;", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/Throwable;Ljava/util/List;)V", "Lkotlinx/coroutines/p1;", "update", "D0", "(Lkotlinx/coroutines/p1;Ljava/lang/Object;)Z", "P", "(Lkotlinx/coroutines/p1;Ljava/lang/Object;)V", "Lkotlinx/coroutines/h2;", "list", "cause", "p0", "(Lkotlinx/coroutines/h2;Ljava/lang/Throwable;)V", "M", "(Ljava/lang/Throwable;)Z", "q0", "", "y0", "(Ljava/lang/Object;)I", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "onCancelling", "Lkotlinx/coroutines/b2;", "m0", "(Lc9/l;Z)Lkotlinx/coroutines/b2;", "expect", "node", "D", "(Ljava/lang/Object;Lkotlinx/coroutines/h2;Lkotlinx/coroutines/b2;)Z", "Lkotlinx/coroutines/d1;", "u0", "(Lkotlinx/coroutines/d1;)V", "v0", "(Lkotlinx/coroutines/b2;)V", "h0", "()Z", "i0", "(Lv8/f;)Ljava/lang/Object;", "L", "(Ljava/lang/Object;)Ljava/lang/Object;", "R", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "j0", "Z", "(Lkotlinx/coroutines/p1;)Lkotlinx/coroutines/h2;", "E0", "(Lkotlinx/coroutines/p1;Ljava/lang/Throwable;)Z", "F0", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "G0", "(Lkotlinx/coroutines/p1;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/u;", ExifInterface.GPS_DIRECTION_TRUE, "(Lkotlinx/coroutines/p1;)Lkotlinx/coroutines/u;", "child", "H0", "(Lkotlinx/coroutines/c2$c;Lkotlinx/coroutines/u;Ljava/lang/Object;)Z", "lastChild", "Q", "(Lkotlinx/coroutines/c2$c;Lkotlinx/coroutines/u;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/q;", "o0", "(Lkotlinx/coroutines/internal/q;)Lkotlinx/coroutines/u;", "", "z0", "(Ljava/lang/Object;)Ljava/lang/String;", "H", "parent", "e0", "(Lkotlinx/coroutines/u1;)V", "start", "t0", "()V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "j", "()Ljava/util/concurrent/CancellationException;", "message", "A0", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/b1;", "x", "(Lc9/l;)Lkotlinx/coroutines/b1;", "invokeImmediately", "n", "(ZZLc9/l;)Lkotlinx/coroutines/b1;", "s", "w0", "a", "(Ljava/util/concurrent/CancellationException;)V", "N", "()Ljava/lang/String;", "K", "(Ljava/lang/Throwable;)V", "parentJob", "m", "(Lkotlinx/coroutines/k2;)V", "O", "I", "J", "(Ljava/lang/Object;)Z", "w", "k0", "l0", "Lkotlinx/coroutines/t;", "z", "(Lkotlinx/coroutines/v;)Lkotlinx/coroutines/t;", "exception", "d0", "r0", "c0", "s0", "(Ljava/lang/Object;)V", "F", "toString", "C0", "n0", "U", "()Ljava/lang/Object;", "G", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "exceptionOrNull", "Lv8/j$c;", "getKey", "()Lv8/j$c;", "key", "value", "a0", "()Lkotlinx/coroutines/t;", "x0", "(Lkotlinx/coroutines/t;)V", "parentHandle", "getParent", "()Lkotlinx/coroutines/u1;", "b0", "isActive", "f0", "isCompleted", "isCancelled", "Y", "onCancelComplete", "g0", "isScopedCoroutine", "X", "handlesException", "Lkotlinx/atomicfu/AtomicRef;", "_parentHandle", "_state", "b", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class c2 implements u1, v, k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14597a = AtomicReferenceFieldUpdater.newUpdater(c2.class, Object.class, "_state");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14598b = AtomicReferenceFieldUpdater.newUpdater(c2.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/c2$a;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/o;", "Lv8/f;", "delegate", "Lkotlinx/coroutines/c2;", "job", "<init>", "(Lv8/f;Lkotlinx/coroutines/c2;)V", "Lkotlinx/coroutines/u1;", "parent", "", "w", "(Lkotlinx/coroutines/u1;)Ljava/lang/Throwable;", "", "K", "()Ljava/lang/String;", "i", "Lkotlinx/coroutines/c2;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class a<T> extends o<T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final c2 job;

        public a(v8.f<? super T> fVar, c2 c2Var) {
            super(fVar, 1);
            this.job = c2Var;
        }

        @Override // kotlinx.coroutines.o
        protected String K() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.o
        public Throwable w(u1 parent) {
            Throwable thE;
            Object objB0 = this.job.b0();
            if (!(objB0 instanceof c) || (thE = ((c) objB0).e()) == null) {
                return objB0 instanceof b0 ? ((b0) objB0).cause : parent.j();
            }
            return thE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/c2$b;", "Lkotlinx/coroutines/b2;", "Lkotlinx/coroutines/c2;", "parent", "Lkotlinx/coroutines/c2$c;", "state", "Lkotlinx/coroutines/u;", "child", "", "proposedUpdate", "<init>", "(Lkotlinx/coroutines/c2;Lkotlinx/coroutines/c2$c;Lkotlinx/coroutines/u;Ljava/lang/Object;)V", "", "cause", "Lr8/z;", "s", "(Ljava/lang/Throwable;)V", "e", "Lkotlinx/coroutines/c2;", "f", "Lkotlinx/coroutines/c2$c;", "g", "Lkotlinx/coroutines/u;", "h", "Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class b extends b2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final c2 parent;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final c state;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private final u child;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final Object proposedUpdate;

        @Override // c9.l
        public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
            s(th);
            return r8.z.f17874a;
        }

        @Override // kotlinx.coroutines.d0
        public void s(Throwable cause) {
            this.parent.Q(this.state, this.child, this.proposedUpdate);
        }

        public b(c2 c2Var, c cVar, u uVar, Object obj) {
            this.parent = c2Var;
            this.state = cVar;
            this.child = uVar;
            this.proposedUpdate = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR(\u0010#\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u0017R\u0011\u0010,\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b+\u0010%R\u0011\u0010.\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b-\u0010%R\u0014\u0010/\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010%R\u0013\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001008\u0002X\u0082\u0004R\u000b\u00103\u001a\u0002028\u0002X\u0082\u0004R\u0013\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b008\u0002X\u0082\u0004¨\u00065"}, d2 = {"Lkotlinx/coroutines/c2$c;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/p1;", "Lkotlinx/coroutines/h2;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/h2;ZLjava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "()Ljava/util/ArrayList;", "proposedException", "", "i", "(Ljava/lang/Throwable;)Ljava/util/List;", "exception", "Lr8/z;", "b", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "a", "Lkotlinx/coroutines/h2;", "()Lkotlinx/coroutines/h2;", "value", "d", "()Ljava/lang/Object;", "k", "(Ljava/lang/Object;)V", "exceptionsHolder", "g", "()Z", "j", "(Z)V", "e", "()Ljava/lang/Throwable;", "l", "h", "isSealed", "f", "isCancelling", "isActive", "Lkotlinx/atomicfu/AtomicRef;", "_exceptionsHolder", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleting", "_rootCause", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class c implements p1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f14604b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f14605c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f14606d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final h2 list;

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return f14606d.get(this);
        }

        private final void k(Object obj) {
            f14606d.set(this, obj);
        }

        @Override // kotlinx.coroutines.p1
        /* JADX INFO: renamed from: a, reason: from getter */
        public h2 getList() {
            return this.list;
        }

        public final Throwable e() {
            return (Throwable) f14605c.get(this);
        }

        public final boolean g() {
            return f14604b.get(this) != 0;
        }

        public final void j(boolean z10) {
            f14604b.set(this, z10 ? 1 : 0);
        }

        public final void l(Throwable th) {
            f14605c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + getList() + ']';
        }

        public c(h2 h2Var, boolean z10, Throwable th) {
            this.list = h2Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th;
        }

        public final void b(Throwable exception) {
            Throwable thE = e();
            if (thE == null) {
                l(exception);
                return;
            }
            if (exception != thE) {
                Object objD = d();
                if (objD == null) {
                    k(exception);
                    return;
                }
                if (objD instanceof Throwable) {
                    if (exception == objD) {
                        return;
                    }
                    ArrayList<Throwable> arrayListC = c();
                    arrayListC.add(objD);
                    arrayListC.add(exception);
                    k(arrayListC);
                    return;
                }
                if (objD instanceof ArrayList) {
                    ((ArrayList) objD).add(exception);
                    return;
                }
                throw new IllegalStateException(("State is " + objD).toString());
            }
        }

        public final boolean f() {
            if (e() != null) {
                return true;
            }
            return false;
        }

        public final boolean h() {
            if (d() == d2.f14669e) {
                return true;
            }
            return false;
        }

        public final List<Throwable> i(Throwable proposedException) {
            ArrayList<Throwable> arrayListC;
            Object objD = d();
            if (objD == null) {
                arrayListC = c();
            } else if (objD instanceof Throwable) {
                ArrayList<Throwable> arrayListC2 = c();
                arrayListC2.add(objD);
                arrayListC = arrayListC2;
            } else if (objD instanceof ArrayList) {
                arrayListC = (ArrayList) objD;
            } else {
                throw new IllegalStateException(("State is " + objD).toString());
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListC.add(0, thE);
            }
            if (proposedException != null && !kotlin.jvm.internal.m.a(proposedException, thE)) {
                arrayListC.add(proposedException);
            }
            k(d2.f14669e);
            return arrayListC;
        }

        @Override // kotlinx.coroutines.p1
        /* JADX INFO: renamed from: isActive */
        public boolean getIsActive() {
            if (e() == null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"kotlinx/coroutines/c2$d", "Lkotlinx/coroutines/internal/q$a;", "Lkotlinx/coroutines/internal/q;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "f", "(Lkotlinx/coroutines/internal/q;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class d extends kotlinx.coroutines.internal.q.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c2 f14608d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f14609e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kotlinx.coroutines.internal.q qVar, c2 c2Var, Object obj) {
            super(qVar);
            this.f14608d = c2Var;
            this.f14609e = obj;
        }

        @Override // kotlinx.coroutines.internal.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object d(kotlinx.coroutines.internal.q affected) {
            if (this.f14608d.b0() == this.f14609e) {
                return null;
            }
            return kotlinx.coroutines.internal.p.a();
        }
    }

    private final Object j0(Object cause) throws Throwable {
        Throwable thR = null;
        while (true) {
            Object objB0 = b0();
            if (objB0 instanceof c) {
                synchronized (objB0) {
                    if (((c) objB0).h()) {
                        return d2.f14668d;
                    }
                    boolean zF = ((c) objB0).f();
                    if (cause != null || !zF) {
                        if (thR == null) {
                            thR = R(cause);
                        }
                        ((c) objB0).b(thR);
                    }
                    Throwable thE = zF ? null : ((c) objB0).e();
                    if (thE != null) {
                        p0(((c) objB0).getList(), thE);
                    }
                    return d2.f14665a;
                }
            }
            if (!(objB0 instanceof p1)) {
                return d2.f14668d;
            }
            if (thR == null) {
                thR = R(cause);
            }
            p1 p1Var = (p1) objB0;
            if (!p1Var.getIsActive()) {
                Object objF0 = F0(objB0, new b0(thR, false, 2, null));
                if (objF0 == d2.f14665a) {
                    throw new IllegalStateException(("Cannot happen in " + objB0).toString());
                }
                if (objF0 != d2.f14667c) {
                    return objF0;
                }
            } else if (E0(p1Var, thR)) {
                return d2.f14665a;
            }
        }
    }

    private final b2 m0(c9.l<? super Throwable, r8.z> handler, boolean onCancelling) {
        b2 t1Var;
        if (onCancelling) {
            t1Var = handler instanceof w1 ? (w1) handler : null;
            if (t1Var == null) {
                t1Var = new s1(handler);
            }
        } else {
            t1Var = handler instanceof b2 ? (b2) handler : null;
            if (t1Var == null) {
                t1Var = new t1(handler);
            }
        }
        t1Var.u(this);
        return t1Var;
    }

    /* JADX INFO: renamed from: X */
    public boolean getHandlesException() {
        return true;
    }

    public boolean Y() {
        return false;
    }

    protected boolean c0(Throwable exception) {
        return false;
    }

    protected boolean g0() {
        return false;
    }

    @Override // kotlinx.coroutines.u1
    public final b1 x(c9.l<? super Throwable, r8.z> handler) {
        return n(false, true, handler);
    }

    public static /* synthetic */ CancellationException B0(c2 c2Var, Throwable th, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return c2Var.A0(th, str);
    }

    private final boolean D(Object expect, h2 list, b2 node) {
        int iR;
        d dVar = new d(node, this, expect);
        do {
            iR = list.m().r(node, list, dVar);
            if (iR == 1) {
                return true;
            }
        } while (iR != 2);
        return false;
    }

    private final boolean D0(p1 state, Object update) throws Throwable {
        if (!androidx.concurrent.futures.a.a(f14597a, this, state, d2.g(update))) {
            return false;
        }
        r0(null);
        s0(update);
        P(state, update);
        return true;
    }

    private final Object F0(Object state, Object proposedUpdate) {
        if (!(state instanceof p1)) {
            return d2.f14665a;
        }
        if ((!(state instanceof d1) && !(state instanceof b2)) || (state instanceof u) || (proposedUpdate instanceof b0)) {
            return G0((p1) state, proposedUpdate);
        }
        return D0((p1) state, proposedUpdate) ? proposedUpdate : d2.f14667c;
    }

    private final Object H(v8.f<Object> fVar) {
        a aVar = new a(kotlin.coroutines.intrinsics.b.b(fVar), this);
        aVar.D();
        q.a(aVar, x(new l2(aVar)));
        Object objZ = aVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ;
    }

    private final boolean H0(c state, u child, Object proposedUpdate) {
        while (u1.a.d(child.childJob, false, false, new b(this, state, child, proposedUpdate), 1, null) == i2.f14809a) {
            child = o0(child);
            if (child == null) {
                return false;
            }
        }
        return true;
    }

    private final Throwable R(Object cause) {
        if (cause == null ? true : cause instanceof Throwable) {
            Throwable th = (Throwable) cause;
            return th == null ? new v1(N(), null, this) : th;
        }
        kotlin.jvm.internal.m.d(cause, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((k2) cause).w();
    }

    private final Object S(c state, Object proposedUpdate) throws Throwable {
        boolean zF;
        Throwable thW;
        b0 b0Var = proposedUpdate instanceof b0 ? (b0) proposedUpdate : null;
        Throwable th = b0Var != null ? b0Var.cause : null;
        synchronized (state) {
            zF = state.f();
            List<Throwable> listI = state.i(th);
            thW = W(state, listI);
            if (thW != null) {
                E(thW, listI);
            }
        }
        if (thW != null && thW != th) {
            proposedUpdate = new b0(thW, false, 2, null);
        }
        if (thW != null && (M(thW) || c0(thW))) {
            kotlin.jvm.internal.m.d(proposedUpdate, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((b0) proposedUpdate).b();
        }
        if (!zF) {
            r0(thW);
        }
        s0(proposedUpdate);
        androidx.concurrent.futures.a.a(f14597a, this, state, d2.g(proposedUpdate));
        P(state, proposedUpdate);
        return proposedUpdate;
    }

    private final u T(p1 state) {
        u uVar = state instanceof u ? (u) state : null;
        if (uVar != null) {
            return uVar;
        }
        h2 list = state.getList();
        if (list != null) {
            return o0(list);
        }
        return null;
    }

    private final Throwable V(Object obj) {
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        if (b0Var != null) {
            return b0Var.cause;
        }
        return null;
    }

    private final Object i0(v8.f<? super r8.z> fVar) {
        o oVar = new o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.D();
        q.a(oVar, x(new m2(oVar)));
        Object objZ = oVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ == kotlin.coroutines.intrinsics.b.c() ? objZ : r8.z.f17874a;
    }

    private final void u0(d1 state) {
        h2 h2Var = new h2();
        Object o1Var = h2Var;
        if (!state.getIsActive()) {
            o1Var = new o1(h2Var);
        }
        androidx.concurrent.futures.a.a(f14597a, this, state, o1Var);
    }

    private final void v0(b2 state) {
        state.e(new h2());
        androidx.concurrent.futures.a.a(f14597a, this, state, state.l());
    }

    private final int y0(Object state) {
        if (state instanceof d1) {
            if (((d1) state).getIsActive()) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(f14597a, this, state, d2.f14671g)) {
                return -1;
            }
            t0();
            return 1;
        }
        if (!(state instanceof o1)) {
            return 0;
        }
        if (!androidx.concurrent.futures.a.a(f14597a, this, state, ((o1) state).getList())) {
            return -1;
        }
        t0();
        return 1;
    }

    private final String z0(Object state) {
        if (!(state instanceof c)) {
            if (state instanceof p1) {
                return ((p1) state).getIsActive() ? "Active" : "New";
            }
            return state instanceof b0 ? "Cancelled" : "Completed";
        }
        c cVar = (c) state;
        if (cVar.f()) {
            return "Cancelling";
        }
        return cVar.g() ? "Completing" : "Active";
    }

    protected final CancellationException A0(Throwable th, String str) {
        CancellationException v1Var = th instanceof CancellationException ? (CancellationException) th : null;
        if (v1Var == null) {
            if (str == null) {
                str = N();
            }
            v1Var = new v1(str, th, this);
        }
        return v1Var;
    }

    public final String C0() {
        return n0() + '{' + z0(b0()) + '}';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String N() {
        return "Job was cancelled";
    }

    public boolean O(Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        return J(cause) && getHandlesException();
    }

    @Override // kotlinx.coroutines.u1
    public void a(CancellationException cause) throws Throwable {
        if (cause == null) {
            cause = new v1(N(), null, this);
        }
        K(cause);
    }

    public final t a0() {
        return (t) f14598b.get(this);
    }

    public final Object b0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14597a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof kotlinx.coroutines.internal.y)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.y) obj).a(this);
        }
    }

    protected final void e0(u1 parent) {
        if (parent == null) {
            x0(i2.f14809a);
            return;
        }
        parent.start();
        t tVarZ = parent.z(this);
        x0(tVarZ);
        if (f0()) {
            tVarZ.dispose();
            x0(i2.f14809a);
        }
    }

    @Override // v8.j.b
    public final v8.j.c<?> getKey() {
        return u1.INSTANCE;
    }

    public String toString() {
        return C0() + '@' + p0.b(this);
    }

    public final void x0(t tVar) {
        f14598b.set(this, tVar);
    }

    @Override // kotlinx.coroutines.u1
    public final t z(v child) {
        b1 b1VarD = u1.a.d(this, true, false, new u(child), 2, null);
        kotlin.jvm.internal.m.d(b1VarD, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (t) b1VarD;
    }

    public c2(boolean z10) {
        this._state = z10 ? d2.f14671g : d2.f14670f;
    }

    private final void E(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() > 1) {
            Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(exceptions.size()));
            for (Throwable th : exceptions) {
                if (th != rootCause && th != rootCause && !(th instanceof CancellationException) && setNewSetFromMap.add(th)) {
                    r8.a.a(rootCause, th);
                }
            }
        }
    }

    private final boolean E0(p1 state, Throwable rootCause) throws Throwable {
        h2 h2VarZ = Z(state);
        if (h2VarZ == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(f14597a, this, state, new c(h2VarZ, false, rootCause))) {
            return false;
        }
        p0(h2VarZ, rootCause);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object G0(p1 state, Object proposedUpdate) throws Throwable {
        c cVar;
        b0 b0Var;
        h2 h2VarZ = Z(state);
        if (h2VarZ == null) {
            return d2.f14667c;
        }
        ?? r10 = 0;
        if (state instanceof c) {
            cVar = (c) state;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            cVar = new c(h2VarZ, false, null);
        }
        kotlin.jvm.internal.b0 b0Var2 = new kotlin.jvm.internal.b0();
        synchronized (cVar) {
            if (cVar.g()) {
                return d2.f14665a;
            }
            cVar.j(true);
            if (cVar != state && !androidx.concurrent.futures.a.a(f14597a, this, state, cVar)) {
                return d2.f14667c;
            }
            boolean zF = cVar.f();
            if (proposedUpdate instanceof b0) {
                b0Var = (b0) proposedUpdate;
            } else {
                b0Var = null;
            }
            if (b0Var != null) {
                cVar.b(b0Var.cause);
            }
            Throwable thE = cVar.e();
            if (!zF) {
                r10 = thE;
            }
            b0Var2.element = r10;
            r8.z zVar = r8.z.f17874a;
            if (r10 != 0) {
                p0(h2VarZ, r10);
            }
            u uVarT = T(state);
            if (uVarT != null && H0(cVar, uVarT, proposedUpdate)) {
                return d2.f14666b;
            }
            return S(cVar, proposedUpdate);
        }
    }

    private final Object L(Object cause) {
        Object objF0;
        do {
            Object objB0 = b0();
            if (!(objB0 instanceof p1) || ((objB0 instanceof c) && ((c) objB0).g())) {
                return d2.f14665a;
            }
            objF0 = F0(objB0, new b0(R(cause), false, 2, null));
        } while (objF0 == d2.f14667c);
        return objF0;
    }

    private final boolean M(Throwable cause) {
        if (g0()) {
            return true;
        }
        boolean z10 = cause instanceof CancellationException;
        t tVarA0 = a0();
        if (tVarA0 != null && tVarA0 != i2.f14809a) {
            if (tVarA0.f(cause) || z10) {
                return true;
            }
            return false;
        }
        return z10;
    }

    private final void P(p1 state, Object update) throws Throwable {
        b0 b0Var;
        t tVarA0 = a0();
        if (tVarA0 != null) {
            tVarA0.dispose();
            x0(i2.f14809a);
        }
        Throwable th = null;
        if (update instanceof b0) {
            b0Var = (b0) update;
        } else {
            b0Var = null;
        }
        if (b0Var != null) {
            th = b0Var.cause;
        }
        if (state instanceof b2) {
            try {
                ((b2) state).s(th);
                return;
            } catch (Throwable th2) {
                d0(new e0("Exception in completion handler " + state + " for " + this, th2));
                return;
            }
        }
        h2 list = state.getList();
        if (list != null) {
            q0(list, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(c state, u lastChild, Object proposedUpdate) {
        u uVarO0 = o0(lastChild);
        if (uVarO0 != null && H0(state, uVarO0, proposedUpdate)) {
            return;
        }
        F(S(state, proposedUpdate));
    }

    private final Throwable W(c state, List<? extends Throwable> exceptions) {
        Object obj = null;
        if (exceptions.isEmpty()) {
            if (!state.f()) {
                return null;
            }
            return new v1(N(), null, this);
        }
        for (Object obj2 : exceptions) {
            if (!(((Throwable) obj2) instanceof CancellationException)) {
                obj = obj2;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        return exceptions.get(0);
    }

    private final h2 Z(p1 state) {
        h2 list = state.getList();
        if (list == null) {
            if (state instanceof d1) {
                return new h2();
            }
            if (state instanceof b2) {
                v0((b2) state);
                return null;
            }
            throw new IllegalStateException(("State should have list: " + state).toString());
        }
        return list;
    }

    private final boolean h0() {
        Object objB0;
        do {
            objB0 = b0();
            if (!(objB0 instanceof p1)) {
                return false;
            }
        } while (y0(objB0) < 0);
        return true;
    }

    private final u o0(kotlinx.coroutines.internal.q qVar) {
        while (qVar.n()) {
            qVar = qVar.m();
        }
        while (true) {
            qVar = qVar.l();
            if (!qVar.n()) {
                if (qVar instanceof u) {
                    return (u) qVar;
                }
                if (qVar instanceof h2) {
                    return null;
                }
            }
        }
    }

    private final void p0(h2 list, Throwable cause) throws Throwable {
        r0(cause);
        Object objK = list.k();
        kotlin.jvm.internal.m.d(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        e0 e0Var = null;
        for (kotlinx.coroutines.internal.q qVarL = (kotlinx.coroutines.internal.q) objK; !kotlin.jvm.internal.m.a(qVarL, list); qVarL = qVarL.l()) {
            if (qVarL instanceof w1) {
                b2 b2Var = (b2) qVarL;
                try {
                    b2Var.s(cause);
                } catch (Throwable th) {
                    if (e0Var != null) {
                        r8.a.a(e0Var, th);
                    } else {
                        e0Var = new e0("Exception in completion handler " + b2Var + " for " + this, th);
                        r8.z zVar = r8.z.f17874a;
                    }
                }
            }
        }
        if (e0Var != null) {
            d0(e0Var);
        }
        M(cause);
    }

    private final void q0(h2 h2Var, Throwable th) throws Throwable {
        Object objK = h2Var.k();
        kotlin.jvm.internal.m.d(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        e0 e0Var = null;
        for (kotlinx.coroutines.internal.q qVarL = (kotlinx.coroutines.internal.q) objK; !kotlin.jvm.internal.m.a(qVarL, h2Var); qVarL = qVarL.l()) {
            if (qVarL instanceof b2) {
                b2 b2Var = (b2) qVarL;
                try {
                    b2Var.s(th);
                } catch (Throwable th2) {
                    if (e0Var != null) {
                        r8.a.a(e0Var, th2);
                    } else {
                        e0Var = new e0("Exception in completion handler " + b2Var + " for " + this, th2);
                        r8.z zVar = r8.z.f17874a;
                    }
                }
            }
        }
        if (e0Var != null) {
            d0(e0Var);
        }
    }

    protected final Object G(v8.f<Object> fVar) throws Throwable {
        Object objB0;
        do {
            objB0 = b0();
            if (!(objB0 instanceof p1)) {
                if (!(objB0 instanceof b0)) {
                    return d2.h(objB0);
                }
                throw ((b0) objB0).cause;
            }
        } while (y0(objB0) < 0);
        return H(fVar);
    }

    public final boolean I(Throwable cause) {
        return J(cause);
    }

    public final boolean J(Object cause) throws Throwable {
        Object objJ0 = d2.f14665a;
        if (Y() && (objJ0 = L(cause)) == d2.f14666b) {
            return true;
        }
        if (objJ0 == d2.f14665a) {
            objJ0 = j0(cause);
        }
        if (objJ0 == d2.f14665a || objJ0 == d2.f14666b) {
            return true;
        }
        if (objJ0 == d2.f14668d) {
            return false;
        }
        F(objJ0);
        return true;
    }

    public void K(Throwable cause) throws Throwable {
        J(cause);
    }

    public final Object U() throws Throwable {
        Object objB0 = b0();
        if (!(objB0 instanceof p1)) {
            if (!(objB0 instanceof b0)) {
                return d2.h(objB0);
            }
            throw ((b0) objB0).cause;
        }
        throw new IllegalStateException("This job has not completed yet");
    }

    public final boolean f0() {
        return !(b0() instanceof p1);
    }

    @Override // v8.j
    public <R> R fold(R r10, c9.p<? super R, ? super v8.j.b, ? extends R> pVar) {
        return (R) u1.a.b(this, r10, pVar);
    }

    @Override // v8.j.b, v8.j
    public <E extends v8.j.b> E get(v8.j.c<E> cVar) {
        return (E) u1.a.c(this, cVar);
    }

    @Override // kotlinx.coroutines.u1
    public u1 getParent() {
        t tVarA0 = a0();
        if (tVarA0 != null) {
            return tVarA0.getParent();
        }
        return null;
    }

    @Override // kotlinx.coroutines.u1
    public boolean isActive() {
        Object objB0 = b0();
        if ((objB0 instanceof p1) && ((p1) objB0).getIsActive()) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.u1
    public final boolean isCancelled() {
        Object objB0 = b0();
        if (!(objB0 instanceof b0)) {
            if (!(objB0 instanceof c) || !((c) objB0).f()) {
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // kotlinx.coroutines.u1
    public final CancellationException j() {
        Object objB0 = b0();
        if (objB0 instanceof c) {
            Throwable thE = ((c) objB0).e();
            if (thE != null) {
                CancellationException cancellationExceptionA0 = A0(thE, p0.a(this) + " is cancelling");
                if (cancellationExceptionA0 != null) {
                    return cancellationExceptionA0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (!(objB0 instanceof p1)) {
            if (objB0 instanceof b0) {
                return B0(this, ((b0) objB0).cause, null, 1, null);
            }
            return new v1(p0.a(this) + " has completed normally", null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final boolean k0(Object proposedUpdate) {
        Object objF0;
        do {
            objF0 = F0(b0(), proposedUpdate);
            if (objF0 == d2.f14665a) {
                return false;
            }
            if (objF0 == d2.f14666b) {
                return true;
            }
        } while (objF0 == d2.f14667c);
        F(objF0);
        return true;
    }

    public final Object l0(Object proposedUpdate) {
        Object objF0;
        do {
            objF0 = F0(b0(), proposedUpdate);
            if (objF0 == d2.f14665a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, V(proposedUpdate));
            }
        } while (objF0 == d2.f14667c);
        return objF0;
    }

    @Override // kotlinx.coroutines.v
    public final void m(k2 parentJob) throws Throwable {
        J(parentJob);
    }

    @Override // v8.j
    public v8.j minusKey(v8.j.c<?> cVar) {
        return u1.a.e(this, cVar);
    }

    @Override // kotlinx.coroutines.u1
    public final b1 n(boolean onCancelling, boolean invokeImmediately, c9.l<? super Throwable, r8.z> handler) {
        b0 b0Var;
        b2 b2VarM0 = m0(handler, onCancelling);
        while (true) {
            Object objB0 = b0();
            if (objB0 instanceof d1) {
                d1 d1Var = (d1) objB0;
                if (d1Var.getIsActive()) {
                    if (androidx.concurrent.futures.a.a(f14597a, this, objB0, b2VarM0)) {
                        break;
                    }
                } else {
                    u0(d1Var);
                }
            } else {
                Throwable thE = null;
                if (objB0 instanceof p1) {
                    h2 list = ((p1) objB0).getList();
                    if (list == null) {
                        kotlin.jvm.internal.m.d(objB0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        v0((b2) objB0);
                    } else {
                        b1 b1Var = i2.f14809a;
                        if (onCancelling && (objB0 instanceof c)) {
                            synchronized (objB0) {
                                try {
                                    thE = ((c) objB0).e();
                                    if (thE == null || ((handler instanceof u) && !((c) objB0).g())) {
                                        if (D(objB0, list, b2VarM0)) {
                                            if (thE == null) {
                                                return b2VarM0;
                                            }
                                            b1Var = b2VarM0;
                                        }
                                    }
                                    r8.z zVar = r8.z.f17874a;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        if (thE != null) {
                            if (invokeImmediately) {
                                handler.invoke(thE);
                            }
                            return b1Var;
                        }
                        if (D(objB0, list, b2VarM0)) {
                            break;
                        }
                    }
                } else {
                    if (invokeImmediately) {
                        if (objB0 instanceof b0) {
                            b0Var = (b0) objB0;
                        } else {
                            b0Var = null;
                        }
                        if (b0Var != null) {
                            thE = b0Var.cause;
                        }
                        handler.invoke(thE);
                    }
                    return i2.f14809a;
                }
            }
        }
        return b2VarM0;
    }

    public String n0() {
        return p0.a(this);
    }

    @Override // v8.j
    public v8.j plus(v8.j jVar) {
        return u1.a.f(this, jVar);
    }

    @Override // kotlinx.coroutines.u1
    public final Object s(v8.f<? super r8.z> fVar) {
        if (!h0()) {
            y1.h(fVar.getContext());
            return r8.z.f17874a;
        }
        Object objI0 = i0(fVar);
        if (objI0 == kotlin.coroutines.intrinsics.b.c()) {
            return objI0;
        }
        return r8.z.f17874a;
    }

    @Override // kotlinx.coroutines.u1
    public final boolean start() {
        int iY0;
        do {
            iY0 = y0(b0());
            if (iY0 == 0) {
                return false;
            }
        } while (iY0 != 1);
        return true;
    }

    @Override // kotlinx.coroutines.k2
    public CancellationException w() {
        Throwable thE;
        Object objB0 = b0();
        CancellationException cancellationException = null;
        if (objB0 instanceof c) {
            thE = ((c) objB0).e();
        } else if (objB0 instanceof b0) {
            thE = ((b0) objB0).cause;
        } else if (!(objB0 instanceof p1)) {
            thE = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + objB0).toString());
        }
        if (thE instanceof CancellationException) {
            cancellationException = (CancellationException) thE;
        }
        if (cancellationException == null) {
            return new v1("Parent job is " + z0(objB0), thE, this);
        }
        return cancellationException;
    }

    public final void w0(b2 node) {
        Object objB0;
        do {
            objB0 = b0();
            if (objB0 instanceof b2) {
                if (objB0 != node) {
                    return;
                }
            } else {
                if ((objB0 instanceof p1) && ((p1) objB0).getList() != null) {
                    node.o();
                    return;
                }
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f14597a, this, objB0, d2.f14671g));
    }

    protected void t0() {
    }

    protected void F(Object state) {
    }

    public void d0(Throwable exception) throws Throwable {
        throw exception;
    }

    protected void r0(Throwable cause) {
    }

    protected void s0(Object state) {
    }
}
