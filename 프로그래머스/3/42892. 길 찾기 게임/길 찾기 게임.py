import sys
sys.setrecursionlimit(10000)
from collections import namedtuple

Node = namedtuple('Node', ['v', 'c', 'r'])

def solution(nodeinfo):
    nodes = [Node(i+1, node[0], node[1]) for i, node in enumerate(nodeinfo)]
    nodes.sort(key=lambda n: (-n.r, n.c))

    def build_tree(arr):
        if not arr:
            return [], []
        root = arr[0]
        left = [n for n in arr[1:] if n.c < root.c]
        right = [n for n in arr[1:] if n.c > root.c]
        pre_l, post_l = build_tree(left)
        pre_r, post_r = build_tree(right)
        return [root.v] + pre_l + pre_r, post_l + post_r + [root.v]

    preorder, postorder = build_tree(nodes)
    return [preorder, postorder]
