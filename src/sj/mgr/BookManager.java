package sj.mgr;

import java.util.List;

import sj.bean.BookBean;
import sj.dao.BookDAO;
import sj.dao.DAOException;


public class BookManager {

	// 全てのメンバの情報を取得
			public List<BookBean> findBookAll() throws DAOException {
				BookDAO dao = new BookDAO();
				return dao.findAllBook();
			}



}