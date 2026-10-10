package com.taobao.sophix;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f8442a = a("android.app.ContextImpl");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class f8443b = a("android.app.ActivityThread");

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e10) {
            s.a("ReflectUtil", "fail to reflect", e10, new Object[0]);
            return null;
        }
    }

    public static Method a(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod;
    }

    public static Constructor a(Class cls, Class... clsArr) throws NoSuchMethodException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
        if (!declaredConstructor.isAccessible()) {
            declaredConstructor.setAccessible(true);
        }
        return declaredConstructor;
    }

    public static Field a(Class cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (!declaredField.isAccessible()) {
            declaredField.setAccessible(true);
        }
        return declaredField;
    }
}
