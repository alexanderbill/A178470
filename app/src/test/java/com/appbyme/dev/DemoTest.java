package com.appbyme.dev;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static com.appbyme.dev.R.id.first;
import static com.baidu.android.pushservice.message.a.m.i;


/**
 * Created by sun on 2016/10/14.
 */

public class DemoTest {
    @Test
    public void do_some() {
        String s  = "{\"body\":{\"json\":{\"fid\":525,\"tid\":64550,\"location\":\"北京市海淀区马连洼北路辅路\",\"aid\":\"156869\",\"content\":\"[{\\\"type\\\":0,\\\"infor\\\":\\\"解决\\\"},{\\\"type\\\":1,\\\"infor\\\":\\\"http:\\\\\\/\\\\\\/forum.longquanzs.org\\\\\\/data\\\\\\/attachment\\\\\\/\\\\\\/forum\\\\\\/201610\\\\\\/14\\\\\\/125735kt4goboyr67aorco.jpg\\\"}]\",\"longitude\":\"116.27349090576172\",\"latitude\":\"40.037715911865234\",\"isHidden\":0,\"isAnonymous\":0,\"isOnlyAuthor\":0,\"isShowPostion\":1,\"replyId\":0,\"isQuote\":0}}}";
        boolean result = s.startsWith("");
        Assert.assertTrue(result);
    }

    public String replaceSpace(StringBuffer str) {
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                str.replace(i, i + 1, "%20");
            }

        }
        return str.toString();
    }
    public void findBinearyCount(int n) {
        Integer inte = n;
    }
    public void reOrderArray(int [] array) {
        int index = 0;
        int len = array.length;
        int[] arr2 = new int[len];
        for (int i = 0; i < len; i++) {
            int num = array[i];
            if (num%2 != 0) {
                // 奇数
                arr2[index++] = num;
            }
        }
        for (int i = 0; i < len; i++) {
            int num = array[i];
            if (num%2 == 0) {
                // 偶数
                arr2[index++] = num;
            }
        }


        System.arraycopy(arr2, 0, array, 0, len);
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }


    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty())
            throw new IllegalArgumentException();
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || popA.length == 0) {
            return  false;
        }

        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i=0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                popIndex++;
                // 找到出站元素
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public int JumpFloorII(int target) {
        if (target <= 0) return 0;
        if (target == 1) return target;
        if (target == 2) return target;

        int result = 0;
        for(int i = target-1; i > 0; i ++){
            result += JumpFloorII(i);
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ListNode front = listNode;
            ListNode mid = front.next;
            front.next = null;
            ArrayList<Integer> result = new ArrayList<>();
            ListNode next;
            while(mid != null) {
                next = mid.next;
                mid.next = front;

                front = mid;
                mid = next;
            }
            result.add(front.val);
            while ((listNode = front.next) != null) {
                result.add(listNode.val);

            }
            return result;

        }
    }
}