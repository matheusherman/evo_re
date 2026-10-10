package g;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f10358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f10359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f10360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f10361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f10362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f10363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f10364g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Writer f10366i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10368k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f10365h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<String, d> f10367j = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f10369l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f10370m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0180b(null));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Callable<Void> f10371n = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Callable<Void> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (b.this) {
                try {
                    if (b.this.f10366i == null) {
                        return null;
                    }
                    b.this.C();
                    if (b.this.u()) {
                        b.this.z();
                        b.this.f10368k = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class ThreadFactoryC0180b implements ThreadFactory {
        private ThreadFactoryC0180b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ ThreadFactoryC0180b(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f10373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f10374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f10375c;

        /* synthetic */ c(b bVar, d dVar, a aVar) {
            this(dVar);
        }

        private c(d dVar) {
            this.f10373a = dVar;
            this.f10374b = dVar.f10381e ? null : new boolean[b.this.f10364g];
        }

        public void a() {
            b.this.n(this, false);
        }

        public void b() {
            if (this.f10375c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() {
            b.this.n(this, true);
            this.f10375c = true;
        }

        public File f(int i10) {
            File fileK;
            synchronized (b.this) {
                try {
                    if (this.f10373a.f10382f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f10373a.f10381e) {
                        this.f10374b[i10] = true;
                    }
                    fileK = this.f10373a.k(i10);
                    b.this.f10358a.mkdirs();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fileK;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f10378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        File[] f10379c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        File[] f10380d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f10381e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c f10382f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f10383g;

        /* synthetic */ d(b bVar, String str, a aVar) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != b.this.f10364g) {
                throw m(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f10378b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        private d(String str) {
            this.f10377a = str;
            this.f10378b = new long[b.this.f10364g];
            this.f10379c = new File[b.this.f10364g];
            this.f10380d = new File[b.this.f10364g];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i10 = 0; i10 < b.this.f10364g; i10++) {
                sb2.append(i10);
                this.f10379c[i10] = new File(b.this.f10358a, sb2.toString());
                sb2.append(".tmp");
                this.f10380d[i10] = new File(b.this.f10358a, sb2.toString());
                sb2.setLength(length);
            }
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File j(int i10) {
            return this.f10379c[i10];
        }

        public File k(int i10) {
            return this.f10380d[i10];
        }

        public String l() {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f10378b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f10387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File[] f10388d;

        /* synthetic */ e(b bVar, String str, long j10, File[] fileArr, long[] jArr, a aVar) {
            this(str, j10, fileArr, jArr);
        }

        private e(String str, long j10, File[] fileArr, long[] jArr) {
            this.f10385a = str;
            this.f10386b = j10;
            this.f10388d = fileArr;
            this.f10387c = jArr;
        }

        public File a(int i10) {
            return this.f10388d[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(c cVar, boolean z10) {
        d dVar = cVar.f10373a;
        if (dVar.f10382f != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f10381e) {
            for (int i10 = 0; i10 < this.f10364g; i10++) {
                if (!cVar.f10374b[i10]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!dVar.k(i10).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f10364g; i11++) {
            File fileK = dVar.k(i11);
            if (!z10) {
                p(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i11);
                fileK.renameTo(fileJ);
                long j10 = dVar.f10378b[i11];
                long length = fileJ.length();
                dVar.f10378b[i11] = length;
                this.f10365h = (this.f10365h - j10) + length;
            }
        }
        this.f10368k++;
        dVar.f10382f = null;
        if (dVar.f10381e || z10) {
            dVar.f10381e = true;
            this.f10366i.append((CharSequence) "CLEAN");
            this.f10366i.append(' ');
            this.f10366i.append((CharSequence) dVar.f10377a);
            this.f10366i.append((CharSequence) dVar.l());
            this.f10366i.append('\n');
            if (z10) {
                long j11 = this.f10369l;
                this.f10369l = 1 + j11;
                dVar.f10383g = j11;
            }
        } else {
            this.f10367j.remove(dVar.f10377a);
            this.f10366i.append((CharSequence) "REMOVE");
            this.f10366i.append(' ');
            this.f10366i.append((CharSequence) dVar.f10377a);
            this.f10366i.append('\n');
        }
        s(this.f10366i);
        if (this.f10365h > this.f10363f || u()) {
            this.f10370m.submit(this.f10371n);
        }
    }

    private synchronized c r(String str, long j10) {
        l();
        d dVar = this.f10367j.get(str);
        a aVar = null;
        if (j10 != -1 && (dVar == null || dVar.f10383g != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.f10367j.put(str, dVar);
        } else if (dVar.f10382f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f10382f = cVar;
        this.f10366i.append((CharSequence) "DIRTY");
        this.f10366i.append(' ');
        this.f10366i.append((CharSequence) str);
        this.f10366i.append('\n');
        s(this.f10366i);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z() {
        try {
            Writer writer = this.f10366i;
            if (writer != null) {
                m(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10360c), g.d.f10396a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f10362e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f10364g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f10367j.values()) {
                    if (dVar.f10382f != null) {
                        bufferedWriter.write("DIRTY " + dVar.f10377a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f10377a + dVar.l() + '\n');
                    }
                }
                m(bufferedWriter);
                if (this.f10359b.exists()) {
                    B(this.f10359b, this.f10361d, true);
                }
                B(this.f10360c, this.f10359b, false);
                this.f10361d.delete();
                this.f10366i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10359b, true), g.d.f10396a));
            } catch (Throwable th) {
                m(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean A(String str) {
        try {
            l();
            d dVar = this.f10367j.get(str);
            if (dVar != null && dVar.f10382f == null) {
                for (int i10 = 0; i10 < this.f10364g; i10++) {
                    File fileJ = dVar.j(i10);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.f10365h -= dVar.f10378b[i10];
                    dVar.f10378b[i10] = 0;
                }
                this.f10368k++;
                this.f10366i.append((CharSequence) "REMOVE");
                this.f10366i.append(' ');
                this.f10366i.append((CharSequence) str);
                this.f10366i.append('\n');
                this.f10367j.remove(str);
                if (u()) {
                    this.f10370m.submit(this.f10371n);
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f10366i == null) {
                return;
            }
            for (d dVar : new ArrayList(this.f10367j.values())) {
                if (dVar.f10382f != null) {
                    dVar.f10382f.a();
                }
            }
            C();
            m(this.f10366i);
            this.f10366i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized e t(String str) {
        Throwable th;
        try {
            try {
                l();
                d dVar = this.f10367j.get(str);
                if (dVar == null) {
                    return null;
                }
                if (!dVar.f10381e) {
                    return null;
                }
                for (File file : dVar.f10379c) {
                    try {
                        if (!file.exists()) {
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                this.f10368k++;
                this.f10366i.append((CharSequence) "READ");
                this.f10366i.append(' ');
                this.f10366i.append((CharSequence) str);
                this.f10366i.append('\n');
                if (u()) {
                    this.f10370m.submit(this.f10371n);
                }
                return new e(this, str, dVar.f10383g, dVar.f10379c, dVar.f10378b, null);
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
        }
        throw th;
    }

    private b(File file, int i10, int i11, long j10) {
        this.f10358a = file;
        this.f10362e = i10;
        this.f10359b = new File(file, "journal");
        this.f10360c = new File(file, "journal.tmp");
        this.f10361d = new File(file, "journal.bkp");
        this.f10364g = i11;
        this.f10363f = j10;
    }

    private static void B(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        while (this.f10365h > this.f10363f) {
            A(this.f10367j.entrySet().iterator().next().getKey());
        }
    }

    private void l() {
        if (this.f10366i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void m(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @TargetApi(26)
    private static void s(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        int i10 = this.f10368k;
        return i10 >= 2000 && i10 >= this.f10367j.size();
    }

    public static b v(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                B(file2, file3, false);
            }
        }
        b bVar = new b(file, i10, i11, j10);
        if (bVar.f10359b.exists()) {
            try {
                bVar.x();
                bVar.w();
                return bVar;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                bVar.o();
            }
        }
        file.mkdirs();
        b bVar2 = new b(file, i10, i11, j10);
        bVar2.z();
        return bVar2;
    }

    private void w() throws IOException {
        p(this.f10360c);
        Iterator<d> it = this.f10367j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i10 = 0;
            if (next.f10382f == null) {
                while (i10 < this.f10364g) {
                    this.f10365h += next.f10378b[i10];
                    i10++;
                }
            } else {
                next.f10382f = null;
                while (i10 < this.f10364g) {
                    p(next.j(i10));
                    p(next.k(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    private void x() {
        g.c cVar = new g.c(new FileInputStream(this.f10359b), g.d.f10396a);
        try {
            String strD = cVar.d();
            String strD2 = cVar.d();
            String strD3 = cVar.d();
            String strD4 = cVar.d();
            String strD5 = cVar.d();
            if (!"libcore.io.DiskLruCache".equals(strD) || !"1".equals(strD2) || !Integer.toString(this.f10362e).equals(strD3) || !Integer.toString(this.f10364g).equals(strD4) || !"".equals(strD5)) {
                throw new IOException("unexpected journal header: [" + strD + ", " + strD2 + ", " + strD4 + ", " + strD5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    y(cVar.d());
                    i10++;
                } catch (EOFException unused) {
                    this.f10368k = i10 - this.f10367j.size();
                    if (cVar.c()) {
                        z();
                    } else {
                        this.f10366i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f10359b, true), g.d.f10396a));
                    }
                    g.d.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            g.d.a(cVar);
            throw th;
        }
    }

    private void y(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i10);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i10);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f10367j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        d dVar = this.f10367j.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, aVar);
            this.f10367j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f10381e = true;
            dVar.f10382f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f10382f = new c(this, dVar, aVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public c q(String str) {
        return r(str, -1L);
    }

    private static void p(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public void o() throws IOException {
        close();
        g.d.b(this.f10358a);
    }
}
