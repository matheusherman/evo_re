package com.skydoves.sandwich;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.u;
import r8.i;
import r8.r;
import r8.z;
import retrofit2.f0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0005*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/skydoves/sandwich/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "a", "b", "c", "Lcom/skydoves/sandwich/a$b;", "Lcom/skydoves/sandwich/a$c;", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.skydoves.sandwich.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\nH\u0001¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0001\u0010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/skydoves/sandwich/a$a;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "ex", "Lcom/skydoves/sandwich/a$b$b;", "a", "(Ljava/lang/Throwable;)Lcom/skydoves/sandwich/a$b$b;", "Lcom/skydoves/sandwich/a;", "c", "(Lcom/skydoves/sandwich/a;)Lcom/skydoves/sandwich/a;", "Lretrofit2/f0;", "response", "Lcom/skydoves/sandwich/e;", "b", "(Lretrofit2/f0;)Lcom/skydoves/sandwich/e;", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: renamed from: com.skydoves.sandwich.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "com.skydoves.sandwich.ApiResponse$Companion$operate$1$1$1", f = "ApiResponse.kt", l = {167}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0000 \u0001*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
        static final class C0150a extends l implements p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ m6.c $globalOperator;
            final /* synthetic */ a<T> $this_apply;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0150a(a<? extends T> aVar, m6.c cVar, v8.f<? super C0150a> fVar) {
                super(2, fVar);
                this.$this_apply = aVar;
                this.$globalOperator = cVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new C0150a(this.$this_apply, this.$globalOperator, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((C0150a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r.b(obj);
                    a<T> aVar = this.$this_apply;
                    m6.c cVar = this.$globalOperator;
                    m.d(cVar, "null cannot be cast to non-null type com.skydoves.sandwich.operators.ApiResponseSuspendOperator<T of com.skydoves.sandwich.ApiResponse.Companion.operate$lambda$2$lambda$1>");
                    this.label = 1;
                    if (com.skydoves.sandwich.c.h(aVar, (m6.b) cVar, this) == objC) {
                        return objC;
                    }
                }
                return z.f17874a;
            }
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        public final <T> b.C0152b<T> a(Throwable ex) {
            m.f(ex, "ex");
            b.C0152b<T> c0152b = new b.C0152b<>(ex);
            a.INSTANCE.c(c0152b);
            return c0152b;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0020  */
        /* JADX WARN: Code duplicated, block: B:12:0x0023 A[RETURN] */
        public final <T> e b(f0<T> response) {
            m.f(response, "response");
            for (e eVar : e.values()) {
                if (eVar.getCode() == response.b()) {
                    if (eVar == null) {
                        return e.Unknown;
                    }
                    return eVar;
                }
            }
            eVar = null;
            if (eVar == null) {
                return e.Unknown;
            }
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> a<T> c(a<? extends T> aVar) {
            m.f(aVar, "<this>");
            for (m6.c cVar : d.a()) {
                if (cVar instanceof m6.a) {
                    com.skydoves.sandwich.c.f(aVar, (m6.a) cVar);
                } else if (cVar instanceof m6.b) {
                    j.d(d.f8347a.b(), null, null, new C0150a(aVar, cVar, null), 3, null);
                }
            }
            return aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/skydoves/sandwich/a$b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/sandwich/a;", "<init>", "()V", "a", "b", "Lcom/skydoves/sandwich/a$b$a;", "Lcom/skydoves/sandwich/a$b$b;", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class b<T> extends a<T> {

        /* JADX INFO: renamed from: com.skydoves.sandwich.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0012\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010&\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010,\u001a\u0004\u0018\u00010'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/skydoves/sandwich/a$b$a;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/sandwich/a$b;", "Lretrofit2/f0;", "response", "<init>", "(Lretrofit2/f0;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "b", "Lretrofit2/f0;", "getResponse", "()Lretrofit2/f0;", "Lcom/skydoves/sandwich/e;", "c", "Lcom/skydoves/sandwich/e;", "()Lcom/skydoves/sandwich/e;", "statusCode", "Lokhttp3/u;", "d", "Lokhttp3/u;", "getHeaders", "()Lokhttp3/u;", "headers", "Lokhttp3/d0;", "e", "Lokhttp3/d0;", "a", "()Lokhttp3/d0;", "raw", "Lokhttp3/e0;", "f", "Lokhttp3/e0;", "getErrorBody", "()Lokhttp3/e0;", "errorBody", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class C0151a<T> extends b<T> {

            /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final f0<T> response;

            /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
            private final e statusCode;

            /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
            private final u headers;

            /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
            private final d0 raw;

            /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
            private final e0 errorBody;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof C0151a) && m.a(this.response, ((C0151a) other).response);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0151a(f0<T> response) {
                super(null);
                m.f(response, "response");
                this.response = response;
                this.statusCode = a.INSTANCE.b(response);
                u uVarE = response.e();
                m.e(uVarE, "response.headers()");
                this.headers = uVarE;
                d0 d0VarH = response.h();
                m.e(d0VarH, "response.raw()");
                this.raw = d0VarH;
                this.errorBody = response.d();
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public final d0 getRaw() {
                return this.raw;
            }

            /* JADX INFO: renamed from: b, reason: from getter */
            public final e getStatusCode() {
                return this.statusCode;
            }

            public int hashCode() {
                return this.response.hashCode();
            }

            public String toString() {
                e0 e0Var = this.errorBody;
                String strL = e0Var != null ? e0Var.l() : null;
                if (strL != null && strL.length() != 0) {
                    return strL;
                }
                return "[ApiResponse.Failure.Error-" + this.statusCode + "](errorResponse=" + this.response + ')';
            }
        }

        /* JADX INFO: renamed from: com.skydoves.sandwich.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/skydoves/sandwich/a$b$b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/sandwich/a$b;", "", "exception", "<init>", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "b", "Ljava/lang/Throwable;", "a", "()Ljava/lang/Throwable;", "c", "Ljava/lang/String;", "message", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class C0152b<T> extends b<T> {

            /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final Throwable exception;

            /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            private final String message;

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof C0152b) && m.a(this.exception, ((C0152b) other).exception);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0152b(Throwable exception) {
                super(null);
                m.f(exception, "exception");
                this.exception = exception;
                this.message = exception.getLocalizedMessage();
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public final Throwable getException() {
                return this.exception;
            }

            /* JADX INFO: renamed from: b, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.exception.hashCode();
            }

            public String toString() {
                return "[ApiResponse.Failure.Exception](message=" + this.message + ')';
            }
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        private b() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0019\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00028\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/skydoves/sandwich/a$c;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/sandwich/a;", "Lretrofit2/f0;", "response", "<init>", "(Lretrofit2/f0;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "b", "Lretrofit2/f0;", "()Lretrofit2/f0;", "Lcom/skydoves/sandwich/e;", "c", "Lcom/skydoves/sandwich/e;", "()Lcom/skydoves/sandwich/e;", "statusCode", "Lokhttp3/u;", "d", "Lokhttp3/u;", "getHeaders", "()Lokhttp3/u;", "headers", "Lokhttp3/d0;", "e", "Lokhttp3/d0;", "getRaw", "()Lokhttp3/d0;", "raw", "f", "Lr8/i;", "a", "()Ljava/lang/Object;", "data", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class c<T> extends a<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final f0<T> response;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final e statusCode;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final u headers;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final d0 raw;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final i data;

        /* JADX INFO: renamed from: com.skydoves.sandwich.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0004\b\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0006\b\u0001\u0010\u0001 \u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C0153a extends o implements c9.a<T> {
            final /* synthetic */ c<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0153a(c<T> cVar) {
                super(0);
                this.this$0 = cVar;
            }

            @Override // c9.a
            public final T invoke() throws l6.a {
                T tA = this.this$0.b().a();
                if (tA != null) {
                    return tA;
                }
                throw new l6.a(this.this$0.getStatusCode().getCode(), null, 2, null);
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof c) && m.a(this.response, ((c) other).response);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f0<T> response) {
            super(null);
            m.f(response, "response");
            this.response = response;
            this.statusCode = a.INSTANCE.b(response);
            u uVarE = response.e();
            m.e(uVarE, "response.headers()");
            this.headers = uVarE;
            d0 d0VarH = response.h();
            m.e(d0VarH, "response.raw()");
            this.raw = d0VarH;
            this.data = r8.j.a(new C0153a(this));
        }

        public final T a() {
            return (T) this.data.getValue();
        }

        public final f0<T> b() {
            return this.response;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final e getStatusCode() {
            return this.statusCode;
        }

        public int hashCode() {
            return this.response.hashCode();
        }

        public String toString() {
            return "[ApiResponse.Success](data=" + a() + ')';
        }
    }

    public /* synthetic */ a(g gVar) {
        this();
    }

    private a() {
    }
}
