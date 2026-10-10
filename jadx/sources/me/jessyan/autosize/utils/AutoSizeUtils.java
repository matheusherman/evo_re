package me.jessyan.autosize.utils;

import android.app.Application;
import android.content.Context;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class AutoSizeUtils {
    public static Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("getApplication", null).invoke(cls.getMethod("currentActivityThread", null).invoke(null, null), null);
            if (objInvoke != null) {
                return (Application) objInvoke;
            }
            throw new NullPointerException("you should init first");
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (NoSuchMethodException e12) {
            e12.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
            throw new NullPointerException("you should init first");
        }
    }

    private AutoSizeUtils() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static int dp2px(Context context, float f10) {
        return (int) (TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int in2px(Context context, float f10) {
        return (int) (TypedValue.applyDimension(4, f10, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int mm2px(Context context, float f10) {
        return (int) (TypedValue.applyDimension(5, f10, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int pt2px(Context context, float f10) {
        return (int) (TypedValue.applyDimension(3, f10, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int sp2px(Context context, float f10) {
        return (int) (TypedValue.applyDimension(2, f10, context.getResources().getDisplayMetrics()) + 0.5f);
    }
}
