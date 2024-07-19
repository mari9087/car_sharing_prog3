package uni.parthenope.carsharing.dao;

import uni.parthenope.carsharing.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static uni.parthenope.carsharing.utility.PasswordHashing.hashPassword;
import static uni.parthenope.carsharing.utility.PasswordHashing.verifyPassword;

public class UserDAO {
    private List<User> users = new ArrayList<>();

    public UserDAO() {
        // inizializzo la lista degli utenti con alcuni dati di esempio
        users.add(new User(1, "admin", hashPassword("password", "salt"), "admin"));
        users.add(new User(2, "user1", hashPassword("password", "salt"), "user"));
        users.add(new User(3, "user2", hashPassword("password", "salt"), "user"));
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && verifyPassword(password, "salt", user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public void registerUser(User user) {
        String salt = generateSalt();
        user.setPassword(hashPassword(user.getPassword(), salt));
        users.add(user);
    }

    private String generateSalt() {
        // genera un valore di salt casuale
        return UUID.randomUUID().toString();
    }
}

