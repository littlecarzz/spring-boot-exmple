package com.cjj.controller;

import com.cjj.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/31 15:29
 */
@RestController
@RequestMapping("/city")
public class WebfluxController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        String key = "city_" + id;
        ValueOperations<String,City> valueOperations = redisTemplate.opsForValue();
        Boolean hasKey = redisTemplate.hasKey(key);
        City city = valueOperations.get(key);
        if (!hasKey) {
            return Mono.create(cityMonoSink -> cityMonoSink.success(null));
        }else{
            return Mono.create(cityMonoSink -> cityMonoSink.success(city));
        }
    }
    @PostMapping()
    public Mono<City> saveCity(@RequestBody City city) {
        String key = "city_" + city.getId();
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        operations.set(key, city, 60, TimeUnit.SECONDS);
        return Mono.create(monoSink -> monoSink.success(city));
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
        }
        return Mono.create(monoSink -> monoSink.success(id));
    }
}
