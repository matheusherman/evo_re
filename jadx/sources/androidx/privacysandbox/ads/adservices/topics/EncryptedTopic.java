package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@ExperimentalFeatures.Ext11OptIn
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/EncryptedTopic;", "", "encryptedTopic", "", "keyIdentifier", "", "encapsulatedKey", "([BLjava/lang/String;[B)V", "getEncapsulatedKey", "()[B", "getEncryptedTopic", "getKeyIdentifier", "()Ljava/lang/String;", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EncryptedTopic {

    /* JADX INFO: renamed from: encapsulatedKey, reason: from kotlin metadata and from toString */
    private final byte[] EncapsulatedKey;

    /* JADX INFO: renamed from: encryptedTopic, reason: from kotlin metadata and from toString */
    private final byte[] EncryptedTopic;

    /* JADX INFO: renamed from: keyIdentifier, reason: from kotlin metadata and from toString */
    private final String KeyIdentifier;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EncryptedTopic)) {
            return false;
        }
        EncryptedTopic encryptedTopic = (EncryptedTopic) other;
        return Arrays.equals(this.EncryptedTopic, encryptedTopic.EncryptedTopic) && this.KeyIdentifier.contentEquals(encryptedTopic.KeyIdentifier) && Arrays.equals(this.EncapsulatedKey, encryptedTopic.EncapsulatedKey);
    }

    public EncryptedTopic(byte[] encryptedTopic, String keyIdentifier, byte[] encapsulatedKey) {
        kotlin.jvm.internal.m.f(encryptedTopic, "encryptedTopic");
        kotlin.jvm.internal.m.f(keyIdentifier, "keyIdentifier");
        kotlin.jvm.internal.m.f(encapsulatedKey, "encapsulatedKey");
        this.EncryptedTopic = encryptedTopic;
        this.KeyIdentifier = keyIdentifier;
        this.EncapsulatedKey = encapsulatedKey;
    }

    public final byte[] getEncapsulatedKey() {
        return this.EncapsulatedKey;
    }

    public final byte[] getEncryptedTopic() {
        return this.EncryptedTopic;
    }

    public final String getKeyIdentifier() {
        return this.KeyIdentifier;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.EncryptedTopic)), this.KeyIdentifier, Integer.valueOf(Arrays.hashCode(this.EncapsulatedKey)));
    }

    public String toString() {
        return "EncryptedTopic { " + ("EncryptedTopic=" + ua.n.t(this.EncryptedTopic) + ", KeyIdentifier=" + this.KeyIdentifier + ", EncapsulatedKey=" + ua.n.t(this.EncapsulatedKey) + " }");
    }
}
