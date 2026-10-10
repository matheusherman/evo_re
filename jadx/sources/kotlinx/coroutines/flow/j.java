package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a#\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "Lkotlinx/coroutines/channels/u;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "Lr8/z;", "c", "(Lkotlinx/coroutines/flow/g;Lkotlinx/coroutines/channels/u;Lv8/f;)Ljava/lang/Object;", "", "consume", "d", "(Lkotlinx/coroutines/flow/g;Lkotlinx/coroutines/channels/u;ZLv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/f;", "b", "(Lkotlinx/coroutines/channels/u;)Lkotlinx/coroutines/flow/f;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class j {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {36, 37}, m = "emitAllImpl$FlowKt__ChannelsKt")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.d(null, null, false, this);
        }

        a(v8.f<? super a> fVar) {
            super(fVar);
        }
    }

    public static final <T> Object c(g<? super T> gVar, kotlinx.coroutines.channels.u<? extends T> uVar, v8.f<? super r8.z> fVar) {
        Object objD = d(gVar, uVar, true, fVar);
        return objD == kotlin.coroutines.intrinsics.b.c() ? objD : r8.z.f17874a;
    }

    public static final <T> f<T> b(kotlinx.coroutines.channels.u<? extends T> uVar) {
        return new c(uVar, true, null, 0, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    /* JADX WARN: Code duplicated, block: B:30:0x007f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:13:0x0036, B:24:0x0062, B:28:0x0077, B:30:0x007f, B:20:0x0054, B:23:0x005e), top: B:42:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0094 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0096  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
    
        if (r2.emit(r9, r0) == r1) goto L32;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0091 -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object d(g<? super T> gVar, kotlinx.coroutines.channels.u<? extends T> uVar, boolean z10, v8.f<? super r8.z> fVar) {
        a aVar;
        kotlinx.coroutines.channels.f<? extends T> it;
        kotlinx.coroutines.channels.f<? extends T> fVar2;
        g<? super T> gVar2;
        Object objA;
        if (fVar instanceof a) {
            aVar = (a) fVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(fVar);
            }
        } else {
            aVar = new a(fVar);
        }
        Object obj = aVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = aVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(obj);
                h.q(gVar);
                it = uVar.iterator();
                aVar.L$0 = gVar;
                aVar.L$1 = uVar;
                aVar.L$2 = it;
                aVar.Z$0 = z10;
                aVar.label = 1;
                objA = it.a(aVar);
                if (objA == objC) {
                    gVar2 = gVar;
                    fVar2 = it;
                    obj = objA;
                    if (!((Boolean) obj).booleanValue()) {
                        if (z10) {
                            kotlinx.coroutines.channels.k.a(uVar, null);
                        }
                        return r8.z.f17874a;
                    }
                    T next = fVar2.next();
                    aVar.L$0 = gVar2;
                    aVar.L$1 = uVar;
                    aVar.L$2 = fVar2;
                    aVar.Z$0 = z10;
                    aVar.label = 2;
                }
                return objC;
            }
            if (i11 == 1) {
                z10 = aVar.Z$0;
                fVar2 = (kotlinx.coroutines.channels.f) aVar.L$2;
                uVar = (kotlinx.coroutines.channels.u) aVar.L$1;
                gVar2 = (g) aVar.L$0;
                r8.r.b(obj);
                if (!((Boolean) obj).booleanValue()) {
                    if (z10) {
                        kotlinx.coroutines.channels.k.a(uVar, null);
                    }
                    return r8.z.f17874a;
                }
                T next2 = fVar2.next();
                aVar.L$0 = gVar2;
                aVar.L$1 = uVar;
                aVar.L$2 = fVar2;
                aVar.Z$0 = z10;
                aVar.label = 2;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z10 = aVar.Z$0;
                fVar2 = (kotlinx.coroutines.channels.f) aVar.L$2;
                uVar = (kotlinx.coroutines.channels.u) aVar.L$1;
                gVar2 = (g) aVar.L$0;
                r8.r.b(obj);
            }
            it = fVar2;
            gVar = gVar2;
            aVar.L$0 = gVar;
            aVar.L$1 = uVar;
            aVar.L$2 = it;
            aVar.Z$0 = z10;
            aVar.label = 1;
            objA = it.a(aVar);
            if (objA == objC) {
                gVar2 = gVar;
                fVar2 = it;
                obj = objA;
                if (!((Boolean) obj).booleanValue()) {
                    if (z10) {
                        kotlinx.coroutines.channels.k.a(uVar, null);
                    }
                    return r8.z.f17874a;
                }
                T next3 = fVar2.next();
                aVar.L$0 = gVar2;
                aVar.L$1 = uVar;
                aVar.L$2 = fVar2;
                aVar.Z$0 = z10;
                aVar.label = 2;
            }
            return objC;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (z10) {
                    kotlinx.coroutines.channels.k.a(uVar, th);
                }
                throw th2;
            }
        }
    }
}
