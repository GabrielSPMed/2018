@bico

@sonares

read_sonar:
    push    {R4-R11, LR}
    mov     r7,     #21
    svc     0x0
    pop     {R4-R11, LR}

@timer

get_time:
    push    {R4-R11, LR}
    mov     r7,     #17
    svc     0x0
    pop     {R4-R11, LR}

set_time:
    push    {R4-R11, LR}
    mov     r7,     #18
    svc     0x0
    pop     {R4-R11, LR}

@motores

set_motor_speed:
    push    {R4-R11, LR}
    mov     r7,     #20
    mov     r0,     r3
    ldrb    r0,     [r3]
    add     r3,     r3,     #1
    ldrb    r1,     [r3]
    svc     0x0
    pop     {R4-R11, LR}
