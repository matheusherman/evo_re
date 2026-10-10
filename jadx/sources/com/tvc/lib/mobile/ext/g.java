package com.tvc.lib.mobile.ext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import com.tvc.lib.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import s.f0;
import s.x;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\n\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/appcompat/widget/AppCompatImageView;", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "", "placeholder", "radius", "Lr8/z;", "e", "(Landroidx/appcompat/widget/AppCompatImageView;Ljava/lang/String;II)V", "icon", "d", "(Landroidx/appcompat/widget/AppCompatImageView;III)V", "Lcom/bumptech/glide/l;", "a", "(Landroidx/appcompat/widget/AppCompatImageView;)Lcom/bumptech/glide/l;", "La0/i;", "c", "(II)La0/i;", "b", "(I)La0/i;", "tvclib_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class g {
    private static final a0.i b(int i10) {
        a0.i iVar = new a0.i();
        if (i10 > 0) {
            iVar.b0(i10);
            iVar.i(i10);
        }
        iVar.g(l.j.f15048a);
        iVar.k0(false);
        return iVar;
    }

    public static final void d(AppCompatImageView appCompatImageView, int i10, int i11, int i12) {
        com.bumptech.glide.k<Drawable> kVarT;
        com.bumptech.glide.k<Drawable> kVarA;
        m.f(appCompatImageView, "<this>");
        com.bumptech.glide.l lVarA = a(appCompatImageView);
        if (lVarA == null || (kVarT = lVarA.t(Integer.valueOf(i10))) == null || (kVarA = kVarT.a(c(i12, i11))) == null) {
            return;
        }
        kVarA.E0(appCompatImageView);
    }

    public static final void e(AppCompatImageView appCompatImageView, String url, int i10, int i11) {
        com.bumptech.glide.k<Drawable> kVarU;
        com.bumptech.glide.k<Drawable> kVarA;
        m.f(appCompatImageView, "<this>");
        m.f(url, "url");
        com.bumptech.glide.l lVarA = a(appCompatImageView);
        if (lVarA == null || (kVarU = lVarA.u(url)) == null || (kVarA = kVarU.a(c(i11, i10))) == null) {
            return;
        }
        kVarA.E0(appCompatImageView);
    }

    public static /* synthetic */ void f(AppCompatImageView appCompatImageView, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = R$drawable.brand_logo;
        }
        if ((i13 & 4) != 0) {
            i12 = 4;
        }
        d(appCompatImageView, i10, i11, i12);
    }

    public static /* synthetic */ void g(AppCompatImageView appCompatImageView, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = R$drawable.brand_logo;
        }
        if ((i12 & 4) != 0) {
            i11 = 4;
        }
        e(appCompatImageView, str, i10, i11);
    }

    private static final com.bumptech.glide.l a(AppCompatImageView appCompatImageView) {
        Context context = appCompatImageView.getContext();
        if (context instanceof AppCompatActivity) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) context;
            if (appCompatActivity.isFinishing() || appCompatActivity.isDestroyed()) {
                return null;
            }
        }
        return com.bumptech.glide.c.t(context);
    }

    private static final a0.i c(int i10, int i11) {
        a0.i iVarM0 = b(i11).m0(new j.g(new x(), new f0(i10)));
        m.e(iVarM0, "transform(...)");
        return iVarM0;
    }
}
