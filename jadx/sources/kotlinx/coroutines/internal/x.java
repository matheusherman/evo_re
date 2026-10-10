package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u001aE\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\u000b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0000*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000e\u0010\u000f**\b\u0000\u0010\u0010\u001a\u0004\b\u0000\u0010\u0000\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0011"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlin/Function1;", "Lr8/z;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "element", "Lkotlinx/coroutines/internal/q0;", "undeliveredElementException", "c", "(Lc9/l;Ljava/lang/Object;Lkotlinx/coroutines/internal/q0;)Lkotlinx/coroutines/internal/q0;", "Lv8/j;", "context", "b", "(Lc9/l;Ljava/lang/Object;Lv8/j;)V", "", "a", "(Lc9/l;Ljava/lang/Object;Lv8/j;)Lc9/l;", "OnUndeliveredElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class x {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LONGITUDE_EAST, "", "<anonymous parameter 0>", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.jvm.internal.o implements c9.l<Throwable, r8.z> {
        final /* synthetic */ v8.j $context;
        final /* synthetic */ E $element;
        final /* synthetic */ c9.l<E, r8.z> $this_bindCancellationFun;

        @Override // c9.l
        public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
            invoke2(th);
            return r8.z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(c9.l<? super E, r8.z> lVar, E e10, v8.j jVar) {
            super(1);
            this.$this_bindCancellationFun = lVar;
            this.$element = e10;
            this.$context = jVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            x.b(this.$this_bindCancellationFun, this.$element, this.$context);
        }
    }

    public static final <E> void b(c9.l<? super E, r8.z> lVar, E e10, v8.j jVar) {
        q0 q0VarC = c(lVar, e10, null);
        if (q0VarC != null) {
            kotlinx.coroutines.k0.a(jVar, q0VarC);
        }
    }

    public static final <E> c9.l<Throwable, r8.z> a(c9.l<? super E, r8.z> lVar, E e10, v8.j jVar) {
        return new a(lVar, e10, jVar);
    }

    public static /* synthetic */ q0 d(c9.l lVar, Object obj, q0 q0Var, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            q0Var = null;
        }
        return c(lVar, obj, q0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> q0 c(c9.l<? super E, r8.z> lVar, E e10, q0 q0Var) {
        try {
            lVar.invoke(e10);
            return q0Var;
        } catch (Throwable th) {
            if (q0Var != null && q0Var.getCause() != th) {
                r8.a.a(q0Var, th);
                return q0Var;
            }
            return new q0("Exception in undelivered element handler for " + e10, th);
        }
    }
}
