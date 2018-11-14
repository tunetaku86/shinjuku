package sj.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sj.bean.MemberBean;

public class MemberDAO {
	private Connection con;

	public MemberDAO() throws DAOException{
		getConnection();
	}
	//新規会員登録
	public MemberBean insertMember(String name, String address, String tel, String email, Date birthday, Date admission,
			Date unsubscribe, String remarks) throws DAOException {
		if (con == null)
			getConnection();
		int id = 0;
		try {
			id = getNextId(con, "member_id_seq");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		PreparedStatement st = null;
		try {
			// SQL文の作成
			String sql = "INSERT into public.member "
							+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// カテゴリの設定
			st.setInt(1,id);
			st.setString(2,name);
			st.setString(3,address);
			st.setString(4,tel);
			st.setString(5,email);
			st.setDate(6,birthday);
			st.setDate(7,admission);
			st.setDate(8,unsubscribe);
			st.setString(9,remarks);
			// SQLの実行
			 st.executeUpdate();

	} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの追加に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
		return null;
	}


	//検索(全件表示)
	//findMemberAll()
	public List<MemberBean> findAllMember() throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//SQL文の作成
			String sql = "SELECT * FROM member ORDER BY id";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<MemberBean> list = new ArrayList<MemberBean>();
			while (rs.next()) { //next()メソッドは一行ずつ呼び出す・データがなくなるとfalseを渡すのでwhile文を抜ける
			MemberBean bean = new MemberBean(
									rs.getInt("id"),
									rs.getString("name"),
									rs.getString("address"),
									rs.getString("tel"),
									rs.getString("email"),
									rs.getDate("birthday"),
									rs.getDate("admission"),
									rs.getDate("unsubscribe"),
									rs.getString("remarks"));
							list.add(bean);
						}	return list;
					} catch (SQLException e) {
						e.printStackTrace();
						throw new DAOException("レコードの取得に失敗しました。");
					} finally {
						try {
							// リソースの開放
							if(rs != null) rs.close();
							if(st != null) st.close();
							close();
						} catch (Exception e) {
							throw new DAOException("リソースの開放に失敗しました。");
						}
					}
	}
	//検索(名前)
		//findMemberByName(String name)
		public List<MemberBean> findMemberByName(String name) throws DAOException {
			if (con == null)
				getConnection();

			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				String sql = "SELECT id, name, address, tel, email, birthday, admission, unsubscribe, remarks "
								+ "FROM member WHERE name LIKE ?";

				// PreparedStatementオブジェクトの取得
				st = con.prepareStatement(sql);
				// カテゴリの設定
				st.setString(1,"%" + name + "%");
				// SQLの実行
				rs = st.executeQuery();
				// 結果の取得および表示
				List<MemberBean> list = new ArrayList<MemberBean>();
				while (rs.next()) {
					MemberBean bean = new MemberBean(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("address"),
							rs.getString("tel"),
							rs.getString("email"),
							rs.getDate("birthday"),
							rs.getDate("admission"),
							rs.getDate("unsubscribe"),
							rs.getString("remarks"));
					list.add(bean);

				}	return list;
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("レコードの取得に失敗しました。");
			} finally {
				try {
					// リソースの開放
					if(rs != null) rs.close();
					if(st != null) st.close();
					close();
				} catch (Exception e) {
					throw new DAOException("リソースの開放に失敗しました。");
				}
			}
		}	//検索(tel)
	//findMemberByTel(String tel)
	public List<MemberBean> findMemberByTel(String tel) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id, name, address, tel, email, birthday, admission, unsubscribe, remarks "
							+ "FROM member WHERE tel LIKE ?";

			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// カテゴリの設定
			st.setString(1,"%" + tel + "%");
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<MemberBean> list = new ArrayList<MemberBean>();
			while (rs.next()) {
				MemberBean bean = new MemberBean(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("address"),
						rs.getString("tel"),
						rs.getString("email"),
						rs.getDate("birthday"),
						rs.getDate("admission"),
						rs.getDate("unsubscribe"),
						rs.getString("remarks"));
				list.add(bean);

			}	return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}
	//検索(ID)
	//findMemberById(int id)
	public List<MemberBean> findMemberById(int id) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id, name, address, tel, email, birthday, admission, unsubscribe, remarks "
							+ "FROM member WHERE id = ?";

			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// カテゴリの設定
			st.setInt(1, id);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<MemberBean> list = new ArrayList<MemberBean>();
			while (rs.next()) {
				MemberBean bean = new MemberBean(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("address"),
						rs.getString("tel"),
						rs.getString("email"),
						rs.getDate("birthday"),
						rs.getDate("admission"),
						rs.getDate("unsubscribe"),
						rs.getString("remarks"));
				list.add(bean);

			}	return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}
	//会員情報の変更
	public MemberBean updateMember(int id,String name,String address,String tel,String email,Date birthday, Date admission,Date unsubscribe,String remarks) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			String sql = "UPDATE member SET "
					+"name = COALESCE(?,name), "
					+"address = COALESCE(?,address), "
					+"tel = COALESCE(?,tel), "
					+"email = COALESCE(?,email), "
					+"birthday = COALESCE(?,birthday), "
					+"admission = COALESCE(?,admission), "
					+"unsubscribe = COALESCE(?,unsubscribe),"
					+"remarks = COALESCE(?,remarks) "
					+"WHERE id = ?";
			/* String sql = "UPDATE member set "
												+"name = COALESCE(?,name), "
												+"address = COALESCE(?,address), "
												+"tel = COALESCE(?,tel), "
												+"email = COALESCE(?,email), "
												+"birthday = COALESCE(?,birthday), "
												+"admission = COALESCE(?,admission), "
												+"unsubscribe = COALESCE(?,unsubscribe), "
												+"remarks = COALESCE(?,remarks) "
												+"WHERE id = ?";
			*/
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// カテゴリの設定
			st.setString(1, name);
			st.setString(2, address);
			st.setString(3, tel);
			st.setString(4, email);
			st.setDate(5, birthday);
			st.setDate(6, admission);
			st.setDate(7, unsubscribe);
			st.setString(8, remarks);
			st.setInt(9, id);
			// SQLの実行
			st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
	}
		return null;
	}



	//*会員の退会*//
	public MemberBean unsubscribeMember(int id) throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			String sql = "UPDATE member SET "
						+ "unsubscribe = CURRENT_TIMESTAMP "
						+ "WHERE id = ?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);

			st.setInt(1, id);

			// SQLの実行
			st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		} finally {
			try {
				// リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
		return null;

	}



	private void getConnection() throws DAOException {
		try {
			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			// URL、ユーザ名、パスワードの設定
			String url = "jdbc:postgresql:libshinjuku";
			String user = "tune";
			String pass = "himitu";
			// データベースへの接続
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("接続に失敗しました。");
		}
	}
	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

	private int getNextId(Connection con, String seq) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		int id = 0;
		try {
			String sql = "SELECT nextval(?)";
			st = con.prepareStatement(sql);
			st.setString(1, seq);
			rs = st.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		}
		finally {
			rs.close();
			st.close();
		}
		return id;
	}
	public static void main(String[] args) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static java.sql.Date convDate(String str) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = sdf.parse(str);
		return new java.sql.Date(d.getTime());
	}
}
