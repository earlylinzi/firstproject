package com.myutil.project.filterUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EFilter {
	
	public static void main(String[] args) {
		
		// 要验证的字符串
	    String str = "18301068121";
	    // 邮箱验证规则
	    String regEx = "^0?(13|14|15|17|18)[0-9]{9}";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 字符串是否与正则表达式相匹配
	    boolean rs = matcher.matches();
	    System.out.println(rs);
		
	}
	
	
	public static boolean containsEmoji(String source) {
        if (source == null && "".equals(source.trim())) {
            return false;
        }

        int len = source.length();

        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);

            if (isEmojiCharacter(codePoint)) {
                //do nothing，判断到了这里表明，确认有表情字符
                return true;
            }
        }

        return false;
    }

    private static boolean isEmojiCharacter(char codePoint) {
    	//'\\xF0\\x9F\\x98\\x92\\xF0\\x9F.
        return (codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

}
