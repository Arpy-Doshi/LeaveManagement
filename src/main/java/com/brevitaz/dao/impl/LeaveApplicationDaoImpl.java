package com.brevitaz.dao.impl;

import com.brevitaz.config.ElasticConfig;
import com.brevitaz.dao.LeaveApplicationDao;
import com.brevitaz.model.Employee;
import com.brevitaz.model.LeaveApplication;
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
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

@Repository
public class LeaveApplicationDaoImpl implements LeaveApplicationDao
{
    private final String INDEX_NAME = "leave-application";
    private final String TYPE_NAME = "doc";

    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    ElasticConfig client;

    @Override
    public boolean request(LeaveApplication leaveApplication,String eid) throws IOException {
        IndexRequest request = new IndexRequest(
                INDEX_NAME,
                TYPE_NAME,""+leaveApplication.getId()
        );
        //ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(leaveApplication);
        request.source(json, XContentType.JSON);
        IndexResponse indexResponse= client.getClient().index(request);
        System.out.println(indexResponse);

        return true;
    }

    @Override
    public boolean cancelRequest(String eid,String lid) throws IOException {
        DeleteRequest request = new DeleteRequest(
                INDEX_NAME,
                TYPE_NAME,
                lid);

        DeleteResponse response = client.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);
        return true;
    }

    @Override
    public boolean updateRequest(LeaveApplication leaveApplication,String eid,String lid) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest request = new UpdateRequest(
                INDEX_NAME,TYPE_NAME,
                lid).doc(objectMapper.writeValueAsString(leaveApplication), XContentType.JSON);
        UpdateResponse updateResponse = client.getClient().update(request);
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public LeaveApplication checkStatus(String eid,String lid) throws IOException {
        GetRequest getRequest = new GetRequest(
                INDEX_NAME,
                TYPE_NAME,
                lid);

        GetResponse getResponse = client.getClient().get(getRequest);
        LeaveApplication leaveApplication  = objectMapper.readValue(getResponse.getSourceAsString(),LeaveApplication.class);
        System.out.println(leaveApplication.getStatus());
        return leaveApplication;
    }


    @Override
    public List<LeaveApplication> getById(String eid) throws IOException //remaining
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
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        sourceBuilder.query(QueryBuilders.boolQuery().must(matchQuery("emp_id", eid)));
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

    }

    @Override
    public List<LeaveApplication> checkRequest() throws IOException {
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        sourceBuilder.query(QueryBuilders.boolQuery().must(termQuery("status", "pending")));
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


    }

    @Override
    public boolean approveRequest(LeaveApplication leaveApplication,String eid,String lid) throws IOException {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        UpdateRequest request = new UpdateRequest(
                INDEX_NAME,TYPE_NAME,
                lid).doc(objectMapper.writeValueAsString(leaveApplication), XContentType.JSON);
        UpdateResponse updateResponse = client.getClient().update(request);
        System.out.println("Update: "+updateResponse);
        return true;
    }

    @Override
    public boolean declineRequest(LeaveApplication leaveApplication,String eid,String lid) throws IOException {
        DeleteRequest request = new DeleteRequest(
                INDEX_NAME,
                TYPE_NAME,
                lid);

        DeleteResponse response = client.getClient().delete(request);

        System.out.println(response.status());

        System.out.println(response);

        return true;
    }

    /*public List<LeaveApplication> getByDate(Date fromDate,Date toDate) throws IOException {

        LeaveApplication leaveApplication;
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        sourceBuilder.query(QueryBuilders.boolQuery().must(matchQuery("fromDate", eid)));
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

    }
*/
    @Override
    public List<LeaveApplication> getAll() throws IOException {
        List<LeaveApplication> leaveApplications = new ArrayList<>();
        SearchRequest request = new SearchRequest(INDEX_NAME);
        request.types(TYPE_NAME);
        SearchResponse response = client.getClient().search(request);
        SearchHit[] hits = response.getHits().getHits();

        LeaveApplication leaveApplication;

        for (SearchHit hit : hits)
        {
            leaveApplication = objectMapper.readValue(hit.getSourceAsString(), LeaveApplication.class);
            leaveApplications.add(leaveApplication);
        }
        return leaveApplications;

    }






}
