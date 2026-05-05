package test;

import java.util.ArrayList;
import java.util.List;

import dao.ProductsDAO;
import model.Product;

/**
 * 商品DAOテストクラス
 */
public class ProductsDAOTest {
	public static void main(String[] args) {
//		testFindAllOK();	// 商品リストが見つかるテスト
//		testFindAllNG();	// 商品リストが見つからないテスト
//		testFindByCategoryNameOK();		// カテゴリ名で商品リストが見つかるテスト
//		testFindByCategoryNameNG();		// カテゴリ名で商品リストが見つからないテスト
//		testFindByProductIdOK();		// 商品IDで商品が見つかるテスト
//		testFindByProductIdNG();		// 商品IDで商品が見つからないテスト	
	}
	
	public static void testFindAllOK() {
		ProductsDAO dao = new ProductsDAO();
		List<Product> productList = new ArrayList<>();
		productList = dao.findAll();
		if(productList != null) {
			System.out.println("testFindAllOK：成功しました");
		} else {
			System.out.println("testFindAllOK：失敗しました");
		}
	}
	
	public static void testFindAllNG() {
		ProductsDAO dao = new ProductsDAO();
		List<Product> productList = new ArrayList<>();
		productList = dao.findAll();
		productList = null;
		if(productList == null) {
			System.out.println("testFindAllNG：成功しました");
		} else {
			System.out.println("testFindAllNG：失敗しました");
		}
	}
	
	public static void testFindByCategoryNameOK() {
		ProductsDAO dao = new ProductsDAO();
		List<Product> productList = new ArrayList<>();
		productList = dao.findByCategoryName("ワイン");
		if(productList != null) {
			System.out.println("testFindAllOK：成功しました");
		} else {
			System.out.println("testFindAllOK：失敗しました");
		}
	}
	
	public static void testFindByCategoryNameNG() {
		ProductsDAO dao = new ProductsDAO();
		List<Product> productList = new ArrayList<>();
		productList = dao.findByCategoryName("ワイン");
		productList = null;
		if(productList == null) {
			System.out.println("testFindAllNG：成功しました");
		} else {
			System.out.println("testFindAllNG：失敗しました");
		}
	}
	
	public static void testFindByProductIdOK() {
		ProductsDAO dao = new ProductsDAO();
		Product product = dao.findByProductId(1);
		if(product != null) {
			System.out.println("testFindByProductIdOK：成功しました");
		} else {
			System.out.println("testFindByProductIdOK：失敗しました");
		}
	}
	
	public static void testFindByProductIdNG() {
		ProductsDAO dao = new ProductsDAO();
		Product product = dao.findByProductId(1);
		product = null;
		if(product == null) {
			System.out.println("testFindByProductIdNG：成功しました");
		} else {
			System.out.println("testFindByProductIdNG：失敗しました");
		}
	}
}
