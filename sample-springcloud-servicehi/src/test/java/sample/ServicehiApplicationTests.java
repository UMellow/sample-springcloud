package sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import sample.es.Item;
import sample.es.ItemRepository;
import sample.es.SampleEntity;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServicehiApplicationTests {

	@Autowired
	private ElasticsearchTemplate esTemplate;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void contextLoads() {
		esTemplate.createIndex(Item.class);
		esTemplate.putMapping(Item.class);
	}

	@Test
	public void index() {
		Item item = new Item(1L, "小米手机7", " 手机",
				"小米", 3499.00, "http://image.baidu.com/13123.jpg");
		itemRepository.save(item);
	}

	@Test
	public void indexList() {
		List<Item> list = new ArrayList<>();
		list.add(new Item(2L, "坚果手机R1", " 手机", "锤子", 3699.00, "http://image.baidu.com/13123.jpg"));
		list.add(new Item(3L, "华为META10", " 手机", "华为", 4499.00, "http://image.baidu.com/13123.jpg"));
		// 接收对象集合，实现批量新增
		itemRepository.saveAll(list);
	}

	// https://blog.csdn.net/weixin_42633131/article/details/82902812

	@Test
	public void addIndex() {
		String documentId = "123456";
		SampleEntity sampleEntity = new SampleEntity();
		sampleEntity.setId(documentId);
		sampleEntity.setMessage("some message");

		IndexQuery indexQuery = new IndexQueryBuilder().withId(documentId).withObject(sampleEntity).build();
		esTemplate.index(indexQuery);
	}

	@Test
	public void queryAll() {
		Iterable<Item> list = itemRepository.findAll(Sort.by("price").ascending());
		for(Item item : list) {
			System.out.println(item);
		}
	}
}
