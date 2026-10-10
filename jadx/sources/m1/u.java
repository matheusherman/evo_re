package m1;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class u extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f15510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ k1.h f15511b;

    u(Intent intent, k1.h hVar, int i10) {
        this.f15510a = intent;
        this.f15511b = hVar;
    }

    @Override // m1.v
    public final void a() {
        Intent intent = this.f15510a;
        if (intent != null) {
            this.f15511b.startActivityForResult(intent, 2);
        }
    }
}
