/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

1、不使用额外的空间：不能转换为String来解决
2、直接反转Integer有时会导致溢出

思路：如果输入为1221，我们可以将数字“1221”的后半部分从“21”还原为“12”，并将其与数字“12”的前半部分进行比较，相同则为回文
数字回文的常用代码：计算结束后x为前半部分，rev为后半部分
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }


简洁的代码：
public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    return (x==rev || x==rev/10);
}

自己的代码：抽出x的第一位和最后一位比较其是否相等，然后将剩余部分继续比较
public static boolean isPalindrome(int x) {
    	if(x<0){
    		return false;
    	}
        int temp = x;
        int num = 1;
        while(temp/10!=0){
            temp/=10;
            num++;
        }
        int leftIndex=1,rightIndex=num;
        temp = x;
        int xxx = 1;
        while(leftIndex<rightIndex){
            int rightIndexNum = temp%10;
            int zhishu = 1;
            for(int i=0;i<num-xxx;i++){
                zhishu*=10;
            }
            int leftIndexNum = temp/zhishu;
            if(leftIndexNum!=rightIndexNum){
                return false;
            }
            temp = (temp%zhishu)/10;
            leftIndex++;
            rightIndex--;
            xxx+=2;
        }
        return true;
    }
