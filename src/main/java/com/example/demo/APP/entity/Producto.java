package com.example.demo.APP.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "producto")
public class Producto implements Serializable {
//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
private static final long serialVersionUID = -3910449336070592149L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer codigo;

@Column(length = 50)
private String descripcion;

private Double precio;

private Integer cantidad;

//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
public Integer getCodigo() {
	return codigo;
}

public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Double getPrecio() {
	return precio;
}

public void setPrecio(Double precio) {
	this.precio = precio;
}

public Integer getCantidad() {
	return cantidad;
}

public void setCantidad(Integer cantidad) {
	this.cantidad = cantidad;
}

//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////


}
