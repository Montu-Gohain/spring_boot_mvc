package com.montu;

import com.montu.user.User;
import com.montu.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

//Let's do some Test Driven Development baby.

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

//    Test for creating a new user.
    @Test
    public void testAddNew(){
        User user = new User();
        user.setName("Mateus Asato");
        user.setEmail("mateus@gmail.com");
        user.setPassword("doubleslides");
        user.setGender("Male");
        user.setQualificaion("Brazilian Guitarist");
        user.setAboutme("Playing doubles stops to add new flavour in my music.");
        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
//    Test for Getting all the users.
    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user : users) {
            System.out.println(user);
        }

    }
//    Test for updating a user by ID.
    @Test
    public void testUpdate(){
        Integer userId = 3;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
          //  let's update the about me here
        String newAboutMe = "Hakuna Matata,Whaaaaat!";
         user.setAboutme(newAboutMe);
         repo.save(user);
         User updatedUser = repo.findById(userId).get();
         Assertions.assertThat(updatedUser.getAboutme()).isEqualTo(newAboutMe);
    }
//    Test for getting a user by ID.

    @Test
    public void testGetOneById(){
        Integer userId = 2;
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }
//    Test for delete a user by ID.

    @Test
    public void testDelete(){
        Integer userId = 2;
        repo.deleteById(userId);
        Optional<User> optionalUser = repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
