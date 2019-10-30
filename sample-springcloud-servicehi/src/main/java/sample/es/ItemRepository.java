package sample.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ItemRepository extends ElasticsearchCrudRepository<Item, Long> {
}
