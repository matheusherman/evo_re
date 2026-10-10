package com.pengrad.telegrambot.request;

import c9.l;
import com.pengrad.telegrambot.request.AbstractMultipartRequest;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegate;
import com.pengrad.telegrambot.utility.kotlin.RequestParameterDelegateKt;
import i9.k;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002BO\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0002\u0010$J\u0013\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\"H\u0016R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00068GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001e\u001a\u00020\u00068GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010#¨\u0006("}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractMultipartRequest;", "REQ", "Lcom/pengrad/telegrambot/request/AbstractSendRequest;", "chatId", "", "channelUsername", "", "contentParameterName", "contentUrl", "contentFile", "Ljava/io/File;", "contentBytes", "", "defaultFileName", "defaultContentType", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;[BLjava/lang/String;Ljava/lang/String;)V", "getContentBytes", "()[B", "contentBytes$delegate", "Lcom/pengrad/telegrambot/utility/kotlin/RequestParameterDelegate;", "getContentFile", "()Ljava/io/File;", "contentFile$delegate", "contentType", "getContentMimeType", "()Ljava/lang/String;", "setContentType", "(Ljava/lang/String;)V", "getContentUrl", "contentUrl$delegate", "fileName", "getContentFileName", "setFileName", "isMultipartRequest", "", "()Z", "(Ljava/lang/String;)Lcom/pengrad/telegrambot/request/AbstractMultipartRequest;", "getContentType", "getFileName", "isMultipart", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractMultipartRequest<REQ extends AbstractMultipartRequest<REQ>> extends AbstractSendRequest<REQ> {
    static final /* synthetic */ k<Object>[] $$delegatedProperties = {c0.g(new w(AbstractMultipartRequest.class, "contentUrl", "getContentUrl()Ljava/lang/String;", 0)), c0.g(new w(AbstractMultipartRequest.class, "contentFile", "getContentFile()Ljava/io/File;", 0)), c0.g(new w(AbstractMultipartRequest.class, "contentBytes", "getContentBytes()[B", 0))};

    /* JADX INFO: renamed from: contentBytes$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate contentBytes;

    /* JADX INFO: renamed from: contentFile$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate contentFile;
    private String contentType;

    /* JADX INFO: renamed from: contentUrl$delegate, reason: from kotlin metadata */
    private final RequestParameterDelegate contentUrl;
    private String fileName;

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractMultipartRequest$contentType$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractMultipartRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractMultipartRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class AnonymousClass1 extends o implements l<REQ, z> {
        final /* synthetic */ String $contentType;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractMultipartRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str) {
            super(1);
            this.$contentType = str;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setContentType(this.$contentType);
        }
    }

    /* JADX INFO: renamed from: com.pengrad.telegrambot.request.AbstractMultipartRequest$fileName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pengrad/telegrambot/request/AbstractMultipartRequest;", "REQ", "Lr8/z;", "invoke", "(Lcom/pengrad/telegrambot/request/AbstractMultipartRequest;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    static final class C05791 extends o implements l<REQ, z> {
        final /* synthetic */ String $fileName;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AbstractMultipartRequest) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05791(String str) {
            super(1);
            this.$fileName = str;
        }

        public final void invoke(REQ applySelf) {
            m.f(applySelf, "$this$applySelf");
            applySelf.setFileName(this.$fileName);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractMultipartRequest(Long l10, String str, String contentParameterName, String str2, File file, byte[] bArr, String defaultFileName, String defaultContentType) {
        super(l10, str);
        m.f(contentParameterName, "contentParameterName");
        m.f(defaultFileName, "defaultFileName");
        m.f(defaultContentType, "defaultContentType");
        RequestParameterDelegate requestParameterDelegateOptionalRequestParameter$default = RequestParameterDelegateKt.optionalRequestParameter$default(str2, contentParameterName, null, 4, null);
        k<?>[] kVarArr = $$delegatedProperties;
        this.contentUrl = requestParameterDelegateOptionalRequestParameter$default.provideDelegate(this, kVarArr[0]);
        this.contentFile = RequestParameterDelegateKt.optionalRequestParameter$default(file, contentParameterName, null, 4, null).provideDelegate(this, kVarArr[1]);
        this.contentBytes = RequestParameterDelegateKt.optionalRequestParameter$default(bArr, contentParameterName, null, 4, null).provideDelegate(this, kVarArr[2]);
        String name = file != null ? file.getName() : null;
        this.fileName = name != null ? name : defaultFileName;
        this.contentType = defaultContentType;
    }

    public final REQ contentType(String contentType) {
        m.f(contentType, "contentType");
        return applySelf(new AnonymousClass1(contentType));
    }

    public final REQ fileName(String fileName) {
        m.f(fileName, "fileName");
        return applySelf(new C05791(fileName));
    }

    public final byte[] getContentBytes() {
        return (byte[]) this.contentBytes.getValue(this, $$delegatedProperties[2]);
    }

    public final File getContentFile() {
        return (File) this.contentFile.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX INFO: renamed from: getContentFileName, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: getContentMimeType, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public String getContentType() {
        return this.contentType;
    }

    public final String getContentUrl() {
        return (String) this.contentUrl.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public String getFileName() {
        return this.fileName;
    }

    public final void setContentType(String str) {
        m.f(str, "<set-?>");
        this.contentType = str;
    }

    public final void setFileName(String str) {
        m.f(str, "<set-?>");
        this.fileName = str;
    }

    @Override // com.pengrad.telegrambot.request.BaseRequest
    public boolean isMultipart() {
        return isMultipartRequest();
    }

    public boolean isMultipartRequest() {
        if (getContentFile() == null && getContentBytes() == null) {
            return false;
        }
        return true;
    }
}
