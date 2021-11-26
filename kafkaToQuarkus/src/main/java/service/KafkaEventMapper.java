package service;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

@Mapper
public interface KafkaEventMapper {
    @DaoFactory
    KafkaEventDao kafkaEvent();
}
