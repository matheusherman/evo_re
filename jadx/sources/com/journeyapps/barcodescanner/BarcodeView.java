package com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.google.zxing.client.android.R$id;
import h3.e;
import h3.s;
import java.util.HashMap;
import java.util.List;
import m4.f;
import m4.g;
import m4.h;
import m4.i;
import m4.j;
import m4.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class BarcodeView extends CameraPreview {
    private b B;
    private m4.a C;
    private i D;
    private g E;
    private Handler F;
    private final Handler.Callback G;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == R$id.zxing_decode_succeeded) {
                m4.b bVar = (m4.b) message.obj;
                if (bVar != null && BarcodeView.this.C != null && BarcodeView.this.B != b.NONE) {
                    BarcodeView.this.C.a(bVar);
                    if (BarcodeView.this.B == b.SINGLE) {
                        BarcodeView.this.M();
                    }
                }
                return true;
            }
            if (i10 == R$id.zxing_decode_failed) {
                return true;
            }
            if (i10 != R$id.zxing_possible_result_points) {
                return false;
            }
            List<s> list = (List) message.obj;
            if (BarcodeView.this.C != null && BarcodeView.this.B != b.NONE) {
                BarcodeView.this.C.b(list);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private enum b {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public BarcodeView(Context context) {
        super(context);
        this.B = b.NONE;
        this.C = null;
        this.G = new a();
        J();
    }

    private f G() {
        if (this.E == null) {
            this.E = H();
        }
        h hVar = new h();
        HashMap map = new HashMap();
        map.put(e.NEED_RESULT_POINT_CALLBACK, hVar);
        f fVarA = this.E.a(map);
        hVar.b(fVarA);
        return fVarA;
    }

    private void J() {
        this.E = new j();
        this.F = new Handler(this.G);
    }

    private void L() {
        i iVar = this.D;
        if (iVar != null) {
            iVar.l();
            this.D = null;
        }
    }

    protected g H() {
        return new j();
    }

    public void I(m4.a aVar) {
        this.B = b.SINGLE;
        this.C = aVar;
        K();
    }

    public void M() {
        this.B = b.NONE;
        this.C = null;
        L();
    }

    public g getDecoderFactory() {
        return this.E;
    }

    private void K() {
        L();
        if (this.B != b.NONE && t()) {
            i iVar = new i(getCameraInstance(), G(), this.F);
            this.D = iVar;
            iVar.i(getPreviewFramingRect());
            this.D.k();
        }
    }

    public void setDecoderFactory(g gVar) {
        r.a();
        this.E = gVar;
        i iVar = this.D;
        if (iVar != null) {
            iVar.j(G());
        }
    }

    @Override // com.journeyapps.barcodescanner.CameraPreview
    public void u() {
        L();
        super.u();
    }

    @Override // com.journeyapps.barcodescanner.CameraPreview
    protected void x() {
        super.x();
        K();
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = b.NONE;
        this.C = null;
        this.G = new a();
        J();
    }

    public BarcodeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.B = b.NONE;
        this.C = null;
        this.G = new a();
        J();
    }
}
