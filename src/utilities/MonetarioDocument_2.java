package utilities;

import javax.swing.text.*;

public class MonetarioDocument_2 extends PlainDocument {

	/**
	 * Author: Alessandro_Taccini
	 */
	private static final long serialVersionUID = 1L;
	public static final int NUMERO_DIGITOS_MAXIMO = 12;
	
	//@SuppressWarnings("static-access")
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
	    String texto = getText(0, getLength());
	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (!Character.isDigit(c)) {
	            return;
	        }
	    }

	    int totalLength = texto.length() + str.length();

	    if (totalLength <= this.NUMERO_DIGITOS_MAXIMO) {
	        StringBuffer s = new StringBuffer(texto);
	        s.insert(offs, str);

	        // Remove existing formatting
	        s = new StringBuffer(s.toString().replace(".", "").replace(",", ""));

	        // Pad leading zeros
	        while (s.length() < 3) {
	            s.insert(0, "0");
	        }

	        // Format with thousands separator
	        for (int i = s.length() - 6; i > 0; i -= 3) {
	            s.insert(i, ".");
	        }

	        // Format with decimal separator
	        s.insert(s.length() - 2, ",");

	        super.remove(0, getLength());
	        super.insertString(0, s.toString(), a);
	    }
	}



	public void remove(int offset, int length) throws BadLocationException {
		super.remove(offset, length);
		String texto = getText(0, getLength());
		texto = texto.replace(",", "");
		texto = texto.replace(".", "");
		super.remove(0, getLength());
		insertString(0, texto, null);
	}

}