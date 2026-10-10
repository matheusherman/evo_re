package com.google.android.exoplayer2.ui;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public interface a0 {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
        void a(a0 a0Var, long j10);

        void b(a0 a0Var, long j10, boolean z10);

        void c(a0 a0Var, long j10);
    }

    void a(a aVar);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j10);

    void setEnabled(boolean z10);

    void setPosition(long j10);
}
