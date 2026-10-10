package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Venue implements Serializable {
    private static final long serialVersionUID = 0;
    private String address;
    private String foursquare_id;
    private String foursquare_type;
    private String google_place_id;
    private String google_place_type;
    private Location location;
    private String title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Venue venue = (Venue) obj;
            if (Objects.equals(this.location, venue.location) && Objects.equals(this.title, venue.title) && Objects.equals(this.address, venue.address) && Objects.equals(this.foursquare_id, venue.foursquare_id) && Objects.equals(this.foursquare_type, venue.foursquare_type) && Objects.equals(this.google_place_id, venue.google_place_id) && Objects.equals(this.google_place_type, venue.google_place_type)) {
                return true;
            }
        }
        return false;
    }

    public String address() {
        return this.address;
    }

    public String foursquareId() {
        return this.foursquare_id;
    }

    public String foursquareType() {
        return this.foursquare_type;
    }

    public String googlePlaceId() {
        return this.google_place_id;
    }

    public String googlePlaceType() {
        return this.google_place_type;
    }

    public int hashCode() {
        return Objects.hash(this.location, this.title, this.address, this.foursquare_id, this.foursquare_type, this.google_place_id, this.google_place_type);
    }

    public Location location() {
        return this.location;
    }

    public String title() {
        return this.title;
    }

    public String toString() {
        return "Venue{location=" + this.location + ", title='" + this.title + "', address='" + this.address + "', foursquare_id='" + this.foursquare_id + "', foursquare_type='" + this.foursquare_type + "', google_place_id='" + this.google_place_id + "', google_place_type='" + this.google_place_type + "'}";
    }
}
