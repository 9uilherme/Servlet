package inf.ufg.br.model;

import java.math.BigDecimal;

public class Compra {

	private Carrinho carrinho;
	private BigDecimal total;
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
	
}
