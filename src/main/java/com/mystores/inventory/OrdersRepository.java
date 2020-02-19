package com.mystores.inventory;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

  /*
          ================================================================
           This OrdersRepository class uses Spring Data REST apis that
           will expose all the resources as REST APIs and by default all the
           data types JSON.

           Author: Saravanan Dharmalingam.
           ================================================================
     */

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrdersRepository extends PagingAndSortingRepository<Orders, Long> {

     @RequestMapping(method = RequestMethod.GET, name = "orders", value = "orders")
     List<Orders> findAllById(@Param("name") long id);

     @RequestMapping(method = RequestMethod.GET, name = "orders", value = "findallorders")
     @Override
     default Iterable<Orders> findAll(Sort sort) {
          return null;
     }

     @Override
     default Page<Orders> findAll(Pageable pageable) {
          return null;
     }

     @Override
     @RequestMapping(method = RequestMethod.PUT, name = "orders", value = "saveorders")
     default <S extends Orders> S save(S entity) {
          return null;
     }

     @Override
     @RequestMapping(method = RequestMethod.PUT, name = "orders", value = "saveallorders")
     default <S extends Orders> Iterable<S> saveAll(Iterable<S> entities) {
          return null;
     }

     @Override
     default Optional<Orders> findById(Long aLong) {
          return Optional.empty();
     }

     @Override
     default boolean existsById(Long aLong) {
          return false;
     }

     @Override
     default Iterable<Orders> findAll() {
          return null;
     }

     @Override
     default Iterable<Orders> findAllById(Iterable<Long> longs) {
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
     default void delete(Orders entity) {

     }

     @Override
     default void deleteAll(Iterable<? extends Orders> entities) {

     }

     @Override
     default void deleteAll() {

     }
}
