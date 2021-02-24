
#include <stdio.h>

typedef struct
{
    unsigned char id;
    unsigned char speed;
} motor_cfg_t;

void girar_90_graus (motor_cfg_t *motor0, motor_cfg_t *motor1){
    //nao sei qual motor e qual
    motor0->id=0;
    motor0->speed=0;
    set_motor_speed(motor0);
    
    motor1->id=1;
    motor0->speed=0;
    set_motor_speed(motor1);
    
    int tempo = 0.3;
    set_time (0);
    motor0->id=0;
    motor0->speed=2;
    set_motor_speed(motor0);
    while (get_time!=0.3);
    motor0->speed=0;
    set_motor_speed(motor0);
    return;
    
}

int main() {
    
    return 0;
}
