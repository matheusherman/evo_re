package yf;

import android.graphics.Color;
import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;
import xf.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J?\u0010\r\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0016\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lyf/a;", "Lxf/b;", "", "<init>", "()V", "", "path", "Lkotlin/Function0;", "Lr8/z;", "onSuccess", "Lkotlin/Function1;", "", "onError", "b", "(Ljava/lang/String;Lc9/a;Lc9/l;)V", "destroy", "Lxf/a;", "mediaPlayer", "a", "(Lxf/a;)V", "", "text", "c", "(Ljava/lang/CharSequence;)V", "Ljava/lang/String;", "EMPTY_TEXT", "", "F", "mStrokeWidth", "", "I", "mStrokeColor", "d", "Lxf/b;", "mSubtitleEngine", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String EMPTY_TEXT = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float mStrokeWidth = 3.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mStrokeColor = Color.parseColor("#000000");

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b mSubtitleEngine;

    public abstract void c(CharSequence text);

    @Override // xf.b
    public void a(xf.a mediaPlayer) {
        b bVar = this.mSubtitleEngine;
        if (bVar != null) {
            bVar.a(mediaPlayer);
        }
    }

    @Override // xf.b
    public void b(String path, c9.a<z> onSuccess, l<? super Throwable, z> onError) {
        m.f(onSuccess, "onSuccess");
        b bVar = this.mSubtitleEngine;
        if (bVar != null) {
            bVar.b(path, onSuccess, onError);
        }
    }

    @Override // xf.b
    public void destroy() {
        b bVar = this.mSubtitleEngine;
        if (bVar != null) {
            bVar.destroy();
        }
    }
}
