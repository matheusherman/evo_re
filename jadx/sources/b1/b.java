package b1;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f632g = new b(-1, ViewCompat.MEASURED_STATE_MASK, 0, 0, -1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Typeface f638f;

    @RequiresApi(19)
    public static b a(CaptioningManager.CaptionStyle captionStyle) {
        return d1.k.f9577a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    @RequiresApi(19)
    private static b b(CaptioningManager.CaptionStyle captionStyle) {
        return new b(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    @RequiresApi(21)
    private static b c(CaptioningManager.CaptionStyle captionStyle) {
        return new b(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f632g.f633a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f632g.f634b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f632g.f635c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f632g.f636d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f632g.f637e, captionStyle.getTypeface());
    }

    public b(int i10, int i11, int i12, int i13, int i14, @Nullable Typeface typeface) {
        this.f633a = i10;
        this.f634b = i11;
        this.f635c = i12;
        this.f636d = i13;
        this.f637e = i14;
        this.f638f = typeface;
    }
}
