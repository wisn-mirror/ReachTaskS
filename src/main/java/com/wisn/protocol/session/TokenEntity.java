package com.wisn.protocol.session;

public class TokenEntity {
    private Long userid;
    private Long expired;

    public TokenEntity(Long userid, Long expired) {
        this.userid = userid;
        this.expired = expired;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getExpired() {
        return expired;
    }

    public void setExpired(Long expired) {
        this.expired = expired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenEntity that = (TokenEntity) o;
        if (!userid.equals(that.userid)) return false;
        return expired.equals(that.expired);
    }

    @Override
    public int hashCode() {
        int result = userid.hashCode();
        result = 31 * result + expired.hashCode();
        return result;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() < expired;
    }
}
