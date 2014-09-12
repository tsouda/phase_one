package phase1.client.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * �N���X��:FlightplanSearchValidator
 * �@�\:����DBC�l�̐��퐫����
 * ���\�b�h:private String sanitizing(String str)
 * 	     public boolean checkDBC(String chkDBC)
 * 		 public boolean validate(String strDBC)
 * 
 * 		OK:1�`32767�̔��p���l
 * 		NG:���̑��̐��l�A�����A�L��
 * 		���͒i�K�Ŕ��p���l5�P�^�ȊO�����e����Ă��Ȃ����߁A
 * 		���p�󔒂̏�����sanitaizing�͎����s�v�����ǎc��
 * 
 */

public class FlightplanSearchValidator {
	public static final short MIN_DBC = 1;		// �ŏ�DBC
	public static final short MAX_DBC = 32767;	// �ő�DBC

	public static final int NG = -1;	// ���ُ͈�
	public static final int OK_ONE = 1;	// �P�ꌟ��
	public static final int OK_ALL = 2;	// �S������

	
	// ���͕����̖��Q��
	public String sanitizing(String str){
System.out.println("FlightplanSearchValidator sanitizing ### START ###");
		// �����Ȃ��̏ꍇ�́A���̂܂ܖ߂�
		if (null == str || "".equals(str)) {
System.out.println("���͒l�Ȃ�");
System.out.println("FlightplanSearchValidator sanitizing ### END ###");
			return str;
		}
		
		// �󔒕����݂̂̔���
		if( "\b".equals(str) ||
			"\b\b".equals(str) ||
			"\b\b\b".equals(str) ||
			"\b\b\b\b".equals(str) ||
			"\b\b\b\b\b".equals(str) ||
			" ".equals(str) ||
			"  ".equals(str) ||
			"   ".equals(str) ||
			"    ".equals(str) ||
			"     ".equals(str)
	){
System.out.println("�󔒕����̂�");
System.out.println("FlightplanSearchValidator sanitizing ### END ###");
			return str;
		}
		
		// ���Q������
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("'", "&#39;");

System.out.println("���͒l����");
System.out.println("FlightplanSearchValidator sanitizing ### END ###");

		return str;
	}

	
	// ���l����1�`32767�͈̔͂�����
	public int checkDBC(String chkDBC){
System.out.println("FlightplanSearchValidator checkDBC ### START ###");

		// ���͒l�Ȃ�(��)�̏ꍇ�͑S�������̂���true�ԋp
		if(0 == chkDBC.length() || null == chkDBC){
System.out.println("�S������");
System.out.println("FlightplanSearchValidator checkDBC ### END ###");
			return OK_ALL;

		}
		
		// �󔒕����݂̂̔���
		if( "\b".equals(chkDBC) ||
			"\b\b".equals(chkDBC) ||
			"\b\b\b".equals(chkDBC) ||
			"\b\b\b\b".equals(chkDBC) ||
			"\b\b\b\b\b".equals(chkDBC) ||
			" ".equals(chkDBC) ||
			"  ".equals(chkDBC) ||
			"   ".equals(chkDBC) ||
			"    ".equals(chkDBC) ||
			"     ".equals(chkDBC)
		){
System.err.println("�󔒕����̂�");
System.out.println("FlightplanSearchValidator sanitizing ### END ###");
			return OK_ALL;
		}

		
		// ���������l������
		// ���l�`�F�b�N
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(chkDBC);
		if(true == m.find()){
			// ���l�݂̂ł���Δ͈͔���
			// �L���X�g(String����int)
			int intDBC=Integer.parseInt(chkDBC);
			if(MIN_DBC <= intDBC && MAX_DBC >=intDBC){
				// �͈͓�
System.out.println("�P�ꌟ��");
System.out.println("FlightplanSearchValidator checkDBC ### END ###");

				return OK_ONE;
			}else{
				// �͈͊O
System.out.println("���͒l�͈͊O");
System.out.println("FlightplanSearchValidator checkDBC ### END ###");
				return NG;
			}
		}else{

System.out.println("���͒l�����l�łȂ�");
System.out.println("FlightplanSearchValidator checkDBC ### END ###");
			// ���l�݂̂łȂ��A�������͔͈͊O�w��̏ꍇ
			return NG;
		}
	}
	
	// �O������̌Ăяo���p���\�b�h
//	public boolean validate(String strDBC){
	public int validate(String strDBC){
		
System.out.println("FlightplanSearchValidator validate ### START ###");
		// �����ϐ���`
		int ret = NG;	// ���ʊi�[�p

		// ���͒l�擾
		String chkDBC = sanitizing(strDBC);
		
		// ���͒l����
		ret = checkDBC(chkDBC);

System.out.println("���茋��ret:"+ret);
System.out.println("���͒lDBC:"+strDBC);
System.out.println("����pDBC:"+chkDBC);

System.out.println("FlightplanSearchValidator validate ### END ###");

		return ret;
	}
}
