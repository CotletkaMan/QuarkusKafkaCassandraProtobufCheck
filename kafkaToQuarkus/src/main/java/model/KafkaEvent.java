package model;

import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.oss.driver.api.mapper.annotations.PropertyStrategy;

@Entity
@PropertyStrategy(mutable = false)
public class KafkaEvent {
    @PartitionKey
    String name;
    String payload;

    public KafkaEvent(String name, String payload) {
        this.name = name;
        this.payload = payload;
    }

    public KafkaEvent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "KafkaEvent{" +
                "name='" + name + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
