package com.skydoves.sandwich.adapters.internal;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/skydoves/sandwich/adapters/internal/a;", "Lretrofit2/c;", "Ljava/lang/reflect/Type;", "Lretrofit2/b;", "Lcom/skydoves/sandwich/a;", "resultType", "Lkotlinx/coroutines/l0;", "coroutineScope", "<init>", "(Ljava/lang/reflect/Type;Lkotlinx/coroutines/l0;)V", "a", "()Ljava/lang/reflect/Type;", NotificationCompat.CATEGORY_CALL, "c", "(Lretrofit2/b;)Lretrofit2/b;", "Ljava/lang/reflect/Type;", "b", "Lkotlinx/coroutines/l0;", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class a implements retrofit2.c<Type, retrofit2.b<com.skydoves.sandwich.a<? extends Type>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Type resultType;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final l0 coroutineScope;

    public a(Type resultType, l0 coroutineScope) {
        m.f(resultType, "resultType");
        m.f(coroutineScope, "coroutineScope");
        this.resultType = resultType;
        this.coroutineScope = coroutineScope;
    }

    @Override // retrofit2.c
    /* JADX INFO: renamed from: a, reason: from getter */
    public Type getResultType() {
        return this.resultType;
    }

    @Override // retrofit2.c
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public retrofit2.b<com.skydoves.sandwich.a<Type>> b(retrofit2.b<Type> call) {
        m.f(call, "call");
        return new b(call, this.coroutineScope);
    }
}
