package com.cjj.config;

import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/30 9:49
 */
@Component
public class MemcacheRunner implements CommandLineRunner {
    protected Logger logger = LoggerFactory.getLogger(MemcacheRunner.class);
    @Resource
    private MemcacheSource memcacheSource;

    private MemcachedClient memcachedClient = null;

    @Override
    public void run(String... args) throws Exception {
        try {
            memcachedClient = new MemcachedClient(new InetSocketAddress(memcacheSource.getIp(), memcacheSource.getPort()));
        } catch (IOException e) {
            logger.error("inint MemcachedClient filed", e);
        }
    }

    public MemcachedClient getMemcachedClient() {
        return memcachedClient;
    }
}
