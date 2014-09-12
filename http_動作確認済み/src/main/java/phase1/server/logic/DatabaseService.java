package phase1.server.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import phase1.server.bean.FlightPlanBean;
import phase1.server.bean.FlightPlanBeanListBean;
import phase1.server.dao.InsertDao;
import phase1.server.dao.SelectDao;

public class DatabaseService {
	//�A�v���P�[�V�����R���e�N�X�X�g���X�^�e�B�b�N�Ő錾�@������DB�ڑ��N���X�݂�ȂŒ��ǂ��g��
	//�Ƃ���ŁADB�ڑ��N���X�ȊO���A�v���P�[�V�����R���e�L�X�g���g�p����Ǝv�����A����������͂��Ȃ��̂��낤���H
	public static  ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
		
	private boolean success = true;
	private boolean failed = false;
	public String arrival = null;
	boolean successFlg = failed;// DB�ڑ����ʃt���O

	/**
	 * �����ŋ�� �S������
	 * 
	 * @return
	 */
	
	public FlightPlanBeanListBean executeSelect() {
		FlightPlanBeanListBean listBean = CONTEXT.getBean(
				"listBean", FlightPlanBeanListBean.class);
		SelectDao selectDao = CONTEXT.getBean("selectDao",
				SelectDao.class);
		// �������s
		List<FlightPlanBean> list = selectDao.selectAll();

		// ���X�g��ArrayList�ɕϊ�����
		ArrayList<FlightPlanBean> arrayList = (ArrayList<FlightPlanBean>) list;

		// ��ڂ̃��X�g�v�f�����o����DB�̐ڑ����ʂ𒲂ׂ�
		if (arrayList != null) {

			FlightPlanBean bean = arrayList.get(0);

			// DB�ڑ��Ɏ��s�����ꍇ�͈�ԍŏ��̃��X�g��DBC�Ɂ[�P�������Ă���
			if (bean.getDbc() != -1) {
				successFlg = success;

			} else {// DB�ڑ����s�̃p�^�[���̓��X�g��null�ɂ���
				arrayList = null;
			}
			// null���Ԃ��Ă����ꍇ�́A�����Ώۂ��Ȃ��������Ƃ�����

		} else {
			successFlg = success;
		}
		listBean.setSuccessflg(successFlg);
		listBean.setFlightListBeanList(arrayList);
		return listBean;
	}

	/**
	 * �ꌏ����
	 * 
	 * @param dbc
	 * @return
	 */
	public FlightPlanBeanListBean executeSelect(short dbc) {

		SelectDao selectDao = CONTEXT.getBean("selectDao",
				SelectDao.class);
		FlightPlanBeanListBean listBean = CONTEXT.getBean(
				"listBean", FlightPlanBeanListBean.class);

		FlightPlanBean bean = selectDao.selectOne(dbc);

		// ���X�g�r�[���̓��X�g���i�[���邱�ƂɂȂ��Ă���̂ŁA���X�g�𐶐����Č������ʃr�[�����i�[����
		ArrayList<FlightPlanBean> arrayList = new ArrayList<FlightPlanBean>();
		arrayList.add(bean);
		// �������ʂ̗L���`�F�b�N
		if (bean != null) {
			// DB�ڑ��Ɏ��s�����ꍇ��DBC�Ɂ[�P�������Ă���
			if (bean.getDbc() != -1) {
				successFlg = success;
			} else {
				// DN�ڑ����s�̏ꍇ�̓��X�g��null�ɂ���
				arrayList = null;
			}
		} else {//���������O�̃P�[�X
			successFlg = success;
			arrayList = null;
		}
		// ���X�g�r�[���Ƀt���O�ƃ��X�g��˂�����
		listBean.setFlightListBeanList(arrayList);

		listBean.setSuccessflg(successFlg);
		return listBean;
	}

	/**
	 * 
	 * @param bean
	 * @return
	 */
	public boolean executeInsert(FlightPlanBean bean) {
		boolean successFlg = failed;

			InsertDao insertDao = CONTEXT.getBean("insertDao",
					InsertDao.class);
			int result = insertDao.insertOne(bean);
			if (result == 1) {
				successFlg = success;
			}

		return successFlg;
	}
}
