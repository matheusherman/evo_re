package com.pengrad.telegrambot;

import com.google.gson.e;
import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.impl.UpdatesHandler;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.utility.BotUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import okhttp3.w;
import okhttp3.z;
import sb.a;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class TelegramBot implements TelegramAware {
    private final TelegramBotClient api;
    private final FileApi fileApi;
    private final RequestPreprocessor requestPreprocessor;
    private final String token;
    private final UpdatesHandler updatesHandler;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class Builder {
        static final String API_URL = "https://api.telegram.org/bot";
        private TelegramBotClient api;
        private String apiUrl;
        private final String botToken;
        private FileApi fileApi;
        private String fileApiUrl;
        private z okHttpClient;
        private boolean useTestServer = false;
        private UpdatesHandler updatesHandler = new UpdatesHandler(100);
        private RequestPreprocessor requestPreprocessor = RequestPreprocessorKt.getEmptyRequestPreprocessor();

        public Builder apiUrl(String str) {
            this.apiUrl = str;
            return this;
        }

        private static String apiUrl(String str, String str2, boolean z10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
            sb2.append(z10 ? "/test/" : "/");
            return sb2.toString();
        }

        private static z client(w wVar) {
            z.a aVar = new z.a();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            z.a aVarP = aVar.d(75L, timeUnit).S(75L, timeUnit).P(75L, timeUnit);
            if (wVar != null) {
                aVarP.a(wVar);
            }
            return aVarP.c();
        }

        private static e gson() {
            return BotUtils.GSON;
        }

        private static w httpLoggingInterceptor() {
            return new a().e(a.EnumC0360a.BODY);
        }

        public TelegramBot build() {
            z zVarClient = this.okHttpClient;
            if (zVarClient != null || this.apiUrl != null) {
                if (zVarClient == null) {
                    zVarClient = client(null);
                }
                String str = this.apiUrl;
                if (str == null) {
                    str = API_URL;
                }
                this.api = new TelegramBotClient(zVarClient, gson(), apiUrl(str, this.botToken, this.useTestServer));
            }
            String str2 = this.fileApiUrl;
            if (str2 != null) {
                this.fileApi = new FileApi(str2, this.botToken);
            }
            return new TelegramBot(this);
        }

        public Builder fileApiUrl(String str) {
            this.fileApiUrl = str;
            return this;
        }

        public Builder okHttpClient(z zVar) {
            this.okHttpClient = zVar;
            return this;
        }

        public Builder requestPreprocessor(RequestPreprocessor requestPreprocessor) {
            this.requestPreprocessor = requestPreprocessor;
            return this;
        }

        public Builder updateListenerSleep(long j10) {
            this.updatesHandler = new UpdatesHandler(j10);
            return this;
        }

        public Builder useTestServer(boolean z10) {
            this.useTestServer = z10;
            return this;
        }

        public Builder(String str) {
            this.botToken = str;
            this.api = new TelegramBotClient(client(null), gson(), apiUrl(API_URL, str, this.useTestServer));
            this.fileApi = new FileApi(str);
        }

        public Builder debug() {
            this.okHttpClient = client(httpLoggingInterceptor());
            return this;
        }
    }

    public TelegramBot(String str) {
        this(new Builder(str));
    }

    @Override // com.pengrad.telegrambot.TelegramAware
    public <T extends BaseRequest<T, R>, R extends BaseResponse> R execute(BaseRequest<T, R> baseRequest) {
        this.requestPreprocessor.process(baseRequest);
        return (R) this.api.send(baseRequest);
    }

    public void setUpdatesListener(UpdatesListener updatesListener) {
        setUpdatesListener(updatesListener, new GetUpdates());
    }

    TelegramBot(Builder builder) {
        this.token = builder.botToken;
        this.api = builder.api;
        this.fileApi = builder.fileApi;
        this.updatesHandler = builder.updatesHandler;
        this.requestPreprocessor = builder.requestPreprocessor;
    }

    public String getFullFilePath(File file) {
        return this.fileApi.getFullFilePath(file.filePath());
    }

    public String getToken() {
        return this.token;
    }

    public void removeGetUpdatesListener() {
        this.updatesHandler.stop();
    }

    public void setUpdatesListener(UpdatesListener updatesListener, GetUpdates getUpdates) {
        setUpdatesListener(updatesListener, null, getUpdates);
    }

    public void shutdown() {
        this.api.shutdown();
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> Cancellable execute(T t10, Callback<T, R> callback) {
        this.requestPreprocessor.process(t10);
        return this.api.send(t10, callback);
    }

    public byte[] getFileContent(File file) throws IOException {
        InputStream inputStream = new URL(getFullFilePath(file)).openConnection().getInputStream();
        try {
            byte[] bytesFromInputStream = BotUtils.getBytesFromInputStream(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
            return bytesFromInputStream;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void setUpdatesListener(UpdatesListener updatesListener, ExceptionHandler exceptionHandler) {
        setUpdatesListener(updatesListener, exceptionHandler, new GetUpdates());
    }

    public void setUpdatesListener(UpdatesListener updatesListener, ExceptionHandler exceptionHandler, GetUpdates getUpdates) {
        this.updatesHandler.stop();
        this.updatesHandler.start(this, updatesListener, exceptionHandler, getUpdates);
    }
}
