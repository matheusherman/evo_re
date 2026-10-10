package t.v.c.i;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.p000lifecycle.Lifecycle;
import c9.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import nf.a0;
import r8.r;
import r8.u;
import r8.z;
import x1.f1.lb.media.c;
import x1.f1.lb.media.d;
import x1.f1.lb.media.model.SubscribeItem;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;
import z1.b1.lb.m.local.LocalSessionInfo;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bR\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u001e\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00050\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ¸\u0001\u0010%\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b%\u0010&J9\u0010*\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f¢\u0006\u0004\b*\u0010+J)\u0010,\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)¢\u0006\u0004\b,\u0010-J)\u0010.\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)¢\u0006\u0004\b.\u0010-J\u0015\u00101\u001a\u00020$2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J=\u00109\u001a\u00020$2\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u000f¢\u0006\u0004\b9\u0010:J\u001f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00120)2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b<\u0010=JO\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0)2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>2,\b\u0002\u0010B\u001a&\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010A\u0012\u0004\u0012\u00020$\u0018\u00010@¢\u0006\u0004\bD\u0010EJ1\u0010F\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)2\u0006\u0010\t\u001a\u00020\u000f¢\u0006\u0004\bF\u0010GJ\r\u0010H\u001a\u00020\u0012¢\u0006\u0004\bH\u0010IJ\r\u0010J\u001a\u00020\u0012¢\u0006\u0004\bJ\u0010IJ\r\u0010K\u001a\u00020\u0006¢\u0006\u0004\bK\u0010LJ,\u0010M\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)H\u0086@¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020\u000f¢\u0006\u0004\bO\u0010PJ4\u0010R\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)2\u0006\u0010Q\u001a\u00020\u000fH\u0086@¢\u0006\u0004\bR\u0010SJ\u0015\u0010T\u001a\u00020\u00122\u0006\u0010Q\u001a\u00020\u000f¢\u0006\u0004\bT\u0010UJF\u0010X\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)2\u0006\u0010V\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\b\b\u0002\u0010W\u001a\u00020\u000fH\u0086@¢\u0006\u0004\bX\u0010YJX\u0010\\\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)2\u0006\u0010V\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u000f2\b\b\u0002\u0010W\u001a\u00020\u000f2\b\b\u0002\u0010[\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\\\u0010]J<\u0010`\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)2\u0006\u0010^\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b`\u0010aJD\u0010d\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)2\u0006\u0010b\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020\u000fH\u0086@¢\u0006\u0004\bd\u0010YJ4\u0010e\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)2\u0006\u0010Q\u001a\u00020\u000fH\u0086@¢\u0006\u0004\be\u0010SJ\r\u0010f\u001a\u00020\u0012¢\u0006\u0004\bf\u0010IJ\r\u0010g\u001a\u00020\u0006¢\u0006\u0004\bg\u0010LJ\r\u0010h\u001a\u00020\u0007¢\u0006\u0004\bh\u0010iJ\r\u0010j\u001a\u00020\u0007¢\u0006\u0004\bj\u0010iJ\r\u0010k\u001a\u00020\u000f¢\u0006\u0004\bk\u0010PJ\r\u0010l\u001a\u00020\u0006¢\u0006\u0004\bl\u0010LJ\r\u0010m\u001a\u00020\u000f¢\u0006\u0004\bm\u0010PJ\r\u0010n\u001a\u00020\u000f¢\u0006\u0004\bn\u0010PJ\r\u0010o\u001a\u00020\u0012¢\u0006\u0004\bo\u0010IJ\r\u0010p\u001a\u00020\u000f¢\u0006\u0004\bp\u0010PJ\r\u0010q\u001a\u00020\u000f¢\u0006\u0004\bq\u0010PJ\u0015\u0010r\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u000f¢\u0006\u0004\br\u0010UJ\r\u0010s\u001a\u00020\u0012¢\u0006\u0004\bs\u0010IJ\u0015\u0010u\u001a\u00020\u00122\u0006\u0010t\u001a\u00020\u000f¢\u0006\u0004\bu\u0010UJ\u0015\u0010v\u001a\u00020$2\u0006\u0010t\u001a\u00020\u000f¢\u0006\u0004\bv\u0010wJI\u0010z\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00050)2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\u000f2\u0006\u0010x\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020\u000f¢\u0006\u0004\bz\u0010{J\r\u0010|\u001a\u00020\u000f¢\u0006\u0004\b|\u0010PJ\r\u0010}\u001a\u00020\u000f¢\u0006\u0004\b}\u0010PJ\r\u0010~\u001a\u00020\u000f¢\u0006\u0004\b~\u0010PJ\r\u0010\u007f\u001a\u00020\u0006¢\u0006\u0004\b\u007f\u0010LJ\u000f\u0010\u0080\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0080\u0001\u0010PJ\u000f\u0010\u0081\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0081\u0001\u0010PJ\u000f\u0010\u0082\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0082\u0001\u0010PJ\u000f\u0010\u0083\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0083\u0001\u0010PJ\u000f\u0010\u0084\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0084\u0001\u0010PJ\u000f\u0010\u0085\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0085\u0001\u0010PJ\u000f\u0010\u0086\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0086\u0001\u0010PJ\u000f\u0010\u0087\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u0087\u0001\u0010IJ\u000f\u0010\u0088\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u0088\u0001\u0010IJ\u000f\u0010\u0089\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u0089\u0001\u0010IJ\u000f\u0010\u008a\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u008a\u0001\u0010IJ\u000f\u0010\u008b\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u008b\u0001\u0010IJ#\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0012¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001a\u0010\u0090\u0001\u001a\u00020\u00122\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000f¢\u0006\u0005\b\u0090\u0001\u0010UJ\u000f\u0010\u0091\u0001\u001a\u00020\u000f¢\u0006\u0005\b\u0091\u0001\u0010PJ&\u0010\u0094\u0001\u001a\u00020$2\t\b\u0002\u0010\u0092\u0001\u001a\u00020\u00122\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u0012¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J1\u0010\u0097\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u00042\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0012¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u0017\u0010\u0099\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u0004¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J)\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u000f2\u000b\b\u0002\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u000f¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J(\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u009b\u0001\u001a\u00020\u000f2\u000b\b\u0002\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u000f¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0017\u0010¡\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u0004¢\u0006\u0006\b¡\u0001\u0010\u009a\u0001J\u0019\u0010£\u0001\u001a\u00020\u00122\u0007\u0010¢\u0001\u001a\u00020\u0006¢\u0006\u0006\b£\u0001\u0010¤\u0001J>\u0010©\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010¢\u0001\u001a\u00020\u00062\u0007\u0010¥\u0001\u001a\u00020\u00072\u0007\u0010¦\u0001\u001a\u00020\u000f2\f\b\u0002\u0010¨\u0001\u001a\u0005\u0018\u00010§\u0001H\u0086@¢\u0006\u0006\b©\u0001\u0010ª\u0001J7\u0010¬\u0001\u001a\u00020$2\u0007\u0010¢\u0001\u001a\u00020\u00062\u0007\u0010¥\u0001\u001a\u00020\u00072\u0007\u0010¦\u0001\u001a\u00020\u000f2\u0007\u0010«\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J7\u0010®\u0001\u001a\u00020$2\u0007\u0010¢\u0001\u001a\u00020\u00062\u0007\u0010¥\u0001\u001a\u00020\u00072\u0007\u0010¦\u0001\u001a\u00020\u000f2\u0007\u0010«\u0001\u001a\u00020\u000fH\u0086@¢\u0006\u0006\b®\u0001\u0010\u00ad\u0001J\u001b\u0010¯\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040)¢\u0006\u0005\b¯\u0001\u0010-J+\u0010°\u0001\u001a\u00020\u00122\u0007\u0010¢\u0001\u001a\u00020\u00062\u0007\u0010¥\u0001\u001a\u00020\u00072\u0007\u0010¦\u0001\u001a\u00020\u000f¢\u0006\u0006\b°\u0001\u0010±\u0001J\u000f\u0010²\u0001\u001a\u00020$¢\u0006\u0005\b²\u0001\u0010\u0003J\u000f\u0010³\u0001\u001a\u00020$¢\u0006\u0005\b³\u0001\u0010\u0003J\u000f\u0010´\u0001\u001a\u00020\u0012¢\u0006\u0005\b´\u0001\u0010IJ\u001f\u0010¶\u0001\u001a\u00020$2\r\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u001f\u0010¸\u0001\u001a\u00020$2\r\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0006\b¸\u0001\u0010·\u0001J\u0019\u0010¹\u0001\u001a\u00020\u00122\u0007\u0010¢\u0001\u001a\u00020\u0006¢\u0006\u0006\b¹\u0001\u0010¤\u0001J\u001a\u0010»\u0001\u001a\u00020\u000f2\b\u0010º\u0001\u001a\u00030\u0096\u0001¢\u0006\u0006\b»\u0001\u0010¼\u0001J\u001c\u0010½\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0007\u0010¢\u0001\u001a\u00020\u0006¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u001c\u0010¿\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0007\u0010¢\u0001\u001a\u00020\u0006¢\u0006\u0006\b¿\u0001\u0010¾\u0001J%\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u000b\b\u0002\u0010¦\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0005\bÀ\u0001\u0010SJ\u000f\u0010Á\u0001\u001a\u00020\u0012¢\u0006\u0005\bÁ\u0001\u0010IJ$\u0010Â\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040)2\u0007\u0010¦\u0001\u001a\u00020\u000f¢\u0006\u0005\bÂ\u0001\u0010GJ-\u0010Ä\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040)2\u0007\u0010¦\u0001\u001a\u00020\u000f2\u0007\u0010Ã\u0001\u001a\u00020\u000f¢\u0006\u0005\bÄ\u0001\u0010+J'\u0010Å\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010¦\u0001\u001a\u00020\u000f2\u0007\u0010¥\u0001\u001a\u00020\u0007H\u0086@¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J6\u0010È\u0001\u001a\u0013\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0Ç\u00012\u0007\u0010¦\u0001\u001a\u00020\u000f2\u0007\u0010¥\u0001\u001a\u00020\u0007H\u0086@¢\u0006\u0006\bÈ\u0001\u0010Æ\u0001J\"\u0010Ë\u0001\u001a\u00020\u000f2\u0007\u0010É\u0001\u001a\u00020\u000f2\u0007\u0010Ê\u0001\u001a\u00020\u000f¢\u0006\u0006\bË\u0001\u0010Ì\u0001¨\u0006Í\u0001"}, d2 = {"Lt/v/c/i/a;", "", "<init>", "()V", "", "Lr8/u;", "", "", "Lz1/b1/lb/m/meta/EPGProgramme;", TypedValues.TransitionType.S_FROM, "Lqf/a;", "d", "(Ljava/util/List;)Ljava/util/List;", "Landroid/content/Context;", "appContext", "", "env", "applicationId", "", "isDebug", "authEndPoint", "adEndPoint", "channelEndPoint", "feedbackEndPoint", "upgradeEndPoint", "messageEndPoint", "metricEndPoint", "streamMediaEndPoint", "loggerEndPoint", "imgEndPoint", "clientSecret", "serverPublicKeyPem", "sportsEndPoint", "historyName", "favoritesName", "allName", "Lr8/z;", "b0", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "username", "password", "Lkotlinx/coroutines/flow/f;", "y0", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "x0", "()Lkotlinx/coroutines/flow/f;", "z0", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "c0", "(Landroidx/appcompat/app/AppCompatActivity;)V", "context", "upgradePermissionDlgTitleTxtResId", "upgradePermissionDlgDescTxtResId", "upgradePermissionDlgBtnTxtResId", "logoDrawableResId", "apkFile", "E0", "(Landroid/content/Context;IIIILjava/lang/String;)V", "timeoutMs", "N0", "(Ljava/lang/Long;)Lkotlinx/coroutines/flow/f;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlin/Function4;", "Lnf/a0;", "onProgress", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "c", "(Landroidx/lifecycle/Lifecycle;Lc9/r;)Lkotlinx/coroutines/flow/f;", "A0", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "n0", "()Z", "o0", "M", "()I", "M0", "(Lv8/f;)Ljava/lang/Object;", "L", "()Ljava/lang/String;", "code", "w0", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "r0", "(Ljava/lang/String;)Z", "contact", "digitalCode", "v0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "verificationCode", "invitationCode", "s0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", NotificationCompat.CATEGORY_EMAIL, "actionType", "s", "(Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "region", "phone", "t", "B0", "l0", ExifInterface.GPS_DIRECTION_TRUE, "U", "()J", "I", "H", "R", "r", "Z", "f0", "i", "Y", "i0", "q0", "pin", "p0", "G0", "(Ljava/lang/String;)V", "newPassword", "captchaCode", "F0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "N", "O", "P", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "z", "y", "v", "x", "w", "F", "Q", "a0", "g", "h", "k0", "g0", "isIncludeAdult", "u", "(Ljava/lang/Boolean;)Ljava/util/List;", "column", "d0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isRetryAfterFailure", "isForce", "u0", "(ZZ)V", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "n", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/util/List;", "J", "()Ljava/util/List;", "streamId", "routeId", "p", "(Ljava/lang/String;Ljava/lang/String;)Lz1/b1/lb/m/meta/ChannelStreamResponse;", "l", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", ExifInterface.LATITUDE_SOUTH, "key", "L0", "(I)Z", "startTime", "epgId", "Lx1/f1/lb/media/model/SubscribeItem;", "subscribeItem", "J0", "(IJLjava/lang/String;Lx1/f1/lb/media/model/SubscribeItem;Lv8/f;)Ljava/lang/Object;", "sportId", "f", "(IJLjava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "e", "K", "h0", "(IJLjava/lang/String;)Z", "H0", "I0", "e0", "keys", "D0", "(Ljava/util/List;)V", "C0", "m0", "response", "b", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)Ljava/lang/String;", "j", "(I)Lz1/b1/lb/m/meta/ChannelStreamResponse;", "k", "B", "j0", "D", "yyyyMMdd", ExifInterface.LONGITUDE_EAST, "G", "(Ljava/lang/String;JLv8/f;)Ljava/lang/Object;", "Lr8/p;", "X", "metaId", "lang", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "tvcbaselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18646a = new a();

    /* JADX INFO: renamed from: t.v.c.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "t.v.c.i.InteractionUtils$getInRemindProgrammes$1", f = "InteractionUtils.kt", l = {832, 832}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lqf/a;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class C0364a extends l implements p<g<? super List<? extends qf.a>>, v8.f<? super z>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        C0364a(v8.f<? super C0364a> fVar) {
            super(2, fVar);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(g<? super List<? extends qf.a>> gVar, v8.f<? super z> fVar) {
            return invoke2((g<? super List<qf.a>>) gVar, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            C0364a c0364a = new C0364a(fVar);
            c0364a.L$0 = obj;
            return c0364a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(g<? super List<qf.a>> gVar, v8.f<? super z> fVar) {
            return ((C0364a) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
        
            if (r3.emit(r7, r6) == r0) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            a aVar;
            g gVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    aVar = (a) this.L$1;
                    gVar = (g) this.L$0;
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            g gVar2 = (g) this.L$0;
            aVar = a.f18646a;
            x1.f1.lb.media.a aVar2 = x1.f1.lb.media.a.f20755a;
            this.L$0 = gVar2;
            this.L$1 = aVar;
            this.label = 1;
            Object objA = aVar2.A(this);
            if (objA != objC) {
                gVar = gVar2;
                obj = objA;
            }
            return objC;
            List listD = aVar.d((List) obj);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "t.v.c.i.InteractionUtils$waitUserInit$1", f = "InteractionUtils.kt", l = {193, 194}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends l implements p<g<? super Boolean>, v8.f<? super z>, Object> {
        final /* synthetic */ Long $timeoutMs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Long l10, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$timeoutMs = l10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            b bVar = new b(this.$timeoutMs, fVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // c9.p
        public final Object invoke(g<? super Boolean> gVar, v8.f<? super z> fVar) {
            return ((b) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        
            if (r1.emit(r6, r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            g gVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    gVar = (g) this.L$0;
                    r.b(obj);
                }
                return z.f17874a;
            }
            r.b(obj);
            gVar = (g) this.L$0;
            x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
            Long l10 = this.$timeoutMs;
            this.L$0 = gVar;
            this.label = 1;
            obj = fVar.Q0(l10, this);
            if (obj != objC) {
            }
            return objC;
            Boolean boolA = kotlin.coroutines.jvm.internal.b.a(((Boolean) obj).booleanValue());
            this.L$0 = null;
            this.label = 2;
        }
    }

    public final Object b0(Context context, String str, String str2, boolean z10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, v8.f<? super z> fVar) {
        Object objR = x1.f1.lb.config.b.f20643a.r(context, str, str2, z10, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, fVar);
        return objR == kotlin.coroutines.intrinsics.b.c() ? objR : z.f17874a;
    }

    public static /* synthetic */ Object C(a aVar, String str, v8.f fVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "";
        }
        return aVar.B(str, fVar);
    }

    public static /* synthetic */ Object K0(a aVar, int i10, long j10, String str, SubscribeItem subscribeItem, v8.f fVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            subscribeItem = null;
        }
        return aVar.J0(i10, j10, str, subscribeItem, fVar);
    }

    public static /* synthetic */ kotlinx.coroutines.flow.f O0(a aVar, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = null;
        }
        return aVar.N0(l10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<qf.a> d(List<? extends u<Integer, Long, ? extends EPGProgramme>> from) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends u<Integer, Long, ? extends EPGProgramme>> it = from.iterator();
        while (it.hasNext()) {
            arrayList.add(new qf.a(it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ Integer m(a aVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return aVar.l(str, str2);
    }

    public static /* synthetic */ List o(a aVar, String str, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            bool = null;
        }
        return aVar.n(str, bool);
    }

    public static /* synthetic */ ChannelStreamResponse q(a aVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return aVar.p(str, str2);
    }

    public static /* synthetic */ Object t0(a aVar, String str, String str2, String str3, String str4, String str5, v8.f fVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str4 = "";
        }
        if ((i10 & 16) != 0) {
            str5 = "";
        }
        return aVar.s0(str, str2, str3, str4, str5, fVar);
    }

    public final String A() {
        return x1.f1.lb.media.a.f20755a.y();
    }

    public final kotlinx.coroutines.flow.f<u<Boolean, Integer, String>> A0(String from) {
        m.f(from, "from");
        return x1.f1.lb.user.f.f21202a.m1(from);
    }

    public final Object B(String str, v8.f<? super List<String>> fVar) {
        return c.f20788a.w(str, fVar);
    }

    public final Object B0(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return x1.f1.lb.user.f.f21202a.s1(str, fVar);
    }

    public final void C0(List<Integer> keys) {
        m.f(keys, "keys");
        x1.f1.lb.media.a.f20755a.Y(keys);
    }

    public final kotlinx.coroutines.flow.f<List<EPGProgramme>> D(String epgId) {
        m.f(epgId, "epgId");
        return c.f20788a.z(epgId);
    }

    public final void D0(List<Integer> keys) {
        m.f(keys, "keys");
        x1.f1.lb.media.a.f20755a.a0(keys);
    }

    public final kotlinx.coroutines.flow.f<List<EPGProgramme>> E(String epgId, String yyyyMMdd) {
        m.f(epgId, "epgId");
        m.f(yyyyMMdd, "yyyyMMdd");
        return c.f20788a.y(epgId, yyyyMMdd);
    }

    public final void E0(Context context, int upgradePermissionDlgTitleTxtResId, int upgradePermissionDlgDescTxtResId, int upgradePermissionDlgBtnTxtResId, int logoDrawableResId, String apkFile) {
        m.f(context, "context");
        m.f(apkFile, "apkFile");
        x1.f1.lb.heartbeat.f.f20678a.D0(context, upgradePermissionDlgTitleTxtResId, upgradePermissionDlgDescTxtResId, upgradePermissionDlgBtnTxtResId, logoDrawableResId, apkFile);
    }

    public final String F() {
        return x1.f1.lb.user.f.f21202a.k0();
    }

    public final kotlinx.coroutines.flow.f<u<Boolean, Integer, String>> F0(String username, String digitalCode, String newPassword, String captchaCode) {
        m.f(username, "username");
        m.f(digitalCode, "digitalCode");
        m.f(newPassword, "newPassword");
        m.f(captchaCode, "captchaCode");
        return x1.f1.lb.user.f.f21202a.u1(username, digitalCode, newPassword, captchaCode);
    }

    public final Object G(String str, long j10, v8.f<? super EPGProgramme> fVar) {
        return c.C(c.f20788a, str, j10, false, fVar, 4, null);
    }

    public final void G0(String pin) {
        m.f(pin, "pin");
        d.f20812a.x(pin);
    }

    public final String H() {
        return x1.f1.lb.user.f.f21202a.l0();
    }

    public final void H0() {
        x1.f1.lb.media.a.f20755a.d0();
    }

    public final long I() {
        return x1.f1.lb.user.f.f21202a.m0();
    }

    public final void I0() {
        x1.f1.lb.media.a.f20755a.e0();
    }

    public final List<ChannelStreamResponse> J() {
        return x1.f1.lb.media.a.f20755a.z();
    }

    public final Object J0(int i10, long j10, String str, SubscribeItem subscribeItem, v8.f<Object> fVar) {
        return x1.f1.lb.media.a.f20755a.g0(i10, j10, str, subscribeItem, fVar);
    }

    public final kotlinx.coroutines.flow.f<List<qf.a>> K() {
        return h.v(new C0364a(null));
    }

    public final String L() {
        String lastUsername;
        LocalSessionInfo localSessionInfoP0 = x1.f1.lb.user.f.f21202a.p0();
        return (localSessionInfoP0 == null || (lastUsername = localSessionInfoP0.getLastUsername()) == null) ? "" : lastUsername;
    }

    public final boolean L0(int key) {
        return x1.f1.lb.media.a.f20755a.h0(key);
    }

    public final int M() {
        return x1.f1.lb.user.f.f21202a.r0();
    }

    public final Object M0(v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return x1.f1.lb.user.f.f21202a.M1(fVar);
    }

    public final String N() {
        return x1.f1.lb.user.f.f21202a.t0();
    }

    public final kotlinx.coroutines.flow.f<Boolean> N0(Long timeoutMs) {
        return h.v(new b(timeoutMs, null));
    }

    public final String O() {
        return x1.f1.lb.user.f.f21202a.u0();
    }

    public final String Q() {
        return x1.f1.lb.user.f.f21202a.v0();
    }

    public final int R() {
        return x1.f1.lb.user.f.f21202a.w0();
    }

    public final List<ChannelStreamResponse> S() {
        return x1.f1.lb.media.a.f20755a.D();
    }

    public final int T() {
        return x1.f1.lb.heartbeat.f.f20678a.p0();
    }

    public final long U() {
        return x1.f1.lb.heartbeat.f.f20678a.q0();
    }

    public final int V() {
        return x1.f1.lb.heartbeat.f.f20678a.r0();
    }

    public final String W(String metaId, String lang) {
        m.f(metaId, "metaId");
        m.f(lang, "lang");
        return x1.f1.lb.streaming.client.a.f21004a.m(metaId, lang);
    }

    public final Object X(String str, long j10, v8.f<? super r8.p<? extends EPGProgramme, ? extends EPGProgramme>> fVar) {
        return c.f20788a.D(str, j10, fVar);
    }

    public final String Y() {
        return x1.f1.lb.user.f.f21202a.C0();
    }

    public final String Z() {
        return x1.f1.lb.user.f.f21202a.D0();
    }

    public final boolean a0() {
        return x1.f1.lb.user.f.f21202a.G0();
    }

    public final String b(ChannelStreamResponse response) {
        m.f(response, "response");
        return x1.f1.lb.media.a.f20755a.p(response);
    }

    public final kotlinx.coroutines.flow.f<UpgradeInfo> c(Lifecycle lifecycle, c9.r<? super String, ? super Integer, ? super String, ? super a0, z> onProgress) {
        return x1.f1.lb.heartbeat.f.f20678a.Y(lifecycle, onProgress);
    }

    public final void c0(AppCompatActivity activity) {
        m.f(activity, "activity");
        x1.f1.lb.heartbeat.f.f20678a.t0(activity);
    }

    public final boolean d0(String column) {
        return x1.f1.lb.media.a.f20755a.G(column);
    }

    public final Object e(int i10, long j10, String str, String str2, v8.f<? super z> fVar) {
        Object objO = x1.f1.lb.media.a.f20755a.o(i10, j10, str, str2, false, fVar);
        return objO == kotlin.coroutines.intrinsics.b.c() ? objO : z.f17874a;
    }

    public final boolean e0() {
        return x1.f1.lb.media.a.f20755a.H();
    }

    public final Object f(int i10, long j10, String str, String str2, v8.f<? super z> fVar) {
        Object objO = x1.f1.lb.media.a.f20755a.o(i10, j10, str, str2, true, fVar);
        return objO == kotlin.coroutines.intrinsics.b.c() ? objO : z.f17874a;
    }

    public final boolean f0() {
        return x1.f1.lb.user.f.f21202a.K0();
    }

    public final boolean g() {
        return x1.f1.lb.user.f.f21202a.d0();
    }

    public final boolean g0() {
        return x1.f1.lb.media.a.f20755a.K();
    }

    public final boolean h() {
        return x1.f1.lb.user.f.f21202a.e0();
    }

    public final boolean h0(int key, long startTime, String epgId) {
        m.f(epgId, "epgId");
        return x1.f1.lb.media.a.f20755a.I(key, startTime, epgId);
    }

    public final String i() {
        String strD0 = x1.f1.lb.user.f.f21202a.D0();
        return strD0.length() == 0 ? f18646a.L() : strD0;
    }

    public final boolean i0(String password) {
        m.f(password, "password");
        return x1.f1.lb.user.f.f21202a.L0(password);
    }

    public final ChannelStreamResponse j(int key) {
        return x1.f1.lb.media.a.f20755a.t(key);
    }

    public final boolean j0() {
        return c.f20788a.F();
    }

    public final ChannelStreamResponse k(int key) {
        return x1.f1.lb.media.a.f20755a.u(key);
    }

    public final boolean k0() {
        return x1.f1.lb.user.f.f21202a.M0();
    }

    public final Integer l(String streamId, String routeId) {
        m.f(streamId, "streamId");
        return x1.f1.lb.media.a.f20755a.v(streamId, routeId);
    }

    public final boolean l0() {
        return x1.f1.lb.user.f.f21202a.O0();
    }

    public final boolean m0(int key) {
        return x1.f1.lb.media.a.f20755a.J(key);
    }

    public final List<ChannelStreamResponse> n(String column, Boolean isIncludeAdult) {
        x1.f1.lb.media.a aVar = x1.f1.lb.media.a.f20755a;
        if (column == null) {
            column = A();
        }
        return aVar.w(column, isIncludeAdult);
    }

    public final boolean n0() {
        return x1.f1.lb.user.f.f21202a.P0();
    }

    public final boolean o0() {
        return x1.f1.lb.user.f.f21202a.T0();
    }

    public final ChannelStreamResponse p(String streamId, String routeId) {
        m.f(streamId, "streamId");
        x1.f1.lb.media.a aVar = x1.f1.lb.media.a.f20755a;
        Integer numV = aVar.v(streamId, routeId);
        if (numV != null) {
            return aVar.u(numV.intValue());
        }
        return null;
    }

    public final boolean p0(String pin) {
        m.f(pin, "pin");
        return m.a(d.f20812a.o(), pin);
    }

    public final boolean q0() {
        return d.f20812a.o().length() > 0;
    }

    public final String r() {
        return x1.f1.lb.user.f.f21202a.i0();
    }

    public final boolean r0(String code) {
        m.f(code, "code");
        return x1.f1.lb.user.f.f21202a.V0(code);
    }

    public final Object s(String str, String str2, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return x1.f1.lb.user.f.f21202a.E0(str, "", str2, fVar);
    }

    public final Object s0(String str, String str2, String str3, String str4, String str5, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return x1.f1.lb.user.f.f21202a.b1(str, str2, str3, str4, str5, fVar);
    }

    public final Object t(String str, String str2, String str3, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return x1.f1.lb.user.f.f21202a.E0(str2, str, str3, fVar);
    }

    public final List<String> u(Boolean isIncludeAdult) {
        return x1.f1.lb.media.a.f20755a.x(isIncludeAdult);
    }

    public final void u0(boolean isRetryAfterFailure, boolean isForce) {
        x1.f1.lb.media.a.f20755a.O(isRetryAfterFailure, isForce);
    }

    public final String v() {
        return x1.f1.lb.heartbeat.f.f20678a.c0();
    }

    public final Object v0(String str, String str2, String str3, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return x1.f1.lb.user.f.f21202a.d1(str, str3, str2, fVar);
    }

    public final String w() {
        return x1.f1.lb.heartbeat.f.f20678a.d0();
    }

    public final Object w0(String str, v8.f<? super kotlinx.coroutines.flow.f<u<Boolean, Integer, String>>> fVar) {
        return x1.f1.lb.user.f.f21202a.e1(str, fVar);
    }

    public final String x() {
        return x1.f1.lb.heartbeat.f.f20678a.e0();
    }

    public final kotlinx.coroutines.flow.f<u<Boolean, Integer, String>> x0() {
        return x1.f1.lb.user.f.g1(x1.f1.lb.user.f.f21202a, null, null, false, 7, null);
    }

    public final String y() {
        return x1.f1.lb.heartbeat.f.f20678a.f0();
    }

    public final kotlinx.coroutines.flow.f<u<Boolean, Integer, String>> y0(String username, String password) {
        m.f(username, "username");
        m.f(password, "password");
        return x1.f1.lb.user.f.g1(x1.f1.lb.user.f.f21202a, username, password, false, 4, null);
    }

    public final String z() {
        return x1.f1.lb.heartbeat.f.f20678a.g0();
    }

    public final kotlinx.coroutines.flow.f<u<Boolean, Integer, String>> z0() {
        return x1.f1.lb.user.f.f21202a.f1(null, null, true);
    }

    private a() {
    }

    public final String P() {
        String str;
        String strO = O();
        if (strO.length() == 0) {
            return "";
        }
        if (Z().length() == 0) {
            str = "1";
        } else {
            str = "2#plan";
        }
        return strO + "&c=" + str;
    }
}
