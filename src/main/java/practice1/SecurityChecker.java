package practice1;

public class SecurityChecker {

    private User user;

    public  boolean checkPermission(User user, Permission permission) {
        //todo code
        if (user == null) {
            return false;
        }

        if (permission == null) {
            return false;
        }

        return user.getPermissions().contains(permission);
    }

    public boolean isAdmin() {
        //todo code
        if (user != null) {
            return user.isAdmin();
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
