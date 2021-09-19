package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataSetUp(){
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 66);
        expectedData.put("title", "Wash the dishes,man");
        expectedData.put("completed", false);
        return expectedData;
    }


}