package x1.f1.lb.media;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.u;
import r8.z;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x1.f1.lb.media.model.SubscribeItem;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.v0;
import x1.f1.lb.util.w0;
import z1.b1.lb.m.meta.ChannelListResponse;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001c2\u0006\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\u0017H\u0002¢\u0006\u0004\b#\u0010$J'\u0010)\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\"H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000bH\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010\u0003J0\u00101\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u0002000/0\u001c2\u0006\u0010\u0018\u001a\u00020\tH\u0082@¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u0010\u0003J\u0010\u00104\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b4\u0010\u0015J0\u00107\u001a\u00020\u000b2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001c2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001cH\u0082@¢\u0006\u0004\b7\u00108J+\u0010>\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00172\n\u0010<\u001a\u00060:j\u0002`;2\u0006\u0010=\u001a\u00020\u0017H\u0002¢\u0006\u0004\b>\u0010?J-\u0010D\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t¢\u0006\u0004\bD\u0010EJ\r\u0010F\u001a\u00020\u000b¢\u0006\u0004\bF\u0010\u0003J\r\u0010G\u001a\u00020\u000b¢\u0006\u0004\bG\u0010\u0003J\r\u0010H\u001a\u00020\u0007¢\u0006\u0004\bH\u0010IJ!\u0010K\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010J\u001a\u00020\u0007¢\u0006\u0004\bK\u0010LJ)\u0010N\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020'2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010J\u001a\u00020\u0007¢\u0006\u0004\bN\u0010OJ\u0015\u0010P\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\bP\u0010QJ\u001b\u0010R\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c¢\u0006\u0004\bR\u0010SJ\u001b\u0010T\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c¢\u0006\u0004\bT\u0010SJ\u0015\u0010U\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\bU\u0010VJ\u0015\u0010W\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\bW\u0010VJ\u0018\u0010Y\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020'H\u0086@¢\u0006\u0004\bY\u0010ZJ%\u0010[\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\t¢\u0006\u0004\b[\u0010\\J8\u0010_\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\t2\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b_\u0010`J4\u0010c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\t2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010aH\u0086@¢\u0006\u0004\bc\u0010dJ(\u0010e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u0002000/0\u001cH\u0086@¢\u0006\u0004\be\u0010\u0015J\r\u0010f\u001a\u00020\t¢\u0006\u0004\bf\u0010gJ\r\u0010h\u001a\u00020\t¢\u0006\u0004\bh\u0010gJ\u001f\u0010j\u001a\b\u0012\u0004\u0012\u00020\t0\u001c2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\t¢\u0006\u0004\bl\u0010mJ'\u0010n\u001a\b\u0012\u0004\u0012\u00020\"0\u001c2\u0006\u0010 \u001a\u00020\t2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bn\u0010oJ\u0013\u0010p\u001a\b\u0012\u0004\u0012\u00020\"0\u001c¢\u0006\u0004\bp\u0010qJ!\u0010s\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\t2\b\u0010r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bs\u0010tJ\u0013\u0010u\u001a\b\u0012\u0004\u0012\u00020\"0\u001c¢\u0006\u0004\bu\u0010qJ\u0017\u0010v\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\bv\u0010wJ\u0017\u0010x\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\bx\u0010wJ\u0015\u0010y\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\"¢\u0006\u0004\by\u0010zJ\r\u0010{\u001a\u00020\u0007¢\u0006\u0004\b{\u0010IR\u001f\u0010\u0080\u0001\u001a\n }*\u0004\u0018\u00010|0|8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010[R9\u0010\u008a\u0001\u001a\"\u0012\u0004\u0012\u00020\u0017\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001c0\u0087\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R@\u0010\u008c\u0001\u001a)\u0012\u0004\u0012\u00020\u0017\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\t\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0087\u00010\u0087\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0089\u0001R,\u0010\u008e\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001c0\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u0089\u0001R3\u0010\u0090\u0001\u001a\u001c\u0012\u0004\u0012\u00020\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\"0\u0087\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0089\u0001R3\u0010\u0092\u0001\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00170\u0087\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0089\u0001R@\u0010\u0095\u0001\u001a)\u0012\u0004\u0012\u00020\u0017\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\t0\u0093\u00010\u0087\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0089\u0001R3\u0010\u0097\u0001\u001a\u001c\u0012\u0004\u0012\u00020\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0087\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0089\u0001R,\u0010\u0099\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001c0\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0089\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0017\u0010@\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bP\u0010\u009b\u0001R%\u0010A\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b_\u0010\u009b\u0001\u001a\u0005\b\u009d\u0001\u0010g\"\u0005\b\u009e\u0001\u0010\u0013R%\u0010B\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\by\u0010\u009b\u0001\u001a\u0005\b\u009f\u0001\u0010g\"\u0005\b \u0001\u0010\u0013R\u0017\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bY\u0010\u009b\u0001R\u0018\u0010¡\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b>\u0010\u009b\u0001R\u0018\u0010¢\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b1\u0010\u009b\u0001R\u001a\u0010¤\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bv\u0010£\u0001R\u0017\u0010¥\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010UR\u0018\u0010¦\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bs\u0010\u009b\u0001R\u0017\u0010©\u0001\u001a\u00030§\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bn\u0010¨\u0001RF\u0010\u00ad\u0001\u001a0\u0012\u0004\u0012\u00020\t\u0012%\u0012#\u0012\u0004\u0012\u00020'\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\t0¬\u00010\u0093\u00010«\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bj\u0010\u0089\u0001R\u0017\u0010®\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010UR\u0017\u0010¯\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010UR2\u0010°\u0001\u001a\u001c\u0012\u0004\u0012\u00020\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'0\u0093\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\be\u0010\u0089\u0001R2\u0010±\u0001\u001a\u001c\u0012\u0004\u0012\u00020\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'0\u0093\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b#\u0010\u0089\u0001R\u001a\u0010µ\u0001\u001a\u00030²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u0017\u0010¶\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010\u001eR\u0017\u0010·\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010\u001e¨\u0006¸\u0001"}, d2 = {"Lx1/f1/lb/media/a;", "", "<init>", "()V", "Ln6/b;", "Lz1/b1/lb/m/meta/ChannelListResponse;", "response", "", "isRetryAfterFailure", "", "oldToken", "Lr8/z;", "U", "(Ln6/b;ZLjava/lang/String;Lv8/f;)Ljava/lang/Object;", "errMessage", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;ZLjava/lang/String;Lv8/f;)Ljava/lang/Object;", NotificationCompat.CATEGORY_MESSAGE, "M", "(Ljava/lang/String;)V", "R", "(Lv8/f;)Ljava/lang/Object;", IjkMediaMeta.IJKM_KEY_TYPE, "", "key", "opType", "b0", "(Ljava/lang/String;II)V", "", "keys", "Z", "(Ljava/lang/String;Ljava/util/List;)V", "columnKey", "mode", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "B", "(Ljava/lang/String;I)Ljava/util/List;", "epgId", "streamId", "", "startTime", "f0", "(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;", "L", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)I", "X", "c0", "Lr8/u;", "Lz1/b1/lb/m/meta/EPGProgramme;", "s", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", ExifInterface.LATITUDE_SOUTH, ExifInterface.LONGITUDE_WEST, IjkMediaMeta.IJKM_KEY_STREAMS, "categorySorts", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/util/List;Ljava/util/List;Lv8/f;)Ljava/lang/Object;", "idx", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "stringBuffer", "numCnt", "r", "(ILjava/lang/StringBuilder;I)Ljava/lang/String;", "columnAll", "columnPlayHistory", "columnFavorites", "columnCatchup", "F", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "e0", "d0", "H", "()Z", "isForce", "O", "(ZZ)V", "now", "N", "(JZZ)V", "n", "(I)V", "a0", "(Ljava/util/List;)V", "Y", "J", "(I)Z", "h0", "noticeInAdvanceMs", "q", "(JLv8/f;)Ljava/lang/Object;", "I", "(IJLjava/lang/String;)Z", "sportId", "isAvailable", "o", "(IJLjava/lang/String;Ljava/lang/String;ZLv8/f;)Ljava/lang/Object;", "Lx1/f1/lb/media/model/SubscribeItem;", "subscribeItem", "g0", "(IJLjava/lang/String;Lx1/f1/lb/media/model/SubscribeItem;Lv8/f;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "()Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "isIncludeAdult", "x", "(Ljava/lang/Boolean;)Ljava/util/List;", "G", "(Ljava/lang/String;)Z", "w", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/util/List;", "z", "()Ljava/util/List;", "routeId", "v", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "D", "t", "(I)Lz1/b1/lb/m/meta/ChannelStreamResponse;", "u", "p", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)Ljava/lang/String;", "K", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Lkotlinx/coroutines/l0;", "c", "Lkotlinx/coroutines/l0;", "puckScope", "d", "playMode", "", "e", "Ljava/util/Map;", "channelsByColumns", "f", "channelPositionsByColumns", "g", "channels", "h", "channelsMap", "i", "streamsMap", "Lr8/p;", "j", "channelNum", "k", "numChannel", "l", "columnNames", "m", "Ljava/lang/String;", "checksumInChannelList", "getColumnPlayHistory", "setColumnPlayHistory", "getColumnFavorites", "setColumnFavorites", "columnSubscribes", "lastColumnKey", "Ljava/lang/Long;", "nextUpdateTime", "botFailureTime", "checksumInUpdateNotice", "Lcom/google/gson/e;", "Lcom/google/gson/e;", "gson", "", "Ljava/util/concurrent/ConcurrentSkipListMap;", "", "inSubscribedMap", "lastInSubscribedChangeTime", "lastInSubscribedSaveTime", "favoritesMap", "playHistoryMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "C", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInLoading", "isInitComplete", "isAdultExists", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private static Map<Integer, r8.p<String, Long>> favoritesMap;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private static Map<Integer, r8.p<String, Long>> playHistoryMap;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private static AtomicBoolean isInLoading;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private static boolean isInitComplete;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private static boolean isAdultExists;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int playMode;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private static Long nextUpdateTime;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private static long botFailureTime;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private static long lastInSubscribedChangeTime;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private static long lastInSubscribedSaveTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20755a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static q6.b logger = q6.c.d(a.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final l0 puckScope = m0.a(a2.b(null, 1, null).plus(a1.b()));

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static Map<Integer, ? extends Map<String, ? extends List<? extends ChannelStreamResponse>>> channelsByColumns = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static Map<Integer, ? extends Map<String, ? extends Map<Integer, Integer>>> channelPositionsByColumns = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static Map<Integer, ? extends List<? extends ChannelStreamResponse>> channels = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static Map<Integer, ? extends Map<Integer, ? extends ChannelStreamResponse>> channelsMap = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static Map<String, ? extends Map<String, Integer>> streamsMap = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static Map<Integer, ? extends Map<Integer, r8.p<Integer, String>>> channelNum = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static Map<Integer, ? extends Map<Integer, Integer>> numChannel = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static Map<Integer, ? extends List<String>> columnNames = new HashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static String checksumInChannelList = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static String columnAll = "ALL";

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static String columnPlayHistory = "PLAY HISTORY";

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static String columnFavorites = "FAVORITES";

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static String columnCatchup = "REPLAY";

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static String columnSubscribes = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private static String lastColumnKey = "ALL";

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private static String checksumInUpdateNotice = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private static final com.google.gson.e gson = new com.google.gson.e();

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private static Map<String, ConcurrentSkipListMap<Long, r8.p<Boolean, Set<String>>>> inSubscribedMap = new HashMap();

    /* JADX INFO: renamed from: x1.f1.lb.media.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager", f = "ChannelManager.kt", l = {710, 713}, m = "changeChannelRemindFlag")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class C0420a extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C0420a(v8.f<? super C0420a> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.o(0, 0L, null, null, false, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager", f = "ChannelManager.kt", l = {597, 617, 634}, m = "executeSubscribe")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class b extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        b(v8.f<? super b> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.q(0L, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager", f = "ChannelManager.kt", l = {1209, 1223}, m = "generateSubscribeList")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class c extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        c(v8.f<? super c> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.s(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return t8.a.a((Long) ((u) t10).e(), (Long) ((u) t11).e());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager", f = "ChannelManager.kt", l = {IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE}, m = "getInSubscribedProgrammes")
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
            return a.this.A(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class f<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f20781a;

        public f(Map map) {
            this.f20781a = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return t8.a.a((Long) this.f20781a.get(((ChannelStreamResponse) t10).getStreamId()), (Long) this.f20781a.get(((ChannelStreamResponse) t11).getStreamId()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class g<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f20782a;

        public g(Map map) {
            this.f20782a = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return t8.a.a((Long) this.f20782a.get(((ChannelStreamResponse) t10).getStreamId()), (Long) this.f20782a.get(((ChannelStreamResponse) t11).getStreamId()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager$loadChannelList$1", f = "ChannelManager.kt", l = {238, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 253, 258, 268, 271, 274, 276, 279, 282}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class h extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ boolean $isRetryAfterFailure;
        final /* synthetic */ String $token;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.media.a$h$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager$loadChannelList$1$1", f = "ChannelManager.kt", l = {251}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ln6/b;", "Lz1/b1/lb/m/meta/ChannelListResponse;", "Lr8/z;", "<anonymous>", "(Ln6/b;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0421a extends kotlin.coroutines.jvm.internal.l implements c9.p<n6.b<ChannelListResponse>, v8.f<? super z>, Object> {
            final /* synthetic */ boolean $isRetryAfterFailure;
            final /* synthetic */ String $token;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0421a(boolean z10, String str, v8.f<? super C0421a> fVar) {
                super(2, fVar);
                this.$isRetryAfterFailure = z10;
                this.$token = str;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                C0421a c0421a = new C0421a(this.$isRetryAfterFailure, this.$token, fVar);
                c0421a.L$0 = obj;
                return c0421a;
            }

            @Override // c9.p
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(n6.b<ChannelListResponse> bVar, v8.f<? super z> fVar) {
                return ((C0421a) create(bVar, fVar)).invokeSuspend(z.f17874a);
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
                    n6.b bVar = (n6.b) this.L$0;
                    a aVar = a.f20755a;
                    boolean z10 = this.$isRetryAfterFailure;
                    String str = this.$token;
                    this.label = 1;
                    if (aVar.U(bVar, z10, str, this) == objC) {
                        return objC;
                    }
                }
                return z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager$loadChannelList$1$3$1", f = "ChannelManager.kt", l = {269}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ln6/b;", "Lz1/b1/lb/m/meta/ChannelListResponse;", "Lr8/z;", "<anonymous>", "(Ln6/b;)V"}, k = 3, mv = {2, 1, 0})
        static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<n6.b<ChannelListResponse>, v8.f<? super z>, Object> {
            final /* synthetic */ boolean $isRetryAfterFailure;
            final /* synthetic */ String $token;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(boolean z10, String str, v8.f<? super b> fVar) {
                super(2, fVar);
                this.$isRetryAfterFailure = z10;
                this.$token = str;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                b bVar = new b(this.$isRetryAfterFailure, this.$token, fVar);
                bVar.L$0 = obj;
                return bVar;
            }

            @Override // c9.p
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(n6.b<ChannelListResponse> bVar, v8.f<? super z> fVar) {
                return ((b) create(bVar, fVar)).invokeSuspend(z.f17874a);
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
                    n6.b bVar = (n6.b) this.L$0;
                    a aVar = a.f20755a;
                    boolean z10 = this.$isRetryAfterFailure;
                    String str = this.$token;
                    this.label = 1;
                    if (aVar.U(bVar, z10, str, this) == objC) {
                        return objC;
                    }
                }
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(boolean z10, String str, v8.f<? super h> fVar) {
            super(2, fVar);
            this.$isRetryAfterFailure = z10;
            this.$token = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new h(this.$isRetryAfterFailure, this.$token, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((h) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0064 A[PHI: r0 r2 r3 r12 r14
          0x0064: PHI (r0v25 java.lang.Object) = (r0v22 java.lang.Object), (r0v33 java.lang.Object) binds: [B:40:0x01a9, B:11:0x0053] A[DONT_GENERATE, DONT_INLINE]
          0x0064: PHI (r2v14 java.lang.String) = (r2v11 java.lang.String), (r2v18 java.lang.String) binds: [B:40:0x01a9, B:11:0x0053] A[DONT_GENERATE, DONT_INLINE]
          0x0064: PHI (r3v18 com.skydoves.sandwich.a) = (r3v15 com.skydoves.sandwich.a), (r3v21 com.skydoves.sandwich.a) binds: [B:40:0x01a9, B:11:0x0053] A[DONT_GENERATE, DONT_INLINE]
          0x0064: PHI (r12v7 x1.f1.lb.media.a$h) = (r12v5 x1.f1.lb.media.a$h), (r12v8 x1.f1.lb.media.a$h) binds: [B:40:0x01a9, B:11:0x0053] A[DONT_GENERATE, DONT_INLINE]
          0x0064: PHI (r14v5 boolean) = (r14v3 boolean), (r14v6 boolean) binds: [B:40:0x01a9, B:11:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:26:0x0104 A[PHI: r0
          0x0104: PHI (r0v9 java.lang.Object) = (r0v7 java.lang.Object), (r0v11 java.lang.Object) binds: [B:24:0x0101, B:15:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:28:0x010e  */
        /* JADX WARN: Code duplicated, block: B:33:0x012d  */
        /* JADX WARN: Code duplicated, block: B:35:0x0138  */
        /* JADX WARN: Code duplicated, block: B:38:0x0191  */
        /* JADX WARN: Code duplicated, block: B:44:0x01b4  */
        /* JADX WARN: Code duplicated, block: B:50:0x01d7  */
        /* JADX WARN: Code duplicated, block: B:53:0x01f8 A[PHI: r0 r2 r3 r4 r12
          0x01f8: PHI (r0v36 boolean) = (r0v34 boolean), (r0v34 boolean), (r0v38 boolean) binds: [B:49:0x01d5, B:51:0x01f4, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]
          0x01f8: PHI (r2v22 com.skydoves.sandwich.a) = (r2v19 com.skydoves.sandwich.a), (r2v19 com.skydoves.sandwich.a), (r2v25 com.skydoves.sandwich.a) binds: [B:49:0x01d5, B:51:0x01f4, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]
          0x01f8: PHI (r3v25 java.lang.String) = (r3v22 java.lang.String), (r3v22 java.lang.String), (r3v27 java.lang.String) binds: [B:49:0x01d5, B:51:0x01f4, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]
          0x01f8: PHI (r4v14 com.skydoves.sandwich.a) = (r4v11 com.skydoves.sandwich.a), (r4v11 com.skydoves.sandwich.a), (r4v20 com.skydoves.sandwich.a) binds: [B:49:0x01d5, B:51:0x01f4, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]
          0x01f8: PHI (r12v11 x1.f1.lb.media.a$h) = (r12v9 x1.f1.lb.media.a$h), (r12v9 x1.f1.lb.media.a$h), (r12v12 x1.f1.lb.media.a$h) binds: [B:49:0x01d5, B:51:0x01f4, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:55:0x01fe  */
        /* JADX WARN: Code duplicated, block: B:58:0x021b  */
        /* JADX WARN: Code duplicated, block: B:61:0x0237  */
        /* JADX WARN: Code duplicated, block: B:62:0x0239  */
        /* JADX WARN: Code duplicated, block: B:66:0x0243  */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x01ce, code lost:
        
            if (r1.T(r0, r14, r3, r12) == r15) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x025d, code lost:
        
            if (r4.T(r3, r1, r2, r12) == r15) goto L68;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objC;
            Object objG;
            com.skydoves.sandwich.a aVar;
            boolean z10;
            String str;
            a aVar2;
            String strC;
            boolean z11;
            String str2;
            com.skydoves.sandwich.a.b.C0151a c0151a;
            com.skydoves.sandwich.a aVar3;
            h hVar;
            a aVar4;
            String strA;
            com.skydoves.sandwich.a aVar5;
            boolean z12;
            Object objD;
            com.skydoves.sandwich.a aVar6;
            String str3;
            Object objG2;
            com.skydoves.sandwich.a aVar7;
            String str4;
            com.skydoves.sandwich.a aVar8;
            boolean z13;
            a aVar9;
            String strA2;
            boolean z14;
            a aVar10;
            String strB;
            Object objC2 = kotlin.coroutines.intrinsics.b.c();
            switch (this.label) {
                case 0:
                    r8.r.b(obj);
                    tf.e eVarE = x1.f1.lb.metric.monitor.h.f20952a.e();
                    if (eVarE != null) {
                        eVarE.x(d1.c());
                    }
                    x1.f1.lb.api.b bVar = x1.f1.lb.api.b.f20552a;
                    of.a aVar11 = of.a.f16585a;
                    String strValueOf = String.valueOf(aVar11.h());
                    String strValueOf2 = String.valueOf(aVar11.a());
                    long jI = aVar11.i();
                    String str5 = a.checksumInChannelList;
                    String strK = aVar11.k();
                    String strL = aVar11.l();
                    long jD = d1.d();
                    String strG = aVar11.g();
                    String strB2 = aVar11.b();
                    this.label = 1;
                    objC = bVar.c(strValueOf, strValueOf2, jI, str5, strK, strL, 1, 2000, jD, strG, strB2, this);
                    if (objC != objC2) {
                        C0421a c0421a = new C0421a(this.$isRetryAfterFailure, this.$token, null);
                        this.label = 2;
                        objG = com.skydoves.sandwich.c.g((com.skydoves.sandwich.a) objC, c0421a, this);
                        if (objG != objC2) {
                            aVar = (com.skydoves.sandwich.a) objG;
                            z10 = this.$isRetryAfterFailure;
                            str = this.$token;
                            if (aVar instanceof com.skydoves.sandwich.a.b) {
                                aVar2 = a.f20755a;
                                strC = v0.f21450a.c((com.skydoves.sandwich.a.b) aVar);
                                this.L$0 = aVar;
                                this.label = 3;
                                if (aVar2.T(strC, z10, str, this) == objC2) {
                                }
                                return objC2;
                            }
                            z11 = this.$isRetryAfterFailure;
                            str2 = this.$token;
                            if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                                hVar = this;
                                boolean z15 = hVar.$isRetryAfterFailure;
                                String str6 = hVar.$token;
                                if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                    a aVar12 = a.f20755a;
                                    String strB3 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                    hVar.L$0 = aVar;
                                    hVar.L$1 = null;
                                    hVar.L$2 = null;
                                    hVar.label = 10;
                                    break;
                                }
                                return z.f17874a;
                            }
                            c0151a = (com.skydoves.sandwich.a.b.C0151a) aVar;
                            if (c0151a.getStatusCode() == com.skydoves.sandwich.e.NotFound) {
                                a.logger.warn("load channel: new api not found try old api", new Object[0]);
                                x1.f1.lb.api.b bVar2 = x1.f1.lb.api.b.f20552a;
                                x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
                                String strJ0 = fVar.j0();
                                String strB0 = fVar.B0();
                                String strF0 = fVar.f0();
                                long jS = x1.f1.lb.util.k.f21398a.s();
                                long jD2 = d1.d();
                                String strA0 = fVar.A0();
                                String str7 = a.checksumInChannelList;
                                this.L$0 = aVar;
                                this.L$1 = str2;
                                this.Z$0 = z11;
                                this.label = 4;
                                aVar5 = aVar;
                                z12 = z11;
                                hVar = this;
                                objD = bVar2.d(strJ0, strB0, strF0, jS, jD2, strA0, str7, 1, 2000, hVar);
                                if (objD != objC2) {
                                    aVar6 = aVar5;
                                    str3 = str2;
                                    b bVar3 = new b(z12, str3, null);
                                    hVar.L$0 = aVar6;
                                    hVar.L$1 = str3;
                                    hVar.Z$0 = z12;
                                    hVar.label = 5;
                                    objG2 = com.skydoves.sandwich.c.g((com.skydoves.sandwich.a) objD, bVar3, hVar);
                                    if (objG2 != objC2) {
                                        aVar7 = aVar6;
                                        str4 = str3;
                                        aVar8 = (com.skydoves.sandwich.a) objG2;
                                        if (aVar8 instanceof com.skydoves.sandwich.a.b) {
                                            a aVar13 = a.f20755a;
                                            String strC2 = v0.f21450a.c((com.skydoves.sandwich.a.b) aVar8);
                                            hVar.L$0 = aVar7;
                                            hVar.L$1 = str4;
                                            hVar.L$2 = aVar8;
                                            hVar.Z$0 = z12;
                                            hVar.label = 6;
                                        }
                                        z13 = z12;
                                        if (!(aVar8 instanceof com.skydoves.sandwich.a.b.C0151a)) {
                                            z14 = z13;
                                            aVar = aVar7;
                                            if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                                                aVar10 = a.f20755a;
                                                strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                                                hVar.L$0 = aVar;
                                                hVar.L$1 = aVar8;
                                                hVar.L$2 = null;
                                                hVar.label = 8;
                                                if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                                                }
                                            }
                                            boolean z16 = hVar.$isRetryAfterFailure;
                                            String str8 = hVar.$token;
                                            if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                                a aVar14 = a.f20755a;
                                                String strB4 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                                hVar.L$0 = aVar;
                                                hVar.L$1 = null;
                                                hVar.L$2 = null;
                                                hVar.label = 10;
                                                break;
                                            }
                                            return z.f17874a;
                                        }
                                        com.skydoves.sandwich.a.b.C0151a c0151a2 = (com.skydoves.sandwich.a.b.C0151a) aVar8;
                                        v0 v0Var = v0.f21450a;
                                        v0Var.a(c0151a2);
                                        aVar9 = a.f20755a;
                                        strA2 = v0Var.a(c0151a2);
                                        hVar.L$0 = aVar7;
                                        hVar.L$1 = str4;
                                        hVar.L$2 = aVar8;
                                        hVar.Z$0 = z13;
                                        hVar.label = 7;
                                        if (aVar9.T(strA2, z13, str4, hVar) != objC2) {
                                            z14 = z13;
                                            aVar = aVar7;
                                            if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                                                aVar10 = a.f20755a;
                                                strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                                                hVar.L$0 = aVar;
                                                hVar.L$1 = aVar8;
                                                hVar.L$2 = null;
                                                hVar.label = 8;
                                                if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                                                }
                                            }
                                            boolean z17 = hVar.$isRetryAfterFailure;
                                            String str9 = hVar.$token;
                                            if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                                a aVar15 = a.f20755a;
                                                String strB5 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                                hVar.L$0 = aVar;
                                                hVar.L$1 = null;
                                                hVar.L$2 = null;
                                                hVar.label = 10;
                                                break;
                                            }
                                            return z.f17874a;
                                        }
                                    }
                                }
                            } else {
                                aVar3 = aVar;
                                hVar = this;
                                aVar4 = a.f20755a;
                                strA = v0.f21450a.a(c0151a);
                                hVar.L$0 = aVar3;
                                hVar.label = 9;
                                if (aVar4.T(strA, z11, str2, hVar) != objC2) {
                                    aVar = aVar3;
                                    boolean z18 = hVar.$isRetryAfterFailure;
                                    String str10 = hVar.$token;
                                    if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                        a aVar16 = a.f20755a;
                                        String strB6 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                        hVar.L$0 = aVar;
                                        hVar.L$1 = null;
                                        hVar.L$2 = null;
                                        hVar.label = 10;
                                        break;
                                    }
                                    return z.f17874a;
                                }
                            }
                            return objC2;
                        }
                    }
                    return objC2;
                case 1:
                    r8.r.b(obj);
                    objC = obj;
                    C0421a c0421a2 = new C0421a(this.$isRetryAfterFailure, this.$token, null);
                    this.label = 2;
                    objG = com.skydoves.sandwich.c.g((com.skydoves.sandwich.a) objC, c0421a2, this);
                    if (objG != objC2) {
                        aVar = (com.skydoves.sandwich.a) objG;
                        z10 = this.$isRetryAfterFailure;
                        str = this.$token;
                        if (aVar instanceof com.skydoves.sandwich.a.b) {
                            aVar2 = a.f20755a;
                            strC = v0.f21450a.c((com.skydoves.sandwich.a.b) aVar);
                            this.L$0 = aVar;
                            this.label = 3;
                            if (aVar2.T(strC, z10, str, this) == objC2) {
                            }
                            return objC2;
                        }
                        z11 = this.$isRetryAfterFailure;
                        str2 = this.$token;
                        if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                            hVar = this;
                            boolean z19 = hVar.$isRetryAfterFailure;
                            String str11 = hVar.$token;
                            if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                a aVar17 = a.f20755a;
                                String strB7 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                hVar.L$0 = aVar;
                                hVar.L$1 = null;
                                hVar.L$2 = null;
                                hVar.label = 10;
                                break;
                            }
                            return z.f17874a;
                        }
                        c0151a = (com.skydoves.sandwich.a.b.C0151a) aVar;
                        if (c0151a.getStatusCode() == com.skydoves.sandwich.e.NotFound) {
                            a.logger.warn("load channel: new api not found try old api", new Object[0]);
                            x1.f1.lb.api.b bVar4 = x1.f1.lb.api.b.f20552a;
                            x1.f1.lb.user.f fVar2 = x1.f1.lb.user.f.f21202a;
                            String strJ1 = fVar2.j0();
                            String strB1 = fVar2.B0();
                            String strF1 = fVar2.f0();
                            long jS2 = x1.f1.lb.util.k.f21398a.s();
                            long jD3 = d1.d();
                            String strA1 = fVar2.A0();
                            String str12 = a.checksumInChannelList;
                            this.L$0 = aVar;
                            this.L$1 = str2;
                            this.Z$0 = z11;
                            this.label = 4;
                            aVar5 = aVar;
                            z12 = z11;
                            hVar = this;
                            objD = bVar4.d(strJ1, strB1, strF1, jS2, jD3, strA1, str12, 1, 2000, hVar);
                            if (objD != objC2) {
                                aVar6 = aVar5;
                                str3 = str2;
                                b bVar5 = new b(z12, str3, null);
                                hVar.L$0 = aVar6;
                                hVar.L$1 = str3;
                                hVar.Z$0 = z12;
                                hVar.label = 5;
                                objG2 = com.skydoves.sandwich.c.g((com.skydoves.sandwich.a) objD, bVar5, hVar);
                                if (objG2 != objC2) {
                                    aVar7 = aVar6;
                                    str4 = str3;
                                    aVar8 = (com.skydoves.sandwich.a) objG2;
                                    if (aVar8 instanceof com.skydoves.sandwich.a.b) {
                                        a aVar18 = a.f20755a;
                                        String strC3 = v0.f21450a.c((com.skydoves.sandwich.a.b) aVar8);
                                        hVar.L$0 = aVar7;
                                        hVar.L$1 = str4;
                                        hVar.L$2 = aVar8;
                                        hVar.Z$0 = z12;
                                        hVar.label = 6;
                                    }
                                    z13 = z12;
                                    if (!(aVar8 instanceof com.skydoves.sandwich.a.b.C0151a)) {
                                        z14 = z13;
                                        aVar = aVar7;
                                        if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                                            aVar10 = a.f20755a;
                                            strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                                            hVar.L$0 = aVar;
                                            hVar.L$1 = aVar8;
                                            hVar.L$2 = null;
                                            hVar.label = 8;
                                            if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                                            }
                                        }
                                        boolean z110 = hVar.$isRetryAfterFailure;
                                        String str13 = hVar.$token;
                                        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                            a aVar19 = a.f20755a;
                                            String strB8 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                            hVar.L$0 = aVar;
                                            hVar.L$1 = null;
                                            hVar.L$2 = null;
                                            hVar.label = 10;
                                            break;
                                        }
                                        return z.f17874a;
                                    }
                                    com.skydoves.sandwich.a.b.C0151a c0151a3 = (com.skydoves.sandwich.a.b.C0151a) aVar8;
                                    v0 v0Var2 = v0.f21450a;
                                    v0Var2.a(c0151a3);
                                    aVar9 = a.f20755a;
                                    strA2 = v0Var2.a(c0151a3);
                                    hVar.L$0 = aVar7;
                                    hVar.L$1 = str4;
                                    hVar.L$2 = aVar8;
                                    hVar.Z$0 = z13;
                                    hVar.label = 7;
                                    if (aVar9.T(strA2, z13, str4, hVar) != objC2) {
                                        z14 = z13;
                                        aVar = aVar7;
                                        if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                                            aVar10 = a.f20755a;
                                            strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                                            hVar.L$0 = aVar;
                                            hVar.L$1 = aVar8;
                                            hVar.L$2 = null;
                                            hVar.label = 8;
                                            if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                                            }
                                        }
                                        boolean z111 = hVar.$isRetryAfterFailure;
                                        String str14 = hVar.$token;
                                        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                            a aVar110 = a.f20755a;
                                            String strB9 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                            hVar.L$0 = aVar;
                                            hVar.L$1 = null;
                                            hVar.L$2 = null;
                                            hVar.label = 10;
                                            break;
                                        }
                                        return z.f17874a;
                                    }
                                }
                            }
                        } else {
                            aVar3 = aVar;
                            hVar = this;
                            aVar4 = a.f20755a;
                            strA = v0.f21450a.a(c0151a);
                            hVar.L$0 = aVar3;
                            hVar.label = 9;
                            if (aVar4.T(strA, z11, str2, hVar) != objC2) {
                                aVar = aVar3;
                                boolean z112 = hVar.$isRetryAfterFailure;
                                String str15 = hVar.$token;
                                if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                    a aVar111 = a.f20755a;
                                    String strB10 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                    hVar.L$0 = aVar;
                                    hVar.L$1 = null;
                                    hVar.L$2 = null;
                                    hVar.label = 10;
                                    break;
                                }
                                return z.f17874a;
                            }
                        }
                        return objC2;
                    }
                    return objC2;
                case 2:
                    r8.r.b(obj);
                    objG = obj;
                    aVar = (com.skydoves.sandwich.a) objG;
                    z10 = this.$isRetryAfterFailure;
                    str = this.$token;
                    if (aVar instanceof com.skydoves.sandwich.a.b) {
                        aVar2 = a.f20755a;
                        strC = v0.f21450a.c((com.skydoves.sandwich.a.b) aVar);
                        this.L$0 = aVar;
                        this.label = 3;
                        if (aVar2.T(strC, z10, str, this) == objC2) {
                        }
                        return objC2;
                    }
                    z11 = this.$isRetryAfterFailure;
                    str2 = this.$token;
                    if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                        hVar = this;
                        boolean z113 = hVar.$isRetryAfterFailure;
                        String str16 = hVar.$token;
                        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                            a aVar112 = a.f20755a;
                            String strB11 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                            hVar.L$0 = aVar;
                            hVar.L$1 = null;
                            hVar.L$2 = null;
                            hVar.label = 10;
                            break;
                        }
                        return z.f17874a;
                    }
                    c0151a = (com.skydoves.sandwich.a.b.C0151a) aVar;
                    if (c0151a.getStatusCode() == com.skydoves.sandwich.e.NotFound) {
                        a.logger.warn("load channel: new api not found try old api", new Object[0]);
                        x1.f1.lb.api.b bVar6 = x1.f1.lb.api.b.f20552a;
                        x1.f1.lb.user.f fVar3 = x1.f1.lb.user.f.f21202a;
                        String strJ2 = fVar3.j0();
                        String strB12 = fVar3.B0();
                        String strF2 = fVar3.f0();
                        long jS3 = x1.f1.lb.util.k.f21398a.s();
                        long jD4 = d1.d();
                        String strA3 = fVar3.A0();
                        String str17 = a.checksumInChannelList;
                        this.L$0 = aVar;
                        this.L$1 = str2;
                        this.Z$0 = z11;
                        this.label = 4;
                        aVar5 = aVar;
                        z12 = z11;
                        hVar = this;
                        objD = bVar6.d(strJ2, strB12, strF2, jS3, jD4, strA3, str17, 1, 2000, hVar);
                        if (objD != objC2) {
                            aVar6 = aVar5;
                            str3 = str2;
                            b bVar7 = new b(z12, str3, null);
                            hVar.L$0 = aVar6;
                            hVar.L$1 = str3;
                            hVar.Z$0 = z12;
                            hVar.label = 5;
                            objG2 = com.skydoves.sandwich.c.g((com.skydoves.sandwich.a) objD, bVar7, hVar);
                            if (objG2 != objC2) {
                                aVar7 = aVar6;
                                str4 = str3;
                                aVar8 = (com.skydoves.sandwich.a) objG2;
                                if (aVar8 instanceof com.skydoves.sandwich.a.b) {
                                    a aVar113 = a.f20755a;
                                    String strC4 = v0.f21450a.c((com.skydoves.sandwich.a.b) aVar8);
                                    hVar.L$0 = aVar7;
                                    hVar.L$1 = str4;
                                    hVar.L$2 = aVar8;
                                    hVar.Z$0 = z12;
                                    hVar.label = 6;
                                }
                                z13 = z12;
                                if (!(aVar8 instanceof com.skydoves.sandwich.a.b.C0151a)) {
                                    z14 = z13;
                                    aVar = aVar7;
                                    if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                                        aVar10 = a.f20755a;
                                        strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                                        hVar.L$0 = aVar;
                                        hVar.L$1 = aVar8;
                                        hVar.L$2 = null;
                                        hVar.label = 8;
                                        if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                                        }
                                    }
                                    boolean z114 = hVar.$isRetryAfterFailure;
                                    String str18 = hVar.$token;
                                    if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                        a aVar114 = a.f20755a;
                                        String strB13 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                        hVar.L$0 = aVar;
                                        hVar.L$1 = null;
                                        hVar.L$2 = null;
                                        hVar.label = 10;
                                        break;
                                    }
                                    return z.f17874a;
                                }
                                com.skydoves.sandwich.a.b.C0151a c0151a4 = (com.skydoves.sandwich.a.b.C0151a) aVar8;
                                v0 v0Var3 = v0.f21450a;
                                v0Var3.a(c0151a4);
                                aVar9 = a.f20755a;
                                strA2 = v0Var3.a(c0151a4);
                                hVar.L$0 = aVar7;
                                hVar.L$1 = str4;
                                hVar.L$2 = aVar8;
                                hVar.Z$0 = z13;
                                hVar.label = 7;
                                if (aVar9.T(strA2, z13, str4, hVar) != objC2) {
                                    z14 = z13;
                                    aVar = aVar7;
                                    if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                                        aVar10 = a.f20755a;
                                        strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                                        hVar.L$0 = aVar;
                                        hVar.L$1 = aVar8;
                                        hVar.L$2 = null;
                                        hVar.label = 8;
                                        if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                                        }
                                    }
                                    boolean z115 = hVar.$isRetryAfterFailure;
                                    String str19 = hVar.$token;
                                    if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                        a aVar115 = a.f20755a;
                                        String strB14 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                        hVar.L$0 = aVar;
                                        hVar.L$1 = null;
                                        hVar.L$2 = null;
                                        hVar.label = 10;
                                        break;
                                    }
                                    return z.f17874a;
                                }
                            }
                        }
                    } else {
                        aVar3 = aVar;
                        hVar = this;
                        aVar4 = a.f20755a;
                        strA = v0.f21450a.a(c0151a);
                        hVar.L$0 = aVar3;
                        hVar.label = 9;
                        if (aVar4.T(strA, z11, str2, hVar) != objC2) {
                            aVar = aVar3;
                            boolean z116 = hVar.$isRetryAfterFailure;
                            String str110 = hVar.$token;
                            if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                a aVar116 = a.f20755a;
                                String strB15 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                hVar.L$0 = aVar;
                                hVar.L$1 = null;
                                hVar.L$2 = null;
                                hVar.label = 10;
                                break;
                            }
                            return z.f17874a;
                        }
                    }
                    return objC2;
                case 3:
                    aVar = (com.skydoves.sandwich.a) this.L$0;
                    r8.r.b(obj);
                    z11 = this.$isRetryAfterFailure;
                    str2 = this.$token;
                    if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                        hVar = this;
                        boolean z117 = hVar.$isRetryAfterFailure;
                        String str111 = hVar.$token;
                        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                            a aVar117 = a.f20755a;
                            String strB16 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                            hVar.L$0 = aVar;
                            hVar.L$1 = null;
                            hVar.L$2 = null;
                            hVar.label = 10;
                            break;
                        }
                        return z.f17874a;
                    }
                    c0151a = (com.skydoves.sandwich.a.b.C0151a) aVar;
                    if (c0151a.getStatusCode() == com.skydoves.sandwich.e.NotFound) {
                        a.logger.warn("load channel: new api not found try old api", new Object[0]);
                        x1.f1.lb.api.b bVar8 = x1.f1.lb.api.b.f20552a;
                        x1.f1.lb.user.f fVar4 = x1.f1.lb.user.f.f21202a;
                        String strJ3 = fVar4.j0();
                        String strB17 = fVar4.B0();
                        String strF3 = fVar4.f0();
                        long jS4 = x1.f1.lb.util.k.f21398a.s();
                        long jD5 = d1.d();
                        String strA4 = fVar4.A0();
                        String str112 = a.checksumInChannelList;
                        this.L$0 = aVar;
                        this.L$1 = str2;
                        this.Z$0 = z11;
                        this.label = 4;
                        aVar5 = aVar;
                        z12 = z11;
                        hVar = this;
                        objD = bVar8.d(strJ3, strB17, strF3, jS4, jD5, strA4, str112, 1, 2000, hVar);
                        if (objD != objC2) {
                            aVar6 = aVar5;
                            str3 = str2;
                            b bVar9 = new b(z12, str3, null);
                            hVar.L$0 = aVar6;
                            hVar.L$1 = str3;
                            hVar.Z$0 = z12;
                            hVar.label = 5;
                            objG2 = com.skydoves.sandwich.c.g((com.skydoves.sandwich.a) objD, bVar9, hVar);
                            if (objG2 != objC2) {
                                aVar7 = aVar6;
                                str4 = str3;
                                aVar8 = (com.skydoves.sandwich.a) objG2;
                                if (aVar8 instanceof com.skydoves.sandwich.a.b) {
                                    a aVar118 = a.f20755a;
                                    String strC5 = v0.f21450a.c((com.skydoves.sandwich.a.b) aVar8);
                                    hVar.L$0 = aVar7;
                                    hVar.L$1 = str4;
                                    hVar.L$2 = aVar8;
                                    hVar.Z$0 = z12;
                                    hVar.label = 6;
                                }
                                z13 = z12;
                                if (!(aVar8 instanceof com.skydoves.sandwich.a.b.C0151a)) {
                                    z14 = z13;
                                    aVar = aVar7;
                                    if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                                        aVar10 = a.f20755a;
                                        strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                                        hVar.L$0 = aVar;
                                        hVar.L$1 = aVar8;
                                        hVar.L$2 = null;
                                        hVar.label = 8;
                                        if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                                        }
                                    }
                                    boolean z118 = hVar.$isRetryAfterFailure;
                                    String str113 = hVar.$token;
                                    if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                        a aVar119 = a.f20755a;
                                        String strB18 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                        hVar.L$0 = aVar;
                                        hVar.L$1 = null;
                                        hVar.L$2 = null;
                                        hVar.label = 10;
                                        break;
                                    }
                                    return z.f17874a;
                                }
                                com.skydoves.sandwich.a.b.C0151a c0151a5 = (com.skydoves.sandwich.a.b.C0151a) aVar8;
                                v0 v0Var4 = v0.f21450a;
                                v0Var4.a(c0151a5);
                                aVar9 = a.f20755a;
                                strA2 = v0Var4.a(c0151a5);
                                hVar.L$0 = aVar7;
                                hVar.L$1 = str4;
                                hVar.L$2 = aVar8;
                                hVar.Z$0 = z13;
                                hVar.label = 7;
                                if (aVar9.T(strA2, z13, str4, hVar) != objC2) {
                                    z14 = z13;
                                    aVar = aVar7;
                                    if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                                        aVar10 = a.f20755a;
                                        strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                                        hVar.L$0 = aVar;
                                        hVar.L$1 = aVar8;
                                        hVar.L$2 = null;
                                        hVar.label = 8;
                                        if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                                        }
                                    }
                                    boolean z119 = hVar.$isRetryAfterFailure;
                                    String str114 = hVar.$token;
                                    if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                        a aVar1110 = a.f20755a;
                                        String strB19 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                        hVar.L$0 = aVar;
                                        hVar.L$1 = null;
                                        hVar.L$2 = null;
                                        hVar.label = 10;
                                        break;
                                    }
                                    return z.f17874a;
                                }
                            }
                        }
                    } else {
                        aVar3 = aVar;
                        hVar = this;
                        aVar4 = a.f20755a;
                        strA = v0.f21450a.a(c0151a);
                        hVar.L$0 = aVar3;
                        hVar.label = 9;
                        if (aVar4.T(strA, z11, str2, hVar) != objC2) {
                            aVar = aVar3;
                            boolean z1110 = hVar.$isRetryAfterFailure;
                            String str115 = hVar.$token;
                            if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                a aVar1111 = a.f20755a;
                                String strB110 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                hVar.L$0 = aVar;
                                hVar.L$1 = null;
                                hVar.L$2 = null;
                                hVar.label = 10;
                                break;
                            }
                            return z.f17874a;
                        }
                    }
                    return objC2;
                case 4:
                    boolean z20 = this.Z$0;
                    str3 = (String) this.L$1;
                    aVar6 = (com.skydoves.sandwich.a) this.L$0;
                    r8.r.b(obj);
                    hVar = this;
                    z12 = z20;
                    objD = obj;
                    b bVar10 = new b(z12, str3, null);
                    hVar.L$0 = aVar6;
                    hVar.L$1 = str3;
                    hVar.Z$0 = z12;
                    hVar.label = 5;
                    objG2 = com.skydoves.sandwich.c.g((com.skydoves.sandwich.a) objD, bVar10, hVar);
                    if (objG2 != objC2) {
                        aVar7 = aVar6;
                        str4 = str3;
                        aVar8 = (com.skydoves.sandwich.a) objG2;
                        if (aVar8 instanceof com.skydoves.sandwich.a.b) {
                            a aVar1112 = a.f20755a;
                            String strC6 = v0.f21450a.c((com.skydoves.sandwich.a.b) aVar8);
                            hVar.L$0 = aVar7;
                            hVar.L$1 = str4;
                            hVar.L$2 = aVar8;
                            hVar.Z$0 = z12;
                            hVar.label = 6;
                        }
                        z13 = z12;
                        if (!(aVar8 instanceof com.skydoves.sandwich.a.b.C0151a)) {
                            z14 = z13;
                            aVar = aVar7;
                            if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                                aVar10 = a.f20755a;
                                strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                                hVar.L$0 = aVar;
                                hVar.L$1 = aVar8;
                                hVar.L$2 = null;
                                hVar.label = 8;
                                if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                                }
                            }
                            boolean z1111 = hVar.$isRetryAfterFailure;
                            String str116 = hVar.$token;
                            if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                a aVar1113 = a.f20755a;
                                String strB111 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                hVar.L$0 = aVar;
                                hVar.L$1 = null;
                                hVar.L$2 = null;
                                hVar.label = 10;
                                break;
                            }
                            return z.f17874a;
                        }
                        com.skydoves.sandwich.a.b.C0151a c0151a6 = (com.skydoves.sandwich.a.b.C0151a) aVar8;
                        v0 v0Var5 = v0.f21450a;
                        v0Var5.a(c0151a6);
                        aVar9 = a.f20755a;
                        strA2 = v0Var5.a(c0151a6);
                        hVar.L$0 = aVar7;
                        hVar.L$1 = str4;
                        hVar.L$2 = aVar8;
                        hVar.Z$0 = z13;
                        hVar.label = 7;
                        if (aVar9.T(strA2, z13, str4, hVar) != objC2) {
                            z14 = z13;
                            aVar = aVar7;
                            if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                                aVar10 = a.f20755a;
                                strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                                hVar.L$0 = aVar;
                                hVar.L$1 = aVar8;
                                hVar.L$2 = null;
                                hVar.label = 8;
                                if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                                }
                            }
                            boolean z1112 = hVar.$isRetryAfterFailure;
                            String str117 = hVar.$token;
                            if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                                a aVar1114 = a.f20755a;
                                String strB112 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                                hVar.L$0 = aVar;
                                hVar.L$1 = null;
                                hVar.L$2 = null;
                                hVar.label = 10;
                                break;
                            }
                            return z.f17874a;
                        }
                        break;
                    }
                    return objC2;
                case 5:
                    boolean z21 = this.Z$0;
                    str3 = (String) this.L$1;
                    aVar6 = (com.skydoves.sandwich.a) this.L$0;
                    r8.r.b(obj);
                    hVar = this;
                    z12 = z21;
                    objG2 = obj;
                    aVar7 = aVar6;
                    str4 = str3;
                    aVar8 = (com.skydoves.sandwich.a) objG2;
                    if (aVar8 instanceof com.skydoves.sandwich.a.b) {
                        a aVar1115 = a.f20755a;
                        String strC7 = v0.f21450a.c((com.skydoves.sandwich.a.b) aVar8);
                        hVar.L$0 = aVar7;
                        hVar.L$1 = str4;
                        hVar.L$2 = aVar8;
                        hVar.Z$0 = z12;
                        hVar.label = 6;
                        break;
                    }
                    z13 = z12;
                    if (!(aVar8 instanceof com.skydoves.sandwich.a.b.C0151a)) {
                        z14 = z13;
                        aVar = aVar7;
                        if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                            aVar10 = a.f20755a;
                            strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                            hVar.L$0 = aVar;
                            hVar.L$1 = aVar8;
                            hVar.L$2 = null;
                            hVar.label = 8;
                            if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                            }
                        }
                        boolean z1113 = hVar.$isRetryAfterFailure;
                        String str118 = hVar.$token;
                        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                            a aVar1116 = a.f20755a;
                            String strB113 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                            hVar.L$0 = aVar;
                            hVar.L$1 = null;
                            hVar.L$2 = null;
                            hVar.label = 10;
                            break;
                        }
                        return z.f17874a;
                    }
                    com.skydoves.sandwich.a.b.C0151a c0151a7 = (com.skydoves.sandwich.a.b.C0151a) aVar8;
                    v0 v0Var6 = v0.f21450a;
                    v0Var6.a(c0151a7);
                    aVar9 = a.f20755a;
                    strA2 = v0Var6.a(c0151a7);
                    hVar.L$0 = aVar7;
                    hVar.L$1 = str4;
                    hVar.L$2 = aVar8;
                    hVar.Z$0 = z13;
                    hVar.label = 7;
                    if (aVar9.T(strA2, z13, str4, hVar) != objC2) {
                        z14 = z13;
                        aVar = aVar7;
                        if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                            aVar10 = a.f20755a;
                            strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                            hVar.L$0 = aVar;
                            hVar.L$1 = aVar8;
                            hVar.L$2 = null;
                            hVar.label = 8;
                            if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                            }
                        }
                        boolean z1114 = hVar.$isRetryAfterFailure;
                        String str119 = hVar.$token;
                        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                            a aVar1117 = a.f20755a;
                            String strB114 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                            hVar.L$0 = aVar;
                            hVar.L$1 = null;
                            hVar.L$2 = null;
                            hVar.label = 10;
                            break;
                        }
                        return z.f17874a;
                    }
                    return objC2;
                case 6:
                    z13 = this.Z$0;
                    aVar8 = (com.skydoves.sandwich.a) this.L$2;
                    str4 = (String) this.L$1;
                    aVar7 = (com.skydoves.sandwich.a) this.L$0;
                    r8.r.b(obj);
                    hVar = this;
                    if (!(aVar8 instanceof com.skydoves.sandwich.a.b.C0151a)) {
                        z14 = z13;
                        aVar = aVar7;
                        if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                            aVar10 = a.f20755a;
                            strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                            hVar.L$0 = aVar;
                            hVar.L$1 = aVar8;
                            hVar.L$2 = null;
                            hVar.label = 8;
                            if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                            }
                        }
                        boolean z1115 = hVar.$isRetryAfterFailure;
                        String str1110 = hVar.$token;
                        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                            a aVar1118 = a.f20755a;
                            String strB115 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                            hVar.L$0 = aVar;
                            hVar.L$1 = null;
                            hVar.L$2 = null;
                            hVar.label = 10;
                            break;
                        }
                        return z.f17874a;
                    }
                    com.skydoves.sandwich.a.b.C0151a c0151a8 = (com.skydoves.sandwich.a.b.C0151a) aVar8;
                    v0 v0Var7 = v0.f21450a;
                    v0Var7.a(c0151a8);
                    aVar9 = a.f20755a;
                    strA2 = v0Var7.a(c0151a8);
                    hVar.L$0 = aVar7;
                    hVar.L$1 = str4;
                    hVar.L$2 = aVar8;
                    hVar.Z$0 = z13;
                    hVar.label = 7;
                    if (aVar9.T(strA2, z13, str4, hVar) != objC2) {
                        z14 = z13;
                        aVar = aVar7;
                        if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                            aVar10 = a.f20755a;
                            strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                            hVar.L$0 = aVar;
                            hVar.L$1 = aVar8;
                            hVar.L$2 = null;
                            hVar.label = 8;
                            if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                            }
                        }
                        boolean z1116 = hVar.$isRetryAfterFailure;
                        String str1111 = hVar.$token;
                        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                            a aVar1119 = a.f20755a;
                            String strB116 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                            hVar.L$0 = aVar;
                            hVar.L$1 = null;
                            hVar.L$2 = null;
                            hVar.label = 10;
                            break;
                        }
                        return z.f17874a;
                    }
                    return objC2;
                case 7:
                    z13 = this.Z$0;
                    aVar8 = (com.skydoves.sandwich.a) this.L$2;
                    str4 = (String) this.L$1;
                    aVar7 = (com.skydoves.sandwich.a) this.L$0;
                    r8.r.b(obj);
                    hVar = this;
                    z14 = z13;
                    aVar = aVar7;
                    if (aVar8 instanceof com.skydoves.sandwich.a.b.C0152b) {
                        aVar10 = a.f20755a;
                        strB = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar8);
                        hVar.L$0 = aVar;
                        hVar.L$1 = aVar8;
                        hVar.L$2 = null;
                        hVar.label = 8;
                        if (aVar10.T(strB, z14, str4, hVar) != objC2) {
                        }
                        return objC2;
                    }
                    boolean z1117 = hVar.$isRetryAfterFailure;
                    String str1112 = hVar.$token;
                    if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                        a aVar11110 = a.f20755a;
                        String strB117 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                        hVar.L$0 = aVar;
                        hVar.L$1 = null;
                        hVar.L$2 = null;
                        hVar.label = 10;
                        break;
                    }
                    return z.f17874a;
                case 8:
                case 9:
                    aVar = (com.skydoves.sandwich.a) this.L$0;
                    r8.r.b(obj);
                    hVar = this;
                    boolean z1118 = hVar.$isRetryAfterFailure;
                    String str1113 = hVar.$token;
                    if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                        a aVar11111 = a.f20755a;
                        String strB118 = v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar);
                        hVar.L$0 = aVar;
                        hVar.L$1 = null;
                        hVar.L$2 = null;
                        hVar.label = 10;
                        break;
                    }
                    return z.f17874a;
                case 10:
                    r8.r.b(obj);
                    return z.f17874a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager", f = "ChannelManager.kt", l = {436}, m = "loadLocalColumns")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class i extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        i(v8.f<? super i> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.R(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager$loadSubscribedChannel$1", f = "ChannelManager.kt", l = {1249}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class k extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        int label;

        k(v8.f<? super k> fVar) {
            super(2, fVar);
        }

        /* JADX INFO: renamed from: x1.f1.lb.media.a$k$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010#\n\u0000*\u0001\u0000\b\n\u0018\u000022\u0012.\u0012,\u0012\u0004\u0012\u00020\u0003\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u00060\u00040\u00020\u0001¨\u0006\t"}, d2 = {"x1/f1/lb/media/a$k$a", "Lf3/a;", "", "", "Ljava/util/concurrent/ConcurrentSkipListMap;", "", "Lr8/p;", "", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0422a extends f3.a<Map<String, ConcurrentSkipListMap<Long, r8.p<? extends Boolean, ? extends Set<String>>>>> {
            C0422a() {
            }
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new k(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((k) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Map map;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    a aVar = a.f20755a;
                    w0 w0Var = w0.f21452a;
                    this.label = 1;
                    obj = w0.o(w0Var, "subscribed_channels", null, this, 2, null);
                    if (obj == objC) {
                        return objC;
                    }
                }
                String str = (String) obj;
                if (ac.g.f(str)) {
                    map = a.inSubscribedMap;
                } else {
                    Object objO = a.gson.o(str, new C0422a().d());
                    kotlin.jvm.internal.m.e(objO, "fromJson(...)");
                    map = (Map) objO;
                }
            } catch (Throwable th) {
                a.logger.error("load subscribed failure", th);
                map = a.inSubscribedMap;
            }
            a.inSubscribedMap = map;
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager", f = "ChannelManager.kt", l = {354, 377}, m = "onLoadChannelFailure")
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
            return a.this.T(null, false, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager$onLoadChannelFailure$2", f = "ChannelManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    static final class m extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super z>, Object> {
        final /* synthetic */ String $errMessage;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, v8.f<? super m> fVar) {
            super(3, fVar);
            this.$errMessage = str;
        }

        @Override // c9.q
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(kotlinx.coroutines.flow.g<? super u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super z> fVar) {
            m mVar = new m(this.$errMessage, fVar);
            mVar.L$0 = th;
            return mVar.invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Long lC;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                Throwable th = (Throwable) this.L$0;
                a.logger.error("fetch channel list failure " + this.$errMessage + ", re-login failure", th);
                xe.c.c().o(new nf.d(false, "", this.$errMessage));
                if (a.isInitComplete) {
                    lC = kotlin.coroutines.jvm.internal.b.c(d1.c() + ((long) 300000));
                } else {
                    lC = kotlin.coroutines.jvm.internal.b.c(d1.c() + 15000);
                }
                a.nextUpdateTime = lC;
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class n<T> implements kotlinx.coroutines.flow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f20783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f20784b;

        n(String str, boolean z10) {
            this.f20783a = str;
            this.f20784b = z10;
        }

        @Override // kotlinx.coroutines.flow.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(u<Boolean, Integer, String> uVar, v8.f<? super z> fVar) {
            Long lC;
            if (!uVar.d().booleanValue()) {
                q6.b bVar = a.logger;
                String str = this.f20783a;
                String strF = uVar.f();
                bVar.error("re-login failure[cause by: " + str + "], [" + ((Object) strF) + "(" + uVar.e() + ")]", new Object[0]);
                xe.c.c().o(new nf.d(false, "", this.f20783a));
                if (a.isInitComplete) {
                    lC = kotlin.coroutines.jvm.internal.b.c(d1.c() + ((long) 300000));
                } else {
                    lC = kotlin.coroutines.jvm.internal.b.c(d1.c() + 15000);
                }
                a.nextUpdateTime = lC;
            } else if (!a.isInitComplete && !a.isInLoading.get()) {
                a.logger.a("re-login complete[cause by: " + this.f20783a + "], reload channel list", new Object[0]);
                a.Q(a.f20755a, this.f20784b, false, 2, null);
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager", f = "ChannelManager.kt", l = {313, 322}, m = "onLoadChannelSuccess")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class o extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        o(v8.f<? super o> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.U(null, false, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class p<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return t8.a.a(Integer.valueOf(((ChannelStreamResponse) t10).getDisplaySeq()), Integer.valueOf(((ChannelStreamResponse) t11).getDisplaySeq()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class q<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return t8.a.a(Integer.valueOf(((ChannelStreamResponse) t10).getDisplaySeq()), Integer.valueOf(((ChannelStreamResponse) t11).getDisplaySeq()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class r<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return t8.a.a(Integer.valueOf(((ChannelStreamResponse) t10).getDisplaySeq()), Integer.valueOf(((ChannelStreamResponse) t11).getDisplaySeq()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager", f = "ChannelManager.kt", l = {1268}, m = "refreshLocalColumns")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class s extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        s(v8.f<? super s> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.W(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.ChannelManager", f = "ChannelManager.kt", l = {758, 781}, m = "toggleChannelSubscribe")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class t extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        t(v8.f<? super t> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.g0(0, 0L, null, null, this);
        }
    }

    private final String r(int idx, StringBuilder stringBuffer, int numCnt) {
        stringBuffer.setLength(0);
        int iLog10 = ((int) Math.log10(idx)) + 1;
        while (true) {
            int i10 = iLog10 + 1;
            if (iLog10 >= numCnt) {
                stringBuffer.append(idx);
                String string = stringBuffer.toString();
                kotlin.jvm.internal.m.e(string, "toString(...)");
                return string;
            }
            stringBuffer.append("0");
            iLog10 = i10;
        }
    }

    /* JADX WARN: Code duplicated, block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0242  */
    /* JADX WARN: Code duplicated, block: B:50:0x0295  */
    /* JADX WARN: Code duplicated, block: B:51:0x0298  */
    /* JADX WARN: Code duplicated, block: B:54:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:56:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:57:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:58:0x02df  */
    /* JADX WARN: Code duplicated, block: B:68:0x037d  */
    /* JADX WARN: Code duplicated, block: B:69:0x0391  */
    /* JADX WARN: Code duplicated, block: B:71:0x0399  */
    /* JADX WARN: Code duplicated, block: B:73:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:76:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:79:0x0440  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:87:0x0468  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9, types: [boolean] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0190 -> B:28:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x030d -> B:28:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x03d4 -> B:74:0x03e9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0440 -> B:14:0x0090). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object q(long r33, v8.f<? super r8.z> r35) {
        /*
            Method dump skipped, instruction units count: 1380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.media.a.q(long, v8.f):java.lang.Object");
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00020\u0001¨\u0006\u0007"}, d2 = {"x1/f1/lb/media/a$j", "Lf3/a;", "", "", "Lr8/p;", "", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j extends f3.a<Map<Integer, r8.p<? extends String, ? extends Long>>> {
        j() {
        }
    }

    static {
        long jC = d1.c();
        lastInSubscribedChangeTime = jC;
        lastInSubscribedSaveTime = jC;
        favoritesMap = new HashMap();
        playHistoryMap = new HashMap();
        isInLoading = new AtomicBoolean(false);
    }

    private final List<ChannelStreamResponse> B(String columnKey, int mode) {
        Map<Integer, r8.p<String, Long>> map;
        List<? extends ChannelStreamResponse> list;
        if (kotlin.jvm.internal.m.a(columnKey, columnFavorites)) {
            map = favoritesMap;
        } else {
            if (!kotlin.jvm.internal.m.a(columnKey, columnPlayHistory)) {
                return new ArrayList();
            }
            map = playHistoryMap;
        }
        Map<String, ? extends List<? extends ChannelStreamResponse>> map2 = channelsByColumns.get(Integer.valueOf(mode));
        if (map2 == null || (list = map2.get(columnAll)) == null) {
            return new ArrayList();
        }
        HashMap map3 = new HashMap();
        synchronized (map) {
            try {
                for (Map.Entry<Integer, r8.p<String, Long>> entry : map.entrySet()) {
                    map3.put(entry.getValue().c(), entry.getValue().d());
                }
                z zVar = z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (!kotlin.jvm.internal.m.a(columnKey, columnFavorites)) {
            for (ChannelStreamResponse channelStreamResponse : list) {
                if (((Long) map3.get(channelStreamResponse.getStreamId())) != null) {
                    arrayList.add(channelStreamResponse);
                }
            }
            return kotlin.collections.r.D0(kotlin.collections.r.J0(arrayList, new g(map3)));
        }
        for (ChannelStreamResponse channelStreamResponse2 : list) {
            if (((Long) map3.get(channelStreamResponse2.getStreamId())) != null) {
                map3.put(channelStreamResponse2.getStreamId(), Long.valueOf(channelStreamResponse2.getDisplaySeq()));
                arrayList.add(channelStreamResponse2);
            }
        }
        return kotlin.collections.r.J0(arrayList, new f(map3));
    }

    static /* synthetic */ List C(a aVar, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return aVar.B(str, i10);
    }

    private final void M(String msg) {
        tf.e eVarE = x1.f1.lb.metric.monitor.h.f20952a.e();
        if (eVarE != null) {
            eVarE.r(msg);
        }
        if (eVarE != null) {
            eVarE.q(d1.d());
        }
        Long lValueOf = eVarE != null ? Long.valueOf(eVarE.h()) : null;
        if (eVarE != null) {
            eVarE.v((lValueOf != null ? lValueOf.longValue() : 0L) + 1);
        }
    }

    public static /* synthetic */ void P(a aVar, long j10, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        aVar.N(j10, z10, z11);
    }

    public static /* synthetic */ void Q(a aVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        aVar.O(z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0060  */
    /* JADX WARN: Code duplicated, block: B:25:0x007c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x007d  */
    /* JADX WARN: Code duplicated, block: B:29:0x008a A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:12:0x0040, B:27:0x0082, B:29:0x008a, B:31:0x00a6, B:32:0x00a9, B:34:0x00af), top: B:46:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a6 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:12:0x0040, B:27:0x0082, B:29:0x008a, B:31:0x00a6, B:32:0x00a9, B:34:0x00af), top: B:46:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a9 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:12:0x0040, B:27:0x0082, B:29:0x008a, B:31:0x00a6, B:32:0x00a9, B:34:0x00af), top: B:46:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00af A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #1 {all -> 0x0044, blocks: (B:12:0x0040, B:27:0x0082, B:29:0x008a, B:31:0x00a6, B:32:0x00a9, B:34:0x00af), top: B:46:0x0040 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007d -> B:27:0x0082). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object R(v8.f<? super r8.z> r18) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.media.a.R(v8.f):java.lang.Object");
    }

    private final void S() {
        kotlinx.coroutines.j.d(puckScope, null, null, new k(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009f, code lost:
    
        if (r3.collect(r6, r4) == r5) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object T(String str, boolean z10, String str2, v8.f<? super z> fVar) {
        l lVar;
        a aVar;
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
        Object obj = lVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = lVar.label;
        if (i11 == 0) {
            r8.r.b(obj);
            isInLoading.set(false);
            String strG = of.a.f16585a.g();
            if (str2.length() > 0 && !kotlin.jvm.internal.m.a(str2, strG)) {
                Q(this, z10, false, 2, null);
                return z.f17874a;
            }
            M(str);
            String lowerCase = str.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.m.e(lowerCase, "toLowerCase(...)");
            if (ac.g.a(lowerCase, "invalid token")) {
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(x1.f1.lb.user.f.g1(x1.f1.lb.user.f.f21202a, null, null, false, 7, null), new m(str, null));
                n nVar = new n(str, z10);
                lVar.label = 1;
            } else {
                x1.f1.lb.bot.a.f20583a.l("[load channel list]\nfailure:" + str);
                botFailureTime = d1.d();
                logger.error("fetch channel list failure " + str + " and keep retry?" + z10, new Object[0]);
                if (z10) {
                    lVar.L$0 = this;
                    lVar.label = 2;
                    if (kotlinx.coroutines.v0.a(15000L, lVar) != objC) {
                        aVar = this;
                        Q(aVar, true, false, 2, null);
                    }
                } else {
                    if (isInitComplete) {
                        logger.error("fetch channel list failure " + str + ", retry after 300000 ms", new Object[0]);
                        nextUpdateTime = kotlin.coroutines.jvm.internal.b.c(d1.c() + ((long) 300000));
                        return z.f17874a;
                    }
                    nextUpdateTime = kotlin.coroutines.jvm.internal.b.c(d1.c() + 15000);
                }
            }
            return objC;
        }
        if (i11 == 1) {
            r8.r.b(obj);
            return z.f17874a;
        }
        if (i11 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        aVar = (a) lVar.L$0;
        r8.r.b(obj);
        Q(aVar, true, false, 2, null);
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fe, code lost:
    
        if (T(r11, r12, r13, r0) == r1) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object U(n6.b<ChannelListResponse> bVar, boolean z10, String str, v8.f<? super z> fVar) {
        o oVar;
        ChannelListResponse channelListResponse;
        if (fVar instanceof o) {
            oVar = (o) fVar;
            int i10 = oVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                oVar.label = i10 - Integer.MIN_VALUE;
            } else {
                oVar = new o(fVar);
            }
        } else {
            oVar = new o(fVar);
        }
        Object obj = oVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = oVar.label;
        if (i11 == 0) {
            r8.r.b(obj);
            String strC = bVar.c();
            if (strC == null) {
                strC = "";
            }
            checksumInUpdateNotice = "";
            isInLoading.set(false);
            ChannelListResponse data = bVar.getData();
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("fetch channel list data[{}]", data);
            }
            boolean z11 = data != null;
            if (!isInitComplete) {
                isInitComplete = z11;
            }
            long jC = d1.c();
            if (z11) {
                checksumInChannelList = strC;
                nextUpdateTime = kotlin.coroutines.jvm.internal.b.c(43200000 + jC);
                tf.e eVarE = x1.f1.lb.metric.monitor.h.f20952a.e();
                if (eVarE != null && eVarE.g() == 0) {
                    eVarE.u(jC);
                    uf.c.f19486a.p();
                }
                List<? extends ChannelStreamResponse> channelStreams = data.getChannelStreams();
                List<String> categorySorts = data.getCategorySorts();
                oVar.L$0 = data;
                oVar.label = 1;
                if (V(channelStreams, categorySorts, oVar) != objC) {
                    channelListResponse = data;
                    xe.c.c().r(nf.d.class);
                    xe.c.c().o(new nf.d());
                    x1.f1.lb.media.c.f20788a.S(channelListResponse.getChannelEPGIndexResponse());
                }
            } else if (!isInitComplete) {
                String str2 = "got list response, but data is null, msg: " + bVar.d() + ", code: " + bVar.getCode();
                oVar.label = 2;
            } else if (kotlin.jvm.internal.m.a(strC, checksumInChannelList)) {
                nextUpdateTime = kotlin.coroutines.jvm.internal.b.c(jC + 43200000);
            } else {
                nextUpdateTime = kotlin.coroutines.jvm.internal.b.c(jC + ((long) 300000));
            }
            return objC;
        }
        if (i11 != 1) {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(obj);
            return z.f17874a;
        }
        channelListResponse = (ChannelListResponse) oVar.L$0;
        r8.r.b(obj);
        xe.c.c().r(nf.d.class);
        xe.c.c().o(new nf.d());
        x1.f1.lb.media.c.f20788a.S(channelListResponse.getChannelEPGIndexResponse());
        return z.f17874a;
    }

    private final Object V(List<? extends ChannelStreamResponse> list, List<String> list2, v8.f<? super z> fVar) {
        if (list == null || ef.a.a(list)) {
            return z.f17874a;
        }
        long j10 = botFailureTime;
        if (j10 > 0) {
            String strB = d1.b(d1.d() - j10, null);
            x1.f1.lb.bot.a.f20583a.m("[load channel list]\nrecover in " + strB);
            botFailureTime = 0L;
        }
        HashMap map = new HashMap();
        map.put(kotlin.coroutines.jvm.internal.b.b(0), new HashMap());
        map.put(kotlin.coroutines.jvm.internal.b.b(1), new HashMap());
        HashMap map2 = new HashMap();
        map2.put(kotlin.coroutines.jvm.internal.b.b(0), new HashMap());
        map2.put(kotlin.coroutines.jvm.internal.b.b(1), new HashMap());
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        ArrayList arrayList = new ArrayList();
        List<String> list3 = list2;
        ArrayList arrayList2 = (list3 == null || list3.isEmpty()) ? new ArrayList() : new ArrayList(list3);
        String[] strArr = {columnAll, columnFavorites, columnSubscribes, columnPlayHistory, columnCatchup};
        for (int i10 = 0; i10 < 5; i10++) {
            String str = strArr[i10];
            if (str.length() > 0) {
                hashSet.add(str);
                hashSet2.add(str);
                arrayList.add(str);
            }
        }
        HashMap map3 = new HashMap();
        map3.put(kotlin.coroutines.jvm.internal.b.b(0), new HashMap());
        map3.put(kotlin.coroutines.jvm.internal.b.b(1), new HashMap());
        ArrayList arrayList3 = new ArrayList();
        HashMap map4 = new HashMap();
        boolean z10 = false;
        for (ChannelStreamResponse channelStreamResponse : list) {
            channelStreamResponse.setKey(L(channelStreamResponse));
            HashMap map5 = (HashMap) map4.get(channelStreamResponse.getStreamId());
            if (map5 == null) {
                map5 = new HashMap();
                map4.put(channelStreamResponse.getStreamId(), map5);
            }
            HashMap map6 = map4;
            map5.put(channelStreamResponse.getRoute(), kotlin.coroutines.jvm.internal.b.b(channelStreamResponse.getKey()));
            boolean z11 = channelStreamResponse.getType() == 1 || channelStreamResponse.getType() == 3;
            Object obj = map3.get(kotlin.coroutines.jvm.internal.b.b(1));
            kotlin.jvm.internal.m.c(obj);
            ((Map) obj).put(kotlin.coroutines.jvm.internal.b.b(channelStreamResponse.getKey()), channelStreamResponse);
            if (!z11) {
                Object obj2 = map3.get(kotlin.coroutines.jvm.internal.b.b(0));
                kotlin.jvm.internal.m.c(obj2);
                ((Map) obj2).put(kotlin.coroutines.jvm.internal.b.b(channelStreamResponse.getKey()), channelStreamResponse);
                arrayList3.add(channelStreamResponse);
            } else if (!z10) {
                z10 = true;
            }
            if (channelStreamResponse.isCatchup()) {
                Object obj3 = map.get(kotlin.coroutines.jvm.internal.b.b(1));
                kotlin.jvm.internal.m.c(obj3);
                List arrayList4 = (List) ((HashMap) obj3).get(columnCatchup);
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                    Object obj4 = map.get(kotlin.coroutines.jvm.internal.b.b(1));
                    kotlin.jvm.internal.m.c(obj4);
                    ((Map) obj4).put(columnCatchup, arrayList4);
                }
                arrayList4.add(channelStreamResponse);
                if (!z11) {
                    Object obj5 = map.get(kotlin.coroutines.jvm.internal.b.b(0));
                    kotlin.jvm.internal.m.c(obj5);
                    List arrayList5 = (List) ((HashMap) obj5).get(columnCatchup);
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                        Object obj6 = map.get(kotlin.coroutines.jvm.internal.b.b(0));
                        kotlin.jvm.internal.m.c(obj6);
                        ((Map) obj6).put(columnCatchup, arrayList5);
                    }
                    arrayList5.add(channelStreamResponse);
                }
            } else {
                map3 = map3;
            }
            ArrayList arrayList6 = new ArrayList();
            arrayList6.add(columnAll);
            if (!ac.g.f(channelStreamResponse.getCategories())) {
                String categories = channelStreamResponse.getCategories();
                kotlin.jvm.internal.m.e(categories, "getCategories(...)");
                for (String str2 : ua.n.z0(categories, new String[]{";"}, false, 0, 6, null)) {
                    if (str2.length() > 0) {
                        arrayList6.add(str2);
                        hashSet2.add(str2);
                        if (!z11) {
                            hashSet.add(str2);
                        }
                    }
                }
            }
            Iterator it = arrayList6.iterator();
            kotlin.jvm.internal.m.e(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.m.e(next, "next(...)");
                String str3 = (String) next;
                Object obj7 = map.get(kotlin.coroutines.jvm.internal.b.b(1));
                kotlin.jvm.internal.m.c(obj7);
                List arrayList7 = (List) ((HashMap) obj7).get(str3);
                if (arrayList7 == null) {
                    arrayList7 = new ArrayList();
                    Object obj8 = map.get(kotlin.coroutines.jvm.internal.b.b(1));
                    kotlin.jvm.internal.m.c(obj8);
                    ((Map) obj8).put(str3, arrayList7);
                }
                arrayList7.add(channelStreamResponse);
                if (!z11 && hashSet.contains(str3)) {
                    Object obj9 = map.get(kotlin.coroutines.jvm.internal.b.b(0));
                    kotlin.jvm.internal.m.c(obj9);
                    List arrayList8 = (List) ((HashMap) obj9).get(str3);
                    if (arrayList8 == null) {
                        arrayList8 = new ArrayList();
                        Object obj10 = map.get(kotlin.coroutines.jvm.internal.b.b(0));
                        kotlin.jvm.internal.m.c(obj10);
                        ((Map) obj10).put(str3, arrayList8);
                    }
                    arrayList8.add(channelStreamResponse);
                }
                it = it;
            }
            map4 = map6;
            map3 = map3;
        }
        isAdultExists = z10;
        channelsMap = map3;
        streamsMap = map4;
        for (String str4 : kotlin.collections.r.I0(hashSet2)) {
            if (!arrayList2.contains(str4)) {
                arrayList2.add(str4);
            }
        }
        HashMap map7 = new HashMap();
        ArrayList arrayList9 = new ArrayList();
        arrayList9.addAll(arrayList);
        for (String str5 : kotlin.collections.r.I0(arrayList2)) {
            if (!arrayList.contains(str5) && hashSet.contains(str5)) {
                arrayList9.add(str5);
            }
        }
        map7.put(kotlin.coroutines.jvm.internal.b.b(0), arrayList9);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.addAll(arrayList9);
        for (String str6 : kotlin.collections.r.I0(arrayList2)) {
            if (!arrayList9.contains(str6) && hashSet2.contains(str6)) {
                arrayList10.add(str6);
            }
        }
        map7.put(kotlin.coroutines.jvm.internal.b.b(1), arrayList10);
        columnNames = map7;
        for (int i11 = 0; i11 < 2; i11++) {
            Object obj11 = map.get(kotlin.coroutines.jvm.internal.b.b(i11));
            kotlin.jvm.internal.m.c(obj11);
            for (Object obj12 : ((HashMap) obj11).entrySet()) {
                kotlin.jvm.internal.m.e(obj12, "next(...)");
                Map.Entry entry = (Map.Entry) obj12;
                Object key = entry.getKey();
                kotlin.jvm.internal.m.e(key, "<get-key>(...)");
                String str7 = (String) key;
                Object value = entry.getValue();
                kotlin.jvm.internal.m.e(value, "<get-value>(...)");
                List list4 = (List) value;
                if (list4.size() > 1) {
                    kotlin.collections.r.B(list4, new p());
                }
                Object obj13 = map2.get(kotlin.coroutines.jvm.internal.b.b(i11));
                kotlin.jvm.internal.m.c(obj13);
                Map map8 = (Map) ((HashMap) obj13).get(str7);
                if (map8 == null) {
                    map8 = new HashMap();
                }
                int size = list4.size();
                for (int i12 = 0; i12 < size; i12++) {
                    map8.put(kotlin.coroutines.jvm.internal.b.b(((ChannelStreamResponse) list4.get(i12)).getKey()), kotlin.coroutines.jvm.internal.b.b(i12));
                }
                Object obj14 = map2.get(kotlin.coroutines.jvm.internal.b.b(i11));
                kotlin.jvm.internal.m.c(obj14);
                ((Map) obj14).put(str7, map8);
            }
        }
        channelsByColumns = map;
        channelPositionsByColumns = map2;
        HashMap map9 = new HashMap();
        map9.put(kotlin.coroutines.jvm.internal.b.b(0), kotlin.collections.r.J0(arrayList3, new q()));
        map9.put(kotlin.coroutines.jvm.internal.b.b(1), kotlin.collections.r.J0(list, new r()));
        channels = map9;
        HashMap map10 = new HashMap();
        HashMap map11 = new HashMap();
        int iLog10 = ((int) Math.log10(list.size())) + 1;
        for (int i13 = 0; i13 < 2; i13++) {
            StringBuilder sb2 = new StringBuilder();
            Object obj15 = map9.get(kotlin.coroutines.jvm.internal.b.b(i13));
            kotlin.jvm.internal.m.c(obj15);
            int i14 = 0;
            for (ChannelStreamResponse channelStreamResponse2 : (Iterable) obj15) {
                int i15 = i14 + 1;
                String strR = r(i15, sb2, iLog10);
                HashMap map12 = (HashMap) map10.get(kotlin.coroutines.jvm.internal.b.b(i13));
                if (map12 == null) {
                    map12 = new HashMap();
                    map10.put(kotlin.coroutines.jvm.internal.b.b(i13), map12);
                }
                map12.put(kotlin.coroutines.jvm.internal.b.b(channelStreamResponse2.getKey()), new r8.p(kotlin.coroutines.jvm.internal.b.b(i14), strR));
                HashMap map13 = (HashMap) map11.get(kotlin.coroutines.jvm.internal.b.b(i13));
                if (map13 == null) {
                    map13 = new HashMap();
                    map11.put(kotlin.coroutines.jvm.internal.b.b(i13), map13);
                }
                map13.put(kotlin.coroutines.jvm.internal.b.b(i15), kotlin.coroutines.jvm.internal.b.b(channelStreamResponse2.getKey()));
                i14 = i15;
            }
        }
        channelNum = map10;
        numChannel = map11;
        Object objW = W(fVar);
        return objW == kotlin.coroutines.intrinsics.b.c() ? objW : z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object W(v8.f<? super z> fVar) {
        s sVar;
        List<? extends ChannelStreamResponse> list;
        if (fVar instanceof s) {
            sVar = (s) fVar;
            int i10 = sVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                sVar.label = i10 - Integer.MIN_VALUE;
            } else {
                sVar = new s(fVar);
            }
        } else {
            sVar = new s(fVar);
        }
        Object obj = sVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = sVar.label;
        if (i11 == 0) {
            r8.r.b(obj);
            sVar.L$0 = this;
            sVar.label = 1;
            if (R(sVar) == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(obj);
        }
        int i12 = playMode;
        String[] strArr = {"favorites", "play_history"};
        for (int i13 = 0; i13 < 2; i13++) {
            String str = strArr[i13];
            Map map = kotlin.jvm.internal.m.a(str, "favorites") ? favoritesMap : kotlin.jvm.internal.m.a(str, "play_history") ? playHistoryMap : new HashMap();
            Map<String, ? extends List<? extends ChannelStreamResponse>> map2 = channelsByColumns.get(kotlin.coroutines.jvm.internal.b.b(i12));
            if (map2 != null && (list = map2.get(columnAll)) != null) {
                HashMap map3 = new HashMap();
                for (Map.Entry entry : map.entrySet()) {
                    map3.put(((r8.p) entry.getValue()).c(), ((r8.p) entry.getValue()).d());
                }
                TreeMap treeMap = new TreeMap();
                HashMap map4 = new HashMap();
                for (ChannelStreamResponse channelStreamResponse : list) {
                    Long l10 = (Long) map3.get(channelStreamResponse.getStreamId());
                    if (l10 != null) {
                        long jLongValue = l10.longValue();
                        treeMap.put(kotlin.coroutines.jvm.internal.b.c(jLongValue), channelStreamResponse);
                        map4.put(kotlin.coroutines.jvm.internal.b.b(channelStreamResponse.getKey()), new r8.p(channelStreamResponse.getStreamId(), kotlin.coroutines.jvm.internal.b.c(jLongValue)));
                    }
                }
                if (kotlin.jvm.internal.m.a(str, "favorites")) {
                    favoritesMap = map4;
                } else if (kotlin.jvm.internal.m.a(str, "play_history")) {
                    playHistoryMap = map4;
                }
            }
        }
        return z.f17874a;
    }

    private final void Z(String type, List<Integer> keys) {
        Map<Integer, r8.p<String, Long>> map;
        if (kotlin.jvm.internal.m.a(type, "play_history")) {
            map = playHistoryMap;
        } else if (!kotlin.jvm.internal.m.a(type, "favorites")) {
            return;
        } else {
            map = favoritesMap;
        }
        synchronized (map) {
            try {
                Iterator<T> it = keys.iterator();
                while (it.hasNext()) {
                    map.remove(Integer.valueOf(((Number) it.next()).intValue()));
                }
                String strW = gson.w(map);
                w0 w0Var = w0.f21452a;
                kotlin.jvm.internal.m.c(strW);
                w0Var.t(type, strW);
                z zVar = z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c0() {
        if (lastInSubscribedChangeTime < lastInSubscribedSaveTime) {
            return;
        }
        try {
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("SubscribeIO save subscribes[{}]", inSubscribedMap);
            }
            String strW = gson.w(inSubscribedMap);
            w0 w0Var = w0.f21452a;
            kotlin.jvm.internal.m.c(strW);
            w0Var.t("subscribed_channels", strW);
            lastInSubscribedSaveTime = d1.c();
        } catch (Exception e10) {
            logger.error("save subscribed channels failure", e10);
        }
    }

    private final String f0(String epgId, String streamId, long startTime) {
        return epgId + "." + streamId + "." + startTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:52:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:55:0x0224  */
    /* JADX WARN: Code duplicated, block: B:58:0x0236  */
    /* JADX WARN: Code duplicated, block: B:62:0x024b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01bb -> B:50:0x01cd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x023c -> B:50:0x01cd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x024b -> B:71:0x02d3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x02a9 -> B:67:0x02b2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object s(java.lang.String r32, v8.f<? super java.util.List<? extends r8.u<java.lang.Integer, java.lang.Long, ? extends z1.b1.lb.m.meta.EPGProgramme>>> r33) {
        /*
            Method dump skipped, instruction units count: 817
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.media.a.s(java.lang.String, v8.f):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object A(v8.f<? super List<? extends u<Integer, Long, ? extends EPGProgramme>>> fVar) {
        e eVar;
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
        Object objS = eVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = eVar.label;
        if (i11 == 0) {
            r8.r.b(objS);
            eVar.label = 1;
            objS = s("subscribed_channels", eVar);
            if (objS == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(objS);
        }
        return kotlin.collections.r.J0((Iterable) objS, new d());
    }

    public final List<ChannelStreamResponse> D() {
        return C(this, columnPlayHistory, 0, 2, null);
    }

    public final String E() {
        return columnPlayHistory;
    }

    public final void F(String columnAll2, String columnPlayHistory2, String columnFavorites2, String columnCatchup2) {
        kotlin.jvm.internal.m.f(columnAll2, "columnAll");
        kotlin.jvm.internal.m.f(columnPlayHistory2, "columnPlayHistory");
        kotlin.jvm.internal.m.f(columnFavorites2, "columnFavorites");
        kotlin.jvm.internal.m.f(columnCatchup2, "columnCatchup");
        columnAll = columnAll2;
        columnPlayHistory = columnPlayHistory2;
        columnFavorites = columnFavorites2;
        columnCatchup = columnCatchup2;
        S();
    }

    public final boolean G(String columnKey) {
        List<String> list;
        List<String> list2 = columnNames.get(1);
        return list2 != null && kotlin.collections.r.a0(list2, columnKey) && ((list = columnNames.get(0)) == null || !kotlin.collections.r.a0(list, columnKey));
    }

    public final boolean H() {
        return playMode == 1;
    }

    public final boolean I(int key, long startTime, String epgId) {
        ChannelStreamResponse channelStreamResponse;
        r8.p<Boolean, Set<String>> pVar;
        Set<String> setD;
        kotlin.jvm.internal.m.f(epgId, "epgId");
        Map<Integer, ? extends ChannelStreamResponse> map = channelsMap.get(Integer.valueOf(playMode));
        if (map == null || (channelStreamResponse = map.get(Integer.valueOf(key))) == null) {
            return false;
        }
        String streamId = channelStreamResponse.getStreamId();
        ConcurrentSkipListMap<Long, r8.p<Boolean, Set<String>>> concurrentSkipListMap = inSubscribedMap.get(epgId);
        if (concurrentSkipListMap == null || (pVar = concurrentSkipListMap.get(Long.valueOf(startTime))) == null || (setD = pVar.d()) == null) {
            return false;
        }
        return setD.contains(streamId);
    }

    public final boolean J(int key) {
        return favoritesMap.containsKey(Integer.valueOf(key));
    }

    public final boolean K() {
        return isInLoading.get();
    }

    public final void N(long now, boolean isRetryAfterFailure, boolean isForce) {
        Long l10;
        if (!isInLoading.compareAndSet(false, true)) {
            logger.warn("channel is in loading", new Object[0]);
            return;
        }
        String strA0 = x1.f1.lb.user.f.f21202a.A0();
        if (ac.g.f(strA0)) {
            logger.warn("stream token is empty, channel list not load", new Object[0]);
            isInLoading.set(false);
            return;
        }
        if (isInitComplete && !isForce && (l10 = nextUpdateTime) != null) {
            kotlin.jvm.internal.m.c(l10);
            if (l10.longValue() > now) {
                isInLoading.set(false);
                return;
            }
        }
        kotlinx.coroutines.j.d(puckScope, null, null, new h(isRetryAfterFailure, strA0, null), 3, null);
    }

    public final void Y(List<Integer> keys) {
        kotlin.jvm.internal.m.f(keys, "keys");
        Z("favorites", keys);
    }

    public final void a0(List<Integer> keys) {
        kotlin.jvm.internal.m.f(keys, "keys");
        Z("play_history", keys);
    }

    public final void d0() {
        if (playMode == 1) {
            return;
        }
        playMode = 1;
        xe.c.c().o(new nf.n(true));
    }

    public final void e0() {
        if (playMode == 0) {
            return;
        }
        playMode = 0;
        xe.c.c().o(new nf.n(false));
    }

    /* JADX WARN: Code duplicated, block: B:55:0x016f  */
    /* JADX WARN: Code duplicated, block: B:73:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    public final Object g0(int i10, long j10, String str, SubscribeItem subscribeItem, v8.f<? super Boolean> fVar) {
        t tVar;
        int i11;
        ChannelStreamResponse channelStreamResponse;
        String streamId;
        char c10;
        char c11;
        char c12;
        a aVar;
        String str2;
        String str3;
        boolean z10;
        long j11 = j10;
        String str4 = str;
        if (fVar instanceof t) {
            tVar = (t) fVar;
            int i12 = tVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                tVar.label = i12 - Integer.MIN_VALUE;
            } else {
                tVar = new t(fVar);
            }
        } else {
            tVar = new t(fVar);
        }
        Object obj = tVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i13 = tVar.label;
        if (i13 == 0) {
            r8.r.b(obj);
            i11 = playMode;
            Map<Integer, ? extends ChannelStreamResponse> map = channelsMap.get(kotlin.coroutines.jvm.internal.b.b(i11));
            if (map == null || (channelStreamResponse = map.get(kotlin.coroutines.jvm.internal.b.b(i10))) == null) {
                return kotlin.coroutines.jvm.internal.b.a(false);
            }
            streamId = channelStreamResponse.getStreamId();
            ConcurrentSkipListMap<Long, r8.p<Boolean, Set<String>>> concurrentSkipListMap = inSubscribedMap.get(str4);
            c10 = 0;
            r8.p<Boolean, Set<String>> pVar = concurrentSkipListMap != null ? concurrentSkipListMap.get(kotlin.coroutines.jvm.internal.b.c(j11)) : null;
            if (pVar != null) {
                Set<String> setD = pVar.d();
                if (setD.contains(streamId)) {
                    setD.remove(streamId);
                    x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                    if (bVar.t()) {
                        logger.debug("SubscribeIO toggle remove from subscribed mode[{}], epgId[{}], time[{}], streamId[{}]", kotlin.coroutines.jvm.internal.b.b(i11), str4, kotlin.coroutines.jvm.internal.b.c(j11), streamId);
                    }
                    if (setD.isEmpty()) {
                        if (concurrentSkipListMap != null) {
                            concurrentSkipListMap.remove(kotlin.coroutines.jvm.internal.b.c(j11));
                        }
                        if (bVar.t()) {
                            logger.debug("SubscribeIO toggle remove mode[{}], epgId[{}], startTime[{}]", kotlin.coroutines.jvm.internal.b.b(i11), str4, kotlin.coroutines.jvm.internal.b.c(j11));
                        }
                        if (concurrentSkipListMap != null && concurrentSkipListMap.isEmpty()) {
                            inSubscribedMap.remove(str4);
                            if (bVar.t()) {
                                logger.debug("SubscribeIO toggle remove mode[{}], epgId[{}]", kotlin.coroutines.jvm.internal.b.b(i11), str4);
                            }
                        }
                    }
                    aVar = this;
                    z10 = false;
                } else {
                    setD.add(streamId);
                    if (subscribeItem != null) {
                        x1.f1.lb.media.k kVar = x1.f1.lb.media.k.f20860a;
                        a aVar2 = f20755a;
                        kotlin.jvm.internal.m.c(streamId);
                        String strF0 = aVar2.f0(str4, streamId, j11);
                        tVar.L$0 = this;
                        tVar.L$1 = str4;
                        tVar.L$2 = streamId;
                        tVar.J$0 = j11;
                        tVar.I$0 = i11;
                        tVar.label = 1;
                        if (kVar.c(strF0, subscribeItem, tVar) != objC) {
                            aVar = this;
                            str3 = streamId;
                            streamId = str3;
                        }
                    } else {
                        aVar = this;
                    }
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        q6.b bVar2 = logger;
                        Integer numB = kotlin.coroutines.jvm.internal.b.b(i11);
                        Long lC = kotlin.coroutines.jvm.internal.b.c(j11);
                        Object[] objArr = new Object[4];
                        objArr[c10] = numB;
                        objArr[1] = str4;
                        objArr[2] = lC;
                        objArr[3] = streamId;
                        bVar2.debug("SubscribeIO toggle add to subscribed mode[{}], epgId[{}], time[{}], streamId[{}]", objArr);
                    }
                    z10 = true;
                }
            } else {
                if (concurrentSkipListMap == null) {
                    concurrentSkipListMap = new ConcurrentSkipListMap<>();
                    inSubscribedMap.put(str4, concurrentSkipListMap);
                }
                r8.p<Boolean, Set<String>> pVar2 = concurrentSkipListMap.get(kotlin.coroutines.jvm.internal.b.c(j11));
                if (pVar2 == null) {
                    c11 = 3;
                    c12 = 1;
                    pVar2 = new r8.p<>(kotlin.coroutines.jvm.internal.b.a(false), new HashSet());
                    concurrentSkipListMap.put(kotlin.coroutines.jvm.internal.b.c(j11), pVar2);
                } else {
                    c11 = 3;
                    c12 = 1;
                }
                pVar2.d().add(streamId);
                if (subscribeItem != null) {
                    x1.f1.lb.media.k kVar2 = x1.f1.lb.media.k.f20860a;
                    a aVar3 = f20755a;
                    kotlin.jvm.internal.m.c(streamId);
                    String strF1 = aVar3.f0(str4, streamId, j11);
                    tVar.L$0 = this;
                    tVar.L$1 = str4;
                    tVar.L$2 = streamId;
                    tVar.J$0 = j11;
                    tVar.I$0 = i11;
                    tVar.label = 2;
                    if (kVar2.c(strF1, subscribeItem, tVar) != objC) {
                        aVar = this;
                        str2 = streamId;
                        streamId = str2;
                    }
                } else {
                    aVar = this;
                }
                if (x1.f1.lb.config.b.f20643a.t()) {
                    q6.b bVar3 = logger;
                    Integer numB2 = kotlin.coroutines.jvm.internal.b.b(i11);
                    Long lC2 = kotlin.coroutines.jvm.internal.b.c(j11);
                    Object[] objArr2 = new Object[4];
                    objArr2[c10] = numB2;
                    objArr2[c12] = str4;
                    objArr2[2] = lC2;
                    objArr2[c11] = streamId;
                    bVar3.debug("SubscribeIO toggle add to subscribed mode[{}], epgId[{}], time[{}], streamId[{}]", objArr2);
                }
                z10 = true;
            }
            return objC;
        }
        if (i13 == 1) {
            int i14 = tVar.I$0;
            long j12 = tVar.J$0;
            str3 = (String) tVar.L$2;
            String str5 = (String) tVar.L$1;
            aVar = (a) tVar.L$0;
            r8.r.b(obj);
            i11 = i14;
            j11 = j12;
            str4 = str5;
            c10 = 0;
            streamId = str3;
            if (x1.f1.lb.config.b.f20643a.t()) {
                q6.b bVar4 = logger;
                Integer numB3 = kotlin.coroutines.jvm.internal.b.b(i11);
                Long lC3 = kotlin.coroutines.jvm.internal.b.c(j11);
                Object[] objArr3 = new Object[4];
                objArr3[c10] = numB3;
                objArr3[1] = str4;
                objArr3[2] = lC3;
                objArr3[3] = streamId;
                bVar4.debug("SubscribeIO toggle add to subscribed mode[{}], epgId[{}], time[{}], streamId[{}]", objArr3);
            }
            z10 = true;
        } else {
            if (i13 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i15 = tVar.I$0;
            long j13 = tVar.J$0;
            str2 = (String) tVar.L$2;
            String str6 = (String) tVar.L$1;
            aVar = (a) tVar.L$0;
            r8.r.b(obj);
            i11 = i15;
            j11 = j13;
            str4 = str6;
            c10 = 0;
            c11 = 3;
            c12 = 1;
            streamId = str2;
            if (x1.f1.lb.config.b.f20643a.t()) {
                q6.b bVar5 = logger;
                Integer numB4 = kotlin.coroutines.jvm.internal.b.b(i11);
                Long lC4 = kotlin.coroutines.jvm.internal.b.c(j11);
                Object[] objArr4 = new Object[4];
                objArr4[c10] = numB4;
                objArr4[c12] = str4;
                objArr4[2] = lC4;
                objArr4[c11] = streamId;
                bVar5.debug("SubscribeIO toggle add to subscribed mode[{}], epgId[{}], time[{}], streamId[{}]", objArr4);
            }
            z10 = true;
        }
        lastInSubscribedChangeTime = d1.c();
        aVar.c0();
        return kotlin.coroutines.jvm.internal.b.a(z10);
    }

    public final void n(int key) {
        b0("play_history", key, 1);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
    
        if (r7.c(r6, r12, r0) == r1) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(int i10, long j10, String str, String str2, boolean z10, v8.f<? super z> fVar) {
        C0420a c0420a;
        ChannelStreamResponse channelStreamResponse;
        String strF0;
        if (fVar instanceof C0420a) {
            c0420a = (C0420a) fVar;
            int i11 = c0420a.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c0420a.label = i11 - Integer.MIN_VALUE;
            } else {
                c0420a = new C0420a(fVar);
            }
        } else {
            c0420a = new C0420a(fVar);
        }
        Object objA = c0420a.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i12 = c0420a.label;
        if (i12 != 0) {
            if (i12 == 1) {
                z10 = c0420a.Z$0;
                strF0 = (String) c0420a.L$1;
                str2 = (String) c0420a.L$0;
                r8.r.b(objA);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(objA);
            }
            return z.f17874a;
        }
        r8.r.b(objA);
        Map<Integer, ? extends ChannelStreamResponse> map = channelsMap.get(kotlin.coroutines.jvm.internal.b.b(playMode));
        if (map == null || (channelStreamResponse = map.get(kotlin.coroutines.jvm.internal.b.b(i10))) == null) {
            return z.f17874a;
        }
        String streamId = channelStreamResponse.getStreamId();
        kotlin.jvm.internal.m.c(streamId);
        strF0 = f0(str, streamId, j10);
        x1.f1.lb.media.k kVar = x1.f1.lb.media.k.f20860a;
        c0420a.L$0 = str2;
        c0420a.L$1 = strF0;
        c0420a.Z$0 = z10;
        c0420a.label = 1;
        objA = kVar.a(strF0, c0420a);
        if (objA != objC) {
        }
        return objC;
        SubscribeItem subscribeItem = (SubscribeItem) objA;
        if (subscribeItem != null && kotlin.jvm.internal.m.a(subscribeItem.getSportId(), str2) && subscribeItem.getIsAvailable() != z10) {
            subscribeItem.g(z10);
            x1.f1.lb.media.k kVar2 = x1.f1.lb.media.k.f20860a;
            c0420a.L$0 = null;
            c0420a.L$1 = null;
            c0420a.label = 2;
        }
        return z.f17874a;
    }

    public final String p(ChannelStreamResponse response) {
        r8.p<Integer, String> pVar;
        String strD;
        kotlin.jvm.internal.m.f(response, "response");
        Map<Integer, r8.p<Integer, String>> map = channelNum.get(1);
        return (map == null || (pVar = map.get(Integer.valueOf(response.getKey()))) == null || (strD = pVar.d()) == null) ? "NA" : strD;
    }

    public final ChannelStreamResponse t(int key) {
        Map<Integer, ? extends ChannelStreamResponse> map = channelsMap.get(Integer.valueOf(playMode));
        if (map != null) {
            return map.get(Integer.valueOf(key));
        }
        return null;
    }

    public final ChannelStreamResponse u(int key) {
        Map<Integer, ? extends ChannelStreamResponse> map = channelsMap.get(1);
        if (map != null) {
            return map.get(Integer.valueOf(key));
        }
        return null;
    }

    public final Integer v(String streamId, String routeId) {
        kotlin.jvm.internal.m.f(streamId, "streamId");
        Map<String, Integer> map = streamsMap.get(streamId);
        if (map == null || map.isEmpty()) {
            return null;
        }
        return (routeId == null || routeId.length() == 0) ? (Integer) kotlin.collections.r.f0(map.values()) : map.get(routeId);
    }

    public final List<ChannelStreamResponse> w(String columnKey, Boolean isIncludeAdult) {
        int i10;
        List<ChannelStreamResponse> list;
        kotlin.jvm.internal.m.f(columnKey, "columnKey");
        lastColumnKey = columnKey;
        if (isIncludeAdult == null) {
            i10 = playMode;
        } else {
            i10 = isIncludeAdult.booleanValue() ? 1 : 0;
        }
        if (kotlin.jvm.internal.m.a(columnKey, columnFavorites) || kotlin.jvm.internal.m.a(columnKey, columnPlayHistory)) {
            return B(columnKey, i10);
        }
        Map<String, ? extends List<? extends ChannelStreamResponse>> map = channelsByColumns.get(Integer.valueOf(i10));
        return (map == null || (list = (List) map.get(columnKey)) == null) ? new ArrayList() : list;
    }

    public final List<String> x(Boolean isIncludeAdult) {
        int i10;
        if (isIncludeAdult == null) {
            i10 = playMode;
        } else {
            i10 = isIncludeAdult.booleanValue() ? 1 : 0;
        }
        List<String> list = columnNames.get(Integer.valueOf(i10));
        return list == null ? new ArrayList() : list;
    }

    public final String y() {
        return columnAll;
    }

    public final List<ChannelStreamResponse> z() {
        return C(this, columnFavorites, 0, 2, null);
    }

    private a() {
    }

    private final int L(ChannelStreamResponse response) {
        return Objects.hash(response.getStreamId(), response.getRoute());
    }

    private final void X() {
        long jD = d1.d();
        Map<String, ConcurrentSkipListMap<Long, r8.p<Boolean, Set<String>>>> map = inSubscribedMap;
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, ConcurrentSkipListMap<Long, r8.p<Boolean, Set<String>>>> entry : map.entrySet()) {
            String key = entry.getKey();
            ConcurrentSkipListMap<Long, r8.p<Boolean, Set<String>>> value = entry.getValue();
            while (!value.isEmpty()) {
                Long lFirstKey = value.firstKey();
                if (lFirstKey.longValue() >= jD - 259200000) {
                    break;
                }
                lastInSubscribedChangeTime = jD;
                r8.p<Boolean, Set<String>> pVarRemove = value.remove(lFirstKey);
                if (x1.f1.lb.config.b.f20643a.t()) {
                    logger.debug("SubscribeIO remove expired epgId[{}] time[{}] subscribe[{}]", key, lFirstKey, pVarRemove);
                }
            }
            if (value.isEmpty()) {
                hashSet.add(entry.getKey());
            }
        }
        Iterator it = hashSet.iterator();
        kotlin.jvm.internal.m.e(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.m.e(next, "next(...)");
            String str = (String) next;
            map.remove(str);
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("SubscribeIO remove expired epgId[{}]", str);
            }
        }
    }

    private final void b0(String type, int key, int opType) {
        String streamId;
        Map<Integer, r8.p<String, Long>> map;
        ChannelStreamResponse channelStreamResponseT = t(key);
        if (channelStreamResponseT != null && (streamId = channelStreamResponseT.getStreamId()) != null) {
            if (kotlin.jvm.internal.m.a(type, "play_history")) {
                map = playHistoryMap;
            } else if (kotlin.jvm.internal.m.a(type, "favorites")) {
                map = favoritesMap;
            } else {
                return;
            }
            long jD = d1.d();
            synchronized (map) {
                try {
                    if (opType != 0) {
                        if (opType != 1) {
                            return;
                        } else {
                            map.put(Integer.valueOf(key), new r8.p<>(streamId, Long.valueOf(jD)));
                        }
                    } else {
                        map.remove(Integer.valueOf(key));
                    }
                    String strW = gson.w(map);
                    w0 w0Var = w0.f21452a;
                    kotlin.jvm.internal.m.c(strW);
                    w0Var.t(type, strW);
                    z zVar = z.f17874a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void O(boolean isRetryAfterFailure, boolean isForce) {
        N(d1.c(), isRetryAfterFailure, isForce);
    }

    public final boolean h0(int key) {
        boolean zJ = J(key);
        b0("favorites", key, !zJ ? 1 : 0);
        return !zJ;
    }
}
