package m1;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f15501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f15502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f15503c = 0;

    static {
        Uri uri = Uri.parse("https://plus.google.com/");
        f15501a = uri;
        f15502b = uri.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
