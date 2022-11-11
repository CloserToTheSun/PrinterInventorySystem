package app;

public class Admin extends Technician {

    public Admin() {
        super("default username","default password");
    }

    public Admin(String userName, String password) {
        super(userName, password);
    }
}
