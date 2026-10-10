package com.live.evo.activity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p000lifecycle.Lifecycle;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$string;
import com.live.evo.fragment.l3;
import com.live.evo.widget.SpeedTextView;
import com.live.evo.widget.sloading.SLoadingView;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import kotlin.Metadata;
import org.apache.log4j.helpers.FileWatchdog;
import org.greenrobot.eventbus.ThreadMode;
import t.v.c.widget.videoview.PlayerView;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import z1.b1.lb.m.extra.upgrade.UpgradeInfo;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Metadata(d1 = {"\u0000Ê\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\n\u0098\u0004\u0099\u0004\u009a\u0004\u009b\u0004\u009c\u0004B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b \u0010\u0004J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010\u0004J\u000f\u0010*\u001a\u00020%H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\nH\u0002¢\u0006\u0004\b,\u0010\u0004J3\u00102\u001a\u00020\n2\u0006\u0010.\u001a\u00020-2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070/2\u0006\u00101\u001a\u00020\u0007H\u0003¢\u0006\u0004\b2\u00103J\u001f\u00106\u001a\u00020\n2\u0006\u0010.\u001a\u00020-2\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\n2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\nH\u0002¢\u0006\u0004\b<\u0010\u0004J\u000f\u0010=\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u0010\u0004J\u001b\u0010?\u001a\u00020\n2\n\b\u0002\u0010>\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0004\b?\u0010@J\u001b\u0010A\u001a\u00020\n2\n\b\u0002\u0010>\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0004\bA\u0010@J\u0019\u0010B\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\nH\u0002¢\u0006\u0004\bD\u0010\u0004J\u001f\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020%2\u0006\u0010\"\u001a\u000208H\u0002¢\u0006\u0004\bF\u0010GJ/\u0010J\u001a\u00020\n2\u0006\u0010E\u001a\u00020%2\u0006\u0010\"\u001a\u0002082\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%H\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\nH\u0002¢\u0006\u0004\bL\u0010\u0004J\u0019\u0010N\u001a\u00020\n2\b\b\u0002\u0010M\u001a\u00020%H\u0002¢\u0006\u0004\bN\u0010(J\u0019\u0010P\u001a\u00020\n2\b\u0010O\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\bP\u0010QJ!\u0010S\u001a\u00020\n2\b\u0010O\u001a\u0004\u0018\u00010-2\u0006\u0010R\u001a\u000208H\u0002¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\nH\u0002¢\u0006\u0004\bU\u0010\u0004J\u000f\u0010V\u001a\u00020\nH\u0002¢\u0006\u0004\bV\u0010\u0004J\u000f\u0010W\u001a\u00020\nH\u0002¢\u0006\u0004\bW\u0010\u0004J\u0017\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0XH\u0002¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\nH\u0002¢\u0006\u0004\b[\u0010\u0004J\u000f\u0010\\\u001a\u00020\nH\u0002¢\u0006\u0004\b\\\u0010\u0004J\u000f\u0010]\u001a\u00020\nH\u0002¢\u0006\u0004\b]\u0010\u0004J\u000f\u0010^\u001a\u00020%H\u0002¢\u0006\u0004\b^\u0010+J\u0019\u0010`\u001a\u00020\n2\b\u0010_\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\b`\u0010QJ\u0019\u0010a\u001a\u00020\n2\b\u0010_\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\ba\u0010QJ\u0017\u0010c\u001a\u00020\n2\u0006\u0010b\u001a\u00020%H\u0002¢\u0006\u0004\bc\u0010(J\u0017\u0010e\u001a\u00020\n2\u0006\u0010d\u001a\u00020\u0007H\u0002¢\u0006\u0004\be\u0010\u000fJ'\u0010i\u001a\u00020\n2\u0006\u0010f\u001a\u0002082\u0006\u0010g\u001a\u0002082\u0006\u0010h\u001a\u000208H\u0002¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020\nH\u0002¢\u0006\u0004\bk\u0010\u0004J\u0017\u0010m\u001a\u00020\n2\u0006\u0010l\u001a\u000208H\u0002¢\u0006\u0004\bm\u0010;J!\u0010p\u001a\u00020\n2\u0006\u0010n\u001a\u0002082\b\u0010o\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\bp\u0010qJ\u000f\u0010r\u001a\u00020\nH\u0002¢\u0006\u0004\br\u0010\u0004J\u000f\u0010s\u001a\u00020%H\u0002¢\u0006\u0004\bs\u0010+J\u0011\u0010u\u001a\u0004\u0018\u00010tH\u0002¢\u0006\u0004\bu\u0010vJ\u000f\u0010w\u001a\u00020\nH\u0002¢\u0006\u0004\bw\u0010\u0004J\u000f\u0010x\u001a\u00020\nH\u0002¢\u0006\u0004\bx\u0010\u0004J\u0017\u0010z\u001a\u00020\n2\u0006\u0010y\u001a\u000208H\u0002¢\u0006\u0004\bz\u0010;J\u000f\u0010{\u001a\u00020\nH\u0002¢\u0006\u0004\b{\u0010\u0004J\u000f\u0010|\u001a\u00020\nH\u0002¢\u0006\u0004\b|\u0010\u0004J2\u0010\u0080\u0001\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010}\u001a\u0002082\u0006\u0010~\u001a\u0002082\u0006\u0010\u007f\u001a\u00020!H\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0082\u0001\u0010\u0004J\u001c\u0010\u0084\u0001\u001a\u00020\n2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0005\b\u0084\u0001\u0010\u000fJ\u0011\u0010\u0085\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0085\u0001\u0010\u0004J\u0011\u0010\u0086\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0086\u0001\u0010\u0004J(\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070\u0088\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J$\u0010\u008d\u0001\u001a\u00020\n2\u0007\u0010\u008b\u0001\u001a\u0002082\u0007\u0010\u008c\u0001\u001a\u000208H\u0002¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J&\u0010\u0090\u0001\u001a\u00020\n2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u008c\u0001\u001a\u000208H\u0002¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J)\u0010\u0094\u0001\u001a\u00020\n2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00072\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u001c\u0010\u0096\u0001\u001a\u00020\n2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0005\b\u0096\u0001\u0010\u000fJ\u0011\u0010\u0097\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0097\u0001\u0010\u0004J\u0011\u0010\u0098\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0098\u0001\u0010\u0004J\u001c\u0010\u009b\u0001\u001a\u00020\n2\b\u0010\u009a\u0001\u001a\u00030\u0099\u0001H\u0002¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J \u0010\u009d\u0001\u001a\u00020\n2\f\b\u0002\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009c\u0001J\u001e\u0010 \u0001\u001a\u00020\n2\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0014¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0019\u0010¢\u0001\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0005\b¢\u0001\u0010\fJ\u0011\u0010£\u0001\u001a\u00020\nH\u0014¢\u0006\u0005\b£\u0001\u0010\u0004J\u001c\u0010¥\u0001\u001a\u00020\n2\b\u0010¤\u0001\u001a\u00030\u009e\u0001H\u0015¢\u0006\u0006\b¥\u0001\u0010¡\u0001J\u001c\u0010¦\u0001\u001a\u00020\n2\b\u0010\u009f\u0001\u001a\u00030\u009e\u0001H\u0014¢\u0006\u0006\b¦\u0001\u0010¡\u0001J\u0018\u0010¨\u0001\u001a\u00020\n2\u0007\u0010§\u0001\u001a\u00020%¢\u0006\u0005\b¨\u0001\u0010(J\u0011\u0010©\u0001\u001a\u00020\nH\u0014¢\u0006\u0005\b©\u0001\u0010\u0004J\u0011\u0010ª\u0001\u001a\u00020\nH\u0014¢\u0006\u0005\bª\u0001\u0010\u0004J\u0011\u0010«\u0001\u001a\u00020\nH\u0016¢\u0006\u0005\b«\u0001\u0010\u0004J\u000f\u0010¬\u0001\u001a\u00020%¢\u0006\u0005\b¬\u0001\u0010+J\u0011\u0010\u00ad\u0001\u001a\u00020\nH\u0014¢\u0006\u0005\b\u00ad\u0001\u0010\u0004J\u0011\u0010®\u0001\u001a\u00020\nH\u0014¢\u0006\u0005\b®\u0001\u0010\u0004J\u000f\u0010¯\u0001\u001a\u00020\n¢\u0006\u0005\b¯\u0001\u0010\u0004J\u001c\u0010²\u0001\u001a\u00020\n2\b\u0010±\u0001\u001a\u00030°\u0001H\u0007¢\u0006\u0006\b²\u0001\u0010³\u0001J\u001c\u0010²\u0001\u001a\u00020\n2\b\u0010±\u0001\u001a\u00030´\u0001H\u0007¢\u0006\u0006\b²\u0001\u0010µ\u0001J\u001c\u0010²\u0001\u001a\u00020\n2\b\u0010±\u0001\u001a\u00030¶\u0001H\u0007¢\u0006\u0006\b²\u0001\u0010·\u0001J\u001c\u0010¹\u0001\u001a\u00020\n2\b\u0010±\u0001\u001a\u00030¸\u0001H\u0007¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u0018\u0010¼\u0001\u001a\u00020\n2\u0007\u0010»\u0001\u001a\u000208¢\u0006\u0005\b¼\u0001\u0010;J\u001c\u0010¾\u0001\u001a\u00020%2\b\u0010±\u0001\u001a\u00030½\u0001H\u0016¢\u0006\u0006\b¾\u0001\u0010¿\u0001J/\u0010Â\u0001\u001a\u00020%2\b\u0010À\u0001\u001a\u00030\u0092\u00012\u0007\u0010Á\u0001\u001a\u0002082\b\u0010±\u0001\u001a\u00030½\u0001H\u0016¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u0019\u0010Ä\u0001\u001a\u00020\u00072\u0007\u0010»\u0001\u001a\u000208¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\u000f\u0010Æ\u0001\u001a\u00020\n¢\u0006\u0005\bÆ\u0001\u0010\u0004J\u0018\u0010Ç\u0001\u001a\u00020\n2\u0007\u0010»\u0001\u001a\u000208¢\u0006\u0005\bÇ\u0001\u0010;J\u0010\u0010È\u0001\u001a\u000208¢\u0006\u0006\bÈ\u0001\u0010É\u0001J\u0012\u0010Ê\u0001\u001a\u0004\u0018\u00010-¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010-2\u0007\u0010\u008c\u0001\u001a\u000208¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u0017\u0010Î\u0001\u001a\u00020\n2\u0006\u0010n\u001a\u000208¢\u0006\u0005\bÎ\u0001\u0010;J-\u0010Ð\u0001\u001a\u0002082\b\u0010\r\u001a\u0004\u0018\u00010\u00072\t\u0010Ï\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010n\u001a\u000208¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u001e\u0010Ó\u0001\u001a\u00020\n2\n\u0010±\u0001\u001a\u0005\u0018\u00010Ò\u0001H\u0007¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J\u0018\u0010Ö\u0001\u001a\u00020\n2\u0007\u0010Õ\u0001\u001a\u00020%¢\u0006\u0005\bÖ\u0001\u0010(J\u001a\u0010Ø\u0001\u001a\u00020\n2\t\u0010×\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0005\bØ\u0001\u0010\u000fJ\u0018\u0010Ú\u0001\u001a\u00020\n2\u0007\u0010Ù\u0001\u001a\u00020%¢\u0006\u0005\bÚ\u0001\u0010(J\u000f\u0010Û\u0001\u001a\u00020\n¢\u0006\u0005\bÛ\u0001\u0010\u0004J\u000f\u0010Ü\u0001\u001a\u00020\n¢\u0006\u0005\bÜ\u0001\u0010\u0004J\u001c\u0010Þ\u0001\u001a\u00020\n2\b\u0010±\u0001\u001a\u00030Ý\u0001H\u0007¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J\u001e\u0010â\u0001\u001a\u00020\n2\n\u0010á\u0001\u001a\u0005\u0018\u00010à\u0001H\u0007¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u001c\u0010¹\u0001\u001a\u00020\n2\b\u0010±\u0001\u001a\u00030ä\u0001H\u0007¢\u0006\u0006\b¹\u0001\u0010å\u0001J\u001c\u0010ç\u0001\u001a\u00020\n2\b\u0010±\u0001\u001a\u00030æ\u0001H\u0007¢\u0006\u0006\bç\u0001\u0010è\u0001J\u001c\u0010ç\u0001\u001a\u00020\n2\b\u0010±\u0001\u001a\u00030é\u0001H\u0007¢\u0006\u0006\bç\u0001\u0010ê\u0001J\u0018\u0010ì\u0001\u001a\u00020\n2\u0007\u0010ë\u0001\u001a\u00020%¢\u0006\u0005\bì\u0001\u0010(J.\u0010ï\u0001\u001a\u00020\n2\u0007\u0010í\u0001\u001a\u0002082\u0007\u0010î\u0001\u001a\u0002082\b\u0010o\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0006\bï\u0001\u0010ð\u0001J\u001e\u0010ò\u0001\u001a\u00020\n2\n\u0010±\u0001\u001a\u0005\u0018\u00010ñ\u0001H\u0007¢\u0006\u0006\bò\u0001\u0010ó\u0001J\u001e\u0010õ\u0001\u001a\u00020\n2\n\u0010±\u0001\u001a\u0005\u0018\u00010ô\u0001H\u0007¢\u0006\u0006\bõ\u0001\u0010ö\u0001J\u001c\u0010ø\u0001\u001a\u00020\n2\b\u0010±\u0001\u001a\u00030÷\u0001H\u0007¢\u0006\u0006\bø\u0001\u0010ù\u0001J\u001e\u0010û\u0001\u001a\u00020\n2\n\u0010±\u0001\u001a\u0005\u0018\u00010ú\u0001H\u0007¢\u0006\u0006\bû\u0001\u0010ü\u0001J\u000f\u0010ý\u0001\u001a\u00020\n¢\u0006\u0005\bý\u0001\u0010\u0004R\"\u0010\u0082\u0002\u001a\r ÿ\u0001*\u0005\u0018\u00010þ\u00010þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0002\u0010\u0081\u0002R,\u0010\u008a\u0002\u001a\u0005\u0018\u00010\u0083\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0084\u0002\u0010\u0085\u0002\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002\"\u0006\b\u0088\u0002\u0010\u0089\u0002R\u0019\u0010\u008d\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010\u008c\u0002R\u001c\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010\u008f\u0002R\u001c\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0091\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0002\u0010\u0093\u0002R\u001c\u0010\u0096\u0002\u001a\u0005\u0018\u00010\u0091\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0002\u0010\u0093\u0002R\u001c\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0097\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0002\u0010\u0099\u0002R\u0019\u0010\u009c\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u008c\u0002R\u0019\u0010\u009f\u0002\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010\u009e\u0002R\u0019\u0010¡\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0002\u0010\u008c\u0002R\u001b\u0010¤\u0002\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0002\u0010£\u0002R\u0019\u0010¦\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0002\u0010\u008c\u0002R\u0018\u0010ª\u0002\u001a\u00030§\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0002\u0010©\u0002R\u001c\u0010®\u0002\u001a\u0005\u0018\u00010«\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0002\u0010\u00ad\u0002R\u001c\u0010±\u0002\u001a\u0005\u0018\u00010¯\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010°\u0002R\u001c\u0010µ\u0002\u001a\u0005\u0018\u00010²\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0002\u0010´\u0002R\u001c\u0010¹\u0002\u001a\u0005\u0018\u00010¶\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0002\u0010¸\u0002R\u001c\u0010»\u0002\u001a\u0005\u0018\u00010¶\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0002\u0010¸\u0002R\u001c\u0010½\u0002\u001a\u0005\u0018\u00010¶\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0002\u0010¸\u0002R\u001c\u0010Á\u0002\u001a\u0005\u0018\u00010¾\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0002\u0010À\u0002R\u001c\u0010Å\u0002\u001a\u0005\u0018\u00010Â\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0002\u0010Ä\u0002R\u0019\u0010È\u0002\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0002\u0010Ç\u0002R\u0019\u0010Ê\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0002\u0010\u008c\u0002R\u0019\u0010Ì\u0002\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0002\u0010\u009e\u0002R\u0019\u0010Î\u0002\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0002\u0010\u009e\u0002R\u0019\u0010Ð\u0002\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0002\u0010\u009e\u0002R\u0019\u0010Ò\u0002\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0002\u0010\u008c\u0002R\u001b\u0010Ô\u0002\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0002\u0010Ó\u0002R\u001b\u0010Õ\u0002\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0002\u0010£\u0002R\u001c\u0010Ù\u0002\u001a\u0005\u0018\u00010Ö\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0002\u0010Ø\u0002R\u0018\u0010Ý\u0002\u001a\u00030Ú\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÛ\u0002\u0010Ü\u0002R\u001b\u0010à\u0002\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0002\u0010ß\u0002R\u001b\u0010â\u0002\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0002\u0010ß\u0002R#\u0010å\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0002\u0010ä\u0002R!\u0010ç\u0002\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0002\u0010ä\u0002RG\u0010ì\u0002\u001a0\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0X\u0018\u00010è\u0002j\u0017\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0X\u0018\u0001`é\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bê\u0002\u0010ë\u0002R(\u0010ð\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030í\u0002\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0002\u0010ï\u0002R\u0019\u0010ò\u0002\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0002\u0010\u009e\u0002R\u0019\u0010ô\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0002\u0010£\u0002R\u0018\u0010ø\u0002\u001a\u00030õ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bö\u0002\u0010÷\u0002R\u0018\u0010ú\u0002\u001a\u00030õ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bù\u0002\u0010÷\u0002R\u001c\u0010þ\u0002\u001a\u0005\u0018\u00010û\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0002\u0010ý\u0002R\u0019\u0010\u0080\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0002\u0010\u008c\u0002R\u001c\u0010\u0084\u0003\u001a\u0005\u0018\u00010\u0081\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0003\u0010\u0083\u0003R\u001c\u0010\u0087\u0003\u001a\u0005\u0018\u00010\u0085\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u0086\u0003R\u001c\u0010\u008b\u0003\u001a\u0005\u0018\u00010\u0088\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0003\u0010\u008a\u0003R\u001c\u0010\u008d\u0003\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0003\u0010\u008f\u0002R\u001c\u0010\u0091\u0003\u001a\u0005\u0018\u00010\u008e\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0003\u0010\u0090\u0003R\u001c\u0010\u0095\u0003\u001a\u0005\u0018\u00010\u0092\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0003\u0010\u0094\u0003R\u001c\u0010\u0099\u0003\u001a\u0005\u0018\u00010\u0096\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0003\u0010\u0098\u0003R\u001c\u0010\u009d\u0003\u001a\u0005\u0018\u00010\u009a\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0003\u0010\u009c\u0003R\u0019\u0010\u009f\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0003\u0010\u008c\u0002R\u0019\u0010¡\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0003\u0010£\u0002R\u0019\u0010£\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0003\u0010\u008c\u0002R\u0019\u0010¥\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0003\u0010Ç\u0002R\u0019\u0010§\u0003\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0003\u0010\u009e\u0002R\u0019\u0010©\u0003\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0003\u0010\u009e\u0002R\u0019\u0010«\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0003\u0010Ç\u0002R\u0019\u0010\u00ad\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0003\u0010£\u0002R\u0019\u0010¯\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0003\u0010£\u0002R\u0019\u0010±\u0003\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0003\u0010\u009e\u0002R\u001c\u0010µ\u0003\u001a\u0005\u0018\u00010²\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0003\u0010´\u0003R\u001c\u0010¹\u0003\u001a\u0005\u0018\u00010¶\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0003\u0010¸\u0003R\u001c\u0010»\u0003\u001a\u0005\u0018\u00010\u0091\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0003\u0010\u0093\u0002R\u001c\u0010½\u0003\u001a\u0005\u0018\u00010\u0091\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0003\u0010\u0093\u0002R\u001c\u0010¿\u0003\u001a\u0005\u0018\u00010\u0091\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0003\u0010\u0093\u0002R\u001c\u0010À\u0003\u001a\u0005\u0018\u00010\u008e\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010\u0090\u0003R\u001c\u0010Ã\u0003\u001a\u0005\u0018\u00010Á\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0001\u0010Â\u0003R\u001b\u0010Ä\u0003\u001a\u0005\u0018\u00010\u0097\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001b\u0010\u0099\u0002R\u001b\u0010Å\u0003\u001a\u0005\u0018\u00010\u0091\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001c\u0010\u0093\u0002R\u0019\u0010Æ\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010\u008c\u0002R\u0018\u0010Ç\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\be\u0010Ç\u0002R\u0018\u0010È\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bc\u0010\u008c\u0002R\u0019\u0010É\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010\u008c\u0002R\u001c\u0010Ì\u0003\u001a\u0005\u0018\u00010Ê\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010Ë\u0003R\u001c\u0010Í\u0003\u001a\u0005\u0018\u00010Á\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010Â\u0003R\u001c\u0010Ð\u0003\u001a\u0005\u0018\u00010Î\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010Ï\u0003R\u0019\u0010Ñ\u0003\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010\u008c\u0002R\u0018\u0010Ò\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b^\u0010Ç\u0002R\u0019\u0010Ó\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010Ç\u0002R\u001a\u0010Õ\u0003\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0015\u0010Ô\u0003R)\u0010Ü\u0003\u001a\u00030Ö\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bs\u0010×\u0003\u001a\u0006\bØ\u0003\u0010Ù\u0003\"\u0006\bÚ\u0003\u0010Û\u0003R\u0017\u0010ß\u0003\u001a\u00030Ý\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000e\u0010Þ\u0003R\u0019\u0010à\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010Ç\u0002R\u0018\u0010á\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\br\u0010Ç\u0002R\u0019\u0010â\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010Ç\u0002R\u0019\u0010ã\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Ç\u0002R\u0018\u0010ä\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b=\u0010Ç\u0002R\u0019\u0010æ\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0003\u0010Ç\u0002R\u0018\u0010ç\u0003\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\b\u0010\u009e\u0002R\u0017\u0010è\u0003\u001a\u00030Á\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bY\u0010Â\u0003R\u0017\u0010é\u0003\u001a\u00030Ö\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\\\u0010×\u0003R\u0018\u0010ì\u0003\u001a\u00030ê\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bØ\u0003\u0010ë\u0003R\u001c\u0010î\u0003\u001a\u0005\u0018\u00010¶\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0002\u0010í\u0003R\u0018\u0010ï\u0003\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bu\u0010Ç\u0002R\u0018\u0010ò\u0003\u001a\u00030ð\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010ñ\u0003R\u0018\u0010õ\u0003\u001a\u00030ó\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010ô\u0003R\u0018\u0010ø\u0003\u001a\u00030ö\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010÷\u0003R\u0018\u0010û\u0003\u001a\u00030ù\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010ú\u0003R\u0017\u0010þ\u0003\u001a\u00030ü\u00038\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bw\u0010ý\u0003R*\u0010\u0084\u0004\u001a\u00030ÿ\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009b\u0001\u0010\u0080\u0004\u001a\u0006\bå\u0003\u0010\u0081\u0004\"\u0006\b\u0082\u0004\u0010\u0083\u0004R\u0017\u0010\u0087\u0004\u001a\u00030\u0085\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bV\u0010\u0086\u0004R\u0017\u0010\u008a\u0004\u001a\u00030\u0088\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u001e\u0010\u0089\u0004R\u001e\u0010\u008e\u0004\u001a\t\u0012\u0004\u0012\u0002080\u008b\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0004\u0010\u008d\u0004R\u001d\u0010\u008f\u0004\u001a\t\u0012\u0004\u0012\u0002080\u008b\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0013\u0010\u008d\u0004R\u0019\u0010\u0091\u0004\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0004\u0010\u008c\u0002R\u0017\u0010\u0092\u0004\u001a\u00030\u0088\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0016\u0010\u0089\u0004R\u001a\u0010\u0093\u0004\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0014\u0010£\u0002R\u0018\u0010\u0094\u0004\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u000b\u0010£\u0002R\u001b\u0010\u0097\u0004\u001a\u0005\u0018\u00010\u0095\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0017\u0010\u0096\u0004¨\u0006\u009d\u0004"}, d2 = {"Lcom/live/evo/activity/LiveNewActivity;", "Lcom/live/evo/activity/base/BaseActivity;", "Landroid/view/View$OnKeyListener;", "<init>", "()V", "Landroid/content/Intent;", "intent", "", "u2", "(Landroid/content/Intent;)Ljava/lang/String;", "Lr8/z;", "N2", "(Landroid/content/Intent;)V", "channelId", "n2", "(Ljava/lang/String;)V", "R2", "T2", "S2", "J2", "M2", "l2", "L2", "O2", "P2", "G3", "E3", "Z1", "a2", "M3", "H2", "Y3", "l4", "", "delay", "j4", "(J)V", "", "exitThread", "m4", "(Z)V", "q3", "b3", "()Z", "f4", "Li5/h;", "channelData", "", "headers", "proxiedUrl", "i4", "(Li5/h;Ljava/util/Map;Ljava/lang/String;)V", "", "throwable", "r3", "(Li5/h;Ljava/lang/Throwable;)V", "", "visibility", "R3", "(I)V", "C3", "s2", "resId", "j3", "(Ljava/lang/Integer;)V", "S3", "c3", "(Li5/h;)Z", "F3", "resetErrCount", "H3", "(ZI)V", "showToast", "blockShowEpg", "I3", "(ZIZZ)V", "B4", "isManual", "A3", "intentChannel", "W3", "(Li5/h;)V", "inputCode", "X3", "(Li5/h;I)V", "a4", "G2", "e4", "", "v2", "()Ljava/util/List;", "Q2", "w2", "p4", "j2", "liveData", "y3", "U3", "bDown", "d2", "newCode", "c2", "targetCategory", "targetChannel", "targetAllPos", "P3", "(III)V", "K3", "inAllPos", "b4", "favorite", "data", "E4", "(ILi5/h;)V", "p2", "m2", "Lcom/live/evo/fragment/t1$b;", "z2", "()Lcom/live/evo/fragment/t1$b;", "E2", "n4", "showType", "d4", "p3", "o3", "eventType", "times", TypedValues.TransitionType.S_DURATION, "k3", "(Ljava/lang/String;IIJ)V", "l3", "action", "h4", "o2", "a3", "channleId", "Landroid/util/Pair;", "k2", "(Ljava/lang/String;)Landroid/util/Pair;", IjkMediaMeta.IJKM_KEY_TYPE, "index", "q2", "(II)V", "tag", "f2", "(Ljava/lang/String;I)V", "Landroid/view/View;", "container", "Y1", "(Ljava/lang/String;Landroid/view/View;)V", "g2", "N3", "o4", "Landroidx/fragment/app/Fragment;", TransactionPartnerType.FRAGMENT, "F2", "(Landroidx/fragment/app/Fragment;)V", "z4", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onNewIntent", "onStart", "outState", "onSaveInstanceState", "onRestoreInstanceState", "isShow", "T3", "onResume", "onPause", "onBackPressed", "d3", "onStop", "onDestroy", "Q3", "Lnf/g;", NotificationCompat.CATEGORY_EVENT, "OnEvent", "(Lnf/g;)V", "Lnf/a0;", "(Lnf/a0;)V", "Lnf/z;", "(Lnf/z;)V", "Lnf/f;", "onEvent", "(Lnf/f;)V", "position", "b2", "Landroid/view/KeyEvent;", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "v", "keyCode", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", "D2", "(I)Ljava/lang/String;", "C4", "e2", "C2", "()I", "A2", "()Li5/h;", "B2", "(I)Li5/h;", "i2", "channelName", "h2", "(Ljava/lang/String;Ljava/lang/String;I)I", "Lb5/d;", "onClearHistory", "(Lb5/d;)V", "closeOsd", "k4", "message", "X1", "withProcess", "r2", "V3", "L3", "Lb5/i;", "onServiceExpired", "(Lb5/i;)V", "Li5/x;", "noticeItem", "onNotice", "(Li5/x;)V", "Lnf/m;", "(Lnf/m;)V", "Lb5/k;", "onSubscribe", "(Lb5/k;)V", "Lnf/x;", "(Lnf/x;)V", "bShow", "D4", "requestCode", "resultCode", "onActivityResult", "(IILandroid/content/Intent;)V", "Lb5/l;", "onTokenChange", "(Lb5/l;)V", "Lb5/e;", "onForceLogoutEvent", "(Lb5/e;)V", "Lb5/b;", "onChangeChannelEvent", "(Lb5/b;)V", "Lb5/c;", "onChannelUpdateEvent", "(Lb5/c;)V", "J3", "Lq6/b;", "kotlin.jvm.PlatformType", "h", "Lq6/b;", "logger", "Lt/v/c/widget/videoview/PlayerView;", "i", "Lt/v/c/widget/videoview/PlayerView;", "y2", "()Lt/v/c/widget/videoview/PlayerView;", "setMVideoView", "(Lt/v/c/widget/videoview/PlayerView;)V", "mVideoView", "j", "Z", "isPopupLoginOrRenewFragment", "k", "Landroid/view/View;", "player_stat_container", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "mPlayerStatInfoView", "m", "mPrtStatInfoView", "Landroid/widget/RelativeLayout;", "n", "Landroid/widget/RelativeLayout;", "mContainer", "o", "isInputProgramNum", "p", "I", "mPlayerInfoWhat", "q", "isChangeChannel", "r", "Ljava/lang/String;", "mVideoPath", "s", "mIsAdult", "Ljava/util/Timer;", "t", "Ljava/util/Timer;", "mTimer", "Lcom/live/evo/osd/j;", "u", "Lcom/live/evo/osd/j;", "mOsdProgramNum", "Lcom/live/evo/osd/h;", "Lcom/live/evo/osd/h;", "mOsdManager", "Lcom/live/evo/osd/i;", "w", "Lcom/live/evo/osd/i;", "mOsdNetwork", "Lcom/live/evo/osd/l;", "x", "Lcom/live/evo/osd/l;", "mOsdProgramPromptSignalPoor", "y", "mOsdProgramPromptLoading", "z", "mOsdProgramPromptRetrying", "Lcom/live/evo/osd/k;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/live/evo/osd/k;", "mOsdProgramPromptOptimizing", "Lcom/live/evo/activity/LiveNewActivity$b;", "B", "Lcom/live/evo/activity/LiveNewActivity$b;", "ecoModeAction", "C", "J", "lastKeyTime", "D", "isOnKeyAfterFocusLost", ExifInterface.LONGITUDE_EAST, "playGroupIdx", "F", "playInGroupIdx", "G", "playInAllIdx", "H", "canClickUpDown", "Lcom/live/evo/fragment/t1$b;", "networkTester", "lookBackInfo", "Lcom/live/evo/osd/persenter/c;", "K", "Lcom/live/evo/osd/persenter/c;", "mOSDListProgramPresenter", "Lcom/live/evo/activity/LiveNewActivity$c;", "L", "Lcom/live/evo/activity/LiveNewActivity$c;", "mOsdPromptRunnable", "M", "Li5/h;", "lastPlayedLiveChannel", "N", "lastStartLiveChannel", "O", "Ljava/util/List;", "mListLiveDataAll", "P", "mCategoryIdList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Q", "Ljava/util/HashMap;", "mMapCategoryPrograms", "Li5/i;", "R", "Ljava/util/Map;", "mGroupsList", ExifInterface.LATITUDE_SOUTH, "mLiveErrorCount", ExifInterface.GPS_DIRECTION_TRUE, "mLiveLastError", "Lcom/live/evo/util/i1;", "U", "Lcom/live/evo/util/i1;", "mKeyUpDownRepeatHandler", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "mInputCodeRepeatHandler", "Lcom/live/evo/activity/n2;", ExifInterface.LONGITUDE_WEST, "Lcom/live/evo/activity/n2;", "livePlayHandler", "X", "isFirstSlivePlayHandlertart", "Lcom/live/evo/fragment/b0;", "Y", "Lcom/live/evo/fragment/b0;", "feedbackDialogFragment", "Lcom/live/evo/widget/SpeedTextView;", "Lcom/live/evo/widget/SpeedTextView;", "mNoticeView", "Lcom/live/evo/activity/LiveNewActivity$d;", "b1", "Lcom/live/evo/activity/LiveNewActivity$d;", "rechargeAction", "D1", "mNoSignal", "Landroid/widget/ImageView;", "E1", "Landroid/widget/ImageView;", "mNoSignalIv", "Lcom/live/evo/g;", "F1", "Lcom/live/evo/g;", "mUiManager", "Lcom/live/evo/activity/LiveNewActivity$e;", "G1", "Lcom/live/evo/activity/LiveNewActivity$e;", "trafficTask", "Lcom/live/evo/dialog/q;", "H1", "Lcom/live/evo/dialog/q;", "noticeAlertDialog", "I1", "isRemoveFavorite", "J1", "brtStatInfo", "K1", "mBufferingAllocateByPosition", "L1", "mBufferingStartTime", "M1", "mBufferingStartChannel", "N1", "mBufferingTimes", "O1", "mBufferingDuration", "P1", "prtTsList", "Q1", "mPlayType", "R1", "mExpiredStatus", "Lcom/live/evo/dialog/u;", "S1", "Lcom/live/evo/dialog/u;", "subscribeDialog", "Landroid/view/ViewStub;", "T1", "Landroid/view/ViewStub;", "mExpiredLayout", "U1", "mExpiredTitle", "V1", "mTVCountdownTime", "W1", "mRechargeGuide", "mMemberQR", "Ljava/util/TimerTask;", "Ljava/util/TimerTask;", "expiredRemindTimeTask", "mExpiredParent", "mRechargeHint", "mIsAppUpdateDialogShowing", "expiredExperienceTimes", "isPlayFavoriteList", "mBackpressedAgain", "Lcom/live/evo/widget/sloading/SLoadingView;", "Lcom/live/evo/widget/sloading/SLoadingView;", "mLoadingView", "replayTask", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "mMosaicView", "isFirstStart", "lastPlayTime", "tipNoNetworkTime", "Ljava/lang/Integer;", "resumeFrom", "Landroid/os/Handler;", "Landroid/os/Handler;", "x2", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mHandler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "preparePlayAction", "mTrafficOldBytes", "mTrafficBytes", "mTrafficOldBytesRx", "mTrafficBytesRx", "mTrafficOldBytesTx", "t2", "mTrafficBytesTx", "mTrafficCount", "mTimerTaskGetPlayPos", "mTrafficHandler", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mMsgReceiver", "Lnf/z;", "upgradeEvent", "lastUpgradeEventTime", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "mVideoPrepareListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "mVideoOnErrorListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "mVideoOnInfoListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnBufferingUpdateListener;", "mVideoOnBufferingUpdateListener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "mVideoOnCompletionListener", "Lx4/a;", "Lx4/a;", "()Lx4/a;", "setCatchUpClickListener", "(Lx4/a;)V", "catchUpClickListener", "Lcom/live/evo/osd/u$a;", "Lcom/live/evo/osd/u$a;", "mSubscribeListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLogoutDlgShow", "Lj8/c;", "I2", "Lj8/c;", "changeChannelByKeyUpDownAction", "changeChannelByInputCodeAction", "K2", "isInLogout", "isInChecking", "apkFile", "lastVersion", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "upgradeInfo", "a", "d", "b", "e", "c", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LiveNewActivity extends com.live.evo.activity.base.BaseActivity implements View.OnKeyListener {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private com.live.evo.osd.k mOsdProgramPromptOptimizing;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private b ecoModeAction;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private long lastKeyTime;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private boolean isOnKeyAfterFocusLost;

    /* JADX INFO: renamed from: D1, reason: from kotlin metadata */
    private View mNoSignal;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private int playGroupIdx;

    /* JADX INFO: renamed from: E1, reason: from kotlin metadata */
    private ImageView mNoSignalIv;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private int playInGroupIdx;

    /* JADX INFO: renamed from: F1, reason: from kotlin metadata */
    private com.live.evo.g mUiManager;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private int playInAllIdx;

    /* JADX INFO: renamed from: G1, reason: from kotlin metadata */
    private e trafficTask;

    /* JADX INFO: renamed from: H1, reason: from kotlin metadata */
    private com.live.evo.dialog.q noticeAlertDialog;

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private com.live.evo.fragment.t1.b networkTester;

    /* JADX INFO: renamed from: I1, reason: from kotlin metadata */
    private boolean isRemoveFavorite;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private String lookBackInfo;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private com.live.evo.osd.persenter.c mOSDListProgramPresenter;

    /* JADX INFO: renamed from: K1, reason: from kotlin metadata */
    private boolean mBufferingAllocateByPosition;

    /* JADX INFO: renamed from: K2, reason: from kotlin metadata */
    private boolean isInLogout;

    /* JADX INFO: renamed from: L1, reason: from kotlin metadata */
    private long mBufferingStartTime;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private i5.h lastPlayedLiveChannel;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private i5.h lastStartLiveChannel;

    /* JADX INFO: renamed from: N1, reason: from kotlin metadata */
    private int mBufferingTimes;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private List<? extends i5.h> mListLiveDataAll;

    /* JADX INFO: renamed from: O1, reason: from kotlin metadata */
    private long mBufferingDuration;

    /* JADX INFO: renamed from: O2, reason: from kotlin metadata */
    private UpgradeInfo upgradeInfo;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private List<String> mCategoryIdList;

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    private HashMap<String, List<i5.h>> mMapCategoryPrograms;

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    private Map<String, ? extends i5.i> mGroupsList;

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    private int mLiveErrorCount;

    /* JADX INFO: renamed from: S1, reason: from kotlin metadata */
    private com.live.evo.dialog.u subscribeDialog;

    /* JADX INFO: renamed from: T1, reason: from kotlin metadata */
    private ViewStub mExpiredLayout;

    /* JADX INFO: renamed from: U1, reason: from kotlin metadata */
    private TextView mExpiredTitle;

    /* JADX INFO: renamed from: V1, reason: from kotlin metadata */
    private TextView mTVCountdownTime;

    /* JADX INFO: renamed from: W, reason: from kotlin metadata */
    private n2 livePlayHandler;

    /* JADX INFO: renamed from: W1, reason: from kotlin metadata */
    private TextView mRechargeGuide;

    /* JADX INFO: renamed from: X1, reason: from kotlin metadata */
    private ImageView mMemberQR;

    /* JADX INFO: renamed from: Y, reason: from kotlin metadata */
    private com.live.evo.fragment.b0 feedbackDialogFragment;

    /* JADX INFO: renamed from: Y1, reason: from kotlin metadata */
    private TimerTask expiredRemindTimeTask;

    /* JADX INFO: renamed from: Z, reason: from kotlin metadata */
    private SpeedTextView mNoticeView;

    /* JADX INFO: renamed from: Z1, reason: from kotlin metadata */
    private RelativeLayout mExpiredParent;

    /* JADX INFO: renamed from: a2, reason: collision with root package name and from kotlin metadata */
    private TextView mRechargeHint;

    /* JADX INFO: renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private d rechargeAction;

    /* JADX INFO: renamed from: b2, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAppUpdateDialogShowing;

    /* JADX INFO: renamed from: c2, reason: collision with root package name and from kotlin metadata */
    private long expiredExperienceTimes;

    /* JADX INFO: renamed from: d2, reason: collision with root package name and from kotlin metadata */
    private boolean isPlayFavoriteList;

    /* JADX INFO: renamed from: e2, reason: collision with root package name and from kotlin metadata */
    private boolean mBackpressedAgain;

    /* JADX INFO: renamed from: f2, reason: collision with root package name and from kotlin metadata */
    private SLoadingView mLoadingView;

    /* JADX INFO: renamed from: g2, reason: collision with root package name and from kotlin metadata */
    private TimerTask replayTask;

    /* JADX INFO: renamed from: h2, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mMosaicView;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PlayerView mVideoView;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isPopupLoginOrRenewFragment;

    /* JADX INFO: renamed from: j2, reason: collision with root package name and from kotlin metadata */
    private long lastPlayTime;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private View player_stat_container;

    /* JADX INFO: renamed from: k2, reason: collision with root package name and from kotlin metadata */
    private long tipNoNetworkTime;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TextView mPlayerStatInfoView;

    /* JADX INFO: renamed from: l2, reason: collision with root package name and from kotlin metadata */
    private Integer resumeFrom;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mPrtStatInfoView;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mContainer;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isInputProgramNum;

    /* JADX INFO: renamed from: o2, reason: collision with root package name and from kotlin metadata */
    private long mTrafficOldBytes;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int mPlayerInfoWhat;

    /* JADX INFO: renamed from: p2, reason: collision with root package name and from kotlin metadata */
    private long mTrafficBytes;

    /* JADX INFO: renamed from: q2, reason: collision with root package name and from kotlin metadata */
    private long mTrafficOldBytesRx;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String mVideoPath;

    /* JADX INFO: renamed from: r2, reason: collision with root package name and from kotlin metadata */
    private long mTrafficBytesRx;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAdult;

    /* JADX INFO: renamed from: s2, reason: collision with root package name and from kotlin metadata */
    private long mTrafficOldBytesTx;

    /* JADX INFO: renamed from: t2, reason: collision with root package name and from kotlin metadata */
    private long mTrafficBytesTx;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.j mOsdProgramNum;

    /* JADX INFO: renamed from: u2, reason: collision with root package name and from kotlin metadata */
    private int mTrafficCount;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.h mOsdManager;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.i mOsdNetwork;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.l mOsdProgramPromptSignalPoor;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.l mOsdProgramPromptLoading;

    /* JADX INFO: renamed from: y2, reason: collision with root package name and from kotlin metadata */
    private nf.z upgradeEvent;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.l mOsdProgramPromptRetrying;

    /* JADX INFO: renamed from: z2, reason: collision with root package name and from kotlin metadata */
    private long lastUpgradeEventTime;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(LiveNewActivity.class);

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isChangeChannel = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Timer mTimer = new Timer();

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private boolean canClickUpDown = true;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private final c mOsdPromptRunnable = new c();

    /* JADX INFO: renamed from: T, reason: from kotlin metadata */
    private String mLiveLastError = "";

    /* JADX INFO: renamed from: U, reason: from kotlin metadata */
    private final com.live.evo.util.i1 mKeyUpDownRepeatHandler = new com.live.evo.util.i1(100);

    /* JADX INFO: renamed from: V, reason: from kotlin metadata */
    private final com.live.evo.util.i1 mInputCodeRepeatHandler = new com.live.evo.util.i1(2000);

    /* JADX INFO: renamed from: X, reason: from kotlin metadata */
    private boolean isFirstSlivePlayHandlertart = true;

    /* JADX INFO: renamed from: J1, reason: from kotlin metadata */
    private String brtStatInfo = "";

    /* JADX INFO: renamed from: M1, reason: from kotlin metadata */
    private int mBufferingStartChannel = -1;

    /* JADX INFO: renamed from: P1, reason: from kotlin metadata */
    private String prtTsList = "";

    /* JADX INFO: renamed from: Q1, reason: from kotlin metadata */
    private String mPlayType = "";

    /* JADX INFO: renamed from: R1, reason: from kotlin metadata */
    private int mExpiredStatus = -1;

    /* JADX INFO: renamed from: i2, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstStart = true;

    /* JADX INFO: renamed from: m2, reason: collision with root package name and from kotlin metadata */
    private Handler mHandler = new l(Looper.getMainLooper());

    /* JADX INFO: renamed from: n2, reason: collision with root package name and from kotlin metadata */
    private final Runnable preparePlayAction = new Runnable() { // from class: com.live.evo.activity.o0
        @Override // java.lang.Runnable
        public final void run() {
            LiveNewActivity.D3(this.f5489a);
        }
    };

    /* JADX INFO: renamed from: v2, reason: collision with root package name and from kotlin metadata */
    private final TimerTask mTimerTaskGetPlayPos = new n();

    /* JADX INFO: renamed from: w2, reason: collision with root package name and from kotlin metadata */
    private final Handler mTrafficHandler = new o(Looper.getMainLooper());

    /* JADX INFO: renamed from: x2, reason: collision with root package name and from kotlin metadata */
    private final BroadcastReceiver mMsgReceiver = new BroadcastReceiver() { // from class: com.live.evo.activity.LiveNewActivity$mMsgReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            i5.h hVarA2;
            kotlin.jvm.internal.m.f(context, "context");
            kotlin.jvm.internal.m.f(intent, "intent");
            if (kotlin.jvm.internal.m.a("com.bb.action.EPG", intent.getAction())) {
                this.f5364a.B4();
                return;
            }
            if (kotlin.jvm.internal.m.a("android.net.conn.CONNECTIVITY_CHANGE", intent.getAction())) {
                if (!this.f5364a.m2()) {
                    if (x1.f1.lb.util.d0.f21360a.j()) {
                        return;
                    }
                    this.f5364a.getMHandler().sendEmptyMessage(620908545);
                    return;
                } else {
                    zf.f fVarE = zf.f.e();
                    if (fVarE != null) {
                        fVarE.u();
                        return;
                    }
                    return;
                }
            }
            int size = 0;
            if (kotlin.jvm.internal.m.a("com.bb.action.FAVORITE", intent.getAction())) {
                int intExtra = intent.getIntExtra("channelFavorite", 0);
                String stringExtra = intent.getStringExtra("channelId");
                String stringExtra2 = intent.getStringExtra("channelName");
                int iH2 = this.f5364a.playInAllIdx;
                if (TextUtils.isEmpty(stringExtra)) {
                    this.f5364a.i2(intExtra);
                } else {
                    iH2 = this.f5364a.h2(stringExtra, stringExtra2, intExtra);
                }
                if (com.live.evo.k.b().d() && this.f5364a.playGroupIdx == com.live.evo.k.b().a() && intExtra == 0) {
                    this.f5364a.isRemoveFavorite = true;
                }
                if (com.live.evo.k.b().d() && intExtra == 0 && (hVarA2 = this.f5364a.A2()) != null && iH2 == hVarA2.i()) {
                    this.f5364a.isRemoveFavorite = true;
                    this.f5364a.isPlayFavoriteList = false;
                    this.f5364a.playGroupIdx = 0;
                    this.f5364a.playInGroupIdx = iH2;
                    return;
                }
                return;
            }
            if (kotlin.jvm.internal.m.a("com.bb.action.EXIT", intent.getAction())) {
                this.f5364a.r2(intent.getBooleanExtra("withProcess", false));
                return;
            }
            if (kotlin.jvm.internal.m.a("com.bb.action.feedback", intent.getAction())) {
                this.f5364a.e4();
                return;
            }
            if (kotlin.jvm.internal.m.a("com.bb.action.AddPIP", intent.getAction())) {
                if (com.live.evo.k.b().l()) {
                    x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                    String strJ = com.live.evo.util.x1.j(2131952573);
                    kotlin.jvm.internal.m.e(strJ, "getString(...)");
                    g1Var.c(strJ);
                    return;
                }
                return;
            }
            if (kotlin.jvm.internal.m.a("com.bb.action.switchpip", intent.getAction())) {
                if (com.live.evo.k.b().l()) {
                    x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
                    String strJ2 = com.live.evo.util.x1.j(R$string.pip_not_open);
                    kotlin.jvm.internal.m.e(strJ2, "getString(...)");
                    g1Var2.c(strJ2);
                    return;
                }
                return;
            }
            if (kotlin.jvm.internal.m.a("com.bb.action.closepip", intent.getAction())) {
                com.live.evo.k.b().l();
                return;
            }
            if (!kotlin.jvm.internal.m.a("com.bb.action.switchprogram", intent.getAction())) {
                if (kotlin.jvm.internal.m.a("com.bb.action.popupmenuview", intent.getAction())) {
                    if (com.live.evo.k.b().l()) {
                        this.f5364a.a4();
                        return;
                    }
                    com.live.evo.g gVar = this.f5364a.mUiManager;
                    if (gVar != null) {
                        gVar.t();
                        return;
                    }
                    return;
                }
                if (!kotlin.jvm.internal.m.a("com.bb.action.showprogram", intent.getAction())) {
                    if (kotlin.jvm.internal.m.a("com.bb.action.update", intent.getAction())) {
                        this.f5364a.o2();
                        return;
                    }
                    return;
                }
                com.live.evo.osd.persenter.c cVar = this.f5364a.mOSDListProgramPresenter;
                if (cVar != null) {
                    LiveNewActivity liveNewActivity = this.f5364a;
                    if (intent.getIntExtra("showType", 0) == 1) {
                        cVar.M(liveNewActivity.getSupportFragmentManager(), "Search");
                    } else {
                        cVar.M(liveNewActivity.getSupportFragmentManager(), "Channel List");
                    }
                }
                this.f5364a.G2();
                return;
            }
            int intExtra2 = intent.getIntExtra("playindex", 0);
            int intExtra3 = intent.getIntExtra("playGroupindex", 0);
            List list = this.f5364a.mCategoryIdList;
            if (list == null || list.isEmpty()) {
                this.f5364a.mCategoryIdList = t.v.c.i.a.f18646a.u(Boolean.TRUE);
            }
            List list2 = this.f5364a.mCategoryIdList;
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            HashMap map = this.f5364a.mMapCategoryPrograms;
            List list3 = null;
            if (map != null) {
                List list4 = this.f5364a.mCategoryIdList;
                list3 = (List) map.get(list4 != null ? (String) list4.get(intExtra3) : null);
            }
            List list5 = list3;
            if (list5 == null || list5.isEmpty()) {
                return;
            }
            if (intExtra2 < 0) {
                size = list3.size() - 1;
            } else if (intExtra2 < list3.size()) {
                size = intExtra2;
            }
            i5.h hVar = (i5.h) list3.get(size);
            i5.h hVarA3 = this.f5364a.A2();
            if (hVarA3 != null && hVarA3.equals(hVar)) {
                this.f5364a.mKeyUpDownRepeatHandler.c();
            }
            this.f5364a.playInGroupIdx = size;
            this.f5364a.playGroupIdx = intExtra3;
        }
    };

    /* JADX INFO: renamed from: A2, reason: from kotlin metadata */
    private final IMediaPlayer.OnPreparedListener mVideoPrepareListener = new IMediaPlayer.OnPreparedListener() { // from class: com.live.evo.activity.p0
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public final void onPrepared(IMediaPlayer iMediaPlayer) {
            LiveNewActivity.i3(this.f5494a, iMediaPlayer);
        }
    };

    /* JADX INFO: renamed from: B2, reason: from kotlin metadata */
    private final IMediaPlayer.OnErrorListener mVideoOnErrorListener = new IMediaPlayer.OnErrorListener() { // from class: com.live.evo.activity.q0
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public final boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
            return LiveNewActivity.g3(this.f5501a, iMediaPlayer, i10, i11);
        }
    };

    /* JADX INFO: renamed from: C2, reason: from kotlin metadata */
    private final IMediaPlayer.OnInfoListener mVideoOnInfoListener = new p();

    /* JADX INFO: renamed from: D2, reason: from kotlin metadata */
    private final IMediaPlayer.OnBufferingUpdateListener mVideoOnBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.live.evo.activity.r0
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i10) {
            LiveNewActivity.e3(iMediaPlayer, i10);
        }
    };

    /* JADX INFO: renamed from: E2, reason: from kotlin metadata */
    private final IMediaPlayer.OnCompletionListener mVideoOnCompletionListener = new IMediaPlayer.OnCompletionListener() { // from class: com.live.evo.activity.s0
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public final void onCompletion(IMediaPlayer iMediaPlayer) {
            LiveNewActivity.f3(iMediaPlayer);
        }
    };

    /* JADX INFO: renamed from: F2, reason: from kotlin metadata */
    private x4.a catchUpClickListener = new x4.d(this);

    /* JADX INFO: renamed from: G2, reason: from kotlin metadata */
    private final com.live.evo.osd.u.a mSubscribeListener = new m();

    /* JADX INFO: renamed from: H2, reason: from kotlin metadata */
    private final AtomicBoolean isLogoutDlgShow = new AtomicBoolean(false);

    /* JADX INFO: renamed from: I2, reason: from kotlin metadata */
    private final j8.c<Integer> changeChannelByKeyUpDownAction = new h();

    /* JADX INFO: renamed from: J2, reason: from kotlin metadata */
    private final j8.c<Integer> changeChannelByInputCodeAction = new g();

    /* JADX INFO: renamed from: L2, reason: from kotlin metadata */
    private final AtomicBoolean isInChecking = new AtomicBoolean(false);

    /* JADX INFO: renamed from: M2, reason: from kotlin metadata */
    private String apkFile = "";

    /* JADX INFO: renamed from: N2, reason: from kotlin metadata */
    private String lastVersion = "";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"com/live/evo/activity/LiveNewActivity$a0", "Lcom/live/evo/osd/a;", "Lr8/z;", "e", "()V", "a", "b", "c", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a0 implements com.live.evo.osd.a {
        a0() {
        }

        @Override // com.live.evo.osd.p
        public void a() {
            LiveNewActivity.this.isPopupLoginOrRenewFragment = false;
        }

        @Override // com.live.evo.osd.p
        public void b() {
            LiveNewActivity.this.isPopupLoginOrRenewFragment = false;
        }

        @Override // com.live.evo.osd.a
        public void c() {
            LiveNewActivity.this.isPopupLoginOrRenewFragment = false;
            LiveNewActivity.this.N3();
        }

        @Override // com.live.evo.osd.p
        public void e() {
            LiveNewActivity.this.isPopupLoginOrRenewFragment = false;
            LiveNewActivity.this.N3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/live/evo/activity/LiveNewActivity$b;", "Ljava/lang/Runnable;", "Lcom/live/evo/activity/LiveNewActivity;", "activity", "<init>", "(Lcom/live/evo/activity/LiveNewActivity;)V", "Lr8/z;", "run", "()V", "a", "Lcom/live/evo/activity/LiveNewActivity;", "()Lcom/live/evo/activity/LiveNewActivity;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final LiveNewActivity activity;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/activity/LiveNewActivity$b$a", "Lcom/live/evo/dialog/c$c;", "", NotificationCompat.CATEGORY_STATUS, "Lr8/z;", "a", "(I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements com.live.evo.dialog.c.InterfaceC0071c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.live.evo.dialog.c f5348b;

            a(com.live.evo.dialog.c cVar) {
                this.f5348b = cVar;
            }

            @Override // com.live.evo.dialog.c.InterfaceC0071c
            public void a(int status) {
                if (status == 0) {
                    x1.f1.lb.util.d0.f21360a.n();
                    com.live.evo.l.n().S(0);
                    if (b.this.getActivity().b3()) {
                        com.live.evo.osd.persenter.c cVar = b.this.getActivity().mOSDListProgramPresenter;
                        if (cVar != null) {
                            cVar.M(b.this.getActivity().getSupportFragmentManager(), "Channel List");
                        }
                        b.this.getActivity().y3(b.this.getActivity().A2());
                    }
                    this.f5348b.cancel();
                    b.this.getActivity().G3();
                    b.this.getActivity().M3();
                    return;
                }
                if (status == 1) {
                    this.f5348b.dismiss();
                    b.this.getActivity().r2(true);
                    return;
                }
                if (status == 3) {
                    x1.f1.lb.util.d0.f21360a.h();
                    PlayerView mVideoView = b.this.getActivity().getMVideoView();
                    if (mVideoView != null) {
                        mVideoView.J(true);
                    }
                    com.live.evo.l.n().S(2);
                    return;
                }
                if (status != 4) {
                    return;
                }
                b bVar = b.this.getActivity().ecoModeAction;
                if (bVar != null) {
                    b.this.getActivity().getMHandler().removeCallbacks(bVar);
                }
                x1.f1.lb.util.d0.f21360a.n();
            }
        }

        public b(LiveNewActivity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            this.activity = activity;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final LiveNewActivity getActivity() {
            return this.activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.live.evo.dialog.c cVar = new com.live.evo.dialog.c(this.activity);
            cVar.show();
            cVar.e(new a(cVar));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$toLogoutProcess$7", f = "LiveNewActivity.kt", l = {3853}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b0 extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$toLogoutProcess$7$1", f = "LiveNewActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LiveNewActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LiveNewActivity liveNewActivity, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = liveNewActivity;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void f(LiveNewActivity liveNewActivity) {
                com.live.evo.osd.l lVar = liveNewActivity.mOsdProgramPromptLoading;
                if (lVar != null) {
                    lVar.f();
                }
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    Handler mHandler = this.this$0.getMHandler();
                    final LiveNewActivity liveNewActivity = this.this$0;
                    mHandler.post(new Runnable() { // from class: com.live.evo.activity.l2
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveNewActivity.b0.a.f(liveNewActivity);
                        }
                    });
                    this.this$0.logger.error("stream token expired, login failure", th);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveNewActivity f5349a;

            b(LiveNewActivity liveNewActivity) {
                this.f5349a = liveNewActivity;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object emit(final r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                Handler mHandler = this.f5349a.getMHandler();
                final LiveNewActivity liveNewActivity = this.f5349a;
                mHandler.post(new Runnable() { // from class: com.live.evo.activity.m2
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.b0.b.d(liveNewActivity, uVar);
                    }
                });
                return r8.z.f17874a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void d(LiveNewActivity liveNewActivity, r8.u uVar) {
                com.live.evo.osd.l lVar = liveNewActivity.mOsdProgramPromptLoading;
                if (lVar != null) {
                    lVar.f();
                }
                if (!((Boolean) uVar.d()).booleanValue()) {
                    liveNewActivity.logger.error("stream token expired, login failure[" + uVar.f() + "(" + uVar.e() + ")", new Object[0]);
                    return;
                }
                liveNewActivity.N3();
            }
        }

        b0(v8.f<? super b0> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return LiveNewActivity.this.new b0(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b0) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(t.v.c.i.a.f18646a.x0(), new a(LiveNewActivity.this, null));
                b bVar = new b(LiveNewActivity.this);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u0007\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/live/evo/activity/LiveNewActivity$c;", "Ljava/lang/Runnable;", "<init>", "()V", "Lr8/z;", "run", "", "a", "I", "getRepeatCnt", "()I", "(I)V", "repeatCnt", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int repeatCnt;

        public final void a(int i10) {
            this.repeatCnt = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"com/live/evo/activity/LiveNewActivity$c0", "Lcom/live/evo/osd/a;", "Lr8/z;", "e", "()V", "a", "b", "c", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c0 implements com.live.evo.osd.a {
        c0() {
        }

        @Override // com.live.evo.osd.p
        public void a() {
            LiveNewActivity.this.isPopupLoginOrRenewFragment = false;
        }

        @Override // com.live.evo.osd.p
        public void b() {
            LiveNewActivity.this.isPopupLoginOrRenewFragment = false;
        }

        @Override // com.live.evo.osd.a
        public void c() {
            LiveNewActivity.this.isPopupLoginOrRenewFragment = false;
        }

        @Override // com.live.evo.osd.p
        public void e() {
            LiveNewActivity.this.isPopupLoginOrRenewFragment = false;
            LiveNewActivity.this.N3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/live/evo/activity/LiveNewActivity$d;", "Ljava/lang/Runnable;", "Lcom/live/evo/activity/LiveNewActivity;", "activity", "<init>", "(Lcom/live/evo/activity/LiveNewActivity;)V", "Lr8/z;", "run", "()V", "a", "Lcom/live/evo/activity/LiveNewActivity;", "getActivity", "()Lcom/live/evo/activity/LiveNewActivity;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final LiveNewActivity activity;

        public d(LiveNewActivity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            this.activity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.activity.d4(24);
            this.activity.E3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/live/evo/activity/LiveNewActivity$e;", "Ljava/util/TimerTask;", "Lcom/live/evo/activity/LiveNewActivity;", "activity", "<init>", "(Lcom/live/evo/activity/LiveNewActivity;)V", "Lr8/z;", "run", "()V", "a", "Lcom/live/evo/activity/LiveNewActivity;", "getActivity", "()Lcom/live/evo/activity/LiveNewActivity;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class e extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final LiveNewActivity activity;

        public e(LiveNewActivity activity) {
            kotlin.jvm.internal.m.f(activity, "activity");
            this.activity = activity;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.activity.mTrafficOldBytes == 0) {
                this.activity.mTrafficOldBytes = com.live.evo.util.x1.i();
            } else {
                long jI = com.live.evo.util.x1.i();
                LiveNewActivity liveNewActivity = this.activity;
                liveNewActivity.mTrafficBytes = jI - liveNewActivity.mTrafficOldBytes;
                this.activity.mTrafficOldBytes = jI;
            }
            this.activity.mTrafficHandler.sendEmptyMessage(0);
            if (this.activity.mTrafficOldBytesRx == 0) {
                this.activity.mTrafficOldBytesRx = com.live.evo.util.x1.i();
            } else {
                long jI2 = com.live.evo.util.x1.i();
                LiveNewActivity liveNewActivity2 = this.activity;
                liveNewActivity2.mTrafficBytesRx = jI2 - liveNewActivity2.mTrafficOldBytesRx;
                this.activity.mTrafficOldBytesRx = jI2;
            }
            if (this.activity.mTrafficOldBytesTx == 0) {
                this.activity.mTrafficOldBytesTx = com.live.evo.util.x1.l();
            } else {
                long jL = com.live.evo.util.x1.l();
                LiveNewActivity liveNewActivity3 = this.activity;
                liveNewActivity3.mTrafficBytesTx = jL - liveNewActivity3.mTrafficOldBytesTx;
                this.activity.mTrafficOldBytesTx = jL;
            }
            this.activity.mTrafficHandler.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$accountLogout$1", f = "LiveNewActivity.kt", l = {5201}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$accountLogout$1$1", f = "LiveNewActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LiveNewActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LiveNewActivity liveNewActivity, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = liveNewActivity;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void f(LiveNewActivity liveNewActivity) {
                com.live.evo.osd.l lVar = liveNewActivity.mOsdProgramPromptLoading;
                if (lVar != null) {
                    lVar.f();
                }
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    Throwable th = (Throwable) this.L$0;
                    this.this$0.isInLogout = false;
                    Handler mHandler = this.this$0.getMHandler();
                    final LiveNewActivity liveNewActivity = this.this$0;
                    mHandler.post(new Runnable() { // from class: com.live.evo.activity.z1
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveNewActivity.f.a.f(liveNewActivity);
                        }
                    });
                    x1.f1.lb.util.g1.f21390a.c(this.this$0.getString(R$string.log_out_fail) + ":" + th.getMessage());
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveNewActivity f5354a;

            b(LiveNewActivity liveNewActivity) {
                this.f5354a = liveNewActivity;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object emit(final r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                Handler mHandler = this.f5354a.getMHandler();
                final LiveNewActivity liveNewActivity = this.f5354a;
                mHandler.post(new Runnable() { // from class: com.live.evo.activity.a2
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.f.b.d(liveNewActivity, uVar);
                    }
                });
                this.f5354a.isInLogout = false;
                return r8.z.f17874a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void d(LiveNewActivity liveNewActivity, r8.u uVar) {
                com.live.evo.osd.l lVar = liveNewActivity.mOsdProgramPromptLoading;
                if (lVar != null) {
                    lVar.f();
                }
                if (!((Boolean) uVar.d()).booleanValue()) {
                    x1.f1.lb.util.g1.f21390a.c(liveNewActivity.getString(R$string.log_out_fail) + ":" + uVar.f());
                    return;
                }
                x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                String string = liveNewActivity.getString(R$string.log_out);
                kotlin.jvm.internal.m.e(string, "getString(...)");
                g1Var.c(string);
                PlayerView mVideoView = liveNewActivity.getMVideoView();
                if (mVideoView != null) {
                    mVideoView.requestFocus();
                }
                liveNewActivity.N3();
            }
        }

        f(v8.f<? super f> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return LiveNewActivity.this.new f(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(t.v.c.i.a.f18646a.A0("main_activity"), new a(LiveNewActivity.this, null));
                b bVar = new b(LiveNewActivity.this);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/activity/LiveNewActivity$g", "Lj8/c;", "", "t", "Lr8/z;", "b", "(I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g implements j8.c<Integer> {
        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(LiveNewActivity liveNewActivity) {
            liveNewActivity.isPlayFavoriteList = false;
            liveNewActivity.canClickUpDown = true;
            liveNewActivity.isInputProgramNum = false;
            com.live.evo.osd.j jVar = liveNewActivity.mOsdProgramNum;
            int iF = jVar != null ? jVar.f() : 0;
            boolean zB = a5.b.a().b();
            Map mapI = kotlin.collections.n0.i();
            Map mapI2 = kotlin.collections.n0.i();
            if (iF == liveNewActivity.playInAllIdx) {
                com.live.evo.osd.j jVar2 = liveNewActivity.mOsdProgramNum;
                if (jVar2 != null) {
                    jVar2.h(String.valueOf(iF), com.live.evo.util.x1.j(R$string.is_playing));
                    return;
                }
                return;
            }
            if (iF >= 0) {
                List list = liveNewActivity.mListLiveDataAll;
                if (iF < (list != null ? list.size() : 0)) {
                    List list2 = liveNewActivity.mListLiveDataAll;
                    i5.h hVar = list2 != null ? (i5.h) list2.get(iF) : null;
                    if (hVar != null) {
                        if (hVar.p()) {
                            com.live.evo.osd.j jVar3 = liveNewActivity.mOsdProgramNum;
                            if (jVar3 != null) {
                                jVar3.g(String.valueOf(liveNewActivity.playInAllIdx));
                                return;
                            }
                            return;
                        }
                        if (!zB || !mapI.containsKey(hVar.b())) {
                            if (!zB || mapI.containsKey(hVar.b())) {
                                liveNewActivity.playGroupIdx = 0;
                                liveNewActivity.playInGroupIdx = iF;
                                liveNewActivity.b2(iF);
                                return;
                            }
                            return;
                        }
                        for (String str : mapI2.keySet()) {
                            if (!ua.n.w(str, "favorite", true) && !ua.n.w(str, "history", true)) {
                                Object obj = mapI2.get(str);
                                kotlin.jvm.internal.m.c(obj);
                                List list3 = (List) obj;
                                int size = list3.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (list3.get(i10) != null) {
                                        i5.h hVar2 = (i5.h) list3.get(i10);
                                        if (ua.n.x(hVar2 != null ? hVar2.b() : null, hVar.b(), false, 2, null)) {
                                            List list4 = liveNewActivity.mCategoryIdList;
                                            int iIndexOf = list4 != null ? list4.indexOf(str) : 0;
                                            if (iIndexOf < 0) {
                                                iIndexOf = 0;
                                            }
                                            liveNewActivity.playGroupIdx = iIndexOf;
                                            liveNewActivity.playInGroupIdx = i10;
                                            liveNewActivity.b2(iF);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        g() {
        }

        @Override // j8.c
        public /* bridge */ /* synthetic */ void accept(Integer num) {
            b(num.intValue());
        }

        public void b(int t10) {
            final LiveNewActivity liveNewActivity = LiveNewActivity.this;
            liveNewActivity.runOnUiThread(new Runnable() { // from class: com.live.evo.activity.b2
                @Override // java.lang.Runnable
                public final void run() {
                    LiveNewActivity.g.c(liveNewActivity);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/activity/LiveNewActivity$h", "Lj8/c;", "", "t", "Lr8/z;", "b", "(I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements j8.c<Integer> {
        h() {
        }

        @Override // j8.c
        public /* bridge */ /* synthetic */ void accept(Integer num) {
            b(num.intValue());
        }

        public void b(int t10) {
            final LiveNewActivity liveNewActivity = LiveNewActivity.this;
            liveNewActivity.runOnUiThread(new Runnable() { // from class: com.live.evo.activity.c2
                @Override // java.lang.Runnable
                public final void run() {
                    LiveNewActivity.h.c(liveNewActivity);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:19:0x0041  */
        public static final void c(LiveNewActivity liveNewActivity) {
            int i10;
            String str;
            i5.h hVar;
            try {
                if (!liveNewActivity.isPlayFavoriteList) {
                    HashMap map = liveNewActivity.mMapCategoryPrograms;
                    if (map != null) {
                        List list = liveNewActivity.mCategoryIdList;
                        if (list != null) {
                            str = (String) list.get(liveNewActivity.playGroupIdx);
                        } else {
                            str = null;
                        }
                        List list2 = (List) map.get(str);
                        if (list2 != null && (hVar = (i5.h) list2.get(liveNewActivity.playInGroupIdx)) != null) {
                            i10 = hVar.i();
                        } else {
                            i10 = 0;
                        }
                    } else {
                        i10 = 0;
                    }
                    liveNewActivity.b2(i10);
                    return;
                }
                liveNewActivity.b2(liveNewActivity.playInAllIdx);
            } catch (Exception e10) {
                q6.b bVar = liveNewActivity.logger;
                kotlin.jvm.internal.m.e(bVar, "access$getLogger$p(...)");
                c5.b.c(bVar, e10, "repeater handler pulse");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$checkUpgrade$1", f = "LiveNewActivity.kt", l = {6053}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class i extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$checkUpgrade$1$2", f = "LiveNewActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lz1/b1/lb/m/extra/upgrade/UpgradeInfo;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super UpgradeInfo>, Throwable, v8.f<? super r8.z>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LiveNewActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LiveNewActivity liveNewActivity, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = liveNewActivity;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super UpgradeInfo> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void f(LiveNewActivity liveNewActivity, Throwable th) {
                x1.f1.lb.util.g1.f21390a.c(liveNewActivity.getString(R$string.check_failed) + ":" + th.getMessage());
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    final Throwable th = (Throwable) this.L$0;
                    final LiveNewActivity liveNewActivity = this.this$0;
                    liveNewActivity.runOnUiThread(new Runnable() { // from class: com.live.evo.activity.f2
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveNewActivity.i.a.f(liveNewActivity, th);
                        }
                    });
                    this.this$0.logger.error("check upgrade failure", th);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveNewActivity f5357a;

            b(LiveNewActivity liveNewActivity) {
                this.f5357a = liveNewActivity;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(UpgradeInfo upgradeInfo, v8.f<? super r8.z> fVar) {
                this.f5357a.upgradeInfo = upgradeInfo;
                this.f5357a.isInChecking.set(false);
                if ((upgradeInfo != null ? upgradeInfo.getUpgradeStatus() : 0) != 0) {
                    x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                    String string = this.f5357a.getString(R$string.update_msg);
                    kotlin.jvm.internal.m.e(string, "getString(...)");
                    g1Var.c(string);
                }
                return r8.z.f17874a;
            }
        }

        i(v8.f<? super i> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return LiveNewActivity.this.new i(fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((i) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r8.z f(final LiveNewActivity liveNewActivity, final String str, Integer num, final String str2, final nf.a0 a0Var) {
            liveNewActivity.getMHandler().post(new Runnable() { // from class: com.live.evo.activity.e2
                @Override // java.lang.Runnable
                public final void run() {
                    LiveNewActivity.i.g(liveNewActivity, str, str2, a0Var);
                }
            });
            return r8.z.f17874a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(LiveNewActivity liveNewActivity, String str, String str2, nf.a0 a0Var) {
            if (!kotlin.jvm.internal.m.a(liveNewActivity.lastVersion, str) && !TextUtils.isEmpty(str)) {
                liveNewActivity.lastVersion = str;
                x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
                String str3 = String.format("%s:%s", Arrays.copyOf(new Object[]{liveNewActivity.getString(R$string.new_version), str}, 2));
                kotlin.jvm.internal.m.e(str3, "format(...)");
                g1Var.c(str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                liveNewActivity.apkFile = str2;
                UpgradeInfo upgradeInfo = liveNewActivity.upgradeInfo;
                if (upgradeInfo != null) {
                    liveNewActivity.OnEvent(new nf.z(upgradeInfo, str2, false));
                }
            }
            if (a0Var != null) {
                x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
                String strA = a0Var.a();
                kotlin.jvm.internal.m.e(strA, "getErrMsg(...)");
                g1Var2.c(strA);
            }
            liveNewActivity.isInChecking.set(false);
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
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                Lifecycle lifecycle = LiveNewActivity.this.getLifecycle();
                final LiveNewActivity liveNewActivity = LiveNewActivity.this;
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(aVar.c(lifecycle, new c9.r() { // from class: com.live.evo.activity.d2
                    @Override // c9.r
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        return LiveNewActivity.i.f(liveNewActivity, (String) obj2, (Integer) obj3, (String) obj4, (nf.a0) obj5);
                    }
                }), new a(LiveNewActivity.this, null));
                b bVar = new b(LiveNewActivity.this);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/live/evo/activity/LiveNewActivity$j", "Lcom/live/evo/activity/n2$a;", "Li5/h;", "channelData", "", "", "headers", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "Lr8/z;", "a", "(Li5/h;Ljava/util/Map;Ljava/lang/String;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j implements n2.a {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(i5.h hVar, LiveNewActivity liveNewActivity, Map map, String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("-----onPlay: ");
            sb2.append(hVar);
            Log.i("LiveNewActivity", sb2.toString() == null ? "" : hVar.b());
            liveNewActivity.i4(hVar, map, str);
        }

        @Override // com.live.evo.activity.n2.a
        public void a(final i5.h channelData, final Map<String, String> headers, final String url) {
            kotlin.jvm.internal.m.f(channelData, "channelData");
            kotlin.jvm.internal.m.f(headers, "headers");
            kotlin.jvm.internal.m.f(url, "url");
            final LiveNewActivity liveNewActivity = LiveNewActivity.this;
            liveNewActivity.runOnUiThread(new Runnable() { // from class: com.live.evo.activity.g2
                @Override // java.lang.Runnable
                public final void run() {
                    LiveNewActivity.j.c(channelData, liveNewActivity, headers, url);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J-\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u0004R\u0014\u0010(\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u0004\u0018\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006-"}, d2 = {"com/live/evo/activity/LiveNewActivity$k", "Lcom/live/evo/osd/persenter/c$a;", "Lr8/z;", "l", "()V", "", "categorySelect", "programSelect", "inAllProgramPos", "", "playType", "j", "(IIILjava/lang/String;)V", "selectedItemPosition", "m", "(I)V", "k", "catchupType", "Li5/p;", "bean", "channelId", "b", "(Ljava/lang/String;Li5/p;Ljava/lang/String;)V", IjkMediaMeta.IJKM_KEY_TYPE, "index", "a", "(II)V", "tag", "c", "(Ljava/lang/String;I)V", "Landroid/view/View;", "container", "h", "(Ljava/lang/String;Landroid/view/View;)V", "e", "(Ljava/lang/String;)V", "d", "f", "g", "()I", "programId", "Li5/h;", "i", "()Li5/h;", "currentPlayProgram", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k implements com.live.evo.osd.persenter.c.a {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/activity/LiveNewActivity$k$a", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Z)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a implements x1.f1.lb.util.m<Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveNewActivity f5360a;

            a(LiveNewActivity liveNewActivity) {
                this.f5360a = liveNewActivity;
            }

            @Override // x1.f1.lb.util.m
            public /* bridge */ /* synthetic */ void a(Boolean bool) {
                c(bool.booleanValue());
            }

            public void c(boolean v10) {
                if (v10) {
                    this.f5360a.k4(true);
                }
            }
        }

        k() {
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void a(int type, int index) {
            LiveNewActivity.this.q2(type, index);
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void b(String catchupType, i5.p bean, String channelId) {
            LiveNewActivity.this.getCatchUpClickListener().a(catchupType, bean, channelId, new a(LiveNewActivity.this));
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void c(String tag, int index) {
            LiveNewActivity.this.f2(tag, index);
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void e(String tag) {
            LiveNewActivity.this.g2(tag);
        }

        @Override // com.live.evo.osd.persenter.c.a
        public int g() {
            return LiveNewActivity.this.C2();
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void h(String tag, View container) {
            LiveNewActivity.this.Y1(tag, container);
        }

        @Override // com.live.evo.osd.persenter.c.a
        public i5.h i() {
            return LiveNewActivity.this.A2();
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void j(int categorySelect, int programSelect, int inAllProgramPos, String playType) {
            LiveNewActivity.this.h4(playType);
            LiveNewActivity.this.isPlayFavoriteList = false;
            LiveNewActivity.this.playGroupIdx = categorySelect;
            LiveNewActivity.this.playInGroupIdx = programSelect;
            LiveNewActivity liveNewActivity = LiveNewActivity.this;
            if (playType == null) {
                playType = "";
            }
            liveNewActivity.mPlayType = playType;
            LiveNewActivity.this.b2(inAllProgramPos);
            LiveNewActivity.this.mPlayType = "";
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void k() {
            LiveNewActivity.this.V3();
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void l() {
            LiveNewActivity.this.C4();
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void m(int selectedItemPosition) {
            LiveNewActivity.this.e2(selectedItemPosition);
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void d() {
        }

        @Override // com.live.evo.osd.persenter.c.a
        public void f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"com/live/evo/activity/LiveNewActivity$l", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "", "a", "Z", "isNetworkConnected", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class l extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isNetworkConnected;

        l(Looper looper) {
            super(looper);
            this.isNetworkConnected = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r8.z c(l lVar, LiveNewActivity liveNewActivity, boolean z10) {
            com.live.evo.osd.h hVar;
            PlayerView mVideoView;
            if (z10) {
                lVar.isNetworkConnected = true;
                i5.h hVarA2 = liveNewActivity.A2();
                if ((hVarA2 == null || !hVarA2.r()) && (mVideoView = liveNewActivity.getMVideoView()) != null && !mVideoView.z()) {
                    liveNewActivity.y3(liveNewActivity.A2());
                }
                LiveNewActivity.K0(liveNewActivity);
                liveNewActivity.l2();
            } else if (!liveNewActivity.m2() && (hVar = liveNewActivity.mOsdManager) != null) {
                hVar.c(liveNewActivity.mOsdNetwork);
            }
            return r8.z.f17874a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r8.z d(l lVar, LiveNewActivity liveNewActivity, boolean z10) {
            com.live.evo.osd.h hVar;
            PlayerView mVideoView;
            if (z10) {
                lVar.isNetworkConnected = true;
                i5.h hVarA2 = liveNewActivity.A2();
                if ((hVarA2 == null || !hVarA2.r()) && (mVideoView = liveNewActivity.getMVideoView()) != null && !mVideoView.z()) {
                    liveNewActivity.y3(liveNewActivity.A2());
                }
                LiveNewActivity.K0(liveNewActivity);
                liveNewActivity.l2();
            } else if (!liveNewActivity.m2() && (hVar = liveNewActivity.mOsdManager) != null) {
                hVar.c(liveNewActivity.mOsdNetwork);
            }
            return r8.z.f17874a;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.m.f(msg, "msg");
            switch (msg.what) {
                case 620908545:
                    this.isNetworkConnected = false;
                    LiveNewActivity.K0(LiveNewActivity.this);
                    PlayerView mVideoView = LiveNewActivity.this.getMVideoView();
                    if (mVideoView == null || !mVideoView.z()) {
                        this.isNetworkConnected = LiveNewActivity.this.m2();
                        LiveNewActivity.K0(LiveNewActivity.this);
                    } else {
                        sendEmptyMessageDelayed(620908578, 2000L);
                    }
                    com.live.evo.fragment.t1.Companion companion = com.live.evo.fragment.t1.INSTANCE;
                    LiveNewActivity liveNewActivity = LiveNewActivity.this;
                    com.live.evo.fragment.t1.b networkTester = liveNewActivity.getNetworkTester();
                    final LiveNewActivity liveNewActivity2 = LiveNewActivity.this;
                    companion.f(liveNewActivity, networkTester, new c9.l() { // from class: com.live.evo.activity.h2
                        @Override // c9.l
                        public final Object invoke(Object obj) {
                            return LiveNewActivity.l.c(this.f5450a, liveNewActivity2, ((Boolean) obj).booleanValue());
                        }
                    });
                    break;
                case 620908546:
                    this.isNetworkConnected = true;
                    LiveNewActivity.K0(LiveNewActivity.this);
                    if (!x1.f1.lb.util.d0.f21360a.j()) {
                        LiveNewActivity.this.q3();
                        LiveNewActivity.this.G3();
                        break;
                    }
                    break;
                case 620908574:
                    LiveNewActivity.this.o2();
                    break;
                case 620908578:
                    LiveNewActivity.K0(LiveNewActivity.this);
                    if (!x1.f1.lb.util.d0.f21360a.j() && !this.isNetworkConnected) {
                        PlayerView mVideoView2 = LiveNewActivity.this.getMVideoView();
                        if (mVideoView2 != null && mVideoView2.z()) {
                            sendEmptyMessageDelayed(620908578, 2000L);
                            break;
                        } else {
                            this.isNetworkConnected = LiveNewActivity.this.m2();
                            LiveNewActivity.K0(LiveNewActivity.this);
                            if (!this.isNetworkConnected) {
                                com.live.evo.fragment.t1.Companion companion2 = com.live.evo.fragment.t1.INSTANCE;
                                LiveNewActivity liveNewActivity3 = LiveNewActivity.this;
                                com.live.evo.fragment.t1.b networkTester2 = liveNewActivity3.getNetworkTester();
                                final LiveNewActivity liveNewActivity4 = LiveNewActivity.this;
                                companion2.f(liveNewActivity3, networkTester2, new c9.l() { // from class: com.live.evo.activity.i2
                                    @Override // c9.l
                                    public final Object invoke(Object obj) {
                                        return LiveNewActivity.l.d(this.f5454a, liveNewActivity4, ((Boolean) obj).booleanValue());
                                    }
                                });
                                break;
                            }
                        }
                    }
                    break;
                case 620908591:
                    LiveNewActivity.this.mBackpressedAgain = false;
                    break;
                case 620908595:
                    i5.h hVarB2 = LiveNewActivity.this.B2(msg.arg1);
                    if (hVarB2 != null && !hVarB2.p()) {
                        hVarB2.q();
                        break;
                    }
                    break;
                case 620908596:
                    LiveNewActivity liveNewActivity5 = LiveNewActivity.this;
                    liveNewActivity5.W3(liveNewActivity5.A2());
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/live/evo/activity/LiveNewActivity$m", "Lcom/live/evo/osd/u$a;", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class m implements com.live.evo.osd.u.a {
        m() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/live/evo/activity/LiveNewActivity$o", "Landroid/os/Handler;", "Landroid/os/Message;", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "handleMessage", "(Landroid/os/Message;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class o extends Handler {
        o(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            boolean zM2;
            com.live.evo.osd.h hVar;
            kotlin.jvm.internal.m.f(msg, "msg");
            if (com.live.evo.l.n().A()) {
                return;
            }
            long j10 = LiveNewActivity.this.mTrafficBytesRx;
            com.live.evo.osd.l lVar = LiveNewActivity.this.mOsdProgramPromptLoading;
            if (lVar != null) {
                lVar.i(String.valueOf(j10));
            }
            if (j10 <= 10 && LiveNewActivity.this.mTrafficCount < 5) {
                LiveNewActivity.this.mTrafficCount++;
            }
            if (j10 <= 0 || LiveNewActivity.this.mTrafficCount >= 5) {
                zM2 = LiveNewActivity.this.m2();
                if (zM2) {
                    LiveNewActivity.this.mTrafficCount = 0;
                }
            } else {
                zM2 = true;
            }
            if (!zM2) {
                com.live.evo.osd.i iVar = LiveNewActivity.this.mOsdNetwork;
                if ((iVar != null && iVar.b() == 0) || (hVar = LiveNewActivity.this.mOsdManager) == null) {
                    return;
                }
                hVar.c(LiveNewActivity.this.mOsdNetwork);
                return;
            }
            com.live.evo.osd.i iVar2 = LiveNewActivity.this.mOsdNetwork;
            if (iVar2 != null && iVar2.b() == 0) {
                PlayerView mVideoView = LiveNewActivity.this.getMVideoView();
                if ((mVideoView == null || mVideoView.z()) ? false : true) {
                    post(LiveNewActivity.this.preparePlayAction);
                }
                LiveNewActivity.K0(LiveNewActivity.this);
            }
            com.live.evo.osd.h hVar2 = LiveNewActivity.this.mOsdManager;
            if (hVar2 != null) {
                hVar2.b(LiveNewActivity.this.mOsdNetwork);
            }
            PlayerView mVideoView2 = LiveNewActivity.this.getMVideoView();
            if (mVideoView2 != null) {
                mVideoView2.requestFocus();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/live/evo/activity/LiveNewActivity$p", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "mp", "", "what", "extra", "", "info", "", "onInfo", "(Ltv/danmaku/ijk/media/player/IMediaPlayer;IILjava/lang/String;)Z", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p implements IMediaPlayer.OnInfoListener {
        p() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer mp, int what, int extra, String info) {
            if (LiveNewActivity.this.mPlayerInfoWhat != what) {
                LiveNewActivity.this.mPlayerInfoWhat = what;
            }
            if (what == 701) {
                if (LiveNewActivity.this.mBufferingAllocateByPosition) {
                    return false;
                }
                LiveNewActivity.this.p3();
                return false;
            }
            if (what != 702 || LiveNewActivity.this.mBufferingAllocateByPosition) {
                return false;
            }
            LiveNewActivity.this.o3();
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo/activity/LiveNewActivity$q", "Lcom/live/evo/dialog/u$a;", "", "pos", "Lr8/z;", "b", "(I)V", "a", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class q implements com.live.evo.dialog.u.a {
        q() {
        }

        @Override // com.live.evo.dialog.u.a
        public void a() {
            com.live.evo.osd.u.f7147a.p();
        }

        @Override // com.live.evo.dialog.u.a
        public void b(int pos) {
            if (LiveNewActivity.this.playInAllIdx != pos) {
                LiveNewActivity.this.playGroupIdx = 0;
                LiveNewActivity.this.playInGroupIdx = pos;
                LiveNewActivity.this.b2(pos);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$onEvent$6", f = "LiveNewActivity.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class r extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ ChannelStreamResponse $channelResponse;
        final /* synthetic */ EPGProgramme $epgProgramme;
        int label;
        final /* synthetic */ LiveNewActivity this$0;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$onEvent$6$1", f = "LiveNewActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ i5.c0 $subscribeBean;
            int label;
            final /* synthetic */ LiveNewActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LiveNewActivity liveNewActivity, i5.c0 c0Var, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = liveNewActivity;
                this.$subscribeBean = c0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, this.$subscribeBean, fVar);
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
                    com.live.evo.dialog.u uVar = this.this$0.subscribeDialog;
                    if (uVar != null) {
                        uVar.p(this.$subscribeBean);
                    }
                    com.live.evo.dialog.u uVar2 = this.this$0.subscribeDialog;
                    if (uVar2 != null) {
                        uVar2.q();
                    }
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(EPGProgramme ePGProgramme, ChannelStreamResponse channelStreamResponse, LiveNewActivity liveNewActivity, v8.f<? super r> fVar) {
            super(2, fVar);
            this.$epgProgramme = ePGProgramme;
            this.$channelResponse = channelStreamResponse;
            this.this$0 = liveNewActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new r(this.$epgProgramme, this.$channelResponse, this.this$0, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((r) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                com.live.evo.util.s0 s0Var = com.live.evo.util.s0.f7342a;
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.this$0, s0Var.e(0, s0Var.l(this.$epgProgramme), this.$channelResponse), null), 3, null);
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo/activity/LiveNewActivity$s", "Lcom/live/evo/dialog/u$a;", "", "pos", "Lr8/z;", "b", "(I)V", "a", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class s implements com.live.evo.dialog.u.a {
        s() {
        }

        @Override // com.live.evo.dialog.u.a
        public void a() {
            com.live.evo.osd.u.f7147a.p();
        }

        @Override // com.live.evo.dialog.u.a
        public void b(int pos) {
            if (LiveNewActivity.this.playInAllIdx != pos) {
                LiveNewActivity.this.playGroupIdx = 0;
                LiveNewActivity.this.playInGroupIdx = pos;
                LiveNewActivity.this.b2(pos);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo/activity/LiveNewActivity$t", "Lcom/live/evo/dialog/y$d;", "Lcom/live/evo/dialog/y;", "upgradeDialog", "Lr8/z;", "c", "(Lcom/live/evo/dialog/y;)V", "a", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class t extends com.live.evo.dialog.y.d {
        t() {
        }

        @Override // com.live.evo.dialog.y.e
        public void a() {
            LiveNewActivity.this.r2(true);
        }

        @Override // com.live.evo.dialog.y.d, com.live.evo.dialog.y.e
        public void c(com.live.evo.dialog.y upgradeDialog) {
            super.c(upgradeDialog);
            LiveNewActivity.this.mIsAppUpdateDialogShowing = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/activity/LiveNewActivity$u", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class u extends TimerTask {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f5371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f5372c;

        u(boolean z10, boolean z11) {
            this.f5371b = z10;
            this.f5372c = z11;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(boolean z10, final LiveNewActivity liveNewActivity, boolean z11) {
            if (z10) {
                com.live.evo.util.r1.a(liveNewActivity, R$string.source_stream_change_restart_player);
            }
            liveNewActivity.l3();
            if (z11) {
                liveNewActivity.getMHandler().post(new Runnable() { // from class: com.live.evo.activity.k2
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.u.d(liveNewActivity);
                    }
                });
            } else {
                liveNewActivity.y3(liveNewActivity.A2());
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler mHandler = LiveNewActivity.this.getMHandler();
            final boolean z10 = this.f5371b;
            final LiveNewActivity liveNewActivity = LiveNewActivity.this;
            final boolean z11 = this.f5372c;
            mHandler.post(new Runnable() { // from class: com.live.evo.activity.j2
                @Override // java.lang.Runnable
                public final void run() {
                    LiveNewActivity.u.c(z10, liveNewActivity, z11);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(LiveNewActivity liveNewActivity) {
            liveNewActivity.C3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/activity/LiveNewActivity$v", "Ljava/lang/Runnable;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class v implements Runnable {
        v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LiveNewActivity.this.isOnKeyAfterFocusLost) {
                return;
            }
            PlayerView mVideoView = LiveNewActivity.this.getMVideoView();
            if (mVideoView != null) {
                mVideoView.requestFocus();
            }
            LiveNewActivity.this.getMHandler().postDelayed(this, 1000L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo/activity/LiveNewActivity$w", "Lcom/live/evo/dialog/a$c;", "Li5/h;", "channelData", "Lr8/z;", "a", "(Li5/h;)V", "b", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class w implements com.live.evo.dialog.a.c {
        w() {
        }

        @Override // com.live.evo.dialog.a.c
        public void a(i5.h channelData) {
            com.live.evo.osd.persenter.c cVar = LiveNewActivity.this.mOSDListProgramPresenter;
            if (cVar != null) {
                cVar.hide();
            }
            LiveNewActivity.this.y3(channelData);
            if (LiveNewActivity.this.isPlayFavoriteList) {
                return;
            }
            LiveNewActivity liveNewActivity = LiveNewActivity.this;
            liveNewActivity.P3(liveNewActivity.playGroupIdx, LiveNewActivity.this.playInGroupIdx, LiveNewActivity.this.playInAllIdx);
        }

        @Override // com.live.evo.dialog.a.c
        public void b() {
            LiveNewActivity.this.w2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/activity/LiveNewActivity$x", "Lcom/live/evo/dialog/n;", "Lr8/z;", "a", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class x implements com.live.evo.dialog.n {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$showExitDialog$1$onExit$1", f = "LiveNewActivity.kt", l = {1732, 1734}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            int label;
            final /* synthetic */ LiveNewActivity this$0;

            /* JADX INFO: renamed from: com.live.evo.activity.LiveNewActivity$x$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$showExitDialog$1$onExit$1$1", f = "LiveNewActivity.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class C0065a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                int label;
                final /* synthetic */ LiveNewActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0065a(LiveNewActivity liveNewActivity, v8.f<? super C0065a> fVar) {
                    super(2, fVar);
                    this.this$0 = liveNewActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new C0065a(this.this$0, fVar);
                }

                @Override // c9.p
                public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                    return ((C0065a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        r8.r.b(obj);
                        com.live.evo.osd.l lVar = this.this$0.mOsdProgramPromptLoading;
                        if (lVar != null) {
                            lVar.f();
                        }
                        this.this$0.r2(true);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LiveNewActivity liveNewActivity, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = liveNewActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, fVar);
            }

            @Override // c9.p
            public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
            
                if (kotlinx.coroutines.h.g(r7, r1, r6) == r0) goto L17;
             */
            @Override // kotlin.coroutines.jvm.internal.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                if (i10 != 0 && i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                    while (t.v.c.i.a.f18646a.n0()) {
                        this.label = 1;
                        if (kotlinx.coroutines.v0.a(200L, this) == objC) {
                            return objC;
                        }
                    }
                    kotlinx.coroutines.g2 g2VarC = kotlinx.coroutines.a1.c();
                    C0065a c0065a = new C0065a(this.this$0, null);
                    this.label = 2;
                }
                return r8.z.f17874a;
            }
        }

        x() {
        }

        @Override // com.live.evo.dialog.n
        public void a() {
            if (!t.v.c.i.a.f18646a.n0()) {
                LiveNewActivity.this.r2(true);
                return;
            }
            com.live.evo.osd.l lVar = LiveNewActivity.this.mOsdProgramPromptLoading;
            if (lVar != null) {
                lVar.h(LiveNewActivity.this.getString(2131952022));
            }
            com.live.evo.osd.l lVar2 = LiveNewActivity.this.mOsdProgramPromptLoading;
            if (lVar2 != null) {
                lVar2.j();
            }
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new a(LiveNewActivity.this, null), 3, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"com/live/evo/activity/LiveNewActivity$y", "Lcom/live/evo/osd/a;", "Lr8/z;", "c", "()V", "e", "a", "b", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class y implements com.live.evo.osd.a {
        y() {
        }

        @Override // com.live.evo.osd.p
        public void a() {
            LiveNewActivity.this.r2(true);
        }

        @Override // com.live.evo.osd.p
        public void b() {
            LiveNewActivity.this.E3();
        }

        @Override // com.live.evo.osd.a
        public void c() {
            if (!com.live.evo.l.n().E()) {
                LiveNewActivity.this.f4();
            }
            LiveNewActivity liveNewActivity = LiveNewActivity.this;
            liveNewActivity.y3(liveNewActivity.A2());
            com.live.evo.l.n().M();
            LiveNewActivity.this.Z1();
        }

        @Override // com.live.evo.osd.p
        public void e() {
            if (!com.live.evo.l.n().E()) {
                LiveNewActivity.this.f4();
            }
            if (!com.live.evo.l.n().J()) {
                LiveNewActivity liveNewActivity = LiveNewActivity.this;
                liveNewActivity.y3(liveNewActivity.A2());
            }
            LiveNewActivity.this.Z1();
            com.live.evo.l.n().M();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$startPlay$1", f = "LiveNewActivity.kt", l = {2137}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class z extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ i5.h $channelData;
        final /* synthetic */ ChannelStreamResponse $response;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.activity.LiveNewActivity$startPlay$1$1", f = "LiveNewActivity.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super Long>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ i5.h $channelData;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ LiveNewActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LiveNewActivity liveNewActivity, i5.h hVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.this$0 = liveNewActivity;
                this.$channelData = hVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Long> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.this$0, this.$channelData, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    this.this$0.r3(this.$channelData, (Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LiveNewActivity f5377a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i5.h f5378b;

            b(LiveNewActivity liveNewActivity, i5.h hVar) {
                this.f5377a = liveNewActivity;
                this.f5378b = hVar;
            }

            public final Object b(long j10, v8.f<? super r8.z> fVar) {
                i5.h hVarA2 = this.f5377a.A2();
                if (hVarA2 != null) {
                    i5.h hVar = this.f5378b;
                    LiveNewActivity liveNewActivity = this.f5377a;
                    if (!ac.g.d(hVarA2.b(), hVar.b())) {
                        liveNewActivity.logger.a("start_play_channel was changed[" + hVar.a() + " -> " + hVarA2.a() + "], start channel[" + hVarA2.a() + "]", new Object[0]);
                        liveNewActivity.i4(hVarA2, kotlin.collections.n0.i(), "");
                    }
                }
                return r8.z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).longValue(), fVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(i5.h hVar, ChannelStreamResponse channelStreamResponse, v8.f<? super z> fVar) {
            super(2, fVar);
            this.$channelData = hVar;
            this.$response = channelStreamResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return LiveNewActivity.this.new z(this.$channelData, this.$response, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((z) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.f<Long> fVarH;
            kotlinx.coroutines.flow.f fVarF;
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
                if (!kotlin.jvm.internal.m.a(LiveNewActivity.this.lastStartLiveChannel, this.$channelData)) {
                    LiveNewActivity.this.lastStartLiveChannel = this.$channelData;
                    LiveNewActivity.this.lastPlayTime = com.live.evo.util.q1.b();
                }
                PlayerView mVideoView = LiveNewActivity.this.getMVideoView();
                if (mVideoView != null && (fVarH = mVideoView.H(this.$response)) != null && (fVarF = kotlinx.coroutines.flow.h.f(fVarH, new a(LiveNewActivity.this, this.$channelData, null))) != null) {
                    b bVar = new b(LiveNewActivity.this, this.$channelData);
                    this.label = 1;
                    if (fVarF.collect(bVar, this) == objC) {
                        return objC;
                    }
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C3() {
        if (t.v.c.i.a.f18646a.o0()) {
            p4();
            return;
        }
        try {
            i5.h hVarA2 = A2();
            PlayerView playerView = this.mVideoView;
            if (playerView != null && playerView.getVisibility() != 0) {
                playerView.setVisibility(0);
                playerView.requestFocus();
            }
            R3(8);
            this.lastPlayedLiveChannel = hVarA2;
            com.live.evo.osd.l lVar = this.mOsdProgramPromptRetrying;
            if ((lVar != null ? Integer.valueOf(lVar.b()) : null) != 0) {
                com.live.evo.osd.h hVar = this.mOsdManager;
                if (hVar != null) {
                    hVar.c(this.mOsdProgramPromptLoading);
                }
                com.live.evo.osd.l lVar2 = this.mOsdProgramPromptLoading;
                if (lVar2 != null) {
                    lVar2.k();
                }
            }
            n2 n2Var = this.livePlayHandler;
            if (n2Var != null) {
                n2Var.d(hVarA2);
            }
            m4(false);
            com.live.evo.osd.l lVar3 = this.mOsdProgramPromptRetrying;
            if ((lVar3 != null ? Integer.valueOf(lVar3.b()) : null) != 0) {
                com.live.evo.osd.h hVar2 = this.mOsdManager;
                if (hVar2 != null) {
                    hVar2.c(this.mOsdProgramPromptLoading);
                }
                com.live.evo.osd.l lVar4 = this.mOsdProgramPromptLoading;
                if (lVar4 != null) {
                    lVar4.k();
                }
            }
        } catch (Exception e10) {
            x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
            String string = getString(R$string.play_unknown_err);
            kotlin.jvm.internal.m.e(string, "getString(...)");
            g1Var.c(string);
            q6.b logger = this.logger;
            kotlin.jvm.internal.m.e(logger, "logger");
            c5.b.c(logger, e10, "Error in preparePlay");
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int F4(i5.h hVar, i5.h hVar2) {
        return Integer.compare(hVar != null ? hVar.i() : 0, hVar2 != null ? hVar2.i() : 0);
    }

    private final void H3(boolean resetErrCount, int delay) {
        I3(resetErrCount, delay, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z3() {
        System.exit(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0012  */
    public static final void c4(int i10, LiveNewActivity liveNewActivity) {
        int i11;
        i5.h hVar;
        i5.h hVar2;
        if (i10 <= 0) {
            i11 = 0;
        } else {
            List<? extends i5.h> list = liveNewActivity.mListLiveDataAll;
            if (i10 >= (list != null ? list.size() : 0)) {
                i11 = 0;
            } else {
                i11 = i10;
            }
        }
        if (a5.b.a().b()) {
            List<? extends i5.h> list2 = liveNewActivity.mListLiveDataAll;
            i10 = (list2 == null || (hVar2 = list2.get(i11)) == null) ? 0 : hVar2.i();
        }
        com.live.evo.osd.j jVar = liveNewActivity.mOsdProgramNum;
        if (jVar != null) {
            String strValueOf = String.valueOf(i10);
            List<? extends i5.h> list3 = liveNewActivity.mListLiveDataAll;
            jVar.h(strValueOf, (list3 == null || (hVar = list3.get(i11)) == null) ? null : hVar.e());
        }
        com.live.evo.osd.j jVar2 = liveNewActivity.mOsdProgramNum;
        if (jVar2 != null) {
            jVar2.d(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(LiveNewActivity liveNewActivity) {
        B3(liveNewActivity, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t3(LiveNewActivity liveNewActivity, b5.i iVar) {
        liveNewActivity.isPopupLoginOrRenewFragment = false;
        if (iVar.f915a == 1) {
            liveNewActivity.J3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u3(LiveNewActivity liveNewActivity, b5.i iVar) {
        liveNewActivity.isPopupLoginOrRenewFragment = false;
        if (iVar.f915a == 1) {
            liveNewActivity.J3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v3(LiveNewActivity liveNewActivity) {
        A4(liveNewActivity, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w3(LiveNewActivity liveNewActivity, b5.i iVar) {
        liveNewActivity.isPopupLoginOrRenewFragment = false;
        if (iVar.f915a == 1) {
            liveNewActivity.J3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x3(LiveNewActivity liveNewActivity, b5.i iVar) {
        liveNewActivity.isPopupLoginOrRenewFragment = false;
        if (iVar.f915a == 1) {
            liveNewActivity.J3();
        }
    }

    public final i5.h A2() {
        try {
            int i10 = this.playInAllIdx;
            List<? extends i5.h> list = this.mListLiveDataAll;
            int size = list != null ? list.size() : 0;
            if (size == 0) {
                return null;
            }
            if (i10 >= size) {
                i10 = 0;
            }
            if (list != null) {
                return list.get(i10);
            }
            return null;
        } catch (Exception e10) {
            q6.b logger = this.logger;
            kotlin.jvm.internal.m.e(logger, "logger");
            c5.b.c(logger, e10, "Error in getProgramData()");
            return null;
        }
    }

    public final i5.h B2(int index) {
        try {
            List<? extends i5.h> list = this.mListLiveDataAll;
            int i10 = index >= (list != null ? list.size() : 0) ? 0 : index;
            if (list != null) {
                return list.get(i10);
            }
            return null;
        } catch (Exception e10) {
            this.logger.error("Error in getProgramData() index = " + index, e10);
            return null;
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(nf.g event) {
        kotlin.jvm.internal.m.f(event, "event");
    }

    public final void Q3() {
        this.isOnKeyAfterFocusLost = false;
        runOnUiThread(new v());
    }

    public final void X1(String message) {
        this.isInLogout = true;
        k4(true);
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            playerView.J(true);
        }
        n2 n2Var = this.livePlayHandler;
        if (n2Var != null && n2Var != null) {
            n2Var.h();
        }
        n4();
        com.live.evo.osd.l lVar = this.mOsdProgramPromptLoading;
        if (lVar != null) {
            lVar.j();
        }
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new f(null), 3, null);
    }

    public final boolean d3() {
        try {
            PlayerView playerView = this.mVideoView;
            return playerView != null && playerView.z();
        } catch (Throwable unused) {
        }
    }

    public final int h2(String channelId, String channelName, int favorite) {
        int i10;
        int i11;
        List<i5.h> list;
        i5.h hVar;
        try {
            List<? extends i5.h> list2 = this.mListLiveDataAll;
            if (list2 == null || list2.size() <= 0) {
                i11 = 0;
                break;
            }
            Iterator<? extends i5.h> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i11 = 0;
                    break;
                }
                i5.h next = it.next();
                if (ua.n.x(next != null ? next.b() : null, channelId, false, 2, null)) {
                    if (ua.n.x(next != null ? next.e() : null, channelName, false, 2, null)) {
                        i11 = next != null ? next.i() : 0;
                        if (next != null) {
                            try {
                                next.C(favorite);
                            } catch (Exception e10) {
                                i10 = i11;
                                e = e10;
                            }
                        }
                        E4(favorite, next);
                        break;
                    }
                }
                this.logger.error("Error in getProgramData()", e);
                return i10;
            }
            List<String> listL = this.mCategoryIdList;
            if (listL == null) {
                listL = kotlin.collections.r.l();
            }
            int size = listL.size();
            for (int i12 = 1; i12 < size; i12++) {
                HashMap<String, List<i5.h>> map = this.mMapCategoryPrograms;
                List<i5.h> list3 = map != null ? map.get(listL.get(i12)) : null;
                if (list3 != null && list3.size() > 0) {
                    int size2 = list3.size();
                    for (int i13 = 0; i13 < size2; i13++) {
                        i5.h hVar2 = list3.get(i13);
                        if ((hVar2 != null ? Integer.valueOf(hVar2.i()) : null) == Integer.valueOf(i11)) {
                            HashMap<String, List<i5.h>> map2 = this.mMapCategoryPrograms;
                            if (map2 != null && (list = map2.get(listL.get(i12))) != null && (hVar = list.get(i13)) != null) {
                                hVar.C(favorite);
                                break;
                            }
                            break;
                        }
                    }
                }
            }
            return i11;
        } catch (Exception e11) {
            e = e11;
            i10 = 0;
        }
    }

    public final void i2(int favorite) {
        List<i5.h> list;
        i5.h hVar;
        try {
            int i10 = this.playInAllIdx;
            List<? extends i5.h> list2 = this.mListLiveDataAll;
            if (i10 >= (list2 != null ? list2.size() : 0)) {
                i10 = 0;
            }
            List<? extends i5.h> list3 = this.mListLiveDataAll;
            i5.h hVar2 = list3 != null ? list3.get(i10) : null;
            if (hVar2 != null) {
                hVar2.C(favorite);
            }
            List<String> list4 = this.mCategoryIdList;
            if (list4 != null && list4.size() > 1 && this.mMapCategoryPrograms != null) {
                E4(favorite, hVar2);
                int i11 = hVar2 != null ? hVar2.i() : 0;
                int size = list4.size();
                for (int i12 = 1; i12 < size; i12++) {
                    HashMap<String, List<i5.h>> map = this.mMapCategoryPrograms;
                    List<i5.h> list5 = map != null ? map.get(list4.get(i12)) : null;
                    if (list5 != null && list5.size() > 0) {
                        int size2 = list5.size();
                        for (int i13 = 0; i13 < size2; i13++) {
                            i5.h hVar3 = list5.get(i13);
                            if (hVar3 != null && hVar3.i() == i11) {
                                HashMap<String, List<i5.h>> map2 = this.mMapCategoryPrograms;
                                if (map2 != null && (list = map2.get(list4.get(i12))) != null && (hVar = list.get(i13)) != null) {
                                    hVar.C(favorite);
                                    break;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            this.logger.error("Error in getProgramData()", e10);
        }
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle savedInstanceState);

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(nf.f event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        if (event.c()) {
            b bVar = this.ecoModeAction;
            if (bVar != null) {
                bVar.run();
                return;
            }
            return;
        }
        com.live.evo.l.n().S(0);
        G3();
        M3();
        this.logger.debug("eco-exit onEvent engine", new Object[0]);
        N3();
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onForceLogoutEvent(b5.e event) {
        k4(true);
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            playerView.J(true);
        }
        Intent intent = new Intent(this, (Class<?>) LiveLoadActivity.class);
        com.live.evo.l.n().K(false);
        startActivity(intent);
        finish();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v10, int keyCode, KeyEvent event) {
        com.live.evo.osd.persenter.c cVar;
        i5.h hVar;
        List<String> listG;
        List listL;
        String strE;
        String string;
        String strE2;
        String strB;
        kotlin.jvm.internal.m.f(v10, "v");
        kotlin.jvm.internal.m.f(event, "event");
        x1.f1.lb.util.d0.f21360a.p(event);
        this.isOnKeyAfterFocusLost = true;
        int i10 = 0;
        if (event.getAction() == 0 && v10 == this.mVideoView) {
            K3();
            if (keyCode != 66) {
                if (keyCode == 82) {
                    i5.h hVarA2 = A2();
                    if (hVarA2 != null && hVarA2.q()) {
                        return true;
                    }
                    if (com.live.evo.k.b().l()) {
                        if (hVarA2 != null && hVarA2.p()) {
                            i10 = 1;
                        }
                        if (i10 != 0) {
                            return true;
                        }
                    }
                    com.live.evo.g gVar = this.mUiManager;
                    if (gVar != null) {
                        gVar.p(A2());
                    }
                    com.live.evo.g gVar2 = this.mUiManager;
                    if (gVar2 != null) {
                        gVar2.t();
                    }
                    return true;
                }
                if (keyCode != 84) {
                    if (keyCode != 92) {
                        if (keyCode != 93) {
                            if (keyCode == 284) {
                                i5.h hVarB2 = B2(this.playInAllIdx);
                                int iJ = hVarB2 != null ? hVarB2.j() : 0;
                                if ((hVarB2 == null || !hVarB2.p()) && com.live.evo.k.b().d()) {
                                    int i11 = iJ == 0 ? 1 : 0;
                                    if (this.playGroupIdx == com.live.evo.k.b().a() && i11 == 0) {
                                        this.isRemoveFavorite = true;
                                    }
                                    List<String> list = this.mCategoryIdList;
                                    if (list != null) {
                                        if ((list != null ? list.size() : 0) > 1 && this.mMapCategoryPrograms != null) {
                                            if (hVarB2 != null) {
                                                hVarB2.C(i11);
                                            }
                                            E4(i11, hVarB2);
                                            if (hVarB2 != null && (strB = hVarB2.b()) != null) {
                                                try {
                                                    t.v.c.i.a.f18646a.L0(Integer.parseInt(strB));
                                                } catch (Throwable th) {
                                                    this.logger.error("add favorites failure", th);
                                                    r8.z zVar = r8.z.f17874a;
                                                }
                                            }
                                            String strJ = com.live.evo.util.x1.j(i11 > 0 ? R$string.add_to_favorite : R$string.cancel_to_favorite);
                                            kotlin.jvm.internal.m.e(strJ, "getString(...)");
                                            com.live.evo.util.r1.d(this, strJ, 1);
                                            return true;
                                        }
                                    }
                                }
                            } else {
                                if (keyCode != 285) {
                                    switch (keyCode) {
                                        case 21:
                                            if (com.live.evo.h.b().d()) {
                                                W3(A2());
                                            }
                                            return true;
                                        case 22:
                                            if (!com.live.evo.l.n().E() && com.live.evo.h.b().d()) {
                                                B4();
                                            }
                                            return true;
                                    }
                                }
                                if (com.live.evo.h.b().d() && !com.live.evo.util.e.b().c()) {
                                    B4();
                                    return true;
                                }
                            }
                        }
                        if (!this.canClickUpDown) {
                            return true;
                        }
                        com.live.evo.osd.persenter.c cVar2 = this.mOSDListProgramPresenter;
                        if (!(cVar2 != null && cVar2.D())) {
                            if (!this.isRemoveFavorite) {
                                this.playInGroupIdx++;
                            }
                            this.isRemoveFavorite = false;
                            d2(true);
                            return true;
                        }
                        com.live.evo.osd.persenter.c cVar3 = this.mOSDListProgramPresenter;
                        if (cVar3 != null) {
                            cVar3.E();
                        }
                        com.live.evo.osd.persenter.c cVar4 = this.mOSDListProgramPresenter;
                        if (cVar4 != null) {
                            cVar4.hide();
                        }
                        return true;
                    }
                    if (!this.canClickUpDown) {
                        return true;
                    }
                    com.live.evo.osd.persenter.c cVar5 = this.mOSDListProgramPresenter;
                    if (!(cVar5 != null && cVar5.D())) {
                        this.isRemoveFavorite = false;
                        this.playInGroupIdx--;
                        d2(false);
                        return true;
                    }
                    com.live.evo.osd.persenter.c cVar6 = this.mOSDListProgramPresenter;
                    if (cVar6 != null) {
                        cVar6.F();
                    }
                    com.live.evo.osd.persenter.c cVar7 = this.mOSDListProgramPresenter;
                    if (cVar7 != null) {
                        cVar7.hide();
                    }
                    return true;
                }
                if (com.live.evo.k.b().m() && (cVar = this.mOSDListProgramPresenter) != null) {
                    cVar.M(getSupportFragmentManager(), "Search");
                }
                String str = "";
                if (keyCode >= 7 && keyCode <= 16) {
                    int i12 = keyCode - 7;
                    if (this.isInputProgramNum) {
                        com.live.evo.osd.j jVar = this.mOsdProgramNum;
                        if (jVar != null) {
                            jVar.d(0);
                        }
                        com.live.evo.osd.j jVar2 = this.mOsdProgramNum;
                        if (jVar2 != null && (strE2 = jVar2.e()) != null) {
                            str = strE2;
                        }
                        if (str.length() >= 3) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(i12);
                            string = sb2.toString();
                        } else if (kotlin.jvm.internal.m.a("0", str)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(i12);
                            string = sb3.toString();
                        } else {
                            string = str + i12;
                        }
                    } else {
                        com.live.evo.osd.j jVar3 = this.mOsdProgramNum;
                        if (jVar3 != null) {
                            jVar3.d(0);
                        }
                        this.isInputProgramNum = true;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(i12);
                        string = sb4.toString();
                    }
                    c2(string);
                    return true;
                }
                if (keyCode == 67) {
                    if (this.isInputProgramNum) {
                        com.live.evo.osd.j jVar4 = this.mOsdProgramNum;
                        if (jVar4 != null && (strE = jVar4.e()) != null) {
                            str = strE;
                        }
                        if (str.length() > 1) {
                            String strSubstring = str.substring(0, str.length() - 1);
                            kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
                            c2(strSubstring);
                        }
                        return true;
                    }
                    if (!TextUtils.isEmpty(this.lookBackInfo)) {
                        String str2 = this.lookBackInfo;
                        String[] strArr = null;
                        if (!((str2 == null || ua.n.O(str2, ",", false, 2, null)) ? false : true)) {
                            String str3 = this.lookBackInfo;
                            if (str3 != null && (listG = new ua.l(",").g(str3, 0)) != null) {
                                if (listG.isEmpty()) {
                                    listL = kotlin.collections.r.l();
                                } else {
                                    ListIterator<String> listIterator = listG.listIterator(listG.size());
                                    while (true) {
                                        if (listIterator.hasPrevious()) {
                                            if (!(listIterator.previous().length() == 0)) {
                                                listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                                            }
                                        } else {
                                            listL = kotlin.collections.r.l();
                                        }
                                    }
                                }
                                if (listL != null) {
                                    strArr = (String[]) listL.toArray(new String[0]);
                                }
                            }
                            if (strArr != null && strArr.length > 2) {
                                int i13 = Integer.parseInt(strArr[0]);
                                int i14 = Integer.parseInt(strArr[1]);
                                int i15 = Integer.parseInt(strArr[2]);
                                if (i13 == this.playGroupIdx && i14 == this.playInGroupIdx && i15 == this.playInAllIdx) {
                                    return false;
                                }
                                List<? extends i5.h> list2 = this.mListLiveDataAll;
                                if (i15 >= (list2 != null ? list2.size() : 0) || i15 < 0) {
                                    return false;
                                }
                                List<? extends i5.h> list3 = this.mListLiveDataAll;
                                if (!((list3 == null || (hVar = list3.get(i15)) == null || !hVar.p()) ? false : true)) {
                                    this.playGroupIdx = i13;
                                    this.playInGroupIdx = i14;
                                    i10 = i15;
                                } else if (this.playGroupIdx != 0 && this.playInGroupIdx != 0) {
                                    this.playGroupIdx = 0;
                                    this.playInGroupIdx = 0;
                                    return true;
                                }
                                h4("keycode_del");
                                b2(i10);
                            }
                            return true;
                        }
                    }
                    return false;
                }
            }
            if (this.isInLogout) {
                x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                String string2 = getString(2131952317);
                kotlin.jvm.internal.m.e(string2, "getString(...)");
                g1Var.e(string2);
            } else {
                com.live.evo.osd.persenter.c cVar8 = this.mOSDListProgramPresenter;
                if (cVar8 != null) {
                    if (cVar8 != null) {
                        cVar8.hide();
                    }
                    i5.h hVarA3 = A2();
                    if (hVarA3 != null) {
                        int i16 = hVarA3.i();
                        com.live.evo.osd.persenter.c cVar9 = this.mOSDListProgramPresenter;
                        if (cVar9 != null) {
                            cVar9.J(i16);
                        }
                    }
                    com.live.evo.osd.persenter.c cVar10 = this.mOSDListProgramPresenter;
                    if (cVar10 != null) {
                        cVar10.M(getSupportFragmentManager(), "Channel List");
                    }
                }
            }
            return true;
        }
        return false;
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onSubscribe(b5.k event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        com.live.evo.osd.persenter.c cVar = this.mOSDListProgramPresenter;
        if (cVar != null) {
            cVar.hide();
        }
        if (this.subscribeDialog == null) {
            this.subscribeDialog = new com.live.evo.dialog.u(this, new s());
        }
        com.live.evo.dialog.u uVar = this.subscribeDialog;
        if (uVar != null) {
            uVar.p(event.f916a);
        }
        com.live.evo.dialog.u uVar2 = this.subscribeDialog;
        if (uVar2 != null) {
            uVar2.q();
        }
    }

    public final void r2(boolean withProcess) {
        try {
            k4(true);
            l4();
            m4(true);
            com.live.evo.osd.persenter.c cVar = this.mOSDListProgramPresenter;
            if (cVar != null) {
                cVar.hide();
                cVar.u();
                this.mOSDListProgramPresenter = null;
            }
            com.live.evo.g gVar = this.mUiManager;
            if (gVar != null) {
                gVar.e();
            }
            n2 n2Var = this.livePlayHandler;
            if (n2Var != null && n2Var != null) {
                n2Var.g();
            }
            if (withProcess) {
                x1.f1.lb.metric.monitor.f.f20907a.v();
                x1.f1.lb.util.d0 d0Var = x1.f1.lb.util.d0.f21360a;
                d0Var.o();
                uf.c.f19486a.j("onDestroy");
                x1.f1.lb.util.d0.r(d0Var, null, 1, null);
                finish();
                System.exit(0);
            }
        } catch (Exception e10) {
            this.logger.error("LiveNewActivity exit error, withProcess: {}", Boolean.valueOf(withProcess), e10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/activity/LiveNewActivity$n", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class n extends TimerTask {
        n() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
        }
    }

    static {
        StubApp.interface11(11813);
        INSTANCE = new Companion(null);
        PlayerView.INSTANCE.a(false);
    }

    private final void A3(boolean isManual) {
        nf.z zVar = this.upgradeEvent;
        if (zVar == null) {
            return;
        }
        long jB = com.live.evo.util.q1.b();
        if (!isManual) {
            long j10 = this.lastUpgradeEventTime;
            if (j10 > 0 && jB - j10 < ((long) zVar.b().getDelayTime()) * 1000) {
                return;
            }
        }
        this.lastUpgradeEventTime = jB;
        if (this.mIsAppUpdateDialogShowing) {
            return;
        }
        this.mIsAppUpdateDialogShowing = true;
        q5.c cVar = q5.c.f17661a;
        String strA = zVar.a();
        kotlin.jvm.internal.m.e(strA, "getApkFile(...)");
        UpgradeInfo upgradeInfoB = zVar.b();
        kotlin.jvm.internal.m.e(upgradeInfoB, "getUpgradeInfo(...)");
        cVar.g(this, strA, upgradeInfoB, new t());
    }

    static /* synthetic */ void A4(LiveNewActivity liveNewActivity, Fragment fragment, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toRechargeFragment");
        }
        if ((i10 & 1) != 0) {
            fragment = null;
        }
        liveNewActivity.z4(fragment);
    }

    static /* synthetic */ void B3(LiveNewActivity liveNewActivity, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popupUpgradeDlg");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        liveNewActivity.A3(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B4() {
        com.live.evo.g gVar = this.mUiManager;
        if (gVar != null) {
            gVar.s(A2());
        }
    }

    private final void E2() {
        RelativeLayout relativeLayout = this.mExpiredParent;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        TextView textView = this.mExpiredTitle;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.mRechargeGuide;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.mRechargeHint;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        ImageView imageView = this.mMemberQR;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E3() {
        try {
            d dVar = this.rechargeAction;
            if (dVar == null) {
                return;
            }
            this.mHandler.removeCallbacks(dVar);
            if (t.v.c.i.a.f18646a.I() < com.live.evo.util.u1.b().a() + com.live.evo.a.f5196p) {
                this.mHandler.postDelayed(dVar, 43200000L);
            }
        } catch (Throwable unused) {
        }
    }

    private final void E4(int favorite, i5.h data) {
        String str;
        if (data == null) {
            return;
        }
        int iA = com.live.evo.k.b().a();
        if (a5.b.a().b()) {
            iA = 0;
        }
        List<String> list = this.mCategoryIdList;
        if (list == null || (str = list.get(iA)) == null) {
            return;
        }
        HashMap<String, List<i5.h>> map = this.mMapCategoryPrograms;
        List<i5.h> list2 = map != null ? map.get(str) : null;
        if (list2 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        if (favorite > 0) {
            arrayList.add(data);
            HashSet hashSet = new HashSet(arrayList);
            arrayList.clear();
            arrayList.addAll(hashSet);
            if (!arrayList.isEmpty()) {
                final c9.p pVar = new c9.p() { // from class: com.live.evo.activity.j0
                    @Override // c9.p
                    public final Object invoke(Object obj, Object obj2) {
                        return Integer.valueOf(LiveNewActivity.F4((i5.h) obj, (i5.h) obj2));
                    }
                };
                kotlin.collections.r.B(arrayList, new Comparator() { // from class: com.live.evo.activity.k0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return LiveNewActivity.G4(pVar, obj, obj2);
                    }
                });
            }
        } else {
            arrayList.remove(data);
        }
        HashMap<String, List<i5.h>> map2 = this.mMapCategoryPrograms;
        if (map2 != null) {
            map2.put(str, arrayList);
        }
    }

    private final void F3() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.bb.action.EPG");
        intentFilter.addAction("com.bb.action.feedback");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("com.bb.action.FAVORITE");
        intentFilter.addAction("com.bb.action.EXIT");
        intentFilter.addAction("com.bb.action.AddPIP");
        intentFilter.addAction("com.bb.action.switchpip");
        intentFilter.addAction("com.bb.action.closepip");
        intentFilter.addAction("com.bb.action.switchprogram");
        intentFilter.addAction("com.bb.action.popupmenuview");
        intentFilter.addAction("com.bb.action.showprogram");
        intentFilter.addAction("com.bb.action.update");
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                registerReceiver(this.mMsgReceiver, intentFilter, 4);
            } catch (Throwable th) {
                this.logger.error("register receiver failure", th);
            }
        }
    }

    private final void H2() {
        final com.live.evo.osd.persenter.c cVar = this.mOSDListProgramPresenter;
        if (cVar == null || cVar.D()) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.activity.n0
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.I2(cVar);
            }
        }, 100L);
    }

    private final void I3(boolean resetErrCount, int delay, boolean showToast, boolean blockShowEpg) {
        if (resetErrCount) {
            this.mLiveErrorCount = 0;
        }
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            if (playerView != null) {
                playerView.J(true);
            }
            n2 n2Var = this.livePlayHandler;
            if (n2Var != null) {
                n2Var.b();
            }
            TimerTask timerTask = this.replayTask;
            if (timerTask != null && timerTask != null) {
                timerTask.cancel();
            }
            u uVar = new u(showToast, blockShowEpg);
            this.replayTask = uVar;
            this.mTimer.schedule(uVar, delay);
        }
    }

    private final void J2() {
        x1.f1.lb.util.d0.f21360a.i(new c9.l() { // from class: com.live.evo.activity.u0
            @Override // c9.l
            public final Object invoke(Object obj) {
                return LiveNewActivity.K2(((Boolean) obj).booleanValue());
            }
        });
        O2();
        S2();
        M2();
        this.networkTester = com.live.evo.fragment.t1.INSTANCE.a(this);
        Q2();
        this.ecoModeAction = new b(this);
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        if (aVar.I() < com.live.evo.util.u1.b().a() + aVar.U()) {
            this.rechargeAction = new d(this);
            E3();
        }
        this.livePlayHandler = new n2(this, new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z K2(boolean z10) {
        return r8.z.f17874a;
    }

    private final void L2() {
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        if (aVar.I() <= com.live.evo.util.u1.b().a() && this.mExpiredLayout == null) {
            ViewStub viewStub = (ViewStub) findViewById(R$id.livenewa_vs_expired);
            this.mExpiredLayout = viewStub;
            if (viewStub != null) {
                viewStub.inflate();
            }
            this.mExpiredTitle = (TextView) findViewById(R$id.tv_expired_remind_title);
            this.mExpiredParent = (RelativeLayout) findViewById(R$id.expired_remind_parent);
            this.mTVCountdownTime = (TextView) findViewById(R$id.tv_free_experience_countdown_time);
            this.mRechargeGuide = (TextView) findViewById(R$id.tv_recharge_guide);
            this.mMemberQR = (ImageView) findViewById(R$id.iv_qr_membersite);
            this.mRechargeHint = (TextView) findViewById(R$id.tv_remind_hint);
            kotlin.jvm.internal.m.e(com.live.evo.util.x1.j(R$string.payment_guide_common), "getString(...)");
            String strJ = com.live.evo.util.x1.j(R$string.recharge_guide);
            String str = String.format(com.live.evo.util.x1.j(R$string.expired_remind_for_live), 10);
            String strJ2 = com.live.evo.util.x1.j(R$string.how_to_renew);
            String strN = aVar.N();
            String strE = ua.n.E(ua.n.E(ua.n.E(strJ, "${MS}", strN, false, 4, null), "${RS}", strN, false, 4, null), "${CS}", aVar.v(), false, 4, null);
            TextView textView = this.mRechargeGuide;
            if (textView != null) {
                textView.setText(Html.fromHtml(strE));
            }
            TextView textView2 = this.mExpiredTitle;
            if (textView2 != null) {
                textView2.setText(Html.fromHtml(str));
            }
            TextView textView3 = this.mRechargeHint;
            if (textView3 != null) {
                textView3.setText(Html.fromHtml(strJ2));
            }
            RelativeLayout relativeLayout = this.mExpiredParent;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
        }
    }

    private final void M2() {
        List listL;
        String strN;
        if (t.v.c.i.a.f18646a.I() > com.live.evo.util.u1.b().a()) {
            this.mExpiredStatus = -1;
            return;
        }
        if (TextUtils.isEmpty("")) {
            this.mExpiredStatus = 0;
            return;
        }
        List<String> listG = new ua.l(",").g("", 0);
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
        if (strArr.length != 2) {
            this.mExpiredStatus = 0;
            return;
        }
        if (!kotlin.jvm.internal.m.a(strArr[0], String.valueOf(com.live.evo.util.q1.h()))) {
            this.mExpiredStatus = 0;
            return;
        }
        int i10 = Integer.parseInt(strArr[1]);
        if (600 > i10) {
            this.mExpiredStatus = 1;
            return;
        }
        this.mExpiredStatus = 2;
        this.expiredExperienceTimes = i10;
        i5.h hVarA2 = A2();
        String str = (hVarA2 == null || (strN = hVarA2.n()) == null) ? "" : strN;
        int iB0 = ua.n.b0(str, ":", 0, false, 6, null);
        if (iB0 > 0) {
            kotlin.jvm.internal.m.e(str.substring(0, iB0), "substring(...)");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M3() {
        e eVar = this.trafficTask;
        if (eVar != null) {
            if (eVar != null) {
                eVar.cancel();
            }
            this.mTimer.purge();
        }
        e eVar2 = new e(this);
        this.trafficTask = eVar2;
        this.mTimer.schedule(eVar2, 1000L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N3() {
        this.mHandler.post(new Runnable() { // from class: com.live.evo.activity.b1
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.O3(this.f5407a);
            }
        });
    }

    private final void Q2() {
        List listL;
        SLoadingView sLoadingView;
        SLoadingView sLoadingView2;
        SLoadingView sLoadingView3;
        this.mOsdManager = new com.live.evo.osd.h();
        this.mOSDListProgramPresenter = new com.live.evo.osd.persenter.c(m5.a.a(getSupportFragmentManager()), new k());
        this.mOsdProgramNum = new com.live.evo.osd.j(StubApp.getOrigApplicationContext(getApplicationContext()), this.mContainer);
        this.mOsdNetwork = new com.live.evo.osd.i(StubApp.getOrigApplicationContext(getApplicationContext()), this.mContainer);
        this.mOsdProgramPromptSignalPoor = new com.live.evo.osd.l(StubApp.getOrigApplicationContext(getApplicationContext()), this.mContainer, R$string.signal_poor);
        this.mOsdProgramPromptLoading = new com.live.evo.osd.l(StubApp.getOrigApplicationContext(getApplicationContext()), this.mContainer, R$string.video_loading, true);
        this.mOsdProgramPromptRetrying = new com.live.evo.osd.l(StubApp.getOrigApplicationContext(getApplicationContext()), this.mContainer, R$string.video_retrying, true);
        this.mOsdProgramPromptOptimizing = new com.live.evo.osd.k(StubApp.getOrigApplicationContext(getApplicationContext()), this.mContainer, R$string.video_optimizing);
        com.live.evo.osd.h hVar = this.mOsdManager;
        if (hVar != null) {
            hVar.a("com.mm.droid.livetv.programnum", this.mOsdProgramNum);
        }
        com.live.evo.osd.h hVar2 = this.mOsdManager;
        if (hVar2 != null) {
            hVar2.a("com.mm.droid.livetv.networkprompt", this.mOsdNetwork);
        }
        com.live.evo.osd.h hVar3 = this.mOsdManager;
        if (hVar3 != null) {
            hVar3.a("com.mm.droid.livetv.program_prompt", this.mOsdProgramPromptSignalPoor);
        }
        String strQ = com.live.evo.util.o0.p().q();
        if (strQ == null) {
            strQ = "";
        }
        if (TextUtils.isEmpty(strQ)) {
            return;
        }
        List<String> listG = new ua.l(",").g(strQ, 0);
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
        if (strArr.length != 2) {
            if (strArr.length != 1 || TextUtils.isEmpty(strArr[0]) || !Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$", strArr[0]) || (sLoadingView = this.mLoadingView) == null) {
                return;
            }
            sLoadingView.setColorFilter(Color.parseColor(strArr[0]));
            return;
        }
        if (!TextUtils.isEmpty(strArr[0]) && Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$", strArr[0]) && (sLoadingView3 = this.mLoadingView) != null) {
            sLoadingView3.setColorFilter(Color.parseColor(strArr[0]));
        }
        if (TextUtils.isEmpty(strArr[1]) || !Pattern.matches("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$", strArr[1]) || (sLoadingView2 = this.mLoadingView) == null) {
            return;
        }
        sLoadingView2.setColorExtra(Color.parseColor(strArr[1]));
    }

    private final void R3(int visibility) {
        View view = this.mNoSignal;
        if (view != null) {
            view.setVisibility(visibility);
        }
        ImageView imageView = this.mNoSignalIv;
        if (imageView != null) {
            imageView.setVisibility(visibility);
        }
    }

    private final void S2() {
        com.live.evo.util.s0 s0Var = com.live.evo.util.s0.f7342a;
        this.mListLiveDataAll = s0Var.w();
        this.mCategoryIdList = t.v.c.i.a.f18646a.u(Boolean.TRUE);
        this.mMapCategoryPrograms = s0Var.C();
        this.mGroupsList = s0Var.t();
    }

    private final void S3(Integer resId) {
        ImageView imageView = this.mNoSignalIv;
        if (imageView == null) {
            return;
        }
        try {
            i5.h hVarA2 = A2();
            imageView.setImageDrawable(null);
            R3(0);
            if (hVarA2 != null) {
                hVarA2.k();
            }
            com.live.evo.util.v.a(this, resId != null ? resId.intValue() : R$drawable.no_signal, 0, imageView);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z U2(final LiveNewActivity liveNewActivity, boolean z10, String loadingTip) {
        kotlin.jvm.internal.m.f(loadingTip, "loadingTip");
        if (z10) {
            com.live.evo.osd.l lVar = liveNewActivity.mOsdProgramPromptLoading;
            if (lVar == null || lVar.b() != 0) {
                liveNewActivity.mHandler.post(new Runnable() { // from class: com.live.evo.activity.q1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.V2(this.f5502a);
                    }
                });
            }
        } else {
            liveNewActivity.mHandler.post(new Runnable() { // from class: com.live.evo.activity.r1
                @Override // java.lang.Runnable
                public final void run() {
                    LiveNewActivity.W2(this.f5505a);
                }
            });
        }
        return r8.z.f17874a;
    }

    private final void U3(i5.h liveData) {
        com.live.evo.g gVar = this.mUiManager;
        if (gVar != null) {
            gVar.g();
        }
        com.live.evo.l.n().T(this, new w(), liveData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(LiveNewActivity liveNewActivity) {
        com.live.evo.osd.l lVar = liveNewActivity.mOsdProgramPromptLoading;
        if (lVar != null) {
            lVar.k();
        }
        com.live.evo.osd.h hVar = liveNewActivity.mOsdManager;
        if (hVar != null) {
            hVar.c(liveNewActivity.mOsdProgramPromptLoading);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W2(LiveNewActivity liveNewActivity) {
        com.live.evo.osd.h hVar = liveNewActivity.mOsdManager;
        if (hVar != null) {
            hVar.b(liveNewActivity.mOsdProgramPromptLoading);
        }
        com.live.evo.osd.l lVar = liveNewActivity.mOsdProgramPromptLoading;
        if (lVar != null) {
            lVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W3(i5.h intentChannel) {
        com.live.evo.g gVar = this.mUiManager;
        if (gVar != null) {
            gVar.r(intentChannel, this.playInGroupIdx, this.playGroupIdx, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z X2(final LiveNewActivity liveNewActivity, final int i10, final String desc) {
        kotlin.jvm.internal.m.f(desc, "desc");
        liveNewActivity.mHandler.post(new Runnable() { // from class: com.live.evo.activity.c1
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.Y2(i10, liveNewActivity, desc);
            }
        });
        return r8.z.f17874a;
    }

    private final void X3(i5.h intentChannel, int inputCode) {
        com.live.evo.g gVar = this.mUiManager;
        if (gVar != null) {
            gVar.r(intentChannel, this.playInGroupIdx, this.playGroupIdx, inputCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y2(int i10, LiveNewActivity liveNewActivity, String str) {
        switch (i10) {
            case -1:
                liveNewActivity.R3(8);
                SpeedTextView speedTextView = liveNewActivity.mNoticeView;
                if (speedTextView != null) {
                    speedTextView.setVisibility(8);
                }
                break;
            case 0:
            case 8:
                liveNewActivity.R3(0);
                SpeedTextView speedTextView2 = liveNewActivity.mNoticeView;
                if (speedTextView2 != null) {
                    speedTextView2.setVisibility(0);
                }
                liveNewActivity.j3(Integer.valueOf(R$drawable.requesttimeout));
                if (liveNewActivity.isPopupLoginOrRenewFragment) {
                    liveNewActivity.logger.warn("there is a popup window, ignore " + i10, new Object[0]);
                    return;
                } else if (liveNewActivity.lastPlayTime >= liveNewActivity.tipNoNetworkTime) {
                    liveNewActivity.tipNoNetworkTime = com.live.evo.util.q1.b();
                    Message messageObtainMessage = liveNewActivity.mHandler.obtainMessage(620908545);
                    kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
                    liveNewActivity.mHandler.sendMessage(messageObtainMessage);
                }
                break;
            case 1:
                liveNewActivity.onServiceExpired(new b5.i());
                break;
            case 2:
                x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
                String string = liveNewActivity.getString(2131952584);
                kotlin.jvm.internal.m.e(string, "getString(...)");
                g1Var.c(string);
                break;
            case 3:
            case 4:
                if (liveNewActivity.isPopupLoginOrRenewFragment) {
                    liveNewActivity.logger.warn("there is a popup window, ignore " + i10, new Object[0]);
                    return;
                }
                liveNewActivity.p4();
                break;
            case 5:
                if (!TextUtils.isEmpty(liveNewActivity.apkFile)) {
                    liveNewActivity.a3();
                } else {
                    liveNewActivity.o2();
                }
                break;
            case 6:
                liveNewActivity.R3(0);
                SpeedTextView speedTextView3 = liveNewActivity.mNoticeView;
                if (speedTextView3 != null) {
                    speedTextView3.setVisibility(0);
                }
                liveNewActivity.j3(Integer.valueOf(R$drawable.no_signal));
                break;
            case 7:
                x1.f1.lb.util.g1 g1Var2 = x1.f1.lb.util.g1.f21390a;
                String string2 = liveNewActivity.getString(R$string.channel_not_found);
                kotlin.jvm.internal.m.e(string2, "getString(...)");
                g1Var2.c(string2);
                break;
        }
        SpeedTextView speedTextView4 = liveNewActivity.mNoticeView;
        if (speedTextView4 != null) {
            speedTextView4.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1() {
        d dVar = this.rechargeAction;
        if (dVar != null) {
            Handler handler = this.mHandler;
            kotlin.jvm.internal.m.c(dVar);
            handler.removeCallbacks(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r8.z Z2(LiveNewActivity liveNewActivity) {
        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
        String string = liveNewActivity.getString(2131953196);
        kotlin.jvm.internal.m.e(string, "getString(...)");
        g1Var.c(string);
        return r8.z.f17874a;
    }

    private final void a2() {
        Handler handler = this.mHandler;
        b bVar = this.ecoModeAction;
        kotlin.jvm.internal.m.c(bVar);
        handler.removeCallbacks(bVar);
    }

    private final void a3() {
        nf.z zVar = this.upgradeEvent;
        if (zVar != null) {
            OnEvent(zVar);
            return;
        }
        String str = this.apkFile;
        if (str == null) {
            return;
        }
        t.v.c.i.a.f18646a.E0(this, 2131953119, 2131953118, 2131953117, R$drawable.ic_launcher_foreground, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b3() {
        int i10;
        Integer num = this.resumeFrom;
        if (num != null && num.intValue() == 3) {
            this.resumeFrom = null;
            return false;
        }
        long jI = t.v.c.i.a.f18646a.I();
        return jI > com.live.evo.util.u1.b().a() || (jI < com.live.evo.util.u1.b().a() && (((i10 = this.mExpiredStatus) == 0 || i10 == 1) && !this.isPopupLoginOrRenewFragment));
    }

    private final void b4(final int inAllPos) {
        com.live.evo.util.k1.f7250a.c(new Runnable() { // from class: com.live.evo.activity.s1
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.c4(inAllPos, this);
            }
        });
    }

    private final void c2(String newCode) {
        i5.h hVar;
        i5.h hVar2;
        i5.h hVar3;
        i5.h hVar4;
        TimerTask timerTask = this.replayTask;
        if (timerTask != null && timerTask != null) {
            timerTask.cancel();
        }
        R3(8);
        int i10 = Integer.parseInt(newCode) - 1;
        com.live.evo.osd.j jVar = this.mOsdProgramNum;
        if (jVar != null) {
            jVar.h(String.valueOf(i10), D2(i10));
        }
        h4(newCode);
        this.mInputCodeRepeatHandler.c();
        boolean zB = a5.b.a().b();
        Map mapI = kotlin.collections.n0.i();
        if (i10 >= 0) {
            List<? extends i5.h> list = this.mListLiveDataAll;
            if (i10 < (list != null ? list.size() : 0)) {
                if (!zB) {
                    List<? extends i5.h> list2 = this.mListLiveDataAll;
                    if ((list2 != null ? list2.get(i10) : null) != null) {
                        List<? extends i5.h> list3 = this.mListLiveDataAll;
                        if (list3 == null || (hVar4 = list3.get(i10)) == null || hVar4.p()) {
                            return;
                        }
                        List<? extends i5.h> list4 = this.mListLiveDataAll;
                        W3(list4 != null ? list4.get(i10) : null);
                        return;
                    }
                }
                if (zB) {
                    List<? extends i5.h> list5 = this.mListLiveDataAll;
                    if ((list5 != null ? list5.get(i10) : null) != null) {
                        List<? extends i5.h> list6 = this.mListLiveDataAll;
                        if (mapI.containsKey((list6 == null || (hVar3 = list6.get(i10)) == null) ? null : hVar3.b())) {
                            List<? extends i5.h> list7 = this.mListLiveDataAll;
                            if (list7 == null || (hVar2 = list7.get(i10)) == null || hVar2.p()) {
                                return;
                            }
                            List<? extends i5.h> list8 = this.mListLiveDataAll;
                            W3(list8 != null ? list8.get(i10) : null);
                            return;
                        }
                    }
                }
                if (zB) {
                    List<? extends i5.h> list9 = this.mListLiveDataAll;
                    if ((list9 != null ? list9.get(i10) : null) != null) {
                        List<? extends i5.h> list10 = this.mListLiveDataAll;
                        if (!mapI.containsKey((list10 == null || (hVar = list10.get(i10)) == null) ? null : hVar.b())) {
                            X3(null, i10);
                            return;
                        }
                    }
                }
                X3(null, i10);
                return;
            }
        }
        X3(null, i10);
    }

    private final void d2(boolean bDown) {
        String lowerCase;
        List<i5.h> list;
        boolean z10;
        List<i5.h> listV2;
        String str;
        List<String> list2 = this.mCategoryIdList;
        if (list2 == null || (list2 != null && list2.isEmpty())) {
            this.mCategoryIdList = t.v.c.i.a.f18646a.u(Boolean.TRUE);
        }
        List<String> list3 = this.mCategoryIdList;
        if (list3 != null) {
            if (list3 == null || !list3.isEmpty()) {
                List<String> list4 = this.mCategoryIdList;
                int size = list4 != null ? list4.size() : 0;
                int i10 = this.playGroupIdx;
                if (size <= i10) {
                    return;
                }
                List<i5.h> list5 = null;
                if (this.isPlayFavoriteList) {
                    listV2 = v2();
                    z10 = false;
                } else {
                    List<String> list6 = this.mCategoryIdList;
                    if (list6 == null || (str = list6.get(i10)) == null) {
                        lowerCase = null;
                    } else {
                        Locale locale = Locale.getDefault();
                        kotlin.jvm.internal.m.e(locale, "getDefault(...)");
                        lowerCase = str.toLowerCase(locale);
                        kotlin.jvm.internal.m.e(lowerCase, "toLowerCase(...)");
                    }
                    boolean z11 = ua.n.w("history", lowerCase, true) && !a5.b.a().b();
                    HashMap<String, List<i5.h>> map = this.mMapCategoryPrograms;
                    if (map != null) {
                        List<String> list7 = this.mCategoryIdList;
                        list = map.get(list7 != null ? list7.get(this.playGroupIdx) : null);
                    } else {
                        list = null;
                    }
                    List<i5.h> list8 = list;
                    z10 = z11;
                    listV2 = list8;
                }
                if (listV2 == null || listV2.isEmpty() || z10) {
                    this.isPlayFavoriteList = false;
                    if (this.playGroupIdx == 0) {
                        this.playInGroupIdx = 0;
                        return;
                    }
                    this.playGroupIdx = 0;
                    HashMap<String, List<i5.h>> map2 = this.mMapCategoryPrograms;
                    if (map2 != null) {
                        List<String> list9 = this.mCategoryIdList;
                        list5 = map2.get(list9 != null ? list9.get(0) : null);
                    }
                    int iIndexOf = list5 != null ? list5.indexOf(A2()) : 0;
                    this.playInGroupIdx = bDown ? iIndexOf + 1 : iIndexOf - 1;
                    d2(bDown);
                    return;
                }
                int i11 = this.playInGroupIdx;
                if (i11 < 0) {
                    this.playInGroupIdx = listV2.size() - 1;
                } else if (i11 >= listV2.size()) {
                    this.playInGroupIdx = 0;
                }
                i5.h hVar = listV2.get(this.playInGroupIdx);
                i5.h hVarA2 = A2();
                if (hVarA2 == null || hVarA2.equals(hVar)) {
                    return;
                }
                b4(hVar != null ? hVar.i() : 0);
                W3(hVar);
                h4("keydown:" + bDown);
                this.mKeyUpDownRepeatHandler.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e4() {
        if (this.feedbackDialogFragment == null) {
            this.feedbackDialogFragment = new com.live.evo.fragment.b0();
        }
        try {
            com.live.evo.fragment.b0 b0Var = this.feedbackDialogFragment;
            if (b0Var != null) {
                i5.h hVarA2 = A2();
                b0Var.X(hVarA2 != null ? hVarA2.e() : null);
            }
            com.live.evo.fragment.b0 b0Var2 = this.feedbackDialogFragment;
            if (b0Var2 != null) {
                i5.h hVarA3 = A2();
                b0Var2.W(hVarA3 != null ? hVarA3.b() : null);
            }
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
            if (supportFragmentManager.findFragmentByTag("feedback") == null) {
                com.live.evo.fragment.b0 b0Var3 = this.feedbackDialogFragment;
                if (b0Var3 != null) {
                    b0Var3.show(supportFragmentManager, "feedback");
                    return;
                }
                return;
            }
            com.live.evo.fragment.b0 b0Var4 = this.feedbackDialogFragment;
            if (b0Var4 != null) {
                supportFragmentManager.beginTransaction().show(b0Var4).commitAllowingStateLoss();
            }
        } catch (Exception e10) {
            q6.b logger = this.logger;
            kotlin.jvm.internal.m.e(logger, "logger");
            c5.b.c(logger, e10, "open feedback error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f4() {
        final boolean zK0 = t.v.c.i.a.f18646a.k0();
        this.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.activity.d1
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.g4(this.f5422a, zK0);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g3(final LiveNewActivity liveNewActivity, IMediaPlayer iMediaPlayer, int i10, int i11) {
        liveNewActivity.mLiveErrorCount++;
        kotlin.jvm.internal.g0 g0Var = kotlin.jvm.internal.g0.f12340a;
        String str = String.format("-----player onError: what[%s] extra[%s] err count[%s]", Arrays.copyOf(new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(liveNewActivity.mLiveErrorCount)}, 3));
        kotlin.jvm.internal.m.e(str, "format(...)");
        Log.e("LiveNewActivity", str);
        String str2 = String.format("w[%s] ex[%s]", Arrays.copyOf(new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}, 2));
        kotlin.jvm.internal.m.e(str2, "format(...)");
        liveNewActivity.mLiveLastError = str2;
        if (liveNewActivity.mLiveErrorCount > 2) {
            liveNewActivity.runOnUiThread(new Runnable() { // from class: com.live.evo.activity.f1
                @Override // java.lang.Runnable
                public final void run() {
                    LiveNewActivity.h3(this.f5437a);
                }
            });
            return false;
        }
        if (i10 == 1) {
            liveNewActivity.H3(false, 5000);
        } else if (i10 != -38) {
            liveNewActivity.H3(true, 5000);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(LiveNewActivity liveNewActivity) {
        com.live.evo.osd.h hVar = liveNewActivity.mOsdManager;
        if (hVar != null) {
            hVar.c(liveNewActivity.mOsdProgramPromptSignalPoor);
        }
    }

    private final boolean j2() {
        List<i5.h> listV2;
        List<i5.h> listV3 = null;
        if (this.isPlayFavoriteList) {
            listV2 = v2();
        } else {
            HashMap<String, List<i5.h>> map = this.mMapCategoryPrograms;
            if (map != null) {
                List<String> list = this.mCategoryIdList;
                listV2 = map.get(list != null ? list.get(this.playGroupIdx) : null);
            } else {
                listV2 = null;
            }
        }
        if (listV2 != null && !listV2.isEmpty()) {
            return true;
        }
        S2();
        if (this.isPlayFavoriteList) {
            listV3 = v2();
        } else {
            HashMap<String, List<i5.h>> map2 = this.mMapCategoryPrograms;
            if (map2 != null) {
                List<String> list2 = this.mCategoryIdList;
                listV3 = map2.get(list2 != null ? list2.get(this.playGroupIdx) : null);
            }
        }
        return (listV3 == null || listV3.isEmpty()) ? false : true;
    }

    private final void j3(Integer resId) {
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            playerView.J(true);
            S3(resId);
        }
    }

    private final Pair<Boolean, String> k2(String channleId) {
        List<i5.a0> listC = com.live.evo.util.b1.c("private_group");
        kotlin.jvm.internal.m.e(listC, "getProperties(...)");
        List<String> listU = t.v.c.i.a.f18646a.u(Boolean.TRUE);
        String strA = "";
        boolean zEquals = false;
        for (i5.a0 a0Var : listC) {
            if (listU.contains(a0Var.a())) {
                strA = a0Var.a();
                List<i5.h> list = com.live.evo.util.s0.f7342a.C().get(a0Var.a());
                if (list != null) {
                    Iterator<i5.h> it = list.iterator();
                    int i10 = 0;
                    while (it.hasNext()) {
                        i5.h next = it.next();
                        if (kotlin.jvm.internal.m.a(channleId, next != null ? next.b() : null)) {
                            this.playGroupIdx = listU.indexOf(a0Var.a());
                            this.playInGroupIdx = i10;
                            zEquals = a0Var.b().equals("1");
                            break;
                        }
                        i10++;
                    }
                }
            }
        }
        return new Pair<>(Boolean.valueOf(zEquals), strA);
    }

    private final void k3(String channelId, int eventType, int times, long duration) {
        if (this.livePlayHandler != null) {
            HashMap map = new HashMap();
            map.put("channel_id", channelId);
            map.put("times", Integer.valueOf(times));
            map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(duration));
            n2 n2Var = this.livePlayHandler;
            if (n2Var != null) {
                n2Var.a(eventType, map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2() {
        if (t.v.c.i.a.f18646a.I() > com.live.evo.util.u1.b().a() || this.mExpiredStatus >= 2) {
            return;
        }
        onServiceExpired(new b5.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l3() {
        try {
            if (this.livePlayHandler != null) {
                HashMap map = new HashMap();
                i5.h hVarA2 = A2();
                map.put("channel_id", hVarA2 != null ? hVarA2.b() : null);
                n2 n2Var = this.livePlayHandler;
                if (n2Var != null) {
                    n2Var.a(101, map);
                }
            }
        } catch (Exception unused) {
        }
    }

    private final void l4() {
        try {
            e eVar = this.trafficTask;
            if (eVar != null) {
                if (eVar != null) {
                    eVar.cancel();
                }
                this.mTimer.purge();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o2() {
        if (this.isInChecking.compareAndSet(false, true)) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new i(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o3() {
        String strB;
        int i10;
        if (this.mBufferingStartTime <= 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.mBufferingStartTime;
        this.mBufferingStartTime = 0L;
        if (jElapsedRealtime >= 0 && jElapsedRealtime <= 86400000 && (i10 = this.mBufferingStartChannel) != -1 && i10 == this.playInAllIdx) {
            this.mBufferingDuration += jElapsedRealtime;
        }
        i5.h hVarB2 = B2(this.mBufferingStartChannel);
        if (hVarB2 != null) {
            strB = hVarB2.b();
            hVarB2.e();
        } else {
            strB = "";
        }
        k3(strB, 702, this.mBufferingTimes, this.mBufferingDuration);
    }

    private final void o4() {
        com.live.evo.util.m.b("liveLoadShowLogin");
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            playerView.J(true);
        }
        this.isPopupLoginOrRenewFragment = true;
        com.live.evo.fragment.login.j.h0(getSupportFragmentManager(), 22, Boolean.TRUE, new a0());
    }

    private final void p2() {
        HashMap<String, List<i5.h>> map = this.mMapCategoryPrograms;
        if (map != null) {
            map.put("history", kotlin.collections.r.l());
        }
    }

    private final void p4() {
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        int iM = aVar.M();
        if (iM == 1) {
            if (this.isPopupLoginOrRenewFragment) {
                this.logger.warn("there is a popup window, ignored " + iM, new Object[0]);
                return;
            }
            if (this.isLogoutDlgShow.compareAndSet(false, true)) {
                this.isPopupLoginOrRenewFragment = true;
                String string = getString(2131952914);
                kotlin.jvm.internal.m.e(string, "getString(...)");
                com.live.evo.dialog.b.j(this, string, getString(2131952327), getString(2131951835), new Runnable() { // from class: com.live.evo.activity.j1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.t4(this.f5456a);
                    }
                }, new Runnable() { // from class: com.live.evo.activity.k1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.u4(this.f5462a);
                    }
                }, new Runnable() { // from class: com.live.evo.activity.l1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.v4(this.f5468a);
                    }
                });
            }
            com.live.evo.osd.persenter.c cVar = this.mOSDListProgramPresenter;
            if (cVar != null) {
                cVar.hide();
                return;
            }
            return;
        }
        if (iM == 2) {
            if (this.isLogoutDlgShow.compareAndSet(false, true)) {
                String string2 = getString(R$string.force_logout_not_support_version, aVar.N());
                kotlin.jvm.internal.m.e(string2, "getString(...)");
                com.live.evo.dialog.b.j(this, string2, getString(2131951877), getString(2131952019), new Runnable() { // from class: com.live.evo.activity.g1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.q4(this.f5442a);
                    }
                }, new Runnable() { // from class: com.live.evo.activity.h1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.r4(this.f5449a);
                    }
                }, new Runnable() { // from class: com.live.evo.activity.i1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.s4(this.f5453a);
                    }
                });
                return;
            }
            return;
        }
        if (iM == 3) {
            com.live.evo.osd.l lVar = this.mOsdProgramPromptLoading;
            if (lVar != null) {
                lVar.j();
            }
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new b0(null), 3, null);
            return;
        }
        if (!this.isPopupLoginOrRenewFragment) {
            if (this.isLogoutDlgShow.compareAndSet(false, true)) {
                this.isPopupLoginOrRenewFragment = true;
                com.live.evo.dialog.b.j(this, getString(R$string.log_out), getString(2131952327), getString(2131951835), new Runnable() { // from class: com.live.evo.activity.m1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.w4(this.f5472a);
                    }
                }, new Runnable() { // from class: com.live.evo.activity.n1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.x4(this.f5477a);
                    }
                }, new Runnable() { // from class: com.live.evo.activity.o1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.y4(this.f5490a);
                    }
                });
                return;
            }
            return;
        }
        this.logger.warn("there is a popup window, ignored " + iM, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q4(LiveNewActivity liveNewActivity) {
        if (TextUtils.isEmpty(liveNewActivity.apkFile)) {
            liveNewActivity.o2();
        } else {
            liveNewActivity.a3();
        }
        liveNewActivity.isLogoutDlgShow.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r3(i5.h channelData, Throwable throwable) {
        q6.b logger = this.logger;
        kotlin.jvm.internal.m.e(logger, "logger");
        c5.b.c(logger, throwable, "Error in toPlay");
        x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
        String string = getString(R$string.play_unknown_err);
        kotlin.jvm.internal.m.e(string, "getString(...)");
        g1Var.c(string);
        if (c3(channelData)) {
            return;
        }
        s2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r4(LiveNewActivity liveNewActivity) {
        liveNewActivity.isLogoutDlgShow.set(false);
        liveNewActivity.r2(true);
    }

    private final void s2() {
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            playerView.J(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s4(LiveNewActivity liveNewActivity) {
        liveNewActivity.isLogoutDlgShow.set(false);
    }

    private final String u2(Intent intent) {
        Uri data;
        if (intent == null) {
            return null;
        }
        return (intent.getScheme() == null || !kotlin.jvm.internal.m.a("livetvcontent", intent.getScheme()) || (data = intent.getData()) == null) ? intent.getStringExtra("channelId") : data.getQueryParameter("channelId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u4(LiveNewActivity liveNewActivity) {
        liveNewActivity.isLogoutDlgShow.set(false);
        liveNewActivity.isPopupLoginOrRenewFragment = false;
    }

    private final List<i5.h> v2() {
        i5.h hVar;
        ArrayList arrayList = new ArrayList();
        List<String> list = this.mCategoryIdList;
        if (list != null && !list.isEmpty()) {
            HashMap<String, List<i5.h>> map = this.mMapCategoryPrograms;
            List<i5.h> list2 = null;
            if (map != null) {
                List<String> list3 = this.mCategoryIdList;
                list2 = map.get(list3 != null ? list3.get(0) : null);
            }
            int size = list2 != null ? list2.size() : 0;
            for (int i10 = 0; i10 < size; i10++) {
                if (list2 != null && (hVar = list2.get(i10)) != null && hVar.j() > 0) {
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v4(LiveNewActivity liveNewActivity) {
        liveNewActivity.isLogoutDlgShow.set(false);
        liveNewActivity.isPopupLoginOrRenewFragment = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x4(LiveNewActivity liveNewActivity) {
        liveNewActivity.isLogoutDlgShow.set(false);
        liveNewActivity.isPopupLoginOrRenewFragment = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y3(final i5.h liveData) {
        String strB;
        int iB0;
        com.live.evo.osd.l lVar;
        String strN;
        if (t.v.c.i.a.f18646a.o0()) {
            p4();
            return;
        }
        f4();
        com.live.evo.osd.l lVar2 = this.mOsdProgramPromptLoading;
        if (lVar2 != null) {
            lVar2.k();
        }
        if (j2()) {
            try {
                if (getWindow().getDecorView().getWindowToken() != null) {
                    W3(liveData);
                } else {
                    this.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.activity.l0
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveNewActivity.z3(this.f5466a, liveData);
                        }
                    }, 200L);
                }
            } catch (Exception e10) {
                this.logger.error(e10.getMessage(), e10);
            }
            b4(this.playInAllIdx);
            this.mLiveErrorCount = 0;
            String str = "";
            this.mLiveLastError = "";
            String str2 = (liveData == null || (strN = liveData.n()) == null) ? "" : strN;
            if (liveData == null || !liveData.p()) {
                if (liveData == null || this.playInAllIdx != liveData.i()) {
                    t.v.c.i.a.f18646a.I0();
                }
            } else if (!t.v.c.i.a.f18646a.e0()) {
                U3(liveData);
                k4(true);
                return;
            }
            com.live.evo.osd.l lVar3 = this.mOsdProgramPromptSignalPoor;
            if ((lVar3 != null ? Integer.valueOf(lVar3.b()) : null) == 0 && (lVar = this.mOsdProgramPromptSignalPoor) != null) {
                lVar.d(8);
            }
            this.mVideoPath = str2;
            this.mIsAdult = liveData != null && liveData.p();
            FrameLayout frameLayout = this.mMosaicView;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            this.mHandler.removeCallbacks(this.preparePlayAction);
            this.preparePlayAction.run();
            if (!TextUtils.isEmpty(str2) && (iB0 = ua.n.b0(str2, ":", 0, false, 6, null)) > 0) {
                kotlin.jvm.internal.m.e(str2.substring(0, iB0), "substring(...)");
            }
            if ((liveData != null ? Integer.valueOf(liveData.l()) : null) != 1) {
                this.mHandler.removeCallbacks(this.mOsdPromptRunnable);
                this.mOsdPromptRunnable.a(0);
                this.mHandler.postDelayed(this.mOsdPromptRunnable, 2000L);
            }
            if (liveData != null && (strB = liveData.b()) != null) {
                str = strB;
            }
            n2(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y4(LiveNewActivity liveNewActivity) {
        liveNewActivity.isLogoutDlgShow.set(false);
        liveNewActivity.isPopupLoginOrRenewFragment = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: z2, reason: from getter */
    public final com.live.evo.fragment.t1.b getNetworkTester() {
        return this.networkTester;
    }

    private final void z4(Fragment fragment) {
        if (fragment != null) {
            F2(fragment);
        }
        this.isPopupLoginOrRenewFragment = true;
        com.live.evo.fragment.login.j.h0(getSupportFragmentManager(), 54, Boolean.TRUE, new c0());
    }

    public final void J3() {
        com.live.evo.osd.persenter.c cVar;
        String strB = CatchUpPlayerActivity.a.f5240a.b();
        if (strB != null) {
            int iHashCode = strB.hashCode();
            if (iHashCode != -1526534151) {
                if (iHashCode == -1389202436) {
                    strB.equals("bigEpg");
                } else if (iHashCode == 738950403 && strB.equals(MessageOriginChannel.MESSAGE_ORIGIN_TYPE) && (cVar = this.mOSDListProgramPresenter) != null) {
                    cVar.H();
                }
            } else if (strB.equals("subjectMatch")) {
                xe.c cVarC = xe.c.c();
                String name = getClass().getName();
                kotlin.jvm.internal.m.e(name, "getName(...)");
                String name2 = com.live.evo.fragment.subjuect.w.Companion.class.getName();
                kotlin.jvm.internal.m.e(name2, "getName(...)");
                cVarC.o(new q7.a(name, name2));
            }
        }
        N3();
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(nf.a0 event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        if (!event.c()) {
            x1.f1.lb.util.g1 g1Var = x1.f1.lb.util.g1.f21390a;
            String strA = event.a();
            kotlin.jvm.internal.m.e(strA, "getErrMsg(...)");
            g1Var.c(strA);
            return;
        }
        com.live.evo.dialog.b.j(this, event.b().getVersionName() + "\n" + event.a(), getString(2131951924), getString(2131951835), new Runnable() { // from class: com.live.evo.activity.w1
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.i0();
            }
        }, new Runnable() { // from class: com.live.evo.activity.x1
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.j0();
            }
        }, new Runnable() { // from class: com.live.evo.activity.y1
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.k0();
            }
        });
    }

    public final void T3(boolean isShow) {
        this.isPopupLoginOrRenewFragment = isShow;
    }

    public final void V3() {
        n2 n2Var = this.livePlayHandler;
        if (n2Var != null) {
            n2Var.f();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        kotlin.jvm.internal.m.f(event, "event");
        PlayerView playerView = this.mVideoView;
        if (playerView != null && onKey(playerView, event.getKeyCode(), event)) {
            return true;
        }
        x1.f1.lb.util.d0.f21360a.p(event);
        return super.dispatchKeyEvent(event);
    }

    public final void k4(boolean closeOsd) {
        PlayerView playerView;
        PlayerView playerView2;
        if (this.lastPlayedLiveChannel != null) {
            try {
                if (com.live.evo.l.n().j("stop_prev_play_imm", true) && (playerView = this.mVideoView) != null) {
                    playerView.J(true);
                }
                if (closeOsd) {
                    com.live.evo.osd.h hVar = this.mOsdManager;
                    if (hVar != null) {
                        hVar.b(this.mOsdProgramPromptSignalPoor);
                    }
                    com.live.evo.osd.h hVar2 = this.mOsdManager;
                    if (hVar2 != null) {
                        hVar2.b(this.mOsdProgramPromptLoading);
                    }
                    com.live.evo.osd.h hVar3 = this.mOsdManager;
                    if (hVar3 != null) {
                        hVar3.b(this.mOsdProgramPromptOptimizing);
                    }
                    com.live.evo.osd.h hVar4 = this.mOsdManager;
                    if (hVar4 != null) {
                        hVar4.b(this.mOsdProgramPromptRetrying);
                    }
                }
            } catch (Throwable unused) {
            }
        } else {
            PlayerView playerView3 = this.mVideoView;
            if (playerView3 != null && playerView3.z() && (playerView2 = this.mVideoView) != null) {
                playerView2.J(true);
            }
        }
        n2 n2Var = this.livePlayHandler;
        if (n2Var != null) {
            n2Var.i();
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (com.live.evo.fragment.subjuect.b.f6641l) {
            com.live.evo.osd.persenter.c cVar = this.mOSDListProgramPresenter;
            if (cVar != null) {
                cVar.hide();
                cVar.M(getSupportFragmentManager(), "subject");
            }
            com.live.evo.fragment.subjuect.b.f6641l = false;
            return;
        }
        if (!a5.c.a().b()) {
            com.live.evo.g gVar = this.mUiManager;
            if (gVar == null || !gVar.h()) {
                Y3();
                return;
            }
            return;
        }
        com.live.evo.osd.persenter.c cVar2 = this.mOSDListProgramPresenter;
        if (cVar2 != null) {
            cVar2.hide();
        }
        com.live.evo.osd.persenter.c cVar3 = this.mOSDListProgramPresenter;
        if (cVar3 != null) {
            cVar3.M(getSupportFragmentManager(), "recommend");
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onChangeChannelEvent(b5.b event) {
        kotlin.jvm.internal.m.f(event, "event");
        String strA = event.a();
        kotlin.jvm.internal.m.e(strA, "getChannelId(...)");
        xe.c.c().s(event);
        if (TextUtils.isEmpty(strA)) {
            com.live.evo.util.r1.c(this, "channel is not null");
            return;
        }
        i5.h hVarA2 = A2();
        if (kotlin.jvm.internal.m.a(strA, hVarA2 != null ? hVarA2.b() : null)) {
            com.live.evo.util.r1.a(this, R$string.channel_playing_now);
            return;
        }
        i5.h hVarS = com.live.evo.util.s0.f7342a.s(strA);
        if (hVarS == null) {
            com.live.evo.util.r1.a(this, R$string.channel_doesnot_exist);
            return;
        }
        int i10 = this.playGroupIdx;
        int i11 = this.playInGroupIdx;
        int i12 = this.playInAllIdx;
        this.playGroupIdx = 0;
        this.playInGroupIdx = hVarS.i();
        this.playInAllIdx = hVarS.i();
        boolean zP = hVarS.p();
        if (zP && hVarA2 != null && !hVarA2.p()) {
            Pair<Boolean, String> pairK2 = k2(strA);
            if (((Boolean) pairK2.first).booleanValue()) {
                this.playGroupIdx = i10;
                this.playInGroupIdx = i11;
                this.playInAllIdx = i12;
                com.live.evo.util.r1.c(this, String.format(com.live.evo.util.x1.j(R$string.unlock_adult_category), pairK2.second));
                return;
            }
        }
        com.live.evo.l.n().b(this);
        com.live.evo.l.n().P(strA);
        if (!zP || hVarA2 == null || !hVarA2.p() || com.live.evo.l.n().D()) {
            PlayerView playerView = this.mVideoView;
            if ((playerView != null ? Integer.valueOf(playerView.getVisibility()) : null) == 0) {
                b2(this.playInAllIdx);
            }
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onChannelUpdateEvent(b5.c event) {
        if (event != null && event.a() == 2) {
            S2();
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        kotlin.jvm.internal.m.f(intent, "intent");
        super.onNewIntent(intent);
        String strU2 = u2(intent);
        if (TextUtils.isEmpty(strU2)) {
            return;
        }
        xe.c.c().o(new b5.b(strU2));
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(savedInstanceState, "savedInstanceState");
        try {
            super.onRestoreInstanceState(savedInstanceState);
            E3();
        } catch (Throwable th) {
            this.logger.error("Failed to restore instance state", th);
        }
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    protected void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.m.f(outState, "outState");
        d dVar = this.rechargeAction;
        if (dVar != null) {
            this.mHandler.removeCallbacks(dVar);
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onServiceExpired(final b5.i event) {
        kotlin.jvm.internal.m.f(event, "event");
        if (this.isPopupLoginOrRenewFragment) {
            this.logger.warn("there is a popup window, ignore ServiceExpiredEvent", new Object[0]);
            return;
        }
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        if (aVar.a0()) {
            this.logger.a("has valid plan, ignore ServiceExpiredEvent", new Object[0]);
            return;
        }
        this.isPopupLoginOrRenewFragment = true;
        if (aVar.Z().length() != 0) {
            if (!l3.INSTANCE.b()) {
                com.live.evo.dialog.b.j(this, getString(2131952427), getString(R$string.recharge), getString(2131951835), new Runnable() { // from class: com.live.evo.activity.t1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.v3(this.f5512a);
                    }
                }, new Runnable() { // from class: com.live.evo.activity.u1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.w3(this.f5514a, event);
                    }
                }, new Runnable() { // from class: com.live.evo.activity.v1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.x3(this.f5518a, event);
                    }
                });
                return;
            } else {
                this.isPopupLoginOrRenewFragment = false;
                this.logger.a("tab is visible, ignore ServiceExpiredEvent", new Object[0]);
                return;
            }
        }
        com.live.evo.dialog.b.j(this, getString(2131952427) + "<br/>" + getString(R$string.free_trial_tip, Integer.valueOf(aVar.T())), getString(2131952330), getString(2131951835), new Runnable() { // from class: com.live.evo.activity.t0
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.s3(this.f5511a);
            }
        }, new Runnable() { // from class: com.live.evo.activity.e1
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.t3(this.f5429a, event);
            }
        }, new Runnable() { // from class: com.live.evo.activity.p1
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.u3(this.f5495a, event);
            }
        });
    }

    @xe.m
    public final void onTokenChange(b5.l event) {
        n2 n2Var = this.livePlayHandler;
        if (n2Var != null) {
            n2Var.c(event);
        }
    }

    /* JADX INFO: renamed from: t2, reason: from getter */
    public final x4.a getCatchUpClickListener() {
        return this.catchUpClickListener;
    }

    /* JADX INFO: renamed from: x2, reason: from getter */
    public final Handler getMHandler() {
        return this.mHandler;
    }

    /* JADX INFO: renamed from: y2, reason: from getter */
    public final PlayerView getMVideoView() {
        return this.mVideoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D3(LiveNewActivity liveNewActivity) {
        liveNewActivity.C3();
    }

    private final void F2(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.m.e(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        fragmentTransactionBeginTransaction.hide(fragment);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2() {
        com.live.evo.g gVar;
        if (com.live.evo.k.b() != null && (gVar = this.mUiManager) != null && gVar != null) {
            gVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int G4(c9.p pVar, Object obj, Object obj2) {
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(com.live.evo.osd.persenter.c cVar) {
        cVar.hide();
    }

    public static final /* synthetic */ p5.a K0(LiveNewActivity liveNewActivity) {
        liveNewActivity.getClass();
        return null;
    }

    private final void K3() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = jElapsedRealtime - this.lastKeyTime;
        this.lastKeyTime = jElapsedRealtime;
        if (j10 > FileWatchdog.DEFAULT_DELAY) {
            G3();
        }
    }

    private final void N2(Intent intent) {
        u2(intent);
        if (intent != null) {
            intent.removeExtra("channelId");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O3(LiveNewActivity liveNewActivity) {
        liveNewActivity.y3(liveNewActivity.A2());
    }

    /* JADX WARN: Code duplicated, block: B:67:0x015e A[Catch: all -> 0x016e, TRY_LEAVE, TryCatch #1 {all -> 0x016e, blocks: (B:24:0x00c8, B:26:0x00d5, B:29:0x00df, B:31:0x00e9, B:33:0x00f9, B:35:0x00fd, B:38:0x0105, B:40:0x010d, B:42:0x0112, B:45:0x0119, B:48:0x0123, B:51:0x012b, B:54:0x0132, B:56:0x0136, B:58:0x0141, B:62:0x014f, B:66:0x015b, B:60:0x0147, B:67:0x015e), top: B:76:0x00c8 }] */
    private final void P2() {
        List listL;
        List<i5.h> list;
        i5.h hVar;
        int size;
        List<i5.h> list2;
        String strB = com.live.evo.util.b2.b();
        kotlin.jvm.internal.m.e(strB, "getHistory(...)");
        this.lookBackInfo = "-1,-1,-1";
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
        this.playGroupIdx = Integer.parseInt(strArr[0]);
        this.playInGroupIdx = Integer.parseInt(strArr[1]);
        int i10 = Integer.parseInt(strArr[2]);
        this.playInAllIdx = i10;
        int i11 = this.playGroupIdx;
        int i12 = this.playInGroupIdx;
        ArrayList arrayList = new ArrayList();
        List<String> list3 = this.mCategoryIdList;
        kotlin.jvm.internal.m.c(list3);
        arrayList.addAll(list3);
        if (com.live.evo.k.b().h()) {
            List<i5.a0> listC = com.live.evo.util.b1.c("private_group");
            kotlin.jvm.internal.m.e(listC, "getProperties(...)");
            for (i5.a0 a0Var : listC) {
                List<String> list4 = this.mCategoryIdList;
                if (list4 != null && list4.contains(a0Var.a()) && a0Var.b().equals("1")) {
                    arrayList.remove(a0Var.a());
                }
            }
        }
        try {
            try {
                String str = (String) arrayList.get(this.playGroupIdx);
                HashMap<String, List<i5.h>> map = this.mMapCategoryPrograms;
                i5.h hVar2 = null;
                if (map != null) {
                    list = map.get(str);
                } else {
                    list = null;
                }
                if (list != null) {
                    hVar = list.get(this.playInGroupIdx);
                } else {
                    hVar = null;
                }
                i5.i iVar = com.live.evo.util.s0.f7342a.t().get(str);
                int i13 = this.playInAllIdx;
                if (i13 >= 0) {
                    List<? extends i5.h> list5 = this.mListLiveDataAll;
                    if (list5 != null) {
                        size = list5.size();
                    } else {
                        size = 0;
                    }
                    if (i13 < size && this.playGroupIdx < arrayList.size() && (list2 = list) != null && !list2.isEmpty() && this.playInGroupIdx < list.size() && hVar != null && !hVar.o() && iVar != null && iVar.g() != 1) {
                        List<? extends i5.h> list6 = this.mListLiveDataAll;
                        if (list6 != null) {
                            hVar2 = list6.get(this.playInAllIdx);
                        }
                        if ((hVar2 != null && hVar2.p()) || t.v.c.i.a.f18646a.e0()) {
                            this.playGroupIdx = 0;
                            this.playInGroupIdx = 0;
                            this.playInAllIdx = 0;
                            if (i11 == 0 && i12 == 0 && i10 == 0) {
                                this.playInAllIdx = 1;
                            }
                        }
                    } else {
                        this.playGroupIdx = 0;
                        this.playInGroupIdx = 0;
                        this.playInAllIdx = 0;
                    }
                } else {
                    this.playGroupIdx = 0;
                    this.playInGroupIdx = 0;
                    this.playInAllIdx = 0;
                }
                P3(this.playGroupIdx, this.playInGroupIdx, this.playInAllIdx);
            } catch (Throwable th) {
                P3(this.playGroupIdx, this.playInGroupIdx, this.playInAllIdx);
                throw th;
            }
        } catch (Throwable unused) {
            this.playGroupIdx = 0;
            this.playInGroupIdx = 0;
            this.playInAllIdx = 0;
            P3(0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P3(int targetCategory, int targetChannel, int targetAllPos) {
        this.lookBackInfo = com.live.evo.util.b2.b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(targetCategory);
        String string = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(targetChannel);
        com.live.evo.util.b2.a(string, sb3.toString(), targetAllPos);
    }

    private final void T2() {
        this.mContainer = (RelativeLayout) findViewById(R$id.livenewa_rl_parent);
        this.mVideoView = (PlayerView) findViewById(R$id.livenewa_ijk_main_videoview);
        this.player_stat_container = findViewById(R$id.livenewa_ll_player_stat_container);
        this.mPlayerStatInfoView = (TextView) findViewById(R$id.livenewa_tv_player_stat_info);
        this.mPrtStatInfoView = (TextView) findViewById(R$id.livenewa_tv_prt_stat_info);
        this.mLoadingView = (SLoadingView) findViewById(R$id.livenewa_slv);
        this.mNoticeView = (SpeedTextView) findViewById(R$id.livenewa_tv_notice);
        this.mNoSignal = findViewById(R$id.livenewa_rl_rly_no_signal_parent);
        this.mNoSignalIv = (ImageView) findViewById(R$id.livenewa_iv_no_signal);
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            playerView.setOnPreparedListener(this.mVideoPrepareListener);
        }
        PlayerView playerView2 = this.mVideoView;
        if (playerView2 != null) {
            playerView2.setOnErrorListener(this.mVideoOnErrorListener);
        }
        PlayerView playerView3 = this.mVideoView;
        if (playerView3 != null) {
            playerView3.setOnInfoListener(this.mVideoOnInfoListener);
        }
        PlayerView playerView4 = this.mVideoView;
        if (playerView4 != null) {
            playerView4.setOnCompletionListener(this.mVideoOnCompletionListener);
        }
        PlayerView playerView5 = this.mVideoView;
        if (playerView5 != null) {
            playerView5.setOnKeyListener(this);
        }
        PlayerView playerView6 = this.mVideoView;
        if (playerView6 != null) {
            playerView6.setLoadingListener(new c9.p() { // from class: com.live.evo.activity.v0
                @Override // c9.p
                public final Object invoke(Object obj, Object obj2) {
                    return LiveNewActivity.U2(this.f5517a, ((Boolean) obj).booleanValue(), (String) obj2);
                }
            });
        }
        PlayerView playerView7 = this.mVideoView;
        if (playerView7 != null) {
            playerView7.setNoSignalListener(new c9.p() { // from class: com.live.evo.activity.w0
                @Override // c9.p
                public final Object invoke(Object obj, Object obj2) {
                    return LiveNewActivity.X2(this.f5521a, ((Integer) obj).intValue(), (String) obj2);
                }
            });
        }
        PlayerView playerView8 = this.mVideoView;
        if (playerView8 != null) {
            playerView8.setPlayCompleteListener(new c9.a() { // from class: com.live.evo.activity.x0
                @Override // c9.a
                public final Object invoke() {
                    return LiveNewActivity.Z2(this.f5523a);
                }
            });
        }
        this.mUiManager = com.live.evo.g.o(this, this.mHandler, new x4.d(this));
        com.live.evo.osd.u.f7147a.h(this, this.mHandler, this.mSubscribeListener);
        com.live.evo.util.t.b(this.mNoticeView);
        com.live.evo.util.t.c(this.mPlayerStatInfoView);
        this.mMosaicView = (FrameLayout) findViewById(R$id.livenewa_mosaic_view);
    }

    private final void Y3() {
        if (!isFinishing() && !isDestroyed()) {
            com.live.evo.g gVar = this.mUiManager;
            if (gVar != null) {
                gVar.q(new x());
                return;
            }
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.activity.a1
            @Override // java.lang.Runnable
            public final void run() {
                LiveNewActivity.Z3();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a4() {
        com.live.evo.g gVar;
        if (com.live.evo.k.b() != null && (gVar = this.mUiManager) != null) {
            gVar.t();
        }
    }

    private final boolean c3(i5.h channelData) {
        i5.h hVarA2 = A2();
        if (hVarA2 == null) {
            if (channelData == null) {
                return false;
            }
            return true;
        }
        if (channelData != null && ac.g.d(hVarA2.b(), channelData.b())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d4(int showType) {
        com.live.evo.fragment.login.j.g0(getSupportFragmentManager(), showType, new y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(String tag, int index) {
        if (com.live.evo.k.b().l()) {
            this.mHandler.removeMessages(620908595);
            Message message = new Message();
            message.what = 620908595;
            message.arg1 = index;
            message.obj = tag;
            this.mHandler.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g4(LiveNewActivity liveNewActivity, boolean z10) {
        com.live.evo.g gVar;
        if (liveNewActivity.getWindow().getDecorView().getWindowToken() != null && (gVar = liveNewActivity.mUiManager) != null) {
            gVar.u(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i3(LiveNewActivity liveNewActivity, IMediaPlayer iMediaPlayer) {
        Integer numValueOf;
        com.live.evo.osd.l lVar;
        liveNewActivity.lastPlayTime = com.live.evo.util.q1.b();
        com.live.evo.osd.l lVar2 = liveNewActivity.mOsdProgramPromptLoading;
        if (lVar2 != null && lVar2.e()) {
            com.live.evo.osd.k kVar = liveNewActivity.mOsdProgramPromptOptimizing;
            if (kVar != null) {
                numValueOf = Integer.valueOf(kVar.b());
            } else {
                numValueOf = null;
            }
            if (numValueOf != 0 && (lVar = liveNewActivity.mOsdProgramPromptLoading) != null) {
                lVar.g();
            }
        }
        liveNewActivity.isChangeChannel = false;
        liveNewActivity.j4(1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void i4(i5.h channelData, Map<String, String> headers, String proxiedUrl) {
        if (c3(channelData)) {
            return;
        }
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        String strH = channelData.h();
        kotlin.jvm.internal.m.e(strH, "getId(...)");
        ChannelStreamResponse channelStreamResponseJ = aVar.j(Integer.parseInt(strH));
        if (channelStreamResponseJ == null) {
            x1.f1.lb.util.g1.f21390a.c(channelData.e() + " " + getString(R$string.channel_not_found));
            return;
        }
        E2();
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new z(channelData, channelStreamResponseJ, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m2() {
        return com.live.evo.util.t0.a(StubApp.getOrigApplicationContext(getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m3(LiveNewActivity liveNewActivity) {
        liveNewActivity.J3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n3(LiveNewActivity liveNewActivity) {
        liveNewActivity.J3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p3() {
        String strB;
        this.mBufferingStartTime = SystemClock.elapsedRealtime();
        int i10 = this.playInAllIdx;
        this.mBufferingStartChannel = i10;
        i5.h hVarB2 = B2(i10);
        if (hVarB2 != null) {
            strB = hVarB2.b();
            hVarB2.e();
        } else {
            strB = "";
        }
        String str = strB;
        int i11 = this.mBufferingTimes + 1;
        this.mBufferingTimes = i11;
        k3(str, 701, i11, this.mBufferingDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q3() {
        int iC;
        P2();
        if (b3()) {
            h4("onLoadDataSuccess");
            b2(this.playInAllIdx);
        }
        com.live.evo.osd.persenter.c cVar = this.mOSDListProgramPresenter;
        if (cVar != null) {
            if (cVar != null) {
                iC = cVar.C();
            } else {
                iC = 0;
            }
            com.live.evo.osd.persenter.c cVar2 = this.mOSDListProgramPresenter;
            if (cVar2 != null) {
                cVar2.K(String.valueOf(iC + 1));
            }
            com.live.evo.osd.persenter.c cVar3 = this.mOSDListProgramPresenter;
            if (cVar3 != null) {
                cVar3.J(iC);
            }
        }
        try {
            M3();
        } catch (Exception e10) {
            q6.b logger = this.logger;
            kotlin.jvm.internal.m.e(logger, "logger");
            c5.b.c(logger, e10, e10.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s3(LiveNewActivity liveNewActivity) {
        liveNewActivity.o4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t4(LiveNewActivity liveNewActivity) {
        liveNewActivity.o4();
        liveNewActivity.isLogoutDlgShow.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2() {
        P2();
        h4("getLastLookAndPlay");
        b2(this.playInAllIdx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w4(LiveNewActivity liveNewActivity) {
        liveNewActivity.o4();
        liveNewActivity.isLogoutDlgShow.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z3(LiveNewActivity liveNewActivity, i5.h hVar) {
        try {
            if (liveNewActivity.getWindow().getDecorView().getWindowToken() != null) {
                liveNewActivity.W3(hVar);
            }
        } catch (Exception e10) {
            liveNewActivity.logger.error(e10.getMessage(), e10);
        }
    }

    public final int C2() {
        i5.h hVarA2 = A2();
        if (hVarA2 != null) {
            return hVarA2.i();
        }
        return 0;
    }

    public final void C4() {
        if (!com.live.evo.l.n().C()) {
            View view = this.player_stat_container;
            if (view != null && view.getVisibility() == 0) {
                n2 n2Var = this.livePlayHandler;
                if (n2Var != null) {
                    n2Var.e(false, 10000);
                }
                View view2 = this.player_stat_container;
                if (view2 != null) {
                    view2.setVisibility(4);
                    return;
                }
                return;
            }
            return;
        }
        View view3 = this.player_stat_container;
        if (view3 != null && view3.getVisibility() == 0) {
            n2 n2Var2 = this.livePlayHandler;
            if (n2Var2 != null) {
                n2Var2.e(false, 10000);
            }
            View view4 = this.player_stat_container;
            if (view4 != null) {
                view4.setVisibility(4);
                return;
            }
            return;
        }
        View view5 = this.player_stat_container;
        if (view5 != null) {
            view5.setVisibility(0);
        }
        n2 n2Var3 = this.livePlayHandler;
        if (n2Var3 != null) {
            n2Var3.e(true, 10000);
        }
    }

    public final String D2(int position) {
        int size;
        List<? extends i5.h> list;
        i5.h hVar;
        i5.h hVar2;
        String strE;
        i5.h hVar3;
        List<? extends i5.h> list2;
        i5.h hVar4;
        i5.h hVar5;
        String strE2;
        boolean zB = a5.b.a().b();
        kotlin.collections.n0.i();
        List<? extends i5.h> list3 = this.mListLiveDataAll;
        if (list3 != null) {
            size = list3.size();
        } else {
            size = 0;
        }
        if (size > position && position >= 0) {
            i5.h hVar6 = null;
            if (!zB) {
                List<? extends i5.h> list4 = this.mListLiveDataAll;
                if (list4 != null) {
                    hVar3 = list4.get(position);
                } else {
                    hVar3 = null;
                }
                if (hVar3 != null && (list2 = this.mListLiveDataAll) != null && (hVar4 = list2.get(position)) != null && !hVar4.p()) {
                    List<? extends i5.h> list5 = this.mListLiveDataAll;
                    if (list5 != null && (hVar5 = list5.get(position)) != null && (strE2 = hVar5.e()) != null) {
                        return strE2;
                    }
                    return getText(R$string.no_program).toString();
                }
            }
            if (zB) {
                List<? extends i5.h> list6 = this.mListLiveDataAll;
                if (list6 != null) {
                    hVar6 = list6.get(position);
                }
                if (hVar6 != null && (list = this.mListLiveDataAll) != null && (hVar = list.get(position)) != null && !hVar.p()) {
                    List<? extends i5.h> list7 = this.mListLiveDataAll;
                    if (list7 != null && (hVar2 = list7.get(position)) != null && (strE = hVar2.e()) != null) {
                        return strE;
                    }
                    return getText(R$string.no_program).toString();
                }
            }
        }
        return getText(R$string.no_program).toString();
    }

    public final void D4(boolean bShow) {
        f4();
    }

    public final void L3() {
        if (com.live.evo.l.n().l() <= com.live.evo.util.u1.b().a()) {
            onServiceExpired(new b5.i());
            return;
        }
        TimerTask timerTask = this.expiredRemindTimeTask;
        if (timerTask != null && timerTask != null) {
            timerTask.cancel();
        }
        RelativeLayout relativeLayout = this.mExpiredParent;
        if (relativeLayout != null && relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        n4();
        N3();
    }

    public final void b2(int position) {
        i5.h hVar;
        if (com.live.evo.l.n().J() && this.mExpiredStatus == 2) {
            this.logger.error("changeChannel is Expired.", new Object[0]);
            return;
        }
        List<? extends i5.h> list = this.mListLiveDataAll;
        if (list != null && list.isEmpty()) {
            this.logger.error("ListLiveData is empty, please check server.", new Object[0]);
            return;
        }
        List<? extends i5.h> list2 = this.mListLiveDataAll;
        if (list2 != null) {
            hVar = list2.get(position);
        } else {
            hVar = null;
        }
        this.playInAllIdx = position;
        com.live.evo.osd.persenter.c cVar = this.mOSDListProgramPresenter;
        if (cVar != null) {
            if (!this.isPlayFavoriteList) {
                if (cVar != null) {
                    cVar.I(this.playGroupIdx);
                }
                com.live.evo.osd.persenter.c cVar2 = this.mOSDListProgramPresenter;
                if (cVar2 != null) {
                    cVar2.J(this.playInGroupIdx);
                }
            }
            com.live.evo.osd.persenter.c cVar3 = this.mOSDListProgramPresenter;
            if (cVar3 != null) {
                cVar3.L(this.playInAllIdx);
            }
        }
        this.isChangeChannel = true;
        this.mBufferingTimes = 0;
        this.mBufferingDuration = 0L;
        this.mBufferingStartTime = 0L;
        y3(hVar);
        if ((hVar == null || !hVar.o() || com.live.evo.l.n().D()) && !this.isPlayFavoriteList) {
            P3(this.playGroupIdx, this.playInGroupIdx, this.playInAllIdx);
        }
        if (com.live.evo.k.b().n()) {
            com.live.evo.osd.u.f7147a.l(this.playInAllIdx);
        }
    }

    public final void e2(int position) {
        com.live.evo.l.n().C();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3) {
            this.resumeFrom = 3;
            if (resultCode > 0) {
                int i10 = resultCode - 1;
                if (this.playInAllIdx != i10) {
                    com.live.evo.osd.persenter.c cVar = this.mOSDListProgramPresenter;
                    if (cVar != null) {
                        cVar.hide();
                    }
                    this.playGroupIdx = 0;
                    this.playInGroupIdx = i10;
                    this.playInAllIdx = i10;
                    b2(i10);
                    return;
                }
                this.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.activity.y0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveNewActivity.m3(this.f5525a);
                    }
                }, 200L);
                return;
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.activity.z0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveNewActivity.n3(this.f5527a);
                }
            }, 200L);
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onClearHistory(b5.d event) {
        p2();
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        n4();
        a2();
        Z1();
        this.mHandler.removeCallbacksAndMessages(null);
        r2(true);
    }

    @xe.m(threadMode = ThreadMode.MAIN)
    public final void onNotice(i5.x noticeItem) {
        i5.h hVarA2 = A2();
        if (this.mNoticeView != null && hVarA2 != null) {
            String strB = hVarA2.b();
            kotlin.jvm.internal.m.e(strB, "getChannelId(...)");
            n2(strB);
        }
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        PlayerView playerView;
        super.onPause();
        this.mKeyUpDownRepeatHandler.e();
        this.mInputCodeRepeatHandler.e();
        if (this.mIsAdult && (playerView = this.mVideoView) != null) {
            playerView.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                unregisterReceiver(this.mMsgReceiver);
            } catch (Throwable th) {
                this.logger.error("unregister receiver failure", th);
            }
        }
        if (this.mIsAdult) {
            P2();
        }
        this.lastKeyTime = 0L;
        this.lastVersion = "";
        this.apkFile = "";
        this.lastPlayedLiveChannel = null;
        this.lastUpgradeEventTime = 0L;
        this.upgradeEvent = null;
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        H2();
        super.onResume();
        L2();
        F3();
        S2();
        this.mKeyUpDownRepeatHandler.d(this.changeChannelByKeyUpDownAction);
        this.mInputCodeRepeatHandler.d(this.changeChannelByInputCodeAction);
        if (b3()) {
            G3();
            PlayerView playerView = this.mVideoView;
            if (playerView != null) {
                if (playerView.getVisibility() != 0) {
                    playerView.setVisibility(0);
                }
                com.live.evo.osd.l lVar = this.mOsdProgramPromptLoading;
                if (lVar != null) {
                    lVar.k();
                }
                w2();
            }
        } else if (!this.isFirstStart && this.mExpiredStatus == 2) {
            onServiceExpired(new b5.i());
        }
        M3();
        if (this.isFirstStart) {
            this.isFirstStart = false;
        }
        i5.h hVarA2 = A2();
        if (this.mNoticeView != null && hVarA2 != null) {
            String strB = hVarA2.b();
            kotlin.jvm.internal.m.e(strB, "getChannelId(...)");
            n2(strB);
        }
        Message messageObtainMessage = this.mHandler.obtainMessage(620908574);
        kotlin.jvm.internal.m.e(messageObtainMessage, "obtainMessage(...)");
        this.mHandler.sendMessageDelayed(messageObtainMessage, FileWatchdog.DEFAULT_DELAY);
    }

    @Override // com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.isFirstStart) {
            this.mHandler.sendEmptyMessageDelayed(620908546, 300L);
        }
    }

    @Override // com.live.evo.activity.base.BaseActivity, com.live.evo.activity.base.MonitorableActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        k4(true);
        n2 n2Var = this.livePlayHandler;
        if (n2Var != null && n2Var != null) {
            n2Var.g();
        }
        l4();
        m4(false);
        a2();
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            playerView.J(true);
        }
        com.live.evo.dialog.q qVar = this.noticeAlertDialog;
        if (qVar != null) {
            qVar.c();
        }
        com.live.evo.dialog.u uVar = this.subscribeDialog;
        if (uVar != null) {
            uVar.j();
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onSubscribe(nf.x event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        PlayerView playerView = this.mVideoView;
        if (playerView != null) {
            playerView.J(true);
        }
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(nf.m event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        com.live.evo.osd.persenter.c cVar = this.mOSDListProgramPresenter;
        if (cVar != null) {
            cVar.hide();
        }
        if (this.subscribeDialog == null) {
            this.subscribeDialog = new com.live.evo.dialog.u(this, new q());
        }
        ChannelStreamResponse channelStreamResponseJ = t.v.c.i.a.f18646a.j(event.getKey());
        if (channelStreamResponseJ == null) {
            return;
        }
        EPGProgramme ePGProgramme = new EPGProgramme();
        ePGProgramme.setChannel(event.getEpgId());
        ePGProgramme.setStart(event.e());
        ePGProgramme.setStop(event.f().longValue());
        ePGProgramme.setTitle(event.d());
        ePGProgramme.setDesc(event.getDesc());
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new r(ePGProgramme, channelStreamResponseJ, this, null), 3, null);
    }

    @xe.m(sticky = true, threadMode = ThreadMode.MAIN)
    public final void OnEvent(nf.z event) {
        kotlin.jvm.internal.m.f(event, "event");
        xe.c.c().s(event);
        this.mHandler.removeMessages(620908574);
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.t()) {
            this.logger.debug("upgrade event[{}]", new com.google.gson.e().w(event));
        }
        int delayTime = event.b().getDelayTime() > 0 ? event.b().getDelayTime() * 1000 : 0;
        if (!event.c() && delayTime != 0) {
            if (bVar.t()) {
                this.logger.debug("upgrade event post to dlg", new Object[0]);
            }
            this.upgradeEvent = event;
            this.mHandler.postDelayed(new Runnable() { // from class: com.live.evo.activity.m0
                @Override // java.lang.Runnable
                public final void run() {
                    LiveNewActivity.l0(this.f5471a);
                }
            }, ((long) event.b().getDelayTime()) * 1000);
            return;
        }
        A3(event.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G3() {
    }

    private final void O2() {
    }

    private final void R2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0() {
    }

    private final void n4() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f3(IMediaPlayer iMediaPlayer) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(String tag) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h4(String action) {
    }

    private final void j4(long delay) {
    }

    private final void m4(boolean exitThread) {
    }

    private final void n2(String channelId) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y1(String tag, View container) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e3(IMediaPlayer iMediaPlayer, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q2(int type, int index) {
    }
}
