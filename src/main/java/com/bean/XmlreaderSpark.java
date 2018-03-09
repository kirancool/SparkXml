package com.bean;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

import com.databricks.spark.xml.XmlReader;

public class XmlreaderSpark {
	
    public static void main(String arr[])
    {
    String localxml="E:\\offfff\\SparkXml\\src\\main\\resources\\Stores.xml";
    String Stores = "Store";
    SparkSession spark = SparkSession
              .builder()
              .master("local")
              .appName("Java Spark SQL Example")
              .getOrCreate();
    SQLContext sqlContext = new SQLContext(spark);

    Dataset<Row> df = (new XmlReader()).withRowTag(Stores).xmlFile(sqlContext, localxml);
    df.show();

    }
}