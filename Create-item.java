package com.amazonaws.codesamples.document;
import java.io.IOExpection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.service.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.service.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.service.dynamodbv2.document.DynamoDB;
import com.amazonaws.service.dynamodbv2.document.Item;
import com.amazonaws.service.dynamodbv2.document.Table;

import com.amazonaws.service.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.service.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.service.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.service.dynamodbv2.document.utils.NameMap;
import com.amazonaws.service.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.service.dynamodbv2.model.ReturnValue;

public class CreateITem{
    static DynamoDB dynamoDB =new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()));
    static String TableName ="ProductList";
    public static void main(String[] args) throws IOExpection{
        CreateITems();
        retrieveItem();

        // Execute Updates
        updateMultipleAtrributes();
        updateAddNewAttribute();
        updateExistingAttributeConditionally();

        // Delete item from DynamoDB
        deleteItem();
    }
    private static void CreateNewItems(){
        Table table =dynamoDB.getTable(TableName);
        try {
            Item item =new Item()
            .withPrimaryKey("ID", 303)
            .withString("Nomenclature", "Product One")
            .withStringSet("Manufacturess", new HashSet<String>(Array.asList("Man1", "Man 2")))
            .withNumber("Price",230)
            .withBoolen("On Sale", true)
            .withString("Category", "Home Decor");
            
            //Put items on the table
            table.putItem(item);  
            item = new Item() 
            .withPrimaryKey("ID", 313) 
            .withString("Nomenclature", "Agitatatron 2000") 
            .withStringSet( "Manufacturers", 
            new HashSet<String>(Arrays.asList("XYZ Inc,", "CDE Inc."))) 
            .withNumber("Price", 40000) 
            .withBoolean("InProduction", true) 
            .withString("Category", "Agitator"); 
         
         table.putItem(item);
        }
        catch (Exception e) {
            System.err.println("Items cannot be created");
            System.err.println(e.getMessage());
        }
      
    }
}