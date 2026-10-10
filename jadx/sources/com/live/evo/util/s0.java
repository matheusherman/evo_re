package com.live.evo.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import com.live.evo.R$dimen;
import com.live.evo.R$string;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import x1.f1.lb.ad.AdItem;
import x1.f1.lb.media.model.SubscribeItem;
import z1.b1.lb.m.meta.ChannelStreamResponse;
import z1.b1.lb.m.meta.EPGProgramme;
import z1.b1.lb.m.sports.Channel;
import z1.b1.lb.m.sports.Match;
import z1.b1.lb.m.sports.Matches;
import z1.b1.lb.m.sports.Sport;
import z1.b1.lb.m.sports.Sports;
import z1.b1.lb.m.sports.Team;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0003J\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0018\u001a\u00020\r2\u0016\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010 \u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\r0\u0015¢\u0006\u0004\b \u0010!J4\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00042\u0006\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0011H\u0086@¢\u0006\u0004\b&\u0010'JH\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010(\u001a\u00020%2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110)2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+H\u0086@¢\u0006\u0004\b0\u00101J\u0015\u00105\u001a\u0002042\u0006\u00103\u001a\u000202¢\u0006\u0004\b5\u00106J\u001d\u00109\u001a\u00020\r2\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u0011¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\n¢\u0006\u0004\b;\u0010\u0010J!\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020<0\u0004¢\u0006\u0004\b>\u0010?J\u0015\u0010A\u001a\u00020=2\u0006\u0010@\u001a\u00020<¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u0004\u0018\u00010C¢\u0006\u0004\bD\u0010EJ\r\u0010F\u001a\u00020,¢\u0006\u0004\bF\u0010GJ\r\u0010H\u001a\u00020\u0011¢\u0006\u0004\bH\u0010\u001bJ\r\u0010I\u001a\u00020,¢\u0006\u0004\bI\u0010GJ\r\u0010J\u001a\u00020,¢\u0006\u0004\bJ\u0010GJ\u0013\u0010L\u001a\b\u0012\u0004\u0012\u00020K0\u0004¢\u0006\u0004\bL\u0010\u001dJ3\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010M\u001a\u0004\u0018\u00010\u00112\u0006\u0010N\u001a\u00020\u00112\f\u0010O\u001a\b\u0012\u0004\u0012\u00020-0\u0004¢\u0006\u0004\bP\u0010QJ\u0015\u0010S\u001a\u00020\u00052\u0006\u0010R\u001a\u00020-¢\u0006\u0004\bS\u0010TJ\u001d\u0010X\u001a\u00020W2\u0006\u0010U\u001a\u00020,2\u0006\u0010V\u001a\u00020\u0011¢\u0006\u0004\bX\u0010YJ\u0019\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020[0Z¢\u0006\u0004\b\\\u0010]J\u0019\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020W0Z¢\u0006\u0004\b^\u0010]J5\u0010`\u001a\u00020\r2\b\u0010N\u001a\u0004\u0018\u00010\u00112\u0006\u0010_\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020\r0\u0015¢\u0006\u0004\b`\u0010!J-\u0010a\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010\u00112\b\u0010M\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\ba\u0010bJ\u001f\u0010d\u001a\u00020\n2\u0006\u0010c\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\bd\u0010eJ]\u0010n\u001a\u00020\r2\u0006\u0010f\u001a\u00020\u00112\u0006\u0010g\u001a\u00020\u00112\u0006\u0010h\u001a\u00020,2\u0006\u0010i\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020\r0\u00152\n\b\u0002\u0010m\u001a\u0004\u0018\u00010l¢\u0006\u0004\bn\u0010oJ!\u0010p\u001a\u00020\r2\u0006\u0010i\u001a\u00020k2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010l¢\u0006\u0004\bp\u0010qJ\u0019\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020k0\u00040r¢\u0006\u0004\bs\u0010tJ#\u0010u\u001a\u0004\u0018\u00010k2\u0006\u0010c\u001a\u00020\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\bu\u0010vJ%\u0010y\u001a\u00020k2\u0006\u0010U\u001a\u00020,2\u0006\u0010c\u001a\u00020\u00052\u0006\u0010x\u001a\u00020w¢\u0006\u0004\by\u0010zJ=\u0010\u0081\u0001\u001a\u00020\r2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020[0\u00042\u0006\u0010}\u001a\u00020|2\u0006\u0010\u007f\u001a\u00020~2\r\u0010\u0017\u001a\t\u0012\u0004\u0012\u00020\r0\u0080\u0001¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J0\u0010\u0083\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040r2\b\u0010M\u001a\u0004\u0018\u00010\u00112\b\u0010N\u001a\u0004\u0018\u00010\u0011¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J.\u0010\u0085\u0001\u001a\u00020\r2\b\u0010N\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\r0\u0015¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J/\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020[0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020w0\u00042\t\b\u0002\u0010\u0087\u0001\u001a\u00020\n¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010,2\u0007\u0010\u008a\u0001\u001a\u00020w¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020[2\u0007\u0010\u008a\u0001\u001a\u00020w¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u001c\u0010\u008f\u0001\u001a\u0004\u0018\u00010[2\b\u0010M\u001a\u0004\u0018\u00010\u0011¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0015\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020[0\u0004¢\u0006\u0005\b\u0091\u0001\u0010\u001dJ+\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020[0\u00042\b\b\u0002\u0010V\u001a\u00020\u00112\t\b\u0002\u0010\u0087\u0001\u001a\u00020\n¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J:\u0010\u0096\u0001\u001a,\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020[0\u00040\u0094\u0001j\u0015\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020[0\u0004`\u0095\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001JP\u0010\u009c\u0001\u001a\u00020\r2\u0007\u0010\u0098\u0001\u001a\u00020\u00112\u0007\u0010\u0099\u0001\u001a\u00020,2,\u0010\u0017\u001a(\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0007\u0012\u0005\u0018\u00010\u009b\u0001\u0012\u0004\u0012\u00020\r0\u009a\u0001¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001JP\u0010 \u0001\u001a\u00020\r2\u0007\u0010\u009e\u0001\u001a\u00020\u00112\u0007\u0010\u009f\u0001\u001a\u00020\n2,\u0010\u0017\u001a(\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0007\u0012\u0005\u0018\u00010\u009b\u0001\u0012\u0004\u0012\u00020\r0\u009a\u0001¢\u0006\u0006\b \u0001\u0010¡\u0001R\"\u0010¦\u0001\u001a\r £\u0001*\u0005\u0018\u00010¢\u00010¢\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R%\u0010©\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\"\u0010ª\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110+8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0013\u0010¨\u0001R\u0018\u0010¬\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\by\u0010«\u0001¨\u0006\u00ad\u0001"}, d2 = {"Lcom/live/evo/util/s0;", "", "<init>", "()V", "", "Li5/p;", "list", "", "startTime", "stopTime", "", ExifInterface.LATITUDE_SOUTH, "(Ljava/util/List;JJ)Z", "Lr8/z;", "Q", "N", "()Z", "", "subjectTypeId", "d", "(Ljava/lang/String;)Z", "Lkotlin/Function1;", "Lj5/h;", "callback", "I", "(Lc9/l;)V", "z", "()Ljava/lang/String;", "G", "()Ljava/util/List;", "lastUpdateTime", "Lj5/f;", "H", "(Ljava/lang/String;JLc9/l;)V", "sportId", "tournamentId", "date", "Lz1/b1/lb/m/sports/Match;", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "match", "", "dateList", "", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "inRemindMap", "Lj5/c;", "m", "(Ljava/lang/String;Lz1/b1/lb/m/sports/Match;Ljava/util/List;Ljava/util/Map;Lv8/f;)Ljava/lang/Object;", "Lz1/b1/lb/m/sports/Team;", "team", "Lj5/d;", "n", "(Lz1/b1/lb/m/sports/Team;)Lj5/d;", "pos", NotificationCompat.CATEGORY_MESSAGE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(ILjava/lang/String;)V", "R", "Lx1/f1/lb/ad/a;", "Li5/b;", "g", "(Ljava/util/List;)Ljava/util/List;", "item", "f", "(Lx1/f1/lb/ad/a;)Li5/b;", "Li5/a;", "p", "()Li5/a;", "r", "()I", "q", "D", "L", "Li5/v;", "F", "channelId", "epgId", "programs", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "program", "l", "(Lz1/b1/lb/m/meta/EPGProgramme;)Li5/p;", "seq", "column", "Li5/i;", "o", "(ILjava/lang/String;)Li5/i;", "", "Li5/h;", "u", "()Ljava/util/Map;", "t", "time", "v", "M", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Z", "epgBean", "O", "(Li5/p;Ljava/lang/String;)Z", "channelName", "icon", "inAllPos", "bean", "subscribeType", "Li5/c0;", "Lx1/f1/lb/media/model/SubscribeItem;", "subscribeItem", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;Ljava/lang/String;ILi5/p;Ljava/lang/String;Ljava/lang/String;Lc9/l;Lx1/f1/lb/media/model/SubscribeItem;)V", "X", "(Li5/c0;Lx1/f1/lb/media/model/SubscribeItem;)V", "Lkotlinx/coroutines/flow/f;", "K", "()Lkotlinx/coroutines/flow/f;", "J", "(Li5/p;Ljava/lang/String;)Li5/c0;", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "e", "(ILi5/p;Lz1/b1/lb/m/meta/ChannelStreamResponse;)Li5/c0;", "channels", "Lcom/live/evo/util/y;", "imageCache", "Landroid/content/res/Resources;", "resources", "Lkotlin/Function0;", "y", "(Ljava/util/List;Lcom/live/evo/util/y;Landroid/content/res/Resources;Lc9/a;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "B", "(Ljava/lang/String;Lc9/l;)V", "isIncludeAdult", "i", "(Ljava/util/List;Z)Ljava/util/List;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "P", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)Ljava/lang/Integer;", "h", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;)Li5/h;", "s", "(Ljava/lang/String;)Li5/h;", "w", "x", "(Ljava/lang/String;Z)Ljava/util/List;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "C", "()Ljava/util/HashMap;", "ccPassword", "accountLoginType", "Lkotlin/Function4;", "", "U", "(Ljava/lang/String;ILc9/r;)V", "renewCode", "isCreateAccount", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;ZLc9/r;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Ljava/util/Map;", "sportMap", "versionMap", "Ljava/lang/String;", "lastVersion", "evo_EVO_Prod_Release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0 f7342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Map<String, String> sportMap;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, String> versionMap;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String lastVersion;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper", f = "ModelHelper.kt", l = {TypedValues.CycleType.TYPE_CURVE_FIT}, m = "convertMatch")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class a extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        long J$0;
        long J$1;
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

        a(v8.f<? super a> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return s0.this.m(null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getChannelProgramName$1", f = "ModelHelper.kt", l = {713}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ c9.l<EPGProgramme, r8.z> $callback;
        final /* synthetic */ String $epgId;
        final /* synthetic */ long $time;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getChannelProgramName$1$1", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ c9.l<EPGProgramme, r8.z> $callback;
            final /* synthetic */ EPGProgramme $program;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c9.l<? super EPGProgramme, r8.z> lVar, EPGProgramme ePGProgramme, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$callback = lVar;
                this.$program = ePGProgramme;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$callback, this.$program, fVar);
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
                    this.$callback.invoke(this.$program);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(String str, long j10, c9.l<? super EPGProgramme, r8.z> lVar, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$epgId = str;
            this.$time = j10;
            this.$callback = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$epgId, this.$time, this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                String str = this.$epgId;
                long j10 = this.$time;
                this.label = 1;
                obj = aVar.G(str, j10, this);
                if (obj == objC) {
                    return objC;
                }
            }
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.$callback, (EPGProgramme) obj, null), 3, null);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getChannelsBitmapFromUrl$1", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class c extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ c9.a<r8.z> $callback;
        final /* synthetic */ List<i5.h> $channels;
        final /* synthetic */ y $imageCache;
        final /* synthetic */ Resources $resources;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getChannelsBitmapFromUrl$1$2", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ c9.a<r8.z> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(c9.a<r8.z> aVar, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$callback = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$callback, fVar);
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
                    this.$callback.invoke();
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Resources resources, List<? extends i5.h> list, y yVar, c9.a<r8.z> aVar, v8.f<? super c> fVar) {
            super(2, fVar);
            this.$resources = resources;
            this.$channels = list;
            this.$imageCache = yVar;
            this.$callback = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new c(this.$resources, this.$channels, this.$imageCache, this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((c) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Bitmap bitmapF;
            int i10;
            boolean z10;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                int dimensionPixelSize = this.$resources.getDimensionPixelSize(R$dimen.catchup_channel_icon_width_d);
                int dimensionPixelSize2 = this.$resources.getDimensionPixelSize(R$dimen.catchup_channel_icon_height_d);
                Iterator<i5.h> it = this.$channels.iterator();
                while (it.hasNext()) {
                    String strG = it.next().g();
                    if (strG == null) {
                        strG = "";
                    }
                    try {
                        if (this.$imageCache.h(strG) == null) {
                            int length = strG.length() - 1;
                            int i11 = 0;
                            boolean z11 = false;
                            while (i11 <= length) {
                                if (!z11) {
                                    i10 = i11;
                                } else {
                                    i10 = length;
                                }
                                if (kotlin.jvm.internal.m.h(strG.charAt(i10), 32) <= 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (!z11) {
                                    if (!z10) {
                                        z11 = true;
                                    } else {
                                        i11++;
                                    }
                                } else {
                                    if (!z10) {
                                        break;
                                    }
                                    length--;
                                }
                            }
                            if (!kotlin.jvm.internal.m.a(strG.subSequence(i11, length + 1).toString(), "") && (bitmapF = y.f(new URL(strG), dimensionPixelSize, dimensionPixelSize2, this.$imageCache)) != null) {
                                this.$imageCache.b(strG, new BitmapDrawable(this.$resources, bitmapF));
                            }
                        }
                    } catch (IOException e10) {
                        s0.logger.error("get channel bitmap from url failure", e10);
                    }
                }
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.$callback, null), 3, null);
                return r8.z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements kotlinx.coroutines.flow.f<List<? extends i5.p>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f7347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7349c;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        public static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f7350a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f7351b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f7352c;

            /* JADX INFO: renamed from: com.live.evo.util.s0$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getEpg$$inlined$map$1$2", f = "ModelHelper.kt", l = {223}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class C0111a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0111a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(kotlinx.coroutines.flow.g gVar, String str, String str2) {
                this.f7350a = gVar;
                this.f7351b = str;
                this.f7352c = str2;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            public final Object emit(Object obj, v8.f fVar) {
                C0111a c0111a;
                if (fVar instanceof C0111a) {
                    c0111a = (C0111a) fVar;
                    int i10 = c0111a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0111a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0111a = new C0111a(fVar);
                    }
                } else {
                    c0111a = new C0111a(fVar);
                }
                Object obj2 = c0111a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0111a.label;
                if (i11 == 0) {
                    r8.r.b(obj2);
                    kotlinx.coroutines.flow.g gVar = this.f7350a;
                    List<i5.p> listK = s0.f7342a.k(this.f7351b, this.f7352c, (List) obj);
                    c0111a.label = 1;
                    if (gVar.emit(listK, c0111a) == objC) {
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

        public d(kotlinx.coroutines.flow.f fVar, String str, String str2) {
            this.f7347a = fVar;
            this.f7348b = str;
            this.f7349c = str2;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super List<? extends i5.p>> gVar, v8.f fVar) {
            Object objCollect = this.f7347a.collect(new a(gVar, this.f7348b, this.f7349c), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getEpgPastDays$1", f = "ModelHelper.kt", l = {893}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ c9.l<Integer, r8.z> $callback;
        final /* synthetic */ String $epgId;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getEpgPastDays$1$1", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ c9.l<Integer, r8.z> $callback;
            final /* synthetic */ kotlin.jvm.internal.z $pastDays;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c9.l<? super Integer, r8.z> lVar, kotlin.jvm.internal.z zVar, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$callback = lVar;
                this.$pastDays = zVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$callback, this.$pastDays, fVar);
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
                    this.$callback.invoke(kotlin.coroutines.jvm.internal.b.b(this.$pastDays.element));
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(String str, c9.l<? super Integer, r8.z> lVar, v8.f<? super e> fVar) {
            super(2, fVar);
            this.$epgId = str;
            this.$callback = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new e(this.$epgId, this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                String str = this.$epgId;
                this.label = 1;
                obj = aVar.B(str, this);
                if (obj == objC) {
                    return objC;
                }
            }
            kotlin.jvm.internal.z zVar = new kotlin.jvm.internal.z();
            String strG = x1.f1.lb.util.n.n().g(2);
            Iterator it = ((List) obj).iterator();
            while (it.hasNext() && !kotlin.jvm.internal.m.a((String) it.next(), strG)) {
                zVar.element++;
            }
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.$callback, zVar, null), 3, null);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper", f = "ModelHelper.kt", l = {292}, m = "getMatches")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class f extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        f(v8.f<? super f> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return s0.this.E(null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getSubjectListDatas$1", f = "ModelHelper.kt", l = {203}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ c9.l<j5.f, r8.z> $callback;
        final /* synthetic */ String $subjectTypeId;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getSubjectListDatas$1$1", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lqf/a;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super List<? extends qf.a>>, Throwable, v8.f<? super r8.z>, Object> {
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super List<qf.a>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                return new a(fVar).invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f7353a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ List<j5.e> f7354b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ List<String> f7355c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ c9.l<j5.f, r8.z> f7356d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ j5.f f7357e;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getSubjectListDatas$1$2$1$3", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ c9.l<j5.f, r8.z> $callback;
                final /* synthetic */ j5.f $response;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(c9.l<? super j5.f, r8.z> lVar, j5.f fVar, v8.f<? super a> fVar2) {
                    super(2, fVar2);
                    this.$callback = lVar;
                    this.$response = fVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.$callback, this.$response, fVar);
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
                        this.$callback.invoke(this.$response);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: renamed from: com.live.evo.util.s0$g$b$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getSubjectListDatas$1$2", f = "ModelHelper.kt", l = {204, 242, 262, 272}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class C0112b extends kotlin.coroutines.jvm.internal.d {
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
                final /* synthetic */ b<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0112b(b<? super T> bVar, v8.f<? super C0112b> fVar) {
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

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class c<T> implements Comparator {
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t10, T t11) {
                    return t8.a.a(Long.valueOf(((j5.c) t10).g()), Long.valueOf(((j5.c) t11).g()));
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            b(String str, List<j5.e> list, List<String> list2, c9.l<? super j5.f, r8.z> lVar, j5.f fVar) {
                this.f7353a = str;
                this.f7354b = list;
                this.f7355c = list2;
                this.f7356d = lVar;
                this.f7357e = fVar;
            }

            /* JADX WARN: Code duplicated, block: B:58:0x01db  */
            /* JADX WARN: Code duplicated, block: B:61:0x0212  */
            /* JADX WARN: Code duplicated, block: B:65:0x0227  */
            /* JADX WARN: Code duplicated, block: B:67:0x0243  */
            /* JADX WARN: Code duplicated, block: B:68:0x024e  */
            /* JADX WARN: Code duplicated, block: B:71:0x0257  */
            /* JADX WARN: Code duplicated, block: B:73:0x0264  */
            /* JADX WARN: Code duplicated, block: B:7:0x0017  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x02b3 -> B:56:0x01d5). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x02e1 -> B:78:0x02eb). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x035e -> B:93:0x0363). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final java.lang.Object emit(java.util.List<qf.a> r30, v8.f<? super r8.z> r31) {
                /*
                    Method dump skipped, instruction units count: 1062
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.live.evo.util.s0.g.b.emit(java.util.List, v8.f):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g(String str, c9.l<? super j5.f, r8.z> lVar, v8.f<? super g> fVar) {
            super(2, fVar);
            this.$subjectTypeId = str;
            this.$callback = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new g(this.$subjectTypeId, this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((g) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                j5.f fVar = new j5.f();
                j5.a aVar = new j5.a();
                fVar.l(aVar);
                aVar.b("");
                aVar.a(0);
                aVar.n(q1.b());
                ArrayList arrayList = new ArrayList();
                aVar.m(arrayList);
                aVar.c("");
                aVar.d("");
                aVar.g(0);
                aVar.f(0L);
                aVar.e(0L);
                aVar.h("");
                aVar.i(0L);
                aVar.j(0);
                ArrayList arrayList2 = new ArrayList();
                aVar.o(arrayList2);
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(t.v.c.i.a.f18646a.K(), new a(null));
                b bVar = new b(this.$subjectTypeId, arrayList2, arrayList, this.$callback, fVar);
                this.label = 1;
                if (fVarF.collect(bVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getSubjectTypeDatas$1", f = "ModelHelper.kt", l = {107}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class h extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ c9.l<j5.h, r8.z> $callback;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getSubjectTypeDatas$1$1", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ c9.l<j5.h, r8.z> $callback;
            final /* synthetic */ kotlin.jvm.internal.b0<j5.h> $ret;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c9.l<? super j5.h, r8.z> lVar, kotlin.jvm.internal.b0<j5.h> b0Var, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$callback = lVar;
                this.$ret = b0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$callback, this.$ret, fVar);
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
                    this.$callback.invoke(this.$ret.element);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        h(c9.l<? super j5.h, r8.z> lVar, v8.f<? super h> fVar) {
            super(2, fVar);
            this.$callback = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new h(this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((h) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [T, j5.h] */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            List<Sport> listC;
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
                x1.f1.lb.media.j jVar = x1.f1.lb.media.j.f20845a;
                this.label = 1;
                obj = jVar.G(this);
                if (obj == objC) {
                    return objC;
                }
            }
            Sports sports = (Sports) obj;
            if (sports != null) {
                listC = sports.c();
            } else {
                listC = null;
            }
            kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
            try {
                List<Sport> list = listC;
                if (list != null && !list.isEmpty()) {
                    ?? hVar = new j5.h();
                    ArrayList arrayList = new ArrayList();
                    hVar.l(arrayList);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Sport sport : listC) {
                        j5.g gVar = new j5.g();
                        Integer sportId = sport.getSportId();
                        if (sportId != null) {
                            String strValueOf = String.valueOf(sportId.intValue());
                            String name = sport.getName();
                            if (name == null) {
                                name = "";
                            }
                            gVar.c(strValueOf);
                            gVar.d(name);
                            arrayList.add(gVar);
                            linkedHashMap.put(strValueOf, name);
                        }
                    }
                    s0.sportMap = linkedHashMap;
                    b0Var.element = hVar;
                    kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.$callback, b0Var, null), 3, null);
                    return r8.z.f17874a;
                }
                s0.logger.error("get sports is empty", new Object[0]);
                return r8.z.f17874a;
            } catch (Throwable th) {
                s0.logger.error("get sports failure", th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements kotlinx.coroutines.flow.f<List<i5.c0>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f7358a;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        public static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f7359a;

            /* JADX INFO: renamed from: com.live.evo.util.s0$i$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$getSubscribeData$$inlined$map$1$2", f = "ModelHelper.kt", l = {223}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class C0113a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0113a(v8.f fVar) {
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
                this.f7359a = gVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            public final Object emit(Object obj, v8.f fVar) {
                C0113a c0113a;
                if (fVar instanceof C0113a) {
                    c0113a = (C0113a) fVar;
                    int i10 = c0113a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0113a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0113a = new C0113a(fVar);
                    }
                } else {
                    c0113a = new C0113a(fVar);
                }
                Object obj2 = c0113a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0113a.label;
                if (i11 == 0) {
                    r8.r.b(obj2);
                    kotlinx.coroutines.flow.g gVar = this.f7359a;
                    ArrayList arrayList = new ArrayList();
                    int i12 = 0;
                    for (qf.a aVar : (List) obj) {
                        s0 s0Var = s0.f7342a;
                        i5.p pVarL = s0Var.l(aVar.d());
                        ChannelStreamResponse channelStreamResponseJ = t.v.c.i.a.f18646a.j(aVar.c());
                        if (channelStreamResponseJ != null) {
                            arrayList.add(s0Var.e(i12, pVarL, channelStreamResponseJ));
                            i12++;
                        }
                    }
                    c0113a.label = 1;
                    if (gVar.emit(arrayList, c0113a) == objC) {
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

        public i(kotlinx.coroutines.flow.f fVar) {
            this.f7358a = fVar;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super List<i5.c0>> gVar, v8.f fVar) {
            Object objCollect = this.f7358a.collect(new a(gVar), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$loginByRenewCode$1", f = "ModelHelper.kt", l = {PointerIconCompat.TYPE_CROSSHAIR, PointerIconCompat.TYPE_VERTICAL_TEXT}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ c9.r<Boolean, Integer, String, Throwable, r8.z> $callback;
        final /* synthetic */ String $renewCode;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$loginByRenewCode$1$1", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ c9.r<Boolean, Integer, String, Throwable, r8.z> $callback;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c9.r<? super Boolean, ? super Integer, ? super String, ? super Throwable, r8.z> rVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.$callback = rVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.$callback, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(false), null, null, (Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c9.r<Boolean, Integer, String, Throwable, r8.z> f7360a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$loginByRenewCode$1$2$1", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ c9.r<Boolean, Integer, String, Throwable, r8.z> $callback;
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(c9.r<? super Boolean, ? super Integer, ? super String, ? super Throwable, r8.z> rVar, r8.u<Boolean, Integer, String> uVar, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$callback = rVar;
                    this.$it = uVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.$callback, this.$it, fVar);
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
                        this.$callback.invoke(this.$it.d(), this.$it.e(), this.$it.f(), null);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            b(c9.r<? super Boolean, ? super Integer, ? super String, ? super Throwable, r8.z> rVar) {
                this.f7360a = rVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.f7360a, uVar, null), 3, null);
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        j(String str, c9.r<? super Boolean, ? super Integer, ? super String, ? super Throwable, r8.z> rVar, v8.f<? super j> fVar) {
            super(2, fVar);
            this.$renewCode = str;
            this.$callback = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new j(this.$renewCode, this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((j) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
        
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
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            String str = this.$renewCode;
            this.label = 1;
            obj = aVar.w0(str, this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(this.$callback, null));
            b bVar = new b(this.$callback);
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$recharge$1", f = "ModelHelper.kt", l = {994, 996}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class k extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ c9.r<Boolean, Integer, String, Throwable, r8.z> $callback;
        final /* synthetic */ String $ccPassword;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$recharge$1$1", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/u;", "", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.q<kotlinx.coroutines.flow.g<? super r8.u<? extends Boolean, ? extends Integer, ? extends String>>, Throwable, v8.f<? super r8.z>, Object> {
            final /* synthetic */ c9.r<Boolean, Integer, String, Throwable, r8.z> $callback;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c9.r<? super Boolean, ? super Integer, ? super String, ? super Throwable, r8.z> rVar, v8.f<? super a> fVar) {
                super(3, fVar);
                this.$callback = rVar;
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super r8.u<Boolean, Integer, String>> gVar, Throwable th, v8.f<? super r8.z> fVar) {
                a aVar = new a(this.$callback, fVar);
                aVar.L$0 = th;
                return aVar.invokeSuspend(r8.z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(false), null, null, (Throwable) this.L$0);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c9.r<Boolean, Integer, String, Throwable, r8.z> f7361a;

            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$recharge$1$2$1", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
            static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
                final /* synthetic */ c9.r<Boolean, Integer, String, Throwable, r8.z> $callback;
                final /* synthetic */ r8.u<Boolean, Integer, String> $it;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                a(c9.r<? super Boolean, ? super Integer, ? super String, ? super Throwable, r8.z> rVar, r8.u<Boolean, Integer, String> uVar, v8.f<? super a> fVar) {
                    super(2, fVar);
                    this.$callback = rVar;
                    this.$it = uVar;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                    return new a(this.$callback, this.$it, fVar);
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
                        this.$callback.invoke(this.$it.d(), this.$it.e(), this.$it.f(), null);
                        return r8.z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            b(c9.r<? super Boolean, ? super Integer, ? super String, ? super Throwable, r8.z> rVar) {
                this.f7361a = rVar;
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(r8.u<Boolean, Integer, String> uVar, v8.f<? super r8.z> fVar) {
                kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.f7361a, uVar, null), 3, null);
                return r8.z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        k(String str, c9.r<? super Boolean, ? super Integer, ? super String, ? super Throwable, r8.z> rVar, v8.f<? super k> fVar) {
            super(2, fVar);
            this.$ccPassword = str;
            this.$callback = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new k(this.$ccPassword, this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((k) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
        
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
            t.v.c.i.a aVar = t.v.c.i.a.f18646a;
            String str = this.$ccPassword;
            this.label = 1;
            obj = aVar.B0(str, this);
            if (obj != objC) {
            }
            return objC;
            kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f((kotlinx.coroutines.flow.f) obj, new a(this.$callback, null));
            b bVar = new b(this.$callback);
            this.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$updateSubscribe$1", f = "ModelHelper.kt", l = {767}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class l extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ i5.p $bean;
        final /* synthetic */ c9.l<i5.c0, r8.z> $callback;
        final /* synthetic */ String $channelId;
        final /* synthetic */ String $channelName;
        final /* synthetic */ String $icon;
        final /* synthetic */ int $inAllPos;
        final /* synthetic */ SubscribeItem $subscribeItem;
        Object L$0;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$updateSubscribe$1$1", f = "ModelHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ c9.l<i5.c0, r8.z> $callback;
            final /* synthetic */ i5.c0 $ret;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c9.l<? super i5.c0, r8.z> lVar, i5.c0 c0Var, v8.f<? super a> fVar) {
                super(2, fVar);
                this.$callback = lVar;
                this.$ret = c0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.$callback, this.$ret, fVar);
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
                    this.$callback.invoke(this.$ret);
                    return r8.z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        l(i5.p pVar, String str, int i10, String str2, String str3, SubscribeItem subscribeItem, c9.l<? super i5.c0, r8.z> lVar, v8.f<? super l> fVar) {
            super(2, fVar);
            this.$bean = pVar;
            this.$channelId = str;
            this.$inAllPos = i10;
            this.$channelName = str2;
            this.$icon = str3;
            this.$subscribeItem = subscribeItem;
            this.$callback = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new l(this.$bean, this.$channelId, this.$inAllPos, this.$channelName, this.$icon, this.$subscribeItem, this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((l) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            i5.c0 c0Var;
            i5.c0 c0Var2;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 == 0) {
                r8.r.b(obj);
                i5.c0 c0VarJ = s0.f7342a.J(this.$bean, this.$channelId);
                if (c0VarJ != null) {
                    c0VarJ.k(1);
                    c0Var = c0VarJ;
                } else {
                    c0Var = new i5.c0(kotlin.coroutines.jvm.internal.b.c(0L), this.$bean.d(), this.$bean.e(), this.$inAllPos, this.$channelName, this.$channelId, this.$bean.b(), this.$icon, this.$bean.a(), this.$bean.f(), this.$bean.g(), 0, false);
                }
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                int i11 = Integer.parseInt(this.$channelId);
                Long lF = this.$bean.f();
                kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
                long jLongValue = lF.longValue();
                String strB = this.$bean.b();
                kotlin.jvm.internal.m.e(strB, "getEpgId(...)");
                SubscribeItem subscribeItem = this.$subscribeItem;
                this.L$0 = c0Var;
                this.label = 1;
                if (aVar.J0(i11, jLongValue, strB, subscribeItem, this) == objC) {
                    return objC;
                }
                c0Var2 = c0Var;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c0Var2 = (i5.c0) this.L$0;
                r8.r.b(obj);
            }
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.b(), null, null, new a(this.$callback, c0Var2, null), 3, null);
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "com.live.evo.util.ModelHelper$updateSubscribeList$1", f = "ModelHelper.kt", l = {777}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class m extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ i5.c0 $bean;
        final /* synthetic */ SubscribeItem $subscribeItem;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(i5.c0 c0Var, SubscribeItem subscribeItem, v8.f<? super m> fVar) {
            super(2, fVar);
            this.$bean = c0Var;
            this.$subscribeItem = subscribeItem;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new m(this.$bean, this.$subscribeItem, fVar);
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((m) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                String strA = this.$bean.a();
                kotlin.jvm.internal.m.e(strA, "getChannelId(...)");
                int i11 = Integer.parseInt(strA);
                Long lH = this.$bean.h();
                kotlin.jvm.internal.m.e(lH, "getStartTime(...)");
                long jLongValue = lH.longValue();
                String strD = this.$bean.d();
                kotlin.jvm.internal.m.e(strD, "getEpgId(...)");
                SubscribeItem subscribeItem = this.$subscribeItem;
                this.label = 1;
                if (aVar.J0(i11, jLongValue, strD, subscribeItem, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    public final int L() {
        return 0;
    }

    public final boolean M(String epgId, String channelId, Long startTime) {
        if (channelId == null) {
            return false;
        }
        try {
            ChannelStreamResponse channelStreamResponseJ = t.v.c.i.a.f18646a.j(Integer.parseInt(channelId));
            if (channelStreamResponseJ == null || !channelStreamResponseJ.isCatchup()) {
                return false;
            }
            return startTime == null || startTime.longValue() > x1.f1.lb.util.c0.f21354a.a();
        } catch (NumberFormatException e10) {
            logger.error("parse channel id failure", e10);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0264  */
    /* JADX WARN: Code duplicated, block: B:21:0x009a  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:28:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:29:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00df A[Catch: all -> 0x00ea, TryCatch #1 {all -> 0x00ea, blocks: (B:36:0x00d9, B:38:0x00df, B:40:0x00e5, B:43:0x00ec, B:45:0x00f2), top: B:116:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ec A[Catch: all -> 0x00ea, TryCatch #1 {all -> 0x00ea, blocks: (B:36:0x00d9, B:38:0x00df, B:40:0x00e5, B:43:0x00ec, B:45:0x00f2), top: B:116:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00f2 A[Catch: all -> 0x00ea, TRY_LEAVE, TryCatch #1 {all -> 0x00ea, blocks: (B:36:0x00d9, B:38:0x00df, B:40:0x00e5, B:43:0x00ec, B:45:0x00f2), top: B:116:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:54:0x011a  */
    /* JADX WARN: Code duplicated, block: B:56:0x012b  */
    /* JADX WARN: Code duplicated, block: B:57:0x012f  */
    /* JADX WARN: Code duplicated, block: B:60:0x0137 A[Catch: all -> 0x0142, TryCatch #0 {all -> 0x0142, blocks: (B:58:0x0131, B:60:0x0137, B:62:0x013d, B:65:0x0144, B:67:0x014a), top: B:114:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0144 A[Catch: all -> 0x0142, TryCatch #0 {all -> 0x0142, blocks: (B:58:0x0131, B:60:0x0137, B:62:0x013d, B:65:0x0144, B:67:0x014a), top: B:114:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x014a A[Catch: all -> 0x0142, TRY_LEAVE, TryCatch #0 {all -> 0x0142, blocks: (B:58:0x0131, B:60:0x0137, B:62:0x013d, B:65:0x0144, B:67:0x014a), top: B:114:0x0131 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x017b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:81:0x01b6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0264 -> B:111:0x0260). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x01b6 -> B:82:0x01c3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:38:0x00df
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object m(java.lang.String r22, z1.b1.lb.m.sports.Match r23, java.util.List<java.lang.String> r24, java.util.Map<java.lang.Integer, z1.b1.lb.m.meta.EPGProgramme> r25, v8.f<? super java.util.List<? extends j5.c>> r26) {
        /*
            Method dump skipped, instruction units count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.live.evo.util.s0.m(java.lang.String, z1.b1.lb.m.sports.Match, java.util.List, java.util.Map, v8.f):java.lang.Object");
    }

    public final i5.h s(String channelId) {
        if (channelId == null) {
            return null;
        }
        try {
            ChannelStreamResponse channelStreamResponseJ = t.v.c.i.a.f18646a.j(Integer.parseInt(channelId));
            if (channelStreamResponseJ == null) {
                return null;
            }
            return h(channelStreamResponseJ);
        } catch (Throwable th) {
            logger.error("get channel by id[" + channelId + "] failure", th);
            return null;
        }
    }

    static {
        s0 s0Var = new s0();
        f7342a = s0Var;
        logger = q6.c.d(s0Var.getClass());
        sportMap = kotlin.collections.n0.i();
        versionMap = new LinkedHashMap();
        lastVersion = "";
    }

    public static /* synthetic */ void Y(s0 s0Var, i5.c0 c0Var, SubscribeItem subscribeItem, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            subscribeItem = null;
        }
        s0Var.X(c0Var, subscribeItem);
    }

    public static /* synthetic */ List j(s0 s0Var, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return s0Var.i(list, z10);
    }

    public final kotlinx.coroutines.flow.f<List<i5.p>> A(String channelId, String epgId) {
        return epgId == null ? kotlinx.coroutines.flow.h.w(kotlin.collections.r.l()) : new d(t.v.c.i.a.f18646a.D(epgId), channelId, epgId);
    }

    public final void B(String epgId, c9.l<? super Integer, r8.z> callback) {
        kotlin.jvm.internal.m.f(callback, "callback");
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new e(epgId, callback, null), 3, null);
    }

    public final HashMap<String, List<i5.h>> C() {
        HashMap<String, List<i5.h>> map = new HashMap<>();
        for (String str : t.v.c.i.a.f18646a.u(Boolean.TRUE)) {
            map.put(str, x(str, t.v.c.i.a.f18646a.d0(str)));
        }
        return map;
    }

    public final int D() {
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        String strZ = aVar.Z();
        if (strZ.length() <= 0) {
            return aVar.l0() ? 1 : 3;
        }
        if (o5.c.a(strZ)) {
            return 2;
        }
        return o5.c.b(strZ) ? 6 : -1;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object E(String str, String str2, String str3, v8.f<? super List<Match>> fVar) {
        f fVar2;
        long jD;
        List list;
        String str4 = str2;
        String str5 = str3;
        if (fVar instanceof f) {
            fVar2 = (f) fVar;
            int i10 = fVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                fVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                fVar2 = new f(fVar);
            }
        } else {
            fVar2 = new f(fVar);
        }
        Object obj = fVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = fVar2.label;
        if (i11 == 0) {
            r8.r.b(obj);
            ArrayList arrayList = new ArrayList();
            if (str4 == null) {
                return arrayList;
            }
            String strG = str5 == null ? x1.f1.lb.util.n.n().g(3) : str5;
            jD = x1.f1.lb.util.n.n().d(strG, "yyyy-MM-dd");
            x1.f1.lb.media.j jVar = x1.f1.lb.media.j.f20845a;
            kotlin.jvm.internal.m.c(strG);
            fVar2.L$0 = str4;
            fVar2.L$1 = str5;
            fVar2.L$2 = arrayList;
            fVar2.J$0 = jD;
            fVar2.label = 1;
            Object objF = jVar.F(str, str4, strG, fVar2);
            if (objF == objC) {
                return objC;
            }
            list = arrayList;
            obj = objF;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j10 = fVar2.J$0;
            list = (List) fVar2.L$2;
            String str6 = (String) fVar2.L$1;
            String str7 = (String) fVar2.L$0;
            r8.r.b(obj);
            jD = j10;
            str4 = str7;
            str5 = str6;
        }
        Matches matches = (Matches) obj;
        if (matches != null) {
            List<Match> listB = matches.b();
            if (listB != null && !listB.isEmpty()) {
                list.addAll(listB);
            } else if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("[" + str4 + "][" + str5 + "]matches is empty", new Object[0]);
            }
        }
        if (list.isEmpty() && x1.f1.lb.config.b.f20643a.u()) {
            ArrayList arrayList2 = new ArrayList();
            for (ChannelStreamResponse channelStreamResponse : t.v.c.i.a.o(t.v.c.i.a.f18646a, null, null, 3, null)) {
                String streamName = channelStreamResponse.getStreamName();
                kotlin.jvm.internal.m.e(streamName, "getStreamName(...)");
                String lowerCase = streamName.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.m.e(lowerCase, "toLowerCase(...)");
                if (ua.n.O(lowerCase, "globo sp", false, 2, null)) {
                    arrayList2.add(new Channel(channelStreamResponse.getStreamId(), channelStreamResponse.getStreamName(), "", "", "", kotlin.coroutines.jvm.internal.b.b(0), "", "", channelStreamResponse.getEpgId(), null));
                }
            }
            int i12 = 11;
            Iterator it = kotlin.collections.r.o(kotlin.coroutines.jvm.internal.b.b(6), kotlin.coroutines.jvm.internal.b.b(11), kotlin.coroutines.jvm.internal.b.b(17)).iterator();
            int i13 = 1;
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                long j11 = ((long) (iIntValue * 3600000)) + jD;
                long j12 = ((long) ((iIntValue + (iIntValue == i12 ? 2 : 1)) * 3600000)) + jD;
                ArrayList arrayList3 = arrayList2;
                list.add(new Match(kotlin.coroutines.jvm.internal.b.b(0), kotlin.coroutines.jvm.internal.b.b(Integer.parseInt(str4)), NotificationCompat.CATEGORY_STATUS, "test title" + i13, "test subtitle", "auto generated match", "venue", "city", "countryCode", new Team(kotlin.coroutines.jvm.internal.b.b(0), "home", "", "country"), new Team(kotlin.coroutines.jvm.internal.b.b(1), "away", "", "country"), arrayList3, kotlin.coroutines.jvm.internal.b.c(j11), kotlin.coroutines.jvm.internal.b.c(j12), kotlin.coroutines.jvm.internal.b.b(1), kotlin.coroutines.jvm.internal.b.b(2)));
                arrayList2 = arrayList3;
                i13++;
                str4 = str4;
                it = it;
                i12 = 11;
            }
        }
        return list;
    }

    public final List<String> G() {
        return x1.f1.lb.media.j.f20845a.B();
    }

    public final void H(String subjectTypeId, long lastUpdateTime, c9.l<? super j5.f, r8.z> callback) {
        kotlin.jvm.internal.m.f(subjectTypeId, "subjectTypeId");
        kotlin.jvm.internal.m.f(callback, "callback");
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new g(subjectTypeId, callback, null), 3, null);
    }

    public final void I(c9.l<? super j5.h, r8.z> callback) {
        kotlin.jvm.internal.m.f(callback, "callback");
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new h(callback, null), 3, null);
    }

    public final i5.c0 J(i5.p epgBean, String channelId) {
        kotlin.jvm.internal.m.f(epgBean, "epgBean");
        if (!O(epgBean, channelId) || channelId == null) {
            return null;
        }
        ChannelStreamResponse channelStreamResponseJ = t.v.c.i.a.f18646a.j(Integer.parseInt(channelId));
        if (channelStreamResponseJ == null) {
            return null;
        }
        return e(0, epgBean, channelStreamResponseJ);
    }

    public final kotlinx.coroutines.flow.f<List<i5.c0>> K() {
        return new i(t.v.c.i.a.f18646a.K());
    }

    public final boolean N() {
        return x1.f1.lb.config.b.f20643a.j();
    }

    public final boolean O(i5.p epgBean, String channelId) {
        kotlin.jvm.internal.m.f(epgBean, "epgBean");
        if (channelId != null && channelId.length() != 0) {
            try {
                int i10 = Integer.parseInt(channelId);
                t.v.c.i.a aVar = t.v.c.i.a.f18646a;
                Long lF = epgBean.f();
                kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
                long jLongValue = lF.longValue();
                String strB = epgBean.b();
                kotlin.jvm.internal.m.e(strB, "getEpgId(...)");
                return aVar.h0(i10, jLongValue, strB);
            } catch (NumberFormatException e10) {
                logger.error("parse channel id failure", e10);
            }
        }
        return false;
    }

    public final Integer P(ChannelStreamResponse channel) {
        kotlin.jvm.internal.m.f(channel, "channel");
        try {
            return Integer.valueOf(Integer.parseInt(t.v.c.i.a.f18646a.b(channel)) - 1);
        } catch (Throwable th) {
            logger.error("convert channel num failure", th);
            return null;
        }
    }

    public final boolean R() {
        return !t.v.c.i.a.f18646a.j0();
    }

    public final void T(String renewCode, boolean isCreateAccount, c9.r<? super Boolean, ? super Integer, ? super String, ? super Throwable, r8.z> callback) {
        kotlin.jvm.internal.m.f(renewCode, "renewCode");
        kotlin.jvm.internal.m.f(callback, "callback");
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new j(renewCode, callback, null), 3, null);
    }

    public final void U(String ccPassword, int accountLoginType, c9.r<? super Boolean, ? super Integer, ? super String, ? super Throwable, r8.z> callback) {
        kotlin.jvm.internal.m.f(ccPassword, "ccPassword");
        kotlin.jvm.internal.m.f(callback, "callback");
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new k(ccPassword, callback, null), 3, null);
    }

    public final void V(int pos, String msg) {
        kotlin.jvm.internal.m.f(msg, "msg");
    }

    public final void W(String channelName, String icon, int inAllPos, i5.p bean, String channelId, String subscribeType, c9.l<? super i5.c0, r8.z> callback, SubscribeItem subscribeItem) {
        kotlin.jvm.internal.m.f(channelName, "channelName");
        kotlin.jvm.internal.m.f(icon, "icon");
        kotlin.jvm.internal.m.f(bean, "bean");
        kotlin.jvm.internal.m.f(channelId, "channelId");
        kotlin.jvm.internal.m.f(subscribeType, "subscribeType");
        kotlin.jvm.internal.m.f(callback, "callback");
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new l(bean, channelId, inAllPos, channelName, icon, subscribeItem, callback, null), 3, null);
    }

    public final void X(i5.c0 bean, SubscribeItem subscribeItem) {
        kotlin.jvm.internal.m.f(bean, "bean");
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new m(bean, subscribeItem, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0043  */
    public final boolean d(String subjectTypeId) {
        boolean z10;
        String strA = x1.f1.lb.media.j.f20845a.A();
        if (!kotlin.jvm.internal.m.a(lastVersion, strA)) {
            if (!kotlin.jvm.internal.m.a(lastVersion, "")) {
                com.live.evo.fragment.subjuect.b.c().e();
            }
            lastVersion = strA;
        }
        if (subjectTypeId == null) {
            return false;
        }
        Map<String, String> map = versionMap;
        String str = map.get(subjectTypeId);
        if (str == null) {
            str = "0";
        }
        if (kotlin.jvm.internal.m.a(str, strA)) {
            z10 = false;
        } else {
            map.put(subjectTypeId, strA);
            if (kotlin.jvm.internal.m.a(str, "0")) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        if (z10 && x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("update_cache_check_data_version_UI[" + subjectTypeId + "]:[v" + str + " -> v" + strA + "]", new Object[0]);
        }
        return z10;
    }

    public final i5.c0 e(int seq, i5.p epgBean, ChannelStreamResponse response) {
        kotlin.jvm.internal.m.f(epgBean, "epgBean");
        kotlin.jvm.internal.m.f(response, "response");
        Integer numP = P(response);
        return new i5.c0(Long.valueOf(seq), epgBean.d(), epgBean.e(), numP != null ? numP.intValue() : 0, response.getStreamName(), String.valueOf(response.getKey()), epgBean.b(), response.getIconUrl(), epgBean.a(), epgBean.f(), epgBean.g(), 0, false);
    }

    public final i5.b f(AdItem item) {
        kotlin.jvm.internal.m.f(item, "item");
        i5.b bVar = new i5.b();
        bVar.g(true);
        bVar.h(item.getFile().getAbsolutePath());
        bVar.j(item.getId());
        bVar.k(item.getIsVideo() ? 2 : 1);
        bVar.i(6000);
        bVar.l(3000);
        return bVar;
    }

    public final List<i5.b> g(List<AdItem> list) {
        kotlin.jvm.internal.m.f(list, "list");
        ArrayList arrayList = new ArrayList();
        Iterator<AdItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f(it.next()));
        }
        return arrayList;
    }

    public final i5.h h(ChannelStreamResponse channel) {
        kotlin.jvm.internal.m.f(channel, "channel");
        i5.h hVar = new i5.h();
        hVar.v(String.valueOf(channel.getKey()));
        Integer numP = P(channel);
        int iIntValue = numP != null ? numP.intValue() : 0;
        hVar.s(channel.c());
        hVar.y(hVar.c());
        hVar.C(t.v.c.i.a.f18646a.m0(channel.getKey()) ? 1 : 0);
        hVar.t(channel.isCatchup());
        hVar.A(channel.getIconUrl());
        hVar.w(channel.getStreamName());
        hVar.u(channel.getStreamName());
        hVar.z(channel.getEpgId());
        hVar.B(iIntValue);
        hVar.x(iIntValue + 1);
        hVar.D(channel.getPlayerArgs());
        return hVar;
    }

    public final List<i5.h> i(List<? extends ChannelStreamResponse> list, boolean isIncludeAdult) {
        kotlin.jvm.internal.m.f(list, "list");
        ArrayList arrayList = new ArrayList();
        for (ChannelStreamResponse channelStreamResponse : list) {
            if (!channelStreamResponse.c() || isIncludeAdult) {
                arrayList.add(h(channelStreamResponse));
            }
        }
        return arrayList;
    }

    public final List<i5.p> k(String channelId, String epgId, List<? extends EPGProgramme> programs) {
        ArrayList arrayList;
        String epgId2 = epgId;
        kotlin.jvm.internal.m.f(epgId2, "epgId");
        kotlin.jvm.internal.m.f(programs, "programs");
        ArrayList arrayList2 = new ArrayList();
        Iterator<? extends EPGProgramme> it = programs.iterator();
        while (it.hasNext()) {
            arrayList2.add(l(it.next()));
        }
        if (x1.f1.lb.config.b.f20643a.u()) {
            long jD = x1.f1.lb.util.n.n().d(x1.f1.lb.util.n.n().h(2, q1.b()), "yyyyMMdd");
            long millis = TimeUnit.DAYS.toMillis(1L);
            int i10 = -7;
            while (i10 < 8) {
                long j10 = jD + (((long) i10) * millis);
                long j11 = j10 + 21600000;
                long j12 = j10 + 25200000;
                if (S(arrayList2, j11, j12)) {
                    arrayList = arrayList2;
                } else {
                    ArrayList arrayList3 = arrayList2;
                    arrayList = arrayList3;
                    arrayList.add(new i5.p(Long.valueOf(j11), epgId2, 0L, "test programme1", Long.valueOf(j11), Long.valueOf(j12), "this is a auto generate programe for test", epgId2 + j11, false));
                }
                long j13 = j10 + 39600000;
                long j14 = j10 + 46800000;
                if (!S(arrayList, j13, j14)) {
                    arrayList.add(new i5.p(Long.valueOf(j13), epgId2, 0L, "test programme2", Long.valueOf(j13), Long.valueOf(j14), "this is a auto generate programe for test", epgId2 + j13, false));
                }
                long j15 = j10 + 61200000;
                long j16 = j10 + 64800000;
                if (!S(arrayList, j15, j16)) {
                    arrayList.add(new i5.p(Long.valueOf(j15), epgId2, 0L, "test programme3", Long.valueOf(j15), Long.valueOf(j16), "this is a auto generate programe for test", epgId2 + j15, false));
                }
                i10++;
                epgId2 = epgId;
                arrayList2 = arrayList;
                jD = jD;
            }
        }
        return arrayList2;
    }

    public final i5.p l(EPGProgramme program) {
        kotlin.jvm.internal.m.f(program, "program");
        return new i5.p(Long.valueOf(program.getStart()), program.getChannel(), Long.valueOf(program.getStart()), program.getTitle(), Long.valueOf(program.getStart()), Long.valueOf(program.getStop()), program.getDesc(), "", false);
    }

    public final j5.d n(Team team) {
        kotlin.jvm.internal.m.f(team, "team");
        j5.d dVar = new j5.d();
        dVar.c(team.getName());
        dVar.d(team.getLogoUrl());
        return dVar;
    }

    public final i5.i o(int seq, String column) {
        kotlin.jvm.internal.m.f(column, "column");
        t.v.c.i.a aVar = t.v.c.i.a.f18646a;
        boolean zD0 = aVar.d0(column);
        ArrayList arrayList = new ArrayList();
        Iterator it = t.v.c.i.a.o(aVar, column, null, 2, null).iterator();
        int i10 = 0;
        while (it.hasNext()) {
            arrayList.add(new i5.j(column, ((ChannelStreamResponse) it.next()).getStreamId(), i10, 1));
            i10++;
        }
        return new i5.i(seq, column, column, column, 0, arrayList, new HashMap(), zD0 ? 1 : 0);
    }

    public final i5.a p() {
        String strI = t.v.c.i.a.f18646a.i();
        if (strI.length() <= 0) {
            return null;
        }
        i5.a aVar = new i5.a();
        if (o5.a.c().h(strI, "")) {
            aVar.f(ua.n.E(strI, "+55", "", false, 4, null));
            aVar.j(1);
            aVar.i("+55");
            aVar.g("BR");
        } else {
            aVar.j(0);
            aVar.f(strI);
        }
        aVar.h("");
        return aVar;
    }

    public final Map<String, i5.i> t() {
        HashMap map = new HashMap();
        List<String> listU = t.v.c.i.a.f18646a.u(Boolean.TRUE);
        int size = listU.size();
        for (String str : listU) {
            map.put(str, o(size, str));
            size--;
        }
        return map;
    }

    public final Map<String, i5.h> u() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<i5.h> listW = w();
        int size = listW.size();
        for (int i10 = 0; i10 < size; i10++) {
            i5.h hVar = listW.get(i10);
            linkedHashMap.put(hVar.b(), hVar);
        }
        return linkedHashMap;
    }

    public final void v(String epgId, long time, c9.l<? super EPGProgramme, r8.z> callback) {
        kotlin.jvm.internal.m.f(callback, "callback");
        if (epgId == null) {
            callback.invoke(null);
        } else {
            kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new b(epgId, time, callback, null), 3, null);
        }
    }

    public final List<i5.h> w() {
        return x(t.v.c.i.a.f18646a.A(), true);
    }

    public final List<i5.h> x(String column, boolean isIncludeAdult) {
        kotlin.jvm.internal.m.f(column, "column");
        List<ChannelStreamResponse> listN = t.v.c.i.a.f18646a.n(column, Boolean.valueOf(isIncludeAdult));
        ArrayList arrayList = new ArrayList();
        Iterator<ChannelStreamResponse> it = listN.iterator();
        while (it.hasNext()) {
            arrayList.add(h(it.next()));
        }
        return arrayList;
    }

    public final void y(List<? extends i5.h> channels, y imageCache, Resources resources, c9.a<r8.z> callback) {
        kotlin.jvm.internal.m.f(channels, "channels");
        kotlin.jvm.internal.m.f(imageCache, "imageCache");
        kotlin.jvm.internal.m.f(resources, "resources");
        kotlin.jvm.internal.m.f(callback, "callback");
        kotlinx.coroutines.j.d(kotlinx.coroutines.m0.a(kotlinx.coroutines.a1.b()), null, null, new c(resources, channels, imageCache, callback, null), 3, null);
    }

    public final String z() {
        String strV = t.v.c.i.a.f18646a.v();
        return strV.length() == 0 ? x1.f1.lb.util.u0.b(x1.f1.lb.util.u0.f21448a, R$string.us, null, 2, null) : strV;
    }

    private s0() {
    }

    private final boolean S(List<? extends i5.p> list, long startTime, long stopTime) {
        for (i5.p pVar : list) {
            Long lF = pVar.f();
            kotlin.jvm.internal.m.e(lF, "getStartTime(...)");
            long jLongValue = lF.longValue();
            if (startTime > jLongValue || jLongValue > stopTime) {
                Long lG = pVar.g();
                kotlin.jvm.internal.m.e(lG, "getStopTime(...)");
                long jLongValue2 = lG.longValue();
                if (startTime <= jLongValue2 && jLongValue2 <= stopTime) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public final List<i5.v> F() {
        return kotlin.collections.r.l();
    }

    public final String q() {
        int iD = D();
        if (iD != 2) {
            if (iD != 3) {
                if (iD != 6) {
                    of.a aVar = of.a.f16585a;
                    String strE = aVar.e();
                    if (strE.length() == 0) {
                        return aVar.k();
                    }
                    return strE;
                }
            } else {
                return t.v.c.i.a.f18646a.r();
            }
        }
        return t.v.c.i.a.f18646a.i();
    }

    public final int r() {
        return D();
    }

    public final void Q() {
    }
}
