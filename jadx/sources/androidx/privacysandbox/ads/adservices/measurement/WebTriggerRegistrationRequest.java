package androidx.privacysandbox.ads.adservices.measurement;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerRegistrationRequest;", "", "webTriggerParams", "", "Landroidx/privacysandbox/ads/adservices/measurement/WebTriggerParams;", "destination", "Landroid/net/Uri;", "(Ljava/util/List;Landroid/net/Uri;)V", "getDestination", "()Landroid/net/Uri;", "getWebTriggerParams", "()Ljava/util/List;", "convertToAdServices", "Landroid/adservices/measurement/WebTriggerRegistrationRequest;", "convertToAdServices$ads_adservices_release", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebTriggerRegistrationRequest {

    /* JADX INFO: renamed from: destination, reason: from kotlin metadata and from toString */
    private final Uri Destination;
    private final List<WebTriggerParams> webTriggerParams;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebTriggerRegistrationRequest)) {
            return false;
        }
        WebTriggerRegistrationRequest webTriggerRegistrationRequest = (WebTriggerRegistrationRequest) other;
        return kotlin.jvm.internal.m.a(this.webTriggerParams, webTriggerRegistrationRequest.webTriggerParams) && kotlin.jvm.internal.m.a(this.Destination, webTriggerRegistrationRequest.Destination);
    }

    public WebTriggerRegistrationRequest(List<WebTriggerParams> webTriggerParams, Uri destination) {
        kotlin.jvm.internal.m.f(webTriggerParams, "webTriggerParams");
        kotlin.jvm.internal.m.f(destination, "destination");
        this.webTriggerParams = webTriggerParams;
        this.Destination = destination;
    }

    public final Uri getDestination() {
        return this.Destination;
    }

    public final List<WebTriggerParams> getWebTriggerParams() {
        return this.webTriggerParams;
    }

    public int hashCode() {
        return (this.webTriggerParams.hashCode() * 31) + this.Destination.hashCode();
    }

    public String toString() {
        return "WebTriggerRegistrationRequest { WebTriggerParams=" + this.webTriggerParams + ", Destination=" + this.Destination;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final android.adservices.measurement.WebTriggerRegistrationRequest convertToAdServices$ads_adservices_release() {
        l0.a();
        android.adservices.measurement.WebTriggerRegistrationRequest webTriggerRegistrationRequestBuild = k0.a(WebTriggerParams.INSTANCE.convertWebTriggerParams$ads_adservices_release(this.webTriggerParams), this.Destination).build();
        kotlin.jvm.internal.m.e(webTriggerRegistrationRequestBuild, "Builder(\n               …   )\n            .build()");
        return webTriggerRegistrationRequestBuild;
    }
}
