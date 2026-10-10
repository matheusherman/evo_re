package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.p0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H$¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H¤@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010\u0011\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010#R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010$R9\u0010*\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120&\u0012\u0006\u0012\u0004\u0018\u00010'0%8@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lkotlinx/coroutines/flow/internal/e;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/m;", "Lv8/j;", "context", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "<init>", "(Lv8/j;ILkotlinx/coroutines/channels/a;)V", "Lkotlinx/coroutines/flow/f;", "b", "(Lv8/j;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/f;", "f", "(Lv8/j;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/internal/e;", "Lkotlinx/coroutines/channels/s;", "scope", "Lr8/z;", "e", "(Lkotlinx/coroutines/channels/s;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/l0;", "Lkotlinx/coroutines/channels/u;", "i", "(Lkotlinx/coroutines/l0;)Lkotlinx/coroutines/channels/u;", "Lkotlinx/coroutines/flow/g;", "collector", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "", "c", "()Ljava/lang/String;", "toString", "a", "Lv8/j;", "I", "Lkotlinx/coroutines/channels/a;", "Lkotlin/Function2;", "Lv8/f;", "", "g", "()Lc9/p;", "collectToFun", "h", "()I", "produceCapacity", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class e<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final v8.j context;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int capacity;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final kotlinx.coroutines.channels.a onBufferOverflow;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.g<T> $collector;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ e<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.flow.g<? super T> gVar, e<T> eVar, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$collector = gVar;
            this.this$0 = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            a aVar = new a(this.$collector, this.this$0, fVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                l0 l0Var = (l0) this.L$0;
                kotlinx.coroutines.flow.g<T> gVar = this.$collector;
                kotlinx.coroutines.channels.u<T> uVarI = this.this$0.i(l0Var);
                this.label = 1;
                if (kotlinx.coroutines.flow.h.o(gVar, uVarI, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/s;", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/channels/s;)V"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.channels.s<? super T>, v8.f<? super z>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ e<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e<T> eVar, v8.f<? super b> fVar) {
            super(2, fVar);
            this.this$0 = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            b bVar = new b(this.this$0, fVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.channels.s<? super T> sVar, v8.f<? super z> fVar) {
            return ((b) create(sVar, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                kotlinx.coroutines.channels.s<? super T> sVar = (kotlinx.coroutines.channels.s) this.L$0;
                e<T> eVar = this.this$0;
                this.label = 1;
                if (eVar.e(sVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    protected String c() {
        return null;
    }

    protected abstract Object e(kotlinx.coroutines.channels.s<? super T> sVar, v8.f<? super z> fVar);

    protected abstract e<T> f(v8.j context, int capacity, kotlinx.coroutines.channels.a onBufferOverflow);

    static /* synthetic */ <T> Object d(e<T> eVar, kotlinx.coroutines.flow.g<? super T> gVar, v8.f<? super z> fVar) {
        Object objC = m0.c(new a(gVar, eVar, null), fVar);
        return objC == kotlin.coroutines.intrinsics.b.c() ? objC : z.f17874a;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    @Override // kotlinx.coroutines.flow.internal.m
    public kotlinx.coroutines.flow.f<T> b(v8.j context, int capacity, kotlinx.coroutines.channels.a onBufferOverflow) {
        v8.j jVarPlus = context.plus(this.context);
        if (onBufferOverflow == kotlinx.coroutines.channels.a.SUSPEND) {
            int i10 = this.capacity;
            if (i10 != -3) {
                if (capacity == -3) {
                    capacity = i10;
                } else if (i10 != -2) {
                    if (capacity == -2) {
                        capacity = i10;
                    } else {
                        capacity += i10;
                        if (capacity < 0) {
                            capacity = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            onBufferOverflow = this.onBufferOverflow;
        }
        return (kotlin.jvm.internal.m.a(jVarPlus, this.context) && capacity == this.capacity && onBufferOverflow == this.onBufferOverflow) ? this : f(jVarPlus, capacity, onBufferOverflow);
    }

    public final c9.p<kotlinx.coroutines.channels.s<? super T>, v8.f<? super z>, Object> g() {
        return new b(this, null);
    }

    public final int h() {
        int i10 = this.capacity;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    public kotlinx.coroutines.channels.u<T> i(l0 scope) {
        return kotlinx.coroutines.channels.q.c(scope, this.context, h(), this.onBufferOverflow, n0.ATOMIC, null, g(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strC = c();
        if (strC != null) {
            arrayList.add(strC);
        }
        if (this.context != v8.k.f19724a) {
            arrayList.add("context=" + this.context);
        }
        if (this.capacity != -3) {
            arrayList.add("capacity=" + this.capacity);
        }
        if (this.onBufferOverflow != kotlinx.coroutines.channels.a.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.onBufferOverflow);
        }
        return p0.a(this) + '[' + kotlin.collections.r.q0(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    public e(v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar) {
        this.context = jVar;
        this.capacity = i10;
        this.onBufferOverflow = aVar;
    }

    @Override // kotlinx.coroutines.flow.f
    public Object collect(kotlinx.coroutines.flow.g<? super T> gVar, v8.f<? super z> fVar) {
        return d(this, gVar, fVar);
    }
}
