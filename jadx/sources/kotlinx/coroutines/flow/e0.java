package kotlinx.coroutines.flow;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001f\u0010 J-\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R*\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b/\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\tR\u0011\u00102\u001a\b\u0012\u0004\u0012\u00020\u0005018\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lkotlinx/coroutines/flow/e0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/b;", "Lkotlinx/coroutines/flow/g0;", "Lkotlinx/coroutines/flow/v;", "", "Lkotlinx/coroutines/flow/internal/m;", "initialState", "<init>", "(Ljava/lang/Object;)V", "expectedState", "newState", "", "m", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "value", "a", "(Ljava/lang/Object;)Z", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/g;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "k", "()Lkotlinx/coroutines/flow/g0;", "", "size", "", "l", "(I)[Lkotlinx/coroutines/flow/g0;", "Lv8/j;", "context", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "Lkotlinx/coroutines/flow/f;", "b", "(Lv8/j;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/f;", "d", "I", "sequence", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "()V", "Lkotlinx/atomicfu/AtomicRef;", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class e0<T> extends kotlinx.coroutines.flow.internal.b<g0> implements v<T>, f, kotlinx.coroutines.flow.internal.m<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f14714e = AtomicReferenceFieldUpdater.newUpdater(e0.class, Object.class, "_state");
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int sequence;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {384, 396, TypedValues.CycleType.TYPE_CURVE_FIT}, m = "collect")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class a extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ e0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e0<T> e0Var, v8.f<? super a> fVar) {
            super(fVar);
            this.this$0 = e0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    private final boolean m(Object expectedState, Object newState) {
        int i10;
        g0[] g0VarArrJ;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14714e;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (expectedState != null && !kotlin.jvm.internal.m.a(obj, expectedState)) {
                return false;
            }
            if (kotlin.jvm.internal.m.a(obj, newState)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, newState);
            int i11 = this.sequence;
            if ((i11 & 1) != 0) {
                this.sequence = i11 + 2;
                return true;
            }
            int i12 = i11 + 1;
            this.sequence = i12;
            g0[] g0VarArrJ2 = j();
            r8.z zVar = r8.z.f17874a;
            while (true) {
                g0[] g0VarArr = g0VarArrJ2;
                if (g0VarArr != null) {
                    for (g0 g0Var : g0VarArr) {
                        if (g0Var != null) {
                            g0Var.g();
                        }
                    }
                }
                synchronized (this) {
                    i10 = this.sequence;
                    if (i10 == i12) {
                        this.sequence = i12 + 1;
                        return true;
                    }
                    g0VarArrJ = j();
                    r8.z zVar2 = r8.z.f17874a;
                }
                g0VarArrJ2 = g0VarArrJ;
                i12 = i10;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ab A[Catch: all -> 0x0043, PHI: r2 r6 r7 r8 r11
      0x00ab: PHI (r2v8 kotlinx.coroutines.u1) = (r2v6 kotlinx.coroutines.u1), (r2v7 kotlinx.coroutines.u1), (r2v7 kotlinx.coroutines.u1), (r2v13 kotlinx.coroutines.u1) binds: [B:35:0x009c, B:51:0x00dd, B:53:0x00ef, B:14:0x003e] A[DONT_GENERATE, DONT_INLINE]
      0x00ab: PHI (r6v7 ??) = (r6v14 ??), (r6v15 ??), (r6v16 ??), (r6v17 ??) binds: [B:35:0x009c, B:51:0x00dd, B:53:0x00ef, B:14:0x003e] A[DONT_GENERATE, DONT_INLINE]
      0x00ab: PHI (r7v2 ??) = (r7v0 ??), (r7v7 ??), (r7v8 ??), (r7v9 ??) binds: [B:35:0x009c, B:51:0x00dd, B:53:0x00ef, B:14:0x003e] A[DONT_GENERATE, DONT_INLINE]
      0x00ab: PHI (r8v6 kotlinx.coroutines.flow.e0<T>) = 
      (r8v4 kotlinx.coroutines.flow.e0<T>)
      (r8v5 kotlinx.coroutines.flow.e0<T>)
      (r8v5 kotlinx.coroutines.flow.e0<T>)
      (r8v12 kotlinx.coroutines.flow.e0<T>)
     binds: [B:35:0x009c, B:51:0x00dd, B:53:0x00ef, B:14:0x003e] A[DONT_GENERATE, DONT_INLINE]
      0x00ab: PHI (r11v7 java.lang.Object) = (r11v5 java.lang.Object), (r11v6 java.lang.Object), (r11v6 java.lang.Object), (r11v19 java.lang.Object) binds: [B:35:0x009c, B:51:0x00dd, B:53:0x00ef, B:14:0x003e] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b3, B:40:0x00b8, B:50:0x00d9, B:52:0x00df, B:42:0x00be, B:46:0x00c5, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00b3 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b3, B:40:0x00b8, B:50:0x00d9, B:52:0x00df, B:42:0x00be, B:46:0x00c5, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b8 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b3, B:40:0x00b8, B:50:0x00d9, B:52:0x00df, B:42:0x00be, B:46:0x00c5, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00df A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:36:0x00ab, B:38:0x00b3, B:40:0x00b8, B:50:0x00d9, B:52:0x00df, B:42:0x00be, B:46:0x00c5, B:21:0x0060, B:24:0x0073, B:35:0x009c), top: B:57:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.d] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, kotlinx.coroutines.flow.g0] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object, kotlinx.coroutines.flow.g] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00dd -> B:36:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00ef -> B:36:0x00ab). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlinx.coroutines.flow.z, kotlinx.coroutines.flow.f
    public java.lang.Object collect(kotlinx.coroutines.flow.g<? super T> r11, v8.f<?> r12) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.e0.collect(kotlinx.coroutines.flow.g, v8.f):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.v, kotlinx.coroutines.flow.d0
    public T getValue() {
        kotlinx.coroutines.internal.f0 f0Var = kotlinx.coroutines.flow.internal.p.f14741a;
        T t10 = (T) f14714e.get(this);
        if (t10 == f0Var) {
            return null;
        }
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.b
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public g0 f() {
        return new g0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.b
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public g0[] g(int size) {
        return new g0[size];
    }

    @Override // kotlinx.coroutines.flow.v
    public void setValue(T t10) {
        if (t10 == null) {
            t10 = (T) kotlinx.coroutines.flow.internal.p.f14741a;
        }
        m(null, t10);
    }

    public e0(Object obj) {
        this._state = obj;
    }

    @Override // kotlinx.coroutines.flow.u
    public boolean a(T value) {
        setValue(value);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.m
    public f<T> b(v8.j context, int capacity, kotlinx.coroutines.channels.a onBufferOverflow) {
        return f0.d(this, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.g
    public Object emit(T t10, v8.f<? super r8.z> fVar) {
        setValue(t10);
        return r8.z.f17874a;
    }
}
