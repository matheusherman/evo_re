package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.zxing.client.android.R$id;
import com.google.zxing.client.android.R$layout;
import com.google.zxing.client.android.R$styleable;
import h3.e;
import h3.k;
import h3.s;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m3.f;
import m4.g;
import m4.j;
import n4.i;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class DecoratedBarcodeView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BarcodeView f4978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewfinderView f4979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f4980c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b implements m4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private m4.a f4981a;

        public b(m4.a aVar) {
            this.f4981a = aVar;
        }

        @Override // m4.a
        public void a(m4.b bVar) {
            this.f4981a.a(bVar);
        }

        @Override // m4.a
        public void b(List<s> list) {
            Iterator<s> it = list.iterator();
            while (it.hasNext()) {
                DecoratedBarcodeView.this.f4979b.a(it.next());
            }
            this.f4981a.b(list);
        }
    }

    public DecoratedBarcodeView(Context context) {
        super(context);
        c();
    }

    private void c() {
        d(null);
    }

    public void b(m4.a aVar) {
        this.f4978a.I(new b(aVar));
    }

    public void f() {
        this.f4978a.u();
    }

    public void g() {
        this.f4978a.v();
    }

    public BarcodeView getBarcodeView() {
        return (BarcodeView) findViewById(R$id.zxing_barcode_surface);
    }

    public i getCameraSettings() {
        return this.f4978a.getCameraSettings();
    }

    public g getDecoderFactory() {
        return this.f4978a.getDecoderFactory();
    }

    public TextView getStatusView() {
        return this.f4980c;
    }

    public ViewfinderView getViewFinder() {
        return this.f4979b;
    }

    public void h() {
        this.f4978a.y();
    }

    public void i() {
        this.f4978a.setTorch(false);
    }

    public void j() {
        this.f4978a.setTorch(true);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 24) {
            j();
            return true;
        }
        if (i10 == 25) {
            i();
            return true;
        }
        if (i10 == 27 || i10 == 80) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public void setCameraSettings(i iVar) {
        this.f4978a.setCameraSettings(iVar);
    }

    public void setDecoderFactory(g gVar) {
        this.f4978a.setDecoderFactory(gVar);
    }

    public void setStatusText(String str) {
        TextView textView = this.f4980c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(attributeSet);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.zxing_view);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.zxing_view_zxing_scanner_layout, R$layout.zxing_barcode_scanner);
        typedArrayObtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        BarcodeView barcodeView = (BarcodeView) findViewById(R$id.zxing_barcode_surface);
        this.f4978a = barcodeView;
        if (barcodeView != null) {
            barcodeView.q(attributeSet);
            ViewfinderView viewfinderView = (ViewfinderView) findViewById(R$id.zxing_viewfinder_view);
            this.f4979b = viewfinderView;
            if (viewfinderView != null) {
                viewfinderView.setCameraPreview(this.f4978a);
                this.f4980c = (TextView) findViewById(R$id.zxing_status_view);
                return;
            }
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
    }

    public void e(Intent intent) {
        int intExtra;
        Set<h3.a> setA = f.a(intent);
        Map<e, ?> mapA = m3.g.a(intent);
        i iVar = new i();
        if (intent.hasExtra("SCAN_CAMERA_ID") && (intExtra = intent.getIntExtra("SCAN_CAMERA_ID", -1)) >= 0) {
            iVar.i(intExtra);
        }
        if (intent.hasExtra("TORCH_ENABLED") && intent.getBooleanExtra("TORCH_ENABLED", false)) {
            j();
        }
        String stringExtra = intent.getStringExtra("PROMPT_MESSAGE");
        if (stringExtra != null) {
            setStatusText(stringExtra);
        }
        int intExtra2 = intent.getIntExtra("SCAN_TYPE", 0);
        String stringExtra2 = intent.getStringExtra("CHARACTER_SET");
        new k().e(mapA);
        this.f4978a.setCameraSettings(iVar);
        this.f4978a.setDecoderFactory(new j(setA, mapA, stringExtra2, intExtra2));
    }

    public DecoratedBarcodeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        d(attributeSet);
    }

    public void setTorchListener(a aVar) {
    }
}
