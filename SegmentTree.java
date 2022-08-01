class NumArray {
    int[] seg;
    int[] arr;
    public NumArray(int[] nums) {
        int n = nums.length;
        seg = new int[4*n+1];
        arr = new int[n];
        arr = nums;
        build(0, arr, 0, n-1);
    }
    
    public void build(int ind, int[] arr, int l, int r){
        
        if(l == r){
            seg[ind] = arr[l];
            return;
        }
        
        int mid = l+(r-l)/2;
        build(ind*2+1, arr, l, mid);
        build(ind*2+2, arr, mid+1, r);
        seg[ind] = seg[ind*2+1]+seg[ind*2+2];
    }
    
    public void update(int index, int val) {
        updateTree(0, arr, 0, arr.length-1, index, val);
    }
    
    public void updateTree(int ind, int[] arr, int l, int r, int index, int val){
        
       if(l == r && l == index){
           seg[ind] = val;
           return;
       } 
        
        int mid = l+(r-l)/2;
        if(index <= mid){
            updateTree(ind*2+1, arr, l, mid, index, val);
        }
        else{
            updateTree(ind*2+2, arr, mid+1, r, index, val);
        }
        seg[ind] = seg[ind*2+1]+seg[ind*2+2];
    }
    
    public int sumRange(int left, int right) {
        return sum(left, right, 0, 0, arr.length-1);
    }
    
    public int sum(int left, int right, int ind, int l, int r){
        
        if((left < l && right < l) || (left > r && right > r)){
            return 0;
        } 
        if(left <= l && right >= r){
            return seg[ind];
        }
        
        int mid = l+(r-l)/2;
        if(left > mid){
            return sum(left, right, ind*2+2, mid+1, r);
        }
        if(right <= mid){
            return sum(left, right, ind*2+1, l, mid);
        }
        int leftSum = sum(left, right, ind*2+1, l, mid);
        int rightSum = sum(left, right, ind*2+2, mid+1, r);
        return leftSum+rightSum;
    }
}
