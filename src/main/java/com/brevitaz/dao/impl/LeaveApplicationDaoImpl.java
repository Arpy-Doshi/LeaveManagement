package com.brevitaz.dao.impl;

import com.brevitaz.config.Config;
import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.LeaveApplicationDao;
import com.brevitaz.model.LeaveApplication;
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
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

@Repository
public class LeaveApplicationDaoImpl implements LeaveApplicationDao
{
    @Value("${LeaveApplication-Index-Name}")
    String indexName;

    private final String TYPE_NAME = "doc";

    @Autowired
    Config config;

    /*@Autowired
    ObjectMapper objectMapper;


    @Autowired
    ElasticConfig client;
*/
    @Override
    public boolean request(LeaveApplication leaveApplication) throws IOException {
        IndexRequest request = new IndexRequest(
                indexName,
                TYPE_NAME,leaveApplication.getId()
        );
        String json = config.getObjectMapper().writeValueAsString(leaveApplication);
        request.source(json, XContentType.JSON);
        IndexResponse indexResponse  = config.getClient().index(request);
        System.out.println(indexResponse);

        return true;
    }

    @Override
    public boolean cancelRequest(String id) throws IOException {
        DeleteRequest request = new DeleteRequest(
                indexName,
                TYPE_NAME,
                id);

        DeleteResponse response = config.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);
        return true;
    }

    @Override
    public boolean updateRequest(LeaveApplication leaveApplication,String id) throws IOException {
        config.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest request = new UpdateRequest(
                indexName,TYPE_NAME,
                id).doc(config.getObjectMapper().writeValueAsString(leaveApplication), XContentType.JSON);
        UpdateResponse updateResponse = config.getClient().update(request);
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public LeaveApplication checkStatus(String id) throws IOException {
        GetRequest getRequest = new GetRequest(
                indexName,
                TYPE_NAME,
                id);

        GetResponse getResponse = config.getClient().get(getRequest);
        LeaveApplication leaveApplication  = config.getObjectMapper().readValue(getResponse.getSourceAsString(),LeaveApplication.class);
        //System.out.println(leaveApplication.getStatus());
        return leaveApplication;
    }


    @Override
    public List<LeaveApplication> getById(String employeeId) throws IOException
    {
  /*      SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        sourceBuilder.query(QueryBuilders.boolQuery().must(termQuery("emp_id", eid)));
        request.source(sourceBuilder);

        SearchResponse response;
        List<LeaveApplication> leaveApplications=new ArrayList<>();

        response = client.getClient().search(request);

        SearchHit[] hits = response.getHits().getHits();

        LeaveApplication leaveApplication;
        for (SearchHit hit : hits)
        {
            leaveApplication = objectMapper.readValue(hit.getSourceAsString(), LeaveApplication.class);
            leaveApplications.add(leaveApplication);
        }

        return leaveApplications;


*/
        SearchRequest request = new SearchRequest(indexName);
        request.types(TYPE_NAME);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        sourceBuilder.query(QueryBuilders.boolQuery().must(matchQuery("employeeId", employeeId)));
        request.source(sourceBuilder);

        SearchResponse response;
        List<LeaveApplication> leaveApplications=new ArrayList<>();

        response = config.getClient().search(request);

        SearchHit[] hits = response.getHits().getHits();

        LeaveApplication leaveApplication;
        for (SearchHit hit : hits)
        {
            leaveApplication = config.getObjectMapper().readValue(hit.getSourceAsString(), LeaveApplication.class);
            leaveApplications.add(leaveApplication);
        }

        return leaveApplications;

    }


    @Override
    public List<LeaveApplication> checkRequest() throws IOException {
        SearchRequest request = new SearchRequest(indexName);
        request.types(TYPE_NAME);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        sourceBuilder.query(QueryBuilders.boolQuery().must(matchQuery("status", "APPLIED")));

        request.source(sourceBuilder);

        SearchResponse response;
        List<LeaveApplication> leaveApplications=new ArrayList<>();

        response = config.getClient().search(request);

        SearchHit[] hits = response.getHits().getHits();

        LeaveApplication leaveApplication;
        for (SearchHit hit : hits)
        {
            leaveApplication = config.getObjectMapper().readValue(hit.getSourceAsString(), LeaveApplication.class);
            leaveApplications.add(leaveApplication);
        }

        return leaveApplications;


    }

    @Override
    public boolean approveRequest(LeaveApplication leaveApplication,String id) throws IOException {
        config.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest request = new UpdateRequest(
                indexName,TYPE_NAME,
                id).doc(config.getObjectMapper().writeValueAsString(leaveApplication), XContentType.JSON);
        UpdateResponse updateResponse = config.getClient().update(request);
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public boolean declineRequest(LeaveApplication leaveApplication,String id) throws IOException {
        DeleteRequest request = new DeleteRequest(
                indexName,
                TYPE_NAME,
                id);

        DeleteResponse response = config.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);

        return true;
    }

    @Override
    public List<LeaveApplication> getAll() throws IOException {
        List<LeaveApplication> leaveApplications = new ArrayList<>();
        SearchRequest request = new SearchRequest(indexName);
        request.types(TYPE_NAME);
        SearchResponse response = config.getClient().search(request);
        SearchHit[] hits = response.getHits().getHits();

        LeaveApplication leaveApplication;

        for (SearchHit hit : hits)
        {
            leaveApplication = config.getObjectMapper().readValue(hit.getSourceAsString(), LeaveApplication.class);
            leaveApplications.add(leaveApplication);
        }
        return leaveApplications;

    }
}
