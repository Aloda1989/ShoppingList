package shoppingList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppingList.domain.Product;
import shoppingList.domain.User;
import shoppingList.repository.UserInHibernate;

import java.util.NoSuchElementException;

@Component
public class UserService {
    private final UserInHibernate userRepository;

    @Autowired
    public UserService(UserInHibernate userRepository) {
        this.userRepository = userRepository;
    }

    public Long createUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long userId) {
        return userRepository.findUserById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found, id: " + userId));
    }

    public void addProductToUser(Product product, Long userId) {
        User user = findUserById(userId);
        user.getProduct().add(product);
        userRepository.update(user);
    }
}
