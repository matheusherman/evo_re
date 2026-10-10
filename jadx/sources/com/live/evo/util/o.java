package com.live.evo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final okhttp3.z f7300a = u0.b().c();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements okhttp3.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f7302b;

        a(b bVar, File file) {
            this.f7301a = bVar;
            this.f7302b = file;
        }

        @Override // okhttp3.f
        public void onFailure(okhttp3.e eVar, IOException iOException) {
            b bVar = this.f7301a;
            if (bVar != null) {
                bVar.a(iOException);
            }
        }

        @Override // okhttp3.f
        public void onResponse(okhttp3.e eVar, okhttp3.d0 d0Var) throws Throwable {
            FileOutputStream fileOutputStream;
            byte[] bArr = new byte[2048];
            InputStream inputStream = null;
            try {
                InputStream inputStreamA = d0Var.getBody().a();
                try {
                    long contentLength = d0Var.getBody().getContentLength();
                    yb.c.h(this.f7302b);
                    fileOutputStream = new FileOutputStream(this.f7302b);
                    long j10 = 0;
                    while (true) {
                        try {
                            int i10 = inputStreamA.read(bArr);
                            if (i10 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i10);
                            j10 += (long) i10;
                            if (contentLength > 0) {
                                int i11 = (int) (((j10 * 1.0f) / contentLength) * 100.0f);
                                b bVar = this.f7301a;
                                if (bVar != null) {
                                    bVar.c(i11);
                                }
                            }
                        } catch (Exception e10) {
                            e = e10;
                            inputStream = inputStreamA;
                            try {
                                b bVar2 = this.f7301a;
                                if (bVar2 != null) {
                                    bVar2.a(e);
                                }
                                yb.c.h(this.f7302b);
                                yb.e.b(inputStream);
                            } catch (Throwable th) {
                                th = th;
                                yb.e.b(inputStream);
                                yb.e.c(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStreamA;
                            yb.e.b(inputStream);
                            yb.e.c(fileOutputStream);
                            throw th;
                        }
                    }
                    fileOutputStream.flush();
                    b bVar3 = this.f7301a;
                    if (bVar3 != null) {
                        bVar3.b(this.f7302b.getAbsolutePath());
                    }
                    yb.e.b(inputStreamA);
                } catch (Exception e11) {
                    e = e11;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (Exception e12) {
                e = e12;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            yb.e.c(fileOutputStream);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
        void a(Throwable th);

        void b(String str);

        void c(int i10);
    }

    public static void a(String str, File file, boolean z10, b bVar) {
        okhttp3.b0 b0VarB = new okhttp3.b0.a().k(str).b();
        a aVar = new a(bVar, file);
        if (z10) {
            f7300a.a(b0VarB).J(aVar);
            return;
        }
        okhttp3.e eVarA = f7300a.a(b0VarB);
        try {
            aVar.onResponse(eVarA, eVarA.execute());
        } catch (IOException e10) {
            aVar.onFailure(eVarA, e10);
        }
    }
}
