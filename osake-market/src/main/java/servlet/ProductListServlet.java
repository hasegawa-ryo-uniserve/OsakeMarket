package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductListLogic;

/**
 * 商品リスト一覧サーブレット
 */
@WebServlet("/product/list")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * dpGetメソッド
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String categoryName = request.getParameter("categoryName");
		
		ProductListLogic logic = new ProductListLogic();
		List<Product> productList = new ArrayList<>();
		
		// リクエストパラメータがnullなら商品一覧を取得する
		if (categoryName == null) {
			productList = logic.findAll();			
		} else {
			switch(categoryName) {
				case "wine":
					categoryName = "ワイン";
					break;
				case "sparklingWine":
					categoryName = "スパークリングワイン";
					break;
				case "whisky":
					categoryName = "ウイスキー";
					break;
				case "brandy":
					categoryName = "ブランデー";
					break;
				case "shochu":
					categoryName = "焼酎";
					break;
				case "japaneseSake":
					categoryName = "日本酒";
					break;
				case "liqueur":
					categoryName = "リキュール";
					break;
				case "beer":
					categoryName = "ビール";
					break;
				case "food":
					categoryName = "おつまみ";
					break;
				default:
					categoryName = null;
					break;
			}
			productList = logic.findByCategoryName(categoryName);
		}
		if(productList != null) {	// 商品リスト一覧が見つかった場合
			// リクエストスコープに格納してフォワード
			request.setAttribute("productList", productList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/productList.jsp");
			dispatcher.forward(request, response);
		} else { // 商品一覧が見つからなかった場合
			// エラーメッセージをリクエストスコープに格納してフォワード
			request.setAttribute("errorMsg", "商品一覧が見つかりませんでした");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
