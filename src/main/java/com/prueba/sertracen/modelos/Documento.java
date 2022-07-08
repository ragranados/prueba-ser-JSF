package com.prueba.sertracen.modelos;

import jakarta.enterprise.inject.Model;
import jakarta.persistence.*;


import java.util.Objects;

@Model
@Entity
@Table(name = "documento", schema = "pruebasertracen")
@NamedQueries({
        @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
})
public class Documento {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String email;
    private String foto;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "edad")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "foto")
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Documento(){

    }

    public Documento(int id, String nombre, String apellido, int edad, String email, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento that = (Documento) o;
        return id == that.id && edad == that.edad && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(email, that.email) && Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, edad, email, foto);
    }
}
