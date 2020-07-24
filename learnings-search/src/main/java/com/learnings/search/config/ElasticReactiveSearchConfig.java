package com.learnings.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients;
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter;
import org.springframework.data.elasticsearch.core.convert.MappingElasticsearchConverter;
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchMappingContext;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.web.reactive.function.client.ExchangeStrategies;

@Configuration
@EnableReactiveElasticsearchRepositories(basePackages = { "com.learnings.search.repository" })
public class ElasticReactiveSearchConfig {

	@Bean
	ReactiveElasticsearchClient reactiveElasticsearchClient() {

		ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200")
				.withWebClientConfigurer(webClient -> {
					ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
							.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)).build();
					return webClient.mutate().exchangeStrategies(exchangeStrategies).build();
				}).build();

		return ReactiveRestClients.create(clientConfiguration);
	}

	@Bean
	public ElasticsearchConverter elasticsearchConverter() {
		return new MappingElasticsearchConverter(elasticsearchMappingContext());
	}

	@Bean
	public SimpleElasticsearchMappingContext elasticsearchMappingContext() {
		return new SimpleElasticsearchMappingContext();
	}

	@Bean(name = { "reactiveElasticsearchOperations", "reactiveElasticsearchTemplate" })
	public ReactiveElasticsearchOperations reactiveElasticsearchOperations() {
		return new ReactiveElasticsearchTemplate(reactiveElasticsearchClient(), elasticsearchConverter());
	}
}
