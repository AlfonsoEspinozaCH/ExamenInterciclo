package com.example.demo.APP.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.APP.entity.Producto;
import com.example.demo.APP.repository.ProductoRepository;



public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository ProductoRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() {
	return ProductoRepository.findAll();
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
	return ProductoRepository.findAll(pageable);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Integer codigo) {
	return ProductoRepository.findById(codigo);
	}
	
	
	@Override
	@Transactional
	public Producto save(Producto Producto) {
	return ProductoRepository.save(Producto);
	}
	
	
	@Override
	@Transactional
	public void deleteById(Integer codigo) {
	ProductoRepository.deleteById(codigo);
	}

	

}
