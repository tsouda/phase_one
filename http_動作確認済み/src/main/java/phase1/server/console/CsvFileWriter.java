package phase1.server.console;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CsvFileWriter {
	
	boolean write_csv(ArrayList<Object> list,String file_path){
	
        try {
            //�o�͐��CSV�t�@�C�����w�肷��
        	FileWriter fw = new FileWriter(file_path, false); // �w�肵���p�X�A�t�@�C�����Ńt�@�C�����쐬
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

            // ���X�g�̒��g��\���B �P�̎������͖��ʂɏo�͂���Ă��܂����߁A�R�����g�A�E�g
//            Iterator<Object> it = list.iterator();
//            while (it.hasNext()) {
//            	System.out.println("List:");
//                System.out.println(it.next());
//            }
                       
            // �t�@�C���Ƀ��X�g�̒��g�������Ă���
            pw.print(list.get(0));  // DBC
            pw.println();
            
            pw.print(list.get(1));  // ������`��
            pw.print(",");
            pw.print(list.get(2));
            pw.println();
            
            pw.print(list.get(3));  // �o�x
            pw.print(",");
            pw.print(list.get(4));
            pw.print(",");
            pw.print(list.get(5));            
            pw.print(",");
            pw.print(list.get(6));
            pw.print(",");
            pw.print(list.get(7));  
            pw.print(",");
            pw.print(list.get(8));
            pw.println();
            
            pw.print(list.get(9));  // �ܓx
            pw.print(",");
            pw.print(list.get(10));
            pw.print(",");
            pw.print(list.get(11));            
            pw.print(",");
            pw.print(list.get(12));
            pw.print(",");          
            pw.print(list.get(13));
            pw.print(",");
            pw.print(list.get(14));
            pw.println();
            
            pw.print(list.get(15));  // ����
            pw.print(",");
            pw.print(list.get(16));
            pw.print(",");
            pw.print(list.get(17));            
            pw.print(",");
            pw.print(list.get(18));
            pw.print(",");
            pw.print(list.get(19));
            pw.print(",");
            pw.print(list.get(20));
            pw.println();

            //�t�@�C���ɏ����o��
            pw.close();

            //�I�����b�Z�[�W����ʂɏo�͂���
            System.out.println("�o�͂��������܂����B");
            System.out.println();
            return true;
        }
        catch(FileNotFoundException e){
        	System.out.println("�t�@�C�������݂��܂���");
        	System.out.println("�t�@�C���̃p�X���m�F���Ă�������");
        	return false;
        }
        catch (IOException ex) {
            //��O������
        	System.out.println("�ُ�I��");
            return false;
        }
        catch(Exception e){
            //��O������
        	System.out.println("�ُ�I��");
            return false;
        }
    }
}