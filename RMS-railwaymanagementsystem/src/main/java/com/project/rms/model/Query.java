package com.project.rms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Queries")
public class Query {
	
	@Id
	String queryId;
	
	String userEmail;
	String userQuery;
	
	public Query() {
		
	}
	
	public Query(String userEmail, String userQuery) {
		this.userEmail = userEmail;
		this.userQuery = userQuery;
	}

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserQuery() {
		return userQuery;
	}

	public void setUserQuery(String userQuery) {
		this.userQuery = userQuery;
	}

	@Override
	public String toString() {
		return "Query [queryId=" + queryId + ", userEmail=" + userEmail + ", userQuery=" + userQuery + "]";
	}

}
