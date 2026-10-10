package b4;

import com.tencent.bugly.BuglyStrategy;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class e extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f874d;

    @Override // b4.i
    protected void h(StringBuilder sb2, int i10) {
        sb2.append('(');
        sb2.append(this.f874d);
        sb2.append(i10 / BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        sb2.append(')');
    }

    e(p3.a aVar, String str, String str2) {
        super(aVar);
        this.f873c = str2;
        this.f874d = str;
    }

    private void k(StringBuilder sb2, int i10) {
        int iF = b().f(i10, 16);
        if (iF == 38400) {
            return;
        }
        sb2.append('(');
        sb2.append(this.f873c);
        sb2.append(')');
        int i11 = iF % 32;
        int i12 = iF / 32;
        int i13 = (i12 % 12) + 1;
        int i14 = i12 / 12;
        if (i14 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i14);
        if (i13 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i13);
        if (i11 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i11);
    }

    @Override // b4.j
    public String d() throws h3.m {
        if (c().m() == 84) {
            StringBuilder sb2 = new StringBuilder();
            f(sb2, 8);
            j(sb2, 48, 20);
            k(sb2, 68);
            return sb2.toString();
        }
        throw h3.m.a();
    }

    @Override // b4.i
    protected int i(int i10) {
        return i10 % BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
    }
}
