package retrofit2;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlinx.coroutines.a1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a'\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u001b\u0010\u000b\u001a\u00020\n*\u00060\bj\u0002`\tH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/b;", "a", "(Lretrofit2/b;Lv8/f;)Ljava/lang/Object;", "b", "Lretrofit2/f0;", "c", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "d", "(Ljava/lang/Exception;Lv8/f;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
public final class p {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "retrofit2/KotlinExtensions$await$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class a extends kotlin.jvm.internal.o implements c9.l<Throwable, r8.z> {
        final /* synthetic */ retrofit2.b $this_await$inlined;

        @Override // c9.l
        public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
            invoke2(th);
            return r8.z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(retrofit2.b bVar) {
            super(1);
            this.$this_await$inlined = bVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.$this_await$inlined.cancel();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "retrofit2/KotlinExtensions$await$4$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.l<Throwable, r8.z> {
        final /* synthetic */ retrofit2.b $this_await$inlined;

        @Override // c9.l
        public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
            invoke2(th);
            return r8.z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(retrofit2.b bVar) {
            super(1);
            this.$this_await$inlined = bVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.$this_await$inlined.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"retrofit2/p$c", "Lretrofit2/d;", "Lretrofit2/b;", NotificationCompat.CATEGORY_CALL, "Lretrofit2/f0;", "response", "Lr8/z;", "b", "(Lretrofit2/b;Lretrofit2/f0;)V", "", "t", "a", "(Lretrofit2/b;Ljava/lang/Throwable;)V", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class c<T> implements retrofit2.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f18061a;

        c(kotlinx.coroutines.n nVar) {
            this.f18061a = nVar;
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> call, Throwable t10) {
            kotlin.jvm.internal.m.g(call, "call");
            kotlin.jvm.internal.m.g(t10, "t");
            kotlinx.coroutines.n nVar = this.f18061a;
            r8.q.Companion companion = r8.q.INSTANCE;
            nVar.resumeWith(r8.q.a(r8.r.a(t10)));
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> call, f0<T> response) {
            kotlin.jvm.internal.m.g(call, "call");
            kotlin.jvm.internal.m.g(response, "response");
            if (!response.f()) {
                kotlinx.coroutines.n nVar = this.f18061a;
                m mVar = new m(response);
                r8.q.Companion companion = r8.q.INSTANCE;
                nVar.resumeWith(r8.q.a(r8.r.a(mVar)));
                return;
            }
            T tA = response.a();
            if (tA != null) {
                this.f18061a.resumeWith(r8.q.a(tA));
                return;
            }
            Object objI = call.f().i(o.class);
            if (objI == null) {
                kotlin.jvm.internal.m.p();
            }
            kotlin.jvm.internal.m.b(objI, "call.request().tag(Invocation::class.java)!!");
            Method method = ((o) objI).a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Response from ");
            kotlin.jvm.internal.m.b(method, "method");
            Class<?> declaringClass = method.getDeclaringClass();
            kotlin.jvm.internal.m.b(declaringClass, "method.declaringClass");
            sb2.append(declaringClass.getName());
            sb2.append('.');
            sb2.append(method.getName());
            sb2.append(" was null but response body type was declared as non-null");
            r8.f fVar = new r8.f(sb2.toString());
            kotlinx.coroutines.n nVar2 = this.f18061a;
            r8.q.Companion companion2 = r8.q.INSTANCE;
            nVar2.resumeWith(r8.q.a(r8.r.a(fVar)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J/\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"retrofit2/p$d", "Lretrofit2/d;", "Lretrofit2/b;", NotificationCompat.CATEGORY_CALL, "Lretrofit2/f0;", "response", "Lr8/z;", "b", "(Lretrofit2/b;Lretrofit2/f0;)V", "", "t", "a", "(Lretrofit2/b;Ljava/lang/Throwable;)V", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class d<T> implements retrofit2.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f18062a;

        d(kotlinx.coroutines.n nVar) {
            this.f18062a = nVar;
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> call, Throwable t10) {
            kotlin.jvm.internal.m.g(call, "call");
            kotlin.jvm.internal.m.g(t10, "t");
            kotlinx.coroutines.n nVar = this.f18062a;
            r8.q.Companion companion = r8.q.INSTANCE;
            nVar.resumeWith(r8.q.a(r8.r.a(t10)));
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> call, f0<T> response) {
            kotlin.jvm.internal.m.g(call, "call");
            kotlin.jvm.internal.m.g(response, "response");
            if (response.f()) {
                this.f18062a.resumeWith(r8.q.a(response.a()));
                return;
            }
            kotlinx.coroutines.n nVar = this.f18062a;
            m mVar = new m(response);
            r8.q.Companion companion = r8.q.INSTANCE;
            nVar.resumeWith(r8.q.a(r8.r.a(mVar)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "L;", "it", "Lr8/z;", "invoke", "(L;)V", "kotlin/Throwable", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class e extends kotlin.jvm.internal.o implements c9.l<Throwable, r8.z> {
        final /* synthetic */ retrofit2.b $this_awaitResponse$inlined;

        @Override // c9.l
        public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
            invoke2(th);
            return r8.z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(retrofit2.b bVar) {
            super(1);
            this.$this_awaitResponse$inlined = bVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.$this_awaitResponse$inlined.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"retrofit2/p$f", "Lretrofit2/d;", "Lretrofit2/b;", NotificationCompat.CATEGORY_CALL, "Lretrofit2/f0;", "response", "Lr8/z;", "b", "(Lretrofit2/b;Lretrofit2/f0;)V", "", "t", "a", "(Lretrofit2/b;Ljava/lang/Throwable;)V", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class f<T> implements retrofit2.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.n f18063a;

        f(kotlinx.coroutines.n nVar) {
            this.f18063a = nVar;
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> call, Throwable t10) {
            kotlin.jvm.internal.m.g(call, "call");
            kotlin.jvm.internal.m.g(t10, "t");
            kotlinx.coroutines.n nVar = this.f18063a;
            r8.q.Companion companion = r8.q.INSTANCE;
            nVar.resumeWith(r8.q.a(r8.r.a(t10)));
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> call, f0<T> response) {
            kotlin.jvm.internal.m.g(call, "call");
            kotlin.jvm.internal.m.g(response, "response");
            this.f18063a.resumeWith(r8.q.a(response));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lr8/z;", "run", "()V", "retrofit2/KotlinExtensions$suspendAndThrow$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ v8.f f18064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Exception f18065b;

        g(v8.f fVar, Exception exc) {
            this.f18064a = fVar;
            this.f18065b = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            v8.f fVarB = kotlin.coroutines.intrinsics.b.b(this.f18064a);
            Exception exc = this.f18065b;
            r8.q.Companion companion = r8.q.INSTANCE;
            fVarB.resumeWith(r8.q.a(r8.r.a(exc)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00060\u0000j\u0002`\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0080@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lv8/f;", "", "continuation", "", "suspendAndThrow", "(Ljava/lang/Exception;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    static final class h extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return p.d(null, this);
        }

        h(v8.f fVar) {
            super(fVar);
        }
    }

    public static final <T> Object a(retrofit2.b<T> bVar, v8.f<? super T> fVar) {
        kotlinx.coroutines.o oVar = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.h(new a(bVar));
        bVar.S(new c(oVar));
        Object objZ = oVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ;
    }

    public static final <T> Object b(retrofit2.b<T> bVar, v8.f<? super T> fVar) {
        kotlinx.coroutines.o oVar = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.h(new b(bVar));
        bVar.S(new d(oVar));
        Object objZ = oVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ;
    }

    public static final <T> Object c(retrofit2.b<T> bVar, v8.f<? super f0<T>> fVar) {
        kotlinx.coroutines.o oVar = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.h(new e(bVar));
        bVar.S(new f(oVar));
        Object objZ = oVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object d(Exception exc, v8.f<?> fVar) {
        h hVar;
        if (fVar instanceof h) {
            hVar = (h) fVar;
            int i10 = hVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                hVar.label = i10 - Integer.MIN_VALUE;
            } else {
                hVar = new h(fVar);
            }
        } else {
            hVar = new h(fVar);
        }
        Object obj = hVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = hVar.label;
        if (i11 == 0) {
            r8.r.b(obj);
            hVar.L$0 = exc;
            hVar.label = 1;
            a1.a().dispatch(hVar.getContext(), new g(hVar, exc));
            Object objC2 = kotlin.coroutines.intrinsics.b.c();
            if (objC2 == kotlin.coroutines.intrinsics.b.c()) {
                kotlin.coroutines.jvm.internal.h.c(hVar);
            }
            if (objC2 == objC) {
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
