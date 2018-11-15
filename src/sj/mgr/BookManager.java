package sj.mgr;

import java.sql.Date;
import java.util.List;

import sj.bean.BookBean;
import sj.dao.BookDAO;
import sj.dao.DAOException;




public class BookManager {
	//登録
			//資料を新規で登録する
				public BookBean registBook(long isbn, String name, int catcode, String author, String publisher, Date pubdate,
											String coverurl)throws DAOException {
					BookDAO dao = new BookDAO();
					return  dao.insertBook(isbn, name, catcode, author, publisher, pubdate,coverurl);
				}

			//全てのメンバの情報を取得
				public List<BookBean> findBookAll() throws DAOException {
					BookDAO dao = new BookDAO();
					return dao.findAllBook();
				}
	//検索
			//ISBNで資料を検索する
				public List<BookBean> searchBookByISBN(long isbn) throws DAOException {
					BookDAO dao = new BookDAO();
					return dao.findBookByISBN(isbn);
				}

			// 名前で資料を検索する
			public List<BookBean> searchBookByName(String name) throws DAOException {
				BookDAO dao = new BookDAO();
				return dao.findBookByName(name);
				}

			// 作者で資料を検索する
			public List<BookBean> searchBookByAuthor(String author) throws DAOException {
				BookDAO dao = new BookDAO();
				return dao.findBookByauthor(author);
			}

			// 出版社で資料を検索する
			public List<BookBean> searchBookBypublisher(String publisher) throws DAOException {
				BookDAO dao = new BookDAO();
				return dao.findBookBypublisher(publisher);
			}
	//ソート
			//登録日順にソート
			public BookBean sortBook(Date pubdate) throws DAOException {
				BookDAO dao = new BookDAO();
				return dao.sortBook(pubdate);
			}
	//削除
			//登録済みの資料を削除
			public BookBean deleteBook(long isbn) throws DAOException{
				BookDAO dao = new BookDAO();
				return dao.deleteBook(isbn);
			}


}