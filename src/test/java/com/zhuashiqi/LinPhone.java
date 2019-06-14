package com.zhuashiqi;

public class LinPhone implements Phone {
    private Phone phone;

    public LinPhone(Phone phone) {
        System.out.println("linPhone");
        this.phone = phone;
    }

    @Override
    public void call() {
        System.out.println("听彩铃");
        phone.call();
    }
}
