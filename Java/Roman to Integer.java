
/*
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/

思路1：将罗马数字对应数值存在Map中，如果当前罗马数字比其后一个小，则减去当前数字，否则加当前数字。注意Map中put的是Character而不是String。
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int num = 0;
        for(int i=0;i<s.length();i++){
        	if(i==s.length()-1){
        		num+=map.get(s.charAt(i));
        	}else{
        		if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
        			num-=map.get(s.charAt(i));
        		}else{
        			num+=map.get(s.charAt(i));
        		}
        	}
        }
        return num;
    }

思路2：反向遍历，根据当前数值的大小判断需要加还是减
public static int romanToInt(String s) {
	int res = 0;
	for (int i = s.length() - 1; i >= 0; i--) {
		char c = s.charAt(i);
		switch (c) {
		case 'I':
			res += (res >= 5 ? -1 : 1);
			break;
		case 'V':
			res += 5;
			break;
		case 'X':
			res += 10 * (res >= 50 ? -1 : 1);
			break;
		case 'L':
			res += 50;
			break;
		case 'C':
			res += 100 * (res >= 500 ? -1 : 1);
			break;
		case 'D':
			res += 500;
			break;
		case 'M':
			res += 1000;
			break;
		}
	}
	return res;
}




