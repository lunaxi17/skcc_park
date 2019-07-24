package com.sk.sample.park.parkinglot.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.sk.sample.park.parkinglot.domain.model.Parkinglot;

@RepositoryRestResource
public interface ParkingLotRepository extends PagingAndSortingRepository<Parkinglot, Long>,
                                           QueryDslPredicateExecutor<Parkinglot> {
	List<Parkinglot> findAll(Predicate predicate); 
	
	Parkinglot findByName(@Param("name") String name);
	Parkinglot findByParkingLotId(@Param("parkingLotId") String parkinglotid);
//	void parkIn(@Param("parkingLotId") String parkinglotid);
//	void parkOut(@Param("parkingLotId") String parkinglotid);
//	List<ParkingLot> findByProductDescriptionSizeType(@Param("sizeType") SizeType sizeType);
//	List<ParkingLot> findByProductDescriptionColorType(@Param("colorType") ColorType colorType);
//	List<ParkingLot> findByPriceValueGreaterThanEqual(@Param("value") Integer value);
//	List<ParkingLot> findByPriceValueLessThanEqual(@Param("value") Integer value);
//	List<ParkingLot> findByPriceValueGreaterThanAndPriceValueLessThan(@Param("value1") Integer value1, @Param("value2") Integer value2);
}
