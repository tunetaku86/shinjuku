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

import sj.bean.MemberBean;
import sj.mgr.MemberManager;


/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
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
			if(action == null||action.length() == 0||action.equals("return")){
					gotoPage(request,response,"/index.jsp");

			}else if(action.equals("member_new")){
					gotoPage(request, response, "/memberNew.jsp");

			}else if(action.equals("serch")){
					gotoPage(request, response, "/UI101management.jsp");
				//トップに戻る
			}else if (action.equals("return")) {
				gotoPage(request, response, "/index.jsp");

				//登録情報を取得して確認画面にフォワード
			}else if(action.equals("regist")){
				HttpSession session = request.getSession();
					String name = request.getParameter("name");
					String address = request.getParameter("address");
					String tel = request.getParameter("tel");
					String email = request.getParameter("email");
					Date birthday = convDate(request.getParameter("birthday"));
					Date admission = convDate(request.getParameter("admission"));
					String remarks = request.getParameter("remarks");
					MemberBean bean = new MemberBean(0, name, address, tel, email, birthday, admission, null, remarks);
					session.setAttribute("member", bean);
					gotoPage(request, response, "/confirm.jsp");

			//確認画面で会員情報を登録
			}else if(action.equals("regist2")){
					HttpSession session = request.getSession();
					MemberBean bean = (MemberBean)session.getAttribute("member");
					MemberManager mgr = new MemberManager();
					MemberBean rgstBean = mgr.registerMember(bean.getName(), bean.getAddress(), bean.getTel(), bean.getEmail(), bean.getBirthday(), bean.getAdmission(), bean.getUnsubscribe(), bean.getRemarks());
					session.setAttribute("registmember", rgstBean);
					gotoPage(request, response, "/UI101management.jsp");
			}else if(action.equals("return")){
					gotoPage(request, response, "/index");
			//会員検索
					//全件表示
			}else if (action.equals("findByAll")) {
					MemberManager mgr = new MemberManager();
					List<MemberBean> list = mgr.findMemberAll();
					request.setAttribute("members", list);
					gotoPage(request, response, "/UI101management.jsp");

			}else if (action.equals("id_search")) {
					//ID検索
					int id = Integer.parseInt(request.getParameter("id"));

					MemberManager mgr = new MemberManager();
					List<MemberBean> list = mgr.searchMemberById(id);
					request.setAttribute("members", list);
					gotoPage(request, response, "/UI101management.jsp");

			}else if (action.equals("name_search"))	{
					//名前検索
					String name = request.getParameter("name");

					MemberManager mgr = new MemberManager();
					List<MemberBean> list = mgr.searchMemberByName(name);
					request.setAttribute("members", list);
					gotoPage(request, response, "/UI101management.jsp");

			}else if(action.equals("tel_search")){
					//電話番号検索
					String tel = request.getParameter("tel");

					MemberManager mgr = new MemberManager();
					List<MemberBean> list = mgr.searchMemberByTel(tel);
					request.setAttribute("members", list);
					gotoPage(request, response, "/UI101management.jsp");

			}else if (action.equals("information")) {
					//IDクリックから登録内容の変更確認
					int id = Integer.parseInt(request.getParameter("id"));

					MemberManager mgr = new MemberManager();
					List<MemberBean> list = mgr.searchMemberById(id);
					request.setAttribute("members", list);
					gotoPage(request, response, "/change.jsp");

			} else if (action.equals("regist_change")) {
					//会員情報の変更

				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				Date birthday = convDate(request.getParameter("birthday"));
				Date admission = convDate(request.getParameter("admission"));
				String remarks = request.getParameter("remarks");
				MemberBean bean = new MemberBean(id, name, address, tel, email, birthday, admission, admission, remarks);
				MemberManager mgr = new MemberManager();
				MemberBean updateBean = mgr.updateMemberInfo(bean.getId(), bean.getName(), bean.getAddress(), bean.getTel(), bean.getEmail(), bean.getBirthday(), bean.getAdmission(), bean.getUnsubscribe(), bean.getRemarks());
				request.setAttribute("updatemember", updateBean);
				gotoPage(request, response, "/UI101management.jsp");

				/*HttpSession session = request.getSession();
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				Date birthday = convDate(request.getParameter("birthday"));
				Date admission = convDate(request.getParameter("admission"));
				Date unsubscribe = convDate(request.getParameter("unsubscribe"));
				String remarks = request.getParameter("remarks");
				MemberManager mgr = new MemberManager();
				MemberBean updatehbean = mgr.updateMemberInfo(id,name,address,tel,email,birthday,admission,unsubscribe,remarks);
				session.setAttribute("updateMember",updatehbean);
				gotoPage(request, response, "/UI101management.jsp");*/
			}




			}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request,response,"/errInternal.jsp");


		}

	}
		private void gotoPage(HttpServletRequest request,HttpServletResponse response,String page)throws ServletException,
						IOException{
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = sdf.parse(str);
		return new java.sql.Date(d.getTime());
	}
}