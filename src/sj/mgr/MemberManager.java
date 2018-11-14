package sj.mgr;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import sj.bean.MemberBean;
import sj.dao.DAOException;
import sj.dao.MemberDAO;


public class MemberManager {

		// 会員情報を登録する
		public MemberBean registerMember(String name, String address, String tel, String email, Date birthday,
				Date admission, Date unsubscribe, String remarks) throws DAOException {
			MemberDAO dao = new MemberDAO();
			return dao.insertMember(name, address, tel, email, birthday, admission, unsubscribe, remarks);
		}

		// 全てのメンバの情報を取得
		public List<MemberBean> findMemberAll() throws DAOException {
			MemberDAO dao = new MemberDAO();
			return dao.findAllMember();

		}
		// IDで会員を検索する
			public List<MemberBean> searchMemberById(int id) throws DAOException {
				MemberDAO dao = new MemberDAO();
				return dao.findMemberById(id);
			}

		// 名前で会員を検索する
		public List<MemberBean> searchMemberByName(String name) throws DAOException {
			MemberDAO dao = new MemberDAO();
			return dao.findMemberByName(name);
		}

		// 電話番号で会員を検索する
		public List<MemberBean> searchMemberByTel(String tel) throws DAOException {
			MemberDAO dao = new MemberDAO();
			return dao.findMemberByTel(tel);
		}

		 //会員情報を変更する
		public MemberBean updateMemberInfo(int id, String name, String address, String tel, String email, Date birthday,
				Date admission, Date unsubscribe, String remarks) throws DAOException {
			MemberDAO dao = new MemberDAO();
			return dao.updateMember(id, name, address, tel, email, birthday, admission, unsubscribe, remarks);
		}

		//会員を退会する
		public MemberBean deleteMemberInfo(int id) throws DAOException{
			MemberDAO dao = new MemberDAO();
			return dao.unsubscribeMember(id);
		}


		public static java.sql.Date convDate(String str) throws ParseException{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d = sdf.parse(str);
			return new java.sql.Date(d.getTime());
		}



	}

