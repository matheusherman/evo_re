package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B#\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\u0010\bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "", "topics", "", "Landroidx/privacysandbox/ads/adservices/topics/Topic;", "(Ljava/util/List;)V", "encryptedTopics", "Landroidx/privacysandbox/ads/adservices/topics/EncryptedTopic;", "(Ljava/util/List;Ljava/util/List;)V", "getEncryptedTopics", "()Ljava/util/List;", "getTopics", "equals", "", TransactionPartnerType.OTHER, "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GetTopicsResponse {

    /* JADX INFO: renamed from: encryptedTopics, reason: from kotlin metadata and from toString */
    private final List<EncryptedTopic> EncryptedTopics;
    private final List<Topic> topics;

    @ExperimentalFeatures.Ext11OptIn
    public GetTopicsResponse(List<Topic> topics, List<EncryptedTopic> encryptedTopics) {
        kotlin.jvm.internal.m.f(topics, "topics");
        kotlin.jvm.internal.m.f(encryptedTopics, "encryptedTopics");
        this.topics = topics;
        this.EncryptedTopics = encryptedTopics;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetTopicsResponse)) {
            return false;
        }
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) other;
        return this.topics.size() == getTopicsResponse.topics.size() && this.EncryptedTopics.size() == getTopicsResponse.EncryptedTopics.size() && kotlin.jvm.internal.m.a(new HashSet(this.topics), new HashSet(getTopicsResponse.topics)) && kotlin.jvm.internal.m.a(new HashSet(this.EncryptedTopics), new HashSet(getTopicsResponse.EncryptedTopics));
    }

    public final List<EncryptedTopic> getEncryptedTopics() {
        return this.EncryptedTopics;
    }

    public final List<Topic> getTopics() {
        return this.topics;
    }

    public int hashCode() {
        return Objects.hash(this.topics, this.EncryptedTopics);
    }

    public String toString() {
        return "GetTopicsResponse: Topics=" + this.topics + ", EncryptedTopics=" + this.EncryptedTopics;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetTopicsResponse(List<Topic> topics) {
        this(topics, kotlin.collections.r.l());
        kotlin.jvm.internal.m.f(topics, "topics");
    }
}
