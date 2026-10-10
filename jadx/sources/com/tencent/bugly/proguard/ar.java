package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ar implements Comparable<ar> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8803a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8804b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8805c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8806d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8807e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8808f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(ar arVar) {
        ar arVar2 = arVar;
        if (arVar2 == null) {
            return 1;
        }
        long j10 = this.f8804b - arVar2.f8804b;
        if (j10 <= 0) {
            return j10 < 0 ? -1 : 0;
        }
        return 1;
    }
}
