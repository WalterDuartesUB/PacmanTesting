package ar.edu.ub.testing.util;


public class StringUtils 
{
	
	public static boolean isEmpty(final CharSequence cs) 
	{		
		return cs == null || cs.toString().trim().length() == 0;
	}
	
	/** Determina si una cadena de caracteres contiene digitos
	 * {@link} http://commons.apache.org/proper/commons-lang/javadocs/api-release/src-html/org/apache/commons/lang3/StringUtils.html
	 * @param cs una cadena de caracteres que puede ser null o vacia
	 * @return true si la cadena de caracteres contiene solo digitos
	 * @return false si la cadena de caracteres es null
	 * @return false si la cadena de caracteres esta vacia
	 * @return false si la cadena de caracteres contiene cualquier caracter que no sea un digito(incluido el . y el -)
	 */
	
	public static boolean isNumeric(final CharSequence cs) 
	{
        if (isEmpty(cs)) 
        {
            return false;
        }
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) 
        {
            if (!Character.isDigit(cs.charAt(i))) 
            {
                return false;
            }
        }
        return true;
    }
}
