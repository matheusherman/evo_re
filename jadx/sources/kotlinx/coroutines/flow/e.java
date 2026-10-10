package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u001c\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R*\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/e;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "upstream", "Lkotlin/Function1;", "", "keySelector", "Lkotlin/Function2;", "", "areEquivalent", "<init>", "(Lkotlinx/coroutines/flow/f;Lc9/l;Lc9/p;)V", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/flow/f;", "b", "Lc9/l;", "c", "Lc9/p;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class e<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f<T> upstream;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final c9.l<T, Object> keySelector;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final c9.p<Object, Object, Boolean> areEquivalent;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class a<T> implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<T> f14711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.b0<Object> f14712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ g<T> f14713c;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", l = {77}, m = "emit")
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C0281a extends kotlin.coroutines.jvm.internal.d {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ a<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0281a(a<? super T> aVar, v8.f<? super C0281a> fVar) {
                super(fVar);
                this.this$0 = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(e<T> eVar, kotlin.jvm.internal.b0<Object> b0Var, g<? super T> gVar) {
            this.f14711a = eVar;
            this.f14712b = b0Var;
            this.f14713c = gVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.flow.g
        public final Object emit(T t10, v8.f<? super r8.z> fVar) {
            C0281a c0281a;
            if (fVar instanceof C0281a) {
                c0281a = (C0281a) fVar;
                int i10 = c0281a.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    c0281a.label = i10 - Integer.MIN_VALUE;
                } else {
                    c0281a = new C0281a(this, fVar);
                }
            } else {
                c0281a = new C0281a(this, fVar);
            }
            Object obj = c0281a.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = c0281a.label;
            if (i11 == 0) {
                r8.r.b(obj);
                T t11 = (T) this.f14711a.keySelector.invoke(t10);
                Object obj2 = this.f14712b.element;
                if (obj2 != kotlinx.coroutines.flow.internal.p.f14741a && this.f14711a.areEquivalent.invoke(obj2, t11).booleanValue()) {
                    return r8.z.f17874a;
                }
                this.f14712b.element = t11;
                g<T> gVar = this.f14713c;
                c0281a.label = 1;
                if (gVar.emit(t10, c0281a) == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(obj);
            }
            return r8.z.f17874a;
        }
    }

    @Override // kotlinx.coroutines.flow.f
    public Object collect(g<? super T> gVar, v8.f<? super r8.z> fVar) {
        kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
        b0Var.element = (T) kotlinx.coroutines.flow.internal.p.f14741a;
        Object objCollect = this.upstream.collect(new a(this, b0Var, gVar), fVar);
        return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(f<? extends T> fVar, c9.l<? super T, ? extends Object> lVar, c9.p<Object, Object, Boolean> pVar) {
        this.upstream = fVar;
        this.keySelector = lVar;
        this.areEquivalent = pVar;
    }
}
