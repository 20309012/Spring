package labarary.labarairy.contoler;

  import labarary.labarairy.domin.User;
import labarary.labarairy.dto.UserDto;
import labarary.labarairy.servise.UserServise;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
//@RequiredArgsConstructor
public class UserContolor {

    private UserServise userServise;

    public UserContolor(UserServise userServise) {
        this.userServise = userServise;
    }


    @PostMapping("/post")
 //   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto>create(@RequestBody UserDto userDto){
       UserDto userDto1=userServise.creatuser(userDto);
        return ResponseEntity.ok(userDto1);
    }
    @GetMapping("all")
  //  @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<List<UserDto>>getAll(){
        List<UserDto>users=userServise.getall();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDto> gitid(@PathVariable Long id){

  UserDto userDto=    userServise.getid(id);
  return ResponseEntity.ok(userDto);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<UserDto> gitid(@PathVariable String name){
        UserDto userDto =userServise.getname(name);
        return ResponseEntity.ok(userDto);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<UserDto>updete(@RequestBody UserDto userDto,@PathVariable Long id){
        UserDto userDto1=userServise.updete(id, userDto);
        return ResponseEntity.ok(userDto1);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>delete(@PathVariable Long id){
        userServise.delete(id);
        return ResponseEntity.ok("username by"+id+"delete");
    }
}
