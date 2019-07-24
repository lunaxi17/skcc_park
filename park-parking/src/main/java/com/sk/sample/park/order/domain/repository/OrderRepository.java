package com.sk.sample.park.order.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.sample.park.order.domain.model.Parking;

@RepositoryRestResource
public interface OrderRepository extends PagingAndSortingRepository<Parking, Long> {
	Parking findByCarNumber(@Param("carnumber") String carnumber);
}
