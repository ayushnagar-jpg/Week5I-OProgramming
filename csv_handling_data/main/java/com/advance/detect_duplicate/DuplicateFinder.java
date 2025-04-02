package com.advance.detect_duplicate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DuplicateFinder {
	public Set<String>getDuplicate(String filePath){
		Set<String>unique = new HashSet();
		Set<String>duplicate = new HashSet();
		String delimiter = ",";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			if((line = br.readLine())!=null) {
				System.out.println(line);
			}
			while((line = br.readLine())!=null) {
				String[]person = line.split(delimiter);
				
				String id = person[0].trim();
				
				if(unique.contains(id)) {
					duplicate.add(line);
				}
				else {
					unique.add(id);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return duplicate;
	}
}
