package phase1.server.bean;

import java.io.Serializable;
import java.util.ArrayList;

import phase1.server.bean.FlightPlanBean;

public class DbResultBean implements Serializable{

		//�p�����[�^
		private boolean dbConnectionFlag;
		private boolean dbSearchFlag;
		private ArrayList<FlightPlanBean> list;
		
		/**
		 * setter
		 */
		//DB�ڑ��m�F
		public void setDbconnectionflag(boolean dbConnectionFlag){
			this.dbConnectionFlag = dbConnectionFlag;
		}
		//��������
		public void setDbsearchflag(boolean dbSearchFlag){
			this.dbSearchFlag = dbSearchFlag;
		}
		//���X�g
		public void setFlightplanlist(ArrayList<FlightPlanBean> list){
			this.list = list;
		}
		
		/**
		 * getter
		 */
		//DB�ڑ��m�F
		public boolean getDbconnectionflag(){
			return dbConnectionFlag;
		}
		//��������
		public boolean getDbsearchflag(){
			return dbSearchFlag;
		}
		//���X�g
		public ArrayList<FlightPlanBean> getFlightplanlist(){
			return list;
		}
}
