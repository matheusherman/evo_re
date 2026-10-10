package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class ae {
    public static bu a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        bu buVar = new bu();
        buVar.f9046a = userInfoBean.f8559e;
        buVar.f9050e = userInfoBean.f8564j;
        buVar.f9049d = userInfoBean.f8557c;
        buVar.f9048c = userInfoBean.f8558d;
        buVar.f9053h = userInfoBean.f8569o == 1;
        int i10 = userInfoBean.f8556b;
        if (i10 == 1) {
            buVar.f9047b = (byte) 1;
        } else if (i10 == 2) {
            buVar.f9047b = (byte) 4;
        } else if (i10 == 3) {
            buVar.f9047b = (byte) 2;
        } else if (i10 == 4) {
            buVar.f9047b = (byte) 3;
        } else if (i10 == 8) {
            buVar.f9047b = (byte) 8;
        } else {
            if (i10 < 10 || i10 >= 20) {
                al.e("unknown uinfo type %d ", Integer.valueOf(i10));
                return null;
            }
            buVar.f9047b = (byte) i10;
        }
        HashMap map = new HashMap();
        buVar.f9051f = map;
        if (userInfoBean.f8570p >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.f8570p);
            map.put("C01", sb2.toString());
        }
        if (userInfoBean.f8571q >= 0) {
            Map<String, String> map2 = buVar.f9051f;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(userInfoBean.f8571q);
            map2.put("C02", sb3.toString());
        }
        Map<String, String> map3 = userInfoBean.f8572r;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f8572r.entrySet()) {
                buVar.f9051f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.f8573s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f8573s.entrySet()) {
                buVar.f9051f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map5 = buVar.f9051f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(!userInfoBean.f8566l);
        map5.put("A36", sb4.toString());
        Map<String, String> map6 = buVar.f9051f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f8561g);
        map6.put("F02", sb5.toString());
        Map<String, String> map7 = buVar.f9051f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f8562h);
        map7.put("F03", sb6.toString());
        buVar.f9051f.put("F04", userInfoBean.f8564j);
        Map<String, String> map8 = buVar.f9051f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f8563i);
        map8.put("F05", sb7.toString());
        buVar.f9051f.put("F06", userInfoBean.f8567m);
        Map<String, String> map9 = buVar.f9051f;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(userInfoBean.f8565k);
        map9.put("F10", sb8.toString());
        al.c("summary type %d vm:%d", Byte.valueOf(buVar.f9047b), Integer.valueOf(buVar.f9051f.size()));
        return buVar;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T tNewInstance = cls.newInstance();
                k kVar = new k(bArr);
                kVar.a("utf-8");
                tNewInstance.a(kVar);
                return tNewInstance;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static bq a(Context context, int i10, byte[] bArr) {
        String str;
        aa aaVarB = aa.b();
        StrategyBean strategyBeanC = ac.a().c();
        if (aaVarB != null && strategyBeanC != null) {
            try {
                bq bqVar = new bq();
                synchronized (aaVarB) {
                    try {
                        bqVar.f8994a = aaVarB.f8665b;
                        bqVar.f8995b = aaVarB.e();
                        bqVar.f8996c = aaVarB.f8666c;
                        bqVar.f8997d = aaVarB.f8678o;
                        bqVar.f8998e = aaVarB.f8682s;
                        bqVar.f8999f = aaVarB.f8671h;
                        bqVar.f9000g = i10;
                        if (bArr == null) {
                            bArr = "".getBytes();
                        }
                        bqVar.f9001h = bArr;
                        bqVar.f9002i = aaVarB.h();
                        bqVar.f9003j = aaVarB.f8674k;
                        bqVar.f9004k = new HashMap();
                        bqVar.f9005l = aaVarB.d();
                        bqVar.f9006m = strategyBeanC.f8591o;
                        bqVar.f9008o = aaVarB.g();
                        bqVar.f9009p = ab.c(context);
                        bqVar.f9010q = System.currentTimeMillis();
                        bqVar.f9012s = aaVarB.i();
                        bqVar.f9015v = aaVarB.g();
                        bqVar.f9016w = bqVar.f9009p;
                        bqVar.f9007n = "com.tencent.bugly";
                        bqVar.f9004k.put("A26", aaVarB.s());
                        Map<String, String> map = bqVar.f9004k;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(aa.C());
                        map.put("A62", sb2.toString());
                        Map<String, String> map2 = bqVar.f9004k;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(aa.D());
                        map2.put("A63", sb3.toString());
                        Map<String, String> map3 = bqVar.f9004k;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(aaVarB.J);
                        map3.put("F11", sb4.toString());
                        Map<String, String> map4 = bqVar.f9004k;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(aaVarB.I);
                        map4.put("F12", sb5.toString());
                        bqVar.f9004k.put("D3", aaVarB.f8680q);
                        List<o> list = p.f9100b;
                        if (list != null) {
                            for (o oVar : list) {
                                String str2 = oVar.versionKey;
                                if (str2 != null && (str = oVar.version) != null) {
                                    bqVar.f9004k.put(str2, str);
                                }
                            }
                        }
                        bqVar.f9004k.put("G15", ap.d("G15", ""));
                        bqVar.f9004k.put("G10", ap.d("G10", ""));
                        bqVar.f9004k.put("D4", ap.d("D4", "0"));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Map<String, String> mapX = aaVarB.x();
                if (mapX != null) {
                    for (Map.Entry<String, String> entry : mapX.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            bqVar.f9004k.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                return bqVar;
            } catch (Throwable th2) {
                if (!al.b(th2)) {
                    th2.printStackTrace();
                }
                return null;
            }
        }
        al.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            e eVar = new e();
            eVar.b();
            eVar.a("utf-8");
            eVar.c();
            eVar.b("RqdServer");
            eVar.c("sync");
            eVar.a("detail", obj);
            return eVar.a();
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static br a(byte[] bArr) {
        if (bArr != null) {
            try {
                e eVar = new e();
                eVar.b();
                eVar.a("utf-8");
                eVar.a(bArr);
                Object objB = eVar.b("detail", new br());
                if (br.class.isInstance(objB)) {
                    return (br) br.class.cast(objB);
                }
                return null;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(m mVar) {
        try {
            l lVar = new l();
            lVar.a("utf-8");
            mVar.a(lVar);
            byte[] bArr = new byte[lVar.f9094a.position()];
            System.arraycopy(lVar.f9094a.array(), 0, bArr, 0, lVar.f9094a.position());
            return bArr;
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
