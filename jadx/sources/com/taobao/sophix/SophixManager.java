package com.taobao.sophix;

import android.app.Application;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class SophixManager {
    public static final String VERSION = "3.4.1";

    public abstract void cleanPatches();

    public abstract Object getPatchStateInfo();

    public abstract void initialize();

    public abstract void killProcessSafely();

    public abstract void queryAndLoadNewPatch();

    public abstract SophixManager setAesKey(String str);

    public abstract SophixManager setAppVersion(String str);

    public abstract SophixManager setContext(Application application);

    public abstract SophixManager setEnableClassLoaderLog();

    public abstract SophixManager setEnableDebug(boolean z10);

    public abstract SophixManager setEnableFullLog();

    public abstract SophixManager setHost(String str, boolean z10);

    public abstract void setOatSdkVersion(int i10);

    public abstract SophixManager setPatchLoadStatusStub(PatchLoadStatusListener patchLoadStatusListener);

    public abstract SophixManager setPreLoadedClass(Class cls);

    public abstract SophixManager setProcessSpecialClass(Class cls);

    public abstract SophixManager setSecretMetaData(String str, String str2, String str3);

    public abstract SophixManager setTags(List<String> list);

    public abstract SophixManager setUnsupportedModel(String str, int i10);

    public abstract SophixManager setUsingEnhance();

    public abstract SophixManager setUsingEnhance(boolean z10);

    public static SophixManager getInstance() {
        return i0.f8446g;
    }
}
