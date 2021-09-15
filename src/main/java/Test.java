/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2021-07-22
 */
public class Test {
    
    public int test(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        
        int ans = 0;
        int[] cnt = new int[input.length];
        
        for (int i = 0; i < input.length; i++) {
            int maxCntBefore = 0;
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    maxCntBefore = Math.max(maxCntBefore, cnt[j]);
                }
            }
            cnt[i] = maxCntBefore + 1;
            ans = Math.max(ans, cnt[i]);
        }
        return ans;
    }
}