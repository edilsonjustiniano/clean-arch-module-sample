package module.delivery.rest.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public interface UserApi {

    @PostMapping
    UserResponse postUser(@RequestBody UserRequest request);

    @PutMapping("/{user-id}")
    UserResponse putUser(@RequestBody UserRequest request, @PathVariable("user-id") String id);

    @GetMapping
    List<UserResponse> getUsers();

    @GetMapping("/{user-id}")
    UserResponse getUser(@PathVariable("user-id") String id);
}
