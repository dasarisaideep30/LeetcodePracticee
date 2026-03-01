class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        res=[]
        def bt(r,c,d1,d2,path):
            if r==n:
                res.append(["."*i+"Q"+"."*(n-i-1) for i in path])
                return
            for i in range(n):
                if i not in c and r-i not in d1 and r+i not in d2:
                    bt(r+1,c|{i},d1|{r-i},d2|{r+i},path+[i])
        bt(0,set(),set(),set(),[])
        return res