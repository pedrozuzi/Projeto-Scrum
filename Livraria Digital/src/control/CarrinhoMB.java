package control;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ItemPedido;
import model.Livro;

@ManagedBean
@SessionScoped
public class CarrinhoMB implements Serializable {
	private static final long serialVersionUID = 6298277515316475903L;
	
	private Map<Integer, ItemPedido> itemPedido;
	private int quantidade = 1;
	private ItemPedido ip;
	
	public CarrinhoMB() {
		itemPedido = new HashMap<Integer, ItemPedido>();
		ip = new ItemPedido();
	}
	
	public void adicionaLivro(Livro l) {
		ip.setLivro(l);
		ip.setValorUnitario(l.getPreco());
		ip.setQuantidade(quantidade);
		itemPedido.put(l.getId(), ip);
		ip = new ItemPedido();
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage("Seu carrinho tem :  " + itemPedido.size() + " Livro(s)" ));
	}
	
	public void excluirLivro(ItemPedido ip) {
		itemPedido.remove(ip.getLivro().getId());
	}
	
	/*
	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}*/
	
	public String totalAPagar() {
		double total = itemPedido.values().stream().mapToDouble( i -> i.getValorUnitario() * i.getQuantidade() ).sum();
		return String.format("%.2f", total);
	}

	public Map<Integer, ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(Map<Integer, ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
