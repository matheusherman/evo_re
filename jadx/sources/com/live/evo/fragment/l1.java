package com.live.evo.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.live.evo.MyApplication;
import com.live.evo.R$color;
import com.live.evo.R$drawable;
import com.live.evo.R$id;
import com.live.evo.R$layout;
import com.live.evo.R$string;
import com.live.evo.R$style;
import com.live.evo.widget.MenuTabLayout;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import org.apache.log4j.helpers.FileWatchdog;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import ziyi.kit.keyboard.KeyUtils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000º\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ò\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002ó\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0005J!\u0010\u001c\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u001f\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u0005J\u0017\u0010)\u001a\u00020\"2\u0006\u0010(\u001a\u00020 H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010\u0005J\u0017\u0010,\u001a\u00020\b2\u0006\u0010(\u001a\u00020 H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010\u0005J\u000f\u0010/\u001a\u00020\bH\u0002¢\u0006\u0004\b/\u0010\u0005J\u000f\u00100\u001a\u00020\bH\u0002¢\u0006\u0004\b0\u0010\u0005J\u000f\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b1\u0010\u0005J\u0017\u00103\u001a\u00020\"2\u0006\u00102\u001a\u00020 H\u0002¢\u0006\u0004\b3\u0010*J\u000f\u00104\u001a\u00020\"H\u0002¢\u0006\u0004\b4\u00105J\u001f\u00108\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00102\u001a\u00020 ¢\u0006\u0004\b8\u00109J\u0019\u0010<\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=J-\u0010@\u001a\u0004\u0018\u00010$2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010>2\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\bH\u0016¢\u0006\u0004\bB\u0010\u0005J\u000f\u0010C\u001a\u00020\bH\u0016¢\u0006\u0004\bC\u0010\u0005J\u000f\u0010D\u001a\u00020\bH\u0016¢\u0006\u0004\bD\u0010\u0005J\u000f\u0010E\u001a\u00020\bH\u0016¢\u0006\u0004\bE\u0010\u0005J\u000f\u0010F\u001a\u00020\bH\u0004¢\u0006\u0004\bF\u0010\u0005J\u000f\u0010G\u001a\u00020\bH\u0004¢\u0006\u0004\bG\u0010\u0005J\r\u0010H\u001a\u00020\b¢\u0006\u0004\bH\u0010\u0005J)\u0010N\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010K\u001a\u00020\"2\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bN\u0010OJ\u0019\u0010R\u001a\u00020\b2\b\u0010Q\u001a\u0004\u0018\u00010PH\u0016¢\u0006\u0004\bR\u0010SJ!\u0010U\u001a\u00020\b2\b\u0010T\u001a\u0004\u0018\u0001062\u0006\u00102\u001a\u00020 H\u0016¢\u0006\u0004\bU\u00109J\u000f\u0010V\u001a\u00020\bH\u0016¢\u0006\u0004\bV\u0010\u0005J\u0019\u0010Y\u001a\u00020\b2\b\u0010X\u001a\u0004\u0018\u00010WH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\"H\u0016¢\u0006\u0004\b[\u00105J\u0017\u0010]\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\"H\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\b2\u0006\u0010_\u001a\u00020\"H\u0016¢\u0006\u0004\b`\u0010^J\u0017\u0010b\u001a\u00020\b2\u0006\u0010a\u001a\u00020\"H\u0016¢\u0006\u0004\bb\u0010^J\u000f\u0010c\u001a\u00020\bH\u0016¢\u0006\u0004\bc\u0010\u0005J\u000f\u0010d\u001a\u00020\bH\u0016¢\u0006\u0004\bd\u0010\u0005J\u000f\u0010e\u001a\u00020\bH\u0016¢\u0006\u0004\be\u0010\u0005J\u000f\u0010f\u001a\u00020\rH\u0016¢\u0006\u0004\bf\u0010\u000fJ\u0019\u0010h\u001a\u00020\b2\b\u0010g\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\bh\u0010-J)\u0010m\u001a\u00020\b2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010i2\b\u0010l\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\bm\u0010nJ#\u0010r\u001a\u00020\b2\b\u0010p\u001a\u0004\u0018\u00010o2\b\u0010q\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\br\u0010sJ\u000f\u0010t\u001a\u00020\bH\u0016¢\u0006\u0004\bt\u0010\u0005J\u0019\u0010v\u001a\u00020\b2\b\u0010M\u001a\u0004\u0018\u00010uH\u0007¢\u0006\u0004\bv\u0010wR\u001c\u0010|\u001a\n y*\u0004\u0018\u00010x0x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R!\u0010\u0087\u0001\u001a\f\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R \u0010\u0089\u0001\u001a\u000b\u0012\u0004\u0012\u00020 \u0018\u00010\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0086\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001c\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0081\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001a\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bc\u0010\u0099\u0001R\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u0099\u0001R\u001b\u0010 \u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b[\u0010\u009f\u0001R\u001a\u0010¡\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b`\u0010\u0099\u0001R)\u0010¦\u0001\u001a\u0004\u0018\u00010P8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\br\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0005\b¥\u0001\u0010SR\u0017\u0010§\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010VR\u0018\u0010©\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\be\u0010¨\u0001R\u0018\u0010ª\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bd\u0010¨\u0001R\u0018\u0010«\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b]\u0010¨\u0001R\u0017\u0010¬\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010VR\u001c\u0010°\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001c\u0010´\u0001\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R'\u0010¹\u0001\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0005\u0012\u00030¶\u00010µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u001c\u0010½\u0001\u001a\u0005\u0018\u00010º\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001c\u0010Á\u0001\u001a\u0005\u0018\u00010¾\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001c\u0010Å\u0001\u001a\u0005\u0018\u00010Â\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001c\u0010É\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u0019\u0010Ë\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010¨\u0001R\u0017\u0010Ì\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010VR\u0017\u0010Í\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010VR\u0018\u0010Ï\u0001\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÎ\u0001\u0010VR\u001c\u0010Ó\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001b\u0010Ö\u0001\u001a\u0005\u0018\u00010Ô\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bV\u0010Õ\u0001R\u0018\u0010Ø\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b×\u0001\u0010~R\u001c\u0010Ü\u0001\u001a\u0005\u0018\u00010Ù\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R%\u0010ß\u0001\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bm\u0010V\u001a\u0005\bÝ\u0001\u00105\"\u0005\bÞ\u0001\u0010^R%\u0010â\u0001\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bh\u0010V\u001a\u0005\bà\u0001\u00105\"\u0005\bá\u0001\u0010^R\u001b\u0010å\u0001\u001a\u0005\u0018\u00010ã\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bU\u0010ä\u0001R\u001a\u0010ç\u0001\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bæ\u0001\u0010~R\u001a\u0010é\u0001\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bè\u0001\u0010~R\u0018\u0010í\u0001\u001a\u00030ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R\u0018\u0010ñ\u0001\u001a\u00030î\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001¨\u0006ô\u0001"}, d2 = {"Lcom/live/evo/fragment/l1;", "Lcom/live/evo/fragment/b;", "Landroid/content/DialogInterface$OnKeyListener;", "Lcom/live/evo/osd/persenter/b;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Lr8/z;", "Z0", "(Landroid/view/LayoutInflater;)V", "V0", "F0", "", "w1", "()Z", "W0", "v1", "Y0", "q1", "S0", "isFocus", "t1", "(Z)V", "j1", "Landroid/widget/TextView;", "v", "hasFocus", "k1", "(Landroid/widget/TextView;Z)V", "J0", "a1", "", "title", "", "backResource", "Landroid/view/View;", "K0", "(Ljava/lang/String;I)Landroid/view/View;", "R0", "menuFirst", "G0", "(Ljava/lang/String;)I", "g1", "l1", "(Ljava/lang/String;)V", "f1", "O0", "Q0", "r1", "menuTag", "M0", "L0", "()I", "Landroidx/fragment/app/FragmentManager;", "fm", "u1", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/ViewGroup;", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "onPause", "onStop", "onDestroyView", "N0", "I0", "H0", "Landroid/content/DialogInterface;", "dialog", "keyCode", "Landroid/view/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onKey", "(Landroid/content/DialogInterface;ILandroid/view/KeyEvent;)Z", "Lcom/live/evo/osd/persenter/a;", "presenter", "s1", "(Lcom/live/evo/osd/persenter/a;)V", "fragmentManager", "N", "I", "Lb5/h;", "savePlayHistoryEvent", "F", "(Lb5/h;)V", "o", "classifyPosition", "u", "(I)V", "allPosition", "p", "inListSelectPos", "r", "m", "t", "s", "isShowing", IjkMediaMeta.IJKM_KEY_TRACK_ID, "M", "", "Li5/p;", "epgBeen", "channelId", "L", "(Ljava/util/List;Ljava/lang/String;)V", "", "throwable", "currentChannelId", "q", "(Ljava/lang/Throwable;Ljava/lang/String;)V", ExifInterface.LONGITUDE_EAST, "Lb5/g;", "onNotification", "(Lb5/g;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "c", "Lq6/b;", "logger", "d", "Ljava/lang/String;", "accountId", "e", "Landroid/view/View;", "mRoot", "", "Landroidx/fragment/app/Fragment;", "f", "Ljava/util/List;", "fragmentList", "g", "mTabMenuList", "Lcom/live/evo/widget/MenuTabLayout;", "h", "Lcom/live/evo/widget/MenuTabLayout;", "tabLayout", "Landroidx/viewpager/widget/ViewPager;", "i", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Landroidx/fragment/app/FragmentPagerAdapter;", "j", "Landroidx/fragment/app/FragmentPagerAdapter;", "viewPagerAdapter", "k", "mTabFunctionView", "l", "Landroid/widget/TextView;", "mTabRenew", "mTabMyAccount", "n", "mTabMyAccountMarketingActivity", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "mTabNotification", "mTabNotificationFlag", "Lcom/live/evo/osd/persenter/a;", "getMPresenter", "()Lcom/live/evo/osd/persenter/a;", "setMPresenter", "mPresenter", "curPosition", "Z", "isShow", "isTabFocus", "mIsRequestShow", "mSubjectPosition", "Lcom/live/evo/fragment/k0;", "w", "Lcom/live/evo/fragment/k0;", "mFunctionFragment", "Lcom/live/evo/fragment/x;", "x", "Lcom/live/evo/fragment/x;", "mChannelFragment", "", "Lcom/live/evo/fragment/subjuect/c0;", "y", "Ljava/util/Map;", "subjectTabFragmentMap", "Lcom/live/evo/fragment/s2;", "z", "Lcom/live/evo/fragment/s2;", "mPhoneScanFragment", "Lcom/live/evo/fragment/r2;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/live/evo/fragment/r2;", "mTabMyAccountFragment", "Lcom/live/evo/fragment/l3;", "B", "Lcom/live/evo/fragment/l3;", "mTabRechargeFragment", "Lcom/live/evo/fragment/p2;", "C", "Lcom/live/evo/fragment/p2;", "mTabNotificationFragment", "D", "mTabBtnCheck", "myaccountPosition", "rechargePosition", "G", "notificationPosition", "Ljava/util/TimerTask;", "H", "Ljava/util/TimerTask;", "hideTask", "Ljava/util/Timer;", "Ljava/util/Timer;", "mTimerMenu", "J", "menu_first", "Lb5/b;", "K", "Lb5/b;", "mCallEvent", "getMTabTextColorSelected", "setMTabTextColorSelected", "mTabTextColorSelected", "getMTabTextColorNormal", "setMTabTextColorNormal", "mTabTextColorNormal", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "mBindEmailBackgroundDrawable", "O", "mBindEmailText", "P", "mBindEmailBackgroundUrl", "Landroid/view/View$OnFocusChangeListener;", "Q", "Landroid/view/View$OnFocusChangeListener;", "mTabFunctionBtnFocusChangeListener", "Lcom/live/evo/fragment/y1;", "R", "Lcom/live/evo/fragment/y1;", "mOnEventListener", ExifInterface.LATITUDE_SOUTH, "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class l1 extends com.live.evo.fragment.b implements DialogInterface.OnKeyListener, com.live.evo.osd.persenter.b {

    /* JADX INFO: renamed from: S, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static SoftReference<l1> T;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private r2 mTabMyAccountFragment;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private l3 mTabRechargeFragment;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private p2 mTabNotificationFragment;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private boolean mTabBtnCheck;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private int myaccountPosition;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    private int rechargePosition;

    /* JADX INFO: renamed from: G, reason: from kotlin metadata */
    private int notificationPosition;

    /* JADX INFO: renamed from: H, reason: from kotlin metadata */
    private TimerTask hideTask;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    private b5.b mCallEvent;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    private int mTabTextColorSelected;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    private int mTabTextColorNormal;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    private Drawable mBindEmailBackgroundDrawable;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    private String mBindEmailText;

    /* JADX INFO: renamed from: P, reason: from kotlin metadata */
    private String mBindEmailBackgroundUrl;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mRoot;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private MenuTabLayout tabLayout;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewPager viewPager;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private FragmentPagerAdapter viewPagerAdapter;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private View mTabFunctionView;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private TextView mTabRenew;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mTabMyAccount;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private TextView mTabMyAccountMarketingActivity;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mTabNotification;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private TextView mTabNotificationFlag;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private com.live.evo.osd.persenter.a mPresenter;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isShow;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRequestShow;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int mSubjectPosition;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private k0 mFunctionFragment;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private x mChannelFragment;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private s2 mPhoneScanFragment;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(getClass());

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String accountId = t.v.c.i.a.f18646a.Y();

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<Fragment> fragmentList = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final List<String> mTabMenuList = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int curPosition = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean isTabFocus = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private Map<String, com.live.evo.fragment.subjuect.c0> subjectTabFragmentMap = new LinkedHashMap();

    /* JADX INFO: renamed from: I, reason: from kotlin metadata */
    private Timer mTimerMenu = new Timer();

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    private String menu_first = "Channel List";

    /* JADX INFO: renamed from: Q, reason: from kotlin metadata */
    private final View.OnFocusChangeListener mTabFunctionBtnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.h1
        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z10) {
            l1.b1(this.f5982a, view, z10);
        }
    };

    /* JADX INFO: renamed from: R, reason: from kotlin metadata */
    private final y1 mOnEventListener = new f();

    /* JADX INFO: renamed from: com.live.evo.fragment.l1$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/live/evo/fragment/l1$a;", "", "<init>", "()V", "Lcom/live/evo/fragment/l1;", "a", "()Lcom/live/evo/fragment/l1;", "Ljava/lang/ref/SoftReference;", "srfInstance", "Ljava/lang/ref/SoftReference;", "b", "()Ljava/lang/ref/SoftReference;", "c", "(Ljava/lang/ref/SoftReference;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final l1 a() {
            l1 l1Var;
            SoftReference<l1> softReferenceB = b();
            l1 l1Var2 = null;
            if (softReferenceB != null) {
                l1Var = softReferenceB.get();
            } else {
                l1Var = null;
            }
            if (l1Var != null && kotlin.jvm.internal.m.a(l1Var.accountId, t.v.c.i.a.f18646a.Y())) {
                return l1Var;
            }
            synchronized (l1.class) {
                Companion companion = l1.INSTANCE;
                SoftReference<l1> softReferenceB2 = companion.b();
                if (softReferenceB2 != null) {
                    l1Var2 = softReferenceB2.get();
                }
                if (l1Var2 != null) {
                    return l1Var2;
                }
                l1 l1Var3 = new l1();
                companion.c(new SoftReference<>(l1Var3));
                return l1Var3;
            }
        }

        public final SoftReference<l1> b() {
            return l1.T;
        }

        public final void c(SoftReference<l1> softReference) {
            l1.T = softReference;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\b\b\u0000\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/live/evo/fragment/l1$b", "Lb0/g;", "Landroid/graphics/drawable/Drawable;", "resource", "Lc0/b;", "transition", "Lr8/z;", "c", "(Landroid/graphics/drawable/Drawable;Lc0/b;)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends b0.g<Drawable> {
        b() {
        }

        @Override // b0.i
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Drawable resource, c0.b<? super Drawable> transition) {
            kotlin.jvm.internal.m.f(resource, "resource");
            l1.this.mBindEmailBackgroundDrawable = resource;
            l1.this.j1();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"com/live/evo/fragment/l1$c", "Lcom/live/evo/widget/MenuTabLayout$a;", "Lcom/live/evo/widget/MenuTabLayout$c;", "Lcom/live/evo/widget/MenuTabLayout;", "view", "", "index", "Lr8/z;", "b", "(Lcom/live/evo/widget/MenuTabLayout$c;I)V", "a", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements MenuTabLayout.a {
        @Override // com.live.evo.widget.MenuTabLayout.a
        public void a(MenuTabLayout.c view, int index) {
            kotlin.jvm.internal.m.f(view, "view");
        }

        @Override // com.live.evo.widget.MenuTabLayout.a
        public void b(MenuTabLayout.c view, int index) {
            kotlin.jvm.internal.m.f(view, "view");
        }

        c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/live/evo/fragment/l1$d", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "getCount", "()I", "position", "", "getItemId", "(I)J", "Landroidx/fragment/app/Fragment;", "getItem", "(I)Landroidx/fragment/app/Fragment;", "", "getPageTitle", "(I)Ljava/lang/CharSequence;", "Landroid/view/ViewGroup;", "container", "", "object", "Lr8/z;", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "getItemPosition", "(Ljava/lang/Object;)I", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends FragmentPagerAdapter {
        d(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            kotlin.jvm.internal.m.f(container, "container");
            kotlin.jvm.internal.m.f(object, "object");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List list = l1.this.fragmentList;
            kotlin.jvm.internal.m.c(list);
            return list.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            List list = l1.this.fragmentList;
            kotlin.jvm.internal.m.c(list);
            return (Fragment) list.get(position);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public long getItemId(int position) {
            List list = l1.this.fragmentList;
            kotlin.jvm.internal.m.c(list);
            if (list.size() > 0) {
                try {
                    Fragment item = getItem(position);
                    if (item != null && (item instanceof l5.b)) {
                        long jA0 = ((l5.b) item).a0();
                        if (jA0 > 0) {
                            return jA0;
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return super.getItemId(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object object) {
            kotlin.jvm.internal.m.f(object, "object");
            if (l1.this.fragmentList != null && l1.this.fragmentList.size() > 0) {
                try {
                    Iterator it = l1.this.fragmentList.iterator();
                    int i10 = 0;
                    while (it.hasNext()) {
                        if (kotlin.jvm.internal.m.a((Fragment) it.next(), object)) {
                            return i10;
                        }
                        i10++;
                    }
                } catch (Exception unused) {
                }
            }
            return super.getItemPosition(object);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            return "pos " + position;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"com/live/evo/fragment/l1$e", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "Lr8/z;", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements ViewPager.OnPageChangeListener {
        e() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            boolean z10 = com.live.evo.a.f5188h;
            if (position == z10) {
                List list = l1.this.fragmentList;
                kotlin.jvm.internal.m.c(list);
                Object obj = list.get(z10 ? 1 : 0);
                kotlin.jvm.internal.m.d(obj, "null cannot be cast to non-null type com.live.evo.fragment.FunctionMenuFragment");
                ((k0) obj).z0(l1.this.menu_first);
            }
            if (position < l1.this.M0("CHANNEL")) {
                l1.this.Q0();
            }
            if (position == 1 && l1.this.mChannelFragment != null) {
                x xVar = l1.this.mChannelFragment;
                kotlin.jvm.internal.m.c(xVar);
                xVar.q2();
            }
            if (position == l1.this.rechargePosition && position >= 0 && l1.this.mTabRechargeFragment != null) {
                l3 l3Var = l1.this.mTabRechargeFragment;
                kotlin.jvm.internal.m.c(l3Var);
                l3Var.m1();
            }
            l1.this.curPosition = position;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/live/evo/fragment/l1$f", "Lcom/live/evo/fragment/y1;", "Lr8/z;", "b", "()V", "c", "", "pos", "a", "(I)V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements y1 {
        f() {
        }

        @Override // com.live.evo.fragment.y1
        public void a(int pos) {
            if (l1.this.tabLayout != null) {
                l1.this.isTabFocus = true;
                MenuTabLayout menuTabLayout = l1.this.tabLayout;
                kotlin.jvm.internal.m.c(menuTabLayout);
                menuTabLayout.requestFocus();
                l1.this.t1(true);
                MenuTabLayout menuTabLayout2 = l1.this.tabLayout;
                kotlin.jvm.internal.m.c(menuTabLayout2);
                menuTabLayout2.setSelectTabView(l1.this.curPosition);
            }
        }

        @Override // com.live.evo.fragment.y1
        public void b() {
            l1.this.I0();
        }

        @Override // com.live.evo.fragment.y1
        public void c() {
            l1.this.N0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/live/evo/fragment/l1$g", "Ljava/util/TimerTask;", "Lr8/z;", "run", "()V", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g extends TimerTask {
        g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            l1.this.O0();
            try {
                if (l1.this.hideTask != null) {
                    TimerTask timerTask = l1.this.hideTask;
                    if (timerTask != null) {
                        timerTask.cancel();
                    }
                    l1.this.hideTask = null;
                }
                if (l1.this.mTimerMenu != null) {
                    Timer timer = l1.this.mTimerMenu;
                    if (timer != null) {
                        timer.cancel();
                    }
                    l1.this.mTimerMenu = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    private final void a1() {
        this.isTabFocus = false;
        ViewPager viewPager = this.viewPager;
        kotlin.jvm.internal.m.c(viewPager);
        viewPager.clearAnimation();
        ViewPager viewPager2 = this.viewPager;
        kotlin.jvm.internal.m.c(viewPager2);
        viewPager2.setAdapter(this.viewPagerAdapter);
        MenuTabLayout menuTabLayout = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout);
        menuTabLayout.setupWithViewPager(this.viewPager);
        int iG0 = G0(this.menu_first);
        ViewPager viewPager3 = this.viewPager;
        kotlin.jvm.internal.m.c(viewPager3);
        viewPager3.setCurrentItem(iG0);
        ViewPager viewPager4 = this.viewPager;
        kotlin.jvm.internal.m.c(viewPager4);
        viewPager4.setOffscreenPageLimit(0);
        R0();
    }

    private final synchronized void q1() {
        try {
            List<Fragment> list = this.fragmentList;
            int size = list != null ? list.size() : 0;
            V0();
            Y0();
            List<Fragment> list2 = this.fragmentList;
            int size2 = list2 != null ? list2.size() : 0;
            FragmentPagerAdapter fragmentPagerAdapter = this.viewPagerAdapter;
            if (fragmentPagerAdapter != null && size != size2) {
                kotlin.jvm.internal.m.c(fragmentPagerAdapter);
                fragmentPagerAdapter.notifyDataSetChanged();
                ViewPager viewPager = this.viewPager;
                kotlin.jvm.internal.m.c(viewPager);
                viewPager.setCurrentItem(G0(this.menu_first));
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void r1() {
        this.mTabBtnCheck = false;
        TextView textView = this.mTabMyAccount;
        if (textView != null) {
            kotlin.jvm.internal.m.c(textView);
            textView.setBackgroundResource(R$drawable.tabmenu_btn_selector);
        }
        TextView textView2 = this.mTabRenew;
        if (textView2 != null) {
            kotlin.jvm.internal.m.c(textView2);
            textView2.setBackgroundResource(R$drawable.tabmenu_btn_selector);
        }
        RelativeLayout relativeLayout = this.mTabNotification;
        if (relativeLayout != null) {
            kotlin.jvm.internal.m.c(relativeLayout);
            relativeLayout.setBackgroundResource(R$drawable.tabmenu_btn_selector);
        }
    }

    public final void H0() {
        this.isShow = false;
        try {
            List<Fragment> list = this.fragmentList;
            if (list != null) {
                list.clear();
            }
            List<String> list2 = this.mTabMenuList;
            if (list2 != null) {
                list2.clear();
            }
            k0 k0Var = this.mFunctionFragment;
            if (k0Var != null) {
                kotlin.jvm.internal.m.c(k0Var);
                k0Var.onDestroy();
                this.mFunctionFragment = null;
            }
            x xVar = this.mChannelFragment;
            if (xVar != null) {
                kotlin.jvm.internal.m.c(xVar);
                xVar.onDestroy();
                this.mChannelFragment = null;
            }
            r2 r2Var = this.mTabMyAccountFragment;
            if (r2Var != null) {
                kotlin.jvm.internal.m.c(r2Var);
                r2Var.onDestroy();
                this.mTabMyAccountFragment = null;
                this.myaccountPosition = 0;
            }
            l3 l3Var = this.mTabRechargeFragment;
            if (l3Var != null) {
                kotlin.jvm.internal.m.c(l3Var);
                l3Var.onDestroy();
                this.mTabRechargeFragment = null;
                this.rechargePosition = 0;
            }
            p2 p2Var = this.mTabNotificationFragment;
            if (p2Var != null) {
                kotlin.jvm.internal.m.c(p2Var);
                p2Var.onDestroy();
                this.mTabNotificationFragment = null;
                this.notificationPosition = 0;
            }
        } catch (Exception unused) {
        }
        x1.f1.lb.util.e0.f21385a.b(this);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.cancel();
        }
    }

    protected final void I0() {
        U(false);
        M0("CHANNEL");
        Q0();
        H0();
        this.isShow = false;
    }

    protected final void N0() {
        U(false);
        M0("CHANNEL");
        r1();
        MenuTabLayout menuTabLayout = this.tabLayout;
        if (menuTabLayout != null) {
            kotlin.jvm.internal.m.c(menuTabLayout);
            menuTabLayout.setTabIsSelected(true);
        }
        x xVar = this.mChannelFragment;
        if (xVar != null) {
            kotlin.jvm.internal.m.c(xVar);
            xVar.T2();
        }
        Dialog dialog = getDialog();
        if (dialog != null && dialog.isShowing()) {
            dialog.hide();
        }
        Q0();
        this.isShow = false;
        this.mCallEvent = null;
        TimerTask timerTask = this.hideTask;
        if (timerTask != null) {
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.hideTask = null;
        }
        Timer timer = this.mTimerMenu;
        if (timer != null) {
            if (timer != null) {
                timer.cancel();
            }
            this.mTimerMenu = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x022e  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:78:0x0174  */
    /* JADX WARN: Code duplicated, block: B:80:0x0178  */
    /* JADX WARN: Code duplicated, block: B:82:0x0181  */
    /* JADX WARN: Code duplicated, block: B:87:0x01a6  */
    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        TextView textView;
        int i10;
        List<Fragment> list;
        RelativeLayout relativeLayout;
        int i11;
        List<Fragment> list2;
        r2 r2Var;
        kotlin.jvm.internal.m.f(event, "event");
        if (event.getAction() != 0) {
            return false;
        }
        com.live.evo.osd.persenter.a aVar = this.mPresenter;
        if (aVar != null) {
            kotlin.jvm.internal.m.c(aVar);
            aVar.f();
        }
        f1();
        if (keyCode == 4) {
            if (KeyUtils.k() != null && KeyUtils.k().getVisibility() == 0) {
                KeyUtils.k().p();
                return true;
            }
            x xVar = this.mChannelFragment;
            if (xVar != null) {
                kotlin.jvm.internal.m.c(xVar);
                if (xVar.getKeyboardView() != null) {
                    x xVar2 = this.mChannelFragment;
                    kotlin.jvm.internal.m.c(xVar2);
                    ziyi.kit.keyboard.b keyboardView = xVar2.getKeyboardView();
                    kotlin.jvm.internal.m.c(keyboardView);
                    if (keyboardView.getVisibility() == 0) {
                        x xVar3 = this.mChannelFragment;
                        kotlin.jvm.internal.m.c(xVar3);
                        ziyi.kit.keyboard.b keyboardView2 = xVar3.getKeyboardView();
                        kotlin.jvm.internal.m.c(keyboardView2);
                        keyboardView2.p();
                        return true;
                    }
                }
            }
            l3 l3Var = this.mTabRechargeFragment;
            if (l3Var != null) {
                kotlin.jvm.internal.m.c(l3Var);
                if (l3Var.getKeyboardView() != null) {
                    l3 l3Var2 = this.mTabRechargeFragment;
                    kotlin.jvm.internal.m.c(l3Var2);
                    ziyi.kit.keyboard.b keyboardView3 = l3Var2.getKeyboardView();
                    kotlin.jvm.internal.m.c(keyboardView3);
                    if (keyboardView3.getVisibility() == 0) {
                        l3 l3Var3 = this.mTabRechargeFragment;
                        kotlin.jvm.internal.m.c(l3Var3);
                        ziyi.kit.keyboard.b keyboardView4 = l3Var3.getKeyboardView();
                        kotlin.jvm.internal.m.c(keyboardView4);
                        keyboardView4.p();
                        return true;
                    }
                }
            }
            N0();
            return true;
        }
        switch (keyCode) {
            case 20:
                TextView textView2 = this.mTabMyAccount;
                if (textView2 != null) {
                    kotlin.jvm.internal.m.c(textView2);
                    if (textView2.getVisibility() == 0) {
                        TextView textView3 = this.mTabMyAccount;
                        kotlin.jvm.internal.m.c(textView3);
                        if (textView3.isFocused()) {
                            r2 r2Var2 = this.mTabMyAccountFragment;
                            if (r2Var2 != null) {
                                this.mTabBtnCheck = true;
                                kotlin.jvm.internal.m.c(r2Var2);
                                r2Var2.a1();
                            }
                            return true;
                        }
                    }
                }
                TextView textView4 = this.mTabRenew;
                if (textView4 != null) {
                    kotlin.jvm.internal.m.c(textView4);
                    if (textView4.getVisibility() == 0) {
                        TextView textView5 = this.mTabRenew;
                        kotlin.jvm.internal.m.c(textView5);
                        if (textView5.isFocused()) {
                            l3 l3Var4 = this.mTabRechargeFragment;
                            if (l3Var4 != null) {
                                this.mTabBtnCheck = true;
                                kotlin.jvm.internal.m.c(l3Var4);
                                l3Var4.C1();
                            }
                            return true;
                        }
                    }
                }
                RelativeLayout relativeLayout2 = this.mTabNotification;
                if (relativeLayout2 == null) {
                    return false;
                }
                kotlin.jvm.internal.m.c(relativeLayout2);
                if (relativeLayout2.getVisibility() != 0) {
                    return false;
                }
                RelativeLayout relativeLayout3 = this.mTabNotification;
                kotlin.jvm.internal.m.c(relativeLayout3);
                if (!relativeLayout3.isFocused()) {
                    return false;
                }
                p2 p2Var = this.mTabNotificationFragment;
                if (p2Var != null) {
                    this.mTabBtnCheck = true;
                    kotlin.jvm.internal.m.c(p2Var);
                    p2Var.u0();
                }
                return true;
            case 21:
                RelativeLayout relativeLayout4 = this.mTabNotification;
                if (relativeLayout4 != null) {
                    kotlin.jvm.internal.m.c(relativeLayout4);
                    if (relativeLayout4.getVisibility() == 0) {
                        RelativeLayout relativeLayout5 = this.mTabNotification;
                        kotlin.jvm.internal.m.c(relativeLayout5);
                        if (relativeLayout5.isFocused()) {
                            TextView textView6 = this.mTabMyAccount;
                            if (textView6 != null) {
                                kotlin.jvm.internal.m.c(textView6);
                                if (textView6.getVisibility() == 0) {
                                    TextView textView7 = this.mTabMyAccount;
                                    kotlin.jvm.internal.m.c(textView7);
                                    textView7.requestFocus();
                                    int i12 = this.myaccountPosition;
                                    List<Fragment> list3 = this.fragmentList;
                                    kotlin.jvm.internal.m.c(list3);
                                    if (i12 <= list3.size() - 1 && this.myaccountPosition >= 0) {
                                        ViewPager viewPager = this.viewPager;
                                        kotlin.jvm.internal.m.c(viewPager);
                                        viewPager.setCurrentItem(this.myaccountPosition);
                                    }
                                } else {
                                    textView = this.mTabRenew;
                                    if (textView != null) {
                                        kotlin.jvm.internal.m.c(textView);
                                        if (textView.getVisibility() == 0) {
                                            TextView textView8 = this.mTabRenew;
                                            kotlin.jvm.internal.m.c(textView8);
                                            textView8.requestFocus();
                                            i10 = this.rechargePosition;
                                            list = this.fragmentList;
                                            kotlin.jvm.internal.m.c(list);
                                            if (i10 <= list.size() - 1 && this.rechargePosition >= 0) {
                                                ViewPager viewPager2 = this.viewPager;
                                                kotlin.jvm.internal.m.c(viewPager2);
                                                viewPager2.setCurrentItem(this.rechargePosition);
                                            }
                                        } else {
                                            MenuTabLayout menuTabLayout = this.tabLayout;
                                            kotlin.jvm.internal.m.c(menuTabLayout);
                                            menuTabLayout.requestFocus();
                                            MenuTabLayout menuTabLayout2 = this.tabLayout;
                                            kotlin.jvm.internal.m.c(menuTabLayout2);
                                            List<String> list4 = this.mTabMenuList;
                                            kotlin.jvm.internal.m.c(list4);
                                            menuTabLayout2.setSelectTabView(list4.size() - 1);
                                        }
                                    } else {
                                        MenuTabLayout menuTabLayout3 = this.tabLayout;
                                        kotlin.jvm.internal.m.c(menuTabLayout3);
                                        menuTabLayout3.requestFocus();
                                        MenuTabLayout menuTabLayout4 = this.tabLayout;
                                        kotlin.jvm.internal.m.c(menuTabLayout4);
                                        List<String> list5 = this.mTabMenuList;
                                        kotlin.jvm.internal.m.c(list5);
                                        menuTabLayout4.setSelectTabView(list5.size() - 1);
                                    }
                                }
                            } else {
                                textView = this.mTabRenew;
                                if (textView != null) {
                                    kotlin.jvm.internal.m.c(textView);
                                    if (textView.getVisibility() == 0) {
                                        TextView textView9 = this.mTabRenew;
                                        kotlin.jvm.internal.m.c(textView9);
                                        textView9.requestFocus();
                                        i10 = this.rechargePosition;
                                        list = this.fragmentList;
                                        kotlin.jvm.internal.m.c(list);
                                        if (i10 <= list.size() - 1) {
                                            ViewPager viewPager3 = this.viewPager;
                                            kotlin.jvm.internal.m.c(viewPager3);
                                            viewPager3.setCurrentItem(this.rechargePosition);
                                        }
                                    } else {
                                        MenuTabLayout menuTabLayout5 = this.tabLayout;
                                        kotlin.jvm.internal.m.c(menuTabLayout5);
                                        menuTabLayout5.requestFocus();
                                        MenuTabLayout menuTabLayout6 = this.tabLayout;
                                        kotlin.jvm.internal.m.c(menuTabLayout6);
                                        List<String> list6 = this.mTabMenuList;
                                        kotlin.jvm.internal.m.c(list6);
                                        menuTabLayout6.setSelectTabView(list6.size() - 1);
                                    }
                                } else {
                                    MenuTabLayout menuTabLayout7 = this.tabLayout;
                                    kotlin.jvm.internal.m.c(menuTabLayout7);
                                    menuTabLayout7.requestFocus();
                                    MenuTabLayout menuTabLayout8 = this.tabLayout;
                                    kotlin.jvm.internal.m.c(menuTabLayout8);
                                    List<String> list7 = this.mTabMenuList;
                                    kotlin.jvm.internal.m.c(list7);
                                    menuTabLayout8.setSelectTabView(list7.size() - 1);
                                }
                            }
                            return true;
                        }
                    }
                }
                if (!com.live.evo.k.b().o()) {
                    return false;
                }
                TextView textView10 = this.mTabMyAccount;
                if (textView10 != null) {
                    kotlin.jvm.internal.m.c(textView10);
                    if (textView10.getVisibility() == 0) {
                        TextView textView11 = this.mTabMyAccount;
                        kotlin.jvm.internal.m.c(textView11);
                        if (textView11.isFocused()) {
                            TextView textView12 = this.mTabRenew;
                            if (textView12 != null) {
                                kotlin.jvm.internal.m.c(textView12);
                                if (textView12.getVisibility() == 0) {
                                    TextView textView13 = this.mTabRenew;
                                    kotlin.jvm.internal.m.c(textView13);
                                    textView13.requestFocus();
                                    int i13 = this.rechargePosition;
                                    List<Fragment> list8 = this.fragmentList;
                                    kotlin.jvm.internal.m.c(list8);
                                    if (i13 <= list8.size() - 1 && this.rechargePosition >= 0) {
                                        ViewPager viewPager4 = this.viewPager;
                                        kotlin.jvm.internal.m.c(viewPager4);
                                        viewPager4.setCurrentItem(this.rechargePosition);
                                    }
                                    l3 l3Var5 = this.mTabRechargeFragment;
                                    if (l3Var5 != null && !l3Var5.isVisible()) {
                                        getChildFragmentManager().beginTransaction().show(l3Var5).commitAllowingStateLoss();
                                    }
                                } else {
                                    MenuTabLayout menuTabLayout9 = this.tabLayout;
                                    kotlin.jvm.internal.m.c(menuTabLayout9);
                                    menuTabLayout9.requestFocus();
                                    MenuTabLayout menuTabLayout10 = this.tabLayout;
                                    kotlin.jvm.internal.m.c(menuTabLayout10);
                                    List<String> list9 = this.mTabMenuList;
                                    kotlin.jvm.internal.m.c(list9);
                                    menuTabLayout10.setSelectTabView(list9.size() - 1);
                                }
                            } else {
                                MenuTabLayout menuTabLayout11 = this.tabLayout;
                                kotlin.jvm.internal.m.c(menuTabLayout11);
                                menuTabLayout11.requestFocus();
                                MenuTabLayout menuTabLayout12 = this.tabLayout;
                                kotlin.jvm.internal.m.c(menuTabLayout12);
                                List<String> list10 = this.mTabMenuList;
                                kotlin.jvm.internal.m.c(list10);
                                menuTabLayout12.setSelectTabView(list10.size() - 1);
                            }
                            return true;
                        }
                    }
                }
                TextView textView14 = this.mTabRenew;
                if (textView14 == null) {
                    return false;
                }
                kotlin.jvm.internal.m.c(textView14);
                if (textView14.getVisibility() != 0) {
                    return false;
                }
                TextView textView15 = this.mTabRenew;
                kotlin.jvm.internal.m.c(textView15);
                if (!textView15.isFocused()) {
                    return false;
                }
                MenuTabLayout menuTabLayout13 = this.tabLayout;
                kotlin.jvm.internal.m.c(menuTabLayout13);
                menuTabLayout13.requestFocus();
                MenuTabLayout menuTabLayout14 = this.tabLayout;
                kotlin.jvm.internal.m.c(menuTabLayout14);
                List<String> list11 = this.mTabMenuList;
                kotlin.jvm.internal.m.c(list11);
                menuTabLayout14.setSelectTabView(list11.size() - 1);
                return true;
            case 22:
                MenuTabLayout menuTabLayout15 = this.tabLayout;
                kotlin.jvm.internal.m.c(menuTabLayout15);
                int tabCount = menuTabLayout15.getTabCount();
                MenuTabLayout menuTabLayout16 = this.tabLayout;
                kotlin.jvm.internal.m.c(menuTabLayout16);
                if (tabCount == menuTabLayout16.getSelectedTabPosition() + 1 && (r2Var = this.mTabMyAccountFragment) != null && !r2Var.isVisible()) {
                    getChildFragmentManager().beginTransaction().show(r2Var).commitAllowingStateLoss();
                }
                if (!com.live.evo.k.b().o()) {
                    return false;
                }
                MenuTabLayout menuTabLayout17 = this.tabLayout;
                kotlin.jvm.internal.m.c(menuTabLayout17);
                if (menuTabLayout17.isFocused()) {
                    return false;
                }
                TextView textView16 = this.mTabRenew;
                if (textView16 != null) {
                    kotlin.jvm.internal.m.c(textView16);
                    if (textView16.getVisibility() == 0) {
                        TextView textView17 = this.mTabRenew;
                        kotlin.jvm.internal.m.c(textView17);
                        if (textView17.isFocused()) {
                            TextView textView18 = this.mTabMyAccount;
                            if (textView18 != null) {
                                kotlin.jvm.internal.m.c(textView18);
                                if (textView18.getVisibility() == 0) {
                                    TextView textView19 = this.mTabMyAccount;
                                    kotlin.jvm.internal.m.c(textView19);
                                    textView19.requestFocus();
                                    int i14 = this.myaccountPosition;
                                    List<Fragment> list12 = this.fragmentList;
                                    kotlin.jvm.internal.m.c(list12);
                                    if (i14 <= list12.size() - 1 && this.myaccountPosition >= 0) {
                                        ViewPager viewPager5 = this.viewPager;
                                        kotlin.jvm.internal.m.c(viewPager5);
                                        viewPager5.setCurrentItem(this.myaccountPosition);
                                    }
                                } else {
                                    relativeLayout = this.mTabNotification;
                                    if (relativeLayout != null) {
                                        kotlin.jvm.internal.m.c(relativeLayout);
                                        if (relativeLayout.getVisibility() == 0) {
                                            RelativeLayout relativeLayout6 = this.mTabNotification;
                                            kotlin.jvm.internal.m.c(relativeLayout6);
                                            relativeLayout6.requestFocus();
                                            i11 = this.notificationPosition;
                                            list2 = this.fragmentList;
                                            kotlin.jvm.internal.m.c(list2);
                                            if (i11 <= list2.size() - 1 && this.notificationPosition >= 0) {
                                                ViewPager viewPager6 = this.viewPager;
                                                kotlin.jvm.internal.m.c(viewPager6);
                                                viewPager6.setCurrentItem(this.notificationPosition);
                                            }
                                        }
                                    }
                                }
                            } else {
                                relativeLayout = this.mTabNotification;
                                if (relativeLayout != null) {
                                    kotlin.jvm.internal.m.c(relativeLayout);
                                    if (relativeLayout.getVisibility() == 0) {
                                        RelativeLayout relativeLayout7 = this.mTabNotification;
                                        kotlin.jvm.internal.m.c(relativeLayout7);
                                        relativeLayout7.requestFocus();
                                        i11 = this.notificationPosition;
                                        list2 = this.fragmentList;
                                        kotlin.jvm.internal.m.c(list2);
                                        if (i11 <= list2.size() - 1) {
                                            ViewPager viewPager7 = this.viewPager;
                                            kotlin.jvm.internal.m.c(viewPager7);
                                            viewPager7.setCurrentItem(this.notificationPosition);
                                        }
                                    }
                                }
                            }
                            return true;
                        }
                    }
                }
                TextView textView20 = this.mTabMyAccount;
                if (textView20 == null) {
                    return false;
                }
                kotlin.jvm.internal.m.c(textView20);
                if (textView20.getVisibility() != 0) {
                    return false;
                }
                TextView textView21 = this.mTabMyAccount;
                kotlin.jvm.internal.m.c(textView21);
                if (!textView21.isFocused()) {
                    return false;
                }
                RelativeLayout relativeLayout8 = this.mTabNotification;
                if (relativeLayout8 != null) {
                    kotlin.jvm.internal.m.c(relativeLayout8);
                    if (relativeLayout8.getVisibility() == 0) {
                        RelativeLayout relativeLayout9 = this.mTabNotification;
                        kotlin.jvm.internal.m.c(relativeLayout9);
                        relativeLayout9.requestFocus();
                        int i15 = this.notificationPosition;
                        List<Fragment> list13 = this.fragmentList;
                        kotlin.jvm.internal.m.c(list13);
                        if (i15 <= list13.size() - 1 && this.notificationPosition >= 0) {
                            ViewPager viewPager8 = this.viewPager;
                            kotlin.jvm.internal.m.c(viewPager8);
                            viewPager8.setCurrentItem(this.notificationPosition);
                        }
                    }
                }
                return true;
            default:
                return false;
        }
    }

    private final int G0(String menuFirst) {
        int iM0;
        if (ua.n.w(menuFirst, "Channel List", true)) {
            iM0 = M0("CHANNEL");
        } else if (ua.n.w(menuFirst, "recommend", true)) {
            iM0 = M0("RECOMMEND");
        } else if (ua.n.w(menuFirst, "subject", true)) {
            iM0 = L0();
        } else if (!kotlin.jvm.internal.m.a(menuFirst, "My Account") && !kotlin.jvm.internal.m.a(menuFirst, "Renew")) {
            iM0 = (kotlin.jvm.internal.m.a(menuFirst, "Message") && com.live.evo.k.b().p() && com.live.evo.k.b().i()) ? M0("FUNCTION") : M0("FUNCTION");
        } else if (!kotlin.jvm.internal.m.a(menuFirst, "My Account")) {
            long jH = com.live.evo.l.n().h("expire_show_ms", com.live.evo.a.f5196p);
            long jL = com.live.evo.l.n().l();
            long jA = com.live.evo.util.u1.b().a();
            if ((com.live.evo.l.n().q() == 0 && jL - jA > jH) || (iM0 = this.rechargePosition) < 0) {
                iM0 = M0("FUNCTION");
            }
        } else if (!com.live.evo.k.b().j() || (iM0 = this.myaccountPosition) < 0) {
            iM0 = M0("FUNCTION");
        }
        int i10 = iM0 >= 0 ? iM0 : 1;
        this.curPosition = i10;
        return i10;
    }

    private final void J0() {
        try {
            v0.b().a(com.live.evo.l.n().q());
            this.mBindEmailText = "";
            if (TextUtils.isEmpty(this.mBindEmailBackgroundUrl) || !kotlin.jvm.internal.m.a(this.mBindEmailBackgroundUrl, "")) {
                this.mBindEmailBackgroundUrl = "";
                if (TextUtils.isEmpty("")) {
                    this.mBindEmailBackgroundDrawable = null;
                }
                if (TextUtils.isEmpty(this.mBindEmailText)) {
                    this.mBindEmailText = getResources().getString(R$string.my_account);
                }
                kotlin.jvm.internal.m.c(com.bumptech.glide.c.t(requireContext()).f().g(l.j.f15048a).J0(this.mBindEmailBackgroundUrl).B0(new b()));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final int L0() {
        if (this.mTabMenuList == null) {
            return -1;
        }
        String str = "SUBJECT_" + this.mSubjectPosition;
        int size = this.mTabMenuList.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str2 = this.mTabMenuList.get(i10);
            if (!TextUtils.isEmpty(str2) && kotlin.jvm.internal.m.a(str2, str)) {
                return i10;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int M0(String menuTag) {
        List<String> list = this.mTabMenuList;
        int iIndexOf = (list == null || list.size() <= 0) ? -1 : this.mTabMenuList.indexOf(menuTag);
        if (iIndexOf >= 0 || !kotlin.jvm.internal.m.a("CHANNEL", menuTag)) {
            return iIndexOf;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0() {
        if (this.curPosition > M0("CHANNEL")) {
            return;
        }
        com.live.evo.util.k1.f7250a.c(new Runnable() { // from class: com.live.evo.fragment.i1
            @Override // java.lang.Runnable
            public final void run() {
                l1.P0(this.f5987a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0() {
        try {
            com.live.evo.osd.persenter.a aVar = this.mPresenter;
            if (aVar != null) {
                kotlin.jvm.internal.m.c(aVar);
                aVar.a(3, 1);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private final void R0() {
        MenuTabLayout menuTabLayout = this.tabLayout;
        if ((menuTabLayout != null ? menuTabLayout.getTabCount() : 0) <= this.curPosition) {
            return;
        }
        MenuTabLayout menuTabLayout2 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout2);
        ViewCompat.setBackground(menuTabLayout2.k(this.curPosition), AppCompatResources.getDrawable(requireContext(), R$drawable.menub_fragment_tab_bg_unfocus));
        MenuTabLayout menuTabLayout3 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout3);
        menuTabLayout3.k(this.curPosition).findViewById(R$id.tab_title).setEnabled(true);
        MenuTabLayout menuTabLayout4 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout4);
        menuTabLayout4.k(this.curPosition).findViewById(R$id.tab_title).setSelected(false);
        MenuTabLayout menuTabLayout5 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout5);
        menuTabLayout5.k(this.curPosition).findViewById(R$id.tab_bottom_line).setVisibility(0);
    }

    private final void S0() {
        MenuTabLayout menuTabLayout = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout);
        menuTabLayout.c(new c());
        this.viewPagerAdapter = new d(getChildFragmentManager());
        ViewPager viewPager = this.viewPager;
        kotlin.jvm.internal.m.c(viewPager);
        viewPager.addOnPageChangeListener(new e());
        MenuTabLayout menuTabLayout2 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout2);
        menuTabLayout2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.live.evo.fragment.x0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                l1.T0(this.f6920a, view, z10);
            }
        });
        MenuTabLayout menuTabLayout3 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout3);
        menuTabLayout3.setOnKeyListener(new View.OnKeyListener() { // from class: com.live.evo.fragment.c1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
                return l1.U0(this.f5896a, view, i10, keyEvent);
            }
        });
        TextView textView = this.mTabRenew;
        kotlin.jvm.internal.m.c(textView);
        textView.setOnFocusChangeListener(this.mTabFunctionBtnFocusChangeListener);
        TextView textView2 = this.mTabMyAccount;
        kotlin.jvm.internal.m.c(textView2);
        textView2.setOnFocusChangeListener(this.mTabFunctionBtnFocusChangeListener);
        RelativeLayout relativeLayout = this.mTabNotification;
        kotlin.jvm.internal.m.c(relativeLayout);
        relativeLayout.setOnFocusChangeListener(this.mTabFunctionBtnFocusChangeListener);
        t1(false);
        Dialog dialog = getDialog();
        kotlin.jvm.internal.m.c(dialog);
        dialog.setOnKeyListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(l1 l1Var, View view, boolean z10) {
        if (z10) {
            l1Var.t1(z10);
        }
    }

    private final void V0() {
        MenuTabLayout menuTabLayout = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout);
        menuTabLayout.setTabCheckShowText(com.live.evo.l.n().j("show_tablayout_text", true));
        List<Fragment> list = this.fragmentList;
        kotlin.jvm.internal.m.c(list);
        list.clear();
        List<String> list2 = this.mTabMenuList;
        kotlin.jvm.internal.m.c(list2);
        list2.clear();
        MenuTabLayout menuTabLayout2 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout2);
        menuTabLayout2.g();
        if (com.live.evo.a.f5188h) {
            String strI = com.live.evo.l.n().i("menu_home", com.live.evo.util.x1.j(R$string.menu_home));
            this.fragmentList.add(new com.live.evo.fragment.d());
            List<String> list3 = this.mTabMenuList;
            list3.add(list3.size(), "HOME");
            MenuTabLayout menuTabLayout3 = this.tabLayout;
            kotlin.jvm.internal.m.c(menuTabLayout3);
            MenuTabLayout menuTabLayout4 = this.tabLayout;
            kotlin.jvm.internal.m.c(menuTabLayout4);
            MenuTabLayout.c cVarL = menuTabLayout4.l();
            kotlin.jvm.internal.m.c(strI);
            menuTabLayout3.d(cVarL.a(K0(strI, R$drawable.menub_fragment_tab_home)));
        }
        String strI2 = com.live.evo.l.n().i("menu_function", com.live.evo.util.x1.j(R$string.menu_functions));
        if (this.mFunctionFragment == null) {
            k0.Companion companion = k0.INSTANCE;
            com.live.evo.osd.persenter.a aVar = this.mPresenter;
            y1 y1Var = this.mOnEventListener;
            Dialog dialog = getDialog();
            kotlin.jvm.internal.m.c(dialog);
            this.mFunctionFragment = companion.a(aVar, y1Var, dialog.getWindow(), this.menu_first);
        }
        List<Fragment> list4 = this.fragmentList;
        k0 k0Var = this.mFunctionFragment;
        kotlin.jvm.internal.m.c(k0Var);
        list4.add(k0Var);
        List<String> list5 = this.mTabMenuList;
        list5.add(list5.size(), "FUNCTION");
        MenuTabLayout menuTabLayout5 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout5);
        MenuTabLayout menuTabLayout6 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout6);
        MenuTabLayout.c cVarL2 = menuTabLayout6.l();
        kotlin.jvm.internal.m.c(strI2);
        menuTabLayout5.d(cVarL2.a(K0(strI2, R$drawable.menub_fragment_tab_function)));
        String strI3 = com.live.evo.l.n().i("menu_channel", com.live.evo.util.x1.j(R$string.menu_channels));
        if (this.mChannelFragment == null) {
            x.Companion companion2 = x.INSTANCE;
            com.live.evo.osd.persenter.a aVar2 = this.mPresenter;
            y1 y1Var2 = this.mOnEventListener;
            Dialog dialog2 = getDialog();
            kotlin.jvm.internal.m.c(dialog2);
            this.mChannelFragment = companion2.d(aVar2, y1Var2, dialog2.getWindow());
        }
        List<Fragment> list6 = this.fragmentList;
        x xVar = this.mChannelFragment;
        kotlin.jvm.internal.m.c(xVar);
        list6.add(xVar);
        List<String> list7 = this.mTabMenuList;
        list7.add(list7.size(), "CHANNEL");
        MenuTabLayout menuTabLayout7 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout7);
        MenuTabLayout menuTabLayout8 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout8);
        MenuTabLayout.c cVarL3 = menuTabLayout8.l();
        kotlin.jvm.internal.m.c(strI3);
        menuTabLayout7.d(cVarL3.a(K0(strI3, R$drawable.menub_fragment_tab_channel)));
        F0();
        if (this.mPhoneScanFragment == null) {
            this.mPhoneScanFragment = s2.INSTANCE.a();
        }
        List<Fragment> list8 = this.fragmentList;
        s2 s2Var = this.mPhoneScanFragment;
        kotlin.jvm.internal.m.c(s2Var);
        list8.add(s2Var);
        List<String> list9 = this.mTabMenuList;
        list9.add(list9.size(), "PHONESCAN");
        MenuTabLayout menuTabLayout9 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout9);
        MenuTabLayout menuTabLayout10 = this.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout10);
        menuTabLayout9.d(menuTabLayout10.l().a(K0("PHONE SCAN", R$drawable.menub_fragment_tab_phone)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(l1 l1Var, View view, boolean z10) {
        if (view != null) {
            if (view.getId() == 2131429544) {
                l1Var.k1(l1Var.mTabMyAccount, z10);
                return;
            }
            if (z10) {
                l1Var.mTabBtnCheck = false;
                view.setBackgroundResource(R$drawable.tabmenu_btn_selector);
            } else if (l1Var.mTabBtnCheck) {
                view.setBackgroundResource(R$drawable.tab_function_btnselected);
            } else {
                view.setBackgroundResource(R$drawable.tabmenu_btn_selector);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(l1 l1Var) {
        TextView textView = l1Var.mTabMyAccount;
        kotlin.jvm.internal.m.c(textView);
        textView.requestFocus();
        if (l1Var.myaccountPosition >= 0) {
            ViewPager viewPager = l1Var.viewPager;
            kotlin.jvm.internal.m.c(viewPager);
            viewPager.setCurrentItem(l1Var.myaccountPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(l1 l1Var) {
        TextView textView = l1Var.mTabRenew;
        kotlin.jvm.internal.m.c(textView);
        textView.requestFocus();
        if (l1Var.rechargePosition >= 0) {
            ViewPager viewPager = l1Var.viewPager;
            kotlin.jvm.internal.m.c(viewPager);
            viewPager.setCurrentItem(l1Var.rechargePosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(l1 l1Var) {
        RelativeLayout relativeLayout = l1Var.mTabNotification;
        kotlin.jvm.internal.m.c(relativeLayout);
        relativeLayout.requestFocus();
        if (l1Var.notificationPosition >= 0) {
            ViewPager viewPager = l1Var.viewPager;
            kotlin.jvm.internal.m.c(viewPager);
            viewPager.setCurrentItem(l1Var.notificationPosition);
        }
    }

    private final void f1() {
        TimerTask timerTask = this.hideTask;
        if (timerTask != null) {
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.hideTask = null;
        }
        this.hideTask = new g();
        if (this.mTimerMenu == null) {
            this.mTimerMenu = new Timer();
        }
        Timer timer = this.mTimerMenu;
        if (timer != null) {
            timer.schedule(this.hideTask, FileWatchdog.DEFAULT_DELAY);
        }
    }

    private final void g1() {
        try {
            if (ua.n.w(this.menu_first, "subject", true)) {
                List<Fragment> list = this.fragmentList;
                Fragment fragment = list != null ? list.get(this.curPosition) : null;
                if (fragment instanceof com.live.evo.fragment.subjuect.c0) {
                    ((com.live.evo.fragment.subjuect.c0) fragment).n0(this.mCallEvent);
                    return;
                }
                return;
            }
            if (!kotlin.jvm.internal.m.a(this.menu_first, "My Account") && !kotlin.jvm.internal.m.a(this.menu_first, "Renew")) {
                if (ua.n.w(this.menu_first, "Channel List", true)) {
                    x xVar = this.mChannelFragment;
                    kotlin.jvm.internal.m.c(xVar);
                    xVar.C2();
                    return;
                }
                boolean z10 = com.live.evo.a.f5188h;
                List<Fragment> list2 = this.fragmentList;
                kotlin.jvm.internal.m.c(list2);
                if (list2.get(z10 ? 1 : 0) instanceof k0) {
                    Fragment fragment2 = this.fragmentList.get(z10 ? 1 : 0);
                    kotlin.jvm.internal.m.d(fragment2, "null cannot be cast to non-null type com.live.evo.fragment.FunctionMenuFragment");
                    ((k0) fragment2).y0(this.menu_first);
                    return;
                }
                return;
            }
            if (kotlin.jvm.internal.m.a(this.menu_first, "My Account")) {
                if (!com.live.evo.k.b().j() || this.myaccountPosition < 0) {
                    return;
                }
                List<Fragment> list3 = this.fragmentList;
                kotlin.jvm.internal.m.c(list3);
                if (list3.get(this.myaccountPosition) instanceof r2) {
                    MenuTabLayout menuTabLayout = this.tabLayout;
                    kotlin.jvm.internal.m.c(menuTabLayout);
                    menuTabLayout.setSelected(false);
                    t1(true);
                    TextView textView = this.mTabMyAccount;
                    kotlin.jvm.internal.m.c(textView);
                    textView.postDelayed(new Runnable() { // from class: com.live.evo.fragment.a1
                        @Override // java.lang.Runnable
                        public final void run() {
                            l1.i1(this.f5862a);
                        }
                    }, 50L);
                    return;
                }
                return;
            }
            long jH = com.live.evo.l.n().h("expire_show_ms", com.live.evo.a.f5196p);
            long jL = com.live.evo.l.n().l();
            long jA = com.live.evo.util.u1.b().a();
            if ((com.live.evo.l.n().q() != 0 || jL - jA <= jH) && this.rechargePosition >= 0) {
                List<Fragment> list4 = this.fragmentList;
                kotlin.jvm.internal.m.c(list4);
                if (list4.get(this.rechargePosition) instanceof l3) {
                    MenuTabLayout menuTabLayout2 = this.tabLayout;
                    kotlin.jvm.internal.m.c(menuTabLayout2);
                    menuTabLayout2.setSelected(false);
                    t1(true);
                    TextView textView2 = this.mTabRenew;
                    kotlin.jvm.internal.m.c(textView2);
                    textView2.requestFocus();
                    TextView textView3 = this.mTabRenew;
                    kotlin.jvm.internal.m.c(textView3);
                    textView3.postDelayed(new Runnable() { // from class: com.live.evo.fragment.b1
                        @Override // java.lang.Runnable
                        public final void run() {
                            l1.h1(this.f5875a);
                        }
                    }, 50L);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(l1 l1Var) {
        MenuTabLayout menuTabLayout = l1Var.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout);
        menuTabLayout.setSelected(false);
        TextView textView = l1Var.mTabRenew;
        kotlin.jvm.internal.m.c(textView);
        textView.requestFocus();
        ViewPager viewPager = l1Var.viewPager;
        kotlin.jvm.internal.m.c(viewPager);
        viewPager.setCurrentItem(l1Var.rechargePosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(l1 l1Var) {
        MenuTabLayout menuTabLayout = l1Var.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout);
        menuTabLayout.setSelected(false);
        TextView textView = l1Var.mTabMyAccount;
        kotlin.jvm.internal.m.c(textView);
        textView.requestFocus();
        ViewPager viewPager = l1Var.viewPager;
        kotlin.jvm.internal.m.c(viewPager);
        viewPager.setCurrentItem(l1Var.myaccountPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1() {
        TextView textView = this.mTabMyAccount;
        kotlin.jvm.internal.m.c(textView);
        k1(textView, textView.hasFocus());
    }

    private final void l1(String menuFirst) {
        boolean z10;
        MenuTabLayout menuTabLayout;
        TextView textView;
        f1();
        try {
            if (a5.c.a().b() && ua.n.w(menuFirst, "recommend", true)) {
                this.curPosition = M0("RECOMMEND");
                ViewPager viewPager = this.viewPager;
                kotlin.jvm.internal.m.c(viewPager);
                viewPager.setCurrentItem(this.curPosition);
            } else if (!ua.n.w(menuFirst, "My Account", true) && !ua.n.w(menuFirst, "Renew", true)) {
                final int iG0 = G0(menuFirst);
                ViewPager viewPager2 = this.viewPager;
                kotlin.jvm.internal.m.c(viewPager2);
                viewPager2.setCurrentItem(iG0);
                ViewPager viewPager3 = this.viewPager;
                kotlin.jvm.internal.m.c(viewPager3);
                viewPager3.post(new Runnable() { // from class: com.live.evo.fragment.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        l1.p1(this.f6944a, iG0);
                    }
                });
            } else if (!com.live.evo.k.b().o()) {
                final int iG1 = G0(menuFirst);
                ViewPager viewPager4 = this.viewPager;
                kotlin.jvm.internal.m.c(viewPager4);
                viewPager4.setCurrentItem(iG1);
                ViewPager viewPager5 = this.viewPager;
                kotlin.jvm.internal.m.c(viewPager5);
                viewPager5.post(new Runnable() { // from class: com.live.evo.fragment.y0
                    @Override // java.lang.Runnable
                    public final void run() {
                        l1.o1(this.f6926a, iG1);
                    }
                });
            } else {
                if (ua.n.w(menuFirst, "My Account", true)) {
                    if (com.live.evo.k.b().j() && (textView = this.mTabMyAccount) != null) {
                        kotlin.jvm.internal.m.c(textView);
                        if (textView.getVisibility() == 0) {
                            t1(true);
                            try {
                                MenuTabLayout menuTabLayout2 = this.tabLayout;
                                kotlin.jvm.internal.m.c(menuTabLayout2);
                                menuTabLayout2.setTabIsSelected(false);
                                TextView textView2 = this.mTabMyAccount;
                                kotlin.jvm.internal.m.c(textView2);
                                textView2.requestFocus();
                                int i10 = this.myaccountPosition;
                                List<Fragment> list = this.fragmentList;
                                kotlin.jvm.internal.m.c(list);
                                if (i10 <= list.size() - 1 && this.myaccountPosition >= 0) {
                                    ViewPager viewPager6 = this.viewPager;
                                    kotlin.jvm.internal.m.c(viewPager6);
                                    viewPager6.setCurrentItem(this.myaccountPosition);
                                }
                                TextView textView3 = this.mTabMyAccount;
                                kotlin.jvm.internal.m.c(textView3);
                                textView3.post(new Runnable() { // from class: com.live.evo.fragment.j1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        l1.m1(this.f5992a);
                                    }
                                });
                            } catch (Exception unused) {
                            }
                            z10 = false;
                        }
                    }
                    menuTabLayout = this.tabLayout;
                    if (menuTabLayout != null && z10 && menuTabLayout != null) {
                        menuTabLayout.setTabIsSelected(true);
                    }
                    g1();
                    a5.c.a().c(false);
                    q1();
                    j1();
                    this.isShow = true;
                }
                long jH = com.live.evo.l.n().h("expire_show_ms", com.live.evo.a.f5196p);
                long jL = com.live.evo.l.n().l();
                long jA = com.live.evo.util.u1.b().a();
                if ((com.live.evo.l.n().q() != 0 || jL - jA <= jH) && this.rechargePosition >= 0) {
                    List<Fragment> list2 = this.fragmentList;
                    kotlin.jvm.internal.m.c(list2);
                    if (list2.get(this.rechargePosition) instanceof l3) {
                        MenuTabLayout menuTabLayout3 = this.tabLayout;
                        kotlin.jvm.internal.m.c(menuTabLayout3);
                        menuTabLayout3.setSelected(false);
                        t1(true);
                        TextView textView4 = this.mTabRenew;
                        kotlin.jvm.internal.m.c(textView4);
                        textView4.requestFocus();
                        if (this.rechargePosition <= this.fragmentList.size() - 1 && this.rechargePosition >= 0) {
                            ViewPager viewPager7 = this.viewPager;
                            kotlin.jvm.internal.m.c(viewPager7);
                            viewPager7.setCurrentItem(this.rechargePosition);
                        }
                        TextView textView5 = this.mTabRenew;
                        kotlin.jvm.internal.m.c(textView5);
                        textView5.post(new Runnable() { // from class: com.live.evo.fragment.k1
                            @Override // java.lang.Runnable
                            public final void run() {
                                l1.n1(this.f6019a);
                            }
                        });
                    }
                }
            }
        } catch (Exception unused2) {
        }
        z10 = true;
        menuTabLayout = this.tabLayout;
        if (menuTabLayout != null) {
            menuTabLayout.setTabIsSelected(true);
        }
        g1();
        a5.c.a().c(false);
        q1();
        j1();
        this.isShow = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(l1 l1Var) {
        MenuTabLayout menuTabLayout = l1Var.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout);
        menuTabLayout.setSelected(false);
        TextView textView = l1Var.mTabMyAccount;
        kotlin.jvm.internal.m.c(textView);
        textView.requestFocus();
        if (l1Var.myaccountPosition > l1Var.fragmentList.size() - 1 || l1Var.myaccountPosition < 0) {
            return;
        }
        ViewPager viewPager = l1Var.viewPager;
        kotlin.jvm.internal.m.c(viewPager);
        viewPager.setCurrentItem(l1Var.myaccountPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(l1 l1Var) {
        MenuTabLayout menuTabLayout = l1Var.tabLayout;
        kotlin.jvm.internal.m.c(menuTabLayout);
        menuTabLayout.setSelected(false);
        TextView textView = l1Var.mTabRenew;
        kotlin.jvm.internal.m.c(textView);
        textView.requestFocus();
        if (l1Var.rechargePosition > l1Var.fragmentList.size() - 1 || l1Var.rechargePosition < 0) {
            return;
        }
        ViewPager viewPager = l1Var.viewPager;
        kotlin.jvm.internal.m.c(viewPager);
        viewPager.setCurrentItem(l1Var.rechargePosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(l1 l1Var, int i10) {
        ViewPager viewPager = l1Var.viewPager;
        kotlin.jvm.internal.m.c(viewPager);
        viewPager.setCurrentItem(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(l1 l1Var, int i10) {
        ViewPager viewPager = l1Var.viewPager;
        kotlin.jvm.internal.m.c(viewPager);
        viewPager.setCurrentItem(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(boolean isFocus) {
        View view = this.mTabFunctionView;
        if (view != null) {
            kotlin.jvm.internal.m.c(view);
            if (view.getVisibility() == 0) {
                TextView textView = this.mTabMyAccount;
                if (textView != null) {
                    kotlin.jvm.internal.m.c(textView);
                    textView.setFocusable(isFocus);
                }
                TextView textView2 = this.mTabRenew;
                if (textView2 != null) {
                    kotlin.jvm.internal.m.c(textView2);
                    textView2.setFocusable(isFocus);
                }
                RelativeLayout relativeLayout = this.mTabNotification;
                if (relativeLayout != null) {
                    kotlin.jvm.internal.m.c(relativeLayout);
                    relativeLayout.setFocusable(isFocus);
                }
            }
        }
    }

    private final void v1() {
        if (this.mTabNotificationFlag == null) {
            return;
        }
        int iL = com.live.evo.util.s0.f7342a.L();
        TextView textView = this.mTabNotificationFlag;
        if (textView != null) {
            textView.setText(String.valueOf(iL));
        }
        if (iL > 0) {
            TextView textView2 = this.mTabNotificationFlag;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setVisibility(0);
        } else {
            TextView textView3 = this.mTabNotificationFlag;
            kotlin.jvm.internal.m.c(textView3);
            textView3.setVisibility(8);
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void F(b5.h savePlayHistoryEvent) {
        x xVar = this.mChannelFragment;
        if (xVar != null) {
            kotlin.jvm.internal.m.c(xVar);
            xVar.F(savePlayHistoryEvent);
            x xVar2 = this.mChannelFragment;
            kotlin.jvm.internal.m.c(xVar2);
            xVar2.I2();
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void L(List<? extends i5.p> epgBeen, String channelId) {
        if (epgBeen == null) {
            return;
        }
        try {
            x xVar = this.mChannelFragment;
            if (xVar != null) {
                kotlin.jvm.internal.m.c(xVar);
                kotlin.jvm.internal.m.c(channelId);
                xVar.L(epgBeen, channelId);
            }
        } catch (Exception e10) {
            this.logger.error(e10.getMessage(), e10);
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void M(String id2) {
        try {
            x xVar = this.mChannelFragment;
            if (xVar != null) {
                kotlin.jvm.internal.m.c(xVar);
                xVar.M(id2);
            }
        } catch (Exception e10) {
            this.logger.error(e10.getMessage(), e10);
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void N(FragmentManager fragmentManager, String menuTag) {
        kotlin.jvm.internal.m.f(menuTag, "menuTag");
        this.mCallEvent = null;
        if (menuTag.length() > 0) {
            this.menu_first = menuTag;
        }
        u1(fragmentManager, "program_menu");
    }

    @Override // com.live.evo.osd.persenter.b
    /* JADX INFO: renamed from: isShowing, reason: from getter */
    public boolean getIsShow() {
        return this.isShow;
    }

    @Override // com.live.evo.osd.persenter.b
    public void m() {
        x xVar = this.mChannelFragment;
        if (xVar != null) {
            kotlin.jvm.internal.m.c(xVar);
            xVar.m();
        }
    }

    @Override // com.live.evo.osd.persenter.b
    /* JADX INFO: renamed from: o */
    public int getMProgramSelect() {
        x xVar = this.mChannelFragment;
        if (xVar == null) {
            return 0;
        }
        kotlin.jvm.internal.m.c(xVar);
        return xVar.getMProgramSelect();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(inflater, "inflater");
        Z0(inflater);
        return this.mRoot;
    }

    @Override // com.live.evo.osd.persenter.b
    public void p(int allPosition) {
        x xVar = this.mChannelFragment;
        if (xVar != null) {
            kotlin.jvm.internal.m.c(xVar);
            xVar.p(allPosition);
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void q(Throwable throwable, String currentChannelId) {
        try {
            x xVar = this.mChannelFragment;
            if (xVar != null) {
                kotlin.jvm.internal.m.c(xVar);
                xVar.q(throwable, currentChannelId);
            }
        } catch (Exception e10) {
            this.logger.error(e10.getMessage(), e10);
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void r(int inListSelectPos) {
        x xVar = this.mChannelFragment;
        if (xVar != null) {
            kotlin.jvm.internal.m.c(xVar);
            xVar.r(inListSelectPos);
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void s() {
        x xVar = this.mChannelFragment;
        if (xVar != null) {
            kotlin.jvm.internal.m.c(xVar);
            xVar.s();
        }
    }

    @Override // k5.b
    /* JADX INFO: renamed from: s1, reason: merged with bridge method [inline-methods] */
    public void K(com.live.evo.osd.persenter.a presenter) {
        this.mPresenter = presenter;
        x xVar = this.mChannelFragment;
        if (xVar != null) {
            kotlin.jvm.internal.m.c(xVar);
            xVar.f3(this.mPresenter);
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void t() {
        x xVar = this.mChannelFragment;
        if (xVar != null) {
            xVar.t();
        }
    }

    @Override // com.live.evo.osd.persenter.b
    public void u(int classifyPosition) {
        x xVar = this.mChannelFragment;
        if (xVar != null) {
            kotlin.jvm.internal.m.c(xVar);
            xVar.u(classifyPosition);
        }
    }

    public final void u1(FragmentManager fm, String menuTag) {
        kotlin.jvm.internal.m.f(menuTag, "menuTag");
        l1 l1VarA = INSTANCE.a();
        U(true);
        View view = this.mTabFunctionView;
        if (view != null && view.getVisibility() == 0) {
            t1(false);
        }
        try {
            if (this.mRoot == null) {
                if (fm == null) {
                    this.logger.error("showProgramMenuDialog current view is null but no fragment manager found", new Object[0]);
                    return;
                }
                Fragment fragmentFindFragmentByTag = fm.findFragmentByTag(menuTag);
                if (fragmentFindFragmentByTag != null) {
                    FragmentTransaction fragmentTransactionBeginTransaction = fm.beginTransaction();
                    kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                    fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag).commitAllowingStateLoss();
                } else if (this.mIsRequestShow || isAdded()) {
                    this.logger.error(menuTag + " is added bug findViewById is null", new Object[0]);
                } else {
                    this.mIsRequestShow = true;
                    show(fm, menuTag);
                }
                this.isShow = true;
                this.isTabFocus = false;
            } else {
                if (this.isShow) {
                    return;
                }
                Dialog dialog = getDialog();
                if (dialog != null) {
                    dialog.show();
                }
                if (fm != null) {
                    FragmentTransaction fragmentTransactionBeginTransaction2 = fm.beginTransaction();
                    kotlin.jvm.internal.m.e(fragmentTransactionBeginTransaction2, "beginTransaction(...)");
                    fragmentTransactionBeginTransaction2.show(l1VarA);
                    fragmentTransactionBeginTransaction2.commitAllowingStateLoss();
                }
                l1(this.menu_first);
            }
            this.isShow = true;
        } catch (Throwable th) {
            this.logger.error("show menu dialog error", th);
        }
    }

    private final void F0() {
        List<j5.g> listF;
        if (com.live.evo.fragment.subjuect.b.c().j() && (listF = com.live.evo.fragment.subjuect.b.c().f()) != null) {
            int size = listF.size();
            for (int i10 = 0; i10 < size; i10++) {
                j5.g gVar = listF.get(i10);
                if (gVar != null) {
                    String strB = gVar.b();
                    com.live.evo.fragment.subjuect.c0 c0Var = this.subjectTabFragmentMap.get(strB);
                    if (c0Var == null) {
                        c0Var = new com.live.evo.fragment.subjuect.c0(this.mPresenter, this.mOnEventListener, this.mCallEvent);
                        this.subjectTabFragmentMap.put(strB, c0Var);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(com.live.evo.fragment.subjuect.c0.INSTANCE.a(), i10);
                    c0Var.setArguments(bundle);
                    List<Fragment> list = this.fragmentList;
                    kotlin.jvm.internal.m.c(list);
                    list.add(c0Var);
                    if (TextUtils.isEmpty(strB)) {
                        strB = "";
                    }
                    List<String> list2 = this.mTabMenuList;
                    kotlin.jvm.internal.m.c(list2);
                    list2.add(this.mTabMenuList.size(), "SUBJECT_" + i10);
                    if (!w1()) {
                        MenuTabLayout menuTabLayout = this.tabLayout;
                        kotlin.jvm.internal.m.c(menuTabLayout);
                        MenuTabLayout menuTabLayout2 = this.tabLayout;
                        kotlin.jvm.internal.m.c(menuTabLayout2);
                        menuTabLayout.d(menuTabLayout2.l().a(K0(strB, -1)));
                    } else {
                        MenuTabLayout menuTabLayout3 = this.tabLayout;
                        kotlin.jvm.internal.m.c(menuTabLayout3);
                        MenuTabLayout menuTabLayout4 = this.tabLayout;
                        kotlin.jvm.internal.m.c(menuTabLayout4);
                        menuTabLayout3.d(menuTabLayout4.l().a(K0(strB, R$drawable.menub_fragment_tab_subject)));
                    }
                }
            }
        }
    }

    private final View K0(String title, int backResource) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.menu_fragment_tabitem_b, (ViewGroup) null);
        kotlin.jvm.internal.m.e(viewInflate, "inflate(...)");
        View viewFindViewById = viewInflate.findViewById(R$id.tab_title);
        if (backResource <= 0) {
            viewFindViewById.setVisibility(8);
            return viewInflate;
        }
        viewFindViewById.setBackgroundResource(backResource);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(l1 l1Var) {
        l1Var.N0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x007b  */
    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0088  */
    /* JADX WARN: Code duplicated, block: B:34:0x0093  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:45:0x00da  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:49:0x0106  */
    /* JADX WARN: Code duplicated, block: B:56:0x011e  */
    /* JADX WARN: Code duplicated, block: B:58:0x012b  */
    /* JADX WARN: Code duplicated, block: B:65:0x013f  */
    public static final boolean U0(l1 l1Var, View view, int i10, KeyEvent keyEvent) {
        x xVar;
        int i11;
        List<String> list;
        com.live.evo.osd.persenter.a aVar;
        TextView textView;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        int i12;
        List<Fragment> list2;
        TextView textView2;
        int i13;
        List<Fragment> list3;
        if (keyEvent.getAction() == 0) {
            if (i10 != 20) {
                if (i10 != 66) {
                    if (i10 != 22) {
                        if (i10 == 23) {
                            i11 = l1Var.curPosition;
                            list = l1Var.mTabMenuList;
                            kotlin.jvm.internal.m.c(list);
                            if (i11 < list.size()) {
                                MenuTabLayout menuTabLayout = l1Var.tabLayout;
                                kotlin.jvm.internal.m.c(menuTabLayout);
                                menuTabLayout.setTabIsSelected(true);
                            }
                            if (l1Var.curPosition == 0) {
                                aVar = l1Var.mPresenter;
                                if (aVar != null) {
                                    kotlin.jvm.internal.m.c(aVar);
                                    aVar.d();
                                }
                                return true;
                            }
                        }
                    } else {
                        int i14 = l1Var.curPosition;
                        List<String> list4 = l1Var.mTabMenuList;
                        kotlin.jvm.internal.m.c(list4);
                        if (i14 >= list4.size() - 1) {
                            if (com.live.evo.k.b().o()) {
                                TextView textView3 = l1Var.mTabRenew;
                                if (textView3 != null) {
                                    kotlin.jvm.internal.m.c(textView3);
                                    if (textView3.getVisibility() == 0) {
                                        TextView textView4 = l1Var.mTabRenew;
                                        kotlin.jvm.internal.m.c(textView4);
                                        if (!textView4.isFocused()) {
                                            MenuTabLayout menuTabLayout2 = l1Var.tabLayout;
                                            kotlin.jvm.internal.m.c(menuTabLayout2);
                                            menuTabLayout2.setTabIsSelected(false);
                                            l1Var.t1(true);
                                            TextView textView5 = l1Var.mTabRenew;
                                            kotlin.jvm.internal.m.c(textView5);
                                            textView5.requestFocus();
                                            int i15 = l1Var.rechargePosition;
                                            List<Fragment> list5 = l1Var.fragmentList;
                                            kotlin.jvm.internal.m.c(list5);
                                            if (i15 <= list5.size() - 1 && l1Var.rechargePosition >= 0) {
                                                ViewPager viewPager = l1Var.viewPager;
                                                kotlin.jvm.internal.m.c(viewPager);
                                                viewPager.setCurrentItem(l1Var.rechargePosition);
                                            }
                                        } else {
                                            textView = l1Var.mTabMyAccount;
                                            if (textView != null) {
                                                kotlin.jvm.internal.m.c(textView);
                                                if (textView.getVisibility() == 0) {
                                                    textView2 = l1Var.mTabMyAccount;
                                                    kotlin.jvm.internal.m.c(textView2);
                                                    if (!textView2.isFocused()) {
                                                        MenuTabLayout menuTabLayout3 = l1Var.tabLayout;
                                                        kotlin.jvm.internal.m.c(menuTabLayout3);
                                                        menuTabLayout3.setTabIsSelected(false);
                                                        l1Var.t1(true);
                                                        TextView textView6 = l1Var.mTabMyAccount;
                                                        kotlin.jvm.internal.m.c(textView6);
                                                        textView6.requestFocus();
                                                        i13 = l1Var.myaccountPosition;
                                                        list3 = l1Var.fragmentList;
                                                        kotlin.jvm.internal.m.c(list3);
                                                        if (i13 <= list3.size() - 1 && l1Var.myaccountPosition >= 0) {
                                                            ViewPager viewPager2 = l1Var.viewPager;
                                                            kotlin.jvm.internal.m.c(viewPager2);
                                                            viewPager2.setCurrentItem(l1Var.myaccountPosition);
                                                        }
                                                    } else if (com.live.evo.k.b().p() && (relativeLayout = l1Var.mTabNotification) != null) {
                                                        kotlin.jvm.internal.m.c(relativeLayout);
                                                        if (relativeLayout.getVisibility() == 0) {
                                                            relativeLayout2 = l1Var.mTabNotification;
                                                            kotlin.jvm.internal.m.c(relativeLayout2);
                                                            if (!relativeLayout2.isFocused()) {
                                                                MenuTabLayout menuTabLayout4 = l1Var.tabLayout;
                                                                kotlin.jvm.internal.m.c(menuTabLayout4);
                                                                menuTabLayout4.setTabIsSelected(false);
                                                                l1Var.t1(true);
                                                                RelativeLayout relativeLayout3 = l1Var.mTabNotification;
                                                                kotlin.jvm.internal.m.c(relativeLayout3);
                                                                relativeLayout3.requestFocus();
                                                                i12 = l1Var.notificationPosition;
                                                                list2 = l1Var.fragmentList;
                                                                kotlin.jvm.internal.m.c(list2);
                                                                if (i12 <= list2.size() - 1 && l1Var.notificationPosition >= 0) {
                                                                    ViewPager viewPager3 = l1Var.viewPager;
                                                                    kotlin.jvm.internal.m.c(viewPager3);
                                                                    viewPager3.setCurrentItem(l1Var.notificationPosition);
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else if (com.live.evo.k.b().p()) {
                                                    kotlin.jvm.internal.m.c(relativeLayout);
                                                    if (relativeLayout.getVisibility() == 0) {
                                                        relativeLayout2 = l1Var.mTabNotification;
                                                        kotlin.jvm.internal.m.c(relativeLayout2);
                                                        if (!relativeLayout2.isFocused()) {
                                                            MenuTabLayout menuTabLayout5 = l1Var.tabLayout;
                                                            kotlin.jvm.internal.m.c(menuTabLayout5);
                                                            menuTabLayout5.setTabIsSelected(false);
                                                            l1Var.t1(true);
                                                            RelativeLayout relativeLayout4 = l1Var.mTabNotification;
                                                            kotlin.jvm.internal.m.c(relativeLayout4);
                                                            relativeLayout4.requestFocus();
                                                            i12 = l1Var.notificationPosition;
                                                            list2 = l1Var.fragmentList;
                                                            kotlin.jvm.internal.m.c(list2);
                                                            if (i12 <= list2.size() - 1) {
                                                                ViewPager viewPager4 = l1Var.viewPager;
                                                                kotlin.jvm.internal.m.c(viewPager4);
                                                                viewPager4.setCurrentItem(l1Var.notificationPosition);
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (com.live.evo.k.b().p()) {
                                                kotlin.jvm.internal.m.c(relativeLayout);
                                                if (relativeLayout.getVisibility() == 0) {
                                                    relativeLayout2 = l1Var.mTabNotification;
                                                    kotlin.jvm.internal.m.c(relativeLayout2);
                                                    if (!relativeLayout2.isFocused()) {
                                                        MenuTabLayout menuTabLayout6 = l1Var.tabLayout;
                                                        kotlin.jvm.internal.m.c(menuTabLayout6);
                                                        menuTabLayout6.setTabIsSelected(false);
                                                        l1Var.t1(true);
                                                        RelativeLayout relativeLayout5 = l1Var.mTabNotification;
                                                        kotlin.jvm.internal.m.c(relativeLayout5);
                                                        relativeLayout5.requestFocus();
                                                        i12 = l1Var.notificationPosition;
                                                        list2 = l1Var.fragmentList;
                                                        kotlin.jvm.internal.m.c(list2);
                                                        if (i12 <= list2.size() - 1) {
                                                            ViewPager viewPager5 = l1Var.viewPager;
                                                            kotlin.jvm.internal.m.c(viewPager5);
                                                            viewPager5.setCurrentItem(l1Var.notificationPosition);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        textView = l1Var.mTabMyAccount;
                                        if (textView != null) {
                                            kotlin.jvm.internal.m.c(textView);
                                            if (textView.getVisibility() == 0) {
                                                textView2 = l1Var.mTabMyAccount;
                                                kotlin.jvm.internal.m.c(textView2);
                                                if (!textView2.isFocused()) {
                                                    MenuTabLayout menuTabLayout7 = l1Var.tabLayout;
                                                    kotlin.jvm.internal.m.c(menuTabLayout7);
                                                    menuTabLayout7.setTabIsSelected(false);
                                                    l1Var.t1(true);
                                                    TextView textView7 = l1Var.mTabMyAccount;
                                                    kotlin.jvm.internal.m.c(textView7);
                                                    textView7.requestFocus();
                                                    i13 = l1Var.myaccountPosition;
                                                    list3 = l1Var.fragmentList;
                                                    kotlin.jvm.internal.m.c(list3);
                                                    if (i13 <= list3.size() - 1) {
                                                        ViewPager viewPager6 = l1Var.viewPager;
                                                        kotlin.jvm.internal.m.c(viewPager6);
                                                        viewPager6.setCurrentItem(l1Var.myaccountPosition);
                                                    }
                                                } else if (com.live.evo.k.b().p()) {
                                                    kotlin.jvm.internal.m.c(relativeLayout);
                                                    if (relativeLayout.getVisibility() == 0) {
                                                        relativeLayout2 = l1Var.mTabNotification;
                                                        kotlin.jvm.internal.m.c(relativeLayout2);
                                                        if (!relativeLayout2.isFocused()) {
                                                            MenuTabLayout menuTabLayout8 = l1Var.tabLayout;
                                                            kotlin.jvm.internal.m.c(menuTabLayout8);
                                                            menuTabLayout8.setTabIsSelected(false);
                                                            l1Var.t1(true);
                                                            RelativeLayout relativeLayout6 = l1Var.mTabNotification;
                                                            kotlin.jvm.internal.m.c(relativeLayout6);
                                                            relativeLayout6.requestFocus();
                                                            i12 = l1Var.notificationPosition;
                                                            list2 = l1Var.fragmentList;
                                                            kotlin.jvm.internal.m.c(list2);
                                                            if (i12 <= list2.size() - 1) {
                                                                ViewPager viewPager7 = l1Var.viewPager;
                                                                kotlin.jvm.internal.m.c(viewPager7);
                                                                viewPager7.setCurrentItem(l1Var.notificationPosition);
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (com.live.evo.k.b().p()) {
                                                kotlin.jvm.internal.m.c(relativeLayout);
                                                if (relativeLayout.getVisibility() == 0) {
                                                    relativeLayout2 = l1Var.mTabNotification;
                                                    kotlin.jvm.internal.m.c(relativeLayout2);
                                                    if (!relativeLayout2.isFocused()) {
                                                        MenuTabLayout menuTabLayout9 = l1Var.tabLayout;
                                                        kotlin.jvm.internal.m.c(menuTabLayout9);
                                                        menuTabLayout9.setTabIsSelected(false);
                                                        l1Var.t1(true);
                                                        RelativeLayout relativeLayout7 = l1Var.mTabNotification;
                                                        kotlin.jvm.internal.m.c(relativeLayout7);
                                                        relativeLayout7.requestFocus();
                                                        i12 = l1Var.notificationPosition;
                                                        list2 = l1Var.fragmentList;
                                                        kotlin.jvm.internal.m.c(list2);
                                                        if (i12 <= list2.size() - 1) {
                                                            ViewPager viewPager8 = l1Var.viewPager;
                                                            kotlin.jvm.internal.m.c(viewPager8);
                                                            viewPager8.setCurrentItem(l1Var.notificationPosition);
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (com.live.evo.k.b().p()) {
                                            kotlin.jvm.internal.m.c(relativeLayout);
                                            if (relativeLayout.getVisibility() == 0) {
                                                relativeLayout2 = l1Var.mTabNotification;
                                                kotlin.jvm.internal.m.c(relativeLayout2);
                                                if (!relativeLayout2.isFocused()) {
                                                    MenuTabLayout menuTabLayout10 = l1Var.tabLayout;
                                                    kotlin.jvm.internal.m.c(menuTabLayout10);
                                                    menuTabLayout10.setTabIsSelected(false);
                                                    l1Var.t1(true);
                                                    RelativeLayout relativeLayout8 = l1Var.mTabNotification;
                                                    kotlin.jvm.internal.m.c(relativeLayout8);
                                                    relativeLayout8.requestFocus();
                                                    i12 = l1Var.notificationPosition;
                                                    list2 = l1Var.fragmentList;
                                                    kotlin.jvm.internal.m.c(list2);
                                                    if (i12 <= list2.size() - 1) {
                                                        ViewPager viewPager9 = l1Var.viewPager;
                                                        kotlin.jvm.internal.m.c(viewPager9);
                                                        viewPager9.setCurrentItem(l1Var.notificationPosition);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    textView = l1Var.mTabMyAccount;
                                    if (textView != null) {
                                        kotlin.jvm.internal.m.c(textView);
                                        if (textView.getVisibility() == 0) {
                                            textView2 = l1Var.mTabMyAccount;
                                            kotlin.jvm.internal.m.c(textView2);
                                            if (!textView2.isFocused()) {
                                                MenuTabLayout menuTabLayout11 = l1Var.tabLayout;
                                                kotlin.jvm.internal.m.c(menuTabLayout11);
                                                menuTabLayout11.setTabIsSelected(false);
                                                l1Var.t1(true);
                                                TextView textView8 = l1Var.mTabMyAccount;
                                                kotlin.jvm.internal.m.c(textView8);
                                                textView8.requestFocus();
                                                i13 = l1Var.myaccountPosition;
                                                list3 = l1Var.fragmentList;
                                                kotlin.jvm.internal.m.c(list3);
                                                if (i13 <= list3.size() - 1) {
                                                    ViewPager viewPager10 = l1Var.viewPager;
                                                    kotlin.jvm.internal.m.c(viewPager10);
                                                    viewPager10.setCurrentItem(l1Var.myaccountPosition);
                                                }
                                            } else if (com.live.evo.k.b().p()) {
                                                kotlin.jvm.internal.m.c(relativeLayout);
                                                if (relativeLayout.getVisibility() == 0) {
                                                    relativeLayout2 = l1Var.mTabNotification;
                                                    kotlin.jvm.internal.m.c(relativeLayout2);
                                                    if (!relativeLayout2.isFocused()) {
                                                        MenuTabLayout menuTabLayout12 = l1Var.tabLayout;
                                                        kotlin.jvm.internal.m.c(menuTabLayout12);
                                                        menuTabLayout12.setTabIsSelected(false);
                                                        l1Var.t1(true);
                                                        RelativeLayout relativeLayout9 = l1Var.mTabNotification;
                                                        kotlin.jvm.internal.m.c(relativeLayout9);
                                                        relativeLayout9.requestFocus();
                                                        i12 = l1Var.notificationPosition;
                                                        list2 = l1Var.fragmentList;
                                                        kotlin.jvm.internal.m.c(list2);
                                                        if (i12 <= list2.size() - 1) {
                                                            ViewPager viewPager11 = l1Var.viewPager;
                                                            kotlin.jvm.internal.m.c(viewPager11);
                                                            viewPager11.setCurrentItem(l1Var.notificationPosition);
                                                        }
                                                    }
                                                }
                                            }
                                        } else if (com.live.evo.k.b().p()) {
                                            kotlin.jvm.internal.m.c(relativeLayout);
                                            if (relativeLayout.getVisibility() == 0) {
                                                relativeLayout2 = l1Var.mTabNotification;
                                                kotlin.jvm.internal.m.c(relativeLayout2);
                                                if (!relativeLayout2.isFocused()) {
                                                    MenuTabLayout menuTabLayout13 = l1Var.tabLayout;
                                                    kotlin.jvm.internal.m.c(menuTabLayout13);
                                                    menuTabLayout13.setTabIsSelected(false);
                                                    l1Var.t1(true);
                                                    RelativeLayout relativeLayout10 = l1Var.mTabNotification;
                                                    kotlin.jvm.internal.m.c(relativeLayout10);
                                                    relativeLayout10.requestFocus();
                                                    i12 = l1Var.notificationPosition;
                                                    list2 = l1Var.fragmentList;
                                                    kotlin.jvm.internal.m.c(list2);
                                                    if (i12 <= list2.size() - 1) {
                                                        ViewPager viewPager12 = l1Var.viewPager;
                                                        kotlin.jvm.internal.m.c(viewPager12);
                                                        viewPager12.setCurrentItem(l1Var.notificationPosition);
                                                    }
                                                }
                                            }
                                        }
                                    } else if (com.live.evo.k.b().p()) {
                                        kotlin.jvm.internal.m.c(relativeLayout);
                                        if (relativeLayout.getVisibility() == 0) {
                                            relativeLayout2 = l1Var.mTabNotification;
                                            kotlin.jvm.internal.m.c(relativeLayout2);
                                            if (!relativeLayout2.isFocused()) {
                                                MenuTabLayout menuTabLayout14 = l1Var.tabLayout;
                                                kotlin.jvm.internal.m.c(menuTabLayout14);
                                                menuTabLayout14.setTabIsSelected(false);
                                                l1Var.t1(true);
                                                RelativeLayout relativeLayout11 = l1Var.mTabNotification;
                                                kotlin.jvm.internal.m.c(relativeLayout11);
                                                relativeLayout11.requestFocus();
                                                i12 = l1Var.notificationPosition;
                                                list2 = l1Var.fragmentList;
                                                kotlin.jvm.internal.m.c(list2);
                                                if (i12 <= list2.size() - 1) {
                                                    ViewPager viewPager13 = l1Var.viewPager;
                                                    kotlin.jvm.internal.m.c(viewPager13);
                                                    viewPager13.setCurrentItem(l1Var.notificationPosition);
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        } else {
                            MenuTabLayout menuTabLayout15 = l1Var.tabLayout;
                            if (menuTabLayout15 != null) {
                                menuTabLayout15.setTabIsSelected(true);
                            }
                        }
                    }
                } else {
                    i11 = l1Var.curPosition;
                    list = l1Var.mTabMenuList;
                    kotlin.jvm.internal.m.c(list);
                    if (i11 < list.size()) {
                        MenuTabLayout menuTabLayout16 = l1Var.tabLayout;
                        kotlin.jvm.internal.m.c(menuTabLayout16);
                        menuTabLayout16.setTabIsSelected(true);
                    }
                    if (l1Var.curPosition == 0 && com.live.evo.a.f5188h) {
                        aVar = l1Var.mPresenter;
                        if (aVar != null) {
                            kotlin.jvm.internal.m.c(aVar);
                            aVar.d();
                        }
                        return true;
                    }
                }
            } else {
                l1Var.isTabFocus = false;
                try {
                    if (l1Var.curPosition == l1Var.M0("CHANNEL") && (xVar = l1Var.mChannelFragment) != null) {
                        kotlin.jvm.internal.m.c(xVar);
                        xVar.B2();
                        l1Var.t1(false);
                        MenuTabLayout menuTabLayout17 = l1Var.tabLayout;
                        if (menuTabLayout17 != null) {
                            menuTabLayout17.setTabIsSelected(true);
                        }
                        return true;
                    }
                    if (l1Var.curPosition >= 0) {
                        List<Fragment> list6 = l1Var.fragmentList;
                        kotlin.jvm.internal.m.c(list6);
                        if (list6.size() > l1Var.curPosition) {
                            MenuTabLayout menuTabLayout18 = l1Var.tabLayout;
                            if (menuTabLayout18 != null) {
                                menuTabLayout18.setTabIsSelected(true);
                            }
                            if (l1Var.fragmentList.get(l1Var.curPosition) instanceof k0) {
                                Fragment fragment = l1Var.fragmentList.get(l1Var.curPosition);
                                kotlin.jvm.internal.m.d(fragment, "null cannot be cast to non-null type com.live.evo.fragment.FunctionMenuFragment");
                                ((k0) fragment).w0();
                                return true;
                            }
                            if (l1Var.fragmentList.get(l1Var.curPosition) instanceof com.live.evo.fragment.subjuect.c0) {
                                Fragment fragment2 = l1Var.fragmentList.get(l1Var.curPosition);
                                kotlin.jvm.internal.m.d(fragment2, "null cannot be cast to non-null type com.live.evo.fragment.subjuect.SubjectTabMenuFragment");
                                ((com.live.evo.fragment.subjuect.c0) fragment2).l0();
                                l1Var.t1(false);
                                return true;
                            }
                            int i16 = l1Var.curPosition;
                            if ((i16 == 0 && com.live.evo.a.f5188h) || (l1Var.fragmentList.get(i16) instanceof s2)) {
                                return true;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    private final void W0() {
        if (com.live.evo.k.b().p() && com.live.evo.k.b().i()) {
            View view = this.mTabFunctionView;
            kotlin.jvm.internal.m.c(view);
            view.setVisibility(0);
            MenuTabLayout menuTabLayout = this.tabLayout;
            kotlin.jvm.internal.m.c(menuTabLayout);
            menuTabLayout.setDispatchKeyMode(3);
            RelativeLayout relativeLayout = this.mTabNotification;
            if (relativeLayout != null) {
                kotlin.jvm.internal.m.c(relativeLayout);
                relativeLayout.setVisibility(0);
            }
            if (this.mTabNotificationFragment == null) {
                this.mTabNotificationFragment = p2.INSTANCE.a("Message", this.mTabNotification, this.mPresenter, new com.live.evo.osd.q() { // from class: com.live.evo.fragment.g1
                    @Override // com.live.evo.osd.q
                    public final void a(String str) {
                        l1.X0(this.f5947a, str);
                    }
                });
            }
            List<Fragment> list = this.fragmentList;
            kotlin.jvm.internal.m.c(list);
            p2 p2Var = this.mTabNotificationFragment;
            kotlin.jvm.internal.m.c(p2Var);
            list.add(p2Var);
            this.notificationPosition = this.fragmentList.size() - 1;
            v1();
            return;
        }
        this.notificationPosition = -1;
        RelativeLayout relativeLayout2 = this.mTabNotification;
        kotlin.jvm.internal.m.c(relativeLayout2);
        relativeLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(l1 l1Var, String str) {
        l1Var.v1();
    }

    private final void Y0() {
        int i10;
        if (!com.live.evo.k.b().o()) {
            this.rechargePosition = -1;
            this.myaccountPosition = -1;
            this.notificationPosition = -1;
            View view = this.mTabFunctionView;
            kotlin.jvm.internal.m.c(view);
            view.setVisibility(8);
            TextView textView = this.mTabRenew;
            if (textView != null) {
                kotlin.jvm.internal.m.c(textView);
                textView.setVisibility(8);
            }
            TextView textView2 = this.mTabMyAccount;
            if (textView2 != null) {
                kotlin.jvm.internal.m.c(textView2);
                textView2.setVisibility(8);
            }
            RelativeLayout relativeLayout = this.mTabNotification;
            if (relativeLayout != null) {
                kotlin.jvm.internal.m.c(relativeLayout);
                relativeLayout.setVisibility(8);
            }
            MenuTabLayout menuTabLayout = this.tabLayout;
            kotlin.jvm.internal.m.c(menuTabLayout);
            menuTabLayout.setDispatchKeyMode(1);
            return;
        }
        long jH = com.live.evo.l.n().h("expire_show_ms", com.live.evo.a.f5196p);
        long jL = com.live.evo.l.n().l();
        long jA = com.live.evo.util.u1.b().a();
        if (com.live.evo.l.n().q() == 0 && jL - jA > jH) {
            this.rechargePosition = -1;
            this.myaccountPosition = -1;
            View view2 = this.mTabFunctionView;
            kotlin.jvm.internal.m.c(view2);
            view2.setVisibility(8);
            MenuTabLayout menuTabLayout2 = this.tabLayout;
            kotlin.jvm.internal.m.c(menuTabLayout2);
            menuTabLayout2.setDispatchKeyMode(1);
        } else {
            View view3 = this.mTabFunctionView;
            kotlin.jvm.internal.m.c(view3);
            view3.setVisibility(0);
            MenuTabLayout menuTabLayout3 = this.tabLayout;
            kotlin.jvm.internal.m.c(menuTabLayout3);
            menuTabLayout3.setDispatchKeyMode(3);
            try {
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                if (aVar.i().length() > 0) {
                    if (aVar.Z().length() == 0) {
                        TextView textView3 = this.mTabRenew;
                        if (textView3 != null) {
                            textView3.setVisibility(8);
                        }
                        l3 l3Var = this.mTabRechargeFragment;
                        if (l3Var != null && l3Var.isVisible()) {
                            getChildFragmentManager().beginTransaction().hide(l3Var).commitAllowingStateLoss();
                        }
                        if (com.live.evo.a.f5188h) {
                            i10 = 2;
                        } else {
                            i10 = 1;
                        }
                        if (this.curPosition > i10) {
                            this.curPosition = 0;
                            this.menu_first = "Setting";
                        }
                    } else {
                        if (this.mTabRechargeFragment == null) {
                            l3.Companion companion = l3.INSTANCE;
                            y1 y1Var = this.mOnEventListener;
                            TextView textView4 = this.mTabRenew;
                            Dialog dialog = getDialog();
                            kotlin.jvm.internal.m.c(dialog);
                            this.mTabRechargeFragment = companion.c(y1Var, textView4, dialog.getWindow());
                        }
                        List<Fragment> list = this.fragmentList;
                        kotlin.jvm.internal.m.c(list);
                        l3 l3Var2 = this.mTabRechargeFragment;
                        kotlin.jvm.internal.m.c(l3Var2);
                        list.add(l3Var2);
                        this.rechargePosition = this.fragmentList.size() - 1;
                        TextView textView5 = this.mTabRenew;
                        if (textView5 != null) {
                            textView5.setVisibility(0);
                        }
                        l3 l3Var3 = this.mTabRechargeFragment;
                        if (l3Var3 != null && !l3Var3.isVisible()) {
                            getChildFragmentManager().beginTransaction().show(l3Var3).commitAllowingStateLoss();
                        }
                    }
                }
                if (com.live.evo.k.b().j() && !com.live.evo.a.f5188h) {
                    if (this.mTabMyAccountFragment == null) {
                        this.mTabMyAccountFragment = r2.Y0("My Account", this.mTabMyAccount, this.mPresenter, this.mOnEventListener);
                    }
                    r2 r2Var = this.mTabMyAccountFragment;
                    if (r2Var != null && r2Var.isVisible()) {
                        getChildFragmentManager().beginTransaction().hide(r2Var).commitAllowingStateLoss();
                    }
                    List<Fragment> list2 = this.fragmentList;
                    kotlin.jvm.internal.m.c(list2);
                    r2 r2Var2 = this.mTabMyAccountFragment;
                    kotlin.jvm.internal.m.c(r2Var2);
                    list2.add(r2Var2);
                    this.myaccountPosition = this.fragmentList.size() - 1;
                    TextView textView6 = this.mTabMyAccount;
                    if (textView6 != null) {
                        textView6.setVisibility(0);
                    }
                } else {
                    this.myaccountPosition = -1;
                    TextView textView7 = this.mTabMyAccount;
                    if (textView7 != null) {
                        textView7.setVisibility(8);
                    }
                }
            } catch (Exception unused) {
            }
        }
        W0();
    }

    private final void Z0(LayoutInflater inflater) {
        View viewInflate = inflater.inflate(R$layout.menu_fragment_parent, (ViewGroup) null);
        this.mRoot = viewInflate;
        kotlin.jvm.internal.m.c(viewInflate);
        this.tabLayout = (MenuTabLayout) viewInflate.findViewById(R$id.tab_layout);
        View view = this.mRoot;
        kotlin.jvm.internal.m.c(view);
        this.viewPager = (ViewPager) view.findViewById(R$id.view_pager);
        View view2 = this.mRoot;
        kotlin.jvm.internal.m.c(view2);
        this.mTabFunctionView = view2.findViewById(R$id.tab_function_view);
        View view3 = this.mRoot;
        kotlin.jvm.internal.m.c(view3);
        this.mTabRenew = (TextView) view3.findViewById(R$id.tab_function_renew);
        View view4 = this.mRoot;
        kotlin.jvm.internal.m.c(view4);
        this.mTabMyAccount = (TextView) view4.findViewById(R$id.tab_function_myaccount);
        View view5 = this.mRoot;
        kotlin.jvm.internal.m.c(view5);
        this.mTabMyAccountMarketingActivity = (TextView) view5.findViewById(R$id.tab_function_myaccount_marketing_activity);
        View view6 = this.mRoot;
        kotlin.jvm.internal.m.c(view6);
        this.mTabNotification = (RelativeLayout) view6.findViewById(R$id.tab_function_notification);
        View view7 = this.mRoot;
        kotlin.jvm.internal.m.c(view7);
        this.mTabNotificationFlag = (TextView) view7.findViewById(R$id.tv_function_notification_flag);
        if (com.live.evo.k.b().o()) {
            View view8 = this.mTabFunctionView;
            if (view8 != null) {
                view8.setVisibility(0);
            }
        } else {
            View view9 = this.mTabFunctionView;
            if (view9 != null) {
                view9.setVisibility(8);
            }
        }
        this.mIsRequestShow = false;
        this.mTabTextColorNormal = getResources().getColor(R$color.menu_fragment_tab_parent_text_color_unselected);
        this.mTabTextColorSelected = getResources().getColor(R$color.menu_fragment_tab_parent_text_color_selected);
        this.mBindEmailText = getString(R$string.my_account);
        j1();
        V0();
        Y0();
        S0();
        a1();
        f1();
    }

    private final void k1(TextView v10, boolean hasFocus) {
        boolean z10;
        if (v0.b().d() == null) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (hasFocus) {
            this.mTabBtnCheck = false;
            kotlin.jvm.internal.m.c(v10);
            v10.setBackgroundResource(R$drawable.tabmenu_btn_selector);
            TextView textView = this.mTabMyAccount;
            kotlin.jvm.internal.m.c(textView);
            textView.setSelected(false);
            v10.setText(R$string.my_account);
            v10.setTextColor(this.mTabTextColorSelected);
            return;
        }
        kotlin.jvm.internal.m.c(v10);
        v10.setTextColor(this.mTabTextColorNormal);
        if (z10) {
            TextView textView2 = this.mTabMyAccount;
            kotlin.jvm.internal.m.c(textView2);
            textView2.setSelected(true);
            J0();
            Drawable drawable = this.mBindEmailBackgroundDrawable;
            if (drawable != null) {
                v10.setBackground(drawable);
            } else if (this.mTabBtnCheck) {
                v10.setBackgroundResource(R$drawable.tab_function_btnselected);
            } else {
                v10.setBackgroundResource(R$drawable.tabmenu_btn_selector);
            }
            v10.setText(this.mBindEmailText);
            return;
        }
        TextView textView3 = this.mTabMyAccount;
        kotlin.jvm.internal.m.c(textView3);
        textView3.setSelected(false);
        if (this.mTabBtnCheck) {
            v10.setBackgroundResource(R$drawable.tab_function_btnselected);
        } else {
            v10.setBackgroundResource(R$drawable.tabmenu_btn_selector);
        }
        v10.setText(R$string.my_account);
    }

    private final boolean w1() {
        return com.live.evo.l.n().j("show_subject_icon", true);
    }

    @Override // com.live.evo.osd.persenter.b
    public void E() {
        H0();
    }

    @Override // com.live.evo.osd.persenter.b
    public void I() {
        try {
            N0();
        } catch (Exception unused) {
            this.isShow = false;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.a().c(this);
        setStyle(1, R$style.DialogFullScreen);
        x1.f1.lb.util.e0.f21385a.a(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mRoot = null;
    }

    @xe.m(threadMode = ThreadMode.MAIN)
    public final void onNotification(b5.g event) {
        v1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        f1();
        if (!this.isShow) {
            u1(null, "program_menu");
            return;
        }
        if (!this.isTabFocus) {
            try {
                if (this.curPosition == M0("CHANNEL")) {
                    x xVar = this.mChannelFragment;
                    kotlin.jvm.internal.m.c(xVar);
                    xVar.D2();
                    return;
                }
                int i10 = this.curPosition;
                List<Fragment> list = this.fragmentList;
                kotlin.jvm.internal.m.c(list);
                if (i10 < list.size()) {
                    Fragment fragment = this.fragmentList.get(this.curPosition);
                    if (fragment instanceof com.live.evo.fragment.subjuect.c0) {
                        ((com.live.evo.fragment.subjuect.c0) fragment).n0(this.mCallEvent);
                        return;
                    }
                    if (fragment instanceof k0) {
                        ((k0) fragment).x0();
                        return;
                    }
                    if (fragment instanceof r2) {
                        t1(true);
                        MenuTabLayout menuTabLayout = this.tabLayout;
                        kotlin.jvm.internal.m.c(menuTabLayout);
                        menuTabLayout.setSelected(false);
                        TextView textView = this.mTabMyAccount;
                        kotlin.jvm.internal.m.c(textView);
                        textView.requestFocus();
                        if (this.myaccountPosition >= 0) {
                            ViewPager viewPager = this.viewPager;
                            kotlin.jvm.internal.m.c(viewPager);
                            viewPager.setCurrentItem(this.myaccountPosition);
                        }
                        TextView textView2 = this.mTabMyAccount;
                        kotlin.jvm.internal.m.c(textView2);
                        textView2.postDelayed(new Runnable() { // from class: com.live.evo.fragment.d1
                            @Override // java.lang.Runnable
                            public final void run() {
                                l1.c1(this.f5922a);
                            }
                        }, 50L);
                        return;
                    }
                    if (fragment instanceof l3) {
                        t1(true);
                        TextView textView3 = this.mTabRenew;
                        kotlin.jvm.internal.m.c(textView3);
                        textView3.requestFocus();
                        if (this.rechargePosition >= 0) {
                            ViewPager viewPager2 = this.viewPager;
                            kotlin.jvm.internal.m.c(viewPager2);
                            viewPager2.setCurrentItem(this.rechargePosition);
                        }
                        TextView textView4 = this.mTabRenew;
                        kotlin.jvm.internal.m.c(textView4);
                        textView4.postDelayed(new Runnable() { // from class: com.live.evo.fragment.e1
                            @Override // java.lang.Runnable
                            public final void run() {
                                l1.d1(this.f5929a);
                            }
                        }, 50L);
                        return;
                    }
                    if (fragment instanceof p2) {
                        t1(true);
                        RelativeLayout relativeLayout = this.mTabNotification;
                        kotlin.jvm.internal.m.c(relativeLayout);
                        relativeLayout.requestFocus();
                        if (this.notificationPosition >= 0) {
                            ViewPager viewPager3 = this.viewPager;
                            kotlin.jvm.internal.m.c(viewPager3);
                            viewPager3.setCurrentItem(this.notificationPosition);
                        }
                        RelativeLayout relativeLayout2 = this.mTabNotification;
                        kotlin.jvm.internal.m.c(relativeLayout2);
                        relativeLayout2.postDelayed(new Runnable() { // from class: com.live.evo.fragment.f1
                            @Override // java.lang.Runnable
                            public final void run() {
                                l1.e1(this.f5936a);
                            }
                        }, 50L);
                    }
                }
            } catch (Throwable th) {
                this.logger.error("show dialog failure", th);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        TimerTask timerTask = this.hideTask;
        if (timerTask != null) {
            kotlin.jvm.internal.m.c(timerTask);
            timerTask.cancel();
            this.hideTask = null;
        }
    }
}
