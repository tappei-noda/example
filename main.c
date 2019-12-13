//
//  main.c
//  training
//
//  Created by Noda  on 2019/05/26.
//  Copyright © 2019年 Noda . All rights reserved.
//

#include <stdio.h>

int main(void) {
    char kakko[][5]={
    "[","]","<--","-->"
};
    int i = sizeof(kakko);
    int j = sizeof(kakko[0]);
    int n = "d";
    printf("%c\n",n);
    printf("%d\n",j);
    printf("%d\n",i);
    printf("%c\n",kakko[2][0]);
    // insert code here...
    return 0;
}
