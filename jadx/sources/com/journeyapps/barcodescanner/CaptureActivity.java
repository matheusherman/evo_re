package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.google.zxing.client.android.R$id;
import com.google.zxing.client.android.R$layout;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class CaptureActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f4976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DecoratedBarcodeView f4977b;

    static {
        StubApp.interface11(11606);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr);

    protected DecoratedBarcodeView a() {
        setContentView(R$layout.zxing_capture);
        return (DecoratedBarcodeView) findViewById(R$id.zxing_barcode_scanner);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        return this.f4977b.onKeyDown(i10, keyEvent) || super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f4976a.r();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f4976a.s();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f4976a.u();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f4976a.v(bundle);
    }
}
