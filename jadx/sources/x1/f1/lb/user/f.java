package x1.f1.lb.user;

import android.content.DialogInterface;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x.l1.b2.R$string;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.j0;
import x1.f1.lb.util.u0;
import x1.f1.lb.util.w0;
import z1.b1.lb.m.extra.user.AccountSubscription;
import z1.b1.lb.m.feedback.FeedbackUploadResponse;
import z1.b1.lb.m.local.LocalSessionInfo;
import z1.b1.lb.m.ptv.ApiResponse;
import z1.b1.lb.m.ptv.referral.ReferralSummary;
import z1.b1.lb.m.user.ServerResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\nJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J[\u0010 \u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010\rJ\u0019\u0010(\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b*\u0010)J\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002¢\u0006\u0004\b-\u0010.J\u0019\u00100\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b6\u00101J8\u0010:\u001a\u00020\b2&\b\u0002\u00109\u001a \u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000608\u0018\u000107H\u0082@¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000bH\u0002¢\u0006\u0004\b<\u0010\rJ\u0010\u0010=\u001a\u00020\bH\u0082@¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\bH\u0002¢\u0006\u0004\b?\u0010\u0003J!\u0010A\u001a\u00020\b2\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aH\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010DJz\u0010K\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u000b2\"\u0010G\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080F2\u0006\u0010H\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\u00062\u0006\u0010J\u001a\u00020\u000b2\"\u00109\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060807H\u0082@¢\u0006\u0004\bK\u0010LJ<\u0010M\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080F2\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0006H\u0082@¢\u0006\u0004\bM\u0010NJ+\u0010O\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080FH\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\bH\u0002¢\u0006\u0004\bQ\u0010\u0003J\u001d\u0010S\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0004¢\u0006\u0004\bS\u0010TJ\r\u0010U\u001a\u00020\b¢\u0006\u0004\bU\u0010\u0003J\u000f\u0010V\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bV\u0010WJI\u0010Z\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080F2\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020\u0006¢\u0006\u0004\bZ\u0010[JF\u0010]\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080F2\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u00020\u000b¢\u0006\u0004\b_\u0010\rJ\u0015\u0010`\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u0006¢\u0006\u0004\b`\u0010aJ\r\u0010b\u001a\u00020&¢\u0006\u0004\bb\u0010cJ\r\u0010d\u001a\u00020\u0006¢\u0006\u0004\bd\u0010$J\r\u0010e\u001a\u00020\u0006¢\u0006\u0004\be\u0010$J\r\u0010f\u001a\u00020\u0006¢\u0006\u0004\bf\u0010$J\u0015\u0010i\u001a\u00020\b2\u0006\u0010h\u001a\u00020g¢\u0006\u0004\bi\u0010jJ\u0015\u0010l\u001a\u00020\b2\u0006\u0010k\u001a\u00020\u0004¢\u0006\u0004\bl\u0010mJ\u0015\u0010n\u001a\u00020\b2\u0006\u0010k\u001a\u00020\u0004¢\u0006\u0004\bn\u0010mJ\u0015\u0010o\u001a\u00020\b2\u0006\u0010k\u001a\u00020\u0004¢\u0006\u0004\bo\u0010mJ\r\u0010p\u001a\u00020\u000b¢\u0006\u0004\bp\u0010\rJ\r\u0010q\u001a\u00020\u000b¢\u0006\u0004\bq\u0010\rJ\r\u0010r\u001a\u00020&¢\u0006\u0004\br\u0010cJ\r\u0010s\u001a\u00020&¢\u0006\u0004\bs\u0010cJ\r\u0010t\u001a\u00020&¢\u0006\u0004\bt\u0010cJ\r\u0010u\u001a\u00020\u0006¢\u0006\u0004\bu\u0010$J\r\u0010v\u001a\u00020\u0004¢\u0006\u0004\bv\u0010wJ\u0015\u0010y\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020\u0006¢\u0006\u0004\by\u0010aJ4\u0010z\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080F2\u0006\u0010x\u001a\u00020\u0006H\u0086@¢\u0006\u0004\bz\u0010{J4\u0010|\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080F2\u0006\u0010x\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b|\u0010{JD\u0010}\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080F2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b}\u0010^J[\u0010\u0080\u0001\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080F2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u007f\u001a\u00020\u0006H\u0086@¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u000f\u0010\u0082\u0001\u001a\u00020\b¢\u0006\u0005\b\u0082\u0001\u0010\u0003J\u000f\u0010\u0083\u0001\u001a\u00020\b¢\u0006\u0005\b\u0083\u0001\u0010\u0003J\u000f\u0010\u0084\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u0084\u0001\u0010\rJ7\u0010\u0086\u0001\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080F2\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u0006¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u000f\u0010\u0088\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0088\u0001\u0010$J\u000f\u0010\u0089\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0089\u0001\u0010$J\u000f\u0010\u008a\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u008a\u0001\u0010$J\u000f\u0010\u008b\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u008b\u0001\u0010\rJ\u000f\u0010\u008c\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u008c\u0001\u0010$J\u000f\u0010\u008d\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u008d\u0001\u0010$J\u000f\u0010\u008e\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u008e\u0001\u0010$J\u000f\u0010\u008f\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u008f\u0001\u0010$J\u0018\u0010\u0091\u0001\u001a\u00020\u00062\u0007\u0010\u0090\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0091\u0001\u0010\u0016J\u000f\u0010\u0092\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0092\u0001\u0010$J\u000f\u0010\u0093\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0093\u0001\u0010$J\u000f\u0010\u0094\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0094\u0001\u0010$J\u000f\u0010\u0095\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0095\u0001\u0010$J\u000f\u0010\u0096\u0001\u001a\u00020\u0006¢\u0006\u0005\b\u0096\u0001\u0010$J\u000f\u0010\u0097\u0001\u001a\u00020&¢\u0006\u0005\b\u0097\u0001\u0010cJ\u000f\u0010\u0098\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u0098\u0001\u0010\rJ\u000f\u0010\u0099\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u0099\u0001\u0010\rJ\u000f\u0010\u009a\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u009a\u0001\u0010\rJ\u000f\u0010\u009b\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u009b\u0001\u0010\rJ \u0010\u009d\u0001\u001a\u00020\u000b2\u000b\b\u0002\u0010\u009c\u0001\u001a\u0004\u0018\u00010&H\u0086@¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u000f\u0010\u009f\u0001\u001a\u00020\u000b¢\u0006\u0005\b\u009f\u0001\u0010\rJ\u000f\u0010 \u0001\u001a\u00020\u0004¢\u0006\u0005\b \u0001\u0010wJ\u000f\u0010¡\u0001\u001a\u00020\u000b¢\u0006\u0005\b¡\u0001\u0010\rJ\u000f\u0010¢\u0001\u001a\u00020\u000b¢\u0006\u0005\b¢\u0001\u0010\rJ\u001a\u0010¥\u0001\u001a\u00020\b2\b\u0010¤\u0001\u001a\u00030£\u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u0013\u0010§\u0001\u001a\u0005\u0018\u00010£\u0001¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001b\u0010ª\u0001\u001a\u00020\b2\u0007\u0010©\u0001\u001a\u00020\u0006H\u0086@¢\u0006\u0005\bª\u0001\u0010{J\u000f\u0010«\u0001\u001a\u00020\b¢\u0006\u0005\b«\u0001\u0010\u0003J#\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0F2\b\u0010\u00ad\u0001\u001a\u00030¬\u0001H\u0086@¢\u0006\u0006\b®\u0001\u0010¯\u0001J.\u0010°\u0001\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080FH\u0086@¢\u0006\u0005\b°\u0001\u0010>JQ\u0010´\u0001\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006080F2\u000b\b\u0002\u0010±\u0001\u001a\u0004\u0018\u00010\u00062\u000b\b\u0002\u0010²\u0001\u001a\u0004\u0018\u00010\u00062\t\b\u0002\u0010³\u0001\u001a\u00020\u000b¢\u0006\u0006\b´\u0001\u0010µ\u0001J\u001a\u0010¸\u0001\u001a\u00020\b2\b\u0010·\u0001\u001a\u00030¶\u0001¢\u0006\u0006\b¸\u0001\u0010¹\u0001J$\u0010»\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010¶\u00010F2\t\b\u0002\u0010º\u0001\u001a\u00020\u000b¢\u0006\u0006\b»\u0001\u0010¼\u0001J\"\u0010¿\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010¾\u00010F2\u0007\u0010½\u0001\u001a\u00020g¢\u0006\u0006\b¿\u0001\u0010À\u0001R$\u0010Å\u0001\u001a\r Â\u0001*\u0005\u0018\u00010Á\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0018\u0010É\u0001\u001a\u00030Æ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0016\u0010Î\u0001\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b3\u0010Í\u0001R\u0019\u0010Ñ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u0019\u0010Ô\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u0018\u0010Ö\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÕ\u0001\u0010KR\u0019\u0010Ø\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Í\u0001R\u0018\u0010Ú\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÙ\u0001\u0010KR\u0018\u0010Ü\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÛ\u0001\u0010KR\u0019\u0010Þ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Ð\u0001R\u0019\u0010à\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010Ð\u0001R\u001c\u0010ã\u0001\u001a\u0005\u0018\u00010£\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R\u0018\u0010å\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bä\u0001\u0010KR\u0018\u0010ç\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bæ\u0001\u0010KR\u0018\u0010ë\u0001\u001a\u00030è\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u001f\u0010î\u0001\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001a\u0010ò\u0001\u001a\u00030ï\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R\u001a\u0010ô\u0001\u001a\u00030ï\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010ñ\u0001R\u0019\u0010ö\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010Í\u0001R#\u0010û\u0001\u001a\u000e\u0012\t\u0012\u0007\u0012\u0002\b\u00030ø\u00010÷\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u0018\u0010ý\u0001\u001a\u00030ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bü\u0001\u0010ñ\u0001R\u001c\u0010\u0080\u0002\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010ÿ\u0001R\u0019\u0010\u0082\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0002\u0010Ð\u0001R\u0019\u0010\u0084\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0002\u0010Í\u0001R\u001b\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010Ð\u0001R\u0018\u0010\u0088\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0002\u0010KR\u0019\u0010\u008a\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010Ó\u0001R\u0019\u0010\u008c\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010Í\u0001R\u0019\u0010\u008e\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010Ó\u0001R\u0019\u0010\u0090\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010Ó\u0001R\u0019\u0010\u0092\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0002\u0010Í\u0001R\u0019\u0010\u0094\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0002\u0010Í\u0001R\u001c\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010\u0095\u0002R\u0019\u0010\u0096\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Í\u0001¨\u0006\u0097\u0002"}, d2 = {"Lx1/f1/lb/user/f;", "", "<init>", "()V", "", "errCode", "", "who", "Lr8/z;", "q1", "(ILjava/lang/String;)V", "", "W0", "()Z", "v1", "E1", "I1", "reasonResId", "dft", "F1", "clearPassword", "p1", "(Ljava/lang/String;)Ljava/lang/String;", "digitalCode", "contact", "reason", "Lx1/f1/lb/util/m;", "onLoginSuccessCallback", "Landroid/content/DialogInterface$OnCancelListener;", "onCancelListener", "Landroid/content/DialogInterface$OnDismissListener;", "onDismissListener", "G1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lx1/f1/lb/util/m;Landroid/content/DialogInterface$OnCancelListener;Landroid/content/DialogInterface$OnDismissListener;)V", "t1", "h0", "()Ljava/lang/String;", "U0", "", "ts", "Y0", "(Ljava/lang/Long;)Z", "X0", "", "Lz1/b1/lb/m/user/ServerResponse;", "z0", "()Ljava/util/List;", NotificationCompat.CATEGORY_MESSAGE, "l1", "(Ljava/lang/String;)V", "", "e", "L1", "(Ljava/lang/Throwable;)V", "K1", "Lkotlinx/coroutines/flow/g;", "Lr8/u;", "flowCollector", "F0", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "D1", "c1", "(Lv8/f;)Ljava/lang/Object;", "w1", "callback", "j1", "(Lx1/f1/lb/util/m;)V", "n1", "(I)Ljava/lang/String;", "isLoginByToken", "Lkotlinx/coroutines/flow/f;", "flow", "username", "password", "isLoginByUser", "Z", "(ZLkotlinx/coroutines/flow/f;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "i1", "(Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "h1", "()Lkotlinx/coroutines/flow/f;", "r1", "reasonCode", "Z0", "(Ljava/lang/String;I)V", "x1", "X", "()Ljava/lang/Integer;", "newPassword", "captchaCode", "u1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "actionType", "E0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "N0", "L0", "(Ljava/lang/String;)Z", "q0", "()J", "t0", "u0", "s0", "Ljava/io/File;", "fileInstallDir", "a1", "(Ljava/io/File;)V", "remindFlag", "B1", "(I)V", "C1", "z1", "d0", "e0", "Y", "o0", "m0", "l0", "w0", "()I", "code", "V0", "e1", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "s1", "d1", "verificationCode", "invitationCode", "b1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "o1", "P0", TypedValues.TransitionType.S_FROM, "m1", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "i0", "C0", "D0", "K0", "k0", "v0", "f0", "j0", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "g0", "b0", "y0", "B0", "A0", "c0", "n0", "M0", "G0", "O0", "I0", "timeoutMS", "Q0", "(Ljava/lang/Long;Lv8/f;)Ljava/lang/Object;", "T0", "r0", "S0", "J0", "Lz1/b1/lb/m/local/LocalSessionInfo;", "newLocalSessionInfo", "y1", "(Lz1/b1/lb/m/local/LocalSessionInfo;)V", "p0", "()Lz1/b1/lb/m/local/LocalSessionInfo;", "oldUid", "a0", "H0", "Lv6/c;", "playType", "J1", "(Lv6/c;Lv8/f;)Ljava/lang/Object;", "M1", "usernameParam", "passwordParam", "loginAsGuest", "f1", "(Ljava/lang/String;Ljava/lang/String;Z)Lkotlinx/coroutines/flow/f;", "Lz1/b1/lb/m/ptv/referral/ReferralSummary;", "referralSummary", "A1", "(Lz1/b1/lb/m/ptv/referral/ReferralSummary;)V", "isForce", "x0", "(Z)Lkotlinx/coroutines/flow/f;", "feedbackFile", "Lz1/b1/lb/m/feedback/FeedbackUploadResponse;", "N1", "(Ljava/io/File;)Lkotlinx/coroutines/flow/f;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Lkotlinx/coroutines/l0;", "c", "Lkotlinx/coroutines/l0;", "puckScope", "d", "Ljava/lang/Boolean;", "inStart", "J", "loginSession", "f", "Ljava/lang/String;", "did", "g", "I", "reLoginCnt", "h", "isInLogin", "i", "lastTryLoginTime", "j", "isAuthRetSuccess", "k", "isUpdateSessionFailed", "l", "markKey", "m", "mark", "n", "Lz1/b1/lb/m/local/LocalSessionInfo;", "localSessionInfo", "o", "isInLogout", "p", "isLocalSessionLoaded", "Ljava/util/concurrent/CountDownLatch;", "q", "Ljava/util/concurrent/CountDownLatch;", "localSessionCreatingCountDownLatch", "r", "Ljava/util/List;", "lastInitServerList", "Ljava/util/concurrent/atomic/AtomicBoolean;", "s", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isKickedOut", "t", "isSessionExpired", "u", "lastStreamTokenExpireTime", "Lx1/f1/lb/user/a;", "Lz1/b1/lb/m/ptv/ApiResponse;", "v", "Lx1/f1/lb/user/a;", "aaaAdapter", "w", "isEngineInStarting", "x", "Lv6/c;", "lastEPlayType", "y", "lastStartEngineUId", "z", "lastEngineStartTime", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "latestLoginRenewCode", "B", "isRenewCodeFirstLogin", "C", "isRemindAfterExpired", "D", "remindAfterExpiredLastRemindTime", ExifInterface.LONGITUDE_EAST, "isRemindPlanNotBindUsername", "F", "planWillExpireRemind", "G", "planWillExpireLastRemindTime", "H", "planWillExpireRemindTimeInStartup", "Lz1/b1/lb/m/ptv/referral/ReferralSummary;", "lastQueryReferralSummaryTime", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private static String latestLoginRenewCode;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private static long remindAfterExpiredLastRemindTime;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private static long planWillExpireLastRemindTime;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private static long planWillExpireRemindTimeInStartup;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private static ReferralSummary referralSummary;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private static long lastQueryReferralSummaryTime;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static Boolean inStart;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int reLoginCnt;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isInLogin;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static long lastTryLoginTime;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static boolean isAuthRetSuccess;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean isUpdateSessionFailed;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static LocalSessionInfo localSessionInfo;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static boolean isInLogout;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static boolean isLocalSessionLoaded;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private static long lastStreamTokenExpireTime;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private static v6.c lastEPlayType;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private static long lastEngineStartTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f21202a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static q6.b logger = q6.c.d(f.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final l0 puckScope = m0.a(a2.b(null, 1, null).plus(a1.b()));

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final long loginSession = d1.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static String did = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static String markKey = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static String mark = "";

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static final CountDownLatch localSessionCreatingCountDownLatch = new CountDownLatch(1);

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static List<? extends ServerResponse> lastInitServerList = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isKickedOut = new AtomicBoolean(false);

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isSessionExpired = new AtomicBoolean(false);

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private static final x1.f1.lb.user.a<ApiResponse<?>> aaaAdapter = x1.f1.lb.user.b.f21174a.d();

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isEngineInStarting = new AtomicBoolean(false);

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private static String lastStartEngineUId = "";

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private static boolean isRenewCodeFirstLogin = true;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private static int isRemindAfterExpired = 1;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private static int isRemindPlanNotBindUsername = 1;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private static int planWillExpireRemind = 24;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class a<T> implements kotlinx.coroutines.flow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f21229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f21230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21231d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f21232e;

        /* JADX INFO: renamed from: x1.f1.lb.user.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$execLoginFlow$2", f = "UserManager.kt", l = {1432, 1444, 1448, 1454, 1468, 1479, 1477, 1488, 1498}, m = "emit")
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0453a extends kotlin.coroutines.jvm.internal.d {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ a<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0453a(a<? super T> aVar, v8.f<? super C0453a> fVar) {
                super(fVar);
                this.this$0 = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, boolean z10, boolean z11, String str, String str2) {
            this.f21228a = gVar;
            this.f21229b = z10;
            this.f21230c = z11;
            this.f21231d = str;
            this.f21232e = str2;
        }

        /* JADX WARN: Code duplicated, block: B:54:0x0114  */
        /* JADX WARN: Code duplicated, block: B:57:0x0141  */
        /* JADX WARN: Code duplicated, block: B:78:0x01e3  */
        /* JADX WARN: Code duplicated, block: B:8:0x0014  */
        /* JADX WARN: Code restructure failed: missing block: B:111:0x02e7, code lost:
        
            if (r12.emit(r11, r8) == r0) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
        
            if (r12.emit(r11, r8) == r0) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x013d, code lost:
        
            if (r11.emit(r1, r8) == r0) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0176, code lost:
        
            if (kotlinx.coroutines.v0.a(r5, r8) == r0) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x01fb, code lost:
        
            if (r1.Z(r2, (kotlinx.coroutines.flow.f) r12, r4, r5, r6, r7, r8) == r0) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0242, code lost:
        
            if (r11.emit(r12, r8) == r0) goto L112;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0279, code lost:
        
            if (r11.F0(r12, r8) == r0) goto L112;
         */
        /* JADX WARN: Instruction removed from duplicated block: B:54:0x0114, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:57:0x0141, please report this as an issue */
        @Override // kotlinx.coroutines.flow.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
            C0453a c0453a;
            f fVar2;
            a<T> aVar;
            int i10;
            a<T> aVar2;
            r8.u<Boolean, Integer, String> uVar2;
            String str;
            if (fVar instanceof C0453a) {
                c0453a = (C0453a) fVar;
                int i11 = c0453a.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    c0453a.label = i11 - Integer.MIN_VALUE;
                } else {
                    c0453a = new C0453a(this, fVar);
                }
            } else {
                c0453a = new C0453a(this, fVar);
            }
            C0453a c0453a2 = c0453a;
            Object objI1 = c0453a2.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            switch (c0453a2.label) {
                case 0:
                    r8.r.b(objI1);
                    if (uVar.d().booleanValue()) {
                        if (f.f21202a.G0()) {
                            f.reLoginCnt = 0;
                        }
                        kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar = this.f21228a;
                        c0453a2.label = 1;
                        break;
                    } else {
                        String str2 = (this.f21229b ? "user" : "auto") + " login " + (this.f21230c ? "by token" : "by user[" + this.f21231d + "]");
                        Integer numE = uVar.e();
                        if (numE != null && numE.intValue() == -3) {
                            f.isInLogin = false;
                            String strF = uVar.f();
                            if (strF == null) {
                                strF = "Unknown";
                            }
                            f.f21202a.l1(strF);
                            kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar2 = this.f21228a;
                            c0453a2.L$0 = this;
                            c0453a2.L$1 = uVar;
                            c0453a2.L$2 = str2;
                            c0453a2.label = 2;
                            if (gVar2.emit(uVar, c0453a2) != objC) {
                                aVar2 = this;
                                uVar2 = uVar;
                                str = str2;
                                if (!aVar2.f21229b) {
                                    long jK0 = x1.f1.lb.heartbeat.f.f20678a.k0();
                                    f.logger.error(str + " failure, call api exception, will retry after " + jK0 + " ms", new Object[0]);
                                    c0453a2.L$0 = null;
                                    c0453a2.L$1 = null;
                                    c0453a2.L$2 = null;
                                    c0453a2.label = 4;
                                } else {
                                    f.logger.error(str + " failure, call api exception", new Object[0]);
                                    kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar3 = aVar2.f21228a;
                                    c0453a2.L$0 = null;
                                    c0453a2.L$1 = null;
                                    c0453a2.L$2 = null;
                                    c0453a2.label = 3;
                                }
                            }
                        } else if (!this.f21230c) {
                            f.isInLogin = false;
                            q6.b bVar = f.logger;
                            String str3 = this.f21232e;
                            bVar.error(str2 + " failure, " + ((str3 == null || str3.length() == 0) ? "password empty, " : "") + "api ret[" + ((Object) uVar.f()) + "]", new Object[0]);
                            LocalSessionInfo localSessionInfo = f.localSessionInfo;
                            if (localSessionInfo != null) {
                                localSessionInfo.setTriedLoginByUsernameFailure(true);
                            }
                            LocalSessionInfo localSessionInfo2 = f.localSessionInfo;
                            if (localSessionInfo2 != null) {
                                localSessionInfo2.setLoginFailureUsername(this.f21231d);
                            }
                            LocalSessionInfo localSessionInfo3 = f.localSessionInfo;
                            if (localSessionInfo3 != null) {
                                localSessionInfo3.setLoginFailurePassword(this.f21232e);
                            }
                            kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar4 = this.f21228a;
                            c0453a2.label = 9;
                        } else if (this.f21231d.length() <= 0) {
                            f.logger.error(str2 + " failure, api ret[" + ((Object) uVar.f()) + "], username empty, try guest login", new Object[0]);
                            f fVar3 = f.f21202a;
                            kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar5 = this.f21228a;
                            c0453a2.label = 8;
                        } else {
                            String str4 = this.f21232e;
                            if (str4 == null || str4.length() == 0) {
                                f.isInLogin = false;
                                f.logger.error(str2 + " failure, api ret[" + ((Object) uVar.f()) + "], password empty, return to UI", new Object[0]);
                                kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar6 = this.f21228a;
                                r8.u<Boolean, Integer, String> uVar3 = new r8.u<>(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-8), this.f21231d);
                                c0453a2.label = 5;
                            } else {
                                f.logger.error(str2 + " failure, api ret[" + ((Object) uVar.f()) + "], try login by[" + this.f21231d + "]", new Object[0]);
                                fVar2 = f.f21202a;
                                String str5 = this.f21231d;
                                String str6 = this.f21232e;
                                c0453a2.L$0 = this;
                                c0453a2.L$1 = fVar2;
                                c0453a2.I$0 = 0;
                                c0453a2.label = 6;
                                objI1 = fVar2.i1(str5, str6, c0453a2);
                                if (objI1 != objC) {
                                    aVar = this;
                                    i10 = 0;
                                    boolean z10 = i10 != 0;
                                    String str7 = aVar.f21231d;
                                    a<T> aVar3 = aVar;
                                    String str8 = aVar3.f21232e;
                                    boolean z11 = aVar3.f21229b;
                                    kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar7 = aVar3.f21228a;
                                    c0453a2.L$0 = null;
                                    c0453a2.L$1 = null;
                                    c0453a2.label = 7;
                                }
                            }
                        }
                        break;
                    }
                    return objC;
                case 1:
                    r8.r.b(objI1);
                    return r8.z.f17874a;
                case 2:
                    str = (String) c0453a2.L$2;
                    uVar2 = (r8.u) c0453a2.L$1;
                    aVar2 = (a) c0453a2.L$0;
                    r8.r.b(objI1);
                    if (!aVar2.f21229b) {
                        f.logger.error(str + " failure, call api exception", new Object[0]);
                        kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar8 = aVar2.f21228a;
                        c0453a2.L$0 = null;
                        c0453a2.L$1 = null;
                        c0453a2.L$2 = null;
                        c0453a2.label = 3;
                        break;
                    } else {
                        long jK1 = x1.f1.lb.heartbeat.f.f20678a.k0();
                        f.logger.error(str + " failure, call api exception, will retry after " + jK1 + " ms", new Object[0]);
                        c0453a2.L$0 = null;
                        c0453a2.L$1 = null;
                        c0453a2.L$2 = null;
                        c0453a2.label = 4;
                        break;
                    }
                    return objC;
                case 3:
                    r8.r.b(objI1);
                    return r8.z.f17874a;
                case 4:
                    r8.r.b(objI1);
                    f.k1(f.f21202a, null, 1, null);
                    return r8.z.f17874a;
                case 5:
                    r8.r.b(objI1);
                    return r8.z.f17874a;
                case 6:
                    i10 = c0453a2.I$0;
                    fVar2 = (f) c0453a2.L$1;
                    aVar = (a) c0453a2.L$0;
                    r8.r.b(objI1);
                    if (i10 != 0) {
                    }
                    String str9 = aVar.f21231d;
                    a<T> aVar4 = aVar;
                    String str10 = aVar4.f21232e;
                    boolean z12 = aVar4.f21229b;
                    kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar9 = aVar4.f21228a;
                    c0453a2.L$0 = null;
                    c0453a2.L$1 = null;
                    c0453a2.label = 7;
                    break;
                case 7:
                    r8.r.b(objI1);
                    return r8.z.f17874a;
                case 8:
                    r8.r.b(objI1);
                    return r8.z.f17874a;
                case 9:
                    r8.r.b(objI1);
                    return r8.z.f17874a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$startEngine$2", f = "UserManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class a0 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super Boolean>, v8.f<? super r8.z>, Object> {
        int label;

        a0(v8.f<? super a0> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new a0(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, v8.f<? super r8.z> fVar) {
            return ((a0) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Exception {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(obj);
            f.k1(f.f21202a, null, 1, null);
            throw new Exception("stream server list is empty");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager", f = "UserManager.kt", l = {PointerIconCompat.TYPE_HELP, PointerIconCompat.TYPE_CROSSHAIR}, m = "fireLoginComplete")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class b extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        b(v8.f<? super b> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.this.a0(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$startEngine$3", f = "UserManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlinx/coroutines/flow/f;", "<anonymous>", "(Z)Lkotlinx/coroutines/flow/f;"}, k = 3, mv = {2, 1, 0})
    static final class b0 extends kotlin.coroutines.jvm.internal.l implements c9.p<Boolean, v8.f<? super kotlinx.coroutines.flow.f<? extends Boolean>>, Object> {
        final /* synthetic */ int $deviceType;
        final /* synthetic */ List<ServerResponse> $list;
        final /* synthetic */ v6.c $playType;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$startEngine$3$1", f = "UserManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Boolean>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ v6.c $playType;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(v6.c cVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.$playType = cVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.$playType, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(obj);
                Throwable th = (Throwable) this.L$0;
                try {
                    f.f21202a.L1(th);
                    f.logger.error("init stream service failure playType[" + this.$playType + "]", th);
                    throw th;
                } catch (Throwable th2) {
                    f.isEngineInStarting.set(false);
                    throw th2;
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b implements kotlinx.coroutines.flow.f<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.f f21233a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ v6.c f21234b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f21235c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f21236d;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
            public static final class a<T> implements kotlinx.coroutines.flow.g {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.g f21237a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ v6.c f21238b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f21239c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f21240d;

                /* JADX INFO: renamed from: x1.f1.lb.user.f$b0$b$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$startEngine$3$invokeSuspend$$inlined$map$1$2", f = "UserManager.kt", l = {223}, m = "emit")
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                public static final class C0454a extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public C0454a(v8.f fVar) {
                        super(fVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return a.this.emit(null, this);
                    }
                }

                public a(kotlinx.coroutines.flow.g gVar, v6.c cVar, String str, List list) {
                    this.f21237a = gVar;
                    this.f21238b = cVar;
                    this.f21239c = str;
                    this.f21240d = list;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.g
                public final Object emit(Object obj, v8.f fVar) {
                    C0454a c0454a;
                    if (fVar instanceof C0454a) {
                        c0454a = (C0454a) fVar;
                        int i10 = c0454a.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            c0454a.label = i10 - Integer.MIN_VALUE;
                        } else {
                            c0454a = new C0454a(fVar);
                        }
                    } else {
                        c0454a = new C0454a(fVar);
                    }
                    Object obj2 = c0454a.result;
                    Object objC = kotlin.coroutines.intrinsics.b.c();
                    int i11 = c0454a.label;
                    if (i11 == 0) {
                        r8.r.b(obj2);
                        kotlinx.coroutines.flow.g gVar = this.f21237a;
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        try {
                            if (zBooleanValue) {
                                f fVar2 = f.f21202a;
                                f.lastEngineStartTime = d1.c();
                                f.lastEPlayType = this.f21238b;
                                f.lastStartEngineUId = this.f21239c;
                                f.lastInitServerList = this.f21240d;
                                tf.e eVarE = x1.f1.lb.metric.monitor.h.f20952a.e();
                                if (eVarE != null) {
                                    eVarE.l(d1.c());
                                }
                                f.logger.a("init stream service complete, engine is started, playType[" + this.f21238b + "]", new Object[0]);
                            } else {
                                f.logger.warn("init stream service complete, engine is not started, playType[" + this.f21238b + "]", new Object[0]);
                            }
                            f.isEngineInStarting.set(false);
                            Boolean boolA = kotlin.coroutines.jvm.internal.b.a(zBooleanValue);
                            c0454a.label = 1;
                            if (gVar.emit(boolA, c0454a) == objC) {
                                return objC;
                            }
                        } catch (Throwable th) {
                            f.isEngineInStarting.set(false);
                            throw th;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r8.r.b(obj2);
                    }
                    return r8.z.f17874a;
                }
            }

            public b(kotlinx.coroutines.flow.f fVar, v6.c cVar, String str, List list) {
                this.f21233a = fVar;
                this.f21234b = cVar;
                this.f21235c = str;
                this.f21236d = list;
            }

            @Override // kotlinx.coroutines.flow.f
            public Object collect(kotlinx.coroutines.flow.g<? super Boolean> gVar, v8.f fVar) {
                Object objCollect = this.f21233a.collect(new a(gVar, this.f21234b, this.f21235c, this.f21236d), fVar);
                return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b0(List<? extends ServerResponse> list, String str, int i10, v6.c cVar, v8.f<? super b0> fVar) {
            super(2, fVar);
            this.$list = list;
            this.$uid = str;
            this.$deviceType = i10;
            this.$playType = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new b0(this.$list, this.$uid, this.$deviceType, this.$playType, fVar);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, v8.f<? super kotlinx.coroutines.flow.f<? extends Boolean>> fVar) {
            return b(bool.booleanValue(), fVar);
        }

        public final Object b(boolean z10, v8.f<? super kotlinx.coroutines.flow.f<Boolean>> fVar) {
            return ((b0) create(Boolean.valueOf(z10), fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                tf.e eVarE = x1.f1.lb.metric.monitor.h.f20952a.e();
                if (eVarE != null) {
                    eVarE.n(d1.c());
                }
                String strW = new com.google.gson.e().w(this.$list);
                x1.f1.lb.streaming.client.a aVar = x1.f1.lb.streaming.client.a.f21004a;
                kotlin.jvm.internal.m.c(strW);
                f fVar = f.f21202a;
                return new b(kotlinx.coroutines.flow.h.f(aVar.h(strW, fVar.A0(), this.$uid, fVar.j0(), String.valueOf(of.a.f16585a.h()), this.$deviceType, this.$playType), new a(this.$playType, null)), this.$playType, this.$uid, this.$list);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$fireLoginComplete$2", f = "UserManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lz1/b1/lb/m/ptv/referral/ReferralSummary;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super ReferralSummary>, Throwable, v8.f<? super r8.z>, Object> {
        /* synthetic */ Object L$0;
        int label;

        c(v8.f<? super c> fVar) {
            super(3, fVar);
        }

        @Override // c9.q
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(kotlinx.coroutines.flow.g<? super ReferralSummary> gVar, Throwable th, v8.f<? super r8.z> fVar) {
            c cVar = new c(fVar);
            cVar.L$0 = th;
            return cVar.invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                f.logger.a("init referral summary failure", (Throwable) this.L$0);
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c0 implements kotlinx.coroutines.flow.f<r8.u<? extends Boolean, ? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f21241a;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        public static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f21242a;

            /* JADX INFO: renamed from: x1.f1.lb.user.f$c0$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$updateSession$$inlined$map$1$2", f = "UserManager.kt", l = {230, 223}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class C0455a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0455a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(kotlinx.coroutines.flow.g gVar) {
                this.f21242a = gVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
            
                if (r15.emit(r14, r0) == r1) goto L26;
             */
            @Override // kotlinx.coroutines.flow.g
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Object obj, v8.f fVar) {
                C0455a c0455a;
                kotlinx.coroutines.flow.g gVar;
                kotlinx.coroutines.flow.g gVar2;
                Object obj2;
                if (fVar instanceof C0455a) {
                    c0455a = (C0455a) fVar;
                    int i10 = c0455a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0455a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0455a = new C0455a(fVar);
                    }
                } else {
                    c0455a = new C0455a(fVar);
                }
                Object obj3 = c0455a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0455a.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        kotlinx.coroutines.flow.g gVar3 = (kotlinx.coroutines.flow.g) c0455a.L$0;
                        r8.r.b(obj3);
                        gVar = gVar3;
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r8.r.b(obj3);
                    }
                    return r8.z.f17874a;
                }
                r8.r.b(obj3);
                kotlinx.coroutines.flow.g gVar4 = this.f21242a;
                r8.u uVar = (r8.u) obj;
                if (((Boolean) uVar.d()).booleanValue()) {
                    f.isUpdateSessionFailed = false;
                    obj2 = uVar;
                    gVar2 = gVar4;
                    c0455a.L$0 = null;
                    c0455a.label = 2;
                } else {
                    f.isAuthRetSuccess = false;
                    f.isUpdateSessionFailed = true;
                    kotlinx.coroutines.flow.f fVarG1 = f.g1(f.f21202a, null, null, false, 7, null);
                    c0455a.L$0 = gVar4;
                    c0455a.label = 1;
                    Object objS = kotlinx.coroutines.flow.h.s(fVarG1, c0455a);
                    if (objS != objC) {
                        obj3 = objS;
                        gVar = gVar4;
                    }
                }
                return objC;
                Object obj4 = obj3;
                gVar2 = gVar;
                obj2 = obj4;
                c0455a.L$0 = null;
                c0455a.label = 2;
            }
        }

        public c0(kotlinx.coroutines.flow.f fVar) {
            this.f21241a = fVar;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f fVar) {
            Object objCollect = this.f21241a.collect(new a(gVar), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class d<T> implements kotlinx.coroutines.flow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f21243a = new d<>();

        @Override // kotlinx.coroutines.flow.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(ReferralSummary referralSummary, v8.f<? super r8.z> fVar) {
            return r8.z.f17874a;
        }

        d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager", f = "UserManager.kt", l = {1258}, m = "updateSession")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class d0 extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        d0(v8.f<? super d0> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.this.M1(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$getReferralSummary$1", f = "UserManager.kt", l = {1608, 1608}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lz1/b1/lb/m/ptv/referral/ReferralSummary;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super ReferralSummary>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ boolean $isForce;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<ReferralSummary> f21244a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f21245b;

            /* JADX WARN: Multi-variable type inference failed */
            a(kotlinx.coroutines.flow.g<? super ReferralSummary> gVar, boolean z10) {
                this.f21244a = gVar;
                this.f21245b = z10;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) throws Exception {
                if (uVar.d().booleanValue()) {
                    Object objEmit = this.f21244a.emit(f.referralSummary, fVar);
                    if (objEmit == kotlin.coroutines.intrinsics.b.c()) {
                        return objEmit;
                    }
                    return r8.z.f17874a;
                }
                if (!this.f21245b && f.referralSummary != null) {
                    Object objEmit2 = this.f21244a.emit(f.referralSummary, fVar);
                    if (objEmit2 == kotlin.coroutines.intrinsics.b.c()) {
                        return objEmit2;
                    }
                    return r8.z.f17874a;
                }
                throw new Exception(uVar.f());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(boolean z10, v8.f<? super e> fVar) {
            super(2, fVar);
            this.$isForce = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            e eVar = new e(this.$isForce, fVar);
            eVar.L$0 = obj;
            return eVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super ReferralSummary> gVar, v8.f<? super r8.z> fVar) {
            return ((e) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (((kotlinx.coroutines.flow.f) r6).collect(r3, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            gVar = (kotlinx.coroutines.flow.g) this.L$0;
            x1.f1.lb.user.a aVar = f.aaaAdapter;
            this.L$0 = gVar;
            this.label = 1;
            obj = aVar.k(this);
            if (obj != objC) {
            }
            return objC;
            a aVar2 = new a(gVar, this.$isForce);
            this.L$0 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$uploadFeedbackFile$1", f = "UserManager.kt", l = {1629, 1629}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lz1/b1/lb/m/feedback/FeedbackUploadResponse;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class e0 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super FeedbackUploadResponse>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ File $feedbackFile;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e0(File file, v8.f<? super e0> fVar) {
            super(2, fVar);
            this.$feedbackFile = file;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            e0 e0Var = new e0(this.$feedbackFile, fVar);
            e0Var.L$0 = obj;
            return e0Var;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super FeedbackUploadResponse> gVar, v8.f<? super r8.z> fVar) {
            return ((e0) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        
            if (r1.emit(r6, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            gVar = (kotlinx.coroutines.flow.g) this.L$0;
            x1.f1.lb.user.a aVar = f.aaaAdapter;
            File file = this.$feedbackFile;
            this.L$0 = gVar;
            this.label = 1;
            obj = aVar.h(file, this);
            if (obj != objC) {
            }
            return objC;
            this.L$0 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.user.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager", f = "UserManager.kt", l = {1148, 1151}, m = "guestLogin")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class C0456f extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C0456f(v8.f<? super C0456f> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.this.F0(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$guestLogin$2", f = "UserManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
        /* synthetic */ Object L$0;
        int label;

        g(v8.f<? super g> fVar) {
            super(3, fVar);
        }

        @Override // c9.q
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
            g gVar2 = new g(fVar);
            gVar2.L$0 = th;
            return gVar2.invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(obj);
            Throwable th = (Throwable) this.L$0;
            f.isInLogin = false;
            throw th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class h<T> implements kotlinx.coroutines.flow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21246a;

        @Override // kotlinx.coroutines.flow.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
            f.isInLogin = false;
            Integer numE = uVar.e();
            if (numE != null && numE.intValue() == -3) {
                String strF = uVar.f();
                if (strF == null) {
                    strF = "Unknown";
                }
                f.f21202a.l1(strF);
                f.logger.error("Guest login failure: " + strF, new Object[0]);
            }
            kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar = this.f21246a;
            if (gVar == null) {
                return r8.z.f17874a;
            }
            Object objEmit = gVar.emit(uVar, fVar);
            return objEmit == kotlin.coroutines.intrinsics.b.c() ? objEmit : r8.z.f17874a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        h(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar) {
            this.f21246a = gVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager", f = "UserManager.kt", l = {TypedValues.Custom.TYPE_REFERENCE}, m = "isInitComplete")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class i extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        i(v8.f<? super i> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.this.Q0(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$isInitComplete$2", f = "UserManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "", "<anonymous>", "(Lkotlinx/coroutines/l0;)Z"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super Boolean>, Object> {
        int label;

        j(v8.f<? super j> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new j(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super Boolean> fVar) {
            return ((j) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(f.localSessionCreatingCountDownLatch.await(15L, TimeUnit.SECONDS));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$launch$1", f = "UserManager.kt", l = {315, 322, 324, 325, 327, 329, 331, 336}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class k extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ File $fileInstallDir;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(File file, v8.f<? super k> fVar) {
            super(2, fVar);
            this.$fileInstallDir = file;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new k(this.$fileInstallDir, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((k) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0070  */
        /* JADX WARN: Code duplicated, block: B:26:0x0098 A[PHI: r6
          0x0098: PHI (r6v15 java.lang.Object) = (r6v13 java.lang.Object), (r6v0 java.lang.Object) binds: [B:24:0x0094, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:29:0x00b0 A[PHI: r6
          0x00b0: PHI (r6v19 java.lang.Object) = (r6v18 java.lang.Object), (r6v0 java.lang.Object) binds: [B:27:0x00ac, B:11:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:32:0x00cc A[PHI: r6
          0x00cc: PHI (r6v24 java.lang.Object) = (r6v23 java.lang.Object), (r6v0 java.lang.Object) binds: [B:30:0x00c8, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:35:0x00e7 A[PHI: r6
          0x00e7: PHI (r6v28 java.lang.Object) = (r6v27 java.lang.Object), (r6v0 java.lang.Object) binds: [B:33:0x00e4, B:9:0x0021] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:38:0x0102 A[PHI: r6
          0x0102: PHI (r6v33 java.lang.Object) = (r6v32 java.lang.Object), (r6v0 java.lang.Object) binds: [B:36:0x00ff, B:8:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:41:0x011d A[PHI: r6
          0x011d: PHI (r6v38 java.lang.Object) = (r6v37 java.lang.Object), (r6v0 java.lang.Object) binds: [B:39:0x011a, B:7:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:43:0x012c  */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x013d, code lost:
        
            if (r6.c1(r5) == r0) goto L46;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            switch (this.label) {
                case 0:
                    r8.r.b(obj);
                    tf.e eVarB = x1.f1.lb.metric.monitor.h.f20952a.b();
                    if (eVarB != null) {
                        eVarB.y(f.loginSession);
                    }
                    f fVar = f.f21202a;
                    x1.f1.lb.id.a aVar = x1.f1.lb.id.a.f20725a;
                    File file = this.$fileInstallDir;
                    this.label = 1;
                    obj = aVar.c(file, this);
                    if (obj != objC) {
                        f.did = (String) obj;
                        x1.f1.lb.util.z.f21470a.B(f.did);
                        if (x1.f1.lb.config.b.f20643a.t()) {
                            f.logger.debug("did[{}]", f.did);
                        }
                        f.f21202a.s0();
                        w0 w0Var = w0.f21452a;
                        this.label = 2;
                        obj = w0Var.m("latest_login_renew_code_in_um", "", this);
                        if (obj != objC) {
                            f.latestLoginRenewCode = (String) obj;
                            w0 w0Var2 = w0.f21452a;
                            int i10 = f.isRemindAfterExpired;
                            this.label = 3;
                            obj = w0Var2.h("um_is_remind_after_plan_expired", i10, this);
                            if (obj != objC) {
                                f.isRemindAfterExpired = ((Number) obj).intValue();
                                w0 w0Var3 = w0.f21452a;
                                long j10 = f.remindAfterExpiredLastRemindTime;
                                this.label = 4;
                                obj = w0Var3.j("um_plan_last_remind_time", j10, this);
                                if (obj != objC) {
                                    f.remindAfterExpiredLastRemindTime = ((Number) obj).longValue();
                                    w0 w0Var4 = w0.f21452a;
                                    int i11 = f.isRemindPlanNotBindUsername;
                                    this.label = 5;
                                    obj = w0Var4.h("um_is_remind_plan_not_bind_username", i11, this);
                                    if (obj != objC) {
                                        f.isRemindPlanNotBindUsername = ((Number) obj).intValue();
                                        w0 w0Var5 = w0.f21452a;
                                        int i12 = f.planWillExpireRemind;
                                        this.label = 6;
                                        obj = w0Var5.h("um_plan_will_expire_remind", i12, this);
                                        if (obj != objC) {
                                            f.planWillExpireRemind = ((Number) obj).intValue();
                                            w0 w0Var6 = w0.f21452a;
                                            long j11 = f.planWillExpireLastRemindTime;
                                            this.label = 7;
                                            obj = w0Var6.j("um_plan_will_expire_last_remind_time", j11, this);
                                            if (obj != objC) {
                                                f.planWillExpireRemindTimeInStartup = ((Number) obj).longValue();
                                                if (f.planWillExpireRemind > 1) {
                                                    f.planWillExpireLastRemindTime = f.planWillExpireRemindTimeInStartup;
                                                }
                                                f fVar2 = f.f21202a;
                                                this.label = 8;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return objC;
                case 1:
                    r8.r.b(obj);
                    f.did = (String) obj;
                    x1.f1.lb.util.z.f21470a.B(f.did);
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        f.logger.debug("did[{}]", f.did);
                    }
                    f.f21202a.s0();
                    w0 w0Var7 = w0.f21452a;
                    this.label = 2;
                    obj = w0Var7.m("latest_login_renew_code_in_um", "", this);
                    if (obj != objC) {
                        f.latestLoginRenewCode = (String) obj;
                        w0 w0Var8 = w0.f21452a;
                        int i13 = f.isRemindAfterExpired;
                        this.label = 3;
                        obj = w0Var8.h("um_is_remind_after_plan_expired", i13, this);
                        if (obj != objC) {
                            f.isRemindAfterExpired = ((Number) obj).intValue();
                            w0 w0Var9 = w0.f21452a;
                            long j12 = f.remindAfterExpiredLastRemindTime;
                            this.label = 4;
                            obj = w0Var9.j("um_plan_last_remind_time", j12, this);
                            if (obj != objC) {
                                f.remindAfterExpiredLastRemindTime = ((Number) obj).longValue();
                                w0 w0Var10 = w0.f21452a;
                                int i14 = f.isRemindPlanNotBindUsername;
                                this.label = 5;
                                obj = w0Var10.h("um_is_remind_plan_not_bind_username", i14, this);
                                if (obj != objC) {
                                    f.isRemindPlanNotBindUsername = ((Number) obj).intValue();
                                    w0 w0Var11 = w0.f21452a;
                                    int i15 = f.planWillExpireRemind;
                                    this.label = 6;
                                    obj = w0Var11.h("um_plan_will_expire_remind", i15, this);
                                    if (obj != objC) {
                                        f.planWillExpireRemind = ((Number) obj).intValue();
                                        w0 w0Var12 = w0.f21452a;
                                        long j13 = f.planWillExpireLastRemindTime;
                                        this.label = 7;
                                        obj = w0Var12.j("um_plan_will_expire_last_remind_time", j13, this);
                                        if (obj != objC) {
                                            f.planWillExpireRemindTimeInStartup = ((Number) obj).longValue();
                                            if (f.planWillExpireRemind > 1) {
                                                f.planWillExpireLastRemindTime = f.planWillExpireRemindTimeInStartup;
                                            }
                                            f fVar3 = f.f21202a;
                                            this.label = 8;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return objC;
                case 2:
                    r8.r.b(obj);
                    f.latestLoginRenewCode = (String) obj;
                    w0 w0Var13 = w0.f21452a;
                    int i16 = f.isRemindAfterExpired;
                    this.label = 3;
                    obj = w0Var13.h("um_is_remind_after_plan_expired", i16, this);
                    if (obj != objC) {
                        f.isRemindAfterExpired = ((Number) obj).intValue();
                        w0 w0Var14 = w0.f21452a;
                        long j14 = f.remindAfterExpiredLastRemindTime;
                        this.label = 4;
                        obj = w0Var14.j("um_plan_last_remind_time", j14, this);
                        if (obj != objC) {
                            f.remindAfterExpiredLastRemindTime = ((Number) obj).longValue();
                            w0 w0Var15 = w0.f21452a;
                            int i17 = f.isRemindPlanNotBindUsername;
                            this.label = 5;
                            obj = w0Var15.h("um_is_remind_plan_not_bind_username", i17, this);
                            if (obj != objC) {
                                f.isRemindPlanNotBindUsername = ((Number) obj).intValue();
                                w0 w0Var16 = w0.f21452a;
                                int i18 = f.planWillExpireRemind;
                                this.label = 6;
                                obj = w0Var16.h("um_plan_will_expire_remind", i18, this);
                                if (obj != objC) {
                                    f.planWillExpireRemind = ((Number) obj).intValue();
                                    w0 w0Var17 = w0.f21452a;
                                    long j15 = f.planWillExpireLastRemindTime;
                                    this.label = 7;
                                    obj = w0Var17.j("um_plan_will_expire_last_remind_time", j15, this);
                                    if (obj != objC) {
                                        f.planWillExpireRemindTimeInStartup = ((Number) obj).longValue();
                                        if (f.planWillExpireRemind > 1) {
                                            f.planWillExpireLastRemindTime = f.planWillExpireRemindTimeInStartup;
                                        }
                                        f fVar4 = f.f21202a;
                                        this.label = 8;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return objC;
                case 3:
                    r8.r.b(obj);
                    f.isRemindAfterExpired = ((Number) obj).intValue();
                    w0 w0Var18 = w0.f21452a;
                    long j16 = f.remindAfterExpiredLastRemindTime;
                    this.label = 4;
                    obj = w0Var18.j("um_plan_last_remind_time", j16, this);
                    if (obj != objC) {
                        f.remindAfterExpiredLastRemindTime = ((Number) obj).longValue();
                        w0 w0Var19 = w0.f21452a;
                        int i19 = f.isRemindPlanNotBindUsername;
                        this.label = 5;
                        obj = w0Var19.h("um_is_remind_plan_not_bind_username", i19, this);
                        if (obj != objC) {
                            f.isRemindPlanNotBindUsername = ((Number) obj).intValue();
                            w0 w0Var110 = w0.f21452a;
                            int i110 = f.planWillExpireRemind;
                            this.label = 6;
                            obj = w0Var110.h("um_plan_will_expire_remind", i110, this);
                            if (obj != objC) {
                                f.planWillExpireRemind = ((Number) obj).intValue();
                                w0 w0Var111 = w0.f21452a;
                                long j17 = f.planWillExpireLastRemindTime;
                                this.label = 7;
                                obj = w0Var111.j("um_plan_will_expire_last_remind_time", j17, this);
                                if (obj != objC) {
                                    f.planWillExpireRemindTimeInStartup = ((Number) obj).longValue();
                                    if (f.planWillExpireRemind > 1) {
                                        f.planWillExpireLastRemindTime = f.planWillExpireRemindTimeInStartup;
                                    }
                                    f fVar5 = f.f21202a;
                                    this.label = 8;
                                }
                            }
                        }
                        break;
                    }
                    return objC;
                case 4:
                    r8.r.b(obj);
                    f.remindAfterExpiredLastRemindTime = ((Number) obj).longValue();
                    w0 w0Var112 = w0.f21452a;
                    int i111 = f.isRemindPlanNotBindUsername;
                    this.label = 5;
                    obj = w0Var112.h("um_is_remind_plan_not_bind_username", i111, this);
                    if (obj != objC) {
                        f.isRemindPlanNotBindUsername = ((Number) obj).intValue();
                        w0 w0Var113 = w0.f21452a;
                        int i112 = f.planWillExpireRemind;
                        this.label = 6;
                        obj = w0Var113.h("um_plan_will_expire_remind", i112, this);
                        if (obj != objC) {
                            f.planWillExpireRemind = ((Number) obj).intValue();
                            w0 w0Var114 = w0.f21452a;
                            long j18 = f.planWillExpireLastRemindTime;
                            this.label = 7;
                            obj = w0Var114.j("um_plan_will_expire_last_remind_time", j18, this);
                            if (obj != objC) {
                                f.planWillExpireRemindTimeInStartup = ((Number) obj).longValue();
                                if (f.planWillExpireRemind > 1) {
                                    f.planWillExpireLastRemindTime = f.planWillExpireRemindTimeInStartup;
                                }
                                f fVar6 = f.f21202a;
                                this.label = 8;
                            }
                        }
                        break;
                    }
                    return objC;
                case 5:
                    r8.r.b(obj);
                    f.isRemindPlanNotBindUsername = ((Number) obj).intValue();
                    w0 w0Var115 = w0.f21452a;
                    int i113 = f.planWillExpireRemind;
                    this.label = 6;
                    obj = w0Var115.h("um_plan_will_expire_remind", i113, this);
                    if (obj != objC) {
                        f.planWillExpireRemind = ((Number) obj).intValue();
                        w0 w0Var116 = w0.f21452a;
                        long j19 = f.planWillExpireLastRemindTime;
                        this.label = 7;
                        obj = w0Var116.j("um_plan_will_expire_last_remind_time", j19, this);
                        if (obj != objC) {
                            f.planWillExpireRemindTimeInStartup = ((Number) obj).longValue();
                            if (f.planWillExpireRemind > 1) {
                                f.planWillExpireLastRemindTime = f.planWillExpireRemindTimeInStartup;
                            }
                            f fVar7 = f.f21202a;
                            this.label = 8;
                        }
                        break;
                    }
                    return objC;
                case 6:
                    r8.r.b(obj);
                    f.planWillExpireRemind = ((Number) obj).intValue();
                    w0 w0Var117 = w0.f21452a;
                    long j110 = f.planWillExpireLastRemindTime;
                    this.label = 7;
                    obj = w0Var117.j("um_plan_will_expire_last_remind_time", j110, this);
                    if (obj != objC) {
                        f.planWillExpireRemindTimeInStartup = ((Number) obj).longValue();
                        if (f.planWillExpireRemind > 1) {
                            f.planWillExpireLastRemindTime = f.planWillExpireRemindTimeInStartup;
                        }
                        f fVar8 = f.f21202a;
                        this.label = 8;
                        break;
                    }
                    return objC;
                case 7:
                    r8.r.b(obj);
                    f.planWillExpireRemindTimeInStartup = ((Number) obj).longValue();
                    if (f.planWillExpireRemind > 1) {
                        f.planWillExpireLastRemindTime = f.planWillExpireRemindTimeInStartup;
                    }
                    f fVar9 = f.f21202a;
                    this.label = 8;
                    break;
                case 8:
                    r8.r.b(obj);
                    return r8.z.f17874a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager", f = "UserManager.kt", l = {1179}, m = "loadLocalSessionInfo")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class l extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        l(v8.f<? super l> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.this.c1(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class n implements kotlinx.coroutines.flow.f<r8.u<? extends Boolean, ? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f21247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21248b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        public static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f21249a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f21250b;

            /* JADX INFO: renamed from: x1.f1.lb.user.f$n$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$login$$inlined$map$1$2", f = "UserManager.kt", l = {223}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class C0457a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0457a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(kotlinx.coroutines.flow.g gVar, String str) {
                this.f21249a = gVar;
                this.f21250b = str;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            public final Object emit(Object obj, v8.f fVar) {
                C0457a c0457a;
                boolean z10;
                if (fVar instanceof C0457a) {
                    c0457a = (C0457a) fVar;
                    int i10 = c0457a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0457a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0457a = new C0457a(fVar);
                    }
                } else {
                    c0457a = new C0457a(fVar);
                }
                Object obj2 = c0457a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0457a.label;
                if (i11 == 0) {
                    r8.r.b(obj2);
                    kotlinx.coroutines.flow.g gVar = this.f21249a;
                    r8.u uVar = (r8.u) obj;
                    if (((Boolean) uVar.d()).booleanValue()) {
                        if (kotlin.jvm.internal.m.a(f.latestLoginRenewCode, this.f21250b)) {
                            z10 = false;
                        } else {
                            w0.f21452a.t("latest_login_renew_code_in_um", this.f21250b);
                            f.latestLoginRenewCode = this.f21250b;
                            z10 = true;
                        }
                        f.isRenewCodeFirstLogin = z10;
                    }
                    c0457a.label = 1;
                    if (gVar.emit(uVar, c0457a) == objC) {
                        return objC;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj2);
                }
                return r8.z.f17874a;
            }
        }

        public n(kotlinx.coroutines.flow.f fVar, String str) {
            this.f21247a = fVar;
            this.f21248b = str;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f fVar) {
            Object objCollect = this.f21247a.collect(new a(gVar, this.f21248b), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class o implements kotlinx.coroutines.flow.f<r8.u<? extends Boolean, ? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f21251a;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        public static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f21252a;

            /* JADX INFO: renamed from: x1.f1.lb.user.f$o$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$login$$inlined$map$2$2", f = "UserManager.kt", l = {223}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class C0458a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0458a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(kotlinx.coroutines.flow.g gVar) {
                this.f21252a = gVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            public final Object emit(Object obj, v8.f fVar) {
                C0458a c0458a;
                if (fVar instanceof C0458a) {
                    c0458a = (C0458a) fVar;
                    int i10 = c0458a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0458a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0458a = new C0458a(fVar);
                    }
                } else {
                    c0458a = new C0458a(fVar);
                }
                Object obj2 = c0458a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0458a.label;
                if (i11 == 0) {
                    r8.r.b(obj2);
                    kotlinx.coroutines.flow.g gVar = this.f21252a;
                    r8.u uVar = (r8.u) obj;
                    if (((Boolean) uVar.d()).booleanValue()) {
                        f.isUpdateSessionFailed = false;
                    }
                    c0458a.label = 1;
                    if (gVar.emit(uVar, c0458a) == objC) {
                        return objC;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj2);
                }
                return r8.z.f17874a;
            }
        }

        public o(kotlinx.coroutines.flow.f fVar) {
            this.f21251a = fVar;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f fVar) {
            Object objCollect = this.f21251a.collect(new a(gVar), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager", f = "UserManager.kt", l = {554}, m = "login")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class p extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        p(v8.f<? super p> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.this.e1(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$login$4", f = "UserManager.kt", l = {1272, 1286, 1302, 1307, 1307}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class q extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ boolean $loginAsGuest;
        final /* synthetic */ String $passwordParam;
        final /* synthetic */ String $usernameParam;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21253a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f21254b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ boolean f21255c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f21256d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f21257e;

            /* JADX INFO: renamed from: x1.f1.lb.user.f$q$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$login$4$1", f = "UserManager.kt", l = {1310, 1316, 1322, 1328, 1336, 1336, 1351, 1360, 1367, 1365, 1374}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class C0459a extends kotlin.coroutines.jvm.internal.d {
                int I$0;
                Object L$0;
                Object L$1;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ a<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0459a(a<? super T> aVar, v8.f<? super C0459a> fVar) {
                    super(fVar);
                    this.this$0 = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            a(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, boolean z10, boolean z11, String str, String str2) {
                this.f21253a = gVar;
                this.f21254b = z10;
                this.f21255c = z11;
                this.f21256d = str;
                this.f21257e = str2;
            }

            /* JADX WARN: Code duplicated, block: B:109:0x01ea  */
            /* JADX WARN: Code duplicated, block: B:69:0x011e  */
            /* JADX WARN: Code duplicated, block: B:8:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:111:0x0203, code lost:
            
                if (r1.Z(r3, (kotlinx.coroutines.flow.f) r13, r4, r5, false, r7, r8) == r0) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:119:0x026c, code lost:
            
                if (r13.emit(r1, r8) == r0) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
            
                if (r13.emit(r12, r8) == r0) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x00b9, code lost:
            
                if (r13.emit(r12, r8) == r0) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x00da, code lost:
            
                if (r12.F0(r1, r8) == r0) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x00f2, code lost:
            
                if (r12.F0(r13, r8) == r0) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:71:0x0136, code lost:
            
                if (r1.Z(r3, (kotlinx.coroutines.flow.f) r13, r4, r5, true, r7, r8) == r0) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:85:0x0167, code lost:
            
                if (r1.Z(true, r3, r4, r5, false, r7, r8) == r0) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:95:0x01bd, code lost:
            
                if (r1.F0(r12, r8) == r0) goto L120;
             */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                C0459a c0459a;
                f fVar2;
                a<T> aVar;
                int i10;
                a<T> aVar2;
                int i11;
                boolean z10;
                if (fVar instanceof C0459a) {
                    c0459a = (C0459a) fVar;
                    int i12 = c0459a.label;
                    if ((i12 & Integer.MIN_VALUE) != 0) {
                        c0459a.label = i12 - Integer.MIN_VALUE;
                    } else {
                        c0459a = new C0459a(this, fVar);
                    }
                } else {
                    c0459a = new C0459a(this, fVar);
                }
                C0459a c0459a2 = c0459a;
                Object objI1 = c0459a2.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                switch (c0459a2.label) {
                    case 0:
                        r8.r.b(objI1);
                        Integer numE = uVar.e();
                        if (numE != null && numE.intValue() == -8) {
                            f.isInLogin = false;
                            kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar = this.f21253a;
                            c0459a2.label = 1;
                            break;
                        } else {
                            Integer numE2 = uVar.e();
                            if (numE2 == null || numE2.intValue() != 0) {
                                f.isInLogin = false;
                                kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar2 = this.f21253a;
                                c0459a2.label = 2;
                            } else if (this.f21254b) {
                                LocalSessionInfo localSessionInfo = f.localSessionInfo;
                                if (localSessionInfo != null) {
                                    localSessionInfo.setLastUsername("");
                                }
                                f fVar3 = f.f21202a;
                                kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar3 = this.f21253a;
                                c0459a2.label = 3;
                            } else if (f.localSessionInfo != null) {
                                fVar2 = f.f21202a;
                                boolean zU0 = fVar2.U0();
                                if (!this.f21255c) {
                                    int iR0 = fVar2.r0();
                                    boolean z11 = (!fVar2.T0() || iR0 == 3 || iR0 == 5) ? false : true;
                                    if (zU0 || z11) {
                                        String str = z11 ? "logout(" + fVar2.n1(iR0) + ")" : "refresh token is expired";
                                        if (this.f21256d.length() == 0) {
                                            f.logger.error("system auto login, username empty, " + str + ", try guest login", new Object[0]);
                                            kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar4 = this.f21253a;
                                            c0459a2.label = 7;
                                        } else if (z11 || this.f21257e.length() == 0) {
                                            f.isInLogin = false;
                                            f.logger.error("no system auto login, " + ("user[" + this.f21256d + "], " + (this.f21257e.length() == 0 ? "password empty, " : "") + str) + ", return to UI", new Object[0]);
                                            kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar5 = this.f21253a;
                                            r8.u<Boolean, Integer, String> uVar2 = new r8.u<>(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-8), this.f21256d);
                                            c0459a2.label = 8;
                                        } else {
                                            String str2 = this.f21256d;
                                            String str3 = this.f21257e;
                                            c0459a2.L$0 = this;
                                            c0459a2.L$1 = fVar2;
                                            c0459a2.I$0 = 0;
                                            c0459a2.label = 9;
                                            objI1 = fVar2.i1(str2, str3, c0459a2);
                                            if (objI1 != objC) {
                                                aVar = this;
                                                i10 = 0;
                                                z10 = i10 != 0;
                                                String str4 = aVar.f21256d;
                                                a<T> aVar3 = aVar;
                                                String str5 = aVar3.f21257e;
                                                kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar6 = aVar3.f21253a;
                                                c0459a2.L$0 = null;
                                                c0459a2.L$1 = null;
                                                c0459a2.label = 10;
                                            }
                                        }
                                    } else {
                                        kotlinx.coroutines.flow.f fVarH1 = fVar2.h1();
                                        String str6 = this.f21256d;
                                        String str7 = this.f21257e;
                                        kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar7 = this.f21253a;
                                        c0459a2.label = 11;
                                    }
                                } else {
                                    String str8 = this.f21256d;
                                    String str9 = this.f21257e;
                                    c0459a2.L$0 = this;
                                    c0459a2.L$1 = fVar2;
                                    c0459a2.I$0 = 0;
                                    c0459a2.label = 5;
                                    objI1 = fVar2.i1(str8, str9, c0459a2);
                                    if (objI1 != objC) {
                                        aVar2 = this;
                                        i11 = 0;
                                        z10 = i11 != 0;
                                        String str10 = aVar2.f21256d;
                                        a<T> aVar4 = aVar2;
                                        String str11 = aVar4.f21257e;
                                        kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar8 = aVar4.f21253a;
                                        c0459a2.L$0 = null;
                                        c0459a2.L$1 = null;
                                        c0459a2.label = 6;
                                    }
                                }
                            } else {
                                f fVar4 = f.f21202a;
                                kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar9 = this.f21253a;
                                c0459a2.label = 4;
                            }
                            break;
                        }
                        return objC;
                    case 1:
                        r8.r.b(objI1);
                        return r8.z.f17874a;
                    case 2:
                        r8.r.b(objI1);
                        return r8.z.f17874a;
                    case 3:
                        r8.r.b(objI1);
                        return r8.z.f17874a;
                    case 4:
                        r8.r.b(objI1);
                        return r8.z.f17874a;
                    case 5:
                        i11 = c0459a2.I$0;
                        fVar2 = (f) c0459a2.L$1;
                        aVar2 = (a) c0459a2.L$0;
                        r8.r.b(objI1);
                        if (i11 != 0) {
                        }
                        String str12 = aVar2.f21256d;
                        a<T> aVar5 = aVar2;
                        String str13 = aVar5.f21257e;
                        kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar10 = aVar5.f21253a;
                        c0459a2.L$0 = null;
                        c0459a2.L$1 = null;
                        c0459a2.label = 6;
                        break;
                    case 6:
                        r8.r.b(objI1);
                        return r8.z.f17874a;
                    case 7:
                        r8.r.b(objI1);
                        return r8.z.f17874a;
                    case 8:
                        r8.r.b(objI1);
                        return r8.z.f17874a;
                    case 9:
                        i10 = c0459a2.I$0;
                        fVar2 = (f) c0459a2.L$1;
                        aVar = (a) c0459a2.L$0;
                        r8.r.b(objI1);
                        if (i10 != 0) {
                        }
                        String str14 = aVar.f21256d;
                        a<T> aVar6 = aVar;
                        String str15 = aVar6.f21257e;
                        kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar11 = aVar6.f21253a;
                        c0459a2.L$0 = null;
                        c0459a2.L$1 = null;
                        c0459a2.label = 10;
                        break;
                    case 10:
                        r8.r.b(objI1);
                        return r8.z.f17874a;
                    case 11:
                        r8.r.b(objI1);
                        return r8.z.f17874a;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f<? super r8.z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>>) gVar, fVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(String str, String str2, boolean z10, v8.f<? super q> fVar) {
            super(2, fVar);
            this.$usernameParam = str;
            this.$passwordParam = str2;
            this.$loginAsGuest = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            q qVar = new q(this.$usernameParam, this.$passwordParam, this.$loginAsGuest, fVar);
            qVar.L$0 = obj;
            return qVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, v8.f<? super r8.z> fVar) {
            return ((q) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x01c4  */
        /* JADX WARN: Code duplicated, block: B:103:0x01d0  */
        /* JADX WARN: Code duplicated, block: B:104:0x01d2  */
        /* JADX WARN: Code duplicated, block: B:97:0x01af  */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x01e2, code lost:
        
            if (r4.collect(r10, r16) == r1) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00e7, code lost:
        
            if (r2.emit(r3, r16) == r1) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x01a9, code lost:
        
            if (r2.emit(r3, r16) == r1) goto L107;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            String lastUsername;
            Object objF;
            kotlinx.coroutines.flow.g gVar2;
            int i10;
            String str;
            LocalSessionInfo localSessionInfo;
            LocalSessionInfo localSessionInfo2;
            LocalSessionInfo localSessionInfo3;
            boolean z10;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = this.label;
            if (i11 == 0) {
                r8.r.b(obj);
                gVar = (kotlinx.coroutines.flow.g) this.L$0;
                f fVar = f.f21202a;
                this.L$0 = gVar;
                this.label = 1;
                if (f.R0(fVar, null, this, 1, null) != objC) {
                }
                return objC;
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    r8.r.b(obj);
                    return r8.z.f17874a;
                }
                if (i11 == 3) {
                    r8.r.b(obj);
                    return r8.z.f17874a;
                }
                if (i11 == 4) {
                    i10 = this.I$0;
                    String str2 = (String) this.L$2;
                    String str3 = (String) this.L$1;
                    kotlinx.coroutines.flow.g gVar3 = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                    str = str2;
                    lastUsername = str3;
                    gVar2 = gVar3;
                    objF = obj;
                    kotlinx.coroutines.flow.f fVar2 = (kotlinx.coroutines.flow.f) objF;
                    boolean z11 = this.$loginAsGuest;
                    if (i10 != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    a aVar = new a(gVar2, z11, z10, lastUsername, str);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                } else {
                    if (i11 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            gVar = (kotlinx.coroutines.flow.g) this.L$0;
            r8.r.b(obj);
            String str4 = this.$usernameParam;
            int i12 = (str4 == null || str4.length() == 0) ? 1 : 0;
            int i13 = i12 ^ 1;
            String str5 = this.$passwordParam;
            String strP1 = str5 != null ? f.f21202a.p1(str5) : "";
            lastUsername = this.$usernameParam;
            if (lastUsername == null) {
                lastUsername = f.f21202a.D0();
            }
            if (lastUsername.length() == 0 && ((localSessionInfo3 = f.localSessionInfo) == null || (lastUsername = localSessionInfo3.getLastUsername()) == null)) {
                lastUsername = "";
            }
            if (strP1.length() == 0 && ((localSessionInfo2 = f.localSessionInfo) == null || (strP1 = localSessionInfo2.getPasswordDigest()) == null)) {
                strP1 = "";
            }
            if (i12 == 0 || this.$loginAsGuest) {
                x1.f1.lb.user.a aVar2 = f.aaaAdapter;
                this.L$0 = gVar;
                this.L$1 = lastUsername;
                this.L$2 = strP1;
                this.I$0 = i13;
                this.label = 4;
                objF = aVar2.f(this);
                if (objF != objC) {
                    gVar2 = gVar;
                    i10 = i13;
                    str = strP1;
                    kotlinx.coroutines.flow.f fVar3 = (kotlinx.coroutines.flow.f) objF;
                    boolean z12 = this.$loginAsGuest;
                    if (i10 != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    a aVar3 = new a(gVar2, z12, z10, lastUsername, str);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                }
            } else if (f.localSessionInfo == null || !f.isAuthRetSuccess || f.f21202a.D1()) {
                LocalSessionInfo localSessionInfo4 = f.localSessionInfo;
                if (localSessionInfo4 == null || !localSessionInfo4.isTriedRefreshAccessTokenFailure() || lastUsername.length() <= 0) {
                    x1.f1.lb.user.a aVar4 = f.aaaAdapter;
                    this.L$0 = gVar;
                    this.L$1 = lastUsername;
                    this.L$2 = strP1;
                    this.I$0 = i13;
                    this.label = 4;
                    objF = aVar4.f(this);
                    if (objF != objC) {
                        gVar2 = gVar;
                        i10 = i13;
                        str = strP1;
                        kotlinx.coroutines.flow.f fVar4 = (kotlinx.coroutines.flow.f) objF;
                        boolean z13 = this.$loginAsGuest;
                        if (i10 != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        a aVar5 = new a(gVar2, z13, z10, lastUsername, str);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                    }
                } else {
                    LocalSessionInfo localSessionInfo5 = f.localSessionInfo;
                    if (kotlin.jvm.internal.m.a(lastUsername, localSessionInfo5 != null ? localSessionInfo5.getLoginFailureUsername() : null)) {
                        LocalSessionInfo localSessionInfo6 = f.localSessionInfo;
                        if (kotlin.jvm.internal.m.a(strP1, localSessionInfo6 != null ? localSessionInfo6.getLoginFailurePassword() : null) && (localSessionInfo = f.localSessionInfo) != null && localSessionInfo.isTriedLoginByUsernameFailure()) {
                            f.isInLogin = false;
                            LocalSessionInfo localSessionInfo7 = f.localSessionInfo;
                            String str6 = (localSessionInfo7 == null || !localSessionInfo7.isTriedRefreshAccessTokenFailure()) ? "" : "refresh token is expired";
                            String str7 = "user[" + lastUsername + "] " + (strP1.length() == 0 ? "password empty " : "") + "already failure";
                            f.logger.error("auto login failure, " + str6 + " " + str7 + ", should not retry", new Object[0]);
                            r8.u uVar = new r8.u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-11), "auto login failure");
                            this.L$0 = null;
                            this.label = 3;
                        } else {
                            x1.f1.lb.user.a aVar6 = f.aaaAdapter;
                            this.L$0 = gVar;
                            this.L$1 = lastUsername;
                            this.L$2 = strP1;
                            this.I$0 = i13;
                            this.label = 4;
                            objF = aVar6.f(this);
                            if (objF != objC) {
                                gVar2 = gVar;
                                i10 = i13;
                                str = strP1;
                                kotlinx.coroutines.flow.f fVar5 = (kotlinx.coroutines.flow.f) objF;
                                boolean z14 = this.$loginAsGuest;
                                if (i10 != 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                a aVar7 = new a(gVar2, z14, z10, lastUsername, str);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.label = 5;
                            }
                        }
                    } else {
                        x1.f1.lb.user.a aVar8 = f.aaaAdapter;
                        this.L$0 = gVar;
                        this.L$1 = lastUsername;
                        this.L$2 = strP1;
                        this.I$0 = i13;
                        this.label = 4;
                        objF = aVar8.f(this);
                        if (objF != objC) {
                            gVar2 = gVar;
                            i10 = i13;
                            str = strP1;
                            kotlinx.coroutines.flow.f fVar6 = (kotlinx.coroutines.flow.f) objF;
                            boolean z15 = this.$loginAsGuest;
                            if (i10 != 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            a aVar9 = new a(gVar2, z15, z10, lastUsername, str);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 5;
                        }
                    }
                }
            } else {
                f.isInLogin = false;
                r8.u uVar2 = new r8.u(kotlin.coroutines.jvm.internal.b.a(true), kotlin.coroutines.jvm.internal.b.b(0), null);
                this.L$0 = null;
                this.label = 2;
            }
            return objC;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$loginByToken$1", f = "UserManager.kt", l = {1521, 1521, 1539, 1539}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class r extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super r8.z>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21258a;

            /* JADX INFO: renamed from: x1.f1.lb.user.f$r$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class C0460a<T> implements kotlinx.coroutines.flow.g {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f21259a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21260b;

                /* JADX WARN: Multi-variable type inference failed */
                C0460a(String str, kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar) {
                    this.f21259a = str;
                    this.f21260b = gVar;
                }

                @Override // kotlinx.coroutines.flow.g
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                    if (!uVar.d().booleanValue()) {
                        f.logger.error("login by token[" + this.f21259a + "] failure, api ret[" + ((Object) uVar.f()) + "]", new Object[0]);
                    }
                    Object objEmit = this.f21260b.emit(uVar, fVar);
                    if (objEmit == kotlin.coroutines.intrinsics.b.c()) {
                        return objEmit;
                    }
                    return r8.z.f17874a;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$loginByToken$1$1", f = "UserManager.kt", l = {1525, 1528, 1528}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class b extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                Object L$1;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ a<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                b(a<? super T> aVar, v8.f<? super b> fVar) {
                    super(fVar);
                    this.this$0 = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            a(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar) {
                this.f21258a = gVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
            
                if (r8.emit(r7, r0) == r1) goto L34;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
            
                if (((kotlinx.coroutines.flow.f) r8).collect(r4, r0) == r1) goto L34;
             */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                b bVar;
                String str;
                a<T> aVar;
                if (fVar instanceof b) {
                    bVar = (b) fVar;
                    int i10 = bVar.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        bVar.label = i10 - Integer.MIN_VALUE;
                    } else {
                        bVar = new b(this, fVar);
                    }
                } else {
                    bVar = new b(this, fVar);
                }
                Object obj = bVar.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = bVar.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        r8.r.b(obj);
                        return r8.z.f17874a;
                    }
                    if (i11 == 2) {
                        str = (String) bVar.L$1;
                        aVar = (a) bVar.L$0;
                        r8.r.b(obj);
                        C0460a c0460a = new C0460a(str, aVar.f21258a);
                        bVar.L$0 = null;
                        bVar.L$1 = null;
                        bVar.label = 3;
                    } else {
                        if (i11 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r8.r.b(obj);
                    }
                    return r8.z.f17874a;
                }
                r8.r.b(obj);
                if (uVar.d().booleanValue()) {
                    f fVar2 = f.f21202a;
                    String strB0 = fVar2.b0();
                    bVar.L$0 = this;
                    bVar.L$1 = strB0;
                    bVar.label = 2;
                    Object objM1 = fVar2.M1(bVar);
                    if (objM1 != objC) {
                        obj = objM1;
                        str = strB0;
                        aVar = this;
                        C0460a c0460a2 = new C0460a(str, aVar.f21258a);
                        bVar.L$0 = null;
                        bVar.L$1 = null;
                        bVar.label = 3;
                    }
                } else {
                    f.logger.error("refresh token failure before login, api ret[" + ((Object) uVar.f()) + "]", new Object[0]);
                    LocalSessionInfo localSessionInfo = f.localSessionInfo;
                    if (localSessionInfo != null) {
                        localSessionInfo.setTriedRefreshAccessTokenFailure(true);
                    }
                    kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar = this.f21258a;
                    bVar.label = 1;
                }
                return objC;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21261a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f21262b;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class a<T> implements kotlinx.coroutines.flow.g {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21263a;

                /* JADX INFO: renamed from: x1.f1.lb.user.f$r$b$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                static final class C0461a<T> implements kotlinx.coroutines.flow.g {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ String f21264a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21265b;

                    /* JADX WARN: Multi-variable type inference failed */
                    C0461a(String str, kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar) {
                        this.f21264a = str;
                        this.f21265b = gVar;
                    }

                    @Override // kotlinx.coroutines.flow.g
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                        if (!uVar.d().booleanValue()) {
                            f.logger.error("re-login by token[" + this.f21264a + "] failure, api ret[" + ((Object) uVar.f()) + "]", new Object[0]);
                        }
                        Object objEmit = this.f21265b.emit(uVar, fVar);
                        if (objEmit == kotlin.coroutines.intrinsics.b.c()) {
                            return objEmit;
                        }
                        return r8.z.f17874a;
                    }
                }

                /* JADX INFO: renamed from: x1.f1.lb.user.f$r$b$a$b, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$loginByToken$1$2$1", f = "UserManager.kt", l = {1549, 1552, 1552}, m = "emit")
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                static final class C0462b extends kotlin.coroutines.jvm.internal.d {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;
                    final /* synthetic */ a<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0462b(a<? super T> aVar, v8.f<? super C0462b> fVar) {
                        super(fVar);
                        this.this$0 = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.emit(null, this);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                a(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar) {
                    this.f21263a = gVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
                
                    if (r8.emit(r7, r0) == r1) goto L34;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
                
                    if (((kotlinx.coroutines.flow.f) r8).collect(r4, r0) == r1) goto L34;
                 */
                @Override // kotlinx.coroutines.flow.g
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                    C0462b c0462b;
                    String str;
                    a<T> aVar;
                    if (fVar instanceof C0462b) {
                        c0462b = (C0462b) fVar;
                        int i10 = c0462b.label;
                        if ((i10 & Integer.MIN_VALUE) != 0) {
                            c0462b.label = i10 - Integer.MIN_VALUE;
                        } else {
                            c0462b = new C0462b(this, fVar);
                        }
                    } else {
                        c0462b = new C0462b(this, fVar);
                    }
                    Object obj = c0462b.result;
                    Object objC = kotlin.coroutines.intrinsics.b.c();
                    int i11 = c0462b.label;
                    if (i11 != 0) {
                        if (i11 == 1) {
                            r8.r.b(obj);
                            return r8.z.f17874a;
                        }
                        if (i11 == 2) {
                            str = (String) c0462b.L$1;
                            aVar = (a) c0462b.L$0;
                            r8.r.b(obj);
                            C0461a c0461a = new C0461a(str, aVar.f21263a);
                            c0462b.L$0 = null;
                            c0462b.L$1 = null;
                            c0462b.label = 3;
                        } else {
                            if (i11 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            r8.r.b(obj);
                        }
                        return r8.z.f17874a;
                    }
                    r8.r.b(obj);
                    if (uVar.d().booleanValue()) {
                        f fVar2 = f.f21202a;
                        String strB0 = fVar2.b0();
                        c0462b.L$0 = this;
                        c0462b.L$1 = strB0;
                        c0462b.label = 2;
                        Object objM1 = fVar2.M1(c0462b);
                        if (objM1 != objC) {
                            obj = objM1;
                            str = strB0;
                            aVar = this;
                            C0461a c0461a2 = new C0461a(str, aVar.f21263a);
                            c0462b.L$0 = null;
                            c0462b.L$1 = null;
                            c0462b.label = 3;
                        }
                    } else {
                        f.logger.error("refresh token failure before re-login, api ret[" + ((Object) uVar.f()) + "]", new Object[0]);
                        LocalSessionInfo localSessionInfo = f.localSessionInfo;
                        if (localSessionInfo != null) {
                            localSessionInfo.setTriedRefreshAccessTokenFailure(true);
                        }
                        kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar = this.f21263a;
                        c0462b.label = 1;
                    }
                    return objC;
                }
            }

            /* JADX INFO: renamed from: x1.f1.lb.user.f$r$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$loginByToken$1$2", f = "UserManager.kt", l = {1541, 1545, 1545}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class C0463b extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ b<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0463b(b<? super T> bVar, v8.f<? super C0463b> fVar) {
                    super(fVar);
                    this.this$0 = bVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            b(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, String str) {
                this.f21261a = gVar;
                this.f21262b = str;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
            
                if (r9.emit(r8, r0) == r1) goto L31;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x00b7, code lost:
            
                if (((kotlinx.coroutines.flow.f) r9).collect(r2, r0) == r1) goto L31;
             */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                C0463b c0463b;
                b<T> bVar;
                if (fVar instanceof C0463b) {
                    c0463b = (C0463b) fVar;
                    int i10 = c0463b.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0463b.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0463b = new C0463b(this, fVar);
                    }
                } else {
                    c0463b = new C0463b(this, fVar);
                }
                Object objD = c0463b.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0463b.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        r8.r.b(objD);
                        return r8.z.f17874a;
                    }
                    if (i11 == 2) {
                        bVar = (b) c0463b.L$0;
                        r8.r.b(objD);
                        a aVar = new a(bVar.f21261a);
                        c0463b.L$0 = null;
                        c0463b.label = 3;
                    } else {
                        if (i11 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r8.r.b(objD);
                    }
                    return r8.z.f17874a;
                }
                r8.r.b(objD);
                if (uVar.d().booleanValue()) {
                    kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar = this.f21261a;
                    c0463b.label = 1;
                } else {
                    f.logger.error("login by token[" + this.f21262b + "] failure, api ret[" + ((Object) uVar.f()) + "]", new Object[0]);
                    x1.f1.lb.user.a aVar2 = f.aaaAdapter;
                    String strY0 = f.f21202a.y0();
                    c0463b.L$0 = this;
                    c0463b.label = 2;
                    objD = aVar2.d(strY0, c0463b);
                    if (objD != objC) {
                        bVar = this;
                        a aVar3 = new a(bVar.f21261a);
                        c0463b.L$0 = null;
                        c0463b.label = 3;
                    }
                }
                return objC;
            }
        }

        r(v8.f<? super r> fVar) {
            super(2, fVar);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f<? super r8.z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>>) gVar, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            r rVar = new r(fVar);
            rVar.L$0 = obj;
            return rVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, v8.f<? super r8.z> fVar) {
            return ((r) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
        
            if (((kotlinx.coroutines.flow.f) r10).collect(r4, r9) == r0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0099, code lost:
        
            if (((kotlinx.coroutines.flow.f) r10).collect(r2, r9) == r0) goto L31;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            kotlinx.coroutines.flow.g gVar2;
            String str;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            str = (String) this.L$1;
                            gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
                            r8.r.b(obj);
                            b bVar = new b(gVar2, str);
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 4;
                        }
                    }
                    r8.r.b(obj);
                } else {
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                    a aVar = new a(gVar);
                    this.L$0 = null;
                    this.label = 2;
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            kotlinx.coroutines.flow.g gVar3 = (kotlinx.coroutines.flow.g) this.L$0;
            f fVar = f.f21202a;
            if (fVar.I0() || f.isUpdateSessionFailed) {
                x1.f1.lb.user.a aVar2 = f.aaaAdapter;
                String strY0 = fVar.y0();
                this.L$0 = gVar3;
                this.label = 1;
                Object objD = aVar2.d(strY0, this);
                if (objD != objC) {
                    gVar = gVar3;
                    obj = objD;
                    a aVar3 = new a(gVar);
                    this.L$0 = null;
                    this.label = 2;
                }
            } else {
                String strB0 = fVar.b0();
                this.L$0 = gVar3;
                this.L$1 = strB0;
                this.label = 3;
                Object objM1 = fVar.M1(this);
                if (objM1 != objC) {
                    gVar2 = gVar3;
                    obj = objM1;
                    str = strB0;
                    b bVar2 = new b(gVar2, str);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 4;
                }
            }
            return objC;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$loginExtra$1", f = "UserManager.kt", l = {1221}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class s extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ x1.f1.lb.util.m<Boolean> $callback;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$loginExtra$1$1", f = "UserManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    f.logger.error("login error", (Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ x1.f1.lb.util.m<Boolean> f21266a;

            b(x1.f1.lb.util.m<Boolean> mVar) {
                this.f21266a = mVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                int iIntValue;
                if (!uVar.d().booleanValue()) {
                    q6.b bVar = f.logger;
                    String strF = uVar.f();
                    bVar.error("auto login failure [" + ((Object) strF) + "] [" + uVar.e() + "]", new Object[0]);
                    Integer numE = uVar.e();
                    if (numE != null) {
                        iIntValue = numE.intValue();
                    } else {
                        iIntValue = -1;
                    }
                    String strF2 = uVar.f();
                    if (strF2 == null) {
                        strF2 = "Unknown";
                    }
                    xe.c.c().l(new nf.h(iIntValue, strF2));
                }
                x1.f1.lb.util.m<Boolean> mVar = this.f21266a;
                if (mVar != null) {
                    mVar.a(uVar.d());
                }
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(x1.f1.lb.util.m<Boolean> mVar, v8.f<? super s> fVar) {
            super(2, fVar);
            this.$callback = mVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new s(this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((s) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(f.g1(f.f21202a, null, null, false, 7, null), new a(null));
                b bVar = new b(this.$callback);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$logout$1", f = "UserManager.kt", l = {694, 697}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class t extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super r8.z>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$logout$1$1", f = "UserManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(obj);
                Throwable th = (Throwable) this.L$0;
                f.isInLogout = false;
                throw th;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21267a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$logout$1$2", f = "UserManager.kt", l = {716, 730}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                Object L$1;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ b<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(b<? super T> bVar, v8.f<? super a> fVar) {
                    super(fVar);
                    this.this$0 = bVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            b(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar) {
                this.f21267a = gVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:71:0x011a, code lost:
            
                if (r11.emit(r10, r0) == r1) goto L72;
             */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                a aVar;
                b<T> bVar;
                if (fVar instanceof a) {
                    aVar = (a) fVar;
                    int i10 = aVar.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        aVar.label = i10 - Integer.MIN_VALUE;
                    } else {
                        aVar = new a(this, fVar);
                    }
                } else {
                    aVar = new a(this, fVar);
                }
                Object obj = aVar.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = aVar.label;
                try {
                    if (i11 != 0) {
                        if (i11 == 1) {
                            uVar = (r8.u) aVar.L$1;
                            bVar = (b) aVar.L$0;
                            r8.r.b(obj);
                        } else {
                            if (i11 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            r8.r.b(obj);
                        }
                        return r8.z.f17874a;
                    }
                    r8.r.b(obj);
                    if (uVar.d().booleanValue()) {
                        f fVar2 = f.f21202a;
                        String strD0 = fVar2.D0();
                        LocalSessionInfo localSessionInfo = f.localSessionInfo;
                        if (localSessionInfo != null) {
                            localSessionInfo.setLogout(true);
                        }
                        LocalSessionInfo localSessionInfo2 = f.localSessionInfo;
                        if (localSessionInfo2 != null) {
                            localSessionInfo2.setAccessToken(null);
                        }
                        LocalSessionInfo localSessionInfo3 = f.localSessionInfo;
                        if (localSessionInfo3 != null) {
                            localSessionInfo3.setRefreshToken(null);
                        }
                        LocalSessionInfo localSessionInfo4 = f.localSessionInfo;
                        if (localSessionInfo4 != null) {
                            localSessionInfo4.setStreamToken(null);
                        }
                        LocalSessionInfo localSessionInfo5 = f.localSessionInfo;
                        if (localSessionInfo5 != null) {
                            localSessionInfo5.setEmail("");
                        }
                        LocalSessionInfo localSessionInfo6 = f.localSessionInfo;
                        if (localSessionInfo6 != null) {
                            localSessionInfo6.setPhone("");
                        }
                        LocalSessionInfo localSessionInfo7 = f.localSessionInfo;
                        if (localSessionInfo7 != null) {
                            localSessionInfo7.setPhoneNumber("");
                        }
                        LocalSessionInfo localSessionInfo8 = f.localSessionInfo;
                        if (localSessionInfo8 != null) {
                            localSessionInfo8.setCode("");
                        }
                        LocalSessionInfo localSessionInfo9 = f.localSessionInfo;
                        if (localSessionInfo9 != null) {
                            localSessionInfo9.setLastUsername(strD0);
                        }
                        LocalSessionInfo localSessionInfo10 = f.localSessionInfo;
                        if (localSessionInfo10 != null) {
                            localSessionInfo10.setUsername("");
                        }
                        LocalSessionInfo localSessionInfo11 = f.localSessionInfo;
                        if (localSessionInfo11 != null) {
                            localSessionInfo11.setDigitalCode(null);
                        }
                        LocalSessionInfo localSessionInfo12 = f.localSessionInfo;
                        if (localSessionInfo12 != null) {
                            localSessionInfo12.setPasswordDigest(null);
                        }
                        fVar2.w1();
                        fVar2.D1();
                        kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar = this.f21267a;
                        aVar.L$0 = this;
                        aVar.L$1 = uVar;
                        aVar.label = 1;
                        if (fVar2.F0(gVar, aVar) != objC) {
                            bVar = this;
                        }
                    } else {
                        bVar = this;
                        f.isInLogout = false;
                        kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar2 = bVar.f21267a;
                        aVar.L$0 = null;
                        aVar.L$1 = null;
                        aVar.label = 2;
                    }
                    return objC;
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        f.logger.debug("logout success: " + ((Object) uVar.f()), new Object[0]);
                    }
                    f.referralSummary = null;
                    f.isInLogout = false;
                    kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar3 = bVar.f21267a;
                    aVar.L$0 = null;
                    aVar.L$1 = null;
                    aVar.label = 2;
                } catch (Throwable th) {
                    f.isInLogout = false;
                    throw th;
                }
            }
        }

        t(v8.f<? super t> fVar) {
            super(2, fVar);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f<? super r8.z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>>) gVar, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            t tVar = new t(fVar);
            tVar.L$0 = obj;
            return tVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, v8.f<? super r8.z> fVar) {
            return ((t) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
        
            if (r6.collect(r3, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            gVar = (kotlinx.coroutines.flow.g) this.L$0;
            f.isInLogout = true;
            x1.f1.lb.user.a aVar = f.aaaAdapter;
            this.L$0 = gVar;
            this.label = 1;
            obj = aVar.a(this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(null));
            b bVar = new b(gVar);
            this.L$0 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/user/f$u", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Z)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class u implements x1.f1.lb.util.m<Boolean> {
        @Override // x1.f1.lb.util.m
        public /* bridge */ /* synthetic */ void a(Boolean bool) {
            c(bool.booleanValue());
        }

        public void c(boolean v10) {
            if (v10) {
                xe.c.c().l(new nf.q(0L, 10, 1, "token_expire_re_login"));
            }
        }

        u() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$queryProperty$1", f = "UserManager.kt", l = {1569, 1571}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class v extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$queryProperty$1$1", f = "UserManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    f.logger.error("query property failure", (Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b<T> f21268a = new b<>();

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                return r8.z.f17874a;
            }

            b() {
            }
        }

        v(v8.f<? super v> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new v(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((v) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            if (r5.collect(r1, r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            x1.f1.lb.user.a aVar = f.aaaAdapter;
            this.label = 1;
            obj = aVar.m(this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(null));
            kotlinx.coroutines.flow.g gVar = b.f21268a;
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$refreshToken$1", f = "UserManager.kt", l = {584, 587}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class w extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $refreshToken;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$refreshToken$1$1", f = "UserManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    LocalSessionInfo localSessionInfo = f.localSessionInfo;
                    if (localSessionInfo != null) {
                        localSessionInfo.setTriedRefreshAccessTokenFailure(true);
                    }
                    f.logger.error("refresh failure", th);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b<T> f21269a = new b<>();

            b() {
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                if (!uVar.d().booleanValue()) {
                    q6.b bVar = f.logger;
                    String strF = uVar.f();
                    bVar.error("refresh token failure:[" + ((Object) strF) + "(" + uVar.e() + ")]", new Object[0]);
                    f.k1(f.f21202a, null, 1, null);
                }
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(String str, v8.f<? super w> fVar) {
            super(2, fVar);
            this.$refreshToken = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new w(this.$refreshToken, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((w) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        
            if (r5.collect(r1, r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            x1.f1.lb.user.a aVar = f.aaaAdapter;
            String str = this.$refreshToken;
            this.label = 1;
            obj = aVar.d(str, this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(null));
            kotlinx.coroutines.flow.g gVar = b.f21269a;
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$resetPassword$1", f = "UserManager.kt", l = {226, 226}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class x extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $captchaCode;
        final /* synthetic */ String $digitalCode;
        final /* synthetic */ String $newPassword;
        final /* synthetic */ String $username;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f21270a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f21271b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.b0<String> f21272c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21273d;

            /* JADX INFO: renamed from: x1.f1.lb.user.f$x$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class C0464a<T> implements kotlinx.coroutines.flow.g {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> f21274a;

                /* JADX WARN: Multi-variable type inference failed */
                C0464a(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar) {
                    this.f21274a = gVar;
                }

                @Override // kotlinx.coroutines.flow.g
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                    Object objEmit = this.f21274a.emit(uVar, fVar);
                    return objEmit == kotlin.coroutines.intrinsics.b.c() ? objEmit : r8.z.f17874a;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$resetPassword$1$1", f = "UserManager.kt", l = {234, 234, 238, 241}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class b extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ a<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                b(a<? super T> aVar, v8.f<? super b> fVar) {
                    super(fVar);
                    this.this$0 = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            a(String str, String str2, kotlin.jvm.internal.b0<String> b0Var, kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar) {
                this.f21270a = str;
                this.f21271b = str2;
                this.f21272c = b0Var;
                this.f21273d = gVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x009f, code lost:
            
                if (((kotlinx.coroutines.flow.f) r9).collect(r2, r0) == r1) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00ad, code lost:
            
                if (r9.emit(r8, r0) == r1) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
            
                if (r9.emit(r8, r0) == r1) goto L43;
             */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                b bVar;
                a<T> aVar;
                if (fVar instanceof b) {
                    bVar = (b) fVar;
                    int i10 = bVar.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        bVar.label = i10 - Integer.MIN_VALUE;
                    } else {
                        bVar = new b(this, fVar);
                    }
                } else {
                    bVar = new b(this, fVar);
                }
                Object objE = bVar.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = bVar.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        aVar = (a) bVar.L$0;
                        r8.r.b(objE);
                        C0464a c0464a = new C0464a(aVar.f21273d);
                        bVar.L$0 = null;
                        bVar.label = 2;
                    } else {
                        if (i11 != 2) {
                            if (i11 == 3) {
                                r8.r.b(objE);
                                return r8.z.f17874a;
                            }
                            if (i11 != 4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            r8.r.b(objE);
                            return r8.z.f17874a;
                        }
                        r8.r.b(objE);
                    }
                    return r8.z.f17874a;
                }
                r8.r.b(objE);
                if (uVar.d().booleanValue()) {
                    f fVar2 = f.f21202a;
                    String strP1 = fVar2.p1(this.f21270a);
                    LocalSessionInfo localSessionInfo = f.localSessionInfo;
                    if (localSessionInfo != null) {
                        localSessionInfo.setPasswordDigest(strP1);
                    }
                    fVar2.w1();
                    if (fVar2.O0()) {
                        x1.f1.lb.user.a aVar2 = f.aaaAdapter;
                        String str = this.f21271b;
                        String str2 = this.f21272c.element;
                        bVar.L$0 = this;
                        bVar.label = 1;
                        objE = aVar2.e(str, strP1, str2, bVar);
                        if (objE != objC) {
                            aVar = this;
                            C0464a c0464a2 = new C0464a(aVar.f21273d);
                            bVar.L$0 = null;
                            bVar.label = 2;
                        }
                    } else {
                        kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar = this.f21273d;
                        bVar.label = 3;
                    }
                } else {
                    kotlinx.coroutines.flow.g<r8.u<Boolean, Integer, String>> gVar2 = this.f21273d;
                    bVar.label = 4;
                }
                return objC;
            }
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>> gVar, v8.f<? super r8.z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>>) gVar, fVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(String str, String str2, String str3, String str4, v8.f<? super x> fVar) {
            super(2, fVar);
            this.$digitalCode = str;
            this.$username = str2;
            this.$newPassword = str3;
            this.$captchaCode = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            x xVar = new x(this.$digitalCode, this.$username, this.$newPassword, this.$captchaCode, fVar);
            xVar.L$0 = obj;
            return xVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, v8.f<? super r8.z> fVar) {
            return ((x) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
        
            if (((kotlinx.coroutines.flow.f) r13).collect(r5, r12) == r0) goto L25;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            x xVar;
            kotlin.jvm.internal.b0 b0Var;
            String str;
            T t10;
            String digitalCode;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    str = (String) this.L$2;
                    b0Var = (kotlin.jvm.internal.b0) this.L$1;
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                    xVar = this;
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            gVar = (kotlinx.coroutines.flow.g) this.L$0;
            kotlin.jvm.internal.b0 b0Var2 = new kotlin.jvm.internal.b0();
            ?? r10 = this.$digitalCode;
            b0Var2.element = r10;
            String strD0 = this.$username;
            if (strD0.length() == 0) {
                LocalSessionInfo localSessionInfo = f.localSessionInfo;
                if (localSessionInfo != null && (digitalCode = localSessionInfo.getDigitalCode()) != null) {
                    t10 = r10;
                    t10 = r10;
                    t10 = digitalCode;
                }
                t10 = r10;
                t10 = r10;
                t10 = r10;
                b0Var2.element = t10;
                strD0 = f.f21202a.D0();
            }
            String str2 = strD0;
            x1.f1.lb.user.a aVar = f.aaaAdapter;
            String str3 = (String) b0Var2.element;
            String str4 = this.$newPassword;
            String str5 = this.$captchaCode;
            this.L$0 = gVar;
            this.L$1 = b0Var2;
            this.L$2 = str2;
            this.label = 1;
            xVar = this;
            Object objI = aVar.i(str2, str3, str4, str5, xVar);
            if (objI != objC) {
                b0Var = b0Var2;
                obj = objI;
                str = str2;
            }
            return objC;
            a aVar2 = new a(xVar.$newPassword, str, b0Var, gVar);
            xVar.L$0 = null;
            xVar.L$1 = null;
            xVar.L$2 = null;
            xVar.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$setLocalSessionInfo$1", f = "UserManager.kt", l = {965, 967}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class y extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager$setLocalSessionInfo$1$1", f = "UserManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Boolean>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    f.logger.error("restart engine failure", (Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b<T> f21275a = new b<>();

            public final Object b(boolean z10, v8.f<? super r8.z> fVar) {
                if (z10) {
                    xe.c.c().o(new nf.q(0L, 8, 1, "restart_engine_um"));
                } else {
                    f.logger.error("restart engine failure", new Object[0]);
                }
                return r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Boolean) obj).booleanValue(), fVar);
            }

            b() {
            }
        }

        y(v8.f<? super y> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new y(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((y) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
        
            if (r6.collect(r1, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            x1.f1.lb.streaming.a aVar = x1.f1.lb.streaming.a.f20960a;
            this.label = 1;
            obj = x1.f1.lb.streaming.a.A(aVar, null, this, 1, null);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(null));
            kotlinx.coroutines.flow.g gVar = b.f21275a;
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.user.UserManager", f = "UserManager.kt", l = {1059, 1088}, m = "startEngine")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class z extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        z(v8.f<? super z> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return f.this.J1(null, this);
        }
    }

    private final boolean Y0(Long ts) {
        if (ts != null) {
            if (d1.d() > ts.longValue()) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void a1(File fileInstallDir) {
        kotlin.jvm.internal.m.f(fileInstallDir, "fileInstallDir");
        Boolean bool = inStart;
        Boolean bool2 = Boolean.TRUE;
        if (kotlin.jvm.internal.m.a(bool, bool2)) {
            logger.warn("Puck is during PHASE SHIFT", new Object[0]);
        } else {
            inStart = bool2;
            kotlinx.coroutines.j.d(puckScope, null, null, new k(fileInstallDir, null), 3, null);
        }
    }

    public final int w0() {
        int i10;
        try {
            LocalSessionInfo localSessionInfo2 = localSessionInfo;
            String planLeftDays = localSessionInfo2 != null ? localSessionInfo2.getPlanLeftDays() : null;
            if (planLeftDays != null) {
                try {
                    i10 = Integer.parseInt(planLeftDays);
                } catch (Throwable unused) {
                    i10 = -1;
                }
            } else {
                i10 = -1;
            }
            if (i10 != -1) {
                return i10;
            }
            long jD = d1.d();
            long jM0 = m0();
            if (jM0 != 0 && jD <= jM0) {
                return (int) ((jM0 - jD) / ((long) 86400000));
            }
            return 0;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/user/f$m", "Lf3/a;", "Lz1/b1/lb/m/local/LocalSessionInfo;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class m extends f3.a<LocalSessionInfo> {
        m() {
        }
    }

    private final void E1() {
        String kickedOutBy;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 == null || (kickedOutBy = localSessionInfo2.getKickedOutBy()) == null) {
            kickedOutBy = "";
        }
        q1(9000042, kickedOutBy);
        F1(R$string.session_kicked_out, "You are kicked out, please login");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
    
        if (r7.collect(r2, r0) == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object F0(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, v8.f<? super r8.z> fVar) {
        C0456f c0456f;
        if (fVar instanceof C0456f) {
            c0456f = (C0456f) fVar;
            int i10 = c0456f.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0456f.label = i10 - Integer.MIN_VALUE;
            } else {
                c0456f = new C0456f(fVar);
            }
        } else {
            c0456f = new C0456f(fVar);
        }
        Object objJ = c0456f.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = c0456f.label;
        if (i11 != 0) {
            if (i11 == 1) {
                gVar = (kotlinx.coroutines.flow.g) c0456f.L$0;
                r8.r.b(objJ);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(objJ);
            }
            return r8.z.f17874a;
        }
        r8.r.b(objJ);
        x1.f1.lb.user.a<ApiResponse<?>> aVar = aaaAdapter;
        c0456f.L$0 = gVar;
        c0456f.label = 1;
        objJ = aVar.j(c0456f);
        if (objJ != objC) {
        }
        return objC;
        kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) objJ, new g(null));
        h hVar = new h(gVar);
        c0456f.L$0 = null;
        c0456f.label = 2;
    }

    private final void F1(int reasonResId, String dft) {
        H1(this, null, null, u0.f21448a.a(reasonResId, dft), null, null, null, 56, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void H1(f fVar, String str, String str2, String str3, x1.f1.lb.util.m mVar, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnDismissListener onDismissListener, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        if ((i10 & 8) != 0) {
            mVar = null;
        }
        if ((i10 & 16) != 0) {
            onCancelListener = null;
        }
        if ((i10 & 32) != 0) {
            onDismissListener = null;
        }
        fVar.G1(str, str2, str3, mVar, onCancelListener, onDismissListener);
    }

    private final void K1(String msg) {
        tf.e eVarE = x1.f1.lb.metric.monitor.h.f20952a.e();
        if (eVarE != null) {
            eVarE.p(msg);
        }
        if (eVarE != null) {
            eVarE.o(d1.d());
        }
        Long lValueOf = eVarE != null ? Long.valueOf(eVarE.b()) : null;
        if (eVarE != null) {
            eVarE.m((lValueOf != null ? lValueOf.longValue() : 0L) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1(Throwable e10) {
        String name;
        Throwable cause;
        if (e10 == null || (name = e10.getMessage()) == null) {
            String message = (e10 == null || (cause = e10.getCause()) == null) ? null : cause.getMessage();
            if (message == null) {
                name = e10 != null ? e10.getClass().getName() : null;
                if (name == null) {
                    name = "Unknown Error";
                }
            } else {
                name = message;
            }
        }
        K1(name);
    }

    public static /* synthetic */ Object R0(f fVar, Long l10, v8.f fVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = null;
        }
        return fVar.Q0(l10, fVar2);
    }

    private final boolean W0() {
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 != null && localSessionInfo2.isKickedOut()) || isSessionExpired.get();
    }

    private final boolean X0(Long ts) {
        Long latestTokenUpdateTime;
        long jLongValue = ts != null ? ts.longValue() : 0L;
        if (jLongValue == 0) {
            return true;
        }
        long jD = d1.d();
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        long jLongValue2 = (localSessionInfo2 == null || (latestTokenUpdateTime = localSessionInfo2.getLatestTokenUpdateTime()) == null) ? 0L : latestTokenUpdateTime.longValue();
        x1.f1.lb.heartbeat.f fVar = x1.f1.lb.heartbeat.f.f20678a;
        if (fVar.a0() + jD <= jLongValue) {
            return jLongValue2 > 0 && jD - jLongValue2 > fVar.b0();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Z(boolean z10, kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>> fVar, String str, String str2, boolean z11, kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, v8.f<? super r8.z> fVar2) {
        Object objCollect = fVar.collect(new a(gVar, z11, z10, str, str2), fVar2);
        return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object c1(v8.f<? super r8.z> fVar) {
        l lVar;
        f fVar2;
        if (fVar instanceof l) {
            lVar = (l) fVar;
            int i10 = lVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                lVar.label = i10 - Integer.MIN_VALUE;
            } else {
                lVar = new l(fVar);
            }
        } else {
            lVar = new l(fVar);
        }
        l lVar2 = lVar;
        Object objO = lVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = lVar2.label;
        try {
            if (i11 == 0) {
                r8.r.b(objO);
                w0 w0Var = w0.f21452a;
                lVar2.L$0 = this;
                lVar2.label = 1;
                objO = w0.o(w0Var, "local_session", null, lVar2, 2, null);
                if (objO == objC) {
                    return objC;
                }
                fVar2 = this;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                fVar2 = (f) lVar2.L$0;
                r8.r.b(objO);
            }
            String str = (String) objO;
            if (str.length() > 0) {
                Object objO2 = new com.google.gson.e().o(str, new m().d());
                kotlin.jvm.internal.m.e(objO2, "fromJson(...)");
                LocalSessionInfo localSessionInfo2 = (LocalSessionInfo) objO2;
                localSessionInfo = localSessionInfo2;
                localSessionInfo2.setLatestLocalLoadTime(kotlin.coroutines.jvm.internal.b.c(d1.d()));
                if (!fVar2.I0()) {
                    localSessionCreatingCountDownLatch.countDown();
                }
            }
            logger.a("[" + did + "], load local session[" + str + "]", new Object[0]);
        } catch (Throwable th) {
            try {
                logger.error("[" + did + "], load local session failure", th);
            } finally {
                isLocalSessionLoaded = true;
            }
        }
        return r8.z.f17874a;
    }

    public static /* synthetic */ kotlinx.coroutines.flow.f g1(f fVar, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return fVar.f1(str, str2, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>> h1() {
        return kotlinx.coroutines.flow.h.v(new r(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i1(String str, String str2, v8.f<? super kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>>> fVar) {
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        String digitalCode = null;
        if (kotlin.jvm.internal.m.a(str, localSessionInfo2 != null ? localSessionInfo2.getPhone() : null)) {
            LocalSessionInfo localSessionInfo3 = localSessionInfo;
            if (localSessionInfo3 != null) {
                digitalCode = localSessionInfo3.getDigitalCode();
            }
        } else {
            digitalCode = "";
        }
        return aaaAdapter.e(str, str2, digitalCode != null ? digitalCode : "", fVar);
    }

    private final void j1(x1.f1.lb.util.m<Boolean> callback) {
        kotlinx.coroutines.j.d(puckScope, null, null, new s(callback, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void k1(f fVar, x1.f1.lb.util.m mVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mVar = null;
        }
        fVar.j1(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1(String msg) {
        if (msg == null) {
            msg = "Unknown";
        }
        tf.e eVarE = x1.f1.lb.metric.monitor.h.f20952a.e();
        if (eVarE != null) {
            eVarE.s(d1.d());
        }
        if (eVarE != null) {
            eVarE.t(msg);
        }
        Long lValueOf = eVarE != null ? Long.valueOf(eVarE.i()) : null;
        if (eVarE != null) {
            eVarE.w((lValueOf != null ? lValueOf.longValue() : 0L) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n1(int reason) {
        if (reason == 0) {
            return "normal logout";
        }
        if (reason != 1) {
            if (reason == 2) {
                return "version not support";
            }
            if (reason == 3) {
                return "stream token expired";
            }
            if (reason != 4) {
                return reason != 5 ? "unknown" : "stream tmp logout";
            }
            return "auth token expired";
        }
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        String kickedOutBy = localSessionInfo2 != null ? localSessionInfo2.getKickedOutBy() : null;
        if (kickedOutBy == null || kickedOutBy.length() == 0) {
            kickedOutBy = "";
        }
        return "kick by other " + kickedOutBy + " session";
    }

    private final void q1(int errCode, String who) {
        logger.error("session terminate event, errCode[" + errCode + "], by[" + who + "]", new Object[0]);
        xe.c.c().l(new nf.u(errCode, who));
    }

    private final void r1() {
        kotlinx.coroutines.j.d(puckScope, null, null, new v(null), 3, null);
    }

    private final void v1() {
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 != null && localSessionInfo2.isKickedOut()) {
            isKickedOut.set(false);
            LocalSessionInfo localSessionInfo3 = localSessionInfo;
            if (localSessionInfo3 != null) {
                localSessionInfo3.setKickedOut(false);
            }
            LocalSessionInfo localSessionInfo4 = localSessionInfo;
            if (localSessionInfo4 != null) {
                localSessionInfo4.setKickedOutReason(0);
            }
            LocalSessionInfo localSessionInfo5 = localSessionInfo;
            if (localSessionInfo5 != null) {
                localSessionInfo5.setKickedOutBy("");
            }
            w1();
        }
        isSessionExpired.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1() {
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 == null) {
            return;
        }
        String strW = new com.google.gson.e().w(localSessionInfo2);
        w0 w0Var = w0.f21452a;
        kotlin.jvm.internal.m.c(strW);
        w0Var.t("local_session", strW);
    }

    private final List<ServerResponse> z0() {
        List<ServerResponse> streamServers;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 == null || (streamServers = localSessionInfo2.getStreamServers()) == null) ? new ArrayList() : streamServers;
    }

    public final String A0() {
        String streamToken;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 == null || (streamToken = localSessionInfo2.getStreamToken()) == null) ? "" : streamToken;
    }

    public final void A1(ReferralSummary referralSummary2) {
        kotlin.jvm.internal.m.f(referralSummary2, "referralSummary");
        referralSummary = referralSummary2;
        lastQueryReferralSummaryTime = d1.d();
    }

    public final String B0() {
        String string;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 == null || (string = Long.valueOf(localSessionInfo2.getAccountId()).toString()) == null) ? "" : string;
    }

    public final void B1(int remindFlag) {
        isRemindAfterExpired = remindFlag;
        w0.f21452a.r("um_is_remind_after_plan_expired", remindFlag);
    }

    public final String C0() {
        String string;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 == null || (string = Long.valueOf(localSessionInfo2.getAccountId()).toString()) == null) ? "" : string;
    }

    public final void C1(int remindFlag) {
        isRemindPlanNotBindUsername = remindFlag;
        w0.f21452a.r("um_is_remind_plan_not_bind_username", remindFlag);
    }

    public final Object E0(String str, String str2, String str3, v8.f<? super kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>>> fVar) {
        return aaaAdapter.l(str, str2, str3, fVar);
    }

    public final void H0() {
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("init user", new Object[0]);
        }
        inStart = Boolean.FALSE;
        isInLogin = false;
        isAuthRetSuccess = true;
        v1();
        x1.f1.lb.media.a.Q(x1.f1.lb.media.a.f20755a, false, false, 3, null);
        x1.f1.lb.media.l.f20862a.n();
    }

    public final boolean J0() {
        return isAuthRetSuccess;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x009d  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:51:0x0140  */
    /* JADX WARN: Code duplicated, block: B:55:0x0178  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ab, code lost:
    
        if (kotlinx.coroutines.v0.a(100, r1) == r3) goto L54;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:51:0x0140, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ab -> B:29:0x00af). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object J1(v6.c cVar, v8.f<? super kotlinx.coroutines.flow.f<Boolean>> fVar) {
        z zVar;
        f fVar2;
        List<ServerResponse> list;
        f fVar3;
        v6.c cVar2;
        AtomicBoolean atomicBoolean;
        String strB0;
        boolean z10;
        Object objI;
        v6.c cVar3;
        int i10;
        String str;
        if (fVar instanceof z) {
            zVar = (z) fVar;
            int i11 = zVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                zVar.label = i11 - Integer.MIN_VALUE;
                fVar2 = this;
            } else {
                fVar2 = this;
                zVar = fVar2.new z(fVar);
            }
        } else {
            fVar2 = this;
            zVar = fVar2.new z(fVar);
        }
        Object obj = zVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i12 = zVar.label;
        if (i12 == 0) {
            r8.r.b(obj);
            List<ServerResponse> listZ0 = fVar2.z0();
            if (listZ0.isEmpty()) {
                if (isAuthRetSuccess) {
                    x1.f1.lb.bot.a.f20583a.l("[no_stream_server]\nauth complete, but no stream server return");
                }
                xe.c.c().o(new nf.l());
                return kotlinx.coroutines.flow.h.v(new a0(null));
            }
            list = listZ0;
            fVar3 = fVar2;
            cVar2 = cVar;
            atomicBoolean = isEngineInStarting;
            if (atomicBoolean.compareAndSet(false, true)) {
                strB0 = fVar3.B0();
                if (lastEPlayType != cVar2) {
                }
                if (x1.f1.lb.config.b.f20643a.t()) {
                    logger.debug("Start engine[" + cVar2 + "]...", new Object[0]);
                }
                z10 = x1.f1.lb.util.z.f21470a.z();
                lastEPlayType = null;
                x1.f1.lb.streaming.client.a aVar = x1.f1.lb.streaming.client.a.f21004a;
                zVar.L$0 = cVar2;
                zVar.L$1 = list;
                zVar.L$2 = strB0;
                zVar.I$0 = z10 ? 1 : 0;
                zVar.label = 2;
                objI = aVar.i(zVar);
                if (objI != objC) {
                    cVar3 = cVar2;
                    obj = objI;
                    i10 = z10 ? 1 : 0;
                    str = strB0;
                }
            } else {
                zVar.L$0 = fVar3;
                zVar.L$1 = cVar2;
                zVar.L$2 = list;
                zVar.label = 1;
            }
            return objC;
        }
        if (i12 == 1) {
            list = (List) zVar.L$2;
            v6.c cVar4 = (v6.c) zVar.L$1;
            fVar3 = (f) zVar.L$0;
            r8.r.b(obj);
            cVar2 = cVar4;
            if (lastEPlayType == cVar2) {
                if (x1.f1.lb.config.b.f20643a.t()) {
                    logger.debug("Already start engine[" + cVar2 + "]", new Object[0]);
                }
                isEngineInStarting.set(false);
                return kotlinx.coroutines.flow.h.w(kotlin.coroutines.jvm.internal.b.a(true));
            }
            atomicBoolean = isEngineInStarting;
            if (atomicBoolean.compareAndSet(false, true)) {
                zVar.L$0 = fVar3;
                zVar.L$1 = cVar2;
                zVar.L$2 = list;
                zVar.label = 1;
            } else {
                strB0 = fVar3.B0();
                if (lastEPlayType != cVar2 && kotlin.jvm.internal.m.a(lastStartEngineUId, strB0) && d1.c() - lastEngineStartTime < 30000 && x1.f1.lb.streaming.client.a.f21004a.o()) {
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        logger.debug("Already start engine[" + cVar2 + "], too frequent to start engine", new Object[0]);
                    }
                    atomicBoolean.set(false);
                    return kotlinx.coroutines.flow.h.w(kotlin.coroutines.jvm.internal.b.a(true));
                }
                if (x1.f1.lb.config.b.f20643a.t()) {
                    logger.debug("Start engine[" + cVar2 + "]...", new Object[0]);
                }
                z10 = x1.f1.lb.util.z.f21470a.z();
                lastEPlayType = null;
                x1.f1.lb.streaming.client.a aVar2 = x1.f1.lb.streaming.client.a.f21004a;
                zVar.L$0 = cVar2;
                zVar.L$1 = list;
                zVar.L$2 = strB0;
                zVar.I$0 = z10 ? 1 : 0;
                zVar.label = 2;
                objI = aVar2.i(zVar);
                if (objI != objC) {
                    cVar3 = cVar2;
                    obj = objI;
                    i10 = z10 ? 1 : 0;
                    str = strB0;
                }
            }
            return objC;
        }
        if (i12 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i13 = zVar.I$0;
        String str2 = (String) zVar.L$2;
        List<ServerResponse> list2 = (List) zVar.L$1;
        v6.c cVar5 = (v6.c) zVar.L$0;
        r8.r.b(obj);
        str = str2;
        list = list2;
        cVar3 = cVar5;
        i10 = i13;
        return kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new b0(list, str, i10, cVar3, null));
    }

    public final boolean L0(String password) {
        kotlin.jvm.internal.m.f(password, "password");
        String strP1 = p1(password);
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return kotlin.jvm.internal.m.a(strP1, localSessionInfo2 != null ? localSessionInfo2.getPasswordDigest() : null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object M1(v8.f<? super kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>>> fVar) {
        d0 d0Var;
        String accessToken;
        if (fVar instanceof d0) {
            d0Var = (d0) fVar;
            int i10 = d0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                d0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                d0Var = new d0(fVar);
            }
        } else {
            d0Var = new d0(fVar);
        }
        Object objG = d0Var.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = d0Var.label;
        if (i11 == 0) {
            r8.r.b(objG);
            LocalSessionInfo localSessionInfo2 = localSessionInfo;
            if (localSessionInfo2 == null || (accessToken = localSessionInfo2.getAccessToken()) == null) {
                return kotlinx.coroutines.flow.h.w(new r8.u(kotlin.coroutines.jvm.internal.b.a(false), null, "access token is empty"));
            }
            x1.f1.lb.user.a<ApiResponse<?>> aVar = aaaAdapter;
            d0Var.label = 1;
            objG = aVar.g(accessToken, d0Var);
            if (objG == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(objG);
        }
        return new c0((kotlinx.coroutines.flow.f) objG);
    }

    public final kotlinx.coroutines.flow.f<FeedbackUploadResponse> N1(File feedbackFile) {
        kotlin.jvm.internal.m.f(feedbackFile, "feedbackFile");
        return kotlinx.coroutines.flow.h.v(new e0(feedbackFile, null));
    }

    public final boolean P0() {
        return isInLogout;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043  */
    /* JADX WARN: Code duplicated, block: B:23:0x0070 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0073  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006e -> B:24:0x0071). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:25:0x0073
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object Q0(java.lang.Long r12, v8.f<? super java.lang.Boolean> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof x1.f1.lb.user.f.i
            if (r0 == 0) goto L13
            r0 = r13
            x1.f1.lb.user.f$i r0 = (x1.f1.lb.user.f.i) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            x1.f1.lb.user.f$i r0 = new x1.f1.lb.user.f$i
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            long r5 = r0.J$0
            java.lang.Object r12 = r0.L$0
            java.lang.Long r12 = (java.lang.Long) r12
            r8.r.b(r13)
            goto L71
        L30:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L38:
            r8.r.b(r13)
            long r5 = x1.f1.lb.util.d1.c()
        L3f:
            java.lang.Boolean r13 = x1.f1.lb.user.f.inStart
            if (r13 == 0) goto L4d
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.b.a(r4)
            boolean r13 = kotlin.jvm.internal.m.a(r13, r2)
            if (r13 == 0) goto L8f
        L4d:
            boolean r13 = x1.f1.lb.user.f.isLocalSessionLoaded
            if (r13 != 0) goto L8f
            q6.b r13 = x1.f1.lb.user.f.logger
            java.lang.String r2 = "wait for the session creating complete"
            java.lang.Object[] r7 = new java.lang.Object[r3]
            r13.a(r2, r7)
            kotlinx.coroutines.i0 r13 = kotlinx.coroutines.a1.b()
            x1.f1.lb.user.f$j r2 = new x1.f1.lb.user.f$j
            r7 = 0
            r2.<init>(r7)
            r0.L$0 = r12
            r0.J$0 = r5
            r0.label = r4
            java.lang.Object r13 = kotlinx.coroutines.h.g(r13, r2, r0)
            if (r13 != r1) goto L71
            return r1
        L71:
            if (r12 == 0) goto L3f
            long r7 = r12.longValue()
            r9 = 0
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 <= 0) goto L3f
            long r7 = x1.f1.lb.util.d1.c()
            long r7 = r7 - r5
            long r9 = r12.longValue()
            int r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r13 <= 0) goto L3f
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r12
        L8f:
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.b.a(r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.user.f.Q0(java.lang.Long, v8.f):java.lang.Object");
    }

    public final boolean T0() {
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 != null ? localSessionInfo2.isLogout() : false) {
            return true;
        }
        LocalSessionInfo localSessionInfo3 = localSessionInfo;
        return localSessionInfo3 != null ? localSessionInfo3.isKickedOut() : false;
    }

    public final boolean V0(String code) {
        kotlin.jvm.internal.m.f(code, "code");
        return kotlin.jvm.internal.m.a(code, latestLoginRenewCode) && isRenewCodeFirstLogin;
    }

    public final void W() {
        String str;
        LocalSessionInfo localSessionInfo2;
        LocalSessionInfo localSessionInfo3 = localSessionInfo;
        if (localSessionInfo3 != null && localSessionInfo3.isRefreshAccessTokenFailure() && K0() && (localSessionInfo2 = localSessionInfo) != null && localSessionInfo2.isTriedLoginByUsernameFailure()) {
            return;
        }
        if (W0()) {
            q6.b bVar = logger;
            LocalSessionInfo localSessionInfo4 = localSessionInfo;
            Boolean boolValueOf = localSessionInfo4 != null ? Boolean.valueOf(localSessionInfo4.isKickedOut()) : null;
            LocalSessionInfo localSessionInfo5 = localSessionInfo;
            String kickedOutBy = localSessionInfo5 != null ? localSessionInfo5.getKickedOutBy() : null;
            if (kickedOutBy == null || kickedOutBy.length() == 0) {
                str = "";
            } else {
                str = " by " + kickedOutBy;
            }
            bVar.warn("session is out of service, kicked out[" + boolValueOf + "]" + ((Object) str) + ", expired[" + isSessionExpired, new Object[0]);
            return;
        }
        if (isInLogin) {
            return;
        }
        LocalSessionInfo localSessionInfo6 = localSessionInfo;
        if (X0(localSessionInfo6 != null ? localSessionInfo6.getAccessTokenExpiresTS() : null)) {
            if (!U0()) {
                q6.b bVar2 = logger;
                long jD = d1.d();
                LocalSessionInfo localSessionInfo7 = localSessionInfo;
                Long latestTokenUpdateTime = localSessionInfo7 != null ? localSessionInfo7.getLatestTokenUpdateTime() : null;
                LocalSessionInfo localSessionInfo8 = localSessionInfo;
                bVar2.warn("time to refresh token, now[ " + jD + " ] last[ " + latestTokenUpdateTime + " ], access token expire[ " + (localSessionInfo8 != null ? localSessionInfo8.getAccessTokenExpiresTS() : null) + " ]", new Object[0]);
                t1();
                return;
            }
            q6.b bVar3 = logger;
            long jD2 = d1.d();
            LocalSessionInfo localSessionInfo9 = localSessionInfo;
            String accessToken = localSessionInfo9 != null ? localSessionInfo9.getAccessToken() : null;
            LocalSessionInfo localSessionInfo10 = localSessionInfo;
            Long accessTokenExpiresTS = localSessionInfo10 != null ? localSessionInfo10.getAccessTokenExpiresTS() : null;
            LocalSessionInfo localSessionInfo11 = localSessionInfo;
            String refreshToken = localSessionInfo11 != null ? localSessionInfo11.getRefreshToken() : null;
            LocalSessionInfo localSessionInfo12 = localSessionInfo;
            bVar3.warn("refresh token is expired, now[ " + jD2 + " ], access token[" + accessToken + "] access token expire[ " + accessTokenExpiresTS + " ] refresh token[" + refreshToken + "] refresh token expire[ " + (localSessionInfo12 != null ? localSessionInfo12.getRefreshTokenExpiresTS() : null) + "]", new Object[0]);
            k1(this, null, 1, null);
        }
    }

    public final Integer X() {
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 != null && localSessionInfo2.isKickedOut()) {
            E1();
            return Integer.valueOf(R$string.session_kicked_out);
        }
        if (!isSessionExpired.get()) {
            return null;
        }
        I1();
        return Integer.valueOf(R$string.session_expired);
    }

    public final long Y() {
        if (x1.f1.lb.config.b.f20643a.t()) {
            return 1200000L;
        }
        return x1.f1.lb.heartbeat.f.f20678a.h0();
    }

    public final void Z0(String who, int reasonCode) {
        kotlin.jvm.internal.m.f(who, "who");
        if (isKickedOut.compareAndSet(false, true)) {
            LocalSessionInfo localSessionInfo2 = localSessionInfo;
            if (localSessionInfo2 != null) {
                localSessionInfo2.setKickedOutBy(who);
            }
            LocalSessionInfo localSessionInfo3 = localSessionInfo;
            if (localSessionInfo3 != null) {
                localSessionInfo3.setKickedOutReason(reasonCode);
            }
            LocalSessionInfo localSessionInfo4 = localSessionInfo;
            if (localSessionInfo4 != null) {
                localSessionInfo4.setKickedOut(true);
            }
            w1();
            E1();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0087, code lost:
    
        if (r2.u(r8, r0) == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a0(String str, v8.f<? super r8.z> fVar) {
        b bVar;
        String strB0;
        f fVar2;
        String str2;
        f fVar3;
        if (fVar instanceof b) {
            bVar = (b) fVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(fVar);
            }
        } else {
            bVar = new b(fVar);
        }
        Object obj = bVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = bVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                str2 = (String) bVar.L$1;
                fVar2 = (f) bVar.L$0;
                r8.r.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                fVar3 = (f) bVar.L$0;
                r8.r.b(obj);
            }
            x1.f1.lb.config.b bVar2 = x1.f1.lb.config.b.f20643a;
            if (!bVar2.t() && !bVar2.u()) {
                j0 j0Var = j0.f21396a;
                j0Var.c();
                j0Var.e();
            }
            fVar3.r1();
            localSessionCreatingCountDownLatch.countDown();
            xe.c.c().o(new nf.g());
            fVar3.H0();
            return r8.z.f17874a;
        }
        r8.r.b(obj);
        strB0 = B0();
        if (!kotlin.jvm.internal.m.a(str, strB0) || referralSummary == null) {
            referralSummary = null;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(x0(true), new c(null));
            kotlinx.coroutines.flow.g gVar = d.f21243a;
            bVar.L$0 = this;
            bVar.L$1 = strB0;
            bVar.label = 1;
            if (fVarF.collect(gVar, bVar) != objC) {
                fVar2 = this;
                str2 = strB0;
            }
        } else {
            fVar3 = this;
            x1.f1.lb.media.d dVar = x1.f1.lb.media.d.f20812a;
            bVar.L$0 = fVar3;
            bVar.L$1 = null;
            bVar.label = 2;
        }
        return objC;
        strB0 = str2;
        fVar3 = fVar2;
        x1.f1.lb.media.d dVar2 = x1.f1.lb.media.d.f20812a;
        bVar.L$0 = fVar3;
        bVar.L$1 = null;
        bVar.label = 2;
    }

    public final String b0() {
        String accessToken;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 == null || (accessToken = localSessionInfo2.getAccessToken()) == null) ? "" : accessToken;
    }

    public final Object b1(String str, String str2, String str3, String str4, String str5, v8.f<? super kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>>> fVar) {
        return aaaAdapter.c(str, str2, str3, str4, str5, fVar);
    }

    public final String c0() {
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return kotlin.jvm.internal.m.a(localSessionInfo2 != null ? localSessionInfo2.getAccountType() : null, "normal") ? "normal" : "guest";
    }

    public final Object d1(String str, String str2, String str3, v8.f<? super kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>>> fVar) {
        return aaaAdapter.e(str, p1(str3), str2, fVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e1(String str, v8.f<? super kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>>> fVar) {
        p pVar;
        String lastUsername;
        if (fVar instanceof p) {
            pVar = (p) fVar;
            int i10 = pVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                pVar.label = i10 - Integer.MIN_VALUE;
            } else {
                pVar = new p(fVar);
            }
        } else {
            pVar = new p(fVar);
        }
        Object objB = pVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = pVar.label;
        if (i11 == 0) {
            r8.r.b(objB);
            if (w0() > x1.f1.lb.heartbeat.f.f20678a.z0() && !O0()) {
                return kotlinx.coroutines.flow.h.w(new r8.u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-10), "limit continuing renew"));
            }
            LocalSessionInfo localSessionInfo2 = localSessionInfo;
            if (localSessionInfo2 == null || (lastUsername = localSessionInfo2.getLastUsername()) == null) {
                lastUsername = "";
            }
            if (lastUsername.length() > 0) {
                return kotlinx.coroutines.flow.h.w(new r8.u(kotlin.coroutines.jvm.internal.b.a(false), kotlin.coroutines.jvm.internal.b.b(-8), lastUsername));
            }
            x1.f1.lb.user.a<ApiResponse<?>> aVar = aaaAdapter;
            pVar.L$0 = str;
            pVar.label = 1;
            objB = aVar.b(str, pVar);
            if (objB == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) pVar.L$0;
            r8.r.b(objB);
        }
        return new n((kotlinx.coroutines.flow.f) objB, str);
    }

    public final String f0() {
        return String.valueOf(x1.f1.lb.util.k.f21398a.q());
    }

    public final kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>> f1(String usernameParam, String passwordParam, boolean loginAsGuest) {
        return new o(kotlinx.coroutines.flow.h.v(new q(usernameParam, passwordParam, loginAsGuest, null)));
    }

    public final String g0(String url) {
        kotlin.jvm.internal.m.f(url, "url");
        String accessToken = null;
        if (ua.n.O(url, "account/token/refresh", false, 2, null)) {
            LocalSessionInfo localSessionInfo2 = localSessionInfo;
            if (localSessionInfo2 != null) {
                accessToken = localSessionInfo2.getAccessToken();
            }
        } else {
            LocalSessionInfo localSessionInfo3 = localSessionInfo;
            if (localSessionInfo3 != null) {
                accessToken = localSessionInfo3.getAccessToken();
            }
        }
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("getAuthToken: [{}]->[{}]", url, accessToken);
        }
        return accessToken == null ? "" : accessToken;
    }

    public final String i0() {
        String code;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 == null || (code = localSessionInfo2.getCode()) == null) ? "" : code;
    }

    public final String j0() {
        return did;
    }

    public final String k0() {
        String email;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 == null || (email = localSessionInfo2.getEmail()) == null) ? "" : email;
    }

    public final String l0() {
        try {
            long jM0 = m0();
            String strH = jM0 == 0 ? "" : x1.f1.lb.util.n.n().h(15, jM0);
            kotlin.jvm.internal.m.c(strH);
            return strH;
        } catch (Throwable unused) {
            return "";
        }
    }

    public final long m0() {
        List<AccountSubscription> arrayList;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 == null || (arrayList = localSessionInfo2.getAccountSubscriptionList()) == null) {
            arrayList = new ArrayList<>();
        }
        long expireTs = 0;
        for (AccountSubscription accountSubscription : arrayList) {
            if (accountSubscription.getExpireTs() > expireTs) {
                expireTs = accountSubscription.getExpireTs();
            }
        }
        if (!O0() && expireTs == 0) {
            q6.b bVar = logger;
            String strC0 = c0();
            Integer numValueOf = Integer.valueOf(arrayList.size());
            LocalSessionInfo localSessionInfo3 = localSessionInfo;
            Long latestLoginResponseTime = localSessionInfo3 != null ? localSessionInfo3.getLatestLoginResponseTime() : null;
            LocalSessionInfo localSessionInfo4 = localSessionInfo;
            Long latestLocalLoadTime = localSessionInfo4 != null ? localSessionInfo4.getLatestLocalLoadTime() : null;
            LocalSessionInfo localSessionInfo5 = localSessionInfo;
            Long latestTokenUpdateTime = localSessionInfo5 != null ? localSessionInfo5.getLatestTokenUpdateTime() : null;
            LocalSessionInfo localSessionInfo6 = localSessionInfo;
            Long accessTokenExpiresTS = localSessionInfo6 != null ? localSessionInfo6.getAccessTokenExpiresTS() : null;
            LocalSessionInfo localSessionInfo7 = localSessionInfo;
            bVar.warn("get user expired ts, atp[{}] ssz[{}] lgt[{}] ldt[{}] tut[{}] tk_exp[{}] tk[{}]", strC0, numValueOf, latestLoginResponseTime, latestLocalLoadTime, latestTokenUpdateTime, accessTokenExpiresTS, localSessionInfo7 != null ? localSessionInfo7.getAccessToken() : null);
        }
        return expireTs;
    }

    public final kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>> m1(String from) {
        kotlin.jvm.internal.m.f(from, "from");
        logger.a("logout[{}]", from);
        return kotlinx.coroutines.flow.h.v(new t(null));
    }

    public final long o0() {
        Long latestLoginResponseTime;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 == null || (latestLoginResponseTime = localSessionInfo2.getLatestLoginResponseTime()) == null) {
            return 0L;
        }
        return latestLoginResponseTime.longValue();
    }

    public final LocalSessionInfo p0() {
        return localSessionInfo;
    }

    public final long q0() {
        return loginSession;
    }

    public final int r0() {
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 != null) {
            return localSessionInfo2.getKickedOutReason();
        }
        return 0;
    }

    public final String s0() {
        if (kotlin.jvm.internal.m.a(mark, "")) {
            String strB0 = B0();
            String strD = markKey;
            if (kotlin.jvm.internal.m.a(strD, "")) {
                strD = w6.a.d("*(^*&65Gikljio");
                markKey = strD;
            }
            x1.f1.lb.util.k kVar = x1.f1.lb.util.k.f21398a;
            String strB = w6.a.b(kVar.y() + ":" + kVar.u() + ":" + kVar.v() + ":" + kVar.r() + ":" + kVar.q() + ":" + strB0 + ":" + did + ":" + kVar.s(), strD);
            mark = strB != null ? strB : "";
        }
        return mark;
    }

    public final Object s1(String str, v8.f<? super kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>>> fVar) {
        return aaaAdapter.n(str, fVar);
    }

    public final String t0() {
        String memberShipUrl;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 == null || (memberShipUrl = localSessionInfo2.getMemberShipUrl()) == null) ? "" : memberShipUrl;
    }

    public final String u0() {
        String memberShipUrl;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 == null || (memberShipUrl = localSessionInfo2.getMemberShipUrl()) == null) {
            return "";
        }
        of.a aVar = of.a.f16585a;
        int iH = aVar.h();
        LocalSessionInfo localSessionInfo3 = localSessionInfo;
        String accessToken = localSessionInfo3 != null ? localSessionInfo3.getAccessToken() : null;
        String strL = aVar.l();
        return memberShipUrl + "?t=" + iH + "&a=" + accessToken + "&d=" + j0() + "&l=" + strL;
    }

    public final kotlinx.coroutines.flow.f<r8.u<Boolean, Integer, String>> u1(String username, String digitalCode, String newPassword, String captchaCode) {
        kotlin.jvm.internal.m.f(username, "username");
        kotlin.jvm.internal.m.f(digitalCode, "digitalCode");
        kotlin.jvm.internal.m.f(newPassword, "newPassword");
        kotlin.jvm.internal.m.f(captchaCode, "captchaCode");
        return kotlinx.coroutines.flow.h.v(new x(digitalCode, username, newPassword, captchaCode, null));
    }

    public final String v0() {
        String phone;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 == null || (phone = localSessionInfo2.getPhone()) == null) ? "" : phone;
    }

    public final kotlinx.coroutines.flow.f<ReferralSummary> x0(boolean isForce) {
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (!bVar.i() || !bVar.f() || D0().length() == 0) {
            return kotlinx.coroutines.flow.h.w(null);
        }
        long jD = d1.d() - lastQueryReferralSummaryTime;
        ReferralSummary referralSummary2 = referralSummary;
        return (referralSummary2 == null || (isForce && jD > 30000) || jD > 600000) ? kotlinx.coroutines.flow.h.v(new e(isForce, null)) : kotlinx.coroutines.flow.h.w(referralSummary2);
    }

    public final void x1() {
        if (isSessionExpired.compareAndSet(false, true)) {
            I1();
        }
    }

    public final String y0() {
        String refreshToken;
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        return (localSessionInfo2 == null || (refreshToken = localSessionInfo2.getRefreshToken()) == null) ? "" : refreshToken;
    }

    public final void y1(LocalSessionInfo newLocalSessionInfo) {
        kotlin.jvm.internal.m.f(newLocalSessionInfo, "newLocalSessionInfo");
        String streamToken = newLocalSessionInfo.getStreamToken();
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        boolean zA = kotlin.jvm.internal.m.a(streamToken, localSessionInfo2 != null ? localSessionInfo2.getStreamToken() : null);
        LocalSessionInfo localSessionInfo3 = localSessionInfo;
        boolean z10 = localSessionInfo3 == null || newLocalSessionInfo.getAccountId() != localSessionInfo3.getAccountId() || T0();
        try {
            LocalSessionInfo localSessionInfo4 = localSessionInfo;
            if (!kotlin.jvm.internal.m.a(localSessionInfo4 != null ? localSessionInfo4.getAccountType() : null, newLocalSessionInfo.getAccountType()) && zA) {
                q6.b bVar = logger;
                LocalSessionInfo localSessionInfo5 = localSessionInfo;
                String accountType = localSessionInfo5 != null ? localSessionInfo5.getAccountType() : null;
                bVar.warn("accountType changed[" + accountType + "] ->[" + newLocalSessionInfo.getAccountType() + "], but streamToken no change[" + newLocalSessionInfo.getStreamToken() + "]", new Object[0]);
            }
            localSessionInfo = newLocalSessionInfo;
            if (G0()) {
                remindAfterExpiredLastRemindTime = 0L;
                w0 w0Var = w0.f21452a;
                w0Var.s("um_plan_last_remind_time", 0L);
                if (isRemindAfterExpired == 0) {
                    isRemindAfterExpired = 1;
                    w0Var.r("um_is_remind_after_plan_expired", 1);
                }
            }
            if (z10) {
                kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new y(null), 3, null);
            } else {
                x1.f1.lb.streaming.client.a aVar = x1.f1.lb.streaming.client.a.f21004a;
                if (aVar.o()) {
                    String streamToken2 = newLocalSessionInfo.getStreamToken();
                    kotlin.jvm.internal.m.e(streamToken2, "getStreamToken(...)");
                    aVar.p(streamToken2);
                } else {
                    logger.a("try refresh stream token, but engine is not running", new Object[0]);
                }
            }
            x1.f1.lb.log.a aVar2 = x1.f1.lb.log.a.f20729a;
            of.a aVar3 = of.a.f16585a;
            aVar2.l(aVar3.f(), aVar3.b(), aVar3.k());
            w1();
        } catch (Throwable th) {
            try {
                logger.warn("refresh stream token failure", th);
            } finally {
                w1();
            }
        }
    }

    public final void z1(int remindFlag) {
        planWillExpireRemind = remindFlag;
        if (remindFlag == 1) {
            planWillExpireLastRemindTime = 0L;
        } else if (remindFlag > 1) {
            planWillExpireLastRemindTime = planWillExpireRemindTimeInStartup;
        }
        w0.f21452a.r("um_plan_will_expire_remind", remindFlag);
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean D1() {
        long jC = d1.c();
        if (!isInLogin && jC - lastTryLoginTime >= x1.f1.lb.heartbeat.f.f20678a.k0()) {
            isInLogin = true;
            lastTryLoginTime = jC;
            return true;
        }
        return false;
    }

    private final void I1() {
        q1(9000010, "api");
        F1(R$string.session_expired, "Your session is expired, please login");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U0() {
        Long refreshTokenExpiresTS;
        if (y0().length() != 0) {
            LocalSessionInfo localSessionInfo2 = localSessionInfo;
            if (localSessionInfo2 != null) {
                refreshTokenExpiresTS = localSessionInfo2.getRefreshTokenExpiresTS();
            } else {
                refreshTokenExpiresTS = null;
            }
            if (Y0(refreshTokenExpiresTS)) {
                return true;
            }
            return false;
        }
        return true;
    }

    private final String h0() {
        if (G0()) {
            return "plan";
        }
        return "free";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p1(String clearPassword) {
        String strO = x1.f1.lb.util.n.n().o(clearPassword);
        kotlin.jvm.internal.m.e(strO, "md5(...)");
        return strO;
    }

    private final void t1() {
        String refreshToken;
        if (T0()) {
            k1(this, null, 1, null);
            return;
        }
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 != null && (refreshToken = localSessionInfo2.getRefreshToken()) != null) {
            kotlinx.coroutines.j.d(puckScope, null, null, new w(refreshToken, null), 3, null);
        }
    }

    public final String D0() {
        String username;
        if (T0()) {
            return "";
        }
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 == null || (username = localSessionInfo2.getUsername()) == null) {
            username = "";
        }
        if (username.length() == 0) {
            f fVar = f21202a;
            String strK0 = fVar.k0();
            if (strK0.length() == 0) {
                String strV0 = fVar.v0();
                if (strV0.length() == 0) {
                    return "";
                }
                return strV0;
            }
            return strK0;
        }
        return username;
    }

    public final boolean G0() {
        if (T0() || d1.d() > m0()) {
            return false;
        }
        return true;
    }

    public final boolean I0() {
        Long accessTokenExpiresTS;
        if (b0().length() != 0) {
            LocalSessionInfo localSessionInfo2 = localSessionInfo;
            if (localSessionInfo2 != null) {
                accessTokenExpiresTS = localSessionInfo2.getAccessTokenExpiresTS();
            } else {
                accessTokenExpiresTS = null;
            }
            if (Y0(accessTokenExpiresTS)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean K0() {
        if (D0().length() > 0) {
            return true;
        }
        return false;
    }

    public final boolean M0() {
        if (O0()) {
            return true;
        }
        return !G0();
    }

    public final boolean N0() {
        if (!kotlin.jvm.internal.m.a(c0(), "guest") && !kotlin.jvm.internal.m.a(h0(), "free")) {
            return false;
        }
        return true;
    }

    public final boolean O0() {
        if (!T0() && !kotlin.jvm.internal.m.a(c0(), "guest")) {
            return false;
        }
        return true;
    }

    public final boolean S0() {
        if (T0()) {
            return false;
        }
        return isAuthRetSuccess;
    }

    public final boolean d0() {
        if (G0()) {
            return false;
        }
        int i10 = isRemindAfterExpired;
        if (i10 == 1) {
            if (remindAfterExpiredLastRemindTime != 0) {
                return false;
            }
            isRemindAfterExpired = 0;
            w0 w0Var = w0.f21452a;
            w0Var.r("um_is_remind_after_plan_expired", 0);
            long jD = d1.d();
            remindAfterExpiredLastRemindTime = jD;
            w0Var.s("um_plan_last_remind_time", jD);
            return true;
        }
        if (i10 <= 1) {
            return false;
        }
        return true;
    }

    public final boolean e0() {
        long jD = d1.d();
        long jM0 = m0();
        if (x1.f1.lb.heartbeat.f.f20678a.q0() + jD >= jM0 && jD < jM0) {
            int i10 = planWillExpireRemind;
            if (i10 == 1) {
                if (planWillExpireLastRemindTime != 0) {
                    return false;
                }
                planWillExpireLastRemindTime = jD;
                w0.f21452a.s("um_plan_will_expire_last_remind_time", jD);
                return true;
            }
            if (i10 > 1) {
                long j10 = jD - planWillExpireLastRemindTime;
                if (j10 > ((long) i10) * 3600000) {
                    planWillExpireLastRemindTime = jD;
                    w0.f21452a.s("um_plan_will_expire_last_remind_time", jD);
                    return true;
                }
                if (j10 < 0) {
                    planWillExpireLastRemindTime = 0L;
                    w0.f21452a.s("um_plan_will_expire_last_remind_time", 0L);
                }
            }
        }
        return false;
    }

    public final long n0() {
        long freeTimeMs;
        long jM0 = m0() - d1.d();
        LocalSessionInfo localSessionInfo2 = localSessionInfo;
        if (localSessionInfo2 != null) {
            freeTimeMs = localSessionInfo2.getFreeTimeMs();
        } else {
            freeTimeMs = 0;
        }
        if (jM0 <= 0) {
            jM0 = 0;
        }
        return freeTimeMs + jM0;
    }

    public final void o1() {
        long jD = d1.d();
        long j10 = jD - lastStreamTokenExpireTime;
        x1.f1.lb.heartbeat.f fVar = x1.f1.lb.heartbeat.f.f20678a;
        if (j10 > fVar.k0()) {
            j1(new u());
            lastStreamTokenExpireTime = jD;
            return;
        }
        logger.a("stream token expired event is too frequent, not reach the re-login interval[" + j10 + " < " + fVar.k0() + "]", new Object[0]);
    }

    private final void G1(String digitalCode, String contact, String reason, x1.f1.lb.util.m<Integer> onLoginSuccessCallback, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnDismissListener onDismissListener) {
    }
}
