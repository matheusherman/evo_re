package com.taobao.sophix;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f8457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Application f8458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static File f8459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static File f8460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static File f8461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f8462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static PatchLoadStatusListener f8463g;

    public static void a(int i10) {
        f8457a = i10;
        h0.b((Context) f8458b, "hpatch_version", f8457a);
        s.c("GlobalProperty", "addPatch", "update patch version", Integer.valueOf(f8457a));
    }
}
