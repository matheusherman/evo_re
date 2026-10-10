package k6;

import com.skydoves.sandwich.d;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.s0;
import retrofit2.b;
import retrofit2.c;
import retrofit2.g0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010¨\u0006\u0012"}, d2 = {"Lk6/a;", "Lretrofit2/c$a;", "Lkotlinx/coroutines/l0;", "coroutineScope", "<init>", "(Lkotlinx/coroutines/l0;)V", "Ljava/lang/reflect/Type;", "returnType", "", "", "annotations", "Lretrofit2/g0;", "retrofit", "Lretrofit2/c;", "a", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/g0;)Lretrofit2/c;", "Lkotlinx/coroutines/l0;", "b", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a extends c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final l0 coroutineScope;

    /* JADX INFO: renamed from: k6.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lk6/a$a;", "", "<init>", "()V", "Lkotlinx/coroutines/l0;", "coroutineScope", "Lk6/a;", "a", "(Lkotlinx/coroutines/l0;)Lk6/a;", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ a b(Companion companion, l0 l0Var, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                l0Var = d.f8347a.b();
            }
            return companion.a(l0Var);
        }

        public final a a(l0 coroutineScope) {
            m.f(coroutineScope, "coroutineScope");
            return new a(coroutineScope, null);
        }
    }

    public /* synthetic */ a(l0 l0Var, g gVar) {
        this(l0Var);
    }

    private a(l0 l0Var) {
        this.coroutineScope = l0Var;
    }

    @Override // retrofit2.c.a
    public c<?, ?> a(Type returnType, Annotation[] annotations, g0 retrofit) {
        m.f(returnType, "returnType");
        m.f(annotations, "annotations");
        m.f(retrofit, "retrofit");
        Class<?> clsC = c.a.c(returnType);
        if (m.a(clsC, b.class)) {
            Type typeB = c.a.b(0, (ParameterizedType) returnType);
            if (!m.a(c.a.c(typeB), com.skydoves.sandwich.a.class)) {
                return null;
            }
            m.d(typeB, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            Type resultType = c.a.b(0, (ParameterizedType) typeB);
            m.e(resultType, "resultType");
            return new com.skydoves.sandwich.adapters.internal.a(resultType, this.coroutineScope);
        }
        if (!m.a(clsC, s0.class)) {
            return null;
        }
        Type typeB2 = c.a.b(0, (ParameterizedType) returnType);
        if (!m.a(c.a.c(typeB2), com.skydoves.sandwich.a.class)) {
            return null;
        }
        m.d(typeB2, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type resultType2 = c.a.b(0, (ParameterizedType) typeB2);
        m.e(resultType2, "resultType");
        return new com.skydoves.sandwich.adapters.internal.c(resultType2, this.coroutineScope);
    }
}
