package com.mystores.inventory;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

     /*
          ================================================================
           This ProductRepository class uses Spring Data REST apis that
           will expose all the resources as REST APIs and by default all the
           data types JSON.

           Author: Saravanan Dharmalingam.
           ================================================================
     */


@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Products, Long> {

     @RequestMapping(method = RequestMethod.GET, name = "products", value = "products")
     List<Products> findAllBySku(@Param("sku") BigInteger sku);

     @Override
     default Iterable<Products> findAll(Sort sort) {
          return null;
     }

     @Override
     default Page<Products> findAll(Pageable pageable) {
          return null;
     }

     @Override
     default <S extends Products> S save(S entity) {
          return null;
     }

     @Override
     default <S extends Products> Iterable<S> saveAll(Iterable<S> entities) {
          return null;
     }

     @Override
     default Optional<Products> findById(Long aLong) {
          return Optional.empty();
     }

     @Override
     default boolean existsById(Long aLong) {
          return false;
     }

     @Override
     default Iterable<Products> findAll() {
          return null;
     }

     @Override
     default Iterable<Products> findAllById(Iterable<Long> longs) {
          return null;
     }

     @Override
     default long count() {
          return 0;
     }

     @Override
     default void deleteById(Long aLong) {

     }

     @Override
     default void delete(Products entity) {

     }

     @Override
     default void deleteAll(Iterable<? extends Products> entities) {

     }

     @Override
     default void deleteAll() {

     }
}
