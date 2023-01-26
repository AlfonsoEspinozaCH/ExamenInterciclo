package com.example.demo.APP.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.APP.entity.Producto;


public interface ProductoService {
	
	public Iterable<Producto> findAll();
	public Page<Producto> findAll(Pageable pageable);
	public Optional<Producto> findById(Integer ProductoCodigo);
	public Producto save (Producto Producto);
	public void deleteById(Integer ProductoCodigo);


}
