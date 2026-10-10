package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.request.AbstractThumbnailedMultipartRequest;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002BO\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\u0013\u0010!\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\n¢\u0006\u0002\u0010\"J\u0013\u0010!\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\f¢\u0006\u0002\u0010#R\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R/\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R/\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "REQ", "Lcom/pengrad/telegrambot/request/AbstractMultipartRequest;", "chatId", "", "channelUsername", "", "contentParameterName", "contentUrl", "contentFile", "Ljava/io/File;", "contentBytes", "", "defaultFileName", "defaultContentType", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;[BLjava/lang/String;Ljava/lang/String;)V", "isMultipartRequest", "", "()Z", "<set-?>", "thumbnailBytes", "getThumbnailBytes", "()[B", "setThumbnailBytes", "([B)V", "thumbnailBytes$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "thumbnailFile", "getThumbnailFile", "()Ljava/io/File;", "setThumbnailFile", "(Ljava/io/File;)V", "thumbnailFile$delegate", "thumbnail", "(Ljava/io/File;)Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "([B)Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractThumbnailedMultipartRequest<REQ extends AbstractThumbnailedMultipartRequest<REQ>> extends AbstractMultipartRequest<REQ> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.e(new q(AbstractThumbnailedMultipartRequest.class, "thumbnailFile", "getThumbnailFile()Ljava/io/File;", 0)), c0.e(new q(AbstractThumbnailedMultipartRequest.class, "thumbnailBytes", "getThumbnailBytes()[B", 0))};

    /* JADX INFO: renamed from: thumbnailBytes$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate thumbnailBytes;

    /* JADX INFO: renamed from: thumbnailFile$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate thumbnailFile;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractThumbnailedMultipartRequest$thumbnail$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass1 extends o implements l<REQ, z> {
        final /* synthetic */ File $thumbnail;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractThumbnailedMultipartRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(File file) {
            super(1);
            this.$thumbnail = file;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setThumbnailFile(this.$thumbnail);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractThumbnailedMultipartRequest$thumbnail$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractThumbnailedMultipartRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass2 extends o implements l<REQ, z> {
        final /* synthetic */ byte[] $thumbnail;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractThumbnailedMultipartRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(byte[] bArr) {
            super(1);
            this.$thumbnail = bArr;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setThumbnailBytes(this.$thumbnail);
        }
    }

    public final REQ thumbnail(File thumbnail) {
        m.f(thumbnail, "thumbnail");
        return applySelf(new AnonymousClass1(thumbnail));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractThumbnailedMultipartRequest(Long l10, String str, String contentParameterName, String str2, File file, byte[] bArr, String defaultFileName, String defaultContentType) {
        super(l10, str, contentParameterName, str2, file, bArr, defaultFileName, defaultContentType);
        m.f(contentParameterName, "contentParameterName");
        m.f(defaultFileName, "defaultFileName");
        m.f(defaultContentType, "defaultContentType");
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(null, "thumbnail", null, 5, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.thumbnailFile = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.thumbnailBytes = RequestParameterDelegateKt.optionalRequestParameter$default(null, "thumbnail", null, 5, null).provideDelegate(this, kVarArr[1]);
    }

    public final byte[] getThumbnailBytes() {
        return (byte[]) this.thumbnailBytes.getValue(this, $$delegatedProperties[1]);
    }

    public final File getThumbnailFile() {
        return (File) this.thumbnailFile.getValue(this, $$delegatedProperties[0]);
    }

    public final void setThumbnailBytes(byte[] bArr) {
        this.thumbnailBytes.setValue(this, $$delegatedProperties[1], bArr);
    }

    public final void setThumbnailFile(File file) {
        this.thumbnailFile.setValue(this, $$delegatedProperties[0], file);
    }

    public final REQ thumbnail(byte[] thumbnail) {
        m.f(thumbnail, "thumbnail");
        return applySelf(new AnonymousClass2(thumbnail));
    }

    @Override // com.pengrad.telegrambot.request.AbstractMultipartRequest
    public boolean isMultipartRequest() {
        if (!super.isMultipartRequest() && getThumbnailFile() == null && getThumbnailBytes() == null) {
            return false;
        }
        return true;
    }
}
