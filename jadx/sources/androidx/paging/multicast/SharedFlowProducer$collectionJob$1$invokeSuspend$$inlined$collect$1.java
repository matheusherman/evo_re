package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import com.taobao.sophix.PatchStatus;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"androidx/paging/multicast/SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
public final class SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1<T> implements g<T> {
    final /* synthetic */ SharedFlowProducer$collectionJob$1 this$0;

    /* JADX INFO: renamed from: androidx.paging.multicast.SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @f(c = "androidx.paging.multicast.SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1", f = "SharedFlowProducer.kt", l = {PatchStatus.CODE_LOAD_LIB_UNZIP, 141}, m = "emit")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "emit"}, k = 3, mv = {1, 4, 1})
    public static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1(SharedFlowProducer$collectionJob$1 sharedFlowProducer$collectionJob$1) {
        this.this$0 = sharedFlowProducer$collectionJob$1;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
    
        if (r8.B(r0) == r1) goto L22;
     */
    @Override // kotlinx.coroutines.flow.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, v8.f fVar) {
        AnonymousClass1 anonymousClass1;
        w wVar;
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
        Object obj2 = anonymousClass1.result;
        Object objC = b.c();
        int i11 = anonymousClass1.label;
        if (i11 != 0) {
            if (i11 == 1) {
                wVar = (w) anonymousClass1.L$0;
                r.b(obj2);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj2);
            }
            return z.f17874a;
        }
        r.b(obj2);
        w wVarB = y.b(null, 1, null);
        p pVar = this.this$0.this$0.sendUpsteamMessage;
        ChannelManager.Message.Dispatch.Value value = new ChannelManager.Message.Dispatch.Value(obj, wVarB);
        anonymousClass1.L$0 = wVarB;
        anonymousClass1.label = 1;
        if (pVar.invoke(value, anonymousClass1) != objC) {
            wVar = wVarB;
        }
        return objC;
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 2;
    }
}
