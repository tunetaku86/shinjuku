package sj.dao;

import java.sql.Connection;
import java.sql.Date;
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
//登録
		//資料を新規で登録する
	public BookBean insertBook(long isbn, String name, int catcode, String author, String publisher, Date pubdate,
			String coverurl) throws DAOException{
		if (con == null)
			getConnection();
			PreparedStatement st = null;

		try {
			//SQL文の作成
			String sql = "INSERT INTO bookinfo(isbn, name, catcode, author, publisher, pubdate, coverurl)"
						+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//カテゴリの設定
			st.setLong(1, isbn);
			st.setString(2, name);
			st.setInt(3, catcode);
			st.setString(4, author);
			st.setString(5, publisher);
			st.setDate(6, pubdate);
			st.setString(7, coverurl);
			//sqlの実行
			st.executeUpdate();


		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}


//検索
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
						rs.getString("coverurl"));
				list.add(bean);
			}return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally{
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

		// isbnで資料検索
	public List<BookBean> findBookByISBN(long isbn) {
		return null;
	}



	public List<BookBean> findBookByName(String name) {
		// TODO 名前で検索
		return null;
	}



	public List<BookBean> findBookByauthor(String author) {
		// 作者で検索
		return null;
	}



	public List<BookBean> findBookBypublisher(String publisher) {
		//出版社で検索
		return null;
	}


//ソート
	public BookBean sortBook(Date pubdate) {
		// 登録日ソート
		return null;
	}


//削除
	public BookBean deleteBook(long isbn) {
		// 資料を削除
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




}
