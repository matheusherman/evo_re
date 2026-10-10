package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class lg extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final pg f2850c;

    public lg(pg pgVar) {
        super("internal.logger");
        this.f2850c = pgVar;
        this.f2887b.put("log", new og(this, false, true));
        this.f2887b.put(NotificationCompat.GROUP_KEY_SILENT, new ag(this, NotificationCompat.GROUP_KEY_SILENT));
        ((n) this.f2887b.get(NotificationCompat.GROUP_KEY_SILENT)).m("log", new og(this, true, true));
        this.f2887b.put("unmonitored", new ng(this, "unmonitored"));
        ((n) this.f2887b.get("unmonitored")).m("log", new og(this, false, false));
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final s a(v6 v6Var, List<s> list) {
        return s.f3010a0;
    }
}
