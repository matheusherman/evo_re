package com.pengrad.telegrambot.impl;

import com.google.gson.e;
import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.Cancellable;
import com.pengrad.telegrambot.model.request.InputFile;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.f;
import okhttp3.s;
import okhttp3.x;
import okhttp3.y;
import okhttp3.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class TelegramBotClient {
    private final String baseUrl;
    private final z client;
    private z clientWithTimeout;
    private final e gson;

    public <T extends BaseRequest<T, R>, R extends BaseResponse> Cancellable send(final T t10, final Callback<T, R> callback) {
        final okhttp3.e eVarA = getOkHttpClient(t10).a(createRequest(t10));
        eVarA.J(new f() { // from class: com.pengrad.telegrambot.impl.TelegramBotClient.1
            @Override // okhttp3.f
            public void onResponse(okhttp3.e eVar, d0 d0Var) {
                BaseResponse baseResponse = null;
                try {
                    BaseResponse baseResponse2 = (BaseResponse) TelegramBotClient.this.gson.n(d0Var.getBody().l(), t10.getResponseType());
                    e = null;
                    baseResponse = baseResponse2;
                } catch (Exception e10) {
                    e = e10;
                }
                if (baseResponse != null) {
                    callback.onResponse(t10, baseResponse);
                } else if (e != null) {
                    callback.onFailure(t10, e instanceof IOException ? (IOException) e : new IOException(e));
                } else {
                    callback.onFailure(t10, new IOException("Empty response"));
                }
            }

            @Override // okhttp3.f
            public void onFailure(okhttp3.e eVar, IOException iOException) {
                callback.onFailure(t10, iOException);
            }
        });
        return new Cancellable() { // from class: com.pengrad.telegrambot.impl.a
            @Override // com.pengrad.telegrambot.Cancellable
            public final void cancel() {
                eVarA.cancel();
            }
        };
    }

    private b0 createRequest(BaseRequest<?, ?> baseRequest) {
        return new b0.a().k(this.baseUrl + baseRequest.getMethod()).h(createRequestBody(baseRequest)).b();
    }

    public void shutdown() {
        this.client.getDispatcher().c().shutdown();
    }

    public TelegramBotClient(z zVar, e eVar, String str) {
        this.client = zVar;
        this.gson = eVar;
        this.baseUrl = str;
        this.clientWithTimeout = zVar;
    }

    private c0 createRequestBody(BaseRequest<?, ?> baseRequest) {
        c0 c0VarF;
        if (baseRequest.isMultipart()) {
            x xVarG = x.g(baseRequest.getContentType());
            y.a aVarF = new y.a().f(y.f16995l);
            for (Map.Entry<String, Object> entry : baseRequest.getParameters().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof byte[]) {
                    aVarF.b(key, baseRequest.getFileName(), c0.f((byte[]) value, xVarG));
                } else if (value instanceof File) {
                    aVarF.b(key, baseRequest.getFileName(), c0.c((File) value, xVarG));
                } else if (value instanceof InputFile) {
                    InputFile inputFile = (InputFile) value;
                    xVarG = x.g(inputFile.getContentType());
                    if (inputFile.getFile() != null) {
                        c0VarF = c0.c(inputFile.getFile(), xVarG);
                    } else {
                        c0VarF = c0.f(inputFile.getBytes(), xVarG);
                    }
                    aVarF.b(key, inputFile.getFileName(), c0VarF);
                } else {
                    aVarF.a(key, toParamValue(value));
                }
            }
            return aVarF.e();
        }
        s.a aVar = new s.a();
        for (Map.Entry<String, Object> entry2 : baseRequest.getParameters().entrySet()) {
            aVar.a(entry2.getKey(), toParamValue(entry2.getValue()));
        }
        return aVar.c();
    }

    private z getOkHttpClient(BaseRequest<?, ?> baseRequest) {
        int timeoutSeconds = baseRequest.getTimeoutSeconds() * 1000;
        if (this.client.getReadTimeoutMillis() != 0 && this.client.getReadTimeoutMillis() <= timeoutSeconds) {
            if (this.clientWithTimeout.getReadTimeoutMillis() > timeoutSeconds) {
                return this.clientWithTimeout;
            }
            z zVarC = this.client.C().P(timeoutSeconds + 1000, TimeUnit.MILLISECONDS).c();
            this.clientWithTimeout = zVarC;
            return zVarC;
        }
        return this.client;
    }

    private String toParamValue(Object obj) {
        if (!obj.getClass().isPrimitive() && !obj.getClass().isEnum() && !obj.getClass().getName().startsWith("java.lang")) {
            return this.gson.w(obj);
        }
        return String.valueOf(obj);
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> R send(BaseRequest<T, R> baseRequest) {
        try {
            return (R) this.gson.n(getOkHttpClient(baseRequest).a(createRequest(baseRequest)).execute().getBody().l(), baseRequest.getResponseType());
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }
}
