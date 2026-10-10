package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.channels.o;
import kotlinx.coroutines.channels.v;
import kotlinx.coroutines.flow.h;
import org.apache.log4j.net.SyslogAppender;
import r8.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0004R&\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/paging/TemporaryDownstream;", "", ExifInterface.GPS_DIRECTION_TRUE, "<init>", "()V", "Lkotlinx/coroutines/flow/f;", "Lkotlin/collections/h0;", "Landroidx/paging/PageEvent;", "consumeHistory", "()Lkotlinx/coroutines/flow/f;", NotificationCompat.CATEGORY_EVENT, "", "send", "(Lkotlin/collections/h0;Lv8/f;)Ljava/lang/Object;", "Lr8/z;", "close", "Lkotlinx/coroutines/channels/d;", "historyChannel", "Lkotlinx/coroutines/channels/d;", "paging-common"}, k = 1, mv = {1, 4, 1})
final class TemporaryDownstream<T> {
    private final d<IndexedValue<PageEvent<T>>> historyChannel = g.b(Integer.MAX_VALUE, null, null, 6, null);

    /* JADX INFO: renamed from: androidx.paging.TemporaryDownstream$send$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.TemporaryDownstream", f = "CachedPageEventFlow.kt", l = {SyslogAppender.LOG_LOCAL3}, m = "send")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/h0;", "Landroidx/paging/PageEvent;", NotificationCompat.CATEGORY_EVENT, "Lv8/f;", "", "continuation", "send", "(Lkotlin/collections/h0;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TemporaryDownstream.this.send(null, this);
        }
    }

    public final void close() {
        v.a.a(this.historyChannel, null, 1, null);
    }

    public final kotlinx.coroutines.flow.f<IndexedValue<PageEvent<T>>> consumeHistory() {
        return h.l(this.historyChannel);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object send(IndexedValue<? extends PageEvent<T>> indexedValue, v8.f<? super Boolean> fVar) {
        AnonymousClass1 anonymousClass1;
        if (fVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) fVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(fVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(fVar);
        }
        Object obj = anonymousClass1.result;
        Object objC = b.c();
        int i11 = anonymousClass1.label;
        boolean z10 = true;
        try {
            if (i11 == 0) {
                r.b(obj);
                d<IndexedValue<PageEvent<T>>> dVar = this.historyChannel;
                anonymousClass1.label = 1;
                if (dVar.b(indexedValue, anonymousClass1) == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj);
            }
        } catch (o unused) {
            z10 = false;
        }
        return kotlin.coroutines.jvm.internal.b.a(z10);
    }
}
