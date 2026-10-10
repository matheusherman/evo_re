package com.skydoves.sandwich.adapters.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.b0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H&¢\u0006\u0004\b\u0016\u0010\u000bJ\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H&¢\u0006\u0004\b\u0017\u0010\rR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/skydoves/sandwich/adapters/internal/d;", "TIn", "TOut", "Lretrofit2/b;", "proxy", "<init>", "(Lretrofit2/b;)V", "Lretrofit2/d;", "callback", "Lr8/z;", ExifInterface.LATITUDE_SOUTH, "(Lretrofit2/d;)V", "clone", "()Lretrofit2/b;", "cancel", "()V", "Lokhttp3/b0;", "f", "()Lokhttp3/b0;", "", "r", "()Z", "c", "a", "Lretrofit2/b;", "d", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class d<TIn, TOut> implements retrofit2.b<TOut> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final retrofit2.b<TIn> proxy;

    public abstract retrofit2.b<TOut> a();

    public abstract void c(retrofit2.d<TOut> callback);

    public d(retrofit2.b<TIn> proxy) {
        m.f(proxy, "proxy");
        this.proxy = proxy;
    }

    @Override // retrofit2.b
    public final void S(retrofit2.d<TOut> callback) {
        m.f(callback, "callback");
        c(callback);
    }

    @Override // retrofit2.b
    public void cancel() {
        this.proxy.cancel();
    }

    @Override // retrofit2.b
    public final retrofit2.b<TOut> clone() {
        return a();
    }

    protected final retrofit2.b<TIn> d() {
        return this.proxy;
    }

    @Override // retrofit2.b
    public b0 f() {
        b0 b0VarF = this.proxy.f();
        m.e(b0VarF, "proxy.request()");
        return b0VarF;
    }

    @Override // retrofit2.b
    public boolean r() {
        return this.proxy.r();
    }
}
