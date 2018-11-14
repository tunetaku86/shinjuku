package sj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//全件表示
	}else if (action.equals("findByAll")) {

		BookManager mgr = new BookManager();
		List<BookBean> list = mgr.findBookAll();
		request.setAttribute("books", list);
		gotoPage(request, response, "/Bookmanagement.jsp");


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

}
