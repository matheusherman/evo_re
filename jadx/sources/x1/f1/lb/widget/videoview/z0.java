package x1.f1.lb.widget.videoview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlinx.coroutines.g2;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.LocationInfo;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import x.l1.b2.R$string;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 \u009f\u00032\u00020\u00012\u00020\u00022\u00020\u0003:\u0006Ý\u0001\u0085\u0001ã\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0013\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\"\u0010\u001cJ\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010(JM\u0010.\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b.\u0010/J!\u00100\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\fH\u0002¢\u0006\u0004\b2\u0010\u0005J!\u00104\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u00101J)\u00107\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u00103\u001a\u00020\u00062\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\fH\u0002¢\u0006\u0004\b9\u0010\u0005J\u000f\u0010:\u001a\u00020\fH\u0002¢\u0006\u0004\b:\u0010\u0005J\u001d\u0010;\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010>\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b@\u0010\u001cJ\u0017\u0010A\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bA\u0010\u001cJ\u0019\u0010D\u001a\u00020\n2\b\u0010C\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\bF\u0010GJ\u001b\u0010I\u001a\u0004\u0018\u00010\u00062\b\u0010H\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\bI\u0010JJ)\u0010L\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010K\u001a\u0004\u0018\u00010B2\u0006\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\fH\u0002¢\u0006\u0004\bN\u0010\u0005J!\u0010Q\u001a\u00020#2\b\u0010O\u001a\u0004\u0018\u00010\n2\u0006\u0010P\u001a\u000205H\u0002¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\fH\u0002¢\u0006\u0004\bS\u0010\u0005J\u000f\u0010T\u001a\u00020\fH\u0002¢\u0006\u0004\bT\u0010\u0005J\u0017\u0010U\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bU\u0010\u001cJ\u0017\u0010V\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bV\u0010\u001cJ\u0015\u0010X\u001a\b\u0012\u0004\u0012\u0002050WH\u0002¢\u0006\u0004\bX\u0010YJ\u0019\u0010Z\u001a\u0002052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\bZ\u0010[J\u0017\u0010]\u001a\u00020\f2\u0006\u0010\\\u001a\u000205H\u0002¢\u0006\u0004\b]\u0010^J\u0012\u0010_\u001a\u0004\u0018\u00010\nH\u0082@¢\u0006\u0004\b_\u0010`J\u0017\u0010a\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\ba\u0010bJ%\u0010c\u001a\u00020\u00062\b\u0010O\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\be\u0010\u001cJ\u0017\u0010f\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\bf\u0010\u001cJ\u000f\u0010g\u001a\u000205H\u0002¢\u0006\u0004\bg\u0010hJ\u000f\u0010i\u001a\u00020\fH\u0002¢\u0006\u0004\bi\u0010\u0005J\u000f\u0010j\u001a\u00020#H\u0002¢\u0006\u0004\bj\u0010%J)\u0010l\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\n2\b\b\u0002\u0010k\u001a\u00020#H\u0002¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020#H\u0002¢\u0006\u0004\bn\u0010%J\u0017\u0010o\u001a\u00020\f2\u0006\u0010P\u001a\u000205H\u0002¢\u0006\u0004\bo\u0010^J\u0019\u0010q\u001a\u0004\u0018\u00010\u00062\u0006\u0010p\u001a\u00020\u0006H\u0002¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020\fH\u0002¢\u0006\u0004\bs\u0010\u0005J%\u0010x\u001a\u00020\f2\u0006\u0010u\u001a\u00020t2\u0006\u0010w\u001a\u00020v2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\bx\u0010yJ\u0017\u0010z\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0004¢\u0006\u0004\bz\u0010!J\r\u0010{\u001a\u00020\u0006¢\u0006\u0004\b{\u0010|J\u0018\u0010\u007f\u001a\u00020\f2\u0006\u0010~\u001a\u00020}H\u0007¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0019\u0010\u007f\u001a\u00020\f2\u0007\u0010~\u001a\u00030\u0081\u0001H\u0007¢\u0006\u0005\b\u007f\u0010\u0082\u0001J\u0019\u0010\u007f\u001a\u00020\f2\u0007\u0010~\u001a\u00030\u0083\u0001H\u0007¢\u0006\u0005\b\u007f\u0010\u0084\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\f2\u0007\u0010\u0085\u0001\u001a\u00020#¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J,\u0010\u008a\u0001\u001a\u00020\f2\u001a\u0010\u0089\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0088\u0001¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J,\u0010\u008c\u0001\u001a\u00020\f2\u001a\u0010\u0089\u0001\u001a\u0015\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0088\u0001¢\u0006\u0006\b\u008c\u0001\u0010\u008b\u0001J \u0010\u008e\u0001\u001a\u00020\f2\u000e\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u008d\u0001¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001b\u0010\u0091\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0090\u0001\u001a\u00020\n¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J1\u0010\u0094\u0001\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n2\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0006¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J2\u0010\u0097\u0001\u001a\u00020\f2\u0007\u0010\u0096\u0001\u001a\u00020\n2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n2\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0006¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u000f\u0010\u0099\u0001\u001a\u00020\f¢\u0006\u0005\b\u0099\u0001\u0010\u0005J\u000f\u0010\u009a\u0001\u001a\u00020\f¢\u0006\u0005\b\u009a\u0001\u0010\u0005J\u000f\u0010\u009b\u0001\u001a\u00020\f¢\u0006\u0005\b\u009b\u0001\u0010\u0005J\u0011\u0010\u009c\u0001\u001a\u000205H\u0016¢\u0006\u0005\b\u009c\u0001\u0010hJ\u0012\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0006¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u000f\u0010\u009f\u0001\u001a\u000205¢\u0006\u0005\b\u009f\u0001\u0010hJ\u000f\u0010 \u0001\u001a\u00020\u0006¢\u0006\u0005\b \u0001\u0010|J\u000f\u0010¡\u0001\u001a\u00020\u0006¢\u0006\u0005\b¡\u0001\u0010|J\u000f\u0010¢\u0001\u001a\u00020\u0006¢\u0006\u0005\b¢\u0001\u0010|J\u0012\u0010£\u0001\u001a\u0004\u0018\u00010\u0006¢\u0006\u0006\b£\u0001\u0010\u009e\u0001J\u0012\u0010¤\u0001\u001a\u0004\u0018\u00010\u0006¢\u0006\u0006\b¤\u0001\u0010\u009e\u0001J\u0011\u0010¥\u0001\u001a\u00020#H\u0016¢\u0006\u0005\b¥\u0001\u0010%J\u000f\u0010¦\u0001\u001a\u00020#¢\u0006\u0005\b¦\u0001\u0010%J\u000f\u0010§\u0001\u001a\u00020#¢\u0006\u0005\b§\u0001\u0010%J\u000f\u0010¨\u0001\u001a\u00020#¢\u0006\u0005\b¨\u0001\u0010%J\u000f\u0010©\u0001\u001a\u00020#¢\u0006\u0005\b©\u0001\u0010%J\u0018\u0010ª\u0001\u001a\u00020#2\u0006\u0010&\u001a\u00020\n¢\u0006\u0006\bª\u0001\u0010«\u0001J!\u0010\u00ad\u0001\u001a\u00020\f2\u0007\u0010¬\u0001\u001a\u00020\n2\u0006\u0010\\\u001a\u000205¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u0019\u0010°\u0001\u001a\u00020#2\u0007\u0010¯\u0001\u001a\u000205¢\u0006\u0006\b°\u0001\u0010±\u0001J\u001b\u0010³\u0001\u001a\u0002052\t\b\u0002\u0010²\u0001\u001a\u00020#¢\u0006\u0006\b³\u0001\u0010´\u0001J!\u0010¶\u0001\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0007\u0010µ\u0001\u001a\u00020#¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u000f\u0010¸\u0001\u001a\u00020\u0006¢\u0006\u0005\b¸\u0001\u0010|J\u0017\u0010¹\u0001\u001a\u00020\f2\u0006\u0010p\u001a\u00020\u0006¢\u0006\u0005\b¹\u0001\u0010bJ\u001c\u0010¼\u0001\u001a\u00020\f2\n\u0010»\u0001\u001a\u0005\u0018\u00010º\u0001¢\u0006\u0006\b¼\u0001\u0010½\u0001J\u001c\u0010À\u0001\u001a\u00020\f2\n\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u0001¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u001c\u0010Ä\u0001\u001a\u00020\f2\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Â\u0001¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\u001c\u0010È\u0001\u001a\u00020\f2\n\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u0001¢\u0006\u0006\bÈ\u0001\u0010É\u0001J\u001c\u0010Ì\u0001\u001a\u00020\f2\n\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u0001¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u001a\u0010Ï\u0001\u001a\u00020\f2\b\u0010\u0089\u0001\u001a\u00030Î\u0001¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\u001a\u0010Ó\u0001\u001a\f\u0012\u0005\u0012\u00030Ò\u0001\u0018\u00010Ñ\u0001¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J\u001a\u0010Õ\u0001\u001a\u00020\f2\b\u0010O\u001a\u0004\u0018\u00010\n¢\u0006\u0006\bÕ\u0001\u0010\u0092\u0001J?\u0010Ù\u0001\u001a\u00020#2\u0006\u0010,\u001a\u00020\n2\b\u0010O\u001a\u0004\u0018\u00010\n2\t\u0010Ö\u0001\u001a\u0004\u0018\u00010\n2\b\u0010Ø\u0001\u001a\u00030×\u00012\u0006\u0010P\u001a\u000205¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001R\"\u0010ß\u0001\u001a\r Ü\u0001*\u0005\u0018\u00010Û\u00010Û\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u001a\u0010â\u0001\u001a\u00030à\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0085\u0001\u0010á\u0001R\u001a\u0010å\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u001a\u0010ç\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bæ\u0001\u0010ä\u0001R\u001a\u0010ë\u0001\u001a\u00030è\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u001a\u0010î\u0001\u001a\u00030º\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001a\u0010ñ\u0001\u001a\u00030¾\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u001a\u0010õ\u0001\u001a\u00030ò\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bó\u0001\u0010ô\u0001R\u001a\u0010÷\u0001\u001a\u00030Ê\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¯\u0001\u0010ö\u0001R\u001a\u0010ú\u0001\u001a\u00030Æ\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R\u001a\u0010ý\u0001\u001a\u00030Â\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u001a\u0010ÿ\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bþ\u0001\u0010ä\u0001R\u001a\u0010\u0081\u0002\u001a\u00030Î\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0080\u0002\u0010ä\u0001R\u0018\u0010\u0085\u0002\u001a\u00030\u0082\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0018\u0010\u0089\u0002\u001a\u00030\u0086\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0002\u0010\u0088\u0002R\u0019\u0010\u008c\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0002\u0010\u008b\u0002R\u0019\u0010\u008e\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010\u008b\u0002R\u0017\u0010\u0090\u0002\u001a\u0002058\u0002X\u0082D¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u008b\u0002R\u001b\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0002\u0010\u0092\u0002R\u001b\u0010\u0096\u0002\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0002\u0010\u0095\u0002R\u001c\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0002\u0010\u0099\u0002R\u001c\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u0099\u0002R\u0019\u0010\u009f\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010\u009e\u0002R\u001a\u0010£\u0002\u001a\u00030 \u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0002\u0010¢\u0002R\u0019\u0010¦\u0002\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0002\u0010¥\u0002R\u0019\u0010¨\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0002\u0010\u009e\u0002R\u0019\u0010ª\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0002\u0010\u008b\u0002R\u0019\u0010¬\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010\u008b\u0002R\u0019\u0010¯\u0002\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0002\u0010®\u0002R\u0019\u0010±\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0002\u0010\u009e\u0002R\u0019\u0010³\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010\u009e\u0002R\u0019\u0010µ\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0002\u0010\u009e\u0002R\u0019\u0010·\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0002\u0010\u009e\u0002R\u0019\u0010¹\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0002\u0010\u008b\u0002R\u001b\u0010»\u0002\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0002\u0010º\u0002R\u0019\u0010¼\u0002\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010®\u0002R\u001a\u0010À\u0002\u001a\u00030½\u00028\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¾\u0002\u0010¿\u0002R\u001c\u0010Â\u0002\u001a\u0005\u0018\u00010Â\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0002\u0010ü\u0001R\u001c\u0010Ä\u0002\u001a\u0005\u0018\u00010º\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0002\u0010í\u0001R\u001c\u0010Æ\u0002\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0002\u0010ù\u0001R\u001c\u0010È\u0002\u001a\u0005\u0018\u00010Ê\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0002\u0010ö\u0001R\u001c\u0010Ê\u0002\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0002\u0010ð\u0001R\u001c\u0010Ì\u0002\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0002\u0010ä\u0001R\u0019\u0010Î\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0002\u0010\u009e\u0002R\u0019\u0010Ð\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0002\u0010\u008b\u0002R\u001b\u0010Ò\u0002\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0002\u0010¥\u0002R*\u0010Ø\u0002\u001a\u00030 \u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÓ\u0002\u0010¢\u0002\u001a\u0006\bÔ\u0002\u0010Õ\u0002\"\u0006\bÖ\u0002\u0010×\u0002R\u0019\u0010Ú\u0002\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0002\u0010\u008b\u0002R\u001a\u0010Ý\u0002\u001a\u00030×\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0002\u0010Ü\u0002R\u0019\u0010ß\u0002\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0002\u0010®\u0002R\u001b\u0010á\u0002\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0002\u0010¥\u0002R'\u0010ä\u0002\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b®\u0002\u0010\u008b\u0002\u001a\u0005\bâ\u0002\u0010h\"\u0005\bã\u0002\u0010^R'\u0010è\u0002\u001a\u0002058\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bå\u0002\u0010\u008b\u0002\u001a\u0005\bæ\u0002\u0010h\"\u0005\bç\u0002\u0010^R(\u0010ì\u0002\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bé\u0002\u0010®\u0002\u001a\u0005\bê\u0002\u0010%\"\u0006\bë\u0002\u0010\u0087\u0001R(\u0010ð\u0002\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bí\u0002\u0010®\u0002\u001a\u0005\bî\u0002\u0010%\"\u0006\bï\u0002\u0010\u0087\u0001R+\u0010ö\u0002\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bñ\u0002\u0010ò\u0002\u001a\u0006\bó\u0002\u0010\u009e\u0001\"\u0006\bô\u0002\u0010õ\u0002R\u0019\u0010ø\u0002\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0002\u0010®\u0002R\u0019\u0010ú\u0002\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0002\u0010®\u0002R\u001b\u0010ý\u0002\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0002\u0010ü\u0002R\u001a\u0010\u0080\u0003\u001a\u00030þ\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0002\u0010°\u0002R\u001c\u0010\u0084\u0003\u001a\u0005\u0018\u00010\u0081\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0003\u0010\u0083\u0003R\u0019\u0010\u0086\u0003\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0003\u0010\u008b\u0002R\u0019\u0010\u0088\u0003\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0003\u0010\u008b\u0002R\u0019\u0010\u008a\u0003\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0003\u0010\u008b\u0002R#\u0010\u008d\u0003\u001a\f\u0012\u0005\u0012\u00030Ò\u0001\u0018\u00010Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0003\u0010\u008c\u0003R\u0019\u0010\u008f\u0003\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0003\u0010\u009e\u0002R\u0019\u0010\u0091\u0003\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0003\u0010®\u0002R.\u0010\u0094\u0003\u001a\u0017\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0003\u0010\u0093\u0003R.\u0010\u0096\u0003\u001a\u0017\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0003\u0010\u0093\u0003R\"\u0010\u0099\u0003\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0003\u0010\u0098\u0003R\u001b\u0010\u009b\u0003\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0003\u0010¥\u0002R\u001b\u0010\u009e\u0003\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0003\u0010\u009d\u0003¨\u0006 \u0003"}, d2 = {"Lx1/f1/lb/widget/videoview/z0;", "", "Lx1/f1/lb/metric/monitor/c;", "Lxf/a;", "<init>", "()V", "", "decodeMode", "Lx1/f1/lb/widget/videoview/z0$b;", "mediaUriHandler", "", "playUri", "Lr8/z;", "V1", "(ILx1/f1/lb/widget/videoview/z0$b;Ljava/lang/String;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "A0", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "W1", "(Ljava/lang/String;Ljava/lang/Integer;)V", "playerId", "uriHandler", "d2", "(ILx1/f1/lb/widget/videoview/z0$b;)V", "Lx1/f1/lb/widget/videoview/j;", "playerInfo", "H0", "(Lx1/f1/lb/widget/videoview/j;)V", "q1", "Lx1/f1/lb/widget/videoview/c;", "renderView", "C2", "(Lx1/f1/lb/widget/videoview/c;)V", "u1", "", "L1", "()Z", TypedValues.TransitionType.S_FROM, "G0", "(Lx1/f1/lb/widget/videoview/j;Ljava/lang/String;)V", "isForceStop", "reason", "resId", "videoName", "code", "R1", "(Lx1/f1/lb/widget/videoview/j;ZILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "g1", "(Lx1/f1/lb/widget/videoview/j;I)V", "B1", "what", "b2", "", "delayMillis", "k2", "(Lx1/f1/lb/widget/videoview/j;IJ)V", "A1", "E1", "Y0", "(Lx1/f1/lb/widget/videoview/j;)Ltv/danmaku/ijk/media/player/IMediaPlayer;", "info", "J1", "(Lx1/f1/lb/widget/videoview/j;)Z", "C1", "r1", "Lx1/f1/lb/widget/videoview/d;", "surfaceHolder", "j1", "(Lx1/f1/lb/widget/videoview/d;)Ljava/lang/String;", "i1", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)Ljava/lang/String;", "obj", "h1", "(Ljava/lang/Object;)Ljava/lang/Integer;", "holder", "B0", "(Lx1/f1/lb/widget/videoview/j;Lx1/f1/lb/widget/videoview/d;Ljava/lang/String;)V", "D2", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "session", "S2", "(Ljava/lang/String;J)Z", "a2", "T2", "F0", "P1", "Lkotlinx/coroutines/flow/f;", "M1", "()Lkotlinx/coroutines/flow/f;", "T0", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)J", "position", "i2", "(J)V", "a1", "(Lv8/f;)Ljava/lang/Object;", "o2", "(I)V", "P0", "(Ljava/lang/String;Ljava/lang/Integer;)I", "T1", "Q1", "C0", "()J", "l2", "E0", "isForce", "I2", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;Ljava/lang/String;Z)Z", "I1", "O2", "aspectRatioType", "D0", "(I)Ljava/lang/Integer;", "c2", "Landroid/content/Context;", "context", "Lx1/f1/lb/widget/videoview/e;", "videoView", "m1", "(Landroid/content/Context;Lx1/f1/lb/widget/videoview/e;Lx1/f1/lb/widget/videoview/c;)V", "D1", "O0", "()I", "Lnf/v;", NotificationCompat.CATEGORY_EVENT, "onEvent", "(Lnf/v;)V", "Lnf/l;", "(Lnf/l;)V", "Lnf/t;", "(Lnf/t;)V", "b", "G2", "(Z)V", "Lkotlin/Function2;", "listener", "t2", "(Lc9/p;)V", "q2", "Lkotlin/Function0;", "A2", "(Lc9/a;)V", NotificationCompat.CATEGORY_MESSAGE, "K2", "(Ljava/lang/String;)V", "errorCode", "I0", "(ILjava/lang/String;Ljava/lang/Integer;)V", "tip", "J0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "l1", "k1", "Q2", "N0", "Q0", "()Ljava/lang/Integer;", "S0", "R0", "e1", "f1", "O1", "N1", "K1", "H1", "G1", "H2", "h2", "U1", "(Ljava/lang/String;)Z", "seekKey", "Z1", "(Ljava/lang/String;J)V", "i", "j2", "(J)Z", "isTerminate", "N2", "(Z)J", "restartPlayer", "p2", "(IZ)V", "M0", "m2", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "onCompletionListener", "u2", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "onErrorListener", "v2", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "onInfoListener", "w2", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "onPreparedListener", "x2", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "onSeekCompleteListener", "z2", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;)V", "Ljava/lang/Runnable;", "y2", "(Ljava/lang/Runnable;)V", "", "Ltv/danmaku/ijk/media/player/misc/ITrackInfo;", "d1", "()[Ltv/danmaku/ijk/media/player/misc/ITrackInfo;", "E2", "playerArgs", "Lv6/c;", "playType", "F2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv6/c;J)Z", "Lq6/b;", "kotlin.jvm.PlatformType", "a", "Lq6/b;", "logger", "Lx1/f1/lb/widget/videoview/z0$c;", "Lx1/f1/lb/widget/videoview/z0$c;", "mPlayerMeter", "c", "Ljava/lang/Runnable;", "mGatewayTimeoutHandler", "d", "mOnMediaBufferAnimationHandler", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "e", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "mOnVideoSizeChangedListener", "f", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "mOnCompletionListenerWrapper", "g", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "mOnErrorListenerWrapper", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "h", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "mOnBufferingUpdateListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "mOnSeekCompleteListenerWrapper", "j", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "mOnPreparedListenerWrapper", "k", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "mOnInfoListenerWrapper", "l", "mOnMediaBufferPlayHandler", "m", "checkPlayingHandler", "Lx1/f1/lb/metric/monitor/b;", "n", "Lx1/f1/lb/metric/monitor/b;", "playerMonitor", "Lx1/f1/lb/metric/monitor/d;", "o", "Lx1/f1/lb/metric/monitor/d;", "streamingMonitor", "p", "J", "mVideoDuration", "q", "mGatewayTimeoutMillis", "r", "mPlayerNotPlayingRestartIntervalMillis", "s", "Lx1/f1/lb/widget/videoview/c;", "mRenderView", "t", "Lx1/f1/lb/widget/videoview/d;", "mSurfaceHolder", "Lx1/f1/lb/widget/videoview/b;", "u", "Lx1/f1/lb/widget/videoview/b;", "mRenderCallback", "v", "mLastRenderCallback", "w", "I", "mIsSoftDecoder", "Ljava/util/concurrent/atomic/AtomicLong;", "x", "Ljava/util/concurrent/atomic/AtomicLong;", "startPlayInitTime", "y", "Ljava/lang/String;", "mVideoName", "z", "mLastDecodeMode", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mMediaBufferingBeginTime", "B", "lastSentBufferingRestartEventTime", "C", "Z", "mIsPaused", "D", "sendRestartCnt", ExifInterface.LONGITUDE_EAST, "mVideoWidth", "F", "mAspectRatioType", "G", "mVideoHeight", "H", "mHardwareDecodeFlag", "Lx1/f1/lb/widget/videoview/j;", "mPlayerInfo", "isPlayerInInitializing", "Landroid/os/Handler;", "K", "Landroid/os/Handler;", "mHandler", "L", "mOnInfoListener", "M", "mOnCompletionListener", "N", "mOnPreparedListener", "O", "mOnSeekCompleteListener", "P", "mOnErrorListener", "Q", "mOnRenderCompleteListener", "R", "mBufferPercent", ExifInterface.LATITUDE_SOUTH, "mSeekPosition", ExifInterface.GPS_DIRECTION_TRUE, "mPlayUri", "U", "X0", "()Ljava/util/concurrent/atomic/AtomicLong;", "setMSession", "(Ljava/util/concurrent/atomic/AtomicLong;)V", "mSession", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "lastSession", ExifInterface.LONGITUDE_WEST, "Lv6/c;", "mPlayType", "X", "isLoading", "Y", "lastTipMsg", "b1", "setPreparedTime", "preparedTime", "a0", "c1", "B2", "renderTime", "b0", "V0", "setMIsCompleted", "mIsCompleted", "c0", "W0", "s2", "mIsForceStop", "d0", "Ljava/lang/Integer;", "U0", "r2", "(Ljava/lang/Integer;)V", "mForceStopReason", "e0", "mCanSeekBackward", "f0", "mCanSeekForward", "g0", "Landroid/content/Context;", "mContext", "", "h0", "mVideoRate", "Ljava/util/concurrent/ExecutorService;", "i0", "Ljava/util/concurrent/ExecutorService;", "mExecutorService", "j0", "latestPlayPosition", "k0", "lastSavedPosition", "l0", "lastSeekCompletePosition", "m0", "[Ltv/danmaku/ijk/media/player/misc/ITrackInfo;", "mTrackInfo", "n0", "downloadThousand", "o0", "isPlayPositionKeepMoving", "p0", "Lc9/p;", "loadingListener", "q0", "noSignalListener", "r0", "Lc9/a;", "playCompleteListener", "s0", "mPlayerArgs", "t0", "Lx1/f1/lb/widget/videoview/e;", "mVideoView", "u0", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z0 implements x1.f1.lb.metric.monitor.c, xf.a {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private long mMediaBufferingBeginTime;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private long lastSentBufferingRestartEventTime;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private boolean mIsPaused;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private int sendRestartCnt;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private int mVideoWidth;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private int mAspectRatioType;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private int mVideoHeight;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private long mHardwareDecodeFlag;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private x1.f1.lb.widget.videoview.j mPlayerInfo;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private boolean isPlayerInInitializing;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private Handler mHandler;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private IMediaPlayer.OnInfoListener mOnInfoListener;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private IMediaPlayer.OnCompletionListener mOnCompletionListener;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private IMediaPlayer.OnPreparedListener mOnPreparedListener;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private IMediaPlayer.OnErrorListener mOnErrorListener;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    private Runnable mOnRenderCompleteListener;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    private int mBufferPercent;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    private long mSeekPosition;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    private String mPlayUri;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    private AtomicLong mSession;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    private long lastSession;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    private v6.c mPlayType;

    /* JADX INFO: renamed from: X, reason: from kotlin metadata */
    private boolean isLoading;

    /* JADX INFO: renamed from: Y, reason: from kotlin metadata */
    private String lastTipMsg;

    /* JADX INFO: renamed from: Z, reason: from kotlin metadata */
    private long preparedTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(z0.class);

    /* JADX INFO: renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private long renderTime;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private c mPlayerMeter;

    /* JADX INFO: renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsCompleted;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Runnable mGatewayTimeoutHandler;

    /* JADX INFO: renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsForceStop;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Runnable mOnMediaBufferAnimationHandler;

    /* JADX INFO: renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private Integer mForceStopReason;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;

    /* JADX INFO: renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean mCanSeekBackward;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnCompletionListener mOnCompletionListenerWrapper;

    /* JADX INFO: renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean mCanSeekForward;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnErrorListener mOnErrorListenerWrapper;

    /* JADX INFO: renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;

    /* JADX INFO: renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private double mVideoRate;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListenerWrapper;

    /* JADX INFO: renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private ExecutorService mExecutorService;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnPreparedListener mOnPreparedListenerWrapper;

    /* JADX INFO: renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private long latestPlayPosition;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnInfoListener mOnInfoListenerWrapper;

    /* JADX INFO: renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private long lastSavedPosition;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Runnable mOnMediaBufferPlayHandler;

    /* JADX INFO: renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private long lastSeekCompletePosition;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Runnable checkPlayingHandler;

    /* JADX INFO: renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private ITrackInfo[] mTrackInfo;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final x1.f1.lb.metric.monitor.b playerMonitor;

    /* JADX INFO: renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private int downloadThousand;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final x1.f1.lb.metric.monitor.d streamingMonitor;

    /* JADX INFO: renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private boolean isPlayPositionKeepMoving;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private long mVideoDuration;

    /* JADX INFO: renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private c9.p<? super Boolean, ? super String, r8.z> loadingListener;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private long mGatewayTimeoutMillis;

    /* JADX INFO: renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private c9.p<? super Integer, ? super String, r8.z> noSignalListener;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final long mPlayerNotPlayingRestartIntervalMillis;

    /* JADX INFO: renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private c9.a<r8.z> playCompleteListener;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.widget.videoview.c mRenderView;

    /* JADX INFO: renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private String mPlayerArgs;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.widget.videoview.d mSurfaceHolder;

    /* JADX INFO: renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.widget.videoview.e mVideoView;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.widget.videoview.b mRenderCallback;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.widget.videoview.b mLastRenderCallback;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int mIsSoftDecoder;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private AtomicLong startPlayInitTime;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private String mVideoName;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private int mLastDecodeMode;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lx1/f1/lb/widget/videoview/z0$b;", "", "Lx1/f1/lb/widget/videoview/j;", "playerInfo", "Lr8/z;", "a", "(Lx1/f1/lb/widget/videoview/j;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        void a(x1.f1.lb.widget.videoview.j playerInfo);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lx1/f1/lb/widget/videoview/z0$c;", "Ljava/lang/Runnable;", "Lr8/z;", "y", "()V", "l", "i", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface c extends Runnable {
        void i();

        void l();

        void y();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/z0$d", "Lx1/f1/lb/widget/videoview/j$a;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "Lr8/z;", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements x1.f1.lb.widget.videoview.j.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x1.f1.lb.widget.videoview.d f21720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ x1.f1.lb.widget.videoview.j f21721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21722d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ x1.f1.lb.widget.videoview.d f21723e;

        d(x1.f1.lb.widget.videoview.d dVar, x1.f1.lb.widget.videoview.j jVar, String str, x1.f1.lb.widget.videoview.d dVar2) {
            this.f21720b = dVar;
            this.f21721c = jVar;
            this.f21722d = str;
            this.f21723e = dVar2;
        }

        @Override // x1.f1.lb.widget.videoview.j.a
        public void a(IMediaPlayer player) {
            char c10;
            boolean z10;
            String str;
            String str2;
            kotlin.jvm.internal.m.f(player, "player");
            long j10 = z0.this.startPlayInitTime.get();
            long preparedTime = z0.this.getPreparedTime();
            if (preparedTime > 0) {
                this.f21720b.b(player);
                z0.this.A0(player);
            }
            long j11 = z0.this.mSeekPosition;
            if (preparedTime <= 0 || j10 <= 0 || !z0.this.startPlayInitTime.compareAndSet(j10, 0L)) {
                c10 = 0;
                z10 = false;
            } else {
                if (j11 <= 0 || z0.this.j2(j11)) {
                    z0.this.I2(player, "bindSurfaceAndStart", true);
                }
                this.f21721c.j(3);
                z0.this.mIsPaused = false;
                z0.this.b2(this.f21721c, 10001);
                c10 = 0;
                z0.this.k2(this.f21721c, 10001, 3000L);
                z10 = true;
            }
            if (x1.f1.lb.config.b.f20643a.t()) {
                q6.b bVar = z0.this.logger;
                String str3 = "media_player_on@{}:{}@{}:{} from " + this.f21722d + " isStart[{}]{} startInitTime[{}] preparedTime[{}] session[{}] bind {} {} {}";
                Integer numValueOf = Integer.valueOf(hashCode());
                String simpleName = d.class.getSimpleName();
                Context context = z0.this.mContext;
                Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                Context context2 = z0.this.mContext;
                String simpleName2 = context2 != null ? context2.getClass().getSimpleName() : null;
                Boolean boolValueOf = Boolean.valueOf(z10);
                if (z10) {
                    str = " seekTo[" + j11 + "]";
                } else {
                    str = "";
                }
                Long lValueOf = Long.valueOf(j10);
                Long lValueOf2 = Long.valueOf(preparedTime);
                Long lValueOf3 = Long.valueOf(z0.this.getMSession().get());
                String strI1 = z0.this.i1(player);
                if (kotlin.jvm.internal.m.a(this.f21723e, this.f21720b)) {
                    str2 = "to " + z0.this.j1(this.f21720b);
                } else {
                    str2 = "from " + z0.this.j1(this.f21723e) + " to " + z0.this.j1(this.f21720b);
                }
                String str4 = preparedTime > 0 ? "success" : "player not prepared yet";
                Object[] objArr = new Object[12];
                objArr[c10] = numValueOf;
                objArr[1] = simpleName;
                objArr[2] = numValueOf2;
                objArr[3] = simpleName2;
                objArr[4] = boolValueOf;
                objArr[5] = str;
                objArr[6] = lValueOf;
                objArr[7] = lValueOf2;
                objArr[8] = lValueOf3;
                objArr[9] = strI1;
                objArr[10] = str2;
                objArr[11] = str4;
                bVar.debug(str3, objArr);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.VideoViewHandler", f = "VideoViewHandler.kt", l = {1901}, m = "getPlayPositionKey")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class e extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        e(v8.f<? super e> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z0.this.a1(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014¨\u0006\u0016"}, d2 = {"x1/f1/lb/widget/videoview/z0$f", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "handler", "", "playerId", "Lr8/z;", "a", "(Ljava/lang/Runnable;Ljava/lang/Object;)V", "", "code", "", "b", "(I)Z", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "handleMessage", "(Landroid/os/Message;)V", "", "", "Ljava/util/Map;", "lastMsgTime", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Map<Integer, Long> lastMsgTime;

        f(Looper looper) {
            super(looper);
            this.lastMsgTime = new ConcurrentHashMap();
        }

        private final void a(Runnable handler, Object playerId) {
            z0 z0Var = z0.this;
            synchronized (z0Var) {
                try {
                    if (!z0Var.getMIsCompleted() && !z0Var.getMIsForceStop()) {
                        x1.f1.lb.widget.videoview.j jVar = z0Var.mPlayerInfo;
                        if (kotlin.jvm.internal.m.a(jVar != null ? Integer.valueOf(jVar.getPlayerId()) : null, playerId)) {
                            handler.run();
                        }
                        r8.z zVar = r8.z.f17874a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            Runnable runnable = null;
            switch (msg.what) {
                case 10000:
                    try {
                        Object obj = msg.obj;
                        kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Int");
                        int iIntValue = ((Integer) obj).intValue();
                        int i10 = msg.arg1;
                        z0 z0Var = z0.this;
                        synchronized (z0Var) {
                            x1.f1.lb.widget.videoview.j jVar = z0Var.mPlayerInfo;
                            if (jVar == null || i10 == jVar.getPlayerId()) {
                                if (b(iIntValue)) {
                                    return;
                                }
                                z0Var.g1(z0Var.mPlayerInfo, iIntValue);
                                r8.z zVar = r8.z.f17874a;
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        z0.this.logger.warn("[" + z0.this.mPlayType + "][" + z0.this.mVideoName + "] session[" + z0.this.getMSession().get() + "] invalid stream event msg", th);
                        return;
                    }
                case 10001:
                    Runnable runnable2 = z0.this.checkPlayingHandler;
                    if (runnable2 == null) {
                        kotlin.jvm.internal.m.v("checkPlayingHandler");
                    } else {
                        runnable = runnable2;
                    }
                    Object obj2 = msg.obj;
                    kotlin.jvm.internal.m.e(obj2, "obj");
                    a(runnable, obj2);
                    return;
                case 10002:
                    c cVar = z0.this.mPlayerMeter;
                    if (cVar == null) {
                        kotlin.jvm.internal.m.v("mPlayerMeter");
                    } else {
                        runnable = cVar;
                    }
                    Object obj3 = msg.obj;
                    kotlin.jvm.internal.m.e(obj3, "obj");
                    a(runnable, obj3);
                    return;
                case 10003:
                    Runnable runnable3 = z0.this.mOnMediaBufferAnimationHandler;
                    if (runnable3 == null) {
                        kotlin.jvm.internal.m.v("mOnMediaBufferAnimationHandler");
                    } else {
                        runnable = runnable3;
                    }
                    Object obj4 = msg.obj;
                    kotlin.jvm.internal.m.e(obj4, "obj");
                    a(runnable, obj4);
                    return;
                default:
                    return;
            }
        }

        private final boolean b(int code) {
            long jC = d1.c();
            Long l10 = this.lastMsgTime.get(Integer.valueOf(code));
            if (l10 != null && jC - l10.longValue() < 2000) {
                return true;
            }
            this.lastMsgTime.put(Integer.valueOf(code), Long.valueOf(jC));
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\t8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\"R\"\u0010&\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\"\u0010)\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\"\u0010,\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\"\u00100\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0019\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR\"\u00103\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u0010\u001dR\"\u00106\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\"\u00109\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\"\u0010=\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0013\u001a\u0004\b;\u0010\u0015\"\u0004\b<\u0010\"R\"\u0010@\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b>\u0010\u0015\"\u0004\b?\u0010\"R\"\u0010D\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0013\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010\"R\"\u0010H\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0019\u001a\u0004\bF\u0010\u001b\"\u0004\bG\u0010\u001dR\"\u0010L\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0019\u001a\u0004\bJ\u0010\u001b\"\u0004\bK\u0010\u001dR\"\u0010T\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010X\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010O\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR\u0019\u0010[\u001a\u0004\u0018\u00010M8\u0006¢\u0006\f\n\u0004\bY\u0010O\u001a\u0004\bZ\u0010QR\"\u0010_\u001a\u00020\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0017\u0010h\u001a\u00020c8\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g¨\u0006i"}, d2 = {"x1/f1/lb/widget/videoview/z0$g", "Lx1/f1/lb/widget/videoview/z0$c;", "Lr8/z;", "j", "()V", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "h", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "", "e", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)J", "d", "f", "y", "l", "i", "run", "a", "J", "getMeterInterval", "()J", "meterInterval", "", "b", "I", "getReadBps", "()I", "setReadBps", "(I)V", "readBps", "c", "getBps", "setBps", "(J)V", "bps", "getResendCount", "setResendCount", "resendCount", "getResendRate", "setResendRate", "resendRate", "getLossRate", "setLossRate", "lossRate", "g", "getRtt", "setRtt", "rtt", "getMinRtt", "setMinRtt", "minRtt", "getMaxRtt", "setMaxRtt", "maxRtt", "getAvgRtt", "setAvgRtt", "avgRtt", "k", "getLastBps", "setLastBps", "lastBps", "getMinBps", "setMinBps", "minBps", "m", "getMaxBps", "setMaxBps", "maxBps", "n", "getVideoWidth", "setVideoWidth", "videoWidth", "o", "getVideoHeight", "setVideoHeight", "videoHeight", "", "p", "Ljava/lang/String;", "getVCodec", "()Ljava/lang/String;", "setVCodec", "(Ljava/lang/String;)V", "vCodec", "q", "getACodec", "setACodec", "aCodec", "r", "getConnecting", "connecting", "", "s", "Z", "isRenderRetryFailed", "()Z", "setRenderRetryFailed", "(Z)V", "Lx1/f1/lb/widget/videoview/j$a;", "t", "Lx1/f1/lb/widget/videoview/j$a;", "getPlayerCheckCallback", "()Lx1/f1/lb/widget/videoview/j$a;", "playerCheckCallback", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int readBps;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long bps;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int resendCount;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int resendRate;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int lossRate;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int rtt;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int minRtt;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int maxRtt;

        /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
        private int avgRtt;

        /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
        private long lastBps;

        /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
        private long minBps;

        /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
        private long maxBps;

        /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
        private int videoWidth;

        /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
        private int videoHeight;

        /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
        private final String connecting;

        /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
        private boolean isRenderRetryFailed;

        /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
        private final x1.f1.lb.widget.videoview.j.a playerCheckCallback;

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long meterInterval = 800;

        /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
        private String vCodec = "";

        /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
        private String aCodec = "";

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/z0$g$a", "Lx1/f1/lb/widget/videoview/j$a;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "Lr8/z;", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements x1.f1.lb.widget.videoview.j.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ z0 f21747a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ g f21748b;

            a(z0 z0Var, g gVar) {
                this.f21747a = z0Var;
                this.f21748b = gVar;
            }

            @Override // x1.f1.lb.widget.videoview.j.a
            public void a(IMediaPlayer player) {
                kotlin.jvm.internal.m.f(player, "player");
                if (this.f21747a.G1() || this.f21747a.getPreparedTime() == 0) {
                    if (this.f21747a.getMIsCompleted() || this.f21747a.getMIsForceStop()) {
                        return;
                    }
                    z0.L2(this.f21747a, null, 1, null);
                    this.f21748b.j();
                    return;
                }
                if (this.f21747a.I1()) {
                    this.f21747a.Q2();
                    this.f21747a.k1();
                    x1.f1.lb.widget.videoview.j jVar = this.f21747a.mPlayerInfo;
                    if (jVar != null) {
                        this.f21747a.b2(jVar, IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START);
                    }
                    this.f21748b.h(player);
                }
            }
        }

        @Override // x1.f1.lb.widget.videoview.z0.c
        public void i() {
            this.videoWidth = 0;
            this.videoHeight = 0;
            this.vCodec = "";
            this.aCodec = "";
        }

        g() {
            Context context = z0.this.mContext;
            this.connecting = context != null ? context.getString(R$string.loading) : null;
            this.playerCheckCallback = new a(z0.this, this);
        }

        private final long e(IMediaPlayer player) {
            if (player == null) {
                return 0L;
            }
            try {
                return player.getCurrentPosition();
            } catch (Throwable unused) {
                return 0L;
            }
        }

        private final void f() {
            final String str = z0.this.mPlayUri;
            if (str == null) {
                return;
            }
            final String str2 = z0.this.mVideoName;
            final v6.c cVar = z0.this.mPlayType;
            final long j10 = z0.this.getMSession().get();
            x1.f1.lb.widget.videoview.k kVar = x1.f1.lb.widget.videoview.k.f21604a;
            long jL = kVar.l();
            long j11 = jL << 1;
            long jE = kVar.e();
            if (this.isRenderRetryFailed) {
                if (j11 > jE) {
                    return;
                } else {
                    this.isRenderRetryFailed = false;
                }
            }
            if (j11 > jE) {
                z0.this.logger.error("[" + cVar + "][" + str2 + "] session[" + j10 + "] render handle_missing_dimensions, Failed to detect dimensions even after retry.", new Object[0]);
                this.isRenderRetryFailed = true;
                return;
            }
            z0.this.logger.warn("[" + cVar + "][" + str2 + "] session[" + j10 + "] render handle_missing_dimensions, Video dimensions [0 x 0] while playing. Retrying probesize[" + jL + " -> " + j11 + "]...", new Object[0]);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(kVar.i());
            linkedHashMap.put("probesize", String.valueOf(j11));
            final String strW = new com.google.gson.e().w(linkedHashMap);
            z0.this.N2(false);
            Handler handler = z0.this.mHandler;
            if (handler == null) {
                kotlin.jvm.internal.m.v("mHandler");
                handler = null;
            }
            final z0 z0Var = z0.this;
            handler.postDelayed(new Runnable() { // from class: x1.f1.lb.widget.videoview.a1
                @Override // java.lang.Runnable
                public final void run() {
                    z0.g.g(z0Var, str, str2, strW, cVar, j10);
                }
            }, 500L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(IMediaPlayer player) {
            long j10;
            long j11;
            long j12;
            g gVar = this;
            long jE = e(player);
            if (jE > 0) {
                z0.this.latestPlayPosition = jE;
                if (gVar.videoWidth == 0) {
                    d(player);
                    if (jE > 3000 && gVar.videoWidth == 0) {
                        gVar.f();
                        return;
                    }
                    z0.this.B2(d1.c());
                    long j13 = z0.this.getMSession().get();
                    tf.d dVarI = x1.f1.lb.metric.monitor.f.f20907a.i();
                    long jT = dVarI != null ? dVarI.t() : j13;
                    long j14 = jT - j13;
                    long preparedTime = z0.this.getPreparedTime() - jT;
                    long renderTime = z0.this.getRenderTime() - z0.this.getPreparedTime();
                    j11 = 0;
                    j12 = 3000;
                    j10 = jE;
                    z0.this.logger.a("[" + z0.this.mPlayType + "][" + z0.this.mVideoName + "][" + j13 + "] render complete, Video a[" + gVar.aCodec + "] v[" + gVar.vCodec + "] dimensions [" + gVar.videoWidth + " x " + gVar.videoHeight + "] urlReady[" + j14 + " ms] prepared[" + preparedTime + " ms] rendered[" + renderTime + " ms]", new Object[0]);
                    x1.f1.lb.util.a1 a1Var = x1.f1.lb.util.a1.f21305a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(j13);
                    sb2.append(".render_complete");
                    a1Var.e(j13, sb2.toString(), true);
                    gVar = this;
                    Runnable runnable = z0.this.mOnRenderCompleteListener;
                    if (runnable != null) {
                        runnable.run();
                    }
                } else {
                    j10 = jE;
                    j11 = 0;
                    j12 = 3000;
                }
                if (z0.this.mPlayType == v6.c.VOD || z0.this.mPlayType == v6.c.CATCHUP) {
                    if (z0.this.mVideoDuration == j11) {
                        long jT0 = z0.this.T0(player);
                        if (j10 < jT0) {
                            z0.this.mVideoDuration = jT0;
                        }
                    }
                    if (j10 - z0.this.lastSavedPosition > j12) {
                        z0.this.i2(j10);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j() {
            String strA;
            if (!z0.this.isLoading || z0.this.getMIsForceStop()) {
                return;
            }
            try {
                long j10 = this.bps;
                if (j10 <= 0 || this.lastBps <= 0) {
                    strA = this.connecting;
                    if (strA == null) {
                        strA = "";
                    }
                } else {
                    strA = x1.f1.lb.util.z0.f21483a.a(j10);
                }
                z0.this.K2(strA);
            } finally {
                this.lastBps = this.bps;
            }
        }

        @Override // x1.f1.lb.widget.videoview.z0.c
        public void l() {
            String string;
            this.bps = 0L;
            this.lastBps = 0L;
            this.minBps = 0L;
            this.maxBps = 0L;
            this.rtt = 0;
            this.minRtt = 0;
            this.maxRtt = 0;
            this.avgRtt = 0;
            z0 z0Var = z0.this;
            Context context = z0Var.mContext;
            if (context == null || (string = context.getString(R$string.connecting)) == null) {
                string = "";
            }
            z0Var.K2(string);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x008c  */
        @Override // java.lang.Runnable
        @SuppressLint({"DefaultLocale"})
        public void run() {
            long j10;
            x1.f1.lb.widget.videoview.j jVar = z0.this.mPlayerInfo;
            int iL = z0.this.streamingMonitor.l();
            if (this.readBps == iL) {
                j10 = 0;
            } else {
                this.readBps = iL;
                j10 = iL;
            }
            this.bps = j10;
            this.resendCount = z0.this.streamingMonitor.m();
            this.lossRate = z0.this.streamingMonitor.p();
            this.resendRate = z0.this.streamingMonitor.o();
            this.rtt = z0.this.streamingMonitor.h();
            this.minRtt = z0.this.streamingMonitor.c();
            this.maxRtt = z0.this.streamingMonitor.g();
            this.avgRtt = z0.this.streamingMonitor.d();
            if (jVar != null) {
                jVar.a(this.playerCheckCallback);
            }
            long j11 = this.minBps;
            if (j11 != 0) {
                long j12 = this.bps;
                if (10001 <= j12 && j12 < j11) {
                    this.minBps = this.bps;
                }
            } else {
                this.minBps = this.bps;
            }
            long j13 = this.maxBps;
            if (j13 == 0 || j13 < this.bps) {
                this.maxBps = this.bps;
            }
            x1.f1.lb.metric.monitor.f.f20907a.y(this.bps, z0.this.streamingMonitor.k(), this.minBps, this.maxBps, this.rtt, this.minRtt, this.maxRtt, this.avgRtt, this.resendCount, this.lossRate, this.resendRate, this.videoWidth, this.videoHeight, this.vCodec, this.aCodec);
            z0.this.k2(jVar, 10002, this.meterInterval);
        }

        @Override // x1.f1.lb.widget.videoview.z0.c
        public void y() {
            String string;
            this.bps = 0L;
            this.lastBps = 0L;
            this.minBps = 0L;
            this.maxBps = 0L;
            this.rtt = 0;
            this.minRtt = 0;
            this.maxRtt = 0;
            this.avgRtt = 0;
            z0 z0Var = z0.this;
            Context context = z0Var.mContext;
            if (context == null || (string = context.getString(R$string.connecting)) == null) {
                string = "";
            }
            z0Var.K2(string);
        }

        private final void d(IMediaPlayer player) {
            String str;
            try {
                this.videoWidth = player.getVideoWidth();
                this.videoHeight = player.getVideoHeight();
                MediaInfo mediaInfo = player.getMediaInfo();
                String str2 = "";
                if (mediaInfo == null) {
                    str = "";
                } else {
                    str = mediaInfo.mMeta.mVideoStream.mCodecName;
                }
                this.vCodec = ac.g.s(str);
                if (mediaInfo != null) {
                    str2 = mediaInfo.mMeta.mAudioStream.mCodecName;
                }
                this.aCodec = ac.g.s(str2);
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(z0 z0Var, String str, String str2, String str3, v6.c cVar, long j10) {
            z0Var.F2(str, str2, str3, cVar, j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0010R\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"x1/f1/lb/widget/videoview/z0$h", "Ljava/lang/Runnable;", "", "j", "()J", "time", "", "h", "(Ljava/lang/Long;)Z", "g", "()Z", "Lr8/z;", "k", "()V", "run", "a", "J", "now", "b", "playerLastPlayingTime", "c", "lastForceCallBufferHandlerTime", "", "d", "Ljava/lang/Integer;", "lastCode", "e", "I", "codeCnt", "f", "lastSendRestartEventTime", "lastPlayPosition", "lastUpdateToPlayerTime", "Lx1/f1/lb/widget/videoview/j$a;", "i", "Lx1/f1/lb/widget/videoview/j$a;", "playingCheckCallback", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long now;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long playerLastPlayingTime;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long lastForceCallBufferHandlerTime;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private Integer lastCode;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int codeCnt;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long lastSendRestartEventTime;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private long lastPlayPosition;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long lastUpdateToPlayerTime;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final x1.f1.lb.widget.videoview.j.a playingCheckCallback;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/z0$h$a", "Lx1/f1/lb/widget/videoview/j$a;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "Lr8/z;", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements x1.f1.lb.widget.videoview.j.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ z0 f21759a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ h f21760b;

            a(z0 z0Var, h hVar) {
                this.f21759a = z0Var;
                this.f21760b = hVar;
            }

            @Override // x1.f1.lb.widget.videoview.j.a
            public void a(IMediaPlayer player) {
                kotlin.jvm.internal.m.f(player, "player");
                x1.f1.lb.widget.videoview.j jVar = this.f21759a.mPlayerInfo;
                try {
                    if (this.f21760b.g()) {
                        h hVar = this.f21760b;
                        hVar.playerLastPlayingTime = hVar.now;
                        if (jVar != null) {
                            z0 z0Var = this.f21759a;
                            z0Var.P1(jVar);
                            z0Var.H0(jVar);
                        }
                        if (this.f21759a.lastSeekCompletePosition > 0) {
                            this.f21759a.lastSeekCompletePosition = 0L;
                        }
                        this.f21759a.k1();
                        this.f21759a.l1();
                        return;
                    }
                    long j10 = this.f21760b.j();
                    if (j10 <= 6000 || this.f21759a.mMediaBufferingBeginTime != 0) {
                        if (j10 <= this.f21759a.mGatewayTimeoutMillis || this.f21760b.now - this.f21760b.lastForceCallBufferHandlerTime <= this.f21759a.mGatewayTimeoutMillis) {
                            return;
                        }
                        h hVar2 = this.f21760b;
                        hVar2.lastForceCallBufferHandlerTime = hVar2.now;
                        Runnable runnable = this.f21759a.mOnMediaBufferPlayHandler;
                        if (runnable == null) {
                            kotlin.jvm.internal.m.v("mOnMediaBufferPlayHandler");
                            runnable = null;
                        }
                        runnable.run();
                        return;
                    }
                    if (jVar != null) {
                        z0 z0Var2 = this.f21759a;
                        z0Var2.Q1(jVar);
                        z0Var2.T1(jVar);
                    }
                    this.f21759a.logger.warn("[" + this.f21759a.mPlayType + "][" + this.f21759a.mVideoName + "] session[" + this.f21759a.getMSession().get() + "] player is not in playing status, setup buffering", new Object[0]);
                } catch (Throwable th) {
                    this.f21759a.logger.error("start player failure", th);
                }
            }
        }

        private final boolean h(Long time) {
            if (time == null) {
                return false;
            }
            long jLongValue = this.now - time.longValue();
            long j10 = z0.this.mGatewayTimeoutMillis;
            if (jLongValue <= j10) {
                return false;
            }
            z0.this.logger.warn("event timeout: [" + z0.this.mPlayType + "][" + z0.this.mVideoName + "] session[" + z0.this.getMSession().get() + "] [" + jLongValue + " = " + this.now + " - " + time + " > " + j10 + "]", new Object[0]);
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:185:0x05a9  */
        /* JADX WARN: Code duplicated, block: B:187:0x05b1  */
        /* JADX WARN: Code duplicated, block: B:189:0x05b9  */
        /* JADX WARN: Code duplicated, block: B:191:0x05c1  */
        /* JADX WARN: Code duplicated, block: B:193:0x05c9  */
        /* JADX WARN: Code duplicated, block: B:195:0x05cd  */
        /* JADX WARN: Code duplicated, block: B:197:0x05d9  */
        /* JADX WARN: Code duplicated, block: B:199:0x05e5  */
        /* JADX WARN: Code duplicated, block: B:202:0x05f0 A[Catch: all -> 0x06bf, TRY_LEAVE, TryCatch #6 {all -> 0x06bf, blocks: (B:247:0x0793, B:200:0x05e7, B:202:0x05f0, B:228:0x06c2, B:230:0x06ca, B:232:0x06d4, B:231:0x06d1), top: B:283:0x0021 }] */
        /* JADX WARN: Code duplicated, block: B:206:0x061c A[Catch: all -> 0x0363, TRY_LEAVE, TryCatch #2 {all -> 0x0363, blocks: (B:121:0x034a, B:123:0x0358, B:204:0x0610, B:206:0x061c, B:128:0x0368, B:130:0x0382, B:131:0x0389, B:133:0x03a3, B:134:0x03ab, B:137:0x03cb, B:140:0x03ec, B:147:0x041b, B:149:0x0427, B:151:0x043d, B:163:0x04ed, B:165:0x04f7, B:167:0x04ff, B:169:0x050b, B:171:0x051a, B:173:0x0532, B:174:0x0536, B:178:0x0542, B:180:0x0598, B:152:0x0487, B:154:0x04a4, B:157:0x04b1, B:160:0x04d0), top: B:278:0x02d8 }] */
        /* JADX WARN: Code duplicated, block: B:208:0x0625  */
        /* JADX WARN: Code duplicated, block: B:212:0x0686  */
        /* JADX WARN: Code duplicated, block: B:214:0x068e  */
        /* JADX WARN: Code duplicated, block: B:216:0x0696  */
        /* JADX WARN: Code duplicated, block: B:218:0x069e  */
        /* JADX WARN: Code duplicated, block: B:220:0x06a2  */
        /* JADX WARN: Code duplicated, block: B:222:0x06ae  */
        /* JADX WARN: Code duplicated, block: B:228:0x06c2 A[Catch: all -> 0x06bf, TRY_ENTER, TryCatch #6 {all -> 0x06bf, blocks: (B:247:0x0793, B:200:0x05e7, B:202:0x05f0, B:228:0x06c2, B:230:0x06ca, B:232:0x06d4, B:231:0x06d1), top: B:283:0x0021 }] */
        /* JADX WARN: Code duplicated, block: B:230:0x06ca A[Catch: all -> 0x06bf, TryCatch #6 {all -> 0x06bf, blocks: (B:247:0x0793, B:200:0x05e7, B:202:0x05f0, B:228:0x06c2, B:230:0x06ca, B:232:0x06d4, B:231:0x06d1), top: B:283:0x0021 }] */
        /* JADX WARN: Code duplicated, block: B:231:0x06d1 A[Catch: all -> 0x06bf, TryCatch #6 {all -> 0x06bf, blocks: (B:247:0x0793, B:200:0x05e7, B:202:0x05f0, B:228:0x06c2, B:230:0x06ca, B:232:0x06d4, B:231:0x06d1), top: B:283:0x0021 }] */
        /* JADX WARN: Code duplicated, block: B:235:0x0761  */
        /* JADX WARN: Code duplicated, block: B:237:0x0769  */
        /* JADX WARN: Code duplicated, block: B:239:0x0771  */
        /* JADX WARN: Code duplicated, block: B:241:0x0779  */
        /* JADX WARN: Code duplicated, block: B:243:0x077d  */
        /* JADX WARN: Code duplicated, block: B:245:0x0789  */
        /* JADX WARN: Code duplicated, block: B:264:0x07da  */
        /* JADX WARN: Code duplicated, block: B:266:0x07e2  */
        /* JADX WARN: Code duplicated, block: B:268:0x07ea  */
        /* JADX WARN: Code duplicated, block: B:270:0x07f2  */
        /* JADX WARN: Code duplicated, block: B:271:0x07f6  */
        /* JADX WARN: Code duplicated, block: B:272:0x0802  */
        /* JADX WARN: Code duplicated, block: B:288:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:289:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:290:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:291:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:292:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:293:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v109 */
        /* JADX WARN: Type inference failed for: r0v113 */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v21 */
        /* JADX WARN: Type inference failed for: r0v25 */
        /* JADX WARN: Type inference failed for: r0v37, types: [java.lang.Integer, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v71 */
        /* JADX WARN: Type inference failed for: r17v1 */
        /* JADX WARN: Type inference failed for: r17v2 */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [x1.f1.lb.widget.videoview.j] */
        /* JADX WARN: Type inference failed for: r3v49 */
        /* JADX WARN: Type inference failed for: r3v50 */
        /* JADX WARN: Type inference failed for: r3v51 */
        /* JADX WARN: Type inference failed for: r3v52 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.StringBuilder] */
        @Override // java.lang.Runnable
        public void run() throws Throwable {
            h hVar;
            c9.a aVar;
            int i10;
            String str;
            Integer num;
            x1.f1.lb.widget.videoview.j jVar;
            x1.f1.lb.widget.videoview.j jVar2;
            char c10;
            ?? r10;
            ?? r17;
            ?? r11;
            ?? r12;
            Integer numValueOf;
            x1.f1.lb.widget.videoview.j jVar3;
            long j10;
            c9.a aVar2;
            x1.f1.lb.widget.videoview.j jVar4;
            Integer numValueOf2;
            c9.a aVar3;
            c9.a aVar4;
            Integer num2;
            h hVar2;
            Activity activityI;
            ?? r13 = 6;
            x1.f1.lb.widget.videoview.j jVar5 = z0.this.mPlayerInfo;
            try {
                try {
                    if (!z0.this.mIsPaused || z0.this.lastSeekCompletePosition > 0) {
                        if (!z0.this.getMIsCompleted() && !z0.this.getMIsForceStop()) {
                            try {
                                try {
                                    if (!z0.this.L1()) {
                                        if (z0.this.getMSession().get() > 0) {
                                            boolean zU1 = z0.this.U1(ExifInterface.GPS_MEASUREMENT_2D);
                                            if (zU1 || !((activityI = x1.f1.lb.util.c.f21341a.i(z0.this.mContext)) == null || activityI.isFinishing() || activityI.isDestroyed())) {
                                                hVar2 = this;
                                            } else {
                                                q6.b bVar = z0.this.logger;
                                                Context context = z0.this.mContext;
                                                String simpleName = context != null ? context.getClass().getSimpleName() : null;
                                                z0 z0Var = z0.this;
                                                Integer numH1 = z0Var.h1(z0Var.mContext);
                                                z0 z0Var2 = z0.this;
                                                Integer numH2 = z0Var2.h1(z0Var2);
                                                v6.c cVar = z0.this.mPlayType;
                                                String str2 = z0.this.mVideoName;
                                                bVar.a(simpleName + "@" + numH1 + ": video view@" + numH2 + " [" + cVar + "][" + str2 + "] session[" + z0.this.getMSession().get() + "] is not shown, pause player[false], activity destroyed, stop player and engine", new Object[0]);
                                                hVar2 = this;
                                                z0.this.N2(false);
                                            }
                                            if (x1.f1.lb.config.b.f20643a.t()) {
                                                q6.b bVar2 = z0.this.logger;
                                                Context context2 = z0.this.mContext;
                                                String simpleName2 = context2 != null ? context2.getClass().getSimpleName() : null;
                                                z0 z0Var3 = z0.this;
                                                Integer numH3 = z0Var3.h1(z0Var3.mContext);
                                                z0 z0Var4 = z0.this;
                                                bVar2.debug(simpleName2 + "@" + numH3 + ": video view@" + z0Var4.h1(z0Var4) + " is not shown, pause player[" + zU1 + "]", new Object[0]);
                                            }
                                        } else {
                                            hVar2 = this;
                                        }
                                        if (z0.this.getMIsForceStop()) {
                                            return;
                                        }
                                        if (!z0.this.getMIsCompleted()) {
                                            z0.this.k2(jVar5, 10001, 1000L);
                                            return;
                                        }
                                        if (z0.this.playCompleteListener == null) {
                                            z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                            return;
                                        }
                                        c9.a aVar5 = z0.this.playCompleteListener;
                                        if (aVar5 != null) {
                                            aVar5.invoke();
                                            return;
                                        }
                                        return;
                                    }
                                    if (jVar5 == null || jVar5.getAndroidx.core.app.NotificationCompat.CATEGORY_STATUS java.lang.String() != 4) {
                                        i10 = 4;
                                    } else {
                                        boolean zH2 = z0.this.H2();
                                        q6.b bVar3 = z0.this.logger;
                                        Context context3 = z0.this.mContext;
                                        String simpleName3 = context3 != null ? context3.getClass().getSimpleName() : null;
                                        i10 = 4;
                                        z0 z0Var5 = z0.this;
                                        Integer numH4 = z0Var5.h1(z0Var5.mContext);
                                        z0 z0Var6 = z0.this;
                                        bVar3.a(simpleName3 + "@" + numH4 + ": video view@" + z0Var6.h1(z0Var6) + " [" + z0.this.mPlayType + "][" + z0.this.mVideoName + "] session[" + z0.this.getMSession().get() + "] is shown but paused, start player[" + zH2 + "]", new Object[0]);
                                    }
                                    int playerId = jVar5 != null ? jVar5.getPlayerId() : 0;
                                    hVar = this;
                                    hVar.now = d1.c();
                                    long j11 = z0.this.mGatewayTimeoutMillis;
                                    if (z0.this.getPreparedTime() == 0) {
                                        if (z0.this.startPlayInitTime.get() == 0 || hVar.now - z0.this.startPlayInitTime.get() > z0.this.mGatewayTimeoutMillis) {
                                            z0.this.startPlayInitTime.set(hVar.now);
                                            str = "player startup timeout";
                                            num2 = -1;
                                        } else {
                                            str = "";
                                            num2 = null;
                                        }
                                        z0.L2(z0.this, null, 1, null);
                                        num = num2;
                                    } else {
                                        hVar.k();
                                        str = "";
                                        num = null;
                                    }
                                    z0 z0Var7 = z0.this;
                                    z0Var7.downloadThousand = z0Var7.playerMonitor.j(z0.this.getMSession().get(), playerId);
                                    String str3 = "[";
                                    try {
                                        if (num == null) {
                                            try {
                                                if (z0.this.isPlayPositionKeepMoving) {
                                                    if (z0.this.getMIsForceStop()) {
                                                        return;
                                                    }
                                                    if (!z0.this.getMIsCompleted()) {
                                                        z0.this.k2(jVar5, 10001, 1000L);
                                                        return;
                                                    }
                                                    if (z0.this.playCompleteListener == null) {
                                                        z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                                        return;
                                                    }
                                                    c9.a aVar6 = z0.this.playCompleteListener;
                                                    if (aVar6 != null) {
                                                        aVar6.invoke();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                if (z0.this.mPlayType != v6.c.LIVE) {
                                                    jVar2 = jVar5;
                                                    c10 = 2;
                                                    if (!z0.this.getMIsCompleted()) {
                                                        if (z0.this.playerMonitor.i(z0.this.getMSession().get(), playerId)) {
                                                            z0.this.logger.a("[" + z0.this.mPlayType + "][" + z0.this.mVideoName + "][" + z0.this.getMSession().get() + "] the last block download complete!", new Object[0]);
                                                            str3 = "[";
                                                            r10 = num;
                                                        } else {
                                                            str3 = "[";
                                                            if (hVar.h(z0.this.playerMonitor.q(z0.this.getMSession().get(), playerId))) {
                                                                if (!z0.this.isPlayPositionKeepMoving) {
                                                                    r10 = num;
                                                                    r10 = r5;
                                                                    str = "player no block request";
                                                                }
                                                            } else if (hVar.h(z0.this.streamingMonitor.f(z0.this.getMSession().get(), playerId))) {
                                                                r10 = r13;
                                                                str = "streaming no block response";
                                                            } else if (hVar.h(z0.this.streamingMonitor.a(z0.this.getMSession().get(), playerId))) {
                                                                r10 = num;
                                                                str = "streaming no block update";
                                                                r10 = r2;
                                                            }
                                                        }
                                                        r10 = num;
                                                        r10 = num;
                                                        if (z0.this.lastSeekCompletePosition <= 0) {
                                                            r17 = r10;
                                                            str = str;
                                                        } else if (!z0.this.isPlayPositionKeepMoving || hVar.lastPlayPosition <= z0.this.lastSeekCompletePosition) {
                                                            long jLongValue = 0;
                                                            Long lA = z0.this.streamingMonitor.a(z0.this.getMSession().get(), playerId);
                                                            if (lA != null) {
                                                                jLongValue = lA.longValue();
                                                            }
                                                            long j12 = hVar.lastUpdateToPlayerTime;
                                                            if (1 <= j12 && j12 < jLongValue) {
                                                                z0.this.logger.a(str3 + z0.this.mPlayType + "][" + z0.this.mVideoName + "][" + z0.this.getMSession().get() + "][" + playerId + "] player got data after seek complete, but not start play", new Object[0]);
                                                                z0.this.H2();
                                                            }
                                                            hVar.lastUpdateToPlayerTime = jLongValue;
                                                            r17 = r10;
                                                        } else {
                                                            z0.this.lastSeekCompletePosition = 0L;
                                                            hVar.lastUpdateToPlayerTime = 0L;
                                                            r17 = r10;
                                                            str = str;
                                                        }
                                                        r11 = r17;
                                                        str = str;
                                                    }
                                                } else if (kotlin.jvm.internal.m.a(x1.f1.lb.config.b.f20643a.l(), "HLS")) {
                                                    jVar2 = jVar5;
                                                    c10 = 2;
                                                    if (hVar.h(z0.this.playerMonitor.b(z0.this.getMSession().get(), playerId))) {
                                                        str = "player no playlist request";
                                                        numValueOf = 2;
                                                    } else if (hVar.h(z0.this.streamingMonitor.r(z0.this.getMSession().get(), playerId))) {
                                                        str = "streaming no playlist response";
                                                        numValueOf = Integer.valueOf(i10);
                                                    } else {
                                                        if (hVar.h(z0.this.streamingMonitor.e(z0.this.getMSession().get(), playerId))) {
                                                            str = "streaming no playlist update";
                                                            numValueOf = 5;
                                                        } else if (hVar.h(z0.this.playerMonitor.q(z0.this.getMSession().get(), playerId))) {
                                                            r12 = 3;
                                                            str = "player no block request";
                                                        } else if (hVar.h(z0.this.streamingMonitor.f(z0.this.getMSession().get(), playerId))) {
                                                            r12 = r13;
                                                            str = "streaming no block response";
                                                        } else if (hVar.h(z0.this.streamingMonitor.a(z0.this.getMSession().get(), playerId))) {
                                                            str = "streaming no block update";
                                                            r12 = 7;
                                                        }
                                                        r11 = r12;
                                                    }
                                                    r12 = numValueOf;
                                                    r11 = r12;
                                                } else {
                                                    jVar2 = jVar5;
                                                    c10 = 2;
                                                }
                                                if (r11 == 0) {
                                                    if (z0.this.getMIsForceStop()) {
                                                        return;
                                                    }
                                                    if (z0.this.getMIsCompleted()) {
                                                        z0.this.k2(jVar2, 10001, 1000L);
                                                        return;
                                                    }
                                                    if (z0.this.playCompleteListener != null) {
                                                        z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                                        return;
                                                    }
                                                    aVar4 = z0.this.playCompleteListener;
                                                    if (aVar4 != null) {
                                                        aVar4.invoke();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                jVar3 = jVar2;
                                                j10 = hVar.now - hVar.lastSendRestartEventTime;
                                                if (j10 < j11) {
                                                    if (kotlin.jvm.internal.m.a(hVar.lastCode, r11)) {
                                                        hVar.codeCnt++;
                                                    } else {
                                                        hVar.codeCnt = 1;
                                                    }
                                                    hVar.lastCode = r11;
                                                    hVar.lastSendRestartEventTime = hVar.now;
                                                    q6.b bVar4 = z0.this.logger;
                                                    String str4 = "player monitor: [" + z0.this.mPlayType + "][" + z0.this.mVideoName + "] session[" + z0.this.getMSession().get() + "] {} [ {} ms ] [{}]";
                                                    Long lValueOf = Long.valueOf(j11);
                                                    Integer numValueOf3 = Integer.valueOf(hVar.codeCnt);
                                                    Object[] objArr = new Object[3];
                                                    objArr[0] = str;
                                                    objArr[1] = lValueOf;
                                                    objArr[c10] = numValueOf3;
                                                    bVar4.warn(str4, objArr);
                                                    z0.L2(z0.this, null, 1, null);
                                                    xe.c.c().o(new nf.q(z0.this.getMSession().get(), r11.intValue(), hVar.codeCnt, str));
                                                    if (z0.this.getMIsForceStop()) {
                                                        return;
                                                    }
                                                    if (z0.this.getMIsCompleted()) {
                                                        z0.this.k2(jVar3, 10001, 1000L);
                                                        return;
                                                    }
                                                    if (z0.this.playCompleteListener != null) {
                                                        z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                                        return;
                                                    }
                                                    aVar2 = z0.this.playCompleteListener;
                                                    if (aVar2 != null) {
                                                        aVar2.invoke();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                q6.b bVar5 = z0.this.logger;
                                                v6.c cVar2 = z0.this.mPlayType;
                                                String str5 = z0.this.mVideoName;
                                                long j13 = z0.this.getMSession().get();
                                                jVar = jVar3;
                                                int i11 = hVar.codeCnt;
                                                jVar4 = z0.this.mPlayerInfo;
                                                if (jVar4 != null) {
                                                    numValueOf2 = Integer.valueOf(jVar4.getPlayerId());
                                                } else {
                                                    numValueOf2 = null;
                                                }
                                                try {
                                                    bVar5.warn(str3 + cVar2 + "][" + str5 + "] session[" + j13 + "] wait not enough time to restart player, [" + j10 + "/" + j11 + "] [" + str + "(" + r11 + ")] [" + i11 + "] [" + numValueOf2 + "]", new Object[0]);
                                                    if (z0.this.getMIsForceStop()) {
                                                        return;
                                                    }
                                                    if (z0.this.getMIsCompleted()) {
                                                        z0.this.k2(jVar, 10001, 1000L);
                                                        return;
                                                    }
                                                    if (z0.this.playCompleteListener != null) {
                                                        z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                                        return;
                                                    }
                                                    aVar3 = z0.this.playCompleteListener;
                                                    if (aVar3 != null) {
                                                        aVar3.invoke();
                                                        return;
                                                    }
                                                    return;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    hVar = this;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                jVar = jVar5;
                                            }
                                            r13 = jVar;
                                            if (!z0.this.getMIsForceStop()) {
                                                if (!z0.this.getMIsCompleted()) {
                                                    z0.this.k2(r13, 10001, 1000L);
                                                } else if (z0.this.playCompleteListener != null) {
                                                    aVar = z0.this.playCompleteListener;
                                                    if (aVar != null) {
                                                        aVar.invoke();
                                                    }
                                                } else {
                                                    z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                                }
                                            }
                                            throw th;
                                        }
                                        jVar2 = jVar5;
                                        c10 = 2;
                                        r11 = num;
                                        if (r11 == 0) {
                                            if (z0.this.getMIsForceStop()) {
                                                if (z0.this.getMIsCompleted()) {
                                                    z0.this.k2(jVar2, 10001, 1000L);
                                                    return;
                                                }
                                                if (z0.this.playCompleteListener != null) {
                                                    z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                                    return;
                                                }
                                                aVar4 = z0.this.playCompleteListener;
                                                if (aVar4 != null) {
                                                    aVar4.invoke();
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        jVar3 = jVar2;
                                        j10 = hVar.now - hVar.lastSendRestartEventTime;
                                        if (j10 < j11) {
                                            if (kotlin.jvm.internal.m.a(hVar.lastCode, r11)) {
                                                hVar.codeCnt++;
                                            } else {
                                                hVar.codeCnt = 1;
                                            }
                                            hVar.lastCode = r11;
                                            hVar.lastSendRestartEventTime = hVar.now;
                                            q6.b bVar6 = z0.this.logger;
                                            String str6 = "player monitor: [" + z0.this.mPlayType + "][" + z0.this.mVideoName + "] session[" + z0.this.getMSession().get() + "] {} [ {} ms ] [{}]";
                                            Long lValueOf2 = Long.valueOf(j11);
                                            Integer numValueOf4 = Integer.valueOf(hVar.codeCnt);
                                            Object[] objArr2 = new Object[3];
                                            objArr2[0] = str;
                                            objArr2[1] = lValueOf2;
                                            objArr2[c10] = numValueOf4;
                                            bVar6.warn(str6, objArr2);
                                            z0.L2(z0.this, null, 1, null);
                                            xe.c.c().o(new nf.q(z0.this.getMSession().get(), r11.intValue(), hVar.codeCnt, str));
                                            if (z0.this.getMIsForceStop()) {
                                                if (z0.this.getMIsCompleted()) {
                                                    z0.this.k2(jVar3, 10001, 1000L);
                                                    return;
                                                }
                                                if (z0.this.playCompleteListener != null) {
                                                    z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                                    return;
                                                }
                                                aVar2 = z0.this.playCompleteListener;
                                                if (aVar2 != null) {
                                                    aVar2.invoke();
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        q6.b bVar7 = z0.this.logger;
                                        v6.c cVar3 = z0.this.mPlayType;
                                        String str7 = z0.this.mVideoName;
                                        long j14 = z0.this.getMSession().get();
                                        jVar = jVar3;
                                        int i12 = hVar.codeCnt;
                                        jVar4 = z0.this.mPlayerInfo;
                                        if (jVar4 != null) {
                                            numValueOf2 = Integer.valueOf(jVar4.getPlayerId());
                                        } else {
                                            numValueOf2 = null;
                                        }
                                        bVar7.warn(str3 + cVar3 + "][" + str7 + "] session[" + j14 + "] wait not enough time to restart player, [" + j10 + "/" + j11 + "] [" + str + "(" + r11 + ")] [" + i12 + "] [" + numValueOf2 + "]", new Object[0]);
                                        if (z0.this.getMIsForceStop()) {
                                            if (z0.this.getMIsCompleted()) {
                                                z0.this.k2(jVar, 10001, 1000L);
                                                return;
                                            }
                                            if (z0.this.playCompleteListener != null) {
                                                z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                                return;
                                            }
                                            aVar3 = z0.this.playCompleteListener;
                                            if (aVar3 != null) {
                                                aVar3.invoke();
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                    r13 = jVar;
                                    if (!z0.this.getMIsForceStop()) {
                                        if (!z0.this.getMIsCompleted()) {
                                            z0.this.k2(r13, 10001, 1000L);
                                        } else if (z0.this.playCompleteListener != null) {
                                            aVar = z0.this.playCompleteListener;
                                            if (aVar != null) {
                                                aVar.invoke();
                                            }
                                        } else {
                                            z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                        }
                                    }
                                    throw th;
                                } catch (Throwable th4) {
                                    th = th4;
                                    r13 = jVar5;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                hVar = this;
                                r13 = jVar5;
                            }
                            r13 = jVar5;
                            if (!z0.this.getMIsForceStop()) {
                                if (!z0.this.getMIsCompleted()) {
                                    z0.this.k2(r13, 10001, 1000L);
                                } else if (z0.this.playCompleteListener != null) {
                                    aVar = z0.this.playCompleteListener;
                                    if (aVar != null) {
                                        aVar.invoke();
                                    }
                                } else {
                                    z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                                }
                            }
                            throw th;
                        }
                    }
                    z0.this.Q2();
                    if (z0.this.getMIsForceStop()) {
                        return;
                    }
                    if (!z0.this.getMIsCompleted()) {
                        z0.this.k2(jVar5, 10001, 1000L);
                        return;
                    }
                    if (z0.this.playCompleteListener == null) {
                        z0.K0(z0.this, R$string.vod_play_complete, null, null, 6, null);
                        return;
                    }
                    c9.a aVar7 = z0.this.playCompleteListener;
                    if (aVar7 != null) {
                        aVar7.invoke();
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                hVar = this;
            }
        }

        h() {
            long jC = d1.c();
            this.now = jC;
            this.playerLastPlayingTime = jC;
            this.lastForceCallBufferHandlerTime = jC;
            this.playingCheckCallback = new a(z0.this, this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean g() {
            if (!z0.this.I1()) {
                return false;
            }
            long jN0 = z0.this.N0();
            z0.this.isPlayPositionKeepMoving = this.lastPlayPosition != jN0;
            this.lastPlayPosition = jN0;
            return z0.this.isPlayPositionKeepMoving;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long j() {
            return this.now - this.playerLastPlayingTime;
        }

        private final void k() {
            if (this.playerLastPlayingTime == 0) {
                this.playerLastPlayingTime = this.now;
                return;
            }
            x1.f1.lb.widget.videoview.j jVar = z0.this.mPlayerInfo;
            if (jVar != null) {
                jVar.a(this.playingCheckCallback);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"x1/f1/lb/widget/videoview/z0$i", "Lx1/f1/lb/widget/videoview/b;", "Lx1/f1/lb/widget/videoview/d;", "holder", "", IjkMediaMeta.IJKM_KEY_FORMAT, "width", "height", "Lr8/z;", "a", "(Lx1/f1/lb/widget/videoview/d;III)V", "b", "(Lx1/f1/lb/widget/videoview/d;II)V", "c", "(Lx1/f1/lb/widget/videoview/d;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements x1.f1.lb.widget.videoview.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x1.f1.lb.widget.videoview.j f21762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z0 f21763c;

        i(x1.f1.lb.widget.videoview.j jVar, z0 z0Var) {
            this.f21762b = jVar;
            this.f21763c = z0Var;
        }

        @Override // x1.f1.lb.widget.videoview.b
        public void a(x1.f1.lb.widget.videoview.d holder, int format, int width, int height) {
            kotlin.jvm.internal.m.f(holder, "holder");
            z0 z0Var = z0.this;
            x1.f1.lb.widget.videoview.j jVar = this.f21762b;
            z0 z0Var2 = this.f21763c;
            synchronized (z0Var) {
                try {
                    x1.f1.lb.widget.videoview.j jVar2 = z0Var.mPlayerInfo;
                    if (jVar2 != null && jVar.getPlayerId() == jVar2.getPlayerId()) {
                        IMediaPlayer iMediaPlayerZ0 = z0.Z0(z0Var, null, 1, null);
                        if (x1.f1.lb.config.b.f20643a.t()) {
                            q6.b bVar = z0Var.logger;
                            Integer numValueOf = Integer.valueOf(z0Var2.hashCode());
                            String simpleName = z0.class.getSimpleName();
                            Context context = z0Var.mContext;
                            Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                            Context context2 = z0Var.mContext;
                            bVar.debug("media_player_on@{}:{}@{}:{} render surface changed, session[{}] {} {}, format[{}], width[{}], height[{}]", numValueOf, simpleName, numValueOf2, context2 != null ? context2.getClass().getSimpleName() : null, Long.valueOf(z0Var.getMSession().get()), z0Var.j1(holder), z0Var.i1(iMediaPlayerZ0), Integer.valueOf(format), Integer.valueOf(width), Integer.valueOf(height));
                        }
                        if (iMediaPlayerZ0 != null) {
                            z0Var.B0(jVar, holder, "surface changed");
                        } else {
                            z0Var.mSurfaceHolder = holder;
                        }
                        r8.z zVar = r8.z.f17874a;
                        return;
                    }
                    q6.b bVar2 = z0Var.logger;
                    v6.c cVar = z0Var.mPlayType;
                    String str = z0Var.mVideoName;
                    long j10 = z0Var.getMSession().get();
                    x1.f1.lb.widget.videoview.j jVar3 = z0Var.mPlayerInfo;
                    Object objValueOf = jVar3 != null ? Integer.valueOf(jVar3.getPlayerId()) : null;
                    bVar2.a("[" + cVar + "][" + str + "] session[" + j10 + "] player_changed, [" + objValueOf + " -> " + jVar.getPlayerId() + "] ignored surface change", new Object[0]);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // x1.f1.lb.widget.videoview.b
        public void b(x1.f1.lb.widget.videoview.d holder, int width, int height) {
            kotlin.jvm.internal.m.f(holder, "holder");
            z0 z0Var = z0.this;
            x1.f1.lb.widget.videoview.j jVar = this.f21762b;
            z0 z0Var2 = this.f21763c;
            synchronized (z0Var) {
                try {
                    x1.f1.lb.widget.videoview.j jVar2 = z0Var.mPlayerInfo;
                    if (jVar2 == null || jVar.getPlayerId() != jVar2.getPlayerId()) {
                        q6.b bVar = z0Var.logger;
                        x1.f1.lb.widget.videoview.j jVar3 = z0Var.mPlayerInfo;
                        Object objValueOf = jVar3 != null ? Integer.valueOf(jVar3.getPlayerId()) : null;
                        bVar.a("player_changed, [" + objValueOf + " -> " + jVar.getPlayerId() + "] ignored surface create", new Object[0]);
                        return;
                    }
                    IMediaPlayer iMediaPlayerZ0 = z0.Z0(z0Var, null, 1, null);
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        q6.b bVar2 = z0Var.logger;
                        Integer numValueOf = Integer.valueOf(z0Var2.hashCode());
                        String simpleName = z0.class.getSimpleName();
                        Context context = z0Var.mContext;
                        Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                        Context context2 = z0Var.mContext;
                        bVar2.debug("media_player_on@{}:{}@{}:{} render surface created, session[{}] holder[{}] player[{}], width[{}], height[{}]", numValueOf, simpleName, numValueOf2, context2 != null ? context2.getClass().getSimpleName() : null, Long.valueOf(z0Var.getMSession().get()), z0Var.j1(holder), z0Var.i1(iMediaPlayerZ0), Integer.valueOf(width), Integer.valueOf(height));
                    }
                    if (iMediaPlayerZ0 != null) {
                        z0Var.B0(jVar, holder, "surface created");
                        z0Var.D2();
                    } else {
                        z0Var.mSurfaceHolder = holder;
                    }
                    r8.z zVar = r8.z.f17874a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // x1.f1.lb.widget.videoview.b
        public void c(x1.f1.lb.widget.videoview.d holder) {
            kotlin.jvm.internal.m.f(holder, "holder");
            z0 z0Var = z0.this;
            x1.f1.lb.widget.videoview.j jVar = this.f21762b;
            z0 z0Var2 = this.f21763c;
            synchronized (z0Var) {
                try {
                    x1.f1.lb.widget.videoview.j jVar2 = z0Var.mPlayerInfo;
                    if (jVar2 != null && jVar.getPlayerId() == jVar2.getPlayerId()) {
                        if (x1.f1.lb.config.b.f20643a.t()) {
                            q6.b bVar = z0Var.logger;
                            Integer numValueOf = Integer.valueOf(z0Var2.hashCode());
                            String simpleName = z0.class.getSimpleName();
                            Context context = z0Var.mContext;
                            Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                            Context context2 = z0Var.mContext;
                            bVar.debug("media_player_on@{}:{}@{}:{} render surface destroyed, session[{}] {} {} {}", numValueOf, simpleName, numValueOf2, context2 != null ? context2.getClass().getSimpleName() : null, Long.valueOf(z0Var.getMSession().get()), z0Var.j1(holder), z0Var.i1(z0.Z0(z0Var, null, 1, null)), Boolean.valueOf(z0Var.L1()));
                        }
                        z0Var.N2(true);
                        z0Var.mSurfaceHolder = null;
                        z0Var.startPlayInitTime.set(d1.c());
                        r8.z zVar = r8.z.f17874a;
                        return;
                    }
                    z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.getMSession().get() + "] player_changed, ignored surface destroy", new Object[0]);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/z0$j", "Lx1/f1/lb/widget/videoview/j$a;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "Lr8/z;", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j implements x1.f1.lb.widget.videoview.j.a {
        j() {
        }

        @Override // x1.f1.lb.widget.videoview.j.a
        public void a(IMediaPlayer player) {
            kotlin.jvm.internal.m.f(player, "player");
            IMediaPlayer.OnErrorListener onErrorListener = z0.this.mOnErrorListenerWrapper;
            if (onErrorListener == null) {
                kotlin.jvm.internal.m.v("mOnErrorListenerWrapper");
                onErrorListener = null;
            }
            onErrorListener.onError(player, 1, TypedValues.PositionType.TYPE_PERCENT_HEIGHT);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.VideoViewHandler$loadLastPlayPosition$1", f = "VideoViewHandler.kt", l = {1841, 1846, 1853}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class k extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super Long>, v8.f<? super r8.z>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.VideoViewHandler$loadLastPlayPosition$1$1", f = "VideoViewHandler.kt", l = {1852}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Long>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ String $positionKey;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;
            final /* synthetic */ z0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(z0 z0Var, String str, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = z0Var;
                this.$positionKey = str;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, this.$positionKey, fVar);
                aVar.L$0 = gVar;
                aVar.L$1 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
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
                    kotlinx.coroutines.flow.g gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    Throwable th = (Throwable) this.L$1;
                    this.this$0.logger.warn("play_position [" + this.this$0.mPlayType + "][" + this.this$0.mVideoName + "] session[" + this.this$0.getMSession().get() + "] load[" + this.$positionKey + "][0]", th);
                    Long lC = kotlin.coroutines.jvm.internal.b.c(0L);
                    this.L$0 = null;
                    this.label = 1;
                    if (gVar.emit(lC, this) == objC) {
                        return objC;
                    }
                }
                return r8.z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ z0 f21765a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f21766b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<Long> f21767c;

            /* JADX WARN: Multi-variable type inference failed */
            b(z0 z0Var, String str, kotlinx.coroutines.flow.g<? super Long> gVar) {
                this.f21765a = z0Var;
                this.f21766b = str;
                this.f21767c = gVar;
            }

            public final Object b(long j10, v8.f<? super r8.z> fVar) {
                this.f21765a.logger.a("play_position [" + this.f21765a.mPlayType + "][" + this.f21765a.mVideoName + "] session[" + this.f21765a.getMSession().get() + "] load[" + this.f21766b + "][" + j10 + "]", new Object[0]);
                Object objEmit = this.f21767c.emit(kotlin.coroutines.jvm.internal.b.c(j10), fVar);
                return objEmit == kotlin.coroutines.intrinsics.b.c() ? objEmit : r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).longValue(), fVar);
            }
        }

        k(v8.f<? super k> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            k kVar = z0.this.new k(fVar);
            kVar.L$0 = obj;
            return kVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, v8.f<? super r8.z> fVar) {
            return ((k) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x008f, code lost:
        
            if (r3.collect(r4, r11) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00fb, code lost:
        
            if (r1.emit(r12, r11) == r0) goto L37;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            String strE;
            nf.r event;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            r8.r.b(obj);
                            return r8.z.f17874a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                    return r8.z.f17874a;
                }
                gVar = (kotlinx.coroutines.flow.g) this.L$0;
                r8.r.b(obj);
            } else {
                r8.r.b(obj);
                gVar = (kotlinx.coroutines.flow.g) this.L$0;
                x1.f1.lb.widget.videoview.i iVar = x1.f1.lb.widget.videoview.i.f21588a;
                long j10 = z0.this.getMSession().get();
                this.L$0 = gVar;
                this.label = 1;
                obj = iVar.b(j10, this);
                if (obj != objC) {
                }
                return objC;
            }
            x1.f1.lb.widget.videoview.h hVar = (x1.f1.lb.widget.videoview.h) obj;
            if (hVar == null || (event = hVar.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String()) == null || (strE = event.e()) == null) {
                strE = "";
            }
            v6.c cVar = z0.this.mPlayType;
            v6.c cVar2 = v6.c.LIVE;
            if (cVar != cVar2 && strE.length() != 0) {
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(x1.f1.lb.widget.videoview.g.f21577a.d(strE), new a(z0.this, strE, null));
                b bVar = new b(z0.this, strE, gVar);
                this.L$0 = null;
                this.label = 3;
            } else {
                if (z0.this.mPlayType != cVar2) {
                    z0.this.logger.a("play_position [" + z0.this.mPlayType + "][" + z0.this.mVideoName + "] session[" + z0.this.getMSession().get() + "] load[" + strE + "][0]", new Object[0]);
                }
                Long lC = kotlin.coroutines.jvm.internal.b.c(0L);
                this.L$0 = null;
                this.label = 2;
            }
            return objC;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/z0$l", "Lx1/f1/lb/widget/videoview/j$a;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "Lr8/z;", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class l implements x1.f1.lb.widget.videoview.j.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z0 f21769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f21770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ x1.f1.lb.widget.videoview.j f21771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f21772e;

        l(z0 z0Var, boolean z10, x1.f1.lb.widget.videoview.j jVar, b bVar) {
            this.f21769b = z0Var;
            this.f21770c = z10;
            this.f21771d = jVar;
            this.f21772e = bVar;
        }

        @Override // x1.f1.lb.widget.videoview.j.a
        public void a(IMediaPlayer player) {
            kotlin.jvm.internal.m.f(player, "player");
            IMediaPlayer.OnPreparedListener onPreparedListener = null;
            if (x1.f1.lb.config.b.f20643a.t()) {
                q6.b bVar = z0.this.logger;
                Integer numValueOf = Integer.valueOf(this.f21769b.hashCode());
                String simpleName = this.f21769b.getClass().getSimpleName();
                Context context = z0.this.mContext;
                Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                Context context2 = z0.this.mContext;
                bVar.debug("media_player_on@{}:{}@{}:{} new player created, session[{}] {}, shouldInitPlayer[{}]", numValueOf, simpleName, numValueOf2, context2 != null ? context2.getClass().getSimpleName() : null, Long.valueOf(z0.this.getMSession().get()), z0.this.i1(player), Boolean.valueOf(this.f21770c));
            }
            z0.this.A0(player);
            z0.this.k2(this.f21771d, 10001, 3000L);
            z0.this.k2(this.f21771d, 10002, 1000L);
            if (this.f21770c) {
                z0.this.d2(this.f21771d.getPlayerId(), this.f21772e);
                return;
            }
            IMediaPlayer.OnPreparedListener onPreparedListener2 = z0.this.mOnPreparedListenerWrapper;
            if (onPreparedListener2 == null) {
                kotlin.jvm.internal.m.v("mOnPreparedListenerWrapper");
            } else {
                onPreparedListener = onPreparedListener2;
            }
            onPreparedListener.onPrepared(player);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/z0$m", "Lx1/f1/lb/widget/videoview/z0$b;", "Lx1/f1/lb/widget/videoview/j;", "playerInfo", "Lr8/z;", "a", "(Lx1/f1/lb/widget/videoview/j;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class m implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f21773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z0 f21774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z0 f21775c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f21776d;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/z0$m$a", "Lx1/f1/lb/widget/videoview/j$a;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "Lr8/z;", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements x1.f1.lb.widget.videoview.j.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f21777a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ z0 f21778b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ x1.f1.lb.widget.videoview.j f21779c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ z0 f21780d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f21781e;

            /* JADX WARN: Code duplicated, block: B:81:0x035b  */
            /* JADX WARN: Code duplicated, block: B:82:0x0362  */
            @Override // x1.f1.lb.widget.videoview.j.a
            public void a(IMediaPlayer player) {
                IMediaPlayer.OnErrorListener onErrorListener;
                char c10;
                char c11;
                char c12;
                IMediaPlayer.OnErrorListener onErrorListener2;
                IMediaPlayer.OnErrorListener onErrorListener3;
                String str;
                kotlin.jvm.internal.m.f(player, "player");
                try {
                    if (this.f21777a == null) {
                        this.f21778b.logger.error("play url is empty", new Object[0]);
                        return;
                    }
                    int iHashCode = player.hashCode();
                    int i10 = this.f21779c.getAndroidx.core.app.NotificationCompat.CATEGORY_STATUS java.lang.String();
                    try {
                        if (i10 == 0 || i10 == 5) {
                            c10 = 4;
                            c11 = 3;
                            c12 = 5;
                            this.f21779c.j(1);
                            this.f21778b.mBufferPercent = 0;
                            onErrorListener = null;
                            try {
                                if (ua.n.O(this.f21777a, LocationInfo.NA, false, 2, null)) {
                                    str = this.f21777a + "&" + x1.f1.lb.streaming.server.r.f21132a.k() + "=" + iHashCode;
                                } else {
                                    str = this.f21777a + LocationInfo.NA + x1.f1.lb.streaming.server.r.f21132a.k() + "=" + iHashCode;
                                }
                                c cVar = this.f21778b.mPlayerMeter;
                                if (cVar == null) {
                                    kotlin.jvm.internal.m.v("mPlayerMeter");
                                    cVar = null;
                                }
                                cVar.l();
                                c cVar2 = this.f21778b.mPlayerMeter;
                                if (cVar2 == null) {
                                    kotlin.jvm.internal.m.v("mPlayerMeter");
                                    cVar2 = null;
                                }
                                cVar2.i();
                                this.f21778b.mVideoWidth = 0;
                                this.f21778b.mVideoHeight = 0;
                                onErrorListener = null;
                                z0.L2(this.f21778b, null, 1, null);
                                Uri uri = Uri.parse(str);
                                kotlin.jvm.internal.m.e(uri, "parse(this)");
                                try {
                                    player.setDataSource(this.f21778b.mContext, uri);
                                    if (x1.f1.lb.config.b.f20643a.t()) {
                                        this.f21778b.logger.debug("zapping_time_opt set_url_to_player player[{}]", Integer.valueOf(player.hashCode()));
                                    }
                                } catch (IllegalStateException unused) {
                                    player.reset();
                                    player.setDataSource(this.f21778b.mContext, uri);
                                }
                                try {
                                    player.prepareAsync();
                                } catch (IllegalStateException unused2) {
                                    player.reset();
                                    player.setDataSource(this.f21778b.mContext, uri);
                                    player.prepareAsync();
                                }
                                if (x1.f1.lb.config.b.f20643a.t()) {
                                    q6.b bVar = this.f21778b.logger;
                                    Integer numValueOf = Integer.valueOf(this.f21780d.hashCode());
                                    String simpleName = this.f21780d.getClass().getSimpleName();
                                    Context context = this.f21778b.mContext;
                                    Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                                    Context context2 = this.f21778b.mContext;
                                    bVar.debug("media_player_on@{}:{}@{}:{} player prepare async {} ms, {}, {}, {}", numValueOf, simpleName, numValueOf2, context2 != null ? context2.getClass().getSimpleName() : null, Long.valueOf(d1.c() - this.f21781e), Integer.valueOf(iHashCode), Long.valueOf(this.f21778b.mSeekPosition), this.f21777a);
                                    return;
                                }
                                this.f21778b.logger.a("set media_player [" + this.f21778b.mPlayType + "][" + this.f21778b.mVideoName + "] session[" + this.f21778b.getMSession().get() + "] [" + str + "]", new Object[0]);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                q6.b bVar2 = this.f21778b.logger;
                                v6.c cVar3 = this.f21778b.mPlayType;
                                String str2 = this.f21778b.mVideoName;
                                Long lValueOf = Long.valueOf(this.f21778b.getMSession().get());
                                String strI1 = this.f21778b.i1(player);
                                String str3 = this.f21777a;
                                Object[] objArr = new Object[6];
                                objArr[0] = cVar3;
                                objArr[1] = str2;
                                objArr[2] = lValueOf;
                                objArr[c11] = strI1;
                                objArr[c10] = str3;
                                objArr[c12] = th;
                                bVar2.error("start player failure [{}] [{}] session[{}], player[ {} ], uri[ {} ]", objArr);
                                onErrorListener2 = this.f21778b.mOnErrorListenerWrapper;
                                if (onErrorListener2 == null) {
                                    kotlin.jvm.internal.m.v("mOnErrorListenerWrapper");
                                    onErrorListener3 = onErrorListener;
                                } else {
                                    onErrorListener3 = onErrorListener2;
                                }
                                onErrorListener3.onError(player, 1, 405);
                            }
                        }
                        try {
                            x1.f1.lb.widget.videoview.j jVar = this.f21778b.mPlayerInfo;
                            c10 = 4;
                            c11 = 3;
                            if (!kotlin.jvm.internal.m.a(this.f21779c, jVar)) {
                                IMediaPlayer mediaPlayer = jVar != null ? jVar.getMediaPlayer() : null;
                                Integer numValueOf3 = jVar != null ? Integer.valueOf(jVar.getAndroidx.core.app.NotificationCompat.CATEGORY_STATUS java.lang.String()) : null;
                                Integer num = numValueOf3;
                                this.f21778b.logger.warn("player@" + this.f21778b.i1(player) + "/" + this.f21779c.hashCode() + " [" + this.f21778b.mPlayType + "][" + this.f21778b.mVideoName + "] session[" + this.f21778b.getMSession().get() + "] init failure, player@" + this.f21778b.i1(mediaPlayer) + "/" + this.f21778b.h1(jVar) + " status=" + num, new Object[0]);
                                return;
                            }
                            try {
                                q6.b bVar3 = this.f21778b.logger;
                                String strI2 = this.f21778b.i1(player);
                                v6.c cVar4 = this.f21778b.mPlayType;
                                c12 = 5;
                                try {
                                    String str4 = this.f21778b.mVideoName;
                                    bVar3.warn("player@" + strI2 + " [" + cVar4 + "][" + str4 + "] session[" + this.f21778b.getMSession().get() + "] init failure, player status=" + i10, new Object[0]);
                                } catch (Throwable th2) {
                                    th = th2;
                                    onErrorListener = null;
                                    q6.b bVar4 = this.f21778b.logger;
                                    v6.c cVar5 = this.f21778b.mPlayType;
                                    String str5 = this.f21778b.mVideoName;
                                    Long lValueOf2 = Long.valueOf(this.f21778b.getMSession().get());
                                    String strI3 = this.f21778b.i1(player);
                                    String str6 = this.f21777a;
                                    Object[] objArr2 = new Object[6];
                                    objArr2[0] = cVar5;
                                    objArr2[1] = str5;
                                    objArr2[2] = lValueOf2;
                                    objArr2[c11] = strI3;
                                    objArr2[c10] = str6;
                                    objArr2[c12] = th;
                                    bVar4.error("start player failure [{}] [{}] session[{}], player[ {} ], uri[ {} ]", objArr2);
                                    onErrorListener2 = this.f21778b.mOnErrorListenerWrapper;
                                    if (onErrorListener2 == null) {
                                        kotlin.jvm.internal.m.v("mOnErrorListenerWrapper");
                                        onErrorListener3 = onErrorListener;
                                    } else {
                                        onErrorListener3 = onErrorListener2;
                                    }
                                    onErrorListener3.onError(player, 1, 405);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                c12 = 5;
                                onErrorListener = null;
                                q6.b bVar5 = this.f21778b.logger;
                                v6.c cVar6 = this.f21778b.mPlayType;
                                String str7 = this.f21778b.mVideoName;
                                Long lValueOf3 = Long.valueOf(this.f21778b.getMSession().get());
                                String strI4 = this.f21778b.i1(player);
                                String str8 = this.f21777a;
                                Object[] objArr3 = new Object[6];
                                objArr3[0] = cVar6;
                                objArr3[1] = str7;
                                objArr3[2] = lValueOf3;
                                objArr3[c11] = strI4;
                                objArr3[c10] = str8;
                                objArr3[c12] = th;
                                bVar5.error("start player failure [{}] [{}] session[{}], player[ {} ], uri[ {} ]", objArr3);
                                onErrorListener2 = this.f21778b.mOnErrorListenerWrapper;
                                if (onErrorListener2 == null) {
                                    kotlin.jvm.internal.m.v("mOnErrorListenerWrapper");
                                    onErrorListener3 = onErrorListener;
                                } else {
                                    onErrorListener3 = onErrorListener2;
                                }
                                onErrorListener3.onError(player, 1, 405);
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            c10 = 4;
                            c11 = 3;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    onErrorListener = null;
                    c10 = 4;
                    c11 = 3;
                    c12 = 5;
                }
            }

            a(String str, z0 z0Var, x1.f1.lb.widget.videoview.j jVar, z0 z0Var2, long j10) {
                this.f21777a = str;
                this.f21778b = z0Var;
                this.f21779c = jVar;
                this.f21780d = z0Var2;
                this.f21781e = j10;
            }
        }

        m(String str, z0 z0Var, z0 z0Var2, long j10) {
            this.f21773a = str;
            this.f21774b = z0Var;
            this.f21775c = z0Var2;
            this.f21776d = j10;
        }

        @Override // x1.f1.lb.widget.videoview.z0.b
        public void a(x1.f1.lb.widget.videoview.j playerInfo) {
            if (playerInfo != null) {
                playerInfo.a(new a(this.f21773a, this.f21774b, playerInfo, this.f21775c, this.f21776d));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.VideoViewHandler$savePlayPosition$1", f = "VideoViewHandler.kt", l = {1893}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class n extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ long $position;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(long j10, v8.f<? super n> fVar) {
            super(2, fVar);
            this.$position = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return z0.this.new n(this.$position, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((n) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                z0 z0Var = z0.this;
                this.label = 1;
                obj = z0Var.a1(this);
                if (obj == objC) {
                    return objC;
                }
            }
            String str = (String) obj;
            if (str == null) {
                return r8.z.f17874a;
            }
            x1.f1.lb.widget.videoview.g.f21577a.f(str, this.$position);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.VideoViewHandler$setVideoPath$1", f = "VideoViewHandler.kt", l = {2556}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class o extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.VideoViewHandler$setVideoPath$1$1", f = "VideoViewHandler.kt", l = {2553}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Long>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ String $url;
            int label;
            final /* synthetic */ z0 this$0;

            /* JADX INFO: renamed from: x1.f1.lb.widget.videoview.z0$o$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.VideoViewHandler$setVideoPath$1$1$1", f = "VideoViewHandler.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0470a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ String $url;
                int label;
                final /* synthetic */ z0 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0470a(z0 z0Var, String str, v8.f<? super C0470a> fVar) {
                    super(2, fVar);
                    this.this$0 = z0Var;
                    this.$url = str;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0470a(this.this$0, this.$url, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0470a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        z0.X1(this.this$0, this.$url, null, 2, null);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(z0 z0Var, String str, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = z0Var;
                this.$url = str;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                return new a(this.this$0, this.$url, fVar).invokeSuspend(r8.z.f17874a);
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
                    g2 g2VarC = kotlinx.coroutines.a1.c();
                    C0470a c0470a = new C0470a(this.this$0, this.$url, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(g2VarC, c0470a, this) == objC) {
                        return objC;
                    }
                }
                return r8.z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ z0 f21782a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f21783b;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.VideoViewHandler$setVideoPath$1$2$1", f = "VideoViewHandler.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ String $url;
                int label;
                final /* synthetic */ z0 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(z0 z0Var, String str, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = z0Var;
                    this.$url = str;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$url, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        z0.X1(this.this$0, this.$url, null, 2, null);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(z0 z0Var, String str) {
                this.f21782a = z0Var;
                this.f21783b = str;
            }

            public final Object b(long j10, v8.f<? super r8.z> fVar) {
                this.f21782a.latestPlayPosition = j10;
                this.f21782a.lastSavedPosition = j10;
                Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.a1.c(), new a(this.f21782a, this.f21783b, null), fVar);
                return objG == kotlin.coroutines.intrinsics.b.c() ? objG : r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).longValue(), fVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(String str, v8.f<? super o> fVar) {
            super(2, fVar);
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return z0.this.new o(this.$url, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((o) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(z0.this.M1(), new a(z0.this, this.$url, null));
                b bVar = new b(z0.this, this.$url);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/z0$p", "Lx1/f1/lb/widget/videoview/j$a;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "Lr8/z;", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p implements x1.f1.lb.widget.videoview.j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f21784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z0 f21785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21786c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ x1.f1.lb.widget.videoview.j f21787d;

        p(boolean[] zArr, z0 z0Var, String str, x1.f1.lb.widget.videoview.j jVar) {
            this.f21784a = zArr;
            this.f21785b = z0Var;
            this.f21786c = str;
            this.f21787d = jVar;
        }

        @Override // x1.f1.lb.widget.videoview.j.a
        public void a(IMediaPlayer player) {
            kotlin.jvm.internal.m.f(player, "player");
            this.f21784a[0] = z0.J2(this.f21785b, player, this.f21786c, false, 4, null);
            if (this.f21784a[0]) {
                this.f21787d.j(3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.VideoViewHandler$stop$1", f = "VideoViewHandler.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class q extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ long $session;
        int label;
        final /* synthetic */ z0 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(long j10, z0 z0Var, v8.f<? super q> fVar) {
            super(2, fVar);
            this.$session = j10;
            this.this$0 = z0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new q(this.$session, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((q) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                try {
                    x1.f1.lb.widget.videoview.k.f21604a.p(this.$session);
                } catch (Throwable th) {
                    this.this$0.logger.error("stop player failure", th);
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/z0$r", "Lx1/f1/lb/widget/videoview/j$a;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "player", "Lr8/z;", "a", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class r implements x1.f1.lb.widget.videoview.j.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x1.f1.lb.widget.videoview.j f21789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean[] f21790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f21791d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f21792e;

        r(x1.f1.lb.widget.videoview.j jVar, boolean[] zArr, long j10, String str) {
            this.f21789b = jVar;
            this.f21790c = zArr;
            this.f21791d = j10;
            this.f21792e = str;
        }

        @Override // x1.f1.lb.widget.videoview.j.a
        public void a(IMediaPlayer player) {
            kotlin.jvm.internal.m.f(player, "player");
            try {
                z0.J2(z0.this, player, "tryResumePlayer", false, 4, null);
                if (player.isPlaying()) {
                    z0.this.F0(this.f21789b);
                    z0.this.mIsPaused = false;
                    this.f21790c[0] = true;
                }
            } catch (Exception e10) {
                z0.this.logger.error("[" + z0.this.mPlayType + "][" + z0.this.mVideoName + "] [" + this.f21791d + "] start play failure, try to reset player [" + this.f21792e + "]", e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D2() {
        x1.f1.lb.widget.videoview.j jVarG;
        g0 videoInfo;
        IMediaPlayer iMediaPlayerZ0 = Z0(this, null, 1, null);
        if (iMediaPlayerZ0 == null || this.preparedTime == 0 || (jVarG = x1.f1.lb.widget.videoview.k.f21604a.g()) == null || (videoInfo = jVarG.getVideoInfo()) == null) {
            return;
        }
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener == null) {
            kotlin.jvm.internal.m.v("mOnVideoSizeChangedListener");
            onVideoSizeChangedListener = null;
        }
        onVideoSizeChangedListener.onVideoSizeChanged(iMediaPlayerZ0, videoInfo.getWidth(), videoInfo.getHeight(), videoInfo.getSarNum(), videoInfo.getSarDen());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I1() {
        IMediaPlayer iMediaPlayerZ0 = Z0(this, null, 1, null);
        if (iMediaPlayerZ0 != null) {
            try {
                if (this.preparedTime > 0 && iMediaPlayerZ0.isPlaying()) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I2(IMediaPlayer player, String from, boolean isForce) {
        if (isForce || L1()) {
            try {
                player.start();
                this.mIsPaused = false;
                return true;
            } catch (Exception e10) {
                this.logger.error("pause player failure", e10);
                return false;
            }
        }
        this.logger.warn("[" + this.mPlayType + "][" + this.mVideoName + "][" + this.mSession.get() + "] from[" + from + "] video view is not shown, ignored start play " + i1(player), new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R2(z0 z0Var) {
        z0Var.isLoading = false;
        c9.p<? super Boolean, ? super String, r8.z> pVar = z0Var.loadingListener;
        if (pVar != null) {
            if (pVar != null) {
                pVar.invoke(Boolean.FALSE, "");
            }
        } else {
            x1.f1.lb.widget.videoview.e eVar = z0Var.mVideoView;
            if (eVar != null) {
                eVar.stopAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y1(z0 z0Var, int i10, String str, z0 z0Var2, b bVar) {
        synchronized (z0Var) {
            try {
                z0Var.mIsSoftDecoder = i10 == 1 ? 0 : 1;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    z0Var.logger.debug("decoder_setting: " + i10 + ", " + z0Var.mIsSoftDecoder + ", " + z0Var.mHardwareDecodeFlag, new Object[0]);
                }
                x1.f1.lb.widget.videoview.k kVar = x1.f1.lb.widget.videoview.k.f21604a;
                x1.f1.lb.widget.videoview.j jVarG = kVar.g();
                z0Var.b2(jVarG, 10001);
                z0Var.b2(jVarG, 10002);
                x1.f1.lb.widget.videoview.j jVarB = kVar.b(str, i10, z0Var.mHardwareDecodeFlag, z0Var.mPlayerArgs, z0Var.mPlayType, z0Var.mSession.get());
                boolean z10 = !kotlin.jvm.internal.m.a(jVarG, jVarB);
                z0Var.mPlayerInfo = jVarB;
                z0Var.C1(jVarB);
                z0Var.r1(jVarB);
                z0Var.u1(jVarB);
                jVarB.a(z0Var.new l(z0Var2, z10, jVarB, bVar));
                r8.z zVar = r8.z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(z0 z0Var) {
        L2(z0Var, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(z0 z0Var, x1.f1.lb.widget.videoview.j jVar, List list, IMediaPlayer iMediaPlayer) {
        synchronized (z0Var) {
            try {
                x1.f1.lb.widget.videoview.j jVar2 = z0Var.mPlayerInfo;
                if (jVar2 == null || jVar.getPlayerId() != jVar2.getPlayerId()) {
                    z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] player_changed, ignored play on seek complete", new Object[0]);
                    return;
                }
                long currentPosition = iMediaPlayer != null ? iMediaPlayer.getCurrentPosition() : 0L;
                if (Math.abs(z0Var.mSeekPosition - currentPosition) > 20000) {
                    Long l10 = (Long) kotlin.collections.r.i0(list);
                    long j10 = z0Var.mSeekPosition;
                    if (l10 == null || l10.longValue() != j10) {
                        q6.b bVar = z0Var.logger;
                        long j11 = z0Var.mSeekPosition;
                        bVar.a("seek_to[" + j11 + "] complete_at[" + currentPosition + "] seek_to[" + j11 + "] once more", new Object[0]);
                        z0Var.j2(z0Var.mSeekPosition);
                        list.set(0, Long.valueOf(z0Var.mSeekPosition));
                    }
                }
                z0Var.mIsPaused = false;
                z0Var.lastSeekCompletePosition = currentPosition;
                IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = z0Var.mOnSeekCompleteListener;
                if (onSeekCompleteListener != null) {
                    onSeekCompleteListener.onSeekComplete(iMediaPlayer);
                }
                r8.z zVar = r8.z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean F2(String videoName, String url, String playerArgs, v6.c playType, long session) {
        String string;
        kotlin.jvm.internal.m.f(videoName, "videoName");
        kotlin.jvm.internal.m.f(playType, "playType");
        if (url == null) {
            return false;
        }
        this.startPlayInitTime.set(d1.c());
        a2();
        if (S2(url, session)) {
            return false;
        }
        if (this.mSession.get() != session || !kotlin.jvm.internal.m.a(this.mVideoName, videoName)) {
            this.mSession.set(session);
            Context context = this.mContext;
            if (context == null || (string = context.getString(R$string.connecting)) == null) {
                string = "";
            }
            K2(string);
        }
        this.isPlayerInInitializing = true;
        this.mGatewayTimeoutMillis = playType == v6.c.CATCHUP ? 90000L : 30000L;
        this.mVideoDuration = 0L;
        this.mPlayUri = url;
        this.mAspectRatioType = x1.f1.lb.media.d.f20812a.q(playType);
        this.mPlayType = playType;
        this.mIsForceStop = false;
        this.mVideoName = videoName;
        this.mPlayerArgs = playerArgs;
        Handler handler = this.mHandler;
        Runnable runnable = null;
        if (handler == null) {
            kotlin.jvm.internal.m.v("mHandler");
            handler = null;
        }
        Runnable runnable2 = this.mGatewayTimeoutHandler;
        if (runnable2 == null) {
            kotlin.jvm.internal.m.v("mGatewayTimeoutHandler");
            runnable2 = null;
        }
        handler.removeCallbacks(runnable2);
        if (this.mIsCompleted) {
            j2(0L);
            X1(this, url, null, 2, null);
        } else {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new o(url, null), 3, null);
        }
        Handler handler2 = this.mHandler;
        if (handler2 == null) {
            kotlin.jvm.internal.m.v("mHandler");
            handler2 = null;
        }
        Runnable runnable3 = this.mGatewayTimeoutHandler;
        if (runnable3 == null) {
            kotlin.jvm.internal.m.v("mGatewayTimeoutHandler");
        } else {
            runnable = runnable3;
        }
        handler2.postDelayed(runnable, this.mGatewayTimeoutMillis);
        x1.f1.lb.widget.videoview.e eVar = this.mVideoView;
        if (eVar != null) {
            eVar.invalidate();
        }
        tf.d dVarC = x1.f1.lb.metric.monitor.h.f20952a.c();
        if (dVarC != null) {
            dVarC.W(d1.c());
        }
        this.isPlayerInInitializing = false;
        return true;
    }

    public final boolean H2() {
        this.mIsPaused = false;
        String strB = x1.f1.lb.util.q.f21441a.b(3);
        x1.f1.lb.widget.videoview.j jVar = this.mPlayerInfo;
        if (jVar == null) {
            return false;
        }
        boolean[] zArr = {false};
        jVar.a(new p(zArr, this, strB, jVar));
        return zArr[0];
    }

    public long N0() {
        IMediaPlayer iMediaPlayerZ0 = Z0(this, null, 1, null);
        if (iMediaPlayerZ0 == null || this.preparedTime <= 0) {
            return -1L;
        }
        try {
            return iMediaPlayerZ0.getCurrentPosition();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public final long S0() {
        return T0(Z0(this, null, 1, null));
    }

    public final boolean h2() {
        this.mIsPaused = false;
        return S2(this.mPlayUri, this.mSession.get());
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(nf.v event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        if (event.d() <= this.lastSession) {
            return;
        }
        Message message = new Message();
        message.what = 10000;
        message.obj = Integer.valueOf(event.c());
        message.arg1 = event.e();
        Handler handler = this.mHandler;
        if (handler == null) {
            kotlin.jvm.internal.m.v("mHandler");
            handler = null;
        }
        handler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(IMediaPlayer player) {
        IMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListenerWrapper;
        IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = null;
        if (onInfoListener == null) {
            kotlin.jvm.internal.m.v("mOnInfoListenerWrapper");
            onInfoListener = null;
        }
        player.setOnInfoListener(onInfoListener);
        IMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListenerWrapper;
        if (onErrorListener == null) {
            kotlin.jvm.internal.m.v("mOnErrorListenerWrapper");
            onErrorListener = null;
        }
        player.setOnErrorListener(onErrorListener);
        IMediaPlayer.OnPreparedListener onPreparedListener = this.mOnPreparedListenerWrapper;
        if (onPreparedListener == null) {
            kotlin.jvm.internal.m.v("mOnPreparedListenerWrapper");
            onPreparedListener = null;
        }
        player.setOnPreparedListener(onPreparedListener);
        IMediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListenerWrapper;
        if (onCompletionListener == null) {
            kotlin.jvm.internal.m.v("mOnCompletionListenerWrapper");
            onCompletionListener = null;
        }
        player.setOnCompletionListener(onCompletionListener);
        player.setAudioStreamType(3);
        IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListenerWrapper;
        if (onSeekCompleteListener == null) {
            kotlin.jvm.internal.m.v("mOnSeekCompleteListenerWrapper");
            onSeekCompleteListener = null;
        }
        player.setOnSeekCompleteListener(onSeekCompleteListener);
        IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener == null) {
            kotlin.jvm.internal.m.v("mOnVideoSizeChangedListener");
            onVideoSizeChangedListener = null;
        }
        player.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener2 = this.mOnBufferingUpdateListener;
        if (onBufferingUpdateListener2 == null) {
            kotlin.jvm.internal.m.v("mOnBufferingUpdateListener");
        } else {
            onBufferingUpdateListener = onBufferingUpdateListener2;
        }
        player.setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    private final void A1() {
        this.mPlayerMeter = new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(x1.f1.lb.widget.videoview.j playerInfo, x1.f1.lb.widget.videoview.d holder, String from) {
        if (holder == null) {
            return;
        }
        x1.f1.lb.widget.videoview.d dVar = this.mSurfaceHolder;
        this.mSurfaceHolder = holder;
        int i10 = playerInfo.getAndroidx.core.app.NotificationCompat.CATEGORY_STATUS java.lang.String();
        if (J1(playerInfo)) {
            playerInfo.a(new d(holder, playerInfo, from, dVar));
            return;
        }
        this.logger.warn("[" + this.mPlayType + "][" + this.mVideoName + "] session[" + this.mSession.get() + "] player bind and start failure, player status[" + i10 + "], from " + from, new Object[0]);
    }

    private final void B1() {
        x1.f1.lb.metric.monitor.f.f20907a.s(this);
        this.checkPlayingHandler = new h();
    }

    private final long C0() {
        long j10 = this.mMediaBufferingBeginTime;
        if (j10 > 0) {
            return d1.c() - j10;
        }
        return 0L;
    }

    private final void C1(x1.f1.lb.widget.videoview.j playerInfo) {
        this.mLastRenderCallback = this.mRenderCallback;
        this.mRenderCallback = new i(playerInfo, this);
    }

    private final Integer D0(int aspectRatioType) {
        if (aspectRatioType == 0) {
            return 0;
        }
        if (aspectRatioType == 1) {
            return 1;
        }
        if (aspectRatioType != 4) {
            return aspectRatioType != 5 ? null : 5;
        }
        return 4;
    }

    private final boolean E0() {
        return this.preparedTime > 0;
    }

    private final void E1() {
        this.mGatewayTimeoutHandler = new Runnable() { // from class: x1.f1.lb.widget.videoview.t0
            @Override // java.lang.Runnable
            public final void run() {
                z0.F1(this.f21652a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(x1.f1.lb.widget.videoview.j playerInfo) {
        this.mMediaBufferingBeginTime = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0(x1.f1.lb.widget.videoview.j playerInfo) {
        b2(playerInfo, 10003);
        Q2();
    }

    private final boolean J1(x1.f1.lb.widget.videoview.j info) {
        if (info == null) {
            info = this.mPlayerInfo;
        }
        if (info == null) {
            return false;
        }
        int i10 = info.getAndroidx.core.app.NotificationCompat.CATEGORY_STATUS java.lang.String();
        return i10 == 2 || i10 == 3 || i10 == 4;
    }

    static /* synthetic */ boolean J2(z0 z0Var, IMediaPlayer iMediaPlayer, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return z0Var.I2(iMediaPlayer, str, z10);
    }

    public static /* synthetic */ void K0(z0 z0Var, int i10, String str, Integer num, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            num = null;
        }
        z0Var.I0(i10, str, num);
    }

    public static /* synthetic */ void L0(z0 z0Var, String str, String str2, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            num = null;
        }
        z0Var.J0(str, str2, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L1() {
        x1.f1.lb.widget.videoview.e eVar = this.mVideoView;
        return eVar != null && eVar.isShown();
    }

    public static /* synthetic */ void L2(z0 z0Var, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        z0Var.K2(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.coroutines.flow.f<Long> M1() {
        return kotlinx.coroutines.flow.h.v(new k(null));
    }

    private final int P0(String url, Integer decodeMode) {
        int iIntValue = decodeMode != null ? decodeMode.intValue() : O0();
        if (url != null) {
            this.mHardwareDecodeFlag = 1L;
            if (iIntValue == 2) {
                this.mHardwareDecodeFlag = 0L;
            }
        }
        int i10 = this.mLastDecodeMode;
        if (i10 == -1) {
            this.mLastDecodeMode = iIntValue;
            return iIntValue;
        }
        if (iIntValue != i10) {
            this.mLastDecodeMode = iIntValue;
            if (x1.f1.lb.config.b.f20643a.t()) {
                q6.b bVar = this.logger;
                String str = "media_player_on@{}:{}@{}: [" + this.mPlayType + "][" + this.mVideoName + "] reset renderView[{}] session[{}] decodeMode[{} -> {}] hardwareDecodeFlag[{}]";
                Integer numValueOf = Integer.valueOf(hashCode());
                String simpleName = z0.class.getSimpleName();
                Context context = this.mContext;
                Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                Context context2 = this.mContext;
                bVar.debug(str, numValueOf, simpleName, numValueOf2, context2 != null ? context2.getClass().getSimpleName() : null, Long.valueOf(this.mSession.get()), Integer.valueOf(i10), Integer.valueOf(iIntValue), Long.valueOf(this.mHardwareDecodeFlag));
            }
        }
        return iIntValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(x1.f1.lb.widget.videoview.j playerInfo) {
        if (this.mMediaBufferingBeginTime > 0) {
            F0(playerInfo);
            c cVar = this.mPlayerMeter;
            if (cVar == null) {
                kotlin.jvm.internal.m.v("mPlayerMeter");
                cVar = null;
            }
            cVar.y();
            H2();
            xe.c.c().o(new nf.o());
            xe.c.c().o(new nf.w());
        }
    }

    public static /* synthetic */ long P2(z0 z0Var, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return z0Var.N2(z10);
    }

    private final void R1(x1.f1.lb.widget.videoview.j playerInfo, boolean isForceStop, int reason, Integer resId, String videoName, Integer code) {
        IMediaPlayer mediaPlayer;
        IMediaPlayer.OnErrorListener onErrorListener;
        Context context;
        String string;
        if (isForceStop) {
            c2();
            this.mIsForceStop = true;
            this.mForceStopReason = Integer.valueOf(reason);
            if (playerInfo != null) {
                G0(playerInfo, "stream[" + code + "]");
            }
            Q2();
        }
        if (this.noSignalListener != null) {
            String str = "";
            if (resId != null && (context = this.mContext) != null && (string = context.getString(resId.intValue())) != null) {
                str = string;
            }
            c9.p<? super Integer, ? super String, r8.z> pVar = this.noSignalListener;
            if (pVar != null) {
                pVar.invoke(Integer.valueOf(reason), str);
                return;
            }
            return;
        }
        if (resId != null) {
            I0(resId.intValue(), videoName, code);
        }
        if (playerInfo != null && (mediaPlayer = playerInfo.getMediaPlayer()) != null && (onErrorListener = this.mOnErrorListener) != null) {
            onErrorListener.onError(mediaPlayer, 404, 404);
        }
        x1.f1.lb.widget.videoview.e eVar = this.mVideoView;
        if (eVar != null) {
            eVar.n();
        }
    }

    static /* synthetic */ void S1(z0 z0Var, x1.f1.lb.widget.videoview.j jVar, boolean z10, int i10, Integer num, String str, Integer num2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            num = null;
        }
        if ((i11 & 16) != 0) {
            str = null;
        }
        if ((i11 & 32) != 0) {
            num2 = null;
        }
        z0Var.R1(jVar, z10, i10, num, str, num2);
    }

    private final boolean S2(String url, long session) {
        x1.f1.lb.widget.videoview.j jVarG = x1.f1.lb.widget.videoview.k.f21604a.g();
        if (jVarG == null) {
            return false;
        }
        int i10 = jVarG.getAndroidx.core.app.NotificationCompat.CATEGORY_STATUS java.lang.String();
        if ((i10 != 2 && i10 != 3 && i10 != 4) || !ac.g.d(url, jVarG.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_URL java.lang.String()) || jVarG.getSession() != session || this.mPlayUri == null || this.mSession.get() == 0) {
            return false;
        }
        if (this.isPlayerInInitializing) {
            return true;
        }
        boolean[] zArr = {false};
        jVarG.a(new r(jVarG, zArr, session, url));
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long T0(IMediaPlayer player) {
        if (player == null) {
            return 0L;
        }
        try {
            long j10 = this.mVideoDuration;
            if (j10 > 0) {
                return j10;
            }
            x1.f1.lb.widget.videoview.j jVar = this.mPlayerInfo;
            if (jVar == null || jVar.getAndroidx.core.app.NotificationCompat.CATEGORY_STATUS java.lang.String() != 3) {
                return 0L;
            }
            return player.getDuration();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(x1.f1.lb.widget.videoview.j playerInfo) {
        b2(playerInfo, 10003);
        k2(playerInfo, 10003, 1000L);
    }

    private final void T2() {
        x1.f1.lb.util.e0.f21385a.b(this);
    }

    private final void V1(final int decodeMode, final b mediaUriHandler, final String playUri) {
        if (playUri == null) {
            return;
        }
        this.startPlayInitTime.set(d1.c());
        this.isPlayPositionKeepMoving = false;
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: x1.f1.lb.widget.videoview.w0
                @Override // java.lang.Runnable
                public final void run() {
                    z0.Y1(this.f21660a, decodeMode, playUri, this, mediaUriHandler);
                }
            });
        }
    }

    static /* synthetic */ void X1(z0 z0Var, String str, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        z0Var.W1(str, num);
    }

    private final IMediaPlayer Y0(x1.f1.lb.widget.videoview.j playerInfo) {
        x1.f1.lb.widget.videoview.j jVar = this.mPlayerInfo;
        if (playerInfo != null && jVar != null && playerInfo.getPlayerId() != jVar.getPlayerId()) {
            this.logger.a("player_changed", new Object[0]);
            return null;
        }
        if (playerInfo == null) {
            if (jVar == null) {
                return null;
            }
            playerInfo = jVar;
        }
        if (J1(playerInfo)) {
            return playerInfo.getMediaPlayer();
        }
        return null;
    }

    static /* synthetic */ IMediaPlayer Z0(z0 z0Var, x1.f1.lb.widget.videoview.j jVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            jVar = null;
        }
        return z0Var.Y0(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a1(v8.f<? super String> fVar) {
        e eVar;
        nf.r event;
        if (fVar instanceof e) {
            eVar = (e) fVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(fVar);
            }
        } else {
            eVar = new e(fVar);
        }
        Object objB = eVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = eVar.label;
        if (i11 == 0) {
            r8.r.b(objB);
            x1.f1.lb.widget.videoview.i iVar = x1.f1.lb.widget.videoview.i.f21588a;
            long j10 = this.mSession.get();
            eVar.label = 1;
            objB = iVar.b(j10, eVar);
            if (objB == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(objB);
        }
        x1.f1.lb.widget.videoview.h hVar = (x1.f1.lb.widget.videoview.h) objB;
        if (hVar == null || (event = hVar.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String()) == null) {
            return null;
        }
        return event.e();
    }

    private final void a2() {
        x1.f1.lb.util.e0.f21385a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(x1.f1.lb.widget.videoview.j playerInfo, int what) {
        if (playerInfo == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            kotlin.jvm.internal.m.v("mHandler");
            handler = null;
        }
        handler.removeMessages(what, Integer.valueOf(playerInfo.getPlayerId()));
    }

    private final void c2() {
        b2(this.mPlayerInfo, 10002);
        b2(this.mPlayerInfo, IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START);
        b2(this.mPlayerInfo, 10003);
        b2(this.mPlayerInfo, 10001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(final int playerId, final b uriHandler) {
        final x1.f1.lb.widget.videoview.c cVar = this.mRenderView;
        if (cVar == null) {
            return;
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            kotlin.jvm.internal.m.v("mHandler");
            handler = null;
        }
        handler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.m0
            @Override // java.lang.Runnable
            public final void run() {
                z0.e2(this.f21620a, cVar, uriHandler, playerId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(final z0 z0Var, x1.f1.lb.widget.videoview.c cVar, final b bVar, final int i10) {
        x1.f1.lb.widget.videoview.b bVar2 = z0Var.mLastRenderCallback;
        if (bVar2 != null) {
            cVar.c(bVar2);
        }
        cVar.c(z0Var.mRenderCallback);
        x1.f1.lb.widget.videoview.e eVar = z0Var.mVideoView;
        if (eVar != null) {
            View view = cVar.getView();
            kotlin.jvm.internal.m.e(view, "getView(...)");
            eVar.removeView(view);
        }
        z0Var.C2(cVar);
        if (bVar != null) {
            z0Var.startPlayInitTime.set(d1.c());
            ExecutorService executorService = z0Var.mExecutorService;
            if (executorService != null) {
                executorService.execute(new Runnable() { // from class: x1.f1.lb.widget.videoview.n0
                    @Override // java.lang.Runnable
                    public final void run() {
                        z0.f2(this.f21626a, i10, bVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(z0 z0Var, int i10, final b bVar) {
        do {
            try {
                Thread.sleep(100L);
            } catch (Throwable unused) {
            }
        } while (z0Var.mSurfaceHolder == null);
        final x1.f1.lb.widget.videoview.j jVar = z0Var.mPlayerInfo;
        if (jVar == null || jVar.getPlayerId() != i10) {
            return;
        }
        Handler handler = z0Var.mHandler;
        if (handler == null) {
            kotlin.jvm.internal.m.v("mHandler");
            handler = null;
        }
        handler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.p0
            @Override // java.lang.Runnable
            public final void run() {
                z0.g2(bVar, jVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x0035  */
    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:19:0x009a  */
    /* JADX WARN: Instruction removed from duplicated block: B:16:0x003c, please report this as an issue */
    public final void g1(x1.f1.lb.widget.videoview.j playerInfo, int code) {
        z0 z0Var = this;
        x1.f1.lb.metric.monitor.f.f20907a.u(code);
        if (code == -4000) {
            S1(z0Var, playerInfo, false, 0, Integer.valueOf(R$string.no_stream_timeout_notice_message), null, null, 48, null);
            if (z0Var.preparedTime == 0) {
                Handler handler = z0Var.mHandler;
                if (handler == null) {
                    kotlin.jvm.internal.m.v("mHandler");
                    handler = null;
                }
                Runnable runnable = z0Var.mGatewayTimeoutHandler;
                if (runnable == null) {
                    kotlin.jvm.internal.m.v("mGatewayTimeoutHandler");
                    runnable = null;
                }
                handler.removeCallbacks(runnable);
                Handler handler2 = z0Var.mHandler;
                if (handler2 == null) {
                    kotlin.jvm.internal.m.v("mHandler");
                    handler2 = null;
                }
                Runnable runnable2 = z0Var.mGatewayTimeoutHandler;
                if (runnable2 == null) {
                    kotlin.jvm.internal.m.v("mGatewayTimeoutHandler");
                    runnable2 = null;
                }
                handler2.post(runnable2);
            } else {
                z0Var.logger.error("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] prt connection is timeout in playing", new Object[0]);
            }
        } else if (code != -1000) {
            if (code == 4101) {
                z0Var = this;
                S1(z0Var, playerInfo, true, 4, Integer.valueOf(R$string.session_logout), null, null, 48, null);
                z0Var.N2(true);
            } else if (code == 4003) {
                z0Var = this;
                S1(z0Var, playerInfo, true, 6, Integer.valueOf(R$string.no_stream_notice_message_invalid_stream), null, null, 48, null);
            } else if (code != 4004) {
                switch (code) {
                    case 1000:
                        z0Var.R1(playerInfo, true, 1, Integer.valueOf(R$string.no_stream_notice_message_no_free), z0Var.mVideoName, Integer.valueOf(code));
                        xe.c.c().o(new nf.x(z0Var.mVideoName, z0Var.mPlayType, Long.valueOf(z0Var.mSession.get())));
                        break;
                    case PointerIconCompat.TYPE_CONTEXT_MENU /* 1001 */:
                        S1(z0Var, playerInfo, true, 2, Integer.valueOf(R$string.no_stream_notice_message_no_server), null, null, 48, null);
                        break;
                    case PointerIconCompat.TYPE_HAND /* 1002 */:
                        S1(z0Var, playerInfo, true, 3, Integer.valueOf(R$string.no_stream_notice_message_out_of_limit), null, null, 48, null);
                        z0Var.N2(true);
                        break;
                    case PointerIconCompat.TYPE_HELP /* 1003 */:
                        z0Var.R1(playerInfo, true, 5, Integer.valueOf(R$string.no_stream_app_version_not_support), z0Var.mVideoName, Integer.valueOf(code));
                        z0Var.N2(true);
                        x1.f1.lb.heartbeat.f.f20678a.H0("stream[" + code + "]");
                        break;
                    case 1004:
                        x1.f1.lb.user.f.f21202a.o1();
                        break;
                    default:
                        switch (code) {
                            case 4006:
                                x1.f1.lb.user.f.f21202a.o1();
                                break;
                            case 4007:
                                z0Var.R1(playerInfo, true, 5, Integer.valueOf(R$string.no_stream_app_version_not_support), z0Var.mVideoName, Integer.valueOf(code));
                                z0Var.N2(true);
                                x1.f1.lb.heartbeat.f.f20678a.H0("stream[" + code + "]");
                                break;
                            case 4008:
                            case 4009:
                                z0Var.R1(playerInfo, true, 1, Integer.valueOf(R$string.no_stream_notice_message_no_free), z0Var.mVideoName, Integer.valueOf(code));
                                xe.c.c().o(new nf.x(z0Var.mVideoName, z0Var.mPlayType, Long.valueOf(z0Var.mSession.get())));
                                break;
                        }
                        break;
                }
            } else {
                S1(z0Var, playerInfo, true, 7, Integer.valueOf(R$string.no_stream_source_not_exists), null, null, 48, null);
                z0Var = this;
            }
        } else if (z0Var.preparedTime == 0) {
            S1(z0Var, playerInfo, false, 0, Integer.valueOf(R$string.no_stream_timeout_notice_message), null, null, 48, null);
            Handler handler3 = z0Var.mHandler;
            if (handler3 == null) {
                kotlin.jvm.internal.m.v("mHandler");
                handler3 = null;
            }
            Runnable runnable3 = z0Var.mGatewayTimeoutHandler;
            if (runnable3 == null) {
                kotlin.jvm.internal.m.v("mGatewayTimeoutHandler");
                runnable3 = null;
            }
            handler3.removeCallbacks(runnable3);
            Handler handler4 = z0Var.mHandler;
            if (handler4 == null) {
                kotlin.jvm.internal.m.v("mHandler");
                handler4 = null;
            }
            Runnable runnable4 = z0Var.mGatewayTimeoutHandler;
            if (runnable4 == null) {
                kotlin.jvm.internal.m.v("mGatewayTimeoutHandler");
                runnable4 = null;
            }
            handler4.post(runnable4);
        } else {
            z0Var.logger.error("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] tracker connection is timeout in playing", new Object[0]);
        }
        uf.c.f19486a.r(z0Var.mSession.get(), z0Var.mVideoName, code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer h1(Object obj) {
        if (obj != null) {
            return Integer.valueOf(obj.hashCode());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i1(IMediaPlayer player) {
        if (player == null) {
            return Configurator.NULL;
        }
        kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
        String str = String.format(Locale.ENGLISH, "%s[%d]", Arrays.copyOf(new Object[]{player.getClass().getSimpleName(), Integer.valueOf(player.hashCode())}, 2));
        kotlin.jvm.internal.m.e(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i2(long position) {
        if (this.mPlayType == v6.c.LIVE || position == this.lastSavedPosition) {
            return;
        }
        if (x1.f1.lb.config.b.f20643a.t()) {
            q6.b bVar = this.logger;
            v6.c cVar = this.mPlayType;
            String str = this.mVideoName;
            long j10 = this.mSession.get();
            x1.f1.lb.widget.videoview.j jVar = this.mPlayerInfo;
            bVar.debug("play_position saved. [" + cVar + "][" + str + "] session[" + j10 + "] player[" + i1(jVar != null ? jVar.getMediaPlayer() : null) + " position[" + position + "] lastSavedPosition[" + this.lastSavedPosition + "]", new Object[0]);
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new n(position, null), 3, null);
        this.lastSavedPosition = position;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j1(x1.f1.lb.widget.videoview.d surfaceHolder) {
        if (surfaceHolder == null) {
            return Configurator.NULL;
        }
        Integer numH1 = h1(surfaceHolder.c());
        Integer numH2 = h1(surfaceHolder.a());
        kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
        String str = String.format(Locale.ENGLISH, "surfaceHolder@%d[surface=%s, renderView=%s]", Arrays.copyOf(new Object[]{Integer.valueOf(surfaceHolder.hashCode()), numH1 != null ? numH1.toString() : null, numH2 != null ? numH2.toString() : null}, 3));
        kotlin.jvm.internal.m.e(str, "format(...)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2(x1.f1.lb.widget.videoview.j playerInfo, int what, long delayMillis) {
        if (playerInfo != null) {
            int playerId = playerInfo.getPlayerId();
            Handler handler = this.mHandler;
            Handler handler2 = null;
            if (handler == null) {
                kotlin.jvm.internal.m.v("mHandler");
                handler = null;
            }
            Message messageObtainMessage = handler.obtainMessage(what, Integer.valueOf(playerId));
            kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
            Handler handler3 = this.mHandler;
            if (handler3 == null) {
                kotlin.jvm.internal.m.v("mHandler");
            } else {
                handler2 = handler3;
            }
            handler2.sendMessageDelayed(messageObtainMessage, delayMillis);
        }
    }

    private final void l2() {
        if (this.mMediaBufferingBeginTime > 0) {
            long jC = d1.c();
            long j10 = this.lastSentBufferingRestartEventTime;
            if (j10 <= 0) {
                this.lastSentBufferingRestartEventTime = jC;
                return;
            }
            if (jC - j10 < this.mGatewayTimeoutMillis) {
                return;
            }
            long jC0 = C0();
            if (jC0 < this.mGatewayTimeoutMillis) {
                return;
            }
            this.sendRestartCnt++;
            nf.q qVar = new nf.q(this.mSession.get(), 1, this.sendRestartCnt, "buffering");
            this.logger.warn("player buffering [ {} ms ], [" + this.mPlayType + "][" + this.mVideoName + "] send player restart event@" + qVar.hashCode() + " cnt[{}]", Long.valueOf(jC0), Integer.valueOf(this.sendRestartCnt));
            this.lastSentBufferingRestartEventTime = jC;
            xe.c.c().o(qVar);
            Handler handler = this.mHandler;
            Runnable runnable = null;
            if (handler == null) {
                kotlin.jvm.internal.m.v("mHandler");
                handler = null;
            }
            Runnable runnable2 = this.mOnMediaBufferPlayHandler;
            if (runnable2 == null) {
                kotlin.jvm.internal.m.v("mOnMediaBufferPlayHandler");
                runnable2 = null;
            }
            handler.removeCallbacks(runnable2);
            Handler handler2 = this.mHandler;
            if (handler2 == null) {
                kotlin.jvm.internal.m.v("mHandler");
                handler2 = null;
            }
            Runnable runnable3 = this.mOnMediaBufferPlayHandler;
            if (runnable3 == null) {
                kotlin.jvm.internal.m.v("mOnMediaBufferPlayHandler");
            } else {
                runnable = runnable3;
            }
            handler2.postDelayed(runnable, this.mGatewayTimeoutMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(z0 z0Var, int i10, x1.f1.lb.widget.videoview.c cVar) {
        z0Var.mAspectRatioType = i10;
        cVar.setAspectRatio(i10);
    }

    private final void o2(int decodeMode) {
        x1.f1.lb.util.w0.f21452a.r("decode_key_cache", decodeMode);
        x1.f1.lb.widget.videoview.k.f21604a.n(decodeMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(z0 z0Var, IMediaPlayer iMediaPlayer, int i10) {
        z0Var.mBufferPercent = i10;
    }

    private final void r1(final x1.f1.lb.widget.videoview.j playerInfo) {
        this.mOnVideoSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: x1.f1.lb.widget.videoview.x0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i10, int i11, int i12, int i13) {
                z0.s1(this.f21666a, playerInfo, iMediaPlayer, i10, i11, i12, i13);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(z0 z0Var, x1.f1.lb.widget.videoview.j jVar, IMediaPlayer iMediaPlayer, final int i10, final int i11, int i12, int i13) {
        synchronized (z0Var) {
            try {
                x1.f1.lb.widget.videoview.j jVar2 = z0Var.mPlayerInfo;
                if (jVar2 == null || jVar2.getPlayerId() != jVar.getPlayerId()) {
                    z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] player_changed, ignored video size changed", new Object[0]);
                    return;
                }
                if (i10 != 0 && i11 != 0) {
                    g0 videoInfo = jVar.getVideoInfo();
                    if (videoInfo == null) {
                        videoInfo = new g0(i10, i11, i12, i13);
                        jVar.k(videoInfo);
                    } else if (jVar.getDecodeMode() != 3 && (videoInfo.getWidth() != i10 || videoInfo.getHeight() != i11 || videoInfo.getSarDen() != i13 || videoInfo.getSarNum() != i12)) {
                        videoInfo = new g0(i10, i11, i12, i13);
                        jVar.k(videoInfo);
                    }
                    final int sarNum = videoInfo.getSarNum();
                    final int sarDen = videoInfo.getSarDen();
                    z0Var.mVideoRate = (((double) sarNum) / ((double) sarDen)) * (((double) i10) / ((double) i11));
                    final Integer numD0 = z0Var.D0(z0Var.mAspectRatioType);
                    final x1.f1.lb.widget.videoview.c cVar = z0Var.mRenderView;
                    if (cVar != null) {
                        Handler handler = z0Var.mHandler;
                        if (handler == null) {
                            kotlin.jvm.internal.m.v("mHandler");
                            handler = null;
                        }
                        handler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.o0
                            @Override // java.lang.Runnable
                            public final void run() {
                                z0.t1(cVar, i10, i11, sarNum, sarDen, numD0);
                            }
                        });
                    }
                    z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] on_video_size_change renderView[" + z0Var.h1(z0Var.mRenderView) + "] " + i10 + " x " + i11 + " " + i12 + "->" + sarNum + " " + i13 + "->" + sarDen + " " + z0Var.mAspectRatioType + " -> " + numD0, new Object[0]);
                }
                r8.z zVar = r8.z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void u1(final x1.f1.lb.widget.videoview.j playerInfo) {
        this.mOnCompletionListenerWrapper = new IMediaPlayer.OnCompletionListener() { // from class: x1.f1.lb.widget.videoview.y0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                z0.v1(this.f21669a, playerInfo, iMediaPlayer);
            }
        };
        this.mOnErrorListenerWrapper = new IMediaPlayer.OnErrorListener() { // from class: x1.f1.lb.widget.videoview.i0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public final boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
                return z0.w1(this.f21590a, playerInfo, iMediaPlayer, i10, i11);
            }
        };
        final ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        this.mOnSeekCompleteListenerWrapper = new IMediaPlayer.OnSeekCompleteListener() { // from class: x1.f1.lb.widget.videoview.j0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(IMediaPlayer iMediaPlayer) {
                z0.x1(this.f21601a, playerInfo, arrayList, iMediaPlayer);
            }
        };
        this.mOnPreparedListenerWrapper = new IMediaPlayer.OnPreparedListener() { // from class: x1.f1.lb.widget.videoview.k0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                z0.y1(this.f21614a, playerInfo, iMediaPlayer);
            }
        };
        this.mOnInfoListenerWrapper = new IMediaPlayer.OnInfoListener() { // from class: x1.f1.lb.widget.videoview.l0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
                return z0.z1(this.f21617a, playerInfo, iMediaPlayer, i10, i11, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00b8  */
    public static final void v1(z0 z0Var, x1.f1.lb.widget.videoview.j jVar, IMediaPlayer iMediaPlayer) {
        boolean z10;
        synchronized (z0Var) {
            try {
                x1.f1.lb.widget.videoview.j jVar2 = z0Var.mPlayerInfo;
                if (jVar2 == null || jVar.getPlayerId() != jVar2.getPlayerId()) {
                    z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] player_changed, ignored play complete", new Object[0]);
                    return;
                }
                if (x1.f1.lb.config.b.f20643a.t()) {
                    q6.b bVar = z0Var.logger;
                    Integer numValueOf = Integer.valueOf(z0Var.hashCode());
                    String simpleName = z0.class.getSimpleName();
                    Context context = z0Var.mContext;
                    Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                    Context context2 = z0Var.mContext;
                    bVar.debug("media_player_on@{}:{}@{}:{} complete session[{}] playType[{}] {} {} position[{}] duration[{}]", numValueOf, simpleName, numValueOf2, context2 != null ? context2.getClass().getSimpleName() : null, Long.valueOf(z0Var.mSession.get()), z0Var.mPlayType, z0Var.j1(z0Var.mSurfaceHolder), z0Var.i1(iMediaPlayer), Long.valueOf(z0Var.latestPlayPosition), Long.valueOf(z0Var.mVideoDuration));
                }
                v6.c cVar = z0Var.mPlayType;
                if (cVar == v6.c.VOD || cVar == v6.c.CATCHUP) {
                    long j10 = z0Var.latestPlayPosition;
                    if (j10 <= 0 || z0Var.mVideoDuration - j10 >= 100000) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                } else {
                    z10 = false;
                }
                z0Var.mIsCompleted = z10;
                if (z10) {
                    z0Var.preparedTime = 0L;
                    z0Var.mIsCompleted = true;
                    z0Var.latestPlayPosition = 0L;
                    z0Var.i2(0L);
                    x1.f1.lb.streaming.a.f20960a.r(z0Var.mSession.get());
                    IMediaPlayer.OnCompletionListener onCompletionListener = z0Var.mOnCompletionListener;
                    if (onCompletionListener != null) {
                        onCompletionListener.onCompletion(iMediaPlayer);
                    }
                } else {
                    z0Var.G0(jVar, "complete");
                }
                r8.z zVar = r8.z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w1(z0 z0Var, x1.f1.lb.widget.videoview.j jVar, IMediaPlayer iMediaPlayer, int i10, int i11) {
        if (z0Var.mIsForceStop) {
            return true;
        }
        synchronized (z0Var) {
            try {
                x1.f1.lb.widget.videoview.j jVar2 = z0Var.mPlayerInfo;
                if (jVar2 == null || jVar.getPlayerId() != jVar2.getPlayerId()) {
                    z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] player_changed, ignored play on error", new Object[0]);
                    return true;
                }
                String str = "Unknown";
                if (i10 == -10000) {
                    str = "Url not available or not supported format";
                } else if (i10 == -1010) {
                    str = "Unsupported";
                } else if (i10 == -1007) {
                    str = "Malformed";
                } else if (i10 == -1004) {
                    str = "IO error";
                } else if (i10 == -110) {
                    str = "Data timeout";
                } else if (i10 == 100) {
                    str = "Server died";
                } else if (i10 == 200) {
                    str = "Not valid for progressive playback";
                }
                q6.b bVar = z0Var.logger;
                String str2 = "[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] media_player_on@{}:{}@{}:{} error,  {} {} what[{}]->[{}], extra[{}]";
                Integer numValueOf = Integer.valueOf(z0Var.hashCode());
                String simpleName = z0.class.getSimpleName();
                Context context = z0Var.mContext;
                Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                Context context2 = z0Var.mContext;
                bVar.error(str2, numValueOf, simpleName, numValueOf2, context2 != null ? context2.getClass().getSimpleName() : null, z0Var.j1(z0Var.mSurfaceHolder), z0Var.i1(iMediaPlayer), Integer.valueOf(i10), str, Integer.valueOf(i11));
                x1.f1.lb.widget.videoview.j jVar3 = z0Var.mPlayerInfo;
                if (jVar3 != null && jVar3.getDecodeMode() == 3 && z0Var.mIsSoftDecoder == 0) {
                    z0Var.W1(z0Var.mPlayUri, 2);
                    return true;
                }
                IMediaPlayer.OnErrorListener onErrorListener = z0Var.mOnErrorListener;
                return onErrorListener != null ? onErrorListener.onError(iMediaPlayer, i10, i11) : true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(z0 z0Var, x1.f1.lb.widget.videoview.j jVar, IMediaPlayer iMediaPlayer) {
        kotlin.jvm.internal.m.f(iMediaPlayer, "iMediaPlayer");
        synchronized (z0Var) {
            try {
                x1.f1.lb.widget.videoview.j jVar2 = z0Var.mPlayerInfo;
                if (jVar2 == null || jVar.getPlayerId() != jVar2.getPlayerId()) {
                    z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] player_changed, ignored play on prepared", new Object[0]);
                    return;
                }
                z0Var.mVideoWidth = iMediaPlayer.getVideoWidth();
                z0Var.mVideoHeight = iMediaPlayer.getVideoHeight();
                z0Var.mCanSeekForward = true;
                z0Var.mCanSeekBackward = true;
                z0Var.mTrackInfo = iMediaPlayer.getTrackInfo();
                z0Var.preparedTime = d1.c();
                Handler handler = z0Var.mHandler;
                if (handler == null) {
                    kotlin.jvm.internal.m.v("mHandler");
                    handler = null;
                }
                Runnable runnable = z0Var.mGatewayTimeoutHandler;
                if (runnable == null) {
                    kotlin.jvm.internal.m.v("mGatewayTimeoutHandler");
                    runnable = null;
                }
                handler.removeCallbacks(runnable);
                x1.f1.lb.widget.videoview.j jVar3 = z0Var.mPlayerInfo;
                if (jVar3 != null && jVar3.getAndroidx.core.app.NotificationCompat.CATEGORY_STATUS java.lang.String() == 1) {
                    z0Var.b2(jVar, IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START);
                    z0Var.b2(jVar, 10003);
                    jVar3.j(2);
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        q6.b bVar = z0Var.logger;
                        String str = "[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] media_player_on@{}:{}@{}:{} prepared, {} {}";
                        Integer numValueOf = Integer.valueOf(z0Var.hashCode());
                        String simpleName = z0.class.getSimpleName();
                        Context context = z0Var.mContext;
                        Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                        Context context2 = z0Var.mContext;
                        bVar.debug(str, numValueOf, simpleName, numValueOf2, context2 != null ? context2.getClass().getSimpleName() : null, z0Var.j1(z0Var.mSurfaceHolder), z0Var.i1(iMediaPlayer));
                        z0Var.logger.debug("zapping_time_opt on_prepared player[{}]", Integer.valueOf(iMediaPlayer.hashCode()));
                    }
                }
                z0Var.B0(jVar, z0Var.mSurfaceHolder, "prepared");
                IMediaPlayer.OnPreparedListener onPreparedListener = z0Var.mOnPreparedListener;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(iMediaPlayer);
                }
                r8.z zVar = r8.z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z1(z0 z0Var, x1.f1.lb.widget.videoview.j jVar, IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
        boolean z10;
        String str2;
        Integer numValueOf;
        synchronized (z0Var) {
            try {
                x1.f1.lb.widget.videoview.j jVar2 = z0Var.mPlayerInfo;
                if (jVar2 == null || jVar.getPlayerId() != jVar2.getPlayerId()) {
                    z0Var.logger.a("player_changed, ignored play on info", new Object[0]);
                    return true;
                }
                if (x1.f1.lb.config.b.f20643a.t()) {
                    q6.b bVar = z0Var.logger;
                    Integer numValueOf2 = Integer.valueOf(z0Var.hashCode());
                    String simpleName = z0.class.getSimpleName();
                    Context context = z0Var.mContext;
                    Integer numValueOf3 = Integer.valueOf(context != null ? context.hashCode() : 0);
                    Context context2 = z0Var.mContext;
                    z10 = true;
                    bVar.debug("media_player_on@{}:{}@{}:{} info, session[{}] {} {} what[{}] extra[{}] info[{}]", numValueOf2, simpleName, numValueOf3, context2 != null ? context2.getClass().getSimpleName() : null, Long.valueOf(z0Var.mSession.get()), z0Var.j1(z0Var.mSurfaceHolder), z0Var.i1(iMediaPlayer), Integer.valueOf(i10), Integer.valueOf(i11), str);
                } else {
                    z10 = true;
                }
                IMediaPlayer.OnInfoListener onInfoListener = z0Var.mOnInfoListener;
                if (onInfoListener != null) {
                    onInfoListener.onInfo(iMediaPlayer, i10, i11, "");
                }
                if (i10 != 3) {
                    if (i10 == 701) {
                        v6.c cVar = z0Var.mPlayType;
                        if (cVar == v6.c.CATCHUP) {
                            z0Var.logger.a("[" + cVar + "][" + z0Var.mVideoName + "][" + z0Var.mSession.get() + "] MEDIA_INFO_BUFFERING_START", new Object[0]);
                        } else {
                            x1.f1.lb.metric.monitor.f fVar = x1.f1.lb.metric.monitor.f.f20907a;
                            tf.c cVarH = fVar.h();
                            Integer numValueOf4 = cVarH != null ? Integer.valueOf(cVarH.G()) : null;
                            tf.c cVarH2 = fVar.h();
                            long jE = (cVarH2 != null ? cVarH2.e() : 0L) / ((long) 1000);
                            tf.c cVarH3 = fVar.h();
                            Integer numValueOf5 = cVarH3 != null ? Integer.valueOf(cVarH3.k()) : null;
                            tf.c cVarH4 = fVar.h();
                            Integer numValueOf6 = cVarH4 != null ? Integer.valueOf(cVarH4.w()) : null;
                            tf.c cVarH5 = fVar.h();
                            numValueOf = cVarH5 != null ? Integer.valueOf(cVarH5.v()) : null;
                            z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "][" + z0Var.mSession.get() + "] MEDIA_INFO_BUFFERING_START kbps[" + jE + "] rtt[" + numValueOf4 + "] lost_rate[" + numValueOf5 + "] resend_rate[" + numValueOf6 + "] resent_time[" + numValueOf + "]", new Object[0]);
                        }
                        z0Var.Q1(jVar);
                        z0Var.T1(jVar);
                        return z10;
                    }
                    if (i10 != 702) {
                        return z10;
                    }
                }
                if (z0Var.mMediaBufferingBeginTime > 0) {
                    long jC = d1.c() - z0Var.mMediaBufferingBeginTime;
                    if (jC < 1000) {
                        str2 = jC + " ms";
                    } else {
                        long j10 = jC / ((long) 1000);
                        if (j10 < 60) {
                            str2 = j10 + " s";
                        } else {
                            long j11 = 60;
                            str2 = (j10 / j11) + " m " + (j10 % j11) + " s";
                        }
                    }
                    v6.c cVar2 = z0Var.mPlayType;
                    if (cVar2 == v6.c.CATCHUP) {
                        z0Var.logger.a("[" + cVar2 + "][" + z0Var.mVideoName + "][" + z0Var.mSession.get() + "] MEDIA_INFO_BUFFERING_END (" + str2 + ")", new Object[0]);
                    } else {
                        x1.f1.lb.metric.monitor.f fVar2 = x1.f1.lb.metric.monitor.f.f20907a;
                        tf.c cVarH6 = fVar2.h();
                        Integer numValueOf7 = cVarH6 != null ? Integer.valueOf(cVarH6.G()) : null;
                        tf.c cVarH7 = fVar2.h();
                        long jE2 = (cVarH7 != null ? cVarH7.e() : 0L) / ((long) 1000);
                        tf.c cVarH8 = fVar2.h();
                        Integer numValueOf8 = cVarH8 != null ? Integer.valueOf(cVarH8.k()) : null;
                        tf.c cVarH9 = fVar2.h();
                        Integer numValueOf9 = cVarH9 != null ? Integer.valueOf(cVarH9.w()) : null;
                        tf.c cVarH10 = fVar2.h();
                        numValueOf = cVarH10 != null ? Integer.valueOf(cVarH10.v()) : null;
                        z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + "][" + z0Var.mSession.get() + "] MEDIA_INFO_BUFFERING_END (" + str2 + ") kbps[" + jE2 + "] rtt[" + numValueOf7 + "] lost_rate[" + numValueOf8 + "] resend_rate[" + numValueOf9 + "] resent_time[" + numValueOf + "]", new Object[0]);
                    }
                }
                z0Var.P1(jVar);
                z0Var.H0(jVar);
                return z10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void A2(c9.a<r8.z> listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.playCompleteListener = listener;
    }

    public final void B2(long j10) {
        this.renderTime = j10;
    }

    protected final void D1(x1.f1.lb.widget.videoview.c renderView) {
        kotlin.jvm.internal.m.f(renderView, "renderView");
        this.mRenderView = renderView;
    }

    public final void E2(String url) {
        F2("no_name", url, null, v6.c.VOD, d1.c());
    }

    public final void G2(boolean b10) {
        x1.f1.lb.widget.videoview.c cVar = this.mRenderView;
        if (cVar != null) {
            cVar.setZOrderOnTop(b10);
        }
    }

    /* JADX INFO: renamed from: H1, reason: from getter */
    public final boolean getMIsPaused() {
        return this.mIsPaused;
    }

    public final void I0(int resId, String videoName, Integer errorCode) {
        String string;
        Context context = this.mContext;
        if (context == null || (string = context.getString(resId)) == null) {
            return;
        }
        J0(string, videoName, errorCode);
    }

    public final void J0(String tip, String videoName, Integer errorCode) {
        kotlin.jvm.internal.m.f(tip, "tip");
        x1.f1.lb.widget.videoview.e eVar = this.mVideoView;
        if (eVar != null) {
            if (videoName == null) {
                videoName = this.mVideoName;
            }
            eVar.d(tip, videoName, errorCode);
        }
    }

    public final void K2(final String msg) {
        kotlin.jvm.internal.m.f(msg, "msg");
        if (this.mIsCompleted || this.mIsForceStop) {
            return;
        }
        if (kotlin.jvm.internal.m.a(this.lastTipMsg, msg) && this.isLoading) {
            return;
        }
        this.lastTipMsg = msg;
        this.isLoading = true;
        Handler handler = this.mHandler;
        if (handler == null) {
            kotlin.jvm.internal.m.v("mHandler");
            handler = null;
        }
        handler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.v0
            @Override // java.lang.Runnable
            public final void run() {
                z0.M2(msg, this);
            }
        });
    }

    /* JADX INFO: renamed from: M0, reason: from getter */
    public final int getMAspectRatioType() {
        return this.mAspectRatioType;
    }

    public final Integer N1() {
        x1.f1.lb.widget.videoview.e eVar = this.mVideoView;
        if (eVar != null) {
            return Integer.valueOf(eVar.m());
        }
        return null;
    }

    public final long N2(boolean isTerminate) {
        long j10;
        char c10;
        synchronized (this) {
            try {
                T2();
                x1.f1.lb.widget.videoview.j jVar = this.mPlayerInfo;
                if (jVar != null) {
                    F0(jVar);
                }
                c9.p<? super Boolean, ? super String, r8.z> pVar = this.loadingListener;
                if (pVar != null) {
                    pVar.invoke(Boolean.FALSE, "");
                }
                x1.f1.lb.widget.videoview.e eVar = this.mVideoView;
                if (eVar != null) {
                    eVar.e();
                }
                j10 = this.mSession.get();
                try {
                    IMediaPlayer iMediaPlayerZ0 = Z0(this, null, 1, null);
                    x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                    if (bVar.t()) {
                        q6.b bVar2 = this.logger;
                        Integer numValueOf = Integer.valueOf(hashCode());
                        String simpleName = z0.class.getSimpleName();
                        Context context = this.mContext;
                        Integer numValueOf2 = Integer.valueOf(context != null ? context.hashCode() : 0);
                        Context context2 = this.mContext;
                        c10 = 1;
                        try {
                            try {
                                bVar2.debug("media_player_on@{}:{}@{}:{} stop player and engine. session[{}] {} {}", numValueOf, simpleName, numValueOf2, context2 != null ? context2.getClass().getSimpleName() : null, Long.valueOf(j10), j1(this.mSurfaceHolder), i1(iMediaPlayerZ0));
                            } catch (Exception e10) {
                                e = e10;
                                q6.b bVar3 = this.logger;
                                String str = "[" + this.mPlayType + "][" + this.mVideoName + "] session[" + j10 + "] stop player failure";
                                Object[] objArr = new Object[2];
                                objArr[0] = Long.valueOf(j10);
                                objArr[c10] = e;
                                bVar3.error(str, objArr);
                            }
                        } catch (Exception e11) {
                            e = e11;
                            q6.b bVar4 = this.logger;
                            String str2 = "[" + this.mPlayType + "][" + this.mVideoName + "] session[" + j10 + "] stop player failure";
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = Long.valueOf(j10);
                            objArr2[c10] = e;
                            bVar4.error(str2, objArr2);
                        }
                    } else {
                        c10 = 1;
                    }
                    if (isTerminate) {
                        O2(j10);
                        x1.f1.lb.streaming.a.f20960a.r(j10);
                    } else {
                        U1(ExifInterface.GPS_MEASUREMENT_3D);
                    }
                    v6.c cVar = this.mPlayType;
                    if (cVar == v6.c.VOD || cVar == v6.c.CATCHUP) {
                        long j11 = this.latestPlayPosition;
                        if (j11 > this.lastSavedPosition) {
                            i2(j11);
                        } else if (bVar.t()) {
                            q6.b bVar5 = this.logger;
                            AtomicLong atomicLong = this.mSession;
                            x1.f1.lb.widget.videoview.j jVar2 = this.mPlayerInfo;
                            bVar5.debug("play_position not save. session[" + atomicLong + "] player[" + i1(jVar2 != null ? jVar2.getMediaPlayer() : null) + " position[" + j11 + "] lastSavedPosition[" + this.lastSavedPosition + "]", new Object[0]);
                        }
                    }
                    c2();
                    this.mPlayUri = null;
                    this.preparedTime = 0L;
                    this.mPlayerInfo = null;
                    this.lastSession = j10;
                    this.mSession.set(0L);
                    this.logger.a("[" + this.mPlayType + "][" + this.mVideoName + "] session[" + j10 + "] player stop(" + isTerminate + ")", new Object[0]);
                } catch (Exception e12) {
                    e = e12;
                    c10 = 1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j10;
    }

    public final int O0() {
        return x1.f1.lb.widget.videoview.k.f21604a.f();
    }

    public final Integer O1() {
        x1.f1.lb.widget.videoview.e eVar = this.mVideoView;
        if (eVar != null) {
            return Integer.valueOf(eVar.h());
        }
        return null;
    }

    public final Integer Q0() {
        x1.f1.lb.widget.videoview.j jVar = this.mPlayerInfo;
        if (jVar != null) {
            return Integer.valueOf(jVar.getDecodeMode());
        }
        return null;
    }

    public final void Q2() {
        if (this.isLoading) {
            Handler handler = this.mHandler;
            if (handler == null) {
                kotlin.jvm.internal.m.v("mHandler");
                handler = null;
            }
            handler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.u0
                @Override // java.lang.Runnable
                public final void run() {
                    z0.R2(this.f21655a);
                }
            });
        }
    }

    /* JADX INFO: renamed from: R0, reason: from getter */
    public final int getDownloadThousand() {
        return this.downloadThousand;
    }

    /* JADX INFO: renamed from: U0, reason: from getter */
    public final Integer getMForceStopReason() {
        return this.mForceStopReason;
    }

    public final boolean U1(String from) {
        IMediaPlayer iMediaPlayerZ0;
        kotlin.jvm.internal.m.f(from, "from");
        x1.f1.lb.widget.videoview.j jVar = this.mPlayerInfo;
        if (jVar != null && (iMediaPlayerZ0 = Z0(this, null, 1, null)) != null && E0()) {
            try {
                iMediaPlayerZ0.pause();
                this.mIsPaused = true;
                jVar.j(4);
                T2();
                Q2();
                this.logger.a("[" + this.mPlayType + "][" + this.mVideoName + "] session[" + this.mSession.get() + "] player paused[" + from + "]", new Object[0]);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: V0, reason: from getter */
    public final boolean getMIsCompleted() {
        return this.mIsCompleted;
    }

    /* JADX INFO: renamed from: W0, reason: from getter */
    public final boolean getMIsForceStop() {
        return this.mIsForceStop;
    }

    /* JADX INFO: renamed from: X0, reason: from getter */
    public final AtomicLong getMSession() {
        return this.mSession;
    }

    public final void Z1(String seekKey, long position) {
        kotlin.jvm.internal.m.f(seekKey, "seekKey");
        x1.f1.lb.widget.videoview.g.f21577a.f(seekKey, position);
    }

    /* JADX INFO: renamed from: b1, reason: from getter */
    public final long getPreparedTime() {
        return this.preparedTime;
    }

    /* JADX INFO: renamed from: c1, reason: from getter */
    public final long getRenderTime() {
        return this.renderTime;
    }

    /* JADX INFO: renamed from: d1, reason: from getter */
    public final ITrackInfo[] getMTrackInfo() {
        return this.mTrackInfo;
    }

    /* JADX INFO: renamed from: e1, reason: from getter */
    public final int getMVideoHeight() {
        return this.mVideoHeight;
    }

    /* JADX INFO: renamed from: f1, reason: from getter */
    public final int getMVideoWidth() {
        return this.mVideoWidth;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0100  */
    /* JADX WARN: Code duplicated, block: B:31:0x015d  */
    /* JADX WARN: Code duplicated, block: B:41:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final boolean j2(long i10) {
        String str;
        String str2;
        long jMax;
        long j10;
        z0 z0Var = this;
        x1.f1.lb.widget.videoview.j jVar = z0Var.mPlayerInfo;
        IMediaPlayer mediaPlayer = jVar != null ? jVar.getMediaPlayer() : null;
        if (!z0Var.L1()) {
            z0Var.logger.warn(z0.class.getSimpleName() + ": [" + z0Var.mPlayType + "][" + z0Var.mVideoName + "] session[" + z0Var.mSession.get() + "] video view is not shown, ignored seek " + z0Var.i1(mediaPlayer) + " to [" + i10 + "]", new Object[0]);
            return false;
        }
        if (mediaPlayer == null) {
            return true;
        }
        try {
            z0Var.mIsPaused = false;
            long duration = mediaPlayer.getDuration();
            long j11 = duration - ((long) 2000);
            if (i10 < j11) {
                str2 = "] session[";
                str = "]";
                if (i10 / duration <= 0.98d) {
                    jMax = i10;
                }
                if (i10 != jMax) {
                    try {
                        String str3 = str2;
                        z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + str3 + z0Var.mSession.get() + "] play_position try seek_to[" + i10 + "] but real seek_to[" + jMax + "] duration[" + duration + str3 + z0Var.mSession + "] ", new Object[0]);
                        z0Var = this;
                    } catch (Throwable unused) {
                        return true;
                    }
                } else {
                    String str4 = str2;
                    z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + str4 + z0Var.mSession.get() + "] play_position seek_to[" + i10 + "] duration[" + duration + str4 + z0Var.mSession + str, new Object[0]);
                }
                if (jMax == 0 && jMax == z0Var.mSeekPosition) {
                    j10 = jMax;
                } else {
                    j10 = jMax;
                    z0Var.latestPlayPosition = j10;
                    z0Var.i2(j10);
                }
                mediaPlayer.seekTo(j10);
                z0Var.mSeekPosition = j10;
                return true;
            }
            str = "]";
            str2 = "] session[";
            jMax = Math.max(0L, j11);
            if (i10 != jMax) {
                String str5 = str2;
                z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + str5 + z0Var.mSession.get() + "] play_position try seek_to[" + i10 + "] but real seek_to[" + jMax + "] duration[" + duration + str5 + z0Var.mSession + "] ", new Object[0]);
                z0Var = this;
            } else {
                String str6 = str2;
                z0Var.logger.a("[" + z0Var.mPlayType + "][" + z0Var.mVideoName + str6 + z0Var.mSession.get() + "] play_position seek_to[" + i10 + "] duration[" + duration + str6 + z0Var.mSession + str, new Object[0]);
            }
            if (jMax == 0) {
                j10 = jMax;
                z0Var.latestPlayPosition = j10;
                z0Var.i2(j10);
            } else {
                j10 = jMax;
                z0Var.latestPlayPosition = j10;
                z0Var.i2(j10);
            }
            mediaPlayer.seekTo(j10);
            z0Var.mSeekPosition = j10;
            return true;
        } catch (Throwable unused2) {
            return true;
        }
    }

    public final void k1() {
        c9.p<? super Boolean, ? super String, r8.z> pVar = this.loadingListener;
        if (pVar != null) {
            pVar.invoke(Boolean.FALSE, "");
        }
        x1.f1.lb.widget.videoview.e eVar = this.mVideoView;
        if (eVar != null) {
            eVar.f();
        }
    }

    public final void l1() {
        c9.p<? super Integer, ? super String, r8.z> pVar = this.noSignalListener;
        if (pVar != null) {
            if (pVar != null) {
                pVar.invoke(-1, "");
            }
        } else {
            x1.f1.lb.widget.videoview.e eVar = this.mVideoView;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public final void m1(Context context, x1.f1.lb.widget.videoview.e videoView, x1.f1.lb.widget.videoview.c renderView) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(videoView, "videoView");
        kotlin.jvm.internal.m.f(renderView, "renderView");
        this.mVideoRate = 0.0d;
        this.mHardwareDecodeFlag = 1L;
        this.mPlayerInfo = null;
        this.mOnInfoListener = null;
        this.mOnCompletionListener = null;
        this.mOnPreparedListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnErrorListener = null;
        this.mBufferPercent = -1;
        this.mSeekPosition = -1L;
        this.mPlayUri = null;
        this.mExecutorService = x1.f1.lb.util.n.f21413l;
        this.mVideoDuration = 0L;
        this.mRenderView = null;
        this.mSurfaceHolder = null;
        this.mIsSoftDecoder = 1;
        this.mLastDecodeMode = -1;
        this.mMediaBufferingBeginTime = 0L;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mAspectRatioType = 0;
        this.mContext = context;
        this.mVideoView = videoView;
        this.mOnMediaBufferPlayHandler = new Runnable() { // from class: x1.f1.lb.widget.videoview.h0
            @Override // java.lang.Runnable
            public final void run() {
                z0.n1(this.f21587a);
            }
        };
        this.mOnMediaBufferAnimationHandler = new Runnable() { // from class: x1.f1.lb.widget.videoview.q0
            @Override // java.lang.Runnable
            public final void run() {
                z0.o1(this.f21641a);
            }
        };
        this.mOnBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() { // from class: x1.f1.lb.widget.videoview.r0
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i10) {
                z0.p1(this.f21644a, iMediaPlayer, i10);
            }
        };
        q1();
        A1();
        E1();
        B1();
        D1(renderView);
    }

    public final void m2(final int aspectRatioType) {
        final x1.f1.lb.widget.videoview.c cVar = this.mRenderView;
        if (cVar != null) {
            x1.f1.lb.media.d.f20812a.y(this.mPlayType, aspectRatioType);
            Handler handler = this.mHandler;
            if (handler == null) {
                kotlin.jvm.internal.m.v("mHandler");
                handler = null;
            }
            handler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.s0
                @Override // java.lang.Runnable
                public final void run() {
                    z0.n2(this.f21646a, aspectRatioType, cVar);
                }
            });
        }
    }

    public final void q2(c9.p<? super Boolean, ? super String, r8.z> listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.loadingListener = listener;
    }

    public final void r2(Integer num) {
        this.mForceStopReason = num;
    }

    public final void s2(boolean z10) {
        this.mIsForceStop = z10;
    }

    public final void t2(c9.p<? super Integer, ? super String, r8.z> listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.noSignalListener = listener;
    }

    public final void u2(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public final void v2(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public final void w2(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public final void x2(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public final void y2(Runnable listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.mOnRenderCompleteListener = listener;
    }

    public final void z2(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public z0() {
        x1.f1.lb.metric.monitor.g gVar = x1.f1.lb.metric.monitor.g.f20917a;
        this.playerMonitor = gVar;
        this.streamingMonitor = gVar;
        this.mGatewayTimeoutMillis = 30000L;
        this.mPlayerNotPlayingRestartIntervalMillis = 6000L;
        this.startPlayInitTime = new AtomicLong(0L);
        this.mVideoName = "";
        this.mSession = new AtomicLong(0L);
        this.mPlayType = v6.c.LIVE;
    }

    private final void C2(x1.f1.lb.widget.videoview.c renderView) {
        View view = renderView.getView();
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        x1.f1.lb.widget.videoview.e eVar = this.mVideoView;
        if (eVar != null) {
            kotlin.jvm.internal.m.c(view);
            eVar.j(view);
        }
        if (view instanceof SurfaceView) {
            ((SurfaceView) view).setZOrderMediaOverlay(true);
        }
        renderView.d(this.mRenderCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(z0 z0Var) {
        x1.f1.lb.widget.videoview.j jVar;
        if (z0Var.L1() && (jVar = z0Var.mPlayerInfo) != null) {
            jVar.a(z0Var.new j());
        }
    }

    private final void G0(x1.f1.lb.widget.videoview.j playerInfo, String from) {
        if (!L1()) {
            return;
        }
        b2(playerInfo, IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START);
        new nf.q(this.mSession.get(), -1, 1, from);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M2(String str, z0 z0Var) {
        Context context;
        if (str.length() == 0 && ((context = z0Var.mContext) == null || (str = context.getString(R$string.loading)) == null)) {
            str = "";
        }
        c9.p<? super Boolean, ? super String, r8.z> pVar = z0Var.loadingListener;
        if (pVar != null) {
            pVar.invoke(Boolean.TRUE, str);
            return;
        }
        x1.f1.lb.widget.videoview.e eVar = z0Var.mVideoView;
        if (eVar != null && eVar.k(str)) {
            c cVar = z0Var.mPlayerMeter;
            if (cVar == null) {
                kotlin.jvm.internal.m.v("mPlayerMeter");
                cVar = null;
            }
            cVar.l();
        }
    }

    private final void O2(long session) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new q(session, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(x1.f1.lb.widget.videoview.j playerInfo) {
        F0(playerInfo);
        this.mMediaBufferingBeginTime = d1.c();
        this.sendRestartCnt = 0;
        xe.c.c().o(new nf.p());
    }

    private final void W1(String playUri, Integer decodeMode) {
        long jC = d1.c();
        this.mPlayerInfo = null;
        this.preparedTime = 0L;
        this.mIsCompleted = false;
        this.mSeekPosition = this.lastSavedPosition;
        V1(P0(playUri, decodeMode), new m(playUri, this, this, jC), playUri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(b bVar, x1.f1.lb.widget.videoview.j jVar) {
        bVar.a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(z0 z0Var) {
        z0Var.l2();
    }

    private final void q1() {
        this.mHandler = new f(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(x1.f1.lb.widget.videoview.c cVar, int i10, int i11, int i12, int i13, Integer num) {
        cVar.a(i10, i11);
        cVar.b(i12, i13);
        if (num != null) {
            cVar.setAspectRatio(num.intValue());
        }
    }

    public final boolean G1() {
        if (I1() && this.mMediaBufferingBeginTime > 0) {
            return true;
        }
        return false;
    }

    public boolean K1() {
        if (I1() && this.isPlayPositionKeepMoving) {
            return true;
        }
        return false;
    }

    public final void p2(int decodeMode, boolean restartPlayer) {
        o2(decodeMode);
        if (decodeMode == 1) {
            this.mIsSoftDecoder = 0;
        }
        if (restartPlayer) {
            W1(this.mPlayUri, Integer.valueOf(decodeMode));
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(nf.l event) {
        kotlin.jvm.internal.m.f(event, "event");
        synchronized (this) {
            x1.f1.lb.widget.videoview.j jVar = this.mPlayerInfo;
            if (jVar != null) {
                P2(this, false, 1, null);
                Q2();
                g1(jVar, 300);
                this.logger.error("[" + this.mPlayType + "][" + this.mVideoName + "] session[" + this.mSession.get() + "] got no stream server event from um, stop player", new Object[0]);
                r8.z zVar = r8.z.f17874a;
            }
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(nf.t event) {
        kotlin.jvm.internal.m.f(event, "event");
        synchronized (this) {
            try {
                x1.f1.lb.widget.videoview.j jVar = this.mPlayerInfo;
                if (jVar != null) {
                    if (event.c() == jVar.getPlayerId() && event.a() == 300) {
                        P2(this, false, 1, null);
                        Q2();
                        g1(jVar, 300);
                        this.logger.error("[" + this.mPlayType + "][" + this.mVideoName + "] session[" + this.mSession.get() + "] got no stream server event from [" + event.a() + ":" + event.b() + "], stop player", new Object[0]);
                    }
                    r8.z zVar = r8.z.f17874a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
