package com.pengrad.telegrambot.model.request;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class InputFile {
    private byte[] bytes;
    private String contentType;
    private File file;
    private String fileName;

    public InputFile(File file, String str, String str2) {
        this.file = file;
        this.fileName = str;
        this.contentType = str2;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public String getContentType() {
        return this.contentType;
    }

    public File getFile() {
        return this.file;
    }

    public String getFileName() {
        return this.fileName;
    }

    void setContentType(String str) {
        this.contentType = str;
    }

    void setFileName(String str) {
        this.fileName = str;
    }

    public InputFile(byte[] bArr, String str, String str2) {
        this.bytes = bArr;
        this.fileName = str;
        this.contentType = str2;
    }
}
