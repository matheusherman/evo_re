package t.v.c.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import q6.b;
import q6.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MyPopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f18719b = c.d(MyPopupWindow.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18720a;

    public MyPopupWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18720a = true;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        try {
            super.showAsDropDown(view);
            this.f18720a = true;
        } catch (Throwable th) {
            f18719b.warn("popup window failure", th);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i10, int i11, int i12) {
        try {
            super.showAtLocation(view, i10, i11, i12);
            this.f18720a = true;
        } catch (Throwable th) {
            f18719b.warn("popup window failure", th);
        }
    }

    public MyPopupWindow(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18720a = true;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        try {
            super.showAsDropDown(view, i10, i11);
            this.f18720a = true;
        } catch (Throwable th) {
            f18719b.warn("popup window failure", th);
        }
    }

    public MyPopupWindow() {
        this.f18720a = true;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
        try {
            super.showAsDropDown(view, i10, i11, i12);
            this.f18720a = true;
        } catch (Throwable th) {
            f18719b.warn("popup window failure", th);
        }
    }
}
