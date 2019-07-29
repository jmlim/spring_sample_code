package io.jmlim.jeongmukbootstarter;

public class Jeongmuk {
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

    @Override
    public String toString() {
        return "Jeongmuk{" +
                "firstname='" + firstname + '\'' +
                ", howLong=" + howLong +
                '}';
    }
}
