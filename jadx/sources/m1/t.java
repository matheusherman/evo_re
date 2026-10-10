package m1;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class t extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f15507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f15508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f15509c;

    t(Intent intent, Activity activity, int i10) {
        this.f15507a = intent;
        this.f15508b = activity;
        this.f15509c = i10;
    }

    @Override // m1.v
    public final void a() {
        Intent intent = this.f15507a;
        if (intent != null) {
            this.f15508b.startActivityForResult(intent, this.f15509c);
        }
    }
}
