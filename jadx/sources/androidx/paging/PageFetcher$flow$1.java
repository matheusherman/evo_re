package androidx.paging;

import c9.p;
import c9.q;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [Value] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.PageFetcher$flow$1", f = "PageFetcher.kt", l = {253}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/channels/s;", "Landroidx/paging/PagingData;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class PageFetcher$flow$1<Value> extends l implements p<s<? super PagingData<Value>>, v8.f<? super z>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PageFetcher this$0;

    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PageFetcher$flow$1$1", f = "PageFetcher.kt", l = {63, 63}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends l implements p<g<? super Boolean>, v8.f<? super z>, Object> {
        final /* synthetic */ RemoteMediatorAccessor $remoteMediatorAccessor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RemoteMediatorAccessor remoteMediatorAccessor, v8.f fVar) {
            super(2, fVar);
            this.$remoteMediatorAccessor = remoteMediatorAccessor;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$remoteMediatorAccessor, completion);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // c9.p
        public final Object invoke(g<? super Boolean> gVar, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0043  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        
            if (r7 == r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        
            if (r1.emit(r7, r6) == r0) goto L23;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            g gVar;
            RemoteMediator.InitializeAction initializeAction;
            Object objC = b.c();
            int i10 = this.label;
            boolean z10 = true;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    gVar = (g) this.L$0;
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            gVar = (g) this.L$0;
            RemoteMediatorAccessor remoteMediatorAccessor = this.$remoteMediatorAccessor;
            if (remoteMediatorAccessor != null) {
                this.L$0 = gVar;
                this.label = 1;
                obj = remoteMediatorAccessor.initialize(this);
            } else {
                initializeAction = null;
                if (initializeAction != RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) {
                    z10 = false;
                }
                Boolean boolA = kotlin.coroutines.jvm.internal.b.a(z10);
                this.L$0 = null;
                this.label = 2;
            }
            return objC;
            initializeAction = (RemoteMediator.InitializeAction) obj;
            if (initializeAction != RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) {
                z10 = false;
            }
            Boolean boolA2 = kotlin.coroutines.jvm.internal.b.a(z10);
            this.L$0 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [Key] */
    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PageFetcher$flow$1$2", f = "PageFetcher.kt", l = {68, 72, 76}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "Value", "", "previousGeneration", "triggerRemoteRefresh", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass2<Key> extends l implements q<PageFetcher.GenerationInfo<Key, Value>, Boolean, v8.f<? super PageFetcher.GenerationInfo<Key, Value>>, Object> {
        final /* synthetic */ RemoteMediatorAccessor $remoteMediatorAccessor;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        private /* synthetic */ boolean Z$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Lr8/z;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        static final /* synthetic */ class AnonymousClass1 extends k implements c9.a<z> {
            @Override // c9.a
            public /* bridge */ /* synthetic */ z invoke() {
                invoke2();
                return z.f17874a;
            }

            AnonymousClass1(PageFetcher pageFetcher) {
                super(0, pageFetcher, PageFetcher.class, "refresh", "refresh()V", 0);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((PageFetcher) this.receiver).refresh();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RemoteMediatorAccessor remoteMediatorAccessor, v8.f fVar) {
            super(3, fVar);
            this.$remoteMediatorAccessor = remoteMediatorAccessor;
        }

        public final v8.f<z> create(PageFetcher.GenerationInfo<Key, Value> generationInfo, boolean z10, v8.f<? super PageFetcher.GenerationInfo<Key, Value>> continuation) {
            m.f(continuation, "continuation");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$remoteMediatorAccessor, continuation);
            anonymousClass2.L$0 = generationInfo;
            anonymousClass2.Z$0 = z10;
            return anonymousClass2;
        }

        @Override // c9.q
        public final Object invoke(Object obj, Boolean bool, Object obj2) {
            return ((AnonymousClass2) create((PageFetcher.GenerationInfo) obj, bool.booleanValue(), (v8.f) obj2)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:44:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:46:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:51:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:56:0x00ee  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r15v6, types: [T, androidx.paging.PagingSource] */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            PageFetcher.GenerationInfo generationInfo;
            boolean z10;
            PagingSource<Key, Value> pagingSource$paging_common;
            b0 b0Var;
            b0 b0Var2;
            PageFetcherSnapshot<Key, Value> snapshot;
            boolean z11;
            PagingState<Key, Value> state;
            PageFetcherSnapshot<Key, Value> snapshot2;
            boolean z12;
            b0 b0Var3;
            PageFetcher.GenerationInfo generationInfo2;
            PagingSource<Key, Value> pagingSource$paging_common2;
            PageFetcherSnapshot<Key, Value> snapshot3;
            Integer anchorPosition;
            Object refreshKey;
            PageFetcherSnapshot<Key, Value> snapshot4;
            PagingState<Key, Value> state2;
            Object objC = b.c();
            int i10 = this.label;
            Integer anchorPosition2 = null;
            if (i10 != 0) {
                if (i10 != 1 && i10 != 2) {
                    if (i10 == 3) {
                        z12 = this.Z$0;
                        b0Var3 = (b0) this.L$1;
                        generationInfo2 = (PageFetcher.GenerationInfo) this.L$0;
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    z10 = this.Z$0;
                    b0Var2 = (b0) this.L$2;
                    b0Var = (b0) this.L$1;
                    generationInfo = (PageFetcher.GenerationInfo) this.L$0;
                    r.b(obj);
                }
                state = (PagingState) obj;
                z11 = z12;
                b0Var = b0Var3;
                generationInfo = generationInfo2;
                if (state != null) {
                    anchorPosition = state.getAnchorPosition();
                } else {
                    anchorPosition = null;
                }
                if (anchorPosition == null) {
                    if (generationInfo != null && (state2 = generationInfo.getState()) != null) {
                        anchorPosition2 = state2.getAnchorPosition();
                    }
                    if (anchorPosition2 != null) {
                        state = generationInfo.getState();
                    }
                }
                if (state != null || (refreshKey = ((PagingSource) b0Var.element).getRefreshKey(state)) == null) {
                    refreshKey = PageFetcher$flow$1.this.this$0.initialKey;
                }
                if (generationInfo != null && (snapshot4 = generationInfo.getSnapshot()) != null) {
                    snapshot4.close();
                }
                return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(refreshKey, (PagingSource) b0Var.element, PageFetcher$flow$1.this.this$0.config, PageFetcher$flow$1.this.this$0.retryEvents.getFlow(), z11, this.$remoteMediatorAccessor, new AnonymousClass1(PageFetcher$flow$1.this.this$0)), state);
            }
            r.b(obj);
            generationInfo = (PageFetcher.GenerationInfo) this.L$0;
            z10 = this.Z$0;
            b0 b0Var4 = new b0();
            PageFetcher pageFetcher = PageFetcher$flow$1.this.this$0;
            if (generationInfo != null && (snapshot = generationInfo.getSnapshot()) != null) {
                pagingSource$paging_common = snapshot.getPagingSource$paging_common();
            } else {
                pagingSource$paging_common = null;
            }
            this.L$0 = generationInfo;
            this.L$1 = b0Var4;
            this.L$2 = b0Var4;
            this.Z$0 = z10;
            this.label = 1;
            Object objGenerateNewPagingSource = pageFetcher.generateNewPagingSource(pagingSource$paging_common, this);
            if (objGenerateNewPagingSource != objC) {
                b0Var = b0Var4;
                obj = objGenerateNewPagingSource;
                b0Var2 = b0Var;
            }
            return objC;
            while (true) {
                b0Var2.element = (PagingSource) obj;
                if (((PagingSource) b0Var.element).getInvalid()) {
                    PageFetcher pageFetcher2 = PageFetcher$flow$1.this.this$0;
                    if (generationInfo != null && (snapshot3 = generationInfo.getSnapshot()) != null) {
                        pagingSource$paging_common2 = snapshot3.getPagingSource$paging_common();
                    } else {
                        pagingSource$paging_common2 = null;
                    }
                    this.L$0 = generationInfo;
                    this.L$1 = b0Var;
                    this.L$2 = b0Var;
                    this.Z$0 = z10;
                    this.label = 2;
                    obj = pageFetcher2.generateNewPagingSource(pagingSource$paging_common2, this);
                    if (obj != objC) {
                        b0Var2 = b0Var;
                    }
                } else if (generationInfo != null && (snapshot2 = generationInfo.getSnapshot()) != null) {
                    this.L$0 = generationInfo;
                    this.L$1 = b0Var;
                    this.L$2 = null;
                    this.Z$0 = z10;
                    this.label = 3;
                    obj = snapshot2.refreshKeyInfo(this);
                    if (obj != objC) {
                        z12 = z10;
                        b0Var3 = b0Var;
                        generationInfo2 = generationInfo;
                        state = (PagingState) obj;
                        z11 = z12;
                        b0Var = b0Var3;
                        generationInfo = generationInfo2;
                        break;
                    }
                } else {
                    z11 = z10;
                    state = null;
                    break;
                }
                return objC;
            }
            if (state != null) {
                anchorPosition = state.getAnchorPosition();
            } else {
                anchorPosition = null;
            }
            if (anchorPosition == null) {
                if (generationInfo != null) {
                    anchorPosition2 = state2.getAnchorPosition();
                }
                if (anchorPosition2 != null) {
                    state = generationInfo.getState();
                }
            }
            if (state != null) {
                refreshKey = PageFetcher$flow$1.this.this$0.initialKey;
            } else {
                refreshKey = PageFetcher$flow$1.this.this$0.initialKey;
            }
            if (generationInfo != null) {
                snapshot4.close();
            }
            return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(refreshKey, (PagingSource) b0Var.element, PageFetcher$flow$1.this.this$0.config, PageFetcher$flow$1.this.this$0.retryEvents.getFlow(), z11, this.$remoteMediatorAccessor, new AnonymousClass1(PageFetcher$flow$1.this.this$0)), state);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [Key] */
    /* JADX INFO: renamed from: androidx.paging.PageFetcher$flow$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PageFetcher$flow$1$3", f = "PageFetcher.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\b\b\u0001\u0010\u0002*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/paging/PagingData;", "Value", "Key", "", "generation", "Landroidx/paging/PageFetcher$GenerationInfo;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass3<Key> extends l implements p<PageFetcher.GenerationInfo<Key, Value>, v8.f<? super PagingData<Value>>, Object> {
        final /* synthetic */ RemoteMediatorAccessor $remoteMediatorAccessor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(RemoteMediatorAccessor remoteMediatorAccessor, v8.f fVar) {
            super(2, fVar);
            this.$remoteMediatorAccessor = remoteMediatorAccessor;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$remoteMediatorAccessor, completion);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // c9.p
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass3) create(obj, (v8.f) obj2)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                PageFetcher.GenerationInfo generationInfo = (PageFetcher.GenerationInfo) this.L$0;
                return new PagingData(PageFetcher$flow$1.this.this$0.injectRemoteEvents(generationInfo.getSnapshot(), this.$remoteMediatorAccessor), new PageFetcher.PagerUiReceiver(PageFetcher$flow$1.this.this$0, generationInfo.getSnapshot(), PageFetcher$flow$1.this.this$0.retryEvents));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcher$flow$1(PageFetcher pageFetcher, v8.f fVar) {
        super(2, fVar);
        this.this$0 = pageFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        PageFetcher$flow$1 pageFetcher$flow$1 = new PageFetcher$flow$1(this.this$0, completion);
        pageFetcher$flow$1.L$0 = obj;
        return pageFetcher$flow$1;
    }

    @Override // c9.p
    public final Object invoke(Object obj, v8.f<? super z> fVar) {
        return ((PageFetcher$flow$1) create(obj, fVar)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        RemoteMediatorAccessor RemoteMediatorAccessor;
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
            final s sVar = (s) this.L$0;
            RemoteMediator remoteMediator = this.this$0.remoteMediator;
            if (remoteMediator != null) {
                RemoteMediatorAccessor = RemoteMediatorAccessorKt.RemoteMediatorAccessor(sVar, remoteMediator);
            } else {
                RemoteMediatorAccessor = null;
            }
            kotlinx.coroutines.flow.f fVarA = h.A(h.r(h.G(h.D(this.this$0.refreshEvents.getFlow(), new AnonymousClass1(RemoteMediatorAccessor, null)), null, new AnonymousClass2(RemoteMediatorAccessor, null))), new AnonymousClass3(RemoteMediatorAccessor, null));
            g<PagingData<Value>> gVar = new g<PagingData<Value>>() { // from class: androidx.paging.PageFetcher$flow$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.g
                public Object emit(Object obj2, v8.f fVar) {
                    Object objB = sVar.b((PagingData) obj2, fVar);
                    return objB == b.c() ? objB : z.f17874a;
                }
            };
            this.label = 1;
            if (fVarA.collect(gVar, this) == objC) {
                return objC;
            }
        }
        return z.f17874a;
    }
}
