package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f1874a = Pattern.compile("(&#13;)?&#10;");

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f1876b;

        /* synthetic */ b(String str, Map map, a aVar) {
            this(str, map);
        }

        private b(String str, Map<String, String> map) {
            this.f1875a = str;
            this.f1876b = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0040c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Comparator<C0040c> f1877e = new Comparator() { // from class: com.google.android.exoplayer2.ui.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.C0040c.a((c.C0040c) obj, (c.C0040c) obj2);
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Comparator<C0040c> f1878f = new Comparator() { // from class: com.google.android.exoplayer2.ui.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.C0040c.b((c.C0040c) obj, (c.C0040c) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f1881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f1882d;

        /* synthetic */ C0040c(int i10, int i11, String str, String str2, a aVar) {
            this(i10, i11, str, str2);
        }

        private C0040c(int i10, int i11, String str, String str2) {
            this.f1879a = i10;
            this.f1880b = i11;
            this.f1881c = str;
            this.f1882d = str2;
        }

        public static /* synthetic */ int a(C0040c c0040c, C0040c c0040c2) {
            int iCompare = Integer.compare(c0040c2.f1880b, c0040c.f1880b);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = c0040c.f1881c.compareTo(c0040c2.f1881c);
            return iCompareTo != 0 ? iCompareTo : c0040c.f1882d.compareTo(c0040c2.f1882d);
        }

        public static /* synthetic */ int b(C0040c c0040c, C0040c c0040c2) {
            int iCompare = Integer.compare(c0040c2.f1879a, c0040c.f1879a);
            if (iCompare != 0) {
                return iCompare;
            }
            int iCompareTo = c0040c2.f1881c.compareTo(c0040c.f1881c);
            return iCompareTo != 0 ? iCompareTo : c0040c2.f1882d.compareTo(c0040c.f1882d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<C0040c> f1883a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<C0040c> f1884b = new ArrayList();
    }

    public static b a(@Nullable CharSequence charSequence, float f10) {
        a aVar = null;
        if (charSequence == null) {
            return new b("", com.google.common.collect.q.i(), aVar);
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(b(charSequence), com.google.common.collect.q.i(), aVar);
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap map = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            StringBuilder sb2 = new StringBuilder(14);
            sb2.append("bg_");
            sb2.append(iIntValue);
            map.put(com.google.android.exoplayer2.ui.b.a(sb2.toString()), d1.k.f("background-color:%s;", com.google.android.exoplayer2.ui.b.b(iIntValue)));
        }
        SparseArray<d> sparseArrayC = c(spanned, f10);
        StringBuilder sb3 = new StringBuilder(spanned.length());
        int i11 = 0;
        while (i10 < sparseArrayC.size()) {
            int iKeyAt = sparseArrayC.keyAt(i10);
            sb3.append(b(spanned.subSequence(i11, iKeyAt)));
            d dVar = sparseArrayC.get(iKeyAt);
            Collections.sort(dVar.f1884b, C0040c.f1878f);
            Iterator it2 = dVar.f1884b.iterator();
            while (it2.hasNext()) {
                sb3.append(((C0040c) it2.next()).f1882d);
            }
            Collections.sort(dVar.f1883a, C0040c.f1877e);
            Iterator it3 = dVar.f1883a.iterator();
            while (it3.hasNext()) {
                sb3.append(((C0040c) it3.next()).f1881c);
            }
            i10++;
            i11 = iKeyAt;
        }
        sb3.append(b(spanned.subSequence(i11, spanned.length())));
        return new b(sb3.toString(), map, aVar);
    }

    private static String g(int i10) {
        return i10 != 2 ? "over right" : "under left";
    }

    private static SparseArray<d> c(Spanned spanned, float f10) {
        SparseArray<d> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String strE = e(obj, f10);
            String strD = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (strE != null) {
                d1.a.b(strD);
                C0040c c0040c = new C0040c(spanStart, spanEnd, strE, strD, null);
                f(sparseArray, spanStart).f1883a.add(c0040c);
                f(sparseArray, spanEnd).f1884b.add(c0040c);
            }
        }
        return sparseArray;
    }

    @Nullable
    private static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof z0.c)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof z0.b) {
                String strB = b(((z0.b) obj).f22604a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(strB).length() + 16);
                sb2.append("<rt>");
                sb2.append(strB);
                sb2.append("</rt></ruby>");
                return sb2.toString();
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    @Nullable
    private static String e(Object obj, float f10) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return d1.k.f("<span style='color:%s;'>", com.google.android.exoplayer2.ui.b.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return d1.k.f("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            return d1.k.f("<span style='font-size:%.2fpx;'>", Float.valueOf(absoluteSizeSpan.getDip() ? absoluteSizeSpan.getSize() : absoluteSizeSpan.getSize() / f10));
        }
        if (obj instanceof RelativeSizeSpan) {
            return d1.k.f("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return d1.k.f("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (!(obj instanceof z0.b)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof z0.c)) {
                return null;
            }
            z0.c cVar = (z0.c) obj;
            return d1.k.f("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(cVar.f22606a, cVar.f22607b), g(cVar.f22608c));
        }
        int i10 = ((z0.b) obj).f22605b;
        if (i10 == -1) {
            return "<ruby style='ruby-position:unset;'>";
        }
        if (i10 == 1) {
            return "<ruby style='ruby-position:over;'>";
        }
        if (i10 != 2) {
            return null;
        }
        return "<ruby style='ruby-position:under;'>";
    }

    private static String h(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        if (i11 == 1) {
            sb2.append("filled ");
        } else if (i11 == 2) {
            sb2.append("open ");
        }
        if (i10 == 0) {
            sb2.append("none");
        } else if (i10 == 1) {
            sb2.append("circle");
        } else if (i10 == 2) {
            sb2.append("dot");
        } else if (i10 != 3) {
            sb2.append("unset");
        } else {
            sb2.append("sesame");
        }
        return sb2.toString();
    }

    private static String b(CharSequence charSequence) {
        return f1874a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static d f(SparseArray<d> sparseArray, int i10) {
        d dVar = sparseArray.get(i10);
        if (dVar == null) {
            d dVar2 = new d();
            sparseArray.put(i10, dVar2);
            return dVar2;
        }
        return dVar;
    }
}
