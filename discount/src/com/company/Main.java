package com.company;

public class Main {

    public static void main(String[] args) {
        Discount calc = new Discount(new int[]{150, 22, 13, 555, 23, 1510}, 50, 1, 5);
        int [] new_price;
        calc.check_input_data();
        new_price = calc.descryptData();
        for (int i = 0; i < new_price.length; i++) {
            System.out.print(" " + new_price[i]);
        }
    }
}

class Discount {

    private int[] price;
    private int discount;
    private int offset;
    private int readLength;

    Discount(int[] p, int d, int o, int r) {
        price = p;
        discount = d;
        offset = o;
        readLength = r;
    }


    public void check_input_data() {
        //Проверка ошибки ввода данных
        //Пустой массив цен
        if (price.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Исходных цен нет");
        }
        //Скидка не входит в границы
        if ((discount > 99) || (discount < 1)) {
            throw new ArithmeticException("Скидка должна быть от 1 до 99%");
        }
        //Номер позиции неверно введен, либо больше чем граница массива цен
        if (offset < 0 || offset > price.length - 1) {
            throw new ArithmeticException("Введите верно номер позиции");
        }
        //Количество позиций неверно введены
        if (readLength < 0 || readLength > price.length || (offset + readLength) > price.length) {
            throw new ArithmeticException("Расчет выходит за пределы массива цен");
        }
    }

    public int[] descryptData() {
        int[] new_price = new int[readLength];
        int position = 0;
        for (int i = offset; i < offset + readLength; i++) {
            new_price[position] = (int)Math.floor(price[i] * discount * 0.01);
            position++;
        }
        return new_price;
    }
}
