package app;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class KafkaProducerQ {
    public static void main(String[] args) {
        Quarkus.run(args);
    }
}
