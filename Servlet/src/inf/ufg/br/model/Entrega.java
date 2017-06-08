package inf.ufg.br.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Entrega {
	private String rua;
	private String cep;
	private String num;

	public Entrega(String rua, String cep, String num) {
		this.rua = rua;
		this.cep = cep;
		this.num = num;
	}

	public static class ListaEntrega {
		private static ListaEntrega instance;
		private LinkedList<Entrega> listaEntrega;

		private ListaEntrega() {
			this.listaEntrega = new LinkedList<Entrega>();
		}
		
		public void listar(){
			int cont = 1;
			Iterator<Entrega> i = listaEntrega.iterator();
			while(i.hasNext()){
				i.next();
				System.out.println(cont);
				cont++;
			}
		}
		
		public void addListaEntrega(Entrega ent){
			this.listaEntrega.add(ent);
		}

		public static ListaEntrega getInstanceOf() {
			if (instance == null) {
				instance = new ListaEntrega();
			}
			return instance;
		}
	}
}
