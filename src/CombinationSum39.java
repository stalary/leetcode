import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CombinationSum39
 * 求出数组(可重复)中相加所能达到最大值的组合
 * @author lirongqian
 * @since 2018/04/10
 */
public class CombinationSum39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getResult(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                // 加入临时数组
                cur.add(candidates[i]);
                // 传入减去当前值的目标值，因为可能有重复元素，所以传入i
                getResult(result, cur, candidates, target - candidates[i], i);
                // 回溯
                cur.remove(cur.size() - 1);
            }
        } else if (target == 0) {
            // 当目标值等于0时代表满足条件
            result.add(new ArrayList<>(cur));
        }
    }
}