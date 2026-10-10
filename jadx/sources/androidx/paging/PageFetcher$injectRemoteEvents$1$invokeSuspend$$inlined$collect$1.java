package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.flow.g;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"androidx/paging/PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
public final class PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1<Value> implements g<PageEvent<Value>> {
    final /* synthetic */ MutableLoadStateCollection $loadStates$inlined;
    final /* synthetic */ s $this_channelFlow$inlined;
    final /* synthetic */ PageFetcher.C05411 this$0;

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @f(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1", f = "PageFetcher.kt", l = {139, 147, 155}, m = "emit")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "emit"}, k = 3, mv = {1, 4, 1})
    public static final class AnonymousClass1 extends d {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$collect$1(PageFetcher.C05411 c05411, s sVar, MutableLoadStateCollection mutableLoadStateCollection) {
        this.this$0 = c05411;
        this.$this_channelFlow$inlined = sVar;
        this.$loadStates$inlined = mutableLoadStateCollection;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
    
        if (r1.b(r4, r2) == r3) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a1, code lost:
    
        if (r4.b(r1, r2) == r3) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c4, code lost:
    
        if (r4.b(r1, r2) == r3) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c6, code lost:
    
        return r3;
     */
    @Override // kotlinx.coroutines.flow.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, v8.f fVar) {
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
        Object obj2 = anonymousClass1.result;
        Object objC = b.c();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            r.b(obj2);
            PageEvent pageEvent = (PageEvent) obj;
            if (pageEvent instanceof PageEvent.Insert) {
                PageEvent.Insert insert = (PageEvent.Insert) pageEvent;
                this.$loadStates$inlined.set(insert.getCombinedLoadStates().getSource(), this.this$0.$accessor.getState().getValue());
                s sVar = this.$this_channelFlow$inlined;
                PageEvent.Insert insertCopy$default = PageEvent.Insert.copy$default(insert, null, null, 0, 0, this.$loadStates$inlined.snapshot(), 15, null);
                anonymousClass1.label = 1;
            } else if (pageEvent instanceof PageEvent.Drop) {
                this.$loadStates$inlined.set(((PageEvent.Drop) pageEvent).getLoadType(), false, LoadState.NotLoading.INSTANCE.getIncomplete$paging_common());
                s sVar2 = this.$this_channelFlow$inlined;
                anonymousClass1.label = 2;
            } else if (pageEvent instanceof PageEvent.LoadStateUpdate) {
                PageEvent.LoadStateUpdate loadStateUpdate = (PageEvent.LoadStateUpdate) pageEvent;
                this.$loadStates$inlined.set(loadStateUpdate.getLoadType(), loadStateUpdate.getFromMediator(), loadStateUpdate.getLoadState());
                s sVar3 = this.$this_channelFlow$inlined;
                anonymousClass1.label = 3;
            }
        } else {
            if (i11 != 1 && i11 != 2 && i11 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(obj2);
        }
        return z.f17874a;
    }
}
