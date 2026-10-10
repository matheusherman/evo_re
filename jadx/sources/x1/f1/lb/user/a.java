package x1.f1.lb.user;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import kotlin.Metadata;
import r8.u;
import z1.b1.lb.m.feedback.FeedbackUploadResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J,\u0010\b\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u0003H¦@¢\u0006\u0004\b\b\u0010\tJ,\u0010\n\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u0003H¦@¢\u0006\u0004\b\n\u0010\tJL\u0010\u000f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H¦@¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0013\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H¦@¢\u0006\u0004\b\u0013\u0010\u0014J4\u0010\u0016\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u0007H¦@¢\u0006\u0004\b\u0016\u0010\u0017J4\u0010\u0019\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u00032\u0006\u0010\u0018\u001a\u00020\u0007H¦@¢\u0006\u0004\b\u0019\u0010\u0017J,\u0010\u001a\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u0003H¦@¢\u0006\u0004\b\u001a\u0010\tJ4\u0010\u001b\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u0007H¦@¢\u0006\u0004\b\u001b\u0010\u0017JD\u0010\u001d\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H¦@¢\u0006\u0004\b\u001d\u0010\u0014J4\u0010\u001f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u00032\u0006\u0010\u001e\u001a\u00020\u0007H¦@¢\u0006\u0004\b\u001f\u0010\u0017JX\u0010\"\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0007H¦@¢\u0006\u0004\b\"\u0010#J,\u0010$\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u0003H¦@¢\u0006\u0004\b$\u0010\tJ,\u0010%\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u0003H¦@¢\u0006\u0004\b%\u0010\tJ\u0018\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H¦@¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lx1/f1/lb/user/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/f;", "Lr8/u;", "", "", "", "f", "(Lv8/f;)Ljava/lang/Object;", "m", "userName", "digitalCode", "password", "captchaCode", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "contact", "actionType", "l", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "code", "n", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "token", "g", "j", "b", "passwordDigest", "e", "refreshToken", "d", "verificationCode", "invitationCode", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "a", "k", "Ljava/io/File;", "feedbackFile", "Lz1/b1/lb/m/feedback/FeedbackUploadResponse;", "h", "(Ljava/io/File;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface a<T> {
    Object a(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object b(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object c(String str, String str2, String str3, String str4, String str5, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object d(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object e(String str, String str2, String str3, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object f(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object g(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object h(File file, v8.f<? super FeedbackUploadResponse> fVar);

    Object i(String str, String str2, String str3, String str4, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object j(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object k(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object l(String str, String str2, String str3, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object m(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);

    Object n(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar);
}
