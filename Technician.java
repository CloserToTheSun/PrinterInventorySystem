package app;
public class Technician  {

    private String userName;
    private String password;

    public Technician() {
        this.userName = "default username";
        this.password = "default password";
    }

    public Technician(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
