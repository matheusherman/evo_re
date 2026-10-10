package v3;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class a implements g {
    public int c() {
        return 0;
    }

    a() {
    }

    private static char b(char c10, char c11) {
        if (j.f(c10) && j.f(c11)) {
            return (char) (((c10 - '0') * 10) + (c11 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c10 + c11);
    }

    @Override // v3.g
    public void a(h hVar) {
        if (j.a(hVar.d(), hVar.f19544f) >= 2) {
            hVar.r(b(hVar.d().charAt(hVar.f19544f), hVar.d().charAt(hVar.f19544f + 1)));
            hVar.f19544f += 2;
            return;
        }
        char c10 = hVar.c();
        int iN = j.n(hVar.d(), hVar.f19544f, c());
        if (iN != c()) {
            if (iN != 1) {
                if (iN != 2) {
                    if (iN != 3) {
                        if (iN != 4) {
                            if (iN == 5) {
                                hVar.r((char) 231);
                                hVar.o(5);
                                return;
                            } else {
                                throw new IllegalStateException("Illegal mode: " + iN);
                            }
                        }
                        hVar.r((char) 240);
                        hVar.o(4);
                        return;
                    }
                    hVar.r((char) 238);
                    hVar.o(3);
                    return;
                }
                hVar.r((char) 239);
                hVar.o(2);
                return;
            }
            hVar.r((char) 230);
            hVar.o(1);
            return;
        }
        if (j.g(c10)) {
            hVar.r((char) 235);
            hVar.r((char) (c10 - 127));
            hVar.f19544f++;
        } else {
            hVar.r((char) (c10 + 1));
            hVar.f19544f++;
        }
    }
}
