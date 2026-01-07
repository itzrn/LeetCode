/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxProduct(TreeNode* root) {
        int M = 1e9+7;
        vector<int> sums;
        long long tot = dfs(root, sums);
        long long mx = 0;
        for(long long sum:sums){
            mx = max(mx, sum*(tot-sum));
        }

        return mx%M;
    }

    int dfs(TreeNode* root, vector<int>& sums){
        if(!root) return 0;

        int lft = dfs(root->left, sums);
        int rgt = dfs(root->right, sums);

        sums.push_back(lft+rgt+root->val);
        return sums.back();
    }
};