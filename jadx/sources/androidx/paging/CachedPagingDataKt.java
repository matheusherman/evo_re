package androidx.paging;

import androidx.annotation.CheckResult;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.multicast.Multicaster;
import c9.p;
import com.taobao.sophix.PatchStatus;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001aI\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "Landroidx/paging/PagingData;", "Lkotlinx/coroutines/l0;", "scope", "cachedIn", "(Lkotlinx/coroutines/flow/f;Lkotlinx/coroutines/l0;)Lkotlinx/coroutines/flow/f;", "Landroidx/paging/ActiveFlowTracker;", "tracker", "(Lkotlinx/coroutines/flow/f;Lkotlinx/coroutines/l0;Landroidx/paging/ActiveFlowTracker;)Lkotlinx/coroutines/flow/f;", "paging-common"}, k = 2, mv = {1, 4, 1})
public final class CachedPagingDataKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.CachedPagingDataKt$cachedIn$1", f = "CachedPagingData.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/PagingData;", "it", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1<T> extends l implements p<PagingData<T>, v8.f<? super z>, Object> {
        int label;

        AnonymousClass1(v8.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new AnonymousClass1(completion);
        }

        @Override // c9.p
        public final Object invoke(Object obj, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create(obj, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @CheckResult
    public static final <T> kotlinx.coroutines.flow.f<PagingData<T>> cachedIn(kotlinx.coroutines.flow.f<PagingData<T>> cachedIn, l0 scope) {
        m.f(cachedIn, "$this$cachedIn");
        m.f(scope, "scope");
        return cachedIn(cachedIn, scope, null);
    }

    public static final <T> kotlinx.coroutines.flow.f<PagingData<T>> cachedIn(final kotlinx.coroutines.flow.f<PagingData<T>> cachedIn, final l0 scope, ActiveFlowTracker activeFlowTracker) {
        m.f(cachedIn, "$this$cachedIn");
        m.f(scope, "scope");
        b0 b0Var = new b0();
        b0Var.element = null;
        final kotlinx.coroutines.flow.f fVarC = h.C(new kotlinx.coroutines.flow.f<MulticastedPagingData<T>>() { // from class: androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1

            /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
            public static final class AnonymousClass2 implements g<PagingData<T>> {
                final /* synthetic */ g $this_unsafeFlow$inlined;
                final /* synthetic */ CachedPagingDataKt$cachedIn$$inlined$map$1 this$0;

                /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1$2$1, reason: invalid class name */
                @f(c = "androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1$2", f = "CachedPagingData.kt", l = {PatchStatus.CODE_LOAD_LIB_UNZIP}, m = "emit")
                @Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "emit"}, k = 3, mv = {1, 4, 1})
                public static final class AnonymousClass1 extends d {
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

                    public AnonymousClass1(v8.f fVar) {
                        super(fVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(g gVar, CachedPagingDataKt$cachedIn$$inlined$map$1 cachedPagingDataKt$cachedIn$$inlined$map$1) {
                    this.$this_unsafeFlow$inlined = gVar;
                    this.this$0 = cachedPagingDataKt$cachedIn$$inlined$map$1;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.g
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
                        g gVar = this.$this_unsafeFlow$inlined;
                        MulticastedPagingData multicastedPagingData = new MulticastedPagingData(scope, (PagingData) obj, null, 4, null);
                        anonymousClass1.label = 1;
                        if (gVar.emit(multicastedPagingData, anonymousClass1) == objC) {
                            return objC;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r.b(obj2);
                    }
                    return z.f17874a;
                }
            }

            @Override // kotlinx.coroutines.flow.f
            public Object collect(g gVar, v8.f fVar) {
                Object objCollect = cachedIn.collect(new AnonymousClass2(gVar, this), fVar);
                return objCollect == b.c() ? objCollect : z.f17874a;
            }
        }, new CachedPagingDataKt$cachedIn$multicastedFlow$2(b0Var, null));
        return new Multicaster(scope, 1, h.B(h.D(new kotlinx.coroutines.flow.f<PagingData<T>>() { // from class: androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$2

            /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
            public static final class AnonymousClass2 implements g<MulticastedPagingData<T>> {
                final /* synthetic */ g $this_unsafeFlow$inlined;
                final /* synthetic */ CachedPagingDataKt$cachedIn$$inlined$map$2 this$0;

                /* JADX INFO: renamed from: androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$2$2$1, reason: invalid class name */
                @f(c = "androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$2$2", f = "CachedPagingData.kt", l = {PatchStatus.CODE_LOAD_LIB_UNZIP}, m = "emit")
                @Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "emit"}, k = 3, mv = {1, 4, 1})
                public static final class AnonymousClass1 extends d {
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

                    public AnonymousClass1(v8.f fVar) {
                        super(fVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(g gVar, CachedPagingDataKt$cachedIn$$inlined$map$2 cachedPagingDataKt$cachedIn$$inlined$map$2) {
                    this.$this_unsafeFlow$inlined = gVar;
                    this.this$0 = cachedPagingDataKt$cachedIn$$inlined$map$2;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.g
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
                        g gVar = this.$this_unsafeFlow$inlined;
                        PagingData<T> pagingDataAsPagingData = ((MulticastedPagingData) obj).asPagingData();
                        anonymousClass1.label = 1;
                        if (gVar.emit(pagingDataAsPagingData, anonymousClass1) == objC) {
                            return objC;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r.b(obj2);
                    }
                    return z.f17874a;
                }
            }

            @Override // kotlinx.coroutines.flow.f
            public Object collect(g gVar, v8.f fVar) {
                Object objCollect = fVarC.collect(new AnonymousClass2(gVar, this), fVar);
                return objCollect == b.c() ? objCollect : z.f17874a;
            }
        }, new CachedPagingDataKt$cachedIn$multicastedFlow$4(activeFlowTracker, null)), new CachedPagingDataKt$cachedIn$multicastedFlow$5(activeFlowTracker, null)), false, new AnonymousClass1(null), true, 8, null).getFlow();
    }

    public static /* synthetic */ kotlinx.coroutines.flow.f cachedIn$default(kotlinx.coroutines.flow.f fVar, l0 l0Var, ActiveFlowTracker activeFlowTracker, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            activeFlowTracker = null;
        }
        return cachedIn(fVar, l0Var, activeFlowTracker);
    }
}
