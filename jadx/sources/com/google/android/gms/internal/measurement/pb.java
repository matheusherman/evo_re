package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class pb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f2948a;

    static {
        char[] cArr = new char[80];
        f2948a = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String a(ob obVar, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        c(obVar, sb2, 0);
        return sb2.toString();
    }

    private static void b(int i10, StringBuilder sb2) {
        while (i10 > 0) {
            char[] cArr = f2948a;
            int length = i10 > cArr.length ? cArr.length : i10;
            sb2.append(cArr, 0, length);
            i10 -= length;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0208  */
    /* JADX WARN: Code duplicated, block: B:102:0x020a  */
    /* JADX WARN: Code duplicated, block: B:104:0x0218  */
    /* JADX WARN: Code duplicated, block: B:130:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0167  */
    /* JADX WARN: Code duplicated, block: B:60:0x0181  */
    /* JADX WARN: Code duplicated, block: B:62:0x0189  */
    /* JADX WARN: Code duplicated, block: B:64:0x018e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0197  */
    /* JADX WARN: Code duplicated, block: B:67:0x019a  */
    /* JADX WARN: Code duplicated, block: B:68:0x019d  */
    /* JADX WARN: Code duplicated, block: B:70:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:75:0x01af  */
    /* JADX WARN: Code duplicated, block: B:78:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:80:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:83:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:85:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:86:0x01de  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e9  */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x0167, please report this as an issue */
    private static void c(ob obVar, StringBuilder sb2, int i10) {
        int i11;
        Method method;
        Method method2;
        Object objU;
        boolean zBooleanValue;
        boolean zEquals;
        Method method3;
        Method method4;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = obVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i12 = 0;
        while (true) {
            i11 = 3;
            if (i12 >= length) {
                break;
            }
            Method method5 = declaredMethods[i12];
            if (!Modifier.isStatic(method5.getModifiers()) && method5.getName().length() >= 3) {
                if (method5.getName().startsWith("set")) {
                    hashSet.add(method5.getName());
                } else if (Modifier.isPublic(method5.getModifiers()) && method5.getParameterTypes().length == 0) {
                    if (method5.getName().startsWith("has")) {
                        map.put(method5.getName(), method5);
                    } else if (method5.getName().startsWith("get")) {
                        treeMap.put(method5.getName(), method5);
                    }
                }
            }
            i12++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i11);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method4 = (Method) entry.getValue()) != null) {
                if (method4.getReturnType().equals(List.class)) {
                    d(sb2, i10, strSubstring.substring(0, strSubstring.length() - 4), ea.u(method4, obVar, new Object[0]));
                }
                i11 = 3;
            }
            if (!strSubstring.endsWith("Map") || strSubstring.equals("Map") || (method3 = (Method) entry.getValue()) == null || !method3.getReturnType().equals(Map.class) || method3.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method3.getModifiers())) {
                if (hashSet.contains("set" + strSubstring)) {
                    if (strSubstring.endsWith("Bytes")) {
                        if (!treeMap.containsKey("get" + strSubstring.substring(0, strSubstring.length() - 5))) {
                            method = (Method) entry.getValue();
                            method2 = (Method) map.get("has" + strSubstring);
                            if (method != null) {
                                objU = ea.u(method, obVar, new Object[0]);
                                if (method2 == null) {
                                    zBooleanValue = true;
                                    if (objU instanceof Boolean) {
                                        if (((Boolean) objU).booleanValue()) {
                                            zEquals = false;
                                        } else {
                                            zEquals = true;
                                        }
                                    } else if (objU instanceof Integer) {
                                        if (((Integer) objU).intValue() == 0) {
                                            zEquals = true;
                                        } else {
                                            zEquals = false;
                                        }
                                    } else if (objU instanceof Float) {
                                        if (Float.floatToRawIntBits(((Float) objU).floatValue()) == 0) {
                                            zEquals = true;
                                        } else {
                                            zEquals = false;
                                        }
                                    } else if (objU instanceof Double) {
                                        if (Double.doubleToRawLongBits(((Double) objU).doubleValue()) == 0) {
                                            zEquals = true;
                                        } else {
                                            zEquals = false;
                                        }
                                    } else if (objU instanceof String) {
                                        zEquals = objU.equals("");
                                    } else if (objU instanceof v8) {
                                        zEquals = objU.equals(v8.f3170a);
                                    } else if ((objU instanceof ob) ? !((objU instanceof Enum) && ((Enum) objU).ordinal() == 0) : objU != ((ob) objU).d()) {
                                        zEquals = false;
                                    } else {
                                        zEquals = true;
                                    }
                                    if (zEquals) {
                                        zBooleanValue = false;
                                    }
                                } else {
                                    zBooleanValue = ((Boolean) ea.u(method2, obVar, new Object[0])).booleanValue();
                                }
                                if (zBooleanValue) {
                                    d(sb2, i10, strSubstring, objU);
                                }
                            }
                        }
                    } else {
                        method = (Method) entry.getValue();
                        method2 = (Method) map.get("has" + strSubstring);
                        if (method != null) {
                            objU = ea.u(method, obVar, new Object[0]);
                            if (method2 == null) {
                                zBooleanValue = true;
                                if (objU instanceof Boolean) {
                                    if (((Boolean) objU).booleanValue()) {
                                        zEquals = true;
                                    } else {
                                        zEquals = false;
                                    }
                                } else if (objU instanceof Integer) {
                                    if (((Integer) objU).intValue() == 0) {
                                        zEquals = true;
                                    } else {
                                        zEquals = false;
                                    }
                                } else if (objU instanceof Float) {
                                    if (Float.floatToRawIntBits(((Float) objU).floatValue()) == 0) {
                                        zEquals = true;
                                    } else {
                                        zEquals = false;
                                    }
                                } else if (objU instanceof Double) {
                                    if (Double.doubleToRawLongBits(((Double) objU).doubleValue()) == 0) {
                                        zEquals = true;
                                    } else {
                                        zEquals = false;
                                    }
                                } else if (objU instanceof String) {
                                    zEquals = objU.equals("");
                                } else if (objU instanceof v8) {
                                    zEquals = objU.equals(v8.f3170a);
                                } else if (objU instanceof ob) {
                                    zEquals = false;
                                } else {
                                    zEquals = false;
                                }
                                if (zEquals) {
                                    zBooleanValue = false;
                                }
                            } else {
                                zBooleanValue = ((Boolean) ea.u(method2, obVar, new Object[0])).booleanValue();
                            }
                            if (zBooleanValue) {
                                d(sb2, i10, strSubstring, objU);
                            }
                        }
                    }
                }
            } else {
                d(sb2, i10, strSubstring.substring(0, strSubstring.length() - 3), ea.u(method3, obVar, new Object[0]));
            }
            i11 = 3;
        }
        if (obVar instanceof ea.d) {
            Iterator<Map.Entry<T, Object>> itP = ((ea.d) obVar).zzc.p();
            if (itP.hasNext()) {
                throw new NoSuchMethodError();
            }
        }
        uc ucVar = ((ea) obVar).zzb;
        if (ucVar != null) {
            ucVar.h(sb2, i10);
        }
    }

    static void d(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                d(sb2, i10, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                d(sb2, i10, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb2.append('\n');
        b(i10, sb2);
        if (!str.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Character.toLowerCase(str.charAt(0)));
            for (int i11 = 1; i11 < str.length(); i11++) {
                char cCharAt = str.charAt(i11);
                if (Character.isUpperCase(cCharAt)) {
                    sb3.append("_");
                }
                sb3.append(Character.toLowerCase(cCharAt));
            }
            str = sb3.toString();
        }
        sb2.append(str);
        if (obj instanceof String) {
            sb2.append(": \"");
            sb2.append(rc.a(v8.k((String) obj)));
            sb2.append('\"');
            return;
        }
        if (obj instanceof v8) {
            sb2.append(": \"");
            sb2.append(rc.a((v8) obj));
            sb2.append('\"');
            return;
        }
        if (obj instanceof ea) {
            sb2.append(" {");
            c((ea) obj, sb2, i10 + 2);
            sb2.append("\n");
            b(i10, sb2);
            sb2.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb2.append(": ");
            sb2.append(obj);
            return;
        }
        sb2.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i12 = i10 + 2;
        d(sb2, i12, "key", entry.getKey());
        d(sb2, i12, "value", entry.getValue());
        sb2.append("\n");
        b(i10, sb2);
        sb2.append("}");
    }
}
