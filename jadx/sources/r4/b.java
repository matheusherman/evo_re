package r4;

import com.koushikdutta.async.l;
import com.koushikdutta.async.n;
import com.koushikdutta.async.q;
import com.koushikdutta.async.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b extends q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17812g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17813h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private EnumC0340b f17814i = EnumC0340b.CHUNK_LEN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    l f17815j = new l();

    /* JADX INFO: renamed from: r4.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum EnumC0340b {
        CHUNK_LEN,
        CHUNK_LEN_CR,
        CHUNK_LEN_CRLF,
        CHUNK,
        CHUNK_CR,
        CHUNK_CRLF,
        COMPLETE,
        ERROR
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17816a;

        static {
            int[] iArr = new int[EnumC0340b.values().length];
            f17816a = iArr;
            try {
                iArr[EnumC0340b.CHUNK_LEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17816a[EnumC0340b.CHUNK_LEN_CR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17816a[EnumC0340b.CHUNK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17816a[EnumC0340b.CHUNK_CR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17816a[EnumC0340b.CHUNK_CRLF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17816a[EnumC0340b.COMPLETE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private boolean A(char c10) {
        return y(c10, '\n');
    }

    private boolean y(char c10, char c11) {
        if (c10 == c11) {
            return true;
        }
        this.f17814i = EnumC0340b.ERROR;
        w(new r4.a(c11 + " was expected, got " + c10));
        return false;
    }

    private boolean z(char c10) {
        return y(c10, '\r');
    }

    @Override // com.koushikdutta.async.q, o4.b
    public void i(n nVar, l lVar) {
        if (this.f17814i == EnumC0340b.ERROR) {
            lVar.z();
            return;
        }
        while (lVar.A() > 0) {
            try {
                switch (a.f17816a[this.f17814i.ordinal()]) {
                    case 1:
                        char cK = lVar.k();
                        if (cK == '\r') {
                            this.f17814i = EnumC0340b.CHUNK_LEN_CR;
                        } else {
                            int i10 = this.f17812g * 16;
                            this.f17812g = i10;
                            if (cK >= 'a' && cK <= 'f') {
                                this.f17812g = i10 + (cK - 'W');
                            } else if (cK >= '0' && cK <= '9') {
                                this.f17812g = i10 + (cK - '0');
                            } else {
                                if (cK < 'A' || cK > 'F') {
                                    w(new r4.a("invalid chunk length: " + cK));
                                    return;
                                }
                                this.f17812g = i10 + (cK - '7');
                            }
                        }
                        this.f17813h = this.f17812g;
                        continue;
                    case 2:
                        if (A(lVar.k())) {
                            this.f17814i = EnumC0340b.CHUNK;
                            continue;
                        } else {
                            return;
                        }
                        break;
                    case 3:
                        int iMin = Math.min(this.f17813h, lVar.A());
                        int i11 = this.f17813h - iMin;
                        this.f17813h = i11;
                        if (i11 == 0) {
                            this.f17814i = EnumC0340b.CHUNK_CR;
                        }
                        if (iMin != 0) {
                            lVar.g(this.f17815j, iMin);
                            y.a(this, this.f17815j);
                            continue;
                        }
                        break;
                    case 4:
                        if (z(lVar.k())) {
                            this.f17814i = EnumC0340b.CHUNK_CRLF;
                            continue;
                        } else {
                            return;
                        }
                        break;
                    case 5:
                        if (A(lVar.k())) {
                            if (this.f17812g > 0) {
                                this.f17814i = EnumC0340b.CHUNK_LEN;
                            } else {
                                this.f17814i = EnumC0340b.COMPLETE;
                                w(null);
                            }
                            this.f17812g = 0;
                            continue;
                        } else {
                            return;
                        }
                        break;
                    case 6:
                        return;
                    default:
                        continue;
                }
            } catch (Exception e10) {
                w(e10);
                return;
            }
            w(e10);
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.async.o
    public void w(Exception exc) {
        if (exc == null && this.f17814i != EnumC0340b.COMPLETE) {
            exc = new r4.a("chunked input ended before final chunk");
        }
        super.w(exc);
    }
}
