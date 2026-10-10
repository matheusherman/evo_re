package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.l;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.h;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m1;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$transform$$inlined$map$3", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
public final class PagingDataTransforms$map$$inlined$transform$2<R> implements f<PageEvent<R>> {
    final /* synthetic */ Executor $executor$inlined;
    final /* synthetic */ f $this_unsafeTransform$inlined;
    final /* synthetic */ l $transform$inlined$1;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$transform$$inlined$map$3$2", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
    public static final class AnonymousClass2<T> implements g<PageEvent<T>> {
        final /* synthetic */ g $this_unsafeFlow$inlined;
        final /* synthetic */ PagingDataTransforms$map$$inlined$transform$2 this$0;

        /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$1, reason: invalid class name */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2", f = "PagingDataTransforms.kt", l = {136, 136}, m = "emit")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "androidx/paging/PagingDataTransforms$transform$$inlined$map$3$2$1", "emit"}, k = 3, mv = {1, 4, 1})
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

        public AnonymousClass2(g gVar, PagingDataTransforms$map$$inlined$transform$2 pagingDataTransforms$map$$inlined$transform$2) {
            this.$this_unsafeFlow$inlined = gVar;
            this.this$0 = pagingDataTransforms$map$$inlined$transform$2;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
        
            if (r9.emit(r10, r0) == r1) goto L22;
         */
        @Override // kotlinx.coroutines.flow.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object emit(Object obj, v8.f fVar) {
            AnonymousClass1 anonymousClass1;
            g gVar;
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
                    g gVar2 = (g) anonymousClass1.L$0;
                    r.b(obj2);
                    gVar = gVar2;
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r.b(obj2);
                }
                return z.f17874a;
            }
            r.b(obj2);
            g gVar3 = this.$this_unsafeFlow$inlined;
            i0 i0VarA = m1.a(this.this$0.$executor$inlined);
            PagingDataTransforms$map$$inlined$transform$2$2$lambda$1 pagingDataTransforms$map$$inlined$transform$2$2$lambda$1 = new PagingDataTransforms$map$$inlined$transform$2$2$lambda$1((PageEvent) obj, null, this);
            anonymousClass1.L$0 = gVar3;
            anonymousClass1.label = 1;
            Object objG = h.g(i0VarA, pagingDataTransforms$map$$inlined$transform$2$2$lambda$1, anonymousClass1);
            if (objG != objC) {
                obj2 = objG;
                gVar = gVar3;
            }
            return objC;
            anonymousClass1.L$0 = null;
            anonymousClass1.label = 2;
        }
    }

    public PagingDataTransforms$map$$inlined$transform$2(f fVar, Executor executor, l lVar) {
        this.$this_unsafeTransform$inlined = fVar;
        this.$executor$inlined = executor;
        this.$transform$inlined$1 = lVar;
    }

    @Override // kotlinx.coroutines.flow.f
    public Object collect(g gVar, v8.f fVar) {
        Object objCollect = this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(gVar, this), fVar);
        return objCollect == b.c() ? objCollect : z.f17874a;
    }
}
