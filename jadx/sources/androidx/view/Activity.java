package androidx.view;

import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import r8.z;
import v8.f;

/* JADX INFO: renamed from: androidx.activity.PipHintTrackerKt, reason: from Kotlin metadata */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Landroid/app/Activity;", "Landroid/view/View;", "view", "Lr8/z;", "trackPipAnimationHintView", "(Landroid/app/Activity;Landroid/view/View;Lv8/f;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Activity {
    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(final android.app.Activity activity, View view, f<? super z> fVar) {
        Object objCollect = h.e(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new g() { // from class: androidx.activity.PipHintTrackerKt.trackPipAnimationHintView.2
            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, f fVar2) {
                return emit((android.graphics.Rect) obj, (f<? super z>) fVar2);
            }

            public final Object emit(android.graphics.Rect rect, f<? super z> fVar2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return z.f17874a;
            }
        }, fVar);
        return objCollect == b.c() ? objCollect : z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.graphics.Rect trackPipAnimationHintView$positionInWindow(View view) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
