package cinema.Soft2.Controller;

import cinema.Soft2.Model.User;
import cinema.Soft2.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
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
    @CrossOrigin(origins = "*")
    private ResponseEntity<User> save(@RequestBody User user) {
        try {
            User userGuardado = userService.save(user);
            return ResponseEntity.created(new URI("/api/v1/user" + userGuardado.getId())).body(userGuardado);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping("/signin")
    public ResponseEntity<Optional<User>> authenticateUser(@RequestBody User user) {
        try{ return ResponseEntity.ok(userService.autenticar(user));
        } catch (Exception e){
        logger.debug(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/actualizar-usuario")
    public Optional<Object> updateUser( @RequestBody @Validated User user) {
        return Optional.of(userService.findById(user.getId()).
                    map(userobj -> {
                    userobj.setName(user.getName());
                    userobj.setLastname(user.getLastname());
                    userobj.setEmail(user.getEmail());
                    userobj.setPhone(user.getPhone());
                    userobj.setPassword(user.getPassword());
                    userobj.setConfirmpassword(user.getConfirmpassword());
                    return ResponseEntity.ok(userService.updateUser(userobj));
                })
                .orElseGet(() -> ResponseEntity.notFound().build()));
    }
    @DeleteMapping("/deleteById/{id}")
    private ResponseEntity<Boolean> deleteById(@PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.ok(true);
    }
}