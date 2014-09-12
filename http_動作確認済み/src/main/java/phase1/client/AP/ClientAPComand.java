package phase1.client.AP;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.Header;
import org.springframework.integration.annotation.Payload;
//����֐�
import phase1.server.bean.DbResultBean;

/**
 * �N���C�A���g-AP�T�[�o�Ԃ̃f�[�^���M�`���̎w��
 * @author machida
 *
 */


public interface ClientAPComand {

	@Gateway
	/**
	 * @param dataName
	 * @param request=dbc�̒l
	 * return=DbResultBean�I�u�W�F�N�g
	 */
	
	DbResultBean echo(
			@Header("dataName") Object dataName,
			@Payload String request);

}
