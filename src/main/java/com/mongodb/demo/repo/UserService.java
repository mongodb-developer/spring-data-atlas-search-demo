package com.mongodb.demo.repo;

import com.mongodb.demo.entities.SimpleFacet;
import com.mongodb.demo.entities.User;
import com.mongodb.demo.entities.Address;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersByName(String name, int limit) {
        return userRepository.findByName(name);
    }

    public List<SimpleFacet> usersByCity() {
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.group("address.city").count().as("count"),
                Aggregation.sort(Sort.Direction.DESC,"count")
        );
        return mongoTemplate.aggregate(agg, "users", SimpleFacet.class).getMappedResults();
    }

    public List<User> searchUsersByName(String[] keywords, int limit) {
        AggregationOperation searchOperation = new SimpleSearchOperation("users", keywords, "name");
        Aggregation aggregation = Aggregation.newAggregation(
                searchOperation,
                Aggregation.limit(limit)
        );

        return mongoTemplate.aggregate(aggregation, "users", User.class).getMappedResults();
    }

    public List<Address> searchAddresses(String[] keywords, int limit) {
        AggregationOperation searchOperation = new SimpleSearchOperation("users", keywords, "address.city", "address.street");
        Aggregation aggregation = Aggregation.newAggregation(
                searchOperation,
                Aggregation.replaceRoot("address"),
                Aggregation.limit(limit)
        );

        return mongoTemplate.aggregate(aggregation, "users", Address.class).getMappedResults();
    }

    class SimpleSearchOperation implements AggregationOperation{
        private String index;
        private List<String> fields;
        private List<String> keywords;

        public SimpleSearchOperation(String index, String[] keywords, String... fields) {
            this.index = index;
            this.fields = Arrays.asList(fields);
            this.keywords = Arrays.asList(keywords);
        }

        @Override
        public Document toDocument(AggregationOperationContext context) {
            Document operation = new Document("$search", new Document(
                    "index", index
            ).append("wildcard", new Document(
                    "path", fields
            ).append("query", keywords).append("allowAnalyzedField", true)));
            return context.getMappedObject(operation);
        }
    }


}
