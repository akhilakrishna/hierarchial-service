#hierarchical-service

- To build this service: It will create a hierarchical-service.jar  in target folder <br />
mvn clean install

- To run the jar : <br />
java -jar hierarchical-service.jar


It has been tested for following inputs:

//String input = "null,0,grandpa|0,1,son|0,2,daugther|1,3,grandkid|1,4,grandkid|2,5,grandkid|5,6,greatgrandkid"; //working <br />
//String input = "1,4,grandkid|2,5,grandkid|5,6,greatgrandkid|null,0,grandpa|0,1,son|0,2,daugther|1,3,grandkid"; //working <br />
//String input = "1,4,grandkid"; // No Root Node Found <br />
//String input = ""; // No Root Node Found <br />
//String input = "null,0,grandpa|0,1,son|0,2,daugther|2,5,grandkid|5,6,greatgrandkid"; //working		 <br />
//String input = "123,21,21,2,"; // No Root Node Found <br />
		
null,0,grandpa|0,1,son|0,2,daugther|1,3,grandkid|1,4,grandkid|2,5,grandkid|5,6,greatgrandkid
      
User can control indentation with INDENTATION in HierarchicalApplication class.