package com.pengrad.telegrambot.model;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class GameHighScore implements Serializable {
    private static final long serialVersionUID = 0;
    private Integer position;
    private Integer score;
    private User user;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GameHighScore gameHighScore = (GameHighScore) obj;
            Integer num = this.position;
            if (num == null ? gameHighScore.position != null : !num.equals(gameHighScore.position)) {
                return false;
            }
            User user = this.user;
            if (user == null ? gameHighScore.user != null : !user.equals(gameHighScore.user)) {
                return false;
            }
            Integer num2 = this.score;
            Integer num3 = gameHighScore.score;
            if (num2 != null) {
                return num2.equals(num3);
            }
            if (num3 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.position;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        User user = this.user;
        int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
        Integer num2 = this.score;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    public Integer position() {
        return this.position;
    }

    public Integer score() {
        return this.score;
    }

    public String toString() {
        return "GameHighScore{position=" + this.position + ", user=" + this.user + ", score=" + this.score + '}';
    }

    public User user() {
        return this.user;
    }
}
