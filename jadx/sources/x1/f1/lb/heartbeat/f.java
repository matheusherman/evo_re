package x1.f1.lb.heartbeat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.p000lifecycle.CoroutineLiveDataKt;
import androidx.p000lifecycle.Lifecycle;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlinx.coroutines.a2;
import org.apache.log4j.helpers.FileWatchdog;
import x.l1.b2.R$string;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;
import z1.b1.lb.m.ptv.ApiResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b*\u0002Ï\u0001\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ[\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132,\b\u0002\u0010\u0018\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J'\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010!JO\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\"2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132,\b\u0002\u0010\u0018\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u001f¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0004¢\u0006\u0004\b'\u0010\u0003J=\u0010,\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b,\u0010-J\u0015\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020\u0004¢\u0006\u0004\b2\u0010\u0003J\u0015\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\tJ\u001f\u00107\u001a\u00020\u00042\u0010\u00106\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u000105¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u000f¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0006¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u0006¢\u0006\u0004\b=\u0010<J\r\u0010>\u001a\u00020\u0006¢\u0006\u0004\b>\u0010<J\r\u0010?\u001a\u00020\u0006¢\u0006\u0004\b?\u0010<J\r\u0010@\u001a\u00020\u0006¢\u0006\u0004\b@\u0010<J\r\u0010A\u001a\u00020\u0006¢\u0006\u0004\bA\u0010<J\r\u0010B\u001a\u00020\u0016¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\u0006¢\u0006\u0004\bD\u0010<J\r\u0010E\u001a\u00020\u0006¢\u0006\u0004\bE\u0010<J\r\u0010F\u001a\u00020\u0006¢\u0006\u0004\bF\u0010<J\r\u0010G\u001a\u00020\u0006¢\u0006\u0004\bG\u0010<J\r\u0010H\u001a\u00020\u000f¢\u0006\u0004\bH\u0010:J\r\u0010I\u001a\u00020\u000f¢\u0006\u0004\bI\u0010:J\r\u0010J\u001a\u00020\u001f¢\u0006\u0004\bJ\u0010&J\r\u0010K\u001a\u00020\u000f¢\u0006\u0004\bK\u0010:J\r\u0010L\u001a\u00020\u000f¢\u0006\u0004\bL\u0010:J\r\u0010M\u001a\u00020\u0016¢\u0006\u0004\bM\u0010CJ\r\u0010N\u001a\u00020\u000f¢\u0006\u0004\bN\u0010:J\r\u0010O\u001a\u00020\u0016¢\u0006\u0004\bO\u0010CJ\r\u0010P\u001a\u00020\u0006¢\u0006\u0004\bP\u0010<J\u0013\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060Q¢\u0006\u0004\bR\u0010SR\u001e\u0010X\u001a\n U*\u0004\u0018\u00010T0T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010ZR\u0016\u0010_\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010ZR\u0016\u0010a\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010ZR\u0016\u0010c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010ZR\u0016\u0010e\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010ZR\u0016\u0010h\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010gR\u0016\u0010l\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010gR\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010gR\u0016\u0010p\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010gR\u0016\u0010r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010gR\u0016\u0010t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010gR\u0016\u0010w\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010gR\u0016\u0010{\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010\u0005R\u0016\u0010}\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010ZR\u0016\u0010\u007f\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010vR\u0018\u0010\u0081\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010ZR\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010vR\u0018\u0010\u0088\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010ZR\u0018\u0010\u008c\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R+\u0010\u0091\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00060\u008e\u00010\u008d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0093\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010\u0005R#\u0010\u0098\u0001\u001a\f\u0012\u0005\u0012\u00030\u0095\u0001\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0018\u0010\u009e\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010ZR\u0018\u0010 \u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010ZR\u0018\u0010¢\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¡\u0001\u0010ZR+\u0010§\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00060£\u0001j\t\u0012\u0004\u0012\u00020\u0006`¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010©\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¨\u0001\u0010gR\u0017\u0010ª\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010vR\u0017\u0010«\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010gR\u0018\u0010\u00ad\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¬\u0001\u0010gR\u0018\u0010¯\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b®\u0001\u0010gR\u0018\u0010±\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b°\u0001\u0010gR\u0018\u0010³\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b²\u0001\u0010\u0005R\u0018\u0010µ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b´\u0001\u0010gR\u001f\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001b\u0010»\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001b\u0010¾\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u0018\u0010À\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¿\u0001\u0010gR\u0018\u0010Â\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÁ\u0001\u0010vR\u001c\u0010Æ\u0001\u001a\u0005\u0018\u00010Ã\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u0018\u0010Ê\u0001\u001a\u00030Ç\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R!\u0010Î\u0001\u001a\f U*\u0005\u0018\u00010Ë\u00010Ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0018\u0010Ò\u0001\u001a\u00030Ï\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R&\u0010Ö\u0001\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b#\u0010v\u001a\u0005\bÓ\u0001\u0010C\"\u0006\bÔ\u0001\u0010Õ\u0001R&\u0010Ù\u0001\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b\u0005\u0010v\u001a\u0005\b×\u0001\u0010C\"\u0006\bØ\u0001\u0010Õ\u0001R\u0017\u0010Ü\u0001\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bK\u0010Û\u0001R\u0017\u0010Ý\u0001\u001a\u00030\u0099\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bL\u0010\u009b\u0001R<\u0010ß\u0001\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b>\u0010Þ\u0001R\u001a\u0010á\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b@\u0010à\u0001¨\u0006â\u0001"}, d2 = {"Lx1/f1/lb/heartbeat/f;", "", "<init>", "()V", "Lr8/z;", "Z", "", "errMessage", "C0", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "apkFile", "v0", "(Landroid/content/Context;Ljava/lang/String;)V", "", "startTime", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "upgradeInfo", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlin/Function4;", "", "Lnf/a0;", "onProgress", "A0", "(JLz1/b1/lb/m/extra/upgrade/UpgradeInfo;Landroidx/lifecycle/Lifecycle;Lc9/r;)V", "s0", "now", "lastTime", "interval", "", "y0", "(JJJ)Z", "Lkotlinx/coroutines/flow/f;", "Y", "(Landroidx/lifecycle/Lifecycle;Lc9/r;)Lkotlinx/coroutines/flow/f;", "w0", "()Z", "L0", "upgradePermissionDlgTitleTxtResId", "upgradePermissionDlgDescTxtResId", "upgradePermissionDlgBtnTxtResId", "logoDrawableResId", "D0", "(Landroid/content/Context;IIIILjava/lang/String;)V", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "t0", "(Landroidx/appcompat/app/AppCompatActivity;)V", "G0", TypedValues.TransitionType.S_FROM, "H0", "", "properties", "K0", "(Ljava/util/Map;)V", "h0", "()J", "f0", "()Ljava/lang/String;", "o0", "c0", "e0", "d0", "g0", "r0", "()I", "j0", "m0", "i0", "l0", "n0", "k0", "x0", "a0", "b0", "p0", "q0", "z0", "M0", "", "N0", "()Ljava/util/List;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "J", "autoLoginBeforeTokenExpired", "d", "autoRefreshAccessTokenInterval", "e", "heartbeatInterval", "f", "upgradeCheckingInterval", "g", "metricHeartbeatInterval", "h", "echoModeTime", "i", "Ljava/lang/String;", "customerServiceEmail", "j", "customerServiceQrCodeImg", "k", "mobileAppQrCodeImg", "l", "customerServiceGroupWhatsappLink", "m", "customerServiceFacebook", "n", "customerServiceWhatsapp", "o", "customerServiceTelegram", "p", "I", "reLoginMaxCntAfterExpired", "q", "how2order", "r", "isReportClientDetail", "s", "loginRetryIntervalMs", "t", "promotionTrialDays", "u", "promptRenewMillis", "v", "Ljava/lang/Integer;", "limitContinuingRenewDays", "w", "qrcodeRefreshIntervalSeconds", "x", "metaUpdateMinIntervalMs", "Lkotlinx/coroutines/l0;", "y", "Lkotlinx/coroutines/l0;", "puckScope", "Ljava/util/concurrent/ConcurrentHashMap;", "Lx1/f1/lb/util/m;", "z", "Ljava/util/concurrent/ConcurrentHashMap;", "propertiesHandlers", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isRun", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "B", "Landroidx/activity/result/ActivityResultLauncher;", "activityResult", "Ljava/lang/Runnable;", "C", "Ljava/lang/Runnable;", "activityAction", "D", "lastUpgradeCheckTime", ExifInterface.LONGITUDE_EAST, "lastHeartbeatTime", "F", "lastMetricHeartbeatTime", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "G", "Ljava/util/HashSet;", "emailBeBlockedHosts", "H", "blockEmailHostTip", "startUpCountNum", "guestTrialEndTipText", "K", "guestTrialEndImgUrl", "L", "memberTrialEndTipText", "M", "memberTrialEndImgUrl", "N", "isShowRegisterFistForNewUser", "O", "subtitleDftLang", "P", "Ljava/util/List;", "subtitleLanguageList", "Q", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "lastUpgradeData", "R", "Ljava/lang/Boolean;", "isFree", ExifInterface.LATITUDE_SOUTH, "planHtml", ExifInterface.GPS_DIRECTION_TRUE, "feedbackLogcatExecuteDuration", "Ljava/util/Timer;", "U", "Ljava/util/Timer;", "timer", "Ljava/util/concurrent/CountDownLatch;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/util/concurrent/CountDownLatch;", "initCountDownLatch", "Ljava/util/concurrent/ExecutorService;", ExifInterface.LONGITUDE_WEST, "Ljava/util/concurrent/ExecutorService;", "executorService", "x1/f1/lb/heartbeat/f$y1", "X", "Lx1/f1/lb/heartbeat/f$y1;", "subscribeExecRunnable", "getExpire_remind_seconds", "J0", "(I)V", "expire_remind_seconds", "getDaily_remind_times", "I0", "daily_remind_times", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isOnUpgrade", "upgradeAction", "Lc9/r;", "mOnProgress", "Landroidx/lifecycle/Lifecycle;", "mLifecycle", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private static boolean isRun;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private static ActivityResultLauncher<Intent> activityResult;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private static Runnable activityAction;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private static long lastUpgradeCheckTime;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private static long lastHeartbeatTime;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private static long lastMetricHeartbeatTime;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private static HashSet<String> emailBeBlockedHosts;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private static String blockEmailHostTip;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private static int startUpCountNum;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private static String guestTrialEndTipText;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private static String guestTrialEndImgUrl;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private static String memberTrialEndTipText;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private static String memberTrialEndImgUrl;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private static boolean isShowRegisterFistForNewUser;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private static String subtitleDftLang;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private static List<String> subtitleLanguageList;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    private static UpgradeInfo lastUpgradeData;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    private static Boolean isFree;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    private static String planHtml;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    private static int feedbackLogcatExecuteDuration;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    private static Timer timer;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    private static final CountDownLatch initCountDownLatch;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    private static final ExecutorService executorService;

    /* JADX INFO: renamed from: X, reason: from kotlin metadata */
    private static final y1 subscribeExecRunnable;

    /* JADX INFO: renamed from: Y, reason: from kotlin metadata */
    private static int expire_remind_seconds;

    /* JADX INFO: renamed from: Z, reason: from kotlin metadata */
    private static int daily_remind_times;

    /* JADX INFO: renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isOnUpgrade;

    /* JADX INFO: renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private static final Runnable upgradeAction;

    /* JADX INFO: renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private static c9.r<? super String, ? super Integer, ? super String, ? super nf.a0, r8.z> mOnProgress;

    /* JADX INFO: renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private static Lifecycle mLifecycle;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static boolean isReportClientDetail;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private static Integer limitContinuingRenewDays;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, x1.f1.lb.util.m<String>> propertiesHandlers;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f20678a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static q6.b logger = q6.c.d(f.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long autoLoginBeforeTokenExpired = 300000;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long autoRefreshAccessTokenInterval = 43200000;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long heartbeatInterval = 120000;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long upgradeCheckingInterval = 7200000;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long metricHeartbeatInterval = 120000;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long echoModeTime = 7200000;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static String customerServiceEmail = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static String customerServiceQrCodeImg = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static String mobileAppQrCodeImg = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static String customerServiceGroupWhatsappLink = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static String customerServiceFacebook = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static String customerServiceWhatsapp = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static String customerServiceTelegram = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static int reLoginMaxCntAfterExpired = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static String how2order = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private static long loginRetryIntervalMs = FileWatchdog.DEFAULT_DELAY;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private static int promotionTrialDays = 7;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private static long promptRenewMillis = 259200000;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private static int qrcodeRefreshIntervalSeconds = 15;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private static long metaUpdateMinIntervalMs = 1800000;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private static final kotlinx.coroutines.l0 puckScope = kotlinx.coroutines.m0.a(a2.b(null, 1, null).plus(kotlinx.coroutines.a1.b()));

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$a", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            f.customerServiceGroupWhatsappLink = v10;
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$a0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            try {
                int i10 = Integer.parseInt(v10);
                if (i10 > 0) {
                    f.startUpCountNum = i10;
                }
            } catch (Throwable th) {
                f.logger.error("set start_up_ad_count_num failure", th);
            }
        }

        a0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$a1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                boolean zJ = bVar.j();
                bVar.C(Boolean.parseBoolean(v10));
                f.logger.a("set_param has_subject[" + v10 + "][" + zJ + " -> " + bVar.j() + "]", new Object[0]);
            } catch (Throwable th) {
                f.logger.error("set_param has subject failure[" + v10 + "]", th);
            }
        }

        a1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$b", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            f.customerServiceWhatsapp = v10;
        }

        b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$b0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            try {
                int i10 = Integer.parseInt(v10);
                if (i10 > 0) {
                    f.metaUpdateMinIntervalMs = ((long) i10) * 1000;
                }
            } catch (Throwable th) {
                f.logger.error("set start_up_ad_count_num failure", th);
            }
        }

        b0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$b1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.K(v10);
            } catch (Throwable th) {
                f.logger.error("set has subject failure[" + v10 + "]", th);
            }
        }

        b1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$c", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            f.customerServiceTelegram = v10;
        }

        c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$c0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            f.guestTrialEndTipText = v10;
        }

        c0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$c1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            long jD = dc.a.d(v10, f.heartbeatInterval);
            if (jD > 30) {
                f.upgradeCheckingInterval = jD * ((long) 1000);
            }
        }

        c1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$d", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            f.customerServiceFacebook = v10;
        }

        d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$d0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            f.memberTrialEndTipText = v10;
        }

        d0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$d1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.J(v10);
            } catch (Throwable th) {
                f.logger.error("set has subject failure[" + v10 + "]", th);
            }
        }

        d1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$e", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                f.f20678a.J0(Integer.parseInt(v10));
            } catch (Throwable th) {
                f.logger.error("set expire_remind_seconds failure", th);
            }
        }

        e() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$e0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            f.guestTrialEndImgUrl = v10;
        }

        e0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$e1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.B(Boolean.parseBoolean(v10));
            } catch (Throwable th) {
                f.logger.error("set has referral summary failure[" + v10 + "]", th);
            }
        }

        e1() {
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.heartbeat.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$f", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0413f implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                f.f20678a.I0(Integer.parseInt(v10));
            } catch (Throwable th) {
                f.logger.error("set daily_remind_times failure", th);
            }
        }

        C0413f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$f0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            f.memberTrialEndImgUrl = v10;
        }

        f0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$f1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.G(Long.parseLong(v10) * ((long) 60000));
            } catch (Throwable th) {
                f.logger.error("set has referral summary failure[" + v10 + "]", th);
            }
        }

        f1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$g", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                f fVar = f.f20678a;
                f.reLoginMaxCntAfterExpired = Integer.parseInt(v10);
            } catch (Throwable th) {
                f.logger.error("set re_login_max_cnt_after_expired failure", th);
            }
        }

        g() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$g0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                long j10 = Long.parseLong(v10);
                if (j10 >= 3600000) {
                    f.autoRefreshAccessTokenInterval = j10;
                }
            } catch (Throwable th) {
                f.logger.error("set auto login before token expired failure", th);
            }
        }

        g0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$g1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.y(Integer.parseInt(v10));
            } catch (Throwable th) {
                f.logger.error("set has referral summary failure[" + v10 + "]", th);
            }
        }

        g1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$h", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                f.how2order = v10;
            } catch (Throwable th) {
                f.logger.error("set how2order failure", th);
            }
        }

        h() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$h0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            f fVar = f.f20678a;
            f.isShowRegisterFistForNewUser = Boolean.parseBoolean(v10);
        }

        h0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$h1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.A(Boolean.parseBoolean(v10));
            } catch (Throwable th) {
                f.logger.error("set has catchup failure[" + v10 + "]", th);
            }
        }

        h1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$i", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            List listL;
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                List<String> listG = new ua.l(",").g(v10, 0);
                if (listG.isEmpty()) {
                    listL = kotlin.collections.r.l();
                } else {
                    ListIterator<String> listIterator = listG.listIterator(listG.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                        }
                    }
                    listL = kotlin.collections.r.l();
                }
                x1.f1.lb.log.a.f20729a.m((String[]) listL.toArray(new String[0]));
            } catch (Throwable th) {
                f.logger.error("update log server failure", th);
            }
        }

        i() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$i0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            f.subtitleDftLang = v10;
        }

        i0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$i1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            f.mobileAppQrCodeImg = v10;
        }

        i1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$j", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                f fVar = f.f20678a;
                f.promotionTrialDays = Integer.parseInt(v10);
            } catch (Throwable th) {
                f.logger.error("set promotion_trial_days failure", th);
            }
        }

        j() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$j0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ua.n.z0(v10, new String[]{","}, false, 0, 6, null).iterator();
            while (it.hasNext()) {
                String string = ua.n.Q0((String) it.next()).toString();
                if (string.length() != 0) {
                    arrayList.add(string);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            f.subtitleLanguageList = arrayList;
        }

        j0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$j1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            x1.f1.lb.util.w0.f21452a.t("ad_list_ext", v10);
            x1.f1.lb.ad.b.f20540a.f(v10);
        }

        j1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$k", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            f fVar = f.f20678a;
            f.isFree = Boolean.valueOf(Boolean.parseBoolean(v10));
        }

        k() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$k0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            f fVar = f.f20678a;
            f.isReportClientDetail = Boolean.parseBoolean(v10);
        }

        k0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$k1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                f fVar = f.f20678a;
                f.feedbackLogcatExecuteDuration = h9.f.c(Integer.parseInt(v10), 0);
            } catch (Exception unused) {
            }
        }

        k1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$l", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class l implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                f fVar = f.f20678a;
                f.promptRenewMillis = ((long) Integer.parseInt(v10)) * 3600000;
            } catch (Throwable th) {
                f.logger.error("set promotion_trial_days failure", th);
            }
        }

        l() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$l0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class l0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            x1.f1.lb.bot.a.f20583a.p(Boolean.parseBoolean(v10));
        }

        l0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$l1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "d", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class l1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() != 0 && ua.n.O(v10, of.a.f16585a.k(), false, 2, null)) {
                x1.f1.lb.feedback.c.f20670a.m(f.feedbackLogcatExecuteDuration, new c9.p() { // from class: x1.f1.lb.heartbeat.g
                    @Override // c9.p
                    public final Object invoke(Object obj, Object obj2) {
                        return f.l1.e(((Boolean) obj).booleanValue(), (String) obj2);
                    }
                });
            }
        }

        l1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r8.z e(boolean z10, String str) {
            f.logger.a("feedback silent call " + z10 + " with " + str, new Object[0]);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$m", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class m implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                f fVar = f.f20678a;
                f.limitContinuingRenewDays = Integer.valueOf(Integer.parseInt(v10));
            } catch (Throwable th) {
                f.logger.error("set promotion_trial_days failure", th);
            }
        }

        m() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$m0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class m0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.user.f.f21202a.B1(Integer.parseInt(v10));
            } catch (Throwable th) {
                f.logger.error("set remind flag for expired plan failure", th);
            }
        }

        m0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$m1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class m1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.E(Long.parseLong(v10));
            } catch (Exception unused) {
            }
        }

        m1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$n", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class n implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            boolean z10;
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                int i10 = Integer.parseInt(v10);
                x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                if (i10 <= 0) {
                    z10 = false;
                } else {
                    if (i10 > 10) {
                        f.qrcodeRefreshIntervalSeconds = i10;
                    }
                    z10 = true;
                }
                bVar.H(z10);
            } catch (Throwable th) {
                f.logger.error("set promotion_trial_days failure", th);
            }
        }

        n() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$n0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class n0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.user.f.f21202a.C1(Integer.parseInt(v10));
            } catch (Throwable th) {
                f.logger.error("set remind flag for plan not bind username failure", th);
            }
        }

        n0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$n1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class n1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            long jD = dc.a.d(v10, f.heartbeatInterval);
            if (jD > 30) {
                f.metricHeartbeatInterval = jD * ((long) 1000);
            }
        }

        n1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$o", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class o implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                List<String> listZ0 = ua.n.z0(v10, new String[]{","}, false, 0, 6, null);
                if (listZ0.isEmpty()) {
                    return;
                }
                x1.f1.lb.util.d0.f21360a.s(listZ0);
            } catch (Throwable th) {
                f.logger.error("set promotion_trial_days failure", th);
            }
        }

        o() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$o0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class o0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.user.f.f21202a.z1(Integer.parseInt(v10));
            } catch (Throwable th) {
                f.logger.error("set remind flag for plan will expire failure", th);
            }
        }

        o0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"x1/f1/lb/heartbeat/f$o1", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class o1 extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                f.f20678a.s0();
            } catch (Throwable th) {
                f.logger.error("heartbeat failure", th);
            }
        }

        o1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$p", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                int i10 = Integer.parseInt(v10);
                if (i10 > 1000) {
                    x1.f1.lb.marquee.a.f20738a.u(i10);
                }
            } catch (Throwable th) {
                f.logger.error("set promotion_trial_days failure", th);
            }
        }

        p() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$p0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                int i10 = Integer.parseInt(v10);
                if (i10 > 3) {
                    uf.c.f19486a.v(i10);
                }
            } catch (Throwable th) {
                f.logger.error("set remind flag for plan will expire failure", th);
            }
        }

        p0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$p1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            long j10 = 60000;
            long jD = dc.a.d(v10, f.echoModeTime / j10);
            if (jD > 1) {
                f.echoModeTime = jD * j10;
            }
        }

        p1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$q", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class q implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                long j10 = Integer.parseInt(v10);
                if (j10 > 15) {
                    f.loginRetryIntervalMs = j10 * 1000;
                }
            } catch (Throwable th) {
                f.logger.error("set promotion_trial_days failure", th);
            }
        }

        q() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$q0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class q0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                int i10 = Integer.parseInt(v10);
                if (i10 > 300) {
                    x1.f1.lb.util.c.f21341a.s(i10);
                }
            } catch (Throwable th) {
                f.logger.error("set log main thread block millis failure", th);
            }
        }

        q0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$q1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class q1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            f.customerServiceQrCodeImg = v10;
        }

        q1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$r", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class r implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                int i10 = Integer.parseInt(v10);
                if (i10 > 0) {
                    x1.f1.lb.marquee.a.f20738a.v(i10);
                }
            } catch (Throwable th) {
                f.logger.error("set promotion_trial_days failure", th);
            }
        }

        r() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$r0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class r0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            long jD = dc.a.d(v10, f.heartbeatInterval);
            if (jD > 30) {
                f.heartbeatInterval = jD * ((long) 1000);
            }
        }

        r0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$r1", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class r1 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            f.customerServiceEmail = v10;
        }

        r1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$s", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class s implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                List<String> listZ0 = ua.n.z0(v10, new String[]{"$$"}, false, 0, 6, null);
                if (listZ0.isEmpty()) {
                    return;
                }
                x1.f1.lb.marquee.a.f20738a.w(listZ0);
            } catch (Throwable th) {
                f.logger.error("set promotion_trial_days failure", th);
            }
        }

        s() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$s0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class s0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                int i10 = Integer.parseInt(v10);
                if (i10 > 1) {
                    x1.f1.lb.util.c.f21341a.r(i10);
                }
            } catch (Throwable th) {
                f.logger.error("set log dropped frames failure", th);
            }
        }

        s0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.heartbeat.HeartbeatUpgradeManager$checkUpgrade$1", f = "HeartbeatUpgradeManager.kt", l = {899, 899}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class s1 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super UpgradeInfo>, v8.f<? super r8.z>, Object> {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ c9.r<String, Integer, String, nf.a0, r8.z> $onProgress;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.heartbeat.HeartbeatUpgradeManager$checkUpgrade$1$1", f = "HeartbeatUpgradeManager.kt", l = {908}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lz1/b1/lb/m/ptv/ApiResponse;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "Lr8/z;", "<anonymous>", "(Lz1/b1/lb/m/ptv/ApiResponse;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<ApiResponse<UpgradeInfo>, v8.f<? super r8.z>, Object> {
            final /* synthetic */ kotlinx.coroutines.flow.g<UpgradeInfo> $$this$flow;
            final /* synthetic */ Lifecycle $lifecycle;
            final /* synthetic */ c9.r<String, Integer, String, nf.a0, r8.z> $onProgress;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(Lifecycle lifecycle, c9.r<? super String, ? super Integer, ? super String, ? super nf.a0, r8.z> rVar, kotlinx.coroutines.flow.g<? super UpgradeInfo> gVar, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$lifecycle = lifecycle;
                this.$onProgress = rVar;
                this.$$this$flow = gVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                a aVar = new a(this.$lifecycle, this.$onProgress, this.$$this$flow, fVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // c9.p
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ApiResponse<UpgradeInfo> apiResponse, v8.f<? super r8.z> fVar) {
                return ((a) create(apiResponse, fVar)).invokeSuspend(r8.z.f17874a);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type v8.f to x1.f1.lb.heartbeat.f$s1$a for r9v1 'this'  v8.f
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.a
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
                    int r1 = r9.label
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    r8.r.b(r10)
                    goto L58
                Lf:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L17:
                    r8.r.b(r10)
                    java.lang.Object r10 = r9.L$0
                    z1.b1.lb.m.ptv.ApiResponse r10 = (z1.b1.lb.m.ptv.ApiResponse) r10
                    int r1 = r10.getErrCode()
                    if (r1 != 0) goto L5b
                    java.lang.Object r1 = r10.getData()
                    if (r1 == 0) goto L49
                    x1.f1.lb.heartbeat.f r1 = x1.f1.lb.heartbeat.f.f20678a
                    java.lang.Object r1 = r10.getData()
                    z1.b1.lb.m.extra.upgrade.UpgradeInfo r1 = (z1.b1.lb.m.extra.upgrade.UpgradeInfo) r1
                    x1.f1.lb.heartbeat.f.F(r1)
                    x1.f1.lb.heartbeat.f r3 = x1.f1.lb.heartbeat.f.f20678a
                    long r4 = x1.f1.lb.util.d1.c()
                    java.lang.Object r1 = r10.getData()
                    r6 = r1
                    z1.b1.lb.m.extra.upgrade.UpgradeInfo r6 = (z1.b1.lb.m.extra.upgrade.UpgradeInfo) r6
                    androidx.lifecycle.Lifecycle r7 = r9.$lifecycle
                    c9.r<java.lang.String, java.lang.Integer, java.lang.String, nf.a0, r8.z> r8 = r9.$onProgress
                    x1.f1.lb.heartbeat.f.m(r3, r4, r6, r7, r8)
                L49:
                    kotlinx.coroutines.flow.g<z1.b1.lb.m.extra.upgrade.UpgradeInfo> r1 = r9.$$this$flow
                    java.lang.Object r10 = r10.getData()
                    r9.label = r2
                    java.lang.Object r10 = r1.emit(r10, r9)
                    if (r10 != r0) goto L58
                    return r0
                L58:
                    r8.z r10 = r8.z.f17874a
                    return r10
                L5b:
                    java.lang.Exception r0 = new java.lang.Exception
                    x1.f1.lb.util.e r1 = x1.f1.lb.util.e.f21383a
                    java.lang.String r10 = r1.a(r10)
                    r0.<init>(r10)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.heartbeat.f.s1.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        s1(Lifecycle lifecycle, c9.r<? super String, ? super Integer, ? super String, ? super nf.a0, r8.z> rVar, v8.f<? super s1> fVar) {
            super(2, fVar);
            this.$lifecycle = lifecycle;
            this.$onProgress = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            s1 s1Var = new s1(this.$lifecycle, this.$onProgress, fVar);
            s1Var.L$0 = obj;
            return s1Var;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super UpgradeInfo> gVar, v8.f<? super r8.z> fVar) {
            return ((s1) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (r8 == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Exception {
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
                com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
                if (!(aVar instanceof com.skydoves.sandwich.a.b)) {
                    if (!(aVar instanceof com.skydoves.sandwich.a.b.C0152b)) {
                        if (!(aVar instanceof com.skydoves.sandwich.a.b.C0151a)) {
                            return r8.z.f17874a;
                        }
                        throw new Exception(x1.f1.lb.util.v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar));
                    }
                    throw new Exception(x1.f1.lb.util.v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar));
                }
                throw new Exception(x1.f1.lb.util.v0.f21450a.c((com.skydoves.sandwich.a.b) aVar));
            }
            r8.r.b(obj);
            gVar = (kotlinx.coroutines.flow.g) this.L$0;
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            this.L$0 = gVar;
            this.label = 1;
            obj = iVar.o(this);
            if (obj != objC) {
            }
            return objC;
            a aVar2 = new a(this.$lifecycle, this.$onProgress, gVar, null);
            this.L$0 = null;
            this.label = 2;
            obj = com.skydoves.sandwich.c.g((com.skydoves.sandwich.a) obj, aVar2, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$t", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class t implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                long j10 = Long.parseLong(v10);
                if (j10 <= 0 || j10 >= 14400) {
                    return;
                }
                x1.f1.lb.marquee.a.f20738a.x(j10 * ((long) 60000));
            } catch (Throwable th) {
                f.logger.error("set marquee_update_interval_minutes failure", th);
            }
        }

        t() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$t0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class t0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                f.planHtml = v10;
            } catch (Throwable th) {
                f.logger.error("set log dropped frames failure", th);
            }
        }

        t0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.heartbeat.HeartbeatUpgradeManager$doHeartbeatRequest$1", f = "HeartbeatUpgradeManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class t1 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        t1(v8.f<? super t1> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new t1(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((t1) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                try {
                    x1.f1.lb.user.f.f21202a.W();
                } catch (Throwable th) {
                    f.logger.error("auto login failure", th);
                }
                x1.f1.lb.user.f fVar = x1.f1.lb.user.f.f21202a;
                String strB0 = fVar.B0();
                String strB1 = fVar.b0();
                if (!kotlin.jvm.internal.m.a(strB0, "") && !kotlin.jvm.internal.m.a(strB1, "")) {
                    return r8.z.f17874a;
                }
                if (x1.f1.lb.config.b.f20643a.t()) {
                    f.logger.debug("heartbeat not ready uid[{}] accessToken[{}]", strB0, strB1);
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$u", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class u implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.marquee.a.f20738a.t(Boolean.parseBoolean(v10));
            } catch (Throwable th) {
                f.logger.error("set marquee_alternately_display failure", th);
            }
        }

        u() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$u0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class u0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                String lowerCase = v10.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.m.e(lowerCase, "toLowerCase(...)");
                bVar.F(kotlin.jvm.internal.m.a(lowerCase, "ts") ? "TS" : "HLS");
            } catch (Throwable th) {
                f.logger.error("set log dropped frames failure", th);
            }
        }

        u0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.heartbeat.HeartbeatUpgradeManager$heartBeat$1", f = "HeartbeatUpgradeManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class u1 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ long $now;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u1(long j10, v8.f<? super u1> fVar) {
            super(2, fVar);
            this.$now = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new u1(this.$now, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((u1) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                try {
                    if (x1.f1.lb.user.f.f21202a.S0()) {
                        x1.f1.lb.media.a.P(x1.f1.lb.media.a.f20755a, this.$now, false, false, 6, null);
                    }
                } catch (Throwable th) {
                    f.logger.error("load channel list in heartbeat failure", th);
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$v", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class v implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                long j10 = Long.parseLong(v10);
                if (j10 >= 300000) {
                    f.autoLoginBeforeTokenExpired = j10;
                }
            } catch (Throwable th) {
                f.logger.error("set auto login before token expired failure", th);
            }
        }

        v() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$v0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class v0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                int i10 = Integer.parseInt(v10);
                if (i10 > 0) {
                    x1.f1.lb.config.b.f20643a.D(Integer.valueOf(i10));
                }
            } catch (Throwable th) {
                f.logger.error("set log dropped frames failure[" + v10 + "]", th);
            }
        }

        v0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.heartbeat.HeartbeatUpgradeManager$installApk$1", f = "HeartbeatUpgradeManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class v1 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ String $apkFile;
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v1(Context context, String str, v8.f<? super v1> fVar) {
            super(2, fVar);
            this.$context = context;
            this.$apkFile = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new v1(this.$context, this.$apkFile, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((v1) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                boolean zI = x1.f1.lb.util.m0.f21410a.i(this.$context, this.$apkFile);
                if (x1.f1.lb.config.b.f20643a.t()) {
                    f.logger.debug("installApk [{} -> {}]", this.$apkFile, kotlin.coroutines.jvm.internal.b.a(zI));
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$w", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class w implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            x1.f1.lb.util.w0.f21452a.t("startup_ad_list", v10);
        }

        w() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$w0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class w0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.L(v6.d.f(Integer.parseInt(v10)));
            } catch (Throwable th) {
                f.logger.error("set log ts push mode failure[" + v10 + "]", th);
            }
        }

        w0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"x1/f1/lb/heartbeat/f$w1", "Lx1/f1/lb/util/b0$c;", "Ljava/io/File;", "file", "", "l", "(Ljava/io/File;)Z", "k", "f", "g", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class w1 extends x1.f1.lb.util.b0.c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.b0<Integer> f20708h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.b0<String> f20709i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ UpgradeInfo f20710j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w1(kotlin.jvm.internal.b0<Integer> b0Var, kotlin.jvm.internal.b0<String> b0Var2, UpgradeInfo upgradeInfo, String str, String str2, x1 x1Var) {
            super(str, str2, "upgrade.apk", false, x1Var);
            this.f20708h = b0Var;
            this.f20709i = b0Var2;
            this.f20710j = upgradeInfo;
            kotlin.jvm.internal.m.c(str);
        }

        private final boolean k(File file) {
            String digestAlgorithm = this.f20710j.getDigestAlgorithm();
            if (digestAlgorithm != null) {
                int iHashCode = digestAlgorithm.hashCode();
                if (iHashCode != 107902) {
                    return iHashCode != 113836 ? x1.f1.lb.util.b0.f21310a.o(file, this.f20710j.getChecksum(), this.f20710j.getSize()) : x1.f1.lb.util.b0.f21310a.o(file, this.f20710j.getChecksum(), this.f20710j.getSize());
                }
                if (digestAlgorithm.equals("md5")) {
                    return x1.f1.lb.util.b0.f21310a.m(file, this.f20710j.getChecksum(), this.f20710j.getSize());
                }
            }
            f.logger.warn("upgrade: unknown digest algorithm[{}], will verify checksum with md5", this.f20710j.getDigestAlgorithm());
            return x1.f1.lb.util.b0.f21310a.m(file, this.f20710j.getChecksum(), this.f20710j.getSize());
        }

        @Override // x1.f1.lb.util.b0.d
        public boolean f(File file) {
            kotlin.jvm.internal.m.f(file, "file");
            return l(file);
        }

        @Override // x1.f1.lb.util.b0.d
        public boolean g(File file) {
            kotlin.jvm.internal.m.f(file, "file");
            return l(file);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
        private final boolean l(File file) {
            T t10;
            if (k(file)) {
                r8.p<Integer, String> pVarL = x1.f1.lb.util.m0.f21410a.l(file);
                if (pVarL != null) {
                    this.f20708h.element = pVarL.c();
                    kotlin.jvm.internal.b0<String> b0Var = this.f20709i;
                    String strD = pVarL.d();
                    if (strD == null) {
                        t10 = strD;
                        t10 = "";
                    }
                    t10 = strD;
                    b0Var.element = t10;
                    return true;
                }
                return true;
            }
            if (file.length() == this.f20710j.getSize()) {
                getTryTimes().set(0);
                this.f20708h.element = 2;
            } else {
                this.f20708h.element = 3;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$x", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class x implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            HashSet hashSet;
            kotlin.jvm.internal.m.f(v10, "v");
            f fVar = f.f20678a;
            if (v10.length() == 0) {
                hashSet = new HashSet();
            } else {
                HashSet hashSet2 = new HashSet();
                Iterator it = ua.n.z0(v10, new String[]{","}, false, 0, 6, null).iterator();
                while (it.hasNext()) {
                    hashSet2.add(ua.n.Q0((String) it.next()).toString());
                }
                hashSet = hashSet2;
            }
            f.emailBeBlockedHosts = hashSet;
        }

        x() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$x0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class x0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.z(Boolean.parseBoolean(v10));
            } catch (Throwable th) {
                f.logger.error("set display member site failure[" + v10 + "]", th);
            }
        }

        x0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"x1/f1/lb/heartbeat/f$x1", "Lx1/f1/lb/util/b0$f;", "", "savedPath", "Lr8/z;", "b", "(Ljava/lang/String;)V", "", "progress", "c", "(I)V", "", "e", "a", "(Ljava/lang/Throwable;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class x1 implements x1.f1.lb.util.b0.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UpgradeInfo f20711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.b0<Throwable> f20712b;

        x1(UpgradeInfo upgradeInfo, kotlin.jvm.internal.b0<Throwable> b0Var) {
            this.f20711a = upgradeInfo;
            this.f20712b = b0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // x1.f1.lb.util.b0.f
        public void a(Throwable e10) {
            kotlin.jvm.internal.m.f(e10, "e");
            this.f20712b.element = e10;
        }

        @Override // x1.f1.lb.util.b0.f
        public void b(String savedPath) {
            kotlin.jvm.internal.m.f(savedPath, "savedPath");
        }

        @Override // x1.f1.lb.util.b0.f
        public void c(int progress) {
            c9.r rVar = f.mOnProgress;
            if (rVar != null) {
                String versionName = this.f20711a.getVersionName();
                kotlin.jvm.internal.m.e(versionName, "getVersionName(...)");
                rVar.invoke(versionName, Integer.valueOf(progress), null, null);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$y", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class y implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            if (v10.length() == 0) {
                return;
            }
            x1.f1.lb.media.c.f20788a.s(Boolean.parseBoolean(v10));
        }

        y() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$y0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class y0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.M(Boolean.parseBoolean(v10));
            } catch (Throwable th) {
                f.logger.error("set display member site failure[" + v10 + "]", th);
            }
        }

        y0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"x1/f1/lb/heartbeat/f$y1", "Ljava/lang/Runnable;", "Lr8/z;", "run", "()V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInRunning", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class y1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final AtomicBoolean isInRunning = new AtomicBoolean(false);

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.heartbeat.HeartbeatUpgradeManager$subscribeExecRunnable$1$run$1", f = "HeartbeatUpgradeManager.kt", l = {145}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            int label;

            a(v8.f<? super a> fVar) {
                super(2, fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                    x1.f1.lb.media.a aVar = x1.f1.lb.media.a.f20755a;
                    this.label = 1;
                    if (aVar.q(10000L, this) == objC) {
                        return objC;
                    }
                }
                return r8.z.f17874a;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.isInRunning.compareAndSet(false, true)) {
                f.logger.warn("execute subscribe is in running, ignored", new Object[0]);
                return;
            }
            try {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new a(null), 3, null);
                this.isInRunning.set(false);
            } catch (Throwable th) {
                try {
                    f.logger.error("execute subscribe in heartbeat failure", th);
                    r8.z zVar = r8.z.f17874a;
                } finally {
                    this.isInRunning.set(false);
                }
            }
        }

        y1() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$z", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class z implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            f.blockEmailHostTip = v10;
        }

        z() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/heartbeat/f$z0", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class z0 implements x1.f1.lb.util.m<String> {
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(String v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            try {
                x1.f1.lb.config.b.f20643a.I(Boolean.parseBoolean(v10));
            } catch (Throwable th) {
                f.logger.error("set is report metric failure[" + v10 + "]", th);
            }
        }

        z0() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.heartbeat.HeartbeatUpgradeManager$upgradeAction$1$1", f = "HeartbeatUpgradeManager.kt", l = {968, 968}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class z1 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ long $startTime;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.heartbeat.HeartbeatUpgradeManager$upgradeAction$1$1$1", f = "HeartbeatUpgradeManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lz1/b1/lb/m/ptv/ApiResponse;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<ApiResponse<UpgradeInfo>, v8.f<? super Object>, Object> {
            final /* synthetic */ long $startTime;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(long j10, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$startTime = j10;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                a aVar = new a(this.$startTime, fVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // c9.p
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ApiResponse<UpgradeInfo> apiResponse, v8.f<Object> fVar) {
                return ((a) create(apiResponse, fVar)).invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    ApiResponse apiResponse = (ApiResponse) this.L$0;
                    if (apiResponse.getErrCode() != 0) {
                        return x1.f1.lb.util.e.f21383a.a(apiResponse);
                    }
                    try {
                        f fVar = f.f20678a;
                        f.lastUpgradeData = (UpgradeInfo) apiResponse.getData();
                        f.B0(f.f20678a, this.$startTime, (UpgradeInfo) apiResponse.getData(), null, null, 12, null);
                    } catch (Throwable th) {
                        f.logger.error("on upgrade failure", th);
                    }
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z1(long j10, v8.f<? super z1> fVar) {
            super(2, fVar);
            this.$startTime = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new z1(this.$startTime, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((z1) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
        
            if (r7 == r0) goto L15;
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
                com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
                if (aVar instanceof com.skydoves.sandwich.a.b) {
                    f.f20678a.C0(x1.f1.lb.util.v0.f21450a.c((com.skydoves.sandwich.a.b) aVar));
                }
                if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                    f.f20678a.C0(x1.f1.lb.util.v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar));
                }
                if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                    f.f20678a.C0(x1.f1.lb.util.v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar));
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            x1.f1.lb.api.i iVar = x1.f1.lb.api.i.f20569a;
            this.label = 1;
            obj = iVar.o(this);
            if (obj != objC) {
            }
            return objC;
            a aVar2 = new a(this.$startTime, null);
            this.label = 2;
            obj = com.skydoves.sandwich.c.g((com.skydoves.sandwich.a) obj, aVar2, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x039a A[Catch: all -> 0x03a9, TryCatch #1 {all -> 0x03a9, blocks: (B:11:0x039a, B:14:0x03ab, B:8:0x038c, B:5:0x0384), top: B:21:0x037b, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x03ab A[Catch: all -> 0x03a9, TRY_LEAVE, TryCatch #1 {all -> 0x03a9, blocks: (B:11:0x039a, B:14:0x03ab, B:8:0x038c, B:5:0x0384), top: B:21:0x037b, inners: #2 }] */
    static {
        Timer timer2;
        Timer timer3 = null;
        ConcurrentHashMap<String, x1.f1.lb.util.m<String>> concurrentHashMap = new ConcurrentHashMap<>();
        propertiesHandlers = concurrentHashMap;
        lastUpgradeCheckTime = x1.f1.lb.util.d1.c();
        lastHeartbeatTime = x1.f1.lb.util.d1.c();
        lastMetricHeartbeatTime = x1.f1.lb.util.d1.c();
        emailBeBlockedHosts = new HashSet<>();
        blockEmailHostTip = "";
        startUpCountNum = 6;
        guestTrialEndTipText = "";
        guestTrialEndImgUrl = "";
        memberTrialEndTipText = "";
        memberTrialEndImgUrl = "";
        subtitleDftLang = "PT";
        subtitleLanguageList = kotlin.collections.r.o("EN", "PT");
        planHtml = "";
        feedbackLogcatExecuteDuration = 3;
        initCountDownLatch = new CountDownLatch(1);
        executorService = x1.f1.lb.util.n.f21413l;
        subscribeExecRunnable = new y1();
        expire_remind_seconds = 259200;
        daily_remind_times = 10;
        isOnUpgrade = new AtomicBoolean(false);
        concurrentHashMap.put("IS_DEVICE_FREE", new k());
        concurrentHashMap.put("AUTO_LOGIN_BEFORE_TOKEN_EXPIRED", new v());
        concurrentHashMap.put("AUTO_REFRESH_ACCESS_TOKEN_INTERVAL", new g0());
        concurrentHashMap.put("HEART_BEAT_INTERVAL", new r0());
        concurrentHashMap.put("UPGRADE_CHECK_INTERVAL", new c1());
        concurrentHashMap.put("METRIC_HEART_BEAT_INTERVAL", new n1());
        concurrentHashMap.put("ECO_MODE_TIME_MINUTES", new p1());
        concurrentHashMap.put("customer_service_qrcode", new q1());
        concurrentHashMap.put("customer_service_email", new r1());
        concurrentHashMap.put("customer_whatsapp_link", new a());
        concurrentHashMap.put("customer_service_whatsapp", new b());
        concurrentHashMap.put("customer_service_telegram", new c());
        concurrentHashMap.put("customer_service_facebook", new d());
        concurrentHashMap.put("expire_remind_seconds", new e());
        concurrentHashMap.put("daily_remind_times", new C0413f());
        concurrentHashMap.put("re_login_max_cnt_after_expired", new g());
        concurrentHashMap.put("how2order", new h());
        concurrentHashMap.put("udp_log_servers", new i());
        concurrentHashMap.put("promotion_trial_days", new j());
        concurrentHashMap.put("prompt_renew_plan_left_hours", new l());
        concurrentHashMap.put("promotion_trial_days", new m());
        concurrentHashMap.put("membership_qrcode_refresh_interval", new n());
        concurrentHashMap.put("eco_mode_pics", new o());
        concurrentHashMap.put("marquee_display_interval", new p());
        concurrentHashMap.put("login_retry_interval_seconds", new q());
        concurrentHashMap.put("marquee_display_times", new r());
        concurrentHashMap.put("marquee_display_contents", new s());
        concurrentHashMap.put("marquee_update_interval_minutes", new t());
        concurrentHashMap.put("marquee_alternately_display", new u());
        concurrentHashMap.put("ad_list", new w());
        concurrentHashMap.put("email_be_blocked_host_list", new x());
        concurrentHashMap.put("is_epg_enable", new y());
        concurrentHashMap.put("email_host_block_tip", new z());
        concurrentHashMap.put("start_up_ad_count_num", new a0());
        concurrentHashMap.put("meta_update_min_interval_sec", new b0());
        concurrentHashMap.put("guest_trial_end_player_tip_text", new c0());
        concurrentHashMap.put("member_trial_end_player_tip_text", new d0());
        concurrentHashMap.put("guest_trial_end_player_tip_img_url", new e0());
        concurrentHashMap.put("member_trial_end_player_tip_img_url", new f0());
        concurrentHashMap.put("is_show_register_first_for_new_user", new h0());
        concurrentHashMap.put("subtitle_dft_lang", new i0());
        concurrentHashMap.put("subtitle_lang_list", new j0());
        concurrentHashMap.put("is_report_client_detail_log", new k0());
        concurrentHashMap.put("is_telegram_bot_enable", new l0());
        concurrentHashMap.put("is_remind_after_plan_expired", new m0());
        concurrentHashMap.put("is_remind_plan_not_bind_username", new n0());
        concurrentHashMap.put("plan_will_expire_remind", new o0());
        concurrentHashMap.put("zapping_time_bot_when_gt_seconds", new p0());
        concurrentHashMap.put("log_main_thread_block_gt_millis", new q0());
        concurrentHashMap.put("log_dropped_frames_gt", new s0());
        concurrentHashMap.put("plan_html", new t0());
        concurrentHashMap.put("player_proxy_type", new u0());
        concurrentHashMap.put("max_downloading_block_cnt", new v0());
        concurrentHashMap.put("ts_push_mode", new w0());
        concurrentHashMap.put("display_member_site", new x0());
        concurrentHashMap.put("verify_channel_when_upgrade", new y0());
        concurrentHashMap.put("is_report_metric", new z0());
        concurrentHashMap.put("has_subject", new a1());
        concurrentHashMap.put("share_app_tip", new b1());
        concurrentHashMap.put("share_app_info", new d1());
        concurrentHashMap.put("has_referral_summary", new e1());
        concurrentHashMap.put("refresh_sports_minutes", new f1());
        concurrentHashMap.put("catchup_dvr_days", new g1());
        concurrentHashMap.put("has_catchup", new h1());
        concurrentHashMap.put("mobile_app_qrcode", new i1());
        concurrentHashMap.put("ad_list_ext", new j1());
        concurrentHashMap.put("feedback_logcat_exe_duration", new k1());
        concurrentHashMap.put("feedback_exe_did", new l1());
        concurrentHashMap.put("mb_tb_flt_mils", new m1());
        try {
            try {
                try {
                    timer2 = new Timer("heartbeat", true);
                } catch (Throwable unused) {
                    timer3 = new Timer();
                    timer2 = timer3;
                    if (timer2 != null) {
                        timer = timer2;
                        timer2.schedule(new o1(), CoroutineLiveDataKt.DEFAULT_TIMEOUT, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                    } else {
                        executorService.execute(new Runnable() { // from class: x1.f1.lb.heartbeat.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                f.f();
                            }
                        });
                    }
                    initCountDownLatch.countDown();
                    upgradeAction = new Runnable() { // from class: x1.f1.lb.heartbeat.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.O0();
                        }
                    };
                }
            } catch (Throwable th) {
                logger.error("init timer failure", th);
                timer2 = timer3;
            }
            if (timer2 != null) {
                timer = timer2;
                timer2.schedule(new o1(), CoroutineLiveDataKt.DEFAULT_TIMEOUT, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            } else {
                executorService.execute(new Runnable() { // from class: x1.f1.lb.heartbeat.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.f();
                    }
                });
            }
        } catch (Throwable th2) {
            logger.warn("heartbeat failure", th2);
        }
        initCountDownLatch.countDown();
        upgradeAction = new Runnable() { // from class: x1.f1.lb.heartbeat.b
            @Override // java.lang.Runnable
            public final void run() {
                f.O0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v41, types: [T, java.lang.Integer] */
    public final void A0(long startTime, UpgradeInfo upgradeInfo, Lifecycle lifecycle, c9.r<? super String, ? super Integer, ? super String, ? super nf.a0, r8.z> onProgress) {
        String str;
        x1.f1.lb.util.z zVar;
        String strB;
        String strP;
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.t()) {
            logger.debug("apiExtra upgrade[ {} ]", upgradeInfo);
        }
        if (upgradeInfo == null || upgradeInfo.getUpgradeStatus() == 0) {
            return;
        }
        if (onProgress != null) {
            mOnProgress = onProgress;
            mLifecycle = lifecycle;
        }
        if (isOnUpgrade.compareAndSet(false, true)) {
            try {
                tf.g gVarA = x1.f1.lb.metric.monitor.i.f20958a.a();
                gVarA.n(upgradeInfo.getVersionName());
                gVarA.k(startTime);
                gVarA.o(x1.f1.lb.util.d1.c() - startTime);
                x1.f1.lb.util.z zVar2 = x1.f1.lb.util.z.f21470a;
                long jL = zVar2.l();
                kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
                kotlin.jvm.internal.b0 b0Var2 = new kotlin.jvm.internal.b0();
                kotlin.jvm.internal.b0 b0Var3 = new kotlin.jvm.internal.b0();
                b0Var3.element = "";
                w1 w1Var = new w1(b0Var2, b0Var3, upgradeInfo, upgradeInfo.getUrl(), x1.f1.lb.util.b1.f21324a.f(), new x1(upgradeInfo, b0Var));
                w1Var.getTryTimes().set(2);
                String absolutePath = w1Var.getFile().getAbsolutePath();
                if (x1.f1.lb.util.b0.h(x1.f1.lb.util.b0.f21310a, w1Var, false, null, 6, null) && b0Var2.element == 0) {
                    gVarA.h(x1.f1.lb.util.d1.c());
                    c9.r<? super String, ? super Integer, ? super String, ? super nf.a0, r8.z> rVar = mOnProgress;
                    if (rVar == null) {
                        xe.c.c().o(new nf.z(upgradeInfo, absolutePath));
                    } else {
                        Lifecycle lifecycle2 = mLifecycle;
                        if ((lifecycle2 != null ? lifecycle2.getState() : null) == Lifecycle.State.DESTROYED) {
                            xe.c.c().o(new nf.z(upgradeInfo, absolutePath));
                        } else {
                            String versionName = upgradeInfo.getVersionName();
                            kotlin.jvm.internal.m.e(versionName, "getVersionName(...)");
                            rVar.invoke(versionName, 100, absolutePath, null);
                        }
                    }
                } else {
                    gVarA.j(x1.f1.lb.util.d1.c());
                    long size = upgradeInfo.getSize() / ((long) 1024);
                    if (b0Var2.element == 0 && size > jL) {
                        b0Var2.element = 0;
                    }
                    gVarA.j(x1.f1.lb.util.d1.c());
                    if (TextUtils.isEmpty(gVarA.b())) {
                        Integer num = (Integer) b0Var2.element;
                        if (num != null && num.intValue() == 0) {
                            strP = bVar.p(R$string.not_enough_space_to_upgrade, "not enough rom");
                        } else if (num != null && num.intValue() == 3) {
                            strP = bVar.p(R$string.upgrade_file_mismatch, "file size mismatched");
                        } else {
                            if (num != null && num.intValue() == 2) {
                                strP = bVar.p(R$string.file_checksum_mismatch, "checksum mismatched");
                            } else if (num != null && num.intValue() == 4) {
                                int i10 = R$string.file_channel_mismatch;
                                String strF = of.a.f16585a.f();
                                Object obj = b0Var3.element;
                                str = "getVersionName(...)";
                                StringBuilder sb2 = new StringBuilder();
                                zVar = zVar2;
                                sb2.append("app channel mismatched, expect[");
                                sb2.append(strF);
                                sb2.append("] but[");
                                sb2.append(obj);
                                sb2.append("]");
                                strP = bVar.p(i10, sb2.toString());
                            } else {
                                str = "getVersionName(...)";
                                zVar = zVar2;
                                if (num != 0 && num.intValue() == 5) {
                                    strP = bVar.p(R$string.file_app_type_mismatch, "app type mismatched, expect[" + of.a.f16585a.c() + "] but[" + b0Var3.element + "]");
                                } else {
                                    strP = bVar.p(R$string.upgrade_unknown_failure, "unknown error");
                                }
                            }
                            gVarA.i(strP);
                        }
                        str = "getVersionName(...)";
                        zVar = zVar2;
                        gVarA.i(strP);
                    } else {
                        str = "getVersionName(...)";
                        zVar = zVar2;
                    }
                    boolean z10 = mOnProgress != null;
                    Integer num2 = (Integer) b0Var2.element;
                    String str2 = str;
                    nf.a0 a0Var = new nf.a0(z10, upgradeInfo, num2 != null ? num2.intValue() : 1, gVarA.b(), (Throwable) b0Var.element);
                    c9.r<? super String, ? super Integer, ? super String, ? super nf.a0, r8.z> rVar2 = mOnProgress;
                    if (rVar2 == null) {
                        xe.c.c().o(a0Var);
                    } else {
                        Lifecycle lifecycle3 = mLifecycle;
                        if ((lifecycle3 != null ? lifecycle3.getState() : null) == Lifecycle.State.DESTROYED) {
                            xe.c.c().o(a0Var);
                        } else {
                            String versionName2 = upgradeInfo.getVersionName();
                            kotlin.jvm.internal.m.e(versionName2, str2);
                            rVar2.invoke(versionName2, 100, null, a0Var);
                        }
                    }
                    if (size > jL) {
                        strB = "no space to upgrade app, required[" + size + "KB] but free[" + zVar.l() + "KB]";
                    } else {
                        strB = gVarA.b();
                    }
                    if (b0Var.element == 0) {
                        logger.error("upgrade apk to [{}] failure [{}]", upgradeInfo.getVersionName(), strB);
                    } else {
                        logger.error("upgrade apk to [{}] failure [{}]", upgradeInfo.getVersionName(), strB, b0Var.element);
                    }
                    x1.f1.lb.bot.a.f20583a.l("[upgrade failure]\n" + strB);
                    uf.c.f19486a.s();
                }
                boolean z11 = false;
            } finally {
                isOnUpgrade.set(false);
            }
        }
    }

    private final boolean y0(long now, long lastTime, long interval) {
        long j10 = now - lastTime;
        return j10 < 0 || j10 > interval;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void B0(f fVar, long j10, UpgradeInfo upgradeInfo, Lifecycle lifecycle, c9.r rVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            lifecycle = null;
        }
        if ((i10 & 8) != 0) {
            rVar = null;
        }
        fVar.A0(j10, upgradeInfo, lifecycle, rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0(String errMessage) {
        tf.g gVarA = x1.f1.lb.metric.monitor.i.f20958a.a();
        gVarA.q(x1.f1.lb.util.d1.c());
        gVarA.p(errMessage);
        logger.error("upgrade failure " + errMessage, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(Context context, String str) {
        f20678a.v0(context, str);
    }

    private final void Z() {
        kotlinx.coroutines.j.d(puckScope, null, null, new t1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Infinite loop detected, blocks: 13, insns: 0 */
    public static final void f() {
        while (true) {
            try {
                f20678a.s0();
                Thread.sleep(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            } catch (InterruptedException e10) {
                logger.error("heartbeat failure", e10);
            } catch (Throwable th) {
                logger.error("heartbeat failure", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0() {
        if (isRun) {
            long jC = x1.f1.lb.util.d1.c();
            x1.f1.lb.marquee.a.f20738a.o(jC);
            try {
                uf.c cVar = uf.c.f19486a;
                if (!cVar.g()) {
                    tf.e eVarE = x1.f1.lb.metric.monitor.h.f20952a.e();
                    long jK = eVarE != null ? eVarE.k() : 0L;
                    if (jK > 0 && jC - jK > FileWatchdog.DEFAULT_DELAY) {
                        cVar.p();
                    }
                }
            } catch (Throwable th) {
                logger.error("report startup metric in heartbeat failure", th);
            }
            subscribeExecRunnable.run();
            kotlinx.coroutines.j.d(puckScope, null, null, new u1(jC, null), 3, null);
            try {
                x1.f1.lb.media.c.f20788a.q(jC);
            } catch (Throwable th2) {
                logger.error("check and update epg in heartbeat failure", th2);
            }
            try {
                x1.f1.lb.media.j.f20845a.w();
            } catch (Throwable th3) {
                logger.error("check and update sports failure", th3);
            }
            if (y0(jC, lastUpgradeCheckTime, upgradeCheckingInterval)) {
                upgradeAction.run();
                lastUpgradeCheckTime = jC;
            }
            if (y0(jC, lastMetricHeartbeatTime, metricHeartbeatInterval)) {
                lastMetricHeartbeatTime = jC;
                uf.c.f19486a.f();
            }
            x1.f1.lb.metric.monitor.e.f20898a.b();
            if (y0(jC, lastHeartbeatTime, heartbeatInterval)) {
                Z();
                lastHeartbeatTime = jC;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(AppCompatActivity appCompatActivity, ActivityResult activityResult2) {
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("register_activity_action: activity[{}], data[{}], resultCode[{}]", appCompatActivity.getClass().getCanonicalName(), activityResult2.getData(), Integer.valueOf(activityResult2.getResultCode()));
        }
        Runnable runnable = activityAction;
        if (runnable != null) {
            runnable.run();
        }
    }

    private final void v0(Context context, String apkFile) {
        kotlinx.coroutines.j.d(puckScope, null, null, new v1(context, apkFile, null), 3, null);
    }

    public final void D0(final Context context, int upgradePermissionDlgTitleTxtResId, int upgradePermissionDlgDescTxtResId, int upgradePermissionDlgBtnTxtResId, int logoDrawableResId, final String apkFile) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(apkFile, "apkFile");
        if (Build.VERSION.SDK_INT < 26) {
            v0(context, apkFile);
            return;
        }
        if (context.getPackageManager().canRequestPackageInstalls()) {
            v0(context, apkFile);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(upgradePermissionDlgTitleTxtResId);
        builder.setMessage(upgradePermissionDlgDescTxtResId);
        builder.setPositiveButton(upgradePermissionDlgBtnTxtResId, new DialogInterface.OnClickListener() { // from class: x1.f1.lb.heartbeat.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                f.E0(context, apkFile, dialogInterface, i10);
            }
        });
        builder.setCancelable(false);
        builder.setIcon(logoDrawableResId);
        AlertDialog alertDialogCreate = builder.create();
        kotlin.jvm.internal.m.e(alertDialogCreate, "create(...)");
        alertDialogCreate.show();
    }

    public final void G0() {
        Runnable runnable = activityAction;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void H0(String from) {
        kotlin.jvm.internal.m.f(from, "from");
        q6.b bVar = logger;
        UpgradeInfo upgradeInfo = lastUpgradeData;
        bVar.a("send upgrade version[" + (upgradeInfo != null ? upgradeInfo.getVersionName() : null) + "] to user, trigger from[" + from + "]", new Object[0]);
        UpgradeInfo upgradeInfo2 = lastUpgradeData;
        if (upgradeInfo2 != null) {
            try {
                B0(f20678a, x1.f1.lb.util.d1.c(), upgradeInfo2, null, null, 12, null);
            } catch (Throwable th) {
                logger.error("on upgrade failure", th);
            }
        }
    }

    public final void I0(int i10) {
        daily_remind_times = i10;
    }

    public final void J0(int i10) {
        expire_remind_seconds = i10;
    }

    public final void K0(Map<?, ?> properties) {
        String str;
        try {
            logger.a("set_param begin[has_subject:" + x1.f1.lb.config.b.f20643a.j() + "]", new Object[0]);
            if (properties == null) {
                return;
            }
            initCountDownLatch.await();
            int size = properties.size();
            ConcurrentHashMap<String, x1.f1.lb.util.m<String>> concurrentHashMap = propertiesHandlers;
            int size2 = concurrentHashMap.size();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i10 = 0;
            for (Map.Entry<String, x1.f1.lb.util.m<String>> entry : concurrentHashMap.entrySet()) {
                kotlin.jvm.internal.m.e(entry, "next(...)");
                Map.Entry<String, x1.f1.lb.util.m<String>> entry2 = entry;
                String key = entry2.getKey();
                kotlin.jvm.internal.m.e(key, "<get-key>(...)");
                String str2 = key;
                String str3 = of.a.f16585a.c() + "_" + str2;
                Object obj = properties.get(str3);
                if (obj == null) {
                    obj = properties.get(str2);
                    str = str2;
                } else {
                    str = str3;
                }
                x1.f1.lb.util.m<String> value = entry2.getValue();
                kotlin.jvm.internal.m.e(value, "<get-value>(...)");
                x1.f1.lb.util.m<String> mVar = value;
                if (obj == null) {
                    if (properties.containsKey(str3)) {
                        logger.warn("set_param got [" + ((Object) entry2.getKey()) + "] but value is null", new Object[0]);
                    }
                    if (properties.containsKey(str2)) {
                        logger.warn("set_param got [" + ((Object) entry2.getKey()) + "] but value is null", new Object[0]);
                    }
                } else {
                    try {
                        mVar.a(obj.toString());
                        linkedHashMap.put(str, obj);
                        i10++;
                    } catch (Throwable th) {
                        logger.error("set_param [" + ((Object) entry2.getKey()) + " -> " + obj + "] failure", th);
                        r8.z zVar = r8.z.f17874a;
                    }
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<?, ?> entry3 : properties.entrySet()) {
                if (!linkedHashMap.containsKey(entry3.getKey())) {
                    linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                }
            }
            if (!linkedHashMap2.isEmpty()) {
                logger.a("set_param ignoredProperties" + linkedHashMap2.keySet(), new Object[0]);
            }
            logger.a("set_param complete[" + i10 + "->" + linkedHashMap.size() + "/" + size + "][" + size2 + "][" + properties + "]", new Object[0]);
        } catch (Throwable th2) {
            logger.error("set_param failure", th2);
        }
    }

    public final void L0() {
        if (isRun) {
            logger.warn("heartbeat already started", new Object[0]);
        } else {
            isRun = true;
        }
    }

    public final String M0() {
        return subtitleDftLang;
    }

    public final List<String> N0() {
        return subtitleLanguageList;
    }

    public final kotlinx.coroutines.flow.f<UpgradeInfo> Y(Lifecycle lifecycle, c9.r<? super String, ? super Integer, ? super String, ? super nf.a0, r8.z> onProgress) {
        return kotlinx.coroutines.flow.h.v(new s1(lifecycle, onProgress, null));
    }

    public final long a0() {
        return autoLoginBeforeTokenExpired;
    }

    public final long b0() {
        return autoRefreshAccessTokenInterval;
    }

    public final String c0() {
        return customerServiceEmail;
    }

    public final String d0() {
        return customerServiceFacebook;
    }

    public final String e0() {
        return customerServiceWhatsapp;
    }

    public final String f0() {
        return customerServiceQrCodeImg;
    }

    public final String g0() {
        return customerServiceGroupWhatsappLink;
    }

    public final long h0() {
        return echoModeTime;
    }

    public final String i0() {
        return guestTrialEndImgUrl;
    }

    public final String j0() {
        return guestTrialEndTipText;
    }

    public final long k0() {
        return loginRetryIntervalMs;
    }

    public final String l0() {
        return memberTrialEndImgUrl;
    }

    public final String m0() {
        return memberTrialEndTipText;
    }

    public final long n0() {
        return metaUpdateMinIntervalMs;
    }

    public final String o0() {
        return mobileAppQrCodeImg;
    }

    public final int p0() {
        return promotionTrialDays;
    }

    public final long q0() {
        return promptRenewMillis;
    }

    public final int r0() {
        return qrcodeRefreshIntervalSeconds;
    }

    public final void t0(final AppCompatActivity activity) {
        kotlin.jvm.internal.m.f(activity, "activity");
        activityResult = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: x1.f1.lb.heartbeat.d
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                f.u0(activity, (ActivityResult) obj);
            }
        });
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("register_activity_action: activity[{}]", activity.getClass().getCanonicalName());
        }
        upgradeAction.run();
    }

    public final boolean w0() {
        Boolean bool = isFree;
        return bool != null ? bool.booleanValue() : x1.f1.lb.util.z.f21470a.z();
    }

    public final boolean x0() {
        return isReportClientDetail;
    }

    public final int z0() {
        Integer num = limitContinuingRenewDays;
        return num != null ? num.intValue() : promotionTrialDays;
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(final Context context, final String str, DialogInterface dialogInterface, int i10) {
        Uri uri = Uri.parse("package:" + context.getPackageName());
        Intent intent = new Intent();
        intent.setData(uri);
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
        } else {
            intent.setAction("android.settings.SECURITY_SETTINGS");
        }
        activityAction = new Runnable() { // from class: x1.f1.lb.heartbeat.e
            @Override // java.lang.Runnable
            public final void run() {
                f.F0(context, str);
            }
        };
        try {
            ActivityResultLauncher<Intent> activityResultLauncher = activityResult;
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(intent);
            }
        } catch (Throwable th) {
            x1.f1.lb.metric.monitor.i iVar = x1.f1.lb.metric.monitor.i.f20958a;
            tf.g gVarC = iVar.c();
            if (gVarC == null) {
                gVarC = iVar.a();
            }
            gVarC.m(r8.a.b(th));
            x1.f1.lb.util.g1.f21390a.c("request install permission failure:\n" + th.getMessage());
            logger.error("request install permission failure", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0() {
        kotlinx.coroutines.j.d(puckScope, null, null, new z1(x1.f1.lb.util.d1.c(), null), 3, null);
    }
}
