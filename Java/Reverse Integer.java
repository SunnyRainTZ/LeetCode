/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

思路1：
  将Int转换为String，然后利用StringBuilder的reverse()方法进行反转，最后再转换回Integer，转回时捕捉异常判断是否溢出
  Integer.parseInt()方法能自动处理开头0的问题，譬如“-0001”能正确转换为“-1”，故不用考虑这一问题
  
  
public static int reverse(int x) {
    String s;
    if(x < 0){
      s = (-x) + "-";
    }else{
      s = x + "";
    }
    StringBuilder sb = new StringBuilder(s);
    String resultString = sb.reverse().toString();
    int result;
    try{
      result = Integer.parseInt(resultString);
    }catch(Exception e){
      return 0;
    }
    return result;
}

思路2：
  结果不断乘10加余数，传入的数字不断除10求余数。溢出的判断通过新的结果求逆运算是否和原来结果相同来判断。
  也可以利用Integer.MAX_VALUE和MIN_VALUE进行判断。



public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}
