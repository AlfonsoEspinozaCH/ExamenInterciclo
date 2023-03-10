package com.example.demo.APP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.APP.entity.Producto;


@Component
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
