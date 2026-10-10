package fc;

import java.io.IOException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class r2 implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o f10218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f10219b = a();

    private Object a() {
        try {
            return this.f10218a.l();
        } catch (IOException e10) {
            throw new y("malformed ASN.1: " + e10, e10);
        }
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f10219b != null;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object obj = this.f10219b;
        if (obj == null) {
            throw new NoSuchElementException();
        }
        this.f10219b = a();
        return obj;
    }

    public r2(byte[] bArr) {
        this.f10218a = new o(bArr, true);
    }
}
