package com.pengrad.telegrambot.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class FileApi {
    public static final String FILE_API = "https://api.telegram.org/file/bot";
    private final String apiUrl;

    public FileApi(String str) {
        this(FILE_API, str);
    }

    public FileApi(String str, String str2) {
        this.apiUrl = str + str2 + "/";
    }

    public String getFullFilePath(String str) {
        int iLastIndexOf = str.lastIndexOf(47) + 1;
        try {
            return this.apiUrl + str.substring(0, iLastIndexOf) + URLEncoder.encode(str.substring(iLastIndexOf), "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException unused) {
            return this.apiUrl + str;
        }
    }
}
