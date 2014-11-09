package actor;

public class RegUser {
    private String email;
    private String nickname;
    private String passwd;

    public void regData() {
        this.email = "asd" + Long.toString(System.currentTimeMillis()) + "@i.ua";
        this.nickname = "nik";
        this.passwd = "password";
    }
}