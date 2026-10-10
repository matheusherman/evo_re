package x1.f1.lb.feedback;

import android.os.Process;
import android.text.TextUtils;
import c9.p;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import ua.n;
import x1.f1.lb.util.b1;
import x1.f1.lb.util.d1;
import z1.b1.lb.m.feedback.FeedbackUploadResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J)\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00040\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lx1/f1/lb/feedback/c;", "", "<init>", "()V", "Lr8/z;", "h", "Ljava/io/File;", "folder", "logcatFile", "", "withTraceFile", "f", "(Ljava/io/File;Ljava/io/File;Z)Ljava/io/File;", "i", "(Ljava/io/File;)V", "", "executeTime", "Lkotlinx/coroutines/flow/f;", "l", "(I)Lkotlinx/coroutines/flow/f;", "withSu", "", "fileName", "k", "(ZILjava/lang/String;)Ljava/io/File;", "Lkotlin/Function2;", "callback", "m", "(ILc9/p;)V", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Ljava/lang/String;", "dirPath", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f20670a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(c.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String dirPath;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.feedback.LogCatHelper$startLog$1", f = "LogCatHelper.kt", l = {68}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Ljava/io/File;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends l implements p<g<? super File>, v8.f<? super z>, Object> {
        final /* synthetic */ int $executeTime;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i10, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$executeTime = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            a aVar = new a(this.$executeTime, fVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // c9.p
        public final Object invoke(g<? super File> gVar, v8.f<? super z> fVar) {
            return ((a) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                g gVar = (g) this.L$0;
                File fileK = c.f20670a.k(false, this.$executeTime, null);
                this.label = 1;
                if (gVar.emit(fileK, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.feedback.LogCatHelper$startLogAndUpload$1", f = "LogCatHelper.kt", l = {139, 157}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ p<Boolean, String, z> $callback;
        final /* synthetic */ int $executeTime;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(int i10, p<? super Boolean, ? super String, z> pVar, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$executeTime = i10;
            this.$callback = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new b(this.$executeTime, this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((b) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:33:0x009e A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0017, B:31:0x007b, B:33:0x009e, B:34:0x00aa, B:36:0x00b8, B:37:0x00c6), top: B:48:0x0017 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x00aa A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0017, B:31:0x007b, B:33:0x009e, B:34:0x00aa, B:36:0x00b8, B:37:0x00c6), top: B:48:0x0017 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00b8 A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0017, B:31:0x007b, B:33:0x009e, B:34:0x00aa, B:36:0x00b8, B:37:0x00c6), top: B:48:0x0017 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x00c6 A[Catch: Exception -> 0x001b, TRY_LEAVE, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0017, B:31:0x007b, B:33:0x009e, B:34:0x00aa, B:36:0x00b8, B:37:0x00c6), top: B:48:0x0017 }] */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            File file;
            File file2;
            Exception e10;
            FeedbackUploadResponse feedbackUploadResponse;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        file2 = (File) this.L$1;
                        file = (File) this.L$0;
                        try {
                            r.b(obj);
                            feedbackUploadResponse = (FeedbackUploadResponse) obj;
                            c.logger.a("upload response {" + feedbackUploadResponse + "}", new Object[0]);
                            if (feedbackUploadResponse == null) {
                                this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(false), "-4");
                            } else if (m.a(feedbackUploadResponse.getData(), kotlin.coroutines.jvm.internal.b.a(true))) {
                                this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(true), feedbackUploadResponse.getCode());
                            } else {
                                this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(false), feedbackUploadResponse.getCode());
                            }
                        } catch (Exception e11) {
                            e10 = e11;
                            c.logger.error("upload file error " + e10, new Object[0]);
                            this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(false), "-5");
                        }
                        file.delete();
                        file2.delete();
                        c.f20670a.i(new File(b1.f21324a.b()));
                        return z.f17874a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj);
            } else {
                r.b(obj);
                kotlinx.coroutines.flow.f<File> fVarL = c.f20670a.l(this.$executeTime);
                this.label = 1;
                obj = h.s(fVarL, this);
                if (obj != objC) {
                }
                return objC;
            }
            file = (File) obj;
            if (file != null && file.exists()) {
                File fileF = c.f20670a.f(new File(b1.f21324a.b()), file, true);
                if (fileF != null && fileF.exists()) {
                    try {
                        kotlinx.coroutines.flow.f<FeedbackUploadResponse> fVarN1 = x1.f1.lb.user.f.f21202a.N1(fileF);
                        this.L$0 = file;
                        this.L$1 = fileF;
                        this.label = 2;
                        Object objS = h.s(fVarN1, this);
                        if (objS != objC) {
                            file2 = fileF;
                            obj = objS;
                            feedbackUploadResponse = (FeedbackUploadResponse) obj;
                            c.logger.a("upload response {" + feedbackUploadResponse + "}", new Object[0]);
                            if (feedbackUploadResponse == null) {
                                this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(false), "-4");
                            } else if (m.a(feedbackUploadResponse.getData(), kotlin.coroutines.jvm.internal.b.a(true))) {
                                this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(true), feedbackUploadResponse.getCode());
                            } else {
                                this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(false), feedbackUploadResponse.getCode());
                            }
                            file.delete();
                            file2.delete();
                            c.f20670a.i(new File(b1.f21324a.b()));
                            return z.f17874a;
                        }
                        return objC;
                    } catch (Exception e12) {
                        file2 = fileF;
                        e10 = e12;
                        c.logger.error("upload file error " + e10, new Object[0]);
                        this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(false), "-5");
                    }
                } else {
                    file.delete();
                    this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(false), "-3");
                    return z.f17874a;
                }
            } else {
                this.$callback.invoke(kotlin.coroutines.jvm.internal.b.a(false), "-2");
                return z.f17874a;
            }
        }
    }

    private final void h() {
        if (dirPath == null) {
            b1 b1Var = b1.f21324a;
            String strB = b1Var.b();
            String str = File.separator;
            String str2 = strB + str;
            File file = new File(str2);
            if (!file.exists() && !file.mkdirs()) {
                str2 = b1Var.f() + str;
            }
            dirPath = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(File folder) {
        try {
            File[] fileArrListFiles = folder.listFiles(new FileFilter() { // from class: x1.f1.lb.feedback.a
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    return c.j(file);
                }
            });
            if (fileArrListFiles == null) {
                fileArrListFiles = new File[0];
            }
            for (File file : fileArrListFiles) {
                file.delete();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.io.OutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.io.DataOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.OutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final File k(boolean withSu, int executeTime, String fileName) throws Throwable {
        File file;
        Throwable th;
        ?? r10;
        ?? dataOutputStream;
        boolean z10;
        String str;
        try {
            h();
            int iMyPid = Process.myPid();
            g0 g0Var = g0.f12340a;
            String str2 = String.format("logcat -P '%s'", Arrays.copyOf(new Object[]{Integer.valueOf(iMyPid)}, 1));
            m.e(str2, "format(...)");
            String str3 = "logcat -v threadtime";
            if (executeTime <= 0) {
                try {
                    str3 = "logcat -v threadtime -d";
                    z10 = true;
                } catch (Exception e10) {
                    e = e10;
                    dataOutputStream = 0;
                    file = null;
                    logger.error(e.getMessage(), e);
                    try {
                        m.c(dataOutputStream);
                        dataOutputStream.close();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    return file;
                } catch (Throwable th2) {
                    th = th2;
                    r10 = 0;
                    try {
                        m.c(r10);
                        r10.close();
                        throw th;
                    } catch (Exception e12) {
                        e12.printStackTrace();
                        throw th;
                    }
                }
            } else {
                z10 = false;
            }
            if (TextUtils.isEmpty(fileName)) {
                String str4 = dirPath;
                of.a aVar = of.a.f16585a;
                file = null;
                try {
                    str = str4 + "logcat-" + aVar.e() + "-" + aVar.d() + "-" + d1.d() + ".log";
                } catch (Exception e13) {
                    e = e13;
                    dataOutputStream = file;
                    logger.error(e.getMessage(), e);
                    m.c(dataOutputStream);
                    dataOutputStream.close();
                    return file;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    r10 = file;
                    m.c(r10);
                    r10.close();
                    throw th;
                }
            } else {
                file = null;
                str = fileName;
            }
            Process processStart = (withSu ? new ProcessBuilder("su") : new ProcessBuilder("sh")).redirectErrorStream(true).start();
            dataOutputStream = new DataOutputStream(processStart.getOutputStream());
            try {
                try {
                    dataOutputStream.writeBytes(str2);
                    dataOutputStream.writeBytes("\n");
                    dataOutputStream.writeBytes(str3 + " > " + str + (z10 ? "" : " &"));
                    dataOutputStream.writeBytes("\n");
                    dataOutputStream.flush();
                    if (executeTime > 0) {
                        new CountDownLatch(1).await(executeTime, TimeUnit.SECONDS);
                        String str5 = String.format("ps|grep logcat|awk -F' ' {'print \"kill \"$2'}|sh\n", Arrays.copyOf(new Object[0], 0));
                        m.e(str5, "format(...)");
                        dataOutputStream.writeBytes(str5);
                        String str6 = String.format("ps -ef|grep logcat|awk -F' ' {'print \"kill \"$2'}|sh\n", Arrays.copyOf(new Object[0], 0));
                        m.e(str6, "format(...)");
                        dataOutputStream.writeBytes(str6);
                    }
                    dataOutputStream.writeBytes("chmod 777 " + str);
                    dataOutputStream.writeBytes("\n");
                    dataOutputStream.writeBytes("logcat -P ''");
                    dataOutputStream.writeBytes("\n");
                    dataOutputStream.writeBytes("exit\n");
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    processStart.waitFor();
                    File file2 = new File(str);
                    try {
                        dataOutputStream.close();
                        return file2;
                    } catch (Exception e14) {
                        e14.printStackTrace();
                        return file2;
                    }
                } catch (Exception e15) {
                    e = e15;
                    dataOutputStream = dataOutputStream;
                    logger.error(e.getMessage(), e);
                    m.c(dataOutputStream);
                    dataOutputStream.close();
                    return file;
                }
            } catch (Throwable th4) {
                th = th4;
                r10 = dataOutputStream;
                m.c(r10);
                r10.close();
                throw th;
            }
        } catch (Exception e16) {
            e = e16;
            file = null;
        } catch (Throwable th5) {
            th = th5;
            file = null;
        }
    }

    public final kotlinx.coroutines.flow.f<File> l(int executeTime) {
        return h.v(new a(executeTime, null));
    }

    public final void m(int executeTime, p<? super Boolean, ? super String, z> callback) {
        m.f(callback, "callback");
        j.d(m0.a(a1.b()), null, null, new b(executeTime, callback, null), 3, null);
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File f(File folder, final File logcatFile, boolean withTraceFile) {
        if (folder.exists() && folder.isDirectory()) {
            File[] fileArrListFiles = folder.listFiles(new FileFilter() { // from class: x1.f1.lb.feedback.b
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    return c.g(logcatFile, file);
                }
            });
            if (fileArrListFiles == null) {
                fileArrListFiles = new File[0];
            }
            File file = new File(logcatFile.getParent(), logcatFile.getName() + ".gz");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
                    try {
                        byte[] bArr = new byte[4096];
                        for (File file2 : fileArrListFiles) {
                            FileInputStream fileInputStream = new FileInputStream(file2);
                            while (true) {
                                try {
                                    int i10 = fileInputStream.read(bArr);
                                    if (i10 == -1) {
                                        break;
                                    }
                                    gZIPOutputStream.write(bArr, 0, i10);
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        a9.a.a(fileInputStream, th);
                                        throw th2;
                                    }
                                }
                            }
                            z zVar = z.f17874a;
                            a9.a.a(fileInputStream, null);
                        }
                        FileInputStream fileInputStream2 = new FileInputStream(logcatFile);
                        while (true) {
                            try {
                                int i11 = fileInputStream2.read(bArr);
                                if (i11 == -1) {
                                    break;
                                }
                                gZIPOutputStream.write(bArr, 0, i11);
                            } catch (Throwable th3) {
                                try {
                                    throw th3;
                                } catch (Throwable th4) {
                                    a9.a.a(fileInputStream2, th3);
                                    throw th4;
                                }
                            }
                            try {
                                throw th;
                            } catch (Throwable th5) {
                                a9.a.a(gZIPOutputStream, th);
                                throw th5;
                            }
                        }
                        z zVar2 = z.f17874a;
                        a9.a.a(fileInputStream2, null);
                        if (withTraceFile) {
                            File file3 = new File("/data/anr/traces.txt");
                            if (file3.exists() && file3.canRead()) {
                                FileInputStream fileInputStream3 = new FileInputStream(file3);
                                while (true) {
                                    try {
                                        int i12 = fileInputStream3.read(bArr);
                                        if (i12 == -1) {
                                            break;
                                        }
                                        gZIPOutputStream.write(bArr, 0, i12);
                                    } catch (Throwable th6) {
                                        try {
                                            throw th6;
                                        } catch (Throwable th7) {
                                            a9.a.a(fileInputStream3, th6);
                                            throw th7;
                                        }
                                    }
                                    throw th;
                                }
                                z zVar3 = z.f17874a;
                                a9.a.a(fileInputStream3, null);
                            }
                        }
                        a9.a.a(gZIPOutputStream, null);
                        a9.a.a(fileOutputStream, null);
                        return file;
                    } catch (Throwable th8) {
                        throw th8;
                    }
                } catch (Throwable th9) {
                    try {
                        throw th9;
                    } catch (Throwable th10) {
                        a9.a.a(fileOutputStream, th9);
                        throw th10;
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(File file, File file2) {
        if (file2.isFile()) {
            String name = file2.getName();
            m.e(name, "getName(...)");
            if (n.u(name, ".log", true) && !file2.getName().equals(file.getName())) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(File file) {
        if (file.isFile()) {
            String name = file.getName();
            m.e(name, "getName(...)");
            if (n.u(name, ".log", true)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
