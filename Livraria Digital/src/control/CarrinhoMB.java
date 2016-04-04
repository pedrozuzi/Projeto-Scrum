package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import model.ItemPedido;
import model.Livro;

@ManagedBean
@SessionScoped
public class CarrinhoMB implements Serializable {
	private static final long serialVersionUID = 6298277515316475903L;
	
	private List<ItemPedido> itemPedido;
	private int quantidade;
	
	public CarrinhoMB() {
		itemPedido = new ArrayList<ItemPedido>();
	}
	
	public void adicionaLivro(Livro l) {
		ItemPedido ip = new ItemPedido();
		ip.setLivro(l);
		ip.setValorUnitario(l.getPreco());
		ip.setQuantidade(quantidade);
		itemPedido.add(ip);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage("Seu carrinho tem :  " + itemPedido.size() + " Livro(s)" ));
	}
	
	public void excluirLivro(ItemPedido ip) {
		itemPedido.remove(ip);
	}
	
	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
	
	public double totalAPagar() {
		return itemPedido.stream().mapToDouble(i -> i.getValorUnitario()).sum() * quantidade;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
