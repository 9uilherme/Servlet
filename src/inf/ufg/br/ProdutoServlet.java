package inf.ufg.br;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import inf.ufg.br.model.Carrinho;
import inf.ufg.br.model.Compra;

//import com.google.gson.Gson;

import inf.ufg.br.model.Produto;

/**
 * Servlet implementation class MercadoServlet
 */@WebServlet(name = "produtoServlet", urlPatterns = {"/produtoServlet"})
 public class ProdutoServlet extends HttpServlet {

	   private static final String PRODUTO = "PRODUTO";
	   private static final String CARRINHO = "CARRINHO";
	   private static final String COMPRAS = "COMPRAS";
	   
	   Compra compra = new Compra();
	   Carrinho carrinho = new Carrinho();
	   List<Produto> produtos = new ArrayList<Produto>();

	   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       response.setContentType("text/html;charset=UTF-8");
	       
	       if(request.getParameter("tipo").equals(PRODUTO)){
	    	   Produto produto = new Produto();
	    	   
	    	   produto.setNome(request.getParameter("nome"));
	    	   produto.setCodigo(request.getParameter("codigo"));
	    	   produto.setPreco(new BigDecimal(Double.parseDouble(request.getParameter("preco"))));
	    	   
	    	   produtos.add(produto);
	    	   
	    	   try (PrintWriter out = response.getWriter()) {
	    		   out.println("<!DOCTYPE html>");
	    		   out.println("<html>");
	    		   out.println("<head>");
	    		   out.println("<title>Servlet ProdutoServlet</title>");            
	    		   out.println("</head>");
	    		   out.println("<body>");
	    		   out.println("<h1>Produto:</h1>");
	    		   out.println("<h1>Codigo: " + produto.getCodigo() + "</h1>");
	    		   out.println("<h1>Nome: " + produto.getNome() + "</h1>");
	    		   out.println("<h1>Preço: " + produto.getPreco().doubleValue() + "</h1>");
	    		   out.println("<a href='produto.html'>Voltar</a>");
	    		   
	    		   out.println("</body>");
	    		   out.println("</html>");
	    	   }
	    	   
	       }else if(request.getParameter("tipo").equals(CARRINHO)){
	    	   carrinho.setProdutos(produtos);
	    	   
	    	   try (PrintWriter out = response.getWriter()) {
	    		   out.println("<!DOCTYPE html>");
	    		   out.println("<html>");
	    		   out.println("<head>");
	    		   out.println("<title>Servlet ProdutoServlet</title>");            
	    		   out.println("</head>");
	    		   out.println("<body>");
	    		   out.println("<a href='compras.html'>Voltar</a>");
	    		   out.println("</body>");
	    		   out.println("</html>");
	    	   }
	       }else if(request.getParameter("tipo").equals(COMPRAS)){
	    	   List<Produto> produtos = carrinho.getProdutos();
	    	   Iterator <?> itProd = produtos.iterator();

	    	   while(itProd.hasNext()){
	    		   
	    		   Produto produto = (Produto) itProd.next();
	    		   
	    		   if(request.getParameter("codigo") == produto.getCodigo()){
	    			   
		    		   produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		    		   produto.setSubtotal(new BigDecimal(Double.parseDouble(request.getParameter("subtotal"))));
	    		   }
	    	   }
	    	   
	    	   try (PrintWriter out = response.getWriter()) {
	    		   out.println("<!DOCTYPE html>");
	    		   out.println("<html>");
	    		   out.println("<head>");
	    		   out.println("<title>Servlet ProdutoServlet</title>");            
	    		   out.println("</head>");
	    		   out.println("<body>");
	    		   out.println("<a href='entrega.html'>Voltar</a>");
	    		   out.println("</body>");
	    		   out.println("</html>");
	    	   }
	       }
	   }

	   @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       
           String json = new Gson().toJson(produtos);
           response.setContentType("application/json");
           response.getWriter().write(json);
	
	   }	
	   
	   @Override
	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	       processRequest(request, response);
	   }
	
	   @Override
	   public String getServletInfo() {
	       return "Short description";
	   }
	   
 }