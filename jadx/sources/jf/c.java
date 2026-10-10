package jf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import t.v.c.R$attr;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ColorStateList f11733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f11734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ColorStateList f11735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11736h;

    @SuppressLint({"RtlHardcoded"})
    private Drawable a(int i10, int i11, boolean z10) {
        return new ClipDrawable(c(i10, i11, z10), 3, 1);
    }

    @SuppressLint({"RtlHardcoded"})
    private Drawable b(int i10, int i11) {
        return new ClipDrawable(d(i10, i11), 3, 1);
    }

    private Drawable c(int i10, int i11, boolean z10) {
        return d(i10, !z10 ? f(i11) : -1);
    }

    private Drawable d(int i10, int i11) {
        f fVar = new f(AppCompatResources.getDrawable(this.f11729a, i10));
        fVar.mutate();
        if (i11 != -1) {
            fVar.setTint(i11);
        }
        return fVar;
    }

    private int f(int i10) {
        TypedArray typedArrayObtainStyledAttributes = this.f11729a.obtainStyledAttributes(new int[]{i10});
        try {
            return typedArrayObtainStyledAttributes.getColor(0, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public ColorStateList e() {
        return this.f11733e;
    }

    public Drawable[] g() {
        return new Drawable[]{c(this.f11731c, R$attr.colorControlHighlight, this.f11736h), b(this.f11732d, 0), a(this.f11732d, R$attr.colorControlActivated, this.f11736h)};
    }

    public ColorStateList h() {
        return this.f11734f;
    }

    public ColorStateList i() {
        return this.f11735g;
    }

    public int j() {
        return this.f11730b;
    }

    public c(Context context, int i10, int i11, int i12, ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, boolean z10) {
        this.f11729a = context;
        this.f11730b = i10;
        this.f11731c = i11;
        this.f11732d = i12;
        this.f11736h = z10;
        this.f11733e = colorStateList;
        this.f11734f = colorStateList2;
        this.f11735g = colorStateList3;
    }
}
