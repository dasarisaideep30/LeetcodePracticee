class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] arr = data.split(",");
        int[] i = {0};
        return build(arr, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode build(String[] arr, int[] i, int min, int max) {
        if (i[0] == arr.length) return null;
        int val = Integer.parseInt(arr[i[0]]);
        if (val < min || val > max) return null;

        i[0]++;
        TreeNode root = new TreeNode(val);
        root.left = build(arr, i, min, val);
        root.right = build(arr, i, val, max);
        return root;
    }
}