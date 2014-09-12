package phase1.server.dao;



import org.apache.ibatis.session.SqlSession;





import phase1.server.bean.FlightPlanBean;

public class InsertDao {
	
	private SqlSession sqlSession;
	//���̃��\�b�h��Application-context.xml��ǂݍ��񂾎���Spring������Ɏ��s����
	public void setSqlSession(SqlSession sqlSession) {
		    this.sqlSession = sqlSession;
		  }
	  
		  public int insertOne(FlightPlanBean bean) {
			  
			  int result = 0;//�X�V���ʁB�X�V����������ƂP������

			  short dbc = bean.getDbc();
			  
			  try{
				  Integer number = sqlSession.selectOne("phase1.server.mapper.FlightPlanMapper.selectBeforeInsert",dbc);
			  if(0 == number){
				  	result =  sqlSession.update("phase1.server.mapper.FlightPlanMapper.insertOne",bean);
			  }else{//�C���T�[�g����DBC�Əd������t���C�g�v�������������ꍇ�͍폜���Ă���C���T�[�g����
				 //�d���̍폜
				sqlSession.update("phase1.server.mapper.FlightPlanMapper.deleteBeforeInsert",dbc);
				//�V�K���R�[�h�̑}��
				result =  sqlSession.update("phase1.server.mapper.FlightPlanMapper.insertOne",bean);
				  
			  }
			  }catch(Exception e){
				  e.printStackTrace();
				  System.out.println("�f�[�^�x�[�X�Ƃ̐ڑ��ɂ����ĉ��炩�̃G���[���������܂���");
			  }
		    return  result;

		  }
		  

}
