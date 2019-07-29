package io.jmlim.jeongmukbootstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jeongmuk")
public class JeongmukProperties {
    private String firstname;

    private long howLong;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public long getHowLong() {
        return howLong;
    }

    public void setHowLong(long howLong) {
        this.howLong = howLong;
    }
}
