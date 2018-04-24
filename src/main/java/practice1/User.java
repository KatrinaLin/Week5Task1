package practice1;

import com.google.common.collect.ImmutableList;

public class User {

    private boolean isAdmin;

    private ImmutableList<Permission> permissions;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public ImmutableList<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(ImmutableList<Permission> permissions) {
        this.permissions = permissions;
    }
}
