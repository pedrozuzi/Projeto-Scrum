package teste;

import java.io.File;
import java.io.FileOutputStream; 
import java.io.IOException; 
import com.itextpdf.text.Document; 
import com.itextpdf.text.DocumentException; 
import com.itextpdf.text.Paragraph; 
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * @author Pedro
 * Gerando PDF
 */
public class Teste {

	public static void main(String[] args) {
		Document document = new Document(); 
		try {
			File dir = new File("C:\\Teste");
			if (!dir.exists()) {
				dir.mkdir();
			}
			PdfWriter.getInstance(document, new FileOutputStream(dir + "\\Teste.pdf")); 
			document.open(); 
			// adicionando um parágrafo no documento 
			document.add(new Paragraph("Gerando PDF - Java")); 
		} catch(DocumentException de) { 
			System.err.println(de.getMessage()); 
		} catch(IOException ioe) { 
			System.err.println(ioe.getMessage()); 
		} 
			document.close(); 
	} 
}
