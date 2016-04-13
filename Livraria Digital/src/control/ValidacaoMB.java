package control;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@FacesValidator(value = "validaMB")
@ViewScoped
public class ValidacaoMB implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valorTela) throws ValidatorException {
		if (!validaCNPJ(String.valueOf(valorTela))) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary(
					ResourceBundle.getBundle(FacesContext.getCurrentInstance().getApplication().getMessageBundle())
							.getString("erro.validacao.cnpj"));
			throw new ValidatorException(message);
		}
	}

	public static boolean validaCNPJ(String cnpj) {
		if (cnpj == null || cnpj.length() != 14)
			return false;

		try {
			Long.parseLong(cnpj);
		} catch (NumberFormatException e) {
			return false;
		}

		int soma = 0;
		String cnpj_calc = cnpj.substring(0, 12);

		char chr_cnpj[] = cnpj.toCharArray();
		for (int i = 0; i < 4; i++)
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
				soma += (chr_cnpj[i] - 48) * (6 - (i + 1));

		for (int i = 0; i < 8; i++)
			if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9)
				soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));

		int dig = 11 - soma % 11;
		cnpj_calc = (new StringBuilder(String.valueOf(cnpj_calc)))
				.append(dig != 10 && dig != 11 ? Integer.toString(dig) : "0").toString();
		soma = 0;
		for (int i = 0; i < 5; i++)
			if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9)
				soma += (chr_cnpj[i] - 48) * (7 - (i + 1));

		for (int i = 0; i < 8; i++)
			if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9)
				soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));

		dig = 11 - soma % 11;
		cnpj_calc = (new StringBuilder(String.valueOf(cnpj_calc)))
				.append(dig != 10 && dig != 11 ? Integer.toString(dig) : "0").toString();

		return cnpj.equals(cnpj_calc);
	}

	
	// isso é um exemplo seu viado, não uso isso, mas é válido
	
	
	public boolean validarCampos(){

	FacesContext context = FacesContext.getCurrentInstance();

	if(!isNome(null)){
	context.addMessage(null, new FacesMessage("Successful é o caralho!", "Deu erro porque você é burro e não sabe digitar o nome"));
	}
	if(!isEndereco(null)){
	context.addMessage(null, new FacesMessage("Successful é o caralho!", "Deu erro porque você é burro e não sabe digitar o endereco"));
	}
	//Entendeu? Entendeu, mesmo? HAHHAHAH
	// Nao entendi a sua pergunta
	// voce não vai chamar la
	// isso! você não coloca o metodo de Salvar ou Cadastrar no bean? para ser chamado no xhml? então... você coloca esse validar campos lá dentro do metodo de salvar
	// coloca ele antes de tudo. Isso...
	// De boa então; vai lá então. Vou fazer uns baguius aqui também HAHAHAH
	// e por ai vai
	//ai se der falço você lança o grow. tipo assim
	return true;

	}

	public void salvar() {
	if (!validarCampos()) {
	FacesContext context = FacesContext.getCurrentInstance();
	context.addMessage(null, new FacesMessage("Successful é o caralho!", "Deu erro porque você é burro e não sabe digitar"));
	// você também pode colocar nos ifs do validar campos. Tipo assim...
	}
	}

	// Essa porra não esta configurada direito no meu ambiente HAHAHAH
	// Estou tentando mostrar o isEmpty() do String mas não vai
	// não precisa não viado
	// estou te mostrando para você aprender e fazer HAHAHAH _|_
	public boolean isNome(String nome) {
	if (nome != "") {
	return true;
	}
	return false;
	}

	public boolean isEndereco(String nome) {
	if (nome != "") {
	return true;
	}
	return false;
	}
}
