package com.example.crud.controller;

import jakarta.persistence.*;

    @Entity
    @Table
    public class Usuarios {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int user_id;

        @Column(unique = true)
        private String username;
        private String password;
        private String name;
        private String apellido;

        public Usuarios() {
        }

        public Usuarios(int user_id, String username, String password, String name, String apellido) {
            this.user_id = user_id;
            this.username = username;
            this.password = password;
            this.name = name;
            this.apellido = apellido;
        }

        public Usuarios(String username, String password, String name, String apellido) {
            this.username = username;
            this.password = password;
            this.name = name;
            this.apellido = apellido;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
    }

