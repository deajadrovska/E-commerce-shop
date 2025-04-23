package mk.finki.ukim.mk.emtproject.repository;

import mk.finki.ukim.mk.emtproject.model.domain.User;
import mk.finki.ukim.mk.emtproject.model.enumerations.Role;
import mk.finki.ukim.mk.emtproject.model.projections.UserProjection;
import org.junit.Assert;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        List<User> userList = this.userRepository.findAll();

        userList.forEach(user -> System.out.println("User: " + user.getUsername() + ", Role: " + user.getRole()));
        Assert.assertEquals(3L, userList.size());
    }

    @Test
    public void testFetchAll() {
        List<User> userList = this.userRepository.fetchAll();
        Assert.assertEquals(3L, userList.size());
    }

    @Test
    public void testLoadAll() {
        List<User> userList = this.userRepository.loadAll();
        Assert.assertEquals(3L, userList.size());
    }

    @Test
    public void testProjectUsernameAndNameAndSurname() {
        UserProjection userProjection = this.userRepository.findByRole(Role.ROLE_USER);
        Assert.assertEquals("user", userProjection.getUsername());
        Assert.assertEquals("user", userProjection.getName());
        Assert.assertEquals("user", userProjection.getSurname());
    }
}

