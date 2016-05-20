package model;

import java.util.Date;

public class Pedido {

	private long numeroPedido;
	private static Date data;
	private static Date hora;
	private static String status;
	public long getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public static Date getData() {
		return data;
	}
	public static void setData(Date data) {
		Pedido.data = data;
	}
	public static Date getHora() {
		return hora;
	}
	public static void setHora(Date hora) {
		Pedido.hora = hora;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
