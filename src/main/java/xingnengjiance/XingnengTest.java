package xingnengjiance;

import java.util.ArrayList;
import java.util.List;

public class XingnengTest {

	public static void main(String[] args) throws InterruptedException {
		fillHeap(1000);
		
		System.gc();
	}
	
	
	
	public static void fillHeap(int num) throws InterruptedException {
		
		List<OOMObject> list = new ArrayList<OOMObject>();
		for (int i = 0; i < num; i++) {
			
			Thread.sleep(100);
			
			list.add(new OOMObject());
			
		}
		
	}
}
