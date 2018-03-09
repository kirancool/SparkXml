package com.sparkxml.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Repository;

import com.databricks.spark.xml.XmlReader;
@Repository("storeDao")
public class StoreDaoImpl implements StoreDao{

	 SparkSession ssc = SparkSession.builder().master("local").appName("test").getOrCreate();
  String inputfile="E:/offfff/SparkXml/src/main/resources/Stores.xml";  
  String Stores = "Store";
	public List<Map<String, Object>> getStoreData() {
		  SQLContext sqlContext = new SQLContext(ssc);
		    Dataset<Row> sq = (new XmlReader()).withRowTag(Stores).xmlFile(sqlContext, inputfile);
		 List<Map<String, Object>> stockList2 = new ArrayList<Map<String, Object>>();
		  Row[] dataRows = (Row[]) sq.collect();
		 
		  String[] columns = sq.columns();
		 
		    for (Row row : dataRows) {
		    		    		
		    	Map<String, Object> object= new HashMap<String, Object>();
		          
		        	   for(String column : columns)
		        	   {
		        		 
		        		   object.put(column, row.getAs(column));
		        		  
		        
		        	   }
		    
		        	   stockList2.add(object);
		    }

		return stockList2;
	}

}
