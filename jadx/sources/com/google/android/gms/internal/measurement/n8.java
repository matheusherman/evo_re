package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n8;
import com.google.android.gms.internal.measurement.o8;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class n8<MessageType extends n8<MessageType, BuilderType>, BuilderType extends o8<MessageType, BuilderType>> implements ob {
    protected int zza = 0;

    void k(int i10) {
        throw new UnsupportedOperationException();
    }

    int l() {
        throw new UnsupportedOperationException();
    }

    protected static <T> void j(Iterable<T> iterable, List<? super T> list) {
        o8.l(iterable, list);
    }

    int f(fc fcVar) {
        int iL = l();
        if (iL == -1) {
            int iA = fcVar.a(this);
            k(iA);
            return iA;
        }
        return iL;
    }

    @Override // com.google.android.gms.internal.measurement.ob
    public final v8 h() {
        try {
            f9 f9VarT = v8.t(e());
            a(f9VarT.b());
            return f9VarT.a();
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e10);
        }
    }

    public final byte[] m() {
        try {
            byte[] bArr = new byte[e()];
            m9 m9VarH = m9.H(bArr);
            a(m9VarH);
            m9VarH.I();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e10);
        }
    }
}
