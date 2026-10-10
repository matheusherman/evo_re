package com.pengrad.telegrambot.model;

import com.pengrad.telegrambot.model.checklist.Checklist;
import com.pengrad.telegrambot.model.giveaway.Giveaway;
import com.pengrad.telegrambot.model.giveaway.GiveawayWinners;
import com.pengrad.telegrambot.model.message.origin.MessageOrigin;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaInfo;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class ExternalReplyInfo implements Serializable {
    private static final long serialVersionUID = 0;
    private Animation animation;
    private Audio audio;
    private Chat chat;
    private Checklist checklist;
    private Contact contact;
    private Dice dice;
    private Document document;
    private Game game;
    private Giveaway giveaway;
    private GiveawayWinners giveaway_winners;
    private Boolean has_media_spoiler;
    private Invoice invoice;
    private LinkPreviewOptions link_preview_options;
    private Location location;
    private Integer message_id;
    private MessageOrigin origin;
    private PaidMediaInfo paid_media;
    private PhotoSize[] photo;
    private Poll poll;
    private Sticker sticker;
    private Story story;
    private Venue venue;
    private Video video;
    private VideoNote video_note;
    private Voice voice;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ExternalReplyInfo externalReplyInfo = (ExternalReplyInfo) obj;
            if (Objects.equals(this.origin, externalReplyInfo.origin) && Objects.equals(this.chat, externalReplyInfo.chat) && Objects.equals(this.message_id, externalReplyInfo.message_id) && Objects.equals(this.link_preview_options, externalReplyInfo.link_preview_options) && Objects.equals(this.animation, externalReplyInfo.animation) && Objects.equals(this.audio, externalReplyInfo.audio) && Objects.equals(this.paid_media, externalReplyInfo.paid_media) && Objects.equals(this.document, externalReplyInfo.document) && Arrays.equals(this.photo, externalReplyInfo.photo) && Objects.equals(this.sticker, externalReplyInfo.sticker) && Objects.equals(this.story, externalReplyInfo.story) && Objects.equals(this.video, externalReplyInfo.video) && Objects.equals(this.video_note, externalReplyInfo.video_note) && Objects.equals(this.voice, externalReplyInfo.voice) && Objects.equals(this.has_media_spoiler, externalReplyInfo.has_media_spoiler) && Objects.equals(this.checklist, externalReplyInfo.checklist) && Objects.equals(this.contact, externalReplyInfo.contact) && Objects.equals(this.dice, externalReplyInfo.dice) && Objects.equals(this.game, externalReplyInfo.game) && Objects.equals(this.giveaway, externalReplyInfo.giveaway) && Objects.equals(this.giveaway_winners, externalReplyInfo.giveaway_winners) && Objects.equals(this.invoice, externalReplyInfo.invoice) && Objects.equals(this.location, externalReplyInfo.location) && Objects.equals(this.poll, externalReplyInfo.poll) && Objects.equals(this.venue, externalReplyInfo.venue)) {
                return true;
            }
        }
        return false;
    }

    public Animation animation() {
        return this.animation;
    }

    public Audio audio() {
        return this.audio;
    }

    public Chat chat() {
        return this.chat;
    }

    public Checklist checklist() {
        return this.checklist;
    }

    public Contact contact() {
        return this.contact;
    }

    public Dice dice() {
        return this.dice;
    }

    public Document document() {
        return this.document;
    }

    public Game game() {
        return this.game;
    }

    public Giveaway giveaway() {
        return this.giveaway;
    }

    public GiveawayWinners giveawayWinners() {
        return this.giveaway_winners;
    }

    public Boolean hasMediaSpoiler() {
        return this.has_media_spoiler;
    }

    public int hashCode() {
        return (Objects.hash(this.origin, this.chat, this.message_id, this.link_preview_options, this.animation, this.audio, this.paid_media, this.document, this.sticker, this.story, this.video, this.video_note, this.voice, this.has_media_spoiler, this.checklist, this.contact, this.dice, this.game, this.giveaway, this.giveaway_winners, this.invoice, this.location, this.poll, this.venue) * 31) + Arrays.hashCode(this.photo);
    }

    public Invoice invoice() {
        return this.invoice;
    }

    public LinkPreviewOptions linkPreviewOptions() {
        return this.link_preview_options;
    }

    public Location location() {
        return this.location;
    }

    public Integer messageId() {
        return this.message_id;
    }

    public MessageOrigin origin() {
        return this.origin;
    }

    public PaidMediaInfo paidMedia() {
        return this.paid_media;
    }

    public PhotoSize[] photo() {
        return this.photo;
    }

    public Poll poll() {
        return this.poll;
    }

    public Sticker sticker() {
        return this.sticker;
    }

    public Story story() {
        return this.story;
    }

    public String toString() {
        return "ExternalReplyInfo{origin=" + this.origin + ", chat=" + this.chat + ", message_id=" + this.message_id + ", link_preview_options=" + this.link_preview_options + ", animation=" + this.animation + ", audio=" + this.audio + ", paid_media=" + this.paid_media + ", document=" + this.document + ", photo=" + Arrays.toString(this.photo) + ", sticker=" + this.sticker + ", story=" + this.story + ", video=" + this.video + ", video_note=" + this.video_note + ", voice=" + this.voice + ", has_media_spoiler=" + this.has_media_spoiler + ", checklist=" + this.checklist + ", contact=" + this.contact + ", dice=" + this.dice + ", game=" + this.game + ", giveaway=" + this.giveaway + ", giveaway_winners=" + this.giveaway_winners + ", invoice=" + this.invoice + ", location=" + this.location + ", poll=" + this.poll + ", venue=" + this.venue + '}';
    }

    public Venue venue() {
        return this.venue;
    }

    public Video video() {
        return this.video;
    }

    public VideoNote videoNote() {
        return this.video_note;
    }

    public Voice voice() {
        return this.voice;
    }
}
