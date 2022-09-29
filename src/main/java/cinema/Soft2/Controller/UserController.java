package cinema.Soft2.Controller;

import cinema.Soft2.Model.User;
import cinema.Soft2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    private ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/findById/{id}")
    private ResponseEntity<Optional<User>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/save")
    private ResponseEntity<User> save(@RequestBody User user) {
        try {
            User userGuardado = userService.save(user);
            return ResponseEntity.created(new URI("/api/v1/user" + userGuardado.getId())).body(userGuardado);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/deleteById/{id}")
    private ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.ok(true);
    }
}