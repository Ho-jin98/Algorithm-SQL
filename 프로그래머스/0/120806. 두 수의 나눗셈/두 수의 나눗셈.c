#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int num1, int num2) {
    double number = (double) num1;
    int result = (number / num2) * 1000;
        return result;
}