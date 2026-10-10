package s4;

import android.text.TextUtils;
import com.pengrad.telegrambot.model.request.InlineQueryResultVideo;
import com.pengrad.telegrambot.request.ContentTypes;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l implements p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static Hashtable<String, String> f18311c = new Hashtable<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static Hashtable<String, p4.b<Manifest>> f18312d = new Hashtable<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList<c> f18313a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f18314b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    abstract class a extends s4.d {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Matcher f18315o;

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements n, p {
        b() {
        }

        @Override // s4.p
        public d b(String str, String str2) {
            return l.this.b(str, str2);
        }

        @Override // s4.n
        public void a(s4.c cVar, e eVar) {
            d dVarB = b(cVar.m(), cVar.getPath());
            if (dVarB == null) {
                eVar.r(404);
                eVar.end();
            } else {
                dVarB.f18324d.a(cVar, eVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f18318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Pattern f18319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        n f18320c;

        private c() {
        }

        /* synthetic */ c(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Matcher f18323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final n f18324d;

        /* synthetic */ d(String str, String str2, Matcher matcher, n nVar, s4.a aVar, k kVar) {
            this(str, str2, matcher, nVar, aVar);
        }

        private d(String str, String str2, Matcher matcher, n nVar, s4.a aVar) {
            this.f18321a = str;
            this.f18322b = str2;
            this.f18323c = matcher;
            this.f18324d = nVar;
        }
    }

    public void a(String str, String str2, n nVar) {
        c(str, str2, nVar, null);
    }

    @Override // s4.p
    public d b(String str, String str2) {
        synchronized (this.f18313a) {
            try {
                for (c cVar : this.f18313a) {
                    if (TextUtils.equals(str, cVar.f18318a) || cVar.f18318a == null) {
                        Matcher matcher = cVar.f18319b.matcher(str2);
                        if (matcher.matches()) {
                            n nVar = cVar.f18320c;
                            if (!(nVar instanceof p)) {
                                return new d(str, str2, matcher, nVar, null, null);
                            }
                            return ((p) cVar.f18320c).b(str, matcher.group(1));
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(String str, String str2, n nVar, s4.a aVar) {
        c cVar = new c(null);
        cVar.f18319b = Pattern.compile("^" + str2);
        cVar.f18320c = nVar;
        cVar.f18318a = str;
        synchronized (this.f18313a) {
            this.f18313a.add(cVar);
        }
    }

    public void d(String str, n nVar) {
        a(IMediaPlayer.DRM_REQ_GET, str, nVar);
    }

    public void e(String str, n nVar) {
        a(IMediaPlayer.DRM_REQ_POST, str, nVar);
    }

    public l() {
        f18311c.put("js", "application/javascript");
        f18311c.put("json", "application/json");
        f18311c.put("png", "image/png");
        f18311c.put("jpg", ContentTypes.PHOTO_MIME_TYPE);
        f18311c.put("jpeg", ContentTypes.PHOTO_MIME_TYPE);
        f18311c.put("html", InlineQueryResultVideo.MIME_TEXT_HTML);
        f18311c.put("css", "text/css");
        f18311c.put("mp4", "video/mp4");
        f18311c.put("mov", "video/quicktime");
        f18311c.put("wmv", "video/x-ms-wmv");
        f18311c.put("txt", ContentTypes.DOC_MIME_TYPE);
        this.f18314b = new b();
    }
}
