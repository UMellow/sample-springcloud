package sample.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "sample")
public class SampleEntity {

    private String id;
    private String message;
}
