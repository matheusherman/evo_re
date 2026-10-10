package com.pengrad.telegrambot.model.story.area.type;

import com.pengrad.telegrambot.model.LocationAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\f¨\u0006\r"}, d2 = {"Lcom/pengrad/telegrambot/model/story/area/type/StoryAreaTypeLocation;", "Lcom/pengrad/telegrambot/model/story/area/type/StoryAreaType;", "latitude", "", "longitude", "(DD)V", "address", "Lcom/pengrad/telegrambot/model/LocationAddress;", "(DDLcom/pengrad/telegrambot/model/LocationAddress;)V", "()Lcom/pengrad/telegrambot/model/LocationAddress;", "setAddress", "(Lcom/pengrad/telegrambot/model/LocationAddress;)V", "()D", "library"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StoryAreaTypeLocation extends StoryAreaType {
    private LocationAddress address;
    private final double latitude;
    private final double longitude;

    private StoryAreaTypeLocation(double d10, double d11, LocationAddress locationAddress) {
        super("location");
        this.latitude = d10;
        this.longitude = d11;
        this.address = locationAddress;
    }

    /* JADX INFO: renamed from: address, reason: from getter */
    public final LocationAddress getAddress() {
        return this.address;
    }

    public final StoryAreaTypeLocation address(LocationAddress address) {
        m.f(address, "address");
        this.address = address;
        return this;
    }

    /* JADX INFO: renamed from: latitude, reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* JADX INFO: renamed from: longitude, reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    public final void setAddress(LocationAddress locationAddress) {
        this.address = locationAddress;
    }

    public StoryAreaTypeLocation(double d10, double d11) {
        this(d10, d11, null);
    }
}
