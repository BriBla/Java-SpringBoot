package test.brice.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.brice.CRUD.User;
import test.brice.CRUD.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String addUser(String name, String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    public User update(Integer id, String name, String email) {
        User userFromDb = userRepository.findById(id).get();
        userFromDb.setName(name);
        userFromDb.setEmail(email);
        userRepository.save(userFromDb);
        return userFromDb;
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
