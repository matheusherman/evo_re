package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.q;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.u;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1", f = "PageFetcherSnapshot.kt", l = {223, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/g;", "it", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1 extends l implements q<g<? super GenerationalViewportHint>, Integer, v8.f<? super z>, Object> {
    final /* synthetic */ LoadType $loadType$inlined;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private g p$;
    private Object p$0;
    final /* synthetic */ PageFetcherSnapshot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1(v8.f fVar, PageFetcherSnapshot pageFetcherSnapshot, LoadType loadType) {
        super(3, fVar);
        this.this$0 = pageFetcherSnapshot;
        this.$loadType$inlined = loadType;
    }

    public final v8.f<z> create(g<? super GenerationalViewportHint> gVar, Integer num, v8.f<? super z> fVar) {
        PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1 pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1(fVar, this.this$0, this.$loadType$inlined);
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1.p$ = gVar;
        pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1.p$0 = num;
        return pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1;
    }

    @Override // c9.q
    public final Object invoke(g<? super GenerationalViewportHint> gVar, Integer num, v8.f<? super z> fVar) {
        return ((PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1) create(gVar, num, fVar)).invokeSuspend(z.f17874a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b8, code lost:
    
        if (r12.collect(r7, r11) == r0) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        g<? super GenerationalViewportHint> gVar;
        final int iIntValue;
        PageFetcherSnapshotState.Holder holder;
        kotlinx.coroutines.sync.a aVar;
        kotlinx.coroutines.flow.f<GenerationalViewportHint> fVarX;
        Object objC = b.c();
        int i10 = this.label;
        int i11 = 1;
        try {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    iIntValue = this.I$0;
                    aVar = (kotlinx.coroutines.sync.a) this.L$2;
                    holder = (PageFetcherSnapshotState.Holder) this.L$1;
                    gVar = (g) this.L$0;
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            gVar = this.p$;
            iIntValue = ((Number) this.p$0).intValue();
            holder = this.this$0.stateHolder;
            aVar = holder.lock;
            this.L$0 = gVar;
            this.L$1 = holder;
            this.L$2 = aVar;
            this.I$0 = iIntValue;
            this.label = 1;
            if (aVar.a(null, this) != objC) {
            }
            return objC;
            PageFetcherSnapshotState pageFetcherSnapshotState = holder.state;
            LoadState loadState = pageFetcherSnapshotState.getSourceLoadStates().get$paging_common(this.$loadType$inlined);
            LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
            if (m.a(loadState, companion.getComplete$paging_common())) {
                fVarX = h.x(new GenerationalViewportHint[0]);
                aVar.b(null);
            } else {
                if (!(pageFetcherSnapshotState.getSourceLoadStates().get$paging_common(this.$loadType$inlined) instanceof LoadState.Error)) {
                    pageFetcherSnapshotState.setSourceLoadState(this.$loadType$inlined, companion.getIncomplete$paging_common());
                }
                z zVar = z.f17874a;
                aVar.b(null);
                u uVar = this.this$0.hintSharedFlow;
                if (iIntValue == 0) {
                    i11 = 0;
                }
                final kotlinx.coroutines.flow.f fVarN = h.n(uVar, i11);
                fVarX = new kotlinx.coroutines.flow.f<GenerationalViewportHint>() { // from class: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1$lambda$1

                    /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1$lambda$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "androidx/paging/PageFetcherSnapshot$$special$$inlined$map$1$2", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
                    public static final class AnonymousClass1 implements g<ViewportHint> {
                        final /* synthetic */ g $this_unsafeFlow$inlined;
                        final /* synthetic */ PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1$lambda$1 this$0;

                        /* JADX INFO: renamed from: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1$lambda$1$1$1, reason: invalid class name and collision with other inner class name */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "androidx/paging/PageFetcherSnapshot$$special$$inlined$map$1$2$1", "emit"}, k = 3, mv = {1, 4, 1})
                        public static final class C00181 extends d {
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            Object L$5;
                            Object L$6;
                            Object L$7;
                            int label;
                            /* synthetic */ Object result;

                            public C00181(v8.f fVar) {
                                super(fVar);
                            }

                            @Override // kotlin.coroutines.jvm.internal.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass1.this.emit(null, this);
                            }
                        }

                        public AnonymousClass1(g gVar, PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1$lambda$1 pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1$lambda$1) {
                            this.$this_unsafeFlow$inlined = gVar;
                            this.this$0 = pageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$flatMapLatest$1$lambda$1;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.g
                        public Object emit(ViewportHint viewportHint, v8.f fVar) {
                            C00181 c00181;
                            if (fVar instanceof C00181) {
                                c00181 = (C00181) fVar;
                                int i10 = c00181.label;
                                if ((i10 & Integer.MIN_VALUE) != 0) {
                                    c00181.label = i10 - Integer.MIN_VALUE;
                                } else {
                                    c00181 = new C00181(fVar);
                                }
                            } else {
                                c00181 = new C00181(fVar);
                            }
                            Object obj = c00181.result;
                            Object objC = b.c();
                            int i11 = c00181.label;
                            if (i11 == 0) {
                                r.b(obj);
                                g gVar = this.$this_unsafeFlow$inlined;
                                GenerationalViewportHint generationalViewportHint = new GenerationalViewportHint(iIntValue, viewportHint);
                                c00181.label = 1;
                                if (gVar.emit(generationalViewportHint, c00181) == objC) {
                                    return objC;
                                }
                            } else {
                                if (i11 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                r.b(obj);
                            }
                            return z.f17874a;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.f
                    public Object collect(g<? super GenerationalViewportHint> gVar2, v8.f fVar) {
                        Object objCollect = fVarN.collect(new AnonymousClass1(gVar2, this), fVar);
                        return objCollect == b.c() ? objCollect : z.f17874a;
                    }
                };
            }
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
        } catch (Throwable th) {
            aVar.b(null);
            throw th;
        }
    }
}
