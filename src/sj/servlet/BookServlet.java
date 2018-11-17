package sj.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sj.bean.BookBean;
import sj.mgr.BookManager;


/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		request.setCharacterEncoding("UTF-8");

		//パラメータの解析
	String action = request.getParameter("action");

		//パラメータなしの場合,戻るの場合はトップページを表示
	if(action == null||action.length() == 0||action.equals("top_return")){
			gotoPage(request,response,"/index.jsp");

	}else if(action.equals("book_new")){
			gotoPage(request, response, "/BookNew.jsp");

	}else if(action.equals("book_serch")){
			gotoPage(request, response, "Bookmanagement.jsp");
		//会員画面に戻る
	}else if (action.equals("return")) {
		gotoPage(request, response, "/index.jsp");


	}else if (action.equals("regist")) {

		BookManager mgr = new BookManager();
		HttpSession session = request.getSession();
			String isbn = request.getParameter("isbn");
			String name = request.getParameter("name");
			int catcode = Integer.parseInt(request.getParameter("catcode"));
			String author = request.getParameter("author");
			String publisher = request.getParameter("publisher");
			Date pubdate = convDate(request.getParameter("pubdate"));
			String coverurl = request.getParameter("coverurl");
			BookBean bean = new BookBean(isbn, name, catcode, author, publisher, pubdate, coverurl);
			session.setAttribute("book", bean);
			gotoPage(request, response, "/confirmBook.jsp");



	}else if(action.equals("regist2")){
		HttpSession session = request.getSession();
		BookBean bean = (BookBean)session.getAttribute("book");
		BookManager mgr = new BookManager();
		BookBean rgstBean = mgr.registBook(bean.getIsbn(), bean.getName(), bean.getCatcode(), bean.getAuthor(), bean.getPublisher(), bean.getPubdate(), bean.getCoverurl());
		session.setAttribute("registbook", rgstBean);
		gotoPage(request, response, "/Bookmanagement.jsp");

	}else if (action.equals("findByAll")) {
		//全件表示
		BookManager mgr = new BookManager();
		List<BookBean> list = mgr.findBookAll();
		request.setAttribute("books", list);
		gotoPage(request, response, "/Bookmanagement.jsp");


	}else if (action.equals("isbn_search")) {

		BookManager mgr = new BookManager();
		String isbn = request.getParameter("isbn");
		List<BookBean> list = mgr.searchBookByISBN(isbn);
		request.setAttribute("books", list);
		gotoPage(request, response, "/Bookmanagement.jsp");


	}else if (action.equals("name_search")) {

		BookManager mgr = new BookManager();
		String name = request.getParameter("name");
		List<BookBean> list = mgr.searchBookByName(name);
		request.setAttribute("books", list);
		gotoPage(request, response, "/Bookmanagement.jsp");


	}else if (action.equals("author_search")) {

		BookManager mgr = new BookManager();
		String author = request.getParameter("author");
		List<BookBean> list = mgr.searchBookByAuthor(author);
		request.setAttribute("books", list);
		gotoPage(request, response, "/Bookmanagement.jsp");


	}else if (action.equals("publisher_search")) {

		BookManager mgr = new BookManager();
		String publisher = request.getParameter("publisher");
		List<BookBean> list = mgr.searchBookBypublisher(publisher);
		request.setAttribute("books", list);
		gotoPage(request, response, "/Bookmanagement.jsp");


	}else if (action.equals("information")) {
		//ISBNクリックから資料情報の確認
		String isbn = request.getParameter("isbn");

		BookManager mgr = new BookManager();
		List<BookBean> list = mgr.searchBookByISBN(isbn);
		request.setAttribute("books", list);
		gotoPage(request, response, "bookinfo.jsp");

}
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("message", "内部エラーが発生しました。");
		gotoPage(request,response,"/errInternal.jsp");

	}


	}
	private void gotoPage(HttpServletRequest request,HttpServletResponse response,String page)throws ServletException,IOException{
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}



	private static java.sql.Date convDate(String str) throws ParseException{
		if (str == "") {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = sdf.parse(str);
		return new java.sql.Date(d.getTime());
	}

}
