package rt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rt.bean.rItemBean;
import rt.dao.DAOException;
import rt.dao.rItemDAO;

@WebServlet("/airroom")
public class AirRoomServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			//パラメータの解析
			String action = request.getParameter("action");
			//モデルのDAOを生成
			rItemDAO dao = new rItemDAO();
			//パラメータなしの場合は全レコード表示
			if(action == null || action.length() == 0) {
				List<rItemBean> list = dao.findAll();
				//ListをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items", list);
				gotoPage(request,response,"/airRoom.jsp");
				//addは追加
			}else if(action.equals("add")) {
				String name = request.getParameter("name");
				int stock = Integer.parseInt(request.getParameter("stock"));
				int price = Integer.parseInt(request.getParameter("price"));
				dao.addItem(name,stock,price);
				//追加後、全レコード表示
				List<rItemBean> list= dao.findAll();
				//ListをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items", list);
				gotoPage(request,response,"/airRoom.jsp");
			}
			//sortはソート
			else if(action.equals("sort")) {
				String key = request.getParameter("key");
				List<rItemBean> list;
				if(key.equals("price_asc"))
					list = dao.sortPrice(true);
				else
					list = dao.sortPrice(false);
				//ListをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items",list);
				gotoPage(request,response,"/airRoom.jsp");
			}
			//searchは結果
			else if(action.equals("search")) {
				int price = Integer.parseInt(request.getParameter("price"));
				List<rItemBean> list = dao.findByPrice(price);
				//ListをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items", list);
				gotoPage(request,response,"/airRoom.jsp");
			}
			//deleteは削除
			else if(action.equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				dao.deleteByPrimaryKey(id);
				//削除後、全レコード表示
				List<rItemBean> list = dao.findAll();
				//ListをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items", list);
				gotoPage(request,response,"/airRoom.jsp");
			}else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request,response,"/goErrInternal.jsp");
			}
		}catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request,response,"/goErrInternal.jsp");
		}
	}

	protected void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
