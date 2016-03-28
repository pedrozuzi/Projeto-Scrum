package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import sun.net.www.content.text.Generic;

abstract class GenericBEAN <T> implements Serializable{

	private List<T> listaPesquisa = new ArrayList<T>(); 
	private T objAtual;
}
