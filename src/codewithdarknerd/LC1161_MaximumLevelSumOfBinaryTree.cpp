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
    int maxLevelSum(TreeNode* root) {
        vector<int> levelSum;
        dfs(root, levelSum, 1);
        auto it = max_element(begin(levelSum), end(levelSum));
        return it-begin(levelSum)+1;
    }

    void dfs(TreeNode* root, vector<int>& levelSum, int level){
        if(!root) return;

        if(level>levelSum.size()) levelSum.push_back(root->val);
        else levelSum[level-1]+=root->val;

        dfs(root->left, levelSum, level+1);
        dfs(root->right, levelSum, level+1);
    }
};