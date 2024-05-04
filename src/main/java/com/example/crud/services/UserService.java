package com.example.crud.services;

import com.example.crud.controller.UsuarioRepository;
import com.example.crud.controller.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    HashMap<String, Object> datos;

    private  final UsuarioRepository usuarioRepository;

    @Autowired
    public UserService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuarios> getUsers() {
        return this.usuarioRepository.findAll();
    }

    //Create
        public ResponseEntity<Object> newUsuarios(Usuarios usuarios) {
        Optional<Usuarios> existingUser = usuarioRepository.findUserByusername(usuarios.getUsername());
         if (this.datos == null){
             new HashMap<>();
         }

        if (existingUser.isPresent()) {
            datos.put("error" , true);
            datos.put("mensage" , "Ya existe un usuario con ese UserName");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        //actualizar
        datos.put("message" , "Se guardado ese UserName");
        if (usuarios.getUser_id()>0) {
            datos.put("message", "Se actualizó con éxito");
        }


        usuarioRepository.save(usuarios);
            datos.put("datos" , usuarios);
            return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
        }

        public ResponseEntity<Object> eliminarUsuarios(Integer id){
            if (this.datos == null){
                new HashMap<>();
            }
            boolean existe = this.usuarioRepository.existsById(id);
            if (!existe){
                datos.put("error" , true);
                datos.put("mensage" , "No existe un usario con ese id");
                return new ResponseEntity<>(
                        datos,
                        HttpStatus.CONFLICT
                );
            }

            datos.put("mensage" , "Usuario Elminado");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.ACCEPTED
            );
        }

    }

