package com.taobao.sophix;

import com.taobao.sophix.listener.PatchLoadStatusListener;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g {
    public boolean a(File file, boolean z10, PatchLoadStatusListener patchLoadStatusListener, b0 b0Var) {
        o bVar;
        s.a("DexManager", "patch", "supportHotfix", Boolean.valueOf(z10));
        if (z10) {
            bVar = new m();
        } else {
            bVar = new b(patchLoadStatusListener, b0Var);
        }
        h0.b(j.f8458b, "happ_ishotfix", z10);
        return bVar.a(file);
    }
}
