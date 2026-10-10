package x1.f1.lb.id;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.m;
import q6.b;
import q6.c;
import r8.r;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x1.f1.lb.util.w0;
import x1.f1.lb.util.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019¨\u0006\u001b"}, d2 = {"Lx1/f1/lb/id/a;", "", "<init>", "()V", "Ljava/io/File;", "installation", "", "d", "(Ljava/io/File;)Ljava/lang/String;", "Lr8/z;", "e", "(Ljava/io/File;)V", "b", "()Ljava/lang/String;", "a", "idFileInstallDir", "c", "(Ljava/io/File;Lv8/f;)Ljava/lang/Object;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Ljava/lang/String;", "sID", "", "Z", "isFirstLogin", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String sID;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isFirstLogin;

    /* JADX INFO: renamed from: x1.f1.lb.id.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.id.Installation", f = "Installation.kt", l = {34}, m = IjkMediaMeta.IJKM_KEY_TRACK_ID)
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class C0415a extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C0415a(v8.f<? super C0415a> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.c(null, this);
        }
    }

    static {
        a aVar = new a();
        f20725a = aVar;
        logger = c.d(aVar.getClass());
    }

    private final String a() {
        String str = "";
        isFirstLogin = true;
        z zVar = z.f21470a;
        String strS = zVar.s();
        String strO = zVar.o();
        try {
            String str2 = strS + strO;
            String string = null;
            if (str2.length() == 0) {
                UUID uuidRandomUUID = UUID.randomUUID();
                if (uuidRandomUUID != null) {
                    string = uuidRandomUUID.toString();
                }
            } else {
                byte[] bytes = str2.getBytes(ua.d.UTF_8);
                m.e(bytes, "getBytes(...)");
                UUID uuidNameUUIDFromBytes = UUID.nameUUIDFromBytes(bytes);
                if (uuidNameUUIDFromBytes != null) {
                    string = uuidNameUUIDFromBytes.toString();
                }
            }
            if (string == null || string.length() == 0) {
                logger.error("did:[" + strS + "][" + strO + "]->[" + string + "] is empty", new Object[0]);
            }
            if (string != null) {
                str = string;
            }
        } catch (Throwable th) {
            logger.error("generate did failure", th);
        }
        if (str.length() == 0) {
            str = strO.length() == 0 ? strS : strO;
        }
        logger.a("did:[" + strS + "][" + strO + "]->[" + str + "]", new Object[0]);
        return str;
    }

    private final String d(File installation) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(installation, "r");
        byte[] bArr = new byte[(int) randomAccessFile.length()];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr, ua.d.UTF_8);
    }

    private final void e(File installation) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(installation);
        byte[] bytes = a().getBytes(ua.d.UTF_8);
        m.e(bytes, "getBytes(...)");
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public final Object c(File file, v8.f<? super String> fVar) {
        C0415a c0415a;
        String strD;
        if (fVar instanceof C0415a) {
            c0415a = (C0415a) fVar;
            int i10 = c0415a.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0415a.label = i10 - Integer.MIN_VALUE;
            } else {
                c0415a = new C0415a(fVar);
            }
        } else {
            c0415a = new C0415a(fVar);
        }
        Object objM = c0415a.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = c0415a.label;
        if (i11 == 0) {
            r.b(objM);
            String str = sID;
            if (str != null && str.length() != 0) {
                return str;
            }
            File file2 = new File(file, "INSTALLATION");
            try {
                if (!file2.exists()) {
                    e(file2);
                }
                strD = d(file2);
            } catch (Throwable th) {
                logger.warn("generate id from file failure", th);
                strD = "";
            }
            if (strD.length() == 0) {
                w0 w0Var = w0.f21452a;
                c0415a.L$0 = this;
                c0415a.label = 1;
                objM = w0Var.m("INSTALLATION", "", c0415a);
                if (objM == objC) {
                    return objC;
                }
            }
            sID = strD;
            return strD;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        r.b(objM);
        CharSequence charSequenceB = (CharSequence) objM;
        if (charSequenceB.length() == 0) {
            charSequenceB = f20725a.b();
        }
        strD = (String) charSequenceB;
        sID = strD;
        return strD;
    }

    private a() {
    }

    private final String b() {
        String strA = a();
        w0.f21452a.t("INSTALLATION", strA);
        return strA;
    }
}
