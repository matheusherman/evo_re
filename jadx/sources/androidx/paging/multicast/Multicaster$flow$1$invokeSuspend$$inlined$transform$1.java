package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import com.taobao.sophix.PatchStatus;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.w;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1", f = "Multicaster.kt", l = {215}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/g;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class Multicaster$flow$1$invokeSuspend$$inlined$transform$1<T> extends l implements p<g<? super T>, v8.f<? super z>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.f $this_transform;
    Object L$0;
    Object L$1;
    int label;
    private g p$;

    /* JADX INFO: renamed from: androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
    public static final class AnonymousClass1 implements g<ChannelManager.Message.Dispatch.Value<T>> {
        final /* synthetic */ g $this_flow$inlined;

        /* JADX INFO: renamed from: androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        @f(c = "androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1$1", f = "Multicaster.kt", l = {PatchStatus.CODE_LOAD_LIB_LOST}, m = "emit")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lv8/f;", "Lr8/z;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1$1", "emit"}, k = 3, mv = {1, 4, 1})
        public static final class C00231 extends d {
            Object L$0;
            int label;
            /* synthetic */ Object result;

            public C00231(v8.f fVar) {
                super(fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(g gVar) {
            this.$this_flow$inlined = gVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.g
        public Object emit(Object obj, v8.f fVar) {
            C00231 c00231;
            ChannelManager.Message.Dispatch.Value value;
            if (fVar instanceof C00231) {
                c00231 = (C00231) fVar;
                int i10 = c00231.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    c00231.label = i10 - Integer.MIN_VALUE;
                } else {
                    c00231 = new C00231(fVar);
                }
            } else {
                c00231 = new C00231(fVar);
            }
            Object obj2 = c00231.result;
            Object objC = b.c();
            int i11 = c00231.label;
            if (i11 == 0) {
                r.b(obj2);
                g gVar = this.$this_flow$inlined;
                value = (ChannelManager.Message.Dispatch.Value) obj;
                Object value2 = value.getValue();
                c00231.L$0 = value;
                c00231.label = 1;
                if (gVar.emit(value2, c00231) == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                value = (ChannelManager.Message.Dispatch.Value) c00231.L$0;
                r.b(obj2);
            }
            w<z> delivered = value.getDelivered();
            z zVar = z.f17874a;
            delivered.r(zVar);
            return zVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Multicaster$flow$1$invokeSuspend$$inlined$transform$1(kotlinx.coroutines.flow.f fVar, v8.f fVar2) {
        super(2, fVar2);
        this.$this_transform = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> fVar) {
        Multicaster$flow$1$invokeSuspend$$inlined$transform$1 multicaster$flow$1$invokeSuspend$$inlined$transform$1 = new Multicaster$flow$1$invokeSuspend$$inlined$transform$1(this.$this_transform, fVar);
        multicaster$flow$1$invokeSuspend$$inlined$transform$1.p$ = (g) obj;
        return multicaster$flow$1$invokeSuspend$$inlined$transform$1;
    }

    @Override // c9.p
    public final Object invoke(Object obj, v8.f<? super z> fVar) {
        return ((Multicaster$flow$1$invokeSuspend$$inlined$transform$1) create(obj, fVar)).invokeSuspend(z.f17874a);
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
            g gVar = this.p$;
            kotlinx.coroutines.flow.f fVar = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(gVar);
            this.label = 1;
            if (fVar.collect(anonymousClass1, this) == objC) {
                return objC;
            }
        }
        return z.f17874a;
    }
}
