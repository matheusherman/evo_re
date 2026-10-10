package d4;

import java.util.Formatter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f9631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d[] f9632b;

    final c a() {
        return this.f9631a;
    }

    final d b(int i10) {
        return this.f9632b[e(i10)];
    }

    final d[] d() {
        return this.f9632b;
    }

    final int e(int i10) {
        return i10 - this.f9631a.g();
    }

    final void f(int i10, d dVar) {
        this.f9632b[e(i10)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i10 = 0;
            for (d dVar : this.f9632b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i10));
                    i10++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i10), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i10++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (Throwable th) {
            try {
                formatter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    g(c cVar) {
        this.f9631a = new c(cVar);
        this.f9632b = new d[(cVar.e() - cVar.g()) + 1];
    }

    final d c(int i10) {
        d dVar;
        d dVar2;
        d dVarB = b(i10);
        if (dVarB != null) {
            return dVarB;
        }
        for (int i11 = 1; i11 < 5; i11++) {
            int iE = e(i10) - i11;
            if (iE >= 0 && (dVar2 = this.f9632b[iE]) != null) {
                return dVar2;
            }
            int iE2 = e(i10) + i11;
            d[] dVarArr = this.f9632b;
            if (iE2 < dVarArr.length && (dVar = dVarArr[iE2]) != null) {
                return dVar;
            }
        }
        return null;
    }
}
