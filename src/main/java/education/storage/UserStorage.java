package education.storage;

import education.exception.UserNotFoundException;
import education.model.User;
import education.util.FileUtil;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {

    private static Map<String, User> userMap = new HashMap<>();


    public static User getByEmail(String email) throws UserNotFoundException {
        return userMap.get(email);
    }


    public static void add(User user) {
        userMap.put(user.getEmail(), user);
        FileUtil.serializeUserMap(userMap);
    }


    public static User GetByEmailOrPassword(String email, String password) throws UserNotFoundException {
        try {
            User user = userMap.get(email);
            if (user.getEmail().equals(null)) {
                return null;
            }
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static void initData() {
        Map<String, User> userMapFromFile = FileUtil.deserializeUserMap();
        if (userMapFromFile != null) {
            userMap = userMapFromFile;
        }
    }


    public void print() {
        for (User value : userMap.values()) {
            System.out.println(value);
        }
    }


}
