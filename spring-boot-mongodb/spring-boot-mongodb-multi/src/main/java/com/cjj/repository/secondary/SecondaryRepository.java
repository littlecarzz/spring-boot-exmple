package com.cjj.repository.secondary;

import com.cjj.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 描述：
 *
 * @author littlecar
 * @date 2019/8/22 16:33
 */
public interface SecondaryRepository extends MongoRepository<User,String> {
}
