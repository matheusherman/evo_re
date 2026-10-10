package fc;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class s implements f, re.c {
    @Override // fc.f
    public abstract z f();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return f().t(((f) obj).f());
        }
        return false;
    }

    @Override // re.c
    public byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        f().q(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] k(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        f().r(byteArrayOutputStream, str);
        return byteArrayOutputStream.toByteArray();
    }

    public int hashCode() {
        return f().hashCode();
    }
}
