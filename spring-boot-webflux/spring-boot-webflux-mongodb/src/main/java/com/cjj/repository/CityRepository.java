package com.cjj.repository;

import com.cjj.model.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/30 16:19
 */
@Repository
public interface CityRepository extends ReactiveMongoRepository<City,Long> {
}
