package phase1.server.console;

import java.util.ArrayList;
import java.util.Scanner;

public class SetupFlightplan {
	
	// �t���C�g�v���������ɕK�v�ȏ���ݒ肷�郁�\�b�h
	public boolean FlightPlanSetting (ArrayList<Object> setup_list){
		
		Scanner scanner = new Scanner(System.in); 
		
		// DBC��ݒ�
        System.out.print("1:DBC(�����̂݋��e) ��");
        String s = scanner.nextLine();  // ���͂����l����U�ێ�
        if(s.equals("")){ // �󕶎���������
        	System.out.println("�󕶎����o");
        	return false;
        }
        else{
        	try{
        		Object obj  = Integer.parseInt(s);  // ���͂����l��int�^�ȊO�̏ꍇ�A�����ŗ�O����������̂ŃK�[�h�����Ƃ��Ďg�p����
        		setup_list.add(obj);  // int�^�̏ꍇ�A��O���������Ȃ����߁A���X�g�ɒǉ�����B
        	}
        	catch(Exception e){
        		System.out.println("�ُ�l���o");
        		return false;
        	}
        }
        
        // ����`��ݒ�
        System.out.print("2:����`(���ꕶ���A�����͔񋖗e)�@��");
        String s2 = scanner.nextLine();  // ���͂����l����U�ێ�
        if(s2.equals("")){ // �󕶎���������
        	System.out.println("�󕶎����o");
        	return false;
        }
        else{
        	// ���ꕶ���A�����͏��O
            if ((s2.matches(".*[@����u��v\\d:�F!#$%&'\"()-=^~|?_.*\\[\\]\\{\\}\\<\\>/]+.*") )) {
            	System.out.println("�ُ�l���o");
            	return false;
            }
            else{
            	// ����l�̂��߁A���X�g�ɒǉ�
            	setup_list.add(s2);
            }
        }
        
        // ����`��ݒ�
        System.out.print("3:����`(���ꕶ���A�����͔񋖗e) ��");
        String s3 = scanner.nextLine();  // ���͂����l����U�ێ�
        if(s3.equals("")){ // �󕶎���������
        	System.out.println("�󕶎����o");
        	return false;
        }
        else{
        	// ���ꕶ���A�����͏��O
            if ((s3.matches(".*[@����u��v\\d:�F!#$%&'\"()-=^~|?_.*\\[\\]\\{\\}\\<\\>/]+.*") )) {
            	System.out.println("�ُ�l���o");
            	return false;
            }
            else{
            	// ����l�̂��߁A���X�g�ɒǉ�
            	setup_list.add(s3);
            }
        }

        // �o�x��ݒ�
        System.out.println("4:�o�x(6�ݒ肵�Ă�������_���l(�����_�t�����܂�)�̂݋��e");
        for(int i=1;i<=6;i++){
        	System.out.print(i+"�ځ�");
            String s4 = scanner.nextLine();  // ���͂����l����U�ێ�
            if(s4.equals("")){ // �󕶎���������
            	System.out.println("�󕶎����o");
            	return false;
            }
            else{
            	try{
            		Object obj  = Double.parseDouble(s4);  // ���͂����l��double�^�ȊO�̏ꍇ�A�����ŗ�O����������̂ŃK�[�h�����Ƃ��Ďg�p����
            		setup_list.add(obj);  // double�^�̏ꍇ�A��O���������Ȃ����߁A���X�g�ɒǉ�����B
            	}
            	catch(Exception e){
            		System.out.println("�ُ�l���o");
            		return false;
            	}
            }
        }
        
        // �ܓx��ݒ�
        System.out.println("5:�ܓx(6�ݒ肵�Ă�������_���l(�����_�t�����܂�)�̂݋��e");
        for(int i=1;i<=6;i++){
        	System.out.print(i+"�ځ�");
            String s5 = scanner.nextLine();  // ���͂����l����U�ێ�
            if(s5.equals("")){ // �󕶎���������
            	System.out.println("�󕶎����o");
            	return false;
            }
            else{
            	try{
            		Object obj  = Double.parseDouble(s5);  // ���͂����l��double�^�ȊO�̏ꍇ�A�����ŗ�O����������̂ŃK�[�h�����Ƃ��Ďg�p����
            		setup_list.add(obj);  // double�^�̏ꍇ�A��O���������Ȃ����߁A���X�g�ɒǉ�����B
            	}
            	catch(Exception e){
            		System.out.println("�ُ�l���o");
            		return false;
            	}
            }
        }
        
        // ���Ԃ�ݒ�
        System.out.println("6:����(6�ݒ肵�Ă�������_HH:MM�`���̂݋��e)");
        for(int i=1;i<=6;i++){
        	System.out.print(i+"�ځ�");
        	String s6 = scanner.nextLine();  // ���͂����l����U�ێ�
            if (s6.equals("")) { // �󕶎��A�����ُ펞
            	System.out.println("�󕶎����o");
                return false;
            }
            
            // �����ُ킩�ǂ����𔻒�
            if(!s6.matches("([0-1][0-9]|[2][0-3])[:][0-5][0-9].*")){ // HH:MM ���ǂ����𔻒�
            	if(s6.matches("([0-9])[:][0-5][0-9].*")){ // H:MM �ɂ��Ă͋��e
            		if(s6.length()!=4){  // H:MM �̌��ɗ]�v�ȕ��������Ă��Ȃ���
            		    System.out.println("�����O�X�ُ�_H:MM");
            		    return false;
            		}
            		else{
            			// H:MM �̐���l�̏ꍇ
            			setup_list.add(s6);
            		}
            	}
            	else{ // HH:MM�ȊO�̏ꍇ
            		System.out.println("�����ُ팟�o��");
            		return false;
            	}
            }
            else{ // HH:MM�̏ꍇ
            	if(s6.length()!=5){ // HH:MM �̌��ɗ]�v�ȕ��������Ă��Ȃ�������
            		System.out.println("�����O�X�ُ�_HH:MM");
            		return false;
            	}
            	else{
            		// HH:MM �̐���l�̏ꍇ
            		setup_list.add(s6);
            	}
            }
        }
        
        System.out.print("���X�g�ɂ͈ȉ��̗v�f���}������܂����B");
        System.out.println(setup_list.toString());
        System.out.println();
        
        return true;
	}
}