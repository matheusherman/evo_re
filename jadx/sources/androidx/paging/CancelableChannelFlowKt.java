package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.channels.v;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.u1;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aR\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012*\b\u0001\u0010\b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/u1;", "controller", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/s;", "Lv8/f;", "Lr8/z;", "", "block", "Lkotlinx/coroutines/flow/f;", "cancelableChannelFlow", "(Lkotlinx/coroutines/u1;Lc9/p;)Lkotlinx/coroutines/flow/f;", "paging-common"}, k = 2, mv = {1, 4, 1})
public final class CancelableChannelFlowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.paging.CancelableChannelFlowKt$cancelableChannelFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.CancelableChannelFlowKt$cancelableChannelFlow$1", f = "CancelableChannelFlow.kt", l = {35}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/s;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1<T> extends l implements p<s<? super T>, v8.f<? super z>, Object> {
        final /* synthetic */ p $block;
        final /* synthetic */ u1 $controller;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.CancelableChannelFlowKt$cancelableChannelFlow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        static final class C00141 extends o implements c9.l<Throwable, z> {
            final /* synthetic */ s $this_channelFlow;

            @Override // c9.l
            public /* bridge */ /* synthetic */ z invoke(Throwable th) {
                invoke2(th);
                return z.f17874a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00141(s sVar) {
                super(1);
                this.$this_channelFlow = sVar;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                v.a.a(this.$this_channelFlow, null, 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(u1 u1Var, p pVar, v8.f fVar) {
            super(2, fVar);
            this.$controller = u1Var;
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$controller, this.$block, completion);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // c9.p
        public final Object invoke(Object obj, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create(obj, fVar)).invokeSuspend(z.f17874a);
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
                s sVar = (s) this.L$0;
                this.$controller.x(new C00141(sVar));
                p pVar = this.$block;
                this.label = 1;
                if (pVar.invoke(sVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    public static final <T> kotlinx.coroutines.flow.f<T> cancelableChannelFlow(u1 controller, p<? super s<? super T>, ? super v8.f<? super z>, ? extends Object> block) {
        m.f(controller, "controller");
        m.f(block, "block");
        return h.h(new AnonymousClass1(controller, block, null));
    }
}
