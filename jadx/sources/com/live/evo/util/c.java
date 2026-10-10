package com.live.evo.util;

import android.view.KeyEvent;
import android.view.View;
import java.io.Closeable;
import java.security.InvalidParameterException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c implements View.OnKeyListener, Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f7185e = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static c f7186f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f7187g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f7188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7189b = 2000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7190c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7191d = 0;

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        return false;
    }

    public static c a() {
        if (f7186f == null) {
            synchronized (c.class) {
                try {
                    if (f7186f == null) {
                        f7186f = new c("5188");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f7186f;
    }

    public boolean b() {
        return f7187g;
    }

    protected c(String str) {
        this.f7188a = null;
        if (str != null && str.length() > 0) {
            this.f7188a = new int[str.length()];
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = charArray[i10] - '0';
                if (i12 >= 0 && i12 <= 9) {
                    this.f7188a[i11] = f7185e[i12];
                    i10++;
                    i11++;
                } else {
                    throw new InvalidParameterException(String.format("Invalid key[%s], only number[0...9] is accepted", str));
                }
            }
            return;
        }
        throw new InvalidParameterException("Empty key");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
