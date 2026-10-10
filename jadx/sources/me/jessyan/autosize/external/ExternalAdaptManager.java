package me.jessyan.autosize.external;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.jessyan.autosize.utils.Preconditions;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ExternalAdaptManager {
    private boolean isRun;
    private List<String> mCancelAdaptList;
    private Map<String, ExternalAdaptInfo> mExternalAdaptInfos;

    public synchronized ExternalAdaptManager addCancelAdaptOfActivity(Class<?> cls) {
        try {
            Preconditions.checkNotNull(cls, "targetClass == null");
            if (!this.isRun) {
                this.isRun = true;
            }
            if (this.mCancelAdaptList == null) {
                this.mCancelAdaptList = new ArrayList();
            }
            this.mCancelAdaptList.add(cls.getCanonicalName());
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized ExternalAdaptManager addExternalAdaptInfoOfActivity(Class<?> cls, ExternalAdaptInfo externalAdaptInfo) {
        try {
            Preconditions.checkNotNull(cls, "targetClass == null");
            if (!this.isRun) {
                this.isRun = true;
            }
            if (this.mExternalAdaptInfos == null) {
                this.mExternalAdaptInfos = new HashMap(16);
            }
            this.mExternalAdaptInfos.put(cls.getCanonicalName(), externalAdaptInfo);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized ExternalAdaptInfo getExternalAdaptInfoOfActivity(Class<?> cls) {
        Preconditions.checkNotNull(cls, "targetClass == null");
        Map<String, ExternalAdaptInfo> map = this.mExternalAdaptInfos;
        if (map == null) {
            return null;
        }
        return map.get(cls.getCanonicalName());
    }

    public synchronized boolean isCancelAdapt(Class<?> cls) {
        Preconditions.checkNotNull(cls, "targetClass == null");
        List<String> list = this.mCancelAdaptList;
        if (list == null) {
            return false;
        }
        return list.contains(cls.getCanonicalName());
    }

    public boolean isRun() {
        return this.isRun;
    }

    public ExternalAdaptManager setRun(boolean z10) {
        this.isRun = z10;
        return this;
    }
}
