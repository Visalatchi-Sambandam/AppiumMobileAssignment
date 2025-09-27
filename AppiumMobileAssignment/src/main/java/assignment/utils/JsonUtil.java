package assignment.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static List<Map<String, String>> readDataFromJson(String fileName) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Map<String, String>> map = mapper.readValue(new File(fileName), new TypeReference<List<Map<String, String>>>() {});
			return map;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Failed to read JSON file: " + fileName, e);
		}
	}

}
