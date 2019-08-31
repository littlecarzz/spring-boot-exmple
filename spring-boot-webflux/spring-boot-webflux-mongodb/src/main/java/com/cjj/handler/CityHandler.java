package com.cjj.handler;

import com.cjj.model.City;
import com.cjj.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/30 16:27
 */
@Component
public class CityHandler {

    @Autowired
    private CityRepository cityRepository;

    public Mono<City> save(City city) {
        return cityRepository.save(city);
    }

    public Mono<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }

    public Flux<City> findAll() {
        return cityRepository.findAll();
    }
    public Mono<City> modifyCity(City city) {
        return cityRepository.save(city);
    }

    public Mono<Long>  deleteCity(Long id) {
        cityRepository.deleteById(id);
        return Mono.create(cityMonoSink -> cityMonoSink.success(id));
    }

}
