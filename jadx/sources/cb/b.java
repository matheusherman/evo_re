package cb;

import db.l;
import db.n;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f1153a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: cb.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class C0034b extends b {
        /* synthetic */ C0034b(int i10, a aVar) {
            this(i10);
        }

        private C0034b(int i10) {
            super(i10);
        }

        @Override // cb.b
        public String k(db.i iVar, Locale locale) {
            return String.valueOf(this.f1153a != 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c extends b {
        /* synthetic */ c(int i10, a aVar) {
            this(i10);
        }

        private c(int i10) {
            super(i10);
        }

        @Override // cb.b
        public String k(db.i iVar, Locale locale) {
            return String.valueOf(this.f1153a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class d extends b {
        /* synthetic */ d(int i10, a aVar) {
            this(i10);
        }

        private d(int i10) {
            super(i10);
        }

        @Override // cb.b
        public String k(db.i iVar, Locale locale) {
            String str;
            short s10 = (short) (this.f1153a & 255);
            if (s10 == 0) {
                str = "px";
            } else if (s10 == 1) {
                str = "dp";
            } else if (s10 == 2) {
                str = "sp";
            } else if (s10 == 3) {
                str = "pt";
            } else if (s10 == 4) {
                str = "in";
            } else if (s10 != 5) {
                str = "unknown unit:0x" + Integer.toHexString(s10);
            } else {
                str = "mm";
            }
            return (this.f1153a >> 8) + str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class e extends b {
        /* synthetic */ e(int i10, a aVar) {
            this(i10);
        }

        private e(int i10) {
            super(i10);
        }

        @Override // cb.b
        public String k(db.i iVar, Locale locale) {
            String str;
            short s10 = (short) (this.f1153a & 15);
            if (s10 == 0) {
                str = "%";
            } else if (s10 != 1) {
                str = "unknown type:0x" + Integer.toHexString(s10);
            } else {
                str = "%p";
            }
            return Float.intBitsToFloat(this.f1153a >> 4) + str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class f extends b {
        /* synthetic */ f(int i10, a aVar) {
            this(i10);
        }

        private f(int i10) {
            super(i10);
        }

        @Override // cb.b
        public String k(db.i iVar, Locale locale) {
            return "0x" + Integer.toHexString(this.f1153a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class g extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final g f1154b = new g();

        private g() {
            super(-1);
        }

        @Override // cb.b
        public String k(db.i iVar, Locale locale) {
            return "";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class h extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1155b;

        /* synthetic */ h(int i10, int i11, a aVar) {
            this(i10, i11);
        }

        private h(int i10, int i11) {
            super(i10);
            this.f1155b = i11;
        }

        @Override // cb.b
        public String k(db.i iVar, Locale locale) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = (this.f1155b / 2) - 1; i10 >= 0; i10--) {
                sb2.append(Integer.toHexString((this.f1153a >> (i10 * 8)) & 255));
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class i extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final short f1156b;

        /* synthetic */ i(int i10, short s10, a aVar) {
            this(i10, s10);
        }

        private i(int i10, short s10) {
            super(i10);
            this.f1156b = s10;
        }

        @Override // cb.b
        public String k(db.i iVar, Locale locale) {
            return "{" + ((int) this.f1156b) + ":" + (((long) this.f1153a) & 4294967295L) + "}";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class j extends b {
        /* synthetic */ j(int i10, a aVar) {
            this(i10);
        }

        private j(int i10) {
            super(i10);
        }

        public long m() {
            return ((long) this.f1153a) & 4294967295L;
        }

        private static int l(int i10) {
            if (i10 != 65534 && i10 != 65535) {
                if (i10 == 0) {
                    return 0;
                }
                return i10;
            }
            return -1;
        }

        @Override // cb.b
        public String k(db.i iVar, Locale locale) {
            long jM = m();
            if (jM > 16973824 && jM < 16977920) {
                return "@android:style/" + db.i.f9695c.get(Integer.valueOf((int) jM));
            }
            String str = "resourceId:0x" + Long.toHexString(jM);
            if (iVar != null) {
                int i10 = -1;
                db.f fVar = null;
                n nVar = null;
                int i11 = -1;
                for (db.i.a aVar : iVar.c(jM)) {
                    l lVarB = aVar.b();
                    n nVarC = aVar.c();
                    db.f fVarA = aVar.a();
                    int iA = fb.c.a(locale, lVarB.c());
                    int iL = l(lVarB.a());
                    if (iA > i10) {
                        fVar = fVarA;
                        i11 = iL;
                        i10 = iA;
                    } else if (iL > i11) {
                        fVar = fVarA;
                        i11 = iL;
                    }
                    nVar = nVarC;
                }
                if (fVar != null) {
                    if (locale == null) {
                        return "@" + nVar.c() + "/" + fVar.b();
                    }
                    return fVar.i(iVar, locale);
                }
            }
            return str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class k extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final cb.c f1157b;

        /* synthetic */ k(int i10, cb.c cVar, a aVar) {
            this(i10, cVar);
        }

        private k(int i10, cb.c cVar) {
            super(i10);
            this.f1157b = cVar;
        }

        @Override // cb.b
        public String k(db.i iVar, Locale locale) {
            int i10 = this.f1153a;
            if (i10 >= 0) {
                return this.f1157b.a(i10);
            }
            return null;
        }

        public String toString() {
            return this.f1153a + ":" + this.f1157b.a(this.f1153a);
        }
    }

    public abstract String k(db.i iVar, Locale locale);

    public static b a(int i10) {
        return new C0034b(i10, null);
    }

    public static b b(int i10) {
        return new c(i10, null);
    }

    public static b c(int i10) {
        return new d(i10, null);
    }

    public static b d(int i10) {
        return new e(i10, null);
    }

    public static b e(int i10) {
        return new f(i10, null);
    }

    public static b g(int i10, short s10) {
        return new i(i10, s10, null);
    }

    public static b h(int i10) {
        return new j(i10, null);
    }

    public static b i(int i10, int i11) {
        return new h(i10, i11, null);
    }

    public static b j(int i10, cb.c cVar) {
        return new k(i10, cVar, null);
    }

    protected b(int i10) {
        this.f1153a = i10;
    }

    public static b f() {
        return g.f1154b;
    }
}
