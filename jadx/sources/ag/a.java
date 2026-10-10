package ag;

import android.view.View;
import java.lang.ref.WeakReference;
import q6.b;
import q6.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference<View> f287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f294i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f286a = c.d(a.class);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f295j = 0;

    /* JADX WARN: Code duplicated, block: B:53:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c1 A[DONT_INVERT] */
    public void a(int i10, int i11) {
        int i12;
        float f10;
        int i13;
        int i14 = this.f292g;
        if (i14 == 90 || i14 == 270) {
            i11 = i10;
            i10 = i11;
        }
        int defaultSize = View.getDefaultSize(this.f288c, i10);
        int defaultSize2 = View.getDefaultSize(this.f289d, i11);
        if (this.f295j != 3) {
            if (this.f288c <= 0 || this.f289d <= 0) {
                i10 = defaultSize;
                i11 = defaultSize2;
            } else {
                int mode = View.MeasureSpec.getMode(i10);
                i10 = View.MeasureSpec.getSize(i10);
                int mode2 = View.MeasureSpec.getMode(i11);
                i11 = View.MeasureSpec.getSize(i11);
                if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                    float f11 = i10;
                    float f12 = i11;
                    float f13 = f11 / f12;
                    int i15 = this.f295j;
                    if (i15 == 1) {
                        f10 = defaultSize / defaultSize2;
                        int i16 = this.f292g;
                        if (i16 == 90 || i16 == 270) {
                            f10 = 1.0f / f10;
                        }
                    } else if (i15 == 4) {
                        int i17 = this.f292g;
                        f10 = (i17 == 90 || i17 == 270) ? 0.5625f : 1.7777778f;
                    } else if (i15 != 5) {
                        f10 = this.f288c / this.f289d;
                        int i18 = this.f290e;
                        if (i18 > 0 && (i13 = this.f291f) > 0) {
                            f10 = (f10 * i18) / i13;
                        }
                    } else {
                        int i19 = this.f292g;
                        f10 = (i19 == 90 || i19 == 270) ? 0.75f : 1.3333334f;
                    }
                    boolean z10 = f10 > f13;
                    if (i15 == 0) {
                        if (z10) {
                            i11 = (int) (f11 / f10);
                        } else {
                            i10 = (int) (f12 * f10);
                        }
                    } else if (i15 != 1) {
                        if (i15 == 4 || i15 == 5) {
                            if (z10) {
                                i11 = (int) (f11 / f10);
                            } else {
                                i10 = (int) (f12 * f10);
                            }
                        } else if (z10) {
                            i10 = Math.min(this.f288c, i10);
                            i11 = (int) (i10 / f10);
                        } else {
                            int iMin = Math.min(this.f289d, i11);
                            i11 = iMin;
                            i10 = (int) (iMin * f10);
                        }
                    } else if (z10) {
                        i10 = (int) (f12 * f10);
                    } else {
                        i11 = (int) (f11 / f10);
                    }
                } else if (mode == 1073741824 && mode2 == 1073741824) {
                    int i20 = this.f288c;
                    int i21 = i20 * i11;
                    int i22 = this.f289d;
                    if (i21 < i10 * i22) {
                        i10 = (i20 * i11) / i22;
                    } else if (i20 * i11 > i10 * i22) {
                        i11 = (i22 * i10) / i20;
                    }
                } else if (mode == 1073741824) {
                    int i23 = (this.f289d * i10) / this.f288c;
                    if (mode2 != Integer.MIN_VALUE || i23 <= i11) {
                        i11 = i23;
                    }
                } else if (mode2 == 1073741824) {
                    int i24 = (this.f288c * i11) / this.f289d;
                    if (mode != Integer.MIN_VALUE || i24 <= i10) {
                        i10 = i24;
                    }
                } else {
                    int i25 = this.f288c;
                    int i26 = this.f289d;
                    if (mode2 != Integer.MIN_VALUE || i26 <= i11) {
                        i12 = i25;
                        i11 = i26;
                    } else {
                        i12 = (i11 * i25) / i26;
                    }
                    if (mode != Integer.MIN_VALUE || i12 <= i10) {
                        i10 = i12;
                    } else {
                        i11 = (i26 * i10) / i25;
                    }
                }
            }
        }
        this.f293h = i10;
        this.f294i = i11;
    }

    public int b() {
        return this.f294i;
    }

    public int c() {
        return this.f293h;
    }

    public void d(int i10) {
        this.f295j = i10;
    }

    public void e(int i10) {
        this.f292g = i10;
    }

    public void f(int i10, int i11) {
        this.f290e = i10;
        this.f291f = i11;
    }

    public void g(int i10, int i11) {
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.f286a.debug("@@@@: setVideoSize[" + this.f288c + ", " + this.f289d + "]", new Object[0]);
        }
        this.f288c = i10;
        this.f289d = i11;
    }

    public a(View view) {
        this.f287b = new WeakReference<>(view);
    }
}
