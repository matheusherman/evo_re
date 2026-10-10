package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.f0;
import kotlinx.coroutines.flow.v;
import r8.p;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\u0005R(\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/paging/ConflatedEventBus;", "", ExifInterface.GPS_DIRECTION_TRUE, "initialValue", "<init>", "(Ljava/lang/Object;)V", "data", "Lr8/z;", "send", "Lkotlinx/coroutines/flow/v;", "Lr8/p;", "", "state", "Lkotlinx/coroutines/flow/v;", "Lkotlinx/coroutines/flow/f;", "flow", "Lkotlinx/coroutines/flow/f;", "getFlow", "()Lkotlinx/coroutines/flow/f;", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class ConflatedEventBus<T> {
    private final f<T> flow;
    private final v<p<Integer, T>> state;

    /* JADX WARN: Illegal instructions before constructor call */
    public ConflatedEventBus() {
        g gVar = null;
        this(gVar, 1, gVar);
    }

    public ConflatedEventBus(T t10) {
        final v<p<Integer, T>> vVarA = f0.a(new p(Integer.MIN_VALUE, t10));
        this.state = vVarA;
        this.flow = new f<T>() { // from class: androidx.paging.ConflatedEventBus$$special$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: androidx.paging.ConflatedEventBus$$special$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 1})
            public static final class AnonymousClass2 implements kotlinx.coroutines.flow.g<p<? extends Integer, ? extends T>> {
                final /* synthetic */ kotlinx.coroutines.flow.g $this_unsafeFlow$inlined;
                final /* synthetic */ ConflatedEventBus$$special$$inlined$mapNotNull$1 this$0;

                /* JADX INFO: renamed from: androidx.paging.ConflatedEventBus$$special$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.ConflatedEventBus$$special$$inlined$mapNotNull$1$2", f = "ConflatedEventBus.kt", l = {136}, m = "emit")
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

                public AnonymousClass2(kotlinx.coroutines.flow.g gVar, ConflatedEventBus$$special$$inlined$mapNotNull$1 conflatedEventBus$$special$$inlined$mapNotNull$1) {
                    this.$this_unsafeFlow$inlined = gVar;
                    this.this$0 = conflatedEventBus$$special$$inlined$mapNotNull$1;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Multi-variable type inference failed */
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
                        kotlinx.coroutines.flow.g gVar = this.$this_unsafeFlow$inlined;
                        Object objD = ((p) obj).d();
                        if (objD == null) {
                            return z.f17874a;
                        }
                        anonymousClass1.label = 1;
                        if (gVar.emit(objD, anonymousClass1) == objC) {
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
            public Object collect(kotlinx.coroutines.flow.g gVar, v8.f fVar) {
                Object objCollect = vVarA.collect(new AnonymousClass2(gVar, this), fVar);
                return objCollect == b.c() ? objCollect : z.f17874a;
            }
        };
    }

    public final f<T> getFlow() {
        return this.flow;
    }

    public final void send(T data) {
        m.f(data, "data");
        v<p<Integer, T>> vVar = this.state;
        vVar.setValue(new p<>(Integer.valueOf(vVar.getValue().c().intValue() + 1), data));
    }

    public /* synthetic */ ConflatedEventBus(Object obj, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : obj);
    }
}
