package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.AttachName;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class InputPaidMedia implements Serializable {
    private static final long serialVersionUID = 0;
    protected transient Map<String, Object> attachments = new HashMap();
    private transient String contentType;
    private transient String fileName;
    private transient InputFile inputFile;
    private transient String inputFileAttachId;
    private final String media;
    private final String type;

    protected abstract String getDefaultContentType();

    protected abstract String getDefaultFileName();

    public Map<String, Object> getAttachments() {
        return this.attachments;
    }

    public String getContentType() {
        String str = this.contentType;
        return (str == null || str.isEmpty()) ? getDefaultContentType() : this.contentType;
    }

    public String getFileName() {
        String str = this.fileName;
        return (str == null || str.isEmpty()) ? getDefaultFileName() : this.fileName;
    }

    public String getInputFileId() {
        return this.inputFileAttachId;
    }

    public InputFile inputFile() {
        return this.inputFile;
    }

    InputPaidMedia(String str, Object obj) {
        this.type = str;
        if (obj instanceof String) {
            this.media = (String) obj;
            return;
        }
        String next = AttachName.next();
        this.media = "attach://" + next;
        this.inputFileAttachId = next;
        if (obj instanceof File) {
            File file = (File) obj;
            this.fileName = file.getName();
            this.inputFile = new InputFile(file, getFileName(), getContentType());
        } else if (obj instanceof byte[]) {
            this.inputFile = new InputFile((byte[]) obj, getFileName(), getContentType());
        }
    }

    protected String addAttachment(Object obj) {
        String next = AttachName.next();
        this.attachments.put(next, obj);
        return "attach://" + next;
    }
}
