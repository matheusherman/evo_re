package com.blankj.utilcode.util;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class UtilsTransActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<UtilsTransActivity, a> f1238a;

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        a aVar = f1238a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.f(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr);

    static {
        StubApp.interface11(7351);
        f1238a = new HashMap();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = f1238a.get(this);
        if (aVar == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (aVar.a(this, motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        a aVar = f1238a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.b(this, i10, i11, intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Map<UtilsTransActivity, a> map = f1238a;
        a aVar = map.get(this);
        if (aVar == null) {
            return;
        }
        aVar.e(this);
        map.remove(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        a aVar = f1238a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.h(this);
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        a aVar = f1238a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.i(this, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        a aVar = f1238a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.j(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        a aVar = f1238a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.k(this);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class a implements Serializable {
        public boolean a(@NonNull UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            return false;
        }

        public void e(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void f(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void h(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void j(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void k(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void c(@NonNull UtilsTransActivity utilsTransActivity, @Nullable Bundle bundle) {
        }

        public void d(@NonNull UtilsTransActivity utilsTransActivity, @Nullable Bundle bundle) {
        }

        public void i(@NonNull UtilsTransActivity utilsTransActivity, Bundle bundle) {
        }

        public void b(@NonNull UtilsTransActivity utilsTransActivity, int i10, int i11, Intent intent) {
        }

        public void g(@NonNull UtilsTransActivity utilsTransActivity, int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        }
    }
}
