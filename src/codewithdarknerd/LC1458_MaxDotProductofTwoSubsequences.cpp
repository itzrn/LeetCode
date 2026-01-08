// memoization
class Solution {
public:
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        int n=nums1.size(), m=nums2.size();
        vector<vector<int>> dp(n, vector<int>(m, INT_MIN));
        return dfs(0, 0, nums1, nums2, n, m, dp);
    }

    int dfs(int i, int j, vector<int>& nums1, vector<int>& nums2, int n, int m, vector<vector<int>>& dp){

        if(i == n || j == m) return -1e9;

        if(dp[i][j] != INT_MIN) return dp[i][j];

        int res=nums1[i]*nums2[j];

        int one = res+dfs(i+1, j+1, nums1, nums2, n, m, dp);
        int two = dfs(i, j+1, nums1, nums2, n, m, dp);
        int three = dfs(i+1, j, nums1, nums2, n, m, dp);

        return dp[i][j]=max({res, one, two, three});

    }
};

// Tabular DP -> bottom UP

class Solution {
public:
    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        int n=nums1.size(), m=nums2.size();

        vector<vector<int>> dp(n+1, vector<int>(m+1, -1e9));

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                int res = nums1[i]*nums2[j];
                int one = res + dp[i+1][j+1];
                int two = dp[i][j+1];
                int three = dp[i+1][j];
                dp[i][j] = max({res, one, two, three});
            }
        }
        return dp[0][0];

    }
};