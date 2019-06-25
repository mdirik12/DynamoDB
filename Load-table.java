import java.io.File;
import java.util.Iterator;

import com.amazonaws.service.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TableLoadData{
    public static void main(String[] args) throws Exception{
        AmazonDynamoDBClient client=new AmazonDynamoDBClient().withEndpoint("http://localhost:8000");
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = new dynamoDB.getTable("Products");
        JsonParser parser = new JsonFactory().createPArser(new File("productinfo.json"));

        JsonNode rootNode = new ObjectMapper().readThree(parser);
        Iterator<JsonNode> iter =rootNode.iterator();
        ObjectNode currentNode;

        while (iter.hasNext())
        {
            currentNode = (ObjectNode) iter.next();
            int ID =currentNode.path("ID").asInt();
            String Nomenclature = currentNode.path("Nomenclature").asText();
            
            try {
                table.putItem(new Item()
                .withPrimaryKey("ID", ID, "Nomenclature", Nomenclature)
                .withJSON("Stat", currentNode.path("Stat").toString()));
                System.out.println("Table Loaded Successful" + ID + "" + Nomenclature);

            }
            catch(Exception e){
                 System.err.println("Product cannot be added to table" + ID + "" + Nomenclature);
                 System.err.println(e.getMessage());
                 break;
          
            }
        }
        parser.close();
    }
}