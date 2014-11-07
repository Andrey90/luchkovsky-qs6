package actor;

public class RegUser {
    private String email;
    private String nickname;
    private String passwd;

    public RegUser() {
        this.email = "asd" + Long.toString(System.currentTimeMillis()) + "@i.ua";
        this.nickname = "asd";
        this.passwd = "qwerty";
    }
}