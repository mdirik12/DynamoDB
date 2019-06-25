import java.util.Arrays;

import com.amazonaws.service.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.service.dynamodbv2.document.DynamoDB;
import com.amazonaws.service.dynamodbv2.document.Table;
import com.amazonaws.service.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.service.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.service.dynamobdv2.model.KeyType;
import com.amazonaws.servcie.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.service.dybamodbv2.model.ScalarAttributeType;

public class CreateTable
    public static void main(String[] args) throws Exception {
        AmazonDynamoDBClient client =new AmazonDynamoDBClient().withEndpoint("http://localhost:8000");
        DynamoDB dynamoDB =new DynamoDB(client);
        String tableName="Products";
        try{
            system.out.println("Table are being created, Please wait");
            Table table=dynamoDB.createTable (tableName, 
                Arrays.asList(
                new KeySchemaElement("ID",KeyType.HASH), 
                new KeySchemaElement("Nomenclature", KeyType.RANGE)
            ),
               Array.asList(
                   new KeySchemaDefinition("ID", ScalarAttributeType.N),
                   new KeySchemaDefinition("Nomenclature", ScalarAttributeType.S)
            ),
               new ProvisionedThroughtput(10L, 10L)
            );
            table.waitForActive();
            System.out.println("Table created sucessfully. Status:" + table.getDescription().getTableStatus());
        }
        catch (Exception e){
            System.err.println("Table cannot be created");
            System.err.println(e.getMessage());
        }
    }
}
