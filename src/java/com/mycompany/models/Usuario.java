/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.models;

/**
 *
 * @author centti
 */
public class Usuario extends User{
    protected String tipo_cuenta;
    
    public Usuario(){}
    public Usuario(String tipo_cuenta, Integer idUser, String firstname, String lastname, String password, String email, Integer dni, String direccion) {
        super(idUser, firstname, lastname, password, email, dni, direccion);
        this.tipo_cuenta = tipo_cuenta;
    }
    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }
    
}
