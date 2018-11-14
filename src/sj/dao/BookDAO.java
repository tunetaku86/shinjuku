package sj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sj.bean.BookBean;


public class BookDAO {
	private Connection con;

	public  BookDAO() throws DAOException {
		getConnection();
	}

	//本の情報を全件取得
	//findAllBook
	public List<BookBean> findAllBook() throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//SQL文の作成
			String sql = "SELECT * FROM bookinfo ORDER BY isbn";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<BookBean> list = new ArrayList<BookBean>();
			while (rs.next()) {
			BookBean bean = new BookBean(
									rs.getLong("isbn"),
									rs.getString("name"),
									rs.getInt("catcode"),
									rs.getString("author"),
									rs.getString("publisher"),
									rs.getDate("pubdate"),
									rs.getString("coverurl"))
					;
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

}
