package ch01_fundamental;

import java.util.HashMap;
import java.util.LinkedList;

public class Basket {
	
	public HashMap<String,String> map = new HashMap<>();
	
	public  void add(EntryVO entry) {
		boolean dupli = map.containsKey(entry.getName());
		System.out.println("duplicate:"+dupli);
		if(dupli) {
				try {
					throw new Exception();
				} catch (Exception e) {
					return;
				}
				
		}
		map.put(entry.getName(),entry.getEtcs());
	}
	public EntryVO entryFor(String name) {
		EntryVO entry =null;
		if(map.get(name)!=null){
			entry = new EntryVO(name,map.get(name));
		}
		return entry;
	}
	public boolean contains(EntryVO entry){
		return map.containsKey(entry.getName());
	}
}

