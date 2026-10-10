package com.live.evo.widget.nicespinner;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
enum d {
    START(0),
    END(1),
    CENTER(2);


    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f7663id;

    d(int i10) {
        this.f7663id = i10;
    }

    static d f(int i10) {
        for (d dVar : values()) {
            if (dVar.f7663id == i10) {
                return dVar;
            }
        }
        return CENTER;
    }
}
