package phase1.server.console;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.*;

public class CsvFileReader {

		public boolean check_file(String ss,int count){ // �����̃t���C�g�v������ǂݍ��܂����ۂ̗v�f�̊m�F�p
		// ���l�̊m�F�p�̃v�����g���B�P�̎����̍ۂɖ��ʂɏo�͂���Ă��܂����߁A�R�����g�A�E�g�B
//		System.out.println("ss="+ss+":count="+count);

		switch(count){
	    case 0: // DBC
           	try{
           		Object obj  = Integer.parseInt(ss);  // ���͂����l��int�^�ȊO�̏ꍇ�A�����ŗ�O����������̂ŃK�[�h�����Ƃ��Ďg�p����
           	}
           	catch(Exception e){
           		System.out.println("DBC_�ُ�l���o :"+count);
           		return false;
           	}
	    		break;
	    case 1: // ������`
	    case 2:
            if ((ss.matches(".*[@����u��v\\d:�F!#$%&'\"()-=^~|?_.*\\[\\]\\{\\}\\<\\>/]+.*") )) {
            	System.out.println("��`��_�ُ�l���o:"+count);
            	return false;
            }
	    	break;
	    case 3: // �o�x�A�ܓx
	    case 4:
	    case 5:
	    case 6:
	    case 7:
	    case 8:
	    case 9:
	    case 10:
	    case 11:
	    case 12:
	    case 13:
	    case 14:
        	try{
        		Object obj  = Double.parseDouble(ss);  // ���͂����l��double�^�ȊO�̏ꍇ�A�����ŗ�O����������̂ŃK�[�h�����Ƃ��Ďg�p����
        	}
        	catch(Exception e){
        		System.out.println("�o�x�A�ܓx_�ُ�l���o:"+count);
        		return false;
        	}
	    	break;
	    case 15: // ����
	    case 16:
	    case 17:
	    case 18:
	    case 19:
	    case 20:
            if(!ss.matches("([0-1][0-9]|[2][0-3])[:][0-5][0-9].*")){ // HH:MM �̕\�L�ɂȂ��Ă��邩 10:00�`23:59
            	if(ss.matches("([0-9])[:][0-5][0-9].*")){ // 0:00 �` 09:59�܂ł�OK
            		if(ss.length()!=4){ // 0:00 �` 09:59 �̌��ɗ]�v�ȕ��������Ă���ꍇ��NG
            			System.out.println("�����ُ팟�o_�����O�X�ُ�_1:"+count);
            			return false;
            		}
            		break;
            	}
                System.out.println("�����ُ팟�o:"+count);
            	return false;
            }
        	if(ss.length()!=5){ // HH:MM�̌��ɗ]�v�ȕ��������Ă��Ȃ���
    			System.out.println("�����ُ팟�o_�����O�X�ُ�_2:"+count);
    			return false;	
        	}
	    	break;
       	
	    default :
	    	break; 
	    }    	
		return true;
	} 

	public boolean file_read(String file_path,ArrayList<Object> read_list){ // �����̃t���C�g�v�����̓ǂݍ��ݎ��Ɏg�p
		
        try{                       
	        //�t�@�C����ǂݍ���
	        FileReader fr = new FileReader(file_path);
	        BufferedReader br = new BufferedReader(fr);
        	
	        //�ǂݍ��񂾃t�@�C�����P�s����������
	        String line;
	        int count = 0;
	        while ((line = br.readLine()) != null) {

	           	// ��؂蕶��","�ŕ�������
	            String [] ss = line.split(","); 
	           
	            // �ǂݍ��񂾃t�@�C���̒��g�����
	            for(int i=0;i<ss.length;i++){
	            	
	            	// ���l�̊m�F�p�̃v�����g���B�P�̎����̍ۂɖ��ʂɏo�͂���Ă��܂����߁A�R�����g�A�E�g�B
//	            	System.out.println("SS[i]= "+ss[i]+" ss_length="+ss.length);
//	            	System.out.println("i="+i+" count="+count);
	            	
	            	// ���X�g�̗v�f�̃`�F�b�N
	            	boolean ans = check_file(ss[i],count);
	            	if(ans!=true){	            	
	            		br.close();
	            		read_list.clear(); // check_file��false���Ԃ��Ă�����A���X�g����ɂ���
	            		return false;
	            	}
	            	// ���Ȃ���΃��X�g�Ƀt�@�C������ǂݍ��񂾒l��ǉ�
	            	read_list.add(ss[i]);
	            	count++;
	            }
	            
     	         // ���l�̊m�F�p�̃v�����g���B�P�̎����̍ۂɖ��ʂɏo�͂���Ă��܂����߁A�R�����g�A�E�g�B
//	            System.out.println("#####");
	        }  	       
	        
    	     // ���l�̊m�F�p�̃v�����g���B�P�̎����̍ۂɖ��ʂɏo�͂���Ă��܂����߁A�R�����g�A�E�g�B
//	        for(int j=0;j<read_list.size();j++){
//	        	System.out.println("SS[i] ="+read_list.get(j));
//	        }	        
	        
	        //�I������
	        br.close();
	        System.out.println("�����t�@�C���̓ǂݍ��݂��������܂���");
	        return true;
	    }
        catch(FileNotFoundException e){
        	System.out.println("�t�@�C����������܂���");
        	return false;
        }
	    catch (IOException ex) {
	        //��O����������
	        ex.printStackTrace();
	        return false;
	    }
	} 
}