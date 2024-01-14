package com.hyosik.android.algorithmproblem.stack;

import java.util.ArrayDeque;

public class StockPrice {

    class Price {
        int index;
        int price;

        public Price(int index, int price) {
            this.index = index;
            this.price = price;
        }

    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Price[] priceArray = new Price[prices.length];

        // (index, price) 객체 담기
        for (int i = 0; i < prices.length; i++) {
            priceArray[i] = new Price(i, prices[i]);
        }

        ArrayDeque<Price> stack = new ArrayDeque<>();

        // 똑같거나 크면 stack 에서 제거
        // 작으면 index 차(price 마지막 index - 현재 index) 계산해서 answer 에 담고 stack 에 넣는다.
        for (int j = prices.length-1; j >=0; j--) {

            while(!stack.isEmpty() && stack.peekLast().price >= priceArray[j].price) {
                stack.pollLast();
            }

            if(!stack.isEmpty()) {
                int seconds = stack.peekLast().index - priceArray[j].index;
                answer[j] = seconds;
            } else {
                answer[j] = prices.length -1 - priceArray[j].index;
            }

            stack.addLast(priceArray[j]);

        }

        return answer;
    }

}
