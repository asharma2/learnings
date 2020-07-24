package com.learnings.search.config;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;

import com.learnings.search.model.Address;
import com.learnings.search.model.Point;

@Configuration
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

	@Override
	@Bean
	public RestHighLevelClient elasticsearchClient() {
		final ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200")
				.build();
		return RestClients.create(clientConfiguration).rest();
	}

//	@Bean
//	@Override
//	public ElasticsearchCustomConversions elasticsearchCustomConversions() {
//		return new ElasticsearchCustomConversions(Arrays.asList(new AddressToMap(), new MapToAddress()));
//	}
//
//	@WritingConverter
//	static class AddressToMap implements Converter<Address, Map<String, Object>> {
//
//		@Override
//		public Map<String, Object> convert(Address source) {
//			Map<String, Object> target = new LinkedHashMap<>();
//			target.put("city", source.getCity());
//			target.put("street", source.getStreet());
//			target.put("pincode", source.getPincode());
//			target.put("point", source.getPoint());
//			return target;
//		}
//	}
//
//	@ReadingConverter
//	static class MapToAddress implements Converter<Map<String, Object>, Address> {
//
//		@Override
//		public Address convert(Map<String, Object> source) {
//			Address address = new Address();
//			address.setCity((String) source.get("city"));
//			address.setStreet((String) source.get("street"));
//			address.setPincode((String) source.get("pincode"));
//			address.setPoint((Point) source.get("point"));
//			return address;
//		}
//	}

}
