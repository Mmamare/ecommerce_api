package com.web.ecommerce.repository;

import org.springframework.stereotype.Repository;

import com.web.ecommerce.entity.Items;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ItemsRepo extends JpaRepository<Items, Integer> {

}
