package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.client.android.R$color;
import com.google.zxing.client.android.R$styleable;
import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import h3.s;
import java.util.ArrayList;
import java.util.List;
import m4.p;
import org.apache.log4j.net.SyslogAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class ViewfinderView extends View {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected static final int[] f4983n = {0, 64, 128, RsaOaep.DerParser.PRIVATE, 255, RsaOaep.DerParser.PRIVATE, 128, 64};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Paint f4984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Bitmap f4985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f4986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f4987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f4988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final int f4989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f4990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f4991h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected List<s> f4992i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected List<s> f4993j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected CameraPreview f4994k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected Rect f4995l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected p f4996m;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements CameraPreview.f {
        a() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
            ViewfinderView.this.b();
            ViewfinderView.this.invalidate();
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b(Exception exc) {
        }
    }

    public void a(s sVar) {
        if (this.f4992i.size() < 20) {
            this.f4992i.add(sVar);
        }
    }

    protected void b() {
        CameraPreview cameraPreview = this.f4994k;
        if (cameraPreview == null) {
            return;
        }
        Rect framingRect = cameraPreview.getFramingRect();
        p previewSize = this.f4994k.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.f4995l = framingRect;
        this.f4996m = previewSize;
    }

    public void setCameraPreview(CameraPreview cameraPreview) {
        this.f4994k = cameraPreview;
        cameraPreview.i(new a());
    }

    public void setLaserVisibility(boolean z10) {
        this.f4990g = z10;
    }

    public void setMaskColor(int i10) {
        this.f4986c = i10;
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4984a = new Paint(1);
        Resources resources = getResources();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_finder);
        this.f4986c = typedArrayObtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_viewfinder_mask, resources.getColor(R$color.zxing_viewfinder_mask));
        this.f4987d = typedArrayObtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_result_view, resources.getColor(R$color.zxing_result_view));
        this.f4988e = typedArrayObtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_viewfinder_laser, resources.getColor(R$color.zxing_viewfinder_laser));
        this.f4989f = typedArrayObtainStyledAttributes.getColor(R$styleable.zxing_finder_zxing_possible_result_points, resources.getColor(R$color.zxing_possible_result_points));
        this.f4990g = typedArrayObtainStyledAttributes.getBoolean(R$styleable.zxing_finder_zxing_viewfinder_laser_visibility, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f4991h = 0;
        this.f4992i = new ArrayList(20);
        this.f4993j = new ArrayList(20);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        p pVar;
        int i10;
        b();
        Rect rect = this.f4995l;
        if (rect != null && (pVar = this.f4996m) != null) {
            int width = getWidth();
            int height = getHeight();
            Paint paint = this.f4984a;
            if (this.f4985b != null) {
                i10 = this.f4987d;
            } else {
                i10 = this.f4986c;
            }
            paint.setColor(i10);
            float f10 = width;
            canvas.drawRect(0.0f, 0.0f, f10, rect.top, this.f4984a);
            canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.f4984a);
            canvas.drawRect(rect.right + 1, rect.top, f10, rect.bottom + 1, this.f4984a);
            canvas.drawRect(0.0f, rect.bottom + 1, f10, height, this.f4984a);
            if (this.f4985b != null) {
                this.f4984a.setAlpha(SyslogAppender.LOG_LOCAL4);
                canvas.drawBitmap(this.f4985b, (Rect) null, rect, this.f4984a);
                return;
            }
            if (this.f4990g) {
                this.f4984a.setColor(this.f4988e);
                Paint paint2 = this.f4984a;
                int[] iArr = f4983n;
                paint2.setAlpha(iArr[this.f4991h]);
                this.f4991h = (this.f4991h + 1) % iArr.length;
                int iHeight = (rect.height() / 2) + rect.top;
                canvas.drawRect(rect.left + 2, iHeight - 1, rect.right - 1, iHeight + 2, this.f4984a);
            }
            float width2 = getWidth() / pVar.f15654a;
            float height2 = getHeight() / pVar.f15655b;
            if (!this.f4993j.isEmpty()) {
                this.f4984a.setAlpha(80);
                this.f4984a.setColor(this.f4989f);
                for (s sVar : this.f4993j) {
                    canvas.drawCircle((int) (sVar.c() * width2), (int) (sVar.d() * height2), 3.0f, this.f4984a);
                }
                this.f4993j.clear();
            }
            if (!this.f4992i.isEmpty()) {
                this.f4984a.setAlpha(SyslogAppender.LOG_LOCAL4);
                this.f4984a.setColor(this.f4989f);
                for (s sVar2 : this.f4992i) {
                    canvas.drawCircle((int) (sVar2.c() * width2), (int) (sVar2.d() * height2), 6.0f, this.f4984a);
                }
                List<s> list = this.f4992i;
                List<s> list2 = this.f4993j;
                this.f4992i = list2;
                this.f4993j = list;
                list2.clear();
            }
            postInvalidateDelayed(80L, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
        }
    }
}
