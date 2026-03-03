func minPatches(nums []int, n int) int {
    patches := 0
    len := len(nums)
    till := 0

    for i:=0;till<n;i++ {
        if i < len && till >= nums[i] - 1 {
            till += nums[i];
        } else {
            till += till + 1;
            i--;
            patches++;
        }
    }
    return patches;
}
