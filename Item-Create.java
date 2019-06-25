DynamoDB dynamoDB = new DynamoDB (new AmazonDynamoDBClient(
   new ProfileCredentialsProvider()));
Table table = dynamoDB.getTable("ProductList");
   
// Spawn a related items list 
List<Number> RELItems = new ArrayList<Number>(); 
RELItems.add(123); 
RELItems.add(456); 
RELItems.add(789);  
   
//Spawn a product picture map  
Map<String, String> photos = new HashMap<String, String>(); 
photos.put("Anterior", "http://xyz.com/products/101_front.jpg"); 
photos.put("Posterior", "http://xyz.com/products/101_back.jpg"); 
photos.put("Lateral", "http://xyz.com/products/101_LFTside.jpg");  

//Spawn a product review map 
Map<String, List<String>> prodReviews = new HashMap<String, List<String>>();  
List<String> fiveStarRVW = new ArrayList<String>(); 
fiveStarRVW.add("Shocking high performance."); 
fiveStarRVW.add("Unparalleled in its market."); 
prodReviews.put("5 Star", fiveStarRVW);  
List<String> oneStarRVW = new ArrayList<String>(); 
oneStarRVW.add("The worst offering in its market."); 
prodReviews.put("1 Star", oneStarRVW);  

// Generate the item 
Item item = new Item()
   .withPrimaryKey("Id", 101) 
   .withString("Nomenclature", "PolyBlaster 101") 
   .withString("Description", "101 description") 
   .withString("Category", "Hybrid Power Polymer Cutter")  
   .withString("Make", "Brand – XYZ") 
   .withNumber("Price", 50000) 
   .withString("ProductCategory", "Laser Cutter") 
   .withBoolean("Availability", true) 
   .withNull("Qty") 
   .withList("ItemsRelated", RELItems) 
   .withMap("Images", photos) 
   .withMap("Reviews", prodReviews);

// Add item to the table  
PutItemOutcome outcome = table.putItem(item);