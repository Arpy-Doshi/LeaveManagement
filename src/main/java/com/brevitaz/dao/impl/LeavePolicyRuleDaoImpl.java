package com.brevitaz.dao.impl;

import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.LeavePolicyRuleDao;
import com.brevitaz.model.LeavePolicyRule;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeavePolicyRuleDaoImpl implements LeavePolicyRuleDao
{
    @Value("${LeavePolicyRule-Index-Name}")
    String indexName;

    private final String TYPE_NAME = "doc";

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ElasticConfig client;

    @Override
    public boolean create(LeavePolicyRule leavePolicyRule) throws IOException {
        IndexRequest request = new IndexRequest(
                indexName,
                TYPE_NAME,leavePolicyRule.getId()
        );

        String json = objectMapper.writeValueAsString(leavePolicyRule);

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= client.getClient().index(request);

        System.out.println(indexResponse);

        return true;
    }


    @Override
    public boolean update(LeavePolicyRule leavePolicyRule,String id) throws IOException {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest updateRequest = new UpdateRequest(
                indexName,TYPE_NAME,
                id).doc(objectMapper.writeValueAsString(leavePolicyRule), XContentType.JSON);
        UpdateResponse updateResponse = client.getClient().update(updateRequest);
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public boolean delete(String id) throws IOException {
        DeleteRequest request = new DeleteRequest(
                indexName,
                TYPE_NAME,
                id);

        DeleteResponse response = client.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);
        return true;
    }

    @Override
    public LeavePolicyRule getById(String id) throws IOException {
        GetRequest getRequest = new GetRequest(
                indexName,
                TYPE_NAME,
                id);

        GetResponse getResponse = client.getClient().get(getRequest);


        LeavePolicyRule leavePolicyRule  = objectMapper.readValue(getResponse.getSourceAsString(),LeavePolicyRule.class);


        return leavePolicyRule;
    }

    @Override
    public List<LeavePolicyRule> getAll() throws IOException {
        List<LeavePolicyRule> leavePolicyRules = new ArrayList<>();
        SearchRequest request = new SearchRequest(indexName);
        request.types(TYPE_NAME);
        SearchResponse response = client.getClient().search(request);
        SearchHit[] hits = response.getHits().getHits();

        LeavePolicyRule leavePolicyRule;

        for (SearchHit hit : hits)
        {
            leavePolicyRule = objectMapper.readValue(hit.getSourceAsString(), LeavePolicyRule.class);
            leavePolicyRules.add(leavePolicyRule);
        }
        return leavePolicyRules;

    }


}
