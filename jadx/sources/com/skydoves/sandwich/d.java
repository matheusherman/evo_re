package com.skydoves.sandwich;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0007\u0010\u000f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0005\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/skydoves/sandwich/d;", "", "<init>", "()V", "Lh9/e;", "b", "Lh9/e;", "c", "()Lh9/e;", "setSuccessCodeRange", "(Lh9/e;)V", "getSuccessCodeRange$annotations", "successCodeRange", "", "Lm6/c;", "Ljava/util/List;", "a", "()Ljava/util/List;", "setSandwichOperators", "(Ljava/util/List;)V", "getSandwichOperators$annotations", "sandwichOperators", "Lkotlinx/coroutines/l0;", "d", "Lkotlinx/coroutines/l0;", "()Lkotlinx/coroutines/l0;", "setSandwichScope", "(Lkotlinx/coroutines/l0;)V", "sandwichScope", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8347a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static h9.e successCodeRange = new h9.e(200, 299);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static List<m6.c> sandwichOperators = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static /* synthetic */ l0 sandwichScope = m0.a(a1.b());

    public static final List<m6.c> a() {
        return sandwichOperators;
    }

    public static final h9.e c() {
        return successCodeRange;
    }

    public final l0 b() {
        return sandwichScope;
    }

    private d() {
    }
}
