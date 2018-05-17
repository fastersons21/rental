package rt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rt.bean.rUserBean;
import rt.dao.rLoginDAO;


@WebServlet("/rLoginServlet")
public class rLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
//		PrintWriter out = response.getWriter();
//		//ログイン済みかどうかチェックする
//		HttpSession session = request.getSession(false);
//		if(session == null) {//セッションが無い場合
//			out.println("<html><head><title>login</title></head><body>");
//			out.println("<h1>ログインしてください</h1>");
//			return;
//		}else {//セッションは開始されているがログイン済みではない場合
//			String isLogin = (String)session.getAttribute("isLogin");
//			if(isLogin == null || !isLogin.equals("true")) {
//				out.println("<html><head><title>login</title></head><body>");
//				out.println("<h1>ログインしてください</h1>");
//				return;
//			}
//		}
		rLoginDAO dao = new rLoginDAO();
		ArrayList<rUserBean> list = dao.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("userLogin.jsp").forward(request,response);
		
		//actionリクエストパラメータの読み込み
		String action = request.getParameter("action");
		if(action.equals("login")) {
			//ログイン時はユーザー名とパスワードを取得する
			//パラメータのエラーチェックは省略

			String name=request.getParameter("name");
			String passWord=request.getParameter("pass");
			//ユーザー名とパスワードが一致したら
			if(name.equals(USER)&&passWord.equals(PASS)) {
				//セッション管理を行う
				HttpSession session = request.getSession();
				//ログイン済みの属性を設定する
				session.setAttribute("isLogin", "true");
				out.println("<html><head><title>AirRoomログインページ</title></head><body>");
				out.println("<h1>ログイン成功</h1>");
			}else {
				out.println("<html><head><title>AirRoomログイン失敗</title></head><body>");
				out.println("<h1>ユーザー名またはパスワードが違います</h1>");
			}
		}else if(action.equals("logout")) {//ログアウト時
			//すでに作成されているセッション領域を取得する。新しくは作成しない
			HttpSession session = request.getSession(false);
			if(session != null) {
				//セッション領域を無効にする
				session.invalidate();
				out.println("<html><head><title>ログアウト</title></head><body>");
				out.println("<h1>ログアウトしました</h1>");
			}
		}
		out.println("<a href='/rental/airRoom.jsp'>戻る</a>");
		out.println("</body></html>");
	}

}
