package x1.f1.lb.cache;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import x1.f1.lb.util.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class b implements Closeable {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final Pattern f20600p = Pattern.compile("[a-z0-9_-]{1,64}");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final OutputStream f20601q = new C0411b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f20603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f20604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f20605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f20606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f20607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f20608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f20609h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Writer f20611j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f20613l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6.b f20602a = q6.c.d(b.class);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f20610i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LinkedHashMap<String, d> f20612k = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f20614m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final ThreadPoolExecutor f20615n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Callable<Void> f20616o = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Callable<Void> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (b.this) {
                try {
                    if (b.this.f20611j == null) {
                        return null;
                    }
                    b.this.C();
                    if (b.this.u()) {
                        b.this.z();
                        b.this.f20613l = 0;
                    }
                } catch (IOException e10) {
                    b.this.f20602a.error("cache cleanup callable failure", e10);
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f20618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f20619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f20620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f20621d;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        private class a extends FilterOutputStream {
            /* synthetic */ a(c cVar, OutputStream outputStream, x1.f1.lb.cache.c cVar2) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i10) {
                try {
                    ((FilterOutputStream) this).out.write(i10);
                } catch (IOException unused) {
                    c.this.f20620c = true;
                }
            }

            private a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    c.this.f20620c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    c.this.f20620c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i10, int i11) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i10, i11);
                } catch (IOException unused) {
                    c.this.f20620c = true;
                }
            }
        }

        /* synthetic */ c(b bVar, d dVar, x1.f1.lb.cache.c cVar) {
            this(dVar);
        }

        private c(d dVar) {
            this.f20618a = dVar;
            this.f20619b = dVar.f20626c ? null : new boolean[b.this.f20609h];
        }

        public void d() {
            b.this.o(this, false);
        }

        public void e() {
            if (this.f20620c) {
                b.this.o(this, false);
                b.this.A(this.f20618a.f20624a);
            } else {
                b.this.o(this, true);
            }
            this.f20621d = true;
        }

        public OutputStream f(int i10) {
            FileOutputStream fileOutputStream;
            a aVar;
            synchronized (b.this) {
                try {
                    if (this.f20618a.f20627d != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f20618a.f20626c) {
                        this.f20619b[i10] = true;
                    }
                    File fileK = this.f20618a.k(i10);
                    try {
                        fileOutputStream = new FileOutputStream(fileK);
                    } catch (FileNotFoundException unused) {
                        b.this.f20603b.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(fileK);
                        } catch (FileNotFoundException unused2) {
                            return b.f20601q;
                        }
                    }
                    aVar = new a(this, fileOutputStream, null);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f20625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f20626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f20627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f20628e;

        /* synthetic */ d(b bVar, String str, x1.f1.lb.cache.c cVar) {
            this(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != b.this.f20609h) {
                throw m(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f20625b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        private d(String str) {
            this.f20624a = str;
            this.f20625b = new long[b.this.f20609h];
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File j(int i10) {
            return new File(b.this.f20603b, this.f20624a + "." + i10);
        }

        public File k(int i10) {
            return new File(b.this.f20603b, this.f20624a + "." + i10 + ".tmp");
        }

        public String l() {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f20625b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public final class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f20631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final InputStream[] f20632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f20633d;

        /* synthetic */ e(b bVar, String str, long j10, InputStream[] inputStreamArr, long[] jArr, x1.f1.lb.cache.c cVar) {
            this(str, j10, inputStreamArr, jArr);
        }

        private e(String str, long j10, InputStream[] inputStreamArr, long[] jArr) {
            this.f20630a = str;
            this.f20631b = j10;
            this.f20632c = inputStreamArr;
            this.f20633d = jArr;
        }

        public InputStream a(int i10) {
            return this.f20632c[i10];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f20632c) {
                x1.f1.lb.cache.e.a(inputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o(c cVar, boolean z10) {
        d dVar = cVar.f20618a;
        if (dVar.f20627d != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f20626c) {
            for (int i10 = 0; i10 < this.f20609h; i10++) {
                if (!cVar.f20619b[i10]) {
                    cVar.d();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!dVar.k(i10).exists()) {
                    cVar.d();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f20609h; i11++) {
            File fileK = dVar.k(i11);
            if (!z10) {
                q(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i11);
                fileK.renameTo(fileJ);
                long j10 = dVar.f20625b[i11];
                long length = fileJ.length();
                dVar.f20625b[i11] = length;
                this.f20610i = (this.f20610i - j10) + length;
            }
        }
        this.f20613l++;
        dVar.f20627d = null;
        if (dVar.f20626c || z10) {
            dVar.f20626c = true;
            this.f20611j.write("CLEAN " + dVar.f20624a + dVar.l() + '\n');
            if (z10) {
                long j11 = this.f20614m;
                this.f20614m = 1 + j11;
                dVar.f20628e = j11;
            }
        } else {
            this.f20612k.remove(dVar.f20624a);
            this.f20611j.write("REMOVE " + dVar.f20624a + '\n');
        }
        this.f20611j.flush();
        if (this.f20610i > this.f20608g || u()) {
            this.f20615n.submit(this.f20616o);
        }
    }

    private synchronized c s(String str, long j10) {
        n();
        String strF = F(str);
        d dVar = this.f20612k.get(strF);
        x1.f1.lb.cache.c cVar = null;
        if (j10 != -1 && (dVar == null || dVar.f20628e != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, strF, cVar);
            this.f20612k.put(strF, dVar);
        } else if (dVar.f20627d != null) {
            return null;
        }
        c cVar2 = new c(this, dVar, cVar);
        dVar.f20627d = cVar2;
        this.f20611j.write("DIRTY " + strF + '\n');
        this.f20611j.flush();
        return cVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z() {
        try {
            Writer writer = this.f20611j;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f20605d), x1.f1.lb.cache.e.f20641a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f20607f));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f20609h));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f20612k.values()) {
                    if (dVar.f20627d != null) {
                        bufferedWriter.write("DIRTY " + dVar.f20624a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f20624a + dVar.l() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f20604c.exists()) {
                    B(this.f20604c, this.f20606e, true);
                }
                B(this.f20605d, this.f20604c, false);
                this.f20606e.delete();
                this.f20611j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f20604c, true), x1.f1.lb.cache.e.f20641a));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean A(String str) {
        try {
            n();
            String strF = F(str);
            d dVar = this.f20612k.get(strF);
            if (dVar != null && dVar.f20627d == null) {
                for (int i10 = 0; i10 < this.f20609h; i10++) {
                    File fileJ = dVar.j(i10);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.f20610i -= dVar.f20625b[i10];
                    dVar.f20625b[i10] = 0;
                }
                this.f20613l++;
                this.f20611j.append((CharSequence) ("REMOVE " + strF + '\n'));
                this.f20612k.remove(strF);
                if (u()) {
                    this.f20615n.submit(this.f20616o);
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
            if (this.f20611j == null) {
                return;
            }
            for (d dVar : new ArrayList(this.f20612k.values())) {
                if (dVar.f20627d != null) {
                    dVar.f20627d.d();
                }
            }
            C();
            this.f20611j.close();
            this.f20611j = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() {
        n();
        C();
        this.f20611j.flush();
    }

    public synchronized long size() {
        return this.f20610i;
    }

    public synchronized e t(String str) throws Throwable {
        InputStream inputStream;
        n();
        String strF = F(str);
        d dVar = this.f20612k.get(strF);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f20626c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f20609h];
        for (int i10 = 0; i10 < this.f20609h; i10++) {
            try {
                try {
                    try {
                        inputStreamArr[i10] = new FileInputStream(dVar.j(i10));
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (FileNotFoundException unused) {
                    for (int i11 = 0; i11 < this.f20609h && (inputStream = inputStreamArr[i11]) != null; i11++) {
                        x1.f1.lb.cache.e.a(inputStream);
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.f20613l++;
        this.f20611j.append((CharSequence) ("READ " + strF + '\n'));
        if (u()) {
            this.f20615n.submit(this.f20616o);
        }
        try {
            return new e(this, strF, dVar.f20628e, inputStreamArr, dVar.f20625b, null);
        } catch (Throwable th3) {
            th = th3;
        }
        throw th;
    }

    /* JADX INFO: renamed from: x1.f1.lb.cache.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0411b extends OutputStream {
        C0411b() {
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
        }
    }

    private static void B(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            q(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        while (this.f20610i > this.f20608g) {
            A(this.f20612k.entrySet().iterator().next().getKey());
        }
    }

    private String F(String str) {
        return !f20600p.matcher(str).matches() ? n.n().o(str) : str;
    }

    private void n() {
        if (this.f20611j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        int i10 = this.f20613l;
        return i10 >= 2000 && i10 >= this.f20612k.size();
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
        if (bVar.f20604c.exists()) {
            try {
                bVar.x();
                bVar.w();
                bVar.f20611j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(bVar.f20604c, true), x1.f1.lb.cache.e.f20641a));
                return bVar;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                bVar.p();
            }
        }
        file.mkdirs();
        b bVar2 = new b(file, i10, i11, j10);
        bVar2.z();
        return bVar2;
    }

    private void w() throws IOException {
        q(this.f20605d);
        Iterator<d> it = this.f20612k.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i10 = 0;
            if (next.f20627d == null) {
                while (i10 < this.f20609h) {
                    this.f20610i += next.f20625b[i10];
                    i10++;
                }
            } else {
                next.f20627d = null;
                while (i10 < this.f20609h) {
                    q(next.j(i10));
                    q(next.k(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    private void x() {
        x1.f1.lb.cache.d dVar = new x1.f1.lb.cache.d(new FileInputStream(this.f20604c), x1.f1.lb.cache.e.f20641a);
        try {
            String strC = dVar.c();
            String strC2 = dVar.c();
            String strC3 = dVar.c();
            String strC4 = dVar.c();
            String strC5 = dVar.c();
            if (!"libcore.io.DiskLruCache".equals(strC) || !"1".equals(strC2) || !Integer.toString(this.f20607f).equals(strC3) || !Integer.toString(this.f20609h).equals(strC4) || !"".equals(strC5)) {
                throw new IOException("unexpected journal header: [" + strC + ", " + strC2 + ", " + strC4 + ", " + strC5 + "]");
            }
            int i10 = 0;
            while (true) {
                try {
                    y(dVar.c());
                    i10++;
                } catch (EOFException unused) {
                    this.f20613l = i10 - this.f20612k.size();
                    x1.f1.lb.cache.e.a(dVar);
                    return;
                }
            }
        } catch (Throwable th) {
            x1.f1.lb.cache.e.a(dVar);
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
                this.f20612k.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        d dVar = this.f20612k.get(strSubstring);
        x1.f1.lb.cache.c cVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, cVar);
            this.f20612k.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f20626c = true;
            dVar.f20627d = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f20627d = new c(this, dVar, cVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public c r(String str) {
        return s(str, -1L);
    }

    private b(File file, int i10, int i11, long j10) {
        this.f20603b = file;
        this.f20607f = i10;
        this.f20604c = new File(file, "journal");
        this.f20605d = new File(file, "journal.tmp");
        this.f20606e = new File(file, "journal.bkp");
        this.f20609h = i11;
        this.f20608g = j10;
    }

    private static void q(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public void p() throws IOException {
        close();
        x1.f1.lb.cache.e.b(this.f20603b);
    }
}
