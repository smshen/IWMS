package org.lazicats.ecos.internal.utils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UnicodeChange {

	//UTF-8->GB2312
	public static String utf8Togb2312(String str){ 

        StringBuffer sb = new StringBuffer(); 

        for ( int i=0; i<str.length(); i++) { 

            char c = str.charAt(i); 
            switch (c) { 
               case '+' : 
                   sb.append( ' ' ); 
               break ; 
               case '%' : 
                   try { 
                        sb.append(( char )Integer.parseInt ( 
                        str.substring(i+1,i+3),16)); 
                   } 
                   catch (NumberFormatException e) { 
                       throw new IllegalArgumentException(); 
                  } 

                  i += 2; 

                  break ; 
                  
               default : 

                  sb.append(c); 

                  break ; 

             } 

        } 

        String result = sb.toString(); 

        String res= null ; 

        try { 

             byte [] inputBytes = result.getBytes( "8859_1" ); 

            res= new String(inputBytes, "UTF-8" ); 

        } 

        catch (Exception e){} 

        return res; 

  }


	//GB2312->UTF-8
	public static String gb2312ToUtf8(String str) { 

        String urlEncode = "" ; 

        try { 

            urlEncode = URLEncoder.encode (str, "UTF-8" ); 

        } catch (UnsupportedEncodingException e) { 

            e.printStackTrace(); 

        } 

        return urlEncode; 

    }
	
	/**
	 * 把中文转成Unicode码
	 * @param str
	 * @return
	 * @deprecated Use {@link #chinaToUnicode(String,String)} instead
	 */
	public static String chinaToUnicode(String str){
		return chinaToUnicode(str, "%u");
	}


	/**
	 * 把中文转成Unicode码
	 * @param str
	 * @param prefix TODO
	 * @return
	 */
	public static String chinaToUnicode(String str, String prefix){
		if(null == str){
			return str;
		}
		
		String result="";
		for (int i = 0; i < str.length(); i++){
            int chr1 = (char) str.charAt(i);
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)
                result+=prefix + Integer.toHexString(chr1);
            }else{
            	result+=str.charAt(i);
            }
        }
		return result;
	}

	/**
	 * 判断是否为中文字符
	 * @param c
	 * @return
	 */
	public  static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }
	
	public static String convertUTF2GBK(String content, String encoding) {

	    byte[] srcByte = null;
	    try {
	      srcByte = content.getBytes("UTF-8");
	    } catch (UnsupportedEncodingException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    StringBuffer str = new StringBuffer();
	    int len = srcByte.length;
	    int char1, char2, char3;
	    int count = 0;
	    while (count < len) {
	      char1 = (int) srcByte[count] & 0xff;
	      switch (char1 >> 4) {
	        case 0:
	        case 1:
	        case 2:
	        case 3:
	        case 4:
	        case 5:
	        case 6:
	        case 7:
	          count++;
	          str.append((char) char1);
	          break;
	        case 12:
	        case 13:
	          count += 2;
	          if (count > len) {
	            break;
	          }
	          char2 = (int) srcByte[count - 1];
	          if ((char2 & 0xC0) != 0x80) {
	            break;
	          }
	          str.append((char) (((char1 & 0x1F) << 6) | (char2 & 0x3F)));
	          break;
	        case 14:

	          count += 3;
	          if (count > len) {
	            System.out.println("wrong");
	          }
	          char2 = (int) srcByte[count - 2];
	          char3 = (int) srcByte[count - 1];
	          if (((char2 & 0xC0) != 0x80) || ((char3 & 0xC0) != 0x80)) {
	            break;
	          }
	          str.append((char) (((char1 & 0x0F) << 12) | ((char2 & 0x3F) << 6) | ((char3 & 0x3F) << 0)));
	          break;
	        default:
	          break;
	      }
	    }

	    String temps = null;
	    try {
	      temps = new String(str.toString().getBytes("GBK"), "GBK");
	    } catch (UnsupportedEncodingException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }

	    return temps;
	  }
	
	public static void main(String[] args){   
	       	        
	    	try {
			
	    	String str="輸入簡體字,點下面繁體字按鈕進行在線轉換.";//%E4%B8%AD%E5%9B%BD
	    		
	    	str=gb2312ToUtf8(str);
	    		
			System.out.println(str);
				  
			str=utf8Togb2312(str);
				
			System.out.println(str);
			
			str=chinaToUnicode(str, "%u");
			
			System.out.println(str);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
	    }   
	


}
