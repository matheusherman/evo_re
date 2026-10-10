package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class b<MessageType extends q> implements s<MessageType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f13626a = g.c();

    private MessageType e(MessageType messagetype) throws k {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw f(messagetype).a().i(messagetype);
    }

    private w f(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).b() : new w(messagetype);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public MessageType c(InputStream inputStream, g gVar) {
        return (MessageType) e(j(inputStream, gVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public MessageType a(InputStream inputStream, g gVar) {
        return (MessageType) e(k(inputStream, gVar));
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public MessageType d(d dVar, g gVar) {
        return (MessageType) e(l(dVar, gVar));
    }

    public MessageType j(InputStream inputStream, g gVar) throws k {
        try {
            int i10 = inputStream.read();
            if (i10 == -1) {
                return null;
            }
            return (MessageType) k(new a.AbstractC0243a.C0244a(inputStream, e.B(i10, inputStream)), gVar);
        } catch (IOException e10) {
            throw new k(e10.getMessage());
        }
    }

    public MessageType k(InputStream inputStream, g gVar) throws k {
        e eVarG = e.g(inputStream);
        MessageType messagetypeB = b(eVarG, gVar);
        try {
            eVarG.a(0);
            return messagetypeB;
        } catch (k e10) {
            throw e10.i(messagetypeB);
        }
    }

    public MessageType l(d dVar, g gVar) throws k {
        e eVarT = dVar.t();
        MessageType messagetypeB = b(eVarT, gVar);
        try {
            eVarT.a(0);
            return messagetypeB;
        } catch (k e10) {
            throw e10.i(messagetypeB);
        }
    }
}
