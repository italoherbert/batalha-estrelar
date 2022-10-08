package batalhaestrelar.painter.text.process;

import java.util.HashMap;
import java.util.Map;

public class TextProcessor {
	
	private String defaultAttrMark = "\\$";
		
	public String textContent( String text ) {
		return this.textContent( defaultAttrMark, text );
	}
		
	public Map<String, String> attrs( String text ) {
		return this.attrs( defaultAttrMark, text );
	}	
	
	public String textContent( String initMark, String text ) {
		if( !text.startsWith( initMark ) )
			return text;
		
		int index = -1;
		int len = text.length();
		for( int i = 0; index == -1 && i < len; i++ )
			if( text.charAt( i ) == ')' )
				index = i;
		if( index == -1 )
			return text;
		return text.substring( index+1 ); 
	}
		
	public Map<String, String> attrs( String initMark, String text ) {
		Map<String, String> map = new HashMap<String, String>();		
		if( !text.startsWith( initMark ) )
			return map;
		
		int indexP1 = text.indexOf( '(' );
		if( indexP1 == -1 )
			return map;
		
		String text2 = text.substring( indexP1+1 );
		int indexP2 = text2.indexOf( ')' );
		if( indexP2 == -1 )
			return map;
		
		text2 = text2.substring( 0, indexP2 ).replaceAll( "\\s", "" ); 		
		
		String[] attrs = text2.split( ";" );
		for( String attr : attrs ) {
			String[] a = attr.split( "=" );
			if( a.length == 2 )
				map.put( a[0], a[1] );			
		}
		return map;
	}
	
	public String get( String text, String name ) {
		String[] attr = text.replaceAll( "\\s", "" )
				.replaceAll( ".*"+name, "" )
				.replaceAll( ";.*", "" ) 
				.split( "=" );  
		if( attr.length == 2 )
			return attr[1].replaceAll( ";.*", "" );
		return null;
	}
	
	public String getStrValue( String value, String defaultValue ) {
		return ( value == null ? defaultValue : value );
	}
	
	public int getIntValue( String value, int defaultValue ) {
		try {
			return Integer.parseInt( value );
		} catch( NumberFormatException e ) {
			
		}
		return defaultValue;
	}

	public String getDefaultAttrMark() {
		return defaultAttrMark;
	}

	public void setDefaultAttrMark(String defaultAttrMark) {
		this.defaultAttrMark = defaultAttrMark;
	}
	
}
