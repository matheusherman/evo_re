package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class e extends ContextWrapper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    static final m<?, ?> f1303k = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m.b f1304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e0.f.b<i> f1305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b0.f f1306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c.a f1307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<a0.h<Object>> f1308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, m<?, ?>> f1309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l.k f1310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final f f1311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f1312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private a0.i f1313j;

    public synchronized a0.i d() {
        try {
            if (this.f1313j == null) {
                this.f1313j = this.f1307d.build().T();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1313j;
    }

    @NonNull
    public <X> b0.j<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f1306c.a(imageView, cls);
    }

    @NonNull
    public m.b b() {
        return this.f1304a;
    }

    public List<a0.h<Object>> c() {
        return this.f1308e;
    }

    @NonNull
    public <T> m<?, T> e(@NonNull Class<T> cls) {
        m<?, T> mVar = (m) this.f1309f.get(cls);
        if (mVar == null) {
            for (Map.Entry<Class<?>, m<?, ?>> entry : this.f1309f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    mVar = (m) entry.getValue();
                }
            }
        }
        return mVar == null ? (m<?, T>) f1303k : mVar;
    }

    @NonNull
    public l.k f() {
        return this.f1310g;
    }

    public f g() {
        return this.f1311h;
    }

    public int h() {
        return this.f1312i;
    }

    @NonNull
    public i i() {
        return this.f1305b.get();
    }

    public e(@NonNull Context context, @NonNull m.b bVar, @NonNull e0.f.b<i> bVar2, @NonNull b0.f fVar, @NonNull c.a aVar, @NonNull Map<Class<?>, m<?, ?>> map, @NonNull List<a0.h<Object>> list, @NonNull l.k kVar, @NonNull f fVar2, int i10) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f1304a = bVar;
        this.f1306c = fVar;
        this.f1307d = aVar;
        this.f1308e = list;
        this.f1309f = map;
        this.f1310g = kVar;
        this.f1311h = fVar2;
        this.f1312i = i10;
        this.f1305b = e0.f.a(bVar2);
    }
}
