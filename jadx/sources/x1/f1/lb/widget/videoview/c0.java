package x1.f1.lb.widget.videoview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlinx.coroutines.a2;
import org.apache.log4j.spi.Configurator;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import x.l1.b2.R$string;
import x1.f1.lb.util.d1;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0004\n\u0002\b\u0006*\u0004\u0087\u0002\u008b\u0002\b&\u0018\u0000 \u008f\u00022\u00020\u0001:\u0004Ê\u0001Ó\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003Jb\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u001b\u0010 \u001a\u00020\u00172\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\rH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001eH\u0002¢\u0006\u0004\b'\u0010(J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010&\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\u0003J\u001f\u00100\u001a\u00020\u00142\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0017H\u0002¢\u0006\u0004\b3\u0010\u001aJ\u0018\u00104\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b4\u0010*J\u000f\u00105\u001a\u00020\u0017H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0004H\u0002¢\u0006\u0004\b7\u0010\u0003J\u0012\u00108\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b8\u00109JE\u0010A\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\u0018\b\u0002\u0010>\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010=\u0012\u0004\u0012\u00020\u0004\u0018\u00010<2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?H\u0002¢\u0006\u0004\bA\u0010BJ\u001e\u0010D\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0004\bD\u0010EJ&\u0010F\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u00062\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0014H\u0002¢\u0006\u0004\bH\u0010IJ\u001e\u0010L\u001a\u00020\u00042\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00060JH\u0082@¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0017H\u0002¢\u0006\u0004\bN\u00106J\u0017\u0010P\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\rH&¢\u0006\u0004\bP\u0010$J\u0017\u0010Q\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\rH&¢\u0006\u0004\bQ\u0010$J\u0011\u0010R\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\rH&¢\u0006\u0004\bT\u0010$J\u000f\u0010U\u001a\u00020\u0004H&¢\u0006\u0004\bU\u0010\u0003J\u0019\u0010W\u001a\u00020\u00042\b\u0010V\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\bW\u0010XJ\u0019\u0010Y\u001a\u00020\u00042\b\u0010V\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\bY\u0010XJ\u000f\u0010Z\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bZ\u0010SJ\r\u0010[\u001a\u00020\r¢\u0006\u0004\b[\u0010\\J\u0015\u0010^\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\r¢\u0006\u0004\b^\u0010$J\u0015\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010_¢\u0006\u0004\b`\u0010aJ\u0015\u0010c\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\r¢\u0006\u0004\bc\u0010$J\r\u0010d\u001a\u00020\r¢\u0006\u0004\bd\u0010\\J\r\u0010e\u001a\u00020\r¢\u0006\u0004\be\u0010\\J\u0015\u0010f\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0006¢\u0006\u0004\bf\u0010XJ\u001b\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010h\u001a\u00020g¢\u0006\u0004\bi\u0010jJ#\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010h\u001a\u00020g2\u0006\u0010l\u001a\u00020k¢\u0006\u0004\bm\u0010nJ\r\u0010o\u001a\u00020\u0014¢\u0006\u0004\bo\u0010pJ\r\u0010q\u001a\u00020\u0017¢\u0006\u0004\bq\u00106J\r\u0010r\u001a\u00020\u0017¢\u0006\u0004\br\u00106J/\u0010t\u001a\u00020\u00172\b\b\u0002\u0010/\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bt\u0010uJ\u0015\u0010w\u001a\u00020\u00042\u0006\u0010v\u001a\u00020\u0017¢\u0006\u0004\bw\u0010\u001aJ\u0017\u0010y\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u0017¢\u0006\u0004\by\u0010\u001aJ\u0015\u0010{\u001a\u00020\u00042\u0006\u0010z\u001a\u00020\r¢\u0006\u0004\b{\u0010$J\r\u0010|\u001a\u00020\u0017¢\u0006\u0004\b|\u00106J\r\u0010}\u001a\u00020\u0017¢\u0006\u0004\b}\u00106J\r\u0010~\u001a\u00020\u0017¢\u0006\u0004\b~\u00106J\r\u0010\u007f\u001a\u00020\u0017¢\u0006\u0004\b\u007f\u00106J\u0011\u0010\u0080\u0001\u001a\u00020\u0017H\u0016¢\u0006\u0005\b\u0080\u0001\u00106J\u000f\u0010\u0081\u0001\u001a\u00020\u0014¢\u0006\u0005\b\u0081\u0001\u0010pJ\u000f\u0010\u0082\u0001\u001a\u00020\u0014¢\u0006\u0005\b\u0082\u0001\u0010pJ\u000f\u0010\u0083\u0001\u001a\u00020\r¢\u0006\u0005\b\u0083\u0001\u0010\\J\u0010\u0010\u0084\u0001\u001a\u00020\u0006¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0010\u0010\u0086\u0001\u001a\u00020\u0006¢\u0006\u0006\b\u0086\u0001\u0010\u0085\u0001J\u0012\u0010\u0087\u0001\u001a\u0004\u0018\u00010\b¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0017\u0010\u0089\u0001\u001a\u00020\u00042\u0006\u0010s\u001a\u00020\u0014¢\u0006\u0005\b\u0089\u0001\u0010IJ\u001a\u0010\u008c\u0001\u001a\u00020\u00042\b\u0010\u008b\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001a\u0010\u0090\u0001\u001a\u00020\u00042\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u001a\u0010\u0094\u0001\u001a\u00020\u00042\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0013\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0092\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u001a\u0010\u009a\u0001\u001a\u00020\u00042\b\u0010\u0099\u0001\u001a\u00030\u0098\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u001a\u0010\u009e\u0001\u001a\u00020\u00042\b\u0010\u009d\u0001\u001a\u00030\u009c\u0001¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001a\u0010¢\u0001\u001a\f\u0012\u0005\u0012\u00030¡\u0001\u0018\u00010 \u0001¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001e\u0010¦\u0001\u001a\u00020\u00042\n\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0007¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u001e\u0010¦\u0001\u001a\u00020\u00042\n\u0010¥\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0007¢\u0006\u0006\b¦\u0001\u0010©\u0001J\u001e\u0010¦\u0001\u001a\u00020\u00042\n\u0010¥\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0007¢\u0006\u0006\b¦\u0001\u0010«\u0001J,\u0010®\u0001\u001a\u00020\u00042\u001a\u0010\u00ad\u0001\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040¬\u0001¢\u0006\u0006\b®\u0001\u0010¯\u0001J,\u0010°\u0001\u001a\u00020\u00042\u001a\u0010\u00ad\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040¬\u0001¢\u0006\u0006\b°\u0001\u0010¯\u0001J \u0010²\u0001\u001a\u00020\u00042\u000e\u0010\u00ad\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040±\u0001¢\u0006\u0006\b²\u0001\u0010³\u0001J\u000f\u0010´\u0001\u001a\u00020\u0017¢\u0006\u0005\b´\u0001\u00106J\u0086\u0001\u0010È\u0001\u001a\u00020\u00042\b\u0010¶\u0001\u001a\u00030µ\u00012\b\u0010¸\u0001\u001a\u00030·\u00012\b\u0010º\u0001\u001a\u00030¹\u00012\b\u0010¼\u0001\u001a\u00030»\u00012\n\u0010¾\u0001\u001a\u0005\u0018\u00010½\u00012\b\u0010À\u0001\u001a\u00030¿\u00012\b\u0010Á\u0001\u001a\u00030¿\u00012\b\u0010Ã\u0001\u001a\u00030Â\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Â\u00012\n\u0010Å\u0001\u001a\u0005\u0018\u00010¿\u00012\n\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u0001¢\u0006\u0006\bÈ\u0001\u0010É\u0001R\u0017\u0010Ì\u0001\u001a\u00020\u00148\u0002X\u0082D¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R!\u0010Ð\u0001\u001a\r Î\u0001*\u0005\u0018\u00010Í\u00010Í\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bv\u0010Ï\u0001R\u001a\u0010º\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001a\u0010¸\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001a\u0010¼\u0001\u001a\u00030»\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u001a\u0010Ù\u0001\u001a\u00030µ\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u001b\u0010Ü\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R!\u0010ß\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u001a\u0010ã\u0001\u001a\u00030à\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010â\u0001R\u001b\u0010æ\u0001\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R\u001b\u0010è\u0001\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010å\u0001R\u001a\u0010ì\u0001\u001a\u00030é\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010î\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0001\u0010ò\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010ô\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010ö\u0001R\u001a\u0010ú\u0001\u001a\u00030÷\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R\u001a\u0010ü\u0001\u001a\u00030à\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010â\u0001R\u0018\u0010þ\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bý\u0001\u0010%R.\u0010\u0081\u0002\u001a\u0017\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0080\u0002R.\u0010\u0083\u0002\u001a\u0017\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0002\u0010\u0080\u0002R\"\u0010\u0086\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0002\u0010\u0085\u0002R\u0018\u0010\u008a\u0002\u001a\u00030\u0087\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0002\u0010\u0089\u0002R\u0018\u0010\u008e\u0002\u001a\u00030\u008b\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u008d\u0002¨\u0006\u0090\u0002"}, d2 = {"Lx1/f1/lb/widget/videoview/c0;", "Lx1/f1/lb/metric/monitor/c;", "<init>", "()V", "Lr8/z;", "j0", "", "videoName", "Lv6/c;", "playType", "playPositionKey", "mediaId", "routeId", "", "mediaMode", "playerArgs", "Lx1/f1/lb/widget/videoview/c0$d;", "flowCreator", "subtitleMediaId", "Lkotlinx/coroutines/flow/f;", "", "B1", "(Ljava/lang/String;Lv6/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lx1/f1/lb/widget/videoview/c0$d;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "", "isForce", "b0", "(Z)V", "f0", "H0", "E0", "Lx1/f1/lb/widget/videoview/f;", "playContext", "k0", "(Lx1/f1/lb/widget/videoview/f;)Z", "reason", "X", "(I)V", "Z", "ctx", "Z0", "(Lx1/f1/lb/widget/videoview/f;)V", "C1", "(Lx1/f1/lb/widget/videoview/f;Lv8/f;)Ljava/lang/Object;", "b1", "J1", "Lx1/f1/lb/widget/videoview/h;", "playSession", TypedValues.TransitionType.S_FROM, "A1", "(Lx1/f1/lb/widget/videoview/h;Ljava/lang/String;)J", "isOn", "U0", "K1", "T0", "()Z", ExifInterface.GPS_DIRECTION_TRUE, "q0", "(Lv8/f;)Ljava/lang/Object;", "lang", "subtitleUrl", "Lkotlin/Function1;", "", "onFailure", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "mediaPlayer", "W0", "(Ljava/lang/String;Ljava/lang/String;Lc9/l;Ltv/danmaku/ijk/media/player/IMediaPlayer;)V", "session", "w0", "(Ljava/lang/Long;Lv8/f;)Ljava/lang/Object;", "y0", "(Ljava/lang/String;Ljava/lang/Long;Lv8/f;)Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "(J)V", "", "list", "t1", "(Ljava/util/List;Lv8/f;)Ljava/lang/Object;", "i0", "visibility", "g1", "k1", "r0", "()Ljava/lang/Integer;", "v1", "y1", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "z1", "(Ljava/lang/String;)V", "x1", "n0", "m0", "()I", "aspectRatioType", "f1", "", "z0", "()Ljava/util/List;", "sizeInSp", "s1", "D0", "B0", "r1", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "G1", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)Lkotlinx/coroutines/flow/f;", "Lz1/b1/lb/m/meta/EPGProgramme;", "programme", "H1", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;Lz1/b1/lb/m/meta/EPGProgramme;)Lkotlinx/coroutines/flow/f;", "v0", "()J", "a1", "D1", "position", "c1", "(Ljava/lang/String;Lx1/f1/lb/widget/videoview/f;Ljava/lang/Long;)Z", "b", "w1", "isTerminate", "I1", "resId", "h0", "S0", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Q0", "R0", "u0", "p0", "o0", "x0", "()Ljava/lang/String;", "C0", "t0", "()Lv6/c;", "e1", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "onInfoListener", "n1", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "onPreparedListener", "o1", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "onCompletionListener", "l1", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;)V", "s0", "()Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "onErrorListener", "m1", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;)V", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "onSeekCompleteListener", "p1", "(Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;)V", "", "Ltv/danmaku/ijk/media/player/misc/ITrackInfo;", "A0", "()[Ltv/danmaku/ijk/media/player/misc/ITrackInfo;", "Lnf/q;", NotificationCompat.CATEGORY_EVENT, "OnEvent", "(Lnf/q;)V", "Lnf/j;", "(Lnf/j;)V", "Lnf/k;", "(Lnf/k;)V", "Lkotlin/Function2;", "listener", "j1", "(Lc9/p;)V", "h1", "Lkotlin/Function0;", "q1", "(Lc9/a;)V", "u1", "Landroid/content/Context;", "context", "Lx1/f1/lb/widget/videoview/a;", "playerView", "Lx1/f1/lb/widget/videoview/z0;", "videoViewHandler", "Lyf/a;", "subtitleViewHandler", "Landroid/view/ViewTreeObserver;", "viewTreeObserver", "Landroidx/appcompat/widget/AppCompatTextView;", "tipTextView", "loadingTxtView", "Landroidx/appcompat/widget/AppCompatImageView;", "loadingImageView", "trialBgImg", "trialText", "Landroid/graphics/drawable/Drawable;", "trialDrawable", "J0", "(Landroid/content/Context;Lx1/f1/lb/widget/videoview/a;Lx1/f1/lb/widget/videoview/z0;Lyf/a;Landroid/view/ViewTreeObserver;Landroidx/appcompat/widget/AppCompatTextView;Landroidx/appcompat/widget/AppCompatTextView;Landroidx/appcompat/widget/AppCompatImageView;Landroidx/appcompat/widget/AppCompatImageView;Landroidx/appcompat/widget/AppCompatTextView;Landroid/graphics/drawable/Drawable;)V", "a", "J", "invalidSession", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "c", "Lx1/f1/lb/widget/videoview/z0;", "d", "Lx1/f1/lb/widget/videoview/a;", "e", "Lyf/a;", "f", "Landroid/content/Context;", "mContext", "g", "Ljava/lang/String;", "subtitleLang", "h", "Ljava/util/List;", "subtitles", "Ljava/util/concurrent/atomic/AtomicBoolean;", "i", "Ljava/util/concurrent/atomic/AtomicBoolean;", "setSubtitlesFlag", "j", "Lx1/f1/lb/widget/videoview/f;", "playingContext", "k", "lastPlayContext", "Lkotlinx/coroutines/sync/a;", "l", "Lkotlinx/coroutines/sync/a;", "mutex", "m", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "n", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "o", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "p", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "q", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnSeekCompleteListener;", "Ljava/util/concurrent/atomic/AtomicLong;", "r", "Ljava/util/concurrent/atomic/AtomicLong;", "lastStartPlayTime", "s", "isPlayerInStarting", "t", "isPause", "u", "Lc9/p;", "loadingListener", "v", "noSignalListener", "w", "Lc9/a;", "playCompleteListener", "x1/f1/lb/widget/videoview/c0$q", "x", "Lx1/f1/lb/widget/videoview/c0$q;", "playTimeAccumulator", "x1/f1/lb/widget/videoview/c0$p", "y", "Lx1/f1/lb/widget/videoview/c0$p;", "mainLooperHandler", "z", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class c0 implements x1.f1.lb.metric.monitor.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long invalidSession;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private z0 videoViewHandler;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a playerView;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private yf.a subtitleViewHandler;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String subtitleLang;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private List<String> subtitles;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.widget.videoview.f playingContext;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.widget.videoview.f lastPlayContext;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnPreparedListener onPreparedListener;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnErrorListener onErrorListener;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnCompletionListener onCompletionListener;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnInfoListener onInfoListener;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean isPause;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private c9.p<? super Boolean, ? super String, r8.z> loadingListener;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private c9.p<? super Integer, ? super String, r8.z> noSignalListener;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private c9.a<r8.z> playCompleteListener;
    private static boolean A = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(getClass());

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean setSubtitlesFlag = new AtomicBoolean(false);

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private kotlinx.coroutines.sync.a mutex = kotlinx.coroutines.sync.c.b(false, 1, null);

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private AtomicLong lastStartPlayTime = new AtomicLong(0);

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isPlayerInStarting = new AtomicBoolean(false);

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final q playTimeAccumulator = new q();

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final p mainLooperHandler = new p(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$start$8", f = "PlayerViewHandler.kt", l = {1128}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class a0 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super Long>, v8.f<? super r8.z>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        a0(v8.f<? super a0> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            a0 a0Var = new a0(fVar);
            a0Var.L$0 = obj;
            return a0Var;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, v8.f<? super r8.z> fVar) {
            return ((a0) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
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
                Long lC = kotlin.coroutines.jvm.internal.b.c(-1L);
                this.label = 1;
                if (gVar.emit(lC, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$OnEvent$1", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ nf.q $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(nf.q qVar, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$event = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new b(this.$event, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                if (c0.this.t0() == v6.c.VOD) {
                    z0 z0Var = c0.this.videoViewHandler;
                    if (z0Var == null) {
                        kotlin.jvm.internal.m.v("videoViewHandler");
                        z0Var = null;
                    }
                    if (z0Var.getMIsCompleted()) {
                        return r8.z.f17874a;
                    }
                }
                if (this.$event.d() == -1) {
                    c0.this.logger.a("receive stop play event@" + this.$event.hashCode() + " from[" + this.$event.e() + "] " + this.$event.f() + ", " + this.$event.d() + ", " + this.$event.c(), new Object[0]);
                    c0.this.I1(true);
                } else if (this.$event.d() == 8 || this.$event.d() == 10 || this.$event.d() == 9 || this.$event.d() == 1 || this.$event.d() == 3 || this.$event.d() == 2) {
                    c0.this.logger.a("receive restart play event@" + this.$event.hashCode() + " from[" + this.$event.e() + "] " + this.$event.f() + ", " + this.$event.d() + ", " + this.$event.c(), new Object[0]);
                    c0.this.j0();
                } else {
                    c0.this.mainLooperHandler.removeMessages(this.$event.d());
                    Message messageObtainMessage = c0.this.mainLooperHandler.obtainMessage(this.$event.d(), kotlin.coroutines.jvm.internal.b.c(this.$event.f()));
                    kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
                    kotlin.coroutines.jvm.internal.b.a(c0.this.mainLooperHandler.sendMessageDelayed(messageObtainMessage, 2000L));
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$start$9", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b0 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ nf.r $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b0(nf.r rVar, v8.f<? super b0> fVar) {
            super(2, fVar);
            this.$event = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new b0(this.$event, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b0) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            z0 z0Var;
            String playerArgs;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                z0 z0Var2 = c0.this.videoViewHandler;
                if (z0Var2 == null) {
                    kotlin.jvm.internal.m.v("videoViewHandler");
                    z0Var = null;
                } else {
                    z0Var = z0Var2;
                }
                String strH = this.$event.h();
                kotlin.jvm.internal.m.e(strH, "getVideoName(...)");
                String url = this.$event.getUrl();
                x1.f1.lb.widget.videoview.f fVar = c0.this.playingContext;
                if (fVar != null) {
                    playerArgs = fVar.getPlayerArgs();
                } else {
                    playerArgs = null;
                }
                v6.c cVarF = this.$event.f();
                kotlin.jvm.internal.m.e(cVarF, "getPlayType(...)");
                if (z0Var.F2(strH, url, playerArgs, cVarF, this.$event.g())) {
                    c0.V0(c0.this, false, 1, null);
                    if (this.$event.f() == v6.c.LIVE) {
                        x1.f1.lb.util.a1.h(x1.f1.lb.util.a1.f21305a, this.$event.g(), this.$event.c() + ".set_video_path", false, 4, null);
                    }
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$OnEvent$2$1", f = "PlayerViewHandler.kt", l = {740}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ AtomicLong $it;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AtomicLong atomicLong, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$it = atomicLong;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new c(this.$it, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                x1.f1.lb.widget.videoview.i iVar = x1.f1.lb.widget.videoview.i.f21588a;
                long j10 = this.$it.get();
                this.label = 1;
                if (iVar.d(j10, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.widget.videoview.c0$c0, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$startPlay$2", f = "PlayerViewHandler.kt", l = {334, 341}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class C0468c0 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super Long>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ ChannelStreamResponse $response;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.widget.videoview.c0$c0$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<Long> f21518a;

            /* JADX WARN: Multi-variable type inference failed */
            a(kotlinx.coroutines.flow.g<? super Long> gVar) {
                this.f21518a = gVar;
            }

            public final Object b(long j10, v8.f<? super r8.z> fVar) {
                Object objEmit = this.f21518a.emit(kotlin.coroutines.jvm.internal.b.c(j10), fVar);
                return objEmit == kotlin.coroutines.intrinsics.b.c() ? objEmit : r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).longValue(), fVar);
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.widget.videoview.c0$c0$b */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"x1/f1/lb/widget/videoview/c0$c0$b", "Lx1/f1/lb/widget/videoview/c0$d;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "force", "Lkotlinx/coroutines/flow/f;", "Lnf/r;", "a", "(Ljava/util/concurrent/atomic/AtomicBoolean;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class b implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ChannelStreamResponse f21519a;

            b(ChannelStreamResponse channelStreamResponse) {
                this.f21519a = channelStreamResponse;
            }

            @Override // x1.f1.lb.widget.videoview.c0.d
            public Object a(AtomicBoolean atomicBoolean, v8.f<? super kotlinx.coroutines.flow.f<? extends nf.r>> fVar) {
                return x1.f1.lb.streaming.a.f20960a.t(this.f21519a, atomicBoolean, fVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0468c0(ChannelStreamResponse channelStreamResponse, v8.f<? super C0468c0> fVar) {
            super(2, fVar);
            this.$response = channelStreamResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            C0468c0 c0468c0 = c0.this.new C0468c0(this.$response, fVar);
            c0468c0.L$0 = obj;
            return c0468c0;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, v8.f<? super r8.z> fVar) {
            return ((C0468c0) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0091, code lost:
        
            if (((kotlinx.coroutines.flow.f) r0).collect(r1, r16) == r13) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            Object objE1;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    kotlinx.coroutines.flow.g gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                    gVar = gVar2;
                    objE1 = obj;
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            gVar = (kotlinx.coroutines.flow.g) this.L$0;
            b bVar = new b(this.$response);
            c0.this.isPause = false;
            c0 c0Var = c0.this;
            String streamName = this.$response.getStreamName();
            kotlin.jvm.internal.m.e(streamName, "getStreamName(...)");
            v6.c cVar = v6.c.LIVE;
            String streamId = this.$response.getStreamId();
            kotlin.jvm.internal.m.e(streamId, "getStreamId(...)");
            String route = this.$response.getRoute();
            kotlin.jvm.internal.m.e(route, "getRoute(...)");
            int type = this.$response.getType();
            String playerArgs = this.$response.getPlayerArgs();
            this.L$0 = gVar;
            this.label = 1;
            objE1 = c0.E1(c0Var, streamName, cVar, "", streamId, route, type, playerArgs, bVar, null, this, 256, null);
            if (objE1 != objC) {
            }
            return objC;
            a aVar = new a(gVar);
            this.L$0 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lx1/f1/lb/widget/videoview/c0$d;", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "force", "Lkotlinx/coroutines/flow/f;", "Lnf/r;", "a", "(Ljava/util/concurrent/atomic/AtomicBoolean;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface d {
        Object a(AtomicBoolean atomicBoolean, v8.f<? super kotlinx.coroutines.flow.f<? extends nf.r>> fVar);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$startPlay$3", f = "PlayerViewHandler.kt", l = {372, 392, 399}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class d0 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super Long>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ EPGProgramme $programme;
        final /* synthetic */ ChannelStreamResponse $response;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ c0 this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$startPlay$3$1", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ int $reason;
            int label;
            final /* synthetic */ c0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(c0 c0Var, int i10, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = c0Var;
                this.$reason = i10;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, this.$reason, fVar);
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
                    Context context = this.this$0.mContext;
                    if (context == null) {
                        kotlin.jvm.internal.m.v("mContext");
                        context = null;
                    }
                    String string = context.getString(R$string.no_stream_notice_message_no_free);
                    kotlin.jvm.internal.m.e(string, "getString(...)");
                    c9.p pVar = this.this$0.noSignalListener;
                    if (pVar != null) {
                        pVar.invoke(kotlin.coroutines.jvm.internal.b.b(this.$reason), string);
                    }
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<Long> f21520a;

            /* JADX WARN: Multi-variable type inference failed */
            b(kotlinx.coroutines.flow.g<? super Long> gVar) {
                this.f21520a = gVar;
            }

            public final Object b(long j10, v8.f<? super r8.z> fVar) {
                Object objEmit = this.f21520a.emit(kotlin.coroutines.jvm.internal.b.c(j10), fVar);
                return objEmit == kotlin.coroutines.intrinsics.b.c() ? objEmit : r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).longValue(), fVar);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"x1/f1/lb/widget/videoview/c0$d0$c", "Lx1/f1/lb/widget/videoview/c0$d;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "force", "Lkotlinx/coroutines/flow/f;", "Lnf/r;", "a", "(Ljava/util/concurrent/atomic/AtomicBoolean;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class c implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ChannelStreamResponse f21521a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f21522b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ EPGProgramme f21523c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f21524d;

            c(ChannelStreamResponse channelStreamResponse, String str, EPGProgramme ePGProgramme, int i10) {
                this.f21521a = channelStreamResponse;
                this.f21522b = str;
                this.f21523c = ePGProgramme;
                this.f21524d = i10;
            }

            @Override // x1.f1.lb.widget.videoview.c0.d
            public Object a(AtomicBoolean atomicBoolean, v8.f<? super kotlinx.coroutines.flow.f<? extends nf.r>> fVar) {
                return x1.f1.lb.streaming.a.f20960a.s(this.f21521a, this.f21522b, this.f21523c.getStart(), this.f21523c.getStop(), this.f21524d, atomicBoolean, fVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d0(ChannelStreamResponse channelStreamResponse, EPGProgramme ePGProgramme, c0 c0Var, v8.f<? super d0> fVar) {
            super(2, fVar);
            this.$response = channelStreamResponse;
            this.$programme = ePGProgramme;
            this.this$0 = c0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            d0 d0Var = new d0(this.$response, this.$programme, this.this$0, fVar);
            d0Var.L$0 = obj;
            return d0Var;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, v8.f<? super r8.z> fVar) {
            return ((d0) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0179, code lost:
        
            if (((kotlinx.coroutines.flow.f) r0).collect(r2, r21) == r13) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0227, code lost:
        
            if (r0.emit(r0, r21) == r13) goto L38;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Exception {
            Object objE1;
            kotlinx.coroutines.flow.g gVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                    return r8.z.f17874a;
                }
                if (i10 == 2) {
                    kotlinx.coroutines.flow.g gVar2 = (kotlinx.coroutines.flow.g) this.L$0;
                    r8.r.b(obj);
                    gVar = gVar2;
                    objE1 = obj;
                    b bVar = new b(gVar);
                    this.L$0 = null;
                    this.label = 3;
                } else {
                    if (i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            kotlinx.coroutines.flow.g gVar3 = (kotlinx.coroutines.flow.g) this.L$0;
            String str = this.$response.getStreamName() + "/" + this.$programme.getTitle();
            String str2 = this.$programme.getChannel() + "." + this.$programme.getStart();
            long j10 = 1000;
            long start = this.$programme.getStart() / j10;
            long stop = (this.$programme.getStop() - this.$programme.getStart()) / j10;
            if (stop <= 0) {
                throw new Exception("catchup duration <0");
            }
            String str3 = this.$response.getCatchupRoute() + "#" + this.$response.getStreamId() + "#" + start + "#" + stop;
            long jD = d1.d() + (this.$programme.getStop() - this.$programme.getStart());
            x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
            if (!fVar.K0() || fVar.m0() < jD) {
                xe.c cVarC = xe.c.c();
                v6.c cVar = v6.c.CATCHUP;
                cVarC.o(new nf.x(str, cVar, kotlin.coroutines.jvm.internal.b.c(0L)));
                if (fVar.K0()) {
                    this.this$0.logger.a("[" + cVar + "][" + str + "][" + str3 + "] start, but not enough time left [" + fVar.m0() + " < " + jD + "]", new Object[0]);
                } else {
                    this.this$0.logger.a("[" + cVar + "][" + str + "][" + str3 + "] start, but guest", new Object[0]);
                }
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.this$0, 1, null), 3, null);
                this.this$0.I1(true);
                Long lC = kotlin.coroutines.jvm.internal.b.c(0L);
                this.label = 1;
            } else {
                q6.b bVar2 = this.this$0.logger;
                v6.c cVar2 = v6.c.CATCHUP;
                bVar2.a("[" + cVar2 + "][" + str + "][" + str3 + "] start", new Object[0]);
                int i11 = this.$response.c() ? 3 : 2;
                c cVar3 = new c(this.$response, str3, this.$programme, i11);
                this.this$0.isPause = false;
                c0 c0Var = this.this$0;
                String route = this.$response.getRoute();
                kotlin.jvm.internal.m.e(route, "getRoute(...)");
                String playerArgs = this.$response.getPlayerArgs();
                this.L$0 = gVar3;
                this.label = 2;
                objE1 = c0.E1(c0Var, str, cVar2, str2, str3, route, i11, playerArgs, cVar3, null, this, 256, null);
                if (objE1 != objC) {
                    gVar = gVar3;
                    b bVar3 = new b(gVar);
                    this.L$0 = null;
                    this.label = 3;
                }
            }
            return objC;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$checkSubtitles$1", f = "PlayerViewHandler.kt", l = {1547, 1551, 1563, 1573}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ long $session;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$checkSubtitles$1$1", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Boolean>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ long $begin;
            final /* synthetic */ String $lang;
            final /* synthetic */ long $session;
            final /* synthetic */ String $url;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ c0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(long j10, c0 c0Var, long j11, String str, String str2, v8.f<? super a> fVar) {
                super(3, fVar);
                this.$begin = j10;
                this.this$0 = c0Var;
                this.$session = j11;
                this.$lang = str;
                this.$url = str2;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.$begin, this.this$0, this.$session, this.$lang, this.$url, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                String str;
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    long jC = d1.c() - this.$begin;
                    q6.b bVar = this.this$0.logger;
                    long j10 = this.$session;
                    String strC0 = this.this$0.C0();
                    String str2 = this.$lang;
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        str = " [" + this.$url + "] ";
                    } else {
                        str = " ";
                    }
                    bVar.error("check subtitles[" + j10 + "/" + strC0 + "/" + str2 + "]" + str + "failure[" + jC + " ms]", th);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f21525a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c0 f21526b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f21527c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f21528d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f21529e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ List<String> f21530f;

            b(long j10, c0 c0Var, long j11, String str, String str2, List<String> list) {
                this.f21525a = j10;
                this.f21526b = c0Var;
                this.f21527c = j11;
                this.f21528d = str;
                this.f21529e = str2;
                this.f21530f = list;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Boolean) obj).booleanValue(), fVar);
            }

            public final Object b(boolean z10, v8.f<? super r8.z> fVar) {
                String str;
                String str2;
                long jC = d1.c() - this.f21525a;
                q6.b bVar = this.f21526b.logger;
                long j10 = this.f21527c;
                String strC0 = this.f21526b.C0();
                String str3 = this.f21528d;
                if (x1.f1.lb.config.b.f20643a.t()) {
                    str = " [" + this.f21529e + "] ";
                } else {
                    str = " ";
                }
                if (z10) {
                    str2 = "exits";
                } else {
                    str2 = "not exists";
                }
                bVar.a("check subtitles[" + j10 + "/" + strC0 + "/" + str3 + "]" + str + str2 + "[" + jC + " ms]", new Object[0]);
                if (z10) {
                    this.f21530f.add(this.f21528d);
                }
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j10, v8.f<? super e> fVar) {
            super(2, fVar);
            this.$session = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new e(this.$session, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x006f  */
        /* JADX WARN: Code duplicated, block: B:23:0x008d A[PHI: r2 r6 r8 r9
          0x008d: PHI (r2v3 java.lang.String) = (r2v12 java.lang.String), (r2v14 java.lang.String) binds: [B:21:0x0089, B:12:0x0034] A[DONT_GENERATE, DONT_INLINE]
          0x008d: PHI (r6v4 java.util.Iterator<java.lang.String>) = (r6v5 java.util.Iterator<java.lang.String>), (r6v8 java.util.Iterator<java.lang.String>) binds: [B:21:0x0089, B:12:0x0034] A[DONT_GENERATE, DONT_INLINE]
          0x008d: PHI (r8v2 java.util.List) = (r8v3 java.util.List), (r8v6 java.util.List) binds: [B:21:0x0089, B:12:0x0034] A[DONT_GENERATE, DONT_INLINE]
          0x008d: PHI (r9v0 java.lang.Object) = (r9v4 java.lang.Object), (r9v5 java.lang.Object) binds: [B:21:0x0089, B:12:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:25:0x0096  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0130 -> B:35:0x0133). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0138 -> B:35:0x0133). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 385
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.widget.videoview.c0.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$stop$1", f = "PlayerViewHandler.kt", l = {533}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e0 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ boolean $isTerminate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e0(boolean z10, v8.f<? super e0> fVar) {
            super(2, fVar);
            this.$isTerminate = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new e0(this.$isTerminate, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((e0) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            yf.a aVar = null;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    c0.this.J1();
                    z0 z0Var = c0.this.videoViewHandler;
                    if (z0Var == null) {
                        kotlin.jvm.internal.m.v("videoViewHandler");
                        z0Var = null;
                    }
                    long jN2 = z0Var.N2(this.$isTerminate);
                    x1.f1.lb.widget.videoview.i iVar = x1.f1.lb.widget.videoview.i.f21588a;
                    this.label = 1;
                    obj = iVar.d(jN2, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                yf.a aVar2 = c0.this.subtitleViewHandler;
                if (aVar2 == null) {
                    kotlin.jvm.internal.m.v("subtitleViewHandler");
                } else {
                    aVar = aVar2;
                }
                aVar.destroy();
                c0.this.U0(false);
            } catch (Throwable th) {
                c0.this.logger.warn("stop player failure", th);
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$displayNoSignalTip$2", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        f(v8.f<? super f> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new f(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                c0.this.y1();
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler", f = "PlayerViewHandler.kt", l = {1197, 1215}, m = "verifyPlaySessionAndStart")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class f0 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        f0(v8.f<? super f0> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c0.this.K1(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$ensureSession$1", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ int $resId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i10, v8.f<? super g> fVar) {
            super(2, fVar);
            this.$resId = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new g(this.$resId, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((g) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                c0.this.h0(this.$resId);
                c0.this.I1(true);
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler", f = "PlayerViewHandler.kt", l = {1489}, m = "getMediaId")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class h extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        h(v8.f<? super h> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c0.this.q0(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler", f = "PlayerViewHandler.kt", l = {1527}, m = "getSubtitleCdnUrl")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class i extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        i(v8.f<? super i> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c0.this.w0(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler", f = "PlayerViewHandler.kt", l = {1531}, m = "getSubtitleUrl")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class j extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        j(v8.f<? super j> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c0.this.y0(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001e"}, d2 = {"x1/f1/lb/widget/videoview/c0$k", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "sizeInDp", "c", "(I)I", "Landroid/view/View;", "view", "widthInDp", "heightInDp", "Lr8/z;", "b", "(Landroid/view/View;II)V", "Landroidx/appcompat/widget/AppCompatTextView;", "txtView", "txtSizeInDp", "a", "(Landroidx/appcompat/widget/AppCompatTextView;I)V", "", "onPreDraw", "()Z", "I", "getVideoViewHeight", "()I", "setVideoViewHeight", "(I)V", "videoViewHeight", "getScreenHeight", "setScreenHeight", "screenHeight", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int videoViewHeight;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int screenHeight;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z0 f21533c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f21534d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f21535e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AppCompatTextView f21536f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AppCompatTextView f21537g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ AppCompatImageView f21538h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ AppCompatImageView f21539i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ AppCompatTextView f21540j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ c0 f21541k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Drawable f21542l;

        k(z0 z0Var, a aVar, Context context, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView3, c0 c0Var, Drawable drawable) {
            this.f21533c = z0Var;
            this.f21534d = aVar;
            this.f21535e = context;
            this.f21536f = appCompatTextView;
            this.f21537g = appCompatTextView2;
            this.f21538h = appCompatImageView;
            this.f21539i = appCompatImageView2;
            this.f21540j = appCompatTextView3;
            this.f21541k = c0Var;
            this.f21542l = drawable;
        }

        private final void a(AppCompatTextView txtView, int txtSizeInDp) {
            if (txtView != null && this.videoViewHeight > 0) {
                txtView.setTextSize(0, c(txtSizeInDp));
            }
        }

        private final void b(View view, int widthInDp, int heightInDp) {
            AppCompatImageView appCompatImageView;
            if (view != null && this.videoViewHeight > 0) {
                int iC = c(widthInDp);
                int iC2 = c(heightInDp);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = iC;
                layoutParams.height = iC2;
                view.setLayoutParams(layoutParams);
                Drawable drawable = this.f21542l;
                if (drawable == null || (appCompatImageView = this.f21539i) == null) {
                    return;
                }
                appCompatImageView.setImageDrawable(drawable);
            }
        }

        private final int c(int sizeInDp) {
            if (this.screenHeight <= 0) {
                this.screenHeight = 1080;
            }
            return (int) x1.f1.lb.util.n.n().e(this.f21535e, (this.videoViewHeight * sizeInDp) / this.screenHeight);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a aVar = this.f21534d;
            Context context = this.f21535e;
            AppCompatTextView appCompatTextView = this.f21536f;
            AppCompatTextView appCompatTextView2 = this.f21537g;
            View view = this.f21538h;
            View view2 = this.f21539i;
            AppCompatTextView appCompatTextView3 = this.f21540j;
            c0 c0Var = this.f21541k;
            int iA = aVar.a();
            if (iA <= 0) {
                return true;
            }
            x1.f1.lb.util.x0 x0Var = x1.f1.lb.util.x0.f21457a;
            int iM = x0Var.m(context);
            this.screenHeight = iM;
            if (iM <= 0 || this.videoViewHeight == iA) {
                return true;
            }
            this.videoViewHeight = iA;
            a(appCompatTextView, 20);
            a(appCompatTextView2, 20);
            b(view, 80, 80);
            int iE = (int) (((double) h9.f.e(this.screenHeight, x0Var.n(context))) / (x1.f1.lb.config.b.f20643a.w() ? 8.0d : 3.5d));
            int i10 = (iE * 90) / 118;
            b(view2, iE, iE);
            b(appCompatTextView3, i10, i10);
            a(appCompatTextView3, (iE * 13) / 118);
            c0Var.T();
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$init$2$1", f = "PlayerViewHandler.kt", l = {1330, 1341}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class l extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ IMediaPlayer $mp;
        final /* synthetic */ a $playerView;
        long J$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(a aVar, IMediaPlayer iMediaPlayer, v8.f<? super l> fVar) {
            super(2, fVar);
            this.$playerView = aVar;
            this.$mp = iMediaPlayer;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new l(this.$playerView, this.$mp, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((l) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0068  */
        /* JADX WARN: Code duplicated, block: B:23:0x007f  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
        
            if (r10 == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            x1.f1.lb.util.a1 a1Var;
            long jV0;
            Object objQ0;
            x1.f1.lb.util.a1 a1Var2;
            long j10;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        long j11 = this.J$0;
                        x1.f1.lb.util.a1 a1Var3 = (x1.f1.lb.util.a1) this.L$0;
                        r8.r.b(obj);
                        a1Var2 = a1Var3;
                        j10 = j11;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                }
                x1.f1.lb.util.a1.h(a1Var2, j10, obj + ".player_prepared", false, 4, null);
                c0.this.T();
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            if (c0.this.t0() == v6.c.VOD) {
                c0 c0Var = c0.this;
                this.label = 1;
                obj = c0Var.q0(this);
            } else {
                if (c0.this.t0() == v6.c.LIVE) {
                    a1Var = x1.f1.lb.util.a1.f21305a;
                    jV0 = c0.this.v0();
                    c0 c0Var2 = c0.this;
                    this.L$0 = a1Var;
                    this.J$0 = jV0;
                    this.label = 2;
                    objQ0 = c0Var2.q0(this);
                    if (objQ0 != objC) {
                        a1Var2 = a1Var;
                        obj = objQ0;
                        j10 = jV0;
                        x1.f1.lb.util.a1.h(a1Var2, j10, obj + ".player_prepared", false, 4, null);
                    }
                }
                c0.this.T();
                return r8.z.f17874a;
            }
            return objC;
            String str = (String) obj;
            if (str != null) {
                c0 c0Var3 = c0.this;
                a aVar = this.$playerView;
                IMediaPlayer iMediaPlayer = this.$mp;
                String strX0 = c0Var3.x0();
                c0Var3.W0(strX0, aVar.c(str, strX0), null, iMediaPlayer);
                c0Var3.s1(x1.f1.lb.media.d.f20812a.r());
            }
            if (c0.this.t0() == v6.c.LIVE) {
                a1Var = x1.f1.lb.util.a1.f21305a;
                jV0 = c0.this.v0();
                c0 c0Var4 = c0.this;
                this.L$0 = a1Var;
                this.J$0 = jV0;
                this.label = 2;
                objQ0 = c0Var4.q0(this);
                if (objQ0 != objC) {
                    a1Var2 = a1Var;
                    obj = objQ0;
                    j10 = jV0;
                    x1.f1.lb.util.a1.h(a1Var2, j10, obj + ".player_prepared", false, 4, null);
                }
                return objC;
            }
            c0.this.T();
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$init$7$1", f = "PlayerViewHandler.kt", l = {1403}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class m extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $errorMsg;
        long J$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(String str, v8.f<? super m> fVar) {
            super(2, fVar);
            this.$errorMsg = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new m(this.$errorMsg, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((m) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            x1.f1.lb.util.a1 a1Var;
            long j10;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    j10 = this.J$0;
                    a1Var = (x1.f1.lb.util.a1) this.L$0;
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                a1Var = x1.f1.lb.util.a1.f21305a;
                long jV0 = c0.this.v0();
                c0 c0Var = c0.this;
                this.L$0 = a1Var;
                this.J$0 = jV0;
                this.label = 1;
                obj = c0Var.q0(this);
                if (obj == objC) {
                    return objC;
                }
                j10 = jV0;
            }
            a1Var.e(j10, obj + ".player_error[" + this.$errorMsg + "]", true);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$keepScreenOn$1", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class n extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ boolean $isOn;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(boolean z10, v8.f<? super n> fVar) {
            super(2, fVar);
            this.$isOn = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new n(this.$isOn, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((n) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                try {
                    x1.f1.lb.util.c cVar = x1.f1.lb.util.c.f21341a;
                    Context context = c0.this.mContext;
                    if (context == null) {
                        kotlin.jvm.internal.m.v("mContext");
                        context = null;
                    }
                    Activity activityI = cVar.i(context);
                    if (activityI != null) {
                        if (this.$isOn) {
                            activityI.getWindow().addFlags(128);
                        } else {
                            activityI.getWindow().clearFlags(128);
                        }
                    }
                } catch (Throwable th) {
                    c0.this.logger.error("keep screen on failure[" + this.$isOn + "]", th);
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$loadSubtitle$1$1$1", f = "PlayerViewHandler.kt", l = {1515}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class o extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $lang;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(String str, v8.f<? super o> fVar) {
            super(2, fVar);
            this.$lang = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new o(this.$lang, fVar);
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
                c0 c0Var = c0.this;
                List listR = kotlin.collections.r.r(this.$lang);
                this.label = 1;
                if (c0Var.t1(listR, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/c0$p", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p extends Handler {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$mainLooperHandler$1$handleMessage$1", f = "PlayerViewHandler.kt", l = {191, 195, 196, 199, 209, 216, 218}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ x1.f1.lb.widget.videoview.f $ctx;
            final /* synthetic */ int $eventCode;
            final /* synthetic */ long $session;
            int label;
            final /* synthetic */ c0 this$0;

            /* JADX INFO: renamed from: x1.f1.lb.widget.videoview.c0$p$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$mainLooperHandler$1$handleMessage$1$1", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0469a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Long>, Throwable, v8.f<? super r8.z>, Object> {
                final /* synthetic */ x1.f1.lb.widget.videoview.f $ctx;
                final /* synthetic */ long $session;
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ c0 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0469a(c0 c0Var, long j10, x1.f1.lb.widget.videoview.f fVar, v8.f<? super C0469a> fVar2) {
                    super(3, fVar2);
                    this.this$0 = c0Var;
                    this.$session = j10;
                    this.$ctx = fVar;
                }

                @Override // c9.q
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                    C0469a c0469a = new C0469a(this.this$0, this.$session, this.$ctx, fVar);
                    c0469a.L$0 = th;
                    return c0469a.invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        Throwable th = (Throwable) this.L$0;
                        this.this$0.logger.error("remove[" + this.$session + "] & restart play failure[" + this.$ctx.getSession() + "][" + this.$ctx.getPlayType() + "][" + this.$ctx.getVideoName() + "][" + this.$ctx.getMediaId() + "]", th);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class b<T> implements kotlinx.coroutines.flow.g {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ c0 f21544a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ long f21545b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ x1.f1.lb.widget.videoview.f f21546c;

                b(c0 c0Var, long j10, x1.f1.lb.widget.videoview.f fVar) {
                    this.f21544a = c0Var;
                    this.f21545b = j10;
                    this.f21546c = fVar;
                }

                public final Object b(long j10, v8.f<? super r8.z> fVar) {
                    this.f21544a.logger.a("remove[" + this.f21545b + "] & restart play complete[" + this.f21546c.getSession() + "][" + this.f21546c.getPlayType() + "][" + this.f21546c.getVideoName() + "][" + this.f21546c.getMediaId() + "]", new Object[0]);
                    return r8.z.f17874a;
                }

                @Override // kotlinx.coroutines.flow.g
                public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                    return b(((Number) obj).longValue(), fVar);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$mainLooperHandler$1$handleMessage$1$3", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
            static final class c extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Long>, Throwable, v8.f<? super r8.z>, Object> {
                final /* synthetic */ x1.f1.lb.widget.videoview.f $ctx;
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ c0 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(c0 c0Var, x1.f1.lb.widget.videoview.f fVar, v8.f<? super c> fVar2) {
                    super(3, fVar2);
                    this.this$0 = c0Var;
                    this.$ctx = fVar;
                }

                @Override // c9.q
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                    c cVar = new c(this.this$0, this.$ctx, fVar);
                    cVar.L$0 = th;
                    return cVar.invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        Throwable th = (Throwable) this.L$0;
                        this.this$0.logger.error("force restart play failure[" + this.$ctx.getSession() + "][" + this.$ctx.getPlayType() + "][" + this.$ctx.getVideoName() + "][" + this.$ctx.getMediaId() + "]", th);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class d<T> implements kotlinx.coroutines.flow.g {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ c0 f21547a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ x1.f1.lb.widget.videoview.f f21548b;

                d(c0 c0Var, x1.f1.lb.widget.videoview.f fVar) {
                    this.f21547a = c0Var;
                    this.f21548b = fVar;
                }

                public final Object b(long j10, v8.f<? super r8.z> fVar) {
                    this.f21547a.logger.a("force restart play complete[" + this.f21548b.getSession() + "][" + this.f21548b.getPlayType() + "][" + this.f21548b.getVideoName() + "][" + this.f21548b.getMediaId() + "]", new Object[0]);
                    return r8.z.f17874a;
                }

                @Override // kotlinx.coroutines.flow.g
                public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                    return b(((Number) obj).longValue(), fVar);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(x1.f1.lb.widget.videoview.f fVar, c0 c0Var, long j10, int i10, v8.f<? super a> fVar2) {
                super(2, fVar2);
                this.$ctx = fVar;
                this.this$0 = c0Var;
                this.$session = j10;
                this.$eventCode = i10;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$ctx, this.this$0, this.$session, this.$eventCode, fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
            }

            /* JADX WARN: Code duplicated, block: B:29:0x00da  */
            /* JADX WARN: Code duplicated, block: B:32:0x00e9  */
            /* JADX WARN: Code duplicated, block: B:35:0x00fc  */
            /* JADX WARN: Code duplicated, block: B:38:0x0144 A[PHI: r13 r15
              0x0144: PHI (r13v1 x1.f1.lb.widget.videoview.c0$p$a) = (r13v0 x1.f1.lb.widget.videoview.c0$p$a), (r13v2 x1.f1.lb.widget.videoview.c0$p$a) binds: [B:36:0x0141, B:9:0x0023] A[DONT_GENERATE, DONT_INLINE]
              0x0144: PHI (r15v28 java.lang.Object) = (r15v27 java.lang.Object), (r15v0 java.lang.Object) binds: [B:36:0x0141, B:9:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x00d3, code lost:
            
                if (r15.collect(r1, r14) == r0) goto L15;
             */
            /* JADX WARN: Code restructure failed: missing block: B:39:0x0168, code lost:
            
                if (r15.collect(r1, r14) == r0) goto L40;
             */
            @Override // kotlin.coroutines.jvm.internal.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) throws Throwable {
                boolean zBooleanValue;
                x1.f1.lb.widget.videoview.i iVar;
                long j10;
                x1.f1.lb.widget.videoview.i iVar2;
                long session;
                a aVar;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                switch (this.label) {
                    case 0:
                        r8.r.b(obj);
                        x1.f1.lb.streaming.client.a aVar2 = x1.f1.lb.streaming.client.a.f21004a;
                        v6.c playType = this.$ctx.getPlayType();
                        this.label = 1;
                        obj = aVar2.n(playType, this);
                        if (obj != objC) {
                            zBooleanValue = ((Boolean) obj).booleanValue();
                            this.this$0.logger.a("restart play event with " + zBooleanValue + ", " + this.$ctx.getSession() + ", " + this.$session + ", " + this.$eventCode, new Object[0]);
                            if (!zBooleanValue && this.$ctx.getSession() == this.$session) {
                                this.$ctx.getForceToStart().set(true);
                                c0 c0Var = this.this$0;
                                x1.f1.lb.widget.videoview.f fVar = this.$ctx;
                                this.label = 6;
                                obj = c0Var.C1(fVar, this);
                                if (obj != objC) {
                                    kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new c(this.this$0, this.$ctx, null));
                                    d dVar = new d(this.this$0, this.$ctx);
                                    this.label = 7;
                                }
                            } else {
                                iVar = x1.f1.lb.widget.videoview.i.f21588a;
                                j10 = this.$session;
                                this.label = 2;
                                if (iVar.d(j10, this) != objC) {
                                    iVar2 = x1.f1.lb.widget.videoview.i.f21588a;
                                    session = this.$ctx.getSession();
                                    this.label = 3;
                                    if (iVar2.d(session, this) == objC) {
                                        this.this$0.playingContext = null;
                                        c0 c0Var2 = this.this$0;
                                        String videoName = this.$ctx.getVideoName();
                                        v6.c playType2 = this.$ctx.getPlayType();
                                        String playPositionPersistenceKey = this.$ctx.getPlayPositionPersistenceKey();
                                        String mediaId = this.$ctx.getMediaId();
                                        String routeId = this.$ctx.getRouteId();
                                        int mediaMode = this.$ctx.getMediaMode();
                                        String playerArgs = this.$ctx.getPlayerArgs();
                                        d flowCreator = this.$ctx.getFlowCreator();
                                        String subtitleMediaId = this.$ctx.getSubtitleMediaId();
                                        this.label = 4;
                                        aVar = this;
                                        obj = c0Var2.B1(videoName, playType2, playPositionPersistenceKey, mediaId, routeId, mediaMode, playerArgs, flowCreator, subtitleMediaId, aVar);
                                        if (obj != objC) {
                                            kotlinx.coroutines.flow.f fVarF2 = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new C0469a(aVar.this$0, aVar.$session, aVar.$ctx, null));
                                            b bVar = new b(aVar.this$0, aVar.$session, aVar.$ctx);
                                            aVar.label = 5;
                                        }
                                        break;
                                    }
                                    return objC;
                                }
                            }
                            break;
                        }
                        return objC;
                    case 1:
                        r8.r.b(obj);
                        zBooleanValue = ((Boolean) obj).booleanValue();
                        this.this$0.logger.a("restart play event with " + zBooleanValue + ", " + this.$ctx.getSession() + ", " + this.$session + ", " + this.$eventCode, new Object[0]);
                        if (!zBooleanValue) {
                            iVar = x1.f1.lb.widget.videoview.i.f21588a;
                            j10 = this.$session;
                            this.label = 2;
                            if (iVar.d(j10, this) != objC) {
                                iVar2 = x1.f1.lb.widget.videoview.i.f21588a;
                                session = this.$ctx.getSession();
                                this.label = 3;
                                if (iVar2.d(session, this) == objC) {
                                    this.this$0.playingContext = null;
                                    c0 c0Var3 = this.this$0;
                                    String videoName2 = this.$ctx.getVideoName();
                                    v6.c playType3 = this.$ctx.getPlayType();
                                    String playPositionPersistenceKey2 = this.$ctx.getPlayPositionPersistenceKey();
                                    String mediaId2 = this.$ctx.getMediaId();
                                    String routeId2 = this.$ctx.getRouteId();
                                    int mediaMode2 = this.$ctx.getMediaMode();
                                    String playerArgs2 = this.$ctx.getPlayerArgs();
                                    d flowCreator2 = this.$ctx.getFlowCreator();
                                    String subtitleMediaId2 = this.$ctx.getSubtitleMediaId();
                                    this.label = 4;
                                    aVar = this;
                                    obj = c0Var3.B1(videoName2, playType3, playPositionPersistenceKey2, mediaId2, routeId2, mediaMode2, playerArgs2, flowCreator2, subtitleMediaId2, aVar);
                                    if (obj != objC) {
                                        kotlinx.coroutines.flow.f fVarF3 = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new C0469a(aVar.this$0, aVar.$session, aVar.$ctx, null));
                                        b bVar2 = new b(aVar.this$0, aVar.$session, aVar.$ctx);
                                        aVar.label = 5;
                                    }
                                    break;
                                }
                                return objC;
                            }
                        } else {
                            iVar = x1.f1.lb.widget.videoview.i.f21588a;
                            j10 = this.$session;
                            this.label = 2;
                            if (iVar.d(j10, this) != objC) {
                                iVar2 = x1.f1.lb.widget.videoview.i.f21588a;
                                session = this.$ctx.getSession();
                                this.label = 3;
                                if (iVar2.d(session, this) == objC) {
                                    this.this$0.playingContext = null;
                                    c0 c0Var4 = this.this$0;
                                    String videoName3 = this.$ctx.getVideoName();
                                    v6.c playType4 = this.$ctx.getPlayType();
                                    String playPositionPersistenceKey3 = this.$ctx.getPlayPositionPersistenceKey();
                                    String mediaId3 = this.$ctx.getMediaId();
                                    String routeId3 = this.$ctx.getRouteId();
                                    int mediaMode3 = this.$ctx.getMediaMode();
                                    String playerArgs3 = this.$ctx.getPlayerArgs();
                                    d flowCreator3 = this.$ctx.getFlowCreator();
                                    String subtitleMediaId3 = this.$ctx.getSubtitleMediaId();
                                    this.label = 4;
                                    aVar = this;
                                    obj = c0Var4.B1(videoName3, playType4, playPositionPersistenceKey3, mediaId3, routeId3, mediaMode3, playerArgs3, flowCreator3, subtitleMediaId3, aVar);
                                    if (obj != objC) {
                                        kotlinx.coroutines.flow.f fVarF4 = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new C0469a(aVar.this$0, aVar.$session, aVar.$ctx, null));
                                        b bVar3 = new b(aVar.this$0, aVar.$session, aVar.$ctx);
                                        aVar.label = 5;
                                    }
                                    break;
                                }
                                return objC;
                            }
                        }
                        return objC;
                    case 2:
                        r8.r.b(obj);
                        iVar2 = x1.f1.lb.widget.videoview.i.f21588a;
                        session = this.$ctx.getSession();
                        this.label = 3;
                        if (iVar2.d(session, this) == objC) {
                            this.this$0.playingContext = null;
                            c0 c0Var5 = this.this$0;
                            String videoName4 = this.$ctx.getVideoName();
                            v6.c playType5 = this.$ctx.getPlayType();
                            String playPositionPersistenceKey4 = this.$ctx.getPlayPositionPersistenceKey();
                            String mediaId4 = this.$ctx.getMediaId();
                            String routeId4 = this.$ctx.getRouteId();
                            int mediaMode4 = this.$ctx.getMediaMode();
                            String playerArgs4 = this.$ctx.getPlayerArgs();
                            d flowCreator4 = this.$ctx.getFlowCreator();
                            String subtitleMediaId4 = this.$ctx.getSubtitleMediaId();
                            this.label = 4;
                            aVar = this;
                            obj = c0Var5.B1(videoName4, playType5, playPositionPersistenceKey4, mediaId4, routeId4, mediaMode4, playerArgs4, flowCreator4, subtitleMediaId4, aVar);
                            if (obj != objC) {
                                kotlinx.coroutines.flow.f fVarF5 = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new C0469a(aVar.this$0, aVar.$session, aVar.$ctx, null));
                                b bVar4 = new b(aVar.this$0, aVar.$session, aVar.$ctx);
                                aVar.label = 5;
                            }
                            break;
                        }
                        return objC;
                    case 3:
                        r8.r.b(obj);
                        this.this$0.playingContext = null;
                        c0 c0Var6 = this.this$0;
                        String videoName5 = this.$ctx.getVideoName();
                        v6.c playType6 = this.$ctx.getPlayType();
                        String playPositionPersistenceKey5 = this.$ctx.getPlayPositionPersistenceKey();
                        String mediaId5 = this.$ctx.getMediaId();
                        String routeId5 = this.$ctx.getRouteId();
                        int mediaMode5 = this.$ctx.getMediaMode();
                        String playerArgs5 = this.$ctx.getPlayerArgs();
                        d flowCreator5 = this.$ctx.getFlowCreator();
                        String subtitleMediaId5 = this.$ctx.getSubtitleMediaId();
                        this.label = 4;
                        aVar = this;
                        obj = c0Var6.B1(videoName5, playType6, playPositionPersistenceKey5, mediaId5, routeId5, mediaMode5, playerArgs5, flowCreator5, subtitleMediaId5, aVar);
                        if (obj != objC) {
                            kotlinx.coroutines.flow.f fVarF6 = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new C0469a(aVar.this$0, aVar.$session, aVar.$ctx, null));
                            b bVar5 = new b(aVar.this$0, aVar.$session, aVar.$ctx);
                            aVar.label = 5;
                            break;
                        }
                        return objC;
                    case 4:
                        r8.r.b(obj);
                        aVar = this;
                        kotlinx.coroutines.flow.f fVarF7 = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new C0469a(aVar.this$0, aVar.$session, aVar.$ctx, null));
                        b bVar6 = new b(aVar.this$0, aVar.$session, aVar.$ctx);
                        aVar.label = 5;
                        break;
                    case 5:
                        r8.r.b(obj);
                        return r8.z.f17874a;
                    case 6:
                        r8.r.b(obj);
                        kotlinx.coroutines.flow.f fVarF8 = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new c(this.this$0, this.$ctx, null));
                        d dVar2 = new d(this.this$0, this.$ctx);
                        this.label = 7;
                        break;
                    case 7:
                        r8.r.b(obj);
                        return r8.z.f17874a;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }

        p(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            super.handleMessage(msg);
            int i10 = msg.what;
            Object obj = msg.obj;
            kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj).longValue();
            z0 z0Var = c0.this.videoViewHandler;
            z0 z0Var2 = null;
            if (z0Var == null) {
                kotlin.jvm.internal.m.v("videoViewHandler");
                z0Var = null;
            }
            if (z0Var.getMSession().get() != jLongValue) {
                return;
            }
            z0 z0Var3 = c0.this.videoViewHandler;
            if (z0Var3 == null) {
                kotlin.jvm.internal.m.v("videoViewHandler");
            } else {
                z0Var2 = z0Var3;
            }
            if (z0Var2.getMIsCompleted()) {
                return;
            }
            x1.f1.lb.metric.monitor.f.f20907a.o(i10);
            if (c0.d1(c0.this, null, null, null, 7, null)) {
                return;
            }
            x1.f1.lb.widget.videoview.f fVar = c0.this.playingContext;
            if (fVar != null) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new a(fVar, c0.this, jLongValue, i10, null), 3, null);
                return;
            }
            c0.this.logger.error("restart player failure " + jLongValue + ", with null play context", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0006X\u0086D¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"x1/f1/lb/widget/videoview/c0$q", "Ljava/lang/Runnable;", "Lr8/z;", "run", "()V", "", "a", "J", "getInterval", "()J", "interval", "b", "getPlayTimeSum", "setPlayTimeSum", "(J)V", "playTimeSum", "", "c", "Ljava/lang/String;", "getLastMediaId", "()Ljava/lang/String;", "setLastMediaId", "(Ljava/lang/String;)V", "lastMediaId", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long interval = 3000;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long playTimeSum;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String lastMediaId;

        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long jF;
            if (c0.this.i0()) {
                try {
                    boolean zR0 = c0.this.R0();
                    z0 z0Var = null;
                    if (!c0.this.isPause) {
                        z0 z0Var2 = c0.this.videoViewHandler;
                        if (z0Var2 == null) {
                            kotlin.jvm.internal.m.v("videoViewHandler");
                            z0Var2 = null;
                        }
                        if (z0Var2.getMIsPaused()) {
                            z0 z0Var3 = c0.this.videoViewHandler;
                            if (z0Var3 == null) {
                                kotlin.jvm.internal.m.v("videoViewHandler");
                                z0Var3 = null;
                            }
                            z0Var3.H2();
                        }
                        x1.f1.lb.widget.videoview.f fVar = c0.this.playingContext;
                        if (fVar != null) {
                            if (zR0) {
                                c0.V0(c0.this, false, 1, null);
                                c0.this.H0();
                            }
                            if (c0.this.u1() && zR0 && !fVar.getIsFree() && !x1.f1.lb.heartbeat.f.f20678a.w0()) {
                                String mediaId = fVar.getMediaId();
                                if (kotlin.jvm.internal.m.a(this.lastMediaId, mediaId)) {
                                    jF = this.playTimeSum;
                                } else {
                                    this.lastMediaId = mediaId;
                                    jF = x1.f1.lb.media.e.f20835a.f(mediaId);
                                }
                                long j10 = jF + this.interval;
                                this.playTimeSum = j10;
                                if (j10 > x1.f1.lb.user.f.f21202a.n0()) {
                                    c0.this.Z0(fVar);
                                } else {
                                    x1.f1.lb.media.e.f20835a.d(mediaId, this.interval);
                                }
                            }
                        }
                    } else if (zR0) {
                        z0 z0Var4 = c0.this.videoViewHandler;
                        if (z0Var4 == null) {
                            kotlin.jvm.internal.m.v("videoViewHandler");
                        } else {
                            z0Var = z0Var4;
                        }
                        z0Var.U1("1");
                    }
                } finally {
                    c0.this.mainLooperHandler.postDelayed(this, this.interval);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$restart$1", f = "PlayerViewHandler.kt", l = {466, 469, 476, 488, 491}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class r extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ CountDownLatch $latch;
        final /* synthetic */ x1.f1.lb.widget.videoview.f $playCtx;
        final /* synthetic */ Long $position;
        final /* synthetic */ AtomicBoolean $ret;
        int label;
        final /* synthetic */ c0 this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$restart$1$1", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Long>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ x1.f1.lb.widget.videoview.f $playCtx;
            final /* synthetic */ AtomicBoolean $ret;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ c0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(c0 c0Var, x1.f1.lb.widget.videoview.f fVar, AtomicBoolean atomicBoolean, v8.f<? super a> fVar2) {
                super(3, fVar2);
                this.this$0 = c0Var;
                this.$playCtx = fVar;
                this.$ret = atomicBoolean;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, this.$playCtx, this.$ret, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    this.this$0.logger.error("restart play failure " + this.$playCtx.getMediaId() + "(" + this.$playCtx.getVideoName() + "), " + th.getMessage(), new Object[0]);
                    this.$ret.set(false);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f21553a;

            b(AtomicBoolean atomicBoolean) {
                this.f21553a = atomicBoolean;
            }

            public final Object b(long j10, v8.f<? super r8.z> fVar) {
                this.f21553a.set(true);
                return r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).longValue(), fVar);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$restart$1$3", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class c extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Long>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ x1.f1.lb.widget.videoview.f $playCtx;
            final /* synthetic */ AtomicBoolean $ret;
            int label;
            final /* synthetic */ c0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(c0 c0Var, x1.f1.lb.widget.videoview.f fVar, AtomicBoolean atomicBoolean, v8.f<? super c> fVar2) {
                super(3, fVar2);
                this.this$0 = c0Var;
                this.$playCtx = fVar;
                this.$ret = atomicBoolean;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                return new c(this.this$0, this.$playCtx, this.$ret, fVar).invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    this.this$0.logger.error("restart play failure " + this.$playCtx.getMediaId() + "(" + this.$playCtx.getVideoName() + ")", new Object[0]);
                    this.$ret.set(false);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class d<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f21554a;

            d(AtomicBoolean atomicBoolean) {
                this.f21554a = atomicBoolean;
            }

            public final Object b(long j10, v8.f<? super r8.z> fVar) {
                this.f21554a.set(true);
                return r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).longValue(), fVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(x1.f1.lb.widget.videoview.f fVar, Long l10, c0 c0Var, AtomicBoolean atomicBoolean, CountDownLatch countDownLatch, v8.f<? super r> fVar2) {
            super(2, fVar2);
            this.$playCtx = fVar;
            this.$position = l10;
            this.this$0 = c0Var;
            this.$ret = atomicBoolean;
            this.$latch = countDownLatch;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new r(this.$playCtx, this.$position, this.this$0, this.$ret, this.$latch, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((r) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0076  */
        /* JADX WARN: Code duplicated, block: B:34:0x009d A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:13:0x0025, B:44:0x00d0, B:14:0x002a, B:32:0x0095, B:34:0x009d, B:36:0x00a5, B:37:0x00ab, B:40:0x00b3, B:41:0x00b9, B:9:0x0018, B:15:0x002e, B:23:0x0056, B:18:0x0035, B:20:0x0048, B:26:0x0078, B:29:0x0084), top: B:50:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00a5 A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:13:0x0025, B:44:0x00d0, B:14:0x002a, B:32:0x0095, B:34:0x009d, B:36:0x00a5, B:37:0x00ab, B:40:0x00b3, B:41:0x00b9, B:9:0x0018, B:15:0x002e, B:23:0x0056, B:18:0x0035, B:20:0x0048, B:26:0x0078, B:29:0x0084), top: B:50:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:38:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b3 A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:13:0x0025, B:44:0x00d0, B:14:0x002a, B:32:0x0095, B:34:0x009d, B:36:0x00a5, B:37:0x00ab, B:40:0x00b3, B:41:0x00b9, B:9:0x0018, B:15:0x002e, B:23:0x0056, B:18:0x0035, B:20:0x0048, B:26:0x0078, B:29:0x0084), top: B:50:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:41:0x00b9 A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:13:0x0025, B:44:0x00d0, B:14:0x002a, B:32:0x0095, B:34:0x009d, B:36:0x00a5, B:37:0x00ab, B:40:0x00b3, B:41:0x00b9, B:9:0x0018, B:15:0x002e, B:23:0x0056, B:18:0x0035, B:20:0x0048, B:26:0x0078, B:29:0x0084), top: B:50:0x000c }] */
        /* JADX WARN: Code duplicated, block: B:43:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:44:0x00d0 A[Catch: all -> 0x00f1, PHI: r9
          0x00d0: PHI (r9v26 java.lang.Object) = (r9v21 java.lang.Object), (r9v0 java.lang.Object) binds: [B:42:0x00cd, B:13:0x0025] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x00f1, blocks: (B:13:0x0025, B:44:0x00d0, B:14:0x002a, B:32:0x0095, B:34:0x009d, B:36:0x00a5, B:37:0x00ab, B:40:0x00b3, B:41:0x00b9, B:9:0x0018, B:15:0x002e, B:23:0x0056, B:18:0x0035, B:20:0x0048, B:26:0x0078, B:29:0x0084), top: B:50:0x000c }] */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ee, code lost:
        
            if (r9.collect(r1, r8) == r0) goto L46;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            kotlinx.coroutines.flow.f fVarF;
            b bVar;
            boolean zH2;
            z0 z0Var;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 3) {
                                if (i10 != 4) {
                                    if (i10 != 5) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    r8.r.b(obj);
                                }
                            } else {
                                r8.r.b(obj);
                                zBooleanValue = ((Boolean) obj).booleanValue();
                                if (zBooleanValue) {
                                    z0Var = this.this$0.videoViewHandler;
                                    if (z0Var == null) {
                                        kotlin.jvm.internal.m.v("videoViewHandler");
                                        z0Var = null;
                                    }
                                    zH2 = z0Var.h2();
                                } else {
                                    zH2 = false;
                                }
                                if (zH2) {
                                    this.$ret.set(true);
                                } else {
                                    this.$playCtx.getForceToStart().set(!zBooleanValue);
                                    c0 c0Var = this.this$0;
                                    x1.f1.lb.widget.videoview.f fVar = this.$playCtx;
                                    this.label = 4;
                                    obj = c0Var.C1(fVar, this);
                                    if (obj == objC) {
                                    }
                                    return objC;
                                }
                            }
                            kotlinx.coroutines.flow.f fVarF2 = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new c(this.this$0, this.$playCtx, this.$ret, null));
                            d dVar = new d(this.$ret);
                            this.label = 5;
                        }
                        r8.r.b(obj);
                    } else {
                        r8.r.b(obj);
                        fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(this.this$0, this.$playCtx, this.$ret, null));
                        bVar = new b(this.$ret);
                        this.label = 2;
                        if (fVarF.collect(bVar, this) == objC) {
                            return objC;
                        }
                    }
                    this.$latch.countDown();
                    return r8.z.f17874a;
                }
                r8.r.b(obj);
                this.$playCtx.q(this.$position);
                if (this.$playCtx.getForceToStart().get()) {
                    c0 c0Var2 = this.this$0;
                    x1.f1.lb.widget.videoview.f fVar2 = this.$playCtx;
                    this.label = 1;
                    obj = c0Var2.C1(fVar2, this);
                    if (obj != objC) {
                        fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(this.this$0, this.$playCtx, this.$ret, null));
                        bVar = new b(this.$ret);
                        this.label = 2;
                        if (fVarF.collect(bVar, this) == objC) {
                        }
                        this.$latch.countDown();
                        return r8.z.f17874a;
                    }
                } else {
                    if (this.$playCtx.getPlayType() == v6.c.CATCHUP) {
                        zBooleanValue = true;
                        if (zBooleanValue) {
                            z0Var = this.this$0.videoViewHandler;
                            if (z0Var == null) {
                                kotlin.jvm.internal.m.v("videoViewHandler");
                                z0Var = null;
                            }
                            zH2 = z0Var.h2();
                        } else {
                            zH2 = false;
                        }
                        if (zH2) {
                            this.$ret.set(true);
                        } else {
                            this.$playCtx.getForceToStart().set(!zBooleanValue);
                            c0 c0Var3 = this.this$0;
                            x1.f1.lb.widget.videoview.f fVar3 = this.$playCtx;
                            this.label = 4;
                            obj = c0Var3.C1(fVar3, this);
                            if (obj == objC) {
                                kotlinx.coroutines.flow.f fVarF3 = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new c(this.this$0, this.$playCtx, this.$ret, null));
                                d dVar2 = new d(this.$ret);
                                this.label = 5;
                            }
                        }
                        this.$latch.countDown();
                        return r8.z.f17874a;
                    }
                    x1.f1.lb.streaming.client.a aVar = x1.f1.lb.streaming.client.a.f21004a;
                    v6.c playType = this.$playCtx.getPlayType();
                    this.label = 3;
                    obj = aVar.n(playType, this);
                    if (obj != objC) {
                        zBooleanValue = ((Boolean) obj).booleanValue();
                        if (zBooleanValue) {
                            z0Var = this.this$0.videoViewHandler;
                            if (z0Var == null) {
                                kotlin.jvm.internal.m.v("videoViewHandler");
                                z0Var = null;
                            }
                            zH2 = z0Var.h2();
                        } else {
                            zH2 = false;
                        }
                        if (zH2) {
                            this.$ret.set(true);
                        } else {
                            this.$playCtx.getForceToStart().set(!zBooleanValue);
                            c0 c0Var4 = this.this$0;
                            x1.f1.lb.widget.videoview.f fVar4 = this.$playCtx;
                            this.label = 4;
                            obj = c0Var4.C1(fVar4, this);
                            if (obj == objC) {
                                kotlinx.coroutines.flow.f fVarF4 = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new c(this.this$0, this.$playCtx, this.$ret, null));
                                d dVar3 = new d(this.$ret);
                                this.label = 5;
                            }
                        }
                        this.$latch.countDown();
                        return r8.z.f17874a;
                    }
                }
                return objC;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$setSubtitle$1", f = "PlayerViewHandler.kt", l = {282}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class s extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $lang;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$setSubtitle$1$1$1", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            int label;
            final /* synthetic */ c0 this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(c0 c0Var, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = c0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c(c0 c0Var) {
                yf.a aVar = c0Var.subtitleViewHandler;
                if (aVar == null) {
                    kotlin.jvm.internal.m.v("subtitleViewHandler");
                    aVar = null;
                }
                aVar.c("");
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    yf.a aVar = this.this$0.subtitleViewHandler;
                    Context context = null;
                    if (aVar == null) {
                        kotlin.jvm.internal.m.v("subtitleViewHandler");
                        aVar = null;
                    }
                    Context context2 = this.this$0.mContext;
                    if (context2 == null) {
                        kotlin.jvm.internal.m.v("mContext");
                    } else {
                        context = context2;
                    }
                    CharSequence text = context.getText(R$string.no_subtitle);
                    kotlin.jvm.internal.m.e(text, "getText(...)");
                    aVar.c(text);
                    p pVar = this.this$0.mainLooperHandler;
                    final c0 c0Var = this.this$0;
                    pVar.postDelayed(new Runnable() { // from class: x1.f1.lb.widget.videoview.e0
                        @Override // java.lang.Runnable
                        public final void run() {
                            c0.s.a.c(c0Var);
                        }
                    }, 6000L);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(String str, v8.f<? super s> fVar) {
            super(2, fVar);
            this.$lang = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r8.z c(c0 c0Var, Throwable th) {
            if (th instanceof FileNotFoundException) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(c0Var, null), 3, null);
            }
            return r8.z.f17874a;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return c0.this.new s(this.$lang, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
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
                c0 c0Var = c0.this;
                this.label = 1;
                obj = c0Var.q0(this);
                if (obj == objC) {
                    return objC;
                }
            }
            String str = (String) obj;
            if (c0.this.S0() && str != null) {
                x1.f1.lb.widget.videoview.a aVar = c0.this.playerView;
                if (aVar == null) {
                    kotlin.jvm.internal.m.v("playerView");
                    aVar = null;
                }
                String strC = aVar.c(str, this.$lang);
                final c0 c0Var2 = c0.this;
                c0.X0(c0Var2, this.$lang, strC, new c9.l() { // from class: x1.f1.lb.widget.videoview.d0
                    @Override // c9.l
                    public final Object invoke(Object obj2) {
                        return c0.s.c(c0Var2, (Throwable) obj2);
                    }
                }, null, 8, null);
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler", f = "PlayerViewHandler.kt", l = {1582}, m = "setSubtitles")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class t extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        t(v8.f<? super t> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c0.this.t1(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler", f = "PlayerViewHandler.kt", l = {1636, 831}, m = "start")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class u extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        Object L$0;
        Object L$1;
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

        u(v8.f<? super u> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c0.this.B1(null, null, null, null, null, 0, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler", f = "PlayerViewHandler.kt", l = {1051, 1077, 1085}, m = "start")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class v extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        v(v8.f<? super v> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c0.this.C1(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/widget/videoview/c0$w", "Lx1/f1/lb/util/w0$a;", "", "value", "Lr8/z;", "b", "(I)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class w implements x1.f1.lb.util.w0.a<Integer> {
        w() {
        }

        @Override // x1.f1.lb.util.w0.a
        public /* bridge */ /* synthetic */ void a(Integer num) {
            b(num.intValue());
        }

        public void b(int value) {
            if (x1.f1.lb.config.b.f20643a.t()) {
                c0.this.logger.debug("decoder_setting: " + value, new Object[0]);
            }
            z0 z0Var = c0.this.videoViewHandler;
            if (z0Var == null) {
                kotlin.jvm.internal.m.v("videoViewHandler");
                z0Var = null;
            }
            z0Var.p2(value, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$start$5", f = "PlayerViewHandler.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lnf/r;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    static final class x extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super nf.r>, Throwable, v8.f<? super r8.z>, Object> {
        final /* synthetic */ x1.f1.lb.widget.videoview.f $ctx;
        final /* synthetic */ ec.b<Long, Throwable> $ret;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ c0 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(ec.b<Long, Throwable> bVar, c0 c0Var, x1.f1.lb.widget.videoview.f fVar, v8.f<? super x> fVar2) {
            super(3, fVar2);
            this.$ret = bVar;
            this.this$0 = c0Var;
            this.$ctx = fVar;
        }

        @Override // c9.q
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(kotlinx.coroutines.flow.g<? super nf.r> gVar, Throwable th, v8.f<? super r8.z> fVar) {
            x xVar = new x(this.$ret, this.this$0, this.$ctx, fVar);
            xVar.L$0 = th;
            return xVar.invokeSuspend(r8.z.f17874a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(c0 c0Var) {
            z0 z0Var = c0Var.videoViewHandler;
            if (z0Var == null) {
                kotlin.jvm.internal.m.v("videoViewHandler");
                z0Var = null;
            }
            z0Var.Q2();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3, types: [R, java.lang.Throwable] */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                ?? r10 = (Throwable) this.L$0;
                this.$ret.right = r10;
                p pVar = this.this$0.mainLooperHandler;
                final c0 c0Var = this.this$0;
                pVar.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        c0.x.f(c0Var);
                    }
                });
                this.this$0.logger.error("start " + this.$ctx.getVideoName() + " failure", r10);
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class y<T> implements kotlinx.coroutines.flow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ec.b<Long, Throwable> f21556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x1.f1.lb.widget.videoview.f f21557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c0 f21558c;

        y(ec.b<Long, Throwable> bVar, x1.f1.lb.widget.videoview.f fVar, c0 c0Var) {
            this.f21556a = bVar;
            this.f21557b = fVar;
            this.f21558c = c0Var;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [L, java.lang.Long] */
        @Override // kotlinx.coroutines.flow.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(nf.r rVar, v8.f<? super r8.z> fVar) {
            this.f21556a.left = kotlin.coroutines.jvm.internal.b.c(rVar.g());
            rVar.j(this.f21557b.getVideoName());
            rVar.i(this.f21557b.getPlayPositionPersistenceKey());
            this.f21557b.r(rVar.g());
            this.f21557b.getForceToStart().set(false);
            this.f21558c.logger.a("start_play " + rVar.h() + "(" + rVar.c() + ") " + rVar.g(), new Object[0]);
            x1.f1.lb.widget.videoview.h hVar = new x1.f1.lb.widget.videoview.h(rVar, this.f21557b.getSubtitleMediaId(), "");
            x1.f1.lb.widget.videoview.i.f21588a.c(hVar);
            if (this.f21557b.getPlayType() == v6.c.LIVE) {
                x1.f1.lb.util.a1.h(x1.f1.lb.util.a1.f21305a, rVar.g(), this.f21557b.getMediaId() + ".play_url_ready", false, 4, null);
            }
            this.f21558c.playingContext = this.f21557b;
            if (this.f21557b.getPlayType() == v6.c.VOD) {
                this.f21558c.W(rVar.g());
            }
            Long preSetSeekPosition = this.f21557b.getPreSetSeekPosition();
            if (preSetSeekPosition != null) {
                c0 c0Var = this.f21558c;
                long jLongValue = preSetSeekPosition.longValue();
                z0 z0Var = c0Var.videoViewHandler;
                if (z0Var == null) {
                    kotlin.jvm.internal.m.v("videoViewHandler");
                    z0Var = null;
                }
                String strE = rVar.e();
                kotlin.jvm.internal.m.e(strE, "getPlayPositionPersistenceKey(...)");
                z0Var.Z1(strE, jLongValue);
            }
            this.f21558c.A1(hVar, "start ctx");
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.widget.videoview.PlayerViewHandler$start$7", f = "PlayerViewHandler.kt", l = {1119}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class z extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super Long>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ ec.b<Long, Throwable> $ret;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(ec.b<Long, Throwable> bVar, v8.f<? super z> fVar) {
            super(2, fVar);
            this.$ret = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            z zVar = new z(this.$ret, fVar);
            zVar.L$0 = obj;
            return zVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, v8.f<? super r8.z> fVar) {
            return ((z) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
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
                ec.b<Long, Throwable> bVar = this.$ret;
                Throwable th = bVar.right;
                if (th == null) {
                    Long l10 = bVar.left;
                    if (l10 != null) {
                        Long lC = kotlin.coroutines.jvm.internal.b.c(l10.longValue());
                        this.label = 1;
                        if (gVar.emit(lC, this) == objC) {
                            return objC;
                        }
                    }
                } else {
                    throw th;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(c0 c0Var, IMediaPlayer iMediaPlayer) {
        c0Var.U0(false);
        q6.b bVar = c0Var.logger;
        v6.c cVarT0 = c0Var.t0();
        String strC0 = c0Var.C0();
        x1.f1.lb.widget.videoview.f fVar = c0Var.playingContext;
        bVar.a("[" + cVarT0 + "][" + strC0 + "][" + (fVar != null ? fVar.getMediaId() : null) + "] play complete", new Object[0]);
        IMediaPlayer.OnCompletionListener onCompletionListener = c0Var.onCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(iMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P0(c0 c0Var, IMediaPlayer iMediaPlayer, int i10, int i11) {
        String str;
        String mediaId;
        if (c0Var.isPlayerInStarting.get()) {
            return true;
        }
        if (i10 == 404 && i11 == 404) {
            if (x1.f1.lb.config.b.f20643a.t()) {
                c0Var.logger.debug("no_signal 404", new Object[0]);
            }
            c0Var.X(8);
            IMediaPlayer.OnErrorListener onErrorListener = c0Var.onErrorListener;
            if (onErrorListener != null) {
                return onErrorListener.onError(iMediaPlayer, i10, i11);
            }
            return true;
        }
        try {
            kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
            str = String.format(Locale.ENGLISH, "player[%s]-what[%d]-extra[%d]", Arrays.copyOf(new Object[]{iMediaPlayer != null ? Integer.valueOf(iMediaPlayer.hashCode()) : Configurator.NULL, Integer.valueOf(i10), Integer.valueOf(i11)}, 3));
            kotlin.jvm.internal.m.e(str, "format(...)");
        } catch (Throwable unused) {
            str = "what[" + i10 + "]-extra[" + i11 + "]";
        }
        String str2 = str;
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, c0Var.new m(str2, null), 3, null);
        q6.b bVar = c0Var.logger;
        v6.c cVarT0 = c0Var.t0();
        String strC0 = c0Var.C0();
        x1.f1.lb.widget.videoview.f fVar = c0Var.playingContext;
        bVar.error("[" + cVarT0 + "][" + strC0 + "][" + (fVar != null ? fVar.getMediaId() : null) + "] play error[" + str2 + "]", new Object[0]);
        if (i11 == 405 || i11 == 406 || i11 == 407 || i11 == 504 || i10 == -10000) {
            x1.f1.lb.widget.videoview.f fVar2 = c0Var.playingContext;
            if (fVar2 == null || fVar2.getPlayType() != v6.c.LIVE) {
                mediaId = null;
            } else {
                if (x1.f1.lb.media.e.f20835a.e(fVar2.getMediaId(), Integer.valueOf(fVar2.getMediaMode())) == qf.b.NO_FREE_NO_TRIAL_TIME) {
                    c0Var.Z0(fVar2);
                } else if (c0Var.T0()) {
                    if (x1.f1.lb.util.d0.f21360a.j()) {
                        c0Var.logger.warn("in eco mode now", new Object[0]);
                    } else {
                        c0Var.logger.warn("restart player", new Object[0]);
                        mediaId = null;
                        if (d1(c0Var, null, null, null, 7, null)) {
                            return true;
                        }
                    }
                }
                mediaId = null;
            }
            if (x1.f1.lb.config.b.f20643a.t()) {
                q6.b bVar2 = c0Var.logger;
                boolean zT0 = c0Var.T0();
                if (fVar2 != null) {
                    mediaId = fVar2.getMediaId();
                }
                bVar2.debug("no_signal " + i11 + " " + zT0 + " " + mediaId, new Object[0]);
            }
            c0Var.X(0);
        }
        tf.d dVarC = x1.f1.lb.metric.monitor.h.f20952a.c();
        if (dVarC != null) {
            dVarC.G(0);
            dVarC.F(i10);
            dVarC.E(str2);
        }
        IMediaPlayer.OnErrorListener onErrorListener2 = c0Var.onErrorListener;
        if (onErrorListener2 != null) {
            return onErrorListener2.onError(iMediaPlayer, i10, i11);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(c0 c0Var) {
        c0Var.g1(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(boolean z10, c0 c0Var) {
        z0 z0Var;
        if (!z10) {
            Integer numR0 = c0Var.r0();
            if (numR0 != null && numR0.intValue() == 0) {
                return;
            }
            c0Var.g1(0);
            return;
        }
        c0Var.k1(8);
        c0Var.g1(0);
        z0 z0Var2 = c0Var.videoViewHandler;
        z0 z0Var3 = null;
        if (z0Var2 == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        } else {
            z0Var = z0Var2;
        }
        z0.L0(z0Var, "", null, null, 6, null);
        z0 z0Var4 = c0Var.videoViewHandler;
        if (z0Var4 == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
        } else {
            z0Var3 = z0Var4;
        }
        z0Var3.l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(c0 c0Var) {
        c0Var.k1(0);
        c0Var.g1(8);
    }

    private final boolean k0(x1.f1.lb.widget.videoview.f playContext) {
        if (playContext == null && (playContext = this.playingContext) == null) {
            return false;
        }
        x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
        String strB0 = fVar.B0();
        long jO0 = fVar.o0();
        z0 z0Var = this.videoViewHandler;
        z0 z0Var2 = null;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        if (z0Var.getMIsForceStop()) {
            if (kotlin.jvm.internal.m.a(playContext.getUid(), strB0) && playContext.getLoginTime() == jO0) {
                z0 z0Var3 = this.videoViewHandler;
                if (z0Var3 == null) {
                    kotlin.jvm.internal.m.v("videoViewHandler");
                } else {
                    z0Var2 = z0Var3;
                }
                Integer mForceStopReason = z0Var2.getMForceStopReason();
                if (mForceStopReason != null) {
                    int iIntValue = mForceStopReason.intValue();
                    c9.p<? super Integer, ? super String, r8.z> pVar = this.noSignalListener;
                    if (pVar != null) {
                        pVar.invoke(Integer.valueOf(iIntValue), "trial check");
                    }
                }
                return false;
            }
            playContext.s(strB0);
            playContext.p(jO0);
            z0 z0Var4 = this.videoViewHandler;
            if (z0Var4 == null) {
                kotlin.jvm.internal.m.v("videoViewHandler");
                z0Var4 = null;
            }
            z0Var4.s2(false);
            z0 z0Var5 = this.videoViewHandler;
            if (z0Var5 == null) {
                kotlin.jvm.internal.m.v("videoViewHandler");
                z0Var5 = null;
            }
            z0Var5.r2(null);
            H0();
        }
        if (playContext.getIsFree() || x1.f1.lb.media.e.f20835a.e(playContext.getMediaId(), Integer.valueOf(playContext.getMediaMode())) != qf.b.NO_FREE_NO_TRIAL_TIME) {
            return true;
        }
        Z();
        return false;
    }

    public final boolean D1() {
        this.isPause = false;
        if (this.playingContext == null || !l0(this, null, 1, null)) {
            return false;
        }
        E0();
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        if (!z0Var.H2()) {
            return d1(this, null, null, null, 7, null);
        }
        V0(this, false, 1, null);
        return true;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.ASYNC)
    public final void OnEvent(nf.q event) {
        if (event == null) {
            return;
        }
        xe.c.c().s(event);
        if (!T0()) {
            this.logger.a("view is hidden, ignored restart event@" + event.hashCode() + " from[" + event.e() + "] [" + event.f() + "], " + event.d() + ", " + event.c(), new Object[0]);
            return;
        }
        x1.f1.lb.widget.videoview.f fVar = this.playingContext;
        Long lValueOf = fVar != null ? Long.valueOf(fVar.getSession()) : null;
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.t()) {
            this.logger.debug("receive restart play event@" + event.hashCode() + " from[" + event.e() + "] [" + lValueOf + " vs " + event.f() + "], " + event.d() + ", " + event.c(), new Object[0]);
        }
        if (lValueOf == null) {
            this.logger.a("receive restart play event@" + event.hashCode() + " from[" + event.e() + "] [" + lValueOf + " vs " + event.f() + "], " + event.d() + ", " + event.c() + " force restart", new Object[0]);
            j0();
            return;
        }
        if (event.f() != 0) {
            if (lValueOf.longValue() != event.f()) {
                this.logger.a("player current session[" + lValueOf + "] changed. ignored old session[" + event.f() + "] restart event[" + event.d() + "] from[" + event.e() + "]", new Object[0]);
                return;
            }
        } else if (d1.c() - lValueOf.longValue() < 15000) {
            if (bVar.t()) {
                this.logger.debug("player current session[" + lValueOf + "] to frequent to restart player, ignore event[" + event.d() + "] from[" + event.e() + "]", new Object[0]);
                return;
            }
            return;
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new b(event, null), 3, null);
    }

    public abstract void g1(int visibility);

    public abstract void k1(int visibility);

    public abstract Integer r0();

    public abstract void v1(int visibility);

    public abstract void x1(String url);

    public abstract void y1();

    public abstract void z1(String url);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object B1(String str, v6.c cVar, String str2, String str3, String str4, int i10, String str5, d dVar, String str6, v8.f<? super kotlinx.coroutines.flow.f<Long>> fVar) throws Throwable {
        u uVar;
        kotlinx.coroutines.sync.a aVar;
        String str7;
        String str8;
        int i11;
        String str9;
        c0 c0Var;
        v6.c cVar2;
        String str10;
        String str11;
        d dVar2;
        String str12;
        if (fVar instanceof u) {
            uVar = (u) fVar;
            int i12 = uVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                uVar.label = i12 - Integer.MIN_VALUE;
            } else {
                uVar = new u(fVar);
            }
        } else {
            uVar = new u(fVar);
        }
        Object obj = uVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i13 = uVar.label;
        try {
            if (i13 == 0) {
                r8.r.b(obj);
                aVar = this.mutex;
                uVar.L$0 = this;
                uVar.L$1 = str;
                uVar.L$2 = cVar;
                uVar.L$3 = str2;
                str7 = str3;
                uVar.L$4 = str7;
                str8 = str4;
                uVar.L$5 = str8;
                uVar.L$6 = str5;
                uVar.L$7 = dVar;
                uVar.L$8 = str6;
                uVar.L$9 = aVar;
                i11 = i10;
                uVar.I$0 = i11;
                uVar.label = 1;
                if (aVar.a(null, uVar) != objC) {
                    str9 = str;
                    c0Var = this;
                    cVar2 = cVar;
                    str10 = str2;
                    str11 = str5;
                    dVar2 = dVar;
                    str12 = str6;
                }
            }
            if (i13 != 1) {
                if (i13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(obj);
                return obj;
            }
            int i14 = uVar.I$0;
            aVar = (kotlinx.coroutines.sync.a) uVar.L$9;
            String str13 = (String) uVar.L$8;
            d dVar3 = (d) uVar.L$7;
            String str14 = (String) uVar.L$6;
            String str15 = (String) uVar.L$5;
            String str16 = (String) uVar.L$4;
            String str17 = (String) uVar.L$3;
            cVar2 = (v6.c) uVar.L$2;
            String str18 = (String) uVar.L$1;
            c0 c0Var2 = (c0) uVar.L$0;
            r8.r.b(obj);
            str9 = str18;
            c0Var = c0Var2;
            str12 = str13;
            dVar2 = dVar3;
            str11 = str14;
            str8 = str15;
            str7 = str16;
            str10 = str17;
            i11 = i14;
            x1.f1.lb.user.f fVar2 = x1.f1.lb.user.f.f21202a;
            String strB0 = fVar2.B0();
            long jO0 = fVar2.o0();
            x1.f1.lb.widget.videoview.f fVar3 = c0Var.playingContext;
            if (fVar3 == null || !kotlin.jvm.internal.m.a(fVar3.getUid(), strB0) || fVar3.getLoginTime() != jO0 || fVar3.getPlayType() != cVar2 || !kotlin.jvm.internal.m.a(fVar3.getMediaId(), str7) || !kotlin.jvm.internal.m.a(fVar3.getRouteId(), str8) || fVar3.getMediaMode() != i11) {
                String str19 = str7;
                v6.c cVar3 = cVar2;
                x1.f1.lb.widget.videoview.f fVar4 = new x1.f1.lb.widget.videoview.f(strB0, jO0, str9, cVar3, str10, str11, str19, str8, i11, x1.f1.lb.media.e.f20835a.e(str7, kotlin.coroutines.jvm.internal.b.b(i11)) == qf.b.FREE, str12, new AtomicBoolean(false), dVar2);
                c0Var.b0(true);
                z0 z0Var = c0Var.videoViewHandler;
                if (z0Var == null) {
                    kotlin.jvm.internal.m.v("videoViewHandler");
                    z0Var = null;
                }
                z0Var.s2(false);
                z0 z0Var2 = c0Var.videoViewHandler;
                if (z0Var2 == null) {
                    kotlin.jvm.internal.m.v("videoViewHandler");
                    z0Var2 = null;
                }
                z0Var2.r2(null);
                if ((fVar3 != null ? fVar3.getPlayType() : null) != cVar3 || !kotlin.jvm.internal.m.a(fVar3.getMediaId(), str19)) {
                    c0Var.I1(true);
                }
                fVar3 = fVar4;
            }
            aVar.b(null);
            uVar.L$0 = null;
            uVar.L$1 = null;
            uVar.L$2 = null;
            uVar.L$3 = null;
            uVar.L$4 = null;
            uVar.L$5 = null;
            uVar.L$6 = null;
            uVar.L$7 = null;
            uVar.L$8 = null;
            uVar.L$9 = null;
            uVar.label = 2;
            Object objC1 = c0Var.C1(fVar3, uVar);
            return objC1 == objC ? objC : objC1;
        } catch (Throwable th) {
            aVar.b(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:54:0x011d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0156  */
    /* JADX WARN: Code duplicated, block: B:58:0x0157  */
    /* JADX WARN: Code duplicated, block: B:62:0x017a  */
    /* JADX WARN: Code duplicated, block: B:70:0x0192  */
    /* JADX WARN: Code duplicated, block: B:74:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Instruction removed from duplicated block: B:70:0x0192, please report this as an issue */
    public final Object C1(x1.f1.lb.widget.videoview.f fVar, v8.f<? super kotlinx.coroutines.flow.f<Long>> fVar2) throws Throwable {
        v vVar;
        final c0 c0Var;
        x1.f1.lb.widget.videoview.f fVar3;
        ec.b bVar;
        Object objA;
        x1.f1.lb.widget.videoview.f fVar4;
        ec.b bVar2;
        c0 c0Var2;
        kotlinx.coroutines.flow.f fVarF;
        y yVar;
        if (fVar2 instanceof v) {
            vVar = (v) fVar2;
            int i10 = vVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                vVar.label = i10 - Integer.MIN_VALUE;
            } else {
                vVar = new v(fVar2);
            }
        } else {
            vVar = new v(fVar2);
        }
        Object objK1 = vVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = vVar.label;
        if (i11 == 0) {
            r8.r.b(objK1);
            this.mainLooperHandler.removeCallbacks(this.playTimeAccumulator);
            qf.b bVarE = x1.f1.lb.media.e.f20835a.e(fVar.getMediaId(), kotlin.coroutines.jvm.internal.b.b(fVar.getMediaMode()));
            if (x1.f1.lb.config.b.f20643a.t()) {
                this.logger.debug("trialOf [" + fVar.getVideoName() + "] is " + bVarE, new Object[0]);
            }
            if (fVar.getPlayType() == v6.c.LIVE && bVarE == qf.b.NO_FREE_NO_TRIAL_TIME) {
                Z0(fVar);
                return kotlinx.coroutines.flow.h.w(kotlin.coroutines.jvm.internal.b.c(0L));
            }
            if (!i0()) {
                return kotlinx.coroutines.flow.h.w(kotlin.coroutines.jvm.internal.b.c(0L));
            }
            this.mainLooperHandler.post(this.playTimeAccumulator);
            if (fVar.getForceToStart().get()) {
                c0Var = this;
                if (c0Var.isPlayerInStarting.compareAndSet(false, true)) {
                    c0Var.logger.warn("start_play " + fVar.getVideoName() + "(" + fVar.getMediaId() + "), ignored, another start play event is in processing", new Object[0]);
                    return kotlinx.coroutines.flow.h.v(new a0(null));
                }
                try {
                    fVar3 = c0Var.playingContext;
                    if (fVar3 == null) {
                        fVar3 = fVar;
                    }
                    c0Var.lastPlayContext = fVar3;
                    c0Var.playingContext = null;
                    x1.f1.lb.util.w0.f21452a.i("decode_key_cache", c0Var.new w(), 1);
                    c0(c0Var, false, 1, null);
                    c0Var.mainLooperHandler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            c0.F1(this.f21616a);
                        }
                    });
                    bVar = new ec.b();
                    d flowCreator = fVar.getFlowCreator();
                    AtomicBoolean forceToStart = fVar.getForceToStart();
                    vVar.L$0 = c0Var;
                    vVar.L$1 = fVar;
                    vVar.L$2 = bVar;
                    vVar.label = 2;
                    objA = flowCreator.a(forceToStart, vVar);
                    if (objA == objC) {
                        fVar4 = fVar;
                        bVar2 = bVar;
                        objK1 = objA;
                        fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) objK1, new x(bVar2, c0Var, fVar4, null));
                        yVar = new y(bVar2, fVar4, c0Var);
                        vVar.L$0 = c0Var;
                        vVar.L$1 = bVar2;
                        vVar.L$2 = null;
                        vVar.label = 3;
                        if (fVarF.collect(yVar, vVar) != objC) {
                            c0Var2 = c0Var;
                            kotlinx.coroutines.flow.f fVarV = kotlinx.coroutines.flow.h.v(new z(bVar2, null));
                            c0Var2.isPlayerInStarting.set(false);
                            return fVarV;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    c0Var2 = c0Var;
                    c0Var2.isPlayerInStarting.set(false);
                    throw th;
                }
            } else {
                vVar.L$0 = this;
                vVar.L$1 = fVar;
                vVar.label = 1;
                objK1 = K1(fVar, vVar);
                if (objK1 != objC) {
                    c0Var = this;
                }
            }
            return objC;
        }
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                bVar2 = (ec.b) vVar.L$1;
                c0Var2 = (c0) vVar.L$0;
                try {
                    r8.r.b(objK1);
                    kotlinx.coroutines.flow.f fVarV2 = kotlinx.coroutines.flow.h.v(new z(bVar2, null));
                    c0Var2.isPlayerInStarting.set(false);
                    return fVarV2;
                } catch (Throwable th2) {
                    th = th2;
                    c0Var2.isPlayerInStarting.set(false);
                    throw th;
                }
            }
            bVar2 = (ec.b) vVar.L$2;
            x1.f1.lb.widget.videoview.f fVar5 = (x1.f1.lb.widget.videoview.f) vVar.L$1;
            c0 c0Var3 = (c0) vVar.L$0;
            try {
                r8.r.b(objK1);
                fVar4 = fVar5;
                c0Var = c0Var3;
                fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) objK1, new x(bVar2, c0Var, fVar4, null));
                yVar = new y(bVar2, fVar4, c0Var);
                vVar.L$0 = c0Var;
                vVar.L$1 = bVar2;
                vVar.L$2 = null;
                vVar.label = 3;
                if (fVarF.collect(yVar, vVar) != objC) {
                    c0Var2 = c0Var;
                    kotlinx.coroutines.flow.f fVarV3 = kotlinx.coroutines.flow.h.v(new z(bVar2, null));
                    c0Var2.isPlayerInStarting.set(false);
                    return fVarV3;
                }
                return objC;
            } catch (Throwable th3) {
                th = th3;
                c0Var2 = c0Var3;
                c0Var2.isPlayerInStarting.set(false);
                throw th;
            }
        }
        fVar = (x1.f1.lb.widget.videoview.f) vVar.L$1;
        c0Var = (c0) vVar.L$0;
        r8.r.b(objK1);
        long jLongValue = ((Number) objK1).longValue();
        if (jLongValue != c0Var.invalidSession) {
            return kotlinx.coroutines.flow.h.w(kotlin.coroutines.jvm.internal.b.c(jLongValue));
        }
        if (c0Var.isPlayerInStarting.compareAndSet(false, true)) {
            c0Var.logger.warn("start_play " + fVar.getVideoName() + "(" + fVar.getMediaId() + "), ignored, another start play event is in processing", new Object[0]);
            return kotlinx.coroutines.flow.h.v(new a0(null));
        }
        fVar3 = c0Var.playingContext;
        if (fVar3 == null) {
            fVar3 = fVar;
        }
        c0Var.lastPlayContext = fVar3;
        c0Var.playingContext = null;
        x1.f1.lb.util.w0.f21452a.i("decode_key_cache", c0Var.new w(), 1);
        c0(c0Var, false, 1, null);
        c0Var.mainLooperHandler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.l
            @Override // java.lang.Runnable
            public final void run() {
                c0.F1(this.f21616a);
            }
        });
        bVar = new ec.b();
        d flowCreator2 = fVar.getFlowCreator();
        AtomicBoolean forceToStart2 = fVar.getForceToStart();
        vVar.L$0 = c0Var;
        vVar.L$1 = fVar;
        vVar.L$2 = bVar;
        vVar.label = 2;
        objA = flowCreator2.a(forceToStart2, vVar);
        if (objA == objC) {
            fVar4 = fVar;
            bVar2 = bVar;
            objK1 = objA;
            fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) objK1, new x(bVar2, c0Var, fVar4, null));
            yVar = new y(bVar2, fVar4, c0Var);
            vVar.L$0 = c0Var;
            vVar.L$1 = bVar2;
            vVar.L$2 = null;
            vVar.label = 3;
            if (fVarF.collect(yVar, vVar) != objC) {
                c0Var2 = c0Var;
                kotlinx.coroutines.flow.f fVarV4 = kotlinx.coroutines.flow.h.v(new z(bVar2, null));
                c0Var2.isPlayerInStarting.set(false);
                return fVarV4;
            }
        }
        return objC;
    }

    private final void E0() {
        c9.p<? super Integer, ? super String, r8.z> pVar = this.noSignalListener;
        if (pVar == null) {
            this.mainLooperHandler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.b0
                @Override // java.lang.Runnable
                public final void run() {
                    c0.G0(this.f21491a);
                }
            });
        } else {
            pVar.invoke(-1, "");
            this.mainLooperHandler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.a0
                @Override // java.lang.Runnable
                public final void run() {
                    c0.F0(this.f21484a);
                }
            });
        }
    }

    static /* synthetic */ Object E1(c0 c0Var, String str, v6.c cVar, String str2, String str3, String str4, int i10, String str5, d dVar, String str6, v8.f fVar, int i11, Object obj) {
        if (obj == null) {
            return c0Var.B1(str, cVar, str2, str3, str4, i10, str5, dVar, (i11 & 256) != 0 ? "" : str6, fVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(c0 c0Var) {
        c0Var.g1(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(c0 c0Var) {
        z0 z0Var = c0Var.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        z0.L2(z0Var, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(c0 c0Var) {
        c0Var.k1(8);
        c0Var.g1(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H0() {
        c9.p<? super Integer, ? super String, r8.z> pVar = this.noSignalListener;
        if (pVar != null) {
            pVar.invoke(-1, "");
        } else {
            this.mainLooperHandler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.m
                @Override // java.lang.Runnable
                public final void run() {
                    c0.I0(this.f21619a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(c0 c0Var) {
        c0Var.k1(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1() {
        x1.f1.lb.util.e0.f21385a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:55:0x0106  */
    /* JADX WARN: Code duplicated, block: B:57:0x010d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object K1(x1.f1.lb.widget.videoview.f fVar, v8.f<? super Long> fVar2) {
        f0 f0Var;
        c0 c0Var;
        x1.f1.lb.widget.videoview.h hVar;
        x1.f1.lb.widget.videoview.h hVar2;
        c0 c0Var2;
        if (fVar2 instanceof f0) {
            f0Var = (f0) fVar2;
            int i10 = f0Var.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                f0Var.label = i10 - Integer.MIN_VALUE;
            } else {
                f0Var = new f0(fVar2);
            }
        } else {
            f0Var = new f0(fVar2);
        }
        Object objB = f0Var.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = f0Var.label;
        if (i11 != 0) {
            if (i11 == 1) {
                fVar = (x1.f1.lb.widget.videoview.f) f0Var.L$1;
                c0Var = (c0) f0Var.L$0;
                r8.r.b(objB);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                hVar2 = (x1.f1.lb.widget.videoview.h) f0Var.L$1;
                c0Var2 = (c0) f0Var.L$0;
                r8.r.b(objB);
            }
            if (!((Boolean) objB).booleanValue()) {
                return kotlin.coroutines.jvm.internal.b.c(c0Var2.invalidSession);
            }
            hVar = hVar2;
            c0Var = c0Var2;
            return kotlin.coroutines.jvm.internal.b.c(c0Var.A1(hVar, "verify session"));
        }
        r8.r.b(objB);
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        AtomicLong mSession = z0Var.getMSession();
        x1.f1.lb.widget.videoview.i iVar = x1.f1.lb.widget.videoview.i.f21588a;
        long j10 = mSession.get();
        f0Var.L$0 = this;
        f0Var.L$1 = fVar;
        f0Var.label = 1;
        objB = iVar.b(j10, f0Var);
        if (objB != objC) {
            c0Var = this;
        }
        return objC;
        hVar = (x1.f1.lb.widget.videoview.h) objB;
        if (hVar == null) {
            return kotlin.coroutines.jvm.internal.b.c(c0Var.invalidSession);
        }
        nf.r rVar = hVar.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String();
        if (rVar.f() != fVar.getPlayType()) {
            return kotlin.coroutines.jvm.internal.b.c(c0Var.invalidSession);
        }
        if (!kotlin.jvm.internal.m.a(rVar.e(), fVar.getPlayPositionPersistenceKey())) {
            return kotlin.coroutines.jvm.internal.b.c(c0Var.invalidSession);
        }
        if (!kotlin.jvm.internal.m.a(rVar.c(), fVar.getMediaId())) {
            return kotlin.coroutines.jvm.internal.b.c(c0Var.invalidSession);
        }
        if (!kotlin.jvm.internal.m.a(rVar.getRouteId(), fVar.getRouteId())) {
            return kotlin.coroutines.jvm.internal.b.c(c0Var.invalidSession);
        }
        if (rVar.d() != fVar.getMediaMode()) {
            return kotlin.coroutines.jvm.internal.b.c(c0Var.invalidSession);
        }
        if (fVar.getPlayType() != v6.c.CATCHUP) {
            x1.f1.lb.streaming.client.a aVar = x1.f1.lb.streaming.client.a.f21004a;
            v6.c playType = fVar.getPlayType();
            f0Var.L$0 = c0Var;
            f0Var.L$1 = hVar;
            f0Var.label = 2;
            Object objN = aVar.n(playType, f0Var);
            if (objN != objC) {
                objB = objN;
                hVar2 = hVar;
                c0Var2 = c0Var;
                if (!((Boolean) objB).booleanValue()) {
                    return kotlin.coroutines.jvm.internal.b.c(c0Var2.invalidSession);
                }
                hVar = hVar2;
                c0Var = c0Var2;
            }
            return objC;
        }
        return kotlin.coroutines.jvm.internal.b.c(c0Var.A1(hVar, "verify session"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L0(c0 c0Var, IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
        IMediaPlayer.OnInfoListener onInfoListener = c0Var.onInfoListener;
        if (onInfoListener != null) {
            return onInfoListener.onInfo(iMediaPlayer, i10, i11, str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(c0 c0Var, IMediaPlayer iMediaPlayer) {
        try {
            q6.b bVar = c0Var.logger;
            v6.c cVarT0 = c0Var.t0();
            String strC0 = c0Var.C0();
            x1.f1.lb.widget.videoview.f fVar = c0Var.playingContext;
            String mediaId = fVar != null ? fVar.getMediaId() : null;
            bVar.a("[" + cVarT0 + "][" + strC0 + "][" + mediaId + "] seek complete[" + iMediaPlayer.getCurrentPosition() + "]", new Object[0]);
            if (!iMediaPlayer.isPlaying()) {
                iMediaPlayer.start();
            }
        } catch (Throwable th) {
            q6.b bVar2 = c0Var.logger;
            v6.c cVarT1 = c0Var.t0();
            String strC1 = c0Var.C0();
            x1.f1.lb.widget.videoview.f fVar2 = c0Var.playingContext;
            bVar2.error("[" + cVarT1 + "][" + strC1 + "][" + (fVar2 != null ? fVar2.getMediaId() : null) + "] start play failure after seek complete", th);
        }
        IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = c0Var.onSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete(iMediaPlayer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        z0 z0Var = this.videoViewHandler;
        a aVar = null;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        int mVideoWidth = z0Var.getMVideoWidth();
        z0 z0Var2 = this.videoViewHandler;
        if (z0Var2 == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var2 = null;
        }
        int mVideoHeight = z0Var2.getMVideoHeight();
        z0 z0Var3 = this.videoViewHandler;
        if (z0Var3 == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var3 = null;
        }
        Integer numO1 = z0Var3.O1();
        if (numO1 != null) {
            int iIntValue = numO1.intValue();
            z0 z0Var4 = this.videoViewHandler;
            if (z0Var4 == null) {
                kotlin.jvm.internal.m.v("videoViewHandler");
                z0Var4 = null;
            }
            Integer numN1 = z0Var4.N1();
            if (numN1 != null) {
                int iIntValue2 = numN1.intValue();
                if (iIntValue <= 0 || mVideoWidth <= 0 || iIntValue2 <= 0 || mVideoHeight <= 0) {
                    return;
                }
                float f10 = ((iIntValue * 1.0f) / mVideoWidth) - ((iIntValue2 * 1.0f) / mVideoHeight);
                if (f10 > 0.01f) {
                    int i10 = (iIntValue - ((iIntValue2 * mVideoWidth) / mVideoHeight)) / 2;
                    a aVar2 = this.playerView;
                    if (aVar2 == null) {
                        kotlin.jvm.internal.m.v("playerView");
                    } else {
                        aVar = aVar2;
                    }
                    aVar.b(aVar.i() + i10, aVar.l());
                    return;
                }
                if (f10 >= -0.01f) {
                    a aVar3 = this.playerView;
                    if (aVar3 == null) {
                        kotlin.jvm.internal.m.v("playerView");
                    } else {
                        aVar = aVar3;
                    }
                    aVar.b(aVar.i(), aVar.l());
                    return;
                }
                int i11 = (iIntValue2 - ((iIntValue * mVideoHeight) / mVideoWidth)) / 2;
                a aVar4 = this.playerView;
                if (aVar4 == null) {
                    kotlin.jvm.internal.m.v("playerView");
                } else {
                    aVar = aVar4;
                }
                aVar.b(aVar.i(), aVar.l() + i11);
            }
        }
    }

    private final boolean T0() {
        a aVar = this.playerView;
        if (aVar == null) {
            kotlin.jvm.internal.m.v("playerView");
            aVar = null;
        }
        return aVar.isShown();
    }

    static /* synthetic */ void V0(c0 c0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: keepScreenOn");
        }
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        c0Var.U0(z10);
    }

    private final void X(int reason) {
        c9.p<? super Integer, ? super String, r8.z> pVar = this.noSignalListener;
        if (pVar != null) {
            pVar.invoke(Integer.valueOf(reason), "");
            this.mainLooperHandler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.s
                @Override // java.lang.Runnable
                public final void run() {
                    c0.Y(this.f21645a);
                }
            });
        } else {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new f(null), 3, null);
            f0();
            U0(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void X0(c0 c0Var, String str, String str2, c9.l lVar, IMediaPlayer iMediaPlayer, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSubtitle");
        }
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        if ((i10 & 8) != 0) {
            iMediaPlayer = null;
        }
        c0Var.W0(str, str2, lVar, iMediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(c0 c0Var) {
        c0Var.g1(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z Y0(c0 c0Var, String str) {
        List<String> list = c0Var.subtitles;
        if (list == null || !list.contains(str)) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, c0Var.new o(str, null), 3, null);
        }
        return r8.z.f17874a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.String] */
    private final void Z() {
        int iP0;
        String videoName;
        c9.p<? super Integer, ? super String, r8.z> pVar = this.noSignalListener;
        final String str = "";
        if (pVar != null) {
            pVar.invoke(1, "");
            return;
        }
        x1.f1.lb.widget.videoview.f fVar = this.playingContext;
        if (fVar != null && (videoName = fVar.getVideoName()) != null) {
            str = videoName;
        }
        final kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
        x1.f1.lb.user.f fVar2 = x1.f1.lb.user.f.f21202a;
        T tJ0 = fVar2.D0().length() == 0 ? x1.f1.lb.heartbeat.f.f20678a.j0() : x1.f1.lb.heartbeat.f.f20678a.m0();
        b0Var.element = tJ0;
        if (((CharSequence) tJ0).length() == 0 && fVar2.D0().length() == 0 && (iP0 = x1.f1.lb.heartbeat.f.f20678a.p0()) > 0) {
            Context context = this.mContext;
            if (context == null) {
                kotlin.jvm.internal.m.v("mContext");
                context = null;
            }
            b0Var.element = context.getString(R$string.new_member_get_more_trial, Integer.valueOf(iP0));
        }
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.debug("no_signal no trial time tip", new Object[0]);
        }
        f0();
        this.mainLooperHandler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.t
            @Override // java.lang.Runnable
            public final void run() {
                c0.a0(this.f21649a, b0Var, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a0(c0 c0Var, kotlin.jvm.internal.b0 b0Var, String str) {
        z0 z0Var;
        z0 z0Var2;
        if (x1.f1.lb.user.f.f21202a.D0().length() == 0) {
            c0Var.z1(x1.f1.lb.heartbeat.f.f20678a.i0());
        } else {
            c0Var.x1(x1.f1.lb.heartbeat.f.f20678a.l0());
        }
        if (((CharSequence) b0Var.element).length() == 0) {
            z0 z0Var3 = c0Var.videoViewHandler;
            if (z0Var3 == null) {
                kotlin.jvm.internal.m.v("videoViewHandler");
                z0Var2 = null;
            } else {
                z0Var2 = z0Var3;
            }
            z0.K0(z0Var2, R$string.media_not_free, str, null, 4, null);
            return;
        }
        z0 z0Var4 = c0Var.videoViewHandler;
        if (z0Var4 == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        } else {
            z0Var = z0Var4;
        }
        z0.L0(z0Var, (String) b0Var.element, str, null, 4, null);
    }

    private final void b0(final boolean isForce) {
        c9.p<? super Integer, ? super String, r8.z> pVar = this.noSignalListener;
        if (pVar == null) {
            this.mainLooperHandler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.r
                @Override // java.lang.Runnable
                public final void run() {
                    c0.e0(isForce, this);
                }
            });
        } else {
            pVar.invoke(-1, "");
            this.mainLooperHandler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.q
                @Override // java.lang.Runnable
                public final void run() {
                    c0.d0(this.f21640a);
                }
            });
        }
    }

    private final void b1() {
        x1.f1.lb.util.e0.f21385a.a(this);
    }

    static /* synthetic */ void c0(c0 c0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayPlayerDftCover");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        c0Var.b0(z10);
    }

    public static /* synthetic */ boolean d1(c0 c0Var, String str, x1.f1.lb.widget.videoview.f fVar, Long l10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: restart");
        }
        if ((i10 & 1) != 0) {
            str = "restart";
        }
        if ((i10 & 2) != 0) {
            fVar = null;
        }
        if ((i10 & 4) != 0) {
            l10 = null;
        }
        return c0Var.c1(str, fVar, l10);
    }

    private final void f0() {
        this.mainLooperHandler.post(new Runnable() { // from class: x1.f1.lb.widget.videoview.p
            @Override // java.lang.Runnable
            public final void run() {
                c0.g0(this.f21637a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i0() {
        c9.p<? super Integer, ? super String, r8.z> pVar;
        if (x1.f1.lb.util.d0.f21360a.j()) {
            return false;
        }
        x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
        Integer numX = fVar.X();
        if (numX == null) {
            return true;
        }
        int iIntValue = numX.intValue();
        Context context = null;
        if (this.noSignalListener == null) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new g(iIntValue, null), 3, null);
            return false;
        }
        if (fVar.r0() == 2) {
            c9.p<? super Integer, ? super String, r8.z> pVar2 = this.noSignalListener;
            if (pVar2 != null) {
                Context context2 = this.mContext;
                if (context2 == null) {
                    kotlin.jvm.internal.m.v("mContext");
                } else {
                    context = context2;
                }
                String string = context.getString(iIntValue);
                kotlin.jvm.internal.m.e(string, "getString(...)");
                pVar2.invoke(5, string);
            }
        } else if (R0() && (pVar = this.noSignalListener) != null) {
            Context context3 = this.mContext;
            if (context3 == null) {
                kotlin.jvm.internal.m.v("mContext");
            } else {
                context = context3;
            }
            String string2 = context.getString(iIntValue);
            kotlin.jvm.internal.m.e(string2, "getString(...)");
            pVar.invoke(4, string2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        x1.f1.lb.widget.videoview.f fVar = this.playingContext;
        if (fVar == null) {
            this.logger.error("force restart failure, no ctx", new Object[0]);
            return;
        }
        fVar.getForceToStart().set(true);
        x1.f1.lb.widget.videoview.j jVarG = x1.f1.lb.widget.videoview.k.f21604a.g();
        if (jVarG != null) {
            jVarG.j(-1);
        }
        d1(this, "holder activity start", fVar, null, 4, null);
    }

    static /* synthetic */ boolean l0(c0 c0Var, x1.f1.lb.widget.videoview.f fVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: freeTrialCheck");
        }
        if ((i10 & 1) != 0) {
            fVar = null;
        }
        return c0Var.k0(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object q0(v8.f<? super String> fVar) {
        h hVar;
        nf.r rVar;
        if (fVar instanceof h) {
            hVar = (h) fVar;
            int i10 = hVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                hVar.label = i10 - Integer.MIN_VALUE;
            } else {
                hVar = new h(fVar);
            }
        } else {
            hVar = new h(fVar);
        }
        Object objB = hVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = hVar.label;
        if (i11 == 0) {
            r8.r.b(objB);
            z0 z0Var = this.videoViewHandler;
            if (z0Var == null) {
                kotlin.jvm.internal.m.v("videoViewHandler");
                z0Var = null;
            }
            long j10 = z0Var.getMSession().get();
            x1.f1.lb.widget.videoview.i iVar = x1.f1.lb.widget.videoview.i.f21588a;
            hVar.label = 1;
            objB = iVar.b(j10, hVar);
            if (objB == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(objB);
        }
        x1.f1.lb.widget.videoview.h hVar2 = (x1.f1.lb.widget.videoview.h) objB;
        if (hVar2 == null || (rVar = hVar2.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String()) == null) {
            return null;
        }
        return rVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object t1(List<String> list, v8.f<? super r8.z> fVar) {
        t tVar;
        c0 c0Var;
        if (fVar instanceof t) {
            tVar = (t) fVar;
            int i10 = tVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                tVar.label = i10 - Integer.MIN_VALUE;
            } else {
                tVar = new t(fVar);
            }
        } else {
            tVar = new t(fVar);
        }
        Object obj = tVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = tVar.label;
        if (i11 == 0) {
            r8.r.b(obj);
            if (list.isEmpty()) {
                return r8.z.f17874a;
            }
            c0Var = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) tVar.L$1;
            c0Var = (c0) tVar.L$0;
            r8.r.b(obj);
        }
        while (!c0Var.setSubtitlesFlag.compareAndSet(false, true)) {
            tVar.L$0 = c0Var;
            tVar.L$1 = list;
            tVar.label = 1;
            if (kotlinx.coroutines.v0.a(50L, tVar) == objC) {
                return objC;
            }
        }
        List<String> list2 = c0Var.subtitles;
        if (list2 == null || list2.isEmpty()) {
            c0Var.subtitles = list;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list2);
            for (String str : list) {
                kotlin.jvm.internal.m.e(str, "next(...)");
                String str2 = str;
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            c0Var.subtitles = arrayList;
        }
        c0Var.setSubtitlesFlag.set(false);
        return r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object w0(Long l10, v8.f<? super String> fVar) {
        i iVar;
        long jLongValue;
        if (fVar instanceof i) {
            iVar = (i) fVar;
            int i10 = iVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                iVar.label = i10 - Integer.MIN_VALUE;
            } else {
                iVar = new i(fVar);
            }
        } else {
            iVar = new i(fVar);
        }
        Object objB = iVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = iVar.label;
        if (i11 == 0) {
            r8.r.b(objB);
            if (l10 != null) {
                jLongValue = l10.longValue();
            } else {
                z0 z0Var = this.videoViewHandler;
                if (z0Var == null) {
                    kotlin.jvm.internal.m.v("videoViewHandler");
                    z0Var = null;
                }
                jLongValue = z0Var.getMSession().get();
            }
            x1.f1.lb.widget.videoview.i iVar2 = x1.f1.lb.widget.videoview.i.f21588a;
            iVar.label = 1;
            objB = iVar2.b(jLongValue, iVar);
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
        if (hVar != null) {
            return hVar.getSubtitleCdnUrl();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object y0(String str, Long l10, v8.f<? super String> fVar) {
        j jVar;
        c0 c0Var;
        if (fVar instanceof j) {
            jVar = (j) fVar;
            int i10 = jVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                jVar.label = i10 - Integer.MIN_VALUE;
            } else {
                jVar = new j(fVar);
            }
        } else {
            jVar = new j(fVar);
        }
        Object objW0 = jVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = jVar.label;
        if (i11 == 0) {
            r8.r.b(objW0);
            jVar.L$0 = this;
            jVar.L$1 = str;
            jVar.label = 1;
            objW0 = w0(l10, jVar);
            if (objW0 == objC) {
                return objC;
            }
            c0Var = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) jVar.L$1;
            c0Var = (c0) jVar.L$0;
            r8.r.b(objW0);
        }
        String str2 = (String) objW0;
        if (str2 != null && str2.length() != 0) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.m.e(upperCase, "toUpperCase(...)");
            return ua.n.E(str2, "{language}", upperCase, false, 4, null);
        }
        x1.f1.lb.widget.videoview.f fVar2 = c0Var.playingContext;
        a aVar = null;
        String subtitleMediaId = fVar2 != null ? fVar2.getSubtitleMediaId() : null;
        if (subtitleMediaId == null || subtitleMediaId.length() == 0) {
            return null;
        }
        a aVar2 = c0Var.playerView;
        if (aVar2 == null) {
            kotlin.jvm.internal.m.v("playerView");
        } else {
            aVar = aVar2;
        }
        return aVar.c(subtitleMediaId, str);
    }

    public final ITrackInfo[] A0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.getMTrackInfo();
    }

    public final int B0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.getMVideoHeight();
    }

    public final String C0() {
        String videoName;
        x1.f1.lb.widget.videoview.f fVar = this.playingContext;
        return (fVar == null || (videoName = fVar.getVideoName()) == null) ? "" : videoName;
    }

    public final int D0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.getMVideoWidth();
    }

    public final kotlinx.coroutines.flow.f<Long> G1(ChannelStreamResponse response) {
        kotlin.jvm.internal.m.f(response, "response");
        x1.f1.lb.media.a.f20755a.n(response.getKey());
        return kotlinx.coroutines.flow.h.y(kotlinx.coroutines.flow.h.v(new C0468c0(response, null)), kotlinx.coroutines.a1.b());
    }

    public final kotlinx.coroutines.flow.f<Long> H1(ChannelStreamResponse response, EPGProgramme programme) {
        kotlin.jvm.internal.m.f(response, "response");
        kotlin.jvm.internal.m.f(programme, "programme");
        return kotlinx.coroutines.flow.h.y(kotlinx.coroutines.flow.h.v(new d0(response, programme, this, null)), kotlinx.coroutines.a1.b());
    }

    public final void I1(boolean isTerminate) {
        if (this.playingContext == null) {
            return;
        }
        if (isTerminate) {
            this.playingContext = null;
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new e0(isTerminate, null), 3, null);
    }

    public final void J0(Context context, final a playerView, z0 videoViewHandler, yf.a subtitleViewHandler, ViewTreeObserver viewTreeObserver, AppCompatTextView tipTextView, AppCompatTextView loadingTxtView, AppCompatImageView loadingImageView, AppCompatImageView trialBgImg, AppCompatTextView trialText, Drawable trialDrawable) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(playerView, "playerView");
        kotlin.jvm.internal.m.f(videoViewHandler, "videoViewHandler");
        kotlin.jvm.internal.m.f(subtitleViewHandler, "subtitleViewHandler");
        kotlin.jvm.internal.m.f(tipTextView, "tipTextView");
        kotlin.jvm.internal.m.f(loadingTxtView, "loadingTxtView");
        kotlin.jvm.internal.m.f(loadingImageView, "loadingImageView");
        if (A) {
            x1.f1.lb.util.a0.f21295a.e(context);
        }
        this.mContext = context;
        this.playerView = playerView;
        this.videoViewHandler = videoViewHandler;
        this.subtitleViewHandler = subtitleViewHandler;
        this.subtitleLang = x1.f1.lb.media.d.f20812a.s();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnPreDrawListener(new k(videoViewHandler, playerView, context, tipTextView, loadingTxtView, loadingImageView, trialBgImg, trialText, this, trialDrawable));
        }
        videoViewHandler.x2(new IMediaPlayer.OnPreparedListener() { // from class: x1.f1.lb.widget.videoview.u
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                c0.K0(this.f21653a, playerView, iMediaPlayer);
            }
        });
        videoViewHandler.w2(new IMediaPlayer.OnInfoListener() { // from class: x1.f1.lb.widget.videoview.v
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11, String str) {
                return c0.L0(this.f21656a, iMediaPlayer, i10, i11, str);
            }
        });
        videoViewHandler.y2(new Runnable() { // from class: x1.f1.lb.widget.videoview.w
            @Override // java.lang.Runnable
            public final void run() {
                c0.M0(this.f21659a);
            }
        });
        videoViewHandler.u2(new IMediaPlayer.OnCompletionListener() { // from class: x1.f1.lb.widget.videoview.x
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                c0.N0(this.f21665a, iMediaPlayer);
            }
        });
        videoViewHandler.z2(new IMediaPlayer.OnSeekCompleteListener() { // from class: x1.f1.lb.widget.videoview.y
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(IMediaPlayer iMediaPlayer) {
                c0.O0(this.f21668a, iMediaPlayer);
            }
        });
        videoViewHandler.v2(new IMediaPlayer.OnErrorListener() { // from class: x1.f1.lb.widget.videoview.z
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public final boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
                return c0.P0(this.f21671a, iMediaPlayer, i10, i11);
            }
        });
    }

    public final boolean Q0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.getMIsCompleted();
    }

    public boolean R0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.K1();
    }

    public final boolean S0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.getPreparedTime() > 0;
    }

    public final boolean a1() {
        if (this.playingContext == null) {
            return false;
        }
        z0 z0Var = null;
        String strC = x1.f1.lb.util.q.c(x1.f1.lb.util.q.f21441a, 0, 1, null);
        z0 z0Var2 = this.videoViewHandler;
        if (z0Var2 == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
        } else {
            z0Var = z0Var2;
        }
        if (!z0Var.U1(strC)) {
            return false;
        }
        U0(false);
        this.isPause = true;
        return true;
    }

    public final boolean c1(String from, x1.f1.lb.widget.videoview.f ctx, Long position) throws InterruptedException {
        x1.f1.lb.widget.videoview.f fVar;
        kotlin.jvm.internal.m.f(from, "from");
        if (ctx == null) {
            x1.f1.lb.widget.videoview.f fVar2 = this.playingContext;
            if (fVar2 == null && (fVar2 = this.lastPlayContext) == null) {
                return false;
            }
            fVar = fVar2;
        } else {
            fVar = ctx;
        }
        if (!k0(fVar)) {
            return false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new r(fVar, position, this, atomicBoolean, countDownLatch, null), 3, null);
        countDownLatch.await();
        if (!atomicBoolean.get()) {
            return false;
        }
        this.isPause = false;
        V0(this, false, 1, null);
        c9.p<? super Integer, ? super String, r8.z> pVar = this.noSignalListener;
        if (pVar != null) {
            pVar.invoke(-1, from);
        }
        return true;
    }

    public final void e1(long position) {
        x1.f1.lb.widget.videoview.f fVar = this.playingContext;
        if (fVar != null) {
            fVar.q(Long.valueOf(position));
        }
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        z0Var.j2(position);
        q6.b bVar = this.logger;
        v6.c cVarT0 = t0();
        String strC0 = C0();
        x1.f1.lb.widget.videoview.f fVar2 = this.playingContext;
        bVar.a("[" + cVarT0 + "][" + strC0 + "][" + (fVar2 != null ? fVar2.getMediaId() : null) + "] seek_to [" + position + "]", new Object[0]);
    }

    public final void f1(int aspectRatioType) {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        z0Var.m2(aspectRatioType);
    }

    public final void h0(int resId) {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        z0.K0(z0Var, resId, null, null, 6, null);
    }

    public final void h1(final c9.p<? super Boolean, ? super String, r8.z> listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        final ArrayList arrayList = new ArrayList();
        z0 z0Var = null;
        arrayList.add(null);
        c9.p<? super Boolean, ? super String, r8.z> pVar = new c9.p() { // from class: x1.f1.lb.widget.videoview.o
            @Override // c9.p
            public final Object invoke(Object obj, Object obj2) {
                return c0.i1(arrayList, listener, ((Boolean) obj).booleanValue(), (String) obj2);
            }
        };
        this.loadingListener = pVar;
        z0 z0Var2 = this.videoViewHandler;
        if (z0Var2 == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
        } else {
            z0Var = z0Var2;
        }
        z0Var.q2(pVar);
    }

    public final void j1(c9.p<? super Integer, ? super String, r8.z> listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.noSignalListener = listener;
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        z0Var.t2(listener);
    }

    public final void l1(IMediaPlayer.OnCompletionListener onCompletionListener) {
        kotlin.jvm.internal.m.f(onCompletionListener, "onCompletionListener");
        this.onCompletionListener = onCompletionListener;
    }

    public final int m0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.getMAspectRatioType();
    }

    public final void m1(IMediaPlayer.OnErrorListener onErrorListener) {
        kotlin.jvm.internal.m.f(onErrorListener, "onErrorListener");
        this.onErrorListener = onErrorListener;
    }

    public final Integer n0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.Q0();
    }

    public final void n1(IMediaPlayer.OnInfoListener onInfoListener) {
        kotlin.jvm.internal.m.f(onInfoListener, "onInfoListener");
        this.onInfoListener = onInfoListener;
    }

    public final int o0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.getDownloadThousand();
    }

    public final void o1(IMediaPlayer.OnPreparedListener onPreparedListener) {
        kotlin.jvm.internal.m.f(onPreparedListener, "onPreparedListener");
        this.onPreparedListener = onPreparedListener;
    }

    public final long p0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.S0();
    }

    public final void p1(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        kotlin.jvm.internal.m.f(onSeekCompleteListener, "onSeekCompleteListener");
        this.onSeekCompleteListener = onSeekCompleteListener;
    }

    public final void q1(c9.a<r8.z> listener) {
        kotlin.jvm.internal.m.f(listener, "listener");
        this.playCompleteListener = listener;
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        z0Var.A2(listener);
    }

    public final void r1(String lang) {
        kotlin.jvm.internal.m.f(lang, "lang");
        if (kotlin.jvm.internal.m.a(this.subtitleLang, lang)) {
            return;
        }
        this.subtitleLang = lang;
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new s(lang, null), 3, null);
    }

    /* JADX INFO: renamed from: s0, reason: from getter */
    public final IMediaPlayer.OnCompletionListener getOnCompletionListener() {
        return this.onCompletionListener;
    }

    public final v6.c t0() {
        x1.f1.lb.widget.videoview.f fVar = this.playingContext;
        if (fVar != null) {
            return fVar.getPlayType();
        }
        return null;
    }

    public final long u0() {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.N0();
    }

    public final boolean u1() {
        x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
        boolean z10 = fVar.O0() || !fVar.G0();
        v1(z10 ? 0 : 8);
        return z10;
    }

    public final long v0() {
        if (this.playingContext == null) {
            return 0L;
        }
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        return z0Var.getMSession().get();
    }

    public final void w1(boolean b10) {
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        z0Var.G2(b10);
    }

    public final String x0() {
        String str = this.subtitleLang;
        return str == null ? x1.f1.lb.heartbeat.f.f20678a.M0() : str;
    }

    public final List<String> z0() {
        return this.subtitles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long A1(x1.f1.lb.widget.videoview.h playSession, String from) {
        nf.r rVar = playSession.getAndroidx.core.app.NotificationCompat.CATEGORY_EVENT java.lang.String();
        z0 z0Var = this.videoViewHandler;
        if (z0Var == null) {
            kotlin.jvm.internal.m.v("videoViewHandler");
            z0Var = null;
        }
        long j10 = z0Var.getMSession().get();
        long jC = d1.c();
        long j11 = this.lastStartPlayTime.get();
        if (!this.lastStartPlayTime.compareAndSet(j11, jC)) {
            this.logger.warn("start_play: a play event is in start", new Object[0]);
            return rVar.g();
        }
        if (jC - j11 < 3000 && j10 == rVar.g()) {
            return rVar.g();
        }
        b1();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.c()), null, null, new b0(rVar, null), 3, null);
        return rVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(c0 c0Var, a aVar, IMediaPlayer iMediaPlayer) {
        String mediaId = null;
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, c0Var.new l(aVar, iMediaPlayer, null), 3, null);
        c0Var.H0();
        IMediaPlayer.OnPreparedListener onPreparedListener = c0Var.onPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared(iMediaPlayer);
        }
        q6.b bVar = c0Var.logger;
        v6.c cVarT0 = c0Var.t0();
        String strC0 = c0Var.C0();
        x1.f1.lb.widget.videoview.f fVar = c0Var.playingContext;
        if (fVar != null) {
            mediaId = fVar.getMediaId();
        }
        bVar.a("[" + cVarT0 + "][" + strC0 + "][" + mediaId + "] prepared", new Object[0]);
        x1.f1.lb.metric.monitor.h.f20952a.g(iMediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(c0 c0Var) {
        c0Var.E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(boolean isOn) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new n(isOn, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(long session) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b().plus(a2.b(null, 1, null))), null, null, new e(session, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(final String lang, String subtitleUrl, c9.l<? super Throwable, r8.z> onFailure, IMediaPlayer mediaPlayer) {
        if (subtitleUrl.length() == 0) {
            return;
        }
        yf.a aVar = this.subtitleViewHandler;
        z0 z0Var = null;
        if (aVar == null) {
            kotlin.jvm.internal.m.v("subtitleViewHandler");
            aVar = null;
        }
        if (mediaPlayer != null) {
            try {
                z0 z0Var2 = this.videoViewHandler;
                if (z0Var2 == null) {
                    kotlin.jvm.internal.m.v("videoViewHandler");
                } else {
                    z0Var = z0Var2;
                }
                aVar.a(z0Var);
            } catch (Exception e10) {
                if (onFailure != null) {
                    onFailure.invoke(e10);
                    r8.z zVar = r8.z.f17874a;
                    return;
                }
                return;
            }
        }
        aVar.b(subtitleUrl, new c9.a() { // from class: x1.f1.lb.widget.videoview.n
            @Override // c9.a
            public final Object invoke() {
                return c0.Y0(this.f21624a, lang);
            }
        }, onFailure);
        r8.z zVar2 = r8.z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(x1.f1.lb.widget.videoview.f ctx) {
        Z();
        I1(true);
        xe.c.c().o(new nf.x(ctx.getVideoName(), ctx.getPlayType(), Long.valueOf(ctx.getSession())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z i1(List<Boolean> list, c9.p<? super Boolean, ? super String, r8.z> pVar, boolean z10, String str) {
        if (kotlin.jvm.internal.m.a(Boolean.valueOf(z10), kotlin.collections.r.i0(list))) {
            return r8.z.f17874a;
        }
        list.set(0, Boolean.valueOf(z10));
        pVar.invoke(Boolean.valueOf(z10), str);
        return r8.z.f17874a;
    }

    public final boolean U() {
        v6.c playType;
        if (S0()) {
            x1.f1.lb.widget.videoview.f fVar = this.playingContext;
            if (fVar != null) {
                playType = fVar.getPlayType();
            } else {
                playType = null;
            }
            if (playType != v6.c.LIVE && !Q0()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean V() {
        v6.c playType;
        if (S0()) {
            x1.f1.lb.widget.videoview.f fVar = this.playingContext;
            if (fVar != null) {
                playType = fVar.getPlayType();
            } else {
                playType = null;
            }
            if (playType != v6.c.LIVE && !Q0()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void s1(int sizeInSp) {
        x1.f1.lb.util.n nVarN = x1.f1.lb.util.n.n();
        Context context = this.mContext;
        a aVar = null;
        if (context == null) {
            kotlin.jvm.internal.m.v("mContext");
            context = null;
        }
        float fE = nVarN.e(context, sizeInSp);
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.debug("subtitle_size[{}][{}]", Integer.valueOf(sizeInSp));
        }
        a aVar2 = this.playerView;
        if (aVar2 == null) {
            kotlin.jvm.internal.m.v("playerView");
        } else {
            aVar = aVar2;
        }
        aVar.g(0, fE);
        x1.f1.lb.media.d.f20812a.z(sizeInSp);
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(nf.j event) {
        this.logger.a("activity on start, isShow[" + T0() + "]@" + hashCode(), new Object[0]);
        if (event != null && T0()) {
            j0();
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(nf.k event) {
        this.logger.a("activity on stop, isShow[" + T0() + "]@" + hashCode(), new Object[0]);
        if (event != null && T0()) {
            this.logger.a("activity on stop, try stop player", new Object[0]);
            try {
                z0 z0Var = this.videoViewHandler;
                yf.a aVar = null;
                if (z0Var == null) {
                    kotlin.jvm.internal.m.v("videoViewHandler");
                    z0Var = null;
                }
                AtomicLong mSession = z0Var.getMSession();
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new c(mSession, null), 3, null);
                z0 z0Var2 = this.videoViewHandler;
                if (z0Var2 == null) {
                    kotlin.jvm.internal.m.v("videoViewHandler");
                    z0Var2 = null;
                }
                z0Var2.N2(true);
                x1.f1.lb.widget.videoview.k.f21604a.p(mSession.get());
                yf.a aVar2 = this.subtitleViewHandler;
                if (aVar2 == null) {
                    kotlin.jvm.internal.m.v("subtitleViewHandler");
                } else {
                    aVar = aVar2;
                }
                aVar.destroy();
            } catch (Throwable th) {
                this.logger.warn("stop player failure", th);
            }
        }
    }
}
