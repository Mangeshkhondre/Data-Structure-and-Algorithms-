/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] result=new int[2];
        if(nums==null ||nums.length<=1)
            return result;
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(m.containsKey(target-nums[i]))
            {
                result[0]=m.get(target-nums[i]);
                result[1]=i;
                break;
            }
            m.put(nums[i],i);
        }
        return result;
    }
}
