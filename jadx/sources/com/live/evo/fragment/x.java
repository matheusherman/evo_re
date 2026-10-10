package com.live.evo.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.live.evo.R$array;
import com.live.evo.R$dimen;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.activity.LiveNewActivity;
import com.live.evo.activity.SpeedTestActivity;
import com.live.evo.widget.ProgramListView;
import com.live.evo.widget.RemoveKeyCodeEnterEditText;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import com.youth.banner.Banner;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000Þ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 N2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002ê\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0005J)\u0010 \u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u0005J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u001eH\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b.\u0010\rJ\u000f\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b/\u0010\rJ\u000f\u00100\u001a\u00020\u000bH\u0002¢\u0006\u0004\b0\u0010\rJ!\u00104\u001a\u00020\b2\u0010\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u000101H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\bH\u0002¢\u0006\u0004\b6\u0010\u0005J\u0017\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020\u001cH\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u001eH\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u000bH\u0002¢\u0006\u0004\b=\u0010\rJ\u000f\u0010>\u001a\u00020\u000bH\u0002¢\u0006\u0004\b>\u0010\rJ\u000f\u0010?\u001a\u00020\bH\u0002¢\u0006\u0004\b?\u0010\u0005J\u0019\u0010A\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\bH\u0002¢\u0006\u0004\bC\u0010\u0005J\u000f\u0010D\u001a\u00020\bH\u0002¢\u0006\u0004\bD\u0010\u0005J\u001f\u0010H\u001a\u00020\b2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u001eH\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\b2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001eH\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001eH\u0002¢\u0006\u0004\bN\u0010MJ\u000f\u0010O\u001a\u00020\bH\u0002¢\u0006\u0004\bO\u0010\u0005J\u000f\u0010P\u001a\u00020\bH\u0002¢\u0006\u0004\bP\u0010\u0005J\u000f\u0010Q\u001a\u00020\bH\u0002¢\u0006\u0004\bQ\u0010\u0005J\u000f\u0010R\u001a\u00020\bH\u0002¢\u0006\u0004\bR\u0010\u0005J\u0017\u0010T\u001a\u00020\b2\u0006\u0010S\u001a\u00020\u001cH\u0002¢\u0006\u0004\bT\u00109J\u0017\u0010W\u001a\u00020\b2\u0006\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\bH\u0016¢\u0006\u0004\bY\u0010\u0005J\u000f\u0010Z\u001a\u00020\u001eH\u0014¢\u0006\u0004\bZ\u0010;J\u0017\u0010[\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0014¢\u0006\u0004\b[\u0010\nJ\u000f\u0010\\\u001a\u00020\bH\u0014¢\u0006\u0004\b\\\u0010\u0005J\u0019\u0010_\u001a\u00020\b2\b\u0010^\u001a\u0004\u0018\u00010]H\u0014¢\u0006\u0004\b_\u0010`J\u0017\u0010c\u001a\u00020\b2\b\u0010b\u001a\u0004\u0018\u00010a¢\u0006\u0004\bc\u0010dJ\r\u0010e\u001a\u00020\b¢\u0006\u0004\be\u0010\u0005J\r\u0010f\u001a\u00020\b¢\u0006\u0004\bf\u0010\u0005J\r\u0010g\u001a\u00020\b¢\u0006\u0004\bg\u0010\u0005J\r\u0010h\u001a\u00020\b¢\u0006\u0004\bh\u0010\u0005J\u0017\u0010j\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u000bH\u0016¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u000bH\u0016¢\u0006\u0004\bl\u0010kJ'\u0010q\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\u001e2\u0006\u0010p\u001a\u00020oH\u0016¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020\bH\u0016¢\u0006\u0004\bs\u0010\u0005J\u000f\u0010t\u001a\u00020\bH\u0016¢\u0006\u0004\bt\u0010\u0005J\u000f\u0010u\u001a\u00020\bH\u0016¢\u0006\u0004\bu\u0010\u0005J\u000f\u0010v\u001a\u00020\u001eH\u0016¢\u0006\u0004\bv\u0010;J\u0017\u0010x\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u001eH\u0016¢\u0006\u0004\bx\u0010-J\u0017\u0010z\u001a\u00020\b2\u0006\u0010y\u001a\u00020\u001eH\u0016¢\u0006\u0004\bz\u0010-J\u0017\u0010|\u001a\u00020\b2\u0006\u0010{\u001a\u00020\u001eH\u0016¢\u0006\u0004\b|\u0010-J\u000f\u0010}\u001a\u00020\bH\u0016¢\u0006\u0004\b}\u0010\u0005J\u000f\u0010~\u001a\u00020\bH\u0016¢\u0006\u0004\b~\u0010\u0005J\u000f\u0010\u007f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u007f\u0010\u0005J\u0011\u0010\u0080\u0001\u001a\u00020\u000bH\u0016¢\u0006\u0005\b\u0080\u0001\u0010\rJ\u001c\u0010\u0082\u0001\u001a\u00020\b2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0005\b\u0082\u0001\u00109J)\u0010\u0086\u0001\u001a\u00020\b2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00012\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0011\u0010\u0088\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0088\u0001\u0010\u0005J*\u0010\u008b\u0001\u001a\u00020\b2\r\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020E012\u0007\u0010\u008a\u0001\u001a\u00020\u001cH\u0016¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u001b\u0010\u008d\u0001\u001a\u00020\b2\b\u0010b\u001a\u0004\u0018\u00010aH\u0016¢\u0006\u0005\b\u008d\u0001\u0010dJ\u001e\u0010\u0090\u0001\u001a\u00020\b2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J)\u0010\u0095\u0001\u001a\u00020\b2\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00012\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0011\u0010\u0097\u0001\u001a\u00020\bH\u0016¢\u0006\u0005\b\u0097\u0001\u0010\u0005J\u000f\u0010\u0098\u0001\u001a\u00020\b¢\u0006\u0005\b\u0098\u0001\u0010\u0005J\u001d\u0010\u009a\u0001\u001a\u00020\b2\t\u0010p\u001a\u0005\u0018\u00010\u0099\u0001H\u0007¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u000f\u0010\u009c\u0001\u001a\u00020\b¢\u0006\u0005\b\u009c\u0001\u0010\u0005J\u0013\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u0001¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001R\"\u0010¤\u0001\u001a\r ¡\u0001*\u0005\u0018\u00010 \u00010 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010¥\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010uR\u0018\u0010§\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¦\u0001\u0010uR\u0017\u0010¨\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010uR\u001b\u0010«\u0001\u001a\u0005\u0018\u00010©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bz\u0010ª\u0001R\u001c\u0010®\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u00ad\u0001R\u001b\u0010±\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b|\u0010°\u0001R(\u0010µ\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0005\u0012\u00030³\u0001\u0018\u00010²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010´\u0001R\u001b\u0010¶\u0001\u001a\u0005\u0018\u00010©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b~\u0010ª\u0001R\u001b\u0010¹\u0001\u001a\u0005\u0018\u00010·\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bx\u0010¸\u0001R \u0010»\u0001\u001a\n\u0012\u0004\u0012\u000202\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bm\u0010º\u0001R\u0019\u0010¾\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001c\u0010Â\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001c\u0010Ä\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Á\u0001R\u001c\u0010Æ\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Á\u0001R\u0018\u0010È\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÇ\u0001\u0010uR\u0018\u0010Ê\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÉ\u0001\u0010uR\u001c\u0010Ì\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010°\u0001R\u001c\u0010Î\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010°\u0001R\u001c\u0010Ï\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010°\u0001R\u001c\u0010Ò\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010Ñ\u0001R\u001c\u0010Ô\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010°\u0001R\u001c\u0010Ö\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Á\u0001R\u001b\u0010×\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bu\u0010°\u0001R)\u0010Ù\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0005\u0012\u00030³\u0001\u0018\u00010²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010´\u0001R\u001c\u0010Û\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Á\u0001R\u001c\u0010Ü\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010Á\u0001R\u001c\u0010Ý\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010Á\u0001R(\u0010à\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010Þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010ß\u0001R\u001c\u0010ä\u0001\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001c\u0010æ\u0001\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010ã\u0001R\u0019\u0010è\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010½\u0001R\u001c\u0010ê\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010°\u0001R\u001c\u0010ì\u0001\u001a\u0005\u0018\u00010©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010ª\u0001R\u001c\u0010ð\u0001\u001a\u0005\u0018\u00010í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R\u001c\u0010ò\u0001\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0001\u0010ã\u0001R\u001c\u0010ô\u0001\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010ã\u0001R\u001c\u0010ö\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010Ñ\u0001R\u001c\u0010ø\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010Á\u0001R\u001c\u0010ú\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010Á\u0001R\u001c\u0010û\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010Á\u0001R\u001c\u0010ý\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010Á\u0001R\u001c\u0010ÿ\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010Á\u0001R\u001c\u0010\u0081\u0002\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0002\u0010Á\u0001R\u001c\u0010\u0083\u0002\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0002\u0010Á\u0001R\u001c\u0010\u0085\u0002\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0002\u0010Á\u0001R\u001c\u0010\u0087\u0002\u001a\u0005\u0018\u00010Ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0002\u0010Ñ\u0001R\u001c\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u0088\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010\u008a\u0002R\u001c\u0010\u008d\u0002\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010Á\u0001R\u001b\u0010\u008e\u0002\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b,\u0010Á\u0001R\u001a\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0018\u0010\u008f\u0002R\u0018\u0010\u0091\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b>\u0010½\u0001R\u0018\u0010\u0092\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b.\u0010½\u0001R\u0018\u0010\u0093\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b=\u0010½\u0001R\u001a\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b/\u0010\u0094\u0002R\u001b\u0010\u0096\u0002\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b0\u0010Á\u0001R\u001b\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0088\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\"\u0010\u008a\u0002R\u001b\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0088\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\f\u0010\u008a\u0002R\u001b\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u0099\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bC\u0010\u009a\u0002R\u001b\u0010\u009c\u0002\u001a\u0005\u0018\u00010©\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bL\u0010ª\u0001R\"\u0010\u009e\u0002\u001a\u000b\u0012\u0004\u0012\u00020E\u0018\u00010\u009d\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010º\u0001R!\u0010\u009f\u0002\u001a\u000b\u0012\u0004\u0012\u00020E\u0018\u00010\u009d\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b:\u0010º\u0001R\u0019\u0010¡\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0002\u0010½\u0001R\u0018\u0010¢\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bP\u0010½\u0001R\u0018\u0010£\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b%\u0010½\u0001R\u0017\u0010¤\u0002\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010uR\u0018\u0010¥\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0019\u0010½\u0001R\u0019\u0010§\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0002\u0010½\u0001R\u0018\u0010¨\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0016\u0010½\u0001R\u0018\u0010©\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0013\u0010½\u0001R\u0019\u0010«\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0002\u0010½\u0001R\u0018\u0010\u00ad\u0002\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¬\u0002\u0010uR\u0018\u0010¯\u0002\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b®\u0002\u0010uR\u001a\u0010²\u0002\u001a\u00030°\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0002\u0010Ø\u0001R\u001a\u0010³\u0002\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000e\u0010\u0094\u0002R\u001a\u0010´\u0002\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0011\u0010\u0094\u0002R\u001b\u0010¶\u0002\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0002\u0010\u0094\u0002R\u001c\u0010º\u0002\u001a\u0005\u0018\u00010·\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0002\u0010¹\u0002R\u001c\u0010¼\u0002\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0002\u0010°\u0001R\u001c\u0010À\u0002\u001a\u0005\u0018\u00010½\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0002\u0010¿\u0002R\u001c\u0010Â\u0002\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0002\u0010Á\u0001R\u001b\u0010Ã\u0002\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bf\u0010Á\u0001R\u0015\u0010Ä\u0002\u001a\u00020\u001e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000f\u0010uR\u001b\u0010Ç\u0002\u001a\u0005\u0018\u00010Å\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0017\u0010Æ\u0002R\u0018\u0010È\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b(\u0010\u0094\u0002R\u001c\u0010Ê\u0002\u001a\u0005\u0018\u00010\u0088\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0002\u0010\u008a\u0002R\u001c\u0010Ì\u0002\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0002\u0010Á\u0001R\u001f\u0010Ï\u0002\u001a\n\u0012\u0005\u0012\u00030Í\u00020\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0002\u0010º\u0001R\u0018\u0010Ð\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b$\u0010½\u0001R\u0018\u0010Ñ\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b#\u0010½\u0001R\u0019\u0010Ó\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0002\u0010½\u0001R\u001c\u0010Ö\u0002\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0002\u0010Õ\u0002R\u001a\u0010×\u0002\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\be\u0010\u008f\u0002R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bg\u0010\u008f\u0002R\u0017\u0010Ú\u0002\u001a\u00030Ø\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bh\u0010Ù\u0002R\u0017\u0010Û\u0002\u001a\u00030Ø\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0012\u0010Ù\u0002R\u0017\u0010Þ\u0002\u001a\u00030Ü\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bA\u0010Ý\u0002R\u0017\u0010ß\u0002\u001a\u00030Ø\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bQ\u0010Ù\u0002R\u0017\u0010â\u0002\u001a\u00030à\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bR\u0010á\u0002R\u0018\u0010å\u0002\u001a\u00030ã\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010ä\u0002R\u0017\u0010è\u0002\u001a\u00030æ\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bT\u0010ç\u0002R\u0017\u0010é\u0002\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010u¨\u0006ë\u0002"}, d2 = {"Lcom/live/evo/fragment/x;", "Ll5/b;", "Landroid/view/View$OnKeyListener;", "Lcom/live/evo/osd/persenter/b;", "<init>", "()V", "Landroid/view/View;", "focusView", "Lr8/z;", "M2", "(Landroid/view/View;)V", "", "S1", "()Z", "j2", "r2", "a2", "k2", "E2", "e2", "U2", "mRoot", "d2", "s2", "L1", "b2", "Landroid/widget/EditText;", "editText", "", "hintText", "", "textSize", "N2", "(Landroid/widget/EditText;Ljava/lang/String;I)V", "R1", "y2", "x2", "Z1", "S2", "W2", "t2", "X2", "b3", "position", "K1", "(I)V", "N1", "P1", "Q1", "", "Li5/h;", "listVodVideo", "e3", "(Ljava/util/List;)V", "R2", "key", "K2", "(Ljava/lang/String;)V", "W1", "()I", "Y2", "O1", "M1", "P2", "data", "F2", "(Li5/h;)V", "T1", "c3", "Li5/p;", "bean", NotificationCompat.CATEGORY_STATUS, "g3", "(Li5/p;I)V", "Q2", "(Li5/p;)V", "U1", "(I)I", "L2", "V2", "Y1", "G2", "H2", "classifyName", "J2", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onDetach", "b0", "f0", "d0", "Landroid/os/Bundle;", "savedInstanceState", "c0", "(Landroid/os/Bundle;)V", "Lcom/live/evo/osd/persenter/a;", "presenter", "f3", "(Lcom/live/evo/osd/persenter/a;)V", "B2", "q2", "C2", "D2", "hidden", "h0", "(Z)V", "onHiddenChanged", "v", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "onResume", "onDestroyView", "I", "o", "classifyPosition", "u", "inAllProgramPos", "p", "inListSelectPos", "r", "m", "t", "s", "isShowing", IjkMediaMeta.IJKM_KEY_TRACK_ID, "M", "", "throwable", "currentChannelId", "q", "(Ljava/lang/Throwable;Ljava/lang/String;)V", ExifInterface.LONGITUDE_EAST, "epgBeen", "channelId", "L", "(Ljava/util/List;Ljava/lang/String;)V", "O2", "Lb5/h;", "savePlayHistoryEvent", "F", "(Lb5/h;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "menuTag", "N", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "onDestroy", "I2", "Lnf/d;", "onChannelUpdateEvent", "(Lnf/d;)V", "T2", "Lziyi/kit/keyboard/b;", "V1", "()Lziyi/kit/keyboard/b;", "Lq6/b;", "kotlin.jvm.PlatformType", "l", "Lq6/b;", "logger", "playCategory", "n", "playChannel", "playAllPos", "Lcom/live/evo/widget/ProgramListView;", "Lcom/live/evo/widget/ProgramListView;", "mProgramListView", "Ln5/o;", "Ln5/o;", "mProgramAdapter", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "mCategoryBannerParent", "Lcom/youth/banner/Banner;", "Lcom/live/evo/catchup/player/b;", "Lcom/youth/banner/Banner;", "mCategoryBanner", "mCategoryListView", "Lcom/live/evo/osd/m;", "Lcom/live/evo/osd/m;", "mCategoryAdapter", "Ljava/util/List;", "mListVodVideo", "w", "Z", "hasChangeCategory", "Landroid/widget/TextView;", "x", "Landroid/widget/TextView;", "mTextCurrentPos", "y", "mTextViewTotalProg", "z", "mSessionId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "mProgramSelect", "B", "mCategorySelect", "C", "mPreviewContainer", "D", "mVideoPreview", "mChannelParent", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mCategoryLayout", "G", "mAdultKeyParent", "H", "mTextCategoryName", "mLayoutBanner", "J", "mBanner", "K", "mTextPosition", "mTextProgramTotal", "mTextPipTip", "", "Ljava/util/Map;", "mHistoryMap", "Landroid/animation/ValueAnimator;", "O", "Landroid/animation/ValueAnimator;", "categoryAnimClose", "P", "categoryAnimOpen", "Q", "mIsCategoryOpen", "R", "mEpgListParent", ExifInterface.LATITUDE_SOUTH, "mEpgListView", "Lcom/live/evo/osd/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/live/evo/osd/b;", "mEpgAdapter", "U", "epgAnimOpen", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "epgAnimClose", ExifInterface.LONGITUDE_WEST, "mEpgParent", "X", "mEpgProgramName", "Y", "mEpgDuration", "mEpgProgram", "b1", "mEpgDescription", "D1", "mEpgTime", "E1", "mEpgDesc", "F1", "mTvDuration", "G1", "mTvProgram", "H1", "mIvRightLayout", "Landroid/widget/ImageView;", "I1", "Landroid/widget/ImageView;", "mIvRight", "J1", "mTvNotData", "mEpgChannel", "Landroid/view/View;", "mCategoryParent", "isFist", "isChangeChannel", "isInitOpen", "Ljava/lang/String;", "mPreviousPlayData", "mTvMonth", "mIvUp", "mIvDown", "Ln5/b;", "Ln5/b;", "epgDateAdapter", "mLvEpgDate", "", "curChannelEpgList", "tempEpgList", "X1", "isInitEpgData", "isKeyCodeUp", "isKeyCodeDown", "mCategoryWidth", "mFocusable", "c2", "mEpgShowFirst", "mIsCatchUp", "mIsOnKeyLeft", "f2", "mShowBanner", "g2", "browseCount", "h2", "clickCount", "", "i2", "browseDuration", "mTipSwitch", "mTipOpenPip", "l2", "mTipClosePip", "Landroid/widget/Button;", "m2", "Landroid/widget/Button;", "goAhead", "n2", "layoutPwd", "Lcom/live/evo/widget/RemoveKeyCodeEnterEditText;", "o2", "Lcom/live/evo/widget/RemoveKeyCodeEnterEditText;", "etPassword", "p2", "title", "hint", "LENGTH", "Landroid/view/inputmethod/InputMethodManager;", "Landroid/view/inputmethod/InputMethodManager;", "mIm", "curChannelId", "u2", "mCategoryBannerFrontPic", "v2", "mCategoryBannerDesc", "Lcom/live/evo/util/x;", "w2", "numberStrategies", "postMetricisFromCategory", "isChannelHistoryLive", "z2", "isChannelUpdateByKids", "A2", "Lziyi/kit/keyboard/b;", "keyboardView", "mView", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mPipTipRunnable", "locateIvLeft", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "mProgramItemSelectListener", "mSetPreviewRunnable", "Landroid/widget/AdapterView$OnItemClickListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "mProgramItemClickListener", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "Lcom/live/evo/osd/v;", "Lcom/live/evo/osd/v;", "subscribeUpdateListener", "mNowPlayingIndex", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class x extends l5.b implements View.OnKeyListener, com.live.evo.osd.persenter.b {

    /* JADX INFO: renamed from: L2, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static List<String> M2 = new ArrayList();
    private static List<String> N2 = new ArrayList();
    private static HashMap<String, List<i5.h>> O2;
    private static Map<String, ? extends i5.i> P2;
    private static com.live.evo.osd.persenter.a Q2;
    private static y1 R2;
    private static SoftReference<x> S2;
    private static Window T2;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private int mProgramSelect;

    /* JADX INFO: renamed from: A2, reason: from kotlin metadata */
    private ziyi.kit.keyboard.b keyboardView;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private int mCategorySelect;

    /* JADX INFO: renamed from: B2, reason: from kotlin metadata */
    private View mView;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private RelativeLayout mPreviewContainer;

    /* JADX INFO: renamed from: C2, reason: from kotlin metadata */
    private View focusView;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private RelativeLayout mVideoPreview;

    /* JADX INFO: renamed from: D1, reason: from kotlin metadata */
    private TextView mEpgTime;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private RelativeLayout mChannelParent;

    /* JADX INFO: renamed from: E1, reason: from kotlin metadata */
    private TextView mEpgDesc;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private LinearLayout mCategoryLayout;

    /* JADX INFO: renamed from: F1, reason: from kotlin metadata */
    private TextView mTvDuration;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private RelativeLayout mAdultKeyParent;

    /* JADX INFO: renamed from: G1, reason: from kotlin metadata */
    private TextView mTvProgram;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private TextView mTextCategoryName;

    /* JADX INFO: renamed from: H1, reason: from kotlin metadata */
    private LinearLayout mIvRightLayout;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private RelativeLayout mLayoutBanner;

    /* JADX INFO: renamed from: I1, reason: from kotlin metadata */
    private ImageView mIvRight;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private Banner<String, com.live.evo.catchup.player.b> mBanner;

    /* JADX INFO: renamed from: J1, reason: from kotlin metadata */
    private TextView mTvNotData;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private TextView mTextPosition;

    /* JADX INFO: renamed from: K1, reason: from kotlin metadata */
    private TextView mEpgChannel;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private TextView mTextProgramTotal;

    /* JADX INFO: renamed from: L1, reason: from kotlin metadata */
    private View mCategoryParent;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private TextView mTextPipTip;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private Map<String, String> mHistoryMap;

    /* JADX INFO: renamed from: N1, reason: from kotlin metadata */
    private boolean isChangeChannel;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private ValueAnimator categoryAnimClose;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private ValueAnimator categoryAnimOpen;

    /* JADX INFO: renamed from: P1, reason: from kotlin metadata */
    private String mPreviousPlayData;

    /* JADX INFO: renamed from: Q1, reason: from kotlin metadata */
    private TextView mTvMonth;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    private RelativeLayout mEpgListParent;

    /* JADX INFO: renamed from: R1, reason: from kotlin metadata */
    private ImageView mIvUp;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    private ProgramListView mEpgListView;

    /* JADX INFO: renamed from: S1, reason: from kotlin metadata */
    private ImageView mIvDown;

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    private com.live.evo.osd.b mEpgAdapter;

    /* JADX INFO: renamed from: T1, reason: from kotlin metadata */
    private n5.b epgDateAdapter;

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    private ValueAnimator epgAnimOpen;

    /* JADX INFO: renamed from: U1, reason: from kotlin metadata */
    private ProgramListView mLvEpgDate;

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    private ValueAnimator epgAnimClose;

    /* JADX INFO: renamed from: V1, reason: from kotlin metadata */
    private List<i5.p> curChannelEpgList;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    private LinearLayout mEpgParent;

    /* JADX INFO: renamed from: W1, reason: from kotlin metadata */
    private List<i5.p> tempEpgList;

    /* JADX INFO: renamed from: X, reason: from kotlin metadata */
    private TextView mEpgProgramName;

    /* JADX INFO: renamed from: Y, reason: from kotlin metadata */
    private TextView mEpgDuration;

    /* JADX INFO: renamed from: Y1, reason: from kotlin metadata */
    private boolean isKeyCodeUp;

    /* JADX INFO: renamed from: Z, reason: from kotlin metadata */
    private TextView mEpgProgram;

    /* JADX INFO: renamed from: Z1, reason: from kotlin metadata */
    private boolean isKeyCodeDown;

    /* JADX INFO: renamed from: a2, reason: collision with root package name and from kotlin metadata */
    private int mCategoryWidth;

    /* JADX INFO: renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private TextView mEpgDescription;

    /* JADX INFO: renamed from: c2, reason: collision with root package name and from kotlin metadata */
    private boolean mEpgShowFirst;

    /* JADX INFO: renamed from: d2, reason: collision with root package name and from kotlin metadata */
    private boolean mIsCatchUp;

    /* JADX INFO: renamed from: f2, reason: collision with root package name and from kotlin metadata */
    private boolean mShowBanner;

    /* JADX INFO: renamed from: g2, reason: collision with root package name and from kotlin metadata */
    private int browseCount;

    /* JADX INFO: renamed from: h2, reason: collision with root package name and from kotlin metadata */
    private int clickCount;

    /* JADX INFO: renamed from: i2, reason: collision with root package name and from kotlin metadata */
    private long browseDuration;

    /* JADX INFO: renamed from: j2, reason: collision with root package name and from kotlin metadata */
    private String mTipSwitch;

    /* JADX INFO: renamed from: k2, reason: collision with root package name and from kotlin metadata */
    private String mTipOpenPip;

    /* JADX INFO: renamed from: l2, reason: collision with root package name and from kotlin metadata */
    private String mTipClosePip;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int playCategory;

    /* JADX INFO: renamed from: m2, reason: collision with root package name and from kotlin metadata */
    private Button goAhead;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int playChannel;

    /* JADX INFO: renamed from: n2, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout layoutPwd;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int playAllPos;

    /* JADX INFO: renamed from: o2, reason: collision with root package name and from kotlin metadata */
    private RemoveKeyCodeEnterEditText etPassword;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private ProgramListView mProgramListView;

    /* JADX INFO: renamed from: p2, reason: collision with root package name and from kotlin metadata */
    private TextView title;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private n5.o mProgramAdapter;

    /* JADX INFO: renamed from: q2, reason: collision with root package name and from kotlin metadata */
    private TextView hint;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mCategoryBannerParent;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Banner<String, com.live.evo.catchup.player.b> mCategoryBanner;

    /* JADX INFO: renamed from: s2, reason: collision with root package name and from kotlin metadata */
    private InputMethodManager mIm;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private ProgramListView mCategoryListView;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.m mCategoryAdapter;

    /* JADX INFO: renamed from: u2, reason: collision with root package name and from kotlin metadata */
    private ImageView mCategoryBannerFrontPic;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private List<? extends i5.h> mListVodVideo;

    /* JADX INFO: renamed from: v2, reason: collision with root package name and from kotlin metadata */
    private TextView mCategoryBannerDesc;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean hasChangeCategory;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private TextView mTextCurrentPos;

    /* JADX INFO: renamed from: x2, reason: collision with root package name and from kotlin metadata */
    private boolean postMetricisFromCategory;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private TextView mTextViewTotalProg;

    /* JADX INFO: renamed from: y2, reason: collision with root package name and from kotlin metadata */
    private boolean isChannelHistoryLive;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private TextView mSessionId;

    /* JADX INFO: renamed from: z2, reason: collision with root package name and from kotlin metadata */
    private boolean isChannelUpdateByKids;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(x.class);

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    private boolean mIsCategoryOpen = true;

    /* JADX INFO: renamed from: M1, reason: from kotlin metadata */
    private boolean isFist = true;

    /* JADX INFO: renamed from: O1, reason: from kotlin metadata */
    private boolean isInitOpen = true;

    /* JADX INFO: renamed from: X1, reason: from kotlin metadata */
    private boolean isInitEpgData = true;

    /* JADX INFO: renamed from: b2, reason: collision with root package name and from kotlin metadata */
    private boolean mFocusable = true;

    /* JADX INFO: renamed from: e2, reason: collision with root package name and from kotlin metadata */
    private boolean mIsOnKeyLeft = true;

    /* JADX INFO: renamed from: r2, reason: collision with root package name and from kotlin metadata */
    private final int LENGTH = 4;

    /* JADX INFO: renamed from: t2, reason: collision with root package name and from kotlin metadata */
    private String curChannelId = "";

    /* JADX INFO: renamed from: w2, reason: collision with root package name and from kotlin metadata */
    private final List<com.live.evo.util.x> numberStrategies = new ArrayList();

    /* JADX INFO: renamed from: D2, reason: from kotlin metadata */
    private final Runnable mPipTipRunnable = new j();

    /* JADX INFO: renamed from: E2, reason: from kotlin metadata */
    private final Runnable locateIvLeft = new Runnable() { // from class: com.live.evo.fragment.e
        @Override // java.lang.Runnable
        public final void run() {
            x.u2();
        }
    };

    /* JADX INFO: renamed from: F2, reason: from kotlin metadata */
    private final AdapterView.OnItemSelectedListener mProgramItemSelectListener = new k();

    /* JADX INFO: renamed from: G2, reason: from kotlin metadata */
    private final Runnable mSetPreviewRunnable = new Runnable() { // from class: com.live.evo.fragment.o
        @Override // java.lang.Runnable
        public final void run() {
            x.w2(this.f6525a);
        }
    };

    /* JADX INFO: renamed from: H2, reason: from kotlin metadata */
    private final AdapterView.OnItemClickListener mProgramItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.live.evo.fragment.p
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            x.v2(this.f6528a, adapterView, view, i10, j10);
        }
    };

    /* JADX INFO: renamed from: I2, reason: from kotlin metadata */
    private final Handler mHandler = new i(Looper.getMainLooper());

    /* JADX INFO: renamed from: J2, reason: from kotlin metadata */
    private final com.live.evo.osd.v subscribeUpdateListener = new com.live.evo.osd.v() { // from class: com.live.evo.fragment.q
        @Override // com.live.evo.osd.v
        public final void onUpdate() {
            x.Z2(this.f6555a);
        }
    };

    /* JADX INFO: renamed from: K2, reason: from kotlin metadata */
    private int mNowPlayingIndex = -1;

    /* JADX INFO: renamed from: com.live.evo.fragment.x$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014RN\u0010\u001c\u001a.\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0015\u0018\u00010\u0019j\u0016\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0015\u0018\u0001`\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R*\u00107\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020E8\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010GR\u0014\u0010I\u001a\u00020E8\u0002X\u0082T¢\u0006\u0006\n\u0004\bI\u0010GR\u0014\u0010J\u001a\u00020E8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010G¨\u0006K"}, d2 = {"Lcom/live/evo/fragment/x$a;", "", "<init>", "()V", "Lcom/live/evo/osd/persenter/a;", "presenter", "Lcom/live/evo/fragment/y1;", "onEventListener", "Landroid/view/Window;", "window", "Lcom/live/evo/fragment/x;", "d", "(Lcom/live/evo/osd/persenter/a;Lcom/live/evo/fragment/y1;Landroid/view/Window;)Lcom/live/evo/fragment/x;", "", "", "mCategoryIdList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setMCategoryIdList", "(Ljava/util/List;)V", "", "mCategoryIdList_bk", "getMCategoryIdList_bk", "e", "Ljava/util/HashMap;", "Li5/h;", "Lkotlin/collections/HashMap;", "mMapPrograms", "Ljava/util/HashMap;", "c", "()Ljava/util/HashMap;", "h", "(Ljava/util/HashMap;)V", "", "Li5/i;", "mCategoryMap", "Ljava/util/Map;", "getMCategoryMap", "()Ljava/util/Map;", "f", "(Ljava/util/Map;)V", "mPresenter", "Lcom/live/evo/osd/persenter/a;", "getMPresenter", "()Lcom/live/evo/osd/persenter/a;", "j", "(Lcom/live/evo/osd/persenter/a;)V", "mOnEventListener", "Lcom/live/evo/fragment/y1;", "getMOnEventListener", "()Lcom/live/evo/fragment/y1;", "i", "(Lcom/live/evo/fragment/y1;)V", "Ljava/lang/ref/SoftReference;", "mInstance", "Ljava/lang/ref/SoftReference;", "b", "()Ljava/lang/ref/SoftReference;", "g", "(Ljava/lang/ref/SoftReference;)V", "mWindow", "Landroid/view/Window;", "getMWindow", "()Landroid/view/Window;", "k", "(Landroid/view/Window;)V", "CHANNEL_TAG", "Ljava/lang/String;", "", "GET_CHANNEL_EPG", "I", "UPDATE_CHANNEL_LIST", "BREATH_INTERVAL_TIME", "PREVIEW_SWITCH", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final List<String> a() {
            return x.M2;
        }

        public final SoftReference<x> b() {
            return x.S2;
        }

        public final HashMap<String, List<i5.h>> c() {
            return x.O2;
        }

        public final x d(com.live.evo.osd.persenter.a presenter, y1 onEventListener, Window window) {
            x xVar;
            j(presenter);
            i(onEventListener);
            k(window);
            com.live.evo.util.s0 s0Var = com.live.evo.util.s0.f7342a;
            h(s0Var.C());
            e(t.v.c.i.a.f18646a.u(Boolean.TRUE));
            f(s0Var.t());
            SoftReference<x> softReferenceB = b();
            if (softReferenceB != null) {
                xVar = softReferenceB.get();
            } else {
                xVar = null;
            }
            if (xVar == null) {
                x xVar2 = new x();
                g(new SoftReference<>(xVar2));
                return xVar2;
            }
            return xVar;
        }

        public final void e(List<String> list) {
            x.N2 = list;
        }

        public final void f(Map<String, ? extends i5.i> map) {
            x.P2 = map;
        }

        public final void g(SoftReference<x> softReference) {
            x.S2 = softReference;
        }

        public final void h(HashMap<String, List<i5.h>> map) {
            x.O2 = map;
        }

        public final void i(y1 y1Var) {
            x.R2 = y1Var;
        }

        public final void j(com.live.evo.osd.persenter.a aVar) {
            x.Q2 = aVar;
        }

        public final void k(Window window) {
            x.T2 = window;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/live/evo/fragment/x$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "Lr8/z;", "onAnimationStart", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
            x.this.mIsCategoryOpen = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
            q6.b bVar = x.this.logger;
            kotlin.jvm.internal.m.e(bVar, "access$getLogger$p(...)");
            c5.b.a(bVar, "categoryAnimClose start");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/live/evo/fragment/x$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "Lr8/z;", "onAnimationStart", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
            q6.b bVar = x.this.logger;
            kotlin.jvm.internal.m.e(bVar, "access$getLogger$p(...)");
            c5.b.a(bVar, "categoryAnimOpen");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/live/evo/fragment/x$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "Lr8/z;", "onAnimationStart", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
            LinearLayout linearLayout = x.this.mEpgParent;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/live/evo/fragment/x$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "Lr8/z;", "onAnimationStart", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements Animator.AnimatorListener {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
            LinearLayout linearLayout = x.this.mEpgParent;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.m.f(animation, "animation");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/live/evo/fragment/x$f", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "", "position", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "Lr8/z;", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements AdapterView.OnItemSelectedListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        @RequiresApi(api = 21)
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            if (x.this.isFist) {
                x.this.isFist = false;
                return;
            }
            if (view == null) {
                return;
            }
            View view2 = x.this.mCategoryParent;
            if (view2 == null || view2.getVisibility() != 0) {
                View view3 = x.this.mCategoryParent;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                if (!x.this.mIsCategoryOpen) {
                    ValueAnimator valueAnimator = x.this.categoryAnimOpen;
                    kotlin.jvm.internal.m.c(valueAnimator);
                    valueAnimator.start();
                    x.this.mIsCategoryOpen = true;
                }
                x.this.isInitOpen = false;
                ValueAnimator valueAnimator2 = x.this.epgAnimClose;
                kotlin.jvm.internal.m.c(valueAnimator2);
                valueAnimator2.start();
            }
            x.this.mCategorySelect = position;
            x.this.X2();
            x.this.V2();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/live/evo/fragment/x$g", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "", "position", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "Lr8/z;", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g implements AdapterView.OnItemSelectedListener {
        g() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            com.live.evo.osd.b bVar;
            List list = x.this.tempEpgList;
            if (list != null && position < list.size()) {
                i5.p pVar = (i5.p) list.get(position);
                ProgramListView programListView = x.this.mEpgListView;
                if (programListView != null && programListView.isFocused() && (bVar = x.this.mEpgAdapter) != null) {
                    bVar.b(position);
                }
                Long lF = pVar.f();
                kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
                String strM = com.live.evo.util.q1.m(lF.longValue(), com.live.evo.util.x1.j(R$string.HHmm));
                kotlin.jvm.internal.m.e(strM, "toDate(...)");
                Long lG = pVar.g();
                kotlin.jvm.internal.m.e(lG, "getStopTime(...)");
                String strM2 = com.live.evo.util.q1.m(lG.longValue(), com.live.evo.util.x1.j(R$string.HHmm));
                kotlin.jvm.internal.m.e(strM2, "toDate(...)");
                TextView textView = x.this.mEpgDuration;
                if (textView != null) {
                    kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
                    String str = String.format("%s - %s", Arrays.copyOf(new Object[]{strM, strM2}, 2));
                    kotlin.jvm.internal.m.e(str, "format(...)");
                    textView.setText(str);
                }
                TextView textView2 = x.this.mEpgProgram;
                if (textView2 != null) {
                    textView2.setText(String.format("%s", pVar.e()));
                }
                TextView textView3 = x.this.mEpgDescription;
                if (textView3 != null) {
                    textView3.setText(com.live.evo.util.x1.j(R$string.epg_description) + String.format("\t%s", pVar.a()));
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/live/evo/fragment/x$h", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "parent", "Landroid/view/View;", "view", "", "position", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "Lr8/z;", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements AdapterView.OnItemSelectedListener {
        h() {
        }

        /* JADX WARN: Code duplicated, block: B:47:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:49:0x00ce  */
        /* JADX WARN: Code duplicated, block: B:50:0x00d3  */
        /* JADX WARN: Code duplicated, block: B:52:0x00d6  */
        /* JADX WARN: Code duplicated, block: B:54:0x00de  */
        /* JADX WARN: Code duplicated, block: B:57:0x00e9  */
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            com.live.evo.osd.b bVar;
            int count;
            ProgramListView programListView;
            com.live.evo.osd.b bVar2;
            if (x.this.isInitEpgData) {
                x.this.isInitEpgData = false;
                return;
            }
            if (com.live.evo.util.s0.f7342a.R()) {
                TextView textView = x.this.mTvNotData;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                TextView textView2 = x.this.mTvNotData;
                if (textView2 != null) {
                    textView2.setText(com.live.evo.util.x1.j(R$string.catchup_init_remind));
                    return;
                }
                return;
            }
            TextView textView3 = x.this.mTvNotData;
            if (textView3 != null) {
                textView3.setText(com.live.evo.util.x1.j(R$string.not_data));
            }
            if (view == null) {
                return;
            }
            n5.b bVar3 = x.this.epgDateAdapter;
            if (bVar3 != null) {
                ProgramListView programListView2 = x.this.mLvEpgDate;
                bVar3.d(position, programListView2 != null && programListView2.isFocused());
            }
            int iL2 = x.this.L2(position);
            if (x.this.isKeyCodeUp) {
                List list = x.this.tempEpgList;
                kotlin.jvm.internal.m.c(list);
                iL2 = list.size() - 1;
                if (iL2 < 0) {
                    ProgramListView programListView3 = x.this.mLvEpgDate;
                    if (programListView3 != null) {
                        programListView3.requestFocus();
                    }
                    com.live.evo.osd.b bVar4 = x.this.mEpgAdapter;
                    if (bVar4 != null) {
                        bVar4.notifyDataSetChanged();
                    }
                } else {
                    ProgramListView programListView4 = x.this.mEpgListView;
                    if (programListView4 != null) {
                        programListView4.setSelection(iL2);
                    }
                }
                x.this.isKeyCodeUp = false;
            } else {
                if (x.this.tempEpgList != null) {
                    List list2 = x.this.tempEpgList;
                    kotlin.jvm.internal.m.c(list2);
                    if (list2.isEmpty()) {
                        bVar = x.this.mEpgAdapter;
                        if (bVar != null) {
                            count = bVar.getCount();
                        } else {
                            count = 0;
                        }
                        if (count <= 0) {
                            programListView = x.this.mLvEpgDate;
                            if (programListView != null) {
                                programListView.requestFocus();
                            }
                            bVar2 = x.this.mEpgAdapter;
                            if (bVar2 != null) {
                                bVar2.notifyDataSetChanged();
                            }
                        }
                    }
                } else {
                    bVar = x.this.mEpgAdapter;
                    if (bVar != null) {
                        count = bVar.getCount();
                    } else {
                        count = 0;
                    }
                    if (count <= 0) {
                        programListView = x.this.mLvEpgDate;
                        if (programListView != null) {
                            programListView.requestFocus();
                        }
                        bVar2 = x.this.mEpgAdapter;
                        if (bVar2 != null) {
                            bVar2.notifyDataSetChanged();
                        }
                    }
                }
                com.live.evo.osd.b bVar5 = x.this.mEpgAdapter;
                if ((bVar5 != null ? bVar5.getCount() : 0) <= 0) {
                    iL2 = 0;
                } else {
                    n5.b bVar6 = x.this.epgDateAdapter;
                    if (position - (bVar6 != null ? bVar6.c() : 0) != 0 || x.this.isKeyCodeDown) {
                        ProgramListView programListView5 = x.this.mEpgListView;
                        if (programListView5 != null) {
                            programListView5.setSelection(0);
                        }
                        x.this.isKeyCodeDown = false;
                        iL2 = 0;
                    } else {
                        if (iL2 < 0) {
                            iL2 = 0;
                        }
                        ProgramListView programListView6 = x.this.mEpgListView;
                        if (programListView6 != null) {
                            programListView6.setSelection(iL2);
                        }
                    }
                }
            }
            List list3 = x.this.tempEpgList;
            int size = list3 != null ? list3.size() : 0;
            if (size <= 0 || iL2 >= size || iL2 < 0) {
                TextView textView4 = x.this.mEpgDuration;
                if (textView4 != null) {
                    textView4.setText("");
                }
                TextView textView5 = x.this.mEpgProgram;
                if (textView5 != null) {
                    textView5.setText("");
                }
                TextView textView6 = x.this.mEpgDescription;
                kotlin.jvm.internal.m.c(textView6);
                textView6.setText("");
                return;
            }
            List list4 = x.this.tempEpgList;
            i5.p pVar = list4 != null ? (i5.p) list4.get(iL2) : null;
            if (pVar != null) {
                Long lF = pVar.f();
                kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
                String strM = com.live.evo.util.q1.m(lF.longValue(), com.live.evo.util.x1.j(R$string.HHmm));
                kotlin.jvm.internal.m.e(strM, "toDate(...)");
                Long lG = pVar.g();
                kotlin.jvm.internal.m.e(lG, "getStopTime(...)");
                String strM2 = com.live.evo.util.q1.m(lG.longValue(), com.live.evo.util.x1.j(R$string.HHmm));
                kotlin.jvm.internal.m.e(strM2, "toDate(...)");
                TextView textView7 = x.this.mEpgDuration;
                if (textView7 != null) {
                    kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
                    String str = String.format("%s - %s", Arrays.copyOf(new Object[]{strM, strM2}, 2));
                    kotlin.jvm.internal.m.e(str, "format(...)");
                    textView7.setText(str);
                }
                TextView textView8 = x.this.mEpgProgram;
                if (textView8 != null) {
                    textView8.setText(String.format("%s", pVar.e()));
                }
                TextView textView9 = x.this.mEpgDescription;
                if (textView9 != null) {
                    textView9.setText(com.live.evo.util.x1.j(R$string.epg_description) + String.format("\t%s", pVar.a()));
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/fragment/x$i", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i extends Handler {
        i(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            int i10 = msg.what;
            if (i10 != 1) {
                if (i10 == 8194) {
                    x.this.c3();
                    return;
                } else {
                    if (i10 != 8195) {
                        return;
                    }
                    x.this.b3();
                    return;
                }
            }
            Companion companion = x.INSTANCE;
            List<String> listA = companion.a();
            kotlin.jvm.internal.m.c(listA);
            if (listA.size() > x.this.mCategorySelect) {
                HashMap<String, List<i5.h>> mapC = companion.c();
                kotlin.jvm.internal.m.c(mapC);
                List<String> listA2 = companion.a();
                kotlin.jvm.internal.m.c(listA2);
                List<i5.h> list = mapC.get(listA2.get(x.this.mCategorySelect));
                if (list == null || list.size() <= x.this.mProgramSelect) {
                    return;
                }
                i5.h hVar = list.get(x.this.mProgramSelect);
                kotlin.jvm.internal.m.c(hVar);
                if (hVar.p()) {
                    return;
                }
                x.this.F2(hVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/fragment/x$j", "Ljava/lang/Runnable;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x.this.mTextPipTip != null) {
                TextView textView = x.this.mTextPipTip;
                kotlin.jvm.internal.m.c(textView);
                if (!TextUtils.equals(textView.getText().toString(), x.this.mTipSwitch)) {
                    TextView textView2 = x.this.mTextPipTip;
                    kotlin.jvm.internal.m.c(textView2);
                    textView2.setText(x.this.mTipSwitch);
                } else if (com.live.evo.l.n().G()) {
                    TextView textView3 = x.this.mTextPipTip;
                    kotlin.jvm.internal.m.c(textView3);
                    textView3.setText(x.this.mTipClosePip);
                } else {
                    TextView textView4 = x.this.mTextPipTip;
                    kotlin.jvm.internal.m.c(textView4);
                    textView4.setText(x.this.mTipOpenPip);
                }
                TextView textView5 = x.this.mTextPipTip;
                kotlin.jvm.internal.m.c(textView5);
                textView5.setSelected(true);
            }
            x.this.mHandler.postDelayed(this, 10000L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/live/evo/fragment/x$k", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", "arg0", "Landroid/view/View;", "view", "", "position", "", "arg3", "Lr8/z;", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "onNothingSelected", "(Landroid/widget/AdapterView;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k implements AdapterView.OnItemSelectedListener {
        /* JADX INFO: Access modifiers changed from: private */
        public static final r8.z b(x xVar, int i10) {
            if (i10 <= 0) {
                i10 = 7;
            }
            n5.b bVar = xVar.epgDateAdapter;
            if (bVar != null) {
                bVar.e(i10 + 7);
            }
            return r8.z.f17874a;
        }

        k() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> arg0, View view, int position, long arg3) {
            ProgramListView programListView;
            i5.h hVar;
            if (view == null) {
                return;
            }
            List list = x.this.mListVodVideo;
            kotlin.jvm.internal.m.c(list);
            if (position >= list.size()) {
                return;
            }
            int y10 = (int) view.getY();
            Map map = x.this.mHistoryMap;
            kotlin.jvm.internal.m.c(map);
            List<String> listA = x.INSTANCE.a();
            kotlin.jvm.internal.m.c(listA);
            map.put(listA.get(x.this.mCategorySelect), position + "," + y10);
            TextView textView = x.this.mTextCurrentPos;
            kotlin.jvm.internal.m.c(textView);
            int i10 = position + 1;
            textView.setText(String.valueOf(i10));
            TextView textView2 = x.this.mTextPosition;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setText(String.valueOf(i10));
            TextView textView3 = x.this.mTextProgramTotal;
            kotlin.jvm.internal.m.c(textView3);
            List list2 = x.this.mListVodVideo;
            kotlin.jvm.internal.m.c(list2);
            textView3.setText("/" + list2.size());
            q6.b bVar = x.this.logger;
            kotlin.jvm.internal.m.e(bVar, "access$getLogger$p(...)");
            c5.b.a(bVar, "onItemSelected: itemPosition==" + position);
            x.this.mProgramSelect = position;
            if (!x.this.mIsCategoryOpen) {
                x.this.T1();
            }
            List list3 = x.this.mListVodVideo;
            String strF = (list3 == null || (hVar = (i5.h) list3.get(position)) == null) ? null : hVar.f();
            if (!TextUtils.isEmpty(strF) && !x.this.mIsCategoryOpen) {
                com.live.evo.util.s0 s0Var = com.live.evo.util.s0.f7342a;
                final x xVar = x.this;
                s0Var.B(strF, new c9.l() { // from class: com.live.evo.fragment.y
                    @Override // c9.l
                    public final Object invoke(Object obj) {
                        return x.k.b(xVar, ((Integer) obj).intValue());
                    }
                });
            }
            if (x.this.mProgramListView == null || (programListView = x.this.mProgramListView) == null || !programListView.isFocused()) {
                return;
            }
            n5.o oVar = x.this.mProgramAdapter;
            if ((oVar != null ? oVar.getCount() : 0) > position) {
                x.this.P2();
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/live/evo/fragment/x$l", "Lcom/live/evo/dialog/x;", "Lr8/z;", "b", "()V", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class l implements com.live.evo.dialog.x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.c0 f6917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ x f6918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i5.p f6919c;

        l(i5.c0 c0Var, x xVar, i5.p pVar) {
            this.f6917a = c0Var;
            this.f6918b = xVar;
            this.f6919c = pVar;
        }

        @Override // com.live.evo.dialog.x
        public void b() {
            com.live.evo.util.s0.Y(com.live.evo.util.s0.f7342a, this.f6917a, null, 2, null);
            this.f6918b.Q2(this.f6919c);
        }

        @Override // com.live.evo.dialog.x
        public void a() {
        }
    }

    private final void a2() {
        this.browseCount = 1;
        this.clickCount = 0;
        this.browseDuration = com.live.evo.util.u1.b().a();
    }

    private final void j2() {
        List<i5.d> listA;
        Banner<String, com.live.evo.catchup.player.b> banner;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        this.mShowBanner = false;
        try {
            i5.f fVarF = v4.g.e().f(String.valueOf(2));
            if (fVarF != null && (listA = fVarF.a()) != null) {
                ArrayList arrayList = new ArrayList();
                int iB = com.live.evo.util.n.b();
                int dimension = (int) getResources().getDimension(R$dimen.banner_bg_width);
                int size = listA.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (!TextUtils.isEmpty(fVarF.a().get(i10).d())) {
                        String strD = fVarF.a().get(i10).d();
                        kotlin.jvm.internal.m.e(strD, "getImageUrl(...)");
                        arrayList.add(strD);
                    }
                }
                if (fVarF.a().get(0) != null) {
                    float f10 = fVarF.a().get(0).f();
                    float f11 = dimension;
                    float f12 = f10 / f11;
                    float fC = fVarF.a().get(0).c();
                    float f13 = iB;
                    if (f12 >= fC / f13) {
                        iB = (int) ((f11 / f10) * fC);
                    } else {
                        dimension = (int) ((f13 / fC) * f10);
                    }
                    fVarF.a().get(0).b();
                }
                boolean z10 = arrayList.size() > 0;
                this.mShowBanner = z10;
                if (z10) {
                    RelativeLayout relativeLayout = this.mLayoutBanner;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                    }
                    Banner<String, com.live.evo.catchup.player.b> banner2 = this.mBanner;
                    if (banner2 != null && (layoutParams2 = banner2.getLayoutParams()) != null) {
                        layoutParams2.height = iB;
                    }
                    Banner<String, com.live.evo.catchup.player.b> banner3 = this.mBanner;
                    if (banner3 != null && (layoutParams = banner3.getLayoutParams()) != null) {
                        layoutParams.width = dimension;
                    }
                    Banner<String, com.live.evo.catchup.player.b> banner4 = this.mBanner;
                    if (banner4 != null) {
                        banner4.setDatas(arrayList);
                    }
                    Banner<String, com.live.evo.catchup.player.b> banner5 = this.mBanner;
                    if (banner5 != null) {
                        banner5.setAdapter(new com.live.evo.catchup.player.b(getContext(), arrayList));
                    }
                    Banner<String, com.live.evo.catchup.player.b> banner6 = this.mBanner;
                    if (banner6 != null) {
                        banner6.start();
                    }
                    if (v4.g.e().c() && (banner = this.mBanner) != null) {
                        banner.start();
                    }
                }
            }
        } catch (Exception e10) {
            this.logger.error("get ad failure", e10);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    public final void C2() {
        ProgramListView programListView;
        List<? extends i5.h> list;
        this.postMetricisFromCategory = false;
        if (this.mProgramListView == null || (list = this.mListVodVideo) == null) {
            programListView = this.mCategoryListView;
            if (programListView != null && programListView != null) {
                programListView.requestFocus();
            }
        } else {
            kotlin.jvm.internal.m.c(list);
            if (list.size() > 0) {
                ProgramListView programListView2 = this.mProgramListView;
                if (programListView2 != null) {
                    programListView2.requestFocus();
                }
            } else {
                programListView = this.mCategoryListView;
                if (programListView != null) {
                    programListView.requestFocus();
                }
            }
        }
        K1(this.mCategorySelect);
        if (N1()) {
            ImageView imageView = this.mIvRight;
            kotlin.jvm.internal.m.c(imageView);
            imageView.setVisibility(8);
            RelativeLayout relativeLayout = this.mChannelParent;
            kotlin.jvm.internal.m.c(relativeLayout);
            relativeLayout.setVisibility(8);
            RelativeLayout relativeLayout2 = this.mAdultKeyParent;
            kotlin.jvm.internal.m.c(relativeLayout2);
            relativeLayout2.setVisibility(0);
            x2();
            ProgramListView programListView3 = this.mCategoryListView;
            if (programListView3 != null && programListView3 != null) {
                programListView3.requestFocus();
            }
        }
        L1();
        P2();
        this.isChannelHistoryLive = false;
    }

    @Override // com.live.evo.osd.persenter.b
    /* JADX INFO: renamed from: isShowing */
    public boolean getIsShow() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:267:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:380:0x0557  */
    /* JADX WARN: Code duplicated, block: B:382:0x055f  */
    /* JADX WARN: Code duplicated, block: B:384:0x0563  */
    /* JADX WARN: Code duplicated, block: B:385:0x0568  */
    /* JADX WARN: Code duplicated, block: B:387:0x056b  */
    /* JADX WARN: Code duplicated, block: B:390:0x0577  */
    /* JADX WARN: Code duplicated, block: B:392:0x0597  */
    /* JADX WARN: Code duplicated, block: B:397:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:399:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:400:0x05de  */
    /* JADX WARN: Code duplicated, block: B:402:0x05ef  */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x0704, code lost:
    
        if (r13.getAction() == 1) goto L485;
     */
    @Override // android.view.View.OnKeyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKey(View v10, int keyCode, KeyEvent event) {
        int iB;
        ProgramListView programListView;
        ProgramListView programListView2;
        int selectedItemPosition;
        List<i5.p> list;
        long jB;
        i5.p pVar;
        long jLongValue;
        Long lG;
        boolean z10;
        View view;
        ViewGroup.LayoutParams layoutParams;
        String[] strArr;
        int i10;
        int i11;
        List listL;
        i5.h hVar;
        kotlin.jvm.internal.m.f(v10, "v");
        kotlin.jvm.internal.m.f(event, "event");
        if (this.keyboardView != null && event.getAction() == 1 && ((keyCode == 23 || keyCode == 66) && v10.getId() == 2131427478)) {
            return true;
        }
        if (event.getAction() != 0) {
            return false;
        }
        int id2 = v10.getId();
        if ((21 == keyCode || 22 == keyCode) && com.live.evo.util.x1.m(100L)) {
            return true;
        }
        if (com.live.evo.k.b().l() && keyCode == 82) {
            if (com.live.evo.l.n().G()) {
                HashMap<String, List<i5.h>> map = O2;
                kotlin.jvm.internal.m.c(map);
                List<String> list2 = M2;
                kotlin.jvm.internal.m.c(list2);
                List<i5.h> list3 = map.get(list2.get(this.mCategorySelect));
                if (list3 != null) {
                    int size = list3.size();
                    int i12 = this.mProgramSelect;
                    if (size > i12 && (hVar = list3.get(i12)) != null && !hVar.p() && !hVar.q()) {
                        com.live.evo.osd.persenter.a aVar = Q2;
                        kotlin.jvm.internal.m.c(aVar);
                        aVar.a(1, hVar.i());
                    }
                }
            } else {
                com.live.evo.util.r1.d(getActivity(), com.live.evo.util.x1.j(R$string.pip_not_open), 1);
            }
            return true;
        }
        if (id2 != 2131429023) {
            switch (id2) {
                case R$id.adultkeyl_btn_go /* 2131427477 */:
                    switch (keyCode) {
                        case 21:
                            ProgramListView programListView3 = this.mCategoryListView;
                            if (programListView3 != null) {
                                programListView3.requestFocus();
                                break;
                            }
                        case 20:
                        case 22:
                            return true;
                    }
                    break;
                case R$id.adultkeyl_et_pwd /* 2131427478 */:
                    if (keyCode != 19) {
                        if (keyCode != 66) {
                            switch (keyCode) {
                                case 21:
                                    ProgramListView programListView4 = this.mCategoryListView;
                                    if (programListView4 != null) {
                                        programListView4.requestFocus();
                                    }
                                    return true;
                            }
                        }
                        ziyi.kit.keyboard.b bVar = this.keyboardView;
                        if (bVar != null) {
                            kotlin.jvm.internal.m.c(bVar);
                            if (bVar.getVisibility() != 0) {
                                ziyi.kit.keyboard.b bVar2 = this.keyboardView;
                                kotlin.jvm.internal.m.c(bVar2);
                                bVar2.m0();
                                return true;
                            }
                        }
                        if (this.keyboardView != null) {
                        }
                        break;
                    }
                    return true;
                default:
                    switch (id2) {
                        case R$id.programviewl_lv_epg_date /* 2131429004 */:
                            if (keyCode == 21) {
                                ValueAnimator valueAnimator = this.epgAnimOpen;
                                kotlin.jvm.internal.m.c(valueAnimator);
                                if (valueAnimator.isRunning()) {
                                    ValueAnimator valueAnimator2 = this.epgAnimOpen;
                                    kotlin.jvm.internal.m.c(valueAnimator2);
                                    valueAnimator2.cancel();
                                }
                                n5.b bVar3 = this.epgDateAdapter;
                                if (bVar3 != null) {
                                    bVar3.d(bVar3 != null ? bVar3.c() : 0, false);
                                    r8.z zVar = r8.z.f17874a;
                                }
                                n5.b bVar4 = this.epgDateAdapter;
                                int iL2 = L2(bVar4 != null ? bVar4.c() : 0);
                                if (iL2 >= 0 && (programListView = this.mEpgListView) != null) {
                                    programListView.setSelection(iL2);
                                    r8.z zVar2 = r8.z.f17874a;
                                }
                                M2(this.mProgramListView);
                            } else if (keyCode == 22) {
                                com.live.evo.osd.b bVar5 = this.mEpgAdapter;
                                if ((bVar5 != null ? bVar5.getCount() : 0) <= 0) {
                                    i0(this.mLvEpgDate);
                                    return true;
                                }
                                n5.b bVar6 = this.epgDateAdapter;
                                Integer numValueOf = bVar6 != null ? Integer.valueOf(bVar6.b()) : null;
                                n5.b bVar7 = this.epgDateAdapter;
                                if (numValueOf != (bVar7 != null ? Integer.valueOf(bVar7.c()) : null)) {
                                    M2(this.mEpgListView);
                                    com.live.evo.osd.b bVar8 = this.mEpgAdapter;
                                    if (bVar8 != null) {
                                        bVar8.b(-1);
                                        r8.z zVar3 = r8.z.f17874a;
                                    }
                                    com.live.evo.osd.b bVar9 = this.mEpgAdapter;
                                    if (bVar9 != null) {
                                        bVar9.b(0);
                                        r8.z zVar4 = r8.z.f17874a;
                                    }
                                    ProgramListView programListView5 = this.mEpgListView;
                                    if (programListView5 != null) {
                                        programListView5.setSelection(0);
                                        r8.z zVar5 = r8.z.f17874a;
                                    }
                                } else {
                                    M2(this.mEpgListView);
                                    int i13 = this.mNowPlayingIndex;
                                    if (i13 <= 0) {
                                        com.live.evo.osd.b bVar10 = this.mEpgAdapter;
                                        if (bVar10 != null) {
                                            bVar10.b(-1);
                                            r8.z zVar6 = r8.z.f17874a;
                                        }
                                        com.live.evo.osd.b bVar11 = this.mEpgAdapter;
                                        if (bVar11 != null) {
                                            bVar11.b(0);
                                            r8.z zVar7 = r8.z.f17874a;
                                        }
                                        ProgramListView programListView6 = this.mEpgListView;
                                        if (programListView6 != null) {
                                            programListView6.setSelection(0);
                                            r8.z zVar8 = r8.z.f17874a;
                                        }
                                    } else {
                                        com.live.evo.osd.b bVar12 = this.mEpgAdapter;
                                        if (bVar12 != null) {
                                            bVar12.b(i13);
                                            r8.z zVar9 = r8.z.f17874a;
                                        }
                                        ProgramListView programListView7 = this.mEpgListView;
                                        if (programListView7 != null) {
                                            programListView7.setSelection(this.mNowPlayingIndex);
                                            r8.z zVar10 = r8.z.f17874a;
                                        }
                                    }
                                }
                            }
                            break;
                        case R$id.programviewl_lv_epg_listview /* 2131429005 */:
                            if (keyCode != 66) {
                                switch (keyCode) {
                                    case 19:
                                        ProgramListView programListView8 = this.mEpgListView;
                                        if ((programListView8 != null ? programListView8.getSelectedItemPosition() : 0) == 0) {
                                            n5.b bVar13 = this.epgDateAdapter;
                                            if ((bVar13 != null ? bVar13.b() : 0) > 0) {
                                                n5.b bVar14 = this.epgDateAdapter;
                                                int iB2 = (bVar14 != null ? bVar14.b() : 0) - 1;
                                                ProgramListView programListView9 = this.mLvEpgDate;
                                                if (programListView9 != null) {
                                                    programListView9.setSelection(iB2);
                                                    r8.z zVar11 = r8.z.f17874a;
                                                }
                                                n5.b bVar15 = this.epgDateAdapter;
                                                if (bVar15 != null) {
                                                    bVar15.d(iB2, false);
                                                    r8.z zVar12 = r8.z.f17874a;
                                                }
                                                this.isKeyCodeUp = true;
                                            }
                                        }
                                        this.isKeyCodeDown = false;
                                        break;
                                    case 20:
                                        ProgramListView programListView10 = this.mEpgListView;
                                        int selectedItemPosition2 = programListView10 != null ? programListView10.getSelectedItemPosition() : 0;
                                        List<i5.p> list4 = this.tempEpgList;
                                        kotlin.jvm.internal.m.c(list4);
                                        if (selectedItemPosition2 == list4.size() - 1) {
                                            n5.b bVar16 = this.epgDateAdapter;
                                            int iB3 = bVar16 != null ? bVar16.b() : 0;
                                            n5.b bVar17 = this.epgDateAdapter;
                                            if (iB3 >= (bVar17 != null ? bVar17.a() : 0)) {
                                                return true;
                                            }
                                            n5.b bVar18 = this.epgDateAdapter;
                                            int iB4 = (bVar18 != null ? bVar18.b() : 0) + 1;
                                            if (U1(iB4) <= 0) {
                                                return true;
                                            }
                                            this.isKeyCodeDown = true;
                                            ProgramListView programListView11 = this.mLvEpgDate;
                                            if (programListView11 != null) {
                                                programListView11.setSelection(iB4);
                                                r8.z zVar13 = r8.z.f17874a;
                                            }
                                            n5.b bVar19 = this.epgDateAdapter;
                                            if (bVar19 != null) {
                                                bVar19.d(iB4, false);
                                                r8.z zVar14 = r8.z.f17874a;
                                            }
                                        }
                                        this.isKeyCodeUp = false;
                                        break;
                                    case 21:
                                        n5.b bVar20 = this.epgDateAdapter;
                                        if (bVar20 != null) {
                                            bVar20.d(bVar20 != null ? bVar20.b() : 0, true);
                                            r8.z zVar15 = r8.z.f17874a;
                                        }
                                        ProgramListView programListView12 = this.mLvEpgDate;
                                        if (programListView12 != null) {
                                            n5.b bVar21 = this.epgDateAdapter;
                                            programListView12.setSelection(bVar21 != null ? bVar21.b() : 0);
                                            r8.z zVar16 = r8.z.f17874a;
                                        }
                                        M2(this.mLvEpgDate);
                                        break;
                                    case 22:
                                        i0(this.mEpgListParent);
                                        return true;
                                    case 23:
                                        if (!com.live.evo.util.x1.m(500L)) {
                                            programListView2 = this.mEpgListView;
                                            if (programListView2 != null) {
                                                selectedItemPosition = programListView2.getSelectedItemPosition();
                                            } else {
                                                selectedItemPosition = 0;
                                            }
                                            if (selectedItemPosition < 0) {
                                                selectedItemPosition = 0;
                                            }
                                            list = this.tempEpgList;
                                            kotlin.jvm.internal.m.c(list);
                                            if (selectedItemPosition < list.size()) {
                                                jB = com.live.evo.util.q1.b();
                                                List<i5.p> list5 = this.tempEpgList;
                                                kotlin.jvm.internal.m.c(list5);
                                                pVar = list5.get(selectedItemPosition);
                                                Long lF = pVar.f();
                                                kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
                                                jLongValue = lF.longValue();
                                                if (jLongValue > jB) {
                                                    TimeUnit.DAYS.toMillis(1L);
                                                    if (com.live.evo.k.b().n() && !M1()) {
                                                        g3(pVar, !com.live.evo.util.s0.f7342a.O(pVar, this.curChannelId) ? 1 : 0);
                                                    }
                                                } else if (com.live.evo.util.s0.f7342a.M(pVar.b(), this.curChannelId, Long.valueOf(jLongValue))) {
                                                    lG = pVar.g();
                                                    kotlin.jvm.internal.m.e(lG, "getStopTime(...)");
                                                    if (lG.longValue() < jB) {
                                                        com.live.evo.util.r1.c(getContext(), com.live.evo.util.x1.j(R$string.not_supported_playback));
                                                    }
                                                } else {
                                                    com.live.evo.osd.persenter.a aVar2 = Q2;
                                                    kotlin.jvm.internal.m.c(aVar2);
                                                    aVar2.b(MessageOriginChannel.MESSAGE_ORIGIN_TYPE, pVar, this.curChannelId);
                                                    this.mIsCatchUp = true;
                                                }
                                            }
                                        }
                                        break;
                                }
                            } else {
                                if (!com.live.evo.util.x1.m(500L)) {
                                    programListView2 = this.mEpgListView;
                                    if (programListView2 != null) {
                                        selectedItemPosition = programListView2.getSelectedItemPosition();
                                    } else {
                                        selectedItemPosition = 0;
                                    }
                                    if (selectedItemPosition < 0) {
                                        selectedItemPosition = 0;
                                    }
                                    list = this.tempEpgList;
                                    kotlin.jvm.internal.m.c(list);
                                    if (selectedItemPosition < list.size()) {
                                        jB = com.live.evo.util.q1.b();
                                        List<i5.p> list6 = this.tempEpgList;
                                        kotlin.jvm.internal.m.c(list6);
                                        pVar = list6.get(selectedItemPosition);
                                        Long lF2 = pVar.f();
                                        kotlin.jvm.internal.m.e(lF2, "getStartTime(...)");
                                        jLongValue = lF2.longValue();
                                        if (jLongValue > jB) {
                                            TimeUnit.DAYS.toMillis(1L);
                                            if (com.live.evo.k.b().n()) {
                                                g3(pVar, !com.live.evo.util.s0.f7342a.O(pVar, this.curChannelId) ? 1 : 0);
                                            }
                                        } else if (com.live.evo.util.s0.f7342a.M(pVar.b(), this.curChannelId, Long.valueOf(jLongValue))) {
                                            lG = pVar.g();
                                            kotlin.jvm.internal.m.e(lG, "getStopTime(...)");
                                            if (lG.longValue() < jB) {
                                                com.live.evo.util.r1.c(getContext(), com.live.evo.util.x1.j(R$string.not_supported_playback));
                                            }
                                        } else {
                                            com.live.evo.osd.persenter.a aVar3 = Q2;
                                            kotlin.jvm.internal.m.c(aVar3);
                                            aVar3.b(MessageOriginChannel.MESSAGE_ORIGIN_TYPE, pVar, this.curChannelId);
                                            this.mIsCatchUp = true;
                                        }
                                    }
                                }
                                break;
                            }
                            break;
                        case R$id.programviewl_lv_main_program_listview /* 2131429006 */:
                            switch (keyCode) {
                                case 19:
                                    List<? extends i5.h> list7 = this.mListVodVideo;
                                    kotlin.jvm.internal.m.c(list7);
                                    int size2 = list7.size();
                                    ProgramListView programListView13 = this.mProgramListView;
                                    int selectedItemPosition3 = programListView13 != null ? programListView13.getSelectedItemPosition() : 0;
                                    this.hasChangeCategory = false;
                                    this.isChangeChannel = false;
                                    if (selectedItemPosition3 == 0 && size2 > 0) {
                                        ProgramListView programListView14 = this.mProgramListView;
                                        if (programListView14 != null) {
                                            programListView14.setSelection(size2 - 1);
                                            r8.z zVar17 = r8.z.f17874a;
                                        }
                                        return true;
                                    }
                                    break;
                                case 20:
                                    List<? extends i5.h> list8 = this.mListVodVideo;
                                    kotlin.jvm.internal.m.c(list8);
                                    int size3 = list8.size();
                                    this.hasChangeCategory = false;
                                    this.isChangeChannel = false;
                                    ProgramListView programListView15 = this.mProgramListView;
                                    if ((programListView15 != null ? programListView15.getSelectedItemPosition() : 0) == size3 - 1) {
                                        ProgramListView programListView16 = this.mProgramListView;
                                        if (programListView16 != null) {
                                            programListView16.setSelection(0);
                                            r8.z zVar18 = r8.z.f17874a;
                                        }
                                        return true;
                                    }
                                    break;
                                case 21:
                                    this.postMetricisFromCategory = false;
                                    if (com.live.evo.a.f5181a) {
                                        View view2 = this.mCategoryParent;
                                        if (view2 != null) {
                                            view2.setVisibility(0);
                                            r8.z zVar19 = r8.z.f17874a;
                                        }
                                        ProgramListView programListView17 = this.mCategoryListView;
                                        if ((programListView17 != null ? Integer.valueOf(programListView17.getVisibility()) : null) == 0) {
                                            ProgramListView programListView18 = this.mCategoryListView;
                                            if (programListView18 != null) {
                                                programListView18.requestFocus();
                                            }
                                            M2(this.mCategoryListView);
                                            ProgramListView programListView19 = this.mCategoryListView;
                                            if (programListView19 != null) {
                                                programListView19.setSelection(this.mCategorySelect);
                                                r8.z zVar20 = r8.z.f17874a;
                                            }
                                            q6.b logger = this.logger;
                                            kotlin.jvm.internal.m.e(logger, "logger");
                                            c5.b.a(logger, "onkey: mCategorySelect = " + this.mCategorySelect);
                                        }
                                        if (!this.isInitOpen) {
                                            ValueAnimator valueAnimator3 = this.categoryAnimClose;
                                            kotlin.jvm.internal.m.c(valueAnimator3);
                                            if (valueAnimator3.isRunning()) {
                                                ValueAnimator valueAnimator4 = this.categoryAnimClose;
                                                kotlin.jvm.internal.m.c(valueAnimator4);
                                                valueAnimator4.cancel();
                                            }
                                            if (!this.mIsCategoryOpen) {
                                                ValueAnimator valueAnimator5 = this.categoryAnimOpen;
                                                kotlin.jvm.internal.m.c(valueAnimator5);
                                                valueAnimator5.start();
                                                this.mIsCategoryOpen = true;
                                            }
                                        }
                                        this.isInitOpen = false;
                                        LinearLayout linearLayout = this.mEpgParent;
                                        if (linearLayout != null && linearLayout.getVisibility() == 0) {
                                            LinearLayout linearLayout2 = this.mEpgParent;
                                            if (((linearLayout2 == null || (layoutParams = linearLayout2.getLayoutParams()) == null) ? 0 : layoutParams.width) > 0) {
                                                z10 = true;
                                            } else {
                                                z10 = false;
                                            }
                                        } else {
                                            z10 = false;
                                        }
                                        if (U2() && z10) {
                                            ValueAnimator valueAnimator6 = this.epgAnimClose;
                                            kotlin.jvm.internal.m.c(valueAnimator6);
                                            valueAnimator6.start();
                                            if (!this.mIsCategoryOpen) {
                                                View view3 = this.mCategoryParent;
                                                if (!(view3 != null && view3.getVisibility() == 0) && (view = this.mCategoryParent) != null) {
                                                    view.setVisibility(0);
                                                    r8.z zVar21 = r8.z.f17874a;
                                                }
                                                ValueAnimator valueAnimator7 = this.categoryAnimOpen;
                                                kotlin.jvm.internal.m.c(valueAnimator7);
                                                valueAnimator7.start();
                                                this.mIsCategoryOpen = true;
                                            }
                                        }
                                        if (!P1()) {
                                            LinearLayout linearLayout3 = this.mIvRightLayout;
                                            kotlin.jvm.internal.m.c(linearLayout3);
                                            linearLayout3.setVisibility(0);
                                        } else {
                                            LinearLayout linearLayout4 = this.mIvRightLayout;
                                            kotlin.jvm.internal.m.c(linearLayout4);
                                            linearLayout4.setVisibility(8);
                                        }
                                    }
                                    break;
                                case 22:
                                    if (!U2()) {
                                        if (com.live.evo.l.n().E()) {
                                            return true;
                                        }
                                        i0(this.mChannelParent);
                                        return false;
                                    }
                                    if (M1()) {
                                        return true;
                                    }
                                    this.postMetricisFromCategory = false;
                                    LinearLayout linearLayout5 = this.mIvRightLayout;
                                    kotlin.jvm.internal.m.c(linearLayout5);
                                    linearLayout5.setVisibility(8);
                                    ValueAnimator valueAnimator8 = this.epgAnimClose;
                                    kotlin.jvm.internal.m.c(valueAnimator8);
                                    if (valueAnimator8.isRunning()) {
                                        ValueAnimator valueAnimator9 = this.epgAnimClose;
                                        kotlin.jvm.internal.m.c(valueAnimator9);
                                        valueAnimator9.cancel();
                                    }
                                    LinearLayout linearLayout6 = this.mEpgParent;
                                    boolean z11 = linearLayout6 != null && linearLayout6.getVisibility() == 0;
                                    if (this.mIsCategoryOpen || !z11) {
                                        ValueAnimator valueAnimator10 = this.epgAnimOpen;
                                        kotlin.jvm.internal.m.c(valueAnimator10);
                                        valueAnimator10.start();
                                        c3();
                                    }
                                    if (this.isInitOpen) {
                                        ValueAnimator valueAnimator11 = this.categoryAnimOpen;
                                        kotlin.jvm.internal.m.c(valueAnimator11);
                                        if (valueAnimator11.isRunning()) {
                                            ValueAnimator valueAnimator12 = this.categoryAnimOpen;
                                            kotlin.jvm.internal.m.c(valueAnimator12);
                                            valueAnimator12.cancel();
                                        }
                                    }
                                    if (this.mIsCategoryOpen || !z11) {
                                        ValueAnimator valueAnimator13 = this.categoryAnimClose;
                                        kotlin.jvm.internal.m.c(valueAnimator13);
                                        valueAnimator13.start();
                                        this.mIsCategoryOpen = false;
                                        this.mEpgShowFirst = false;
                                    }
                                    this.isInitOpen = false;
                                    com.live.evo.osd.b bVar22 = this.mEpgAdapter;
                                    if ((bVar22 != null ? bVar22.getCount() : 0) <= 0) {
                                        ProgramListView programListView20 = this.mLvEpgDate;
                                        if (programListView20 != null) {
                                            programListView20.requestFocus();
                                        }
                                        M2(this.mLvEpgDate);
                                        ProgramListView programListView21 = this.mLvEpgDate;
                                        if (programListView21 != null) {
                                            n5.b bVar23 = this.epgDateAdapter;
                                            programListView21.setSelection(bVar23 != null ? bVar23.b() : 0);
                                            r8.z zVar22 = r8.z.f17874a;
                                        }
                                        n5.b bVar24 = this.epgDateAdapter;
                                        if (bVar24 != null) {
                                            bVar24.f(bVar24 != null ? bVar24.b() : 0);
                                            r8.z zVar23 = r8.z.f17874a;
                                        }
                                        i0(this.mLvEpgDate);
                                        this.mEpgShowFirst = false;
                                        return true;
                                    }
                                    ProgramListView programListView22 = this.mEpgListView;
                                    if (programListView22 != null) {
                                        programListView22.requestFocus();
                                    }
                                    M2(this.mEpgListView);
                                    n5.b bVar25 = this.epgDateAdapter;
                                    Integer numValueOf2 = bVar25 != null ? Integer.valueOf(bVar25.b()) : null;
                                    n5.b bVar26 = this.epgDateAdapter;
                                    if (numValueOf2 != (bVar26 != null ? Integer.valueOf(bVar26.c()) : null)) {
                                        n5.b bVar27 = this.epgDateAdapter;
                                        if (bVar27 != null) {
                                            bVar27.d(bVar27 != null ? bVar27.b() : 0, false);
                                            r8.z zVar24 = r8.z.f17874a;
                                        }
                                    } else {
                                        n5.b bVar28 = this.epgDateAdapter;
                                        if (bVar28 != null) {
                                            bVar28.d(bVar28 != null ? bVar28.c() : 0, false);
                                            r8.z zVar25 = r8.z.f17874a;
                                        }
                                        int i14 = this.mNowPlayingIndex;
                                        if (i14 > 0) {
                                            com.live.evo.osd.b bVar29 = this.mEpgAdapter;
                                            if (bVar29 != null) {
                                                bVar29.b(i14);
                                                r8.z zVar26 = r8.z.f17874a;
                                            }
                                            ProgramListView programListView23 = this.mEpgListView;
                                            if (programListView23 != null) {
                                                programListView23.setSelection(this.mNowPlayingIndex);
                                                r8.z zVar27 = r8.z.f17874a;
                                            }
                                        } else {
                                            com.live.evo.osd.b bVar30 = this.mEpgAdapter;
                                            if (bVar30 != null) {
                                                bVar30.b(-1);
                                                r8.z zVar28 = r8.z.f17874a;
                                            }
                                            com.live.evo.osd.b bVar31 = this.mEpgAdapter;
                                            if (bVar31 != null) {
                                                bVar31.b(0);
                                                r8.z zVar29 = r8.z.f17874a;
                                            }
                                            ProgramListView programListView24 = this.mEpgListView;
                                            if (programListView24 != null) {
                                                programListView24.setSelection(0);
                                                r8.z zVar30 = r8.z.f17874a;
                                            }
                                        }
                                    }
                                    return true;
                            }
                            break;
                        case R$id.programviewl_lv_main_program_listview_classify /* 2131429007 */:
                            if (keyCode == 19) {
                                this.hasChangeCategory = true;
                                ProgramListView programListView25 = this.mCategoryListView;
                                int selectedItemPosition4 = programListView25 != null ? programListView25.getSelectedItemPosition() : 0;
                                List<String> list9 = M2;
                                kotlin.jvm.internal.m.c(list9);
                                list9.size();
                                if (selectedItemPosition4 == 0) {
                                    y1 y1Var = R2;
                                    if (y1Var != null) {
                                        y1Var.a(1);
                                        r8.z zVar31 = r8.z.f17874a;
                                    }
                                    return true;
                                }
                            } else if (keyCode == 20) {
                                this.hasChangeCategory = true;
                                List<String> list10 = M2;
                                kotlin.jvm.internal.m.c(list10);
                                int size4 = list10.size();
                                ProgramListView programListView26 = this.mCategoryListView;
                                if ((programListView26 != null ? programListView26.getSelectedItemPosition() : 0) == size4 - 1) {
                                    ProgramListView programListView27 = this.mProgramListView;
                                    if (programListView27 != null) {
                                        programListView27.setSelection(0);
                                        r8.z zVar32 = r8.z.f17874a;
                                    }
                                    return true;
                                }
                            } else if (keyCode == 22) {
                                if (N1()) {
                                    RelativeLayout relativeLayout = this.mAdultKeyParent;
                                    kotlin.jvm.internal.m.c(relativeLayout);
                                    if (relativeLayout.getVisibility() == 0) {
                                        RelativeLayout relativeLayout2 = this.mAdultKeyParent;
                                        kotlin.jvm.internal.m.c(relativeLayout2);
                                        relativeLayout2.requestFocus();
                                    } else {
                                        this.postMetricisFromCategory = true;
                                        ProgramListView programListView28 = this.mProgramListView;
                                        if (programListView28 != null) {
                                            programListView28.requestFocus();
                                        }
                                    }
                                    return true;
                                }
                                if (com.live.evo.a.f5181a) {
                                    List<? extends i5.h> list11 = this.mListVodVideo;
                                    if (list11 != null) {
                                        kotlin.jvm.internal.m.c(list11);
                                        if (list11.size() > 0) {
                                            this.postMetricisFromCategory = true;
                                            Map<String, String> map2 = this.mHistoryMap;
                                            kotlin.jvm.internal.m.c(map2);
                                            List<String> list12 = M2;
                                            kotlin.jvm.internal.m.c(list12);
                                            String str = map2.get(list12.get(this.mCategorySelect));
                                            if (str != null) {
                                                List<String> listG = new ua.l(",").g(str, 0);
                                                if (listG.isEmpty()) {
                                                    listL = kotlin.collections.r.l();
                                                } else {
                                                    ListIterator<String> listIterator = listG.listIterator(listG.size());
                                                    while (true) {
                                                        if (!listIterator.hasPrevious()) {
                                                            listL = kotlin.collections.r.l();
                                                        } else if (!(listIterator.previous().length() == 0)) {
                                                            listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                                                        }
                                                    }
                                                }
                                                strArr = (String[]) listL.toArray(new String[0]);
                                            } else {
                                                strArr = null;
                                            }
                                            try {
                                                kotlin.jvm.internal.m.c(strArr);
                                                i10 = Integer.parseInt(strArr[0]);
                                                try {
                                                    i11 = Integer.parseInt(strArr[1]);
                                                } catch (Exception unused) {
                                                    i11 = 0;
                                                }
                                            } catch (Exception unused2) {
                                                i10 = 0;
                                            }
                                            int iW1 = W1();
                                            M2(this.mProgramListView);
                                            if (iW1 >= 0 && this.hasChangeCategory) {
                                                ProgramListView programListView29 = this.mProgramListView;
                                                if (programListView29 != null) {
                                                    programListView29.setSelection(iW1);
                                                    r8.z zVar33 = r8.z.f17874a;
                                                }
                                            } else if (iW1 < 0 || !this.isChangeChannel) {
                                                ProgramListView programListView30 = this.mProgramListView;
                                                if (programListView30 != null) {
                                                    programListView30.setSelectionFromTop(i10, i11);
                                                    r8.z zVar34 = r8.z.f17874a;
                                                }
                                            } else {
                                                ProgramListView programListView31 = this.mProgramListView;
                                                if (programListView31 != null) {
                                                    programListView31.setSelection(iW1);
                                                    r8.z zVar35 = r8.z.f17874a;
                                                }
                                            }
                                            ValueAnimator valueAnimator14 = this.categoryAnimOpen;
                                            kotlin.jvm.internal.m.c(valueAnimator14);
                                            if (valueAnimator14.isRunning()) {
                                                ValueAnimator valueAnimator15 = this.categoryAnimOpen;
                                                kotlin.jvm.internal.m.c(valueAnimator15);
                                                valueAnimator15.cancel();
                                            }
                                        }
                                        break;
                                    }
                                    return true;
                                }
                            }
                            break;
                    }
                    break;
            }
        } else {
            if (keyCode == 19) {
                n5.b bVar32 = this.epgDateAdapter;
                if ((bVar32 != null ? bVar32.b() : 0) > 0) {
                    n5.b bVar33 = this.epgDateAdapter;
                    iB = bVar33 != null ? bVar33.b() : 0;
                    ProgramListView programListView32 = this.mLvEpgDate;
                    if (programListView32 != null) {
                        programListView32.setSelection(iB - 1);
                        r8.z zVar36 = r8.z.f17874a;
                    }
                }
                return true;
            }
            if (keyCode == 20) {
                n5.b bVar34 = this.epgDateAdapter;
                int iB5 = bVar34 != null ? bVar34.b() : 0;
                n5.b bVar35 = this.epgDateAdapter;
                if (iB5 < (bVar35 != null ? bVar35.a() : 0)) {
                    n5.b bVar36 = this.epgDateAdapter;
                    iB = bVar36 != null ? bVar36.b() : 0;
                    ProgramListView programListView33 = this.mLvEpgDate;
                    if (programListView33 != null) {
                        programListView33.setSelection(iB + 1);
                        r8.z zVar37 = r8.z.f17874a;
                    }
                }
                return true;
            }
        }
        if (keyCode == 16 && event.getRepeatCount() == 5) {
            com.live.evo.osd.persenter.a aVar4 = Q2;
            kotlin.jvm.internal.m.c(aVar4);
            aVar4.m();
            return true;
        }
        if (keyCode == 15 && event.getRepeatCount() == 5) {
            com.live.evo.osd.persenter.a aVar5 = Q2;
            kotlin.jvm.internal.m.c(aVar5);
            ProgramListView programListView34 = this.mProgramListView;
            aVar5.k(programListView34 != null ? programListView34.getSelectedItemPosition() : 0);
            return true;
        }
        if (keyCode == 13 && event.getRepeatCount() == 5) {
            com.live.evo.osd.persenter.a aVar6 = Q2;
            kotlin.jvm.internal.m.c(aVar6);
            aVar6.w();
            return true;
        }
        if (keyCode == 14 && event.getRepeatCount() == 5) {
            Y2();
            return true;
        }
        if (com.live.evo.util.c.a().onKey(null, keyCode, event)) {
            n5.o oVar = this.mProgramAdapter;
            if (oVar != null) {
                oVar.notifyDataSetChanged();
                r8.z zVar38 = r8.z.f17874a;
            }
            return true;
        }
        if (keyCode >= 7 && keyCode <= 16 && com.live.evo.util.c.a().b()) {
            Iterator<com.live.evo.util.x> it = this.numberStrategies.iterator();
            while (it.hasNext()) {
                if (it.next().a(keyCode, event)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void E2() {
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        list.clear();
        if (!com.live.evo.k.b().h()) {
            List<String> list2 = M2;
            kotlin.jvm.internal.m.c(list2);
            List<String> list3 = N2;
            kotlin.jvm.internal.m.c(list3);
            list2.addAll(list3);
            return;
        }
        List<String> list4 = M2;
        kotlin.jvm.internal.m.c(list4);
        List<String> list5 = N2;
        kotlin.jvm.internal.m.c(list5);
        list4.addAll(list5);
        List<i5.a0> listC = com.live.evo.util.b1.c("private_group");
        kotlin.jvm.internal.m.e(listC, "getProperties(...)");
        for (i5.a0 a0Var : listC) {
            List<String> list6 = N2;
            kotlin.jvm.internal.m.c(list6);
            if (list6.contains(a0Var.a()) && a0Var.b().equals("1")) {
                List<String> list7 = M2;
                kotlin.jvm.internal.m.c(list7);
                list7.remove(a0Var.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F2(i5.h data) {
        com.live.evo.osd.persenter.a aVar = Q2;
        if (aVar != null) {
            kotlin.jvm.internal.m.c(aVar);
            kotlin.jvm.internal.m.c(data);
            aVar.c("ChannelFragment", data.i());
        }
    }

    private final void H2() {
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        if (list.size() > 0) {
            try {
                TextView textView = this.mTextCategoryName;
                kotlin.jvm.internal.m.c(textView);
                Map<String, ? extends i5.i> map = P2;
                kotlin.jvm.internal.m.c(map);
                List<String> list2 = M2;
                kotlin.jvm.internal.m.c(list2);
                i5.i iVar = map.get(list2.get(this.mCategorySelect));
                kotlin.jvm.internal.m.c(iVar);
                textView.setText(iVar.h());
            } catch (Exception unused) {
            }
        }
        com.live.evo.osd.m mVar = this.mCategoryAdapter;
        if (mVar == null || mVar == null) {
            return;
        }
        mVar.a(M2);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:55:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:57:0x00cf  */
    private final void J2(String classifyName) {
        boolean z10;
        ProgramListView programListView;
        RelativeLayout relativeLayout;
        n5.o oVar = this.mProgramAdapter;
        if (oVar != null) {
            ProgramListView programListView2 = this.mProgramListView;
            oVar.e(programListView2 != null ? programListView2.getSelectedView() : null, true);
        }
        e3(this.mListVodVideo);
        com.live.evo.osd.m mVar = this.mCategoryAdapter;
        if (mVar != null) {
            int i10 = this.mCategorySelect;
            ProgramListView programListView3 = this.mCategoryListView;
            mVar.b(i10, programListView3 != null && programListView3.isFocused());
        }
        R2();
        K2(classifyName);
        RelativeLayout relativeLayout2 = this.mPreviewContainer;
        if (relativeLayout2 != null) {
            kotlin.jvm.internal.m.c(relativeLayout2);
            z10 = relativeLayout2.getVisibility() == 0;
        }
        L1();
        if (!z10 && (relativeLayout = this.mPreviewContainer) != null) {
            kotlin.jvm.internal.m.c(relativeLayout);
            if (relativeLayout.getVisibility() == 0 && !com.live.evo.l.n().H()) {
                P2();
            }
        }
        RelativeLayout relativeLayout3 = this.mAdultKeyParent;
        kotlin.jvm.internal.m.c(relativeLayout3);
        if (relativeLayout3.getVisibility() == 0) {
            RelativeLayout relativeLayout4 = this.mAdultKeyParent;
            kotlin.jvm.internal.m.c(relativeLayout4);
            relativeLayout4.setVisibility(8);
        }
        RelativeLayout relativeLayout5 = this.mChannelParent;
        kotlin.jvm.internal.m.c(relativeLayout5);
        if (relativeLayout5.getVisibility() != 0) {
            RelativeLayout relativeLayout6 = this.mChannelParent;
            kotlin.jvm.internal.m.c(relativeLayout6);
            relativeLayout6.setVisibility(0);
        }
        TextView textView = this.mTextPipTip;
        if (textView != null) {
            kotlin.jvm.internal.m.c(textView);
            if (textView.getVisibility() != 0) {
                TextView textView2 = this.mTextPipTip;
                kotlin.jvm.internal.m.c(textView2);
                textView2.setVisibility(0);
            }
        }
        List<? extends i5.h> list = this.mListVodVideo;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            if (list.size() > 0) {
                if (P1()) {
                    ImageView imageView = this.mIvRight;
                    kotlin.jvm.internal.m.c(imageView);
                    imageView.setVisibility(8);
                } else {
                    ImageView imageView2 = this.mIvRight;
                    kotlin.jvm.internal.m.c(imageView2);
                    imageView2.setVisibility(0);
                }
                ProgramListView programListView4 = this.mProgramListView;
                if (programListView4 != null) {
                    programListView4.setVisibility(0);
                }
            } else {
                programListView = this.mProgramListView;
                if (programListView != null) {
                    programListView.setVisibility(8);
                }
                ImageView imageView3 = this.mIvRight;
                kotlin.jvm.internal.m.c(imageView3);
                imageView3.setVisibility(8);
            }
        } else {
            programListView = this.mProgramListView;
            if (programListView != null) {
                programListView.setVisibility(8);
            }
            ImageView imageView4 = this.mIvRight;
            kotlin.jvm.internal.m.c(imageView4);
            imageView4.setVisibility(8);
        }
        V2();
    }

    private final void K1(int position) {
        List<String> list;
        boolean z10;
        if (this.mProgramAdapter == null || (list = M2) == null) {
            return;
        }
        kotlin.jvm.internal.m.c(list);
        if (list.size() <= position) {
            return;
        }
        n5.o oVar = this.mProgramAdapter;
        if (oVar != null) {
            ProgramListView programListView = this.mProgramListView;
            oVar.e(programListView != null ? programListView.getSelectedView() : null, true);
        }
        List<String> list2 = M2;
        kotlin.jvm.internal.m.c(list2);
        String str = list2.get(position);
        if (position == 1) {
            List<i5.h> listJ = com.live.evo.util.s0.j(com.live.evo.util.s0.f7342a, t.v.c.i.a.f18646a.J(), false, 2, null);
            HashMap<String, List<i5.h>> map = O2;
            kotlin.jvm.internal.m.c(map);
            map.put(str, listJ);
            this.mListVodVideo = listJ;
            e3(listJ);
        } else if (position != 2) {
            HashMap<String, List<i5.h>> map2 = O2;
            kotlin.jvm.internal.m.c(map2);
            List<i5.h> listL = map2.get(str);
            if (listL == null) {
                listL = kotlin.collections.r.l();
            }
            List<i5.a0> listC = com.live.evo.util.b1.c("private_group");
            kotlin.jvm.internal.m.e(listC, "getProperties(...)");
            Iterator<i5.a0> it = listC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                i5.a0 next = it.next();
                List<String> list3 = N2;
                kotlin.jvm.internal.m.c(list3);
                if (list3.contains(next.a()) && next.b().equals("1")) {
                    z10 = true;
                    break;
                }
            }
            i5.i iVar = com.live.evo.util.s0.f7342a.t().get(str);
            boolean z11 = iVar != null && iVar.g() == 1;
            if (z10 || !z11) {
                ArrayList arrayList = new ArrayList();
                for (i5.h hVar : listL) {
                    if (!hVar.p()) {
                        arrayList.add(hVar);
                    }
                }
                listL = arrayList;
            }
            this.mListVodVideo = listL;
            e3(listL);
        } else {
            List<i5.h> listI = com.live.evo.util.s0.f7342a.i(t.v.c.i.a.f18646a.S(), false);
            HashMap<String, List<i5.h>> map3 = O2;
            kotlin.jvm.internal.m.c(map3);
            map3.put(str, listI);
            this.mListVodVideo = listI;
            e3(listI);
            xe.c.c().l(new b5.c(2));
        }
        com.live.evo.osd.m mVar = this.mCategoryAdapter;
        if (mVar != null) {
            ProgramListView programListView2 = this.mCategoryListView;
            mVar.b(position, programListView2 != null && programListView2.isFocused());
        }
        R2();
        K2(str);
    }

    private final void K2(String key) {
        try {
            TextView textView = this.mTextCategoryName;
            kotlin.jvm.internal.m.c(textView);
            Map<String, ? extends i5.i> map = P2;
            kotlin.jvm.internal.m.c(map);
            i5.i iVar = map.get(key);
            kotlin.jvm.internal.m.c(iVar);
            textView.setText(iVar.h());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final void L1() {
        if (this.mPreviewContainer != null) {
            if (P1() && !com.live.evo.l.n().H()) {
                RelativeLayout relativeLayout = this.mPreviewContainer;
                kotlin.jvm.internal.m.c(relativeLayout);
                relativeLayout.setVisibility(8);
            } else if (com.live.evo.k.b().l()) {
                RelativeLayout relativeLayout2 = this.mPreviewContainer;
                kotlin.jvm.internal.m.c(relativeLayout2);
                relativeLayout2.setVisibility(com.live.evo.l.n().G() ? 0 : 8);
            }
            if (!com.live.evo.l.n().G() || Q2 == null) {
                return;
            }
            q6.b logger = this.logger;
            kotlin.jvm.internal.m.e(logger, "logger");
            c5.b.a(logger, "ChannelFragment changePipView:" + this);
            com.live.evo.osd.persenter.a aVar = Q2;
            kotlin.jvm.internal.m.c(aVar);
            aVar.e("ChannelFragment");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized int L2(int position) {
        int size;
        Resources resources;
        CharSequence[] textArray;
        try {
            List<i5.p> list = this.tempEpgList;
            kotlin.jvm.internal.m.c(list);
            list.clear();
            long jH = com.live.evo.util.q1.h();
            n5.b bVar = this.epgDateAdapter;
            Calendar calendarC = com.live.evo.util.q1.c(jH, position - (bVar != null ? bVar.c() : 0));
            kotlin.jvm.internal.m.e(calendarC, "getNext0TimeCalendar(...)");
            long timeInMillis = calendarC.getTimeInMillis();
            TextView textView = this.mTvMonth;
            if (textView != null) {
                Context context = getContext();
                textView.setText((context == null || (resources = context.getResources()) == null || (textArray = resources.getTextArray(R$array.month)) == null) ? null : textArray[calendarC.get(2)]);
            }
            long jD = com.live.evo.util.q1.d(timeInMillis, 1);
            long jB = com.live.evo.util.q1.b();
            List<i5.p> list2 = this.curChannelEpgList;
            size = -1;
            if (list2 != null) {
                long j10 = 0;
                long j11 = LocationRequestCompat.PASSIVE_INTERVAL;
                for (i5.p pVar : list2) {
                    Long lF = pVar.f();
                    long j12 = timeInMillis;
                    kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
                    long jLongValue = lF.longValue();
                    Long lG = pVar.g();
                    kotlin.jvm.internal.m.e(lG, "getStopTime(...)");
                    long jLongValue2 = lG.longValue();
                    if (jLongValue < j11) {
                        j11 = jLongValue;
                    }
                    if (jLongValue2 > j10) {
                        j10 = jLongValue2;
                    }
                    n5.b bVar2 = this.epgDateAdapter;
                    if (bVar2 != null && position == bVar2.c() && jLongValue + 1 <= j12 && j12 < jLongValue2) {
                        List<i5.p> list3 = this.tempEpgList;
                        kotlin.jvm.internal.m.c(list3);
                        list3.add(pVar);
                    } else if (jLongValue >= j12 && jLongValue < jD) {
                        List<i5.p> list4 = this.tempEpgList;
                        kotlin.jvm.internal.m.c(list4);
                        list4.add(pVar);
                    }
                    List<i5.p> list5 = this.tempEpgList;
                    if (list5 != null) {
                        kotlin.jvm.internal.m.c(list5);
                        if (!list5.isEmpty() && size < 0 && jLongValue <= jB && jB <= jLongValue2) {
                            List<i5.p> list6 = this.tempEpgList;
                            kotlin.jvm.internal.m.c(list6);
                            size = list6.size() - 1;
                        }
                    }
                    timeInMillis = j12;
                }
            }
            List<i5.p> list7 = this.tempEpgList;
            if (list7 != null) {
                kotlin.jvm.internal.m.c(list7);
                if (!list7.isEmpty() && size < 0) {
                    size = 0;
                }
            }
            List<i5.p> list8 = this.tempEpgList;
            kotlin.jvm.internal.m.c(list8);
            if (list8.size() > 0) {
                TextView textView2 = this.mTvNotData;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else {
                TextView textView3 = this.mEpgDuration;
                if (textView3 != null) {
                    textView3.setText("");
                }
                TextView textView4 = this.mEpgProgram;
                if (textView4 != null) {
                    textView4.setText("");
                }
                TextView textView5 = this.mEpgDescription;
                if (textView5 != null) {
                    textView5.setText(com.live.evo.util.x1.j(R$string.epg_description));
                }
                TextView textView6 = this.mTvNotData;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
            }
            com.live.evo.osd.b bVar3 = this.mEpgAdapter;
            if (bVar3 != null) {
                bVar3.a(this.tempEpgList, this.curChannelId);
            }
        } catch (Throwable th) {
            throw th;
        }
        return size;
    }

    private final boolean M1() {
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        if (!list.isEmpty()) {
            HashMap<String, List<i5.h>> map = O2;
            kotlin.jvm.internal.m.c(map);
            if (!map.isEmpty()) {
                HashMap<String, List<i5.h>> map2 = O2;
                kotlin.jvm.internal.m.c(map2);
                List<String> list2 = M2;
                kotlin.jvm.internal.m.c(list2);
                List<i5.h> list3 = map2.get(list2.get(this.mCategorySelect));
                if (list3 != null) {
                    int size = list3.size();
                    int i10 = this.mProgramSelect;
                    if (size > i10) {
                        i5.h hVar = list3.get(i10);
                        return hVar != null && hVar.p();
                    }
                }
            }
        }
        return true;
    }

    private final void M2(View focusView) {
        this.focusView = focusView;
    }

    private final void N2(EditText editText, String hintText, int textSize) {
        SpannableString spannableString = new SpannableString(hintText);
        spannableString.setSpan(new AbsoluteSizeSpan(textSize, true), 0, spannableString.length(), 33);
        kotlin.jvm.internal.m.c(editText);
        editText.setHint(new SpannedString(spannableString));
    }

    private final boolean O1() {
        int i10 = this.playCategory;
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        if (i10 >= list.size()) {
            return false;
        }
        List<String> list2 = M2;
        kotlin.jvm.internal.m.c(list2);
        String str = list2.get(this.playCategory);
        i5.i iVar = com.live.evo.util.s0.f7342a.t().get(str);
        boolean z10 = iVar != null && iVar.g() == 1;
        this.logger.debug("checkPlayingIsInAdultCategory:{},{},{}", Integer.valueOf(this.playCategory), str, Boolean.valueOf(z10));
        return z10;
    }

    private final boolean P1() {
        String str;
        int i10 = this.mCategorySelect;
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        if (i10 < list.size()) {
            List<String> list2 = M2;
            kotlin.jvm.internal.m.c(list2);
            str = list2.get(this.mCategorySelect);
        } else {
            List<String> list3 = M2;
            kotlin.jvm.internal.m.c(list3);
            str = list3.get(0);
        }
        i5.i iVar = com.live.evo.util.s0.f7342a.t().get(str);
        return iVar != null && iVar.g() == 1;
    }

    private final boolean Q1() {
        String lowerCase;
        int i10 = this.mCategorySelect;
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        if (i10 < list.size()) {
            List<String> list2 = M2;
            kotlin.jvm.internal.m.c(list2);
            String str = list2.get(this.mCategorySelect);
            Locale locale = Locale.getDefault();
            kotlin.jvm.internal.m.e(locale, "getDefault(...)");
            lowerCase = str.toLowerCase(locale);
            kotlin.jvm.internal.m.e(lowerCase, "toLowerCase(...)");
        } else {
            List<String> list3 = M2;
            kotlin.jvm.internal.m.c(list3);
            String str2 = list3.get(0);
            Locale locale2 = Locale.getDefault();
            kotlin.jvm.internal.m.e(locale2, "getDefault(...)");
            lowerCase = str2.toLowerCase(locale2);
            kotlin.jvm.internal.m.e(lowerCase, "toLowerCase(...)");
        }
        return com.live.evo.k.b().f() && ua.n.w(lowerCase, "history", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q2(i5.p bean) {
        HashMap<String, List<i5.h>> map = O2;
        kotlin.jvm.internal.m.c(map);
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        List<i5.h> list2 = map.get(list.get(this.mCategorySelect));
        kotlin.jvm.internal.m.c(list2);
        i5.h hVar = list2.get(this.mProgramSelect);
        com.live.evo.osd.u uVar = com.live.evo.osd.u.f7147a;
        String strE = hVar.e();
        kotlin.jvm.internal.m.e(strE, "getDname(...)");
        uVar.s(strE, hVar.g(), hVar.i(), bean, this.curChannelId, MessageOriginChannel.MESSAGE_ORIGIN_TYPE, this.subscribeUpdateListener, (128 & 128) != 0 ? null : null);
    }

    private final void R1() {
        Editable text;
        RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText = this.etPassword;
        if (removeKeyCodeEnterEditText == null || (text = removeKeyCodeEnterEditText.getText()) == null) {
            return;
        }
        if (text.length() < this.LENGTH) {
            com.live.evo.util.r1.a(getActivity(), R$string.adult_key_not_map);
            RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText2 = this.etPassword;
            if (removeKeyCodeEnterEditText2 != null) {
                removeKeyCodeEnterEditText2.requestFocus();
                return;
            }
            return;
        }
        if (!com.live.evo.l.n().y()) {
            if (!TextUtils.equals(text, "2026")) {
                com.live.evo.util.r1.c(getActivity(), com.live.evo.util.x1.k(R$string.adult_key_saved, text.toString()));
                com.live.evo.l.n().O(text.toString());
                com.live.evo.l.n().N(true);
                RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText3 = this.etPassword;
                if (removeKeyCodeEnterEditText3 != null) {
                    removeKeyCodeEnterEditText3.setText("");
                }
                y2();
                return;
            }
            com.live.evo.util.r1.a(getActivity(), R$string.adult_key_invalid);
            com.live.evo.l.n().N(false);
            RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText4 = this.etPassword;
            if (removeKeyCodeEnterEditText4 != null) {
                removeKeyCodeEnterEditText4.setText("");
            }
            RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText5 = this.etPassword;
            if (removeKeyCodeEnterEditText5 != null) {
                removeKeyCodeEnterEditText5.requestFocus();
                return;
            }
            return;
        }
        if (t.v.c.i.a.f18646a.p0(text.toString())) {
            com.live.evo.l.n().N(true);
            RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText6 = this.etPassword;
            if (removeKeyCodeEnterEditText6 != null) {
                removeKeyCodeEnterEditText6.setText("");
            }
            y2();
            return;
        }
        if (TextUtils.equals(text, "2026")) {
            com.live.evo.util.r1.a(getActivity(), R$string.adult_key_reset_hint);
            com.live.evo.l.n().O("");
            com.live.evo.l.n().N(false);
            RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText7 = this.etPassword;
            if (removeKeyCodeEnterEditText7 != null) {
                removeKeyCodeEnterEditText7.setText("");
            }
            x2();
            return;
        }
        com.live.evo.util.r1.a(getActivity(), R$string.adult_key_not_map);
        com.live.evo.l.n().N(false);
        RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText8 = this.etPassword;
        if (removeKeyCodeEnterEditText8 != null) {
            removeKeyCodeEnterEditText8.setText("");
        }
        RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText9 = this.etPassword;
        if (removeKeyCodeEnterEditText9 != null) {
            removeKeyCodeEnterEditText9.requestFocus();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    private final void R2() {
        int size;
        String str;
        List<? extends i5.h> list = this.mListVodVideo;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            if (list.size() > 0) {
                List<? extends i5.h> list2 = this.mListVodVideo;
                kotlin.jvm.internal.m.c(list2);
                size = list2.size();
                str = "1";
            } else {
                size = 0;
                str = "0";
            }
        } else {
            size = 0;
            str = "0";
        }
        TextView textView = this.mTextViewTotalProg;
        kotlin.jvm.internal.m.c(textView);
        StringBuilder sb2 = new StringBuilder("/");
        sb2.append(size);
        textView.setText(sb2);
        TextView textView2 = this.mTextPosition;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setText(str);
        TextView textView3 = this.mTextProgramTotal;
        kotlin.jvm.internal.m.c(textView3);
        StringBuilder sb3 = new StringBuilder("/");
        sb3.append(size);
        textView3.setText(sb3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1() {
        this.mHandler.removeMessages(8194);
        this.mHandler.sendEmptyMessageDelayed(8194, 100L);
    }

    private final int U1(int position) {
        List<i5.p> list = this.curChannelEpgList;
        int i10 = 0;
        if (list == null) {
            return 0;
        }
        long jH = com.live.evo.util.q1.h();
        TimeUnit timeUnit = TimeUnit.DAYS;
        n5.b bVar = this.epgDateAdapter;
        long millis = jH + timeUnit.toMillis(position - (bVar != null ? bVar.c() : 0));
        long millis2 = timeUnit.toMillis(1L) + millis;
        long jB = com.live.evo.util.q1.b();
        long millis3 = timeUnit.toMillis(1L) + jB;
        n5.b bVar2 = this.epgDateAdapter;
        long millis4 = jB + timeUnit.toMillis(0 - ((long) (bVar2 != null ? bVar2.c() : 0)));
        Iterator<i5.p> it = list.iterator();
        while (it.hasNext()) {
            Long lF = it.next().f();
            kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
            long jLongValue = lF.longValue();
            if (jLongValue >= millis && jLongValue < millis2 && jLongValue >= millis4 && jLongValue < millis3) {
                i10++;
            }
        }
        return i10;
    }

    private final int W1() {
        HashMap<String, List<i5.h>> map = O2;
        kotlin.jvm.internal.m.c(map);
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        List<i5.h> list2 = map.get(list.get(this.mCategorySelect));
        if (list2 == null) {
            return -1;
        }
        int i10 = this.playAllPos;
        int size = list2.size();
        for (int i11 = 0; i11 < size; i11++) {
            i5.h hVar = list2.get(i11);
            kotlin.jvm.internal.m.c(hVar);
            if (i10 == hVar.i()) {
                return i11;
            }
        }
        return -1;
    }

    private final void W2() {
        TextView textView = this.mTextPipTip;
        if (textView == null) {
            return;
        }
        kotlin.jvm.internal.m.c(textView);
        textView.setText("");
        TextView textView2 = this.mTextPipTip;
        kotlin.jvm.internal.m.c(textView2);
        if (textView2.getVisibility() != 0) {
            TextView textView3 = this.mTextPipTip;
            kotlin.jvm.internal.m.c(textView3);
            textView3.setVisibility(0);
        }
        TextView textView4 = this.mTextCurrentPos;
        if (textView4 != null) {
            kotlin.jvm.internal.m.c(textView4);
            if (textView4.getVisibility() == 0) {
                TextView textView5 = this.mTextCurrentPos;
                kotlin.jvm.internal.m.c(textView5);
                textView5.setVisibility(8);
            }
        }
        TextView textView6 = this.mTextViewTotalProg;
        if (textView6 != null) {
            kotlin.jvm.internal.m.c(textView6);
            if (textView6.getVisibility() == 0) {
                TextView textView7 = this.mTextViewTotalProg;
                kotlin.jvm.internal.m.c(textView7);
                textView7.setVisibility(8);
            }
        }
        if (com.live.evo.k.b() == null || com.live.evo.k.b().l()) {
            this.mHandler.removeCallbacks(this.mPipTipRunnable);
            this.mHandler.postDelayed(this.mPipTipRunnable, 6000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(x xVar) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        if (xVar.mCategoryListView != null) {
            int i10 = com.live.evo.a.f5181a ? xVar.mCategoryWidth : 0;
            View view = xVar.mCategoryParent;
            if (view != null && (layoutParams2 = view.getLayoutParams()) != null) {
                layoutParams2.width = i10;
            }
            View view2 = xVar.mCategoryParent;
            if (view2 != null) {
                view2.requestLayout();
            }
            View view3 = xVar.mCategoryParent;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            if (xVar.U2()) {
                LinearLayout linearLayout = xVar.mEpgParent;
                if (linearLayout != null && (layoutParams = linearLayout.getLayoutParams()) != null) {
                    layoutParams.width = 0;
                }
                LinearLayout linearLayout2 = xVar.mEpgParent;
                if (linearLayout2 != null) {
                    linearLayout2.requestLayout();
                }
            }
        }
        com.live.evo.osd.persenter.a aVar = Q2;
        kotlin.jvm.internal.m.c(aVar);
        aVar.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X2() {
        this.mHandler.removeMessages(8195);
        this.mHandler.sendEmptyMessageDelayed(8195, 150L);
    }

    private final void Y1() {
        RelativeLayout relativeLayout = this.mCategoryBannerParent;
        kotlin.jvm.internal.m.c(relativeLayout);
        if (relativeLayout.getVisibility() != 8) {
            Banner<String, com.live.evo.catchup.player.b> banner = this.mCategoryBanner;
            kotlin.jvm.internal.m.c(banner);
            banner.stop();
            RelativeLayout relativeLayout2 = this.mCategoryBannerParent;
            kotlin.jvm.internal.m.c(relativeLayout2);
            relativeLayout2.setVisibility(8);
        }
        ImageView imageView = this.mCategoryBannerFrontPic;
        kotlin.jvm.internal.m.c(imageView);
        imageView.setVisibility(4);
        TextView textView = this.mCategoryBannerDesc;
        kotlin.jvm.internal.m.c(textView);
        textView.setVisibility(4);
    }

    private final void Z1() {
        if (this.etPassword == null || getContext() == null) {
            return;
        }
        Context context = getContext();
        InputMethodManager inputMethodManager = (InputMethodManager) (context != null ? context.getSystemService("input_method") : null);
        if (inputMethodManager != null) {
            RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText = this.etPassword;
            inputMethodManager.hideSoftInputFromWindow(removeKeyCodeEnterEditText != null ? removeKeyCodeEnterEditText.getWindowToken() : null, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z2(final x xVar) {
        com.live.evo.util.k1.f7250a.c(new Runnable() { // from class: com.live.evo.fragment.m
            @Override // java.lang.Runnable
            public final void run() {
                x.a3(this.f6451a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a3(x xVar) {
        com.live.evo.osd.b bVar = xVar.mEpgAdapter;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    private final void b2() {
        Button button = this.goAhead;
        kotlin.jvm.internal.m.c(button);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.live.evo.fragment.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.c2(this.f6498a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:24:0x008c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0113  */
    /* JADX WARN: Code duplicated, block: B:58:0x0117  */
    /* JADX WARN: Code duplicated, block: B:75:0x017a  */
    /* JADX WARN: Code duplicated, block: B:77:0x0190  */
    public final void b3() {
        boolean z10;
        ProgramListView programListView;
        ProgramListView programListView2;
        int i10;
        int i11;
        List listL;
        ProgramListView programListView3;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ImageView imageView = this.mIvRight;
        kotlin.jvm.internal.m.c(imageView);
        if (imageView.getParent() != null) {
            ImageView imageView2 = this.mIvRight;
            kotlin.jvm.internal.m.c(imageView2);
            Object parent = imageView2.getParent();
            kotlin.jvm.internal.m.d(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).setVisibility(0);
        }
        K1(this.mCategorySelect);
        if (N1()) {
            ImageView imageView3 = this.mIvRight;
            kotlin.jvm.internal.m.c(imageView3);
            imageView3.setVisibility(8);
            RelativeLayout relativeLayout3 = this.mChannelParent;
            kotlin.jvm.internal.m.c(relativeLayout3);
            relativeLayout3.setVisibility(8);
            RelativeLayout relativeLayout4 = this.mAdultKeyParent;
            kotlin.jvm.internal.m.c(relativeLayout4);
            relativeLayout4.setVisibility(0);
            x2();
            TextView textView = this.mTextPipTip;
            if (textView != null) {
                kotlin.jvm.internal.m.c(textView);
                if (textView.getVisibility() == 0) {
                    TextView textView2 = this.mTextPipTip;
                    kotlin.jvm.internal.m.c(textView2);
                    textView2.setVisibility(8);
                }
            }
            if (com.live.evo.k.b().l() && !com.live.evo.l.n().H() && (relativeLayout2 = this.mPreviewContainer) != null) {
                kotlin.jvm.internal.m.c(relativeLayout2);
                relativeLayout2.setVisibility(8);
            }
        } else {
            RelativeLayout relativeLayout5 = this.mPreviewContainer;
            if (relativeLayout5 != null) {
                kotlin.jvm.internal.m.c(relativeLayout5);
                if (relativeLayout5.getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else {
                z10 = false;
            }
            L1();
            if (!z10 && (relativeLayout = this.mPreviewContainer) != null) {
                kotlin.jvm.internal.m.c(relativeLayout);
                if (relativeLayout.getVisibility() == 0 && !com.live.evo.l.n().H()) {
                    P2();
                }
            }
            RelativeLayout relativeLayout6 = this.mAdultKeyParent;
            kotlin.jvm.internal.m.c(relativeLayout6);
            if (relativeLayout6.getVisibility() == 0) {
                RelativeLayout relativeLayout7 = this.mAdultKeyParent;
                kotlin.jvm.internal.m.c(relativeLayout7);
                relativeLayout7.setVisibility(8);
            }
            RelativeLayout relativeLayout8 = this.mChannelParent;
            kotlin.jvm.internal.m.c(relativeLayout8);
            if (relativeLayout8.getVisibility() != 0) {
                RelativeLayout relativeLayout9 = this.mChannelParent;
                kotlin.jvm.internal.m.c(relativeLayout9);
                relativeLayout9.setVisibility(0);
            }
            TextView textView3 = this.mTextPipTip;
            if (textView3 != null) {
                kotlin.jvm.internal.m.c(textView3);
                if (textView3.getVisibility() != 0) {
                    TextView textView4 = this.mTextPipTip;
                    kotlin.jvm.internal.m.c(textView4);
                    textView4.setVisibility(0);
                }
            }
            List<? extends i5.h> list = this.mListVodVideo;
            if (list != null) {
                kotlin.jvm.internal.m.c(list);
                if (list.size() > 0) {
                    if (P1()) {
                        ImageView imageView4 = this.mIvRight;
                        kotlin.jvm.internal.m.c(imageView4);
                        imageView4.setVisibility(8);
                    } else {
                        ImageView imageView5 = this.mIvRight;
                        kotlin.jvm.internal.m.c(imageView5);
                        imageView5.setVisibility(0);
                    }
                    ProgramListView programListView4 = this.mProgramListView;
                    if (programListView4 != null) {
                        programListView4.setVisibility(0);
                    }
                } else {
                    programListView = this.mProgramListView;
                    if (programListView != null) {
                        programListView.setVisibility(8);
                    }
                    ImageView imageView6 = this.mIvRight;
                    kotlin.jvm.internal.m.c(imageView6);
                    imageView6.setVisibility(8);
                }
            } else {
                programListView = this.mProgramListView;
                if (programListView != null) {
                    programListView.setVisibility(8);
                }
                ImageView imageView7 = this.mIvRight;
                kotlin.jvm.internal.m.c(imageView7);
                imageView7.setVisibility(8);
            }
            List<? extends i5.h> list2 = this.mListVodVideo;
            String str = "0";
            if (list2 != null) {
                kotlin.jvm.internal.m.c(list2);
                if (list2.isEmpty()) {
                    TextView textView5 = this.mTextPosition;
                    kotlin.jvm.internal.m.c(textView5);
                    textView5.setText("0");
                    TextView textView6 = this.mTextProgramTotal;
                    kotlin.jvm.internal.m.c(textView6);
                    textView6.setText("/0");
                    programListView2 = this.mProgramListView;
                    if (programListView2 != null) {
                        programListView2.setVisibility(8);
                    }
                } else {
                    ProgramListView programListView5 = this.mProgramListView;
                    if ((programListView5 != null ? Integer.valueOf(programListView5.getVisibility()) : null) != 0 && (programListView3 = this.mProgramListView) != null) {
                        programListView3.setVisibility(0);
                    }
                    TextView textView7 = this.mTextPosition;
                    kotlin.jvm.internal.m.c(textView7);
                    textView7.setText("1");
                    TextView textView8 = this.mTextProgramTotal;
                    kotlin.jvm.internal.m.c(textView8);
                    List<? extends i5.h> list3 = this.mListVodVideo;
                    kotlin.jvm.internal.m.c(list3);
                    textView8.setText("/" + list3.size());
                }
            } else {
                TextView textView9 = this.mTextPosition;
                kotlin.jvm.internal.m.c(textView9);
                textView9.setText("0");
                TextView textView10 = this.mTextProgramTotal;
                kotlin.jvm.internal.m.c(textView10);
                textView10.setText("/0");
                programListView2 = this.mProgramListView;
                if (programListView2 != null) {
                    programListView2.setVisibility(8);
                }
            }
            List<String> list4 = M2;
            kotlin.jvm.internal.m.c(list4);
            String str2 = list4.get(this.mCategorySelect);
            Map<String, String> map = this.mHistoryMap;
            kotlin.jvm.internal.m.c(map);
            String str3 = map.get(str2);
            try {
                kotlin.jvm.internal.m.c(str3);
                List<String> listG = new ua.l(",").g(str3, 0);
                if (!listG.isEmpty()) {
                    ListIterator<String> listIterator = listG.listIterator(listG.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            listL = kotlin.collections.r.l();
                            break;
                        } else if (listIterator.previous().length() != 0) {
                            listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                } else {
                    listL = kotlin.collections.r.l();
                    break;
                }
                String[] strArr = (String[]) listL.toArray(new String[0]);
                i10 = Integer.parseInt(strArr[0]);
                try {
                    i11 = Integer.parseInt(strArr[1]);
                } catch (Exception unused) {
                    i11 = 0;
                }
            } catch (Exception unused2) {
                i10 = 0;
            }
            int iW1 = W1();
            if (iW1 < 0 || !(this.hasChangeCategory || this.isChangeChannel)) {
                ProgramListView programListView6 = this.mProgramListView;
                if (programListView6 != null) {
                    programListView6.setSelectionFromTop(i10, i11);
                }
            } else {
                ProgramListView programListView7 = this.mProgramListView;
                if (programListView7 != null) {
                    programListView7.setSelection(iW1);
                }
                Map<String, String> map2 = this.mHistoryMap;
                kotlin.jvm.internal.m.c(map2);
                map2.put(str2, iW1 + ",0");
            }
            Map<String, String> map3 = this.mHistoryMap;
            kotlin.jvm.internal.m.c(map3);
            String str4 = map3.get(str2);
            try {
                kotlin.jvm.internal.m.c(str4);
                String strSubstring = str4.substring(0, ua.n.b0(str4, ",", 0, false, 6, null));
                kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
                try {
                    if (!TextUtils.isEmpty(strSubstring)) {
                        str = strSubstring;
                    }
                } catch (Exception e10) {
                    e = e10;
                    str = strSubstring;
                    e.printStackTrace();
                }
            } catch (Exception e11) {
                e = e11;
            }
            int i12 = Integer.parseInt(str) + 1;
            TextView textView11 = this.mTextCurrentPos;
            kotlin.jvm.internal.m.c(textView11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i12);
            textView11.setText(sb2.toString());
        }
        b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c3() {
        List<String> list = M2;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            if (list.size() <= this.mCategorySelect) {
                return;
            }
            com.live.evo.util.s0 s0Var = com.live.evo.util.s0.f7342a;
            if (s0Var.R()) {
                TextView textView = this.mTvNotData;
                if (textView != null) {
                    textView.setVisibility(0);
                }
                TextView textView2 = this.mTvNotData;
                if (textView2 != null) {
                    textView2.setText(com.live.evo.util.x1.j(R$string.catchup_init_remind));
                    return;
                }
                return;
            }
            TextView textView3 = this.mTvNotData;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            HashMap<String, List<i5.h>> map = O2;
            kotlin.jvm.internal.m.c(map);
            List<String> list2 = M2;
            kotlin.jvm.internal.m.c(list2);
            if (map.get(list2.get(this.mCategorySelect)) != null) {
                HashMap<String, List<i5.h>> map2 = O2;
                kotlin.jvm.internal.m.c(map2);
                List<String> list3 = M2;
                kotlin.jvm.internal.m.c(list3);
                List<i5.h> list4 = map2.get(list3.get(this.mCategorySelect));
                kotlin.jvm.internal.m.c(list4);
                if (list4.size() > this.mProgramSelect) {
                    HashMap<String, List<i5.h>> map3 = O2;
                    kotlin.jvm.internal.m.c(map3);
                    List<String> list5 = M2;
                    kotlin.jvm.internal.m.c(list5);
                    List<i5.h> list6 = map3.get(list5.get(this.mCategorySelect));
                    kotlin.jvm.internal.m.c(list6);
                    final i5.h hVar = list6.get(this.mProgramSelect);
                    TextView textView4 = this.mEpgChannel;
                    kotlin.jvm.internal.m.c(textView4);
                    kotlin.jvm.internal.m.c(hVar);
                    textView4.setText(hVar.e());
                    s0Var.B(hVar.f(), new c9.l() { // from class: com.live.evo.fragment.l
                        @Override // c9.l
                        public final Object invoke(Object obj) {
                            return x.d3(hVar, ((Integer) obj).intValue());
                        }
                    });
                    this.mEpgShowFirst = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z d3(i5.h hVar, int i10) {
        com.live.evo.osd.persenter.a aVar = Q2;
        if (aVar != null) {
            aVar.q(hVar.f(), i10, hVar.b());
        }
        return r8.z.f17874a;
    }

    private final void e3(List<? extends i5.h> listVodVideo) {
        n5.o oVar = this.mProgramAdapter;
        if (oVar == null || oVar == null) {
            return;
        }
        oVar.c(listVodVideo, this.playAllPos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(x xVar, int i10, ValueAnimator animation) {
        ViewGroup.LayoutParams layoutParams;
        kotlin.jvm.internal.m.f(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        kotlin.jvm.internal.m.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        View view = xVar.mCategoryParent;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.width = i10 - (iIntValue * 10);
        }
        View view2 = xVar.mCategoryParent;
        if (view2 != null) {
            view2.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(x xVar, ValueAnimator animation) {
        ViewGroup.LayoutParams layoutParams;
        kotlin.jvm.internal.m.f(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        kotlin.jvm.internal.m.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) animatedValue).intValue();
        View view = xVar.mCategoryParent;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.width = iIntValue * 10;
        }
        View view2 = xVar.mCategoryParent;
        if (view2 != null) {
            view2.requestLayout();
        }
    }

    private final void g3(i5.p bean, int status) {
        if (status <= 0) {
            Q2(bean);
            return;
        }
        i5.c0 c0VarJ = com.live.evo.util.s0.f7342a.J(bean, this.curChannelId);
        if (c0VarJ != null) {
            com.live.evo.osd.u.f7147a.o(bean, c0VarJ, new l(c0VarJ, this, bean));
        } else {
            Q2(bean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(x xVar, ValueAnimator animation) {
        ViewGroup.LayoutParams layoutParams;
        kotlin.jvm.internal.m.f(animation, "animation");
        LinearLayout linearLayout = xVar.mEpgParent;
        if (linearLayout != null && (layoutParams = linearLayout.getLayoutParams()) != null) {
            Object animatedValue = animation.getAnimatedValue();
            kotlin.jvm.internal.m.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            layoutParams.width = ((Integer) animatedValue).intValue();
        }
        LinearLayout linearLayout2 = xVar.mEpgParent;
        if (linearLayout2 != null) {
            linearLayout2.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(x xVar, int i10, ValueAnimator animation) {
        ViewGroup.LayoutParams layoutParams;
        kotlin.jvm.internal.m.f(animation, "animation");
        LinearLayout linearLayout = xVar.mEpgParent;
        if (linearLayout != null && (layoutParams = linearLayout.getLayoutParams()) != null) {
            Object animatedValue = animation.getAnimatedValue();
            kotlin.jvm.internal.m.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            layoutParams.width = i10 - ((Integer) animatedValue).intValue();
        }
        LinearLayout linearLayout2 = xVar.mEpgParent;
        if (linearLayout2 != null) {
            linearLayout2.requestLayout();
        }
    }

    private final void k2() {
        List<String> list = M2;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            list.clear();
        }
        List<String> list2 = N2;
        if (list2 != null) {
            kotlin.jvm.internal.m.c(list2);
            if (list2.size() <= 0) {
                return;
            }
            E2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(x xVar) {
        ProgramListView programListView;
        ProgramListView programListView2 = xVar.mCategoryListView;
        boolean z10 = false;
        int firstVisiblePosition = ((programListView2 != null ? programListView2.getFirstVisiblePosition() : 0) < 0 || (programListView = xVar.mCategoryListView) == null) ? 0 : programListView.getFirstVisiblePosition();
        int i10 = xVar.playCategory;
        if (i10 - firstVisiblePosition >= 0) {
            i10 -= firstVisiblePosition;
        }
        com.live.evo.osd.m mVar = xVar.mCategoryAdapter;
        if (mVar != null) {
            ProgramListView programListView3 = xVar.mCategoryListView;
            if (programListView3 != null && programListView3.isFocused()) {
                z10 = true;
            }
            mVar.b(i10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(x xVar, View view, boolean z10) {
        n5.o oVar;
        if (z10 && (oVar = xVar.mProgramAdapter) != null) {
            ProgramListView programListView = xVar.mProgramListView;
            oVar.e(programListView != null ? programListView.getSelectedView() : null, z10);
        }
        com.live.evo.osd.m mVar = xVar.mCategoryAdapter;
        if (mVar != null) {
            ProgramListView programListView2 = xVar.mCategoryListView;
            mVar.b(programListView2 != null ? programListView2.getSelectedItemPosition() : 0, z10);
        }
        xVar.V2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(x xVar, View view, boolean z10) {
        View selectedView;
        n5.o oVar;
        ProgramListView programListView = xVar.mProgramListView;
        if (programListView == null || (selectedView = programListView.getSelectedView()) == null) {
            return;
        }
        if (!xVar.isChannelHistoryLive && (oVar = xVar.mProgramAdapter) != null) {
            oVar.e(selectedView, z10);
        }
        if (z10 && com.live.evo.util.e.b().f()) {
            List<? extends i5.h> list = xVar.mListVodVideo;
            kotlin.jvm.internal.m.c(list);
            list.size();
        }
        if (z10) {
            xVar.P2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(x xVar, View view, boolean z10) {
        com.live.evo.osd.b bVar;
        if (xVar.tempEpgList == null || z10 || (bVar = xVar.mEpgAdapter) == null) {
            return;
        }
        bVar.b(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(x xVar, View view, boolean z10) {
        if (z10) {
            n5.b bVar = xVar.epgDateAdapter;
            if (bVar != null) {
                bVar.f(bVar != null ? bVar.b() : 0);
                return;
            }
            return;
        }
        n5.b bVar2 = xVar.epgDateAdapter;
        if (bVar2 != null) {
            bVar2.f(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(x xVar, AdapterView adapterView, View view, int i10, long j10) {
        try {
            List<? extends i5.h> list = xVar.mListVodVideo;
            kotlin.jvm.internal.m.c(list);
            i5.h hVar = list.get(i10);
            kotlin.jvm.internal.m.c(hVar);
            int i11 = hVar.i();
            com.live.evo.osd.persenter.a aVar = Q2;
            kotlin.jvm.internal.m.c(aVar);
            if (aVar.g() == i11) {
                com.live.evo.util.r1.a(xVar.getActivity(), R$string.is_playing);
                return;
            }
            xVar.mProgramSelect = i10;
            xVar.playCategory = xVar.mCategorySelect;
            com.live.evo.osd.persenter.a aVar2 = Q2;
            kotlin.jvm.internal.m.c(aVar2);
            aVar2.o(xVar.mCategorySelect, xVar.mProgramSelect, i11, MessageOriginChannel.MESSAGE_ORIGIN_TYPE);
            xVar.p(i11);
            xVar.isChangeChannel = true;
            if (xVar.Q1()) {
                xVar.isChannelHistoryLive = true;
            }
            com.live.evo.osd.persenter.a aVar3 = Q2;
            kotlin.jvm.internal.m.c(aVar3);
            aVar3.hide();
        } catch (Exception e10) {
            q6.b logger = xVar.logger;
            kotlin.jvm.internal.m.e(logger, "logger");
            c5.b.b(logger, "Change channel err", e10);
        }
    }

    private final void x2() {
        if (this.title == null) {
            return;
        }
        boolean zJ = com.live.evo.l.n().j("category_is_upcase", true);
        if (com.live.evo.l.n().y()) {
            String strJ = com.live.evo.util.x1.j(R$string.adult_key_title);
            kotlin.jvm.internal.m.e(strJ, "getString(...)");
            if (zJ) {
                Locale locale = Locale.getDefault();
                kotlin.jvm.internal.m.e(locale, "getDefault(...)");
                strJ = strJ.toUpperCase(locale);
                kotlin.jvm.internal.m.e(strJ, "toUpperCase(...)");
            }
            TextView textView = this.title;
            kotlin.jvm.internal.m.c(textView);
            textView.setText(strJ);
            RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText = this.etPassword;
            String strJ2 = com.live.evo.util.x1.j(R$string.adult_key_pwd_hint2);
            kotlin.jvm.internal.m.e(strJ2, "getString(...)");
            N2(removeKeyCodeEnterEditText, strJ2, 18);
            String strJ3 = com.live.evo.util.x1.j(R$string.adult_key_again_hint);
            kotlin.jvm.internal.m.e(strJ3, "getString(...)");
            TextView textView2 = this.hint;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setText(strJ3);
        } else {
            String strJ4 = com.live.evo.util.x1.j(R$string.adult_key_title);
            kotlin.jvm.internal.m.e(strJ4, "getString(...)");
            if (zJ) {
                Locale locale2 = Locale.getDefault();
                kotlin.jvm.internal.m.e(locale2, "getDefault(...)");
                strJ4 = strJ4.toUpperCase(locale2);
                kotlin.jvm.internal.m.e(strJ4, "toUpperCase(...)");
            }
            TextView textView3 = this.title;
            kotlin.jvm.internal.m.c(textView3);
            textView3.setText(strJ4);
            RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText2 = this.etPassword;
            String strJ5 = com.live.evo.util.x1.j(R$string.adult_key_pwd_hint);
            kotlin.jvm.internal.m.e(strJ5, "getString(...)");
            N2(removeKeyCodeEnterEditText2, strJ5, 18);
            TextView textView4 = this.hint;
            if (textView4 != null) {
                textView4.setText(R$string.adult_key_first_hint);
            }
        }
        RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText3 = this.etPassword;
        if (removeKeyCodeEnterEditText3 != null) {
            removeKeyCodeEnterEditText3.setText("");
        }
    }

    private final void y2() {
        List listL;
        ProgramListView programListView = this.mProgramListView;
        if (programListView != null) {
            programListView.requestFocus();
        }
        RelativeLayout relativeLayout = this.mAdultKeyParent;
        kotlin.jvm.internal.m.c(relativeLayout);
        if (relativeLayout.getVisibility() == 0) {
            RelativeLayout relativeLayout2 = this.mAdultKeyParent;
            kotlin.jvm.internal.m.c(relativeLayout2);
            relativeLayout2.setVisibility(8);
        }
        RelativeLayout relativeLayout3 = this.mChannelParent;
        kotlin.jvm.internal.m.c(relativeLayout3);
        if (relativeLayout3.getVisibility() != 0) {
            RelativeLayout relativeLayout4 = this.mChannelParent;
            kotlin.jvm.internal.m.c(relativeLayout4);
            relativeLayout4.setVisibility(0);
        }
        List<? extends i5.h> list = this.mListVodVideo;
        if (list != null) {
            kotlin.jvm.internal.m.c(list);
            if (list.size() > 0) {
                ProgramListView programListView2 = this.mProgramListView;
                if (programListView2 != null) {
                    programListView2.setVisibility(0);
                }
                RelativeLayout relativeLayout5 = this.mAdultKeyParent;
                kotlin.jvm.internal.m.c(relativeLayout5);
                if (relativeLayout5.getVisibility() == 0) {
                    RelativeLayout relativeLayout6 = this.mAdultKeyParent;
                    kotlin.jvm.internal.m.c(relativeLayout6);
                    relativeLayout6.setVisibility(8);
                }
                RelativeLayout relativeLayout7 = this.mChannelParent;
                kotlin.jvm.internal.m.c(relativeLayout7);
                if (relativeLayout7.getVisibility() != 0) {
                    RelativeLayout relativeLayout8 = this.mChannelParent;
                    kotlin.jvm.internal.m.c(relativeLayout8);
                    relativeLayout8.setVisibility(0);
                }
                int i10 = this.mCategorySelect;
                q6.b logger = this.logger;
                kotlin.jvm.internal.m.e(logger, "logger");
                c5.b.a(logger, "onItemSelected: position=" + i10 + "  mclassifySelect=" + this.mCategorySelect);
                List<String> list2 = M2;
                kotlin.jvm.internal.m.c(list2);
                String str = list2.get(this.mCategorySelect);
                Map<String, String> map = this.mHistoryMap;
                kotlin.jvm.internal.m.c(map);
                String str2 = map.get(str);
                kotlin.jvm.internal.m.c(str2);
                List<String> listG = new ua.l(",").g(str2, 0);
                if (!listG.isEmpty()) {
                    ListIterator<String> listIterator = listG.listIterator(listG.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            listL = kotlin.collections.r.l();
                            break;
                        } else if (listIterator.previous().length() != 0) {
                            listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                } else {
                    listL = kotlin.collections.r.l();
                    break;
                }
                String[] strArr = (String[]) listL.toArray(new String[0]);
                int i11 = Integer.parseInt(strArr[0]);
                int iW1 = W1();
                if (iW1 < 0 || !(this.hasChangeCategory || this.isChangeChannel)) {
                    ProgramListView programListView3 = this.mProgramListView;
                    if (programListView3 != null) {
                        programListView3.setSelectionFromTop(i11, Integer.parseInt(strArr[1]));
                    }
                } else {
                    ProgramListView programListView4 = this.mProgramListView;
                    if (programListView4 != null) {
                        programListView4.setSelection(iW1);
                    }
                    Map<String, String> map2 = this.mHistoryMap;
                    kotlin.jvm.internal.m.c(map2);
                    map2.put(str, iW1 + ",0");
                }
                Map<String, String> map3 = this.mHistoryMap;
                kotlin.jvm.internal.m.c(map3);
                String str3 = map3.get(str);
                kotlin.jvm.internal.m.c(str3);
                String strSubstring = str3.substring(0, ua.n.b0(str3, ",", 0, false, 6, null));
                kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
                int i12 = Integer.parseInt(TextUtils.isEmpty(strSubstring) ? "0" : strSubstring) + 1;
                TextView textView = this.mTextCurrentPos;
                kotlin.jvm.internal.m.c(textView);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i12);
                textView.setText(sb2.toString());
                ProgramListView programListView5 = this.mProgramListView;
                if (programListView5 != null) {
                    programListView5.requestFocus();
                    return;
                }
                return;
            }
        }
        ProgramListView programListView6 = this.mProgramListView;
        if (programListView6 != null) {
            programListView6.setVisibility(8);
        }
        TextView textView2 = this.mTextCurrentPos;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setText("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2() {
        t.v.c.i.a.f18646a.u0(false, true);
    }

    public final void B2() {
        List<? extends i5.h> list;
        List<String> list2;
        ProgramListView programListView = this.mCategoryListView;
        if (programListView == null || !this.mIsCategoryOpen) {
            if (this.mProgramListView == null || (list = this.mListVodVideo) == null) {
                return;
            }
            kotlin.jvm.internal.m.c(list);
            if (list.size() == 0) {
                return;
            }
            ProgramListView programListView2 = this.mProgramListView;
            if (programListView2 != null) {
                programListView2.requestFocus();
            }
            ProgramListView programListView3 = this.mProgramListView;
            if (programListView3 != null) {
                programListView3.setSelection(0);
            }
            this.mProgramSelect = 0;
            M2(this.mProgramListView);
            return;
        }
        if (programListView == null || (list2 = M2) == null) {
            return;
        }
        kotlin.jvm.internal.m.c(list2);
        if (list2.size() == 0) {
            return;
        }
        ProgramListView programListView4 = this.mCategoryListView;
        if (programListView4 != null) {
            programListView4.requestFocus();
        }
        ProgramListView programListView5 = this.mCategoryListView;
        if (programListView5 != null) {
            programListView5.setSelection(0);
        }
        this.mCategorySelect = 0;
        M2(this.mCategoryListView);
    }

    public final void D2() {
        View view = this.focusView;
        if (view == null) {
            return;
        }
        ProgramListView programListView = this.mCategoryListView;
        if (view != programListView) {
            ProgramListView programListView2 = this.mProgramListView;
            if (view != programListView2) {
                ProgramListView programListView3 = this.mLvEpgDate;
                if (view != programListView3) {
                    ProgramListView programListView4 = this.mEpgListView;
                    if (view == programListView4) {
                        if (programListView4 != null) {
                            programListView4.requestFocus();
                        }
                    } else if (programListView == null || !this.mIsCategoryOpen) {
                        if (programListView2 != null && programListView2 != null) {
                            programListView2.requestFocus();
                        }
                    } else if (programListView != null) {
                        programListView.requestFocus();
                    }
                } else if (programListView3 != null) {
                    programListView3.requestFocus();
                }
            } else if (programListView2 != null) {
                programListView2.requestFocus();
            }
        } else if (programListView != null) {
            programListView.requestFocus();
        }
        this.isChannelHistoryLive = false;
    }

    @Override // com.live.evo.osd.persenter.b
    public void E() {
        n5.o oVar = this.mProgramAdapter;
        if (oVar == null || oVar == null) {
            return;
        }
        oVar.b();
    }

    @Override // com.live.evo.osd.persenter.b
    public void F(b5.h savePlayHistoryEvent) {
        if (savePlayHistoryEvent == null) {
            return;
        }
        this.playCategory = savePlayHistoryEvent.f912a;
        this.playChannel = savePlayHistoryEvent.f913b;
        int i10 = savePlayHistoryEvent.f914c;
        this.playAllPos = i10;
        n5.o oVar = this.mProgramAdapter;
        if (oVar != null && oVar != null) {
            oVar.d(i10);
        }
        q6.b logger = this.logger;
        kotlin.jvm.internal.m.e(logger, "logger");
        c5.b.a(logger, " RxBusPlayHistory: " + this.playCategory + "," + this.playChannel + "," + this.playAllPos);
    }

    @Override // com.live.evo.osd.persenter.b
    public void I() {
        com.live.evo.util.k1.f7250a.c(new Runnable() { // from class: com.live.evo.fragment.w
            @Override // java.lang.Runnable
            public final void run() {
                x.X1(this.f6853a);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0066  */
    @Override // com.live.evo.osd.persenter.b
    public void L(List<? extends i5.p> epgBeen, String channelId) {
        boolean z10;
        kotlin.jvm.internal.m.f(epgBeen, "epgBeen");
        kotlin.jvm.internal.m.f(channelId, "channelId");
        this.curChannelId = channelId;
        q6.b logger = this.logger;
        kotlin.jvm.internal.m.e(logger, "logger");
        c5.b.a(logger, "fetchEpgData query epgBean = " + epgBeen.size());
        List<i5.p> list = this.curChannelEpgList;
        kotlin.jvm.internal.m.c(list);
        list.clear();
        List<i5.p> list2 = this.curChannelEpgList;
        kotlin.jvm.internal.m.c(list2);
        list2.addAll(epgBeen);
        n5.b bVar = this.epgDateAdapter;
        this.mNowPlayingIndex = L2(bVar != null ? bVar.c() : 0);
        n5.b bVar2 = this.epgDateAdapter;
        if (bVar2 != null) {
            int iC = bVar2 != null ? bVar2.c() : 0;
            ProgramListView programListView = this.mLvEpgDate;
            if (programListView != null) {
                z10 = programListView.isFocused();
            }
            bVar2.d(iC, z10);
        }
        List<i5.p> list3 = this.tempEpgList;
        kotlin.jvm.internal.m.c(list3);
        if (list3.size() <= 0) {
            if (!this.mEpgShowFirst) {
                ProgramListView programListView2 = this.mLvEpgDate;
                if (programListView2 != null) {
                    programListView2.requestFocus();
                }
                ProgramListView programListView3 = this.mLvEpgDate;
                if (programListView3 != null) {
                    n5.b bVar3 = this.epgDateAdapter;
                    programListView3.setSelection(bVar3 != null ? bVar3.c() : 0);
                }
            }
            com.live.evo.osd.b bVar4 = this.mEpgAdapter;
            if (bVar4 != null) {
                bVar4.notifyDataSetChanged();
                return;
            }
            return;
        }
        int i10 = this.mNowPlayingIndex;
        int i11 = i10 >= 0 ? i10 : 0;
        ProgramListView programListView4 = this.mEpgListView;
        if (programListView4 != null) {
            programListView4.setSelection(i11);
        }
        if (this.mEpgShowFirst) {
            return;
        }
        ProgramListView programListView5 = this.mEpgListView;
        if (programListView5 != null) {
            programListView5.requestFocus();
        }
        com.live.evo.osd.b bVar5 = this.mEpgAdapter;
        if (bVar5 != null) {
            bVar5.b(i11);
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void M(String id2) {
        TextView textView = this.mTextCurrentPos;
        if (textView != null) {
            kotlin.jvm.internal.m.c(textView);
            textView.setText(id2);
        }
    }

    public final void T2() {
        View view;
        ProgramListView programListView;
        if (this.mIsCategoryOpen) {
            return;
        }
        ValueAnimator valueAnimator = this.categoryAnimOpen;
        kotlin.jvm.internal.m.c(valueAnimator);
        valueAnimator.start();
        this.mIsCategoryOpen = true;
        LinearLayout linearLayout = this.mEpgParent;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view2 = this.mCategoryParent;
        if ((view2 == null || view2.getVisibility() != 0) && (view = this.mCategoryParent) != null) {
            view.setVisibility(0);
        }
        ProgramListView programListView2 = this.mCategoryListView;
        if ((programListView2 != null ? Integer.valueOf(programListView2.getVisibility()) : null) != 0 && (programListView = this.mCategoryListView) != null) {
            programListView.setVisibility(0);
        }
        if (P1()) {
            LinearLayout linearLayout2 = this.mIvRightLayout;
            kotlin.jvm.internal.m.c(linearLayout2);
            linearLayout2.setVisibility(8);
        } else {
            LinearLayout linearLayout3 = this.mIvRightLayout;
            kotlin.jvm.internal.m.c(linearLayout3);
            linearLayout3.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: V1, reason: from getter */
    public final ziyi.kit.keyboard.b getKeyboardView() {
        return this.keyboardView;
    }

    @Override // l5.b
    protected void d0() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        if (!com.live.evo.a.f5181a) {
            View view = this.mCategoryParent;
            if (view != null && (layoutParams2 = view.getLayoutParams()) != null) {
                layoutParams2.width = 0;
            }
            View view2 = this.mCategoryParent;
            if (view2 != null) {
                view2.requestLayout();
            }
        }
        LinearLayout linearLayout = this.mEpgParent;
        if (linearLayout != null && (layoutParams = linearLayout.getLayoutParams()) != null) {
            layoutParams.width = 0;
        }
        ProgramListView programListView = this.mProgramListView;
        if (programListView != null) {
            programListView.setOnItemClickListener(this.mProgramItemClickListener);
        }
        ProgramListView programListView2 = this.mProgramListView;
        if (programListView2 != null) {
            programListView2.setOnItemSelectedListener(this.mProgramItemSelectListener);
        }
        ProgramListView programListView3 = this.mProgramListView;
        if (programListView3 != null) {
            programListView3.setOnKeyListener(this);
        }
        ProgramListView programListView4 = this.mCategoryListView;
        if (programListView4 != null) {
            programListView4.setOnKeyListener(this);
        }
        TextView textView = this.mTvNotData;
        if (textView != null) {
            textView.setOnKeyListener(this);
        }
        ProgramListView programListView5 = this.mEpgListView;
        if (programListView5 != null) {
            programListView5.setOnKeyListener(this);
        }
        ProgramListView programListView6 = this.mLvEpgDate;
        if (programListView6 != null) {
            programListView6.setOnKeyListener(this);
        }
        RemoveKeyCodeEnterEditText removeKeyCodeEnterEditText = this.etPassword;
        if (removeKeyCodeEnterEditText != null) {
            removeKeyCodeEnterEditText.setOnKeyListener(this);
        }
        ProgramListView programListView7 = this.mCategoryListView;
        if (programListView7 != null) {
            programListView7.setOnItemSelectedListener(new f());
        }
        ProgramListView programListView8 = this.mCategoryListView;
        if (programListView8 != null) {
            programListView8.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.r
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view3, boolean z10) {
                    x.m2(this.f6559a, view3, z10);
                }
            });
        }
        ProgramListView programListView9 = this.mProgramListView;
        if (programListView9 != null) {
            programListView9.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.s
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view3, boolean z10) {
                    x.n2(this.f6625a, view3, z10);
                }
            });
        }
        ProgramListView programListView10 = this.mEpgListView;
        if (programListView10 != null) {
            programListView10.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.t
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view3, boolean z10) {
                    x.o2(this.f6786a, view3, z10);
                }
            });
        }
        ProgramListView programListView11 = this.mEpgListView;
        if (programListView11 != null) {
            programListView11.setOnItemSelectedListener(new g());
        }
        ProgramListView programListView12 = this.mLvEpgDate;
        if (programListView12 != null) {
            programListView12.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.u
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view3, boolean z10) {
                    x.p2(this.f6820a, view3, z10);
                }
            });
        }
        ProgramListView programListView13 = this.mLvEpgDate;
        if (programListView13 != null) {
            programListView13.setOnItemSelectedListener(new h());
        }
        q2();
    }

    @Override // l5.b
    protected void f0(View mRoot) {
        LinearLayout linearLayout;
        kotlin.jvm.internal.m.f(mRoot, "mRoot");
        this.mView = mRoot;
        this.mCategoryListView = (ProgramListView) mRoot.findViewById(R$id.programviewl_lv_main_program_listview_classify);
        this.mProgramListView = (ProgramListView) mRoot.findViewById(R$id.programviewl_lv_main_program_listview);
        this.mTextViewTotalProg = (TextView) mRoot.findViewById(R$id.programviewl_tv_program_all_num);
        if (com.live.evo.l.n().j("pip_on_channel", true)) {
            this.mPreviewContainer = (RelativeLayout) mRoot.findViewById(R$id.programviewl_preview_container);
        }
        this.mChannelParent = (RelativeLayout) mRoot.findViewById(R$id.programviewl_rl_program);
        this.mCategoryLayout = (LinearLayout) mRoot.findViewById(R$id.programviewl_ll_clssify_layout);
        this.mAdultKeyParent = (RelativeLayout) mRoot.findViewById(R$id.programviewl_rl_adult);
        this.mTextCategoryName = (TextView) mRoot.findViewById(R$id.programviewl_tv_clssify_name);
        this.mLayoutBanner = (RelativeLayout) mRoot.findViewById(R$id.programviewl_ll_layout_channel_banner);
        this.mBanner = (Banner) mRoot.findViewById(R$id.programviewl_bn_channel_banner);
        this.mTextPosition = (TextView) mRoot.findViewById(R$id.programviewl_tv_program_position);
        this.mTextProgramTotal = (TextView) mRoot.findViewById(R$id.programviewl_tv_program_position_total);
        this.mSessionId = (TextView) mRoot.findViewById(R$id.programviewl_tv_sessionid);
        this.mTextPipTip = (TextView) mRoot.findViewById(R$id.programviewl_tv_piptip);
        this.mEpgListParent = (RelativeLayout) mRoot.findViewById(R$id.programviewl_rl_epg_list);
        this.mEpgListView = (ProgramListView) mRoot.findViewById(R$id.programviewl_lv_epg_listview);
        this.mIvRightLayout = (LinearLayout) mRoot.findViewById(R$id.programviewl_ll_layout_arrowright);
        this.mIvRight = (ImageView) mRoot.findViewById(R$id.programviewl_iv_right);
        TextView textView = (TextView) mRoot.findViewById(R$id.programviewl_tv_clssify_name_no_classify);
        this.mTextCurrentPos = (TextView) mRoot.findViewById(R$id.programviewl_tv_program_current_position);
        this.mEpgParent = (LinearLayout) mRoot.findViewById(R$id.programviewl_ll_epg_parent);
        this.mEpgDesc = (TextView) mRoot.findViewById(R$id.epgdesc_tv_epg_desc);
        this.mEpgTime = (TextView) mRoot.findViewById(R$id.epgdesc_tv_epg_time);
        this.mEpgProgramName = (TextView) mRoot.findViewById(R$id.epgdesc_tv_epg_channel_name);
        this.mEpgChannel = (TextView) mRoot.findViewById(R$id.programviewl_tv_epg_channel);
        this.mEpgDuration = (TextView) mRoot.findViewById(R$id.programviewl_tv_epg_duration);
        this.mEpgProgram = (TextView) mRoot.findViewById(R$id.programviewl_tv_epg_program);
        this.mEpgDescription = (TextView) mRoot.findViewById(R$id.programviewl_tv_epg_description);
        this.mTvDuration = (TextView) mRoot.findViewById(R$id.programviewl_tv_duration);
        this.mTvProgram = (TextView) mRoot.findViewById(R$id.programviewl_tv_program);
        this.mCategoryBannerParent = (RelativeLayout) mRoot.findViewById(R$id.programviewl_rl_banner_parent);
        this.mCategoryBanner = (Banner) mRoot.findViewById(R$id.programviewl_bn_banner);
        com.live.evo.l.n().g("category_ad_interval", 3000);
        this.mCategoryBannerFrontPic = (ImageView) mRoot.findViewById(R$id.programviewl_categoryly_iv_front);
        this.mCategoryBannerDesc = (TextView) mRoot.findViewById(R$id.programviewl_categoryly_tv_desc);
        this.mTvNotData = (TextView) mRoot.findViewById(R$id.programviewl_tv_not_data);
        this.mCategoryParent = mRoot.findViewById(R$id.programviewl_rly_classify_parent);
        this.mEpgListView = (ProgramListView) mRoot.findViewById(R$id.programviewl_lv_epg_listview);
        this.mLvEpgDate = (ProgramListView) mRoot.findViewById(R$id.programviewl_lv_epg_date);
        this.mTvMonth = (TextView) mRoot.findViewById(R$id.programviewl_tv_month);
        this.mIvUp = (ImageView) mRoot.findViewById(R$id.programviewl_iv_dateup);
        this.mIvDown = (ImageView) mRoot.findViewById(R$id.programviewl_iv_image_datedown);
        if (com.live.evo.a.f5181a) {
            ProgramListView programListView = this.mCategoryListView;
            if (programListView != null) {
                programListView.setVisibility(0);
            }
            LinearLayout linearLayout2 = this.mCategoryLayout;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        } else {
            textView.setVisibility(0);
        }
        if (!U2() && (linearLayout = this.mIvRightLayout) != null) {
            linearLayout.setVisibility(8);
        }
        ProgramListView programListView2 = this.mLvEpgDate;
        if (programListView2 != null) {
            programListView2.setNextFocusLeftId(R$id.programviewl_lv_main_program_listview);
        }
        ProgramListView programListView3 = this.mLvEpgDate;
        if (programListView3 != null) {
            programListView3.setNextFocusRightId(R$id.programviewl_lv_epg_listview);
        }
        ProgramListView programListView4 = this.mLvEpgDate;
        if (programListView4 != null) {
            programListView4.setNextFocusUpId(R$id.programviewl_lv_epg_date);
        }
        ProgramListView programListView5 = this.mLvEpgDate;
        if (programListView5 != null) {
            programListView5.setNextFocusDownId(R$id.programviewl_lv_epg_date);
        }
        ProgramListView programListView6 = this.mProgramListView;
        if (programListView6 != null) {
            programListView6.setNextFocusRightId(R$id.programviewl_lv_epg_listview);
        }
        ProgramListView programListView7 = this.mProgramListView;
        if (programListView7 != null) {
            programListView7.setNextFocusLeftId(R$id.programviewl_lv_main_program_listview_classify);
        }
        ProgramListView programListView8 = this.mProgramListView;
        if (programListView8 != null) {
            programListView8.setNextFocusUpId(R$id.programviewl_lv_main_program_listview);
        }
        ProgramListView programListView9 = this.mProgramListView;
        if (programListView9 != null) {
            programListView9.setNextFocusDownId(R$id.programviewl_lv_main_program_listview);
        }
        ProgramListView programListView10 = this.mCategoryListView;
        if (programListView10 != null) {
            programListView10.setNextFocusRightId(R$id.programviewl_lv_main_program_listview);
        }
        ProgramListView programListView11 = this.mCategoryListView;
        if (programListView11 != null) {
            programListView11.setNextFocusUpId(R$id.programviewl_lv_main_program_listview_classify);
        }
        ProgramListView programListView12 = this.mCategoryListView;
        if (programListView12 != null) {
            programListView12.setNextFocusDownId(R$id.programviewl_lv_main_program_listview_classify);
        }
        ProgramListView programListView13 = this.mEpgListView;
        if (programListView13 != null) {
            programListView13.setNextFocusLeftId(R$id.programviewl_lv_epg_date);
        }
        ProgramListView programListView14 = this.mEpgListView;
        if (programListView14 != null) {
            programListView14.setNextFocusUpId(R$id.programviewl_lv_epg_listview);
        }
        ProgramListView programListView15 = this.mEpgListView;
        if (programListView15 != null) {
            programListView15.setNextFocusDownId(R$id.programviewl_lv_epg_listview);
        }
        RelativeLayout relativeLayout = this.mAdultKeyParent;
        if (relativeLayout != null) {
            relativeLayout.setNextFocusLeftId(R$id.programviewl_lv_main_program_listview_classify);
        }
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.b(this.mTextCategoryName);
            com.live.evo.util.t.b(this.mTextPosition);
            com.live.evo.util.t.b(this.mTextProgramTotal);
            com.live.evo.util.t.b(this.mSessionId);
            com.live.evo.util.t.b(this.mTvMonth);
            com.live.evo.util.t.c(this.mTvDuration);
            com.live.evo.util.t.c(this.mTvProgram);
            com.live.evo.util.t.b(this.mEpgDesc);
            com.live.evo.util.t.b(this.mEpgDesc);
            com.live.evo.util.t.b(this.mEpgTime);
            com.live.evo.util.t.b(this.mEpgProgramName);
            com.live.evo.util.t.b(this.mEpgChannel);
            com.live.evo.util.t.b(this.mEpgDuration);
            com.live.evo.util.t.b(this.mEpgProgram);
            com.live.evo.util.t.b(this.mEpgDescription);
            com.live.evo.util.t.b(this.mTvNotData);
        } else {
            com.live.evo.util.t.a(this.mTextCategoryName);
            com.live.evo.util.t.a(this.mTextPosition);
            com.live.evo.util.t.b(this.mTextProgramTotal);
            com.live.evo.util.t.b(this.mSessionId);
            com.live.evo.util.t.b(this.mTvMonth);
            com.live.evo.util.t.b(this.mEpgDesc);
            com.live.evo.util.t.b(this.mEpgTime);
            com.live.evo.util.t.b(this.mEpgProgramName);
            com.live.evo.util.t.b(this.mEpgChannel);
            com.live.evo.util.t.b(this.mEpgDuration);
            com.live.evo.util.t.b(this.mEpgProgram);
            com.live.evo.util.t.b(this.mEpgDescription);
            com.live.evo.util.t.d(this.mTvNotData);
        }
        if (com.live.evo.l.n().E()) {
            ProgramListView programListView16 = this.mCategoryListView;
            if (programListView16 != null) {
                programListView16.setSelector(R$drawable.program_adult_selector);
            }
            ProgramListView programListView17 = this.mProgramListView;
            if (programListView17 != null) {
                programListView17.setSelector(R$drawable.program_adult_selector);
            }
        }
        int i10 = TextUtils.equals(com.live.evo.util.x1.j(R$string.epgdate_arrowup_show), "show") ? 0 : 8;
        ImageView imageView = this.mIvUp;
        if (imageView != null) {
            imageView.setVisibility(i10);
        }
        ImageView imageView2 = this.mIvDown;
        if (imageView2 != null) {
            imageView2.setVisibility(i10);
        }
        d2(mRoot);
        s2();
        ProgramListView programListView18 = this.mCategoryListView;
        if (programListView18 != null) {
            programListView18.setOnKeyListener(this);
        }
        ProgramListView programListView19 = this.mProgramListView;
        if (programListView19 != null) {
            programListView19.setOnKeyListener(this);
        }
    }

    public final void f3(com.live.evo.osd.persenter.a presenter) {
        Q2 = presenter;
    }

    @Override // l5.b
    public void h0(boolean hidden) {
        ValueAnimator valueAnimator;
        ProgramListView programListView;
        View view;
        q6.b logger = this.logger;
        kotlin.jvm.internal.m.e(logger, "logger");
        c5.b.a(logger, "onFragmentVisibleChange = " + hidden);
        if (!hidden) {
            LinearLayout linearLayout = this.mEpgParent;
            if (linearLayout != null && linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.mChannelParent;
            if (relativeLayout != null) {
                kotlin.jvm.internal.m.c(relativeLayout);
                if (relativeLayout.getVisibility() != 0) {
                    RelativeLayout relativeLayout2 = this.mChannelParent;
                    kotlin.jvm.internal.m.c(relativeLayout2);
                    relativeLayout2.setVisibility(0);
                }
            }
            View view2 = this.mCategoryParent;
            if (view2 != null && ((view2 == null || view2.getVisibility() != 0) && (view = this.mCategoryParent) != null)) {
                view.setVisibility(0);
            }
            ProgramListView programListView2 = this.mCategoryListView;
            if (programListView2 != null) {
                if ((programListView2 != null ? Integer.valueOf(programListView2.getVisibility()) : null) != 0 && (programListView = this.mCategoryListView) != null) {
                    programListView.setVisibility(0);
                }
            }
            if (!this.mIsCategoryOpen && (valueAnimator = this.categoryAnimOpen) != null) {
                kotlin.jvm.internal.m.c(valueAnimator);
                valueAnimator.start();
                this.mIsCategoryOpen = true;
            }
            this.mEpgShowFirst = false;
            n5.o oVar = this.mProgramAdapter;
            if (oVar != null && oVar != null) {
                oVar.notifyDataSetChanged();
            }
            Z1();
        } else if (!this.isChannelUpdateByKids) {
            S2();
            K1(this.mCategorySelect);
            L1();
            P2();
        }
        this.mIsCatchUp = false;
    }

    @Override // com.live.evo.osd.persenter.b
    public void m() {
        ProgramListView programListView = this.mProgramListView;
        if (programListView == null) {
            return;
        }
        n5.o oVar = this.mProgramAdapter;
        if (oVar != null) {
            if (oVar != null) {
                oVar.e(programListView != null ? programListView.getSelectedView() : null, true);
            }
            n5.o oVar2 = this.mProgramAdapter;
            if (oVar2 != null) {
                ProgramListView programListView2 = this.mProgramListView;
                oVar2.e(programListView2 != null ? programListView2.getChildAt(this.mProgramSelect) : null, true);
            }
        }
        ProgramListView programListView3 = this.mProgramListView;
        int selectedItemPosition = programListView3 != null ? programListView3.getSelectedItemPosition() : 0;
        if (selectedItemPosition == 0) {
            ProgramListView programListView4 = this.mProgramListView;
            if (programListView4 != null) {
                List<? extends i5.h> list = this.mListVodVideo;
                kotlin.jvm.internal.m.c(list);
                programListView4.setSelection(list.size() - 1);
            }
        } else {
            ProgramListView programListView5 = this.mProgramListView;
            if (programListView5 != null) {
                programListView5.setSelection(selectedItemPosition - 1);
            }
        }
        M2(this.mProgramListView);
    }

    @Override // com.live.evo.osd.persenter.b
    /* JADX INFO: renamed from: o, reason: from getter */
    public int getMProgramSelect() {
        return this.mProgramSelect;
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        super.onAttach(context);
        x1.f1.lb.util.e0.f21385a.a(this);
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onChannelUpdateEvent(nf.d event) {
        ProgramListView programListView;
        ProgramListView programListView2;
        List<? extends i5.h> list;
        ProgramListView programListView3;
        Context context;
        if (event == null) {
            return;
        }
        if (event.d()) {
            HashMap<String, List<i5.h>> map = O2;
            if ((map == null || map.isEmpty()) && isAdded() && (context = getContext()) != null) {
                com.live.evo.dialog.b.i(context, getString(R$string.load_fail) + ":\n" + event.c() + "(" + event.getCode() + ")", getString(2131952869), getString(2131952019), new Runnable() { // from class: com.live.evo.fragment.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.z2();
                    }
                }, new Runnable() { // from class: com.live.evo.fragment.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.A2(this.f5945a);
                    }
                });
                return;
            }
            return;
        }
        com.live.evo.util.s0 s0Var = com.live.evo.util.s0.f7342a;
        O2 = s0Var.C();
        N2 = t.v.c.i.a.f18646a.u(Boolean.TRUE);
        P2 = s0Var.t();
        List<String> list2 = N2;
        if (list2 != null) {
            kotlin.jvm.internal.m.c(list2);
            if (list2.size() == 0 || P2 == null || O2 == null) {
                return;
            }
            T2();
            G2();
            int i10 = this.mCategorySelect;
            List<String> list3 = M2;
            kotlin.jvm.internal.m.c(list3);
            if (i10 >= list3.size()) {
                this.mCategorySelect = 0;
            }
            H2();
            List<String> list4 = M2;
            kotlin.jvm.internal.m.c(list4);
            String str = list4.get(this.mCategorySelect);
            HashMap<String, List<i5.h>> map2 = O2;
            kotlin.jvm.internal.m.c(map2);
            List<i5.h> list5 = map2.get(str);
            this.mListVodVideo = list5;
            if (list5 == null) {
                return;
            }
            J2(str);
            ProgramListView programListView4 = this.mCategoryListView;
            if (programListView4 != null && programListView4.isFocused()) {
                ProgramListView programListView5 = this.mCategoryListView;
                if (programListView5 != null) {
                    programListView5.requestFocus();
                    return;
                }
                return;
            }
            if (this.mProgramListView != null && (list = this.mListVodVideo) != null) {
                kotlin.jvm.internal.m.c(list);
                if (list.size() > 0 && (programListView3 = this.mProgramListView) != null && programListView3.isFocused()) {
                    ProgramListView programListView6 = this.mProgramListView;
                    if (programListView6 != null) {
                        programListView6.requestFocus();
                        return;
                    }
                    return;
                }
            }
            ProgramListView programListView7 = this.mEpgListView;
            if (((programListView7 == null || !programListView7.isFocused()) && ((programListView = this.mLvEpgDate) == null || !programListView.isFocused())) || (programListView2 = this.mCategoryListView) == null) {
                return;
            }
            programListView2.requestFocus();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.widget.AdapterView$OnItemSelectedListener] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        ProgramListView programListView;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        ?? onItemSelectedListener;
        View view;
        RelativeLayout relativeLayout3;
        Banner<String, com.live.evo.catchup.player.b> banner;
        ProgramListView programListView2;
        q6.b logger = this.logger;
        kotlin.jvm.internal.m.e(logger, "logger");
        c5.b.a(logger, "onHiddenChanged = " + hidden);
        if (hidden) {
            LinearLayout linearLayout = this.mEpgParent;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            View view2 = this.mCategoryParent;
            if ((view2 == null || view2.getVisibility() != 0) && (view = this.mCategoryParent) != null) {
                view.setVisibility(0);
            }
            ProgramListView programListView3 = this.mCategoryListView;
            if ((programListView3 != null ? Integer.valueOf(programListView3.getVisibility()) : null) != 0 && (programListView2 = this.mCategoryListView) != null) {
                programListView2.setVisibility(0);
            }
            if (!this.mIsCategoryOpen) {
                ValueAnimator valueAnimator = this.categoryAnimOpen;
                kotlin.jvm.internal.m.c(valueAnimator);
                valueAnimator.start();
                this.mIsCategoryOpen = true;
            }
            if (S1() && (banner = this.mBanner) != null && banner != null) {
                banner.stop();
            }
            RelativeLayout relativeLayout4 = this.mLayoutBanner;
            if (relativeLayout4 != null && relativeLayout4 != null && relativeLayout4.getVisibility() == 0 && (relativeLayout3 = this.mLayoutBanner) != null) {
                relativeLayout3.setVisibility(8);
            }
            Z1();
        } else {
            S2();
            List<String> list = M2;
            kotlin.jvm.internal.m.c(list);
            String str = list.get(this.mCategorySelect);
            Locale locale = Locale.getDefault();
            kotlin.jvm.internal.m.e(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
            kotlin.jvm.internal.m.e(lowerCase, "toLowerCase(...)");
            if (TextUtils.equals(lowerCase, "favorite") || TextUtils.equals(lowerCase, "history")) {
                K1(this.mCategorySelect);
                List<? extends i5.h> list2 = this.mListVodVideo;
                if (list2 != null) {
                    kotlin.jvm.internal.m.c(list2);
                    if (list2.size() > 0 && (programListView = this.mProgramListView) != null && programListView != null) {
                        programListView.setVisibility(0);
                    }
                }
            }
            if (this.mFocusable) {
                ProgramListView programListView4 = this.mCategoryListView;
                ?? childAt = programListView4 != null ? programListView4.getChildAt(this.mCategorySelect) : null;
                ProgramListView programListView5 = this.mCategoryListView;
                if (programListView5 != null && childAt != 0 && programListView5 != null && (onItemSelectedListener = programListView5.getOnItemSelectedListener()) != 0) {
                    onItemSelectedListener.onItemSelected(this.mCategoryListView, childAt, this.mCategorySelect, childAt.getId());
                }
            }
            if (!S1() || this.mBanner == null) {
                RelativeLayout relativeLayout5 = this.mLayoutBanner;
                if (relativeLayout5 != null && relativeLayout5 != null && relativeLayout5.getVisibility() == 0 && (relativeLayout = this.mLayoutBanner) != null) {
                    relativeLayout.setVisibility(8);
                }
                Banner<String, com.live.evo.catchup.player.b> banner2 = this.mBanner;
                if (banner2 != null && banner2 != null) {
                    banner2.stop();
                }
            } else {
                RelativeLayout relativeLayout6 = this.mLayoutBanner;
                if (relativeLayout6 != null && ((relativeLayout6 == null || relativeLayout6.getVisibility() != 0) && (relativeLayout2 = this.mLayoutBanner) != null)) {
                    relativeLayout2.setVisibility(0);
                }
                a2();
                Banner<String, com.live.evo.catchup.player.b> banner3 = this.mBanner;
                if (banner3 != null) {
                    banner3.start();
                }
            }
            L1();
        }
        this.mEpgShowFirst = false;
    }

    @Override // com.live.evo.osd.persenter.b
    public void p(int inAllProgramPos) {
        n5.o oVar;
        ProgramListView programListView = this.mProgramListView;
        if (programListView == null || (oVar = this.mProgramAdapter) == null) {
            return;
        }
        if (oVar != null) {
            oVar.e(programListView != null ? programListView.getSelectedView() : null, true);
        }
        n5.o oVar2 = this.mProgramAdapter;
        if (oVar2 != null) {
            ProgramListView programListView2 = this.mProgramListView;
            oVar2.e(programListView2 != null ? programListView2.getChildAt(this.mProgramSelect) : null, true);
        }
        n5.o oVar3 = this.mProgramAdapter;
        if (oVar3 != null) {
            oVar3.d(inAllProgramPos);
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void q(Throwable throwable, String currentChannelId) {
        q6.b logger = this.logger;
        kotlin.jvm.internal.m.e(logger, "logger");
        c5.b.c(logger, throwable, "get tdoac epg data for channel failed:" + currentChannelId);
        TextView textView = this.mTvNotData;
        if (textView != null) {
            textView.setText(R$string.not_data);
        }
        TextView textView2 = this.mTvNotData;
        if (textView2 != null) {
            textView2.requestFocus();
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void r(int inListSelectPos) {
        ProgramListView programListView;
        ProgramListView programListView2 = this.mProgramListView;
        if (programListView2 == null) {
            return;
        }
        n5.o oVar = this.mProgramAdapter;
        if (oVar != null) {
            if (oVar != null) {
                oVar.e(programListView2 != null ? programListView2.getSelectedView() : null, true);
            }
            n5.o oVar2 = this.mProgramAdapter;
            if (oVar2 != null) {
                ProgramListView programListView3 = this.mProgramListView;
                oVar2.e(programListView3 != null ? programListView3.getChildAt(this.mProgramSelect) : null, true);
            }
        }
        this.mProgramSelect = inListSelectPos;
        n5.o oVar3 = this.mProgramAdapter;
        if (oVar3 != null) {
            if ((oVar3 != null ? oVar3.getCount() : 0) <= inListSelectPos || (programListView = this.mProgramListView) == null) {
                return;
            }
            programListView.setSelection(this.mProgramSelect);
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void s() {
        ProgramListView programListView = this.mProgramListView;
        if (programListView == null) {
            return;
        }
        n5.o oVar = this.mProgramAdapter;
        if (oVar != null) {
            if (oVar != null) {
                oVar.e(programListView != null ? programListView.getSelectedView() : null, true);
            }
            n5.o oVar2 = this.mProgramAdapter;
            if (oVar2 != null) {
                ProgramListView programListView2 = this.mProgramListView;
                oVar2.e(programListView2 != null ? programListView2.getChildAt(this.mProgramSelect) : null, true);
            }
        }
        ProgramListView programListView3 = this.mProgramListView;
        int selectedItemPosition = programListView3 != null ? programListView3.getSelectedItemPosition() : 0;
        List<? extends i5.h> list = this.mListVodVideo;
        kotlin.jvm.internal.m.c(list);
        if (selectedItemPosition == list.size() - 1) {
            ProgramListView programListView4 = this.mProgramListView;
            if (programListView4 != null) {
                programListView4.setSelection(0);
            }
        } else {
            ProgramListView programListView5 = this.mProgramListView;
            if (programListView5 != null) {
                programListView5.setSelection(selectedItemPosition + 1);
            }
        }
        M2(this.mProgramListView);
    }

    @Override // com.live.evo.osd.persenter.b
    public void t() {
        View view = this.focusView;
        if (view != null) {
            view.requestFocus();
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void u(int classifyPosition) {
        ProgramListView programListView = this.mCategoryListView;
        if (programListView == null || this.mCategorySelect == classifyPosition) {
            return;
        }
        this.mCategorySelect = classifyPosition;
        if (programListView != null) {
            programListView.setSelection(classifyPosition);
        }
        com.live.evo.osd.m mVar = this.mCategoryAdapter;
        if (mVar != null) {
            int i10 = this.mCategorySelect;
            ProgramListView programListView2 = this.mCategoryListView;
            boolean z10 = false;
            if (programListView2 != null && programListView2.isFocused()) {
                z10 = true;
            }
            mVar.b(i10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(x xVar) {
        FragmentActivity activity = xVar.getActivity();
        if (activity instanceof LiveNewActivity) {
            ((LiveNewActivity) activity).finish();
        }
    }

    private final void G2() {
        k2();
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        if (list.size() <= 0) {
            List<String> list2 = M2;
            kotlin.jvm.internal.m.c(list2);
            list2.addAll(t.v.c.i.a.f18646a.u(Boolean.TRUE));
        }
    }

    private final boolean N1() {
        boolean zO1 = O1();
        if (P1() && !zO1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P2() {
        if (com.live.evo.k.b().l() && com.live.evo.l.n().G()) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(1, com.live.evo.l.n().r());
        }
    }

    private final boolean S1() {
        if (v4.g.e().c() && this.mShowBanner) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a2  */
    private final void S2() {
        int i10;
        com.live.evo.k.b().h();
        if (this.mTextCategoryName != null) {
            k2();
            List<String> list = M2;
            kotlin.jvm.internal.m.c(list);
            int size = list.size();
            if (size > 0) {
                boolean z10 = false;
                if (this.mCategorySelect >= size) {
                    this.mCategorySelect = 0;
                }
                HashMap<String, List<i5.h>> map = O2;
                kotlin.jvm.internal.m.c(map);
                List<String> list2 = M2;
                kotlin.jvm.internal.m.c(list2);
                List<i5.h> list3 = map.get(list2.get(this.mCategorySelect));
                if (list3 == null || this.mProgramSelect >= list3.size()) {
                    this.mProgramSelect = 0;
                }
                for (int i11 = 0; i11 < size; i11++) {
                    if (this.mCategorySelect == i11) {
                        i10 = this.mProgramSelect;
                    } else {
                        i10 = 0;
                    }
                    Map<String, String> map2 = this.mHistoryMap;
                    kotlin.jvm.internal.m.c(map2);
                    List<String> list4 = M2;
                    kotlin.jvm.internal.m.c(list4);
                    if (TextUtils.isEmpty(map2.get(list4.get(i11)))) {
                        Map<String, String> map3 = this.mHistoryMap;
                        kotlin.jvm.internal.m.c(map3);
                        List<String> list5 = M2;
                        kotlin.jvm.internal.m.c(list5);
                        map3.put(list5.get(i11), i10 + ",0");
                    }
                }
                List<? extends i5.h> list6 = this.mListVodVideo;
                if (list6 != null) {
                    kotlin.jvm.internal.m.c(list6);
                    if (list6.isEmpty()) {
                        HashMap<String, List<i5.h>> map4 = O2;
                        kotlin.jvm.internal.m.c(map4);
                        List<String> list7 = M2;
                        kotlin.jvm.internal.m.c(list7);
                        this.mListVodVideo = map4.get(list7.get(0));
                    }
                } else {
                    HashMap<String, List<i5.h>> map5 = O2;
                    kotlin.jvm.internal.m.c(map5);
                    List<String> list8 = M2;
                    kotlin.jvm.internal.m.c(list8);
                    this.mListVodVideo = map5.get(list8.get(0));
                }
                com.live.evo.osd.m mVar = this.mCategoryAdapter;
                if (mVar == null) {
                    com.live.evo.osd.m mVar2 = new com.live.evo.osd.m(getActivity(), M2);
                    this.mCategoryAdapter = mVar2;
                    ProgramListView programListView = this.mCategoryListView;
                    if (programListView != null) {
                        programListView.setAdapter((ListAdapter) mVar2);
                    }
                } else if (mVar != null) {
                    mVar.a(M2);
                }
                ProgramListView programListView2 = this.mCategoryListView;
                if (programListView2 != null) {
                    if (programListView2 != null) {
                        programListView2.clearFocus();
                    }
                    ProgramListView programListView3 = this.mCategoryListView;
                    if (programListView3 != null) {
                        programListView3.setSelection(this.mCategorySelect);
                    }
                    com.live.evo.osd.m mVar3 = this.mCategoryAdapter;
                    if (mVar3 != null) {
                        int i12 = this.mCategorySelect;
                        ProgramListView programListView4 = this.mCategoryListView;
                        if (programListView4 != null && programListView4.isFocused()) {
                            z10 = true;
                        }
                        mVar3.b(i12, z10);
                    }
                }
            }
        }
    }

    private final boolean U2() {
        if (com.live.evo.l.n().E()) {
            return com.live.evo.h.b().d();
        }
        return com.live.evo.h.b().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V2() {
        if (N1()) {
            Y1();
            return;
        }
        Map<String, i5.i> mapT = com.live.evo.util.s0.f7342a.t();
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        i5.i iVar = mapT.get(list.get(this.mCategorySelect));
        if (iVar != null) {
            if (TextUtils.isEmpty(iVar.f()) && TextUtils.isEmpty(iVar.e()) && (iVar.a() == null || iVar.a().size() == 0)) {
                Y1();
                return;
            }
            RelativeLayout relativeLayout = this.mCategoryBannerParent;
            kotlin.jvm.internal.m.c(relativeLayout);
            relativeLayout.setVisibility(0);
            if (TextUtils.isEmpty(iVar.f())) {
                ImageView imageView = this.mCategoryBannerFrontPic;
                kotlin.jvm.internal.m.c(imageView);
                imageView.setVisibility(4);
            } else {
                ImageView imageView2 = this.mCategoryBannerFrontPic;
                kotlin.jvm.internal.m.c(imageView2);
                imageView2.setVisibility(0);
                com.live.evo.util.v.c(getContext(), iVar.f(), R$drawable.icon_transport, this.mCategoryBannerFrontPic);
            }
            TextView textView = this.mCategoryBannerDesc;
            kotlin.jvm.internal.m.c(textView);
            textView.setText(iVar.e());
            TextView textView2 = this.mCategoryBannerDesc;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setVisibility(0);
            List<String> listA = iVar.a();
            List<String> list2 = M2;
            kotlin.jvm.internal.m.c(list2);
            if (!ua.n.w(list2.get(this.mCategorySelect), com.live.evo.util.x1.j(R$string.favorite_list), true) && listA != null && !listA.isEmpty()) {
                Banner<String, com.live.evo.catchup.player.b> banner = this.mCategoryBanner;
                kotlin.jvm.internal.m.c(banner);
                banner.setVisibility(0);
                Banner<String, com.live.evo.catchup.player.b> banner2 = this.mCategoryBanner;
                kotlin.jvm.internal.m.c(banner2);
                banner2.setAdapter(new com.live.evo.catchup.player.b(getContext(), listA));
                Banner<String, com.live.evo.catchup.player.b> banner3 = this.mCategoryBanner;
                kotlin.jvm.internal.m.c(banner3);
                banner3.start();
                return;
            }
            RelativeLayout relativeLayout2 = this.mCategoryBannerParent;
            kotlin.jvm.internal.m.c(relativeLayout2);
            if (relativeLayout2.getVisibility() != 8) {
                Banner<String, com.live.evo.catchup.player.b> banner4 = this.mCategoryBanner;
                kotlin.jvm.internal.m.c(banner4);
                banner4.stop();
                Banner<String, com.live.evo.catchup.player.b> banner5 = this.mCategoryBanner;
                kotlin.jvm.internal.m.c(banner5);
                banner5.setVisibility(8);
                return;
            }
            return;
        }
        Y1();
    }

    private final void Y2() {
        Context context = getContext();
        if (context != null) {
            SpeedTestActivity.INSTANCE.a(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(x xVar, View view) {
        xVar.R1();
    }

    private final void d2(View mRoot) {
        Object systemService;
        this.layoutPwd = (RelativeLayout) mRoot.findViewById(R$id.adultkeyl_rl_pwd_layout);
        this.etPassword = (RemoveKeyCodeEnterEditText) mRoot.findViewById(R$id.adultkeyl_et_pwd);
        this.goAhead = (Button) mRoot.findViewById(R$id.adultkeyl_btn_go);
        this.title = (TextView) mRoot.findViewById(R$id.adultkeyl_tv_title);
        this.hint = (TextView) mRoot.findViewById(R$id.adultkeyl_tv_hint);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            systemService = activity.getSystemService("input_method");
        } else {
            systemService = null;
        }
        this.mIm = (InputMethodManager) systemService;
        if (com.live.evo.util.e.b().a()) {
            com.live.evo.util.t.b(this.goAhead);
            com.live.evo.util.t.b(this.etPassword);
            com.live.evo.util.t.b(this.hint);
        } else {
            com.live.evo.util.t.c(this.goAhead);
            com.live.evo.util.t.c(this.etPassword);
            com.live.evo.util.t.c(this.hint);
        }
        x2();
    }

    private final void e2() {
        final int dimension;
        final int dimension2;
        Resources resources;
        Resources resources2;
        Context context = getContext();
        if (context != null && (resources2 = context.getResources()) != null) {
            dimension = (int) resources2.getDimension(R$dimen.classify_width_2);
        } else {
            dimension = 0;
        }
        if (this.categoryAnimClose == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, dimension / 10);
            this.categoryAnimClose = valueAnimatorOfInt;
            if (valueAnimatorOfInt != null) {
                valueAnimatorOfInt.setDuration(100L);
            }
        }
        ValueAnimator valueAnimator = this.categoryAnimClose;
        kotlin.jvm.internal.m.c(valueAnimator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.live.evo.fragment.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                x.f2(this.f5979a, dimension, valueAnimator2);
            }
        });
        ValueAnimator valueAnimator2 = this.categoryAnimClose;
        kotlin.jvm.internal.m.c(valueAnimator2);
        valueAnimator2.addListener(new b());
        if (this.categoryAnimOpen == null) {
            ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(0, dimension / 10);
            this.categoryAnimOpen = valueAnimatorOfInt2;
            if (valueAnimatorOfInt2 != null) {
                valueAnimatorOfInt2.setDuration(100L);
            }
        }
        ValueAnimator valueAnimator3 = this.categoryAnimOpen;
        kotlin.jvm.internal.m.c(valueAnimator3);
        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.live.evo.fragment.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                x.g2(this.f5985a, valueAnimator4);
            }
        });
        ValueAnimator valueAnimator4 = this.categoryAnimOpen;
        kotlin.jvm.internal.m.c(valueAnimator4);
        valueAnimator4.addListener(new c());
        Context context2 = getContext();
        if (context2 != null && (resources = context2.getResources()) != null) {
            dimension2 = (int) resources.getDimension(R$dimen.epg_width_2);
        } else {
            dimension2 = 0;
        }
        if (this.epgAnimOpen == null) {
            ValueAnimator valueAnimatorOfInt3 = ValueAnimator.ofInt(0, dimension2);
            this.epgAnimOpen = valueAnimatorOfInt3;
            if (valueAnimatorOfInt3 != null) {
                valueAnimatorOfInt3.setDuration(100L);
            }
        }
        ValueAnimator valueAnimator5 = this.epgAnimOpen;
        kotlin.jvm.internal.m.c(valueAnimator5);
        valueAnimator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.live.evo.fragment.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator6) {
                x.h2(this.f5990a, valueAnimator6);
            }
        });
        ValueAnimator valueAnimator6 = this.epgAnimOpen;
        kotlin.jvm.internal.m.c(valueAnimator6);
        valueAnimator6.addListener(new d());
        if (this.epgAnimClose == null) {
            ValueAnimator valueAnimatorOfInt4 = ValueAnimator.ofInt(0, dimension2);
            this.epgAnimClose = valueAnimatorOfInt4;
            if (valueAnimatorOfInt4 != null) {
                valueAnimatorOfInt4.setDuration(100L);
            }
        }
        ValueAnimator valueAnimator7 = this.epgAnimClose;
        kotlin.jvm.internal.m.c(valueAnimator7);
        valueAnimator7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.live.evo.fragment.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator8) {
                x.i2(this.f5995a, dimension2, valueAnimator8);
            }
        });
        ValueAnimator valueAnimator8 = this.epgAnimClose;
        kotlin.jvm.internal.m.c(valueAnimator8);
        valueAnimator8.addListener(new e());
    }

    private final void s2() {
        Context context = getContext();
        kotlin.jvm.internal.m.d(context, "null cannot be cast to non-null type android.app.Activity");
        this.mVideoPreview = (RelativeLayout) ((Activity) context).findViewById(R$id.preview_container);
        if (Q2 != null && com.live.evo.k.b().l() && this.mPreviewContainer != null) {
            com.live.evo.osd.persenter.a aVar = Q2;
            kotlin.jvm.internal.m.c(aVar);
            aVar.h("ChannelFragment", this.mPreviewContainer);
        }
    }

    private final void t2() {
        this.mTipSwitch = com.live.evo.l.n().i("pip_menu_tipwatch", com.live.evo.util.x1.j(R$string.pip_menu_tipwatch));
        this.mTipOpenPip = com.live.evo.l.n().i("pip_menu_tipopen", com.live.evo.util.x1.j(R$string.pip_menu_tipopen));
        this.mTipClosePip = com.live.evo.l.n().i("pip_menu_tipclose", com.live.evo.util.x1.j(R$string.pip_menu_tipclose));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(x xVar) {
        i5.h hVar;
        if (com.live.evo.l.n() != null) {
            HashMap<String, List<i5.h>> map = O2;
            kotlin.jvm.internal.m.c(map);
            List<String> list = M2;
            kotlin.jvm.internal.m.c(list);
            List<i5.h> list2 = map.get(list.get(xVar.mCategorySelect));
            if (list2 != null) {
                int size = list2.size();
                int i10 = xVar.mProgramSelect;
                if (size > i10 && (hVar = list2.get(i10)) != null && !hVar.p() && !hVar.q()) {
                    com.live.evo.osd.persenter.a aVar = Q2;
                    kotlin.jvm.internal.m.c(aVar);
                    aVar.a(0, hVar.i());
                }
            }
        }
    }

    public final void I2() {
        List<String> list;
        n5.o oVar;
        View selectedView;
        if (com.live.evo.k.b().f() && Q1() && (list = M2) != null) {
            kotlin.jvm.internal.m.c(list);
            if (list.size() > this.mCategorySelect && (oVar = this.mProgramAdapter) != null) {
                if (oVar != null) {
                    ProgramListView programListView = this.mProgramListView;
                    if (programListView != null) {
                        selectedView = programListView.getSelectedView();
                    } else {
                        selectedView = null;
                    }
                    oVar.e(selectedView, true);
                }
                List<String> list2 = M2;
                kotlin.jvm.internal.m.c(list2);
                String str = list2.get(this.mCategorySelect);
                HashMap<String, List<i5.h>> map = O2;
                kotlin.jvm.internal.m.c(map);
                List<i5.h> list3 = map.get(str);
                this.mListVodVideo = list3;
                e3(list3);
                R2();
                K2(str);
                ProgramListView programListView2 = this.mProgramListView;
                if (programListView2 != null) {
                    programListView2.requestFocus();
                }
            }
        }
    }

    @Override // l5.b
    protected int b0() {
        return R$layout.program_view_layout3;
    }

    @Override // l5.b
    protected void c0(Bundle savedInstanceState) {
        int iC;
        int i10;
        List listL;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (Q2 == null) {
            ((LiveNewActivity) activity).r2(true);
        }
        com.live.evo.osd.persenter.a aVar = Q2;
        if (aVar != null) {
            aVar.v();
        }
        this.mCategoryWidth = (int) activity.getResources().getDimension(R$dimen.classify_width_2);
        if (this.mPreviousPlayData == null) {
            String strB = com.live.evo.util.b2.b();
            this.mPreviousPlayData = strB;
            kotlin.jvm.internal.m.c(strB);
            List<String> listG = new ua.l(",").g(strB, 0);
            if (!listG.isEmpty()) {
                ListIterator<String> listIterator = listG.listIterator(listG.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        listL = kotlin.collections.r.l();
                        break;
                    }
                }
            } else {
                listL = kotlin.collections.r.l();
                break;
            }
            String[] strArr = (String[]) listL.toArray(new String[0]);
            this.playCategory = Integer.parseInt(strArr[0]);
            this.playChannel = Integer.parseInt(strArr[1]);
            this.playAllPos = Integer.parseInt(strArr[2]);
        }
        if (this.mHistoryMap == null) {
            this.mHistoryMap = new HashMap();
        }
        k2();
        List<String> list = M2;
        kotlin.jvm.internal.m.c(list);
        int size = list.size();
        if (size <= 0) {
            List<String> list2 = M2;
            kotlin.jvm.internal.m.c(list2);
            list2.addAll(t.v.c.i.a.f18646a.u(Boolean.TRUE));
        }
        int i11 = this.playCategory;
        this.mCategorySelect = i11;
        List<String> list3 = M2;
        kotlin.jvm.internal.m.c(list3);
        if (i11 >= list3.size()) {
            this.mCategorySelect = 0;
        }
        List<String> list4 = M2;
        kotlin.jvm.internal.m.c(list4);
        if (list4.size() > 0) {
            Map<String, ? extends i5.i> map = P2;
            kotlin.jvm.internal.m.c(map);
            List<String> list5 = M2;
            kotlin.jvm.internal.m.c(list5);
            if (map.get(list5.get(this.mCategorySelect)) != null) {
                TextView textView = this.mTextCategoryName;
                kotlin.jvm.internal.m.c(textView);
                Map<String, ? extends i5.i> map2 = P2;
                kotlin.jvm.internal.m.c(map2);
                List<String> list6 = M2;
                kotlin.jvm.internal.m.c(list6);
                i5.i iVar = map2.get(list6.get(this.mCategorySelect));
                kotlin.jvm.internal.m.c(iVar);
                textView.setText(iVar.h());
            }
        }
        this.mProgramSelect = this.playChannel;
        HashMap<String, List<i5.h>> map3 = O2;
        kotlin.jvm.internal.m.c(map3);
        List<String> list7 = M2;
        kotlin.jvm.internal.m.c(list7);
        List<i5.h> list8 = map3.get(list7.get(this.mCategorySelect));
        if (list8 == null || this.mProgramSelect >= list8.size()) {
            this.mProgramSelect = 0;
        }
        for (int i12 = 0; i12 < size; i12++) {
            if (this.mCategorySelect == i12) {
                i10 = this.mProgramSelect;
            } else {
                i10 = 0;
            }
            Map<String, String> map4 = this.mHistoryMap;
            kotlin.jvm.internal.m.c(map4);
            List<String> list9 = M2;
            kotlin.jvm.internal.m.c(list9);
            map4.put(list9.get(i12), i10 + ",0");
        }
        HashMap<String, List<i5.h>> map5 = O2;
        kotlin.jvm.internal.m.c(map5);
        List<String> list10 = M2;
        kotlin.jvm.internal.m.c(list10);
        this.mListVodVideo = map5.get(list10.get(0));
        com.live.evo.osd.m mVar = this.mCategoryAdapter;
        if (mVar == null) {
            this.mCategoryAdapter = new com.live.evo.osd.m(getActivity(), M2);
        } else if (mVar != null) {
            mVar.a(M2);
        }
        ProgramListView programListView = this.mCategoryListView;
        if (programListView != null) {
            programListView.setAdapter((ListAdapter) this.mCategoryAdapter);
        }
        if (this.mProgramAdapter == null) {
            this.mProgramAdapter = new n5.o(getActivity(), this.mListVodVideo);
        }
        ProgramListView programListView2 = this.mProgramListView;
        if (programListView2 != null) {
            programListView2.setAdapter((ListAdapter) this.mProgramAdapter);
        }
        n5.o oVar = this.mProgramAdapter;
        if (oVar != null) {
            HashMap<String, List<i5.h>> map6 = O2;
            kotlin.jvm.internal.m.c(map6);
            List<String> list11 = M2;
            kotlin.jvm.internal.m.c(list11);
            oVar.c(map6.get(list11.get(this.mCategorySelect)), this.playAllPos);
        }
        K1(this.mCategorySelect);
        ProgramListView programListView3 = this.mCategoryListView;
        if (programListView3 != null) {
            programListView3.setSelection(this.playCategory);
        }
        ProgramListView programListView4 = this.mCategoryListView;
        if (programListView4 != null) {
            programListView4.post(new Runnable() { // from class: com.live.evo.fragment.v
                @Override // java.lang.Runnable
                public final void run() {
                    x.l2(this.f6848a);
                }
            });
        }
        if (this.mEpgAdapter == null) {
            this.mEpgAdapter = new com.live.evo.osd.b(getContext(), null, this.curChannelId);
        }
        ProgramListView programListView5 = this.mEpgListView;
        if (programListView5 != null) {
            programListView5.setAdapter((ListAdapter) this.mEpgAdapter);
        }
        if (this.epgDateAdapter == null) {
            this.epgDateAdapter = new n5.b(getContext());
        }
        ProgramListView programListView6 = this.mLvEpgDate;
        if (programListView6 != null) {
            programListView6.setAdapter((ListAdapter) this.epgDateAdapter);
        }
        this.isInitEpgData = true;
        ProgramListView programListView7 = this.mLvEpgDate;
        if (programListView7 != null) {
            n5.b bVar = this.epgDateAdapter;
            if (bVar != null) {
                iC = bVar.c();
            } else {
                iC = 0;
            }
            programListView7.setSelectionFromTop(iC, 0);
        }
        this.tempEpgList = new ArrayList();
        this.curChannelEpgList = new ArrayList();
        e2();
        RelativeLayout relativeLayout = this.mChannelParent;
        kotlin.jvm.internal.m.c(relativeLayout);
        if (relativeLayout.getVisibility() == 0) {
            ProgramListView programListView8 = this.mProgramListView;
            if (programListView8 != null) {
                programListView8.requestFocus();
            }
            M2(this.mProgramListView);
        }
        int iW1 = W1();
        List<? extends i5.h> list12 = this.mListVodVideo;
        if (iW1 > 0 && list12 != null && iW1 < list12.size()) {
            ProgramListView programListView9 = this.mProgramListView;
            if (programListView9 != null) {
                programListView9.setSelection(iW1);
            }
        } else {
            ProgramListView programListView10 = this.mProgramListView;
            if (programListView10 != null) {
                programListView10.setSelection(this.mProgramSelect);
            }
        }
        R2();
        TextView textView2 = this.mSessionId;
        if (textView2 != null) {
            textView2.setText(com.live.evo.l.n().w());
        }
        j2();
        r2();
        V2();
        t2();
        L1();
    }

    @Override // l5.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        S2 = null;
    }

    @Override // l5.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        x1.f1.lb.util.e0.f21385a.b(this);
        this.mProgramAdapter = null;
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        x1.f1.lb.util.e0.f21385a.b(this);
    }

    @Override // com.live.evo.fragment.c, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        x1.f1.lb.util.e0.f21385a.a(this);
        W2();
    }

    public final void q2() {
        try {
            if (getContext() != null) {
                ziyi.kit.keyboard.b bVar = this.keyboardView;
                if (bVar != null) {
                    kotlin.jvm.internal.m.c(bVar);
                    bVar.W();
                }
                ziyi.kit.keyboard.b bVarU = KeyUtils.u(T2, getContext(), this.mView, getLifecycle(), false, false);
                this.keyboardView = bVarU;
                if (bVarU != null && this.etPassword != null) {
                    kotlin.jvm.internal.m.c(bVarU);
                    bVarU.l(this.etPassword);
                }
            }
        } catch (Exception e10) {
            q6.b logger = this.logger;
            kotlin.jvm.internal.m.e(logger, "logger");
            c5.b.b(logger, "channel initKeyBoard error", e10);
        }
    }

    private final void r2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2() {
    }

    @Override // k5.b
    /* JADX INFO: renamed from: O2, reason: merged with bridge method [inline-methods] */
    public void K(com.live.evo.osd.persenter.a presenter) {
    }

    @Override // com.live.evo.osd.persenter.b
    public void N(FragmentManager fragmentManager, String menuTag) {
    }
}
