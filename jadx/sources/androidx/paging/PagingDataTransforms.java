package androidx.paging;

import androidx.annotation.CheckResult;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import c9.q;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.h;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m1;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001ai\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000320\b\u0004\u0010\u0007\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004H\u0082\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aZ\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\b\u001aO\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH\u0007¢\u0006\u0004\b\t\u0010\r\u001a`\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032(\u0010\u0007\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\b\u001aU\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e0\fH\u0007¢\u0006\u0004\b\u000f\u0010\r\u001aP\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\b\u001aE\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\fH\u0007¢\u0006\u0004\b\u0012\u0010\r\u001af\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0000\u0010\u0001*\u00028\u0001\"\b\b\u0001\u0010\u0002*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032.\u0010\u0014\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a[\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u000b\u001a\u00020\n2\u001e\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0007¢\u0006\u0004\b\u0015\u0010\u0017\u001a1\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0018\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a1\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0018\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u001b\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "R", "Landroidx/paging/PagingData;", "Lkotlin/Function2;", "Landroidx/paging/PageEvent;", "Lv8/f;", "transform", "(Landroidx/paging/PagingData;Lc9/p;)Landroidx/paging/PagingData;", "map", "Ljava/util/concurrent/Executor;", "executor", "Lkotlin/Function1;", "(Landroidx/paging/PagingData;Ljava/util/concurrent/Executor;Lc9/l;)Landroidx/paging/PagingData;", "", "flatMap", "", "predicate", "filter", "Lkotlin/Function3;", "generator", "insertSeparators", "(Landroidx/paging/PagingData;Lc9/q;)Landroidx/paging/PagingData;", "(Landroidx/paging/PagingData;Ljava/util/concurrent/Executor;Lc9/p;)Landroidx/paging/PagingData;", "item", "insertHeaderItem", "(Landroidx/paging/PagingData;Ljava/lang/Object;)Landroidx/paging/PagingData;", "insertFooterItem", "paging-common"}, k = 2, mv = {1, 4, 1})
public final class PagingDataTransforms {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertFooterItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PagingDataTransforms$insertFooterItem$1", f = "PagingDataTransforms.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0001H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "<anonymous parameter 0>", "after", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1<T> extends l implements q<T, T, v8.f<? super T>, Object> {
        final /* synthetic */ Object $item;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, v8.f fVar) {
            super(3, fVar);
            this.$item = obj;
        }

        public final v8.f<z> create(T t10, T t11, v8.f<? super T> continuation) {
            m.f(continuation, "continuation");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$item, continuation);
            anonymousClass1.L$0 = t11;
            return anonymousClass1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.q
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ((AnonymousClass1) create(obj, obj2, (v8.f) obj3)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                if (this.L$0 == null) {
                    return this.$item;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertHeaderItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PagingDataTransforms$insertHeaderItem$1", f = "PagingDataTransforms.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0001H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "before", "<anonymous parameter 1>", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class C05591<T> extends l implements q<T, T, v8.f<? super T>, Object> {
        final /* synthetic */ Object $item;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05591(Object obj, v8.f fVar) {
            super(3, fVar);
            this.$item = obj;
        }

        public final v8.f<z> create(T t10, T t11, v8.f<? super T> continuation) {
            m.f(continuation, "continuation");
            C05591 c05591 = new C05591(this.$item, continuation);
            c05591.L$0 = t10;
            return c05591;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.q
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ((C05591) create(obj, obj2, (v8.f) obj3)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                if (this.L$0 == null) {
                    return this.$item;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertSeparators$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PagingDataTransforms$insertSeparators$1", f = "PagingDataTransforms.kt", l = {240}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00032\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "R", "", ExifInterface.GPS_DIRECTION_TRUE, "before", "after", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class C05601<R, T> extends l implements q<T, T, v8.f<? super R>, Object> {
        final /* synthetic */ Executor $executor;
        final /* synthetic */ p $generator;
        private /* synthetic */ Object L$0;
        private /* synthetic */ Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$insertSeparators$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "androidx.paging.PagingDataTransforms$insertSeparators$1$1", f = "PagingDataTransforms.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        static final class C00191 extends l implements p<l0, v8.f<? super R>, Object> {
            final /* synthetic */ Object $after;
            final /* synthetic */ Object $before;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00191(Object obj, Object obj2, v8.f fVar) {
                super(2, fVar);
                this.$before = obj;
                this.$after = obj2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> completion) {
                m.f(completion, "completion");
                return new C00191(this.$before, this.$after, completion);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, Object obj) {
                return ((C00191) create(l0Var, (v8.f) obj)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                b.c();
                if (this.label == 0) {
                    r.b(obj);
                    return C05601.this.$generator.invoke(this.$before, this.$after);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05601(Executor executor, p pVar, v8.f fVar) {
            super(3, fVar);
            this.$executor = executor;
            this.$generator = pVar;
        }

        public final v8.f<z> create(T t10, T t11, v8.f<? super R> continuation) {
            m.f(continuation, "continuation");
            C05601 c05601 = new C05601(this.$executor, this.$generator, continuation);
            c05601.L$0 = t10;
            c05601.L$1 = t11;
            return c05601;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.q
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ((C05601) create(obj, obj2, (v8.f) obj3)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(obj);
            Object obj2 = this.L$0;
            Object obj3 = this.L$1;
            i0 i0VarA = m1.a(this.$executor);
            C00191 c00191 = new C00191(obj2, obj3, null);
            this.L$0 = null;
            this.label = 1;
            Object objG = h.g(i0VarA, c00191, this);
            if (objG == objC) {
                return objC;
            }
            return objG;
        }
    }

    @CheckResult
    public static final /* synthetic */ <T> PagingData<T> filter(PagingData<T> filter, final p<? super T, ? super v8.f<? super Boolean>, ? extends Object> predicate) {
        m.f(filter, "$this$filter");
        m.f(predicate, "predicate");
        final kotlinx.coroutines.flow.f<PageEvent<T>> flow$paging_common = filter.getFlow$paging_common();
        return new PagingData<>(new kotlinx.coroutines.flow.f<PageEvent<T>>() { // from class: androidx.paging.PagingDataTransforms$filter$$inlined$transform$1

            /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$filter$$inlined$transform$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$transform$$inlined$map$6$2", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
            public static final class AnonymousClass2 implements g<PageEvent<T>> {
                final /* synthetic */ g $this_unsafeFlow$inlined;
                final /* synthetic */ PagingDataTransforms$filter$$inlined$transform$1 this$0;

                /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$filter$$inlined$transform$1$2$1, reason: invalid class name */
                @f(c = "androidx.paging.PagingDataTransforms$filter$$inlined$transform$1$2", f = "PagingDataTransforms.kt", l = {136, 136}, m = "emit")
                @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "androidx/paging/PagingDataTransforms$transform$$inlined$map$6$2$1", "emit"}, k = 3, mv = {1, 4, 1})
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

                public AnonymousClass2(g gVar, PagingDataTransforms$filter$$inlined$transform$1 pagingDataTransforms$filter$$inlined$transform$1) {
                    this.$this_unsafeFlow$inlined = gVar;
                    this.this$0 = pagingDataTransforms$filter$$inlined$transform$1;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                
                    if (r7.emit(r8, r0) == r1) goto L22;
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
                    p<? super T, ? super v8.f<? super Boolean>, ? extends Object> pVar = predicate;
                    anonymousClass1.L$0 = gVar3;
                    anonymousClass1.label = 1;
                    Object objFilter = ((PageEvent) obj).filter(pVar, anonymousClass1);
                    if (objFilter != objC) {
                        obj2 = objFilter;
                        gVar = gVar3;
                    }
                    return objC;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                }
            }

            @Override // kotlinx.coroutines.flow.f
            public Object collect(g gVar, v8.f fVar) {
                Object objCollect = flow$paging_common.collect(new AnonymousClass2(gVar, this), fVar);
                return objCollect == b.c() ? objCollect : z.f17874a;
            }
        }, filter.getReceiver());
    }

    @CheckResult
    public static final /* synthetic */ <T, R> PagingData<R> flatMap(PagingData<T> flatMap, final p<? super T, ? super v8.f<? super Iterable<? extends R>>, ? extends Object> transform) {
        m.f(flatMap, "$this$flatMap");
        m.f(transform, "transform");
        final kotlinx.coroutines.flow.f<PageEvent<T>> flow$paging_common = flatMap.getFlow$paging_common();
        return new PagingData<>(new kotlinx.coroutines.flow.f<PageEvent<R>>() { // from class: androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$transform$$inlined$map$4$2", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
            public static final class AnonymousClass2<T> implements g<PageEvent<T>> {
                final /* synthetic */ g $this_unsafeFlow$inlined;
                final /* synthetic */ PagingDataTransforms$flatMap$$inlined$transform$1 this$0;

                /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1$2$1, reason: invalid class name */
                @f(c = "androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1$2", f = "PagingDataTransforms.kt", l = {136, 136}, m = "emit")
                @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "androidx/paging/PagingDataTransforms$transform$$inlined$map$4$2$1", "emit"}, k = 3, mv = {1, 4, 1})
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

                public AnonymousClass2(g gVar, PagingDataTransforms$flatMap$$inlined$transform$1 pagingDataTransforms$flatMap$$inlined$transform$1) {
                    this.$this_unsafeFlow$inlined = gVar;
                    this.this$0 = pagingDataTransforms$flatMap$$inlined$transform$1;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                
                    if (r7.emit(r8, r0) == r1) goto L22;
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
                    p<? super T, ? super v8.f<? super Iterable<? extends R>>, ? extends Object> pVar = transform;
                    anonymousClass1.L$0 = gVar3;
                    anonymousClass1.label = 1;
                    Object objFlatMap = ((PageEvent) obj).flatMap(pVar, anonymousClass1);
                    if (objFlatMap != objC) {
                        obj2 = objFlatMap;
                        gVar = gVar3;
                    }
                    return objC;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                }
            }

            @Override // kotlinx.coroutines.flow.f
            public Object collect(g gVar, v8.f fVar) {
                Object objCollect = flow$paging_common.collect(new AnonymousClass2(gVar, this), fVar);
                return objCollect == b.c() ? objCollect : z.f17874a;
            }
        }, flatMap.getReceiver());
    }

    @CheckResult
    public static final /* synthetic */ <T extends R, R> PagingData<R> insertSeparators(PagingData<T> insertSeparators, q<? super T, ? super T, ? super v8.f<? super R>, ? extends Object> generator) {
        m.f(insertSeparators, "$this$insertSeparators");
        m.f(generator, "generator");
        return new PagingData<>(SeparatorsKt.insertEventSeparators(insertSeparators.getFlow$paging_common(), generator), insertSeparators.getReceiver());
    }

    @CheckResult
    public static final /* synthetic */ <T, R> PagingData<R> map(PagingData<T> map, final p<? super T, ? super v8.f<? super R>, ? extends Object> transform) {
        m.f(map, "$this$map");
        m.f(transform, "transform");
        final kotlinx.coroutines.flow.f<PageEvent<T>> flow$paging_common = map.getFlow$paging_common();
        return new PagingData<>(new kotlinx.coroutines.flow.f<PageEvent<R>>() { // from class: androidx.paging.PagingDataTransforms$map$$inlined$transform$1

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$transform$$inlined$map$2$2", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
            public static final class AnonymousClass2<T> implements g<PageEvent<T>> {
                final /* synthetic */ g $this_unsafeFlow$inlined;
                final /* synthetic */ PagingDataTransforms$map$$inlined$transform$1 this$0;

                /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2$1, reason: invalid class name */
                @f(c = "androidx.paging.PagingDataTransforms$map$$inlined$transform$1$2", f = "PagingDataTransforms.kt", l = {136, 136}, m = "emit")
                @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "androidx/paging/PagingDataTransforms$transform$$inlined$map$2$2$1", "emit"}, k = 3, mv = {1, 4, 1})
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

                public AnonymousClass2(g gVar, PagingDataTransforms$map$$inlined$transform$1 pagingDataTransforms$map$$inlined$transform$1) {
                    this.$this_unsafeFlow$inlined = gVar;
                    this.this$0 = pagingDataTransforms$map$$inlined$transform$1;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
                
                    if (r7.emit(r8, r0) == r1) goto L22;
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
                    p<? super T, ? super v8.f<? super R>, ? extends Object> pVar = transform;
                    anonymousClass1.L$0 = gVar3;
                    anonymousClass1.label = 1;
                    Object map = ((PageEvent) obj).map(pVar, anonymousClass1);
                    if (map != objC) {
                        obj2 = map;
                        gVar = gVar3;
                    }
                    return objC;
                    anonymousClass1.L$0 = null;
                    anonymousClass1.label = 2;
                }
            }

            @Override // kotlinx.coroutines.flow.f
            public Object collect(g gVar, v8.f fVar) {
                Object objCollect = flow$paging_common.collect(new AnonymousClass2(gVar, this), fVar);
                return objCollect == b.c() ? objCollect : z.f17874a;
            }
        }, map.getReceiver());
    }

    @CheckResult
    public static final <T> PagingData<T> insertFooterItem(PagingData<T> insertFooterItem, T item) {
        m.f(insertFooterItem, "$this$insertFooterItem");
        m.f(item, "item");
        return insertSeparators(insertFooterItem, new AnonymousClass1(item, null));
    }

    @CheckResult
    public static final <T> PagingData<T> insertHeaderItem(PagingData<T> insertHeaderItem, T item) {
        m.f(insertHeaderItem, "$this$insertHeaderItem");
        m.f(item, "item");
        return insertSeparators(insertHeaderItem, new C05591(item, null));
    }

    private static final <T, R> PagingData<R> transform(PagingData<T> pagingData, p<? super PageEvent<T>, ? super v8.f<? super PageEvent<R>>, ? extends Object> pVar) {
        return new PagingData<>(new PagingDataTransforms$transform$$inlined$map$1(pagingData.getFlow$paging_common(), pVar), pagingData.getReceiver());
    }

    @CheckResult
    public static final <R, T extends R> PagingData<R> insertSeparators(PagingData<T> insertSeparators, Executor executor, p<? super T, ? super T, ? extends R> generator) {
        m.f(insertSeparators, "$this$insertSeparators");
        m.f(executor, "executor");
        m.f(generator, "generator");
        return insertSeparators(insertSeparators, new C05601(executor, generator, null));
    }

    @CheckResult
    public static final <T> PagingData<T> filter(PagingData<T> filter, Executor executor, c9.l<? super T, Boolean> predicate) {
        m.f(filter, "$this$filter");
        m.f(executor, "executor");
        m.f(predicate, "predicate");
        return new PagingData<>(new PagingDataTransforms$filter$$inlined$transform$2(filter.getFlow$paging_common(), executor, predicate), filter.getReceiver());
    }

    @CheckResult
    public static final <T, R> PagingData<R> flatMap(PagingData<T> flatMap, Executor executor, c9.l<? super T, ? extends Iterable<? extends R>> transform) {
        m.f(flatMap, "$this$flatMap");
        m.f(executor, "executor");
        m.f(transform, "transform");
        return new PagingData<>(new PagingDataTransforms$flatMap$$inlined$transform$2(flatMap.getFlow$paging_common(), executor, transform), flatMap.getReceiver());
    }

    @CheckResult
    public static final <T, R> PagingData<R> map(PagingData<T> map, Executor executor, c9.l<? super T, ? extends R> transform) {
        m.f(map, "$this$map");
        m.f(executor, "executor");
        m.f(transform, "transform");
        return new PagingData<>(new PagingDataTransforms$map$$inlined$transform$2(map.getFlow$paging_common(), executor, transform), map.getReceiver());
    }
}
