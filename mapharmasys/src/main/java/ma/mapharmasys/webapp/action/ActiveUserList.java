package ma.mapharmasys.webapp.action;

import ma.mapharmasys.model.User;
import ma.mapharmasys.webapp.listener.UserCounterListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActiveUserList extends BasePage implements Serializable {
    private static final long serialVersionUID = -2725378005612769815L;

    public ActiveUserList() {
        setSortColumn("username");
    }
    
    @SuppressWarnings("unchecked")
    public List getUsers() {
        Set users = (Set) getServletContext().getAttribute(UserCounterListener.USERS_KEY);
        if (users != null) {
            return sort(new ArrayList<User>(users));
        } else {
            return new ArrayList();
        }
    }
}
