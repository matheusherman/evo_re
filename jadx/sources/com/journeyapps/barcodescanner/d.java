package com.journeyapps.barcodescanner;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.zxing.client.android.R$string;
import h3.r;
import h3.s;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m3.e;
import m3.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f5002o = "d";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f5003p = 250;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f5004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DecoratedBarcodeView f5005b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h f5011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private e f5012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Handler f5013j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final CameraPreview.f f5016m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f5017n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5006c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5007d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5008e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5009f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5010g = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5014k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private m4.a f5015l = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements m4.a {
        a() {
        }

        @Override // m4.a
        public void a(final m4.b bVar) {
            d.this.f5005b.f();
            d.this.f5012i.d();
            d.this.f5013j.post(new Runnable() { // from class: com.journeyapps.barcodescanner.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.y(bVar);
                }
            });
        }

        @Override // m4.a
        public void b(List<s> list) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements CameraPreview.f {
        b() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b(Exception exc) {
            d dVar = d.this;
            dVar.m(dVar.f5004a.getString(R$string.zxing_msg_camera_framework_bug));
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
            if (d.this.f5014k) {
                Log.d(d.f5002o, "Camera closed; finishing activity");
                d.this.n();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
        }
    }

    public void r() {
        this.f5010g = true;
        this.f5011h.d();
        this.f5013j.removeCallbacksAndMessages(null);
    }

    private void A() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("MISSING_CAMERA_PERMISSION", true);
        this.f5004a.setResult(0, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f5004a.finish();
    }

    private String o(m4.b bVar) {
        if (!this.f5007d) {
            return null;
        }
        Bitmap bitmapB = bVar.b();
        try {
            File fileCreateTempFile = File.createTempFile("barcodeimage", ".jpg", this.f5004a.getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            bitmapB.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.close();
            return fileCreateTempFile.getAbsolutePath();
        } catch (IOException e10) {
            Log.w(f5002o, "Unable to create temporary file and store bitmap! " + e10);
            return null;
        }
    }

    @TargetApi(23)
    private void w() {
        if (ContextCompat.checkSelfPermission(this.f5004a, "android.permission.CAMERA") == 0) {
            this.f5005b.h();
        } else {
            if (this.f5017n) {
                return;
            }
            ActivityCompat.requestPermissions(this.f5004a, new String[]{"android.permission.CAMERA"}, f5003p);
            this.f5017n = true;
        }
    }

    public static Intent x(m4.b bVar, String str) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addFlags(524288);
        intent.putExtra("SCAN_RESULT", bVar.toString());
        intent.putExtra("SCAN_RESULT_FORMAT", bVar.a().toString());
        byte[] bArrC = bVar.c();
        if (bArrC != null && bArrC.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", bArrC);
        }
        Map<r, Object> mapD = bVar.d();
        if (mapD != null) {
            r rVar = r.UPC_EAN_EXTENSION;
            if (mapD.containsKey(rVar)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", mapD.get(rVar).toString());
            }
            Number number = (Number) mapD.get(r.ORIENTATION);
            if (number != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
            }
            String str2 = (String) mapD.get(r.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str2);
            }
            Iterable iterable = (Iterable) mapD.get(r.BYTE_SEGMENTS);
            if (iterable != null) {
                Iterator it = iterable.iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i10, (byte[]) it.next());
                    i10++;
                }
            }
        }
        if (str != null) {
            intent.putExtra("SCAN_RESULT_IMAGE_PATH", str);
        }
        return intent;
    }

    public void B(boolean z10, String str) {
        this.f5008e = z10;
        if (str == null) {
            str = "";
        }
        this.f5009f = str;
    }

    protected void k() {
        if (this.f5005b.getBarcodeView().s()) {
            n();
        } else {
            this.f5014k = true;
        }
        this.f5005b.f();
        this.f5011h.d();
    }

    public void l() {
        this.f5005b.b(this.f5015l);
    }

    protected void m(String str) {
        if (this.f5004a.isFinishing() || this.f5010g || this.f5014k) {
            return;
        }
        if (str.isEmpty()) {
            str = this.f5004a.getString(R$string.zxing_msg_camera_framework_bug);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f5004a);
        builder.setTitle(this.f5004a.getString(R$string.zxing_app_name));
        builder.setMessage(str);
        builder.setPositiveButton(R$string.zxing_button_ok, new DialogInterface.OnClickListener() { // from class: m4.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f15623a.n();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: m4.e
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f15624a.n();
            }
        });
        builder.show();
    }

    public void p(Intent intent, Bundle bundle) {
        this.f5004a.getWindow().addFlags(128);
        if (bundle != null) {
            this.f5006c = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra("SCAN_ORIENTATION_LOCKED", true)) {
                q();
            }
            if ("com.google.zxing.client.android.SCAN".equals(intent.getAction())) {
                this.f5005b.e(intent);
            }
            if (!intent.getBooleanExtra("BEEP_ENABLED", true)) {
                this.f5012i.e(false);
            }
            if (intent.hasExtra("SHOW_MISSING_CAMERA_PERMISSION_DIALOG")) {
                B(intent.getBooleanExtra("SHOW_MISSING_CAMERA_PERMISSION_DIALOG", true), intent.getStringExtra("MISSING_CAMERA_PERMISSION_DIALOG_MESSAGE"));
            }
            if (intent.hasExtra("TIMEOUT")) {
                this.f5013j.postDelayed(new Runnable() { // from class: com.journeyapps.barcodescanner.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f4999a.z();
                    }
                }, intent.getLongExtra("TIMEOUT", 0L));
            }
            if (intent.getBooleanExtra("BARCODE_IMAGE_ENABLED", false)) {
                this.f5007d = true;
            }
        }
    }

    protected void q() {
        if (this.f5006c == -1) {
            int rotation = this.f5004a.getWindowManager().getDefaultDisplay().getRotation();
            int i10 = this.f5004a.getResources().getConfiguration().orientation;
            int i11 = 0;
            if (i10 == 2) {
                if (rotation != 0 && rotation != 1) {
                    i11 = 8;
                }
            } else if (i10 == 1) {
                i11 = (rotation == 0 || rotation == 3) ? 1 : 9;
            }
            this.f5006c = i11;
        }
        this.f5004a.setRequestedOrientation(this.f5006c);
    }

    public void s() {
        this.f5011h.d();
        this.f5005b.g();
    }

    public void t(int i10, String[] strArr, int[] iArr) {
        if (i10 == f5003p) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.f5005b.h();
                return;
            }
            A();
            if (this.f5008e) {
                m(this.f5009f);
            } else {
                k();
            }
        }
    }

    public void u() {
        if (Build.VERSION.SDK_INT >= 23) {
            w();
        } else {
            this.f5005b.h();
        }
        this.f5011h.h();
    }

    public void v(Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.f5006c);
    }

    protected void z() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("TIMEOUT", true);
        this.f5004a.setResult(0, intent);
        k();
    }

    public d(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        b bVar = new b();
        this.f5016m = bVar;
        this.f5017n = false;
        this.f5004a = activity;
        this.f5005b = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().i(bVar);
        this.f5013j = new Handler();
        this.f5011h = new h(activity, new Runnable() { // from class: m4.c
            @Override // java.lang.Runnable
            public final void run() {
                com.journeyapps.barcodescanner.d.c(this.f15622a);
            }
        });
        this.f5012i = new e(activity);
    }

    public static /* synthetic */ void c(d dVar) {
        dVar.getClass();
        Log.d(f5002o, "Finishing due to inactivity");
        dVar.n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(m4.b bVar) {
        this.f5004a.setResult(-1, x(bVar, o(bVar)));
        k();
    }
}
