package com.myspace.rulesproject;

import java.util.*;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class DataFact implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	@org.kie.api.definition.type.Label("result")
	private java.lang.Double result;
	@org.kie.api.definition.type.Label("entryId")
	private java.lang.Integer entryId;

	public DataFact() {
	}

	public DataFact(java.lang.Integer entryId) {
		this.entryId = entryId;
	}

	public java.lang.Double getResult() {
		return this.result;
	}

	public void setResult(java.lang.Double result) {
		this.result = result;
	}

	public java.lang.Integer getEntryId() {
		return this.entryId;
	}

	public void setEntryId(java.lang.Integer entryId) {
		this.entryId = entryId;
	}

	public DataFact(java.lang.Double result, java.lang.Integer entryId) {
		this.result = result;
		this.entryId = entryId;
	}

	public List<DataFact> factoryListEntries() {
		List<DataFact> entries = Arrays.asList(new DataFact(1001),
				new DataFact(1002), new DataFact(1003));
		return entries;
	}

	public void addResultToListEntries(DataFact fact) {
		List<DataFact> dataList = factoryListEntries();
		for (DataFact obj : dataList)
			obj.setResult(fact.getResult());

		displayListData(dataList);
	}

	public void displayListData(List<DataFact> dataList) {

		for (DataFact obj : dataList)
			System.out.println("********************** \n Entry id:"
					+ obj.getEntryId() + "\n Result:" + obj.getResult() + "\n");
	}
}