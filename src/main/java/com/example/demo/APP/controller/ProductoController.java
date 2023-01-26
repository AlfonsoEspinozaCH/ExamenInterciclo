package com.example.demo.APP.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.APP.entity.Producto;
import com.example.demo.APP.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {	
//////////////////////////////////////////////////////////////////////////////////////////
@Autowired
private ProductoService productoService;

//////////////////////////////////////////////////////////////////////////////////////////
//Created a now producto 
@PostMapping
public ResponseEntity<?> create (@RequestBody Producto producto){
return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
}
//////////////////////////////////////////////////////////////////////////////////////////
//leer an producto
@GetMapping("/{codigo}")
public ResponseEntity<?> read(@PathVariable(value = "codigo") Integer ProductoCodigo){
Optional<Producto> oProducto = productoService.findById(ProductoCodigo);
if(!oProducto.isPresent()) {
return ResponseEntity.notFound().build(); 
}
return ResponseEntity.ok(oProducto);
}
//////////////////////////////////////////////////////////////////////////////////////////
//Update an producto
@PutMapping("/{codigo}") 
public ResponseEntity<?> update (@RequestBody Producto productoDetails, @PathVariable(value = "codigo") Integer productoId){
Optional<Producto> producto = productoService.findById(productoId);
if(!producto.isPresent()){
return ResponseEntity.notFound().build();
}
BeanUtils.copyProperties(productoDetails, producto.get());
producto.get().setDescripcion(productoDetails.getDescripcion());
producto.get().setPrecio(productoDetails.getPrecio());
producto.get().setCantidad(productoDetails.getCantidad());
return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto.get()));
}
//////////////////////////////////////////////////////////////////////////////////////////
//Delete an Producto
@DeleteMapping("/{codigo}")
public ResponseEntity<?> delete (@PathVariable(value="codigo") Integer ProductoCodigo){
if(!productoService.findById(ProductoCodigo).isPresent()){
return ResponseEntity.notFound().build();
}

productoService.deleteById(ProductoCodigo);
return ResponseEntity.ok().build();
}
//////////////////////////////////////////////////////////////////////////////////////////
//Read All Productos
@GetMapping
public List<Producto> readAll(){
List<Producto> productos = StreamSupport.stream(productoService.findAll().spliterator(), false)
.collect(Collectors.toList());
return productos;
}
//////////////////////////////////////////////////////////////////////////////////////////




}
