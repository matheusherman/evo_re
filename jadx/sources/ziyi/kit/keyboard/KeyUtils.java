package ziyi.kit.keyboard;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import androidx.p000lifecycle.Lifecycle;
import androidx.p000lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;
import org.apache.log4j.spi.LocationInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class KeyUtils {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f23286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ziyi.kit.keyboard.b f23287i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f23288j;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static HashMap<Integer, ziyi.kit.keyboard.b> f23297s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static HashMap<Integer, Integer> f23298t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static HashMap<Integer, c> f23299u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static HashMap<Integer, ViewTreeObserver.OnGlobalLayoutListener> f23300v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static HashMap<Integer, Lifecycle> f23301w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static HashMap<Integer, MyLifecycleObserver> f23302x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static HashMap<Integer, Window> f23303y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f23279a = R$drawable.key_keyboard_background_shape;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f23280b = R$drawable.key_normal_focus;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f23281c = R$drawable.key_normal_unfocus;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f23282d = R$color.keyTextColor;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f23283e = R$color.keyNextColor;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f23284f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f23285g = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static SparseArray<ziyi.kit.keyboard.a> f23289k = new SparseArray<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static List<List<ziyi.kit.keyboard.a>> f23290l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static List<List<ziyi.kit.keyboard.a>> f23291m = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static List<List<ziyi.kit.keyboard.a>> f23292n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static List<List<ziyi.kit.keyboard.a>> f23293o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static List<List<ziyi.kit.keyboard.a>> f23294p = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static List<List<ziyi.kit.keyboard.a>> f23295q = new ArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static List<List<ziyi.kit.keyboard.a>> f23296r = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends ziyi.kit.keyboard.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Window f23304c;

        a(Window window) {
            this.f23304c = window;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z10;
            ziyi.kit.keyboard.b bVar = (ziyi.kit.keyboard.b) KeyUtils.f23297s.get(Integer.valueOf(a()));
            if (bVar != null && bVar.getVisibility() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            KeyUtils.f23286h = this.f23304c.getDecorView().getHeight();
            boolean z11 = this.f23400b;
            if ((z11 && !z10) || (!z11 && z10)) {
                this.f23400b = z10;
                ((c) KeyUtils.f23299u.get(Integer.valueOf(a()))).a(KeyUtils.f23286h, this.f23400b, a());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface c {
        void a(int i10, boolean z10, int i11);
    }

    static {
        C(new ziyi.kit.keyboard.a(0, "0"));
        C(new ziyi.kit.keyboard.a(1, (CharSequence) "1", true));
        C(new ziyi.kit.keyboard.a(2, ExifInterface.GPS_MEASUREMENT_2D));
        C(new ziyi.kit.keyboard.a(3, ExifInterface.GPS_MEASUREMENT_3D));
        C(new ziyi.kit.keyboard.a(4, "4"));
        C(new ziyi.kit.keyboard.a(5, "5"));
        C(new ziyi.kit.keyboard.a(6, "6"));
        C(new ziyi.kit.keyboard.a(7, "7"));
        C(new ziyi.kit.keyboard.a(8, "8"));
        C(new ziyi.kit.keyboard.a(9, "9"));
        C(new ziyi.kit.keyboard.a(16, "a"));
        C(new ziyi.kit.keyboard.a(17, "b"));
        C(new ziyi.kit.keyboard.a(18, "c"));
        C(new ziyi.kit.keyboard.a(19, "d"));
        C(new ziyi.kit.keyboard.a(20, "e"));
        C(new ziyi.kit.keyboard.a(21, "f"));
        C(new ziyi.kit.keyboard.a(22, "g"));
        C(new ziyi.kit.keyboard.a(23, "h"));
        C(new ziyi.kit.keyboard.a(24, "i"));
        C(new ziyi.kit.keyboard.a(25, "j"));
        C(new ziyi.kit.keyboard.a(32, "k"));
        C(new ziyi.kit.keyboard.a(33, "l"));
        C(new ziyi.kit.keyboard.a(34, "m"));
        C(new ziyi.kit.keyboard.a(35, "n"));
        C(new ziyi.kit.keyboard.a(36, "o"));
        C(new ziyi.kit.keyboard.a(37, "p"));
        C(new ziyi.kit.keyboard.a(38, "q"));
        C(new ziyi.kit.keyboard.a(39, "r"));
        C(new ziyi.kit.keyboard.a(40, "s"));
        C(new ziyi.kit.keyboard.a(41, (CharSequence) "t", true));
        C(new ziyi.kit.keyboard.a(48, "u"));
        C(new ziyi.kit.keyboard.a(49, "v"));
        C(new ziyi.kit.keyboard.a(50, "w"));
        C(new ziyi.kit.keyboard.a(51, "x"));
        C(new ziyi.kit.keyboard.a(52, "y"));
        C(new ziyi.kit.keyboard.a(53, "z"));
        C(new ziyi.kit.keyboard.a(64, "!"));
        C(new ziyi.kit.keyboard.a(65, (CharSequence) "@", true));
        C(new ziyi.kit.keyboard.a(66, "#"));
        C(new ziyi.kit.keyboard.a(67, "$"));
        C(new ziyi.kit.keyboard.a(68, "%"));
        C(new ziyi.kit.keyboard.a(69, "^"));
        C(new ziyi.kit.keyboard.a(70, "&"));
        C(new ziyi.kit.keyboard.a(71, "*"));
        C(new ziyi.kit.keyboard.a(72, "(\u3000)", "()"));
        C(new ziyi.kit.keyboard.a(73, "[\u3000]", "[]"));
        C(new ziyi.kit.keyboard.a(80, "{\u3000}", "{}"));
        C(new ziyi.kit.keyboard.a(81, "<\u3000>", "<>"));
        C(new ziyi.kit.keyboard.a(82, "\"", "\"\""));
        C(new ziyi.kit.keyboard.a(83, "'", "''"));
        C(new ziyi.kit.keyboard.a(84, "|"));
        C(new ziyi.kit.keyboard.a(85, "\\"));
        C(new ziyi.kit.keyboard.a(86, LocationInfo.NA));
        C(new ziyi.kit.keyboard.a(87, "/"));
        C(new ziyi.kit.keyboard.a(88, ":"));
        C(new ziyi.kit.keyboard.a(89, ";"));
        C(new ziyi.kit.keyboard.a(96, ","));
        C(new ziyi.kit.keyboard.a(97, "•", "."));
        C(new ziyi.kit.keyboard.a(98, ","));
        C(new ziyi.kit.keyboard.a(99, "`", "``"));
        C(new ziyi.kit.keyboard.a(100, "~"));
        C(new ziyi.kit.keyboard.a(101, "+"));
        C(new ziyi.kit.keyboard.a(102, "="));
        C(new ziyi.kit.keyboard.a(103, "-"));
        C(new ziyi.kit.keyboard.a(104, "_"));
        C(new ziyi.kit.keyboard.a(112, "Space", "\u2000"));
        C(new ziyi.kit.keyboard.a(146, "ABC"));
        C(new ziyi.kit.keyboard.a(145, "@", "@"));
        C(new ziyi.kit.keyboard.a(144, "Close", "", R$drawable.key_icon_close));
        C(new ziyi.kit.keyboard.a(147, "Delete", "", R$drawable.key_icon_del));
        C(new ziyi.kit.keyboard.a(148, "Next", ""));
        C(new ziyi.kit.keyboard.a(149, "123?", ""));
        C(new ziyi.kit.keyboard.a(150, "Aa", "", R$drawable.key_icon_lower_case));
        C(new ziyi.kit.keyboard.a(151, "Show", ""));
        C(new ziyi.kit.keyboard.a(SyslogAppender.LOG_LOCAL3, "Enter", "\r"));
        C(new ziyi.kit.keyboard.a(153, "Sym", ""));
        C(new ziyi.kit.keyboard.a(256, "Back", ""));
        f23297s = new HashMap<>();
        f23298t = new HashMap<>();
        f23299u = new HashMap<>();
        f23300v = new HashMap<>();
        f23301w = new HashMap<>();
        f23302x = new HashMap<>();
        f23303y = new HashMap<>();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements c {
        b() {
        }

        @Override // ziyi.kit.keyboard.KeyUtils.c
        public void a(int i10, boolean z10, int i11) {
            ziyi.kit.keyboard.b bVar = (ziyi.kit.keyboard.b) KeyUtils.f23297s.get(Integer.valueOf(i11));
            if (bVar != null && bVar.getFocusedEditText() != null) {
                if (z10) {
                    bVar.h0(i10);
                } else {
                    bVar.Y();
                }
            }
        }
    }

    private static void B(Lifecycle lifecycle, int i10) {
        if (f23301w.containsKey(Integer.valueOf(i10)) || f23302x.containsKey(Integer.valueOf(i10))) {
            return;
        }
        MyLifecycleObserver myLifecycleObserver = new MyLifecycleObserver() { // from class: ziyi.kit.keyboard.KeyUtils.1
            @Override // ziyi.kit.keyboard.MyLifecycleObserver, androidx.p000lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                ziyi.kit.keyboard.b bVar = (ziyi.kit.keyboard.b) KeyUtils.f23297s.get(Integer.valueOf(a()));
                if (bVar != null) {
                    bVar.S();
                }
                KeyUtils.D(a());
                KeyUtils.F(a());
                KeyUtils.f23303y.remove(Integer.valueOf(a()));
                KeyUtils.f23297s.remove(Integer.valueOf(a()));
                KeyUtils.E(a());
            }

            @Override // ziyi.kit.keyboard.MyLifecycleObserver, androidx.p000lifecycle.DefaultLifecycleObserver
            public void onPause(@NonNull LifecycleOwner lifecycleOwner) {
                ziyi.kit.keyboard.b bVar = (ziyi.kit.keyboard.b) KeyUtils.f23297s.get(Integer.valueOf(a()));
                if (bVar != null) {
                    if (!KeyUtils.f23288j) {
                        KeyUtils.f23298t.put(Integer.valueOf(a()), Integer.valueOf(bVar.getVisibility()));
                    }
                    bVar.T();
                }
            }

            @Override // ziyi.kit.keyboard.MyLifecycleObserver, androidx.p000lifecycle.DefaultLifecycleObserver
            public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
                ziyi.kit.keyboard.b bVar;
                Window window;
                if ((KeyUtils.f23288j || (KeyUtils.f23298t.containsKey(Integer.valueOf(a())) && ((Integer) KeyUtils.f23298t.get(Integer.valueOf(a()))).intValue() == 0)) && (bVar = (ziyi.kit.keyboard.b) KeyUtils.f23297s.get(Integer.valueOf(a()))) != null) {
                    if (bVar.getParent() == null && (window = (Window) KeyUtils.f23303y.get(Integer.valueOf(a()))) != null) {
                        KeyUtils.v(window, bVar, 81);
                    }
                    bVar.U();
                    ziyi.kit.keyboard.b unused = KeyUtils.f23287i = bVar;
                }
            }
        };
        myLifecycleObserver.b(i10);
        lifecycle.addObserver(myLifecycleObserver);
        f23302x.put(Integer.valueOf(i10), myLifecycleObserver);
        f23301w.put(Integer.valueOf(i10), lifecycle);
    }

    private static void C(@NonNull ziyi.kit.keyboard.a aVar) {
        f23289k.put(aVar.c(), aVar);
    }

    public static void D(int i10) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = f23300v.get(Integer.valueOf(i10));
        Window window = f23303y.get(Integer.valueOf(i10));
        if (onGlobalLayoutListener == null || window == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(int i10) {
        Lifecycle lifecycle = f23301w.get(Integer.valueOf(i10));
        MyLifecycleObserver myLifecycleObserver = f23302x.get(Integer.valueOf(i10));
        if (lifecycle == null || myLifecycleObserver == null) {
            return;
        }
        lifecycle.removeObserver(myLifecycleObserver);
        f23301w.remove(Integer.valueOf(i10));
        f23302x.remove(Integer.valueOf(i10));
    }

    public static void F(int i10) {
        HashMap<Integer, c> map = f23299u;
        if (map != null) {
            map.remove(Integer.valueOf(i10));
        }
    }

    public static void G(int i10) {
        f23279a = i10;
    }

    public static void H(String str) {
        f23284f = str;
    }

    public static void I(String str) {
        f23285g = str;
    }

    public static void J(int i10) {
        f23280b = i10;
    }

    public static void K(int i10) {
        f23282d = i10;
        f23283e = i10;
    }

    public static void L(int i10) {
        f23281c = i10;
    }

    public static void M(int i10, float f10) {
        f23289k.get(i10).h(f10);
    }

    public static void h(Window window, int i10) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerL;
        if (f23300v.containsKey(Integer.valueOf(i10)) || (onGlobalLayoutListenerL = l(window, i10)) == null || window == null) {
            return;
        }
        window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListenerL);
        f23300v.put(Integer.valueOf(i10), onGlobalLayoutListenerL);
    }

    public static void i(int i10) {
        if (f23299u.containsKey(Integer.valueOf(i10))) {
            return;
        }
        f23299u.put(Integer.valueOf(i10), new b());
    }

    public static synchronized Boolean j() {
        ziyi.kit.keyboard.b bVar;
        try {
            bVar = f23287i;
        } catch (Throwable th) {
            throw th;
        }
        return Boolean.valueOf(bVar != null ? bVar.q().booleanValue() : false);
    }

    public static ziyi.kit.keyboard.b k() {
        return f23287i;
    }

    public static ViewTreeObserver.OnGlobalLayoutListener l(Window window, int i10) {
        a aVar = new a(window);
        aVar.b(i10);
        return aVar;
    }

    public static List<List<ziyi.kit.keyboard.a>> m() {
        if (f23292n.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f23289k.get(38));
            arrayList.add(f23289k.get(50));
            arrayList.add(f23289k.get(20));
            arrayList.add(f23289k.get(39));
            arrayList.add(f23289k.get(41));
            arrayList.add(f23289k.get(52));
            arrayList.add(f23289k.get(48));
            arrayList.add(f23289k.get(24));
            arrayList.add(f23289k.get(36));
            arrayList.add(f23289k.get(37));
            arrayList.add(f23289k.get(144));
            f23292n.add(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(f23289k.get(16));
            arrayList2.add(f23289k.get(40));
            arrayList2.add(f23289k.get(19));
            arrayList2.add(f23289k.get(21));
            arrayList2.add(f23289k.get(22));
            arrayList2.add(f23289k.get(23));
            arrayList2.add(f23289k.get(25));
            arrayList2.add(f23289k.get(32));
            arrayList2.add(f23289k.get(33));
            arrayList2.add(f23289k.get(151));
            f23292n.add(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(f23289k.get(103));
            arrayList3.add(f23289k.get(53));
            arrayList3.add(f23289k.get(51));
            arrayList3.add(f23289k.get(18));
            arrayList3.add(f23289k.get(49));
            arrayList3.add(f23289k.get(17));
            arrayList3.add(f23289k.get(35));
            arrayList3.add(f23289k.get(34));
            arrayList3.add(f23289k.get(97));
            arrayList3.add(f23289k.get(147));
            f23292n.add(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(f23289k.get(150));
            arrayList4.add(f23289k.get(149));
            arrayList4.add(f23289k.get(153));
            arrayList4.add(f23289k.get(112));
            arrayList4.add(f23289k.get(148));
            f23292n.add(arrayList4);
        }
        M(72, 1.0f);
        M(73, 1.0f);
        M(80, 1.0f);
        M(81, 1.0f);
        M(97, 1.0f);
        M(16, 1.25f);
        M(103, 1.25f);
        M(112, 5.0f);
        M(151, 1.75f);
        M(150, 1.75f);
        M(147, 1.75f);
        M(148, 2.25f);
        return f23292n;
    }

    public static List<List<ziyi.kit.keyboard.a>> n() {
        if (f23293o.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f23289k.get(1));
            arrayList.add(f23289k.get(2));
            arrayList.add(f23289k.get(3));
            arrayList.add(f23289k.get(4));
            arrayList.add(f23289k.get(5));
            arrayList.add(f23289k.get(6));
            arrayList.add(f23289k.get(7));
            arrayList.add(f23289k.get(8));
            arrayList.add(f23289k.get(9));
            arrayList.add(f23289k.get(0));
            arrayList.add(f23289k.get(144));
            f23293o.add(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(f23289k.get(38));
            arrayList2.add(f23289k.get(50));
            arrayList2.add(f23289k.get(20));
            arrayList2.add(f23289k.get(39));
            arrayList2.add(f23289k.get(41));
            arrayList2.add(f23289k.get(52));
            arrayList2.add(f23289k.get(48));
            arrayList2.add(f23289k.get(24));
            arrayList2.add(f23289k.get(36));
            arrayList2.add(f23289k.get(37));
            arrayList2.add(f23289k.get(145));
            f23293o.add(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(f23289k.get(16));
            arrayList3.add(f23289k.get(40));
            arrayList3.add(f23289k.get(19));
            arrayList3.add(f23289k.get(21));
            arrayList3.add(f23289k.get(22));
            arrayList3.add(f23289k.get(23));
            arrayList3.add(f23289k.get(25));
            arrayList3.add(f23289k.get(32));
            arrayList3.add(f23289k.get(33));
            arrayList3.add(f23289k.get(151));
            f23293o.add(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(f23289k.get(103));
            arrayList4.add(f23289k.get(53));
            arrayList4.add(f23289k.get(51));
            arrayList4.add(f23289k.get(18));
            arrayList4.add(f23289k.get(49));
            arrayList4.add(f23289k.get(17));
            arrayList4.add(f23289k.get(35));
            arrayList4.add(f23289k.get(34));
            arrayList4.add(f23289k.get(97));
            arrayList4.add(f23289k.get(147));
            f23293o.add(arrayList4);
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add(f23289k.get(150));
            arrayList5.add(f23289k.get(149));
            arrayList5.add(f23289k.get(153));
            arrayList5.add(f23289k.get(112));
            arrayList5.add(f23289k.get(148));
            f23293o.add(arrayList5);
        }
        M(72, 1.0f);
        M(73, 1.0f);
        M(80, 1.0f);
        M(81, 1.0f);
        M(97, 1.0f);
        M(103, 1.25f);
        M(112, 5.0f);
        M(151, 1.75f);
        M(150, 1.75f);
        M(16, 1.25f);
        M(147, 1.75f);
        M(148, 2.25f);
        return f23293o;
    }

    public static List<List<ziyi.kit.keyboard.a>> o() {
        if (f23290l.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f23289k.get(1));
            arrayList.add(f23289k.get(2));
            arrayList.add(f23289k.get(3));
            arrayList.add(f23289k.get(144));
            f23290l.add(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(f23289k.get(4));
            arrayList2.add(f23289k.get(5));
            arrayList2.add(f23289k.get(6));
            arrayList2.add(f23289k.get(103));
            f23290l.add(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(f23289k.get(7));
            arrayList3.add(f23289k.get(8));
            arrayList3.add(f23289k.get(9));
            arrayList3.add(f23289k.get(147));
            f23290l.add(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(f23289k.get(97));
            arrayList4.add(f23289k.get(0));
            arrayList4.add(f23289k.get(148));
            f23290l.add(arrayList4);
        }
        M(72, 1.0f);
        M(73, 1.0f);
        M(80, 1.0f);
        M(81, 1.0f);
        M(97, 1.0f);
        M(103, 1.0f);
        M(112, 1.0f);
        M(151, 1.0f);
        M(150, 1.0f);
        M(147, 1.0f);
        M(148, 2.0f);
        return f23290l;
    }

    public static List<List<ziyi.kit.keyboard.a>> p() {
        if (f23291m.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f23289k.get(1));
            arrayList.add(f23289k.get(2));
            arrayList.add(f23289k.get(3));
            arrayList.add(f23289k.get(144));
            f23291m.add(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(f23289k.get(4));
            arrayList2.add(f23289k.get(5));
            arrayList2.add(f23289k.get(6));
            arrayList2.add(f23289k.get(103));
            f23291m.add(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(f23289k.get(7));
            arrayList3.add(f23289k.get(8));
            arrayList3.add(f23289k.get(9));
            arrayList3.add(f23289k.get(147));
            f23291m.add(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(f23289k.get(146));
            arrayList4.add(f23289k.get(0));
            arrayList4.add(f23289k.get(97));
            arrayList4.add(f23289k.get(148));
            f23291m.add(arrayList4);
        }
        M(72, 1.0f);
        M(73, 1.0f);
        M(80, 1.0f);
        M(81, 1.0f);
        M(97, 1.0f);
        M(103, 1.0f);
        M(112, 1.0f);
        M(151, 1.0f);
        M(150, 1.0f);
        M(147, 1.0f);
        M(148, 1.0f);
        return f23291m;
    }

    public static List<List<ziyi.kit.keyboard.a>> q() {
        if (f23295q.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f23289k.get(38));
            arrayList.add(f23289k.get(50));
            arrayList.add(f23289k.get(20));
            arrayList.add(f23289k.get(39));
            arrayList.add(f23289k.get(41));
            arrayList.add(f23289k.get(144));
            f23295q.add(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(f23289k.get(52));
            arrayList2.add(f23289k.get(48));
            arrayList2.add(f23289k.get(24));
            arrayList2.add(f23289k.get(36));
            arrayList2.add(f23289k.get(37));
            arrayList2.add(f23289k.get(16));
            f23295q.add(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(f23289k.get(40));
            arrayList3.add(f23289k.get(19));
            arrayList3.add(f23289k.get(21));
            arrayList3.add(f23289k.get(22));
            arrayList3.add(f23289k.get(23));
            arrayList3.add(f23289k.get(25));
            f23295q.add(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(f23289k.get(32));
            arrayList4.add(f23289k.get(33));
            arrayList4.add(f23289k.get(53));
            arrayList4.add(f23289k.get(51));
            arrayList4.add(f23289k.get(18));
            arrayList4.add(f23289k.get(49));
            f23295q.add(arrayList4);
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add(f23289k.get(17));
            arrayList5.add(f23289k.get(35));
            arrayList5.add(f23289k.get(34));
            arrayList5.add(f23289k.get(103));
            arrayList5.add(f23289k.get(97));
            arrayList5.add(f23289k.get(147));
            f23295q.add(arrayList5);
            ArrayList arrayList6 = new ArrayList();
            arrayList6.add(f23289k.get(150));
            arrayList6.add(f23289k.get(149));
            arrayList6.add(f23289k.get(153));
            arrayList6.add(f23289k.get(112));
            arrayList6.add(f23289k.get(148));
            f23295q.add(arrayList6);
        }
        M(72, 1.0f);
        M(73, 1.0f);
        M(80, 1.0f);
        M(81, 1.0f);
        M(97, 0.75f);
        M(103, 0.75f);
        M(112, 1.5f);
        M(151, 1.0f);
        M(150, 1.0f);
        M(147, 1.5f);
        M(148, 1.5f);
        return f23295q;
    }

    public static List<List<ziyi.kit.keyboard.a>> r() {
        if (f23296r.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f23289k.get(64));
            arrayList.add(f23289k.get(65));
            arrayList.add(f23289k.get(66));
            arrayList.add(f23289k.get(67));
            arrayList.add(f23289k.get(68));
            arrayList.add(f23289k.get(144));
            f23296r.add(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(f23289k.get(69));
            arrayList2.add(f23289k.get(70));
            arrayList2.add(f23289k.get(100));
            arrayList2.add(f23289k.get(99));
            arrayList2.add(f23289k.get(103));
            arrayList2.add(f23289k.get(104));
            f23296r.add(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(f23289k.get(84));
            arrayList3.add(f23289k.get(85));
            arrayList3.add(f23289k.get(87));
            arrayList3.add(f23289k.get(86));
            arrayList3.add(f23289k.get(88));
            arrayList3.add(f23289k.get(89));
            f23296r.add(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(f23289k.get(82));
            arrayList4.add(f23289k.get(83));
            arrayList4.add(f23289k.get(72));
            arrayList4.add(f23289k.get(73));
            arrayList4.add(f23289k.get(80));
            arrayList4.add(f23289k.get(81));
            f23296r.add(arrayList4);
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add(f23289k.get(256));
            arrayList5.add(f23289k.get(97));
            arrayList5.add(f23289k.get(98));
            arrayList5.add(f23289k.get(101));
            arrayList5.add(f23289k.get(102));
            arrayList5.add(f23289k.get(147));
            f23296r.add(arrayList5);
        }
        M(72, 1.0f);
        M(73, 1.0f);
        M(80, 1.0f);
        M(81, 1.0f);
        M(97, 1.0f);
        M(103, 1.0f);
        M(112, 1.0f);
        M(151, 1.0f);
        M(150, 1.0f);
        M(147, 1.0f);
        M(148, 1.0f);
        return f23296r;
    }

    public static List<List<ziyi.kit.keyboard.a>> s() {
        if (f23294p.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(f23289k.get(64));
            arrayList.add(f23289k.get(65));
            arrayList.add(f23289k.get(66));
            arrayList.add(f23289k.get(67));
            arrayList.add(f23289k.get(68));
            arrayList.add(f23289k.get(69));
            arrayList.add(f23289k.get(70));
            arrayList.add(f23289k.get(144));
            f23294p.add(arrayList);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(f23289k.get(82));
            arrayList2.add(f23289k.get(72));
            arrayList2.add(f23289k.get(73));
            arrayList2.add(f23289k.get(80));
            arrayList2.add(f23289k.get(81));
            arrayList2.add(f23289k.get(83));
            f23294p.add(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(f23289k.get(84));
            arrayList3.add(f23289k.get(85));
            arrayList3.add(f23289k.get(87));
            arrayList3.add(f23289k.get(86));
            arrayList3.add(f23289k.get(88));
            arrayList3.add(f23289k.get(89));
            arrayList3.add(f23289k.get(104));
            arrayList3.add(f23289k.get(99));
            f23294p.add(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(f23289k.get(256));
            arrayList4.add(f23289k.get(97));
            arrayList4.add(f23289k.get(98));
            arrayList4.add(f23289k.get(100));
            arrayList4.add(f23289k.get(101));
            arrayList4.add(f23289k.get(102));
            arrayList4.add(f23289k.get(103));
            arrayList4.add(f23289k.get(147));
            f23294p.add(arrayList4);
        }
        M(72, 1.5f);
        M(73, 1.5f);
        M(80, 1.5f);
        M(81, 1.5f);
        M(97, 1.0f);
        M(103, 1.0f);
        M(112, 1.0f);
        M(151, 1.0f);
        M(150, 1.0f);
        M(147, 1.0f);
        M(148, 1.0f);
        return f23294p;
    }

    public static ziyi.kit.keyboard.b t(Window window, Context context, View view, Lifecycle lifecycle, boolean z10) {
        ziyi.kit.keyboard.b bVar = null;
        if (!f23284f.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) && (!f23284f.equals("C") || !f23285g.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS))) {
            if (window != null && view != null) {
                bVar = new ziyi.kit.keyboard.b(context, view, false);
                window.setSoftInputMode(3);
                window.addFlags(131072);
                h(window, view.getId());
                i(view.getId());
                f23303y.put(Integer.valueOf(view.getId()), window);
                f23297s.put(Integer.valueOf(view.getId()), bVar);
                v(window, bVar, 81);
                B(lifecycle, view.getId());
            }
            f23287i = bVar;
            f23288j = true;
        }
        return bVar;
    }

    public static ziyi.kit.keyboard.b u(Window window, Context context, View view, Lifecycle lifecycle, boolean z10, boolean z11) {
        ziyi.kit.keyboard.b bVar = null;
        if (!f23284f.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS) && (!f23284f.equals("C") || !f23285g.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS))) {
            if (window != null && view != null) {
                bVar = new ziyi.kit.keyboard.b(context, view, false);
                window.setSoftInputMode(3);
                h(window, view.getId());
                i(view.getId());
                f23303y.put(Integer.valueOf(view.getId()), window);
                f23297s.put(Integer.valueOf(view.getId()), bVar);
                v(window, bVar, 81);
                B(lifecycle, view.getId());
            }
            f23287i = bVar;
            f23288j = z11;
        }
        return bVar;
    }

    public static void v(Window window, @NonNull ViewGroup viewGroup, int i10) {
        if (window != null) {
            if (viewGroup.getParent() != null) {
                throw new IllegalStateException("Initialized already.");
            }
            View decorView = window.getDecorView();
            if (decorView instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = i10;
                ((FrameLayout) decorView).addView(viewGroup, 0, layoutParams);
                viewGroup.setVisibility(8);
            }
        }
    }

    public static boolean x(int i10) {
        return i10 >= 144 && i10 <= 256;
    }

    public static boolean y(int i10) {
        return i10 == 72 || i10 == 73 || i10 == 80 || i10 == 81 || i10 == 82 || i10 == 83 || i10 == 99;
    }

    public static boolean z(int i10) {
        return i10 >= 294 && i10 <= 295;
    }

    public static List<List<ziyi.kit.keyboard.a>> A(String str, boolean z10) {
        str.getClass();
        switch (str) {
            case "ninePalaceNumberWithABC":
                return p();
            case "ninePalaceNumber":
                return o();
            case "letter":
                if (z10) {
                    return q();
                }
                return m();
            case "symbol":
                if (z10) {
                    return r();
                }
                return s();
            case "letterNumber":
                if (z10) {
                    return q();
                }
                return n();
            default:
                return null;
        }
    }

    public static boolean w(int i10) {
        return !z(i10);
    }
}
