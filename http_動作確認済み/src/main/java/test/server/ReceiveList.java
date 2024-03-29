package test.server;
import java.util.ArrayList;
import java.util.Iterator; 

import org.springframework.integration.annotation.Payload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import phase1.server.console.*;
import phase1.server.logic.HttpReceiveFlightplan;

@Component
public class ReceiveList {
	
	static public int count =0;
	static public ArrayList<Object> list = new ArrayList<Object>();
	
	@ServiceActivator
	public String execute(
			@Payload Object object){
		String ret = "true";
		int result = 0;
		try{
			System.out.println("object = "+object);
			System.out.println("count ="+count);
			list.add(object);
			count++;
		
			if(count==21){
				Iterator<Object> it = list.iterator();
				while (it.hasNext()) {
					System.out.println("Server-List:");
					System.out.println(it.next());
				}
			//. S.川合作成分		
				HttpReceiveFlightplan ft = new HttpReceiveFlightplan();
				result = ft.FlightTest();
		    //. E.川合作成分
				list.clear();
				count=0;
				if (result == 0){
					ret = "false";
				}
				System.out.println("Server String:" + ret);				
			}
			return ret;

		}
		catch(Exception e){
			System.out.println("異常終了");
			ret = "false";
			return ret;
		}
	}
}