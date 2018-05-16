package rt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import rt.bean.rUserBean;

public class rLoginDAO {
	private Connection con;

	public rLoginDAO() throws DAOException{
		getConnection();
	}

	public ArrayList<rUserBean> findAll() throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			String sql = "select * from user";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得及び表示
			ArrayList<rUserBean> list = new ArrayList<rUserBean>();
			while(rs.next()) {
				String name = rs.getString("name");
				String Password = rs.getString("password");
				rUserBean bean = new rUserBean(name,Password);
				list.add(bean);
			}
			//商品一覧をListとして返す
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}
	private void getConnection() throws DAOException{
		try {
			//JDBCドライバの登録
			Class.forName("com.mysql.cj.jdbc.Driver");
			//URL、ユーザー名、パスワードの設定
			String url= "jdbc:mysql://localhost/airroom?serverTimezone=UTC&useSSL=false";
			String user= "root";
			String pass="sht30";
			//データベースへの接続
			con = DriverManager.getConnection(url,user,pass);
		}catch (Exception e) {
			throw new DAOException("DBへの接続に失敗しました。");
		}
	}
	//SQLの例外を宣言してコネクションをcloseする
	private void close() throws SQLException{
		if(con != null) {
			con.close();
			con = null;
		}
	}
}
