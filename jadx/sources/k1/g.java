package k1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    protected final h f12027a;

    @NonNull
    public static h c(@NonNull Activity activity) {
        return d(new f(activity));
    }

    @NonNull
    public Activity b() {
        Activity activityX = this.f12027a.x();
        m1.g.k(activityX);
        return activityX;
    }

    protected g(@NonNull h hVar) {
        this.f12027a = hVar;
    }

    @NonNull
    protected static h d(@NonNull f fVar) {
        if (fVar.d()) {
            return e1.R(fVar.b());
        }
        if (fVar.c()) {
            return b1.a(fVar.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @MainThread
    public void g() {
    }

    @MainThread
    public void h() {
    }

    @MainThread
    public void j() {
    }

    @MainThread
    public void k() {
    }

    @MainThread
    public void f(@Nullable Bundle bundle) {
    }

    @MainThread
    public void i(@NonNull Bundle bundle) {
    }

    @MainThread
    public void e(int i10, int i11, @Nullable Intent intent) {
    }

    @MainThread
    public void a(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }
}
