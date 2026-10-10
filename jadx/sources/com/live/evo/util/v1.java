package com.live.evo.util;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.FileProvider;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q6.b f7372a = q6.c.d(v1.class);

    public static void a(Context context, String str) {
        File file = new File(str);
        Intent intent = new Intent();
        intent.setFlags(268435457);
        intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file), "application/vnd.android.package-archive");
        intent.setAction("android.intent.action.VIEW");
        context.startActivity(intent);
    }
}
