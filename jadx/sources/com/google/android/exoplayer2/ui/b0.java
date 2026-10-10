package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.pengrad.telegrambot.model.request.InlineQueryResultVideo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class b0 extends FrameLayout implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.ui.a f1866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebView f1867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<y0.a> f1868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b1.b f1869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f1870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f1872g;

    public b0(Context context) {
        this(context, null);
    }

    private static int b(int i10) {
        if (i10 != 1) {
            return i10 != 2 ? 0 : -100;
        }
        return -50;
    }

    private static String f(int i10) {
        if (i10 != 1) {
            return i10 != 2 ? "horizontal-tb" : "vertical-lr";
        }
        return "vertical-rl";
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends WebView {
        a(b0 b0Var, Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1873a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f1873a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1873a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1873a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b0(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1868c = Collections.EMPTY_LIST;
        this.f1869d = b1.b.f632g;
        this.f1870e = 0.0533f;
        this.f1871f = 0;
        this.f1872g = 0.08f;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context, attributeSet);
        this.f1866a = aVar;
        a aVar2 = new a(this, context, attributeSet);
        this.f1867b = aVar2;
        aVar2.setBackgroundColor(0);
        addView(aVar);
        addView(aVar2);
    }

    private static String c(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i10 = b.f1873a[alignment.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? "center" : "end";
        }
        return "start";
    }

    private static String d(b1.b bVar) {
        int i10 = bVar.f636d;
        if (i10 == 1) {
            return d1.k.f("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", com.google.android.exoplayer2.ui.b.b(bVar.f637e));
        }
        if (i10 == 2) {
            return d1.k.f("0.1em 0.12em 0.15em %s", com.google.android.exoplayer2.ui.b.b(bVar.f637e));
        }
        if (i10 != 3) {
            return i10 != 4 ? "unset" : d1.k.f("-0.05em -0.05em 0.15em %s", com.google.android.exoplayer2.ui.b.b(bVar.f637e));
        }
        return d1.k.f("0.06em 0.08em 0.15em %s", com.google.android.exoplayer2.ui.b.b(bVar.f637e));
    }

    private static String h(y0.a aVar) {
        float f10 = aVar.f22289q;
        if (f10 == 0.0f) {
            return "";
        }
        int i10 = aVar.f22288p;
        return d1.k.f("%s(%.2fdeg)", (i10 == 2 || i10 == 1) ? "skewY" : "skewX", Float.valueOf(f10));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0114  */
    /* JADX WARN: Code duplicated, block: B:28:0x0125  */
    /* JADX WARN: Code duplicated, block: B:31:0x0141  */
    /* JADX WARN: Code duplicated, block: B:32:0x0144  */
    /* JADX WARN: Code duplicated, block: B:35:0x015b  */
    /* JADX WARN: Code duplicated, block: B:37:0x015e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x0160  */
    /* JADX WARN: Code duplicated, block: B:41:0x0168 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x016b  */
    /* JADX WARN: Code duplicated, block: B:44:0x016e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x017a  */
    /* JADX WARN: Code duplicated, block: B:55:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:65:0x023d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0257  */
    private void i() {
        char c10;
        float f10;
        String strF;
        int iB;
        boolean z10;
        float f11;
        float f12;
        char c11;
        String strF2;
        int i10;
        int i11;
        String str;
        String str2;
        String str3;
        c.b bVarA;
        Layout.Alignment alignment;
        String str4;
        boolean z11;
        StringBuilder sb2 = new StringBuilder();
        char c12 = 0;
        int i12 = 1;
        sb2.append(d1.k.f("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", com.google.android.exoplayer2.ui.b.b(this.f1869d.f633a), e(this.f1871f, this.f1870e), Float.valueOf(1.2f), d(this.f1869d)));
        HashMap map = new HashMap();
        map.put(com.google.android.exoplayer2.ui.b.a("default_bg"), d1.k.f("background-color:%s;", com.google.android.exoplayer2.ui.b.b(this.f1869d.f634b)));
        int i13 = 0;
        while (i13 < this.f1868c.size()) {
            y0.a aVar = this.f1868c.get(i13);
            float f13 = aVar.f22280h;
            float f14 = f13 != -3.4028235E38f ? f13 * 100.0f : 50.0f;
            int iB2 = b(aVar.f22281i);
            float f15 = aVar.f22277e;
            if (f15 != -3.4028235E38f) {
                c10 = 4;
                if (aVar.f22278f != i12) {
                    Object[] objArr = new Object[i12];
                    objArr[c12] = Float.valueOf(f15 * 100.0f);
                    strF = d1.k.f("%.2f%%", objArr);
                    iB = aVar.f22288p == i12 ? -b(aVar.f22279g) : b(aVar.f22279g);
                    z10 = false;
                    f11 = 100.0f;
                    f10 = -3.4028235E38f;
                } else {
                    if (f15 >= 0.0f) {
                        f10 = -3.4028235E38f;
                        Object[] objArr2 = new Object[i12];
                        objArr2[c12] = Float.valueOf(f15 * 1.2f);
                        strF = d1.k.f("%.2fem", objArr2);
                        iB = 0;
                    } else {
                        f10 = -3.4028235E38f;
                        Object[] objArr3 = new Object[i12];
                        objArr3[c12] = Float.valueOf(((-f15) - 1.0f) * 1.2f);
                        strF = d1.k.f("%.2fem", objArr3);
                        iB = 0;
                        z10 = true;
                    }
                    f11 = 100.0f;
                }
                f12 = aVar.f22282j;
                if (f12 != f10) {
                    Float fValueOf = Float.valueOf(f12 * f11);
                    c11 = 0;
                    Object[] objArr4 = new Object[i12];
                    objArr4[0] = fValueOf;
                    strF2 = d1.k.f("%.2f%%", objArr4);
                } else {
                    c11 = 0;
                    strF2 = "fit-content";
                }
                String strC = c(aVar.f22274b);
                String strF3 = f(aVar.f22288p);
                String strE = e(aVar.f22286n, aVar.f22287o);
                if (aVar.f22284l) {
                    i10 = aVar.f22285m;
                } else {
                    i10 = this.f1869d.f635c;
                }
                String strB = com.google.android.exoplayer2.ui.b.b(i10);
                i11 = aVar.f22288p;
                str = "right";
                str2 = "top";
                if (i11 != 1) {
                    if (i11 != 2) {
                        str = z10 ? "bottom" : "top";
                        str2 = "left";
                    } else if (!z10) {
                        str = "left";
                    }
                } else if (z10) {
                    str = "left";
                }
                if (i11 != 2 || i11 == 1) {
                    str3 = "height";
                    iB2 = iB;
                    iB = iB2;
                } else {
                    str3 = "width";
                }
                bVarA = c.a(aVar.f22273a, getContext().getResources().getDisplayMetrics().density);
                for (String str5 : map.keySet()) {
                    String str6 = str3;
                    String str7 = strF;
                    str4 = (String) map.put(str5, (String) map.get(str5));
                    if (str4 != null || str4.equals(map.get(str5))) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    d1.a.c(z11);
                    str3 = str6;
                    strF = str7;
                }
                String str8 = str3;
                String str9 = strF;
                Integer numValueOf = Integer.valueOf(i13);
                Float fValueOf2 = Float.valueOf(f14);
                Integer numValueOf2 = Integer.valueOf(iB2);
                Integer numValueOf3 = Integer.valueOf(iB);
                String strH = h(aVar);
                Object[] objArr5 = new Object[14];
                objArr5[c11] = numValueOf;
                objArr5[1] = str2;
                objArr5[2] = fValueOf2;
                objArr5[3] = str;
                objArr5[c10] = str9;
                objArr5[5] = str8;
                objArr5[6] = strF2;
                objArr5[7] = strC;
                objArr5[8] = strF3;
                objArr5[9] = strE;
                objArr5[10] = strB;
                objArr5[11] = numValueOf2;
                objArr5[12] = numValueOf3;
                objArr5[13] = strH;
                sb2.append(d1.k.f("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr5));
                Object[] objArr6 = new Object[1];
                objArr6[c11] = "default_bg";
                sb2.append(d1.k.f("<span class='%s'>", objArr6));
                alignment = aVar.f22275c;
                if (alignment != null) {
                    Object[] objArr7 = new Object[1];
                    objArr7[c11] = c(alignment);
                    sb2.append(d1.k.f("<span style='display:inline-block; text-align:%s;'>", objArr7));
                    sb2.append(bVarA.f1875a);
                    sb2.append("</span>");
                } else {
                    sb2.append(bVarA.f1875a);
                }
                sb2.append("</span>");
                sb2.append("</div>");
                i13++;
                i12 = 1;
                c12 = 0;
            } else {
                c10 = 4;
                f10 = -3.4028235E38f;
                Object[] objArr8 = new Object[i12];
                objArr8[c12] = Float.valueOf((1.0f - this.f1872g) * 100.0f);
                strF = d1.k.f("%.2f%%", objArr8);
                iB = -100;
            }
            z10 = false;
            f11 = 100.0f;
            f12 = aVar.f22282j;
            if (f12 != f10) {
                Float fValueOf3 = Float.valueOf(f12 * f11);
                c11 = 0;
                Object[] objArr9 = new Object[i12];
                objArr9[0] = fValueOf3;
                strF2 = d1.k.f("%.2f%%", objArr9);
            } else {
                c11 = 0;
                strF2 = "fit-content";
            }
            String strC2 = c(aVar.f22274b);
            String strF4 = f(aVar.f22288p);
            String strE2 = e(aVar.f22286n, aVar.f22287o);
            if (aVar.f22284l) {
                i10 = aVar.f22285m;
            } else {
                i10 = this.f1869d.f635c;
            }
            String strB2 = com.google.android.exoplayer2.ui.b.b(i10);
            i11 = aVar.f22288p;
            str = "right";
            str2 = "top";
            if (i11 != 1) {
                if (i11 != 2) {
                    str = z10 ? "bottom" : "top";
                    str2 = "left";
                } else if (!z10) {
                    str = "left";
                }
            } else if (z10) {
                str = "left";
            }
            if (i11 != 2) {
                str3 = "height";
                iB2 = iB;
                iB = iB2;
            } else {
                str3 = "height";
                iB2 = iB;
                iB = iB2;
            }
            bVarA = c.a(aVar.f22273a, getContext().getResources().getDisplayMetrics().density);
            while (r13.hasNext()) {
                String str10 = str3;
                String str11 = strF;
                str4 = (String) map.put(str5, (String) map.get(str5));
                if (str4 != null) {
                    z11 = true;
                } else {
                    z11 = true;
                }
                d1.a.c(z11);
                str3 = str10;
                strF = str11;
            }
            String str12 = str3;
            String str13 = strF;
            Integer numValueOf4 = Integer.valueOf(i13);
            Float fValueOf4 = Float.valueOf(f14);
            Integer numValueOf5 = Integer.valueOf(iB2);
            Integer numValueOf6 = Integer.valueOf(iB);
            String strH2 = h(aVar);
            Object[] objArr10 = new Object[14];
            objArr10[c11] = numValueOf4;
            objArr10[1] = str2;
            objArr10[2] = fValueOf4;
            objArr10[3] = str;
            objArr10[c10] = str13;
            objArr10[5] = str12;
            objArr10[6] = strF2;
            objArr10[7] = strC2;
            objArr10[8] = strF4;
            objArr10[9] = strE2;
            objArr10[10] = strB2;
            objArr10[11] = numValueOf5;
            objArr10[12] = numValueOf6;
            objArr10[13] = strH2;
            sb2.append(d1.k.f("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", objArr10));
            Object[] objArr11 = new Object[1];
            objArr11[c11] = "default_bg";
            sb2.append(d1.k.f("<span class='%s'>", objArr11));
            alignment = aVar.f22275c;
            if (alignment != null) {
                Object[] objArr12 = new Object[1];
                objArr12[c11] = c(alignment);
                sb2.append(d1.k.f("<span style='display:inline-block; text-align:%s;'>", objArr12));
                sb2.append(bVarA.f1875a);
                sb2.append("</span>");
            } else {
                sb2.append(bVarA.f1875a);
            }
            sb2.append("</span>");
            sb2.append("</div>");
            i13++;
            i12 = 1;
            c12 = 0;
        }
        sb2.append("</div></body></html>");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("<html><head><style>");
        for (String str14 : map.keySet()) {
            sb3.append(str14);
            sb3.append("{");
            sb3.append((String) map.get(str14));
            sb3.append("}");
        }
        sb3.append("</style></head>");
        sb2.insert(0, sb3.toString());
        this.f1867b.loadData(Base64.encodeToString(sb2.toString().getBytes(com.google.common.base.d.f4562c), 1), InlineQueryResultVideo.MIME_TEXT_HTML, "base64");
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<y0.a> list, b1.b bVar, float f10, int i10, float f11) {
        this.f1869d = bVar;
        this.f1870e = f10;
        this.f1871f = i10;
        this.f1872g = f11;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            y0.a aVar = list.get(i11);
            if (aVar.f22276d != null) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        if (!this.f1868c.isEmpty() || !arrayList2.isEmpty()) {
            this.f1868c = arrayList2;
            i();
        }
        this.f1866a.a(arrayList, bVar, f10, i10, f11);
        invalidate();
    }

    public void g() {
        this.f1867b.destroy();
    }

    private String e(int i10, float f10) {
        float f11 = z.f(i10, f10, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (f11 == -3.4028235E38f) {
            return "unset";
        }
        return d1.k.f("%.2fpx", Float.valueOf(f11 / getContext().getResources().getDisplayMetrics().density));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10 && !this.f1868c.isEmpty()) {
            i();
        }
    }
}
