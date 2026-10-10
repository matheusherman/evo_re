package uc;

import tc.c;
import tc.d;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f19469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f19470d;

    public a(String str, int i10) {
        this(str, i10, null, d.ANY);
    }

    public a(String str, int i10, Object obj, d dVar) {
        this.f19467a = str;
        this.f19468b = i10;
        this.f19469c = obj;
        if (obj instanceof d) {
            throw new IllegalArgumentException("params should not be CryptoServicePurpose");
        }
        this.f19470d = dVar;
    }

    @Override // tc.c
    public String a() {
        return this.f19467a;
    }
}
