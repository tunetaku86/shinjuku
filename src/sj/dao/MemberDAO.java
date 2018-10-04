package sj.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MemberDAO {
	private Connection con;

	public MemberDAO() throws DAOException{

	}
	//新規会員登録
	//insertMember(String name, String address, String tel, String email, Date birthday, Date admission,
	//Date unsubscribe, String remarks)


	//検索(全件表示)
	//findMemberAll()

	//検索(名前)
	//findMemberByName(String name)

	//検索(tel)
	//findMemberByTel(String tel)

	//検索(ID)
	//findMemberById(int id)

	private void getConnection() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			// URL、ユーザ名、パスワードの設定
			String url = "jdbc:postgresql:libshinjuku";
			String user = "postgres";
			String pass = "himitu";
			// データベースへの接続
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("接続に失敗しました。");
		}
	}

}
