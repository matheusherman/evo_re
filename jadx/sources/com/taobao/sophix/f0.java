package com.taobao.sophix;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.ArrayMap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class f8444a;

    @TargetApi(24)
    private void b(String str) throws IllegalAccessException, NoSuchFieldException {
        Object obj = e0.a(e0.f8442a, "mPackageInfo").get(j.f8458b.getBaseContext());
        Field fieldA = e0.a(obj.getClass(), "mSplitResDirs");
        fieldA.set(obj, a((String[]) fieldA.get(obj), str));
    }

    public boolean a(File file) throws w {
        if (Build.VERSION.SDK_INT >= 30 && b(file)) {
            return true;
        }
        String path = file.getPath();
        try {
            b(path);
            AssetManager assets = j.f8458b.getAssets();
            synchronized (assets) {
                try {
                    try {
                        a("addAssetPath", String.class).invoke(assets, path);
                        try {
                            a();
                        } catch (Exception e10) {
                            throw new w(122, e10);
                        }
                    } catch (Exception e11) {
                        throw new w(123, e11);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } catch (Exception e12) {
            throw new w(121, e12);
        }
    }

    public f0() throws w {
        try {
            this.f8444a = Class.forName("android.content.res.AssetManager");
        } catch (ClassNotFoundException e10) {
            throw new w(82, e10);
        }
    }

    @SuppressLint({"NewApi"})
    private boolean b(File file) {
        s.a("ResourceManager", "patchV30", "start patch res file");
        try {
            ResourcesProvider resourcesProviderLoadFromApk = ResourcesProvider.loadFromApk(ParcelFileDescriptor.open(file, 268435456));
            com.google.android.material.color.h.a();
            ResourcesLoader resourcesLoaderA = com.google.android.material.color.g.a();
            resourcesLoaderA.addProvider(resourcesProviderLoadFromApk);
            j.f8458b.getResources().addLoaders(resourcesLoaderA);
            s.a("ResourceManager", "patchV30", "patch res file success");
            return true;
        } catch (Throwable unused) {
            s.a("ResourceManager", "patchV30", "patch res file error");
            return false;
        }
    }

    private String[] a(String[] strArr, String str) {
        int length = strArr != null ? strArr.length : 0;
        String[] strArr2 = new String[length + 1];
        if (strArr != null) {
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        strArr2[length] = str;
        return strArr2;
    }

    private void a() throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Collection collectionValues;
        Class<?> cls = Class.forName("android.app.ResourcesManager");
        Object objInvoke = e0.a(cls, "getInstance", new Class[0]).invoke(null, null);
        try {
            collectionValues = ((ArrayMap) e0.a(cls, "mActiveResources").get(objInvoke)).values();
        } catch (NoSuchFieldException unused) {
            collectionValues = (Collection) e0.a(cls, "mResourceReferences").get(objInvoke);
        }
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            Resources resources = (Resources) ((WeakReference) it.next()).get();
            if (resources != null) {
                resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                s.d("ResourceManager", "update successfully", new Object[0]);
            }
        }
    }

    private void a(AssetManager assetManager, Method method, String str) throws IllegalAccessException, w, InvocationTargetException {
        Method methodA = a("destroy", new Class[0]);
        Method methodA2 = a("getStringBlockCount", new Class[0]);
        Method methodA3 = a("getCookieName", Integer.TYPE);
        Field fieldA = a("mStringBlocks");
        ArrayList<String> arrayList = new ArrayList();
        int iIntValue = ((Integer) methodA2.invoke(assetManager, null)).intValue();
        int i10 = 0;
        while (i10 < iIntValue) {
            i10++;
            String str2 = (String) methodA3.invoke(assetManager, Integer.valueOf(i10));
            if (!str2.equals(str)) {
                arrayList.add(str2);
            }
        }
        methodA.invoke(assetManager, null);
        fieldA.set(assetManager, null);
        try {
            a("init", new Class[0]).invoke(assetManager, null);
        } catch (Exception unused) {
            a("init", Boolean.TYPE).invoke(assetManager, Boolean.FALSE);
        }
        for (String str3 : arrayList) {
            s.d("ResourceManager", "add asset " + str3, new Object[0]);
            method.invoke(assetManager, str3);
        }
    }

    private Method a(String str, Class<?>... clsArr) throws w {
        try {
            return e0.a(this.f8444a, str, clsArr);
        } catch (NoSuchMethodException e10) {
            throw new w(84, e10);
        }
    }

    private Field a(String str) throws w {
        try {
            return e0.a(this.f8444a, str);
        } catch (Exception e10) {
            throw new w(85, e10);
        }
    }
}
