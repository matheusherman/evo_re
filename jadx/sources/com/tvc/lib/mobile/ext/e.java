package com.tvc.lib.mobile.ext;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "Ljava/io/File;", "b", "(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;", "", "a", "(Landroid/content/Context;)Z", "tvclib_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class e {
    public static final boolean a(Context context) {
        if (context == null) {
            return true;
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            return activity.isFinishing() || activity.isDestroyed();
        }
        if (!(context instanceof FragmentActivity)) {
            return false;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        return fragmentActivity.isFinishing() || fragmentActivity.isDestroyed();
    }

    public static final File b(Context context, String url) {
        m.f(context, "<this>");
        m.f(url, "url");
        if (a(context)) {
            return null;
        }
        try {
            a0.d<File> dVarM0 = com.bumptech.glide.c.t(context).m().J0(url).M0();
            m.e(dVarM0, "submit(...)");
            return dVarM0.get();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
