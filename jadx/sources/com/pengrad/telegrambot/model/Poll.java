package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class Poll implements Serializable {
    private static final long serialVersionUID = 0;
    private Boolean allows_multiple_answers;
    private Integer close_date;
    private Integer correct_option_id;
    private String explanation;
    private MessageEntity[] explanation_entities;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f8235id;
    private Boolean is_anonymous;
    private Boolean is_closed;
    private Integer open_period;
    private PollOption[] options;
    private String question;
    private MessageEntity[] question_entities;
    private Integer total_voter_count;
    private Type type;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public enum Type {
        quiz,
        regular
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Poll poll = (Poll) obj;
            String str = this.f8235id;
            if (str == null ? poll.f8235id != null : !str.equals(poll.f8235id)) {
                return false;
            }
            String str2 = this.question;
            if (str2 == null ? poll.question != null : !str2.equals(poll.question)) {
                return false;
            }
            if (!Arrays.equals(this.question_entities, poll.question_entities) || !Arrays.equals(this.options, poll.options)) {
                return false;
            }
            Integer num = this.total_voter_count;
            if (num == null ? poll.total_voter_count != null : !num.equals(poll.total_voter_count)) {
                return false;
            }
            Boolean bool = this.is_closed;
            if (bool == null ? poll.is_closed != null : !bool.equals(poll.is_closed)) {
                return false;
            }
            Boolean bool2 = this.is_anonymous;
            if (bool2 == null ? poll.is_anonymous != null : !bool2.equals(poll.is_anonymous)) {
                return false;
            }
            if (this.type != poll.type) {
                return false;
            }
            Boolean bool3 = this.allows_multiple_answers;
            if (bool3 == null ? poll.allows_multiple_answers != null : !bool3.equals(poll.allows_multiple_answers)) {
                return false;
            }
            Integer num2 = this.correct_option_id;
            if (num2 == null ? poll.correct_option_id != null : !num2.equals(poll.correct_option_id)) {
                return false;
            }
            String str3 = this.explanation;
            if (str3 == null ? poll.explanation != null : !str3.equals(poll.explanation)) {
                return false;
            }
            if (!Arrays.equals(this.explanation_entities, poll.explanation_entities)) {
                return false;
            }
            Integer num3 = this.open_period;
            if (num3 == null ? poll.open_period != null : !num3.equals(poll.open_period)) {
                return false;
            }
            Integer num4 = this.close_date;
            Integer num5 = poll.close_date;
            if (num4 != null) {
                return num4.equals(num5);
            }
            if (num5 == null) {
                return true;
            }
        }
        return false;
    }

    public Boolean allowsMultipleAnswers() {
        return this.allows_multiple_answers;
    }

    public Integer closeDate() {
        return this.close_date;
    }

    public Integer correctOptionId() {
        return this.correct_option_id;
    }

    public String explanation() {
        return this.explanation;
    }

    public MessageEntity[] explanationEntities() {
        return this.explanation_entities;
    }

    public int hashCode() {
        String str = this.f8235id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String id() {
        return this.f8235id;
    }

    public Boolean isAnonymous() {
        return this.is_anonymous;
    }

    public Boolean isClosed() {
        return this.is_closed;
    }

    public Integer openPeriod() {
        return this.open_period;
    }

    public PollOption[] options() {
        return this.options;
    }

    public String question() {
        return this.question;
    }

    public MessageEntity[] questionEntities() {
        return this.question_entities;
    }

    public String toString() {
        return "Poll{id='" + this.f8235id + "', question='" + this.question + "', options=" + Arrays.toString(this.options) + ", question_entities=" + Arrays.toString(this.question_entities) + ", total_voter_count=" + this.total_voter_count + ", is_closed=" + this.is_closed + ", is_anonymous=" + this.is_anonymous + ", type=" + this.type + ", allows_multiple_answers=" + this.allows_multiple_answers + ", correct_option_id=" + this.correct_option_id + ", explanation='" + this.explanation + "', explanation_entities=" + Arrays.toString(this.explanation_entities) + ", open_period=" + this.open_period + ", close_date=" + this.close_date + '}';
    }

    public Integer totalVoterCount() {
        return this.total_voter_count;
    }

    public Type type() {
        return this.type;
    }
}
