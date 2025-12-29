class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int tot=0;

        for(vector<int>& vec : grid){

            auto it = upper_bound(begin(vec), end(vec), 0, [](int key, int a){
                return key > a;
            });

            tot += end(vec)-it;

        }

        return tot;
    }
};