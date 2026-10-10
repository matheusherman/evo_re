package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H¦@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/flow/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "", "<init>", "()V", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class a<T> implements f<T> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C0280a extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0280a(a<T> aVar, v8.f<? super C0280a> fVar) {
            super(fVar);
            this.this$0 = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    public abstract Object c(g<? super T> gVar, v8.f<? super r8.z> fVar);

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.f
    public final Object collect(g<? super T> gVar, v8.f<? super r8.z> fVar) throws Throwable {
        C0280a c0280a;
        Throwable th;
        kotlinx.coroutines.flow.internal.q qVar;
        if (fVar instanceof C0280a) {
            c0280a = (C0280a) fVar;
            int i10 = c0280a.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0280a.label = i10 - Integer.MIN_VALUE;
            } else {
                c0280a = new C0280a(this, fVar);
            }
        } else {
            c0280a = new C0280a(this, fVar);
        }
        Object obj = c0280a.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = c0280a.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            qVar = (kotlinx.coroutines.flow.internal.q) c0280a.L$0;
            try {
                r8.r.b(obj);
                qVar.releaseIntercepted();
                return r8.z.f17874a;
            } catch (Throwable th2) {
                th = th2;
                qVar.releaseIntercepted();
                throw th;
            }
        }
        r8.r.b(obj);
        kotlinx.coroutines.flow.internal.q qVar2 = new kotlinx.coroutines.flow.internal.q(gVar, c0280a.getContext());
        try {
            c0280a.L$0 = qVar2;
            c0280a.label = 1;
            if (c(qVar2, c0280a) == objC) {
                return objC;
            }
            qVar = qVar2;
            qVar.releaseIntercepted();
            return r8.z.f17874a;
        } catch (Throwable th3) {
            th = th3;
            qVar = qVar2;
            qVar.releaseIntercepted();
            throw th;
        }
    }
}
