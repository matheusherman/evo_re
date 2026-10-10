package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class WebhookInfo implements Serializable {
    private static final long serialVersionUID = 0;
    private String[] allowed_updates;
    private Boolean has_custom_certificate;
    private String ip_address;
    private Integer last_error_date;
    private String last_error_message;
    private Integer last_synchronization_error_date;
    private Integer max_connections;
    private Integer pending_update_count;
    private String url;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            WebhookInfo webhookInfo = (WebhookInfo) obj;
            if (Objects.equals(this.url, webhookInfo.url) && Objects.equals(this.has_custom_certificate, webhookInfo.has_custom_certificate) && Objects.equals(this.pending_update_count, webhookInfo.pending_update_count) && Objects.equals(this.ip_address, webhookInfo.ip_address) && Objects.equals(this.last_error_date, webhookInfo.last_error_date) && Objects.equals(this.last_error_message, webhookInfo.last_error_message) && Objects.equals(this.last_synchronization_error_date, webhookInfo.last_synchronization_error_date) && Objects.equals(this.max_connections, webhookInfo.max_connections) && Arrays.equals(this.allowed_updates, webhookInfo.allowed_updates)) {
                return true;
            }
        }
        return false;
    }

    public String[] allowedUpdates() {
        return this.allowed_updates;
    }

    public Boolean hasCustomCertificate() {
        return this.has_custom_certificate;
    }

    public int hashCode() {
        return (Objects.hash(this.url, this.has_custom_certificate, this.pending_update_count, this.ip_address, this.last_error_date, this.last_error_message, this.last_synchronization_error_date, this.max_connections) * 31) + Arrays.hashCode(this.allowed_updates);
    }

    public String ipAddress() {
        return this.ip_address;
    }

    public Integer lastErrorDate() {
        return this.last_error_date;
    }

    public String lastErrorMessage() {
        return this.last_error_message;
    }

    public Integer lastSynchronizationErrorDate() {
        return this.last_synchronization_error_date;
    }

    public Integer maxConnections() {
        return this.max_connections;
    }

    public Integer pendingUpdateCount() {
        return this.pending_update_count;
    }

    public String toString() {
        return "WebhookInfo{url='" + this.url + "', has_custom_certificate=" + this.has_custom_certificate + ", pending_update_count=" + this.pending_update_count + ", ip_address='" + this.ip_address + "', last_error_date=" + this.last_error_date + ", last_error_message='" + this.last_error_message + "', last_synchronization_error_date=" + this.last_synchronization_error_date + ", max_connections=" + this.max_connections + ", allowed_updates=" + Arrays.toString(this.allowed_updates) + '}';
    }

    public String url() {
        return this.url;
    }
}
