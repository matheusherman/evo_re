package androidx.paging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1", f = "PageFetcherSnapshot.kt", l = {590, 161, TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/channels/s;", "Landroidx/paging/PageEvent;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class PageFetcherSnapshot$pageEventFlow$1<Value> extends l implements p<s<? super PageEvent<Value>>, v8.f<? super z>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PageFetcherSnapshot this$0;

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2", f = "PageFetcherSnapshot.kt", l = {584}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass2 extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ s $this_cancelableChannelFlow;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(s sVar, v8.f fVar) {
            super(2, fVar);
            this.$this_cancelableChannelFlow = sVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new AnonymousClass2(this.$this_cancelableChannelFlow, completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((AnonymousClass2) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                kotlinx.coroutines.flow.f fVarL = h.l(PageFetcherSnapshot$pageEventFlow$1.this.this$0.pageEventCh);
                PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1 pageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1 = new PageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1(this);
                this.label = 1;
                if (fVarL.collect(pageFetcherSnapshot$pageEventFlow$1$2$invokeSuspend$$inlined$collect$1, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3", f = "PageFetcherSnapshot.kt", l = {584}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass3 extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ d $retryChannel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(d dVar, v8.f fVar) {
            super(2, fVar);
            this.$retryChannel = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new AnonymousClass3(this.$retryChannel, completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((AnonymousClass3) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                kotlinx.coroutines.flow.f fVar = PageFetcherSnapshot$pageEventFlow$1.this.this$0.retryFlow;
                g<z> gVar = new g<z>() { // from class: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3$invokeSuspend$$inlined$collect$1
                    @Override // kotlinx.coroutines.flow.g
                    public Object emit(z zVar, v8.f fVar2) {
                        this.this$0.$retryChannel.offer(zVar);
                        return z.f17874a;
                    }
                };
                this.label = 1;
                if (fVar.collect(gVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4", f = "PageFetcherSnapshot.kt", l = {584}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass4 extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ d $retryChannel;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(d dVar, v8.f fVar) {
            super(2, fVar);
            this.$retryChannel = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$retryChannel, completion);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((AnonymousClass4) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                l0 l0Var = (l0) this.L$0;
                kotlinx.coroutines.flow.f fVarL = h.l(this.$retryChannel);
                PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 pageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 = new PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1(this, l0Var);
                this.label = 1;
                if (fVarL.collect(pageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcherSnapshot$pageEventFlow$1(PageFetcherSnapshot pageFetcherSnapshot, v8.f fVar) {
        super(2, fVar);
        this.this$0 = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        PageFetcherSnapshot$pageEventFlow$1 pageFetcherSnapshot$pageEventFlow$1 = new PageFetcherSnapshot$pageEventFlow$1(this.this$0, completion);
        pageFetcherSnapshot$pageEventFlow$1.L$0 = obj;
        return pageFetcherSnapshot$pageEventFlow$1;
    }

    @Override // c9.p
    public final Object invoke(Object obj, v8.f<? super z> fVar) {
        return ((PageFetcherSnapshot$pageEventFlow$1) create(obj, fVar)).invokeSuspend(z.f17874a);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:38:0x010a  */
    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        s sVar;
        RemoteMediatorConnection remoteMediatorConnection;
        PageFetcherSnapshotState.Holder holder;
        kotlinx.coroutines.sync.a aVar;
        s sVar2;
        RemoteMediatorConnection remoteMediatorConnection2;
        PageFetcherSnapshot pageFetcherSnapshot;
        s sVar3;
        PageFetcherSnapshotState.Holder holder2;
        kotlinx.coroutines.sync.a aVar2;
        s sVar4;
        PageFetcherSnapshotState.Holder holder3;
        LoadState loadState;
        Object objC = b.c();
        int i10 = this.label;
        try {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            kotlinx.coroutines.sync.a aVar3 = (kotlinx.coroutines.sync.a) this.L$2;
                            holder3 = (PageFetcherSnapshotState.Holder) this.L$1;
                            sVar4 = (s) this.L$0;
                            r.b(obj);
                            aVar2 = aVar3;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        sVar3 = (s) this.L$0;
                        r.b(obj);
                        holder2 = this.this$0.stateHolder;
                        aVar2 = holder2.lock;
                        this.L$0 = sVar3;
                        this.L$1 = holder2;
                        this.L$2 = aVar2;
                        this.label = 3;
                        if (aVar2.a(null, this) != objC) {
                            sVar4 = sVar3;
                            holder3 = holder2;
                        }
                        return objC;
                    }
                } else {
                    aVar = (kotlinx.coroutines.sync.a) this.L$3;
                    holder = (PageFetcherSnapshotState.Holder) this.L$2;
                    remoteMediatorConnection2 = (RemoteMediatorConnection) this.L$1;
                    sVar2 = (s) this.L$0;
                    r.b(obj);
                }
                try {
                    loadState = holder3.state.getSourceLoadStates().get$paging_common(LoadType.REFRESH);
                    aVar2.b(null);
                    if (!(loadState instanceof LoadState.Error)) {
                        this.this$0.startConsumingHints(sVar4);
                    }
                    return z.f17874a;
                } catch (Throwable th) {
                    aVar2.b(null);
                    throw th;
                }
            }
            r.b(obj);
            sVar = (s) this.L$0;
            if (this.this$0.pageEventChCollected.compareAndSet(false, true)) {
                j.d(sVar, null, null, new AnonymousClass2(sVar, null), 3, null);
                d dVarB = kotlinx.coroutines.channels.g.b(0, null, null, 6, null);
                j.d(sVar, null, null, new AnonymousClass3(dVarB, null), 3, null);
                j.d(sVar, null, null, new AnonymousClass4(dVarB, null), 3, null);
                if (this.this$0.triggerRemoteRefresh && (remoteMediatorConnection = this.this$0.getRemoteMediatorConnection()) != null) {
                    PageFetcherSnapshotState.Holder holder4 = this.this$0.stateHolder;
                    kotlinx.coroutines.sync.a aVar4 = holder4.lock;
                    this.L$0 = sVar;
                    this.L$1 = remoteMediatorConnection;
                    this.L$2 = holder4;
                    this.L$3 = aVar4;
                    this.label = 1;
                    if (aVar4.a(null, this) != objC) {
                        holder = holder4;
                        aVar = aVar4;
                        sVar2 = sVar;
                        remoteMediatorConnection2 = remoteMediatorConnection;
                    }
                } else {
                    pageFetcherSnapshot = this.this$0;
                    this.L$0 = sVar;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 2;
                    if (pageFetcherSnapshot.doInitialLoad(this) != objC) {
                        sVar3 = sVar;
                        holder2 = this.this$0.stateHolder;
                        aVar2 = holder2.lock;
                        this.L$0 = sVar3;
                        this.L$1 = holder2;
                        this.L$2 = aVar2;
                        this.label = 3;
                        if (aVar2.a(null, this) != objC) {
                            sVar4 = sVar3;
                            holder3 = holder2;
                            loadState = holder3.state.getSourceLoadStates().get$paging_common(LoadType.REFRESH);
                            aVar2.b(null);
                            if (!(loadState instanceof LoadState.Error)) {
                                this.this$0.startConsumingHints(sVar4);
                            }
                            return z.f17874a;
                        }
                    }
                }
                return objC;
            }
            throw new IllegalStateException("Attempt to collect twice from pageEventFlow, which is an illegal operation. Did you forget to call Flow<PagingData<*>>.cachedIn(coroutineScope)?");
            PagingState pagingStateCurrentPagingState$paging_common = holder.state.currentPagingState$paging_common(null);
            aVar.b(null);
            remoteMediatorConnection2.requestLoad(LoadType.REFRESH, pagingStateCurrentPagingState$paging_common);
            sVar = sVar2;
            pageFetcherSnapshot = this.this$0;
            this.L$0 = sVar;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            if (pageFetcherSnapshot.doInitialLoad(this) != objC) {
                sVar3 = sVar;
                holder2 = this.this$0.stateHolder;
                aVar2 = holder2.lock;
                this.L$0 = sVar3;
                this.L$1 = holder2;
                this.L$2 = aVar2;
                this.label = 3;
                if (aVar2.a(null, this) != objC) {
                    sVar4 = sVar3;
                    holder3 = holder2;
                    loadState = holder3.state.getSourceLoadStates().get$paging_common(LoadType.REFRESH);
                    aVar2.b(null);
                    if (!(loadState instanceof LoadState.Error)) {
                        this.this$0.startConsumingHints(sVar4);
                    }
                    return z.f17874a;
                }
            }
            return objC;
        } catch (Throwable th2) {
            aVar.b(null);
            throw th2;
        }
    }
}
