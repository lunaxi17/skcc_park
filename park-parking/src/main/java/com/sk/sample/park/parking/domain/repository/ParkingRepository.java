package com.sk.sample.park.parking.domain.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.sample.park.parking.domain.model.Parking;

@RepositoryRestResource
public interface ParkingRepository extends PagingAndSortingRepository<Parking, Long>,
                                           QueryDslPredicateExecutor<Parking> {
}
