package com.example.crud.controller;

import com.example.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

@Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<Usuarios> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<Object> registarUsuario(@RequestBody Usuarios usuarios){
        return this.userService.newUsuarios(usuarios);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarUsuario(@RequestBody Usuarios usuarios){
        return this.userService.newUsuarios(usuarios);
    }

    @DeleteMapping (path = "{userId}")
    public ResponseEntity<Object> elminarUsuario(@PathVariable ("userId") Integer user_id){
        return this.userService.eliminarUsuarios(user_id);
    }
}
