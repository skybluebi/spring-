package com.zhuashiqi;

public class SmsPhone implements Phone{

    private Phone phone;

    public SmsPhone(Phone phone){
        System.out.println("SmsPhone");
        this.phone=phone;
    }

    @Override
    public void call() {
        phone.call();
        System.out.println("发短信");
    }
}
