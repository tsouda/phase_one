package test.server;

import java.io.Serializable;

import org.springframework.integration.annotation.Payload;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import phase1.server.bean.DbResultBean;

@Component
public class SampleService implements Serializable{
	
	@ServiceActivator
	/**public String execute(
			@Payload String param){
	
		//�����̕�����
		String ret = param + " test string";
		
		System.out.println("Server String:" + ret);
		
		return ret;

	}*/
	
	//DbResultBean�̃I�u�W�F�N�g�@�߂�l
	public DbResultBean obzi(
			@Payload String param){
		//DbResultBean�I�u�W�F�N�g�̐���
		DbResultBean brb = new DbResultBean();
		
		//�����̕�����
		//String ret = param + " test string";
		
		System.out.println("Server String:" + brb);
		//null�͂��܂�悭�Ȃ��݂����Ȃ̂Ŋi�[���܂����[
		brb.setDbconnectionflag(true);
		brb.setDbsearchflag(true);
		brb.setFlightplanlist(null);
		
		System.out.println("Server String:" + brb);
		return brb;

	}
}
