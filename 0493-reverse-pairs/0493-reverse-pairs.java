class Solution {
    public int reversePairs(int[] a) {
        return sort(a,0,a.length-1);
    }
    int sort(int[] a,int l,int r){
        if(l>=r) return 0;
        int m=l+(r-l)/2,c=sort(a,l,m)+sort(a,m+1,r);
        for(int i=l,j=m+1;i<=m;i++){
            while(j<=r&&(long)a[i]>2L*a[j]) j++;
            c+=j-m-1;
        }
        int[] t=new int[r-l+1]; int i=l,j=m+1,k=0;
        while(i<=m&&j<=r) t[k++]=a[i]<=a[j]?a[i++]:a[j++];
        while(i<=m) t[k++]=a[i++];
        while(j<=r) t[k++]=a[j++];
        System.arraycopy(t,0,a,l,t.length);
        return c;
    }
}