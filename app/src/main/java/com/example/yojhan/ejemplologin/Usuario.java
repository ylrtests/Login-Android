package com.example.yojhan.ejemplologin;

/**
 * Created by Yojhan on 1/06/2016.
 */
public class Usuario {

    String username,nombre,apellido,password,fechanac;
    int id;

    public Usuario(int id, String nombre, String apellido, String username, String password, String fechanac){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password =password;
        this.fechanac=fechanac;
    }

}
