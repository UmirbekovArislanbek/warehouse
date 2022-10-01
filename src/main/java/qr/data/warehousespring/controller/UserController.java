package qr.data.warehousespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.UserDto;
import qr.data.warehousespring.entity.User;
import qr.data.warehousespring.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping
    public Result add(@RequestBody UserDto userDto) {
        return userService.add(userDto);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody UserDto userDto, @PathVariable Integer id) {
        return userService.update(userDto, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        return userService.deleteById(id);
    }

}
