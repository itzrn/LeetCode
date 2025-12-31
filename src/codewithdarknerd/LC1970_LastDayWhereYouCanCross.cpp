class Solution {
public:
    bool bfs(int row, int col, vector<vector<int>>& cells, int mid){

        vector<vector<int>> visited(row, vector<int>(col, 0)); // 0 1 2
        for(int i=0; i<=mid; i++){
            visited[cells[i][0]-1][cells[i][1]-1] = 1;
        }

        queue<tuple<int, int>> qu;

        for(int i=0; i<col; i++){
            if(visited[0][i] == 0){
                qu.push({0, i});
                visited[0][i] = 2;
            }
        }

        int dir[5] = {1, 0, -1, 0, 1};

        while(!qu.empty()){

            auto [x, y] = qu.front();
            qu.pop();

            for(int i=0; i<4; i++){

                int nx = x+dir[i], ny = y+dir[i+1];

                if(nx<0 || ny <0 || nx==row || ny == col || visited[nx][ny]==1 || visited[nx][ny]==2) continue;

                visited[nx][ny] = 2;
                qu.push({nx, ny});

            }



        }


        for(int i=0; i<col; i++){
            if(visited[row-1][i] == 2) return true;
        }

        return false;

    }
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {

        int n=cells.size();
        int lft=0, rgt=n-1;

        int ans=-1;

        while(lft<=rgt){
            int mid = lft+((rgt-lft)>>1);

            if(bfs(row, col, cells, mid)){
                ans=mid;
                lft=mid+1;
            }else{
                rgt=mid-1;
            }
        }

        return ans+1;
        
    }
};