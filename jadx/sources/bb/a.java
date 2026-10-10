package bb;

import db.l;
import eb.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f1018a = new String[100];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1019b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private za.a.b f1020c = za.a.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<za.c> f1021d = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private db.i f1022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Locale f1023f;

    @Override // bb.h
    public void b(j jVar) {
        eb.b bVarA = jVar.a();
        String strB = jVar.b();
        strB.getClass();
        switch (strB) {
            case "permission":
                this.f1020c.D(new za.d(bVarA.e("name"), bVarA.e("label"), bVarA.e("icon"), bVarA.e("description"), bVarA.e("group"), bVarA.e("android:protectionLevel")));
                break;
            case "uses-sdk":
                String strE = bVarA.e("minSdkVersion");
                if (strE != null) {
                    this.f1020c.U(strE);
                }
                String strE2 = bVarA.e("targetSdkVersion");
                if (strE2 != null) {
                    this.f1020c.e0(strE2);
                }
                String strE3 = bVarA.e("maxSdkVersion");
                if (strE3 != null) {
                    this.f1020c.T(strE3);
                    break;
                }
                break;
            case "manifest":
                this.f1020c.W(bVarA.e("package"));
                this.f1020c.g0(bVarA.e("versionName"));
                this.f1020c.Z(bVarA.d("revisionCode"));
                this.f1020c.a0(bVarA.e("sharedUserId"));
                this.f1020c.b0(bVarA.e("sharedUserLabel"));
                this.f1020c.d0(bVarA.e("split"));
                this.f1020c.K(bVarA.e("configForSplit"));
                this.f1020c.O(bVarA.b("isFeatureSplit", false));
                this.f1020c.P(bVarA.b("isSplitRequired", false));
                this.f1020c.Q(bVarA.b("isolatedSplits", false));
                Long lD = bVarA.d("versionCodeMajor");
                Long lD2 = bVarA.d("versionCode");
                if (lD != null) {
                    if (lD2 == null) {
                        lD2 = 0L;
                    }
                    lD2 = Long.valueOf((lD2.longValue() & 4294967295L) | (lD.longValue() << 32));
                }
                this.f1020c.f0(lD2);
                String strE4 = bVarA.e("installLocation");
                if (strE4 != null) {
                    this.f1020c.N(strE4);
                }
                this.f1020c.I(bVarA.e("compileSdkVersion"));
                this.f1020c.J(bVarA.e("compileSdkVersionCodename"));
                this.f1020c.X(bVarA.e("platformBuildVersionCode"));
                this.f1020c.Y(bVarA.e("platformBuildVersionName"));
                break;
            case "uses-permission":
                this.f1020c.F(bVarA.e("name"));
                break;
            case "supports-screens":
                this.f1020c.H(bVarA.b("anyDensity", false));
                this.f1020c.c0(bVarA.b("smallScreens", false));
                this.f1020c.V(bVarA.b("normalScreens", false));
                this.f1020c.S(bVarA.b("largeScreens", false));
                break;
            case "application":
                String strE5 = bVarA.e("label");
                if (strE5 != null) {
                    this.f1020c.R(strE5);
                }
                eb.a aVarA = bVarA.a("icon");
                if (aVarA != null) {
                    cb.b bVarC = aVarA.c();
                    if (bVarC instanceof cb.b.j) {
                        List<db.i.a> listC = this.f1022e.c(((cb.b.j) bVarC).m());
                        if (!listC.isEmpty()) {
                            ArrayList arrayList = new ArrayList();
                            boolean z10 = false;
                            for (db.i.a aVar : listC) {
                                l lVarB = aVar.b();
                                String strI = aVar.a().i(this.f1022e, this.f1023f);
                                if (lVarB.a() == 0) {
                                    this.f1020c.M(strI);
                                    z10 = true;
                                }
                                arrayList.add(new za.c(strI, lVarB.a()));
                            }
                            if (!z10) {
                                this.f1020c.M(((za.c) arrayList.get(0)).a());
                            }
                            this.f1021d = arrayList;
                        }
                    } else {
                        String strD = aVarA.d();
                        if (strD != null) {
                            this.f1020c.M(strD);
                            this.f1021d = Collections.singletonList(new za.c(strD, 0));
                        }
                    }
                    break;
                }
                break;
            case "uses-feature":
                String strE6 = bVarA.e("name");
                boolean zB = bVarA.b("required", false);
                if (strE6 == null) {
                    Integer numC = bVarA.c("glEsVersion");
                    if (numC != null) {
                        int iIntValue = numC.intValue();
                        this.f1020c.L(new za.b(iIntValue >> 16, iIntValue & 65535, zB));
                    }
                    break;
                } else {
                    this.f1020c.E(new za.e(strE6, zB));
                    break;
                }
                break;
        }
        String[] strArr = this.f1018a;
        int i10 = this.f1019b;
        this.f1019b = i10 + 1;
        strArr[i10] = jVar.b();
    }

    @Override // bb.h
    public void d(eb.h hVar) {
        this.f1019b--;
    }

    public za.a e() {
        return this.f1020c.G();
    }

    public List<za.c> f() {
        return this.f1021d;
    }

    public a(db.i iVar, Locale locale) {
        Objects.requireNonNull(iVar);
        this.f1022e = iVar;
        this.f1023f = locale;
    }

    @Override // bb.h
    public void a(eb.f fVar) {
    }

    @Override // bb.h
    public void c(eb.g gVar) {
    }
}
