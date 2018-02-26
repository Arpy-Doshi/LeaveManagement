package com.brevitaz.dao.impl;

import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.LeavePolicyDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.LeavePolicy;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LeavePolicyDaoImpl implements LeavePolicyDao
{
    private final String INDEX_NAME = "leave-policy";
    private final String TYPE_NAME = "doc";

    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    ElasticConfig client;

    @Override
    public boolean create(LeavePolicy leavePolicy) throws IOException {
        IndexRequest request = new IndexRequest(
                INDEX_NAME,
                TYPE_NAME,leavePolicy.getId()
        );

        String json = objectMapper.writeValueAsString(leavePolicy);

        request.source(json, XContentType.JSON);

        IndexResponse indexResponse= client.getClient().index(request);

        System.out.println(indexResponse);

        return true;
    }


    @Override
    public boolean update(LeavePolicy leavePolicy,String id) throws IOException {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest updateRequest = new UpdateRequest(
                INDEX_NAME,TYPE_NAME,
                id).doc(objectMapper.writeValueAsString(leavePolicy), XContentType.JSON);
        UpdateResponse updateResponse = client.getClient().update(updateRequest);
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public boolean delete(String id) throws IOException {
        DeleteRequest request = new DeleteRequest(
                INDEX_NAME,
                TYPE_NAME,
                id);

        DeleteResponse response = client.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);
        return true;
    }

    @Override
    public LeavePolicy getById(String id) throws IOException {
        GetRequest getRequest = new GetRequest(
                INDEX_NAME,
                TYPE_NAME,
                id);

        GetResponse getResponse = client.getClient().get(getRequest);


        LeavePolicy leavePolicy  = objectMapper.readValue(getResponse.getSourceAsString(),LeavePolicy.class);


        System.out.println(leavePolicy);
        return leavePolicy;
    }

    @Override
    public List<LeavePolicy> getAll() throws IOException {
        List<LeavePolicy> leavePolicies = new ArrayList<>();
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);
        SearchResponse response = client.getClient().search(request);
        SearchHit[] hits = response.getHits().getHits();

        LeavePolicy leavePolicy;

        for (SearchHit hit : hits)
        {
            leavePolicy = objectMapper.readValue(hit.getSourceAsString(), LeavePolicy.class);
            leavePolicies.add(leavePolicy);
        }
        return leavePolicies;

    }


}
