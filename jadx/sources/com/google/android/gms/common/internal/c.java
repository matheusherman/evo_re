package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class c<T extends IInterface> extends b<T> implements com.google.android.gms.common.api.a.f {
    private final m1.c F;
    private final Set G;

    @Nullable
    private final Account H;

    @Deprecated
    protected c(@NonNull Context context, @NonNull Looper looper, int i10, @NonNull m1.c cVar, @NonNull com.google.android.gms.common.api.g.a aVar, @NonNull com.google.android.gms.common.api.g.b bVar) {
        this(context, looper, i10, cVar, (k1.d) aVar, (k1.k) bVar);
    }

    @Override // com.google.android.gms.common.internal.b
    @Nullable
    protected Executor u() {
        return null;
    }

    protected c(@NonNull Context context, @NonNull Looper looper, int i10, @NonNull m1.c cVar, @NonNull k1.d dVar, @NonNull k1.k kVar) {
        this(context, looper, d.a(context), com.google.android.gms.common.a.m(), i10, cVar, (k1.d) m1.g.k(dVar), (k1.k) m1.g.k(kVar));
    }

    @Override // com.google.android.gms.common.internal.b
    @NonNull
    protected final Set<Scope> A() {
        return this.G;
    }

    @Override // com.google.android.gms.common.internal.b
    @Nullable
    public final Account s() {
        return this.H;
    }

    private final Set i0(@NonNull Set set) {
        Set<Scope> setH0 = h0(set);
        Iterator<Scope> it = setH0.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setH0;
    }

    @Override // com.google.android.gms.common.api.a.f
    @NonNull
    public Set<Scope> a() {
        if (m()) {
            return this.G;
        }
        return Collections.EMPTY_SET;
    }

    @VisibleForTesting
    protected c(@NonNull Context context, @NonNull Looper looper, @NonNull d dVar, @NonNull com.google.android.gms.common.a aVar, int i10, @NonNull m1.c cVar, @Nullable k1.d dVar2, @Nullable k1.k kVar) {
        super(context, looper, dVar, aVar, i10, dVar2 == null ? null : new f(dVar2), kVar != null ? new g(kVar) : null, cVar.h());
        this.F = cVar;
        this.H = cVar.a();
        this.G = i0(cVar.c());
    }

    @NonNull
    protected Set<Scope> h0(@NonNull Set<Scope> set) {
        return set;
    }
}
