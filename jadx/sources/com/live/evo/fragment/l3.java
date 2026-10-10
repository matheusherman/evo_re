package com.live.evo.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.VerticalGridView;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.activity.LiveNewActivity;
import com.live.evo.widget.RechargeEditText;
import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.apache.log4j.helpers.FileWatchdog;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0002Û\u0001\u0018\u0000 V2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001dB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0006J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\u0006J\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u0006J\u000f\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0014H\u0002¢\u0006\u0004\b$\u0010\u0016J\u000f\u0010%\u001a\u00020\u0007H\u0002¢\u0006\u0004\b%\u0010\u0006J\u000f\u0010&\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010\u0006J\u000f\u0010'\u001a\u00020\u0007H\u0002¢\u0006\u0004\b'\u0010\u0006J\u000f\u0010(\u001a\u00020\u0007H\u0002¢\u0006\u0004\b(\u0010\u0006J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010\u0006J\u000f\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b*\u0010\u0006J1\u00101\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00142\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0007H\u0002¢\u0006\u0004\b5\u0010\u0006J\u000f\u00106\u001a\u00020\u0007H\u0002¢\u0006\u0004\b6\u0010\u0006J\u000f\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0004\b7\u0010\u0006J\u000f\u00108\u001a\u00020\u0007H\u0002¢\u0006\u0004\b8\u0010\u0006J1\u0010=\u001a\u00020\u00072\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b=\u0010>J1\u0010?\u001a\u00020\u00072\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b?\u0010>J\u000f\u0010A\u001a\u00020@H\u0014¢\u0006\u0004\bA\u0010BJ\u0019\u0010E\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010CH\u0014¢\u0006\u0004\bE\u0010FJ\u0019\u0010I\u001a\u00020\u00072\b\u0010H\u001a\u0004\u0018\u00010GH\u0014¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0007H\u0014¢\u0006\u0004\bK\u0010\u0006J\r\u0010L\u001a\u00020\u0007¢\u0006\u0004\bL\u0010\u0006J\u000f\u0010M\u001a\u00020\u0007H\u0016¢\u0006\u0004\bM\u0010\u0006J\u0017\u0010O\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0014H\u0016¢\u0006\u0004\bO\u0010\u001dJ\u000f\u0010P\u001a\u00020\u0007H\u0016¢\u0006\u0004\bP\u0010\u0006J\u000f\u0010Q\u001a\u00020\u0007H\u0016¢\u0006\u0004\bQ\u0010\u0006J\r\u0010R\u001a\u00020\u0007¢\u0006\u0004\bR\u0010\u0006J\r\u0010S\u001a\u00020\u0007¢\u0006\u0004\bS\u0010\u0006J\u0017\u0010U\u001a\u00020\u00072\u0006\u0010T\u001a\u00020GH\u0016¢\u0006\u0004\bU\u0010JJ\u001f\u0010V\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010+\u001a\u00020\u0014¢\u0006\u0004\bV\u0010WJ\u000f\u0010Y\u001a\u0004\u0018\u00010X¢\u0006\u0004\bY\u0010ZJ!\u0010\\\u001a\u00020\u00072\b\u0010T\u001a\u0004\u0018\u00010G2\u0006\u0010[\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u0007H\u0016¢\u0006\u0004\b^\u0010\u0006J\u001f\u0010`\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\r2\u0006\u0010;\u001a\u00020\rH\u0016¢\u0006\u0004\b`\u0010aJ#\u0010b\u001a\u00020\u00072\b\u0010_\u001a\u0004\u0018\u00010\r2\b\u0010;\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bb\u0010aJ\u000f\u0010c\u001a\u00020\u0007H\u0016¢\u0006\u0004\bc\u0010\u0006J\u000f\u0010d\u001a\u00020\u0007H\u0016¢\u0006\u0004\bd\u0010\u0006J\u000f\u0010e\u001a\u00020\u0007H\u0016¢\u0006\u0004\be\u0010\u0006J\u0019\u0010h\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010fH\u0007¢\u0006\u0004\bh\u0010iR\u001c\u0010m\u001a\n k*\u0004\u0018\u00010j0j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010lR$\u0010u\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010}\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0083\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0083\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0083\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0083\u0001R\u001a\u0010\u008e\u0001\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010\u007fR\u0019\u0010\u008f\u0001\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010\u007fR\u001a\u0010\u0091\u0001\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010\u007fR\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0083\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0083\u0001R\u001b\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\be\u0010\u0097\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0083\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u0083\u0001R\u0019\u0010\u009d\u0001\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010\u007fR\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u0083\u0001R\u001c\u0010¡\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010\u0083\u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001c\u0010§\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010\u0083\u0001R\u001a\u0010©\u0001\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¨\u0001\u0010\u007fR\u001c\u0010«\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u0083\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u0083\u0001R\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u0097\u0001R\u001c\u0010±\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010\u0083\u0001R\u001c\u0010³\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010\u0083\u0001R,\u0010»\u0001\u001a\u0005\u0018\u00010´\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R\u0019\u0010¾\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u0019\u0010À\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010¬\u0001R\u0019\u0010Â\u0001\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010¬\u0001R\u0019\u0010Å\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0019\u0010Ç\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010ª\u0001R\u001c\u0010Ë\u0001\u001a\u0005\u0018\u00010È\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u0018\u0010N\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Ä\u0001R\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010Í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001c\u0010Ô\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001b\u0010×\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u0019\u0010Ù\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010ª\u0001R\u0019\u0010Ú\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Ä\u0001R\u0017\u0010Ý\u0001\u001a\u00030Û\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0019\u0010Ü\u0001R\u0017\u0010à\u0001\u001a\u00030Þ\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b?\u0010ß\u0001R'\u0010ä\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bá\u0001\u0010Ä\u0001\u001a\u0005\bâ\u0001\u0010\u0016\"\u0005\bã\u0001\u0010\u001dR\u0016\u0010æ\u0001\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b6\u0010å\u0001¨\u0006ç\u0001"}, d2 = {"Lcom/live/evo/fragment/l3;", "Ll5/b;", "Lcom/live/evo/fragment/login/presenter/f;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnFocusChangeListener;", "<init>", "()V", "Lr8/z;", "M1", "l", "W0", "Z0", "p1", "", "renewKey", "q1", "(Ljava/lang/String;)V", "V0", "t1", "n1", "", "u1", "()Z", "s1", "Y0", "b1", "Y1", "layoutHide", "Q1", "(Z)V", "Z1", "r1", "X0", "a1", "d1", "c1", "Q0", "e1", "O1", "o1", "K1", "L1", "a2", "bMessage", "", "nowExpireTs", "responseExpiredTS", "Ljava/lang/Runnable;", "buttonAction", "R1", "(ZJJLjava/lang/Runnable;)V", "I1", "(Ljava/lang/Runnable;)V", "J1", "F1", "W1", "U0", "title", "message", "errorCode", "rightRun", "A1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V", "D1", "", "b0", "()I", "Landroid/os/Bundle;", "savedInstanceState", "c0", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "mRoot", "f0", "(Landroid/view/View;)V", "d0", "C1", "onResume", "isVisible", "h0", "onPause", "onDestroy", "m1", "P1", "v", "onClick", "G1", "(Ljava/lang/Runnable;Z)V", "Lziyi/kit/keyboard/b;", "R0", "()Lziyi/kit/keyboard/b;", "hasFocus", "onFocusChange", "(Landroid/view/View;Z)V", "e", IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, "i", "(Ljava/lang/String;Ljava/lang/String;)V", "C", "b", "a", "z", "Lb5/m;", NotificationCompat.CATEGORY_EVENT, "onUserTokenChangedEvent", "(Lb5/m;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Landroid/view/Window;", "m", "Landroid/view/Window;", "getMWindow", "()Landroid/view/Window;", "V1", "(Landroid/view/Window;)V", "mWindow", "Lcom/live/evo/fragment/y1;", "n", "Lcom/live/evo/fragment/y1;", "T0", "()Lcom/live/evo/fragment/y1;", "U1", "(Lcom/live/evo/fragment/y1;)V", "mOnEventListener", "o", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "p", "Landroid/widget/TextView;", "mRemind", "q", "mRemindBottom", "r", "mRenewNow", "s", "mRechargeHint", "t", "mBindUser", "u", "mRenewLayout", "mScanedRenewLayout", "w", "mRechargeCodeLayout", "x", "mScanQRTitle", "y", "mScanQRRemind", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mScanQRPic", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mRefreshQR", "B", "mCheckPayment", "mGapLine", "D", "mRechargeTitle", ExifInterface.LONGITUDE_EAST, "mRechargeRemind", "Lcom/live/evo/widget/RechargeEditText;", "F", "Lcom/live/evo/widget/RechargeEditText;", "mRechargeEdit", "G", "mRechargeConfirm", "H", "mScanWebPlanLayout", "I", "mScanPlanQRTitle", "J", "mScanPlanQRRemind", "K", "mScanPlanQRPic", "L", "mRefreshPlanQR", "M", "mCheckPlanPayment", "Landroidx/leanback/widget/VerticalGridView;", "N", "Landroidx/leanback/widget/VerticalGridView;", "getRecyclerViewPlan", "()Landroidx/leanback/widget/VerticalGridView;", "setRecyclerViewPlan", "(Landroidx/leanback/widget/VerticalGridView;)V", "recyclerViewPlan", "O", "Ljava/lang/String;", "lastQRUrl", "P", "lastRequestTime", "Q", "interval", "R", "Z", "isOnRequest", ExifInterface.LATITUDE_SOUTH, "mAccountRenewType", "Lt5/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lt5/a;", "loadingView", "U", "Lcom/live/evo/osd/a;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/live/evo/osd/a;", "mAccountCallback", "Lcom/live/evo/fragment/login/presenter/g;", ExifInterface.LONGITUDE_WEST, "Lcom/live/evo/fragment/login/presenter/g;", "mRechargeAndLoginPresenter", "X", "Lziyi/kit/keyboard/b;", "keyboardView", "Y", "rechargeCodeState", "isPopup", "com/live/evo/fragment/l3$d", "Lcom/live/evo/fragment/l3$d;", "handler", "Lcom/live/evo/b;", "Lcom/live/evo/b;", "featuresListener", "E1", "S0", "T1", "mActionExecute", "Ljava/lang/Runnable;", "mQuryUserRun", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l3 extends l5.b implements com.live.evo.fragment.login.presenter.f, View.OnClickListener, View.OnFocusChangeListener {

    /* JADX INFO: renamed from: G1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static SoftReference<l3> H1;
    private static SoftReference<View> I1;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private TextView mRefreshQR;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private TextView mCheckPayment;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private View mGapLine;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private TextView mRechargeTitle;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private TextView mRechargeRemind;

    /* JADX INFO: renamed from: E1, reason: from kotlin metadata */
    private boolean mActionExecute;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private RechargeEditText mRechargeEdit;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private TextView mRechargeConfirm;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private View mScanWebPlanLayout;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private TextView mScanPlanQRTitle;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private TextView mScanPlanQRRemind;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private ImageView mScanPlanQRPic;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private TextView mRefreshPlanQR;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private TextView mCheckPlanPayment;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private VerticalGridView recyclerViewPlan;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private long lastRequestTime;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    private boolean isOnRequest;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    private int mAccountRenewType;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    private t5.a loadingView;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    private boolean isVisible;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    private com.live.evo.osd.a mAccountCallback;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    private com.live.evo.fragment.login.presenter.g mRechargeAndLoginPresenter;

    /* JADX INFO: renamed from: X, reason: from kotlin metadata */
    private ziyi.kit.keyboard.b keyboardView;

    /* JADX INFO: renamed from: Y, reason: from kotlin metadata */
    private int rechargeCodeState;

    /* JADX INFO: renamed from: Z, reason: from kotlin metadata */
    private boolean isPopup;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Window mWindow;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private y1 mOnEventListener;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private View view;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private TextView mRemind;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private TextView mRemindBottom;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private TextView mRenewNow;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private TextView mRechargeHint;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private TextView mBindUser;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private View mRenewLayout;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private View mScanedRenewLayout;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private View mRechargeCodeLayout;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private TextView mScanQRTitle;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private TextView mScanQRRemind;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private ImageView mScanQRPic;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(l3.class);

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private String lastQRUrl = "";

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    private long interval = FileWatchdog.DEFAULT_DELAY;

    /* JADX INFO: renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private final d handler = new d(Looper.getMainLooper());

    /* JADX INFO: renamed from: D1, reason: from kotlin metadata */
    private final com.live.evo.b featuresListener = new c();

    /* JADX INFO: renamed from: F1, reason: from kotlin metadata */
    private final Runnable mQuryUserRun = new Runnable() { // from class: com.live.evo.fragment.v2
        @Override // java.lang.Runnable
        public final void run() {
            l3.v1(this.f6852a);
        }
    };

    /* JADX INFO: renamed from: com.live.evo.fragment.l3$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0014\u0010#\u001a\u00020\"8\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00128\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/live/evo/fragment/l3$a;", "", "<init>", "()V", "", "b", "()Z", "Lcom/live/evo/fragment/y1;", "onEventListener", "Landroid/view/View;", "tabFunctionView", "Landroid/view/Window;", "window", "Lcom/live/evo/fragment/l3;", "c", "(Lcom/live/evo/fragment/y1;Landroid/view/View;Landroid/view/Window;)Lcom/live/evo/fragment/l3;", "Landroidx/fragment/app/FragmentManager;", "fm", "", "containerId", "listener", "Lr8/z;", "f", "(Landroidx/fragment/app/FragmentManager;Landroid/view/Window;ILcom/live/evo/fragment/y1;)V", "Ljava/lang/ref/SoftReference;", "sfrInstance", "Ljava/lang/ref/SoftReference;", "a", "()Ljava/lang/ref/SoftReference;", "e", "(Ljava/lang/ref/SoftReference;)V", "mTabFunctionView", "getMTabFunctionView", "d", "", "TAG", "Ljava/lang/String;", "MSG_REFRESH_SESSION", "I", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final synchronized void f(FragmentManager fm, Window window, int containerId, y1 listener) {
            l3 l3Var;
            kotlin.jvm.internal.m.f(fm, "fm");
            SoftReference<l3> softReferenceA = a();
            if (softReferenceA != null && (l3Var = softReferenceA.get()) != null && l3Var.isVisible) {
                if (listener != null) {
                    listener.b();
                }
                return;
            }
            Fragment fragmentFindFragmentByTag = fm.findFragmentByTag("TabFunctionRechargeFragment");
            FragmentTransaction fragmentTransactionBeginTransaction = fm.beginTransaction();
            kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            if (fragmentFindFragmentByTag == null) {
                l3 l3Var2 = new l3();
                l3Var2.V1(window);
                l3Var2.U1(listener);
                l3Var2.isPopup = true;
                fragmentTransactionBeginTransaction.add(containerId, l3Var2, "TabFunctionRechargeFragment").commitAllowingStateLoss();
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag).commitAllowingStateLoss();
            }
        }

        private Companion() {
        }

        public final l3 c(y1 onEventListener, View tabFunctionView, Window window) {
            if (tabFunctionView != null) {
                d(new SoftReference<>(tabFunctionView));
            }
            SoftReference<l3> softReferenceA = a();
            l3 l3Var = softReferenceA != null ? softReferenceA.get() : null;
            if (l3Var != null) {
                l3Var.V1(window);
                l3Var.U1(onEventListener);
                return l3Var;
            }
            synchronized (Companion.class) {
                Companion companion = l3.INSTANCE;
                SoftReference<l3> softReferenceA2 = companion.a();
                l3 l3Var2 = softReferenceA2 != null ? softReferenceA2.get() : null;
                if (l3Var2 != null) {
                    return l3Var2;
                }
                l3 l3Var3 = new l3();
                companion.e(new SoftReference<>(l3Var3));
                l3Var3.V1(window);
                l3Var3.U1(onEventListener);
                return l3Var3;
            }
        }

        public final SoftReference<l3> a() {
            return l3.H1;
        }

        public final boolean b() {
            l3 l3Var;
            SoftReference<l3> softReferenceA = a();
            if (softReferenceA != null && (l3Var = softReferenceA.get()) != null) {
                return l3Var.isVisible;
            }
            return false;
        }

        public final void d(SoftReference<View> softReference) {
            l3.I1 = softReference;
        }

        public final void e(SoftReference<l3> softReference) {
            l3.H1 = softReference;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/live/evo/fragment/l3$b", "Lcom/live/evo/dialog/r$c;", "Lr8/z;", "a", "()V", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements com.live.evo.dialog.r.c {
        b() {
        }

        @Override // com.live.evo.dialog.r.c
        public void b() {
            com.live.evo.fragment.login.j.g0(l3.this.getChildFragmentManager(), 22, l3.this.mAccountCallback);
        }

        @Override // com.live.evo.dialog.r.c
        public void a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/live/evo/fragment/l3$c", "Lcom/live/evo/b;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements com.live.evo.b {
        c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/fragment/l3$d", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends Handler {
        d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            super.handleMessage(msg);
            if (msg.what == 1 && l3.this.isVisible) {
                l3.this.mQuryUserRun.run();
                sendEmptyMessageDelayed(1, ((long) t.v.c.i.a.f18646a.V()) * 1000);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"com/live/evo/fragment/l3$e", "Lcom/live/evo/osd/a;", "Lr8/z;", "c", "()V", "e", "a", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements com.live.evo.osd.a {
        e() {
        }

        @Override // com.live.evo.osd.p
        public void a() {
            Intent intent = new Intent("com.bb.action.EXIT");
            intent.putExtra("withProcess", true);
            Context context = l3.this.getContext();
            kotlin.jvm.internal.m.c(context);
            context.sendBroadcast(intent);
        }

        @Override // com.live.evo.osd.a
        public void c() {
            if (l3.this.getMOnEventListener() != null) {
                y1 mOnEventListener = l3.this.getMOnEventListener();
                kotlin.jvm.internal.m.c(mOnEventListener);
                mOnEventListener.c();
            }
            FragmentActivity activity = l3.this.getActivity();
            kotlin.jvm.internal.m.d(activity, "null cannot be cast to non-null type com.live.evo.activity.LiveNewActivity");
            ((LiveNewActivity) activity).L3();
            l3.this.l();
            v0.b().e();
            if (com.live.evo.l.n().e() == 2) {
                a.a().d();
            }
        }

        @Override // com.live.evo.osd.p
        public void e() {
            FragmentActivity activity = l3.this.getActivity();
            kotlin.jvm.internal.m.d(activity, "null cannot be cast to non-null type com.live.evo.activity.LiveNewActivity");
            ((LiveNewActivity) activity).L3();
            l3.this.l();
        }

        @Override // com.live.evo.osd.p
        public void b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/live/evo/fragment/l3$f", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "Lr8/z;", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements TextWatcher {
        f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s10) {
            kotlin.jvm.internal.m.f(s10, "s");
            if (TextUtils.isEmpty(s10) || s10.length() < 19) {
                RechargeEditText rechargeEditText = l3.this.mRechargeEdit;
                kotlin.jvm.internal.m.c(rechargeEditText);
                rechargeEditText.setTextColor(com.live.evo.util.x1.e(R$color.text_color_et_selector_focus));
                RechargeEditText rechargeEditText2 = l3.this.mRechargeEdit;
                kotlin.jvm.internal.m.c(rechargeEditText2);
                rechargeEditText2.setBackground(com.live.evo.util.x1.f(R$drawable.load_et_selector));
                TextView textView = l3.this.mRechargeConfirm;
                kotlin.jvm.internal.m.c(textView);
                textView.setEnabled(false);
                TextView textView2 = l3.this.mRechargeConfirm;
                kotlin.jvm.internal.m.c(textView2);
                textView2.setFocusable(false);
                return;
            }
            RechargeEditText rechargeEditText3 = l3.this.mRechargeEdit;
            kotlin.jvm.internal.m.c(rechargeEditText3);
            rechargeEditText3.setBackground(com.live.evo.util.x1.f(R$drawable.recharge_mini_full));
            RechargeEditText rechargeEditText4 = l3.this.mRechargeEdit;
            kotlin.jvm.internal.m.c(rechargeEditText4);
            rechargeEditText4.setTextColor(com.live.evo.util.x1.e(R$color.recharge_fill_text_color));
            TextView textView3 = l3.this.mRechargeConfirm;
            kotlin.jvm.internal.m.c(textView3);
            textView3.setEnabled(true);
            TextView textView4 = l3.this.mRechargeConfirm;
            kotlin.jvm.internal.m.c(textView4);
            textView4.setFocusable(true);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
            kotlin.jvm.internal.m.f(s10, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s10, int start, int before, int count) {
            kotlin.jvm.internal.m.f(s10, "s");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.TabFunctionRechargeFragment$mQuryUserRun$1$1", f = "TabFunctionRechargeFragment.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        g(v8.f<? super g> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return l3.this.new g(fVar);
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
                l3.this.G1(null, false);
                if (l3.this.Y1()) {
                    l3.this.F1();
                }
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/live/evo/fragment/l3$h", "Lcom/live/evo/dialog/r$c;", "Lr8/z;", "a", "()V", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements com.live.evo.dialog.r.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f6097a;

        h(Runnable runnable) {
            this.f6097a = runnable;
        }

        @Override // com.live.evo.dialog.r.c
        public void b() {
            Runnable runnable = this.f6097a;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.live.evo.dialog.r.c
        public void a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/live/evo/fragment/l3$i", "Lcom/live/evo/dialog/r$c;", "Lr8/z;", "a", "()V", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements com.live.evo.dialog.r.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f6098a;

        i(Runnable runnable) {
            this.f6098a = runnable;
        }

        @Override // com.live.evo.dialog.r.c
        public void b() {
            Runnable runnable = this.f6098a;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.live.evo.dialog.r.c
        public void a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.TabFunctionRechargeFragment$queryUserInfo$2", f = "TabFunctionRechargeFragment.kt", l = {1565, 1580}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ boolean $bMessage;
        final /* synthetic */ Runnable $buttonAction;
        final /* synthetic */ long $nowExpireTS;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.TabFunctionRechargeFragment$queryUserInfo$2$1", f = "TabFunctionRechargeFragment.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ Runnable $buttonAction;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ l3 this$0;

            /* JADX INFO: renamed from: com.live.evo.fragment.l3$j$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.TabFunctionRechargeFragment$queryUserInfo$2$1$1", f = "TabFunctionRechargeFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0077a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ Runnable $buttonAction;
                final /* synthetic */ Throwable $it;
                int label;
                final /* synthetic */ l3 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0077a(l3 l3Var, Runnable runnable, Throwable th, v8.f<? super C0077a> fVar) {
                    super(2, fVar);
                    this.this$0 = l3Var;
                    this.$buttonAction = runnable;
                    this.$it = th;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0077a(this.this$0, this.$buttonAction, this.$it, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0077a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.this$0.isAdded()) {
                            TextView textView = this.this$0.mCheckPayment;
                            kotlin.jvm.internal.m.c(textView);
                            textView.setText(com.live.evo.util.x1.j(2131952883));
                            if (this.$buttonAction != null && !this.this$0.getMActionExecute()) {
                                this.this$0.T1(true);
                                this.$buttonAction.run();
                            }
                            String message = this.$it.getMessage();
                            if (message != null) {
                                this.this$0.A1("", message, "", null);
                            }
                            return r8.z.f17874a;
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(l3 l3Var, Runnable runnable, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = l3Var;
                this.$buttonAction = runnable;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, this.$buttonAction, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new C0077a(this.this$0, this.$buttonAction, (Throwable) this.L$0, null), 3, null);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ l3 f6099a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f6100b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f6101c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Runnable f6102d;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.fragment.TabFunctionRechargeFragment$queryUserInfo$2$2$1", f = "TabFunctionRechargeFragment.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ boolean $bMessage;
                final /* synthetic */ Runnable $buttonAction;
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                final /* synthetic */ long $nowExpireTS;
                int label;
                final /* synthetic */ l3 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(l3 l3Var, r8.u<Boolean, Integer, String> uVar, boolean z10, long j10, Runnable runnable, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.this$0 = l3Var;
                    this.$it = uVar;
                    this.$bMessage = z10;
                    this.$nowExpireTS = j10;
                    this.$buttonAction = runnable;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.this$0, this.$it, this.$bMessage, this.$nowExpireTS, this.$buttonAction, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    String string;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        if (this.this$0.isAdded()) {
                            TextView textView = this.this$0.mCheckPayment;
                            kotlin.jvm.internal.m.c(textView);
                            textView.setText(com.live.evo.util.x1.j(2131952883));
                            if (this.$it.d().booleanValue()) {
                                this.this$0.R1(this.$bMessage, this.$nowExpireTS, com.live.evo.l.n().l(), this.$buttonAction);
                            } else {
                                if (this.$buttonAction != null && !this.this$0.getMActionExecute()) {
                                    this.this$0.T1(true);
                                    this.$buttonAction.run();
                                }
                                Integer numE = this.$it.e();
                                if (numE == null || (string = numE.toString()) == null) {
                                    string = "";
                                }
                                String strF = this.$it.f();
                                if (strF != null) {
                                    this.this$0.A1("", strF, string, null);
                                }
                            }
                            return r8.z.f17874a;
                        }
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            b(l3 l3Var, boolean z10, long j10, Runnable runnable) {
                this.f6099a = l3Var;
                this.f6100b = z10;
                this.f6101c = j10;
                this.f6102d = runnable;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.f6099a, uVar, this.f6100b, this.f6101c, this.f6102d, null), 3, null);
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Runnable runnable, boolean z10, long j10, v8.f<? super j> fVar) {
            super(2, fVar);
            this.$buttonAction = runnable;
            this.$bMessage = z10;
            this.$nowExpireTS = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return l3.this.new j(this.$buttonAction, this.$bMessage, this.$nowExpireTS, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((j) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
        
            if (r10.collect(r3, r9) == r0) goto L15;
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
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            this.label = 1;
            obj = aVar.M0(this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(l3.this, this.$buttonAction, null));
            b bVar = new b(l3.this, this.$bMessage, this.$nowExpireTS, this.$buttonAction);
            this.label = 2;
        }
    }

    private final synchronized void I1(Runnable buttonAction) {
        if (!com.live.evo.l.n().v()) {
            if (buttonAction != null) {
                buttonAction.run();
            }
            return;
        }
        int iE = com.live.evo.l.n().e();
        int iD = com.live.evo.util.s0.f7342a.D();
        if (iE == 0 && iD == 8) {
            G1(buttonAction, false);
        } else if (buttonAction != null) {
            buttonAction.run();
        }
    }

    private final synchronized void J1() {
        try {
            if (com.live.evo.l.n().v()) {
                int iE = com.live.evo.l.n().e();
                com.live.evo.util.s0.f7342a.D();
                if (com.live.evo.l.n().f() || iE == 0 || iE == 1) {
                    com.live.evo.util.t1.a().d(this.mQuryUserRun);
                    com.live.evo.util.t1.a().c(this.mQuryUserRun, 2000L);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // l5.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        H1 = null;
        super.onDestroy();
        x1.f1.lb.util.e0.f21385a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(final String title, final String message, final String errorCode, final Runnable rightRun) {
        try {
            com.live.evo.util.k1.f7250a.c(new Runnable() { // from class: com.live.evo.fragment.z2
                @Override // java.lang.Runnable
                public final void run() {
                    l3.B1(this.f6946a, title, errorCode, message, rightRun);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(l3 l3Var, String str, String str2, String str3, Runnable runnable) {
        String str4;
        com.live.evo.dialog.r rVar = new com.live.evo.dialog.r(l3Var.getActivity(), new h(runnable));
        rVar.k(str);
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        } else {
            str4 = com.live.evo.util.x1.j(2131952013) + str2;
        }
        rVar.j(str3, str4);
        rVar.l();
    }

    private final void D1(final String title, final String message, final String errorCode, final Runnable rightRun) {
        try {
            com.live.evo.util.k1.f7250a.c(new Runnable() { // from class: com.live.evo.fragment.b3
                @Override // java.lang.Runnable
                public final void run() {
                    l3.E1(this.f5884a, title, errorCode, message, rightRun);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(l3 l3Var, String str, String str2, String str3, Runnable runnable) {
        String str4;
        com.live.evo.dialog.r rVar = new com.live.evo.dialog.r(l3Var.getActivity(), new i(runnable));
        rVar.k(str);
        rVar.i(R$drawable.successfully_icon);
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        } else {
            str4 = com.live.evo.util.x1.j(2131952013) + str2;
        }
        rVar.j(str3, str4);
        rVar.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(Runnable runnable, l3 l3Var) {
        if (runnable == null || l3Var.mActionExecute) {
            return;
        }
        l3Var.mActionExecute = true;
        runnable.run();
    }

    private final void L1() {
        TextView textView = this.mRechargeConfirm;
        kotlin.jvm.internal.m.c(textView);
        if (textView.isEnabled()) {
            int iE = com.live.evo.l.n().e();
            int iQ = com.live.evo.l.n().q();
            if (!com.live.evo.l.n().f() && com.live.evo.l.n().v() && iE == 1) {
                com.live.evo.util.r1.c(getContext(), "Incorrect user renew type!");
                return;
            }
            RechargeEditText rechargeEditText = this.mRechargeEdit;
            kotlin.jvm.internal.m.c(rechargeEditText);
            String strValueOf = String.valueOf(rechargeEditText.getText());
            int length = strValueOf.length() - 1;
            int i10 = 0;
            boolean z10 = false;
            while (i10 <= length) {
                boolean z11 = kotlin.jvm.internal.m.h(strValueOf.charAt(!z10 ? i10 : length), 32) <= 0;
                if (z10) {
                    if (!z11) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z11) {
                    i10++;
                } else {
                    z10 = true;
                }
            }
            String string = strValueOf.subSequence(i10, length + 1).toString();
            if (com.live.evo.l.n().F()) {
                if (iQ != 2 && iQ != 6) {
                    com.live.evo.fragment.login.presenter.g gVar = this.mRechargeAndLoginPresenter;
                    if (gVar != null) {
                        kotlin.jvm.internal.m.c(gVar);
                        gVar.s(getContext(), ua.n.E(string, " ", "", false, 4, null));
                        return;
                    }
                    return;
                }
                if (this.mRechargeAndLoginPresenter != null) {
                    int iA = o5.a.c().a(com.live.evo.l.n().d());
                    com.live.evo.fragment.login.presenter.g gVar2 = this.mRechargeAndLoginPresenter;
                    kotlin.jvm.internal.m.c(gVar2);
                    gVar2.A(ua.n.E(string, " ", "", false, 4, null), iA);
                    return;
                }
                return;
            }
            if (iQ != 2) {
                if (iQ != 3) {
                    if (iQ != 6) {
                        if (iQ != 8) {
                            com.live.evo.fragment.login.presenter.g gVar3 = this.mRechargeAndLoginPresenter;
                            if (gVar3 != null) {
                                kotlin.jvm.internal.m.c(gVar3);
                                gVar3.s(getContext(), ua.n.E(string, " ", "", false, 4, null));
                                return;
                            }
                            return;
                        }
                    }
                }
                com.live.evo.fragment.login.presenter.g gVar4 = this.mRechargeAndLoginPresenter;
                if (gVar4 != null) {
                    kotlin.jvm.internal.m.c(gVar4);
                    gVar4.s(getContext(), ua.n.E(string, " ", "", false, 4, null));
                    return;
                }
                return;
            }
            if (this.mRechargeAndLoginPresenter != null) {
                int iA2 = o5.a.c().a(com.live.evo.l.n().d());
                com.live.evo.fragment.login.presenter.g gVar5 = this.mRechargeAndLoginPresenter;
                kotlin.jvm.internal.m.c(gVar5);
                gVar5.A(ua.n.E(string, " ", "", false, 4, null), iA2);
            }
        }
    }

    private final void M1() {
        View view = this.mRechargeCodeLayout;
        kotlin.jvm.internal.m.c(view);
        if (view.getVisibility() == 0) {
            RechargeEditText rechargeEditText = this.mRechargeEdit;
            kotlin.jvm.internal.m.c(rechargeEditText);
            rechargeEditText.requestFocus();
            RechargeEditText rechargeEditText2 = this.mRechargeEdit;
            kotlin.jvm.internal.m.c(rechargeEditText2);
            if (TextUtils.isEmpty(rechargeEditText2.getText())) {
                return;
            }
            RechargeEditText rechargeEditText3 = this.mRechargeEdit;
            kotlin.jvm.internal.m.c(rechargeEditText3);
            RechargeEditText rechargeEditText4 = this.mRechargeEdit;
            kotlin.jvm.internal.m.c(rechargeEditText4);
            Editable text = rechargeEditText4.getText();
            kotlin.jvm.internal.m.c(text);
            rechargeEditText3.setSelection(text.length());
        }
    }

    private final boolean Q0() {
        View view;
        SoftReference<View> softReference = I1;
        if (softReference == null || (view = softReference.get()) == null) {
            return false;
        }
        view.requestFocus();
        return true;
    }

    private final void Q1(boolean layoutHide) {
        View view = this.mRenewLayout;
        kotlin.jvm.internal.m.c(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        kotlin.jvm.internal.m.d(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (layoutHide) {
            layoutParams2.width = com.live.evo.util.x1.b(700.0f);
            TextView textView = this.mRemind;
            kotlin.jvm.internal.m.c(textView);
            textView.setGravity(17);
        } else {
            layoutParams2.width = -1;
            TextView textView2 = this.mRemind;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setGravity(19);
        }
        View view2 = this.mRenewLayout;
        kotlin.jvm.internal.m.c(view2);
        view2.setLayoutParams(layoutParams2);
    }

    private final void U0() {
        t5.a aVar = this.loadingView;
        if (aVar != null) {
            kotlin.jvm.internal.m.c(aVar);
            aVar.d();
        }
    }

    private final void V0() {
        if (this.mAccountCallback == null) {
            this.mAccountCallback = new e();
        }
    }

    private final void W1() {
        FragmentActivity activity;
        if (this.loadingView == null || (activity = getActivity()) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.live.evo.fragment.w2
            @Override // java.lang.Runnable
            public final void run() {
                l3.X1(this.f6864a);
            }
        });
    }

    private final void X0() {
        int i10 = this.mAccountRenewType;
        if (i10 == 0) {
            if (com.live.evo.l.n().v()) {
                d1();
                return;
            }
            RechargeEditText rechargeEditText = this.mRechargeEdit;
            kotlin.jvm.internal.m.c(rechargeEditText);
            rechargeEditText.setNextFocusLeftId(R$id.renew_et_rechargecode);
            TextView textView = this.mRechargeConfirm;
            kotlin.jvm.internal.m.c(textView);
            textView.setNextFocusLeftId(R$id.renew_rechargecode_confirm);
            return;
        }
        if (i10 == 1) {
            if (this.mCheckPayment != null) {
                TextView textView2 = this.mRefreshQR;
                kotlin.jvm.internal.m.c(textView2);
                textView2.setNextFocusRightId(R$id.renew_qrcode_refresh);
                TextView textView3 = this.mCheckPayment;
                kotlin.jvm.internal.m.c(textView3);
                textView3.setNextFocusRightId(R$id.renew_check_payment);
                return;
            }
            return;
        }
        if (i10 == 2) {
            RechargeEditText rechargeEditText2 = this.mRechargeEdit;
            kotlin.jvm.internal.m.c(rechargeEditText2);
            rechargeEditText2.setNextFocusLeftId(R$id.renew_et_rechargecode);
            TextView textView4 = this.mRechargeConfirm;
            kotlin.jvm.internal.m.c(textView4);
            textView4.setNextFocusLeftId(R$id.renew_rechargecode_confirm);
            return;
        }
        if (com.live.evo.l.n().v()) {
            d1();
            return;
        }
        RechargeEditText rechargeEditText3 = this.mRechargeEdit;
        kotlin.jvm.internal.m.c(rechargeEditText3);
        rechargeEditText3.setNextFocusLeftId(R$id.renew_et_rechargecode);
        TextView textView5 = this.mRechargeConfirm;
        kotlin.jvm.internal.m.c(textView5);
        textView5.setNextFocusLeftId(R$id.renew_rechargecode_confirm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(l3 l3Var) {
        t5.a aVar = l3Var.loadingView;
        kotlin.jvm.internal.m.c(aVar);
        aVar.h();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0097  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:28:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:29:0x00db  */
    private final void Y0() {
        boolean z10;
        int i10;
        View view;
        if (com.live.evo.a.f5188h) {
            return;
        }
        if (!u1() && com.live.evo.l.n().q() == 3) {
            View view2 = this.mRenewLayout;
            kotlin.jvm.internal.m.c(view2);
            view2.setVisibility(8);
            TextView textView = this.mBindUser;
            kotlin.jvm.internal.m.c(textView);
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = this.mBindUser;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setVisibility(8);
        View view3 = this.mRenewLayout;
        kotlin.jvm.internal.m.c(view3);
        view3.setVisibility(0);
        this.rechargeCodeState = com.live.evo.l.n().g("recharge_code_ctrl", -1);
        boolean zV = com.live.evo.l.n().v();
        View view4 = this.mScanedRenewLayout;
        kotlin.jvm.internal.m.c(view4);
        view4.setVisibility(0);
        View view5 = this.mGapLine;
        kotlin.jvm.internal.m.c(view5);
        view5.setVisibility(0);
        View view6 = this.mRechargeCodeLayout;
        kotlin.jvm.internal.m.c(view6);
        view6.setVisibility(0);
        int i11 = this.mAccountRenewType;
        boolean z11 = true;
        if (i11 != 1) {
            if (i11 != 2) {
                z10 = false;
            } else {
                View view7 = this.mScanedRenewLayout;
                kotlin.jvm.internal.m.c(view7);
                view7.setVisibility(8);
                View view8 = this.mGapLine;
                kotlin.jvm.internal.m.c(view8);
                view8.setVisibility(8);
                zV = false;
            }
            if (!zV) {
                View view9 = this.mScanedRenewLayout;
                kotlin.jvm.internal.m.c(view9);
                view9.setVisibility(8);
                z10 = true;
            }
            i10 = this.rechargeCodeState;
            if (i10 == 0) {
                View view10 = this.mRechargeCodeLayout;
                kotlin.jvm.internal.m.c(view10);
                view10.setVisibility(8);
                View view11 = this.mGapLine;
                kotlin.jvm.internal.m.c(view11);
                view11.setVisibility(8);
            } else if (i10 == 1) {
                View view12 = this.mRechargeCodeLayout;
                kotlin.jvm.internal.m.c(view12);
                view12.setVisibility(0);
                view = this.mScanedRenewLayout;
                kotlin.jvm.internal.m.c(view);
                if (view.getVisibility() == 8) {
                    View view13 = this.mGapLine;
                    kotlin.jvm.internal.m.c(view13);
                    view13.setVisibility(8);
                } else {
                    View view14 = this.mGapLine;
                    kotlin.jvm.internal.m.c(view14);
                    view14.setVisibility(0);
                    z11 = z10;
                }
            } else {
                z11 = z10;
            }
            Q1(z11);
        }
        View view15 = this.mRechargeCodeLayout;
        kotlin.jvm.internal.m.c(view15);
        view15.setVisibility(8);
        View view16 = this.mGapLine;
        kotlin.jvm.internal.m.c(view16);
        view16.setVisibility(8);
        z10 = true;
        if (!zV) {
            View view17 = this.mScanedRenewLayout;
            kotlin.jvm.internal.m.c(view17);
            view17.setVisibility(8);
            z10 = true;
        }
        i10 = this.rechargeCodeState;
        if (i10 == 0) {
            View view18 = this.mRechargeCodeLayout;
            kotlin.jvm.internal.m.c(view18);
            view18.setVisibility(8);
            View view19 = this.mGapLine;
            kotlin.jvm.internal.m.c(view19);
            view19.setVisibility(8);
        } else if (i10 == 1) {
            View view110 = this.mRechargeCodeLayout;
            kotlin.jvm.internal.m.c(view110);
            view110.setVisibility(0);
            view = this.mScanedRenewLayout;
            kotlin.jvm.internal.m.c(view);
            if (view.getVisibility() == 8) {
                View view111 = this.mGapLine;
                kotlin.jvm.internal.m.c(view111);
                view111.setVisibility(8);
            } else {
                View view112 = this.mGapLine;
                kotlin.jvm.internal.m.c(view112);
                view112.setVisibility(0);
                z11 = z10;
            }
        } else {
            z11 = z10;
        }
        Q1(z11);
    }

    private final void b1() {
        if (com.live.evo.a.f5188h) {
            return;
        }
        boolean z10 = false;
        if (!u1() && com.live.evo.l.n().q() == 3) {
            View view = this.mRenewLayout;
            kotlin.jvm.internal.m.c(view);
            view.setVisibility(8);
            TextView textView = this.mBindUser;
            kotlin.jvm.internal.m.c(textView);
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = this.mBindUser;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setVisibility(8);
        View view2 = this.mRenewLayout;
        kotlin.jvm.internal.m.c(view2);
        view2.setVisibility(0);
        if (Y1()) {
            View view3 = this.mScanWebPlanLayout;
            kotlin.jvm.internal.m.c(view3);
            view3.setVisibility(0);
            View view4 = this.mScanedRenewLayout;
            kotlin.jvm.internal.m.c(view4);
            view4.setVisibility(8);
            View view5 = this.mRechargeCodeLayout;
            kotlin.jvm.internal.m.c(view5);
            view5.setVisibility(8);
            View view6 = this.mGapLine;
            kotlin.jvm.internal.m.c(view6);
            view6.setVisibility(8);
            TextView textView3 = this.mRemind;
            kotlin.jvm.internal.m.c(textView3);
            textView3.setGravity(17);
            return;
        }
        View view7 = this.mScanWebPlanLayout;
        kotlin.jvm.internal.m.c(view7);
        view7.setVisibility(8);
        boolean zV = com.live.evo.l.n().v();
        boolean zU = com.live.evo.l.n().u();
        View view8 = this.mScanedRenewLayout;
        kotlin.jvm.internal.m.c(view8);
        view8.setVisibility(0);
        View view9 = this.mGapLine;
        kotlin.jvm.internal.m.c(view9);
        view9.setVisibility(0);
        View view10 = this.mRechargeCodeLayout;
        kotlin.jvm.internal.m.c(view10);
        view10.setVisibility(0);
        if (zV) {
            if (!zU) {
                View view11 = this.mRechargeCodeLayout;
                kotlin.jvm.internal.m.c(view11);
                view11.setVisibility(8);
                View view12 = this.mGapLine;
                kotlin.jvm.internal.m.c(view12);
                view12.setVisibility(8);
            }
            Q1(z10);
        }
        View view13 = this.mScanedRenewLayout;
        kotlin.jvm.internal.m.c(view13);
        view13.setVisibility(8);
        View view14 = this.mGapLine;
        kotlin.jvm.internal.m.c(view14);
        view14.setVisibility(8);
        z10 = true;
        Q1(z10);
    }

    private final void c1() {
        TextView textView = this.mRenewNow;
        kotlin.jvm.internal.m.c(textView);
        textView.setOnClickListener(this);
        TextView textView2 = this.mRefreshQR;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setOnClickListener(this);
        TextView textView3 = this.mRefreshPlanQR;
        kotlin.jvm.internal.m.c(textView3);
        textView3.setOnClickListener(this);
        TextView textView4 = this.mCheckPayment;
        kotlin.jvm.internal.m.c(textView4);
        textView4.setOnClickListener(this);
        TextView textView5 = this.mCheckPlanPayment;
        kotlin.jvm.internal.m.c(textView5);
        textView5.setOnClickListener(this);
        TextView textView6 = this.mRechargeConfirm;
        kotlin.jvm.internal.m.c(textView6);
        textView6.setOnClickListener(this);
        TextView textView7 = this.mBindUser;
        kotlin.jvm.internal.m.c(textView7);
        textView7.setOnClickListener(this);
        RechargeEditText rechargeEditText = this.mRechargeEdit;
        kotlin.jvm.internal.m.c(rechargeEditText);
        rechargeEditText.addTextChangedListener(new f());
    }

    private final void d1() {
        RechargeEditText rechargeEditText = this.mRechargeEdit;
        kotlin.jvm.internal.m.c(rechargeEditText);
        rechargeEditText.setNextFocusLeftId(R$id.renew_qrcode_refresh);
        TextView textView = this.mRechargeConfirm;
        kotlin.jvm.internal.m.c(textView);
        textView.setNextFocusLeftId(R$id.renew_qrcode_refresh);
        TextView textView2 = this.mRefreshQR;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setNextFocusRightId(R$id.renew_et_rechargecode);
        TextView textView3 = this.mCheckPayment;
        kotlin.jvm.internal.m.c(textView3);
        textView3.setNextFocusRightId(R$id.renew_et_rechargecode);
        TextView textView4 = this.mBindUser;
        kotlin.jvm.internal.m.c(textView4);
        textView4.setNextFocusLeftId(R$id.rechargeremindf_tv_binduser);
        TextView textView5 = this.mBindUser;
        kotlin.jvm.internal.m.c(textView5);
        textView5.setNextFocusRightId(R$id.rechargeremindf_tv_binduser);
        TextView textView6 = this.mBindUser;
        kotlin.jvm.internal.m.c(textView6);
        textView6.setNextFocusDownId(R$id.rechargeremindf_tv_binduser);
    }

    private final void e1() {
        TextView textView = this.mRefreshQR;
        kotlin.jvm.internal.m.c(textView);
        textView.setOnKeyListener(new View.OnKeyListener() { // from class: com.live.evo.fragment.t2
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return l3.f1(this.f6819a, view, i10, keyEvent);
            }
        });
        TextView textView2 = this.mCheckPayment;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setOnKeyListener(new View.OnKeyListener() { // from class: com.live.evo.fragment.c3
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return l3.g1(this.f5917a, view, i10, keyEvent);
            }
        });
        VerticalGridView verticalGridView = this.recyclerViewPlan;
        kotlin.jvm.internal.m.c(verticalGridView);
        verticalGridView.setOnKeyInterceptListener(new BaseGridView.OnKeyInterceptListener() { // from class: com.live.evo.fragment.d3
            @Override // androidx.leanback.widget.BaseGridView.OnKeyInterceptListener
            public final boolean onInterceptKeyEvent(KeyEvent keyEvent) {
                return l3.h1(this.f5928a, keyEvent);
            }
        });
        RechargeEditText rechargeEditText = this.mRechargeEdit;
        kotlin.jvm.internal.m.c(rechargeEditText);
        rechargeEditText.setOnKeyListener(new View.OnKeyListener() { // from class: com.live.evo.fragment.e3
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return l3.i1(this.f5930a, view, i10, keyEvent);
            }
        });
        TextView textView3 = this.mRechargeConfirm;
        kotlin.jvm.internal.m.c(textView3);
        textView3.setOnKeyListener(new View.OnKeyListener() { // from class: com.live.evo.fragment.f3
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return l3.j1(this.f5944a, view, i10, keyEvent);
            }
        });
        TextView textView4 = this.mBindUser;
        kotlin.jvm.internal.m.c(textView4);
        textView4.setOnKeyListener(new View.OnKeyListener() { // from class: com.live.evo.fragment.g3
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return l3.k1(this.f5978a, view, i10, keyEvent);
            }
        });
        TextView textView5 = this.mRenewNow;
        kotlin.jvm.internal.m.c(textView5);
        textView5.setOnKeyListener(new View.OnKeyListener() { // from class: com.live.evo.fragment.h3
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return l3.l1(this.f5984a, view, i10, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h1(l3 l3Var, KeyEvent event) {
        kotlin.jvm.internal.m.f(event, "event");
        if (event.getAction() != 0) {
            return false;
        }
        if (event.getKeyCode() == 21) {
            l3Var.Q0();
            return false;
        }
        if (event.getKeyCode() != 19) {
            return false;
        }
        VerticalGridView verticalGridView = l3Var.recyclerViewPlan;
        kotlin.jvm.internal.m.c(verticalGridView);
        if (verticalGridView.getSelectedPosition() != 0) {
            return false;
        }
        l3Var.Q0();
        return false;
    }

    private final void n1() {
        if (this.mRechargeAndLoginPresenter == null) {
            com.live.evo.fragment.login.presenter.g gVar = new com.live.evo.fragment.login.presenter.g();
            this.mRechargeAndLoginPresenter = gVar;
            kotlin.jvm.internal.m.c(gVar);
            gVar.B(this);
        }
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void C(String error, String errorCode) {
        com.live.evo.dialog.r rVar = new com.live.evo.dialog.r(getActivity(), new b());
        rVar.g(com.live.evo.util.x1.j(R$string.close));
        rVar.c();
        rVar.h(com.live.evo.util.x1.j(R$string.tv_continue));
        rVar.j(error, "");
        rVar.l();
    }

    public final void C1() {
        if (this.mRefreshQR == null) {
            return;
        }
        TextView textView = this.mBindUser;
        kotlin.jvm.internal.m.c(textView);
        if (textView.getVisibility() == 0) {
            TextView textView2 = this.mBindUser;
            kotlin.jvm.internal.m.c(textView2);
            textView2.requestFocus();
        } else if (!com.live.evo.l.n().f()) {
            int iE = com.live.evo.l.n().e();
            if (iE == 0 || iE == 1) {
                if (com.live.evo.l.n().v()) {
                    View view = this.mScanedRenewLayout;
                    kotlin.jvm.internal.m.c(view);
                    if (view.getVisibility() == 0) {
                        TextView textView3 = this.mRefreshQR;
                        kotlin.jvm.internal.m.c(textView3);
                        textView3.requestFocus();
                    }
                } else {
                    M1();
                }
            } else if (iE == 2) {
                M1();
            }
        } else if (!com.live.evo.l.n().v()) {
            M1();
        } else if (com.live.evo.l.n().I()) {
            TextView textView4 = this.mRefreshPlanQR;
            kotlin.jvm.internal.m.c(textView4);
            textView4.requestFocus();
        } else {
            TextView textView5 = this.mRefreshQR;
            kotlin.jvm.internal.m.c(textView5);
            textView5.requestFocus();
        }
        if (com.live.evo.a.f5188h) {
            TextView textView6 = this.mRenewNow;
            kotlin.jvm.internal.m.c(textView6);
            textView6.requestFocus();
        }
    }

    public final void G1(final Runnable buttonAction, boolean bMessage) {
        if (buttonAction != null) {
            this.mActionExecute = false;
            com.live.evo.util.t1.a().c(new Runnable() { // from class: com.live.evo.fragment.x2
                @Override // java.lang.Runnable
                public final void run() {
                    l3.H1(buttonAction, this);
                }
            }, 2000L);
        }
        long jL = com.live.evo.l.n().l();
        String strJ = com.live.evo.util.x1.j(R$string.checking);
        TextView textView = this.mCheckPayment;
        if (kotlin.jvm.internal.m.a(textView != null ? textView.getText() : null, strJ)) {
            return;
        }
        TextView textView2 = this.mCheckPayment;
        if (textView2 != null) {
            textView2.setText(strJ);
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new j(buttonAction, bMessage, jL, null), 3, null);
    }

    public final void P1() {
        long j10 = this.lastRequestTime;
        if (j10 > 0) {
            this.lastRequestTime = j10 - this.interval;
        }
    }

    /* JADX INFO: renamed from: R0, reason: from getter */
    public final ziyi.kit.keyboard.b getKeyboardView() {
        return this.keyboardView;
    }

    /* JADX INFO: renamed from: S0, reason: from getter */
    public final boolean getMActionExecute() {
        return this.mActionExecute;
    }

    /* JADX INFO: renamed from: T0, reason: from getter */
    public final y1 getMOnEventListener() {
        return this.mOnEventListener;
    }

    public final void T1(boolean z10) {
        this.mActionExecute = z10;
    }

    public final void U1(y1 y1Var) {
        this.mOnEventListener = y1Var;
    }

    public final void V1(Window window) {
        this.mWindow = window;
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void e() {
        com.live.evo.osd.a aVar;
        y1 y1Var = this.mOnEventListener;
        if (y1Var != null) {
            kotlin.jvm.internal.m.c(y1Var);
            y1Var.c();
        }
        com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 49, this.mAccountCallback);
        if (this.isPopup && (aVar = this.mAccountCallback) != null) {
            aVar.e();
        }
        v0.b().e();
        if (com.live.evo.l.n().e() == 2) {
            a.a().d();
        }
    }

    @Override // l5.b
    protected void f0(View mRoot) {
        this.view = mRoot;
        t1();
        m1();
        s1();
    }

    @Override // l5.b
    public void h0(boolean isVisible) {
        if (!isVisible) {
            VerticalGridView verticalGridView = this.recyclerViewPlan;
            kotlin.jvm.internal.m.c(verticalGridView);
            verticalGridView.setVisibility(4);
            if (Y1()) {
                com.live.evo.util.v.c(getContext(), "", R$drawable.qr_placehodler, this.mScanPlanQRPic);
            }
            this.handler.removeMessages(1);
        } else {
            if (this.mRemind == null) {
                return;
            }
            RechargeEditText rechargeEditText = this.mRechargeEdit;
            if (rechargeEditText != null) {
                kotlin.jvm.internal.m.c(rechargeEditText);
                rechargeEditText.setText("");
            }
            l();
        }
        this.isVisible = isVisible;
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.debug("tab visible on visible change[" + isVisible + "]", new Object[0]);
        }
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void i(String error, String errorCode) {
        kotlin.jvm.internal.m.f(error, "error");
        kotlin.jvm.internal.m.f(errorCode, "errorCode");
        String strJ = com.live.evo.util.x1.j(R$string.recharge_fail);
        kotlin.jvm.internal.m.e(strJ, "getString(...)");
        A1(strJ, error, errorCode, new Runnable() { // from class: com.live.evo.fragment.a3
            @Override // java.lang.Runnable
            public final void run() {
                l3.N1();
            }
        });
    }

    public final void m1() {
        try {
            ziyi.kit.keyboard.b bVar = this.keyboardView;
            if (bVar != null) {
                kotlin.jvm.internal.m.c(bVar);
                bVar.W();
            }
            ziyi.kit.keyboard.b bVarU = KeyUtils.u(this.mWindow, getContext(), this.view, getLifecycle(), false, false);
            this.keyboardView = bVarU;
            if (bVarU == null || this.mRechargeEdit == null) {
                return;
            }
            kotlin.jvm.internal.m.c(bVarU);
            bVarU.l(this.mRechargeEdit);
            ziyi.kit.keyboard.b bVar2 = this.keyboardView;
            kotlin.jvm.internal.m.c(bVar2);
            bVar2.setKeyboardListener(null);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        kotlin.jvm.internal.m.f(v10, "v");
        switch (v10.getId()) {
            case R$id.rechargeremindf_tv_binduser /* 2131429082 */:
                a2();
                break;
            case R$id.rechargeremindf_tv_how_to_recharge /* 2131429083 */:
                boolean z10 = com.live.evo.a.f5181a;
                break;
            case R$id.renew_check_payment /* 2131429143 */:
                K1();
                G1(null, true);
                break;
            case R$id.renew_plan_check_payment /* 2131429147 */:
                K1();
                G1(new Runnable() { // from class: com.live.evo.fragment.k3
                    @Override // java.lang.Runnable
                    public final void run() {
                        l3.w1(this.f6043a);
                    }
                }, true);
                break;
            case R$id.renew_plan_qrcode_refresh /* 2131429149 */:
                I1(new Runnable() { // from class: com.live.evo.fragment.j3
                    @Override // java.lang.Runnable
                    public final void run() {
                        l3.z1(this.f5994a);
                    }
                });
                break;
            case R$id.renew_qrcode_refresh /* 2131429154 */:
                I1(new Runnable() { // from class: com.live.evo.fragment.i3
                    @Override // java.lang.Runnable
                    public final void run() {
                        l3.y1(this.f5989a);
                    }
                });
                break;
            case R$id.renew_rechargecode_confirm /* 2131429161 */:
                if (!com.live.evo.util.x1.m(1000L)) {
                    if (!com.live.evo.l.n().v()) {
                        L1();
                    } else {
                        I1(new Runnable() { // from class: com.live.evo.fragment.u2
                            @Override // java.lang.Runnable
                            public final void run() {
                                l3.x1(this.f6847a);
                            }
                        });
                    }
                }
                break;
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View v10, boolean hasFocus) {
        if (hasFocus) {
            com.live.evo.util.z0.d(v10);
        } else {
            com.live.evo.util.z0.g(v10);
        }
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onPause() {
        com.live.evo.fragment.login.presenter.g gVar = this.mRechargeAndLoginPresenter;
        if (gVar != null) {
            kotlin.jvm.internal.m.c(gVar);
            gVar.u();
        }
        this.isVisible = false;
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.debug("tab visible on pause", new Object[0]);
        }
        super.onPause();
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void z() {
        y1 y1Var = this.mOnEventListener;
        if (y1Var != null) {
            kotlin.jvm.internal.m.c(y1Var);
            y1Var.c();
        }
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.m.d(activity, "null cannot be cast to non-null type com.live.evo.activity.LiveNewActivity");
        ((LiveNewActivity) activity).L3();
        v0.b().e();
        if (com.live.evo.l.n().e() == 2) {
            a.a().d();
        }
        l();
    }

    private final void K1() {
        int iE = com.live.evo.l.n().e();
        int iD = com.live.evo.util.s0.f7342a.D();
        if (iE != 0 && iE != 1 && iE != 2) {
            if (iD == 3) {
                y1 y1Var = this.mOnEventListener;
                if (y1Var != null) {
                    kotlin.jvm.internal.m.c(y1Var);
                    y1Var.c();
                }
                a2();
                return;
            }
            if (!com.live.evo.util.x1.m(500L)) {
                l();
                return;
            }
            return;
        }
        if (iD == 3) {
            y1 y1Var2 = this.mOnEventListener;
            if (y1Var2 != null) {
                kotlin.jvm.internal.m.c(y1Var2);
                y1Var2.c();
            }
            a2();
            return;
        }
        if (com.live.evo.util.x1.m(500L)) {
            return;
        }
        l();
    }

    private final void O1() {
        W1();
        o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(boolean bMessage, long nowExpireTs, long responseExpiredTS, Runnable buttonAction) {
        com.live.evo.l.n().e();
        if (nowExpireTs != responseExpiredTS) {
            if (buttonAction != null) {
                this.mActionExecute = true;
            }
            String strJ = com.live.evo.util.x1.j(R$string.remind_recharge_successfully);
            kotlin.jvm.internal.m.e(strJ, "getString(...)");
            D1("", strJ, "", null);
            com.live.evo.l.n().M();
            P1();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.live.evo.fragment.y2
                    @Override // java.lang.Runnable
                    public final void run() {
                        l3.S1(this.f6928a);
                    }
                });
                return;
            }
            return;
        }
        if (buttonAction != null && !this.mActionExecute) {
            this.mActionExecute = true;
            buttonAction.run();
        }
        if (bMessage) {
            String strJ2 = com.live.evo.util.x1.j(R$string.user_not_available);
            kotlin.jvm.internal.m.e(strJ2, "getString(...)");
            A1("", strJ2, "", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(l3 l3Var) {
        y1 y1Var;
        l3Var.Z1();
        l3Var.l();
        if (com.live.evo.l.n().q() == 3 && (y1Var = l3Var.mOnEventListener) != null) {
            kotlin.jvm.internal.m.c(y1Var);
            y1Var.c();
        }
        if (l3Var.getActivity() instanceof LiveNewActivity) {
            FragmentActivity activity = l3Var.getActivity();
            kotlin.jvm.internal.m.d(activity, "null cannot be cast to non-null type com.live.evo.activity.LiveNewActivity");
            ((LiveNewActivity) activity).L3();
        }
    }

    private final void W0() {
        String str;
        int i10;
        this.mAccountRenewType = com.live.evo.l.n().e();
        if (this.lastRequestTime + ((long) 10000) < com.live.evo.util.u1.b().a() && !this.isOnRequest) {
            this.lastRequestTime = 0L;
        }
        String strJ = com.live.evo.util.x1.j(R$string.payment_guide_common);
        int i11 = this.mAccountRenewType;
        String strJ2 = "";
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 != 2) {
                    str = "";
                } else {
                    strJ2 = com.live.evo.util.x1.j(R$string.renew_your_plan);
                    strJ = com.live.evo.util.x1.j(R$string.payment_guide_rechargecode);
                    str = "_offline";
                }
            } else {
                strJ2 = com.live.evo.util.x1.j(R$string.renew_your_plan);
                strJ = com.live.evo.util.x1.j(R$string.payment_guide_online);
                str = "_online";
            }
        } else {
            String strJ3 = com.live.evo.util.x1.j(R$string.choose_renew_method);
            if (!com.live.evo.l.n().v()) {
                strJ3 = com.live.evo.util.x1.j(R$string.renew_your_plan);
            }
            strJ2 = strJ3;
            str = "";
        }
        if (com.live.evo.a.f5188h) {
            strJ2 = com.live.evo.util.x1.j(R$string.renew_your_plan);
            TextView textView = this.mRemind;
            kotlin.jvm.internal.m.c(textView);
            textView.setGravity(17);
        }
        TextView textView2 = this.mRemind;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setText(Html.fromHtml(com.live.evo.l.n().i("renew_your_plan" + str, strJ2)));
        TextView textView3 = this.mRenewNow;
        kotlin.jvm.internal.m.c(textView3);
        int i12 = 0;
        if (com.live.evo.a.f5188h) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        textView3.setVisibility(i10);
        View view = this.mRenewLayout;
        kotlin.jvm.internal.m.c(view);
        if (com.live.evo.a.f5188h) {
            i12 = 8;
        }
        view.setVisibility(i12);
        String strA = com.live.evo.util.p1.a("how_to_new_title" + str, com.live.evo.util.x1.j(R$string.how_to_buy_play));
        TextView textView4 = this.mRechargeHint;
        kotlin.jvm.internal.m.c(textView4);
        textView4.setText(Html.fromHtml(strA));
        if (!com.live.evo.l.n().v() || this.mAccountRenewType == 2) {
            strJ = com.live.evo.util.x1.j(R$string.payment_guide_rechargecode);
            if (this.mAccountRenewType == 1) {
                View view2 = this.mRechargeCodeLayout;
                kotlin.jvm.internal.m.c(view2);
                view2.setVisibility(8);
                strJ = com.live.evo.util.x1.j(R$string.payment_guide_not_all);
            }
        }
        String strA2 = com.live.evo.util.p1.a("payment_guide" + str, strJ);
        TextView textView5 = this.mRemindBottom;
        kotlin.jvm.internal.m.c(textView5);
        textView5.setText(Html.fromHtml(strA2));
        P1();
        Z1();
        q1(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Y1() {
        if (com.live.evo.l.n().f() && com.live.evo.l.n().v() && com.live.evo.l.n().I()) {
            return true;
        }
        return false;
    }

    private final void Z0() {
        String strJ;
        String str;
        int i10;
        this.mAccountRenewType = com.live.evo.l.n().e();
        if (this.lastRequestTime + ((long) 10000) < com.live.evo.util.u1.b().a() && !this.isOnRequest) {
            this.lastRequestTime = 0L;
        }
        com.live.evo.util.x1.j(R$string.payment_guide_rechargecode);
        if (com.live.evo.l.n().v() && com.live.evo.l.n().u()) {
            strJ = com.live.evo.util.x1.j(R$string.choose_renew_method);
        } else {
            strJ = com.live.evo.util.x1.j(R$string.renew_your_plan);
        }
        int i11 = this.mAccountRenewType;
        if (i11 != 1) {
            if (i11 != 2) {
                str = "";
            } else {
                com.live.evo.util.x1.j(R$string.payment_guide_rechargecode);
                str = "_offline";
            }
        } else {
            com.live.evo.util.x1.j(R$string.payment_guide_online);
            str = "_online";
        }
        if (com.live.evo.a.f5188h) {
            strJ = com.live.evo.util.x1.j(R$string.renew_your_plan);
            TextView textView = this.mRemind;
            kotlin.jvm.internal.m.c(textView);
            textView.setGravity(17);
        }
        TextView textView2 = this.mRemind;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setText(Html.fromHtml(com.live.evo.l.n().i("renew_your_plan", strJ)));
        TextView textView3 = this.mRenewNow;
        kotlin.jvm.internal.m.c(textView3);
        int i12 = 0;
        if (com.live.evo.a.f5188h) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        textView3.setVisibility(i10);
        View view = this.mRenewLayout;
        kotlin.jvm.internal.m.c(view);
        if (com.live.evo.a.f5188h) {
            i12 = 8;
        }
        view.setVisibility(i12);
        String strA = com.live.evo.util.p1.a("how_to_new_title" + str, com.live.evo.util.x1.j(R$string.how_to_buy_play));
        TextView textView4 = this.mRechargeHint;
        kotlin.jvm.internal.m.c(textView4);
        textView4.setText(Html.fromHtml(strA));
        if (!com.live.evo.l.n().v()) {
            com.live.evo.util.x1.j(R$string.payment_guide_rechargecode);
            if (!com.live.evo.l.n().u()) {
                View view2 = this.mRechargeCodeLayout;
                kotlin.jvm.internal.m.c(view2);
                view2.setVisibility(8);
                com.live.evo.util.x1.j(R$string.payment_guide_not_all);
            }
        }
        String strB = com.live.evo.util.p1.b(com.live.evo.util.x1.j(R$string.payment_guide_how_to));
        TextView textView5 = this.mRemindBottom;
        kotlin.jvm.internal.m.c(textView5);
        textView5.setText(Html.fromHtml(strB));
        P1();
        Z1();
        q1(str);
    }

    private final void Z1() {
        s1();
        r1();
    }

    private final void a1() {
        boolean zV = com.live.evo.l.n().v();
        boolean zU = com.live.evo.l.n().u();
        if (zV) {
            if (!zU) {
                if (this.mCheckPayment != null) {
                    TextView textView = this.mRefreshQR;
                    kotlin.jvm.internal.m.c(textView);
                    textView.setNextFocusRightId(R$id.renew_qrcode_refresh);
                    TextView textView2 = this.mCheckPayment;
                    kotlin.jvm.internal.m.c(textView2);
                    textView2.setNextFocusRightId(R$id.renew_check_payment);
                    return;
                }
                return;
            }
            d1();
            return;
        }
        RechargeEditText rechargeEditText = this.mRechargeEdit;
        kotlin.jvm.internal.m.c(rechargeEditText);
        rechargeEditText.setNextFocusLeftId(R$id.renew_et_rechargecode);
        TextView textView3 = this.mRechargeConfirm;
        kotlin.jvm.internal.m.c(textView3);
        textView3.setNextFocusLeftId(R$id.renew_rechargecode_confirm);
    }

    private final void a2() {
        com.live.evo.fragment.login.j.g0(getChildFragmentManager(), 25, this.mAccountCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f1(l3 l3Var, View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (i10 != 19) {
                if (i10 == 22) {
                    View view2 = l3Var.mRechargeCodeLayout;
                    if (view2 != null) {
                        kotlin.jvm.internal.m.c(view2);
                        if (view2.getVisibility() == 0) {
                            l3Var.M1();
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
            l3Var.Q0();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g1(l3 l3Var, View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i10 == 22) {
            View view2 = l3Var.mRechargeCodeLayout;
            if (view2 != null) {
                kotlin.jvm.internal.m.c(view2);
                if (view2.getVisibility() == 0) {
                    l3Var.M1();
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i1(l3 l3Var, View view, int i10, KeyEvent keyEvent) {
        ziyi.kit.keyboard.b bVar;
        if (keyEvent.getAction() == 0) {
            if (i10 != 19) {
                if (i10 != 20) {
                    if (i10 != 22) {
                        if ((i10 == 23 || i10 == 66) && (bVar = l3Var.keyboardView) != null) {
                            kotlin.jvm.internal.m.c(bVar);
                            if (bVar.getFocusedEditText() != null) {
                                ziyi.kit.keyboard.b bVar2 = l3Var.keyboardView;
                                kotlin.jvm.internal.m.c(bVar2);
                                EditText focusedEditText = bVar2.getFocusedEditText();
                                kotlin.jvm.internal.m.c(focusedEditText);
                                if (focusedEditText.getId() == view.getId()) {
                                    ziyi.kit.keyboard.b bVar3 = l3Var.keyboardView;
                                    kotlin.jvm.internal.m.c(bVar3);
                                    if (bVar3.getVisibility() != 0) {
                                        try {
                                            ziyi.kit.keyboard.b bVar4 = l3Var.keyboardView;
                                            kotlin.jvm.internal.m.c(bVar4);
                                            bVar4.m0();
                                        } catch (Exception unused) {
                                        }
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
                TextView textView = l3Var.mRechargeConfirm;
                kotlin.jvm.internal.m.c(textView);
                if (textView.isEnabled()) {
                    TextView textView2 = l3Var.mRechargeConfirm;
                    kotlin.jvm.internal.m.c(textView2);
                    textView2.requestFocus();
                }
                return true;
            }
            l3Var.Q0();
            return false;
        }
        if (keyEvent.getAction() == 1) {
            if (i10 != 23 && i10 != 66) {
                ziyi.kit.keyboard.b bVar5 = l3Var.keyboardView;
                if (bVar5 != null) {
                    if (i10 == 4 || i10 == 111) {
                        kotlin.jvm.internal.m.c(bVar5);
                        if (bVar5.getVisibility() == 0) {
                            ziyi.kit.keyboard.b bVar6 = l3Var.keyboardView;
                            kotlin.jvm.internal.m.c(bVar6);
                            bVar6.p();
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            ziyi.kit.keyboard.b bVar7 = l3Var.keyboardView;
            if (bVar7 != null) {
                kotlin.jvm.internal.m.c(bVar7);
                if (bVar7.getFocusedEditText() != null) {
                    ziyi.kit.keyboard.b bVar8 = l3Var.keyboardView;
                    kotlin.jvm.internal.m.c(bVar8);
                    EditText focusedEditText2 = bVar8.getFocusedEditText();
                    kotlin.jvm.internal.m.c(focusedEditText2);
                    if (focusedEditText2.getId() == view.getId()) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j1(l3 l3Var, View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i10 == 22) {
            l3Var.M1();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k1(l3 l3Var, View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i10 == 19) {
            l3Var.Q0();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        if (com.live.evo.l.n().f()) {
            Z0();
        } else {
            W0();
        }
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, ((long) t.v.c.i.a.f18646a.V()) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l1(l3 l3Var, View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i10 == 19) {
            l3Var.Q0();
            return false;
        }
        return false;
    }

    private final void o1() {
        Bitmap bitmapT;
        if (!com.live.evo.l.n().v()) {
            U0();
            return;
        }
        if (Y1()) {
            J1();
            return;
        }
        String strP = t.v.c.i.a.f18646a.P();
        if (!ac.g.d(strP, this.lastQRUrl)) {
            boolean zIsEmpty = TextUtils.isEmpty(strP);
            if (!zIsEmpty) {
                View view = this.mScanedRenewLayout;
                kotlin.jvm.internal.m.c(view);
                if (view.getVisibility() != 0) {
                    View view2 = this.mScanedRenewLayout;
                    kotlin.jvm.internal.m.c(view2);
                    view2.setVisibility(0);
                }
            } else {
                View view3 = this.mScanedRenewLayout;
                kotlin.jvm.internal.m.c(view3);
                if (view3.getVisibility() == 0) {
                    View view4 = this.mScanedRenewLayout;
                    kotlin.jvm.internal.m.c(view4);
                    view4.setVisibility(8);
                }
            }
            if (!zIsEmpty && (bitmapT = com.live.evo.l.n().t(strP)) != null) {
                com.live.evo.util.v.b(getContext(), bitmapT, R$drawable.qr_placehodler, this.mScanQRPic);
            }
            this.lastQRUrl = strP;
            return;
        }
        U0();
    }

    private final void p1() {
        this.interval = com.live.evo.l.n().h("request_scanurl_interval", TimeUnit.MINUTES.toMillis(1L));
    }

    private final void q1(String renewKey) {
        if (com.live.evo.l.n().f()) {
            if (com.live.evo.l.n().v()) {
                o1();
            }
        } else {
            int i10 = this.mAccountRenewType;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2 && com.live.evo.l.n().v()) {
                        o1();
                    }
                } else {
                    o1();
                }
            } else if (com.live.evo.l.n().v()) {
                o1();
            }
        }
        String strI = com.live.evo.l.n().i("renew_scaned_title", com.live.evo.util.x1.j(R$string.qr_code_plan));
        TextView textView = this.mScanQRTitle;
        kotlin.jvm.internal.m.c(textView);
        textView.setText(strI);
        TextView textView2 = this.mScanPlanQRTitle;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setText(strI);
        String strB = com.live.evo.util.p1.b(com.live.evo.util.x1.j(R$string.payment_guide_online_1));
        TextView textView3 = this.mScanQRRemind;
        kotlin.jvm.internal.m.c(textView3);
        textView3.setText(Html.fromHtml(strB));
        TextView textView4 = this.mScanPlanQRRemind;
        kotlin.jvm.internal.m.c(textView4);
        textView4.setText(Html.fromHtml(strB));
        String strI2 = com.live.evo.l.n().i("renew_refresh_qr", com.live.evo.util.x1.j(R$string.refresh_qr_code));
        TextView textView5 = this.mRefreshQR;
        kotlin.jvm.internal.m.c(textView5);
        textView5.setText(strI2);
        String strI3 = com.live.evo.l.n().i("renew_checkpayment", com.live.evo.util.x1.j(2131952883));
        TextView textView6 = this.mCheckPayment;
        kotlin.jvm.internal.m.c(textView6);
        textView6.setText(strI3);
        String strI4 = com.live.evo.l.n().i("renew_rechargecode_title", com.live.evo.util.x1.j(R$string.use_code_nopaid));
        if (!com.live.evo.l.n().v()) {
            strI4 = com.live.evo.l.n().i("renew_rechargecode_title", com.live.evo.util.x1.j(R$string.use_code_nopaid));
        }
        TextView textView7 = this.mRechargeTitle;
        kotlin.jvm.internal.m.c(textView7);
        textView7.setText(strI4);
        String strI5 = com.live.evo.l.n().i("renew_rechargecode_remind", com.live.evo.util.x1.j(R$string.renew_rehargecode_tip));
        TextView textView8 = this.mRechargeRemind;
        kotlin.jvm.internal.m.c(textView8);
        textView8.setText(strI5);
    }

    private final void r1() {
        if (com.live.evo.l.n().f()) {
            a1();
        } else {
            X0();
        }
    }

    private final void s1() {
        if (com.live.evo.l.n().f()) {
            b1();
        } else {
            Y0();
        }
    }

    private final void t1() {
        View viewRequireView = requireView();
        kotlin.jvm.internal.m.e(viewRequireView, "requireView(...)");
        this.mRemind = (TextView) viewRequireView.findViewById(R$id.rechargeremindf_tv_remind);
        this.mRenewNow = (TextView) viewRequireView.findViewById(R$id.rechargeremindf_tv_how_to_recharge);
        this.mBindUser = (TextView) viewRequireView.findViewById(R$id.rechargeremindf_tv_binduser);
        this.mRenewLayout = viewRequireView.findViewById(R$id.rechargeremindf_ll_recharge);
        this.mGapLine = viewRequireView.findViewById(R$id.renew_view_line);
        this.mScanedRenewLayout = viewRequireView.findViewById(R$id.renew_scaned_layout);
        this.mScanQRTitle = (TextView) viewRequireView.findViewById(R$id.renew_qrcode_title);
        this.mScanQRRemind = (TextView) viewRequireView.findViewById(R$id.renew_qrcode_remind);
        this.mScanQRPic = (ImageView) viewRequireView.findViewById(R$id.renew_qrcode_pic);
        this.mRefreshQR = (TextView) viewRequireView.findViewById(R$id.renew_qrcode_refresh);
        this.mCheckPayment = (TextView) viewRequireView.findViewById(R$id.renew_check_payment);
        this.mRechargeCodeLayout = viewRequireView.findViewById(R$id.renew_recharge_layout);
        this.mRechargeTitle = (TextView) viewRequireView.findViewById(R$id.renew_rechargecode_title);
        this.mRechargeRemind = (TextView) viewRequireView.findViewById(R$id.renew_rechargecode_remind);
        this.mRechargeEdit = (RechargeEditText) viewRequireView.findViewById(R$id.renew_et_rechargecode);
        this.mRechargeConfirm = (TextView) viewRequireView.findViewById(R$id.renew_rechargecode_confirm);
        this.mScanWebPlanLayout = viewRequireView.findViewById(R$id.layout_scan_plan_content);
        this.mScanPlanQRTitle = (TextView) viewRequireView.findViewById(R$id.renew_plan_qrcode_title);
        this.mScanPlanQRRemind = (TextView) viewRequireView.findViewById(R$id.renew_plan_qrcode_remind);
        this.mScanPlanQRPic = (ImageView) viewRequireView.findViewById(R$id.renew_plan_qrcode_pic);
        this.mRefreshPlanQR = (TextView) viewRequireView.findViewById(R$id.renew_plan_qrcode_refresh);
        this.mCheckPlanPayment = (TextView) viewRequireView.findViewById(R$id.renew_plan_check_payment);
        this.recyclerViewPlan = (VerticalGridView) viewRequireView.findViewById(R$id.rv_plan_list);
        this.mRechargeHint = (TextView) viewRequireView.findViewById(R$id.rechargeremindf_ltv_remind_hint);
        this.mRemindBottom = (TextView) viewRequireView.findViewById(R$id.rechargeremindf_tv_remind_bottom);
        com.live.evo.util.t.c(this.mRemind);
        com.live.evo.util.t.b(this.mRemindBottom);
        com.live.evo.util.t.b(this.mRechargeHint);
        com.live.evo.util.t.a(this.mScanQRTitle);
        com.live.evo.util.t.a(this.mScanQRRemind);
        com.live.evo.util.t.a(this.mRechargeTitle);
        com.live.evo.util.t.a(this.mRechargeRemind);
        com.live.evo.util.t.a(this.mRefreshQR);
        com.live.evo.util.t.a(this.mCheckPayment);
        com.live.evo.util.t.d(this.mRechargeConfirm);
        t5.a aVar = new t5.a(requireActivity());
        this.loadingView = aVar;
        kotlin.jvm.internal.m.c(aVar);
        aVar.f(com.live.evo.widget.sloading.c.SINGLE_CIRCLE);
        t5.a aVar2 = this.loadingView;
        kotlin.jvm.internal.m.c(aVar2);
        aVar2.g(R$color.sloading_color);
        VerticalGridView verticalGridView = this.recyclerViewPlan;
        if (verticalGridView != null) {
            verticalGridView.addItemDecoration(new com.live.evo.widget.v(6));
        }
    }

    private final boolean u1() {
        if (com.live.evo.l.n().l() <= com.live.evo.util.u1.b().a()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(l3 l3Var) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, l3Var.new g(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(l3 l3Var) {
        if (l3Var.Y1()) {
            l3Var.F1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(l3 l3Var) {
        l3Var.L1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(l3 l3Var) {
        l3Var.O1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(l3 l3Var) {
        l3Var.F1();
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void a() {
        U0();
    }

    @Override // com.live.evo.fragment.login.presenter.f
    public void b() {
        W1();
    }

    @Override // l5.b
    protected int b0() {
        return R$layout.tabfunction_recharge_fragment;
    }

    @Override // l5.b
    protected void c0(Bundle savedInstanceState) {
        n1();
        l();
        p1();
        V0();
    }

    @Override // l5.b
    protected void d0() {
        d1();
        c1();
        e1();
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        x1.f1.lb.util.e0.f21385a.a(this);
        com.live.evo.fragment.login.presenter.g gVar = this.mRechargeAndLoginPresenter;
        if (gVar != null) {
            kotlin.jvm.internal.m.c(gVar);
            gVar.B(this);
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1() {
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onUserTokenChangedEvent(b5.m event) {
    }
}
