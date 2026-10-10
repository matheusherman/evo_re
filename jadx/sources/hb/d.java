package hb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import h9.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.collections.k0;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
import tb.f;
import tb.g;
import tb.q;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import ua.l;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0007*\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001c\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u001c\u0010\u001d\u001a%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010\"\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#\u001a%\u0010$\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b$\u0010#\u001a%\u0010%\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010)\u001a-\u0010,\u001a\u00020\u001b*\u00020\u00072\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b,\u0010-\u001a\u0011\u0010.\u001a\u00020\u001b*\u00020\u0007¢\u0006\u0004\b.\u0010/\u001a\u0011\u00100\u001a\u00020\t*\u00020\u0007¢\u0006\u0004\b0\u00101\u001a\u0015\u00102\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b2\u00101\u001a)\u00106\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0012\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u0002040\u000e\"\u000204¢\u0006\u0004\b6\u00107\u001a\u0019\u0010;\u001a\u000209*\u0002082\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<\u001a'\u0010@\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00002\b\u0010?\u001a\u0004\u0018\u00010>¢\u0006\u0004\b@\u0010A\u001a\u0011\u0010B\u001a\u00020\u001b*\u00020*¢\u0006\u0004\bB\u0010C\u001a\u0017\u0010G\u001a\u00020F*\b\u0012\u0004\u0012\u00020E0D¢\u0006\u0004\bG\u0010H\u001a\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020E0D*\u00020F¢\u0006\u0004\bI\u0010J\u001a\u0019\u0010K\u001a\u00020\t*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\bK\u0010L\u001a\u0011\u0010O\u001a\u00020N*\u00020M¢\u0006\u0004\bO\u0010P\u001a\u001c\u0010S\u001a\u00020\u001b*\u00020Q2\u0006\u0010R\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bS\u0010T\u001a\u001c\u0010V\u001a\u00020\u001b*\u00020U2\u0006\u0010R\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bV\u0010W\u001a\u001c\u0010X\u001a\u00020\u0000*\u00020\u001b2\u0006\u0010R\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\bX\u0010Y\u001a\u0019\u0010\\\u001a\u00020\u0004*\u00020Z2\u0006\u0010[\u001a\u00020\u001b¢\u0006\u0004\b\\\u0010]\u001a\u0011\u0010^\u001a\u00020\u001b*\u000208¢\u0006\u0004\b^\u0010_\u001a!\u0010b\u001a\u00020\t*\u00020`2\u0006\u0010=\u001a\u00020\u001b2\u0006\u0010a\u001a\u00020>¢\u0006\u0004\bb\u0010c\u001a!\u0010e\u001a\u00020\t*\u00020`2\u0006\u0010d\u001a\u00020\u001b2\u0006\u0010a\u001a\u00020>¢\u0006\u0004\be\u0010c\u001a\u0019\u0010h\u001a\u00020\t*\u00020f2\u0006\u0010g\u001a\u000208¢\u0006\u0004\bh\u0010i\u001a\u0019\u0010l\u001a\u00020\u001b*\u00020j2\u0006\u0010k\u001a\u00020Q¢\u0006\u0004\bl\u0010m\u001a\u001b\u0010n\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b¢\u0006\u0004\bn\u0010o\u001a\u0011\u0010q\u001a\u00020\u0000*\u00020p¢\u0006\u0004\bq\u0010r\u001a\u0019\u0010t\u001a\u00020\u0000*\u00020\u00072\u0006\u0010s\u001a\u00020\u0000¢\u0006\u0004\bt\u0010u\u001a\u001b\u0010v\u001a\u00020\u001b*\u0004\u0018\u00010\u00072\u0006\u0010s\u001a\u00020\u001b¢\u0006\u0004\bv\u0010o\u001a#\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000D\"\u0004\b\u0000\u0010w*\b\u0012\u0004\u0012\u00028\u00000D¢\u0006\u0004\bx\u0010y\u001a/\u0010{\u001a\b\u0012\u0004\u0012\u00028\u00000D\"\u0004\b\u0000\u0010w2\u0012\u0010z\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e\"\u00028\u0000H\u0007¢\u0006\u0004\b{\u0010|\u001a5\u0010w\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010}\"\u0004\b\u0000\u0010l\"\u0004\b\u0001\u0010v*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010}¢\u0006\u0004\bw\u0010~\u001a\u0014\u0010\u0080\u0001\u001a\u00020\u0004*\u00020\u007f¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0014\u0010\u0082\u0001\u001a\u00020\u0004*\u00020f¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a,\u0010\u0086\u0001\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0012*\t\u0012\u0004\u0012\u00028\u00000\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00028\u0000H\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a0\u0010\u008c\u0001\u001a\u00030\u008b\u0001*\b0\u0088\u0001j\u0003`\u0089\u00012\u0013\u0010\u008a\u0001\u001a\u000e\u0012\n\u0012\b0\u0088\u0001j\u0003`\u0089\u00010D¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0018\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0016\u0010\u0093\u0001\u001a\u00020F8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\bk\u0010\u0092\u0001\"\u0018\u0010\u0096\u0001\u001a\u00030\u0094\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0095\u0001\"\u0017\u0010\u0099\u0001\u001a\u00030\u0097\u00018\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\bS\u0010\u0098\u0001\"\u0017\u0010\u009c\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bV\u0010\u009b\u0001\"\u0017\u0010\u009f\u0001\u001a\u00030\u009d\u00018\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\bX\u0010\u009e\u0001\"\u0017\u0010¢\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bO\u0010¡\u0001\"\u0016\u0010¤\u0001\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0007\n\u0005\b£\u0001\u0010\\\"\u0016\u0010¦\u0001\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0007\n\u0005\b0\u0010¥\u0001¨\u0006§\u0001"}, d2 = {"", "arrayLength", "offset", "count", "Lr8/z;", "l", "(JJJ)V", "", "name", "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "M", "(Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;", "", TransactionPartnerType.OTHER, "Ljava/util/Comparator;", "comparator", ExifInterface.LONGITUDE_EAST, "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "u", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/v;", "includeDefaultPort", "Q", "(Lokhttp3/v;Z)Ljava/lang/String;", "value", "", "x", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "o", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "z", "(Ljava/lang/String;II)I", "B", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;II)Ljava/lang/String;", "delimiters", "q", "(Ljava/lang/String;Ljava/lang/String;II)I", "", "delimiter", "p", "(Ljava/lang/String;CII)I", "y", "(Ljava/lang/String;)I", "i", "(Ljava/lang/String;)Z", "G", IjkMediaMeta.IJKM_KEY_FORMAT, "", "args", "t", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Ltb/f;", "Ljava/nio/charset/Charset;", "default", "I", "(Ltb/f;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", TypedValues.TransitionType.S_DURATION, "Ljava/util/concurrent/TimeUnit;", "unit", "k", "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)I", "H", "(C)I", "", "Lnb/c;", "Lokhttp3/u;", "P", "(Ljava/util/List;)Lokhttp3/u;", "O", "(Lokhttp3/u;)Ljava/util/List;", "j", "(Lokhttp3/v;Lokhttp3/v;)Z", "Lokhttp3/r;", "Lokhttp3/r$c;", "g", "(Lokhttp3/r;)Lokhttp3/r$c;", "", "mask", "d", "(BI)I", "", "e", "(SI)I", "f", "(IJ)J", "Ltb/e;", "medium", "Z", "(Ltb/e;I)V", "J", "(Ltb/f;)I", "Ltb/z;", "timeUnit", "L", "(Ltb/z;ILjava/util/concurrent/TimeUnit;)Z", "timeout", "s", "Ljava/net/Socket;", "source", "F", "(Ljava/net/Socket;Ltb/f;)Z", "Ltb/d;", "b", "K", "(Ltb/d;B)I", "D", "(Ljava/lang/String;I)I", "Lokhttp3/d0;", "v", "(Lokhttp3/d0;)J", "defaultValue", "U", "(Ljava/lang/String;J)J", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "(Ljava/util/List;)Ljava/util/List;", "elements", "w", "([Ljava/lang/Object;)Ljava/util/List;", "", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/io/Closeable;", "m", "(Ljava/io/Closeable;)V", "n", "(Ljava/net/Socket;)V", "", "element", "c", "(Ljava/util/List;Ljava/lang/Object;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "Y", "(Ljava/lang/Exception;Ljava/util/List;)Ljava/lang/Throwable;", "", "a", "[B", "EMPTY_BYTE_ARRAY", "Lokhttp3/u;", "EMPTY_HEADERS", "Lokhttp3/e0;", "Lokhttp3/e0;", "EMPTY_RESPONSE", "Lokhttp3/c0;", "Lokhttp3/c0;", "EMPTY_REQUEST", "Ltb/q;", "Ltb/q;", "UNICODE_BOMS", "Ljava/util/TimeZone;", "Ljava/util/TimeZone;", "UTC", "Lua/l;", "Lua/l;", "VERIFY_AS_IP_ADDRESS", "h", "assertionsEnabled", "Ljava/lang/String;", "okHttpName", "okhttp"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f10913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f10914b = u.INSTANCE.g(new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e0 f10915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c0 f10916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final q f10917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TimeZone f10918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final l f10919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f10920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f10921i;

    static {
        byte[] bArr = new byte[0];
        f10913a = bArr;
        f10915c = e0.Companion.e(e0.INSTANCE, bArr, null, 1, null);
        f10916d = c0.Companion.k(c0.INSTANCE, bArr, null, 0, 0, 7, null);
        q.Companion aVar = q.INSTANCE;
        g.Companion aVar2 = g.INSTANCE;
        f10917e = aVar.d(aVar2.a("efbbbf"), aVar2.a("feff"), aVar2.a("fffe"), aVar2.a("0000ffff"), aVar2.a("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        m.c(timeZone);
        f10918f = timeZone;
        f10919g = new l("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f10920h = false;
        String name = z.class.getName();
        m.e(name, "OkHttpClient::class.java.name");
        f10921i = n.t0(n.s0(name, "okhttp3."), "Client");
    }

    public static final int d(byte b10, int i10) {
        return b10 & i10;
    }

    public static final int e(short s10, int i10) {
        return s10 & i10;
    }

    public static final long f(int i10, long j10) {
        return j10 & ((long) i10);
    }

    public static /* synthetic */ int A(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return z(str, i10, i11);
    }

    public static final int B(String str, int i10, int i11) {
        m.f(str, "<this>");
        int i12 = i11 - 1;
        if (i10 <= i12) {
            while (true) {
                char cCharAt = str.charAt(i12);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i12 + 1;
                }
                if (i12 != i10) {
                    i12--;
                }
            }
        }
        return i10;
    }

    public static /* synthetic */ int C(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return B(str, i10, i11);
    }

    public static final int D(String str, int i10) {
        m.f(str, "<this>");
        int length = str.length();
        while (i10 < length) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i10;
            }
            i10++;
        }
        return str.length();
    }

    public static final String[] E(String[] strArr, String[] other, Comparator<? super String> comparator) {
        m.f(strArr, "<this>");
        m.f(other, "other");
        m.f(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : other) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean F(Socket socket, f source) {
        m.f(socket, "<this>");
        m.f(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !source.L();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean G(String name) {
        m.f(name, "name");
        return n.w(name, "Authorization", true) || n.w(name, "Cookie", true) || n.w(name, "Proxy-Authorization", true) || n.w(name, "Set-Cookie", true);
    }

    public static final int H(char c10) {
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        if ('a' <= c10 && c10 < 'g') {
            return c10 - 'W';
        }
        if ('A' > c10 || c10 >= 'G') {
            return -1;
        }
        return c10 - '7';
    }

    public static final Charset I(f fVar, Charset charset) {
        m.f(fVar, "<this>");
        m.f(charset, "default");
        int iX = fVar.X(f10917e);
        if (iX == -1) {
            return charset;
        }
        if (iX == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            m.e(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (iX == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            m.e(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (iX == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            m.e(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (iX == 3) {
            return ua.d.f19425a.a();
        }
        if (iX == 4) {
            return ua.d.f19425a.b();
        }
        throw new AssertionError();
    }

    public static final int J(f fVar) {
        m.f(fVar, "<this>");
        return d(fVar.readByte(), 255) | (d(fVar.readByte(), 255) << 16) | (d(fVar.readByte(), 255) << 8);
    }

    public static final int K(tb.d dVar, byte b10) {
        m.f(dVar, "<this>");
        int i10 = 0;
        while (!dVar.L() && dVar.k(0L) == b10) {
            i10++;
            dVar.readByte();
        }
        return i10;
    }

    public static final boolean L(tb.z zVar, int i10, TimeUnit timeUnit) {
        m.f(zVar, "<this>");
        m.f(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = zVar.getTimeout().getHasDeadline() ? zVar.getTimeout().c() - jNanoTime : Long.MAX_VALUE;
        zVar.getTimeout().d(Math.min(jC, timeUnit.toNanos(i10)) + jNanoTime);
        try {
            tb.d dVar = new tb.d();
            while (zVar.D(dVar, 8192L) != -1) {
                dVar.a();
            }
            if (jC == LocationRequestCompat.PASSIVE_INTERVAL) {
                zVar.getTimeout().a();
                return true;
            }
            zVar.getTimeout().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == LocationRequestCompat.PASSIVE_INTERVAL) {
                zVar.getTimeout().a();
                return false;
            }
            zVar.getTimeout().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == LocationRequestCompat.PASSIVE_INTERVAL) {
                zVar.getTimeout().a();
            } else {
                zVar.getTimeout().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final ThreadFactory M(final String name, final boolean z10) {
        m.f(name, "name");
        return new ThreadFactory() { // from class: hb.c
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return d.N(name, z10, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread N(String name, boolean z10, Runnable runnable) {
        m.f(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(z10);
        return thread;
    }

    public static final List<nb.c> O(u uVar) {
        m.f(uVar, "<this>");
        e eVarM = h9.f.m(0, uVar.size());
        ArrayList arrayList = new ArrayList(r.w(eVarM, 10));
        Iterator<Integer> it = eVarM.iterator();
        while (it.hasNext()) {
            int iNextInt = ((k0) it).nextInt();
            arrayList.add(new nb.c(uVar.f(iNextInt), uVar.k(iNextInt)));
        }
        return arrayList;
    }

    public static final u P(List<nb.c> list) {
        m.f(list, "<this>");
        u.a aVar = new u.a();
        for (nb.c cVar : list) {
            aVar.d(cVar.getName().A(), cVar.getValue().A());
        }
        return aVar.f();
    }

    public static final String Q(v vVar, boolean z10) {
        String strI;
        m.f(vVar, "<this>");
        if (n.O(vVar.getHost(), ":", false, 2, null)) {
            strI = '[' + vVar.getHost() + ']';
        } else {
            strI = vVar.getHost();
        }
        if (!z10 && vVar.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String() == v.INSTANCE.c(vVar.getScheme())) {
            return strI;
        }
        return strI + ':' + vVar.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String();
    }

    public static /* synthetic */ String R(v vVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return Q(vVar, z10);
    }

    public static final <T> List<T> S(List<? extends T> list) {
        m.f(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(r.Q0(list));
        m.e(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final <K, V> Map<K, V> T(Map<K, ? extends V> map) {
        m.f(map, "<this>");
        if (map.isEmpty()) {
            return n0.i();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        m.e(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return mapUnmodifiableMap;
    }

    public static final long U(String str, long j10) {
        m.f(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public static final int V(String str, int i10) {
        if (str == null) {
            return i10;
        }
        try {
            long j10 = Long.parseLong(str);
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j10 < 0) {
                return 0;
            }
            return (int) j10;
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public static final String W(String str, int i10, int i11) {
        m.f(str, "<this>");
        int iZ = z(str, i10, i11);
        String strSubstring = str.substring(iZ, B(str, iZ, i11));
        m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String X(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return W(str, i10, i11);
    }

    public static final Throwable Y(Exception exc, List<? extends Exception> suppressed) {
        m.f(exc, "<this>");
        m.f(suppressed, "suppressed");
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            r8.a.a(exc, it.next());
        }
        return exc;
    }

    public static final void Z(tb.e eVar, int i10) {
        m.f(eVar, "<this>");
        eVar.writeByte((i10 >>> 16) & 255);
        eVar.writeByte((i10 >>> 8) & 255);
        eVar.writeByte(i10 & 255);
    }

    public static final <E> void c(List<E> list, E e10) {
        m.f(list, "<this>");
        if (list.contains(e10)) {
            return;
        }
        list.add(e10);
    }

    public static final okhttp3.r.c g(final okhttp3.r rVar) {
        m.f(rVar, "<this>");
        return new okhttp3.r.c() { // from class: hb.b
            @Override // okhttp3.r.c
            public final okhttp3.r a(okhttp3.e eVar) {
                return d.h(rVar, eVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final okhttp3.r h(okhttp3.r this_asFactory, okhttp3.e it) {
        m.f(this_asFactory, "$this_asFactory");
        m.f(it, "it");
        return this_asFactory;
    }

    public static final boolean i(String str) {
        m.f(str, "<this>");
        return f10919g.d(str);
    }

    public static final boolean j(v vVar, v other) {
        m.f(vVar, "<this>");
        m.f(other, "other");
        return m.a(vVar.getHost(), other.getHost()) && vVar.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String() == other.getTv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT java.lang.String() && m.a(vVar.getScheme(), other.getScheme());
    }

    public static final int k(String name, long j10, TimeUnit timeUnit) {
        m.f(name, "name");
        if (j10 < 0) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j10);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException((name + " too large.").toString());
        }
        if (millis != 0 || j10 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException((name + " too small.").toString());
    }

    public static final void l(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void m(Closeable closeable) {
        m.f(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final void n(Socket socket) {
        m.f(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!m.a(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final String[] o(String[] strArr, String value) {
        m.f(strArr, "<this>");
        m.f(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        m.e(objArrCopyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[j.R(strArr2)] = value;
        return strArr2;
    }

    public static final int p(String str, char c10, int i10, int i11) {
        m.f(str, "<this>");
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static final int q(String str, String delimiters, int i10, int i11) {
        m.f(str, "<this>");
        m.f(delimiters, "delimiters");
        while (i10 < i11) {
            if (n.N(delimiters, str.charAt(i10), false, 2, null)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int r(String str, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return p(str, c10, i10, i11);
    }

    public static final boolean s(tb.z zVar, int i10, TimeUnit timeUnit) {
        m.f(zVar, "<this>");
        m.f(timeUnit, "timeUnit");
        try {
            return L(zVar, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String t(String format, Object... args) {
        m.f(format, "format");
        m.f(args, "args");
        g0 g0Var = g0.f12340a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        m.e(str, "format(locale, format, *args)");
        return str;
    }

    public static final boolean u(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        m.f(strArr, "<this>");
        m.f(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                Iterator itA = kotlin.jvm.internal.b.a(strArr2);
                while (itA.hasNext()) {
                    if (comparator.compare(str, (String) itA.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long v(d0 d0Var) {
        m.f(d0Var, "<this>");
        String strE = d0Var.getHeaders().e("Content-Length");
        if (strE != null) {
            return U(strE, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> w(T... elements) {
        m.f(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(r.o(Arrays.copyOf(objArr, objArr.length)));
        m.e(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int x(String[] strArr, String value, Comparator<String> comparator) {
        m.f(strArr, "<this>");
        m.f(value, "value");
        m.f(comparator, "comparator");
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], value) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int y(String str) {
        m.f(str, "<this>");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (m.h(cCharAt, 31) <= 0 || m.h(cCharAt, 127) >= 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int z(String str, int i10, int i11) {
        m.f(str, "<this>");
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }
}
