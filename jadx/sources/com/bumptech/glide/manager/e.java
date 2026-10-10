package com.bumptech.glide.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final c.a f1409b;

    private void c() {
        t.a(this.f1408a).d(this.f1409b);
    }

    private void e() {
        t.a(this.f1408a).e(this.f1409b);
    }

    e(@NonNull Context context, @NonNull c.a aVar) {
        this.f1408a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f1409b = aVar;
    }

    @Override // com.bumptech.glide.manager.m
    public void h() {
        e();
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
        c();
    }

    @Override // com.bumptech.glide.manager.m
    public void d() {
    }
}
