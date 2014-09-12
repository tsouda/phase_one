package phase1.server.console;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HttpSendFlightplan {
	
	private static Logger logger = Logger.getLogger(HttpSendFlightplan.class);
	
	public boolean file_send(ArrayList<Object> list){

		if(list.isEmpty()){ // �ǂݏo�����ŃK�[�h���Ă��邪�A�O�̂���
			System.out.println("���X�g����ł�");
			return false;
		}
		
		if(list.size()!=21){
			System.out.println("���X�g�ɐݒ肳��Ă���p�����[�^�ɕs��������܂�");
			return false;
		}

		System.out.println("�t���C�g�v�����̏���AP�T�[�o�֑��M���܂�");
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration/http-outbound-config.xml");
		RequestGateway requestGateway_console = context.getBean("requestGateway_console", RequestGateway.class);
		try{
			for(int i =0;i<list.size();i++){
				String ans = requestGateway_console.File_send(list.get(i));
				if(ans.equals("true")){
					logger.info("Replied with: " + ans);
					System.out.println("reply:" + ans);
				}
				else{
					System.out.println("�T�[�o����G���[����M���܂���");
					return false;
				}
			}
		}
		catch(Exception e){
			System.out.println("�ُ�I��");
			return false;
		}
		// ����I��
		return true;
	}
}