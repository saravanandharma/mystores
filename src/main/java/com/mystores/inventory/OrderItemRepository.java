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
      This OrderItemRepository class uses Spring Data REST apis that
      will expose all the resources as REST APIs and by default all the
      data types JSON.

      Author: Saravanan Dharmalingam.
      ================================================================
*/


@RepositoryRestResource(collectionResourceRel = "orderitem", path = "orderitem")
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItems, Long> {


     @RequestMapping(method = RequestMethod.GET, name = "orders", value = "po")
     List<OrderItems> findAllByOrderItemId(@Param("orderItemId") long orderItemId);

     @Override
     default Iterable<OrderItems> findAll(Sort sort) {
          return null;
     }

     @Override
     default Page<OrderItems> findAll(Pageable pageable) {
          return null;
     }

     @Override
     default <S extends OrderItems> S save(S entity) {
          return null;
     }

     @Override
     default <S extends OrderItems> Iterable<S> saveAll(Iterable<S> entities) {
          return null;
     }

     @Override
     default Optional<OrderItems> findById(Long aLong) {
          return Optional.empty();
     }

     @Override
     default boolean existsById(Long aLong) {
          return false;
     }

     @Override
     default Iterable<OrderItems> findAll() {
          return null;
     }

     @Override
     default Iterable<OrderItems> findAllById(Iterable<Long> longs) {
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
     default void delete(OrderItems entity) {

     }

     @Override
     default void deleteAll(Iterable<? extends OrderItems> entities) {

     }

     @Override
     default void deleteAll() {


     }


}
