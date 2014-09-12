package phase1.server.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
//�e�X�g�p�C���|�[�g��
// import org.springframework.integration.samples.http.ClientAPDemo;






import phase1.server.bean.FlightPlanBean;
import phase1.server.logic.DatabaseService;

public class SelectDao {

	
	private short error = -1;//�G���[�l
	
	private SqlSession sqlSession;
	
	  public void setSqlSession(SqlSession sqlSession) {
		    this.sqlSession = sqlSession;
		  }
	  //�S������
		  public List<FlightPlanBean> selectAll()  {

			  List<FlightPlanBean> list =null;
			  try{
				 list = sqlSession.selectList("phase1.server.mapper.FlightPlanMapper.selectAll");
			  }catch(Exception e  ){
				  //�f�[�^�x�[�X�ڑ��G���[�̍ۂ́A���X�g�̍ŏ��̃I�u�W�F�N�g��DBC�Ƀ}�C�i�X�̒l�����ĕԋp����
				  FlightPlanBean bean = DatabaseService.CONTEXT.getBean("��ean",FlightPlanBean.class);
				  bean.setDbc(error);
				  list = new ArrayList<FlightPlanBean>();
				  list.add(bean);
				  e.printStackTrace();
				  System.out.println("�f�[�^�x�[�X�Ƃ̐ڑ��ɂ����ĉ��炩�̃G���[���������܂���");
			  }
			  //���X�g�̃T�C�Y���O�̏ꍇ�́A��������ż�Ȃ̂�null���l�߂�
			  if(list.size() ==0){
				  list = null;
			  }
			return  list;

		  }
		  
		//1������
		  public FlightPlanBean selectOne(short dbc) {
			  FlightPlanBean bean = DatabaseService.CONTEXT.getBean("��ean",FlightPlanBean.class);
			  try{
				  bean = sqlSession.selectOne("phase1.server.mapper.FlightPlanMapper.selectOne",dbc);
			  }catch(Exception e){
				  //�f�[�^�x�[�X�ڑ��G���[�̍ۂ́A�I�u�W�F�N�g��DBC�Ƀ}�C�i�X�̒l�����ĕԋp����
				  bean.setDbc(error);	
				  e.printStackTrace();
				  System.out.println("�f�[�^�x�[�X�Ƃ̐ڑ��ɂ����ĉ��炩�̃G���[���������܂���");
			  }
			  return  bean;
		  }
}
