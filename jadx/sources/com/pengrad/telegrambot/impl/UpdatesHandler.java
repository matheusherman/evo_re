package com.pengrad.telegrambot.impl;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.Cancellable;
import com.pengrad.telegrambot.ExceptionHandler;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramException;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class UpdatesHandler {
    private TelegramBot bot;
    private ExceptionHandler exceptionHandler;
    private UpdatesListener listener;
    private Cancellable pendingRequest;
    private final long sleepTimeout;

    public void stop() {
        this.bot = null;
        this.listener = null;
        this.exceptionHandler = null;
        Cancellable cancellable = this.pendingRequest;
        if (cancellable != null) {
            cancellable.cancel();
            this.pendingRequest = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUpdates(GetUpdates getUpdates) {
        TelegramBot telegramBot = this.bot;
        if (telegramBot == null || this.listener == null) {
            return;
        }
        this.pendingRequest = telegramBot.execute(getUpdates, new Callback<GetUpdates, GetUpdatesResponse>() { // from class: com.pengrad.telegrambot.impl.UpdatesHandler.1
            @Override // com.pengrad.telegrambot.Callback
            public void onFailure(GetUpdates getUpdates2, IOException iOException) {
                if (iOException.getMessage().equals("Canceled")) {
                    return;
                }
                if (UpdatesHandler.this.exceptionHandler != null) {
                    UpdatesHandler.this.exceptionHandler.onException(new TelegramException(iOException));
                } else {
                    Logger.getGlobal().log(Level.INFO, "Update listener failure", (Throwable) iOException);
                }
                UpdatesHandler.this.sleep();
                UpdatesHandler.this.getUpdates(getUpdates2);
            }

            @Override // com.pengrad.telegrambot.Callback
            public void onResponse(GetUpdates getUpdates2, GetUpdatesResponse getUpdatesResponse) {
                if (UpdatesHandler.this.listener == null) {
                    return;
                }
                if (getUpdatesResponse.isOk() && getUpdatesResponse.updates() != null && getUpdatesResponse.updates().size() > 0) {
                    List<Update> listUpdates = getUpdatesResponse.updates();
                    if (listUpdates == null) {
                        listUpdates = Collections.EMPTY_LIST;
                    }
                    int iProcess = UpdatesHandler.this.listener.process(listUpdates);
                    if (iProcess != -2) {
                        getUpdates2 = getUpdates2.offset(iProcess == -1 ? UpdatesHandler.this.lastUpdateId(listUpdates) + 1 : iProcess + 1);
                    }
                    UpdatesHandler.this.getUpdates(getUpdates2);
                    return;
                }
                if (!getUpdatesResponse.isOk()) {
                    if (UpdatesHandler.this.exceptionHandler != null) {
                        UpdatesHandler.this.exceptionHandler.onException(new TelegramException("GetUpdates failed with error_code " + getUpdatesResponse.errorCode() + " " + getUpdatesResponse.description(), getUpdatesResponse));
                    } else {
                        Logger.getGlobal().log(Level.INFO, "Update listener error for request " + getUpdates2.toWebhookResponse() + " with response " + getUpdatesResponse.errorCode() + " " + getUpdatesResponse.description());
                    }
                }
                UpdatesHandler.this.sleep();
                UpdatesHandler.this.getUpdates(getUpdates2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sleep() {
        long j10 = this.sleepTimeout;
        if (j10 <= 0) {
            return;
        }
        try {
            Thread.sleep(j10);
        } catch (InterruptedException unused) {
        }
    }

    public void start(TelegramBot telegramBot, UpdatesListener updatesListener, ExceptionHandler exceptionHandler, GetUpdates getUpdates) {
        this.bot = telegramBot;
        this.listener = updatesListener;
        this.exceptionHandler = exceptionHandler;
        getUpdates(getUpdates);
    }

    public UpdatesHandler(long j10) {
        this.sleepTimeout = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lastUpdateId(List<Update> list) {
        return list.get(list.size() - 1).updateId().intValue();
    }
}
