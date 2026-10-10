package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.l0;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/v;", "element", "Lkotlinx/coroutines/channels/h;", "Lr8/z;", "a", "(Lkotlinx/coroutines/channels/v;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class l {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", l = {39}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/l0;", "Lkotlinx/coroutines/channels/h;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)Lkotlinx/coroutines/channels/h;"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super h<? extends z>>, Object> {
        final /* synthetic */ E $element;
        final /* synthetic */ v<E> $this_trySendBlocking;
        private /* synthetic */ Object L$0;
        int label;

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(l0 l0Var, v8.f<? super h<? extends z>> fVar) {
            return invoke2(l0Var, (v8.f<? super h<z>>) fVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(v<? super E> vVar, E e10, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$this_trySendBlocking = vVar;
            this.$element = e10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            a aVar = new a(this.$this_trySendBlocking, this.$element, fVar);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 l0Var, v8.f<? super h<z>> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

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
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object objA2;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    v<E> vVar = this.$this_trySendBlocking;
                    E e10 = this.$element;
                    r8.q.Companion companion = r8.q.INSTANCE;
                    this.label = 1;
                    if (vVar.b(e10, this) == objC) {
                        return objC;
                    }
                }
                objA = r8.q.a(z.f17874a);
            } catch (Throwable th) {
                r8.q.Companion companion2 = r8.q.INSTANCE;
                objA = r8.q.a(r8.r.a(th));
            }
            if (r8.q.f(objA)) {
                objA2 = h.INSTANCE.c(z.f17874a);
            } else {
                objA2 = h.INSTANCE.a(r8.q.c(objA));
            }
            return h.b(objA2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> Object a(v<? super E> vVar, E e10) {
        Object objI = vVar.i(e10);
        if (!(objI instanceof h.c)) {
            return h.INSTANCE.c(z.f17874a);
        }
        return ((h) kotlinx.coroutines.i.b(null, new a(vVar, e10, null), 1, null)).getHolder();
    }
}
