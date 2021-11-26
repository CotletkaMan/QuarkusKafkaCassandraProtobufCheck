package service;

import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import model.KafkaEvent;

@Dao
public interface KafkaEventDao {
    @Update
    void update(KafkaEvent event);

    @Select
    PagingIterable<KafkaEvent> findAll();
}
