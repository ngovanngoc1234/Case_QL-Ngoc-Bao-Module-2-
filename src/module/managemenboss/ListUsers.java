package module.managemenboss;
import module.Module.User;

import java.util.List;

public class ListUsers {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public ListUsers() {
    }

    public ListUsers(List<User> users) {
        userList = users;
    }

}
