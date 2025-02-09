package labarary.labarairy.servise;


import labarary.labarairy.domin.User;
import labarary.labarairy.domin.UserRole;
import labarary.labarairy.dto.UserDto;
import labarary.labarairy.mapper.UserMaper;
import labarary.labarairy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class UserServise {
    @Autowired
    private UserRepository userRepository;
    //   private PasswordEncoder passwordEncoder;

    private UserRole userRole;
    @Autowired
    private UserMaper userMaper;


    public UserDto creatuser(UserDto userDto) {
        User user = userMaper.ToEntity(userDto);
        User user1 = new User();
        user1.setPasword(user.getPasword());
        user1.setName(user.getName());
        user1.setUsername(user.getUsername());
        user1.setRole(user.getRole());

        User usersaved = userRepository.save(user1);
        return userMaper.ToDto(usersaved);
    }

    public List<UserDto> getall() {
        return userRepository.findAll().stream().map(userMaper::ToDto).collect(Collectors.toList());

    }

    public UserDto getid(Long id) {
   Optional<User> user=userRepository.findById(id);
    UserDto userDto=userMaper.ToDto(user.get());
    return userDto;
    }
    public UserDto getname(String name){

        Optional<User>username= userRepository.findByname(name);

           UserDto userDto=userMaper.ToDto(username.get());

           return userDto;

    }
        public void delete (Long id){
            userRepository.existsById(id);
        }
        public UserDto updete (Long id, UserDto userDto){
            User user = userMaper.ToEntity(userDto);
            User user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("notfind"));
            user1.setUsername(user.getUsername());
            user1.setPasword(user.getPasword());
            user1.setName(user.getName());
            User user2 = userRepository.save(user1);
            return userMaper.ToDto(user2);
        }
        public void creteAdmin () {
            if (userRepository.findByRole("admin").isPresent()) {
                User admin = new User();
                admin.setUsername("admin");


            }
        }
    }
